package o4;

import android.net.Uri;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f9484a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9485b;

    public c(Uri uri, boolean z10) {
        this.f9484a = uri;
        this.f9485b = z10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        za.h.c("null cannot be cast to non-null type androidx.work.Constraints.ContentUriTrigger", obj);
        c cVar = (c) obj;
        return za.h.a(this.f9484a, cVar.f9484a) && this.f9485b == cVar.f9485b;
    }

    public final int hashCode() {
        return (this.f9484a.hashCode() * 31) + (this.f9485b ? 1231 : 1237);
    }
}
