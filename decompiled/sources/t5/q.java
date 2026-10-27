package t5;

import java.security.MessageDigest;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q implements r5.e {

    /* renamed from: b, reason: collision with root package name */
    public final Object f11977b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11978c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11979d;

    /* renamed from: e, reason: collision with root package name */
    public final Class f11980e;

    /* renamed from: f, reason: collision with root package name */
    public final Class f11981f;
    public final r5.e g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f11982h;

    /* renamed from: i, reason: collision with root package name */
    public final r5.h f11983i;

    /* renamed from: j, reason: collision with root package name */
    public int f11984j;

    public q(Object obj, r5.e eVar, int i10, int i11, Map map, Class cls, Class cls2, r5.h hVar) {
        m6.f.c("Argument must not be null", obj);
        this.f11977b = obj;
        this.g = eVar;
        this.f11978c = i10;
        this.f11979d = i11;
        m6.f.c("Argument must not be null", map);
        this.f11982h = map;
        m6.f.c("Resource class must not be null", cls);
        this.f11980e = cls;
        m6.f.c("Transcode class must not be null", cls2);
        this.f11981f = cls2;
        m6.f.c("Argument must not be null", hVar);
        this.f11983i = hVar;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f11977b.equals(qVar.f11977b) && this.g.equals(qVar.g) && this.f11979d == qVar.f11979d && this.f11978c == qVar.f11978c && this.f11982h.equals(qVar.f11982h) && this.f11980e.equals(qVar.f11980e) && this.f11981f.equals(qVar.f11981f) && this.f11983i.equals(qVar.f11983i)) {
                return true;
            }
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        if (this.f11984j == 0) {
            int hashCode = this.f11977b.hashCode();
            this.f11984j = hashCode;
            int hashCode2 = ((((this.g.hashCode() + (hashCode * 31)) * 31) + this.f11978c) * 31) + this.f11979d;
            this.f11984j = hashCode2;
            int hashCode3 = this.f11982h.hashCode() + (hashCode2 * 31);
            this.f11984j = hashCode3;
            int hashCode4 = this.f11980e.hashCode() + (hashCode3 * 31);
            this.f11984j = hashCode4;
            int hashCode5 = this.f11981f.hashCode() + (hashCode4 * 31);
            this.f11984j = hashCode5;
            this.f11984j = this.f11983i.f10795b.hashCode() + (hashCode5 * 31);
        }
        return this.f11984j;
    }

    public final String toString() {
        return "EngineKey{model=" + this.f11977b + ", width=" + this.f11978c + ", height=" + this.f11979d + ", resourceClass=" + this.f11980e + ", transcodeClass=" + this.f11981f + ", signature=" + this.g + ", hashCode=" + this.f11984j + ", transformations=" + this.f11982h + ", options=" + this.f11983i + '}';
    }
}
