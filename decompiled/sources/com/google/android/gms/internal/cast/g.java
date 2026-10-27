package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g extends c8.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3309c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(String str, int i10) {
        super(str, 1);
        this.f3309c = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        int i11 = 0;
        r4 = 0;
        int i12 = 0;
        i11 = 0;
        i11 = 0;
        int i13 = 2;
        switch (this.f3309c) {
            case 0:
                h hVar = null;
                Bundle bundle = null;
                switch (i10) {
                    case 1:
                        Bundle bundle2 = (Bundle) u.a(parcel, Bundle.CREATOR);
                        IBinder readStrongBinder = parcel.readStrongBinder();
                        if (readStrongBinder != null) {
                            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.IMediaRouterCallback");
                            hVar = queryLocalInterface instanceof h ? (h) queryLocalInterface : new h(readStrongBinder, "com.google.android.gms.cast.framework.internal.IMediaRouterCallback", 2);
                        }
                        u.b(parcel);
                        q qVar = (q) this;
                        w3.o b2 = w3.o.b(bundle2);
                        if (b2 != null) {
                            HashMap hashMap = qVar.f3435f;
                            if (!hashMap.containsKey(b2)) {
                                hashMap.put(b2, new HashSet());
                            }
                            ((Set) hashMap.get(b2)).add(new i(hVar));
                        }
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        Bundle bundle3 = (Bundle) u.a(parcel, Bundle.CREATOR);
                        int readInt = parcel.readInt();
                        u.b(parcel);
                        q qVar2 = (q) this;
                        w3.o b10 = w3.o.b(bundle3);
                        if (b10 != null) {
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                qVar2.z0(b10, readInt);
                            } else {
                                new b8.e(Looper.getMainLooper(), 2).post(new androidx.activity.h(qVar2, b10, readInt, i13));
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 3:
                        Bundle bundle4 = (Bundle) u.a(parcel, Bundle.CREATOR);
                        u.b(parcel);
                        q qVar3 = (q) this;
                        w3.o b11 = w3.o.b(bundle4);
                        if (b11 != null) {
                            if (Looper.myLooper() == Looper.getMainLooper()) {
                                qVar3.A0(b11);
                            } else {
                                new b8.e(Looper.getMainLooper(), 2).post(new app.shamel.tv.activities.y(qVar3, b11, 8, i11));
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        Bundle bundle5 = (Bundle) u.a(parcel, Bundle.CREATOR);
                        int readInt2 = parcel.readInt();
                        u.b(parcel);
                        q qVar4 = (q) this;
                        w3.o b12 = w3.o.b(bundle5);
                        if (b12 != null) {
                            qVar4.f3433d.getClass();
                            w3.b0.b();
                            w3.w c10 = w3.b0.c();
                            ArrayList arrayList = c10.f13036h;
                            if (!b12.d()) {
                                if ((readInt2 & 2) != 0 || !c10.f13043o) {
                                    w3.g0 g0Var = c10.f13045q;
                                    Object[] objArr = g0Var != null && g0Var.f12926b && c10.f();
                                    int size = arrayList.size();
                                    for (int i14 = 0; i14 < size; i14++) {
                                        w3.z zVar = (w3.z) arrayList.get(i14);
                                        if (((readInt2 & 1) != 0 && zVar.d()) || ((objArr != false && !zVar.d() && zVar.c() != c10.f13035f) || !zVar.h(b12))) {
                                        }
                                    }
                                }
                                i11 = 1;
                            }
                        }
                        parcel2.writeNoException();
                        parcel2.writeInt(i11);
                        return true;
                    case 5:
                        String readString = parcel.readString();
                        u.b(parcel);
                        l7.b bVar = q.f3432i;
                        bVar.b("select route with routeId = %s", readString);
                        ((q) this).f3433d.getClass();
                        Iterator it = w3.b0.f().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                w3.z zVar2 = (w3.z) it.next();
                                if (zVar2.f13071c.equals(readString)) {
                                    bVar.b("media route is found and selected", new Object[0]);
                                    w3.b0.b();
                                    w3.b0.c().j(zVar2, 3);
                                }
                            }
                        }
                        parcel2.writeNoException();
                        return true;
                    case 6:
                        ((q) this).f3433d.getClass();
                        w3.b0.b();
                        w3.z zVar3 = w3.b0.c().f13046r;
                        if (zVar3 == null) {
                            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                        }
                        w3.b0.b();
                        w3.b0.c().j(zVar3, 3);
                        parcel2.writeNoException();
                        return true;
                    case 7:
                        ((q) this).f3433d.getClass();
                        w3.b0.b();
                        w3.z zVar4 = w3.b0.c().f13046r;
                        if (zVar4 == null) {
                            throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                        }
                        boolean equals = w3.b0.g().f13071c.equals(zVar4.f13071c);
                        parcel2.writeNoException();
                        int i15 = u.f3485a;
                        parcel2.writeInt(equals ? 1 : 0);
                        return true;
                    case 8:
                        String readString2 = parcel.readString();
                        u.b(parcel);
                        ((q) this).f3433d.getClass();
                        Iterator it2 = w3.b0.f().iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                w3.z zVar5 = (w3.z) it2.next();
                                if (zVar5.f13071c.equals(readString2)) {
                                    bundle = zVar5.f13085r;
                                }
                            }
                        }
                        parcel2.writeNoException();
                        if (bundle == null) {
                            parcel2.writeInt(0);
                            return true;
                        }
                        parcel2.writeInt(1);
                        bundle.writeToParcel(parcel2, 1);
                        return true;
                    case 9:
                        ((q) this).f3433d.getClass();
                        String str = w3.b0.g().f13071c;
                        parcel2.writeNoException();
                        parcel2.writeString(str);
                        return true;
                    case 10:
                        parcel2.writeNoException();
                        parcel2.writeInt(12451000);
                        return true;
                    case 11:
                        q qVar5 = (q) this;
                        HashMap hashMap2 = qVar5.f3435f;
                        Iterator it3 = hashMap2.values().iterator();
                        while (it3.hasNext()) {
                            Iterator it4 = ((Set) it3.next()).iterator();
                            while (it4.hasNext()) {
                                qVar5.f3433d.i((w3.p) it4.next());
                            }
                        }
                        hashMap2.clear();
                        parcel2.writeNoException();
                        return true;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        ((q) this).f3433d.getClass();
                        w3.b0.b();
                        w3.w c11 = w3.b0.c();
                        w3.z zVar6 = c11 != null ? c11.f13047s : null;
                        if (zVar6 != null && w3.b0.g().f13071c.equals(zVar6.f13071c)) {
                            i12 = 1;
                        }
                        parcel2.writeNoException();
                        int i16 = u.f3485a;
                        parcel2.writeInt(i12);
                        return true;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        int readInt3 = parcel.readInt();
                        u.b(parcel);
                        ((q) this).f3433d.getClass();
                        w3.b0.j(readInt3);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return false;
                }
            default:
                if (i10 == 1) {
                    x7.b bVar2 = new x7.b((c) this);
                    parcel2.writeNoException();
                    u.d(parcel2, bVar2);
                    return true;
                }
                if (i10 == 2) {
                    c cVar = (c) this;
                    l7.b bVar3 = c.f3275f;
                    Log.i(bVar3.f8271a, bVar3.d("onAppEnteredForeground", new Object[0]));
                    cVar.f3277e = 1;
                    Iterator it5 = cVar.f3276d.iterator();
                    while (it5.hasNext()) {
                        ((l) it5.next()).f3355a.m();
                    }
                    parcel2.writeNoException();
                    return true;
                }
                if (i10 != 3) {
                    if (i10 != 4) {
                        return false;
                    }
                    parcel2.writeNoException();
                    parcel2.writeInt(12451000);
                    return true;
                }
                c cVar2 = (c) this;
                l7.b bVar4 = c.f3275f;
                Log.i(bVar4.f8271a, bVar4.d("onAppEnteredBackground", new Object[0]));
                cVar2.f3277e = 2;
                Iterator it6 = cVar2.f3276d.iterator();
                while (it6.hasNext()) {
                    m mVar = ((l) it6.next()).f3355a;
                    m.f3366f.b("Stopping RouteDiscovery.", new Object[0]);
                    mVar.f3369c.clear();
                    if (Looper.myLooper() == Looper.getMainLooper()) {
                        x4.e eVar = mVar.f3371e;
                        if (((w3.b0) eVar.f13543q) == null) {
                            eVar.f13543q = w3.b0.d((Context) eVar.f13542p);
                        }
                        w3.b0 b0Var = (w3.b0) eVar.f13543q;
                        if (b0Var != null) {
                            b0Var.i(mVar);
                        }
                    } else {
                        new b8.e(Looper.getMainLooper(), 2).post(new j(mVar, i11 == true ? 1 : 0));
                    }
                }
                parcel2.writeNoException();
                return true;
        }
    }
}
