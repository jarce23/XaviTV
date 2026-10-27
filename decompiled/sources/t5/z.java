package t5;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements f, com.bumptech.glide.load.data.c {

    /* renamed from: o, reason: collision with root package name */
    public final h f12008o;

    /* renamed from: p, reason: collision with root package name */
    public final g f12009p;

    /* renamed from: q, reason: collision with root package name */
    public int f12010q;

    /* renamed from: r, reason: collision with root package name */
    public int f12011r = -1;

    /* renamed from: s, reason: collision with root package name */
    public r5.e f12012s;

    /* renamed from: t, reason: collision with root package name */
    public List f12013t;

    /* renamed from: u, reason: collision with root package name */
    public int f12014u;

    /* renamed from: v, reason: collision with root package name */
    public volatile x5.s f12015v;

    /* renamed from: w, reason: collision with root package name */
    public File f12016w;

    /* renamed from: x, reason: collision with root package name */
    public a0 f12017x;

    public z(g gVar, h hVar) {
        this.f12009p = gVar;
        this.f12008o = hVar;
    }

    @Override // t5.f
    public final boolean b() {
        List list;
        boolean z10;
        List list2;
        boolean z11;
        ArrayList a10 = this.f12009p.a();
        if (a10.isEmpty()) {
            return false;
        }
        g gVar = this.f12009p;
        com.bumptech.glide.k b2 = gVar.f11916c.b();
        Class<?> cls = gVar.f11917d.getClass();
        Class cls2 = gVar.g;
        Class cls3 = gVar.f11923k;
        x4.c cVar = b2.f3029h;
        m6.l lVar = (m6.l) ((AtomicReference) cVar.f13537p).getAndSet(null);
        if (lVar == null) {
            lVar = new m6.l(cls, cls2, cls3);
        } else {
            lVar.f9023a = cls;
            lVar.f9024b = cls2;
            lVar.f9025c = cls3;
        }
        synchronized (((p.e) cVar.f13538q)) {
            list = (List) ((p.e) cVar.f13538q).get(lVar);
        }
        ((AtomicReference) cVar.f13537p).set(lVar);
        if (list == null) {
            ArrayList arrayList = new ArrayList();
            ArrayList a11 = b2.f3023a.a(cls);
            int size = a11.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = a11.get(i10);
                i10++;
                ArrayList j10 = b2.f3025c.j((Class) obj, cls2);
                int size2 = j10.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = j10.get(i11);
                    i11++;
                    Class cls4 = (Class) obj2;
                    if (!b2.f3028f.j(cls4, cls3).isEmpty() && !arrayList.contains(cls4)) {
                        arrayList.add(cls4);
                    }
                }
            }
            z10 = false;
            b2.f3029h.Z(cls, cls2, cls3, Collections.unmodifiableList(arrayList));
            list2 = arrayList;
        } else {
            z10 = false;
            list2 = list;
        }
        if (list2.isEmpty()) {
            if (File.class.equals(this.f12009p.f11923k)) {
                return z10;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f12009p.f11917d.getClass() + " to " + this.f12009p.f11923k);
        }
        while (true) {
            List list3 = this.f12013t;
            if (list3 != null && this.f12014u < list3.size()) {
                this.f12015v = null;
                boolean z12 = z10;
                while (!z12 && this.f12014u < this.f12013t.size()) {
                    List list4 = this.f12013t;
                    int i12 = this.f12014u;
                    this.f12014u = i12 + 1;
                    x5.t tVar = (x5.t) list4.get(i12);
                    File file = this.f12016w;
                    g gVar2 = this.f12009p;
                    this.f12015v = tVar.a(file, gVar2.f11918e, gVar2.f11919f, gVar2.f11921i);
                    if (this.f12015v != null && this.f12009p.c(this.f12015v.f13666c.a()) != null) {
                        this.f12015v.f13666c.d(this.f12009p.f11927o, this);
                        z12 = true;
                    }
                }
                return z12;
            }
            int i13 = this.f12011r + 1;
            this.f12011r = i13;
            if (i13 >= list2.size()) {
                int i14 = this.f12010q + 1;
                this.f12010q = i14;
                if (i14 >= a10.size()) {
                    return z10;
                }
                this.f12011r = z10 ? 1 : 0;
            }
            r5.e eVar = (r5.e) a10.get(this.f12010q);
            Class cls5 = (Class) list2.get(this.f12011r);
            r5.l e7 = this.f12009p.e(cls5);
            g gVar3 = this.f12009p;
            this.f12017x = new a0(gVar3.f11916c.f3008a, eVar, gVar3.f11926n, gVar3.f11918e, gVar3.f11919f, e7, cls5, gVar3.f11921i);
            File l10 = gVar3.f11920h.b().l(this.f12017x);
            this.f12016w = l10;
            if (l10 != null) {
                this.f12012s = eVar;
                this.f12013t = this.f12009p.f11916c.b().g(l10);
                z11 = false;
                this.f12014u = 0;
            } else {
                z11 = false;
            }
            z10 = z11;
        }
    }

    @Override // t5.f
    public final void cancel() {
        x5.s sVar = this.f12015v;
        if (sVar != null) {
            sVar.f13666c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void l(Exception exc) {
        this.f12008o.a(this.f12017x, exc, this.f12015v.f13666c, 4);
    }

    @Override // com.bumptech.glide.load.data.c
    public final void p(Object obj) {
        this.f12008o.c(this.f12012s, obj, this.f12015v.f13666c, 4, this.f12017x);
    }
}
