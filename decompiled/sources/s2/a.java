package s2;

import e3.m;
import java.util.List;
import k2.k;
import k2.n;
import k2.o;
import k2.p;
import k2.r;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: b, reason: collision with root package name */
    public p f11515b;

    /* renamed from: c, reason: collision with root package name */
    public int f11516c;

    /* renamed from: d, reason: collision with root package name */
    public int f11517d;

    /* renamed from: e, reason: collision with root package name */
    public int f11518e;
    public z2.a g;

    /* renamed from: h, reason: collision with root package name */
    public o f11520h;

    /* renamed from: i, reason: collision with root package name */
    public b4.c f11521i;

    /* renamed from: j, reason: collision with root package name */
    public m f11522j;

    /* renamed from: a, reason: collision with root package name */
    public final t f11514a = new t(2);

    /* renamed from: f, reason: collision with root package name */
    public long f11519f = -1;

    @Override // k2.n
    public final void a() {
        m mVar = this.f11522j;
        if (mVar != null) {
            mVar.getClass();
        }
    }

    @Override // k2.n
    public final void c(p pVar) {
        this.f11515b = pVar;
    }

    public final void d() {
        p pVar = this.f11515b;
        pVar.getClass();
        pVar.f();
        this.f11515b.t(new r(-9223372036854775807L));
        this.f11516c = 6;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        if (j10 == 0) {
            this.f11516c = 0;
            this.f11522j = null;
        } else if (this.f11516c == 5) {
            m mVar = this.f11522j;
            mVar.getClass();
            mVar.e(j10, j11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0179  */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r26, i1.s r27) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.a.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        k kVar = (k) oVar;
        t tVar = this.f11514a;
        tVar.F(2);
        kVar.m(tVar.f8129a, 0, 2, false);
        if (tVar.C() == 65496) {
            tVar.F(2);
            kVar.m(tVar.f8129a, 0, 2, false);
            int C = tVar.C();
            this.f11517d = C;
            if (C == 65504) {
                tVar.F(2);
                kVar.m(tVar.f8129a, 0, 2, false);
                kVar.f(tVar.C() - 2, false);
                tVar.F(2);
                kVar.m(tVar.f8129a, 0, 2, false);
                this.f11517d = tVar.C();
            }
            if (this.f11517d == 65505) {
                return true;
            }
        }
        return false;
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
