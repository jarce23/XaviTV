package com.google.android.gms.internal.cast;

import android.content.Context;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l0 {

    /* renamed from: i, reason: collision with root package name */
    public static final l7.b f3356i = new l7.b("ClientCastAnalytics", null);

    /* renamed from: j, reason: collision with root package name */
    public static final boolean f3357j = true;

    /* renamed from: a, reason: collision with root package name */
    public final h7.i f3358a;

    /* renamed from: b, reason: collision with root package name */
    public final t f3359b;

    /* renamed from: c, reason: collision with root package name */
    public final c f3360c;

    /* renamed from: e, reason: collision with root package name */
    public Long f3362e;
    public x4.m g;

    /* renamed from: h, reason: collision with root package name */
    public int f3364h = 1;

    /* renamed from: d, reason: collision with root package name */
    public final String f3361d = UUID.randomUUID().toString();

    /* renamed from: f, reason: collision with root package name */
    public final ExecutorService f3363f = Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());

    public l0(Context context, l7.s sVar, h7.i iVar, t tVar, c cVar) {
        this.f3358a = iVar;
        this.f3359b = tVar;
        this.f3360c = cVar;
    }

    public final void a(n1 n1Var, int i10) {
        this.f3363f.execute(new androidx.activity.h(this, n1Var, i10, 3));
    }
}
