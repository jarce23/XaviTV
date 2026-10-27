package n2;

import i1.s;
import java.util.List;
import k2.c0;
import k2.k;
import k2.n;
import k2.o;
import k2.p;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9115a;

    /* renamed from: b, reason: collision with root package name */
    public final t f9116b;

    /* renamed from: c, reason: collision with root package name */
    public final c0 f9117c;

    public a(int i10) {
        this.f9115a = i10;
        switch (i10) {
            case 1:
                this.f9116b = new t(4);
                this.f9117c = new c0("image/heif", -1, -1);
                break;
            case 2:
                this.f9116b = new t(4);
                this.f9117c = new c0("image/webp", -1, -1);
                break;
            default:
                this.f9116b = new t(4);
                this.f9117c = new c0("image/avif", -1, -1);
                break;
        }
    }

    @Override // k2.n
    public final void a() {
        int i10 = this.f9115a;
    }

    @Override // k2.n
    public final n b() {
        int i10 = this.f9115a;
        return this;
    }

    @Override // k2.n
    public final void c(p pVar) {
        switch (this.f9115a) {
            case 0:
                this.f9117c.c(pVar);
                break;
            case 1:
                this.f9117c.c(pVar);
                break;
            default:
                this.f9117c.c(pVar);
                break;
        }
    }

    @Override // k2.n
    public final void e(long j10, long j11) {
        switch (this.f9115a) {
            case 0:
                this.f9117c.e(j10, j11);
                break;
            case 1:
                this.f9117c.e(j10, j11);
                break;
            default:
                this.f9117c.e(j10, j11);
                break;
        }
    }

    @Override // k2.n
    public final int f(o oVar, s sVar) {
        switch (this.f9115a) {
        }
        return this.f9117c.f(oVar, sVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0002. Please report as an issue. */
    @Override // k2.n
    public final List g() {
        switch (this.f9115a) {
        }
        e0 e0Var = g0.f9617p;
        return w0.f9686s;
    }

    @Override // k2.n
    public final boolean m(o oVar) {
        switch (this.f9115a) {
            case 0:
                k kVar = (k) oVar;
                kVar.f(4, false);
                t tVar = this.f9116b;
                tVar.F(4);
                kVar.m(tVar.f8129a, 0, 4, false);
                if (tVar.y() == 1718909296) {
                    tVar.F(4);
                    kVar.m(tVar.f8129a, 0, 4, false);
                    if (tVar.y() == 1635150182) {
                    }
                }
                break;
            case 1:
                k kVar2 = (k) oVar;
                kVar2.f(4, false);
                t tVar2 = this.f9116b;
                tVar2.F(4);
                kVar2.m(tVar2.f8129a, 0, 4, false);
                if (tVar2.y() == 1718909296) {
                    tVar2.F(4);
                    kVar2.m(tVar2.f8129a, 0, 4, false);
                    if (tVar2.y() == 1751476579) {
                    }
                }
                break;
            default:
                t tVar3 = this.f9116b;
                tVar3.F(4);
                k kVar3 = (k) oVar;
                kVar3.m(tVar3.f8129a, 0, 4, false);
                if (tVar3.y() == 1380533830) {
                    kVar3.f(4, false);
                    tVar3.F(4);
                    kVar3.m(tVar3.f8129a, 0, 4, false);
                    if (tVar3.y() == 1464156752) {
                    }
                }
                break;
        }
        return false;
    }

    private final void d() {
    }

    private final void h() {
    }

    private final void i() {
    }
}
