package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.util.Log;
import java.math.BigInteger;
import java.util.Map;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: d, reason: collision with root package name */
    public static final l7.b f3586d = new l7.b("ApplicationAnalyticsUtils", null);

    /* renamed from: e, reason: collision with root package name */
    public static final String f3587e = "21.4.0";

    /* renamed from: a, reason: collision with root package name */
    public final String f3588a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f3589b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f3590c;

    public y0(String str, Bundle bundle) {
        this.f3588a = str;
        this.f3589b = n.y("com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", bundle);
        this.f3590c = n.y("com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON", bundle);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.cast.n1 a(com.google.android.gms.internal.cast.x0 r5, int r6) {
        /*
            r4 = this;
            com.google.android.gms.internal.cast.m1 r5 = r4.b(r5)
            com.google.android.gms.internal.cast.i1 r0 = r5.d()
            com.google.android.gms.internal.cast.h1 r0 = com.google.android.gms.internal.cast.i1.m(r0)
            java.util.Map r1 = r4.f3590c
            if (r1 == 0) goto L29
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            boolean r3 = r1.containsKey(r2)
            if (r3 != 0) goto L1b
            goto L29
        L1b:
            java.lang.Object r1 = r1.get(r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r7.r.e(r1)
            int r1 = r1.intValue()
            goto L2b
        L29:
            int r1 = r6 + 10000
        L2b:
            r0.c()
            com.google.android.gms.internal.cast.a5 r2 = r0.f3641p
            com.google.android.gms.internal.cast.i1 r2 = (com.google.android.gms.internal.cast.i1) r2
            com.google.android.gms.internal.cast.i1.r(r2, r1)
            java.util.Map r1 = r4.f3589b
            if (r1 == 0) goto L52
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
            boolean r3 = r1.containsKey(r2)
            if (r3 != 0) goto L44
            goto L52
        L44:
            java.lang.Object r6 = r1.get(r2)
            java.lang.Integer r6 = (java.lang.Integer) r6
            r7.r.e(r6)
            int r6 = r6.intValue()
            goto L54
        L52:
            int r6 = r6 + 10000
        L54:
            r0.c()
            com.google.android.gms.internal.cast.a5 r1 = r0.f3641p
            com.google.android.gms.internal.cast.i1 r1 = (com.google.android.gms.internal.cast.i1) r1
            com.google.android.gms.internal.cast.i1.s(r1, r6)
            com.google.android.gms.internal.cast.a5 r6 = r0.a()
            com.google.android.gms.internal.cast.i1 r6 = (com.google.android.gms.internal.cast.i1) r6
            r5.e(r6)
            com.google.android.gms.internal.cast.a5 r5 = r5.a()
            com.google.android.gms.internal.cast.n1 r5 = (com.google.android.gms.internal.cast.n1) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.y0.a(com.google.android.gms.internal.cast.x0, int):com.google.android.gms.internal.cast.n1");
    }

    public final m1 b(x0 x0Var) {
        long j10;
        m1 m10 = n1.m();
        long j11 = x0Var.f3574d;
        m10.c();
        n1.t((n1) m10.f3641p, j11);
        int i10 = x0Var.f3575e;
        x0Var.f3575e = i10 + 1;
        m10.c();
        n1.o((n1) m10.f3641p, i10);
        String str = x0Var.f3573c;
        if (str != null) {
            m10.c();
            n1.y((n1) m10.f3641p, str);
        }
        String str2 = x0Var.f3577h;
        if (str2 != null) {
            m10.c();
            n1.u((n1) m10.f3641p, str2);
        }
        f1 l10 = g1.l();
        l10.c();
        g1.n((g1) l10.f3641p, f3587e);
        l10.c();
        g1.m((g1) l10.f3641p, this.f3588a);
        g1 g1Var = (g1) l10.a();
        m10.c();
        n1.r((n1) m10.f3641p, g1Var);
        h1 l11 = i1.l();
        if (x0Var.f3572b != null) {
            e2 l12 = f2.l();
            String str3 = x0Var.f3572b;
            l12.c();
            f2.m((f2) l12.f3641p, str3);
            f2 f2Var = (f2) l12.a();
            l11.c();
            i1.o((i1) l11.f3641p, f2Var);
        }
        l11.c();
        i1.p((i1) l11.f3641p, false);
        String str4 = x0Var.f3576f;
        if (str4 != null) {
            try {
                String replace = str4.replace("-", _UrlKt.FRAGMENT_ENCODE_SET);
                j10 = new BigInteger(replace.substring(0, Math.min(16, replace.length())), 16).longValue();
            } catch (NumberFormatException e7) {
                Object[] objArr = {str4};
                l7.b bVar = f3586d;
                Log.w(bVar.f8271a, bVar.d("receiverSessionId %s is not valid for hash", objArr), e7);
                j10 = 0;
            }
            l11.c();
            i1.q((i1) l11.f3641p, j10);
        }
        int i11 = x0Var.g;
        l11.c();
        i1.t((i1) l11.f3641p, i11);
        boolean z10 = x0Var.f3571a.f3277e == 2;
        l11.c();
        i1.u((i1) l11.f3641p, z10);
        boolean z11 = x0Var.f3578i;
        l11.c();
        i1.x((i1) l11.f3641p, z11);
        m10.c();
        n1.p((n1) m10.f3641p, (i1) l11.a());
        return m10;
    }
}
