package i5;

import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieModel;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ int f6401i;

    public /* synthetic */ a(int i10) {
        this.f6401i = i10;
    }

    @Override // i5.e
    public final Object a() {
        switch (this.f6401i) {
            case 0:
                LTVApp a10 = LTVApp.a();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = a10.f2091o;
                int size = arrayList2.size();
                int i10 = 0;
                int i11 = 0;
                while (i11 < size) {
                    Object obj = arrayList2.get(i11);
                    i11++;
                    EPGChannel fromM3UItem = EPGChannel.fromM3UItem((ja.a) obj);
                    if (fromM3UItem != null) {
                        i10++;
                        fromM3UItem.setNum(String.valueOf(i10));
                        arrayList.add(fromM3UItem);
                    }
                }
                return arrayList;
            case 1:
                LTVApp a11 = LTVApp.a();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = a11.f2093q;
                int size2 = arrayList4.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList4.get(i12);
                    i12++;
                    EpisodeModel fromM3UItem2 = EpisodeModel.fromM3UItem((ja.a) obj2);
                    if (fromM3UItem2 != null) {
                        arrayList3.add(fromM3UItem2);
                    }
                }
                return arrayList3;
            default:
                new HashMap();
                LTVApp a12 = LTVApp.a();
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = a12.f2092p;
                int size3 = arrayList6.size();
                int i13 = 0;
                int i14 = 0;
                while (i14 < size3) {
                    Object obj3 = arrayList6.get(i14);
                    i14++;
                    MovieModel fromM3UItem3 = MovieModel.fromM3UItem((ja.a) obj3);
                    if (fromM3UItem3 != null) {
                        i13++;
                        fromM3UItem3.setNum(i13);
                        arrayList5.add(fromM3UItem3);
                    }
                }
                return arrayList5;
        }
    }

    @Override // i5.e, android.os.AsyncTask
    public final void onPreExecute() {
        int i10 = this.f6401i;
    }

    private final void b() {
    }

    private final void c() {
    }

    private final void d() {
    }
}
