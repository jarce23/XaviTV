package h7;

import android.os.Parcel;
import android.os.RemoteException;
import c2.j1;
import com.google.android.gms.internal.cast.j4;
import com.google.android.gms.internal.cast.t6;
import com.google.android.gms.internal.cast.u5;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f5749a;

    public k(d dVar) {
        this.f5749a = dVar;
    }

    public final void a() {
        d dVar = this.f5749a;
        r rVar = dVar.f5729e;
        if (rVar == null) {
            return;
        }
        try {
            i7.h hVar = dVar.f5733j;
            if (hVar != null) {
                hVar.v();
            }
            p pVar = (p) rVar;
            Parcel w02 = pVar.w0();
            int i10 = com.google.android.gms.internal.cast.u.f3485a;
            w02.writeInt(0);
            pVar.y0(w02, 1);
        } catch (RemoteException e7) {
            d.f5726m.a(e7, "Unable to call %s on %s.", "onConnected", r.class.getSimpleName());
        }
        j4 j4Var = dVar.f5735l;
        if (j4Var != null) {
            u5.e(j4Var.f3345o, new t6(new j1(3, 2)));
        }
    }
}
