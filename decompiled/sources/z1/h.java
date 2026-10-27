package z1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends r1.e {

    /* renamed from: x, reason: collision with root package name */
    public long f13990x;

    /* renamed from: y, reason: collision with root package name */
    public int f13991y;

    /* renamed from: z, reason: collision with root package name */
    public int f13992z;

    @Override // r1.e
    public final void j() {
        super.j();
        this.f13991y = 0;
    }

    public final boolean o(r1.e eVar) {
        ByteBuffer byteBuffer;
        l1.d.b(!eVar.d(1073741824));
        l1.d.b(!eVar.d(268435456));
        l1.d.b(!eVar.d(4));
        if (p()) {
            if (this.f13991y >= this.f13992z) {
                return false;
            }
            ByteBuffer byteBuffer2 = eVar.f10410s;
            if (byteBuffer2 != null && (byteBuffer = this.f10410s) != null) {
                if (byteBuffer2.remaining() + byteBuffer.position() > 3072000) {
                    return false;
                }
            }
        }
        int i10 = this.f13991y;
        this.f13991y = i10 + 1;
        if (i10 == 0) {
            this.f10412u = eVar.f10412u;
            if (eVar.d(1)) {
                this.f8759p = 1;
            }
        }
        ByteBuffer byteBuffer3 = eVar.f10410s;
        if (byteBuffer3 != null) {
            m(byteBuffer3.remaining());
            this.f10410s.put(byteBuffer3);
        }
        this.f13990x = eVar.f10412u;
        return true;
    }

    public final boolean p() {
        return this.f13991y > 0;
    }
}
