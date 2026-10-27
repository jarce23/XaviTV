package w3;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Messenger;
import android.util.Log;
import android.util.SparseArray;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends l {

    /* renamed from: f, reason: collision with root package name */
    public final String f12898f;
    public final MediaRouter2.RoutingController g;

    /* renamed from: h, reason: collision with root package name */
    public final Messenger f12899h;

    /* renamed from: i, reason: collision with root package name */
    public final Messenger f12900i;

    /* renamed from: k, reason: collision with root package name */
    public final Handler f12902k;

    /* renamed from: o, reason: collision with root package name */
    public i f12906o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ g f12907p;

    /* renamed from: j, reason: collision with root package name */
    public final SparseArray f12901j = new SparseArray();

    /* renamed from: l, reason: collision with root package name */
    public final AtomicInteger f12903l = new AtomicInteger(1);

    /* renamed from: m, reason: collision with root package name */
    public final w1.o f12904m = new w1.o(1, this);

    /* renamed from: n, reason: collision with root package name */
    public int f12905n = -1;

    public c(g gVar, MediaRouter2.RoutingController routingController, String str) {
        Bundle controlHints;
        this.f12907p = gVar;
        this.g = routingController;
        this.f12898f = str;
        int i10 = g.f12915r;
        controlHints = routingController.getControlHints();
        Messenger messenger = controlHints == null ? null : (Messenger) controlHints.getParcelable("androidx.mediarouter.media.KEY_MESSENGER");
        this.f12899h = messenger;
        this.f12900i = messenger != null ? new Messenger(new android.support.v4.media.session.q(this)) : null;
        this.f12902k = new Handler(Looper.getMainLooper());
    }

    @Override // w3.m
    public final void d() {
        this.g.release();
    }

    @Override // w3.m
    public final void f(int i10) {
        MediaRouter2.RoutingController routingController = this.g;
        if (routingController == null) {
            return;
        }
        routingController.setVolume(i10);
        this.f12905n = i10;
        Handler handler = this.f12902k;
        w1.o oVar = this.f12904m;
        handler.removeCallbacks(oVar);
        handler.postDelayed(oVar, 1000L);
    }

    @Override // w3.m
    public final void i(int i10) {
        int volumeMax;
        MediaRouter2.RoutingController routingController = this.g;
        if (routingController == null) {
            return;
        }
        int i11 = this.f12905n;
        if (i11 < 0) {
            i11 = routingController.getVolume();
        }
        int i12 = i11 + i10;
        volumeMax = this.g.getVolumeMax();
        int max = Math.max(0, Math.min(i12, volumeMax));
        this.f12905n = max;
        this.g.setVolume(max);
        Handler handler = this.f12902k;
        w1.o oVar = this.f12904m;
        handler.removeCallbacks(oVar);
        handler.postDelayed(oVar, 1000L);
    }

    @Override // w3.l
    public final void m(String str) {
        if (str == null || str.isEmpty()) {
            Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
            return;
        }
        MediaRoute2Info i10 = this.f12907p.i(str);
        if (i10 == null) {
            Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=".concat(str));
        } else {
            this.g.selectRoute(i10);
        }
    }

    @Override // w3.l
    public final void n(String str) {
        if (str == null || str.isEmpty()) {
            Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
            return;
        }
        MediaRoute2Info i10 = this.f12907p.i(str);
        if (i10 == null) {
            Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=".concat(str));
        } else {
            this.g.deselectRoute(i10);
        }
    }

    @Override // w3.l
    public final void o(List list) {
        if (list == null || list.isEmpty()) {
            Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
            return;
        }
        String str = (String) list.get(0);
        g gVar = this.f12907p;
        MediaRoute2Info i10 = gVar.i(str);
        if (i10 != null) {
            gVar.f12916i.transferTo(i10);
            return;
        }
        Log.w("MR2Provider", "onUpdateMemberRoutes: Specified route not found. routeId=" + str);
    }
}
