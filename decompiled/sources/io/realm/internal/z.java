package io.realm.internal;

import io.realm.exceptions.RealmException;
import io.realm.i0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class z {
    public static RealmException d(Class cls) {
        return new RealmException(android.support.v4.media.d.q("'", cls.toString(), "' is not part of the schema for this Realm."));
    }

    public abstract c a(Class cls, OsSchemaInfo osSchemaInfo);

    public abstract Class b(String str);

    public abstract HashMap c();

    public abstract Set e();

    public final boolean equals(Object obj) {
        if (obj instanceof z) {
            return e().equals(((z) obj).e());
        }
        return false;
    }

    public final String f(Class cls) {
        return g(Util.a(cls));
    }

    public abstract String g(Class cls);

    public abstract void h(io.realm.u uVar, Collection collection);

    public final int hashCode() {
        return e().hashCode();
    }

    public abstract i0 i(Class cls, Object obj, a0 a0Var, c cVar);

    public abstract boolean j();
}
