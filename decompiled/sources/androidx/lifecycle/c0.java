package androidx.lifecycle;

import android.os.Handler;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements r {

    /* renamed from: w, reason: collision with root package name */
    public static final c0 f1116w = new c0();

    /* renamed from: o, reason: collision with root package name */
    public int f1117o;

    /* renamed from: p, reason: collision with root package name */
    public int f1118p;

    /* renamed from: s, reason: collision with root package name */
    public Handler f1121s;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1119q = true;

    /* renamed from: r, reason: collision with root package name */
    public boolean f1120r = true;

    /* renamed from: t, reason: collision with root package name */
    public final t f1122t = new t(this);

    /* renamed from: u, reason: collision with root package name */
    public final androidx.activity.d f1123u = new androidx.activity.d(5, this);

    /* renamed from: v, reason: collision with root package name */
    public final a6.n f1124v = new a6.n(6, this);

    public final void a() {
        int i10 = this.f1118p + 1;
        this.f1118p = i10;
        if (i10 == 1) {
            if (this.f1119q) {
                this.f1122t.d(l.ON_RESUME);
                this.f1119q = false;
            } else {
                Handler handler = this.f1121s;
                za.h.b(handler);
                handler.removeCallbacks(this.f1123u);
            }
        }
    }

    @Override // androidx.lifecycle.r
    public final t f() {
        return this.f1122t;
    }
}
