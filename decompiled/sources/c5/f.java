package c5;

import android.widget.Toast;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.helper.s;
import app.shamel.tv.models.CategoryModel;
import h5.g0;
import io.realm.n0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements g0, s {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2932o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f2933p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ LiveMobileActivity f2934q;

    public /* synthetic */ f(LiveMobileActivity liveMobileActivity, int i10, int i11) {
        this.f2932o = i11;
        this.f2934q = liveMobileActivity;
        this.f2933p = i10;
    }

    @Override // app.shamel.tv.helper.s
    public void j() {
        switch (this.f2932o) {
            case 1:
                LiveMobileActivity liveMobileActivity = this.f2934q;
                if (((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getId().equalsIgnoreCase("fav_id")) {
                    n0 w10 = a6.n.K().w((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0), _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity.f1978w0.g(), liveMobileActivity.f1978w0.o());
                    liveMobileActivity.f1964j0 = w10;
                    liveMobileActivity.f1954d0.q(-1, w10);
                } else {
                    liveMobileActivity.f1954d0.e(this.f2933p);
                }
                liveMobileActivity.f1978w0.S(a6.n.K().t());
                liveMobileActivity.f1950b0.e(3);
                break;
            default:
                LiveMobileActivity liveMobileActivity2 = this.f2934q;
                if (((CategoryModel) liveMobileActivity2.f1952c0.get(liveMobileActivity2.R0)).getId().equalsIgnoreCase("lock_id")) {
                    n0 w11 = a6.n.K().w((CategoryModel) liveMobileActivity2.f1952c0.get(liveMobileActivity2.R0), _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity2.f1978w0.g(), liveMobileActivity2.f1978w0.o());
                    liveMobileActivity2.f1964j0 = w11;
                    liveMobileActivity2.f1954d0.q(0, w11);
                } else {
                    liveMobileActivity2.f1954d0.e(this.f2933p);
                }
                liveMobileActivity2.f1978w0.T(a6.n.K().x());
                liveMobileActivity2.f1950b0.e(4);
                break;
        }
    }

    @Override // h5.g0
    public void t() {
        LiveMobileActivity liveMobileActivity = this.f2934q;
        Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getPut_pin_code(), 0).show();
    }

    @Override // h5.g0
    public void u() {
        LiveMobileActivity liveMobileActivity = this.f2934q;
        Toast.makeText(liveMobileActivity, liveMobileActivity.Q0.getPin_incorrect(), 0).show();
    }

    @Override // h5.g0
    public void y() {
        LiveMobileActivity liveMobileActivity = this.f2934q;
        int i10 = this.f2933p;
        liveMobileActivity.R0 = i10;
        liveMobileActivity.Y0 = (liveMobileActivity.R0 + 1) + " • Group : " + ((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0)).getName();
        liveMobileActivity.f1964j0 = a6.n.K().w((CategoryModel) liveMobileActivity.f1952c0.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, liveMobileActivity.f1978w0.g(), liveMobileActivity.f1978w0.o());
        liveMobileActivity.f1954d0.q(-1, liveMobileActivity.f1964j0);
        liveMobileActivity.f1980y0.e0(0);
    }
}
