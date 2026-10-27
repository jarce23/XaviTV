package r7;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class p {

    /* renamed from: a, reason: collision with root package name */
    public Boolean f10944a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10945b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10946c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10947d;

    /* renamed from: e, reason: collision with root package name */
    public final Bundle f10948e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10949f;

    public p(com.google.android.gms.common.internal.a aVar, int i10, Bundle bundle) {
        this.f10949f = aVar;
        Boolean bool = Boolean.TRUE;
        this.f10946c = aVar;
        this.f10944a = bool;
        this.f10945b = false;
        this.f10947d = i10;
        this.f10948e = bundle;
    }

    public abstract boolean a();

    public abstract void b(n7.a aVar);

    public final void c() {
        d();
        com.google.android.gms.common.internal.a aVar = this.f10946c;
        synchronized (aVar.f3219l) {
            aVar.f3219l.remove(this);
        }
    }

    public final void d() {
        synchronized (this) {
            this.f10944a = null;
        }
    }
}
