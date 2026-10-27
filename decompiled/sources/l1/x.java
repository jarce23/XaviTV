package l1;

import android.os.Handler;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f8137b = new ArrayList(50);

    /* renamed from: a, reason: collision with root package name */
    public final Handler f8138a;

    public x(Handler handler) {
        this.f8138a = handler;
    }

    public static w b() {
        w wVar;
        ArrayList arrayList = f8137b;
        synchronized (arrayList) {
            try {
                wVar = arrayList.isEmpty() ? new w() : (w) arrayList.remove(arrayList.size() - 1);
            } catch (Throwable th) {
                throw th;
            }
        }
        return wVar;
    }

    public final w a(int i10, Object obj) {
        w b2 = b();
        b2.f8136a = this.f8138a.obtainMessage(i10, obj);
        return b2;
    }

    public final boolean c(Runnable runnable) {
        return this.f8138a.post(runnable);
    }

    public final void d(int i10) {
        d.b(i10 != 0);
        this.f8138a.removeMessages(i10);
    }

    public final boolean e(int i10) {
        return this.f8138a.sendEmptyMessage(i10);
    }
}
