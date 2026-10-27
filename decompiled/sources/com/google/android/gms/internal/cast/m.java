package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends w3.p {

    /* renamed from: f, reason: collision with root package name */
    public static final l7.b f3366f = new l7.b("MRDiscoveryCallback", null);

    /* renamed from: e, reason: collision with root package name */
    public final x4.e f3371e;

    /* renamed from: c, reason: collision with root package name */
    public final Map f3369c = Collections.synchronizedMap(new HashMap());

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f3370d = new LinkedHashSet();

    /* renamed from: b, reason: collision with root package name */
    public final Set f3368b = Collections.synchronizedSet(new LinkedHashSet());

    /* renamed from: a, reason: collision with root package name */
    public final l f3367a = new l(this);

    public m(Context context) {
        this.f3371e = new x4.e(context, 5);
    }

    @Override // w3.p
    public final void d(w3.z zVar) {
        f3366f.b("MediaRouterDiscoveryCallback.onRouteAdded.", new Object[0]);
        o(zVar, true);
    }

    @Override // w3.p
    public final void e(w3.z zVar) {
        f3366f.b("MediaRouterDiscoveryCallback.onRouteChanged.", new Object[0]);
        o(zVar, true);
    }

    @Override // w3.p
    public final void f(w3.z zVar) {
        f3366f.b("MediaRouterDiscoveryCallback.onRouteRemoved.", new Object[0]);
        o(zVar, false);
    }

    public final void m() {
        l7.b bVar = f3366f;
        bVar.b(android.support.v4.media.d.o("Starting RouteDiscovery with ", this.f3370d.size(), " IDs"), new Object[0]);
        bVar.b("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.f3369c.keySet())), new Object[0]);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            n();
        } else {
            new b8.e(Looper.getMainLooper(), 2).post(new j(this, 1));
        }
    }

    public final void n() {
        x4.e eVar = this.f3371e;
        if (((w3.b0) eVar.f13543q) == null) {
            eVar.f13543q = w3.b0.d((Context) eVar.f13542p);
        }
        w3.b0 b0Var = (w3.b0) eVar.f13543q;
        if (b0Var != null) {
            b0Var.i(this);
        }
        synchronized (this.f3370d) {
            try {
                Iterator it = this.f3370d.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    String a10 = g7.y.a(str);
                    if (a10 == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    ArrayList<String> arrayList = new ArrayList<>();
                    if (!arrayList.contains(a10)) {
                        arrayList.add(a10);
                    }
                    Bundle bundle = new Bundle();
                    bundle.putStringArrayList("controlCategories", arrayList);
                    w3.o oVar = new w3.o(bundle, arrayList);
                    if (((k) this.f3369c.get(str)) == null) {
                        this.f3369c.put(str, new k(oVar));
                    }
                    f3366f.b("Adding mediaRouter callback for control category " + g7.y.a(str), new Object[0]);
                    x4.e eVar2 = this.f3371e;
                    if (((w3.b0) eVar2.f13543q) == null) {
                        eVar2.f13543q = w3.b0.d((Context) eVar2.f13542p);
                    }
                    ((w3.b0) eVar2.f13543q).a(oVar, this, 4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        f3366f.b("appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(this.f3369c.keySet())), new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x015f, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0172, code lost:
    
        throw r11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(w3.z r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.m.o(w3.z, boolean):void");
    }
}
