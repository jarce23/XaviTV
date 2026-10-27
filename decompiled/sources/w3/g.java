package w3;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$RouteCallback;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends n {

    /* renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f12915r = 0;

    /* renamed from: i, reason: collision with root package name */
    public final MediaRouter2 f12916i;

    /* renamed from: j, reason: collision with root package name */
    public final s f12917j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayMap f12918k;

    /* renamed from: l, reason: collision with root package name */
    public final MediaRouter2$RouteCallback f12919l;

    /* renamed from: m, reason: collision with root package name */
    public final f f12920m;

    /* renamed from: n, reason: collision with root package name */
    public final b f12921n;

    /* renamed from: o, reason: collision with root package name */
    public final u1.x f12922o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f12923p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayMap f12924q;

    static {
        Log.isLoggable("MR2Provider", 3);
    }

    public g(Context context, s sVar) {
        super(context, null);
        MediaRouter2 mediaRouter2;
        this.f12918k = new ArrayMap();
        this.f12920m = new f(this);
        this.f12921n = new b(this);
        this.f12923p = new ArrayList();
        this.f12924q = new ArrayMap();
        mediaRouter2 = MediaRouter2.getInstance(context);
        this.f12916i = mediaRouter2;
        this.f12917j = sVar;
        this.f12922o = new u1.x(new Handler(Looper.getMainLooper()), 0);
        if (Build.VERSION.SDK_INT >= 34) {
            this.f12919l = new e(this, 1);
        } else {
            this.f12919l = new e(this, 0);
        }
    }

    @Override // w3.n
    public final l c(String str) {
        Iterator it = this.f12918k.entrySet().iterator();
        while (it.hasNext()) {
            c cVar = (c) ((Map.Entry) it.next()).getValue();
            if (TextUtils.equals(str, cVar.f12898f)) {
                return cVar;
            }
        }
        return null;
    }

    @Override // w3.n
    public final m d(String str) {
        return new d((String) this.f12924q.get(str), null);
    }

    @Override // w3.n
    public final m e(String str, String str2) {
        String str3 = (String) this.f12924q.get(str);
        for (c cVar : this.f12918k.values()) {
            i iVar = cVar.f12906o;
            if (TextUtils.equals(str2, iVar != null ? iVar.d() : cVar.g.getId())) {
                return new d(str3, cVar);
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + str + ", routeGroupId=" + str2);
        return new d(str3, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0049  */
    @Override // w3.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(w3.j r15) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.g.f(w3.j):void");
    }

    public final MediaRoute2Info i(String str) {
        String id;
        if (str == null) {
            return null;
        }
        ArrayList arrayList = this.f12923p;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            MediaRoute2Info c10 = n0.c.c(obj);
            id = c10.getId();
            if (TextUtils.equals(id, str)) {
                return c10;
            }
        }
        return null;
    }

    public final void j() {
        List routes;
        Bundle extras;
        String id;
        boolean isSystemRoute;
        ArrayList arrayList = new ArrayList();
        ArraySet arraySet = new ArraySet();
        routes = this.f12916i.getRoutes();
        Iterator it = routes.iterator();
        while (it.hasNext()) {
            MediaRoute2Info c10 = n0.c.c(it.next());
            if (c10 != null && !arraySet.contains(c10)) {
                isSystemRoute = c10.isSystemRoute();
                if (!isSystemRoute) {
                    arraySet.add(c10);
                    arrayList.add(c10);
                }
            }
        }
        if (arrayList.equals(this.f12923p)) {
            return;
        }
        this.f12923p = arrayList;
        ArrayMap arrayMap = this.f12924q;
        arrayMap.clear();
        ArrayList arrayList2 = this.f12923p;
        int size = arrayList2.size();
        int i10 = 0;
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList2.get(i11);
            i11++;
            MediaRoute2Info c11 = n0.c.c(obj);
            extras = c11.getExtras();
            if (extras == null || extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") == null) {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + c11);
            } else {
                id = c11.getId();
                arrayMap.put(id, extras.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.f12923p;
        int size2 = arrayList4.size();
        int i12 = 0;
        while (i12 < size2) {
            Object obj2 = arrayList4.get(i12);
            i12++;
            MediaRoute2Info c12 = n0.c.c(obj2);
            i x6 = com.bumptech.glide.e.x(c12);
            if (c12 != null) {
                arrayList3.add(x6);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        if (!arrayList3.isEmpty()) {
            int size3 = arrayList3.size();
            while (i10 < size3) {
                Object obj3 = arrayList3.get(i10);
                i10++;
                i iVar = (i) obj3;
                if (iVar == null) {
                    throw new IllegalArgumentException("route must not be null");
                }
                if (arrayList5.contains(iVar)) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList5.add(iVar);
            }
        }
        g(new ea.a(arrayList5, true));
    }

    public final void k(MediaRouter2.RoutingController routingController) {
        List selectedRoutes;
        Bundle controlHints;
        h hVar;
        int volume;
        int volumeMax;
        int volumeHandling;
        List selectableRoutes;
        List deselectableRoutes;
        String id;
        c cVar = (c) this.f12918k.get(routingController);
        if (cVar == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + routingController);
            return;
        }
        selectedRoutes = routingController.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + routingController);
            return;
        }
        ArrayList m10 = com.bumptech.glide.e.m(selectedRoutes);
        int i10 = 0;
        i x6 = com.bumptech.glide.e.x(n0.c.c(selectedRoutes.get(0)));
        controlHints = routingController.getControlHints();
        String string = this.f12967a.getString(R.string.mr_dialog_default_group_name);
        i iVar = null;
        if (controlHints != null) {
            try {
                String string2 = controlHints.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if (!TextUtils.isEmpty(string2)) {
                    string = string2;
                }
                Bundle bundle = controlHints.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if (bundle != null) {
                    iVar = new i(bundle);
                }
            } catch (Exception e7) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", e7);
            }
        }
        if (iVar == null) {
            id = routingController.getId();
            hVar = new h(id, string);
            Bundle bundle2 = hVar.f12929a;
            bundle2.putInt("connectionState", 2);
            bundle2.putInt("playbackType", 1);
        } else {
            hVar = new h(iVar);
        }
        volume = routingController.getVolume();
        Bundle bundle3 = hVar.f12929a;
        bundle3.putInt("volume", volume);
        volumeMax = routingController.getVolumeMax();
        bundle3.putInt("volumeMax", volumeMax);
        volumeHandling = routingController.getVolumeHandling();
        bundle3.putInt("volumeHandling", volumeHandling);
        hVar.f12931c.clear();
        hVar.a(x6.b());
        ArrayList arrayList = hVar.f12930b;
        arrayList.clear();
        if (!m10.isEmpty()) {
            int size = m10.size();
            while (i10 < size) {
                Object obj = m10.get(i10);
                i10++;
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("groupMemberId must not be empty");
                }
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        i b2 = hVar.b();
        selectableRoutes = routingController.getSelectableRoutes();
        ArrayList m11 = com.bumptech.glide.e.m(selectableRoutes);
        deselectableRoutes = routingController.getDeselectableRoutes();
        ArrayList m12 = com.bumptech.glide.e.m(deselectableRoutes);
        ea.a aVar = this.g;
        if (aVar == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        List<i> list = (List) aVar.f4681c;
        if (!list.isEmpty()) {
            for (i iVar2 : list) {
                String d6 = iVar2.d();
                arrayList2.add(new k(iVar2, m10.contains(d6) ? 3 : 1, m12.contains(d6), m11.contains(d6), true));
            }
        }
        cVar.f12906o = b2;
        cVar.l(b2, arrayList2);
    }
}
