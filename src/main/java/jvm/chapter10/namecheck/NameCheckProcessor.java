package jvm.chapter10.namecheck;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * 自定义注解处理器 ---  p.278
 *
 * Created by Dennis on 2017/12/27.
 */
@SupportedAnnotationTypes("*")                      // *表明支持所有的Annotations  -- SupportedAnnotationTypes 代表该注解处理器对哪些注解感兴趣
@SupportedSourceVersion(SourceVersion.RELEASE_8)   // 只支持JKD8的java代码         -- 指出该处理器可以处理哪些版本的JAVA代码
public class NameCheckProcessor extends AbstractProcessor{

    private NameChecker nameChecker;

    public void init(ProcessingEnvironment processingEnvironment){  // processingEnvironment代表注解处理器框架提供的一个上下文环境，用于创建新的代码、向编译器输出信息、获取其他工具类
       super.init(processingEnvironment);
       nameChecker = new NameChecker(processingEnvironment);
    }

    /**
     * 对输入的语法树的各个节点进行名称检查
     * @param annotations  从该参数可以获取到注解处理器所要处理的注解集合
     * @param roundEnv    从该参数可以访问到当前这个Round中的语法树节点
     * @return
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if(!roundEnv.processingOver()){
            for(Element element : roundEnv.getRootElements()){
                nameChecker.checkNames(element);
            }
        }
        return false;  // false表明通知编译器这个Round中的代码未发生变化，无须构造新的JavaCompiler实例
    }
}
