package org.springframework.boot.jdbc.init;

public abstract class _FactoryProvider {
  public static DataSourceScriptDatabaseInitializerDetector dataSourceScriptDatabaseInitializerDetector(
      ) {
    return new DataSourceScriptDatabaseInitializerDetector();
  }
}
