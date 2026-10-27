package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final l7.b f3291a = new l7.b("CastDynamiteModule", null);

    public static h7.o a(Context context, h7.c cVar, q qVar, HashMap hashMap) {
        h7.o mVar;
        f b2 = b(context);
        x7.b bVar = new x7.b(context.getApplicationContext());
        Parcel w02 = b2.w0();
        u.d(w02, bVar);
        u.c(w02, cVar);
        u.d(w02, qVar);
        w02.writeMap(hashMap);
        Parcel x02 = b2.x0(w02, 1);
        IBinder readStrongBinder = x02.readStrongBinder();
        int i10 = h7.n.f5752c;
        if (readStrongBinder == null) {
            mVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastContext");
            mVar = queryLocalInterface instanceof h7.o ? (h7.o) queryLocalInterface : new h7.m(readStrongBinder, "com.google.android.gms.cast.framework.ICastContext", 2);
        }
        x02.recycle();
        return mVar;
    }

    public static f b(Context context) {
        try {
            try {
                IBinder iBinder = (IBinder) y7.c.a(context, y7.c.f13893b, "com.google.android.gms.cast.framework.dynamite").f13903a.getClassLoader().loadClass("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl").newInstance();
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
                return queryLocalInterface instanceof f ? (f) queryLocalInterface : new f(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule", 2);
            } catch (ClassNotFoundException e7) {
                e = e7;
                throw new y7.a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            } catch (IllegalAccessException e8) {
                e = e8;
                throw new y7.a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            } catch (InstantiationException e10) {
                e = e10;
                throw new y7.a("Failed to instantiate module class: ".concat("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl"), e);
            }
        } catch (y7.a e11) {
            throw new h7.e(e11);
        }
    }
}
