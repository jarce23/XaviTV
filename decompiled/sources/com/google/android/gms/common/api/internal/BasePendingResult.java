package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.util.Pair;
import bb.b;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import i7.p;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import o7.j;
import p7.c;
import r7.r;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends j> extends d {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f3197n = 0;

    /* renamed from: h, reason: collision with root package name */
    public p f3201h;

    /* renamed from: j, reason: collision with root package name */
    public j f3203j;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f3204k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f3205l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3206m;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3198d = new Object();

    /* renamed from: f, reason: collision with root package name */
    public final CountDownLatch f3200f = new CountDownLatch(1);
    public final ArrayList g = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final AtomicReference f3202i = new AtomicReference();

    /* renamed from: e, reason: collision with root package name */
    public final c f3199e = new c(Looper.getMainLooper(), 0);

    static {
        new b(5);
    }

    public BasePendingResult() {
        new WeakReference(null);
    }

    public final void M() {
        synchronized (this.f3198d) {
            try {
                if (!this.f3205l && !this.f3204k) {
                    this.f3205l = true;
                    U(N(Status.f3192u));
                }
            } finally {
            }
        }
    }

    public abstract j N(Status status);

    public final void O(Status status) {
        synchronized (this.f3198d) {
            try {
                if (!Q()) {
                    R(N(status));
                    this.f3206m = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean P() {
        boolean z10;
        synchronized (this.f3198d) {
            z10 = this.f3205l;
        }
        return z10;
    }

    public final boolean Q() {
        return this.f3200f.getCount() == 0;
    }

    public final void R(j jVar) {
        synchronized (this.f3198d) {
            try {
                if (this.f3206m || this.f3205l) {
                    return;
                }
                Q();
                r.g("Results have already been set", !Q());
                r.g("Result has already been consumed", !this.f3204k);
                U(jVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void S(p pVar) {
        synchronized (this.f3198d) {
            try {
                r.g("Result has already been consumed.", !this.f3204k);
                if (P()) {
                    return;
                }
                if (Q()) {
                    c cVar = this.f3199e;
                    j T = T();
                    cVar.getClass();
                    cVar.sendMessage(cVar.obtainMessage(1, new Pair(pVar, T)));
                } else {
                    this.f3201h = pVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j T() {
        j jVar;
        synchronized (this.f3198d) {
            r.g("Result has already been consumed.", !this.f3204k);
            r.g("Result is not ready.", Q());
            jVar = this.f3203j;
            this.f3203j = null;
            this.f3201h = null;
            this.f3204k = true;
        }
        if (this.f3202i.getAndSet(null) != null) {
            throw new ClassCastException();
        }
        r.e(jVar);
        return jVar;
    }

    public final void U(j jVar) {
        this.f3203j = jVar;
        jVar.getClass();
        this.f3200f.countDown();
        if (this.f3205l) {
            this.f3201h = null;
        } else {
            p pVar = this.f3201h;
            if (pVar != null) {
                c cVar = this.f3199e;
                cVar.removeMessages(2);
                cVar.sendMessage(cVar.obtainMessage(1, new Pair(pVar, T())));
            }
        }
        ArrayList arrayList = this.g;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.d.k(0, arrayList);
        }
        arrayList.clear();
    }
}
