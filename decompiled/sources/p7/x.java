package p7;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import j9.v1;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends s {

    /* renamed from: b, reason: collision with root package name */
    public final e9.d f10103b;

    /* renamed from: c, reason: collision with root package name */
    public final i8.d f10104c;

    /* renamed from: d, reason: collision with root package name */
    public final v1 f10105d;

    public x(int i10, e9.d dVar, i8.d dVar2, v1 v1Var) {
        super(i10);
        this.f10104c = dVar2;
        this.f10103b = dVar;
        this.f10105d = v1Var;
        if (i10 == 2 && dVar.f4676c) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // p7.s
    public final n7.c[] a(k kVar) {
        return (n7.c[]) this.f10103b.f4677d;
    }

    @Override // p7.s
    public final boolean b(k kVar) {
        return this.f10103b.f4676c;
    }

    @Override // p7.s
    public final int c(k kVar) {
        return this.f10103b.f4675b;
    }

    @Override // p7.s
    public final void d(Status status) {
        this.f10105d.getClass();
        this.f10104c.c(status.f3195q != null ? new j9.a(status) : new o7.d(status));
    }

    @Override // p7.s
    public final void e(Exception exc) {
        this.f10104c.c(exc);
    }

    @Override // p7.s
    public final void f(x4.e eVar, boolean z10) {
        Boolean valueOf = Boolean.valueOf(z10);
        Map map = (Map) eVar.f13543q;
        i8.d dVar = this.f10104c;
        map.put(dVar, valueOf);
        dVar.f6520a.i(new x4.r(eVar, dVar));
    }

    @Override // p7.s
    public final void g(k kVar) {
        i8.d dVar = this.f10104c;
        try {
            e9.d dVar2 = this.f10103b;
            ((h) ((e9.d) dVar2.f4678e).f4677d).accept(kVar.f10054c, dVar);
        } catch (DeadObjectException e7) {
            throw e7;
        } catch (RemoteException e8) {
            d(s.h(e8));
        } catch (RuntimeException e10) {
            dVar.c(e10);
        }
    }
}
