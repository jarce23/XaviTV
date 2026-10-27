package j9;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends OutputStream {

    /* renamed from: o, reason: collision with root package name */
    public final a1 f7371o = new a1();

    /* renamed from: p, reason: collision with root package name */
    public final File f7372p;

    /* renamed from: q, reason: collision with root package name */
    public final o1 f7373q;

    /* renamed from: r, reason: collision with root package name */
    public long f7374r;

    /* renamed from: s, reason: collision with root package name */
    public long f7375s;

    /* renamed from: t, reason: collision with root package name */
    public FileOutputStream f7376t;

    /* renamed from: u, reason: collision with root package name */
    public u f7377u;

    public m0(File file, o1 o1Var) {
        this.f7372p = file;
        this.f7373q = o1Var;
    }

    @Override // java.io.OutputStream
    public final void write(int i10) {
        write(new byte[]{(byte) i10}, 0, 1);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i10, int i11) {
        int i12;
        int i13;
        int i14 = i10;
        int i15 = i11;
        while (i15 > 0) {
            if (this.f7374r == 0 && this.f7375s == 0) {
                a1 a1Var = this.f7371o;
                int a10 = a1Var.a(bArr, i14, i15);
                if (a10 == -1) {
                    return;
                }
                i14 += a10;
                i15 -= a10;
                u b2 = a1Var.b();
                this.f7377u = b2;
                boolean z10 = b2.f7455e;
                o1 o1Var = this.f7373q;
                if (z10) {
                    this.f7374r = 0L;
                    byte[] bArr2 = b2.f7456f;
                    o1Var.k(bArr2.length, bArr2);
                    this.f7375s = this.f7377u.f7456f.length;
                } else {
                    if (b2.f7453c == 0) {
                        String str = b2.f7451a;
                        if (!(str == null ? false : str.endsWith("/"))) {
                            o1Var.i(this.f7377u.f7456f);
                            File file = new File(this.f7372p, this.f7377u.f7451a);
                            file.getParentFile().mkdirs();
                            this.f7374r = this.f7377u.f7452b;
                            this.f7376t = new FileOutputStream(file);
                        }
                    }
                    byte[] bArr3 = this.f7377u.f7456f;
                    o1Var.k(bArr3.length, bArr3);
                    this.f7374r = this.f7377u.f7452b;
                }
            }
            int i16 = i15;
            String str2 = this.f7377u.f7451a;
            if (str2 == null ? false : str2.endsWith("/")) {
                i15 = i16;
            } else {
                long j10 = i16;
                u uVar = this.f7377u;
                if (uVar.f7455e) {
                    i12 = i14;
                    this.f7373q.d(this.f7375s, bArr, i12, i16);
                    i13 = i16;
                    this.f7375s += j10;
                } else {
                    i12 = i14;
                    i13 = i16;
                    if (uVar.f7453c == 0) {
                        i16 = (int) Math.min(j10, this.f7374r);
                        this.f7376t.write(bArr, i12, i16);
                        long j11 = this.f7374r - i16;
                        this.f7374r = j11;
                        if (j11 == 0) {
                            this.f7376t.close();
                        }
                    } else {
                        i16 = (int) Math.min(j10, this.f7374r);
                        this.f7373q.d((r0.f7456f.length + this.f7377u.f7452b) - this.f7374r, bArr, i12, i16);
                        this.f7374r -= i16;
                    }
                }
                i14 = i12 + i16;
                i15 = i13 - i16;
            }
        }
    }
}
