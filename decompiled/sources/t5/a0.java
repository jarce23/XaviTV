package t5;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayDeque;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 implements r5.e {

    /* renamed from: j, reason: collision with root package name */
    public static final m6.j f11888j = new m6.j(50);

    /* renamed from: b, reason: collision with root package name */
    public final u5.f f11889b;

    /* renamed from: c, reason: collision with root package name */
    public final r5.e f11890c;

    /* renamed from: d, reason: collision with root package name */
    public final r5.e f11891d;

    /* renamed from: e, reason: collision with root package name */
    public final int f11892e;

    /* renamed from: f, reason: collision with root package name */
    public final int f11893f;
    public final Class g;

    /* renamed from: h, reason: collision with root package name */
    public final r5.h f11894h;

    /* renamed from: i, reason: collision with root package name */
    public final r5.l f11895i;

    public a0(u5.f fVar, r5.e eVar, r5.e eVar2, int i10, int i11, r5.l lVar, Class cls, r5.h hVar) {
        this.f11889b = fVar;
        this.f11890c = eVar;
        this.f11891d = eVar2;
        this.f11892e = i10;
        this.f11893f = i11;
        this.f11895i = lVar;
        this.g = cls;
        this.f11894h = hVar;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        Object f10;
        u5.f fVar = this.f11889b;
        synchronized (fVar) {
            u5.e eVar = fVar.f12534b;
            u5.h hVar = (u5.h) ((ArrayDeque) eVar.f2162a).poll();
            if (hVar == null) {
                hVar = eVar.q();
            }
            u5.d dVar = (u5.d) hVar;
            dVar.f12530b = 8;
            dVar.f12531c = byte[].class;
            f10 = fVar.f(dVar, byte[].class);
        }
        byte[] bArr = (byte[]) f10;
        ByteBuffer.wrap(bArr).putInt(this.f11892e).putInt(this.f11893f).array();
        this.f11891d.b(messageDigest);
        this.f11890c.b(messageDigest);
        messageDigest.update(bArr);
        r5.l lVar = this.f11895i;
        if (lVar != null) {
            lVar.b(messageDigest);
        }
        this.f11894h.b(messageDigest);
        m6.j jVar = f11888j;
        Class cls = this.g;
        byte[] bArr2 = (byte[]) jVar.a(cls);
        if (bArr2 == null) {
            bArr2 = cls.getName().getBytes(r5.e.f10789a);
            jVar.d(cls, bArr2);
        }
        messageDigest.update(bArr2);
        this.f11889b.h(bArr);
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof a0) {
            a0 a0Var = (a0) obj;
            if (this.f11893f == a0Var.f11893f && this.f11892e == a0Var.f11892e && m6.n.b(this.f11895i, a0Var.f11895i) && this.g.equals(a0Var.g) && this.f11890c.equals(a0Var.f11890c) && this.f11891d.equals(a0Var.f11891d) && this.f11894h.equals(a0Var.f11894h)) {
                return true;
            }
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        int hashCode = ((((this.f11891d.hashCode() + (this.f11890c.hashCode() * 31)) * 31) + this.f11892e) * 31) + this.f11893f;
        r5.l lVar = this.f11895i;
        if (lVar != null) {
            hashCode = (hashCode * 31) + lVar.hashCode();
        }
        return this.f11894h.f10795b.hashCode() + ((this.g.hashCode() + (hashCode * 31)) * 31);
    }

    public final String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f11890c + ", signature=" + this.f11891d + ", width=" + this.f11892e + ", height=" + this.f11893f + ", decodedResourceClass=" + this.g + ", transformation='" + this.f11895i + "', options=" + this.f11894h + '}';
    }
}
