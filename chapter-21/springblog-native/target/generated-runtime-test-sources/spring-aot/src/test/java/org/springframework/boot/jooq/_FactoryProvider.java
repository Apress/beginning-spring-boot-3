package org.springframework.boot.jooq;

public abstract class _FactoryProvider {
  public static JooqDependsOnDatabaseInitializationDetector jooqDependsOnDatabaseInitializationDetector(
      ) {
    return new JooqDependsOnDatabaseInitializationDetector();
  }
}
