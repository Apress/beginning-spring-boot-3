package org.springframework.boot.sql.init.dependency;

public abstract class _FactoryProvider {
  public static AnnotationDependsOnDatabaseInitializationDetector annotationDependsOnDatabaseInitializationDetector(
      ) {
    return new AnnotationDependsOnDatabaseInitializationDetector();
  }
}
