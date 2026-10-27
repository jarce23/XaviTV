package io.realm;

import android.os.Looper;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.util.ArrayList;
import java.util.Collection;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends d {

    /* renamed from: z, reason: collision with root package name */
    public static final Object f6839z = new Object();

    /* renamed from: y, reason: collision with root package name */
    public final k f6840y;

    public u(OsSharedRealm osSharedRealm) {
        super(osSharedRealm);
        this.f6840y = new k(this, new x4.i(this.f6645q.g, osSharedRealm.getSchemaInfo()), 0);
    }

    public static u R(f0 f0Var) {
        if (f0Var == null) {
            throw new IllegalArgumentException("A non-null RealmConfiguration must be provided");
        }
        ArrayList arrayList = c0.f6633e;
        return (u) c0.c(f0Var.f6666c, true).a(f0Var, u.class, io.realm.internal.t.f6767q);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void S(android.content.Context r7) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.realm.u.S(android.content.Context):void");
    }

    public static void U(f0 f0Var) {
        synchronized (f6839z) {
        }
    }

    @Override // io.realm.d
    public final k M() {
        return this.f6840y;
    }

    public final void P(t tVar) {
        c();
        Looper looper = (Looper) ((ea.a) this.f6647s.capabilities).f4681c;
        if (looper != null && looper == Looper.getMainLooper() && !this.f6645q.f6672j) {
            throw new RealmException("Running transactions on the UI thread has been disabled. It can be enabled by setting 'RealmConfiguration.Builder.allowWritesOnUiThread(true)'.");
        }
        c();
        this.f6647s.beginTransaction();
        try {
            tVar.e(this);
            c();
            this.f6647s.commitTransaction();
        } catch (Throwable th) {
            if (O()) {
                c();
                this.f6647s.cancelTransaction();
            } else {
                RealmLog.c("Could not cancel transaction, not currently in a transaction.", new Object[0]);
            }
            throw th;
        }
    }

    public final a6.n Q(t tVar, androidx.fragment.app.v0 v0Var) {
        c();
        if (N()) {
            throw new IllegalStateException("Write transactions on a frozen Realm is not allowed.");
        }
        io.realm.internal.a aVar = this.f6647s.capabilities;
        ea.a aVar2 = (ea.a) aVar;
        boolean z10 = (((Looper) aVar2.f4681c) == null || aVar2.f4680b) ? false : true;
        if (v0Var != null) {
            ((ea.a) aVar).c("Callback cannot be delivered on current thread.");
        }
        s sVar = new s(this, this.f6645q, tVar, z10, v0Var, this.f6647s.realmNotifier);
        fa.b bVar = d.f6640v;
        bVar.getClass();
        bVar.submit(new androidx.activity.j(14, sVar));
        return new a6.n(25, bVar);
    }

    public final void T(Collection collection) {
        if (!O()) {
            throw new IllegalStateException("Changing Realm data can only be done from inside a transaction.");
        }
        if (collection == null) {
            throw new IllegalArgumentException("Null objects cannot be inserted into Realm.");
        }
        if (collection.isEmpty()) {
            return;
        }
        this.f6645q.g.h(this, collection);
    }

    public final RealmQuery V(Class cls) {
        c();
        return new RealmQuery(this, cls);
    }

    @Override // io.realm.d
    public final d s() {
        io.realm.internal.t versionID = this.f6647s.getVersionID();
        ArrayList arrayList = c0.f6633e;
        f0 f0Var = this.f6645q;
        return (u) c0.c(f0Var.f6666c, true).a(f0Var, u.class, versionID);
    }

    public u(c0 c0Var, io.realm.internal.t tVar) {
        super(c0Var, new OsSchemaInfo(c0Var.f6637c.g.c().values()), tVar);
        this.f6840y = new k(this, new x4.i(this.f6645q.g, this.f6647s.getSchemaInfo()), 0);
        this.f6645q.getClass();
    }
}
