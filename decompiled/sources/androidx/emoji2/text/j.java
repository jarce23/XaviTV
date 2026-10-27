package androidx.emoji2.text;

import androidx.leanback.widget.SearchBar;
import androidx.work.impl.foreground.SystemForegroundService;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f572o;

    /* renamed from: p, reason: collision with root package name */
    public final int f573p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f574q;

    public /* synthetic */ j(int i10, int i11, Object obj) {
        this.f572o = i11;
        this.f574q = obj;
        this.f573p = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f572o) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f574q;
                int size = arrayList.size();
                int i10 = 0;
                if (this.f573p == 1) {
                    while (i10 < size) {
                        ((i) arrayList.get(i10)).b();
                        i10++;
                    }
                    break;
                } else {
                    while (i10 < size) {
                        ((i) arrayList.get(i10)).a();
                        i10++;
                    }
                    break;
                }
            case 1:
                SearchBar searchBar = (SearchBar) this.f574q;
                searchBar.H.play(searchBar.I.get(this.f573p), 1.0f, 1.0f, 1, 0, 1.0f);
                break;
            case 2:
                ((com.google.android.material.datepicker.l) this.f574q).f3764o0.h0(this.f573p);
                break;
            case 3:
                d0.b bVar = (d0.b) ((a6.n) this.f574q).f74p;
                if (bVar != null) {
                    bVar.i(this.f573p);
                    break;
                }
                break;
            case 4:
                ((l7.w) this.f574q).C.b(this.f573p);
                break;
            case 5:
                ((p7.k) this.f574q).b(this.f573p);
                break;
            default:
                ((SystemForegroundService) this.f574q).f1554s.cancel(this.f573p);
                break;
        }
    }

    public j(List list, int i10, Throwable th) {
        this.f572o = 0;
        y7.d.d("initCallbacks cannot be null", list);
        this.f574q = new ArrayList(list);
        this.f573p = i10;
    }
}
