package c4;

import androidx.lifecycle.h0;
import androidx.work.impl.WorkDatabase;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final WorkDatabase f2920a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f2921b;

    /* renamed from: c, reason: collision with root package name */
    public final la.g f2922c;

    public o(WorkDatabase workDatabase) {
        za.h.e("database", workDatabase);
        this.f2920a = workDatabase;
        this.f2921b = new AtomicBoolean(false);
        this.f2922c = new la.g(new h0(1, this));
    }

    public final h4.i a() {
        this.f2920a.a();
        return this.f2921b.compareAndSet(false, true) ? (h4.i) this.f2922c.a() : b();
    }

    public final h4.i b() {
        String c10 = c();
        WorkDatabase workDatabase = this.f2920a;
        workDatabase.getClass();
        workDatabase.a();
        workDatabase.b();
        return workDatabase.h().getWritableDatabase().n(c10);
    }

    public abstract String c();

    public final void d(h4.i iVar) {
        za.h.e("statement", iVar);
        if (iVar == ((h4.i) this.f2922c.a())) {
            this.f2921b.set(false);
        }
    }
}
