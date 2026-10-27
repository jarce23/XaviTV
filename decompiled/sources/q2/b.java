package q2;

import java.util.List;
import k2.k;
import k2.m;
import k2.n;
import k2.o;
import k2.p;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements n {

    /* renamed from: a, reason: collision with root package name */
    public final t f10244a = new t(4);

    /* renamed from: b, reason: collision with root package name */
    public final t f10245b = new t(9);

    /* renamed from: c, reason: collision with root package name */
    public final t f10246c = new t(11);

    /* renamed from: d, reason: collision with root package name */
    public final t f10247d = new t();

    /* renamed from: e, reason: collision with root package name */
    public final c f10248e;

    /* renamed from: f, reason: collision with root package name */
    public p f10249f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10250h;

    /* renamed from: i, reason: collision with root package name */
    public long f10251i;

    /* renamed from: j, reason: collision with root package name */
    public int f10252j;

    /* renamed from: k, reason: collision with root package name */
    public int f10253k;

    /* renamed from: l, reason: collision with root package name */
    public int f10254l;

    /* renamed from: m, reason: collision with root package name */
    public long f10255m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10256n;

    /* renamed from: o, reason: collision with root package name */
    public a f10257o;

    /* renamed from: p, reason: collision with root package name */
    public d f10258p;

    public b() {
        c cVar = new c(new m());
        cVar.f10259b = -9223372036854775807L;
        cVar.f10260c = new long[0];
        cVar.f10261d = new long[0];
        this.f10248e = cVar;
        this.g = 1;
    }

    @Override // k2.n
    public final void c(p pVar) {
        this.f10249f = pVar;
    }

    public final t d(o oVar) {
        int i10 = this.f10254l;
        t tVar = this.f10247d;
        byte[] bArr = tVar.f8129a;
        if (i10 > bArr.length) {
            tVar.G(0, new byte[Math.max(bArr.length * 2, i10)]);
        } else {
            tVar.I(0);
        }
        tVar.H(this.f10254l);
        oVar.readFully(tVar.f8129a, 0, this.f10254l);
        return tVar;
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        if (j10 == 0) {
            this.g = 1;
            this.f10250h = false;
        } else {
            this.g = 3;
        }
        this.f10252j = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0009 A[SYNTHETIC] */
    @Override // k2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int f(k2.o r29, i1.s r30) {
        /*
            Method dump skipped, instructions count: 1119
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.b.f(k2.o, i1.s):int");
    }

    @Override // k2.n
    public final List g() {
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        t tVar = this.f10244a;
        k kVar = (k) oVar;
        kVar.m(tVar.f8129a, 0, 3, false);
        tVar.I(0);
        if (tVar.z() == 4607062) {
            kVar.m(tVar.f8129a, 0, 2, false);
            tVar.I(0);
            if ((tVar.C() & 250) == 0) {
                kVar.m(tVar.f8129a, 0, 4, false);
                tVar.I(0);
                int j10 = tVar.j();
                kVar.f7755t = 0;
                kVar.f(j10, false);
                kVar.m(tVar.f8129a, 0, 4, false);
                tVar.I(0);
                if (tVar.j() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // k2.n
    public final void a() {
    }

    @Override // k2.n
    public final n b() {
        return this;
    }
}
