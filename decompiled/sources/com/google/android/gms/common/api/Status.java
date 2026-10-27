package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.Arrays;
import l7.d;
import o7.j;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import r7.r;
import s7.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Status extends a implements j, ReflectedParcelable {

    /* renamed from: o, reason: collision with root package name */
    public final int f3193o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3194p;

    /* renamed from: q, reason: collision with root package name */
    public final PendingIntent f3195q;

    /* renamed from: r, reason: collision with root package name */
    public final n7.a f3196r;

    /* renamed from: s, reason: collision with root package name */
    public static final Status f3190s = new Status(0, null, null, null);

    /* renamed from: t, reason: collision with root package name */
    public static final Status f3191t = new Status(15, null, null, null);

    /* renamed from: u, reason: collision with root package name */
    public static final Status f3192u = new Status(16, null, null, null);
    public static final Parcelable.Creator<Status> CREATOR = new d(8);

    public Status(int i10, String str, PendingIntent pendingIntent, n7.a aVar) {
        this.f3193o = i10;
        this.f3194p = str;
        this.f3195q = pendingIntent;
        this.f3196r = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f3193o == status.f3193o && r.h(this.f3194p, status.f3194p) && r.h(this.f3195q, status.f3195q) && r.h(this.f3196r, status.f3196r);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3193o), this.f3194p, this.f3195q, this.f3196r});
    }

    public final String toString() {
        x4.r rVar = new x4.r(this);
        String str = this.f3194p;
        if (str == null) {
            int i10 = this.f3193o;
            switch (i10) {
                case -1:
                    str = "SUCCESS_CACHE";
                    break;
                case 0:
                    str = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                default:
                    StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 21);
                    sb2.append("unknown status code: ");
                    sb2.append(i10);
                    str = sb2.toString();
                    break;
                case 2:
                    str = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    str = "SERVICE_DISABLED";
                    break;
                case 4:
                    str = "SIGN_IN_REQUIRED";
                    break;
                case 5:
                    str = "INVALID_ACCOUNT";
                    break;
                case 6:
                    str = "RESOLUTION_REQUIRED";
                    break;
                case 7:
                    str = "NETWORK_ERROR";
                    break;
                case 8:
                    str = "INTERNAL_ERROR";
                    break;
                case 10:
                    str = "DEVELOPER_ERROR";
                    break;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    str = "ERROR";
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    str = "INTERRUPTED";
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    str = "TIMEOUT";
                    break;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    str = "CANCELED";
                    break;
                case 17:
                    str = "API_NOT_CONNECTED";
                    break;
                case 18:
                    str = "DEAD_CLIENT";
                    break;
                case 19:
                    str = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    str = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    str = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    str = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        rVar.e("statusCode", str);
        rVar.e("resolution", this.f3195q);
        return rVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f3193o);
        y7.d.w(parcel, 2, this.f3194p);
        y7.d.v(parcel, 3, this.f3195q, i10);
        y7.d.v(parcel, 4, this.f3196r, i10);
        y7.d.G(parcel, E);
    }

    @Override // o7.j
    public final Status a() {
        return this;
    }
}
