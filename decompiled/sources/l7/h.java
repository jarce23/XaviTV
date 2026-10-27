package l7;

import android.os.Parcel;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h extends c8.h implements i {
    public h() {
        super("com.google.android.gms.cast.internal.ICastDeviceControllerListener", 1);
    }

    @Override // c8.h
    public final boolean x0(int i10, Parcel parcel, Parcel parcel2) {
        switch (i10) {
            case 1:
                int readInt = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                d0(readInt);
                return true;
            case 2:
                g7.d dVar = (g7.d) com.google.android.gms.internal.cast.u.a(parcel, g7.d.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                boolean z10 = parcel.readInt() != 0;
                com.google.android.gms.internal.cast.u.b(parcel);
                k(dVar, readString, readString2, z10);
                return true;
            case 3:
                int readInt2 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                n0(readInt2);
                return true;
            case 4:
                parcel.readString();
                parcel.readDouble();
                int i11 = com.google.android.gms.internal.cast.u.f3485a;
                parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                R();
                return true;
            case 5:
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                com.google.android.gms.internal.cast.u.b(parcel);
                i0(readString3, readString4);
                return true;
            case 6:
                String readString5 = parcel.readString();
                byte[] createByteArray = parcel.createByteArray();
                com.google.android.gms.internal.cast.u.b(parcel);
                p0(readString5, createByteArray);
                return true;
            case 7:
                int readInt3 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                a(readInt3);
                return true;
            case 8:
                int readInt4 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                c(readInt4);
                return true;
            case 9:
                int readInt5 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                g(readInt5);
                return true;
            case 10:
                parcel.readString();
                long readLong = parcel.readLong();
                int readInt6 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                l0(readInt6, readLong);
                return true;
            case 11:
                parcel.readString();
                long readLong2 = parcel.readLong();
                com.google.android.gms.internal.cast.u.b(parcel);
                r0(readLong2);
                return true;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                c cVar = (c) com.google.android.gms.internal.cast.u.a(parcel, c.CREATOR);
                com.google.android.gms.internal.cast.u.b(parcel);
                a0(cVar);
                return true;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                e eVar = (e) com.google.android.gms.internal.cast.u.a(parcel, e.CREATOR);
                com.google.android.gms.internal.cast.u.b(parcel);
                t0(eVar);
                return true;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                int readInt7 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                r(readInt7);
                return true;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                int readInt8 = parcel.readInt();
                com.google.android.gms.internal.cast.u.b(parcel);
                Z(readInt8);
                return true;
            default:
                return false;
        }
    }
}
