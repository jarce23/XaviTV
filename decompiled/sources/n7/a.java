package n7;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends s7.a {

    /* renamed from: o, reason: collision with root package name */
    public final int f9213o;

    /* renamed from: p, reason: collision with root package name */
    public final int f9214p;

    /* renamed from: q, reason: collision with root package name */
    public final PendingIntent f9215q;

    /* renamed from: r, reason: collision with root package name */
    public final String f9216r;

    /* renamed from: s, reason: collision with root package name */
    public final Integer f9217s;

    /* renamed from: t, reason: collision with root package name */
    public static final a f9212t = new a(0, null, null);
    public static final Parcelable.Creator<a> CREATOR = new l7.d(5);

    public a(int i10, int i11, PendingIntent pendingIntent, String str, Integer num) {
        this.f9213o = i10;
        this.f9214p = i11;
        this.f9215q = pendingIntent;
        this.f9216r = str;
        this.f9217s = num;
    }

    public static String b(int i10) {
        if (i10 == 99) {
            return "UNFINISHED";
        }
        if (i10 == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i10) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i10) {
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        return "CANCELED";
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        return "TIMEOUT";
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        return "INTERRUPTED";
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 20);
                        sb2.append("UNKNOWN_ERROR_CODE(");
                        sb2.append(i10);
                        sb2.append(")");
                        return sb2.toString();
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f9214p == aVar.f9214p && r.h(this.f9215q, aVar.f9215q) && r.h(this.f9216r, aVar.f9216r) && r.h(this.f9217s, aVar.f9217s);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f9214p), this.f9215q, this.f9216r, this.f9217s});
    }

    public final String toString() {
        x4.r rVar = new x4.r(this);
        rVar.e("statusCode", b(this.f9214p));
        rVar.e("resolution", this.f9215q);
        rVar.e("message", this.f9216r);
        rVar.e("clientMethodKey", this.f9217s);
        return rVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f9213o);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f9214p);
        y7.d.v(parcel, 3, this.f9215q, i10);
        y7.d.w(parcel, 4, this.f9216r);
        y7.d.t(parcel, 5, this.f9217s);
        y7.d.G(parcel, E);
    }

    public a(int i10, PendingIntent pendingIntent, String str) {
        this(1, i10, pendingIntent, str, null);
    }
}
