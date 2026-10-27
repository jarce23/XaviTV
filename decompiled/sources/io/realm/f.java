package io.realm;

import io.realm.internal.OsObjectStore;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: y, reason: collision with root package name */
    public final k f6661y;

    public f(c0 c0Var, io.realm.internal.t tVar) {
        super(c0Var, null, tVar);
        f0 f0Var = c0Var.f6637c;
        j5.g gVar = new j5.g(this, c0Var, false);
        synchronized (c0.f6633e) {
            try {
                c0 c10 = c0.c(f0Var.f6666c, false);
                if (c10 == null) {
                    gVar.q(0);
                } else {
                    c10.b(gVar);
                }
            } finally {
            }
        }
        this.f6661y = new k(this, null, 1);
    }

    @Override // io.realm.d
    public final k M() {
        return this.f6661y;
    }

    @Override // io.realm.d
    public final d s() {
        io.realm.internal.t versionID;
        try {
            versionID = this.f6647s.getVersionID();
        } catch (IllegalStateException unused) {
            OsObjectStore.b(this.f6647s);
            versionID = this.f6647s.getVersionID();
        }
        ArrayList arrayList = c0.f6633e;
        f0 f0Var = this.f6645q;
        return (f) c0.c(f0Var.f6666c, true).a(f0Var, f.class, versionID);
    }
}
