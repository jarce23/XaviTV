package k9;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends b8.a {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback", 3);
    }

    public final void J(Bundle bundle) {
        Parcel v10 = v();
        int i10 = g.f7848a;
        v10.writeInt(1);
        bundle.writeToParcel(v10, 0);
        w(v10, 3);
    }
}
