package org.springframework.boot.flyway;

public abstract class _FactoryProvider {
  public static FlywayDatabaseInitializerDetector flywayDatabaseInitializerDetector() {
    return new FlywayDatabaseInitializerDetector();
  }
}
