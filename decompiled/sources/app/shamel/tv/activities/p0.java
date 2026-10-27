package app.shamel.tv.activities;

import android.content.Intent;
import app.shamel.tv.activities.mobile.LiveMobileActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import java.io.Serializable;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p0 implements ya.q {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2042o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SearchActivity f2043p;

    public /* synthetic */ p0(SearchActivity searchActivity, int i10) {
        this.f2042o = i10;
        this.f2043p = searchActivity;
    }

    @Override // ya.q
    public final Object c(Object obj, Serializable serializable, Serializable serializable2) {
        int i10;
        int i11 = this.f2042o;
        String str = "UnNamed Category";
        SearchActivity searchActivity = this.f2043p;
        boolean z10 = true;
        int i12 = 0;
        switch (i11) {
            case 0:
                EPGChannel ePGChannel = (EPGChannel) obj;
                int i13 = SearchActivity.f1784d0;
                if (((Boolean) serializable2).booleanValue()) {
                    a6.n.K().l(ePGChannel.getName(), true, new a6.a0(3));
                    e5.l.a(searchActivity, searchActivity.R.h());
                    ArrayList arrayList = LTVApp.f2087v;
                    if (searchActivity.R.g()) {
                        String category_name = ePGChannel.getCategory_name();
                        i10 = 0;
                        while (true) {
                            if (i10 >= arrayList.size()) {
                                i10 = 0;
                            } else if (!((CategoryModel) arrayList.get(i10)).getName().equalsIgnoreCase(category_name)) {
                                i10++;
                            }
                        }
                    } else {
                        String category_id = ePGChannel.getCategory_id();
                        i10 = 0;
                        for (int i14 = 0; i14 < arrayList.size(); i14++) {
                            if (((CategoryModel) arrayList.get(i14)).getId().equalsIgnoreCase(category_id)) {
                                i10 = i14;
                            }
                        }
                    }
                    io.realm.n0 w10 = a6.n.K().w((CategoryModel) arrayList.get(i10), _UrlKt.FRAGMENT_ENCODE_SET, searchActivity.R.g(), searchActivity.R.o());
                    int i15 = 0;
                    while (true) {
                        if (i15 < w10.size()) {
                            EPGChannel ePGChannel2 = (EPGChannel) w10.get(i15);
                            if (ePGChannel.getName() == null || ePGChannel2 == null || ePGChannel2.getName() == null || !ePGChannel.getName().equalsIgnoreCase(ePGChannel2.getName())) {
                                i15++;
                            } else {
                                i12 = i15;
                            }
                        }
                    }
                    searchActivity.R.M(i10);
                    searchActivity.R.N(i12);
                    if (searchActivity.f1786b0) {
                        Intent intent = new Intent();
                        intent.putExtra("is_changed", "from_search");
                        searchActivity.setResult(-1, intent);
                        searchActivity.finish();
                        break;
                    } else if (app.shamel.tv.helper.a.l(searchActivity)) {
                        Intent intent2 = new Intent(searchActivity, (Class<?>) LiveActivity.class);
                        intent2.putExtra("is_full", true);
                        searchActivity.startActivity(intent2);
                        break;
                    } else {
                        Intent intent3 = new Intent(searchActivity, (Class<?>) LiveMobileActivity.class);
                        intent3.putExtra("is_full", true);
                        searchActivity.startActivity(intent3);
                        break;
                    }
                }
                break;
            case 1:
                MovieModel movieModel = (MovieModel) obj;
                int i16 = SearchActivity.f1784d0;
                if (((Boolean) serializable2).booleanValue()) {
                    String category_name2 = movieModel.getCategory_name();
                    String category_id2 = movieModel.getCategory_id();
                    SearchActivity searchActivity2 = this.f2043p;
                    if (!searchActivity2.R.g()) {
                        z10 = e5.l.f4607b.contains(category_id2);
                    } else if (!category_name2.contains("xxx") && !category_name2.contains("porn") && !category_name2.contains("adult")) {
                        z10 = false;
                    }
                    if (z10) {
                        String name = movieModel.getName();
                        String stream_id = movieModel.getStream_id();
                        androidx.fragment.app.j0 n10 = searchActivity2.n();
                        androidx.fragment.app.a i17 = android.support.v4.media.d.i(n10, n10);
                        androidx.fragment.app.s A = n10.A("fragment_lock");
                        if (A != null) {
                            android.support.v4.media.d.v(i17, A, false);
                            break;
                        } else {
                            h5.h0 N = h5.h0.N(searchActivity2.R.u());
                            N.f5607z0 = new android.support.v4.media.session.a0(searchActivity2, name, stream_id, 4, false);
                            N.M(n10, "fragment_lock");
                            break;
                        }
                    } else {
                        Intent intent4 = new Intent(searchActivity2, (Class<?>) MovieInfoActivity.class);
                        intent4.putExtra("name", movieModel.getName());
                        intent4.putExtra("stream_id", movieModel.getStream_id());
                        if (searchActivity2.R.g()) {
                            intent4.putExtra("category_name", movieModel.getCategory_name());
                        } else {
                            String category_id3 = movieModel.getCategory_id();
                            ArrayList arrayList2 = LTVApp.f2088w;
                            int size = arrayList2.size();
                            while (true) {
                                if (i12 < size) {
                                    Object obj2 = arrayList2.get(i12);
                                    i12++;
                                    CategoryModel categoryModel = (CategoryModel) obj2;
                                    if (categoryModel.getId().equalsIgnoreCase(category_id3)) {
                                        str = categoryModel.getName();
                                    }
                                }
                            }
                            intent4.putExtra("category_name", str);
                        }
                        searchActivity2.startActivity(intent4);
                        break;
                    }
                }
                break;
            default:
                SeriesModel seriesModel = (SeriesModel) obj;
                int i18 = SearchActivity.f1784d0;
                if (((Boolean) serializable2).booleanValue()) {
                    Intent intent5 = new Intent(searchActivity, (Class<?>) SeriesInfoActivity.class);
                    intent5.putExtra("name", seriesModel.getName());
                    intent5.putExtra("series_id", seriesModel.getSeries_id());
                    if (searchActivity.R.g()) {
                        intent5.putExtra("category_name", seriesModel.getCategory_name());
                    } else {
                        String category_id4 = seriesModel.getCategory_id();
                        ArrayList arrayList3 = LTVApp.f2088w;
                        int size2 = arrayList3.size();
                        while (true) {
                            if (i12 < size2) {
                                Object obj3 = arrayList3.get(i12);
                                i12++;
                                CategoryModel categoryModel2 = (CategoryModel) obj3;
                                if (categoryModel2.getId().equalsIgnoreCase(category_id4)) {
                                    str = categoryModel2.getName();
                                }
                            }
                        }
                        intent5.putExtra("category_name", str);
                    }
                    searchActivity.startActivity(intent5);
                    break;
                }
                break;
        }
        return null;
    }
}
