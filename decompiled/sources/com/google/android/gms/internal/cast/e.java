package com.google.android.gms.internal.cast;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f3295a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3296b;

    /* renamed from: c, reason: collision with root package name */
    public final h7.a0 f3297c;

    /* renamed from: d, reason: collision with root package name */
    public final h7.c f3298d;

    /* renamed from: e, reason: collision with root package name */
    public final q f3299e;

    public e(Context context, h7.c cVar, q qVar) {
        String o2;
        ArrayList arrayList = cVar.f5713p;
        String str = cVar.f5712o;
        if (Collections.unmodifiableList(arrayList).isEmpty()) {
            o2 = g7.y.a(str);
        } else {
            List unmodifiableList = Collections.unmodifiableList(cVar.f5713p);
            if (str == null) {
                throw new IllegalArgumentException("applicationId cannot be null");
            }
            if (unmodifiableList == null) {
                throw new IllegalArgumentException("namespaces cannot be null");
            }
            o2 = x4.r.o(new x4.r(str, 6, unmodifiableList));
        }
        this.f3297c = new h7.a0(this);
        this.f3295a = context.getApplicationContext();
        r7.r.c(o2);
        this.f3296b = o2;
        this.f3298d = cVar;
        this.f3299e = qVar;
    }
}
