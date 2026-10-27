package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements k {

    /* renamed from: o, reason: collision with root package name */
    public final Context f602o;

    /* renamed from: p, reason: collision with root package name */
    public final j0.d f603p;

    /* renamed from: q, reason: collision with root package name */
    public final n7.i f604q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f605r = new Object();

    /* renamed from: s, reason: collision with root package name */
    public Handler f606s;

    /* renamed from: t, reason: collision with root package name */
    public ThreadPoolExecutor f607t;

    /* renamed from: u, reason: collision with root package name */
    public ThreadPoolExecutor f608u;

    /* renamed from: v, reason: collision with root package name */
    public j1.c f609v;

    public u(Context context, j0.d dVar) {
        y7.d.d("Context cannot be null", context);
        this.f602o = context.getApplicationContext();
        this.f603p = dVar;
        this.f604q = v.f610d;
    }

    @Override // androidx.emoji2.text.k
    public final void a(j1.c cVar) {
        synchronized (this.f605r) {
            this.f609v = cVar;
        }
        c();
    }

    public final void b() {
        synchronized (this.f605r) {
            try {
                this.f609v = null;
                Handler handler = this.f606s;
                if (handler != null) {
                    handler.removeCallbacks(null);
                }
                this.f606s = null;
                ThreadPoolExecutor threadPoolExecutor = this.f608u;
                if (threadPoolExecutor != null) {
                    threadPoolExecutor.shutdown();
                }
                this.f607t = null;
                this.f608u = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void c() {
        synchronized (this.f605r) {
            try {
                if (this.f609v == null) {
                    return;
                }
                if (this.f607t == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("emojiCompat", 0));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    this.f608u = threadPoolExecutor;
                    this.f607t = threadPoolExecutor;
                }
                this.f607t.execute(new androidx.activity.d(3, this));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final j0.j d() {
        try {
            n7.i iVar = this.f604q;
            Context context = this.f602o;
            j0.d dVar = this.f603p;
            iVar.getClass();
            Object[] objArr = {dVar};
            ArrayList arrayList = new ArrayList(1);
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            arrayList.add(obj);
            j0.i a10 = j0.c.a(context, Collections.unmodifiableList(arrayList));
            int i10 = a10.f6928a;
            if (i10 != 0) {
                throw new RuntimeException(android.support.v4.media.d.o("fetchFonts failed (", i10, ")"));
            }
            j0.j[] jVarArr = (j0.j[]) a10.f6929b.get(0);
            if (jVarArr == null || jVarArr.length == 0) {
                throw new RuntimeException("fetchFonts failed (empty result)");
            }
            return jVarArr[0];
        } catch (PackageManager.NameNotFoundException e7) {
            throw new RuntimeException("provider not found", e7);
        }
    }
}
