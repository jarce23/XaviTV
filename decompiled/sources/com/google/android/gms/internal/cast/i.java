package com.google.android.gms.internal.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends w3.p {

    /* renamed from: b, reason: collision with root package name */
    public static final l7.b f3333b = new l7.b("MediaRouterCallback", null);

    /* renamed from: a, reason: collision with root package name */
    public final h f3334a;

    public i(h hVar) {
        r7.r.e(hVar);
        this.f3334a = hVar;
    }

    @Override // w3.p
    public final void d(w3.z zVar) {
        try {
            h hVar = this.f3334a;
            String str = zVar.f13071c;
            Bundle bundle = zVar.f13085r;
            Parcel w02 = hVar.w0();
            w02.writeString(str);
            u.c(w02, bundle);
            hVar.y0(w02, 1);
        } catch (RemoteException e7) {
            f3333b.a(e7, "Unable to call %s on %s.", "onRouteAdded", h.class.getSimpleName());
        }
    }

    @Override // w3.p
    public final void e(w3.z zVar) {
        try {
            h hVar = this.f3334a;
            String str = zVar.f13071c;
            Bundle bundle = zVar.f13085r;
            Parcel w02 = hVar.w0();
            w02.writeString(str);
            u.c(w02, bundle);
            hVar.y0(w02, 2);
        } catch (RemoteException e7) {
            f3333b.a(e7, "Unable to call %s on %s.", "onRouteChanged", h.class.getSimpleName());
        }
    }

    @Override // w3.p
    public final void f(w3.z zVar) {
        try {
            h hVar = this.f3334a;
            String str = zVar.f13071c;
            Bundle bundle = zVar.f13085r;
            Parcel w02 = hVar.w0();
            w02.writeString(str);
            u.c(w02, bundle);
            hVar.y0(w02, 3);
        } catch (RemoteException e7) {
            f3333b.a(e7, "Unable to call %s on %s.", "onRouteRemoved", h.class.getSimpleName());
        }
    }

    @Override // w3.p
    public final void h(w3.b0 b0Var, w3.z zVar, int i10) {
        CastDevice b2;
        String str;
        CastDevice b10;
        h hVar = this.f3334a;
        Integer valueOf = Integer.valueOf(i10);
        String str2 = zVar.f13071c;
        l7.b bVar = f3333b;
        Log.i(bVar.f8271a, bVar.d("onRouteSelected with reason = %d, routeId = %s", valueOf, str2));
        if (zVar.f13078k != 1) {
            return;
        }
        if (str2 != null) {
            try {
                if (str2.endsWith("-groupRoute") && (b2 = CastDevice.b(zVar.f13085r)) != null) {
                    String str3 = b2.f3128o;
                    if (str3.startsWith("__cast_nearby__")) {
                        str3 = str3.substring(16);
                    }
                    for (w3.z zVar2 : w3.b0.f()) {
                        str = zVar2.f13071c;
                        if (str != null && !str.endsWith("-groupRoute") && (b10 = CastDevice.b(zVar2.f13085r)) != null) {
                            String str4 = b10.f3128o;
                            if (str4.startsWith("__cast_nearby__")) {
                                str4 = str4.substring(16);
                            }
                            if (TextUtils.equals(str4, str3)) {
                                bVar.b("routeId is changed from %s to %s", str2, str);
                                break;
                            }
                        }
                    }
                }
            } catch (RemoteException e7) {
                bVar.a(e7, "Unable to call %s on %s.", "onRouteSelected", h.class.getSimpleName());
                return;
            }
        }
        str = str2;
        Parcel x02 = hVar.x0(hVar.w0(), 7);
        int readInt = x02.readInt();
        x02.recycle();
        if (readInt < 220400000) {
            Bundle bundle = zVar.f13085r;
            Parcel w02 = hVar.w0();
            w02.writeString(str);
            u.c(w02, bundle);
            hVar.y0(w02, 4);
            return;
        }
        Bundle bundle2 = zVar.f13085r;
        Parcel w03 = hVar.w0();
        w03.writeString(str);
        w03.writeString(str2);
        u.c(w03, bundle2);
        hVar.y0(w03, 8);
    }

    @Override // w3.p
    public final void j(w3.b0 b0Var, w3.z zVar, int i10) {
        Integer valueOf = Integer.valueOf(i10);
        String str = zVar.f13071c;
        l7.b bVar = f3333b;
        Log.i(bVar.f8271a, bVar.d("onRouteUnselected with reason = %d, routeId = %s", valueOf, str));
        if (zVar.f13078k != 1) {
            bVar.b("skip route unselection for non-cast route", new Object[0]);
            return;
        }
        try {
            h hVar = this.f3334a;
            Bundle bundle = zVar.f13085r;
            Parcel w02 = hVar.w0();
            w02.writeString(str);
            u.c(w02, bundle);
            w02.writeInt(i10);
            hVar.y0(w02, 6);
        } catch (RemoteException e7) {
            bVar.a(e7, "Unable to call %s on %s.", "onRouteUnselected", h.class.getSimpleName());
        }
    }
}
