package e5;

import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import i1.m0;
import io.realm.t;
import io.realm.u;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements t, l1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4584o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ List f4585p;

    public /* synthetic */ c(int i10, List list) {
        this.f4584o = i10;
        this.f4585p = list;
    }

    @Override // io.realm.t
    public void e(u uVar) {
        switch (this.f4584o) {
            case 0:
                uVar.V(MovieModel.class).d().f();
                uVar.T(this.f4585p);
                break;
            case 1:
                uVar.V(EpisodeModel.class).d().f();
                uVar.V(SeriesModel.class).d().f();
                uVar.T(this.f4585p);
                break;
            default:
                uVar.V(EPGChannel.class).d().f();
                uVar.T(this.f4585p);
                break;
        }
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f4584o) {
            case 3:
                ((m0) obj).o(this.f4585p);
                break;
            default:
                ((t1.b) obj).getClass();
                break;
        }
    }

    public /* synthetic */ c(t1.a aVar, List list) {
        this.f4584o = 4;
        this.f4585p = list;
    }
}
