package androidx.leanback.widget;

import android.graphics.Color;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public float f1001a;

    /* renamed from: b, reason: collision with root package name */
    public int f1002b;

    /* renamed from: c, reason: collision with root package name */
    public float f1003c;

    /* renamed from: d, reason: collision with root package name */
    public float f1004d;

    /* renamed from: e, reason: collision with root package name */
    public float f1005e;

    /* renamed from: f, reason: collision with root package name */
    public float f1006f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public float f1007h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public float f1008i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ PagingIndicator f1009j;

    public a0(PagingIndicator pagingIndicator) {
        this.f1009j = pagingIndicator;
        this.f1008i = pagingIndicator.f925o ? 1.0f : -1.0f;
    }

    public final void a() {
        int round = Math.round(this.f1001a * 255.0f);
        PagingIndicator pagingIndicator = this.f1009j;
        this.f1002b = Color.argb(round, Color.red(pagingIndicator.D), Color.green(pagingIndicator.D), Color.blue(pagingIndicator.D));
    }

    public final void b() {
        this.f1003c = 0.0f;
        this.f1004d = 0.0f;
        PagingIndicator pagingIndicator = this.f1009j;
        this.f1005e = pagingIndicator.f926p;
        float f10 = pagingIndicator.f927q;
        this.f1006f = f10;
        this.g = f10 * pagingIndicator.J;
        this.f1001a = 0.0f;
        a();
    }
}
