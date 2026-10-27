package com.google.gson;

import java.lang.reflect.Field;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface FieldNamingStrategy {
    List<String> alternateNames(Field field);

    String translateName(Field field);
}
