package org.springframework.boot.autoconfigure;

import java.lang.String;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerAutoConfigurationPackages_BasePackages(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.AutoConfigurationPackages", AutoConfigurationPackages.BasePackages.class)
        .instanceSupplier(() -> new AutoConfigurationPackages.BasePackages(new String[] { "com.apress.demo.springblog" })).customize((bd) -> bd.setRole(2)).register(beanFactory);
  }
}
