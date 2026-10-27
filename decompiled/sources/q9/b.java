package q9;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f10371a = 0;

    static {
        Math.log(2.0d);
    }

    public static boolean a(double d6) {
        if (n4.a.u(d6)) {
            return d6 == 0.0d || 52 - Long.numberOfTrailingZeros(n4.a.q(d6)) <= Math.getExponent(d6);
        }
        return false;
    }

    public static boolean b(double d6) {
        if (d6 > 0.0d && n4.a.u(d6)) {
            long q10 = n4.a.q(d6);
            if ((q10 & (q10 - 1)) == 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(double r6) {
        /*
            java.math.RoundingMode r0 = java.math.RoundingMode.CEILING
            r1 = 0
            int r1 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            r2 = 0
            r3 = 1
            if (r1 <= 0) goto L12
            boolean r1 = n4.a.u(r6)
            if (r1 == 0) goto L12
            r1 = r3
            goto L13
        L12:
            r1 = r2
        L13:
            if (r1 == 0) goto L81
            int r1 = java.lang.Math.getExponent(r6)
            int r4 = java.lang.Math.getExponent(r6)
            r5 = -1022(0xfffffffffffffc02, float:NaN)
            if (r4 < r5) goto L77
            int[] r4 = q9.a.f10370a
            int r0 = r0.ordinal()
            r0 = r4[r0]
            switch(r0) {
                case 1: goto L65;
                case 2: goto L6b;
                case 3: goto L5e;
                case 4: goto L56;
                case 5: goto L4c;
                case 6: goto L32;
                case 7: goto L32;
                case 8: goto L32;
                default: goto L2c;
            }
        L2c:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            r6.<init>()
            throw r6
        L32:
            long r6 = java.lang.Double.doubleToRawLongBits(r6)
            r4 = 4503599627370495(0xfffffffffffff, double:2.225073858507201E-308)
            long r6 = r6 & r4
            r4 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            long r6 = r6 | r4
            double r6 = java.lang.Double.longBitsToDouble(r6)
            double r6 = r6 * r6
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 <= 0) goto L6b
            r2 = r3
            goto L6b
        L4c:
            if (r1 < 0) goto L4f
            r2 = r3
        L4f:
            boolean r6 = b(r6)
        L53:
            r6 = r6 ^ r3
            r2 = r2 & r6
            goto L6b
        L56:
            if (r1 >= 0) goto L59
            r2 = r3
        L59:
            boolean r6 = b(r6)
            goto L53
        L5e:
            boolean r6 = b(r6)
            r2 = r6 ^ 1
            goto L6b
        L65:
            boolean r6 = b(r6)
            if (r6 == 0) goto L6f
        L6b:
            if (r2 == 0) goto L6e
            int r1 = r1 + r3
        L6e:
            return r1
        L6f:
            java.lang.ArithmeticException r6 = new java.lang.ArithmeticException
            java.lang.String r7 = "mode was UNNECESSARY, but rounding was necessary"
            r6.<init>(r7)
            throw r6
        L77:
            r0 = 4841369599423283200(0x4330000000000000, double:4.503599627370496E15)
            double r6 = r6 * r0
            int r6 = c(r6)
            int r6 = r6 + (-52)
            return r6
        L81:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r7 = "x must be positive and finite"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: q9.b.c(double):int");
    }
}
