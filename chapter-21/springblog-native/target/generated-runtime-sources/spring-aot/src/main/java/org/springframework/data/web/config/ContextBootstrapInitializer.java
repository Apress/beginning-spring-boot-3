package org.springframework.data.web.config;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerProjectingArgumentResolverRegistrar_projectingArgumentResolverBeanPostProcessor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("projectingArgumentResolverBeanPostProcessor", ProjectingArgumentResolverRegistrar.ProjectingArgumentResolverBeanPostProcessor.class).withFactoryMethod(ProjectingArgumentResolverRegistrar.class, "projectingArgumentResolverBeanPostProcessor", ObjectFactory.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> ProjectingArgumentResolverRegistrar.projectingArgumentResolverBeanPostProcessor(attributes.get(0)))).register(beanFactory);
  }
}
