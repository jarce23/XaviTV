package r3;

import java.util.concurrent.atomic.AtomicInteger;
import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements h {

    /* renamed from: a, reason: collision with root package name */
    public final l1.t f10513a;

    /* renamed from: c, reason: collision with root package name */
    public final String f10515c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10516d;

    /* renamed from: f, reason: collision with root package name */
    public String f10518f;
    public g0 g;

    /* renamed from: i, reason: collision with root package name */
    public int f10520i;

    /* renamed from: j, reason: collision with root package name */
    public int f10521j;

    /* renamed from: k, reason: collision with root package name */
    public long f10522k;

    /* renamed from: l, reason: collision with root package name */
    public i1.p f10523l;

    /* renamed from: m, reason: collision with root package name */
    public int f10524m;

    /* renamed from: n, reason: collision with root package name */
    public int f10525n;

    /* renamed from: h, reason: collision with root package name */
    public int f10519h = 0;

    /* renamed from: q, reason: collision with root package name */
    public long f10528q = -9223372036854775807L;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicInteger f10514b = new AtomicInteger();

    /* renamed from: o, reason: collision with root package name */
    public int f10526o = -1;

    /* renamed from: p, reason: collision with root package name */
    public int f10527p = -1;

    /* renamed from: e, reason: collision with root package name */
    public final String f10517e = "video/mp2t";

    public f(String str, int i10, int i11) {
        this.f10513a = new l1.t(new byte[i11]);
        this.f10515c = str;
        this.f10516d = i10;
    }

    @Override // r3.h
    public final void a() {
        this.f10519h = 0;
        this.f10520i = 0;
        this.f10521j = 0;
        this.f10528q = -9223372036854775807L;
        this.f10514b.set(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0488  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x04bb  */
    @Override // r3.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(l1.t r40) {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r3.f.b(l1.t):void");
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        this.f10528q = j10;
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        e0Var.a();
        e0Var.b();
        this.f10518f = e0Var.f10512e;
        e0Var.b();
        this.g = pVar.q(e0Var.f10511d, 1);
    }

    public final boolean f(l1.t tVar, byte[] bArr, int i10) {
        int min = Math.min(tVar.a(), i10 - this.f10520i);
        tVar.h(bArr, this.f10520i, min);
        int i11 = this.f10520i + min;
        this.f10520i = i11;
        return i11 == i10;
    }

    public final void g(k2.a aVar) {
        int i10 = aVar.f7661b;
        String str = aVar.f7660a;
        int i11 = aVar.f7662c;
        if (i10 == -2147483647 || i11 == -1) {
            return;
        }
        i1.p pVar = this.f10523l;
        if (pVar != null && i11 == pVar.F && i10 == pVar.G && str.equals(pVar.f5991n)) {
            return;
        }
        i1.p pVar2 = this.f10523l;
        i1.o oVar = pVar2 == null ? new i1.o() : pVar2.a();
        oVar.f5929a = this.f10518f;
        oVar.f5939l = i1.g0.m(this.f10517e);
        oVar.f5940m = i1.g0.m(str);
        oVar.E = i11;
        oVar.F = i10;
        oVar.f5932d = this.f10515c;
        oVar.f5934f = this.f10516d;
        i1.p pVar3 = new i1.p(oVar);
        this.f10523l = pVar3;
        this.g.a(pVar3);
    }

    @Override // r3.h
    public final void c(boolean z10) {
    }
}
