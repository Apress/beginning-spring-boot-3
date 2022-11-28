package org.springframework.transaction.annotation;

import java.util.Collection;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerProxyTransactionManagementConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.transaction.annotation.ProxyTransactionManagementConfiguration", ProxyTransactionManagementConfiguration.class)
        .instanceSupplier((instanceContext) -> {
          ProxyTransactionManagementConfiguration bean = new ProxyTransactionManagementConfiguration();
          instanceContext.method("setConfigurers", Collection.class)
              .resolve(beanFactory, false).ifResolved((attributes) -> bean.setConfigurers(attributes.get(0)));
          return bean;
        }).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }
}
