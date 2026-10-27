package org.bson.types;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Decimal128 extends Number implements Comparable<Decimal128> {

    /* renamed from: o, reason: collision with root package name */
    public final long f9742o;

    /* renamed from: p, reason: collision with root package name */
    public final long f9743p;

    static {
        new BigInteger("10");
        new BigInteger("1");
        new BigInteger("0");
        new HashSet(Collections.singletonList("nan"));
        new HashSet(Collections.singletonList("-nan"));
        new HashSet(Arrays.asList("inf", "+inf", "infinity", "+infinity"));
        new HashSet(Arrays.asList("-inf", "-infinity"));
        fromIEEE754BIDEncoding(8646911284551352320L, 0L);
        fromIEEE754BIDEncoding(-576460752303423488L, 0L);
        fromIEEE754BIDEncoding(-288230376151711744L, 0L);
        fromIEEE754BIDEncoding(8935141660703064064L, 0L);
        fromIEEE754BIDEncoding(3476778912330022912L, 0L);
        fromIEEE754BIDEncoding(-5746593124524752896L, 0L);
    }

    public Decimal128(long j10, long j11) {
        this.f9742o = j10;
        this.f9743p = j11;
    }

    public static Decimal128 fromIEEE754BIDEncoding(long j10, long j11) {
        return new Decimal128(j10, j11);
    }

    public final BigDecimal a() {
        long j10;
        char c10;
        long j11 = this.f9742o;
        if ((j11 & 6917529027641081856L) == 6917529027641081856L) {
            j10 = 2305807824841605120L & j11;
            c10 = '/';
        } else {
            j10 = 9223231299366420480L & j11;
            c10 = '1';
        }
        int i10 = -(((int) (j10 >>> c10)) - 6176);
        if ((j11 & 6917529027641081856L) == 6917529027641081856L) {
            return BigDecimal.valueOf(0L, i10);
        }
        int i11 = e() ? -1 : 1;
        byte[] bArr = new byte[15];
        long j12 = 255;
        for (int i12 = 14; i12 >= 7; i12--) {
            bArr[i12] = (byte) ((this.f9743p & j12) >>> ((14 - i12) << 3));
            j12 <<= 8;
        }
        long j13 = 255;
        for (int i13 = 6; i13 >= 1; i13--) {
            bArr[i13] = (byte) ((j11 & j13) >>> ((6 - i13) << 3));
            j13 <<= 8;
        }
        bArr[0] = (byte) ((j11 & 281474976710656L) >>> 48);
        return new BigDecimal(new BigInteger(i11, bArr), i10);
    }

    public final boolean b(BigDecimal bigDecimal) {
        return e() && bigDecimal.signum() == 0;
    }

    public final boolean c() {
        return (this.f9742o & 8646911284551352320L) == 8646911284551352320L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x007c, code lost:
    
        if (r6.b(r2) != false) goto L51;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compareTo(org.bson.types.Decimal128 r6) {
        /*
            r5 = this;
            org.bson.types.Decimal128 r6 = (org.bson.types.Decimal128) r6
            boolean r0 = r5.d()
            r1 = 1
            if (r0 == 0) goto Lf
            boolean r6 = r6.d()
            r6 = r6 ^ r1
            return r6
        Lf:
            boolean r0 = r5.c()
            if (r0 == 0) goto L3c
            boolean r0 = r5.e()
            if (r0 == 0) goto L28
            boolean r0 = r6.c()
            if (r0 == 0) goto L93
            boolean r6 = r6.e()
            if (r6 == 0) goto L93
            goto L76
        L28:
            boolean r0 = r6.d()
            if (r0 == 0) goto L2f
            goto L93
        L2f:
            boolean r0 = r6.c()
            if (r0 == 0) goto L92
            boolean r6 = r6.e()
            if (r6 != 0) goto L92
            goto L76
        L3c:
            java.math.BigDecimal r0 = r5.a()
            java.math.BigDecimal r2 = r6.a()
            boolean r3 = r5.d()
            if (r3 != 0) goto L7f
            boolean r3 = r5.c()
            if (r3 != 0) goto L7f
            java.math.BigDecimal r3 = java.math.BigDecimal.ZERO
            int r4 = r0.compareTo(r3)
            if (r4 != 0) goto L7f
            boolean r4 = r6.d()
            if (r4 != 0) goto L7f
            boolean r4 = r6.c()
            if (r4 != 0) goto L7f
            int r3 = r2.compareTo(r3)
            if (r3 != 0) goto L7f
            boolean r3 = r5.b(r0)
            if (r3 == 0) goto L78
            boolean r6 = r6.b(r2)
            if (r6 == 0) goto L93
        L76:
            r6 = 0
            return r6
        L78:
            boolean r3 = r6.b(r2)
            if (r3 == 0) goto L7f
            goto L92
        L7f:
            boolean r3 = r6.d()
            if (r3 == 0) goto L86
            goto L93
        L86:
            boolean r3 = r6.c()
            if (r3 == 0) goto L95
            boolean r6 = r6.e()
            if (r6 == 0) goto L93
        L92:
            return r1
        L93:
            r6 = -1
            return r6
        L95:
            int r6 = r0.compareTo(r2)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bson.types.Decimal128.compareTo(java.lang.Object):int");
    }

    public final boolean d() {
        return (this.f9742o & 8935141660703064064L) == 8935141660703064064L;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        if (d()) {
            return Double.NaN;
        }
        if (c()) {
            return e() ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
        }
        BigDecimal a10 = a();
        if (b(a10)) {
            return -0.0d;
        }
        return a10.doubleValue();
    }

    public final boolean e() {
        return (this.f9742o & Long.MIN_VALUE) == Long.MIN_VALUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Decimal128.class != obj.getClass()) {
            return false;
        }
        Decimal128 decimal128 = (Decimal128) obj;
        return this.f9742o == decimal128.f9742o && this.f9743p == decimal128.f9743p;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return (float) doubleValue();
    }

    public final int hashCode() {
        long j10 = this.f9743p;
        int i10 = ((int) (j10 ^ (j10 >>> 32))) * 31;
        long j11 = this.f9742o;
        return i10 + ((int) ((j11 >>> 32) ^ j11));
    }

    @Override // java.lang.Number
    public final int intValue() {
        return (int) doubleValue();
    }

    @Override // java.lang.Number
    public final long longValue() {
        return (long) doubleValue();
    }

    public final String toString() {
        if (d()) {
            return "NaN";
        }
        if (c()) {
            return e() ? "-Infinity" : "Infinity";
        }
        StringBuilder sb2 = new StringBuilder();
        BigDecimal a10 = a();
        String bigInteger = a10.unscaledValue().abs().toString();
        if (e()) {
            sb2.append('-');
        }
        int i10 = -a10.scale();
        int length = (bigInteger.length() - 1) + i10;
        if (i10 > 0 || length < -6) {
            sb2.append(bigInteger.charAt(0));
            if (bigInteger.length() > 1) {
                sb2.append('.');
                sb2.append((CharSequence) bigInteger, 1, bigInteger.length());
            }
            sb2.append('E');
            if (length > 0) {
                sb2.append('+');
            }
            sb2.append(length);
        } else if (i10 == 0) {
            sb2.append(bigInteger);
        } else {
            int length2 = (-i10) - bigInteger.length();
            if (length2 >= 0) {
                sb2.append("0.");
                for (int i11 = 0; i11 < length2; i11++) {
                    sb2.append('0');
                }
                sb2.append((CharSequence) bigInteger, 0, bigInteger.length());
            } else {
                int i12 = -length2;
                sb2.append((CharSequence) bigInteger, 0, i12);
                sb2.append('.');
                sb2.append((CharSequence) bigInteger, i12, i12 - i10);
            }
        }
        return sb2.toString();
    }
}
