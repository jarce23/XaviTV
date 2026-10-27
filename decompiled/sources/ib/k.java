package ib;

import java.util.concurrent.CancellationException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6568a;

    /* renamed from: b, reason: collision with root package name */
    public final d f6569b;

    /* renamed from: c, reason: collision with root package name */
    public final ya.l f6570c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f6571d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f6572e;

    public k(Object obj, d dVar, ya.l lVar, Object obj2, Throwable th) {
        this.f6568a = obj;
        this.f6569b = dVar;
        this.f6570c = lVar;
        this.f6571d = obj2;
        this.f6572e = th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Throwable] */
    public static k a(k kVar, d dVar, CancellationException cancellationException, int i10) {
        Object obj = kVar.f6568a;
        if ((i10 & 2) != 0) {
            dVar = kVar.f6569b;
        }
        d dVar2 = dVar;
        ya.l lVar = kVar.f6570c;
        Object obj2 = kVar.f6571d;
        CancellationException cancellationException2 = cancellationException;
        if ((i10 & 16) != 0) {
            cancellationException2 = kVar.f6572e;
        }
        return new k(obj, dVar2, lVar, obj2, cancellationException2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return za.h.a(this.f6568a, kVar.f6568a) && za.h.a(this.f6569b, kVar.f6569b) && za.h.a(this.f6570c, kVar.f6570c) && za.h.a(this.f6571d, kVar.f6571d) && za.h.a(this.f6572e, kVar.f6572e);
    }

    public final int hashCode() {
        Object obj = this.f6568a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        d dVar = this.f6569b;
        int hashCode2 = (hashCode + (dVar == null ? 0 : dVar.hashCode())) * 31;
        ya.l lVar = this.f6570c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f6571d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f6572e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public final String toString() {
        return "CompletedContinuation(result=" + this.f6568a + ", cancelHandler=" + this.f6569b + ", onCancellation=" + this.f6570c + ", idempotentResume=" + this.f6571d + ", cancelCause=" + this.f6572e + ')';
    }

    public /* synthetic */ k(Object obj, d dVar, ya.l lVar, CancellationException cancellationException, int i10) {
        this(obj, (i10 & 2) != 0 ? null : dVar, (i10 & 4) != 0 ? null : lVar, (Object) null, (i10 & 16) != 0 ? null : cancellationException);
    }
}
