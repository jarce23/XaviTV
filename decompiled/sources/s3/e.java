package s3;

import g2.h;
import i1.h0;
import k2.o;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f11557a = {0, 0, 0, 0, 16, 0, Byte.MIN_VALUE, 0, 0, -86, 0, 56, -101, 113};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f11558b = {0, 0, 33, 7, -45, 17, -122, 68, -56, -63, -54, 0, 0, 0};

    public static boolean a(o oVar) {
        t tVar = new t(8);
        int i10 = h.a(oVar, tVar).f5115a;
        if (i10 != 1380533830 && i10 != 1380333108) {
            return false;
        }
        oVar.o(tVar.f8129a, 0, 4);
        tVar.I(0);
        int j10 = tVar.j();
        if (j10 == 1463899717) {
            return true;
        }
        l1.b.g("WavHeaderReader", "Unsupported form type: " + j10);
        return false;
    }

    public static h b(int i10, o oVar, t tVar) {
        h a10 = h.a(oVar, tVar);
        while (true) {
            int i11 = a10.f5115a;
            if (i11 == i10) {
                return a10;
            }
            android.support.v4.media.d.x("Ignoring unknown WAV chunk: ", i11, "WavHeaderReader");
            long j10 = a10.f5116b;
            long j11 = 8 + j10;
            if (j10 % 2 != 0) {
                j11 = 9 + j10;
            }
            if (j11 > 2147483647L) {
                throw h0.c("Chunk is too large (~2GB+) to skip; id: " + i11);
            }
            oVar.i((int) j11);
            a10 = h.a(oVar, tVar);
        }
    }
}
