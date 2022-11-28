package org.springframework.boot.autoconfigure.orm.jpa;

import javax.sql.DataSource;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public final class ContextBootstrapInitializer {
  public static void registerJpaBaseConfiguration_JpaWebConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration$JpaWebConfiguration", JpaBaseConfiguration.JpaWebConfiguration.class).withConstructor(JpaProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new JpaBaseConfiguration.JpaWebConfiguration(attributes.get(0)))).register(beanFactory);
  }

  public static void registerJpaWebConfiguration_openEntityManagerInViewInterceptor(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("openEntityManagerInViewInterceptor", OpenEntityManagerInViewInterceptor.class).withFactoryMethod(JpaBaseConfiguration.JpaWebConfiguration.class, "openEntityManagerInViewInterceptor")
        .instanceSupplier(() -> beanFactory.getBean(JpaBaseConfiguration.JpaWebConfiguration.class).openEntityManagerInViewInterceptor()).register(beanFactory);
  }

  public static void registerJpaWebConfiguration_openEntityManagerInViewInterceptorConfigurer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("openEntityManagerInViewInterceptorConfigurer", WebMvcConfigurer.class).withFactoryMethod(JpaBaseConfiguration.JpaWebConfiguration.class, "openEntityManagerInViewInterceptorConfigurer", OpenEntityManagerInViewInterceptor.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JpaBaseConfiguration.JpaWebConfiguration.class).openEntityManagerInViewInterceptorConfigurer(attributes.get(0)))).register(beanFactory);
  }

  public static void registerHibernateJpaConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration", HibernateJpaConfiguration.class).withConstructor(DataSource.class, JpaProperties.class, ConfigurableListableBeanFactory.class, ObjectProvider.class, HibernateProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new HibernateJpaConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6), attributes.get(7), attributes.get(8), attributes.get(9)))).register(beanFactory);
  }
}
