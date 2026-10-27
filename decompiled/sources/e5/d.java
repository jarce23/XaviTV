package e5;

import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.ResumeModel;
import io.realm.RealmQuery;
import io.realm.t;
import io.realm.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4586o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ ResumeModel f4587p;

    public /* synthetic */ d(ResumeModel resumeModel, int i10) {
        this.f4586o = i10;
        this.f4587p = resumeModel;
    }

    @Override // io.realm.t
    public final void e(u uVar) {
        switch (this.f4586o) {
            case 0:
                RealmQuery V = uVar.V(MovieModel.class);
                ResumeModel resumeModel = this.f4587p;
                V.c("name", resumeModel.getName());
                MovieModel movieModel = (MovieModel) V.e();
                if (movieModel != null) {
                    movieModel.setIs_recent(true);
                    movieModel.setPro(resumeModel.getPro());
                    movieModel.setTime(resumeModel.getLast_position());
                    break;
                }
                break;
            case 1:
                RealmQuery V2 = uVar.V(MovieModel.class);
                ResumeModel resumeModel2 = this.f4587p;
                V2.c("name", resumeModel2.getName());
                MovieModel movieModel2 = (MovieModel) V2.e();
                if (movieModel2 != null) {
                    movieModel2.setIs_recent(true);
                    movieModel2.setPro(resumeModel2.getPro());
                    movieModel2.setTime(resumeModel2.getLast_position());
                    movieModel2.setTmdb_id(resumeModel2.getTmdb_id());
                    break;
                }
                break;
            default:
                RealmQuery V3 = uVar.V(MovieModel.class);
                ResumeModel resumeModel3 = this.f4587p;
                V3.c("name", resumeModel3.getName());
                MovieModel movieModel3 = (MovieModel) V3.e();
                if (movieModel3 != null) {
                    movieModel3.setIs_recent(true);
                    movieModel3.setPro(resumeModel3.getPro());
                    movieModel3.setTime(resumeModel3.getLast_position());
                    movieModel3.setTmdb_id(resumeModel3.getTmdb_id());
                    break;
                }
                break;
        }
    }
}
