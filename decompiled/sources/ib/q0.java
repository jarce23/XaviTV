package ib;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q0 extends CancellationException {

    /* renamed from: o, reason: collision with root package name */
    public final transient y0 f6587o;

    public q0(String str, Throwable th, y0 y0Var) {
        super(str);
        this.f6587o = y0Var;
        if (th != null) {
            initCause(th);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return za.h.a(q0Var.getMessage(), getMessage()) && za.h.a(q0Var.f6587o, this.f6587o) && za.h.a(q0Var.getCause(), getCause());
    }

    @Override // java.lang.Throwable
    public final Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public final int hashCode() {
        String message = getMessage();
        za.h.b(message);
        int hashCode = (this.f6587o.hashCode() + (message.hashCode() * 31)) * 31;
        Throwable cause = getCause();
        return hashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return super.toString() + "; job=" + this.f6587o;
    }
}
