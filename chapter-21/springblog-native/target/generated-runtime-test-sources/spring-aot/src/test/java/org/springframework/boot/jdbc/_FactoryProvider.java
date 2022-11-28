package org.springframework.boot.jdbc;

public abstract class _FactoryProvider {
  public static AbstractDataSourceInitializerDatabaseInitializerDetector abstractDataSourceInitializerDatabaseInitializerDetector(
      ) {
    return new AbstractDataSourceInitializerDatabaseInitializerDetector();
  }

  public static SpringJdbcDependsOnDatabaseInitializationDetector springJdbcDependsOnDatabaseInitializationDetector(
      ) {
    return new SpringJdbcDependsOnDatabaseInitializationDetector();
  }
}
