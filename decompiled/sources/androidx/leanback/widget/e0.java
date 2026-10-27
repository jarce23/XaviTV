package androidx.leanback.widget;

import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 implements TextWatcher {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d0 f1014o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SearchBar f1015p;

    public e0(SearchBar searchBar, d0 d0Var) {
        this.f1015p = searchBar;
        this.f1014o = d0Var;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        SearchBar searchBar = this.f1015p;
        Handler handler = searchBar.f957v;
        if (searchBar.J) {
            return;
        }
        d0 d0Var = this.f1014o;
        handler.removeCallbacks(d0Var);
        handler.post(d0Var);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
