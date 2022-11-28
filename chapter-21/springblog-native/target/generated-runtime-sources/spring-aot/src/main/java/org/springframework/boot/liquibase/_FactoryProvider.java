package org.springframework.boot.liquibase;

public abstract class _FactoryProvider {
  public static LiquibaseDatabaseInitializerDetector liquibaseDatabaseInitializerDetector() {
    return new LiquibaseDatabaseInitializerDetector();
  }
}
