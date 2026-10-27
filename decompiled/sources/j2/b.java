package j2;

import i1.p;
import java.nio.ByteBuffer;
import l1.a0;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends s1.d {
    public final r1.e G;
    public final t H;
    public a I;
    public long J;

    public b() {
        super(6);
        this.G = new r1.e(1);
        this.H = new t();
    }

    @Override // s1.d, s1.a1
    public final void c(int i10, Object obj) {
        if (i10 == 8) {
            this.I = (a) obj;
        }
    }

    @Override // s1.d
    public final String j() {
        return "CameraMotionRenderer";
    }

    @Override // s1.d
    public final boolean l() {
        return k();
    }

    @Override // s1.d
    public final boolean m() {
        return true;
    }

    @Override // s1.d
    public final void n() {
        a aVar = this.I;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // s1.d
    public final void p(long j10, boolean z10) {
        this.J = Long.MIN_VALUE;
        a aVar = this.I;
        if (aVar != null) {
            aVar.b();
        }
    }

    @Override // s1.d
    public final void w(long j10, long j11) {
        float[] fArr;
        while (!k() && this.J < 100000 + j10) {
            r1.e eVar = this.G;
            eVar.j();
            x4.e eVar2 = this.f11250q;
            eVar2.f();
            if (v(eVar2, eVar, 0) != -4 || eVar.d(4)) {
                return;
            }
            long j12 = eVar.f10412u;
            this.J = j12;
            boolean z10 = j12 < this.f11259z;
            if (this.I != null && !z10) {
                eVar.n();
                ByteBuffer byteBuffer = eVar.f10410s;
                int i10 = a0.f8067a;
                if (byteBuffer.remaining() != 16) {
                    fArr = null;
                } else {
                    byte[] array = byteBuffer.array();
                    int limit = byteBuffer.limit();
                    t tVar = this.H;
                    tVar.G(limit, array);
                    tVar.I(byteBuffer.arrayOffset() + 4);
                    float[] fArr2 = new float[3];
                    for (int i11 = 0; i11 < 3; i11++) {
                        fArr2[i11] = Float.intBitsToFloat(tVar.l());
                    }
                    fArr = fArr2;
                }
                if (fArr != null) {
                    this.I.a(this.J - this.f11258y, fArr);
                }
            }
        }
    }

    @Override // s1.d
    public final int z(p pVar) {
        return "application/x-camera-motion".equals(pVar.f5991n) ? r.a.a(4, 0, 0, 0) : r.a.a(0, 0, 0, 0);
    }
}
