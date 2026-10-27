package u1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends j1.h {

    /* renamed from: i, reason: collision with root package name */
    public int[] f12274i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f12275j;

    @Override // j1.g
    public final void f(ByteBuffer byteBuffer) {
        int[] iArr = this.f12275j;
        iArr.getClass();
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer k10 = k(((limit - position) / this.f6956b.f6954d) * this.f6957c.f6954d);
        while (position < limit) {
            for (int i10 : iArr) {
                int s10 = (l1.a0.s(this.f6956b.f6953c) * i10) + position;
                int i11 = this.f6956b.f6953c;
                if (i11 != 2) {
                    if (i11 == 3) {
                        k10.put(byteBuffer.get(s10));
                    } else if (i11 != 4) {
                        if (i11 != 21) {
                            if (i11 != 22) {
                                if (i11 != 268435456) {
                                    if (i11 != 1342177280) {
                                        if (i11 != 1610612736) {
                                            throw new IllegalStateException("Unexpected encoding: " + this.f6956b.f6953c);
                                        }
                                    }
                                }
                            }
                            k10.putInt(byteBuffer.getInt(s10));
                        }
                        ByteOrder order = byteBuffer.order();
                        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                        byte b2 = byteBuffer.get(order == byteOrder ? s10 : s10 + 2);
                        byte b10 = byteBuffer.get(s10 + 1);
                        if (byteBuffer.order() == byteOrder) {
                            s10 += 2;
                        }
                        int i12 = ((((b2 << 24) & (-16777216)) | ((b10 << 16) & 16711680)) | ((byteBuffer.get(s10) << 8) & 65280)) >> 8;
                        l1.d.a("Value out of range of 24-bit integer: " + Integer.toHexString(i12), (i12 & (-16777216)) == 0 || (i12 & (-8388608)) == -8388608);
                        l1.d.b(k10.remaining() >= 3);
                        k10.put((byte) (k10.order() == byteOrder ? (i12 & 16711680) >> 16 : i12 & 255)).put((byte) ((i12 & 65280) >> 8)).put((byte) (k10.order() == byteOrder ? i12 & 255 : (i12 & 16711680) >> 16));
                    } else {
                        k10.putFloat(byteBuffer.getFloat(s10));
                    }
                }
                k10.putShort(byteBuffer.getShort(s10));
            }
            position += this.f6956b.f6954d;
        }
        byteBuffer.position(limit);
        k10.flip();
    }

    @Override // j1.h
    public final j1.e g(j1.e eVar) {
        int i10 = eVar.f6953c;
        int[] iArr = this.f12274i;
        if (iArr == null) {
            return j1.e.f6950e;
        }
        int i11 = eVar.f6952b;
        if (!l1.a0.K(i10)) {
            throw new j1.f(eVar);
        }
        boolean z10 = i11 != iArr.length;
        int i12 = 0;
        while (i12 < iArr.length) {
            int i13 = iArr[i12];
            if (i13 >= i11) {
                throw new j1.f("Channel map (" + Arrays.toString(iArr) + ") trying to access non-existent input channel.", eVar);
            }
            z10 |= i13 != i12;
            i12++;
        }
        return z10 ? new j1.e(eVar.f6951a, iArr.length, i10) : j1.e.f6950e;
    }

    @Override // j1.h
    public final void h() {
        this.f12275j = this.f12274i;
    }

    @Override // j1.h
    public final void j() {
        this.f12275j = null;
        this.f12274i = null;
    }
}
