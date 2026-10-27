package h7;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public static final l7.b f5746c = new l7.b("SessionManager", null);

    /* renamed from: a, reason: collision with root package name */
    public final z f5747a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f5748b;

    public i(z zVar, Context context) {
        this.f5747a = zVar;
        this.f5748b = context;
    }

    public final void a(j jVar) {
        if (jVar == null) {
            throw new NullPointerException("SessionManagerListener can't be null");
        }
        r7.r.b();
        try {
            z zVar = this.f5747a;
            b0 b0Var = new b0(jVar);
            Parcel w02 = zVar.w0();
            com.google.android.gms.internal.cast.u.d(w02, b0Var);
            zVar.y0(w02, 2);
        } catch (RemoteException e7) {
            f5746c.a(e7, "Unable to call %s on %s.", "addSessionManagerListener", z.class.getSimpleName());
        }
    }

    public final void b(boolean z10) {
        l7.b bVar = f5746c;
        r7.r.b();
        try {
            Log.i(bVar.f8271a, bVar.d("End session for %s", this.f5748b.getPackageName()));
            z zVar = this.f5747a;
            Parcel w02 = zVar.w0();
            int i10 = com.google.android.gms.internal.cast.u.f3485a;
            w02.writeInt(1);
            w02.writeInt(z10 ? 1 : 0);
            zVar.y0(w02, 6);
        } catch (RemoteException e7) {
            bVar.a(e7, "Unable to call %s on %s.", "endCurrentSession", z.class.getSimpleName());
        }
    }

    public final d c() {
        r7.r.b();
        h d6 = d();
        if (d6 == null || !(d6 instanceof d)) {
            return null;
        }
        return (d) d6;
    }

    public final h d() {
        r7.r.b();
        try {
            z zVar = this.f5747a;
            Parcel x02 = zVar.x0(zVar.w0(), 1);
            x7.a y02 = x7.b.y0(x02.readStrongBinder());
            x02.recycle();
            return (h) x7.b.z0(y02);
        } catch (RemoteException e7) {
            f5746c.a(e7, "Unable to call %s on %s.", "getWrappedCurrentSession", z.class.getSimpleName());
            return null;
        }
    }

    public final void e(j jVar) {
        r7.r.b();
        if (jVar == null) {
            return;
        }
        try {
            z zVar = this.f5747a;
            b0 b0Var = new b0(jVar);
            Parcel w02 = zVar.w0();
            com.google.android.gms.internal.cast.u.d(w02, b0Var);
            zVar.y0(w02, 3);
        } catch (RemoteException e7) {
            f5746c.a(e7, "Unable to call %s on %s.", "removeSessionManagerListener", z.class.getSimpleName());
        }
    }
}
