package org.springframework.boot.autoconfigure.aop;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerAspectJAutoProxyingConfiguration_JdkDynamicAutoProxyConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration$JdkDynamicAutoProxyConfiguration", AopAutoConfiguration.AspectJAutoProxyingConfiguration.JdkDynamicAutoProxyConfiguration.class)
        .instanceSupplier(AopAutoConfiguration.AspectJAutoProxyingConfiguration.JdkDynamicAutoProxyConfiguration::new).register(beanFactory);
  }

  public static void registerAopAutoConfiguration_AspectJAutoProxyingConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.aop.AopAutoConfiguration$AspectJAutoProxyingConfiguration", AopAutoConfiguration.AspectJAutoProxyingConfiguration.class)
        .instanceSupplier(AopAutoConfiguration.AspectJAutoProxyingConfiguration::new).register(beanFactory);
  }
}
