package j2;

import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import app.shamel.tv.activities.v;
import i1.p;
import i2.y;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import l1.t;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements y, a {
    public byte[] A;

    /* renamed from: w, reason: collision with root package name */
    public int f7028w;

    /* renamed from: x, reason: collision with root package name */
    public SurfaceTexture f7029x;

    /* renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f7020o = new AtomicBoolean();

    /* renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f7021p = new AtomicBoolean(true);

    /* renamed from: q, reason: collision with root package name */
    public final g f7022q = new g();

    /* renamed from: r, reason: collision with root package name */
    public final c4.e f7023r = new c4.e();

    /* renamed from: s, reason: collision with root package name */
    public final v f7024s = new v();

    /* renamed from: t, reason: collision with root package name */
    public final v f7025t = new v();

    /* renamed from: u, reason: collision with root package name */
    public final float[] f7026u = new float[16];

    /* renamed from: v, reason: collision with root package name */
    public final float[] f7027v = new float[16];

    /* renamed from: y, reason: collision with root package name */
    public volatile int f7030y = 0;

    /* renamed from: z, reason: collision with root package name */
    public int f7031z = -1;

    @Override // j2.a
    public final void a(long j10, float[] fArr) {
        ((v) this.f7023r.f2878r).a(j10, fArr);
    }

    @Override // j2.a
    public final void b() {
        this.f7024s.b();
        c4.e eVar = this.f7023r;
        ((v) eVar.f2878r).b();
        eVar.f2875o = false;
        this.f7021p.set(true);
    }

    public final void c(float[] fArr) {
        Object d6;
        GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            l1.b.c();
        } catch (l1.j e7) {
            l1.b.h("SceneRenderer", "Failed to draw a frame", e7);
        }
        if (this.f7020o.compareAndSet(true, false)) {
            SurfaceTexture surfaceTexture = this.f7029x;
            surfaceTexture.getClass();
            surfaceTexture.updateTexImage();
            try {
                l1.b.c();
            } catch (l1.j e8) {
                l1.b.h("SceneRenderer", "Failed to draw a frame", e8);
            }
            if (this.f7021p.compareAndSet(true, false)) {
                Matrix.setIdentityM(this.f7026u, 0);
            }
            long timestamp = this.f7029x.getTimestamp();
            v vVar = this.f7024s;
            synchronized (vVar) {
                d6 = vVar.d(timestamp, false);
            }
            Long l10 = (Long) d6;
            if (l10 != null) {
                c4.e eVar = this.f7023r;
                float[] fArr2 = this.f7026u;
                float[] fArr3 = (float[]) ((v) eVar.f2878r).f(l10.longValue());
                if (fArr3 != null) {
                    float[] fArr4 = (float[]) eVar.f2877q;
                    float f10 = fArr3[0];
                    float f11 = -fArr3[1];
                    float f12 = -fArr3[2];
                    float length = Matrix.length(f10, f11, f12);
                    if (length != 0.0f) {
                        Matrix.setRotateM(fArr4, 0, (float) Math.toDegrees(length), f10 / length, f11 / length, f12 / length);
                    } else {
                        Matrix.setIdentityM(fArr4, 0);
                    }
                    if (!eVar.f2875o) {
                        c4.e.d((float[]) eVar.f2876p, (float[]) eVar.f2877q);
                        eVar.f2875o = true;
                    }
                    Matrix.multiplyMM(fArr2, 0, (float[]) eVar.f2876p, 0, (float[]) eVar.f2877q, 0);
                }
            }
            f fVar = (f) this.f7025t.f(timestamp);
            if (fVar != null) {
                g gVar = this.f7022q;
                gVar.getClass();
                if (g.b(fVar)) {
                    gVar.f7012a = fVar.f7007c;
                    gVar.f7013b = new v(fVar.f7005a.f7004a[0]);
                    if (!fVar.f7008d) {
                        new v(fVar.f7006b.f7004a[0]);
                    }
                }
            }
        }
        Matrix.multiplyMM(this.f7027v, 0, fArr, 0, this.f7026u, 0);
        g gVar2 = this.f7022q;
        int i10 = this.f7028w;
        float[] fArr5 = this.f7027v;
        v vVar2 = gVar2.f7013b;
        if (vVar2 == null) {
            return;
        }
        int i11 = gVar2.f7012a;
        GLES20.glUniformMatrix3fv(gVar2.f7016e, 1, false, i11 == 1 ? g.f7010j : i11 == 2 ? g.f7011k : g.f7009i, 0);
        GLES20.glUniformMatrix4fv(gVar2.f7015d, 1, false, fArr5, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i10);
        GLES20.glUniform1i(gVar2.f7018h, 0);
        try {
            l1.b.c();
        } catch (l1.j e10) {
            Log.e("ProjectionRenderer", "Failed to bind uniforms", e10);
        }
        GLES20.glVertexAttribPointer(gVar2.f7017f, 3, 5126, false, 12, (Buffer) vVar2.f2063r);
        try {
            l1.b.c();
        } catch (l1.j e11) {
            Log.e("ProjectionRenderer", "Failed to load position data", e11);
        }
        GLES20.glVertexAttribPointer(gVar2.g, 2, 5126, false, 8, (Buffer) vVar2.f2064s);
        try {
            l1.b.c();
        } catch (l1.j e12) {
            Log.e("ProjectionRenderer", "Failed to load texture data", e12);
        }
        GLES20.glDrawArrays(vVar2.f2062q, 0, vVar2.f2061p);
        try {
            l1.b.c();
        } catch (l1.j e13) {
            Log.e("ProjectionRenderer", "Failed to render", e13);
        }
    }

    @Override // i2.y
    public final void d(long j10, long j11, p pVar, MediaFormat mediaFormat) {
        int i10;
        ArrayList arrayList;
        int j12;
        this.f7024s.a(j11, Long.valueOf(j10));
        byte[] bArr = pVar.B;
        int i11 = pVar.C;
        byte[] bArr2 = this.A;
        int i12 = this.f7031z;
        this.A = bArr;
        if (i11 == -1) {
            i11 = this.f7030y;
        }
        this.f7031z = i11;
        if (i12 == i11 && Arrays.equals(bArr2, this.A)) {
            return;
        }
        byte[] bArr3 = this.A;
        f fVar = null;
        if (bArr3 != null) {
            int i13 = this.f7031z;
            t tVar = new t(bArr3);
            try {
                tVar.J(4);
                j12 = tVar.j();
                tVar.I(0);
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            if (j12 == 1886547818) {
                tVar.J(8);
                int i14 = tVar.f8130b;
                int i15 = tVar.f8131c;
                while (i14 < i15) {
                    int j13 = tVar.j() + i14;
                    if (j13 <= i14 || j13 > i15) {
                        break;
                    }
                    int j14 = tVar.j();
                    if (j14 != 2037673328 && j14 != 1836279920) {
                        tVar.I(j13);
                        i14 = j13;
                    }
                    tVar.H(j13);
                    arrayList = com.bumptech.glide.c.s(tVar);
                    break;
                }
                arrayList = null;
            } else {
                arrayList = com.bumptech.glide.c.s(tVar);
            }
            if (arrayList != null) {
                int size = arrayList.size();
                if (size == 1) {
                    e eVar = (e) arrayList.get(0);
                    fVar = new f(eVar, eVar, i13);
                } else if (size == 2) {
                    fVar = new f((e) arrayList.get(0), (e) arrayList.get(1), i13);
                }
            }
        }
        if (fVar == null || !g.b(fVar)) {
            int i16 = this.f7031z;
            float radians = (float) Math.toRadians(180.0f);
            float radians2 = (float) Math.toRadians(360.0f);
            float f10 = radians / 36;
            float f11 = radians2 / 72;
            float[] fArr = new float[15984];
            float[] fArr2 = new float[10656];
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            for (int i20 = 36; i17 < i20; i20 = 36) {
                float f12 = radians / 2.0f;
                float f13 = (i17 * f10) - f12;
                int i21 = i17 + 1;
                float f14 = (i21 * f10) - f12;
                int i22 = 0;
                while (i22 < 73) {
                    int i23 = i21;
                    float f15 = f14;
                    float f16 = radians;
                    int i24 = i18;
                    int i25 = i19;
                    int i26 = 0;
                    int i27 = 2;
                    while (i26 < i27) {
                        float f17 = i26 == 0 ? f13 : f15;
                        float f18 = radians2;
                        float f19 = i22 * f11;
                        float f20 = f13;
                        float f21 = f10;
                        double d6 = 50.0f;
                        double d10 = (f19 + 3.1415927f) - (f18 / 2.0f);
                        double d11 = f17;
                        fArr[i24] = -((float) (Math.cos(d11) * Math.sin(d10) * d6));
                        fArr[i24 + 1] = (float) (Math.sin(d11) * d6);
                        int i28 = i24 + 3;
                        fArr[i24 + 2] = (float) (Math.cos(d11) * Math.cos(d10) * d6);
                        fArr2[i25] = f19 / f18;
                        int i29 = i25 + 2;
                        fArr2[i25 + 1] = ((i17 + i26) * f21) / f16;
                        if ((i22 != 0 || i26 != 0) && (i22 != 72 || i26 != 1)) {
                            i10 = 2;
                            i24 = i28;
                            i25 = i29;
                            i26++;
                            i27 = i10;
                            radians2 = f18;
                            f13 = f20;
                            f10 = f21;
                        }
                        System.arraycopy(fArr, i24, fArr, i28, 3);
                        i24 += 6;
                        i10 = 2;
                        System.arraycopy(fArr2, i25, fArr2, i29, 2);
                        i25 += 4;
                        i26++;
                        i27 = i10;
                        radians2 = f18;
                        f13 = f20;
                        f10 = f21;
                    }
                    i22++;
                    i18 = i24;
                    i19 = i25;
                    i21 = i23;
                    f14 = f15;
                    radians = f16;
                    radians2 = radians2;
                    f10 = f10;
                }
                i17 = i21;
            }
            e eVar2 = new e(new v(0, fArr, fArr2, 1));
            fVar = new f(eVar2, eVar2, i16);
        }
        this.f7025t.a(j11, fVar);
    }

    public final SurfaceTexture e() {
        try {
            GLES20.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
            l1.b.c();
            this.f7022q.a();
            l1.b.c();
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            l1.b.c();
            int i10 = iArr[0];
            l1.b.b(36197, i10);
            this.f7028w = i10;
        } catch (l1.j e7) {
            l1.b.h("SceneRenderer", "Failed to initialize the renderer", e7);
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f7028w);
        this.f7029x = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: j2.h
            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                i.this.f7020o.set(true);
            }
        });
        return this.f7029x;
    }
}
