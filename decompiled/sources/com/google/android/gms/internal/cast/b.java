package com.google.android.gms.internal.cast;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final long f3256a;

    /* renamed from: b, reason: collision with root package name */
    public long f3257b;

    /* renamed from: c, reason: collision with root package name */
    public long f3258c;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicInteger f3259d;

    /* renamed from: e, reason: collision with root package name */
    public final int f3260e;

    public b(androidx.leanback.widget.i iVar) {
        this.f3260e = iVar.f1022o;
        long currentTimeMillis = System.currentTimeMillis();
        this.f3256a = currentTimeMillis;
        this.f3257b = currentTimeMillis;
        this.f3259d = new AtomicInteger(1);
    }
}
