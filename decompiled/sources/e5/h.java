package e5;

import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.RealmQuery;
import io.realm.t;
import io.realm.u;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4594o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Iterator f4595p;

    public /* synthetic */ h(Iterator it, int i10) {
        this.f4594o = i10;
        this.f4595p = it;
    }

    @Override // io.realm.t
    public final void e(u uVar) {
        switch (this.f4594o) {
            case 0:
                RealmQuery V = uVar.V(EPGChannel.class);
                V.c("name", (String) this.f4595p.next());
                EPGChannel ePGChannel = (EPGChannel) V.e();
                if (ePGChannel != null) {
                    ePGChannel.setIs_favorite(true);
                    break;
                }
                break;
            case 1:
                RealmQuery V2 = uVar.V(EPGChannel.class);
                V2.c("name", (String) this.f4595p.next());
                EPGChannel ePGChannel2 = (EPGChannel) V2.e();
                if (ePGChannel2 != null) {
                    ePGChannel2.setIs_locked(true);
                    break;
                }
                break;
            case 2:
                RealmQuery V3 = uVar.V(EPGChannel.class);
                V3.c("name", (String) this.f4595p.next());
                EPGChannel ePGChannel3 = (EPGChannel) V3.e();
                if (ePGChannel3 != null) {
                    ePGChannel3.setIs_favorite(true);
                    break;
                }
                break;
            case 3:
                RealmQuery V4 = uVar.V(EPGChannel.class);
                V4.c("name", (String) this.f4595p.next());
                EPGChannel ePGChannel4 = (EPGChannel) V4.e();
                if (ePGChannel4 != null) {
                    ePGChannel4.setIs_locked(true);
                    break;
                }
                break;
            case 4:
                RealmQuery V5 = uVar.V(MovieModel.class);
                V5.c("name", (String) this.f4595p.next());
                MovieModel movieModel = (MovieModel) V5.e();
                if (movieModel != null) {
                    movieModel.setIs_favorite(true);
                    break;
                }
                break;
            case 5:
                RealmQuery V6 = uVar.V(SeriesModel.class);
                V6.c("name", (String) this.f4595p.next());
                SeriesModel seriesModel = (SeriesModel) V6.e();
                if (seriesModel != null) {
                    seriesModel.setIs_favorite(true);
                    break;
                }
                break;
            case 6:
                RealmQuery V7 = uVar.V(SeriesModel.class);
                V7.c("name", (String) this.f4595p.next());
                SeriesModel seriesModel2 = (SeriesModel) V7.e();
                if (seriesModel2 != null) {
                    seriesModel2.setIs_favorite(true);
                    break;
                }
                break;
            default:
                RealmQuery V8 = uVar.V(MovieModel.class);
                V8.c("name", (String) this.f4595p.next());
                MovieModel movieModel2 = (MovieModel) V8.e();
                if (movieModel2 != null) {
                    movieModel2.setIs_favorite(true);
                    break;
                }
                break;
        }
    }
}
