package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3540o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f3541p;

    public /* synthetic */ w(int i10, Object obj) {
        this.f3540o = i10;
        this.f3541p = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3540o) {
            case 0:
                List list = ((x) this.f3541p).f3565e;
                if (list != null) {
                    list.isEmpty();
                }
                throw null;
            case 1:
                w0 w0Var = (w0) this.f3541p;
                x0 x0Var = w0Var.g;
                if (x0Var != null) {
                    w0Var.f3543a.a((n1) w0Var.f3545c.b(x0Var).a(), 223);
                }
                w0Var.e();
                return;
            default:
                y1 y1Var = (y1) this.f3541p;
                HashSet hashSet = y1Var.f3599f;
                SharedPreferences sharedPreferences = y1Var.f3595b;
                HashSet hashSet2 = y1Var.g;
                if (hashSet.isEmpty()) {
                    return;
                }
                long j10 = true != hashSet2.equals(hashSet) ? 86400000L : 172800000L;
                long currentTimeMillis = System.currentTimeMillis();
                long j11 = y1Var.f3600h;
                if (j11 == 0 || currentTimeMillis - j11 >= j10) {
                    y1.f3591i.b("Upload the feature usage report.", new Object[0]);
                    f1 l10 = g1.l();
                    String str = y1.f3592j;
                    l10.c();
                    g1.n((g1) l10.f3641p, str);
                    String str2 = y1Var.f3596c;
                    l10.c();
                    g1.m((g1) l10.f3641p, str2);
                    g1 g1Var = (g1) l10.a();
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(hashSet);
                    b1 l11 = c1.l();
                    l11.c();
                    c1.n((c1) l11.f3641p, arrayList);
                    l11.c();
                    c1.m((c1) l11.f3641p, g1Var);
                    c1 c1Var = (c1) l11.a();
                    m1 m10 = n1.m();
                    m10.c();
                    n1.s((n1) m10.f3641p, c1Var);
                    y1Var.f3594a.a((n1) m10.a(), 243);
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    if (!hashSet2.equals(hashSet)) {
                        hashSet2.clear();
                        hashSet2.addAll(hashSet);
                        Iterator it = hashSet2.iterator();
                        while (it.hasNext()) {
                            String num = Integer.toString(((z0) it.next()).f3634o);
                            String l12 = r.a.l("feature_usage_timestamp_reported_feature_", num);
                            if (!sharedPreferences.contains(l12)) {
                                l12 = r.a.l("feature_usage_timestamp_detected_feature_", num);
                            }
                            String l13 = r.a.l("feature_usage_timestamp_reported_feature_", num);
                            if (!TextUtils.equals(l12, l13)) {
                                long j12 = sharedPreferences.getLong(l12, 0L);
                                edit.remove(l12);
                                if (j12 != 0) {
                                    edit.putLong(l13, j12);
                                }
                            }
                        }
                    }
                    y1Var.f3600h = currentTimeMillis;
                    edit.putLong("feature_usage_last_report_time", currentTimeMillis).apply();
                    return;
                }
                return;
        }
    }
}
