package org.springframework.boot.autoconfigure.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import java.util.List;
import org.springframework.aot.beans.factory.BeanDefinitionRegistrar;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

public final class ContextBootstrapInitializer {
  public static void registerJacksonAutoConfiguration_Jackson2ObjectMapperBuilderCustomizerConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$Jackson2ObjectMapperBuilderCustomizerConfiguration", JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration::new).register(beanFactory);
  }

  public static void registerJackson2ObjectMapperBuilderCustomizerConfiguration_standardJacksonObjectMapperBuilderCustomizer(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("standardJacksonObjectMapperBuilderCustomizer", JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.StandardJackson2ObjectMapperBuilderCustomizer.class).withFactoryMethod(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class, "standardJacksonObjectMapperBuilderCustomizer", ApplicationContext.class, JacksonProperties.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JacksonAutoConfiguration.Jackson2ObjectMapperBuilderCustomizerConfiguration.class).standardJacksonObjectMapperBuilderCustomizer(attributes.get(0), attributes.get(1)))).register(beanFactory);
  }

  public static void registerJacksonAutoConfiguration_JacksonObjectMapperBuilderConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperBuilderConfiguration", JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration::new).register(beanFactory);
  }

  public static void registerJacksonObjectMapperBuilderConfiguration_jacksonObjectMapperBuilder(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("jacksonObjectMapperBuilder", Jackson2ObjectMapperBuilder.class).withFactoryMethod(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class, "jacksonObjectMapperBuilder", ApplicationContext.class, List.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JacksonAutoConfiguration.JacksonObjectMapperBuilderConfiguration.class).jacksonObjectMapperBuilder(attributes.get(0), attributes.get(1)))).customize((bd) -> bd.setScope("prototype")).register(beanFactory);
  }

  public static void registerJacksonAutoConfiguration_ParameterNamesModuleConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$ParameterNamesModuleConfiguration", JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration.ParameterNamesModuleConfiguration::new).register(beanFactory);
  }

  public static void registerParameterNamesModuleConfiguration_parameterNamesModule(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("parameterNamesModule", ParameterNamesModule.class).withFactoryMethod(JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class, "parameterNamesModule")
        .instanceSupplier(() -> beanFactory.getBean(JacksonAutoConfiguration.ParameterNamesModuleConfiguration.class).parameterNamesModule()).register(beanFactory);
  }

  public static void registerJacksonAutoConfiguration_JacksonObjectMapperConfiguration(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration$JacksonObjectMapperConfiguration", JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class)
        .instanceSupplier(JacksonAutoConfiguration.JacksonObjectMapperConfiguration::new).register(beanFactory);
  }

  public static void registerJacksonObjectMapperConfiguration_jacksonObjectMapper(
      DefaultListableBeanFactory beanFactory) {
    BeanDefinitionRegistrar.of("jacksonObjectMapper", ObjectMapper.class).withFactoryMethod(JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class, "jacksonObjectMapper", Jackson2ObjectMapperBuilder.class)
        .instanceSupplier((instanceContext) -> instanceContext.create(beanFactory, (attributes) -> beanFactory.getBean(JacksonAutoConfiguration.JacksonObjectMapperConfiguration.class).jacksonObjectMapper(attributes.get(0)))).customize((bd) -> bd.setPrimary(true)).register(beanFactory);
  }
}
