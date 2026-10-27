package com.bumptech.glide;

import android.support.v4.media.session.a0;
import j9.v1;
import j9.w1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import x5.t;
import x5.u;
import x5.v;
import x5.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final w f3023a;

    /* renamed from: b, reason: collision with root package name */
    public final e2.d f3024b;

    /* renamed from: c, reason: collision with root package name */
    public final x4.e f3025c;

    /* renamed from: d, reason: collision with root package name */
    public final e2.d f3026d;

    /* renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.load.data.g f3027e;

    /* renamed from: f, reason: collision with root package name */
    public final e2.d f3028f;
    public final e2.d g;

    /* renamed from: h, reason: collision with root package name */
    public final x4.c f3029h = new x4.c(7);

    /* renamed from: i, reason: collision with root package name */
    public final h6.b f3030i = new h6.b();

    /* renamed from: j, reason: collision with root package name */
    public final a0 f3031j;

    public k() {
        int i10 = 7;
        a0 a0Var = new a0(new l0.e(20), new v1(i10), new w1(i10), 15, false);
        this.f3031j = a0Var;
        this.f3023a = new w(a0Var);
        this.f3024b = new e2.d(2);
        this.f3025c = new x4.e(7);
        this.f3026d = new e2.d(4);
        this.f3027e = new com.bumptech.glide.load.data.g();
        this.f3028f = new e2.d(1);
        this.g = new e2.d(3);
        List asList = Arrays.asList("Animation", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.add("legacy_prepend_all");
        Iterator it = asList.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        arrayList.add("legacy_append");
        x4.e eVar = this.f3025c;
        synchronized (eVar) {
            try {
                ArrayList arrayList2 = new ArrayList((ArrayList) eVar.f13542p);
                ((ArrayList) eVar.f13542p).clear();
                int size = arrayList.size();
                int i11 = 0;
                int i12 = 0;
                while (i12 < size) {
                    Object obj = arrayList.get(i12);
                    i12++;
                    ((ArrayList) eVar.f13542p).add((String) obj);
                }
                int size2 = arrayList2.size();
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    String str = (String) obj2;
                    if (!arrayList.contains(str)) {
                        ((ArrayList) eVar.f13542p).add(str);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void a(Class cls, Class cls2, u uVar) {
        w wVar = this.f3023a;
        synchronized (wVar) {
            wVar.f13668a.a(cls, cls2, uVar);
            wVar.f13669b.f3017a.clear();
        }
    }

    public final void b(Class cls, r5.b bVar) {
        e2.d dVar = this.f3024b;
        synchronized (dVar) {
            dVar.f4413a.add(new h6.a(cls, bVar));
        }
    }

    public final void c(Class cls, r5.k kVar) {
        e2.d dVar = this.f3026d;
        synchronized (dVar) {
            dVar.f4413a.add(new h6.d(cls, kVar));
        }
    }

    public final void d(String str, Class cls, Class cls2, r5.j jVar) {
        x4.e eVar = this.f3025c;
        synchronized (eVar) {
            eVar.i(str).add(new h6.c(cls, cls2, jVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ArrayList e(Class cls, Class cls2, Class cls3) {
        ArrayList arrayList;
        Class cls4 = cls;
        ArrayList arrayList2 = new ArrayList();
        ArrayList j10 = this.f3025c.j(cls4, cls2);
        int size = j10.size();
        int i10 = 0;
        while (i10 < size) {
            int i11 = i10 + 1;
            Class cls5 = (Class) j10.get(i10);
            ArrayList j11 = this.f3028f.j(cls5, cls3);
            int size2 = j11.size();
            int i12 = 0;
            while (i12 < size2) {
                int i13 = i12 + 1;
                Class cls6 = (Class) j11.get(i12);
                x4.e eVar = this.f3025c;
                synchronized (eVar) {
                    arrayList = new ArrayList();
                    ArrayList arrayList3 = (ArrayList) eVar.f13542p;
                    int size3 = arrayList3.size();
                    int i14 = 0;
                    while (i14 < size3) {
                        Object obj = arrayList3.get(i14);
                        i14++;
                        ArrayList arrayList4 = arrayList3;
                        String str = (String) obj;
                        int i15 = size3;
                        List list = (List) ((HashMap) eVar.f13543q).get(str);
                        if (list != null) {
                            Iterator it = list.iterator();
                            while (it.hasNext()) {
                                h6.c cVar = (h6.c) it.next();
                                Iterator it2 = it;
                                if (cVar.f5688a.isAssignableFrom(cls4) && cls5.isAssignableFrom(cVar.f5689b)) {
                                    arrayList.add(cVar.f5690c);
                                }
                                it = it2;
                            }
                        }
                        size3 = i15;
                        arrayList3 = arrayList4;
                    }
                }
                arrayList2.add(new t5.i(cls4, cls5, cls6, arrayList, this.f3028f.g(cls5, cls6), this.f3031j));
                cls4 = cls;
                i12 = i13;
            }
            cls4 = cls;
            i10 = i11;
        }
        return arrayList2;
    }

    public final ArrayList f() {
        ArrayList arrayList;
        e2.d dVar = this.g;
        synchronized (dVar) {
            arrayList = dVar.f4413a;
        }
        if (arrayList.isEmpty()) {
            throw new j("Failed to find image header parser.");
        }
        return arrayList;
    }

    public final List g(Object obj) {
        List list;
        w wVar = this.f3023a;
        wVar.getClass();
        Class<?> cls = obj.getClass();
        synchronized (wVar) {
            v vVar = (v) wVar.f13669b.f3017a.get(cls);
            list = vVar == null ? null : vVar.f13667a;
            if (list == null) {
                list = Collections.unmodifiableList(wVar.f13668a.b(cls));
                if (((v) wVar.f13669b.f3017a.put(cls, new v(list))) != null) {
                    throw new IllegalStateException("Already cached loaders for model: " + cls);
                }
            }
        }
        if (list.isEmpty()) {
            throw new j("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }
        int size = list.size();
        List list2 = Collections.EMPTY_LIST;
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            t tVar = (t) list.get(i10);
            if (tVar.b(obj)) {
                if (z10) {
                    list2 = new ArrayList(size - i10);
                    z10 = false;
                }
                list2.add(tVar);
            }
        }
        if (!list2.isEmpty()) {
            return list2;
        }
        throw new j("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + obj);
    }

    public final com.bumptech.glide.load.data.f h(Object obj) {
        com.bumptech.glide.load.data.f b2;
        com.bumptech.glide.load.data.g gVar = this.f3027e;
        synchronized (gVar) {
            try {
                m6.f.b(obj);
                com.bumptech.glide.load.data.e eVar = (com.bumptech.glide.load.data.e) ((HashMap) gVar.f3043p).get(obj.getClass());
                if (eVar == null) {
                    Iterator it = ((HashMap) gVar.f3043p).values().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        com.bumptech.glide.load.data.e eVar2 = (com.bumptech.glide.load.data.e) it.next();
                        if (eVar2.a().isAssignableFrom(obj.getClass())) {
                            eVar = eVar2;
                            break;
                        }
                    }
                }
                if (eVar == null) {
                    eVar = com.bumptech.glide.load.data.g.f3041q;
                }
                b2 = eVar.b(obj);
            } catch (Throwable th) {
                throw th;
            }
        }
        return b2;
    }

    public final void i(com.bumptech.glide.load.data.e eVar) {
        com.bumptech.glide.load.data.g gVar = this.f3027e;
        synchronized (gVar) {
            ((HashMap) gVar.f3043p).put(eVar.a(), eVar);
        }
    }

    public final void j(Class cls, Class cls2, f6.b bVar) {
        e2.d dVar = this.f3028f;
        synchronized (dVar) {
            dVar.f4413a.add(new f6.c(cls, cls2, bVar));
        }
    }

    public final void k(r5.d dVar) {
        e2.d dVar2 = this.g;
        synchronized (dVar2) {
            dVar2.f4413a.add(dVar);
        }
    }

    public final void l(q5.b bVar) {
        w wVar = this.f3023a;
        synchronized (wVar) {
            ArrayList f10 = wVar.f13668a.f(bVar);
            int size = f10.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = f10.get(i10);
                i10++;
                ((u) obj).getClass();
            }
            wVar.f13669b.f3017a.clear();
        }
    }
}
