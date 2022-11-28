package org.springframework.boot.context.properties;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;

public final class ContextBootstrapInitializer {
  public static void registerConfigurationPropertiesBinder_Factory(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.context.internalConfigurationPropertiesBinderFactory", ConfigurationPropertiesBinder.Factory.class)
        .instanceSupplier(ConfigurationPropertiesBinder.Factory::new).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }

  public static void registerConfigurationPropertiesBinder(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.context.internalConfigurationPropertiesBinder", ConfigurationPropertiesBinder.class).withConstructor(ApplicationContext.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new ConfigurationPropertiesBinder(attributes.get(0)))).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }
}
