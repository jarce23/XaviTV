package w3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l extends m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12953a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public Executor f12954b;

    /* renamed from: c, reason: collision with root package name */
    public s f12955c;

    /* renamed from: d, reason: collision with root package name */
    public i f12956d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f12957e;

    public String j() {
        return null;
    }

    public String k() {
        return null;
    }

    public final void l(i iVar, ArrayList arrayList) {
        if (iVar == null) {
            throw new NullPointerException("groupRoute must not be null");
        }
        synchronized (this.f12953a) {
            try {
                try {
                    Executor executor = this.f12954b;
                    if (executor != null) {
                        executor.execute(new com.google.android.gms.internal.cast.o(this, this.f12955c, iVar, arrayList, 3));
                    } else {
                        this.f12956d = iVar;
                        this.f12957e = new ArrayList(arrayList);
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public abstract void m(String str);

    public abstract void n(String str);

    public abstract void o(List list);
}
