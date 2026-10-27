package app.shamel.tv.helper;

import app.shamel.tv.models.SeriesModel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class u implements io.realm.t, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2102o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f2103p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f2104q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f2105r;

    public /* synthetic */ u(String str, int i10, int i11, boolean z10) {
        this.f2105r = str;
        this.f2104q = z10;
        this.f2102o = i10;
        this.f2103p = i11;
    }

    @Override // io.realm.t
    public void e(io.realm.u uVar) {
        SeriesModel seriesModel = (SeriesModel) android.support.v4.media.d.j(uVar, SeriesModel.class, "name", (String) this.f2105r);
        if (seriesModel != null) {
            seriesModel.setIs_recent(this.f2104q);
            seriesModel.setSeason_pos(this.f2102o);
            seriesModel.setEpisode_pos(this.f2103p);
        }
    }

    @Override // l1.m
    public void invoke(Object obj) {
        ((t1.b) obj).w((t1.a) this.f2105r, this.f2102o, this.f2103p, this.f2104q);
    }

    public /* synthetic */ u(t1.a aVar, int i10, int i11, boolean z10) {
        this.f2105r = aVar;
        this.f2102o = i10;
        this.f2103p = i11;
        this.f2104q = z10;
    }
}
