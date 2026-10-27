package com.google.android.gms.internal.cast;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: j, reason: collision with root package name */
    public static final l7.b f3560j = new l7.b("ConnectivityMonitor", null);

    /* renamed from: a, reason: collision with root package name */
    public final g4 f3561a;

    /* renamed from: c, reason: collision with root package name */
    public final ConnectivityManager f3563c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f3566f;
    public final Context g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f3567h = new Object();

    /* renamed from: i, reason: collision with root package name */
    public final Set f3568i = Collections.synchronizedSet(new HashSet());

    /* renamed from: d, reason: collision with root package name */
    public final Map f3564d = Collections.synchronizedMap(new HashMap());

    /* renamed from: e, reason: collision with root package name */
    public final List f3565e = Collections.synchronizedList(new ArrayList());

    /* renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.manager.p f3562b = new com.bumptech.glide.manager.p(1, this);

    public x(Context context, g4 g4Var) {
        this.f3561a = g4Var;
        this.g = context;
        this.f3563c = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public final void a(Network network, LinkProperties linkProperties) {
        synchronized (this.f3567h) {
            try {
                if (this.f3564d != null && this.f3565e != null) {
                    f3560j.b("a new network is available", new Object[0]);
                    if (this.f3564d.containsKey(network)) {
                        this.f3565e.remove(network);
                    }
                    this.f3564d.put(network, linkProperties);
                    this.f3565e.add(network);
                    b();
                }
            } finally {
            }
        }
    }

    public final void b() {
        if (this.f3561a == null) {
            return;
        }
        synchronized (this.f3568i) {
            try {
                Iterator it = this.f3568i.iterator();
                while (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    if (!((h4) this.f3561a).f3321o.isShutdown()) {
                        ((h4) this.f3561a).execute(new w(0, this));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
