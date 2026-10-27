package io.realm;

import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import io.realm.internal.core.NativeRealmAny;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j0 extends x {

    /* renamed from: b, reason: collision with root package name */
    public final i0 f6772b;

    public j0(i0 i0Var) {
        v vVar = v.OBJECT;
        this.f6772b = i0Var;
        i0Var.getClass();
    }

    @Override // io.realm.x
    public final NativeRealmAny a() {
        i0 i0Var = this.f6772b;
        if (i0Var instanceof io.realm.internal.y) {
            return new NativeRealmAny((io.realm.internal.y) io.realm.internal.y.class.cast(i0Var));
        }
        throw new IllegalStateException("Native RealmAny instances only allow managed Realm objects or primitives");
    }

    @Override // io.realm.x
    public final Object b(Class cls) {
        return cls.cast(this.f6772b);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !getClass().equals(obj.getClass())) {
            return false;
        }
        i0 i0Var = ((j0) obj).f6772b;
        i0 i0Var2 = this.f6772b;
        return i0Var2 == null ? i0Var == null : i0Var2.equals(i0Var);
    }

    public final int hashCode() {
        return this.f6772b.hashCode();
    }

    public final String toString() {
        return this.f6772b.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(d dVar, NativeRealmAny nativeRealmAny, Class cls) {
        super(nativeRealmAny);
        v vVar = v.OBJECT;
        long realmModelRowKey = nativeRealmAny.getRealmModelRowKey();
        List list = Collections.EMPTY_LIST;
        dVar.getClass();
        Table b2 = dVar.M().b(cls);
        io.realm.internal.g gVar = b2.f6718p;
        int i10 = UncheckedRow.f6726s;
        this.f6772b = dVar.f6645q.g.i(cls, dVar, new UncheckedRow(gVar, b2, b2.nativeGetRowPtr(b2.f6717o, realmModelRowKey)), dVar.M().a(cls));
    }
}
