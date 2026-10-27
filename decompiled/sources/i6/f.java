package i6;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.i;
import f.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m6.h;
import m6.n;
import okhttp3.internal.url._UrlKt;
import t5.j;
import t5.k;
import t5.o;
import t5.u;
import t5.y;
import x4.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements c, j6.b {
    public static final boolean C = Log.isLoggable("GlideRequest", 2);
    public final RuntimeException A;
    public int B;

    /* renamed from: a, reason: collision with root package name */
    public final String f6428a;

    /* renamed from: b, reason: collision with root package name */
    public final n6.d f6429b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6430c;

    /* renamed from: d, reason: collision with root package name */
    public final d f6431d;

    /* renamed from: e, reason: collision with root package name */
    public final Context f6432e;

    /* renamed from: f, reason: collision with root package name */
    public final com.bumptech.glide.g f6433f;
    public final Object g;

    /* renamed from: h, reason: collision with root package name */
    public final Class f6434h;

    /* renamed from: i, reason: collision with root package name */
    public final a f6435i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6436j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6437k;

    /* renamed from: l, reason: collision with root package name */
    public final i f6438l;

    /* renamed from: m, reason: collision with root package name */
    public final j6.c f6439m;

    /* renamed from: n, reason: collision with root package name */
    public final List f6440n;

    /* renamed from: o, reason: collision with root package name */
    public final k6.a f6441o;

    /* renamed from: p, reason: collision with root package name */
    public final p f6442p;

    /* renamed from: q, reason: collision with root package name */
    public y f6443q;

    /* renamed from: r, reason: collision with root package name */
    public m f6444r;

    /* renamed from: s, reason: collision with root package name */
    public long f6445s;

    /* renamed from: t, reason: collision with root package name */
    public volatile k f6446t;

    /* renamed from: u, reason: collision with root package name */
    public Drawable f6447u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f6448v;

    /* renamed from: w, reason: collision with root package name */
    public Drawable f6449w;

    /* renamed from: x, reason: collision with root package name */
    public int f6450x;

    /* renamed from: y, reason: collision with root package name */
    public int f6451y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f6452z;

    public f(Context context, com.bumptech.glide.g gVar, Object obj, Object obj2, Class cls, a aVar, int i10, int i11, i iVar, j6.c cVar, ArrayList arrayList, d dVar, k kVar, k6.a aVar2) {
        p pVar = m6.f.f9013a;
        this.f6428a = C ? String.valueOf(hashCode()) : null;
        this.f6429b = new n6.d();
        this.f6430c = obj;
        this.f6432e = context;
        this.f6433f = gVar;
        this.g = obj2;
        this.f6434h = cls;
        this.f6435i = aVar;
        this.f6436j = i10;
        this.f6437k = i11;
        this.f6438l = iVar;
        this.f6439m = cVar;
        this.f6440n = arrayList;
        this.f6431d = dVar;
        this.f6446t = kVar;
        this.f6441o = aVar2;
        this.f6442p = pVar;
        this.B = 1;
        if (this.A == null && ((Map) gVar.f3014h.f74p).containsKey(com.bumptech.glide.d.class)) {
            this.A = new RuntimeException("Glide request origin trace");
        }
    }

    @Override // i6.c
    public final boolean a() {
        boolean z10;
        synchronized (this.f6430c) {
            z10 = this.B == 4;
        }
        return z10;
    }

    public final void b() {
        if (this.f6452z) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
        this.f6429b.a();
        this.f6439m.c(this);
        m mVar = this.f6444r;
        if (mVar != null) {
            synchronized (((k) mVar.f13566r)) {
                ((o) mVar.f13564p).j((f) mVar.f13565q);
            }
            this.f6444r = null;
        }
    }

    public final Drawable c() {
        if (this.f6448v == null) {
            a aVar = this.f6435i;
            aVar.getClass();
            this.f6448v = null;
            int i10 = aVar.f6414s;
            if (i10 > 0) {
                Resources.Theme theme = aVar.C;
                Context context = this.f6432e;
                if (theme == null) {
                    theme = context.getTheme();
                }
                this.f6448v = a.a.l(context, context, i10, theme);
            }
        }
        return this.f6448v;
    }

    @Override // i6.c
    public final void clear() {
        synchronized (this.f6430c) {
            try {
                if (this.f6452z) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f6429b.a();
                if (this.B == 6) {
                    return;
                }
                b();
                y yVar = this.f6443q;
                if (yVar != null) {
                    this.f6443q = null;
                } else {
                    yVar = null;
                }
                d dVar = this.f6431d;
                if (dVar == null || dVar.d(this)) {
                    this.f6439m.g(c());
                }
                this.B = 6;
                if (yVar != null) {
                    this.f6446t.getClass();
                    k.g(yVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(String str) {
        StringBuilder a10 = s.e.a(str, " this: ");
        a10.append(this.f6428a);
        Log.v("GlideRequest", a10.toString());
    }

    @Override // i6.c
    public final boolean e() {
        boolean z10;
        synchronized (this.f6430c) {
            z10 = this.B == 6;
        }
        return z10;
    }

    public final void f(u uVar, int i10) {
        Drawable drawable;
        this.f6429b.a();
        synchronized (this.f6430c) {
            try {
                uVar.getClass();
                int i11 = this.f6433f.f3015i;
                if (i11 <= i10) {
                    Log.w("Glide", "Load failed for [" + this.g + "] with dimensions [" + this.f6450x + "x" + this.f6451y + "]", uVar);
                    if (i11 <= 4) {
                        uVar.d();
                    }
                }
                this.f6444r = null;
                this.B = 5;
                d dVar = this.f6431d;
                if (dVar != null) {
                    dVar.h(this);
                }
                boolean z10 = true;
                this.f6452z = true;
                try {
                    List<k5.f> list = this.f6440n;
                    if (list != null) {
                        for (k5.f fVar : list) {
                            d dVar2 = this.f6431d;
                            if (dVar2 != null) {
                                dVar2.getRoot().a();
                            }
                            fVar.f7824a.setVisibility(0);
                            fVar.f7825b.setVisibility(0);
                        }
                    }
                    d dVar3 = this.f6431d;
                    if (dVar3 != null && !dVar3.b(this)) {
                        z10 = false;
                    }
                    if (this.g == null) {
                        if (this.f6449w == null) {
                            this.f6435i.getClass();
                            this.f6449w = null;
                        }
                        drawable = this.f6449w;
                    } else {
                        drawable = null;
                    }
                    if (drawable == null) {
                        if (this.f6447u == null) {
                            a aVar = this.f6435i;
                            aVar.getClass();
                            this.f6447u = null;
                            int i12 = aVar.f6413r;
                            if (i12 > 0) {
                                Context context = this.f6432e;
                                Resources.Theme theme = this.f6435i.C;
                                if (theme == null) {
                                    theme = context.getTheme();
                                }
                                this.f6447u = a.a.l(context, context, i12, theme);
                            }
                        }
                        drawable = this.f6447u;
                    }
                    if (drawable == null) {
                        drawable = c();
                    }
                    this.f6439m.a(drawable);
                } finally {
                    this.f6452z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // i6.c
    public final void g() {
        synchronized (this.f6430c) {
            try {
                if (this.f6452z) {
                    throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
                }
                this.f6429b.a();
                int i10 = h.f9016b;
                this.f6445s = SystemClock.elapsedRealtimeNanos();
                if (this.g == null) {
                    if (n.i(this.f6436j, this.f6437k)) {
                        this.f6450x = this.f6436j;
                        this.f6451y = this.f6437k;
                    }
                    if (this.f6449w == null) {
                        this.f6435i.getClass();
                        this.f6449w = null;
                    }
                    f(new u("Received null model"), this.f6449w == null ? 5 : 3);
                    return;
                }
                int i11 = this.B;
                if (i11 == 2) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                }
                if (i11 == 4) {
                    h(this.f6443q, 5, false);
                    return;
                }
                List<k5.f> list = this.f6440n;
                if (list != null) {
                    for (k5.f fVar : list) {
                    }
                }
                this.B = 3;
                if (n.i(this.f6436j, this.f6437k)) {
                    l(this.f6436j, this.f6437k);
                } else {
                    this.f6439m.e(this);
                }
                int i12 = this.B;
                if (i12 == 2 || i12 == 3) {
                    d dVar = this.f6431d;
                    if (dVar == null || dVar.b(this)) {
                        this.f6439m.d(c());
                    }
                }
                if (C) {
                    d("finished run method in " + h.a(this.f6445s));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h(y yVar, int i10, boolean z10) {
        this.f6429b.a();
        y yVar2 = null;
        try {
            synchronized (this.f6430c) {
                try {
                    this.f6444r = null;
                    if (yVar == null) {
                        f(new u("Expected to receive a Resource<R> with an object of " + this.f6434h + " inside, but instead got null."), 5);
                        return;
                    }
                    Object obj = yVar.get();
                    try {
                        if (obj != null && this.f6434h.isAssignableFrom(obj.getClass())) {
                            d dVar = this.f6431d;
                            if (dVar == null || dVar.c(this)) {
                                k(yVar, obj, i10);
                                return;
                            }
                            this.f6443q = null;
                            this.B = 4;
                            this.f6446t.getClass();
                            k.g(yVar);
                        }
                        this.f6443q = null;
                        StringBuilder sb2 = new StringBuilder("Expected to receive an object of ");
                        sb2.append(this.f6434h);
                        sb2.append(" but instead got ");
                        sb2.append(obj != null ? obj.getClass() : _UrlKt.FRAGMENT_ENCODE_SET);
                        sb2.append("{");
                        sb2.append(obj);
                        sb2.append("} inside Resource{");
                        sb2.append(yVar);
                        sb2.append("}.");
                        sb2.append(obj != null ? _UrlKt.FRAGMENT_ENCODE_SET : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        f(new u(sb2.toString()), 5);
                        this.f6446t.getClass();
                        k.g(yVar);
                    } catch (Throwable th) {
                        yVar2 = yVar;
                        th = th;
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            if (yVar2 != null) {
                this.f6446t.getClass();
                k.g(yVar2);
            }
            throw th3;
        }
    }

    @Override // i6.c
    public final boolean i() {
        boolean z10;
        synchronized (this.f6430c) {
            z10 = this.B == 4;
        }
        return z10;
    }

    @Override // i6.c
    public final boolean isRunning() {
        boolean z10;
        synchronized (this.f6430c) {
            int i10 = this.B;
            z10 = i10 == 2 || i10 == 3;
        }
        return z10;
    }

    @Override // i6.c
    public final boolean j(c cVar) {
        int i10;
        int i11;
        Object obj;
        Class cls;
        a aVar;
        i iVar;
        int size;
        int i12;
        int i13;
        Object obj2;
        Class cls2;
        a aVar2;
        i iVar2;
        int size2;
        if (!(cVar instanceof f)) {
            return false;
        }
        synchronized (this.f6430c) {
            try {
                i10 = this.f6436j;
                i11 = this.f6437k;
                obj = this.g;
                cls = this.f6434h;
                aVar = this.f6435i;
                iVar = this.f6438l;
                List list = this.f6440n;
                size = list != null ? list.size() : 0;
            } finally {
            }
        }
        f fVar = (f) cVar;
        synchronized (fVar.f6430c) {
            try {
                i12 = fVar.f6436j;
                i13 = fVar.f6437k;
                obj2 = fVar.g;
                cls2 = fVar.f6434h;
                aVar2 = fVar.f6435i;
                iVar2 = fVar.f6438l;
                List list2 = fVar.f6440n;
                size2 = list2 != null ? list2.size() : 0;
            } finally {
            }
        }
        if (i10 == i12 && i11 == i13) {
            char[] cArr = n.f9027a;
            if ((obj == null ? obj2 == null : obj.equals(obj2)) && cls.equals(cls2)) {
                if ((aVar == null ? aVar2 == null : aVar.h(aVar2)) && iVar == iVar2 && size == size2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void k(y yVar, Object obj, int i10) {
        d dVar = this.f6431d;
        if (dVar != null) {
            dVar.getRoot().a();
        }
        this.B = 4;
        this.f6443q = yVar;
        if (this.f6433f.f3015i <= 3) {
            Log.d("Glide", "Finished loading " + obj.getClass().getSimpleName() + " from " + r.a.n(i10) + " for " + this.g + " with size [" + this.f6450x + "x" + this.f6451y + "] in " + h.a(this.f6445s) + " ms");
        }
        if (dVar != null) {
            dVar.f(this);
        }
        this.f6452z = true;
        try {
            List<k5.f> list = this.f6440n;
            if (list != null) {
                for (k5.f fVar : list) {
                    fVar.getClass();
                    fVar.f7825b.setVisibility(0);
                    fVar.f7824a.setVisibility(8);
                }
            }
            this.f6441o.getClass();
            this.f6439m.h(obj);
            this.f6452z = false;
        } catch (Throwable th) {
            this.f6452z = false;
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l(int i10, int i11) {
        f fVar = this;
        int i12 = i10;
        fVar.f6429b.a();
        Object obj = fVar.f6430c;
        synchronized (obj) {
            try {
                try {
                    boolean z10 = C;
                    if (z10) {
                        fVar.d("Got onSizeReady in " + h.a(fVar.f6445s));
                    }
                    if (fVar.B == 3) {
                        fVar.B = 2;
                        fVar.f6435i.getClass();
                        if (i12 != Integer.MIN_VALUE) {
                            i12 = Math.round(i12 * 1.0f);
                        }
                        fVar.f6450x = i12;
                        fVar.f6451y = i11 == Integer.MIN_VALUE ? i11 : Math.round(1.0f * i11);
                        if (z10) {
                            fVar.d("finished setup for calling load in " + h.a(fVar.f6445s));
                        }
                        k kVar = fVar.f6446t;
                        com.bumptech.glide.g gVar = fVar.f6433f;
                        Object obj2 = fVar.g;
                        a aVar = fVar.f6435i;
                        r5.e eVar = aVar.f6418w;
                        try {
                            int i13 = fVar.f6450x;
                            int i14 = fVar.f6451y;
                            Class cls = aVar.A;
                            try {
                                Class cls2 = fVar.f6434h;
                                i iVar = fVar.f6438l;
                                j jVar = aVar.f6411p;
                                try {
                                    m6.c cVar = aVar.f6421z;
                                    boolean z11 = aVar.f6419x;
                                    boolean z12 = aVar.E;
                                    try {
                                        r5.h hVar = aVar.f6420y;
                                        boolean z13 = aVar.f6415t;
                                        boolean z14 = aVar.F;
                                        p pVar = fVar.f6442p;
                                        fVar = obj;
                                        try {
                                            fVar.f6444r = kVar.a(gVar, obj2, eVar, i13, i14, cls, cls2, iVar, jVar, cVar, z11, z12, hVar, z13, z14, fVar, pVar);
                                            if (fVar.B != 2) {
                                                fVar.f6444r = null;
                                            }
                                            if (z10) {
                                                fVar.d("finished onSizeReady in " + h.a(fVar.f6445s));
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            throw th;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        fVar = obj;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    fVar = obj;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                fVar = obj;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fVar = obj;
                        }
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Throwable th7) {
                th = th7;
                fVar = obj;
            }
        }
    }

    @Override // i6.c
    public final void pause() {
        synchronized (this.f6430c) {
            try {
                if (isRunning()) {
                    clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        Object obj;
        Class cls;
        synchronized (this.f6430c) {
            obj = this.g;
            cls = this.f6434h;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }
}
