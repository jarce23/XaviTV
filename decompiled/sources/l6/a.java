package l6;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import m6.n;
import r5.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e {

    /* renamed from: b, reason: collision with root package name */
    public final int f8264b;

    /* renamed from: c, reason: collision with root package name */
    public final e f8265c;

    public a(int i10, e eVar) {
        this.f8264b = i10;
        this.f8265c = eVar;
    }

    @Override // r5.e
    public final void b(MessageDigest messageDigest) {
        this.f8265c.b(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f8264b).array());
    }

    @Override // r5.e
    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.f8264b == aVar.f8264b && this.f8265c.equals(aVar.f8265c)) {
                return true;
            }
        }
        return false;
    }

    @Override // r5.e
    public final int hashCode() {
        return n.h(this.f8264b, this.f8265c);
    }
}
