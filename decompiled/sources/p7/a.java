package p7;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f10029a;

    /* renamed from: b, reason: collision with root package name */
    public final x4.l f10030b;

    /* renamed from: c, reason: collision with root package name */
    public final o7.b f10031c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10032d;

    public a(x4.l lVar, o7.b bVar, String str) {
        this.f10030b = lVar;
        this.f10031c = bVar;
        this.f10032d = str;
        this.f10029a = Arrays.hashCode(new Object[]{lVar, bVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return r7.r.h(this.f10030b, aVar.f10030b) && r7.r.h(this.f10031c, aVar.f10031c) && r7.r.h(this.f10032d, aVar.f10032d);
    }

    public final int hashCode() {
        return this.f10029a;
    }
}
