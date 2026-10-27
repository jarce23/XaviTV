package e5;

import app.shamel.tv.models.ResumeSeriesModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.RealmQuery;
import io.realm.t;
import io.realm.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4588o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ResumeSeriesModel f4589p;

    public /* synthetic */ e(ResumeSeriesModel resumeSeriesModel, int i10) {
        this.f4588o = i10;
        this.f4589p = resumeSeriesModel;
    }

    @Override // io.realm.t
    public final void e(u uVar) {
        switch (this.f4588o) {
            case 0:
                RealmQuery V = uVar.V(SeriesModel.class);
                ResumeSeriesModel resumeSeriesModel = this.f4589p;
                V.c("name", resumeSeriesModel.getName());
                SeriesModel seriesModel = (SeriesModel) V.e();
                if (seriesModel != null) {
                    seriesModel.setIs_recent(true);
                    seriesModel.setSeason_pos(resumeSeriesModel.getSeason_pos());
                    seriesModel.setEpisode_pos(resumeSeriesModel.getEpisode_pos());
                    break;
                }
                break;
            case 1:
                RealmQuery V2 = uVar.V(SeriesModel.class);
                ResumeSeriesModel resumeSeriesModel2 = this.f4589p;
                V2.c("name", resumeSeriesModel2.getName());
                SeriesModel seriesModel2 = (SeriesModel) V2.e();
                if (seriesModel2 != null) {
                    seriesModel2.setIs_recent(true);
                    seriesModel2.setSeason_pos(resumeSeriesModel2.getSeason_pos());
                    seriesModel2.setEpisode_pos(resumeSeriesModel2.getEpisode_pos());
                    break;
                }
                break;
            default:
                RealmQuery V3 = uVar.V(SeriesModel.class);
                ResumeSeriesModel resumeSeriesModel3 = this.f4589p;
                V3.c("name", resumeSeriesModel3.getName());
                SeriesModel seriesModel3 = (SeriesModel) V3.e();
                if (seriesModel3 != null) {
                    seriesModel3.setIs_recent(true);
                    seriesModel3.setSeason_pos(resumeSeriesModel3.getSeason_pos());
                    seriesModel3.setEpisode_pos(resumeSeriesModel3.getEpisode_pos());
                    break;
                }
                break;
        }
    }
}
