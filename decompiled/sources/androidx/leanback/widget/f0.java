package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 implements TextView.OnEditorActionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchBar f1018a;

    public f0(SearchBar searchBar) {
        this.f1018a = searchBar;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
        if (2 != i10) {
            return false;
        }
        SearchBar searchBar = this.f1018a;
        searchBar.f958w.hideSoftInputFromWindow(searchBar.f950o.getWindowToken(), 0);
        searchBar.f957v.postDelayed(new androidx.activity.j(5, this), 500L);
        return true;
    }
}
