package rb;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class o implements Serializable, Comparable {

    /* renamed from: r, reason: collision with root package name */
    public static final o f11048r = new o(new byte[0]);

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f11049o;

    /* renamed from: p, reason: collision with root package name */
    public transient int f11050p;

    /* renamed from: q, reason: collision with root package name */
    public transient String f11051q;

    public o(byte[] bArr) {
        za.h.e("data", bArr);
        this.f11049o = bArr;
    }

    public static int g(o oVar, o oVar2) {
        oVar.getClass();
        za.h.e("other", oVar2);
        return oVar.f(0, oVar2.h());
    }

    public static int k(o oVar, o oVar2) {
        oVar.getClass();
        za.h.e("other", oVar2);
        return oVar.j(oVar2.h());
    }

    public static /* synthetic */ o p(o oVar, int i10, int i11, int i12) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = -1234567890;
        }
        return oVar.o(i10, i11);
    }

    public String a() {
        byte[] bArr = a.f10989a;
        byte[] bArr2 = this.f11049o;
        za.h.e("<this>", bArr2);
        za.h.e("map", bArr);
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b2 = bArr2[i10];
            int i12 = i10 + 2;
            byte b10 = bArr2[i10 + 1];
            i10 += 3;
            byte b11 = bArr2[i12];
            bArr3[i11] = bArr[(b2 & 255) >> 2];
            bArr3[i11 + 1] = bArr[((b2 & 3) << 4) | ((b10 & 255) >> 4)];
            int i13 = i11 + 3;
            bArr3[i11 + 2] = bArr[((b10 & 15) << 2) | ((b11 & 255) >> 6)];
            i11 += 4;
            bArr3[i13] = bArr[b11 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b12 = bArr2[i10];
            bArr3[i11] = bArr[(b12 & 255) >> 2];
            bArr3[i11 + 1] = bArr[(b12 & 3) << 4];
            bArr3[i11 + 2] = 61;
            bArr3[i11 + 3] = 61;
        } else if (length2 == 2) {
            int i14 = i10 + 1;
            byte b13 = bArr2[i10];
            byte b14 = bArr2[i14];
            bArr3[i11] = bArr[(b13 & 255) >> 2];
            bArr3[i11 + 1] = bArr[((b13 & 3) << 4) | ((b14 & 255) >> 4)];
            bArr3[i11 + 2] = bArr[(b14 & 15) << 2];
            bArr3[i11 + 3] = 61;
        }
        return new String(bArr3, gb.a.f5445a);
    }

    @Override // java.lang.Comparable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final int compareTo(o oVar) {
        za.h.e("other", oVar);
        int d6 = d();
        int d10 = oVar.d();
        int min = Math.min(d6, d10);
        for (int i10 = 0; i10 < min; i10++) {
            int i11 = i(i10) & 255;
            int i12 = oVar.i(i10) & 255;
            if (i11 != i12) {
                return i11 < i12 ? -1 : 1;
            }
        }
        if (d6 == d10) {
            return 0;
        }
        return d6 < d10 ? -1 : 1;
    }

    public o c(String str) {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f11049o, 0, d());
        byte[] digest = messageDigest.digest();
        za.h.b(digest);
        return new o(digest);
    }

    public int d() {
        return this.f11049o.length;
    }

    public String e() {
        byte[] bArr = this.f11049o;
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (byte b2 : bArr) {
            int i11 = i10 + 1;
            char[] cArr2 = sb.b.f11668a;
            cArr[i10] = cArr2[(b2 >> 4) & 15];
            i10 += 2;
            cArr[i11] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            int d6 = oVar.d();
            byte[] bArr = this.f11049o;
            if (d6 == bArr.length && oVar.l(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int f(int i10, byte[] bArr) {
        za.h.e("other", bArr);
        byte[] bArr2 = this.f11049o;
        int length = bArr2.length - bArr.length;
        int max = Math.max(i10, 0);
        if (max > length) {
            return -1;
        }
        while (!b.a(max, 0, bArr.length, bArr2, bArr)) {
            if (max == length) {
                return -1;
            }
            max++;
        }
        return max;
    }

    public byte[] h() {
        return this.f11049o;
    }

    public int hashCode() {
        int i10 = this.f11050p;
        if (i10 != 0) {
            return i10;
        }
        int hashCode = Arrays.hashCode(this.f11049o);
        this.f11050p = hashCode;
        return hashCode;
    }

    public byte i(int i10) {
        return this.f11049o[i10];
    }

    public int j(byte[] bArr) {
        za.h.e("other", bArr);
        int d6 = d();
        byte[] bArr2 = this.f11049o;
        for (int min = Math.min(d6, bArr2.length - bArr.length); -1 < min; min--) {
            if (b.a(min, 0, bArr.length, bArr2, bArr)) {
                return min;
            }
        }
        return -1;
    }

    public boolean l(int i10, int i11, int i12, byte[] bArr) {
        za.h.e("other", bArr);
        if (i10 < 0) {
            return false;
        }
        byte[] bArr2 = this.f11049o;
        return i10 <= bArr2.length - i12 && i11 >= 0 && i11 <= bArr.length - i12 && b.a(i10, i11, i12, bArr2, bArr);
    }

    public boolean m(int i10, o oVar, int i11) {
        za.h.e("other", oVar);
        return oVar.l(0, i10, i11, this.f11049o);
    }

    public String n(Charset charset) {
        za.h.e("charset", charset);
        return new String(this.f11049o, charset);
    }

    public o o(int i10, int i11) {
        if (i11 == -1234567890) {
            i11 = d();
        }
        if (i10 < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.f11049o;
        if (i11 <= bArr.length) {
            if (i11 - i10 >= 0) {
                return (i10 == 0 && i11 == bArr.length) ? this : new o(ma.i.G(bArr, i10, i11));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
    }

    public o q() {
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f11049o;
            if (i10 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i10];
            if (b2 >= 65 && b2 <= 90) {
                byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
                za.h.d("copyOf(...)", copyOf);
                copyOf[i10] = (byte) (b2 + 32);
                for (int i11 = i10 + 1; i11 < copyOf.length; i11++) {
                    byte b10 = copyOf[i11];
                    if (b10 >= 65 && b10 <= 90) {
                        copyOf[i11] = (byte) (b10 + 32);
                    }
                }
                return new o(copyOf);
            }
            i10++;
        }
    }

    public final String r() {
        String str = this.f11051q;
        if (str != null) {
            return str;
        }
        byte[] h10 = h();
        za.h.e("<this>", h10);
        String str2 = new String(h10, gb.a.f5445a);
        this.f11051q = str2;
        return str2;
    }

    public void s(int i10, l lVar) {
        lVar.m154write(this.f11049o, 0, i10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x00f6, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0130, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0134, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00d6, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0173, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x017a, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x016c, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01aa, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01ad, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01b0, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0140, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x01b3, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0096, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00c4, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0085, code lost:
    
        if (r6 == 64) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00fe, code lost:
    
        if (r6 == 64) goto L180;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rb.o.toString():java.lang.String");
    }
}
