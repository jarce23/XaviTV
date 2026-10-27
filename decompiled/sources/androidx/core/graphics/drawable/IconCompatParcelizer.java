package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import n4.b;
import n4.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f532a = bVar.f(iconCompat.f532a, 1);
        byte[] bArr = iconCompat.f534c;
        if (bVar.e(2)) {
            Parcel parcel = ((c) bVar).f9187e;
            int readInt = parcel.readInt();
            if (readInt < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[readInt];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f534c = bArr;
        iconCompat.f535d = bVar.g(iconCompat.f535d, 3);
        iconCompat.f536e = bVar.f(iconCompat.f536e, 4);
        iconCompat.f537f = bVar.f(iconCompat.f537f, 5);
        iconCompat.g = (ColorStateList) bVar.g(iconCompat.g, 6);
        String str = iconCompat.f539i;
        if (bVar.e(7)) {
            str = ((c) bVar).f9187e.readString();
        }
        iconCompat.f539i = str;
        String str2 = iconCompat.f540j;
        if (bVar.e(8)) {
            str2 = ((c) bVar).f9187e.readString();
        }
        iconCompat.f540j = str2;
        iconCompat.f538h = PorterDuff.Mode.valueOf(iconCompat.f539i);
        switch (iconCompat.f532a) {
            case -1:
                Parcelable parcelable = iconCompat.f535d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f533b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f535d;
                if (parcelable2 != null) {
                    iconCompat.f533b = parcelable2;
                    return iconCompat;
                }
                byte[] bArr3 = iconCompat.f534c;
                iconCompat.f533b = bArr3;
                iconCompat.f532a = 3;
                iconCompat.f536e = 0;
                iconCompat.f537f = bArr3.length;
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str3 = new String(iconCompat.f534c, Charset.forName("UTF-16"));
                iconCompat.f533b = str3;
                if (iconCompat.f532a == 2 && iconCompat.f540j == null) {
                    iconCompat.f540j = str3.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f533b = iconCompat.f534c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.getClass();
        iconCompat.f539i = iconCompat.f538h.name();
        switch (iconCompat.f532a) {
            case -1:
                iconCompat.f535d = (Parcelable) iconCompat.f533b;
                break;
            case 1:
            case 5:
                iconCompat.f535d = (Parcelable) iconCompat.f533b;
                break;
            case 2:
                iconCompat.f534c = ((String) iconCompat.f533b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f534c = (byte[]) iconCompat.f533b;
                break;
            case 4:
            case 6:
                iconCompat.f534c = iconCompat.f533b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i10 = iconCompat.f532a;
        if (-1 != i10) {
            bVar.j(i10, 1);
        }
        byte[] bArr = iconCompat.f534c;
        if (bArr != null) {
            bVar.i(2);
            Parcel parcel = ((c) bVar).f9187e;
            parcel.writeInt(bArr.length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f535d;
        if (parcelable != null) {
            bVar.k(parcelable, 3);
        }
        int i11 = iconCompat.f536e;
        if (i11 != 0) {
            bVar.j(i11, 4);
        }
        int i12 = iconCompat.f537f;
        if (i12 != 0) {
            bVar.j(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            bVar.k(colorStateList, 6);
        }
        String str = iconCompat.f539i;
        if (str != null) {
            bVar.i(7);
            ((c) bVar).f9187e.writeString(str);
        }
        String str2 = iconCompat.f540j;
        if (str2 != null) {
            bVar.i(8);
            ((c) bVar).f9187e.writeString(str2);
        }
    }
}
