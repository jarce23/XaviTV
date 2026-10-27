package h7;

import android.content.Context;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: b, reason: collision with root package name */
    public static final l7.b f5743b = new l7.b("Session", null);

    /* renamed from: a, reason: collision with root package name */
    public final y f5744a;

    public h(Context context, String str, String str2) {
        y yVar;
        try {
            yVar = com.google.android.gms.internal.cast.d.b(context).C0(str, str2, new a0(this));
        } catch (RemoteException | e e7) {
            com.google.android.gms.internal.cast.d.f3291a.a(e7, "Unable to call %s on %s.", "newSessionImpl", com.google.android.gms.internal.cast.f.class.getSimpleName());
            yVar = null;
        }
        this.f5744a = yVar;
    }

    public final boolean a() {
        r7.r.b();
        y yVar = this.f5744a;
        if (yVar != null) {
            try {
                w wVar = (w) yVar;
                Parcel x02 = wVar.x0(wVar.w0(), 5);
                int i10 = com.google.android.gms.internal.cast.u.f3485a;
                boolean z10 = x02.readInt() != 0;
                x02.recycle();
                return z10;
            } catch (RemoteException e7) {
                f5743b.a(e7, "Unable to call %s on %s.", "isConnected", y.class.getSimpleName());
            }
        }
        return false;
    }

    public final void b(int i10) {
        y yVar = this.f5744a;
        if (yVar == null) {
            return;
        }
        try {
            w wVar = (w) yVar;
            Parcel w02 = wVar.w0();
            w02.writeInt(i10);
            wVar.y0(w02, 13);
        } catch (RemoteException e7) {
            f5743b.a(e7, "Unable to call %s on %s.", "notifySessionEnded", y.class.getSimpleName());
        }
    }

    public final int c() {
        r7.r.b();
        y yVar = this.f5744a;
        if (yVar != null) {
            try {
                w wVar = (w) yVar;
                Parcel x02 = wVar.x0(wVar.w0(), 17);
                int readInt = x02.readInt();
                x02.recycle();
                if (readInt >= 211100000) {
                    w wVar2 = (w) yVar;
                    Parcel x03 = wVar2.x0(wVar2.w0(), 18);
                    int readInt2 = x03.readInt();
                    x03.recycle();
                    return readInt2;
                }
            } catch (RemoteException e7) {
                f5743b.a(e7, "Unable to call %s on %s.", "getSessionStartType", y.class.getSimpleName());
            }
        }
        return 0;
    }

    public final x7.a d() {
        y yVar = this.f5744a;
        if (yVar != null) {
            try {
                w wVar = (w) yVar;
                Parcel x02 = wVar.x0(wVar.w0(), 1);
                x7.a y02 = x7.b.y0(x02.readStrongBinder());
                x02.recycle();
                return y02;
            } catch (RemoteException e7) {
                f5743b.a(e7, "Unable to call %s on %s.", "getWrappedObject", y.class.getSimpleName());
            }
        }
        return null;
    }
}
