package okhttp3.internal;

import gb.i;
import okhttp3.CacheControl;
import okhttp3.internal.url._UrlKt;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _CacheControlCommonKt {
    public static final CacheControl commonBuild(CacheControl.Builder builder) {
        h.e("<this>", builder);
        return new CacheControl(builder.getNoCache$okhttp(), builder.getNoStore$okhttp(), builder.getMaxAgeSeconds$okhttp(), -1, false, false, false, builder.getMaxStaleSeconds$okhttp(), builder.getMinFreshSeconds$okhttp(), builder.getOnlyIfCached$okhttp(), builder.getNoTransform$okhttp(), builder.getImmutable$okhttp(), null);
    }

    public static final int commonClampToInt(long j10) {
        if (j10 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x006a, code lost:
    
        if (r0 > 4611686018427387903L) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final okhttp3.CacheControl commonForceCache(okhttp3.CacheControl.Companion r9) {
        /*
            java.lang.String r0 = "<this>"
            za.h.e(r0, r9)
            okhttp3.CacheControl$Builder r9 = new okhttp3.CacheControl$Builder
            r9.<init>()
            okhttp3.CacheControl$Builder r9 = r9.onlyIfCached()
            int r0 = hb.a.f5768q
            hb.c r0 = hb.c.f5772r
            java.lang.String r1 = "unit"
            za.h.e(r1, r0)
            int r1 = r0.compareTo(r0)
            r2 = 1
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r1 > 0) goto L2c
            long r3 = (long) r3
            hb.c r1 = hb.c.f5770p
            long r0 = j1.c.g(r3, r0, r1)
            long r0 = r0 << r2
            int r2 = hb.b.f5769a
            goto L73
        L2c:
            long r3 = (long) r3
            hb.c r1 = hb.c.f5770p
            r5 = 4611686018426999999(0x3ffffffffffa14bf, double:1.9999999999138678)
            long r5 = j1.c.g(r5, r1, r0)
            long r7 = -r5
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 > 0) goto L49
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 > 0) goto L49
            long r0 = j1.c.g(r3, r0, r1)
            long r0 = r0 << r2
            int r2 = hb.b.f5769a
            goto L73
        L49:
            hb.c r1 = hb.c.f5771q
            java.lang.String r5 = "targetUnit"
            za.h.e(r5, r1)
            java.util.concurrent.TimeUnit r1 = r1.f5774o
            java.util.concurrent.TimeUnit r0 = r0.f5774o
            long r0 = r1.convert(r3, r0)
            r3 = -4611686018427387903(0xc000000000000001, double:-2.0000000000000004)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 >= 0) goto L63
        L61:
            r0 = r3
            goto L6d
        L63:
            r3 = 4611686018427387903(0x3fffffffffffffff, double:1.9999999999999998)
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 <= 0) goto L6d
            goto L61
        L6d:
            long r0 = r0 << r2
            r2 = 1
            long r0 = r0 + r2
            int r2 = hb.b.f5769a
        L73:
            okhttp3.CacheControl$Builder r9 = r9.m24maxStaleLRDsOJo(r0)
            okhttp3.CacheControl r9 = r9.build()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonForceCache(okhttp3.CacheControl$Companion):okhttp3.CacheControl");
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion companion) {
        h.e("<this>", companion);
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder builder) {
        h.e("<this>", builder);
        builder.setImmutable$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder builder) {
        h.e("<this>", builder);
        builder.setNoCache$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder builder) {
        h.e("<this>", builder);
        builder.setNoStore$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder builder) {
        h.e("<this>", builder);
        builder.setNoTransform$okhttp(true);
        return builder;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder builder) {
        h.e("<this>", builder);
        builder.setOnlyIfCached$okhttp(true);
        return builder;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final okhttp3.CacheControl commonParse(okhttp3.CacheControl.Companion r23, okhttp3.Headers r24) {
        /*
            Method dump skipped, instructions count: 397
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal._CacheControlCommonKt.commonParse(okhttp3.CacheControl$Companion, okhttp3.Headers):okhttp3.CacheControl");
    }

    public static final String commonToString(CacheControl cacheControl) {
        h.e("<this>", cacheControl);
        String headerValue$okhttp = cacheControl.getHeaderValue$okhttp();
        if (headerValue$okhttp != null) {
            return headerValue$okhttp;
        }
        StringBuilder sb2 = new StringBuilder();
        if (cacheControl.noCache()) {
            sb2.append("no-cache, ");
        }
        if (cacheControl.noStore()) {
            sb2.append("no-store, ");
        }
        if (cacheControl.maxAgeSeconds() != -1) {
            sb2.append("max-age=");
            sb2.append(cacheControl.maxAgeSeconds());
            sb2.append(", ");
        }
        if (cacheControl.sMaxAgeSeconds() != -1) {
            sb2.append("s-maxage=");
            sb2.append(cacheControl.sMaxAgeSeconds());
            sb2.append(", ");
        }
        if (cacheControl.isPrivate()) {
            sb2.append("private, ");
        }
        if (cacheControl.isPublic()) {
            sb2.append("public, ");
        }
        if (cacheControl.mustRevalidate()) {
            sb2.append("must-revalidate, ");
        }
        if (cacheControl.maxStaleSeconds() != -1) {
            sb2.append("max-stale=");
            sb2.append(cacheControl.maxStaleSeconds());
            sb2.append(", ");
        }
        if (cacheControl.minFreshSeconds() != -1) {
            sb2.append("min-fresh=");
            sb2.append(cacheControl.minFreshSeconds());
            sb2.append(", ");
        }
        if (cacheControl.onlyIfCached()) {
            sb2.append("only-if-cached, ");
        }
        if (cacheControl.noTransform()) {
            sb2.append("no-transform, ");
        }
        if (cacheControl.immutable()) {
            sb2.append("immutable, ");
        }
        if (sb2.length() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        h.d("delete(...)", sb2.delete(sb2.length() - 2, sb2.length()));
        String sb3 = sb2.toString();
        cacheControl.setHeaderValue$okhttp(sb3);
        return sb3;
    }

    private static final int indexOfElement(String str, String str2, int i10) {
        int length = str.length();
        while (i10 < length) {
            if (i.a0(str2, str.charAt(i10))) {
                return i10;
            }
            i10++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfElement$default(String str, String str2, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return indexOfElement(str, str2, i10);
    }
}
