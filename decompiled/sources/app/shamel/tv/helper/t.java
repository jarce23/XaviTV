package app.shamel.tv.helper;

import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class t implements io.realm.t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2099o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ String f2100p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ boolean f2101q;

    public /* synthetic */ t(String str, boolean z10, int i10) {
        this.f2099o = i10;
        this.f2100p = str;
        this.f2101q = z10;
    }

    @Override // io.realm.t
    public final void e(io.realm.u uVar) {
        switch (this.f2099o) {
            case 0:
                SeriesModel seriesModel = (SeriesModel) android.support.v4.media.d.j(uVar, SeriesModel.class, "name", this.f2100p);
                if (seriesModel != null) {
                    seriesModel.setIs_favorite(this.f2101q);
                    break;
                }
                break;
            case 1:
                EPGChannel ePGChannel = (EPGChannel) android.support.v4.media.d.j(uVar, EPGChannel.class, "name", this.f2100p);
                if (ePGChannel != null) {
                    ePGChannel.setIs_favorite(this.f2101q);
                    break;
                }
                break;
            case 2:
                MovieModel movieModel = (MovieModel) android.support.v4.media.d.j(uVar, MovieModel.class, "name", this.f2100p);
                if (movieModel != null) {
                    movieModel.setIs_favorite(this.f2101q);
                    break;
                }
                break;
            case 3:
                EPGChannel ePGChannel2 = (EPGChannel) android.support.v4.media.d.j(uVar, EPGChannel.class, "name", this.f2100p);
                if (ePGChannel2 != null) {
                    ePGChannel2.setIs_recent(this.f2101q);
                    ePGChannel2.setRecent_pos(System.currentTimeMillis() / 1000);
                    break;
                }
                break;
            default:
                EPGChannel ePGChannel3 = (EPGChannel) android.support.v4.media.d.j(uVar, EPGChannel.class, "name", this.f2100p);
                if (ePGChannel3 != null) {
                    ePGChannel3.setIs_locked(this.f2101q);
                    break;
                }
                break;
        }
    }
}
