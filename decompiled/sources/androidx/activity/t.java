package androidx.activity;

import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f353a = new t();

    public final OnBackInvokedCallback a(ya.a aVar) {
        za.h.e("onBackInvoked", aVar);
        return new s(0, aVar);
    }

    public final void b(Object obj, int i10, Object obj2) {
        za.h.e("dispatcher", obj);
        za.h.e("callback", obj2);
        ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) obj2);
    }

    public final void c(Object obj, Object obj2) {
        za.h.e("dispatcher", obj);
        za.h.e("callback", obj2);
        ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
    }
}
