package org.springframework.boot.test.autoconfigure;

public abstract class _FactoryProvider {
  public static SpringBootDependencyInjectionTestExecutionListener.PostProcessor springBootDependencyInjectionTestExecutionListenerPostProcessor(
      ) {
    return new SpringBootDependencyInjectionTestExecutionListener.PostProcessor();
  }
}
