package org.springframework.boot.test.autoconfigure.jdbc;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class SpringblogApplicationTestsContextInitializer {
  public static void registerTestDatabaseAutoConfiguration_dataSource(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("dataSource", TestDatabaseAutoConfiguration.EmbeddedDataSourceFactoryBean.class)
        .instanceSupplier(TestDatabaseAutoConfiguration.EmbeddedDataSourceFactoryBean::new).register(beanFactory);
  }
}
