package y7;

import android.os.Parcel;
import c8.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h extends b8.a {
    public final x7.a A0(x7.b bVar, String str, int i10, x7.b bVar2) {
        Parcel w02 = w0();
        i.b(w02, bVar);
        w02.writeString(str);
        w02.writeInt(i10);
        i.b(w02, bVar2);
        Parcel G = G(w02, 2);
        x7.a y02 = x7.b.y0(G.readStrongBinder());
        G.recycle();
        return y02;
    }

    public final x7.a B0(x7.b bVar, String str, int i10, x7.b bVar2) {
        Parcel w02 = w0();
        i.b(w02, bVar);
        w02.writeString(str);
        w02.writeInt(i10);
        i.b(w02, bVar2);
        Parcel G = G(w02, 3);
        x7.a y02 = x7.b.y0(G.readStrongBinder());
        G.recycle();
        return y02;
    }
}
