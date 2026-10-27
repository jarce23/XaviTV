package t6;

import android.content.Context;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12020a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.a f12021b;

    /* renamed from: c, reason: collision with root package name */
    public final c7.a f12022c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12023d;

    public b(Context context, c7.a aVar, c7.a aVar2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f12020a = context;
        if (aVar == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f12021b = aVar;
        if (aVar2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f12022c = aVar2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f12023d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            b bVar = (b) ((c) obj);
            if (this.f12020a.equals(bVar.f12020a) && this.f12021b.equals(bVar.f12021b) && this.f12022c.equals(bVar.f12022c) && this.f12023d.equals(bVar.f12023d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f12020a.hashCode() ^ 1000003) * 1000003) ^ this.f12021b.hashCode()) * 1000003) ^ this.f12022c.hashCode()) * 1000003) ^ this.f12023d.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("CreationContext{applicationContext=");
        sb2.append(this.f12020a);
        sb2.append(", wallClock=");
        sb2.append(this.f12021b);
        sb2.append(", monotonicClock=");
        sb2.append(this.f12022c);
        sb2.append(", backendName=");
        return android.support.v4.media.d.r(sb2, this.f12023d, "}");
    }
}
