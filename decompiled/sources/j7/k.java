package j7;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import i7.o;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final l7.b f7180a = new l7.b("MediaSessionUtils", null);

    public static ArrayList a(o oVar) {
        try {
            Parcel x02 = oVar.x0(oVar.w0(), 3);
            ArrayList createTypedArrayList = x02.createTypedArrayList(i7.d.CREATOR);
            x02.recycle();
            return createTypedArrayList;
        } catch (RemoteException e7) {
            Object[] objArr = {"getNotificationActions", o.class.getSimpleName()};
            l7.b bVar = f7180a;
            Log.e(bVar.f8271a, bVar.d("Unable to call %s on %s.", objArr), e7);
            return null;
        }
    }

    public static int[] b(o oVar) {
        try {
            Parcel x02 = oVar.x0(oVar.w0(), 4);
            int[] createIntArray = x02.createIntArray();
            x02.recycle();
            return createIntArray;
        } catch (RemoteException e7) {
            Object[] objArr = {"getCompactViewActionIndices", o.class.getSimpleName()};
            l7.b bVar = f7180a;
            Log.e(bVar.f8271a, bVar.d("Unable to call %s on %s.", objArr), e7);
            return null;
        }
    }
}
