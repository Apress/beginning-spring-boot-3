package org.springframework.data.util;

public abstract class _FactoryProvider {
  public static CustomCollections.VavrCollections customCollectionsVavrCollections() {
    return new CustomCollections.VavrCollections();
  }

  public static CustomCollections.EclipseCollections customCollectionsEclipseCollections() {
    return new CustomCollections.EclipseCollections();
  }
}
