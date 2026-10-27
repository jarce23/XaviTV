package c5;

import android.widget.Toast;
import app.shamel.tv.activities.mobile.MovieMobilePlayer;
import app.shamel.tv.helper.s;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class i implements s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2938o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ MovieMobilePlayer f2939p;

    public /* synthetic */ i(MovieMobilePlayer movieMobilePlayer, int i10) {
        this.f2938o = i10;
        this.f2939p = movieMobilePlayer;
    }

    @Override // app.shamel.tv.helper.s
    public final void j() {
        switch (this.f2938o) {
            case 0:
                this.f2939p.f1989i0.X(a6.n.K().C());
                break;
            case 1:
                this.f2939p.f1989i0.X(a6.n.K().C());
                break;
            case 2:
                MovieMobilePlayer movieMobilePlayer = this.f2939p;
                movieMobilePlayer.f1989i0.d0(a6.n.K().u());
                Toast.makeText(movieMobilePlayer, movieMobilePlayer.C0.getMovie_is_added_to_fav(), 0).show();
                break;
            default:
                MovieMobilePlayer movieMobilePlayer2 = this.f2939p;
                movieMobilePlayer2.f1989i0.d0(a6.n.K().u());
                Toast.makeText(movieMobilePlayer2, movieMobilePlayer2.C0.getMovie_is_removed_from_fav(), 0).show();
                break;
        }
    }
}
