package rb;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p0 extends o {

    /* renamed from: s, reason: collision with root package name */
    public final transient byte[][] f11058s;

    /* renamed from: t, reason: collision with root package name */
    public final transient int[] f11059t;

    public p0(byte[][] bArr, int[] iArr) {
        super(o.f11048r.f11049o);
        this.f11058s = bArr;
        this.f11059t = iArr;
    }

    @Override // rb.o
    public final String a() {
        return u().a();
    }

    @Override // rb.o
    public final o c(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f11058s;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.f11059t;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            messageDigest.update(bArr[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digest = messageDigest.digest();
        za.h.b(digest);
        return new o(digest);
    }

    @Override // rb.o
    public final int d() {
        return this.f11059t[this.f11058s.length - 1];
    }

    @Override // rb.o
    public final String e() {
        return u().e();
    }

    @Override // rb.o
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (oVar.d() == d() && m(0, oVar, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // rb.o
    public final int f(int i10, byte[] bArr) {
        za.h.e("other", bArr);
        return u().f(i10, bArr);
    }

    @Override // rb.o
    public final byte[] h() {
        return t();
    }

    @Override // rb.o
    public final int hashCode() {
        int i10 = this.f11050p;
        if (i10 != 0) {
            return i10;
        }
        byte[][] bArr = this.f11058s;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int[] iArr = this.f11059t;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            byte[] bArr2 = bArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr2[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.f11050p = i12;
        return i12;
    }

    @Override // rb.o
    public final byte i(int i10) {
        byte[][] bArr = this.f11058s;
        int length = bArr.length - 1;
        int[] iArr = this.f11059t;
        b.e(iArr[length], i10, 1L);
        int i11 = sb.b.i(this, i10);
        return bArr[i11][(i10 - (i11 == 0 ? 0 : iArr[i11 - 1])) + iArr[bArr.length + i11]];
    }

    @Override // rb.o
    public final int j(byte[] bArr) {
        za.h.e("other", bArr);
        return u().j(bArr);
    }

    @Override // rb.o
    public final boolean l(int i10, int i11, int i12, byte[] bArr) {
        za.h.e("other", bArr);
        if (i10 < 0 || i10 > d() - i12 || i11 < 0 || i11 > bArr.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int i14 = sb.b.i(this, i10);
        while (i10 < i13) {
            int[] iArr = this.f11059t;
            int i15 = i14 == 0 ? 0 : iArr[i14 - 1];
            int i16 = iArr[i14] - i15;
            byte[][] bArr2 = this.f11058s;
            int i17 = iArr[bArr2.length + i14];
            int min = Math.min(i13, i16 + i15) - i10;
            if (!b.a((i10 - i15) + i17, i11, min, bArr2[i14], bArr)) {
                return false;
            }
            i11 += min;
            i10 += min;
            i14++;
        }
        return true;
    }

    @Override // rb.o
    public final boolean m(int i10, o oVar, int i11) {
        za.h.e("other", oVar);
        if (i10 >= 0 && i10 <= d() - i11) {
            int i12 = i11 + i10;
            int i13 = sb.b.i(this, i10);
            int i14 = 0;
            while (i10 < i12) {
                int[] iArr = this.f11059t;
                int i15 = i13 == 0 ? 0 : iArr[i13 - 1];
                int i16 = iArr[i13] - i15;
                byte[][] bArr = this.f11058s;
                int i17 = iArr[bArr.length + i13];
                int min = Math.min(i12, i16 + i15) - i10;
                if (oVar.l(i14, (i10 - i15) + i17, min, bArr[i13])) {
                    i14 += min;
                    i10 += min;
                    i13++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // rb.o
    public final String n(Charset charset) {
        za.h.e("charset", charset);
        return u().n(charset);
    }

    @Override // rb.o
    public final o o(int i10, int i11) {
        if (i11 == -1234567890) {
            i11 = d();
        }
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("beginIndex=", i10, " < 0").toString());
        }
        if (i11 > d()) {
            StringBuilder f10 = r.a.f("endIndex=", i11, " > length(");
            f10.append(d());
            f10.append(')');
            throw new IllegalArgumentException(f10.toString().toString());
        }
        int i12 = i11 - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.p("endIndex=", " < beginIndex=", i11, i10).toString());
        }
        if (i10 == 0 && i11 == d()) {
            return this;
        }
        if (i10 == i11) {
            return o.f11048r;
        }
        int i13 = sb.b.i(this, i10);
        int i14 = sb.b.i(this, i11 - 1);
        byte[][] bArr = this.f11058s;
        byte[][] bArr2 = (byte[][]) ma.i.H(bArr, i13, i14 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.f11059t;
        if (i13 <= i14) {
            int i15 = i13;
            int i16 = 0;
            while (true) {
                iArr[i16] = Math.min(iArr2[i15] - i10, i12);
                int i17 = i16 + 1;
                iArr[i16 + bArr2.length] = iArr2[bArr.length + i15];
                if (i15 == i14) {
                    break;
                }
                i15++;
                i16 = i17;
            }
        }
        int i18 = i13 != 0 ? iArr2[i13 - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i10 - i18) + iArr[length];
        return new p0(bArr2, iArr);
    }

    @Override // rb.o
    public final o q() {
        return u().q();
    }

    @Override // rb.o
    public final void s(int i10, l lVar) {
        int i11 = sb.b.i(this, 0);
        int i12 = 0;
        while (i12 < i10) {
            int[] iArr = this.f11059t;
            int i13 = i11 == 0 ? 0 : iArr[i11 - 1];
            int i14 = iArr[i11] - i13;
            byte[][] bArr = this.f11058s;
            int i15 = iArr[bArr.length + i11];
            int min = Math.min(i10, i14 + i13) - i12;
            int i16 = (i12 - i13) + i15;
            n0 n0Var = new n0(bArr[i11], i16, i16 + min, true, false);
            n0 n0Var2 = lVar.f11034o;
            if (n0Var2 == null) {
                n0Var.g = n0Var;
                n0Var.f11047f = n0Var;
                lVar.f11034o = n0Var;
            } else {
                n0 n0Var3 = n0Var2.g;
                za.h.b(n0Var3);
                n0Var3.b(n0Var);
            }
            i12 += min;
            i11++;
        }
        lVar.f11035p += i10;
    }

    public final byte[] t() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.f11058s;
        int length = bArr2.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.f11059t;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            int i15 = i14 - i11;
            ma.i.C(i12, i13, i13 + i15, bArr2[i10], bArr);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // rb.o
    public final String toString() {
        return u().toString();
    }

    public final o u() {
        return new o(t());
    }
}
