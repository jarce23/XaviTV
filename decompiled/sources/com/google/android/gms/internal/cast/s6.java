package com.google.android.gms.internal.cast;

import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s6 {

    /* renamed from: n, reason: collision with root package name */
    public static final l7.b f3452n = new l7.b("SessionFlowSummary", null);

    /* renamed from: o, reason: collision with root package name */
    public static final String f3453o = "21.4.0";

    /* renamed from: p, reason: collision with root package name */
    public static long f3454p = System.currentTimeMillis();

    /* renamed from: a, reason: collision with root package name */
    public final c.a f3455a;

    /* renamed from: b, reason: collision with root package name */
    public final List f3456b;

    /* renamed from: c, reason: collision with root package name */
    public final List f3457c;

    /* renamed from: d, reason: collision with root package name */
    public final List f3458d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f3459e;

    /* renamed from: f, reason: collision with root package name */
    public final l0 f3460f;
    public final String g;

    /* renamed from: h, reason: collision with root package name */
    public final long f3461h;

    /* renamed from: i, reason: collision with root package name */
    public final long f3462i;

    /* renamed from: j, reason: collision with root package name */
    public h7.d f3463j;

    /* renamed from: k, reason: collision with root package name */
    public String f3464k;

    /* renamed from: l, reason: collision with root package name */
    public String f3465l;

    /* renamed from: m, reason: collision with root package name */
    public String f3466m;

    public s6(l0 l0Var, String str) {
        f6 f6Var = f6.f3308o;
        c.a aVar = new c.a(1);
        aVar.f2492p = f6Var;
        this.f3455a = aVar;
        this.f3456b = Collections.synchronizedList(new ArrayList());
        this.f3457c = Collections.synchronizedList(new ArrayList());
        this.f3458d = Collections.synchronizedList(new ArrayList());
        this.f3459e = Collections.synchronizedMap(new HashMap());
        this.f3460f = l0Var;
        this.g = str;
        this.f3461h = System.currentTimeMillis();
        long j10 = f3454p;
        f3454p = 1 + j10;
        this.f3462i = j10;
    }

    public final void a(h7.d dVar) {
        if (dVar == null) {
            b(2);
            return;
        }
        r7.r.b();
        CastDevice castDevice = dVar.f5734k;
        if (castDevice == null) {
            b(3);
            return;
        }
        String str = castDevice.f3139z;
        this.f3463j = dVar;
        String str2 = this.f3465l;
        if (str2 == null) {
            this.f3465l = str;
            this.f3466m = castDevice.f3132s;
            dVar.c();
        } else {
            if (TextUtils.equals(str2, str)) {
                return;
            }
            b(5);
        }
    }

    public final void b(int i10) {
        Integer valueOf = Integer.valueOf(i10 - 1);
        Map map = this.f3459e;
        b bVar = (b) map.get(valueOf);
        if (bVar != null) {
            bVar.f3259d.incrementAndGet();
            bVar.f3257b = System.currentTimeMillis();
        } else {
            b bVar2 = new b(new androidx.leanback.widget.i(i10));
            bVar2.f3258c = this.f3461h;
            map.put(valueOf, bVar2);
        }
    }
}
