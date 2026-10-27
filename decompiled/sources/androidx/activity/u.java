package androidx.activity;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements OnBackAnimationCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ya.l f354a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ya.l f355b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ya.a f356c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ya.a f357d;

    public u(ya.l lVar, ya.l lVar2, ya.a aVar, ya.a aVar2) {
        this.f354a = lVar;
        this.f355b = lVar2;
        this.f356c = aVar;
        this.f357d = aVar2;
    }

    public final void onBackCancelled() {
        this.f357d.invoke();
    }

    public final void onBackInvoked() {
        this.f356c.invoke();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        za.h.e("backEvent", backEvent);
        this.f355b.invoke(new b(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        za.h.e("backEvent", backEvent);
        this.f354a.invoke(new b(backEvent));
    }
}
