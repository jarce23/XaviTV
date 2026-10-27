package e5;

import android.widget.Toast;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.EPGChannel;
import io.realm.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements i5.d, i5.c {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4582o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ k f4583p;

    public /* synthetic */ b(k kVar, int i10) {
        this.f4582o = i10;
        this.f4583p = kVar;
    }

    @Override // i5.d
    public void a() {
        switch (this.f4582o) {
            case 0:
                this.f4583p.x();
                break;
            case 1:
                k.O(false);
                k kVar = this.f4583p;
                if (!kVar.Y) {
                    kVar.w(true);
                    break;
                }
                break;
            default:
                this.f4583p.C();
                break;
        }
    }

    @Override // i5.c
    public void c(Object obj) {
        List list = (List) obj;
        boolean isEmpty = list.isEmpty();
        k kVar = this.f4583p;
        int i10 = 0;
        if (isEmpty) {
            kVar.w(false);
            Toast.makeText(kVar.getApplicationContext(), kVar.X.getUser_incorrect(), 0).show();
        } else if (!kVar.Y) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Iterator it = list.iterator();
            while (true) {
                char c10 = 2;
                if (!it.hasNext()) {
                    break;
                }
                ja.a aVar = (ja.a) it.next();
                String str = aVar.f7513h;
                if (str == null || str.length() <= 0) {
                    c10 = 65535;
                } else if (str.contains("movie/") || str.contains("=movie") || str.contains("==movie") || str.contains("movies/") || str.contains("vod/") || str.contains("video/")) {
                    c10 = 1;
                } else if (!str.contains("series/")) {
                    c10 = 0;
                }
                if (c10 != 65535) {
                    if (c10 == 0) {
                        arrayList.add(aVar);
                    } else if (c10 == 1) {
                        arrayList2.add(aVar);
                    } else {
                        arrayList3.add(aVar);
                    }
                }
            }
            LTVApp lTVApp = kVar.f4605a0;
            lTVApp.f2091o = arrayList;
            lTVApp.f2092p = arrayList2;
            lTVApp.f2093q = arrayList3;
            n0 d6 = kVar.U.V(EPGChannel.class).d();
            List m10 = kVar.T.m();
            List n10 = kVar.T.n();
            if (d6.isEmpty() || System.currentTimeMillis() / 1000 > (kVar.T.G() * 72000) + kVar.T.l()) {
                i5.a aVar2 = kVar.O;
                if (aVar2 != null && !aVar2.g) {
                    aVar2.f6409h = true;
                    aVar2.cancel(true);
                }
                i5.a aVar3 = new i5.a(i10);
                kVar.O = aVar3;
                aVar3.f6406d = new a(kVar, d6, m10, n10, 1);
                aVar3.f6407e = new b(kVar, 4);
                aVar3.execute(null, null);
            } else if (!kVar.Y) {
                kVar.z(new ArrayList(d6));
            }
        }
        k.O(false);
    }
}
