package me.aihuishou.spring;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class UserLabelNamespaceHandler extends NamespaceHandlerSupport{
    @Override
    public void init() {
        registerBeanDefinitionParser("user",new UserBeanDefinitionParser());//目的是将组件注册到spring容器
    }
}
