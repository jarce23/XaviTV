package androidx.activity;

import android.window.OnBackInvokedCallback;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public static final v f358a = new v();

    public final OnBackInvokedCallback a(ya.l lVar, ya.l lVar2, ya.a aVar, ya.a aVar2) {
        za.h.e("onBackStarted", lVar);
        za.h.e("onBackProgressed", lVar2);
        za.h.e("onBackInvoked", aVar);
        za.h.e("onBackCancelled", aVar2);
        return new u(lVar, lVar2, aVar, aVar2);
    }
}
