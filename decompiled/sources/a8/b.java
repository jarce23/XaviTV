package a8;

import android.content.Context;
import java.util.concurrent.Callable;
import o5.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f149a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f150b;

    public /* synthetic */ b(int i10, Object obj) {
        this.f149a = i10;
        this.f150b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f149a) {
            case 0:
                return ((Context) this.f150b).getSharedPreferences("google_sdk_flags", 0);
            default:
                synchronized (((c) this.f150b)) {
                    try {
                        c cVar = (c) this.f150b;
                        if (cVar.f9535w == null) {
                            return null;
                        }
                        cVar.T();
                        if (((c) this.f150b).M()) {
                            ((c) this.f150b).R();
                            ((c) this.f150b).f9537y = 0;
                        }
                        return null;
                    } finally {
                    }
                }
        }
    }
}
