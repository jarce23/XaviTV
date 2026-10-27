package h7;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.mediarouter.app.MediaRouteButton;
import com.google.android.gms.internal.cast.y1;
import com.google.android.gms.internal.cast.z0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f5693a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5694b;

    static {
        r7.r.d("CastButtonFactory", "The log tag cannot be null or empty.");
        TextUtils.isEmpty(null);
        new ArrayList();
        f5693a = new ArrayList();
        f5694b = new Object();
    }

    public static void a(f.j jVar, MediaRouteButton mediaRouteButton) {
        b bVar;
        r7.r.b();
        if (mediaRouteButton != null) {
            r7.r.b();
            l7.b bVar2 = b.f5697l;
            r7.r.b();
            w3.o oVar = null;
            try {
                bVar = b.a(jVar);
            } catch (RuntimeException e7) {
                l7.b bVar3 = b.f5697l;
                Log.e(bVar3.f8271a, bVar3.d("Failed to load module from Google Play services. Cast will not work properly. Might due to outdated Google Play services. Ignoring this failure silently.", e7));
                bVar = null;
            }
            if (bVar != null) {
                r7.r.b();
                try {
                    m mVar = (m) bVar.f5701b;
                    Parcel x02 = mVar.x0(mVar.w0(), 1);
                    Bundle bundle = (Bundle) com.google.android.gms.internal.cast.u.a(x02, Bundle.CREATOR);
                    x02.recycle();
                    oVar = w3.o.b(bundle);
                } catch (RemoteException e8) {
                    b.f5697l.a(e8, "Unable to call %s on %s.", "getMergedSelectorAsBundle", o.class.getSimpleName());
                }
                if (oVar != null) {
                    mediaRouteButton.setRouteSelector(oVar);
                }
            }
            synchronized (f5694b) {
                f5693a.add(new WeakReference(mediaRouteButton));
            }
        }
        y1.a(z0.CAST_DEFAULT_MEDIA_ROUTER_DIALOG);
    }
}
