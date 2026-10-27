package r3;

import java.util.Collections;
import java.util.List;
import k2.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10529a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10530b;

    /* renamed from: c, reason: collision with root package name */
    public long f10531c;

    /* renamed from: d, reason: collision with root package name */
    public int f10532d;

    /* renamed from: e, reason: collision with root package name */
    public int f10533e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f10534f;
    public Object g;

    public g(List list) {
        this.f10529a = 0;
        this.f10534f = list;
        this.g = new g0[list.size()];
        this.f10531c = -9223372036854775807L;
    }

    @Override // r3.h
    public final void a() {
        switch (this.f10529a) {
            case 0:
                this.f10530b = false;
                this.f10531c = -9223372036854775807L;
                break;
            default:
                this.f10530b = false;
                this.f10531c = -9223372036854775807L;
                break;
        }
    }

    @Override // r3.h
    public final void b(l1.t tVar) {
        boolean z10;
        boolean z11;
        switch (this.f10529a) {
            case 0:
                if (this.f10530b) {
                    if (this.f10532d == 2) {
                        if (tVar.a() == 0) {
                            z11 = false;
                        } else {
                            if (tVar.w() != 32) {
                                this.f10530b = false;
                            }
                            this.f10532d--;
                            z11 = this.f10530b;
                        }
                        if (!z11) {
                        }
                    }
                    if (this.f10532d == 1) {
                        if (tVar.a() == 0) {
                            z10 = false;
                        } else {
                            if (tVar.w() != 0) {
                                this.f10530b = false;
                            }
                            this.f10532d--;
                            z10 = this.f10530b;
                        }
                        if (!z10) {
                        }
                    }
                    int i10 = tVar.f8130b;
                    int a10 = tVar.a();
                    for (g0 g0Var : (g0[]) this.g) {
                        tVar.I(i10);
                        g0Var.c(a10, tVar);
                    }
                    this.f10533e += a10;
                    break;
                }
                break;
            default:
                l1.t tVar2 = (l1.t) this.f10534f;
                l1.d.h((g0) this.g);
                if (this.f10530b) {
                    int a11 = tVar.a();
                    int i11 = this.f10533e;
                    if (i11 < 10) {
                        int min = Math.min(a11, 10 - i11);
                        System.arraycopy(tVar.f8129a, tVar.f8130b, tVar2.f8129a, this.f10533e, min);
                        if (this.f10533e + min == 10) {
                            tVar2.I(0);
                            if (73 != tVar2.w() || 68 != tVar2.w() || 51 != tVar2.w()) {
                                l1.b.q("Id3Reader", "Discarding invalid ID3 tag");
                                this.f10530b = false;
                                break;
                            } else {
                                tVar2.J(3);
                                this.f10532d = tVar2.v() + 10;
                            }
                        }
                    }
                    int min2 = Math.min(a11, this.f10532d - this.f10533e);
                    ((g0) this.g).c(min2, tVar);
                    this.f10533e += min2;
                    break;
                }
                break;
        }
    }

    @Override // r3.h
    public final void c(boolean z10) {
        int i10;
        switch (this.f10529a) {
            case 0:
                if (this.f10530b) {
                    l1.d.g(this.f10531c != -9223372036854775807L);
                    for (g0 g0Var : (g0[]) this.g) {
                        g0Var.e(this.f10531c, 1, this.f10533e, 0, null);
                    }
                    this.f10530b = false;
                    break;
                }
                break;
            default:
                l1.d.h((g0) this.g);
                if (this.f10530b && (i10 = this.f10532d) != 0 && this.f10533e == i10) {
                    l1.d.g(this.f10531c != -9223372036854775807L);
                    ((g0) this.g).e(this.f10531c, 1, this.f10532d, 0, null);
                    this.f10530b = false;
                    break;
                }
                break;
        }
    }

    @Override // r3.h
    public final void d(int i10, long j10) {
        switch (this.f10529a) {
            case 0:
                if ((i10 & 4) != 0) {
                    this.f10530b = true;
                    this.f10531c = j10;
                    this.f10533e = 0;
                    this.f10532d = 2;
                    break;
                }
                break;
            default:
                if ((i10 & 4) != 0) {
                    this.f10530b = true;
                    this.f10531c = j10;
                    this.f10532d = 0;
                    this.f10533e = 0;
                    break;
                }
                break;
        }
    }

    @Override // r3.h
    public final void e(k2.p pVar, e0 e0Var) {
        switch (this.f10529a) {
            case 0:
                g0[] g0VarArr = (g0[]) this.g;
                for (int i10 = 0; i10 < g0VarArr.length; i10++) {
                    d0 d0Var = (d0) ((List) this.f10534f).get(i10);
                    e0Var.a();
                    e0Var.b();
                    g0 q10 = pVar.q(e0Var.f10511d, 3);
                    i1.o oVar = new i1.o();
                    e0Var.b();
                    oVar.f5929a = e0Var.f10512e;
                    oVar.f5939l = i1.g0.m("video/mp2t");
                    oVar.f5940m = i1.g0.m("application/dvbsubs");
                    oVar.f5943p = Collections.singletonList(d0Var.f10484b);
                    oVar.f5932d = d0Var.f10483a;
                    r.a.i(oVar, q10);
                    g0VarArr[i10] = q10;
                }
                break;
            default:
                e0Var.a();
                e0Var.b();
                g0 q11 = pVar.q(e0Var.f10511d, 5);
                this.g = q11;
                i1.o oVar2 = new i1.o();
                e0Var.b();
                oVar2.f5929a = e0Var.f10512e;
                oVar2.f5939l = i1.g0.m("video/mp2t");
                oVar2.f5940m = i1.g0.m("application/id3");
                r.a.i(oVar2, q11);
                break;
        }
    }

    public g() {
        this.f10529a = 1;
        this.f10534f = new l1.t(10);
        this.f10531c = -9223372036854775807L;
    }
}
