package s6;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static volatile j f11625e;

    /* renamed from: a, reason: collision with root package name */
    public final c7.a f11626a;

    /* renamed from: b, reason: collision with root package name */
    public final c7.a f11627b;

    /* renamed from: c, reason: collision with root package name */
    public final y6.b f11628c;

    /* renamed from: d, reason: collision with root package name */
    public final j9.n f11629d;

    public o(c7.a aVar, c7.a aVar2, y6.b bVar, j9.n nVar, x4.i iVar) {
        this.f11626a = aVar;
        this.f11627b = aVar2;
        this.f11628c = bVar;
        this.f11629d = nVar;
        ((Executor) iVar.f13553p).execute(new w1.o(5, iVar));
    }

    public static o a() {
        j jVar = f11625e;
        if (jVar != null) {
            return (o) jVar.f11618s.get();
        }
        throw new IllegalStateException("Not initialized!");
    }

    public static void b(Context context) {
        if (f11625e == null) {
            synchronized (o.class) {
                try {
                    if (f11625e == null) {
                        androidx.emoji2.text.o oVar = new androidx.emoji2.text.o();
                        context.getClass();
                        oVar.f591o = context;
                        f11625e = oVar.b();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
