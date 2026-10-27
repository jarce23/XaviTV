package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class v implements i8.c {

    /* renamed from: o, reason: collision with root package name */
    public Object f3499o;

    /* renamed from: p, reason: collision with root package name */
    public int f3500p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f3501q;

    /* renamed from: r, reason: collision with root package name */
    public Object f3502r;

    public /* synthetic */ v(l0 l0Var, String str, int i10, SharedPreferences sharedPreferences) {
        this.f3501q = l0Var;
        this.f3499o = str;
        this.f3500p = i10;
        this.f3502r = sharedPreferences;
    }

    public int a() {
        int i10 = this.f3500p;
        if (i10 != 2) {
            return i10 != 3 ? 0 : 512;
        }
        return 2048;
    }

    public Looper b() {
        Looper looper;
        synchronized (this.f3501q) {
            try {
                if (((Looper) this.f3499o) == null) {
                    l1.d.g(this.f3500p == 0 && ((HandlerThread) this.f3502r) == null);
                    HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
                    this.f3502r = handlerThread;
                    handlerThread.start();
                    this.f3499o = ((HandlerThread) this.f3502r).getLooper();
                }
                this.f3500p++;
                looper = (Looper) this.f3499o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return looper;
    }

    public void c() {
        HandlerThread handlerThread;
        synchronized (this.f3501q) {
            try {
                l1.d.g(this.f3500p > 0);
                int i10 = this.f3500p - 1;
                this.f3500p = i10;
                if (i10 == 0 && (handlerThread = (HandlerThread) this.f3502r) != null) {
                    handlerThread.quit();
                    this.f3502r = null;
                    this.f3499o = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // i8.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f3501q
            r3 = r0
            com.google.android.gms.internal.cast.l0 r3 = (com.google.android.gms.internal.cast.l0) r3
            java.lang.Object r0 = r13.f3499o
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            int r0 = r13.f3500p
            java.lang.Object r1 = r13.f3502r
            r2 = r1
            android.content.SharedPreferences r2 = (android.content.SharedPreferences) r2
            r5 = r14
            android.os.Bundle r5 = (android.os.Bundle) r5
            h7.i r14 = r3.f3358a
            r7.r.e(r14)
            com.google.android.gms.internal.cast.t r7 = r3.f3359b
            r1 = 3
            r8 = 0
            r9 = 1
            java.lang.String r10 = "register callback = %s"
            r4 = 2
            if (r0 == r1) goto L26
            if (r0 != r4) goto L4d
            r0 = r4
        L26:
            com.google.android.gms.internal.cast.c r1 = r3.f3360c
            com.google.android.gms.internal.cast.u5 r11 = new com.google.android.gms.internal.cast.u5
            r11.<init>(r3, r1, r6)
            com.google.android.gms.internal.cast.j4 r1 = new com.google.android.gms.internal.cast.j4
            r1.<init>(r11)
            r14.a(r1)
            if (r7 == 0) goto L4d
            com.google.android.gms.internal.cast.u0 r1 = new com.google.android.gms.internal.cast.u0
            r1.<init>(r9, r11)
            l7.b r11 = com.google.android.gms.internal.cast.t.f3467i
            java.lang.Object[] r12 = new java.lang.Object[r9]
            r12[r8] = r1
            r11.b(r10, r12)
            r7.r.b()
            java.util.Set r11 = r7.f3469b
            r11.add(r1)
        L4d:
            if (r0 == r9) goto L51
            if (r0 != r4) goto L78
        L51:
            com.google.android.gms.internal.cast.c r4 = r3.f3360c
            com.google.android.gms.internal.cast.w0 r1 = new com.google.android.gms.internal.cast.w0
            r1.<init>(r2, r3, r4, r5, r6)
            com.google.android.gms.internal.cast.p5 r0 = new com.google.android.gms.internal.cast.p5
            r0.<init>(r1)
            r14.a(r0)
            if (r7 == 0) goto L78
            com.google.android.gms.internal.cast.u0 r14 = new com.google.android.gms.internal.cast.u0
            r14.<init>(r8, r1)
            l7.b r0 = com.google.android.gms.internal.cast.t.f3467i
            java.lang.Object[] r1 = new java.lang.Object[r9]
            r1[r8] = r14
            r0.b(r10, r1)
            r7.r.b()
            java.util.Set r0 = r7.f3469b
            r0.add(r14)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.v.l(java.lang.Object):void");
    }

    public v() {
        this.f3501q = new Object();
        this.f3499o = null;
        this.f3502r = null;
        this.f3500p = 0;
    }

    public v(int i10, String str, int i11, ArrayList arrayList, byte[] bArr) {
        List unmodifiableList;
        this.f3499o = str;
        this.f3500p = i11;
        if (arrayList == null) {
            unmodifiableList = Collections.EMPTY_LIST;
        } else {
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        this.f3501q = unmodifiableList;
        this.f3502r = bArr;
    }
}
