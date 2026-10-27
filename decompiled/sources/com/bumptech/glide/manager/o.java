package com.bumptech.glide.manager;

import androidx.media3.ui.AspectRatioFrameLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f3079o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f3080p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f3081q;

    public /* synthetic */ o(Object obj, boolean z10, int i10) {
        this.f3079o = i10;
        this.f3081q = obj;
        this.f3080p = z10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = this.f3079o;
        Object obj = this.f3081q;
        switch (i10) {
            case 0:
                boolean z10 = this.f3080p;
                m6.n.a();
                c4.e eVar = (c4.e) ((p) obj).f3083b;
                boolean z11 = eVar.f2875o;
                eVar.f2875o = z10;
                if (z11 != z10) {
                    ((m) eVar.f2876p).a(z10);
                    break;
                }
                break;
            case 1:
                ((s) obj).f3090p.a(this.f3080p);
                break;
            default:
                this.f3080p = false;
                int i11 = AspectRatioFrameLayout.f1200r;
                ((AspectRatioFrameLayout) obj).getClass();
                break;
        }
    }

    public o(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f3079o = 2;
        this.f3081q = aspectRatioFrameLayout;
    }
}
