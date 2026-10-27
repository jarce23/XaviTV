package app.shamel.tv.activities;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import app.shamel.tv.models.MovieCreditModel;
import app.shamel.tv.models.MovieCreditResponse;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.TMDBVideoResponse;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1895o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MovieCreditActivity f1896p;

    public /* synthetic */ h0(MovieCreditActivity movieCreditActivity, int i10) {
        this.f1895o = i10;
        this.f1896p = movieCreditActivity;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        switch (this.f1895o) {
            case 0:
                break;
            default:
                Toast.makeText(this.f1896p, "No Trailer", 0).show();
                break;
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        switch (this.f1895o) {
            case 0:
                MovieCreditActivity movieCreditActivity = this.f1896p;
                ArrayList arrayList = movieCreditActivity.f1732a0;
                if (response.isSuccessful() && response.body() != null) {
                    arrayList.addAll(((MovieCreditResponse) response.body()).getCast());
                    List<MovieCreditModel> cast = ((MovieCreditResponse) response.body()).getCast();
                    if (cast != null && cast.size() > 0) {
                        for (MovieCreditModel movieCreditModel : cast) {
                            a6.n K = a6.n.K();
                            String title = movieCreditModel.getTitle();
                            RealmQuery V = ((io.realm.u) K.f74p).V(MovieModel.class);
                            V.a("name", 1, title);
                            if (((MovieModel) V.e()) == null) {
                                arrayList.remove(movieCreditModel);
                            }
                        }
                        d5.e eVar = movieCreditActivity.M;
                        eVar.f4088h = arrayList;
                        eVar.d();
                        if (!arrayList.isEmpty()) {
                            movieCreditActivity.u((MovieCreditModel) arrayList.get(0));
                            break;
                        }
                    }
                }
                break;
            default:
                boolean isSuccessful = response.isSuccessful();
                MovieCreditActivity movieCreditActivity2 = this.f1896p;
                if (!isSuccessful || response.body() == null || ((TMDBVideoResponse) response.body()).getResults().size() <= 0) {
                    Toast.makeText(movieCreditActivity2, "No Trailer", 0).show();
                    break;
                } else {
                    String key = ((TMDBVideoResponse) response.body()).getResults().get(0).getKey();
                    if (app.shamel.tv.helper.a.l(movieCreditActivity2)) {
                        androidx.emoji2.text.s m10 = k5.j.m(movieCreditActivity2);
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.youtube.com/watch?v=" + key));
                        intent.setPackage(m10.f595p);
                        movieCreditActivity2.startActivity(intent);
                        break;
                    } else {
                        try {
                            Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + key));
                            intent2.addFlags(335544320);
                            movieCreditActivity2.startActivity(intent2);
                            break;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
        }
    }

    private final void a(Call call, Throwable th) {
    }
}
