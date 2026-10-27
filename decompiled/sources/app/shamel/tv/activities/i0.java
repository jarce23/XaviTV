package app.shamel.tv.activities;

import app.shamel.tv.models.CastResponse;
import app.shamel.tv.models.MovieInfoResponse;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements Callback, app.shamel.tv.helper.s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1897o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MovieInfoActivity f1898p;

    public /* synthetic */ i0(MovieInfoActivity movieInfoActivity, int i10) {
        this.f1897o = i10;
        this.f1898p = movieInfoActivity;
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        switch (this.f1897o) {
            case 2:
                this.f1898p.Z.d0(a6.n.K().u());
                break;
            default:
                this.f1898p.Z.d0(a6.n.K().u());
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        int i10 = this.f1897o;
        MovieInfoActivity movieInfoActivity = this.f1898p;
        switch (i10) {
            case 0:
                MovieInfoActivity.u(movieInfoActivity, new ArrayList());
                break;
            default:
                int i11 = MovieInfoActivity.f1734u0;
                movieInfoActivity.x();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.f1897o) {
            case 0:
                Object body = response.body();
                MovieInfoActivity movieInfoActivity = this.f1898p;
                if (body != null && response.isSuccessful()) {
                    MovieInfoActivity.u(movieInfoActivity, ((CastResponse) response.body()).getCast());
                    break;
                } else {
                    MovieInfoActivity.u(movieInfoActivity, new ArrayList());
                    break;
                }
            default:
                if (response.isSuccessful() && response.body() != null) {
                    MovieInfoResponse movieInfoResponse = (MovieInfoResponse) response.body();
                    MovieInfoActivity movieInfoActivity2 = this.f1898p;
                    movieInfoActivity2.W = movieInfoResponse;
                    try {
                        MovieInfoActivity.v(movieInfoActivity2);
                        break;
                    } catch (Exception unused) {
                        movieInfoActivity2.x();
                    }
                }
                break;
        }
    }
}
