package x1;

import android.net.Uri;
import android.os.SystemClock;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import l1.a0;
import o1.x;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements t {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ c f13330o;

    public a(c cVar) {
        this.f13330o = cVar;
    }

    @Override // x1.t
    public final void b() {
        this.f13330o.f13347s.remove(this);
    }

    @Override // x1.t
    public final boolean c(Uri uri, app.shamel.tv.b bVar, boolean z10) {
        b bVar2;
        int i10;
        c cVar = this.f13330o;
        HashMap hashMap = cVar.f13346r;
        if (cVar.f13354z == null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            o oVar = cVar.f13352x;
            int i11 = a0.f8067a;
            List list = oVar.f13442e;
            int i12 = 0;
            for (int i13 = 0; i13 < list.size(); i13++) {
                b bVar3 = (b) hashMap.get(((n) list.get(i13)).f13434a);
                if (bVar3 != null && elapsedRealtime < bVar3.f13338v) {
                    i12++;
                }
            }
            int size = cVar.f13352x.f13442e.size();
            cVar.f13345q.getClass();
            IOException iOException = (IOException) bVar.f2096q;
            g2.h hVar = ((iOException instanceof x) && ((i10 = ((x) iOException).f9462r) == 403 || i10 == 404 || i10 == 410 || i10 == 416 || i10 == 500 || i10 == 503) && size - i12 > 1) ? new g2.h(2, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) : null;
            if (hVar != null && hVar.f5115a == 2 && (bVar2 = (b) hashMap.get(uri)) != null) {
                b.a(bVar2, hVar.f5116b);
            }
        }
        return false;
    }
}
