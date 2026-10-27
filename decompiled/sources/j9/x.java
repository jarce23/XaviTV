package j9;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x extends FilterInputStream {

    /* renamed from: o, reason: collision with root package name */
    public final a1 f7483o;

    /* renamed from: p, reason: collision with root package name */
    public byte[] f7484p;

    /* renamed from: q, reason: collision with root package name */
    public long f7485q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7486r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7487s;

    public x(InputStream inputStream) {
        super(inputStream);
        this.f7483o = new a1();
        this.f7484p = new byte[4096];
        this.f7486r = false;
        this.f7487s = false;
    }

    public final u a() {
        byte[] bArr;
        if (this.f7485q > 0) {
            do {
                bArr = this.f7484p;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f7486r || this.f7487s) {
            return new u(null, -1L, -1, false, false, null);
        }
        boolean c10 = c(30);
        a1 a1Var = this.f7483o;
        if (!c10) {
            this.f7486r = true;
            return a1Var.b();
        }
        u b2 = a1Var.b();
        if (b2.f7455e) {
            this.f7487s = true;
            return b2;
        }
        if (b2.f7452b == 4294967295L) {
            throw new j0("Files bigger than 4GiB are not supported.");
        }
        int i10 = a1Var.f7217f - 30;
        int length = this.f7484p.length;
        long j10 = i10;
        if (j10 > length) {
            do {
                length += length;
            } while (length < j10);
            this.f7484p = Arrays.copyOf(this.f7484p, length);
        }
        if (!c(i10)) {
            this.f7486r = true;
            return a1Var.b();
        }
        u b10 = a1Var.b();
        this.f7485q = b10.f7452b;
        return b10;
    }

    public final boolean c(int i10) {
        int max = Math.max(0, super.read(this.f7484p, 0, i10));
        a1 a1Var = this.f7483o;
        if (max != i10) {
            int i11 = i10 - max;
            if (Math.max(0, super.read(this.f7484p, max, i11)) != i11) {
                a1Var.a(this.f7484p, 0, max);
                return false;
            }
        }
        a1Var.a(this.f7484p, 0, i10);
        return true;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i10, int i11) {
        long j10 = this.f7485q;
        if (j10 <= 0 || this.f7486r) {
            return -1;
        }
        int max = Math.max(0, super.read(bArr, i10, (int) Math.min(j10, i11)));
        this.f7485q -= max;
        if (max != 0) {
            return max;
        }
        this.f7486r = true;
        return 0;
    }
}
