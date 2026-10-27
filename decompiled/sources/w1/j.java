package w1;

import android.net.Uri;
import android.text.TextUtils;
import i1.f0;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import l1.y;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.http2.Http2;
import r3.c0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends d2.b {
    public static final AtomicInteger M = new AtomicInteger();
    public final boolean A;
    public final boolean B;
    public b C;
    public r D;
    public int E;
    public boolean F;
    public volatile boolean G;
    public boolean H;
    public g0 I;
    public boolean J;
    public long K;
    public boolean L;

    /* renamed from: k, reason: collision with root package name */
    public final int f12792k;

    /* renamed from: l, reason: collision with root package name */
    public final int f12793l;

    /* renamed from: m, reason: collision with root package name */
    public final Uri f12794m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f12795n;

    /* renamed from: o, reason: collision with root package name */
    public final int f12796o;

    /* renamed from: p, reason: collision with root package name */
    public final o1.h f12797p;

    /* renamed from: q, reason: collision with root package name */
    public final o1.l f12798q;

    /* renamed from: r, reason: collision with root package name */
    public final b f12799r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f12800s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f12801t;

    /* renamed from: u, reason: collision with root package name */
    public final y f12802u;

    /* renamed from: v, reason: collision with root package name */
    public final c f12803v;

    /* renamed from: w, reason: collision with root package name */
    public final List f12804w;

    /* renamed from: x, reason: collision with root package name */
    public final i1.l f12805x;

    /* renamed from: y, reason: collision with root package name */
    public final y2.i f12806y;

    /* renamed from: z, reason: collision with root package name */
    public final l1.t f12807z;

    public j(c cVar, o1.h hVar, o1.l lVar, i1.p pVar, boolean z10, o1.h hVar2, o1.l lVar2, boolean z11, Uri uri, List list, int i10, Object obj, long j10, long j11, long j12, int i11, boolean z12, int i12, boolean z13, boolean z14, y yVar, i1.l lVar3, b bVar, y2.i iVar, l1.t tVar, boolean z15, boolean z16, t1.u uVar) {
        super(hVar, lVar, pVar, i10, obj, j10, j11, j12);
        this.A = z10;
        this.f12796o = i11;
        this.K = z12 ? j11 - j10 : -9223372036854775807L;
        this.f12793l = i12;
        this.f12798q = lVar2;
        this.f12797p = hVar2;
        this.F = lVar2 != null;
        this.B = z11;
        this.f12794m = uri;
        this.f12800s = z14;
        this.f12802u = yVar;
        this.f12801t = z13;
        this.f12803v = cVar;
        this.f12804w = list;
        this.f12805x = lVar3;
        this.f12799r = bVar;
        this.f12806y = iVar;
        this.f12807z = tVar;
        this.L = z15;
        this.f12795n = z16;
        e0 e0Var = g0.f9617p;
        this.I = w0.f9686s;
        this.f12792k = M.getAndIncrement();
    }

    public static byte[] d(String str) {
        if (com.bumptech.glide.c.C(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length > 16 ? byteArray.length - 16 : 0;
        System.arraycopy(byteArray, length, bArr, (16 - byteArray.length) + length, byteArray.length - length);
        return bArr;
    }

    @Override // g2.k
    public final void a() {
        b bVar;
        this.D.getClass();
        if (this.C == null && (bVar = this.f12799r) != null) {
            k2.n b2 = bVar.f12755a.b();
            if ((b2 instanceof c0) || (b2 instanceof e3.j)) {
                this.C = this.f12799r;
                this.F = false;
            }
        }
        o1.l lVar = this.f12798q;
        o1.h hVar = this.f12797p;
        if (this.F) {
            hVar.getClass();
            lVar.getClass();
            c(hVar, lVar, this.B, false);
            this.E = 0;
            this.F = false;
        }
        if (this.G) {
            return;
        }
        if (!this.f12801t) {
            c(this.f4003i, this.f3997b, this.A, true);
        }
        this.H = !this.G;
    }

    @Override // g2.k
    public final void b() {
        this.G = true;
    }

    public final void c(o1.h hVar, o1.l lVar, boolean z10, boolean z11) {
        o1.l c10;
        boolean z12;
        long j10;
        if (z10) {
            z12 = this.E != 0;
            c10 = lVar;
        } else {
            long j11 = this.E;
            long j12 = lVar.g;
            c10 = lVar.c(j11, j12 != -1 ? j12 - j11 : -1L);
            z12 = false;
        }
        try {
            k2.k g = g(hVar, c10, z11);
            if (z12) {
                g.k(this.E, false);
            }
            while (!this.G && this.C.f12755a.f(g, b.f12754f) == 0) {
                try {
                    try {
                    } catch (EOFException e7) {
                        if ((this.f3999d.f5984f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                            throw e7;
                        }
                        this.C.f12755a.e(0L, 0L);
                        j10 = g.f7753r;
                    }
                } catch (Throwable th) {
                    this.E = (int) (g.f7753r - lVar.f9433f);
                    throw th;
                }
            }
            j10 = g.f7753r;
            this.E = (int) (j10 - lVar.f9433f);
        } finally {
            j1.c.f(hVar);
        }
    }

    public final int e(int i10) {
        l1.d.g(!this.L);
        if (i10 >= this.I.size()) {
            return 0;
        }
        return ((Integer) this.I.get(i10)).intValue();
    }

    public final boolean f() {
        return this.K != -9223372036854775807L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v21, types: [d9.f] */
    /* JADX WARN: Type inference failed for: r5v11, types: [d9.f] */
    public final k2.k g(o1.h hVar, o1.l lVar, boolean z10) {
        int i10;
        long j10;
        long j11;
        long j12;
        b bVar;
        y yVar;
        ArrayList arrayList;
        k2.n aVar;
        boolean z11;
        n7.i iVar;
        boolean z12;
        boolean z13;
        n7.i iVar2;
        List singletonList;
        int i11;
        k2.n dVar;
        long j13 = hVar.j(lVar);
        long j14 = this.g;
        y yVar2 = this.f12802u;
        if (z10) {
            try {
                yVar2.h(j14, this.f12800s);
            } catch (InterruptedException unused) {
                throw new InterruptedIOException();
            } catch (TimeoutException e7) {
                throw new IOException(e7);
            }
        }
        k2.k kVar = new k2.k(hVar, lVar.f9433f, j13);
        if (this.C == null) {
            l1.t tVar = this.f12807z;
            kVar.f7755t = 0;
            try {
                tVar.F(10);
                kVar.m(tVar.f8129a, 0, 10, false);
            } catch (EOFException unused2) {
                j10 = -9223372036854775807L;
            }
            if (tVar.z() != 4801587) {
                j11 = -9223372036854775807L;
                j10 = -9223372036854775807L;
            } else {
                tVar.J(3);
                int v10 = tVar.v();
                int i12 = v10 + 10;
                byte[] bArr = tVar.f8129a;
                j10 = -9223372036854775807L;
                if (i12 > bArr.length) {
                    tVar.F(i12);
                    System.arraycopy(bArr, 0, tVar.f8129a, 0, 10);
                }
                kVar.m(tVar.f8129a, 10, v10, false);
                f0 Q = this.f12806y.Q(v10, tVar.f8129a);
                if (Q != null) {
                    for (i1.e0 e0Var : Q.f5876a) {
                        if (e0Var instanceof y2.n) {
                            y2.n nVar = (y2.n) e0Var;
                            if ("com.apple.streaming.transportStreamTimestamp".equals(nVar.f13801b)) {
                                System.arraycopy(nVar.f13802c, 0, tVar.f8129a, 0, 8);
                                tVar.I(0);
                                tVar.H(8);
                                j11 = tVar.q() & 8589934591L;
                                break;
                            }
                        }
                    }
                }
                j11 = j10;
            }
            kVar.f7755t = 0;
            b bVar2 = this.f12799r;
            if (bVar2 == null) {
                Uri uri = lVar.f9428a;
                Map e8 = hVar.e();
                c cVar = this.f12803v;
                cVar.getClass();
                i1.p pVar = this.f3999d;
                int q10 = k5.a.q(pVar.f5991n);
                List list = (List) e8.get("Content-Type");
                int q11 = k5.a.q((list == null || list.isEmpty()) ? null : (String) list.get(0));
                int r2 = k5.a.r(uri);
                ArrayList arrayList2 = new ArrayList(7);
                c.a(q10, arrayList2);
                c.a(q11, arrayList2);
                c.a(r2, arrayList2);
                int i13 = 0;
                for (int i14 = 7; i13 < i14; i14 = 7) {
                    c.a(c.f12760c[i13], arrayList2);
                    i13++;
                }
                kVar.f7755t = 0;
                int i15 = 0;
                k2.n nVar2 = null;
                while (true) {
                    int size = arrayList2.size();
                    y yVar3 = this.f12802u;
                    if (i15 >= size) {
                        j12 = j14;
                        i10 = 0;
                        nVar2.getClass();
                        bVar = new b(nVar2, pVar, yVar3, cVar.f12761a, cVar.f12762b);
                        break;
                    }
                    int intValue = ((Integer) arrayList2.get(i15)).intValue();
                    int i16 = i15;
                    if (intValue == 0) {
                        yVar = yVar3;
                        j12 = j14;
                        arrayList = arrayList2;
                        aVar = new r3.a();
                    } else if (intValue == 1) {
                        yVar = yVar3;
                        j12 = j14;
                        arrayList = arrayList2;
                        aVar = new r3.c();
                    } else if (intValue == 2) {
                        yVar = yVar3;
                        j12 = j14;
                        arrayList = arrayList2;
                        aVar = new r3.d(0);
                    } else if (intValue != 7) {
                        List list2 = this.f12804w;
                        n7.i iVar3 = h3.i.f5534c;
                        if (intValue == 8) {
                            yVar = yVar3;
                            j12 = j14;
                            arrayList = arrayList2;
                            ?? r52 = cVar.f12761a;
                            boolean z14 = cVar.f12762b;
                            f0 f0Var = pVar.f5989l;
                            if (f0Var != null) {
                                iVar = r52;
                                int i17 = 0;
                                while (true) {
                                    i1.e0[] e0VarArr = f0Var.f5876a;
                                    z12 = z14;
                                    if (i17 >= e0VarArr.length) {
                                        break;
                                    }
                                    i1.e0 e0Var2 = e0VarArr[i17];
                                    if (e0Var2 instanceof t) {
                                        z13 = !((t) e0Var2).f12877c.isEmpty();
                                        break;
                                    }
                                    i17++;
                                    z14 = z12;
                                }
                            } else {
                                iVar = r52;
                                z12 = z14;
                            }
                            z13 = false;
                            int i18 = z13 ? 4 : 0;
                            if (z12) {
                                iVar2 = iVar;
                            } else {
                                i18 |= 32;
                                iVar2 = iVar3;
                            }
                            aVar = new e3.j(iVar2, i18, yVar, list2 != null ? list2 : w0.f9686s);
                        } else if (intValue == 11) {
                            j12 = j14;
                            arrayList = arrayList2;
                            ?? r42 = cVar.f12761a;
                            boolean z15 = cVar.f12762b;
                            if (list2 != null) {
                                i11 = 48;
                                singletonList = list2;
                            } else {
                                i1.o oVar = new i1.o();
                                oVar.f5940m = i1.g0.m("application/cea-608");
                                singletonList = Collections.singletonList(new i1.p(oVar));
                                i11 = 16;
                            }
                            String str = pVar.f5988k;
                            if (!TextUtils.isEmpty(str)) {
                                if (i1.g0.b(str, "audio/mp4a-latm") == null) {
                                    i11 |= 2;
                                }
                                if (i1.g0.b(str, "video/avc") == null) {
                                    i11 |= 4;
                                }
                            }
                            yVar = yVar3;
                            aVar = new c0(2, !z15 ? 1 : 0, !z15 ? iVar3 : r42, yVar3, new j0.i(i11, singletonList));
                        } else if (intValue != 13) {
                            yVar = yVar3;
                            j12 = j14;
                            arrayList = arrayList2;
                            aVar = null;
                        } else {
                            j12 = j14;
                            arrayList = arrayList2;
                            aVar = new u(pVar.f5982d, yVar3, cVar.f12761a, cVar.f12762b);
                            yVar = yVar3;
                        }
                    } else {
                        yVar = yVar3;
                        j12 = j14;
                        arrayList = arrayList2;
                        aVar = new d3.d(0L);
                    }
                    aVar.getClass();
                    try {
                        z11 = aVar.m(kVar);
                        i10 = 0;
                        kVar.f7755t = 0;
                    } catch (EOFException unused3) {
                        i10 = 0;
                        kVar.f7755t = 0;
                        z11 = false;
                    } catch (Throwable th) {
                        kVar.f7755t = 0;
                        throw th;
                    }
                    if (z11) {
                        bVar = new b(aVar, pVar, yVar, cVar.f12761a, cVar.f12762b);
                        break;
                    }
                    i1.p pVar2 = pVar;
                    if (nVar2 == null && (intValue == q10 || intValue == q11 || intValue == r2 || intValue == 11)) {
                        nVar2 = aVar;
                    }
                    i15 = i16 + 1;
                    pVar = pVar2;
                    arrayList2 = arrayList;
                    j14 = j12;
                }
            } else {
                k2.n nVar3 = bVar2.f12755a;
                k2.n b2 = nVar3.b();
                l1.d.g(!((b2 instanceof c0) || (b2 instanceof e3.j)));
                l1.d.f("Can't recreate wrapped extractors. Outer type: " + nVar3.getClass(), nVar3.b() == nVar3);
                if (nVar3 instanceof u) {
                    dVar = new u(bVar2.f12756b.f5982d, bVar2.f12757c, bVar2.f12758d, bVar2.f12759e);
                } else if (nVar3 instanceof r3.d) {
                    dVar = new r3.d(0);
                } else if (nVar3 instanceof r3.a) {
                    dVar = new r3.a();
                } else if (nVar3 instanceof r3.c) {
                    dVar = new r3.c();
                } else {
                    if (!(nVar3 instanceof d3.d)) {
                        throw new IllegalStateException("Unexpected extractor type for recreation: ".concat(nVar3.getClass().getSimpleName()));
                    }
                    dVar = new d3.d(0);
                }
                bVar = new b(dVar, bVar2.f12756b, bVar2.f12757c, bVar2.f12758d, bVar2.f12759e);
                j12 = j14;
                i10 = 0;
            }
            b bVar3 = bVar;
            this.C = bVar3;
            k2.n b10 = bVar3.f12755a.b();
            if ((((b10 instanceof r3.d) || (b10 instanceof r3.a) || (b10 instanceof r3.c) || (b10 instanceof d3.d)) ? 1 : i10) != 0) {
                r rVar = this.D;
                long b11 = j11 != j10 ? yVar2.b(j11) : j12;
                if (rVar.f12854j0 != b11) {
                    rVar.f12854j0 = b11;
                    q[] qVarArr = rVar.J;
                    int length = qVarArr.length;
                    for (int i19 = i10; i19 < length; i19++) {
                        q qVar = qVarArr[i19];
                        if (qVar.F != b11) {
                            qVar.F = b11;
                            qVar.f2568z = true;
                        }
                    }
                }
            } else {
                r rVar2 = this.D;
                if (rVar2.f12854j0 != 0) {
                    rVar2.f12854j0 = 0L;
                    q[] qVarArr2 = rVar2.J;
                    int length2 = qVarArr2.length;
                    for (int i20 = i10; i20 < length2; i20++) {
                        q qVar2 = qVarArr2[i20];
                        if (qVar2.F != 0) {
                            qVar2.F = 0L;
                            qVar2.f2568z = true;
                        }
                    }
                }
            }
            this.D.L.clear();
            this.C.f12755a.c(this.D);
        } else {
            i10 = 0;
        }
        r rVar3 = this.D;
        i1.l lVar2 = rVar3.f12855k0;
        i1.l lVar3 = this.f12805x;
        if (!Objects.equals(lVar2, lVar3)) {
            rVar3.f12855k0 = lVar3;
            int i21 = i10;
            while (true) {
                q[] qVarArr3 = rVar3.J;
                if (i21 >= qVarArr3.length) {
                    break;
                }
                if (rVar3.f12848c0[i21]) {
                    q qVar3 = qVarArr3[i21];
                    qVar3.I = lVar3;
                    qVar3.f2568z = true;
                }
                i21++;
            }
        }
        return kVar;
    }
}
