package jvm.chapter10.namecheck;


import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.*;
import javax.lang.model.util.ElementScanner8;
import javax.tools.Diagnostic;
import java.util.EnumSet;

/**
 * 命名检查器 -- p.279
 *
 * Created by Dennis on 2017/12/27.
 */
public class NameChecker {

    private final Messager messager;

    NameCheckerScanner nameCheckerScanner = new NameCheckerScanner();

    NameChecker(ProcessingEnvironment processingEnvironment){
        this.messager = processingEnvironment.getMessager();
    }

    /**
     * 对java程序命名进行检查，Java程序命名应当符合下列各式：
     *  <ul>
     *      <li>类或接口：符合驼式命名法，首字母大写</li>
     *      <li>方法：符合驼式命名法，首字母小写</li>
     *      <li>字段：
     *         <li>类、实例变量：符合驼式命名法，首字母小写</li>
     *         <li>常量：要求全大写</li>
     *      </li>
     *  </ul>
     *
     * @param element
     */
    public void checkNames(Element element){

        nameCheckerScanner.scan(element);
    }

    /**
     * 名称检查器实现类，继承于ElementScanner8，
     * 将以Visitor模式访问抽象语法树中的元素
     */
    private class NameCheckerScanner extends ElementScanner8<Void,Void> {

        //该方法适用于检查JAVA类
        @Override
        public Void visitType(TypeElement e, Void aVoid) {

            scan(e.getTypeParameters(),aVoid);
            checkCameCase(e,true);
            super.visitType(e,aVoid);
            return null;
        }

        //检查方法命名是否合法
        @Override
        public Void visitExecutable(ExecutableElement e, Void aVoid) {

            if(e.getKind() == ElementKind.METHOD){
                Name name = e.getSimpleName();
                if(name.contentEquals(e.getEnclosingElement().getSimpleName())){
                    messager.printMessage(Diagnostic.Kind.WARNING,"一个普通方法"+name+"不应当与类名重复,避免与构造函数产生混淆",e);
                    checkCameCase(e,false);
                }
            }
            super.visitExecutable(e,aVoid);
            return null;
        }

        //检查变量命名是否合法
        @Override
        public Void visitVariable(VariableElement e, Void aVoid) {

            //如果这个Variable是枚举或常量，则按大写命名检查，否则按驼峰式命名法则检查
            if(e.getKind() == ElementKind.ENUM_CONSTANT || e.getConstantValue() != null || heuristicallyConstant(e)){
                checkAllCaps(e);
            } else {
                checkCameCase(e,false);
            }
            return null;
        }

        //判断一个变量是否是常量
        private boolean heuristicallyConstant(VariableElement e){

//            if(e.getEnclosingElement().getKind() == ElementKind.INTERFACE){
//                return true;
//            } else if(e.getKind() == ElementKind.FIELD && e.getModifiers().containsAll(EnumSet.of(PUBLIC,STATIC,FINAL))){
//                return true;
//            } else {
//                return false;
//            }
            return false;
        }

        //检查传入的Element是否符合驼峰法，如果不符合，输出警告信息
        private void checkCameCase(Element e,boolean initialCaps){

            String name = e.getSimpleName().toString();
            boolean previousUpper = false;
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);  //返回index=0位置处字符的ASCII

            if(Character.isUpperCase(firstCodePoint)){
                previousUpper = true;
                if(!initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当以小写字母开头",e);
                    return;
                }
            } else if(Character.isLowerCase(firstCodePoint)){

                if(initialCaps){
                    messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当以大写字母开头",e);
                    return;
                }
            } else {
                conventional = false;
            }

            if(conventional){

                int cp = firstCodePoint;
                for(int i = Character.charCount(cp); i<name.length();i+=Character.charCount(cp)){

                    cp = name.codePointAt(i);
                    if(Character.isUpperCase(cp)) {
                        if (previousUpper) {
                            conventional = false;
                            break;
                        }
                        previousUpper = true;
                    } else {
                        previousUpper = false;
                    }
                }
            }

            if(!conventional){

                messager.printMessage(Diagnostic.Kind.WARNING,"名称"+name+"应当符合驼峰法命名",e);
            }
        }

        //大写命名检查，要求第一个字母必须是大写英文字母，其余部分可以是下划线或者大写字母
        private void checkAllCaps(Element e){

            String name = e.getSimpleName().toString();
            boolean conventional = true;
            int firstCodePoint = name.codePointAt(0);

            if(!Character.isUpperCase(firstCodePoint)){
                conventional = false;
            } else {
                boolean previousUnderscore = false;
                int cp = firstCodePoint;
                for(int i = Character.charCount(cp);i < name.length();i+=Character.charCount(cp)){

                    cp = name.codePointAt(i);
                    if(cp == (int) '_'){

                        if(previousUnderscore){
                            conventional = false;
                            break;
                        }
                        previousUnderscore = true;
                    } else {

                        previousUnderscore = false;
                        if(!Character.isUpperCase(cp) && !Character.isDefined(cp)){
                            conventional = false;
                            break;
                        }
                    }
                }
            }

            if(!conventional){

                messager.printMessage(Diagnostic.Kind.WARNING,"常量"+name+"应当全部以大写字母或下划线命名，并且以字母开头",e);
            }
        }
    }
}
