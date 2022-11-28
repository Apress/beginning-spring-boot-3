package org.springframework.boot.autoconfigure.thymeleaf;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

public final class ContextBootstrapInitializer {
  public static void registerThymeleafAutoConfiguration_ThymeleafJava8TimeDialect(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafJava8TimeDialect", ThymeleafAutoConfiguration.ThymeleafJava8TimeDialect.class)
        .instanceSupplier(ThymeleafAutoConfiguration.ThymeleafJava8TimeDialect::new).register(beanFactory);
  }

  public static void registerThymeleafJava8TimeDialect_java8TimeDialect(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("java8TimeDialect", Java8TimeDialect.class).withFactoryMethod(ThymeleafAutoConfiguration.ThymeleafJava8TimeDialect.class, "java8TimeDialect")
        .instanceSupplier(() -> beanFactory.getBean(ThymeleafAutoConfiguration.ThymeleafJava8TimeDialect.class).java8TimeDialect()).register(beanFactory);
  }

  public static void registerThymeleafWebMvcConfiguration_ThymeleafViewResolverConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafWebMvcConfiguration$ThymeleafViewResolverConfiguration", ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class)
        .instanceSupplier(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration::new).register(beanFactory);
  }

  public static void registerThymeleafViewResolverConfiguration_thymeleafViewResolver(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("thymeleafViewResolver", ThymeleafViewResolver.class).withFactoryMethod(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class, "thymeleafViewResolver", ThymeleafProperties.class, SpringTemplateEngine.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.ThymeleafViewResolverConfiguration.class).thymeleafViewResolver(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerThymeleafAutoConfiguration_ThymeleafWebMvcConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$ThymeleafWebMvcConfiguration", ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration.class)
        .instanceSupplier(ThymeleafAutoConfiguration.ThymeleafWebMvcConfiguration::new).register(beanFactory);
  }

  public static void registerThymeleafAutoConfiguration_DefaultTemplateResolverConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration$DefaultTemplateResolverConfiguration", ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class).withConstructor(ThymeleafProperties.class, ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerDefaultTemplateResolverConfiguration_defaultTemplateResolver(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("defaultTemplateResolver", SpringResourceTemplateResolver.class).withFactoryMethod(ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class, "defaultTemplateResolver")
        .instanceSupplier(() -> beanFactory.getBean(ThymeleafAutoConfiguration.DefaultTemplateResolverConfiguration.class).defaultTemplateResolver()).register(beanFactory);
  }

  public static void registerTemplateEngineConfigurations_DefaultTemplateEngineConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.thymeleaf.TemplateEngineConfigurations$DefaultTemplateEngineConfiguration", TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class)
        .instanceSupplier(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration::new).register(beanFactory);
  }

  public static void registerDefaultTemplateEngineConfiguration_templateEngine(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("templateEngine", SpringTemplateEngine.class).withFactoryMethod(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class, "templateEngine", ThymeleafProperties.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(TemplateEngineConfigurations.DefaultTemplateEngineConfiguration.class).templateEngine(attributes.get(0), attributes.get(1), attributes.get(2)))).register(beanFactory);
  }
}
