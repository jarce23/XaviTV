package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements ComponentCallbacks2 {

    /* renamed from: v, reason: collision with root package name */
    public static volatile b f2986v;

    /* renamed from: w, reason: collision with root package name */
    public static volatile boolean f2987w;

    /* renamed from: o, reason: collision with root package name */
    public final u5.a f2988o;

    /* renamed from: p, reason: collision with root package name */
    public final v5.c f2989p;

    /* renamed from: q, reason: collision with root package name */
    public final g f2990q;

    /* renamed from: r, reason: collision with root package name */
    public final u5.f f2991r;

    /* renamed from: s, reason: collision with root package name */
    public final com.bumptech.glide.manager.k f2992s;

    /* renamed from: t, reason: collision with root package name */
    public final d9.f f2993t;

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f2994u = new ArrayList();

    public b(Context context, t5.k kVar, v5.c cVar, u5.a aVar, u5.f fVar, com.bumptech.glide.manager.k kVar2, d9.f fVar2, int i10, n7.i iVar, p.e eVar, List list, List list2, x4.f fVar3, a6.n nVar) {
        this.f2988o = aVar;
        this.f2991r = fVar;
        this.f2989p = cVar;
        this.f2992s = kVar2;
        this.f2993t = fVar2;
        this.f2990q = new g(context, fVar, new c4.e(this, list2, fVar3), new n7.i(26), iVar, eVar, list, kVar, nVar, i10);
    }

    public static b a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (f2986v == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) GeneratedAppGlideModuleImpl.class.getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e7);
            } catch (InstantiationException e8) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e8);
            } catch (NoSuchMethodException e10) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", e11);
            }
            synchronized (b.class) {
                if (f2986v == null) {
                    if (f2987w) {
                        throw new IllegalStateException("Glide has been called recursively, this is probably an internal library error!");
                    }
                    f2987w = true;
                    try {
                        c(context, generatedAppGlideModule);
                        f2987w = false;
                    } catch (Throwable th) {
                        f2987w = false;
                        throw th;
                    }
                }
            }
        }
        return f2986v;
    }

    public static com.bumptech.glide.manager.k b(Context context) {
        m6.f.c("You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).", context);
        return a(context).f2992s;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x014e A[LOOP:3: B:62:0x014c->B:63:0x014e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0181  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void c(android.content.Context r31, com.bumptech.glide.GeneratedAppGlideModule r32) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.b.c(android.content.Context, com.bumptech.glide.GeneratedAppGlideModule):void");
    }

    public static o e(Context context) {
        return b(context).b(context);
    }

    public final void d(o oVar) {
        synchronized (this.f2994u) {
            try {
                if (!this.f2994u.contains(oVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.f2994u.remove(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
        m6.n.a();
        this.f2989p.f(0L);
        this.f2988o.m();
        this.f2991r.a();
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i10) {
        m6.n.a();
        synchronized (this.f2994u) {
            try {
                ArrayList arrayList = this.f2994u;
                int size = arrayList.size();
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList.get(i11);
                    i11++;
                    ((o) obj).getClass();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f2989p.g(i10);
        this.f2988o.k(i10);
        this.f2991r.i(i10);
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }
}
