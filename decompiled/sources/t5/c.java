package t5;

import java.io.File;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements f, com.bumptech.glide.load.data.c {

    /* renamed from: o, reason: collision with root package name */
    public final List f11903o;

    /* renamed from: p, reason: collision with root package name */
    public final g f11904p;

    /* renamed from: q, reason: collision with root package name */
    public final e f11905q;

    /* renamed from: r, reason: collision with root package name */
    public int f11906r = -1;

    /* renamed from: s, reason: collision with root package name */
    public r5.e f11907s;

    /* renamed from: t, reason: collision with root package name */
    public List f11908t;

    /* renamed from: u, reason: collision with root package name */
    public int f11909u;

    /* renamed from: v, reason: collision with root package name */
    public volatile x5.s f11910v;

    /* renamed from: w, reason: collision with root package name */
    public File f11911w;

    public c(List list, g gVar, e eVar) {
        this.f11903o = list;
        this.f11904p = gVar;
        this.f11905q = eVar;
    }

    @Override // t5.f
    public final boolean b() {
        while (true) {
            List list = this.f11908t;
            boolean z10 = false;
            if (list != null && this.f11909u < list.size()) {
                this.f11910v = null;
                while (!z10 && this.f11909u < this.f11908t.size()) {
                    List list2 = this.f11908t;
                    int i10 = this.f11909u;
                    this.f11909u = i10 + 1;
                    x5.t tVar = (x5.t) list2.get(i10);
                    File file = this.f11911w;
                    g gVar = this.f11904p;
                    this.f11910v = tVar.a(file, gVar.f11918e, gVar.f11919f, gVar.f11921i);
                    if (this.f11910v != null && this.f11904p.c(this.f11910v.f13666c.a()) != null) {
                        this.f11910v.f13666c.d(this.f11904p.f11927o, this);
                        z10 = true;
                    }
                }
                return z10;
            }
            int i11 = this.f11906r + 1;
            this.f11906r = i11;
            if (i11 >= this.f11903o.size()) {
                return false;
            }
            r5.e eVar = (r5.e) this.f11903o.get(this.f11906r);
            g gVar2 = this.f11904p;
            File l10 = gVar2.f11920h.b().l(new d(eVar, gVar2.f11926n));
            this.f11911w = l10;
            if (l10 != null) {
                this.f11907s = eVar;
                this.f11908t = this.f11904p.f11916c.b().g(l10);
                this.f11909u = 0;
            }
        }
    }

    @Override // t5.f
    public final void cancel() {
        x5.s sVar = this.f11910v;
        if (sVar != null) {
            sVar.f13666c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public final void l(Exception exc) {
        this.f11905q.a(this.f11907s, exc, this.f11910v.f13666c, 3);
    }

    @Override // com.bumptech.glide.load.data.c
    public final void p(Object obj) {
        this.f11905q.c(this.f11907s, obj, this.f11910v.f13666c, 3, this.f11907s);
    }
}
