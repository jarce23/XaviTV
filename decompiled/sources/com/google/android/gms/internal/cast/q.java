package com.google.android.gms.internal.cast;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends g {

    /* renamed from: i, reason: collision with root package name */
    public static final l7.b f3432i = new l7.b("MediaRouterProxy", null);

    /* renamed from: d, reason: collision with root package name */
    public final w3.b0 f3433d;

    /* renamed from: e, reason: collision with root package name */
    public final h7.c f3434e;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f3435f;
    public final t g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f3436h;

    public q(Context context, w3.b0 b0Var, h7.c cVar, l7.s sVar) {
        super("com.google.android.gms.cast.framework.internal.IMediaRouter", 0);
        this.f3435f = new HashMap();
        this.f3433d = b0Var;
        this.f3434e = cVar;
        int i10 = Build.VERSION.SDK_INT;
        l7.b bVar = f3432i;
        if (i10 <= 32) {
            Log.i(bVar.f8271a, bVar.d("Don't need to set MediaRouterParams for Android S v2 or below", new Object[0]));
            return;
        }
        bVar.b("Set up MediaRouterParams based on module flag and CastOptions for Android T or above", new Object[0]);
        this.g = new t(cVar);
        Intent intent = new Intent(context, (Class<?>) w3.h0.class);
        intent.setPackage(context.getPackageName());
        boolean isEmpty = context.getPackageManager().queryBroadcastReceivers(intent, 0).isEmpty();
        this.f3436h = !isEmpty;
        if (!isEmpty) {
            y1.a(z0.CAST_OUTPUT_SWITCHER_ENABLED);
        }
        sVar.d(new String[]{"com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED"}).i(new x4.c(this, 5, cVar));
    }

    public final void A0(w3.o oVar) {
        Set set = (Set) this.f3435f.get(oVar);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.f3433d.i((w3.p) it.next());
        }
    }

    public final void y0(android.support.v4.media.session.a0 a0Var) {
        this.f3433d.getClass();
        w3.b0.b();
        w3.w c10 = w3.b0.c();
        c10.E = a0Var;
        x4.m mVar = a0Var != null ? new x4.m(c10, a0Var) : null;
        x4.m mVar2 = c10.D;
        if (mVar2 != null) {
            mVar2.u();
        }
        c10.D = mVar;
        if (mVar != null) {
            c10.m();
        }
    }

    public final void z0(w3.o oVar, int i10) {
        Set set = (Set) this.f3435f.get(oVar);
        if (set == null) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.f3433d.a(oVar, (w3.p) it.next(), i10);
        }
    }
}
