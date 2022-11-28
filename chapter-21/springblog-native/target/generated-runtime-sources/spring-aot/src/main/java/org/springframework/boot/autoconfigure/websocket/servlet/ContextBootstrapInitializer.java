package org.springframework.boot.autoconfigure.websocket.servlet;

import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public final class ContextBootstrapInitializer {
  public static void registerWebSocketServletAutoConfiguration_TomcatWebSocketConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration$TomcatWebSocketConfiguration", WebSocketServletAutoConfiguration.TomcatWebSocketConfiguration.class)
        .instanceSupplier(WebSocketServletAutoConfiguration.TomcatWebSocketConfiguration::new).register(beanFactory);
  }

  public static void registerTomcatWebSocketConfiguration_websocketServletWebServerCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("websocketServletWebServerCustomizer", TomcatWebSocketServletWebServerCustomizer.class).withFactoryMethod(WebSocketServletAutoConfiguration.TomcatWebSocketConfiguration.class, "websocketServletWebServerCustomizer")
        .instanceSupplier(() -> beanFactory.getBean(WebSocketServletAutoConfiguration.TomcatWebSocketConfiguration.class).websocketServletWebServerCustomizer()).register(beanFactory);
  }
}
