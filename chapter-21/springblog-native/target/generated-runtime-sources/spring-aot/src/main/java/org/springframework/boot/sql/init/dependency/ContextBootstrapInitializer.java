package org.springframework.boot.sql.init.dependency;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerDatabaseInitializationDependencyConfigurer_DependsOnDatabaseInitializationPostProcessor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.sql.init.dependency.DatabaseInitializationDependencyConfigurer$DependsOnDatabaseInitializationPostProcessor", DatabaseInitializationDependencyConfigurer.DependsOnDatabaseInitializationPostProcessor.class)
        .instanceSupplier(DatabaseInitializationDependencyConfigurer.DependsOnDatabaseInitializationPostProcessor::new).register(beanFactory);
  }
}
