package org.springframework.boot.autoconfigure.jdbc.metadata;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.jdbc.metadata.DataSourcePoolMetadataProvider;

public final class ContextBootstrapInitializer {
  public static void registerDataSourcePoolMetadataProvidersConfiguration_HikariPoolDataSourceMetadataProviderConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jdbc.metadata.DataSourcePoolMetadataProvidersConfiguration$HikariPoolDataSourceMetadataProviderConfiguration", DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class)
        .instanceSupplier(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration::new).register(beanFactory);
  }

  public static void registerHikariPoolDataSourceMetadataProviderConfiguration_hikariPoolDataSourceMetadataProvider(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("hikariPoolDataSourceMetadataProvider", DataSourcePoolMetadataProvider.class).withFactoryMethod(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class, "hikariPoolDataSourceMetadataProvider")
        .instanceSupplier(() -> beanFactory.getBean(DataSourcePoolMetadataProvidersConfiguration.HikariPoolDataSourceMetadataProviderConfiguration.class).hikariPoolDataSourceMetadataProvider()).register(beanFactory);
  }
}
