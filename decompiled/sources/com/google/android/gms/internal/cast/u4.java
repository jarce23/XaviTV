package com.google.android.gms.internal.cast;

import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u4 extends com.bumptech.glide.d {

    /* renamed from: h, reason: collision with root package name */
    public static final Logger f3489h = Logger.getLogger(u4.class.getName());

    /* renamed from: i, reason: collision with root package name */
    public static final boolean f3490i = p6.f3430e;

    /* renamed from: d, reason: collision with root package name */
    public p5 f3491d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f3492e;

    /* renamed from: f, reason: collision with root package name */
    public final int f3493f;
    public int g;

    public u4(int i10, byte[] bArr) {
        int length = bArr.length;
        if (((length - i10) | i10) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), 0, Integer.valueOf(i10)));
        }
        this.f3492e = bArr;
        this.g = 0;
        this.f3493f = i10;
    }

    public static int c0(int i10) {
        if (i10 >= 0) {
            return e0(i10);
        }
        return 10;
    }

    public static int d0(String str) {
        int length;
        try {
            length = r6.c(str);
        } catch (q6 unused) {
            length = str.getBytes(g5.f3312a).length;
        }
        return e0(length) + length;
    }

    public static int e0(int i10) {
        if ((i10 & (-128)) == 0) {
            return 1;
        }
        if ((i10 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i10) == 0) {
            return 3;
        }
        return (i10 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int f0(long j10) {
        int i10;
        if (((-128) & j10) == 0) {
            return 1;
        }
        if (j10 < 0) {
            return 10;
        }
        if (((-34359738368L) & j10) != 0) {
            j10 >>>= 28;
            i10 = 6;
        } else {
            i10 = 2;
        }
        if (((-2097152) & j10) != 0) {
            j10 >>>= 14;
            i10 += 2;
        }
        return (j10 & (-16384)) != 0 ? i10 + 1 : i10;
    }

    public final void Q(byte b2) {
        try {
            byte[] bArr = this.f3492e;
            int i10 = this.g;
            this.g = i10 + 1;
            bArr[i10] = b2;
        } catch (IndexOutOfBoundsException e7) {
            throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), 1), e7);
        }
    }

    public final void R(int i10, byte[] bArr) {
        try {
            System.arraycopy(bArr, 0, this.f3492e, this.g, i10);
            this.g += i10;
        } catch (IndexOutOfBoundsException e7) {
            throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), Integer.valueOf(i10)), e7);
        }
    }

    public final void S(int i10, t4 t4Var) {
        Z((i10 << 3) | 2);
        Z(t4Var.h());
        R(t4Var.h(), t4Var.f3478p);
    }

    public final void T(int i10, int i11) {
        Z((i10 << 3) | 5);
        U(i11);
    }

    public final void U(int i10) {
        try {
            byte[] bArr = this.f3492e;
            int i11 = this.g;
            int i12 = i11 + 1;
            this.g = i12;
            bArr[i11] = (byte) (i10 & 255);
            int i13 = i11 + 2;
            this.g = i13;
            bArr[i12] = (byte) ((i10 >> 8) & 255);
            int i14 = i11 + 3;
            this.g = i14;
            bArr[i13] = (byte) ((i10 >> 16) & 255);
            this.g = i11 + 4;
            bArr[i14] = (byte) ((i10 >> 24) & 255);
        } catch (IndexOutOfBoundsException e7) {
            throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), 1), e7);
        }
    }

    public final void V(int i10, long j10) {
        Z((i10 << 3) | 1);
        W(j10);
    }

    public final void W(long j10) {
        try {
            byte[] bArr = this.f3492e;
            int i10 = this.g;
            int i11 = i10 + 1;
            this.g = i11;
            bArr[i10] = (byte) (((int) j10) & 255);
            int i12 = i10 + 2;
            this.g = i12;
            bArr[i11] = (byte) (((int) (j10 >> 8)) & 255);
            int i13 = i10 + 3;
            this.g = i13;
            bArr[i12] = (byte) (((int) (j10 >> 16)) & 255);
            int i14 = i10 + 4;
            this.g = i14;
            bArr[i13] = (byte) (((int) (j10 >> 24)) & 255);
            int i15 = i10 + 5;
            this.g = i15;
            bArr[i14] = (byte) (((int) (j10 >> 32)) & 255);
            int i16 = i10 + 6;
            this.g = i16;
            bArr[i15] = (byte) (((int) (j10 >> 40)) & 255);
            int i17 = i10 + 7;
            this.g = i17;
            bArr[i16] = (byte) (((int) (j10 >> 48)) & 255);
            this.g = i10 + 8;
            bArr[i17] = (byte) (((int) (j10 >> 56)) & 255);
        } catch (IndexOutOfBoundsException e7) {
            throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), 1), e7);
        }
    }

    public final void X(int i10, String str) {
        Z((i10 << 3) | 2);
        int i11 = this.g;
        try {
            int e02 = e0(str.length() * 3);
            int e03 = e0(str.length());
            int i12 = this.f3493f;
            byte[] bArr = this.f3492e;
            if (e03 != e02) {
                Z(r6.c(str));
                int i13 = this.g;
                this.g = r6.b(str, bArr, i13, i12 - i13);
            } else {
                int i14 = i11 + e03;
                this.g = i14;
                int b2 = r6.b(str, bArr, i14, i12 - i14);
                this.g = i11;
                Z((b2 - i11) - e03);
                this.g = b2;
            }
        } catch (q6 e7) {
            this.g = i11;
            f3489h.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) e7);
            byte[] bytes = str.getBytes(g5.f3312a);
            try {
                int length = bytes.length;
                Z(length);
                R(length, bytes);
            } catch (IndexOutOfBoundsException e8) {
                throw new a6.d0(e8);
            }
        } catch (IndexOutOfBoundsException e10) {
            throw new a6.d0(e10);
        }
    }

    public final void Y(int i10, int i11) {
        Z((i10 << 3) | i11);
    }

    public final void Z(int i10) {
        while (true) {
            int i11 = i10 & (-128);
            byte[] bArr = this.f3492e;
            if (i11 == 0) {
                int i12 = this.g;
                this.g = i12 + 1;
                bArr[i12] = (byte) i10;
                return;
            } else {
                try {
                    int i13 = this.g;
                    this.g = i13 + 1;
                    bArr[i13] = (byte) ((i10 & 127) | 128);
                    i10 >>>= 7;
                } catch (IndexOutOfBoundsException e7) {
                    throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), 1), e7);
                }
            }
            throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(this.f3493f), 1), e7);
        }
    }

    public final void a0(int i10, long j10) {
        Z(i10 << 3);
        b0(j10);
    }

    public final void b0(long j10) {
        boolean z10 = f3490i;
        int i10 = this.f3493f;
        byte[] bArr = this.f3492e;
        if (!z10 || i10 - this.g < 10) {
            while ((j10 & (-128)) != 0) {
                try {
                    int i11 = this.g;
                    this.g = i11 + 1;
                    bArr[i11] = (byte) ((((int) j10) & 127) | 128);
                    j10 >>>= 7;
                } catch (IndexOutOfBoundsException e7) {
                    throw new a6.d0(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.g), Integer.valueOf(i10), 1), e7);
                }
            }
            int i12 = this.g;
            this.g = i12 + 1;
            bArr[i12] = (byte) j10;
            return;
        }
        while (true) {
            int i13 = (int) j10;
            if ((j10 & (-128)) == 0) {
                int i14 = this.g;
                this.g = i14 + 1;
                p6.f3428c.d(bArr, p6.f3431f + i14, (byte) i13);
                return;
            } else {
                int i15 = this.g;
                this.g = i15 + 1;
                p6.f3428c.d(bArr, p6.f3431f + i15, (byte) ((i13 & 127) | 128));
                j10 >>>= 7;
            }
        }
    }
}
