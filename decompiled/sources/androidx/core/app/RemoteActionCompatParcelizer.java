package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import n4.b;
import n4.c;
import n4.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(b bVar) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        d dVar = remoteActionCompat.f519a;
        boolean z10 = true;
        if (bVar.e(1)) {
            dVar = bVar.h();
        }
        remoteActionCompat.f519a = (IconCompat) dVar;
        CharSequence charSequence = remoteActionCompat.f520b;
        if (bVar.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f9187e);
        }
        remoteActionCompat.f520b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f521c;
        if (bVar.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((c) bVar).f9187e);
        }
        remoteActionCompat.f521c = charSequence2;
        remoteActionCompat.f522d = (PendingIntent) bVar.g(remoteActionCompat.f522d, 4);
        boolean z11 = remoteActionCompat.f523e;
        if (bVar.e(5)) {
            z11 = ((c) bVar).f9187e.readInt() != 0;
        }
        remoteActionCompat.f523e = z11;
        boolean z12 = remoteActionCompat.f524f;
        if (!bVar.e(6)) {
            z10 = z12;
        } else if (((c) bVar).f9187e.readInt() == 0) {
            z10 = false;
        }
        remoteActionCompat.f524f = z10;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, b bVar) {
        bVar.getClass();
        IconCompat iconCompat = remoteActionCompat.f519a;
        bVar.i(1);
        bVar.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f520b;
        bVar.i(2);
        Parcel parcel = ((c) bVar).f9187e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f521c;
        bVar.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        bVar.k(remoteActionCompat.f522d, 4);
        boolean z10 = remoteActionCompat.f523e;
        bVar.i(5);
        parcel.writeInt(z10 ? 1 : 0);
        boolean z11 = remoteActionCompat.f524f;
        bVar.i(6);
        parcel.writeInt(z11 ? 1 : 0);
    }
}
