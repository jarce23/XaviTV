package androidx.activity;

import android.window.OnBackInvokedCallback;
import f.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class s implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f351a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f352b;

    public /* synthetic */ s(int i10, Object obj) {
        this.f351a = i10;
        this.f352b = obj;
    }

    public final void onBackInvoked() {
        switch (this.f351a) {
            case 0:
                ((ya.a) this.f352b).invoke();
                break;
            case 1:
                ((b0) this.f352b).D();
                break;
            default:
                ((Runnable) this.f352b).run();
                break;
        }
    }
}
