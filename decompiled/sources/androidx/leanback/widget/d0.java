package androidx.leanback.widget;

import android.os.SystemClock;
import android.view.MotionEvent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1012o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ SearchBar f1013p;

    public /* synthetic */ d0(SearchBar searchBar, int i10) {
        this.f1012o = i10;
        this.f1013p = searchBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1012o) {
            case 0:
                SearchBar searchBar = this.f1013p;
                searchBar.setSearchQueryInternal(searchBar.f950o.getText().toString());
                break;
            default:
                SearchBar searchBar2 = this.f1013p;
                searchBar2.f950o.requestFocusFromTouch();
                searchBar2.f950o.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, searchBar2.f950o.getWidth(), searchBar2.f950o.getHeight(), 0));
                searchBar2.f950o.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, searchBar2.f950o.getWidth(), searchBar2.f950o.getHeight(), 0));
                break;
        }
    }
}
