package e5;

import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.t;
import io.realm.u;
import java.util.Collection;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4592o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Response f4593p;

    public /* synthetic */ g(Response response, int i10) {
        this.f4592o = i10;
        this.f4593p = response;
    }

    @Override // io.realm.t
    public final void e(u uVar) {
        switch (this.f4592o) {
            case 0:
                uVar.V(EPGChannel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
            case 1:
                uVar.V(EPGChannel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
            case 2:
                uVar.V(MovieModel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
            case 3:
                uVar.V(SeriesModel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
            case 4:
                uVar.V(SeriesModel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
            default:
                uVar.V(MovieModel.class).d().f();
                uVar.T((Collection) this.f4593p.body());
                break;
        }
    }
}
