package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends ContextWrapper {

    /* renamed from: k, reason: collision with root package name */
    public static final a f3007k;

    /* renamed from: a, reason: collision with root package name */
    public final u5.f f3008a;

    /* renamed from: b, reason: collision with root package name */
    public final c.a f3009b;

    /* renamed from: c, reason: collision with root package name */
    public final n7.i f3010c;

    /* renamed from: d, reason: collision with root package name */
    public final n7.i f3011d;

    /* renamed from: e, reason: collision with root package name */
    public final List f3012e;

    /* renamed from: f, reason: collision with root package name */
    public final p.e f3013f;
    public final t5.k g;

    /* renamed from: h, reason: collision with root package name */
    public final a6.n f3014h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3015i;

    /* renamed from: j, reason: collision with root package name */
    public i6.e f3016j;

    static {
        a aVar = new a();
        aVar.f2985o = k6.b.f7829a;
        f3007k = aVar;
    }

    public g(Context context, u5.f fVar, c4.e eVar, n7.i iVar, n7.i iVar2, p.e eVar2, List list, t5.k kVar, a6.n nVar, int i10) {
        super(context.getApplicationContext());
        this.f3008a = fVar;
        this.f3010c = iVar;
        this.f3011d = iVar2;
        this.f3012e = list;
        this.f3013f = eVar2;
        this.g = kVar;
        this.f3014h = nVar;
        this.f3015i = i10;
        this.f3009b = new c.a(2, eVar);
    }

    public final synchronized i6.e a() {
        try {
            if (this.f3016j == null) {
                this.f3011d.getClass();
                i6.e eVar = new i6.e();
                eVar.B = true;
                this.f3016j = eVar;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f3016j;
    }

    public final k b() {
        return (k) this.f3009b.get();
    }
}
