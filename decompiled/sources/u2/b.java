package u2;

import com.bumptech.glide.d;
import i1.f0;
import i3.f;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f12337d;

    public static v2.a Q(t tVar) {
        String r2 = tVar.r();
        r2.getClass();
        String r10 = tVar.r();
        r10.getClass();
        return new v2.a(r2, r10, tVar.q(), tVar.q(), Arrays.copyOfRange(tVar.f8129a, tVar.f8130b, tVar.f8131c));
    }

    @Override // com.bumptech.glide.d
    public final f0 j(t2.a aVar, ByteBuffer byteBuffer) {
        switch (this.f12337d) {
            case 0:
                if (byteBuffer.get() != 116) {
                    return null;
                }
                f fVar = new f(byteBuffer.limit(), byteBuffer.array());
                int i10 = 12;
                fVar.t(12);
                int f10 = (fVar.f() + fVar.i(12)) - 4;
                fVar.t(44);
                fVar.u(fVar.i(12));
                fVar.t(16);
                ArrayList arrayList = new ArrayList();
                while (fVar.f() < f10) {
                    fVar.t(48);
                    int i11 = fVar.i(8);
                    fVar.t(4);
                    int f11 = fVar.f() + fVar.i(i10);
                    String str = null;
                    String str2 = null;
                    while (fVar.f() < f11) {
                        int i12 = fVar.i(8);
                        int i13 = fVar.i(8);
                        int f12 = fVar.f() + i13;
                        if (i12 == 2) {
                            int i14 = fVar.i(16);
                            fVar.t(8);
                            if (i14 == 3) {
                                while (fVar.f() < f12) {
                                    int i15 = fVar.i(8);
                                    Charset charset = StandardCharsets.US_ASCII;
                                    byte[] bArr = new byte[i15];
                                    fVar.l(i15, bArr);
                                    String str3 = new String(bArr, charset);
                                    int i16 = fVar.i(8);
                                    for (int i17 = 0; i17 < i16; i17++) {
                                        fVar.u(fVar.i(8));
                                    }
                                    str = str3;
                                }
                            }
                        } else if (i12 == 21) {
                            Charset charset2 = StandardCharsets.US_ASCII;
                            byte[] bArr2 = new byte[i13];
                            fVar.l(i13, bArr2);
                            str2 = new String(bArr2, charset2);
                        }
                        fVar.q(f12 * 8);
                    }
                    fVar.q(f11 * 8);
                    if (str != null && str2 != null) {
                        arrayList.add(new a(i11, str.concat(str2)));
                    }
                    i10 = 12;
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new f0(arrayList);
            default:
                return new f0(Q(new t(byteBuffer.limit(), byteBuffer.array())));
        }
    }
}
