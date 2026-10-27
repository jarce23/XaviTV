package za;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b implements eb.a, Serializable {

    /* renamed from: o, reason: collision with root package name */
    public transient eb.a f14163o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f14164p;

    /* renamed from: q, reason: collision with root package name */
    public final Class f14165q;

    /* renamed from: r, reason: collision with root package name */
    public final String f14166r;

    /* renamed from: s, reason: collision with root package name */
    public final String f14167s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f14168t;

    public b(Object obj, Class cls, String str, String str2, boolean z10) {
        this.f14164p = obj;
        this.f14165q = cls;
        this.f14166r = str;
        this.f14167s = str2;
        this.f14168t = z10;
    }

    public final c e() {
        boolean z10 = this.f14168t;
        Class cls = this.f14165q;
        if (!z10) {
            return n.a(cls);
        }
        n.f14178a.getClass();
        return new j(cls);
    }
}
