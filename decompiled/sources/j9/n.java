package j9;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7381o = 2;

    /* renamed from: p, reason: collision with root package name */
    public final Object f7382p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f7383q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f7384r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f7385s;

    /* renamed from: t, reason: collision with root package name */
    public final Object f7386t;

    /* renamed from: u, reason: collision with root package name */
    public final Object f7387u;

    /* renamed from: v, reason: collision with root package name */
    public final Object f7388v;

    /* renamed from: w, reason: collision with root package name */
    public final Object f7389w;

    /* renamed from: x, reason: collision with root package name */
    public final Object f7390x;

    public n(h5.i iVar, k9.e eVar, k9.e eVar2, d1 d1Var, k9.e eVar3, k9.e eVar4, k9.e eVar5, k9.e eVar6, k9.e eVar7) {
        this.f7390x = iVar;
        this.f7382p = eVar;
        this.f7384r = eVar2;
        this.f7383q = d1Var;
        this.f7385s = eVar3;
        this.f7386t = eVar4;
        this.f7387u = eVar5;
        this.f7388v = eVar6;
        this.f7389w = eVar7;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x03eb A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(final s6.i r45, int r46) {
        /*
            Method dump skipped, instructions count: 1158
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.n.a(s6.i, int):void");
    }

    @Override // k9.f
    public Object c() {
        switch (this.f7381o) {
            case 0:
                Context context = ((androidx.emoji2.text.o) ((h5.i) this.f7390x).f5610p).f591o;
                Object c10 = ((k9.e) this.f7382p).c();
                Object c11 = ((k9.e) this.f7384r).c();
                k9.e eVar = new k9.e(new h5.i(12, (d1) this.f7383q));
                Object c12 = ((k9.e) this.f7385s).c();
                Object c13 = ((k9.e) this.f7386t).c();
                return new m(context, (u0) c10, (l0) c11, eVar, (n0) c12, (y) c13, new k9.e(new h5.i(12, (k9.e) this.f7387u)), new k9.e(new h5.i(12, (k9.e) this.f7388v)), (i1) ((k9.e) this.f7389w).c());
            default:
                Object c14 = ((k9.e) this.f7382p).c();
                return new l0((u0) c14, new k9.e(new h5.i(12, (d1) this.f7383q)), (a0) ((k9.e) this.f7384r).c(), (s1) ((k9.e) this.f7385s).c(), (c1) ((k9.e) this.f7386t).c(), (f1) ((k9.e) this.f7387u).c(), (l1) ((k9.e) this.f7388v).c(), (n1) ((k9.e) this.f7389w).c(), (w0) ((k9.e) this.f7390x).c());
        }
    }

    public n(k9.e eVar, d1 d1Var, k9.e eVar2, k9.e eVar3, k9.e eVar4, k9.e eVar5, k9.e eVar6, k9.e eVar7, k9.e eVar8) {
        this.f7382p = eVar;
        this.f7383q = d1Var;
        this.f7384r = eVar2;
        this.f7385s = eVar3;
        this.f7386t = eVar4;
        this.f7387u = eVar5;
        this.f7388v = eVar6;
        this.f7389w = eVar7;
        this.f7390x = eVar8;
    }

    public n(Context context, t6.d dVar, a7.d dVar2, android.support.v4.media.session.a0 a0Var, Executor executor, b7.c cVar, c7.a aVar, c7.a aVar2, a7.c cVar2) {
        this.f7390x = context;
        this.f7382p = dVar;
        this.f7384r = dVar2;
        this.f7385s = a0Var;
        this.f7386t = executor;
        this.f7387u = cVar;
        this.f7388v = aVar;
        this.f7389w = aVar2;
        this.f7383q = cVar2;
    }
}
