package org.springframework.boot.autoconfigure.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

public final class ContextBootstrapInitializer {
  public static void registerHttpMessageConvertersAutoConfiguration_StringHttpMessageConverterConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration$StringHttpMessageConverterConfiguration", HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration.class)
        .instanceSupplier(HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration::new).register(beanFactory);
  }

  public static void registerStringHttpMessageConverterConfiguration_stringHttpMessageConverter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("stringHttpMessageConverter", StringHttpMessageConverter.class).withFactoryMethod(HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration.class, "stringHttpMessageConverter", Environment.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(HttpMessageConvertersAutoConfiguration.StringHttpMessageConverterConfiguration.class).stringHttpMessageConverter(attributes.get(0)))).register(beanFactory);
  }

  public static void registerJacksonHttpMessageConvertersConfiguration_MappingJackson2HttpMessageConverterConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration$MappingJackson2HttpMessageConverterConfiguration", JacksonHttpMessageConvertersConfiguration.MappingJackson2HttpMessageConverterConfiguration.class)
        .instanceSupplier(JacksonHttpMessageConvertersConfiguration.MappingJackson2HttpMessageConverterConfiguration::new).register(beanFactory);
  }

  public static void registerMappingJackson2HttpMessageConverterConfiguration_mappingJackson2HttpMessageConverter(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("mappingJackson2HttpMessageConverter", MappingJackson2HttpMessageConverter.class).withFactoryMethod(JacksonHttpMessageConvertersConfiguration.MappingJackson2HttpMessageConverterConfiguration.class, "mappingJackson2HttpMessageConverter", ObjectMapper.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JacksonHttpMessageConvertersConfiguration.MappingJackson2HttpMessageConverterConfiguration.class).mappingJackson2HttpMessageConverter(attributes.get(0)))).register(beanFactory);
  }

  public static void registerJacksonHttpMessageConvertersConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.http.JacksonHttpMessageConvertersConfiguration", JacksonHttpMessageConvertersConfiguration.class)
        .instanceSupplier(JacksonHttpMessageConvertersConfiguration::new).register(beanFactory);
  }
}
