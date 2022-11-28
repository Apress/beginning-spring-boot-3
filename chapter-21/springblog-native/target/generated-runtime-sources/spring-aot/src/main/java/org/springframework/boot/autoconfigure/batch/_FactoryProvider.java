package org.springframework.boot.autoconfigure.batch;

public abstract class _FactoryProvider {
  public static JobRepositoryDependsOnDatabaseInitializationDetector jobRepositoryDependsOnDatabaseInitializationDetector(
      ) {
    return new JobRepositoryDependsOnDatabaseInitializationDetector();
  }
}
