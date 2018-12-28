package com.spring.exercise.p91;

import com.spring.exercise.p104.CheckoutEvent;
import lombok.Data;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

import java.io.*;
import java.util.Date;

import java.io.BufferedWriter;

/**
 * Spring IOC容器对Bean的生命周期管理进行管理的过程：
 *
 * 1.   通过构造器或工厂方法创建Bean的实例
 * 2.   为Bean的属性设置值和对其他Bean的引用
 * 3.   调用定义在感知接口里的setter方法
 * 4.   将Bean实例传给每个Bean后置处理器的postProcessBeforeInitialization()方法
 *          （作用：打开日志文件前确认Cashier的日志文件路径是否存在，为了能使后缀处理器辨别被处理的Bean，此处需要创建一个标记接口---StorageConfig ）
 *
 * 5.   调用Bean的初始化回调方法（作用：使用Bean前需要打开文件）
 *
 * 6.   将Bean实例传给每个Bean后置处理器的postProcessAfterInitialization()方法
 * 7.   Bean可以使用了
 * 8.   当容器关闭时，调用Bean的销毁回调方法
 *
 */
@Data
public class Cashier implements BeanNameAware,StorageConfig,MessageSourceAware,ApplicationEventPublisherAware{

    private String name;

    private String path;

    private BufferedWriter writer;

    public void openFile() throws FileNotFoundException {

        File logFile = new File(path,name+".txt");

        writer = new BufferedWriter(
                 new OutputStreamWriter(new FileOutputStream(logFile,true))
        );
    }

    public void checkOut(ShoppingCart shoppingCart) throws IOException{ // 检查购物车时必须要打开文件，使用初始化回调方法来实现(InitializingBean,DisposableBean)

        double total = 0;
        for(Product product : shoppingCart.getItems()){
            total+= product.getPrice();
        }

        CheckoutEvent checkoutEvent = new CheckoutEvent(this,total,new Date());
        applicationEventPublisher.publishEvent(checkoutEvent);

        writer.write(new Date()+"\t"+total+"\r\n");
        writer.flush();
    }

    public void  closeFile() throws IOException{
        writer.close();
    }

    @Override
    public void setBeanName(String name) { //通过BeanNameAware接口，可以让收营员Bean感知到它在容器里的Bean名称，这可以省去通过xml文件为这个收银员设置name属性的麻烦
        this.name = name;
    }

    public String getPath(){
        return path;
    }


    // 文本解析
    private MessageSource messageSource;

    @Override
    public void setMessageSource(MessageSource messageSource) {
       this.messageSource = messageSource;
    }


    // 事件发布
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
