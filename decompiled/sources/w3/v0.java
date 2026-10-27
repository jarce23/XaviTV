package w3;

import android.content.ComponentName;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaRouter;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import java.util.ArrayList;
import java.util.Locale;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class v0 extends w0 implements e0, c0 {

    /* renamed from: s, reason: collision with root package name */
    public static final ArrayList f13018s;

    /* renamed from: t, reason: collision with root package name */
    public static final ArrayList f13019t;

    /* renamed from: i, reason: collision with root package name */
    public final w f13020i;

    /* renamed from: j, reason: collision with root package name */
    public final MediaRouter f13021j;

    /* renamed from: k, reason: collision with root package name */
    public final MediaRouter.Callback f13022k;

    /* renamed from: l, reason: collision with root package name */
    public final d0 f13023l;

    /* renamed from: m, reason: collision with root package name */
    public final MediaRouter.RouteCategory f13024m;

    /* renamed from: n, reason: collision with root package name */
    public int f13025n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f13026o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f13027p;

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f13028q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f13029r;

    static {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addCategory("android.media.intent.category.LIVE_AUDIO");
        ArrayList arrayList = new ArrayList();
        f13018s = arrayList;
        arrayList.add(intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addCategory("android.media.intent.category.LIVE_VIDEO");
        ArrayList arrayList2 = new ArrayList();
        f13019t = arrayList2;
        arrayList2.add(intentFilter2);
    }

    public v0(Context context, w wVar) {
        super(context, new p4.p(26, new ComponentName("android", w0.class.getName())));
        this.f13028q = new ArrayList();
        this.f13029r = new ArrayList();
        this.f13020i = wVar;
        MediaRouter mediaRouter = (MediaRouter) context.getSystemService("media_router");
        this.f13021j = mediaRouter;
        this.f13022k = new f0(this);
        this.f13023l = new d0(this);
        this.f13024m = mediaRouter.createRouteCategory((CharSequence) context.getResources().getString(R.string.mr_user_route_category_name), false);
        x();
    }

    public static u0 o(MediaRouter.RouteInfo routeInfo) {
        Object tag = routeInfo.getTag();
        if (tag instanceof u0) {
            return (u0) tag;
        }
        return null;
    }

    @Override // w3.c0
    public final void a(MediaRouter.RouteInfo routeInfo, int i10) {
        u0 o2 = o(routeInfo);
        if (o2 != null) {
            o2.f13016a.j(i10);
        }
    }

    @Override // w3.c0
    public final void b(MediaRouter.RouteInfo routeInfo, int i10) {
        u0 o2 = o(routeInfo);
        if (o2 != null) {
            o2.f13016a.k(i10);
        }
    }

    @Override // w3.n
    public final m d(String str) {
        int k10 = k(str);
        if (k10 >= 0) {
            return new s0(((t0) this.f13028q.get(k10)).f13010a);
        }
        return null;
    }

    @Override // w3.n
    public final void f(j jVar) {
        boolean z10;
        int i10 = 0;
        if (jVar != null) {
            jVar.a();
            ArrayList c10 = jVar.f12939b.c();
            int size = c10.size();
            int i11 = 0;
            while (i10 < size) {
                String str = (String) c10.get(i10);
                i11 = str.equals("android.media.intent.category.LIVE_AUDIO") ? i11 | 1 : str.equals("android.media.intent.category.LIVE_VIDEO") ? i11 | 2 : i11 | 8388608;
                i10++;
            }
            z10 = jVar.b();
            i10 = i11;
        } else {
            z10 = false;
        }
        if (this.f13025n == i10 && this.f13026o == z10) {
            return;
        }
        this.f13025n = i10;
        this.f13026o = z10;
        x();
    }

    public final boolean i(MediaRouter.RouteInfo routeInfo) {
        String format;
        String str;
        if (o(routeInfo) != null || j(routeInfo) >= 0) {
            return false;
        }
        Object n10 = n();
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        Context context = this.f12967a;
        if (n10 == routeInfo) {
            format = "DEFAULT_ROUTE";
        } else {
            Locale locale = Locale.US;
            CharSequence name = routeInfo.getName(context);
            format = String.format(locale, "ROUTE_%08x", Integer.valueOf((name != null ? name.toString() : _UrlKt.FRAGMENT_ENCODE_SET).hashCode()));
        }
        if (k(format) >= 0) {
            int i10 = 2;
            while (true) {
                Locale locale2 = Locale.US;
                str = format + "_" + i10;
                if (k(str) < 0) {
                    break;
                }
                i10++;
            }
            format = str;
        }
        t0 t0Var = new t0(routeInfo, format);
        CharSequence name2 = routeInfo.getName(context);
        if (name2 != null) {
            str2 = name2.toString();
        }
        h hVar = new h(format, str2);
        q(t0Var, hVar);
        t0Var.f13012c = hVar.b();
        this.f13028q.add(t0Var);
        return true;
    }

    public final int j(MediaRouter.RouteInfo routeInfo) {
        ArrayList arrayList = this.f13028q;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((t0) arrayList.get(i10)).f13010a == routeInfo) {
                return i10;
            }
        }
        return -1;
    }

    public final int k(String str) {
        ArrayList arrayList = this.f13028q;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((t0) arrayList.get(i10)).f13011b.equals(str)) {
                return i10;
            }
        }
        return -1;
    }

    public final int l(z zVar) {
        ArrayList arrayList = this.f13029r;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((u0) arrayList.get(i10)).f13016a == zVar) {
                return i10;
            }
        }
        return -1;
    }

    public MediaRouter.RouteInfo m() {
        return this.f13021j.getDefaultRoute();
    }

    public /* bridge */ Object n() {
        return m();
    }

    public boolean p(t0 t0Var) {
        return t0Var.f13010a.isConnecting();
    }

    public void q(t0 t0Var, h hVar) {
        Display display;
        MediaRouter.RouteInfo routeInfo = t0Var.f13010a;
        int supportedTypes = routeInfo.getSupportedTypes();
        if ((supportedTypes & 1) != 0) {
            hVar.a(f13018s);
        }
        if ((supportedTypes & 2) != 0) {
            hVar.a(f13019t);
        }
        int playbackType = routeInfo.getPlaybackType();
        Bundle bundle = hVar.f12929a;
        Bundle bundle2 = hVar.f12929a;
        bundle.putInt("playbackType", playbackType);
        bundle2.putInt("playbackStream", routeInfo.getPlaybackStream());
        bundle2.putInt("volume", routeInfo.getVolume());
        bundle2.putInt("volumeMax", routeInfo.getVolumeMax());
        bundle2.putInt("volumeHandling", routeInfo.getVolumeHandling());
        Bundle bundle3 = hVar.f12929a;
        MediaRouter.RouteInfo routeInfo2 = t0Var.f13010a;
        if (!routeInfo2.isEnabled()) {
            bundle3.putBoolean("enabled", false);
        }
        if (p(t0Var)) {
            bundle3.putInt("connectionState", 1);
        }
        try {
            display = routeInfo2.getPresentationDisplay();
        } catch (NoSuchMethodError e7) {
            Log.w("MediaRouterJellybeanMr1", "Cannot get presentation display for the route.", e7);
            display = null;
        }
        if (display != null) {
            bundle3.putInt("presentationDisplayId", display.getDisplayId());
        }
        CharSequence description = t0Var.f13010a.getDescription();
        if (description != null) {
            hVar.f12929a.putString("status", description.toString());
        }
    }

    public final void r(z zVar) {
        n c10 = zVar.c();
        MediaRouter mediaRouter = this.f13021j;
        if (c10 == this) {
            int j10 = j(mediaRouter.getSelectedRoute(8388611));
            if (j10 < 0 || !((t0) this.f13028q.get(j10)).f13011b.equals(zVar.f13070b)) {
                return;
            }
            zVar.l();
            return;
        }
        MediaRouter.UserRouteInfo createUserRoute = mediaRouter.createUserRoute(this.f13024m);
        u0 u0Var = new u0(zVar, createUserRoute);
        createUserRoute.setTag(u0Var);
        createUserRoute.setVolumeCallback(this.f13023l);
        y(u0Var);
        this.f13029r.add(u0Var);
        mediaRouter.addUserRoute(createUserRoute);
    }

    public final void s(z zVar) {
        int l10;
        if (zVar.c() == this || (l10 = l(zVar)) < 0) {
            return;
        }
        MediaRouter.UserRouteInfo userRouteInfo = ((u0) this.f13029r.remove(l10)).f13017b;
        userRouteInfo.setTag(null);
        userRouteInfo.setVolumeCallback(null);
        try {
            this.f13021j.removeUserRoute(userRouteInfo);
        } catch (IllegalArgumentException e7) {
            Log.w("MediaRouterJellybean", "Failed to remove user route", e7);
        }
    }

    public final void t(z zVar) {
        if (zVar.g()) {
            if (zVar.c() != this) {
                int l10 = l(zVar);
                if (l10 >= 0) {
                    v(((u0) this.f13029r.get(l10)).f13017b);
                    return;
                }
                return;
            }
            int k10 = k(zVar.f13070b);
            if (k10 >= 0) {
                v(((t0) this.f13028q.get(k10)).f13010a);
            }
        }
    }

    public final void u() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f13028q;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            i iVar = ((t0) arrayList2.get(i10)).f13012c;
            if (iVar == null) {
                throw new IllegalArgumentException("route must not be null");
            }
            if (arrayList.contains(iVar)) {
                throw new IllegalArgumentException("route descriptor already added");
            }
            arrayList.add(iVar);
        }
        g(new ea.a(arrayList, false));
    }

    public void v(MediaRouter.RouteInfo routeInfo) {
        this.f13021j.selectRoute(8388611, routeInfo);
    }

    public void w() {
        boolean z10 = this.f13027p;
        MediaRouter.Callback callback = this.f13022k;
        MediaRouter mediaRouter = this.f13021j;
        if (z10) {
            mediaRouter.removeCallback(callback);
        }
        this.f13027p = true;
        mediaRouter.addCallback(this.f13025n, callback, (this.f13026o ? 1 : 0) | 2);
    }

    public final void x() {
        w();
        MediaRouter mediaRouter = this.f13021j;
        int routeCount = mediaRouter.getRouteCount();
        ArrayList arrayList = new ArrayList(routeCount);
        boolean z10 = false;
        for (int i10 = 0; i10 < routeCount; i10++) {
            arrayList.add(mediaRouter.getRouteAt(i10));
        }
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            z10 |= i((MediaRouter.RouteInfo) obj);
        }
        if (z10) {
            u();
        }
    }

    public void y(u0 u0Var) {
        MediaRouter.UserRouteInfo userRouteInfo = u0Var.f13017b;
        z zVar = u0Var.f13016a;
        userRouteInfo.setName(zVar.f13072d);
        MediaRouter.UserRouteInfo userRouteInfo2 = u0Var.f13017b;
        userRouteInfo2.setPlaybackType(zVar.f13078k);
        userRouteInfo2.setPlaybackStream(zVar.f13079l);
        userRouteInfo2.setVolume(zVar.f13082o);
        userRouteInfo2.setVolumeMax(zVar.f13083p);
        userRouteInfo2.setVolumeHandling((!zVar.e() || b0.h()) ? zVar.f13081n : 0);
        u0Var.f13017b.setDescription(u0Var.f13016a.f13073e);
    }
}
