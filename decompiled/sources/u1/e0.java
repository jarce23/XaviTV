package u1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends j1.h {

    /* renamed from: i, reason: collision with root package name */
    public static final int f12198i = Float.floatToIntBits(Float.NaN);

    public static void l(int i10, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i10 * 4.656612875245797E-10d));
        if (floatToIntBits == f12198i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // j1.g
    public final void f(ByteBuffer byteBuffer) {
        ByteBuffer k10;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        int i11 = this.f6956b.f6953c;
        if (i11 == 21) {
            k10 = k((i10 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), k10);
                position += 3;
            }
        } else if (i11 == 22) {
            k10 = k(i10);
            while (position < limit) {
                l((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), k10);
                position += 4;
            }
        } else if (i11 == 1342177280) {
            k10 = k((i10 / 3) * 4);
            while (position < limit) {
                l(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), k10);
                position += 3;
            }
        } else {
            if (i11 != 1610612736) {
                throw new IllegalStateException();
            }
            k10 = k(i10);
            while (position < limit) {
                l((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << 24), k10);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        k10.flip();
    }

    @Override // j1.h
    public final j1.e g(j1.e eVar) {
        int i10 = eVar.f6953c;
        if (i10 == 21 || i10 == 1342177280 || i10 == 22 || i10 == 1610612736 || i10 == 4) {
            return i10 != 4 ? new j1.e(eVar.f6951a, eVar.f6952b, 4) : j1.e.f6950e;
        }
        throw new j1.f(eVar);
    }
}
