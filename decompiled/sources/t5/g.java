package t5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f11914a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f11915b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public com.bumptech.glide.g f11916c;

    /* renamed from: d, reason: collision with root package name */
    public Object f11917d;

    /* renamed from: e, reason: collision with root package name */
    public int f11918e;

    /* renamed from: f, reason: collision with root package name */
    public int f11919f;
    public Class g;

    /* renamed from: h, reason: collision with root package name */
    public c.a f11920h;

    /* renamed from: i, reason: collision with root package name */
    public r5.h f11921i;

    /* renamed from: j, reason: collision with root package name */
    public Map f11922j;

    /* renamed from: k, reason: collision with root package name */
    public Class f11923k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11924l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11925m;

    /* renamed from: n, reason: collision with root package name */
    public r5.e f11926n;

    /* renamed from: o, reason: collision with root package name */
    public com.bumptech.glide.i f11927o;

    /* renamed from: p, reason: collision with root package name */
    public j f11928p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f11929q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f11930r;

    public final ArrayList a() {
        boolean z10 = this.f11925m;
        ArrayList arrayList = this.f11915b;
        if (!z10) {
            this.f11925m = true;
            arrayList.clear();
            ArrayList b2 = b();
            int size = b2.size();
            for (int i10 = 0; i10 < size; i10++) {
                x5.s sVar = (x5.s) b2.get(i10);
                r5.e eVar = sVar.f13664a;
                List list = sVar.f13665b;
                if (!arrayList.contains(eVar)) {
                    arrayList.add(sVar.f13664a);
                }
                for (int i11 = 0; i11 < list.size(); i11++) {
                    if (!arrayList.contains(list.get(i11))) {
                        arrayList.add((r5.e) list.get(i11));
                    }
                }
            }
        }
        return arrayList;
    }

    public final ArrayList b() {
        boolean z10 = this.f11924l;
        ArrayList arrayList = this.f11914a;
        if (!z10) {
            this.f11924l = true;
            arrayList.clear();
            List g = this.f11916c.b().g(this.f11917d);
            int size = g.size();
            for (int i10 = 0; i10 < size; i10++) {
                x5.s a10 = ((x5.t) g.get(i10)).a(this.f11917d, this.f11918e, this.f11919f, this.f11921i);
                if (a10 != null) {
                    arrayList.add(a10);
                }
            }
        }
        return arrayList;
    }

    public final w c(Class cls) {
        w wVar;
        Class cls2;
        com.bumptech.glide.k b2 = this.f11916c.b();
        Class cls3 = this.g;
        Class cls4 = this.f11923k;
        h6.b bVar = b2.f3030i;
        m6.l lVar = (m6.l) bVar.f5687b.getAndSet(null);
        if (lVar == null) {
            lVar = new m6.l();
        }
        lVar.f9023a = cls;
        lVar.f9024b = cls3;
        lVar.f9025c = cls4;
        synchronized (bVar.f5686a) {
            wVar = (w) bVar.f5686a.get(lVar);
        }
        bVar.f5687b.set(lVar);
        b2.f3030i.getClass();
        if (h6.b.f5685c.equals(wVar)) {
            return null;
        }
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = null;
        ArrayList e7 = b2.e(cls, cls3, cls4);
        if (e7.isEmpty()) {
            cls2 = cls;
        } else {
            cls2 = cls;
            wVar2 = new w(cls2, cls3, cls4, e7, b2.f3031j);
        }
        w wVar3 = wVar2;
        b2.f3030i.a(cls2, cls3, cls4, wVar3);
        return wVar3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r1 = r5.f5684b;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final r5.b d(java.lang.Object r8) {
        /*
            r7 = this;
            com.bumptech.glide.g r0 = r7.f11916c
            com.bumptech.glide.k r0 = r0.b()
            e2.d r0 = r0.f3024b
            java.lang.Class r1 = r8.getClass()
            monitor-enter(r0)
            java.util.ArrayList r2 = r0.f4413a     // Catch: java.lang.Throwable -> L2a
            int r3 = r2.size()     // Catch: java.lang.Throwable -> L2a
            r4 = 0
        L14:
            if (r4 >= r3) goto L2c
            java.lang.Object r5 = r2.get(r4)     // Catch: java.lang.Throwable -> L2a
            int r4 = r4 + 1
            h6.a r5 = (h6.a) r5     // Catch: java.lang.Throwable -> L2a
            java.lang.Class r6 = r5.f5683a     // Catch: java.lang.Throwable -> L2a
            boolean r6 = r6.isAssignableFrom(r1)     // Catch: java.lang.Throwable -> L2a
            if (r6 == 0) goto L14
            r5.b r1 = r5.f5684b     // Catch: java.lang.Throwable -> L2a
            monitor-exit(r0)
            goto L2e
        L2a:
            r8 = move-exception
            goto L49
        L2c:
            monitor-exit(r0)
            r1 = 0
        L2e:
            if (r1 == 0) goto L31
            return r1
        L31:
            com.bumptech.glide.j r0 = new com.bumptech.glide.j
            java.lang.Class r8 = r8.getClass()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Failed to find source encoder for data class: "
            r1.<init>(r2)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            r0.<init>(r8)
            throw r0
        L49:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L2a
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.g.d(java.lang.Object):r5.b");
    }

    public final r5.l e(Class cls) {
        r5.l lVar = (r5.l) this.f11922j.get(cls);
        if (lVar == null) {
            Iterator it = this.f11922j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                if (((Class) entry.getKey()).isAssignableFrom(cls)) {
                    lVar = (r5.l) entry.getValue();
                    break;
                }
            }
        }
        if (lVar != null) {
            return lVar;
        }
        if (!this.f11922j.isEmpty() || !this.f11929q) {
            return z5.c.f14122b;
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }
}
