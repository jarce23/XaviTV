package app.shamel.tv.activities;

import android.text.Editable;
import android.text.TextWatcher;
import app.shamel.tv.activities.mobile.LiveChannelMobileActivity;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import app.shamel.tv.view.LiveHorizontalGridView;
import io.realm.RealmQuery;
import java.util.ArrayList;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements TextWatcher {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1905o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1906p;

    public /* synthetic */ l(int i10, Object obj) {
        this.f1905o = i10;
        this.f1906p = obj;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        io.realm.n0 d6;
        io.realm.n0 d10;
        int i10 = this.f1905o;
        int i11 = 1;
        int i12 = 2;
        int i13 = 0;
        Object obj = this.f1906p;
        switch (i10) {
            case 0:
                CategoryActivity categoryActivity = (CategoryActivity) obj;
                String obj2 = editable.toString();
                if (!obj2.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = categoryActivity.M;
                    int size = arrayList2.size();
                    int i14 = 0;
                    while (i14 < size) {
                        Object obj3 = arrayList2.get(i14);
                        i14++;
                        CategoryModel categoryModel = (CategoryModel) obj3;
                        if (categoryModel.getName().toLowerCase().contains(obj2.toLowerCase())) {
                            arrayList.add(categoryModel);
                        }
                    }
                    int i15 = n.f2032a[s.e.b(LTVApp.f2090y)];
                    if (i15 != 1) {
                        if (i15 == 2) {
                            categoryActivity.P.setAdapter(new d5.t0(categoryActivity, arrayList, 0, true, categoryActivity.O.g(), false, new m(categoryActivity, i12)));
                            break;
                        } else {
                            categoryActivity.P.setAdapter(new d5.n0(categoryActivity, arrayList, categoryActivity.O.g(), true, categoryActivity.V, new m(categoryActivity, i11)));
                            break;
                        }
                    } else {
                        categoryActivity.P.setAdapter(new d5.t0(categoryActivity, arrayList, 0, true, categoryActivity.O.g(), true, new m(categoryActivity, i13)));
                        break;
                    }
                } else {
                    categoryActivity.x(categoryActivity.V);
                    break;
                }
            case 1:
                LiveActivity liveActivity = (LiveActivity) obj;
                String obj4 = editable.toString();
                int i16 = liveActivity.f1651c1;
                if (i16 <= 4 || i16 >= liveActivity.f1682x0.s().size() + 5) {
                    liveActivity.X = a6.n.K().w((CategoryModel) liveActivity.Q.get(liveActivity.f1651c1), obj4, liveActivity.f1682x0.g(), liveActivity.f1682x0.o());
                } else if (liveActivity.f1682x0.s().size() > 0) {
                    a6.n K = a6.n.K();
                    app.shamel.tv.helper.r rVar = liveActivity.f1682x0;
                    liveActivity.X = K.s(obj4, rVar.t((String) rVar.s().get(liveActivity.f1651c1 - 5)));
                }
                liveActivity.R.q(-1, liveActivity.X);
                liveActivity.f1684z0.setSelectedPosition(0);
                liveActivity.f1684z0.e0(0);
                break;
            case 2:
                LiveChannelActivity liveChannelActivity = (LiveChannelActivity) obj;
                String obj5 = editable.toString();
                int i17 = liveChannelActivity.f1687a1;
                if (i17 <= 4 || i17 >= liveChannelActivity.f1718w0.s().size() + 5) {
                    liveChannelActivity.W = a6.n.K().w((CategoryModel) liveChannelActivity.P.get(liveChannelActivity.f1687a1), obj5, liveChannelActivity.f1718w0.g(), liveChannelActivity.f1718w0.o());
                } else if (liveChannelActivity.f1718w0.s().size() > 0) {
                    a6.n K2 = a6.n.K();
                    app.shamel.tv.helper.r rVar2 = liveChannelActivity.f1718w0;
                    liveChannelActivity.W = K2.s(obj5, rVar2.t((String) rVar2.s().get(liveChannelActivity.f1687a1 - 5)));
                }
                liveChannelActivity.Q.q(-1, liveChannelActivity.W);
                liveChannelActivity.f1719x0.setSelectedPosition(0);
                liveChannelActivity.f1719x0.e0(0);
                break;
            case 3:
                if (!editable.toString().isEmpty()) {
                    MovieActivity movieActivity = (MovieActivity) obj;
                    String obj6 = editable.toString();
                    int i18 = MovieActivity.f1722k0;
                    io.realm.n0 A = a6.n.K().A((CategoryModel) movieActivity.N.get(movieActivity.f1729g0), obj6, movieActivity.S.g(), movieActivity.h0);
                    movieActivity.R = A;
                    movieActivity.f1726d0.p(A);
                    movieActivity.U.setSelectedPosition(0);
                    break;
                }
                break;
            case 4:
                if (!editable.toString().isEmpty()) {
                    MovieSecondActivity movieSecondActivity = (MovieSecondActivity) obj;
                    String obj7 = editable.toString();
                    int i19 = MovieSecondActivity.f1779e0;
                    io.realm.n0 A2 = a6.n.K().A((CategoryModel) movieSecondActivity.M.get(movieSecondActivity.f1781b0), obj7, movieSecondActivity.P.g(), movieSecondActivity.f1782c0);
                    movieSecondActivity.O = A2;
                    movieSecondActivity.Y.p(A2);
                    movieSecondActivity.Q.setSelectedPosition(0);
                    break;
                }
                break;
            case 5:
                if (!editable.toString().isEmpty()) {
                    SearchActivity searchActivity = (SearchActivity) obj;
                    String obj8 = editable.toString();
                    a6.n K3 = a6.n.K();
                    boolean g = searchActivity.R.g();
                    io.realm.u uVar = (io.realm.u) K3.f74p;
                    String str = _UrlKt.FRAGMENT_ENCODE_SET;
                    if (g) {
                        RealmQuery V = uVar.V(EPGChannel.class);
                        V.a("name", 1, obj8.toLowerCase(Locale.ROOT));
                        V.f();
                        V.a("category_name", 2, "xxx");
                        V.f();
                        V.a("category_name", 2, "adult");
                        V.f();
                        V.a("category_name", 2, "porn");
                        d6 = V.d();
                    } else {
                        RealmQuery V2 = uVar.V(EPGChannel.class);
                        V2.a("name", 2, obj8.toLowerCase(Locale.ROOT));
                        ArrayList arrayList3 = e5.l.f4606a;
                        V2.g(!arrayList3.isEmpty() ? (String) arrayList3.get(0) : _UrlKt.FRAGMENT_ENCODE_SET);
                        d6 = V2.d();
                    }
                    searchActivity.N = d6;
                    a6.n K4 = a6.n.K();
                    boolean g6 = searchActivity.R.g();
                    io.realm.u uVar2 = (io.realm.u) K4.f74p;
                    String str2 = g6 ? "category_name" : "category_id";
                    if (g6) {
                        RealmQuery V3 = uVar2.V(MovieModel.class);
                        V3.a("name", 1, obj8.toLowerCase(Locale.ROOT));
                        V3.f();
                        V3.a(str2, 2, "xxx");
                        V3.f();
                        V3.a(str2, 2, "adult");
                        V3.f();
                        V3.a(str2, 2, "porn");
                        d10 = V3.d();
                    } else {
                        RealmQuery V4 = uVar2.V(MovieModel.class);
                        V4.a("name", 2, obj8.toLowerCase(Locale.ROOT));
                        ArrayList arrayList4 = e5.l.f4607b;
                        if (!arrayList4.isEmpty()) {
                            str = (String) arrayList4.get(0);
                        }
                        V4.g(str);
                        d10 = V4.d();
                    }
                    searchActivity.Q = d10;
                    RealmQuery V5 = ((io.realm.u) a6.n.K().f74p).V(SeriesModel.class);
                    V5.a("name", 2, obj8.toLowerCase(Locale.ROOT));
                    searchActivity.V = V5.d();
                    io.realm.n0 n0Var = searchActivity.N;
                    if (n0Var == null || n0Var.size() <= 0) {
                        searchActivity.W.setVisibility(8);
                        searchActivity.S.setVisibility(8);
                    } else {
                        searchActivity.W.setVisibility(0);
                        searchActivity.S.setVisibility(0);
                        new ArrayList();
                        p0 p0Var = new p0(searchActivity, 0);
                        d5.k kVar = new d5.k(2);
                        kVar.f4125f = searchActivity;
                        kVar.f4124e = p0Var;
                        searchActivity.P = kVar;
                        kVar.g = searchActivity.N;
                        kVar.d();
                        searchActivity.S.setAdapter(searchActivity.P);
                    }
                    io.realm.n0 n0Var2 = searchActivity.Q;
                    if (n0Var2 == null || n0Var2.size() <= 0) {
                        searchActivity.X.setVisibility(8);
                        searchActivity.T.setVisibility(8);
                    } else {
                        searchActivity.X.setVisibility(0);
                        searchActivity.T.setVisibility(0);
                        new ArrayList();
                        p0 p0Var2 = new p0(searchActivity, 1);
                        d5.k kVar2 = new d5.k(4);
                        kVar2.f4125f = searchActivity;
                        kVar2.f4124e = p0Var2;
                        searchActivity.Z = kVar2;
                        kVar2.g = searchActivity.Q;
                        kVar2.d();
                        searchActivity.T.setAdapter(searchActivity.Z);
                    }
                    io.realm.n0 n0Var3 = searchActivity.V;
                    if (n0Var3 != null && n0Var3.size() > 0) {
                        searchActivity.Y.setVisibility(0);
                        searchActivity.U.setVisibility(0);
                        LiveHorizontalGridView liveHorizontalGridView = searchActivity.U;
                        io.realm.n0 n0Var4 = searchActivity.V;
                        p0 p0Var3 = new p0(searchActivity, 2);
                        d5.k kVar3 = new d5.k(3);
                        kVar3.f4125f = searchActivity;
                        kVar3.g = n0Var4;
                        kVar3.f4124e = p0Var3;
                        liveHorizontalGridView.setAdapter(kVar3);
                        break;
                    } else {
                        searchActivity.Y.setVisibility(8);
                        searchActivity.U.setVisibility(8);
                        break;
                    }
                }
                break;
            case 6:
                if (!editable.toString().isEmpty()) {
                    SeriesActivity seriesActivity = (SeriesActivity) obj;
                    io.realm.n0 D = a6.n.K().D((CategoryModel) seriesActivity.N.get(seriesActivity.f1802g0), editable.toString(), seriesActivity.R.g(), seriesActivity.h0);
                    seriesActivity.V = D;
                    seriesActivity.U.p(D);
                    seriesActivity.T.setSelectedPosition(0);
                    break;
                }
                break;
            case 7:
                if (!editable.toString().isEmpty()) {
                    SeriesSecondActivity seriesSecondActivity = (SeriesSecondActivity) obj;
                    io.realm.n0 D2 = a6.n.K().D((CategoryModel) seriesSecondActivity.M.get(seriesSecondActivity.f1842b0), editable.toString(), seriesSecondActivity.O.g(), seriesSecondActivity.f1843c0);
                    seriesSecondActivity.R = D2;
                    seriesSecondActivity.Q.p(D2);
                    seriesSecondActivity.P.setSelectedPosition(0);
                    break;
                }
                break;
            case 8:
                LiveChannelMobileActivity liveChannelMobileActivity = (LiveChannelMobileActivity) obj;
                String obj9 = editable.toString();
                int i20 = liveChannelMobileActivity.Q0;
                if (i20 <= 4 || i20 >= liveChannelMobileActivity.f1942v0.s().size() + 5) {
                    liveChannelMobileActivity.f1928i0 = a6.n.K().w((CategoryModel) liveChannelMobileActivity.f1916b0.get(liveChannelMobileActivity.Q0), obj9, liveChannelMobileActivity.f1942v0.g(), liveChannelMobileActivity.f1942v0.o());
                } else if (liveChannelMobileActivity.f1942v0.s().size() > 0) {
                    a6.n K5 = a6.n.K();
                    app.shamel.tv.helper.r rVar3 = liveChannelMobileActivity.f1942v0;
                    liveChannelMobileActivity.f1928i0 = K5.s(obj9, rVar3.t((String) rVar3.s().get(liveChannelMobileActivity.Q0 - 5)));
                }
                liveChannelMobileActivity.f1918c0.q(-1, liveChannelMobileActivity.f1928i0);
                liveChannelMobileActivity.f1943w0.e0(0);
                break;
            case 9:
                LiveMobileActivity liveMobileActivity = (LiveMobileActivity) obj;
                String obj10 = editable.toString();
                int i21 = liveMobileActivity.R0;
                if (i21 <= 4 || i21 >= liveMobileActivity.f1978w0.s().size() + 5) {
                    liveMobileActivity.f1964j0 = a6.n.K().w((CategoryModel) liveMobileActivity.f1952c0.get(liveMobileActivity.R0), obj10, liveMobileActivity.f1978w0.g(), liveMobileActivity.f1978w0.o());
                } else if (liveMobileActivity.f1978w0.s().size() > 0) {
                    a6.n K6 = a6.n.K();
                    app.shamel.tv.helper.r rVar4 = liveMobileActivity.f1978w0;
                    liveMobileActivity.f1964j0 = K6.s(obj10, rVar4.t((String) rVar4.s().get(liveMobileActivity.R0 - 5)));
                }
                liveMobileActivity.f1954d0.q(-1, liveMobileActivity.f1964j0);
                liveMobileActivity.f1980y0.e0(0);
                break;
            case 10:
                ((h5.c0) obj).O(editable.toString());
                break;
            default:
                h5.s0 s0Var = (h5.s0) obj;
                s0Var.Q0.removeCallbacks(s0Var.I0);
                androidx.activity.j jVar = new androidx.activity.j(18, s0Var);
                s0Var.I0 = jVar;
                jVar.run();
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f1905o;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        int i13 = this.f1905o;
    }

    private final void a(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void b(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void c(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void d(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void e(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void f(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void g(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void h(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void i(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void j(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void k(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void l(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void m(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void n(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void o(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void p(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void q(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void r(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void s(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void t(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void u(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void v(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void w(int i10, int i11, int i12, CharSequence charSequence) {
    }

    private final void x(int i10, int i11, int i12, CharSequence charSequence) {
    }
}
