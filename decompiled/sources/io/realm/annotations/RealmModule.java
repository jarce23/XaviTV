package io.realm.annotations;

import ca.a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface RealmModule {
    boolean allClasses() default false;

    a classNamingPolicy() default a.f2982o;

    Class<?>[] classes() default {};

    a fieldNamingPolicy() default a.f2982o;

    boolean library() default false;
}
