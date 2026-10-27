package app.shamel.tv.activities;

import android.content.Intent;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.ResumeSeriesModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class k implements androidx.activity.result.b, app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1902o;

    public /* synthetic */ k(Object obj) {
        this.f1902o = obj;
    }

    @Override // androidx.activity.result.b
    public void c(Object obj) {
        Intent intent;
        CategoryActivity categoryActivity = (CategoryActivity) this.f1902o;
        androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
        int i10 = CategoryActivity.Y;
        if (aVar.f330o != -1 || (intent = aVar.f331p) == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("is_changed");
        String lowerCase = stringExtra != null ? stringExtra.toLowerCase() : "false";
        Objects.requireNonNull(lowerCase);
        switch (lowerCase) {
            case "series":
                LTVApp.f2090y = 3;
                categoryActivity.z();
                categoryActivity.x(0);
                break;
            case "home":
                categoryActivity.finish();
                break;
            case "live":
            case "add_group":
                LTVApp.f2090y = 1;
                categoryActivity.z();
                categoryActivity.x(0);
                break;
            case "movie":
                LTVApp.f2090y = 2;
                categoryActivity.z();
                categoryActivity.x(0);
                break;
        }
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        app.shamel.tv.helper.r rVar = ((SeasonActivity) ((f) this.f1902o).f1885p).T;
        a6.n K = a6.n.K();
        K.getClass();
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) K.f74p).V(SeriesModel.class);
        V.b("is_recent");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            SeriesModel seriesModel = (SeriesModel) oVar.next();
            ResumeSeriesModel resumeSeriesModel = new ResumeSeriesModel();
            resumeSeriesModel.setName(seriesModel.getName());
            resumeSeriesModel.setSeason_pos(seriesModel.getSeason_pos());
            resumeSeriesModel.setEpisode_pos(seriesModel.getEpisode_pos());
            arrayList.add(resumeSeriesModel);
        }
        rVar.W(arrayList);
    }
}
