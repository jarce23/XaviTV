package p7;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import g7.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends s {

    /* renamed from: b, reason: collision with root package name */
    public final i8.d f10100b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10101c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10102d;

    public w(int i10, i8.d dVar) {
        super(i10);
        this.f10100b = dVar;
    }

    @Override // p7.s
    public final n7.c[] a(k kVar) {
        switch (this.f10101c) {
            case 0:
                return (n7.c[]) ((u) this.f10102d).f10091a.f8124r;
            default:
                u uVar = (u) kVar.g.get((f) this.f10102d);
                if (uVar == null) {
                    return null;
                }
                return (n7.c[]) uVar.f10091a.f8124r;
        }
    }

    @Override // p7.s
    public final boolean b(k kVar) {
        switch (this.f10101c) {
            case 0:
                return ((u) this.f10102d).f10091a.f8121o;
            default:
                u uVar = (u) kVar.g.get((f) this.f10102d);
                return uVar != null && uVar.f10091a.f8121o;
        }
    }

    @Override // p7.s
    public final int c(k kVar) {
        switch (this.f10101c) {
            case 0:
                return ((u) this.f10102d).f10091a.f8122p;
            default:
                u uVar = (u) kVar.g.get((f) this.f10102d);
                if (uVar != null) {
                    return uVar.f10091a.f8122p;
                }
                return -1;
        }
    }

    @Override // p7.s
    public final void d(Status status) {
        this.f10100b.c(new o7.d(status));
    }

    @Override // p7.s
    public final void e(Exception exc) {
        this.f10100b.c(exc);
    }

    @Override // p7.s
    public final /* bridge */ /* synthetic */ void f(x4.e eVar, boolean z10) {
        int i10 = this.f10101c;
    }

    @Override // p7.s
    public final void g(k kVar) {
        try {
            k(kVar);
        } catch (DeadObjectException e7) {
            d(s.h(e7));
            throw e7;
        } catch (RemoteException e8) {
            d(s.h(e8));
        } catch (RuntimeException e10) {
            this.f10100b.c(e10);
        }
    }

    public final void k(k kVar) {
        switch (this.f10101c) {
            case 0:
                u uVar = (u) this.f10102d;
                l1.s sVar = uVar.f10091a;
                ((a6.n) ((f3.j) sVar.f8125s).f5007p).accept(kVar.f10054c, this.f10100b);
                f fVar = ((g) sVar.f8123q).f10051a;
                if (fVar != null) {
                    kVar.g.put(fVar, uVar);
                    break;
                }
                break;
            default:
                u uVar2 = (u) kVar.g.remove((f) this.f10102d);
                if (uVar2 == null) {
                    this.f10100b.d(Boolean.FALSE);
                    break;
                } else {
                    ((z) ((f3.j) uVar2.f10092b.f9953p).f5008q).accept(kVar.f10054c, this.f10100b);
                    ((g) uVar2.f10091a.f8123q).f10051a = null;
                    break;
                }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(f fVar, i8.d dVar) {
        this(4, dVar);
        this.f10101c = 1;
        this.f10102d = fVar;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(u uVar, i8.d dVar) {
        this(3, dVar);
        this.f10101c = 0;
        this.f10102d = uVar;
    }

    private final /* bridge */ /* synthetic */ void i(x4.e eVar, boolean z10) {
    }

    private final /* bridge */ /* synthetic */ void j(x4.e eVar, boolean z10) {
    }
}
