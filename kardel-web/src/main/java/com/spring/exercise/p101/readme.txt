解析文本信息

   一个区域的文本信息应该集中在一个单独的属性文件里，这个属性文件我们称之为Resource Bundle。
   ApplicationContext扩展了MessageSource接口，因此它可以解析所有文本信息。
   ApplicationContext将文本的解析工作委派给了一个名称为messageSource的Bean，ResourceBundleMessageSource是
最常用的MessageSource实现。


解析的优先级依次降低：
                                                             无                            无
    文本信息的区域是美国，语言是英语（message_en_US.properties) -----》 message_en.properties ----》 message.properties