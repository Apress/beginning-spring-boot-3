package org.springframework.boot.autoconfigure.quartz;

public abstract class _FactoryProvider {
  public static SchedulerDependsOnDatabaseInitializationDetector schedulerDependsOnDatabaseInitializationDetector(
      ) {
    return new SchedulerDependsOnDatabaseInitializationDetector();
  }
}
