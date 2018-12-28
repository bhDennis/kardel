package com.spring.exercise.p91;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import java.io.File;

/**
 * Created by dennis on 2018/12/17.
 */
public class PathCheckingBeanPostProcessor implements BeanPostProcessor{


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof StorageConfig){
            String path = ((StorageConfig) bean).getPath();
            File file = new File(path);
            if(!file.exists()){
                file.mkdir();
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
