package a9;

import android.graphics.Typeface;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends d0.b {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ com.bumptech.glide.e f154h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ d f155i;

    public b(d dVar, com.bumptech.glide.e eVar) {
        this.f155i = dVar;
        this.f154h = eVar;
    }

    @Override // d0.b
    public final void i(int i10) {
        this.f155i.f172n = true;
        this.f154h.r(i10);
    }

    @Override // d0.b
    public final void j(Typeface typeface) {
        d dVar = this.f155i;
        dVar.f174p = Typeface.create(typeface, dVar.f163d);
        dVar.f172n = true;
        this.f154h.s(dVar.f174p, false);
    }
}
