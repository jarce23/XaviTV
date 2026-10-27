package l6;

import java.security.MessageDigest;
import m6.f;
import r5.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements e {

    /* renamed from: b, reason: collision with root package name */
    public final Object f8268b;

    public d(Object obj) {
        f.c("Argument must not be null", obj);
        this.f8268b = obj;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(this.f8268b.toString().getBytes(e.f10789a));
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f8268b.equals(((d) obj).f8268b);
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return this.f8268b.hashCode();
    }

    public final String toString() {
        return "ObjectKey{object=" + this.f8268b + '}';
    }
}
