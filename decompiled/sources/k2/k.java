package k2;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements o {

    /* renamed from: p, reason: collision with root package name */
    public final i1.h f7751p;

    /* renamed from: q, reason: collision with root package name */
    public final long f7752q;

    /* renamed from: r, reason: collision with root package name */
    public long f7753r;

    /* renamed from: t, reason: collision with root package name */
    public int f7755t;

    /* renamed from: u, reason: collision with root package name */
    public int f7756u;

    /* renamed from: s, reason: collision with root package name */
    public byte[] f7754s = new byte[65536];

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f7750o = new byte[4096];

    static {
        i1.b0.a("media3.extractor");
    }

    public k(i1.h hVar, long j10, long j11) {
        this.f7751p = hVar;
        this.f7753r = j10;
        this.f7752q = j11;
    }

    @Override // k2.o
    public final int a(int i10) {
        k kVar;
        int min = Math.min(this.f7756u, i10);
        s(min);
        if (min == 0) {
            byte[] bArr = this.f7750o;
            kVar = this;
            min = kVar.r(bArr, 0, Math.min(i10, bArr.length), 0, true);
        } else {
            kVar = this;
        }
        if (min != -1) {
            kVar.f7753r += min;
        }
        return min;
    }

    @Override // k2.o
    public final boolean b(byte[] bArr, int i10, int i11, boolean z10) {
        int min;
        int i12 = this.f7756u;
        if (i12 == 0) {
            min = 0;
        } else {
            min = Math.min(i12, i11);
            System.arraycopy(this.f7754s, 0, bArr, i10, min);
            s(min);
        }
        int i13 = min;
        while (i13 < i11 && i13 != -1) {
            i13 = r(bArr, i10, i11, i13, z10);
        }
        if (i13 != -1) {
            this.f7753r += i13;
        }
        return i13 != -1;
    }

    @Override // k2.o
    public final long c() {
        return this.f7752q;
    }

    @Override // k2.o
    public final int d(byte[] bArr, int i10, int i11) {
        k kVar;
        int min;
        q(i11);
        int i12 = this.f7756u;
        int i13 = this.f7755t;
        int i14 = i12 - i13;
        if (i14 == 0) {
            kVar = this;
            min = kVar.r(this.f7754s, i13, i11, 0, true);
            if (min == -1) {
                return -1;
            }
            kVar.f7756u += min;
        } else {
            kVar = this;
            min = Math.min(i11, i14);
        }
        System.arraycopy(kVar.f7754s, kVar.f7755t, bArr, i10, min);
        kVar.f7755t += min;
        return min;
    }

    public final boolean f(int i10, boolean z10) {
        q(i10);
        int i11 = this.f7756u - this.f7755t;
        while (i11 < i10) {
            int i12 = i10;
            boolean z11 = z10;
            i11 = r(this.f7754s, this.f7755t, i12, i11, z11);
            if (i11 == -1) {
                return false;
            }
            this.f7756u = this.f7755t + i11;
            i10 = i12;
            z10 = z11;
        }
        this.f7755t += i10;
        return true;
    }

    @Override // k2.o
    public final long getPosition() {
        return this.f7753r;
    }

    @Override // k2.o
    public final void h() {
        this.f7755t = 0;
    }

    @Override // k2.o
    public final void i(int i10) {
        k(i10, false);
    }

    @Override // k2.o
    public final boolean k(int i10, boolean z10) {
        int min = Math.min(this.f7756u, i10);
        s(min);
        int i11 = min;
        while (i11 < i10 && i11 != -1) {
            byte[] bArr = this.f7750o;
            i11 = r(bArr, -i11, Math.min(i10, bArr.length + i11), i11, z10);
        }
        if (i11 != -1) {
            this.f7753r += i11;
        }
        return i11 != -1;
    }

    @Override // k2.o
    public final boolean m(byte[] bArr, int i10, int i11, boolean z10) {
        if (!f(i11, z10)) {
            return false;
        }
        System.arraycopy(this.f7754s, this.f7755t - i11, bArr, i10, i11);
        return true;
    }

    @Override // k2.o
    public final long n() {
        return this.f7753r + this.f7755t;
    }

    @Override // k2.o
    public final void o(byte[] bArr, int i10, int i11) {
        m(bArr, i10, i11, false);
    }

    @Override // k2.o
    public final void p(int i10) {
        f(i10, false);
    }

    public final void q(int i10) {
        int i11 = this.f7755t + i10;
        byte[] bArr = this.f7754s;
        if (i11 > bArr.length) {
            this.f7754s = Arrays.copyOf(this.f7754s, l1.a0.i(bArr.length * 2, 65536 + i11, i11 + 524288));
        }
    }

    public final int r(byte[] bArr, int i10, int i11, int i12, boolean z10) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f7751p.read(bArr, i10 + i12, i11 - i12);
        if (read != -1) {
            return i12 + read;
        }
        if (i12 == 0 && z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        k kVar;
        int i12 = this.f7756u;
        int i13 = 0;
        if (i12 != 0) {
            int min = Math.min(i12, i11);
            System.arraycopy(this.f7754s, 0, bArr, i10, min);
            s(min);
            i13 = min;
        }
        if (i13 == 0) {
            kVar = this;
            i13 = kVar.r(bArr, i10, i11, 0, true);
        } else {
            kVar = this;
        }
        if (i13 != -1) {
            kVar.f7753r += i13;
        }
        return i13;
    }

    @Override // k2.o
    public final void readFully(byte[] bArr, int i10, int i11) {
        b(bArr, i10, i11, false);
    }

    public final void s(int i10) {
        int i11 = this.f7756u - i10;
        this.f7756u = i11;
        this.f7755t = 0;
        byte[] bArr = this.f7754s;
        byte[] bArr2 = i11 < bArr.length - 524288 ? new byte[65536 + i11] : bArr;
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.f7754s = bArr2;
    }
}
