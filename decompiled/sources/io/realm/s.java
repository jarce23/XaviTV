package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.RealmNotifier;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ f0 f6820o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ t f6821p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f6822q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ androidx.fragment.app.v0 f6823r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ RealmNotifier f6824s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ u f6825t;

    public s(u uVar, f0 f0Var, t tVar, boolean z10, androidx.fragment.app.v0 v0Var, RealmNotifier realmNotifier) {
        this.f6825t = uVar;
        this.f6820o = f0Var;
        this.f6821p = tVar;
        this.f6822q = z10;
        this.f6823r = v0Var;
        this.f6824s = realmNotifier;
    }

    @Override // java.lang.Runnable
    public final void run() {
        io.realm.internal.t tVar;
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        u R = u.R(this.f6820o);
        R.c();
        R.f6647s.beginTransaction();
        Throwable th = null;
        try {
            this.f6821p.e(R);
        } catch (Throwable th2) {
            try {
                if (R.O()) {
                    R.c();
                    R.f6647s.cancelTransaction();
                }
                R.close();
                tVar = null;
                th = th2;
            } finally {
            }
        }
        if (Thread.currentThread().isInterrupted()) {
            try {
                if (R.O()) {
                    R.c();
                    R.f6647s.cancelTransaction();
                }
                return;
            } finally {
            }
        }
        R.c();
        R.f6647s.commitTransaction();
        tVar = R.f6647s.getVersionID();
        try {
            if (R.O()) {
                R.c();
                R.f6647s.cancelTransaction();
            }
            if (!this.f6822q) {
                if (th != null) {
                    throw new RealmException("Async transaction failed", th);
                }
                return;
            }
            RealmNotifier realmNotifier = this.f6824s;
            if (tVar != null && this.f6823r != null) {
                realmNotifier.post(new app.shamel.tv.activities.y(this, 14, tVar));
            } else if (th != null) {
                realmNotifier.post(new app.shamel.tv.activities.y(this, 15, th));
            }
        } finally {
        }
    }
}
