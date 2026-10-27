package x5;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements com.bumptech.glide.load.data.d, com.bumptech.glide.load.data.c {

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f13670o;

    /* renamed from: p, reason: collision with root package name */
    public final l0.c f13671p;

    /* renamed from: q, reason: collision with root package name */
    public int f13672q;

    /* renamed from: r, reason: collision with root package name */
    public com.bumptech.glide.i f13673r;

    /* renamed from: s, reason: collision with root package name */
    public com.bumptech.glide.load.data.c f13674s;

    /* renamed from: t, reason: collision with root package name */
    public List f13675t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f13676u;

    public x(ArrayList arrayList, l0.c cVar) {
        this.f13671p = cVar;
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f13670o = arrayList;
        this.f13672q = 0;
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return ((com.bumptech.glide.load.data.d) this.f13670o.get(0)).a();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        List list = this.f13675t;
        if (list != null) {
            this.f13671p.m(list);
        }
        this.f13675t = null;
        ArrayList arrayList = this.f13670o;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((com.bumptech.glide.load.data.d) obj).b();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int c() {
        return ((com.bumptech.glide.load.data.d) this.f13670o.get(0)).c();
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.f13676u = true;
        ArrayList arrayList = this.f13670o;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((com.bumptech.glide.load.data.d) obj).cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final void d(com.bumptech.glide.i iVar, com.bumptech.glide.load.data.c cVar) {
        this.f13673r = iVar;
        this.f13674s = cVar;
        this.f13675t = (List) this.f13671p.v();
        ((com.bumptech.glide.load.data.d) this.f13670o.get(this.f13672q)).d(iVar, this);
        if (this.f13676u) {
            cancel();
        }
    }

    public final void e() {
        if (this.f13676u) {
            return;
        }
        if (this.f13672q < this.f13670o.size() - 1) {
            this.f13672q++;
            d(this.f13673r, this.f13674s);
        } else {
            m6.f.b(this.f13675t);
            this.f13674s.l(new t5.u("Fetch failed", new ArrayList(this.f13675t)));
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void l(Exception exc) {
        List list = this.f13675t;
        m6.f.c("Argument must not be null", list);
        list.add(exc);
        e();
    }

    @Override // com.bumptech.glide.load.data.c
    public final void p(Object obj) {
        if (obj != null) {
            this.f13674s.p(obj);
        } else {
            e();
        }
    }
}
