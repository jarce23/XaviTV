package h4;

import android.content.Context;
import androidx.lifecycle.h0;
import c2.j1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements g4.c {

    /* renamed from: o, reason: collision with root package name */
    public final Context f5567o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5568p;

    /* renamed from: q, reason: collision with root package name */
    public final j1 f5569q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f5570r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f5571s;

    /* renamed from: t, reason: collision with root package name */
    public final la.g f5572t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5573u;

    public g(Context context, String str, j1 j1Var, boolean z10, boolean z11) {
        za.h.e("callback", j1Var);
        this.f5567o = context;
        this.f5568p = str;
        this.f5569q = j1Var;
        this.f5570r = z10;
        this.f5571s = z11;
        this.f5572t = new la.g(new h0(2, this));
    }

    public final f a() {
        return (f) this.f5572t.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f5572t.f8332p != la.h.f8334a) {
            a().close();
        }
    }

    @Override // g4.c
    public final c getWritableDatabase() {
        return a().a(true);
    }

    @Override // g4.c
    public final void setWriteAheadLoggingEnabled(boolean z10) {
        if (this.f5572t.f8332p != la.h.f8334a) {
            f a10 = a();
            za.h.e("sQLiteOpenHelper", a10);
            a10.setWriteAheadLoggingEnabled(z10);
        }
        this.f5573u = z10;
    }
}
