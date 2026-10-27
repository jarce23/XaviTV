package s1;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g1 implements l0 {

    /* renamed from: o, reason: collision with root package name */
    public long f11311o;

    /* renamed from: p, reason: collision with root package name */
    public long f11312p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11313q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f11314r;

    /* renamed from: s, reason: collision with root package name */
    public Object f11315s;

    public g1(p0.b bVar) {
        this.f11314r = new Handler(Looper.getMainLooper());
        this.f11315s = bVar;
    }

    @Override // s1.l0
    public void a(i1.j0 j0Var) {
        if (this.f11313q) {
            c(e());
        }
        this.f11315s = j0Var;
    }

    @Override // s1.l0
    public /* synthetic */ boolean b() {
        return false;
    }

    public void c(long j10) {
        this.f11311o = j10;
        if (this.f11313q) {
            ((l1.v) this.f11314r).getClass();
            this.f11312p = SystemClock.elapsedRealtime();
        }
    }

    @Override // s1.l0
    public i1.j0 d() {
        return (i1.j0) this.f11315s;
    }

    @Override // s1.l0
    public long e() {
        long j10 = this.f11311o;
        if (!this.f11313q) {
            return j10;
        }
        ((l1.v) this.f11314r).getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f11312p;
        return (((i1.j0) this.f11315s).f5906a == 1.0f ? l1.a0.O(elapsedRealtime) : elapsedRealtime * r4.f5908c) + j10;
    }

    public void f() {
        if (this.f11313q) {
            return;
        }
        ((l1.v) this.f11314r).getClass();
        this.f11312p = SystemClock.elapsedRealtime();
        this.f11313q = true;
    }

    public g1(l1.v vVar) {
        this.f11314r = vVar;
        this.f11315s = i1.j0.f5905d;
    }
}
