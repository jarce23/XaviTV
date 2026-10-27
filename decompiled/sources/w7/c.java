package w7;

import android.content.Context;
import androidx.emoji2.text.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name */
    public static final c f13139b;

    /* renamed from: a, reason: collision with root package name */
    public o f13140a;

    static {
        c cVar = new c();
        cVar.f13140a = null;
        f13139b = cVar;
    }

    public static o a(Context context) {
        o oVar;
        c cVar = f13139b;
        synchronized (cVar) {
            try {
                if (cVar.f13140a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cVar.f13140a = new o(context, false);
                }
                oVar = cVar.f13140a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return oVar;
    }
}
