package d;

import android.os.Handler;
import android.os.Looper;
import android.view.accessibility.AccessibilityNodeInfo;
import e6.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f3947b;

    /* renamed from: a, reason: collision with root package name */
    public final Object f3948a;

    public /* synthetic */ a(Object obj) {
        this.f3948a = obj;
    }

    public static a a(boolean z10, int i10, int i11, int i12, int i13) {
        return new a(AccessibilityNodeInfo.CollectionItemInfo.obtain(i10, i11, i12, i13, false, z10));
    }

    public void b() {
        synchronized (this.f3948a) {
        }
    }

    public a() {
        this.f3948a = new Object();
        new Handler(Looper.getMainLooper(), new h(1, this));
    }
}
