package i7;

import android.util.Log;
import com.google.android.gms.common.api.Status;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f6517b;

    public /* synthetic */ p(c cVar, int i10) {
        this.f6516a = i10;
        this.f6517b = cVar;
    }

    public final void a(o7.j jVar) {
        l lVar = (l) jVar;
        switch (this.f6516a) {
            case 0:
                Status a10 = lVar.a();
                int i10 = a10.f3193o;
                c cVar = this.f6517b;
                if (i10 != 0) {
                    l7.b bVar = cVar.f6469a;
                    Log.w(bVar.f8271a, bVar.d("Error fetching queue item ids, statusCode=" + i10 + ", statusMessage=" + a10.f3194p, new Object[0]));
                }
                cVar.f6479l = null;
                if (!cVar.f6475h.isEmpty()) {
                    b8.e eVar = cVar.f6476i;
                    q qVar = cVar.f6477j;
                    eVar.removeCallbacks(qVar);
                    eVar.postDelayed(qVar, 500L);
                    break;
                }
                break;
            default:
                Status a11 = lVar.a();
                int i11 = a11.f3193o;
                c cVar2 = this.f6517b;
                if (i11 != 0) {
                    l7.b bVar2 = cVar2.f6469a;
                    Log.w(bVar2.f8271a, bVar2.d("Error fetching queue items, statusCode=" + i11 + ", statusMessage=" + a11.f3194p, new Object[0]));
                }
                cVar2.f6478k = null;
                if (!cVar2.f6475h.isEmpty()) {
                    b8.e eVar2 = cVar2.f6476i;
                    q qVar2 = cVar2.f6477j;
                    eVar2.removeCallbacks(qVar2);
                    eVar2.postDelayed(qVar2, 500L);
                    break;
                }
                break;
        }
    }
}
