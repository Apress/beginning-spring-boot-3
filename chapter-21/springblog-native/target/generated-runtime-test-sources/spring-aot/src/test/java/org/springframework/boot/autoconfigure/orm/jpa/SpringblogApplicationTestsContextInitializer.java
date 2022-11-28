package org.springframework.boot.autoconfigure.orm.jpa;

import javax.sql.DataSource;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class SpringblogApplicationTestsContextInitializer {
  public static void registerHibernateJpaConfiguration(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaConfiguration", HibernateJpaConfiguration.class).withConstructor(DataSource.class, JpaProperties.class, ConfigurableListableBeanFactory.class, ObjectProvider.class, HibernateProperties.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> new HibernateJpaConfiguration(attributes.get(0), attributes.get(1), attributes.get(2), attributes.get(3), attributes.get(4), attributes.get(5), attributes.get(6), attributes.get(7), attributes.get(8), attributes.get(9)))).register(beanFactory);
  }
}
