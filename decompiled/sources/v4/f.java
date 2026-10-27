package v4;

import android.content.Context;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final x4.i f12667a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12668b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f12669c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f12670d;

    /* renamed from: e, reason: collision with root package name */
    public Object f12671e;

    public f(Context context, x4.i iVar) {
        this.f12667a = iVar;
        Context applicationContext = context.getApplicationContext();
        za.h.d("context.applicationContext", applicationContext);
        this.f12668b = applicationContext;
        this.f12669c = new Object();
        this.f12670d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.f12669c) {
            Object obj2 = this.f12671e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.f12671e = obj;
                ((a5.a) this.f12667a.f13556s).execute(new androidx.fragment.app.d(ma.j.J(this.f12670d), 27, this));
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
