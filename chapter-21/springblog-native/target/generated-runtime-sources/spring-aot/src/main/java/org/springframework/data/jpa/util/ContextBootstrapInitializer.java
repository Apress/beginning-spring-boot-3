package org.springframework.data.jpa.util;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerJpaMetamodelCacheCleanup(DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.data.jpa.util.JpaMetamodelCacheCleanup", JpaMetamodelCacheCleanup.class)
        .instanceSupplier(JpaMetamodelCacheCleanup::new).register(beanFactory);
  }
}
