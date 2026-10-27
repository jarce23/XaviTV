package androidx.leanback.widget;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1010o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SearchBar f1011p;

    public /* synthetic */ c0(SearchBar searchBar, int i10) {
        this.f1010o = i10;
        this.f1011p = searchBar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f1010o) {
            case 0:
                SearchBar searchBar = this.f1011p;
                if (z10) {
                    searchBar.f957v.post(new d0(searchBar, 1));
                } else {
                    searchBar.f958w.hideSoftInputFromWindow(searchBar.f950o.getWindowToken(), 0);
                }
                searchBar.d(z10);
                break;
            default:
                SearchBar searchBar2 = this.f1011p;
                if (z10) {
                    searchBar2.f958w.hideSoftInputFromWindow(searchBar2.f950o.getWindowToken(), 0);
                    if (searchBar2.f959x) {
                        searchBar2.a();
                        searchBar2.f959x = false;
                    }
                } else {
                    searchBar2.b();
                }
                searchBar2.d(z10);
                break;
        }
    }
}
