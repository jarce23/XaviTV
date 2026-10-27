package jb;

import android.os.Handler;
import android.os.Looper;
import ib.a0;
import ib.p0;
import ib.q;
import ib.r;
import ib.y;
import java.util.concurrent.CancellationException;
import nb.o;
import pa.i;
import pb.e;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends q implements y {

    /* renamed from: q, reason: collision with root package name */
    public final Handler f7516q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f7517r;

    /* renamed from: s, reason: collision with root package name */
    public final c f7518s;

    public c(Handler handler, boolean z10) {
        this.f7516q = handler;
        this.f7517r = z10;
        this.f7518s = z10 ? this : new c(handler, true);
    }

    @Override // ib.q
    public final void M(i iVar, Runnable runnable) {
        if (this.f7516q.post(runnable)) {
            return;
        }
        CancellationException cancellationException = new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed");
        p0 p0Var = (p0) iVar.s(r.f6589p);
        if (p0Var != null) {
            p0Var.c(cancellationException);
        }
        a0.f6542b.M(iVar, runnable);
    }

    @Override // ib.q
    public final boolean O() {
        return (this.f7517r && h.a(Looper.myLooper(), this.f7516q.getLooper())) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return cVar.f7516q == this.f7516q && cVar.f7517r == this.f7517r;
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7516q) ^ (this.f7517r ? 1231 : 1237);
    }

    @Override // ib.q
    public final String toString() {
        c cVar;
        String str;
        e eVar = a0.f6541a;
        c cVar2 = o.f9340a;
        if (this == cVar2) {
            str = "Dispatchers.Main";
        } else {
            try {
                cVar = cVar2.f7518s;
            } catch (UnsupportedOperationException unused) {
                cVar = null;
            }
            str = this == cVar ? "Dispatchers.Main.immediate" : null;
        }
        if (str != null) {
            return str;
        }
        String handler = this.f7516q.toString();
        return this.f7517r ? r.a.c(handler, ".immediate") : handler;
    }
}
