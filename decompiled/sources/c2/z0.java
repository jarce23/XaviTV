package c2;

import android.media.MediaCodec;
import android.os.Build;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z0 {

    /* renamed from: a, reason: collision with root package name */
    public final g2.e f2782a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2783b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f2784c;

    /* renamed from: d, reason: collision with root package name */
    public y0 f2785d;

    /* renamed from: e, reason: collision with root package name */
    public y0 f2786e;

    /* renamed from: f, reason: collision with root package name */
    public y0 f2787f;
    public long g;

    public z0(g2.e eVar) {
        this.f2782a = eVar;
        int i10 = eVar.f5088b;
        this.f2783b = i10;
        this.f2784c = new l1.t(32);
        y0 y0Var = new y0(i10, 0L);
        this.f2785d = y0Var;
        this.f2786e = y0Var;
        this.f2787f = y0Var;
    }

    public static y0 d(y0 y0Var, long j10, ByteBuffer byteBuffer, int i10) {
        while (j10 >= y0Var.f2773p) {
            y0Var = (y0) y0Var.f2775r;
        }
        while (i10 > 0) {
            int min = Math.min(i10, (int) (y0Var.f2773p - j10));
            g2.a aVar = (g2.a) y0Var.f2774q;
            byteBuffer.put(aVar.f5077a, ((int) (j10 - y0Var.f2772o)) + aVar.f5078b, min);
            i10 -= min;
            j10 += min;
            if (j10 == y0Var.f2773p) {
                y0Var = (y0) y0Var.f2775r;
            }
        }
        return y0Var;
    }

    public static y0 e(y0 y0Var, long j10, byte[] bArr, int i10) {
        while (j10 >= y0Var.f2773p) {
            y0Var = (y0) y0Var.f2775r;
        }
        int i11 = i10;
        while (i11 > 0) {
            int min = Math.min(i11, (int) (y0Var.f2773p - j10));
            g2.a aVar = (g2.a) y0Var.f2774q;
            System.arraycopy(aVar.f5077a, ((int) (j10 - y0Var.f2772o)) + aVar.f5078b, bArr, i10 - i11, min);
            i11 -= min;
            j10 += min;
            if (j10 == y0Var.f2773p) {
                y0Var = (y0) y0Var.f2775r;
            }
        }
        return y0Var;
    }

    public static y0 f(y0 y0Var, r1.e eVar, a1 a1Var, l1.t tVar) {
        if (eVar.d(1073741824)) {
            long j10 = a1Var.f2525b;
            int i10 = 1;
            tVar.F(1);
            y0 e7 = e(y0Var, j10, tVar.f8129a, 1);
            long j11 = j10 + 1;
            byte b2 = tVar.f8129a[0];
            boolean z10 = (b2 & 128) != 0;
            int i11 = b2 & Byte.MAX_VALUE;
            o4.a aVar = eVar.f10409r;
            byte[] bArr = (byte[]) aVar.f9477e;
            if (bArr == null) {
                aVar.f9477e = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            y0Var = e(e7, j11, (byte[]) aVar.f9477e, i11);
            long j12 = j11 + i11;
            if (z10) {
                tVar.F(2);
                y0Var = e(y0Var, j12, tVar.f8129a, 2);
                j12 += 2;
                i10 = tVar.C();
            }
            int[] iArr = (int[]) aVar.g;
            if (iArr == null || iArr.length < i10) {
                iArr = new int[i10];
            }
            int[] iArr2 = (int[]) aVar.f9479h;
            if (iArr2 == null || iArr2.length < i10) {
                iArr2 = new int[i10];
            }
            if (z10) {
                int i12 = i10 * 6;
                tVar.F(i12);
                y0Var = e(y0Var, j12, tVar.f8129a, i12);
                j12 += i12;
                tVar.I(0);
                for (int i13 = 0; i13 < i10; i13++) {
                    iArr[i13] = tVar.C();
                    iArr2[i13] = tVar.A();
                }
            } else {
                iArr[0] = 0;
                iArr2[0] = a1Var.f2524a - ((int) (j12 - a1Var.f2525b));
            }
            k2.f0 f0Var = (k2.f0) a1Var.f2526c;
            int i14 = l1.a0.f8067a;
            byte[] bArr2 = f0Var.f7727b;
            byte[] bArr3 = (byte[]) aVar.f9477e;
            int i15 = f0Var.f7726a;
            int i16 = f0Var.f7728c;
            int i17 = f0Var.f7729d;
            aVar.f9474b = i10;
            aVar.g = iArr;
            aVar.f9479h = iArr2;
            aVar.f9478f = bArr2;
            aVar.f9477e = bArr3;
            aVar.f9473a = i15;
            aVar.f9475c = i16;
            aVar.f9476d = i17;
            MediaCodec.CryptoInfo cryptoInfo = (MediaCodec.CryptoInfo) aVar.f9480i;
            cryptoInfo.numSubSamples = i10;
            cryptoInfo.numBytesOfClearData = iArr;
            cryptoInfo.numBytesOfEncryptedData = iArr2;
            cryptoInfo.key = bArr2;
            cryptoInfo.iv = bArr3;
            cryptoInfo.mode = i15;
            if (Build.VERSION.SDK_INT >= 24) {
                x4.c cVar = (x4.c) aVar.f9481j;
                cVar.getClass();
                ((MediaCodec.CryptoInfo.Pattern) cVar.f13538q).set(i16, i17);
                ((MediaCodec.CryptoInfo) cVar.f13537p).setPattern((MediaCodec.CryptoInfo.Pattern) cVar.f13538q);
            }
            long j13 = a1Var.f2525b;
            int i18 = (int) (j12 - j13);
            a1Var.f2525b = j13 + i18;
            a1Var.f2524a -= i18;
        }
        if (!eVar.d(268435456)) {
            eVar.m(a1Var.f2524a);
            return d(y0Var, a1Var.f2525b, eVar.f10410s, a1Var.f2524a);
        }
        tVar.F(4);
        y0 e8 = e(y0Var, a1Var.f2525b, tVar.f8129a, 4);
        int A = tVar.A();
        a1Var.f2525b += 4;
        a1Var.f2524a -= 4;
        eVar.m(A);
        y0 d6 = d(e8, a1Var.f2525b, eVar.f10410s, A);
        a1Var.f2525b += A;
        int i19 = a1Var.f2524a - A;
        a1Var.f2524a = i19;
        ByteBuffer byteBuffer = eVar.f10413v;
        if (byteBuffer == null || byteBuffer.capacity() < i19) {
            eVar.f10413v = ByteBuffer.allocate(i19);
        } else {
            eVar.f10413v.clear();
        }
        return d(d6, a1Var.f2525b, eVar.f10413v, a1Var.f2524a);
    }

    public final void a(y0 y0Var) {
        if (((g2.a) y0Var.f2774q) == null) {
            return;
        }
        g2.e eVar = this.f2782a;
        synchronized (eVar) {
            y0 y0Var2 = y0Var;
            while (y0Var2 != null) {
                try {
                    g2.a[] aVarArr = eVar.f5092f;
                    int i10 = eVar.f5091e;
                    eVar.f5091e = i10 + 1;
                    g2.a aVar = (g2.a) y0Var2.f2774q;
                    aVar.getClass();
                    aVarArr[i10] = aVar;
                    eVar.f5090d--;
                    y0Var2 = (y0) y0Var2.f2775r;
                    if (y0Var2 == null || ((g2.a) y0Var2.f2774q) == null) {
                        y0Var2 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            eVar.notifyAll();
        }
        y0Var.f2774q = null;
        y0Var.f2775r = null;
    }

    public final void b(long j10) {
        y0 y0Var;
        if (j10 == -1) {
            return;
        }
        while (true) {
            y0Var = this.f2785d;
            if (j10 < y0Var.f2773p) {
                break;
            }
            g2.e eVar = this.f2782a;
            g2.a aVar = (g2.a) y0Var.f2774q;
            synchronized (eVar) {
                g2.a[] aVarArr = eVar.f5092f;
                int i10 = eVar.f5091e;
                eVar.f5091e = i10 + 1;
                aVarArr[i10] = aVar;
                eVar.f5090d--;
                eVar.notifyAll();
            }
            y0 y0Var2 = this.f2785d;
            y0Var2.f2774q = null;
            y0 y0Var3 = (y0) y0Var2.f2775r;
            y0Var2.f2775r = null;
            this.f2785d = y0Var3;
        }
        if (this.f2786e.f2772o < y0Var.f2772o) {
            this.f2786e = y0Var;
        }
    }

    public final int c(int i10) {
        g2.a aVar;
        y0 y0Var = this.f2787f;
        if (((g2.a) y0Var.f2774q) == null) {
            g2.e eVar = this.f2782a;
            synchronized (eVar) {
                try {
                    int i11 = eVar.f5090d + 1;
                    eVar.f5090d = i11;
                    int i12 = eVar.f5091e;
                    if (i12 > 0) {
                        g2.a[] aVarArr = eVar.f5092f;
                        int i13 = i12 - 1;
                        eVar.f5091e = i13;
                        aVar = aVarArr[i13];
                        aVar.getClass();
                        eVar.f5092f[eVar.f5091e] = null;
                    } else {
                        g2.a aVar2 = new g2.a(0, new byte[eVar.f5088b]);
                        g2.a[] aVarArr2 = eVar.f5092f;
                        if (i11 > aVarArr2.length) {
                            eVar.f5092f = (g2.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length * 2);
                        }
                        aVar = aVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            y0 y0Var2 = new y0(this.f2783b, this.f2787f.f2773p);
            y0Var.f2774q = aVar;
            y0Var.f2775r = y0Var2;
        }
        return Math.min(i10, (int) (this.f2787f.f2773p - this.g));
    }
}
