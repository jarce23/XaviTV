package g7;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;
import java.util.ArrayList;
import java.util.regex.Pattern;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5309a;

    public /* synthetic */ v(int i10) {
        this.f5309a = i10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        float f10 = 0.0f;
        double d6 = 0.0d;
        long j10 = 0;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        String str = null;
        String str2 = null;
        r14 = null;
        JSONObject jSONObject4 = null;
        String str3 = null;
        String str4 = null;
        ArrayList arrayList = null;
        String str5 = null;
        w wVar = null;
        switch (this.f5309a) {
            case 0:
                int V = x4.f.V(parcel);
                long j11 = 0;
                long j12 = 0;
                String str6 = null;
                String str7 = null;
                String str8 = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                String str12 = null;
                String str13 = null;
                String str14 = null;
                t tVar = null;
                while (parcel.dataPosition() < V) {
                    int readInt = parcel.readInt();
                    switch ((char) readInt) {
                        case 2:
                            str6 = x4.f.q(parcel, readInt);
                            break;
                        case 3:
                            str7 = x4.f.q(parcel, readInt);
                            break;
                        case 4:
                            j11 = x4.f.Q(parcel, readInt);
                            break;
                        case 5:
                            str8 = x4.f.q(parcel, readInt);
                            break;
                        case 6:
                            str9 = x4.f.q(parcel, readInt);
                            break;
                        case 7:
                            str10 = x4.f.q(parcel, readInt);
                            break;
                        case '\b':
                            str11 = x4.f.q(parcel, readInt);
                            break;
                        case '\t':
                            str12 = x4.f.q(parcel, readInt);
                            break;
                        case '\n':
                            str13 = x4.f.q(parcel, readInt);
                            break;
                        case 11:
                            j12 = x4.f.Q(parcel, readInt);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            str14 = x4.f.q(parcel, readInt);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            tVar = (t) x4.f.p(parcel, readInt, t.CREATOR);
                            break;
                        default:
                            x4.f.U(parcel, readInt);
                            break;
                    }
                }
                x4.f.w(parcel, V);
                return new a(str6, str7, j11, str8, str9, str10, str11, str12, str13, j12, str14, tVar);
            case 1:
                int V2 = x4.f.V(parcel);
                String str15 = null;
                while (parcel.dataPosition() < V2) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 1) {
                        str = x4.f.q(parcel, readInt2);
                    } else if (c10 != 2) {
                        x4.f.U(parcel, readInt2);
                    } else {
                        str15 = x4.f.q(parcel, readInt2);
                    }
                }
                x4.f.w(parcel, V2);
                return new h(str, str15);
            case 2:
                int V3 = x4.f.V(parcel);
                float f11 = 0.0f;
                float f12 = 0.0f;
                while (parcel.dataPosition() < V3) {
                    int readInt3 = parcel.readInt();
                    char c11 = (char) readInt3;
                    if (c11 == 2) {
                        x4.f.X(parcel, readInt3, 4);
                        f10 = parcel.readFloat();
                    } else if (c11 == 3) {
                        x4.f.X(parcel, readInt3, 4);
                        f11 = parcel.readFloat();
                    } else if (c11 != 4) {
                        x4.f.U(parcel, readInt3);
                    } else {
                        x4.f.X(parcel, readInt3, 4);
                        f12 = parcel.readFloat();
                    }
                }
                x4.f.w(parcel, V3);
                return new w(f10, f11, f12);
            case 3:
                int V4 = x4.f.V(parcel);
                w wVar2 = null;
                while (parcel.dataPosition() < V4) {
                    int readInt4 = parcel.readInt();
                    char c12 = (char) readInt4;
                    if (c12 == 2) {
                        wVar = (w) x4.f.p(parcel, readInt4, w.CREATOR);
                    } else if (c12 != 3) {
                        x4.f.U(parcel, readInt4);
                    } else {
                        wVar2 = (w) x4.f.p(parcel, readInt4, w.CREATOR);
                    }
                }
                x4.f.w(parcel, V4);
                return new x(wVar, wVar2);
            case 4:
                int V5 = x4.f.V(parcel);
                long j13 = 0;
                long j14 = 0;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                String str16 = null;
                String[] strArr = null;
                while (parcel.dataPosition() < V5) {
                    int readInt5 = parcel.readInt();
                    switch ((char) readInt5) {
                        case 2:
                            j13 = x4.f.Q(parcel, readInt5);
                            break;
                        case 3:
                            str16 = x4.f.q(parcel, readInt5);
                            break;
                        case 4:
                            j14 = x4.f.Q(parcel, readInt5);
                            break;
                        case 5:
                            z11 = x4.f.K(parcel, readInt5);
                            break;
                        case 6:
                            int R = x4.f.R(parcel, readInt5);
                            int dataPosition = parcel.dataPosition();
                            if (R != 0) {
                                String[] createStringArray = parcel.createStringArray();
                                parcel.setDataPosition(dataPosition + R);
                                strArr = createStringArray;
                                break;
                            } else {
                                strArr = null;
                                break;
                            }
                        case 7:
                            z12 = x4.f.K(parcel, readInt5);
                            break;
                        case '\b':
                            z13 = x4.f.K(parcel, readInt5);
                            break;
                        default:
                            x4.f.U(parcel, readInt5);
                            break;
                    }
                }
                x4.f.w(parcel, V5);
                return new b(j13, str16, j14, z11, strArr, z12, z13);
            case 5:
                int V6 = x4.f.V(parcel);
                boolean z14 = false;
                h hVar = null;
                while (parcel.dataPosition() < V6) {
                    int readInt6 = parcel.readInt();
                    char c13 = (char) readInt6;
                    if (c13 == 2) {
                        z10 = x4.f.K(parcel, readInt6);
                    } else if (c13 == 3) {
                        str5 = x4.f.q(parcel, readInt6);
                    } else if (c13 == 4) {
                        z14 = x4.f.K(parcel, readInt6);
                    } else if (c13 != 5) {
                        x4.f.U(parcel, readInt6);
                    } else {
                        hVar = (h) x4.f.p(parcel, readInt6, h.CREATOR);
                    }
                }
                x4.f.w(parcel, V6);
                return new i(z10, str5, z14, hVar);
            case 6:
                int V7 = x4.f.V(parcel);
                long j15 = 0;
                String str17 = null;
                String str18 = null;
                Integer num = null;
                String str19 = null;
                while (parcel.dataPosition() < V7) {
                    int readInt7 = parcel.readInt();
                    char c14 = (char) readInt7;
                    if (c14 == 2) {
                        str18 = x4.f.q(parcel, readInt7);
                    } else if (c14 == 3) {
                        j15 = x4.f.Q(parcel, readInt7);
                    } else if (c14 == 4) {
                        num = x4.f.P(parcel, readInt7);
                    } else if (c14 == 5) {
                        str19 = x4.f.q(parcel, readInt7);
                    } else if (c14 != 6) {
                        x4.f.U(parcel, readInt7);
                    } else {
                        str17 = x4.f.q(parcel, readInt7);
                    }
                }
                x4.f.w(parcel, V7);
                Pattern pattern = l7.a.f8269a;
                if (str17 != null) {
                    try {
                        jSONObject = new JSONObject(str17);
                    } catch (JSONException unused) {
                    }
                    return new MediaError(str18, j15, num, str19, jSONObject);
                }
                jSONObject = null;
                return new MediaError(str18, j15, num, str19, jSONObject);
            case 7:
                int V8 = x4.f.V(parcel);
                long j16 = 0;
                long j17 = 0;
                int i14 = 0;
                String str20 = null;
                String str21 = null;
                l lVar = null;
                ArrayList arrayList2 = null;
                s sVar = null;
                String str22 = null;
                ArrayList arrayList3 = null;
                ArrayList arrayList4 = null;
                String str23 = null;
                t tVar2 = null;
                String str24 = null;
                String str25 = null;
                String str26 = null;
                String str27 = null;
                while (parcel.dataPosition() < V8) {
                    int readInt8 = parcel.readInt();
                    switch ((char) readInt8) {
                        case 2:
                            str20 = x4.f.q(parcel, readInt8);
                            break;
                        case 3:
                            i14 = x4.f.O(parcel, readInt8);
                            break;
                        case 4:
                            str21 = x4.f.q(parcel, readInt8);
                            break;
                        case 5:
                            lVar = (l) x4.f.p(parcel, readInt8, l.CREATOR);
                            break;
                        case 6:
                            j16 = x4.f.Q(parcel, readInt8);
                            break;
                        case 7:
                            arrayList2 = x4.f.t(parcel, readInt8, MediaTrack.CREATOR);
                            break;
                        case '\b':
                            sVar = (s) x4.f.p(parcel, readInt8, s.CREATOR);
                            break;
                        case '\t':
                            str22 = x4.f.q(parcel, readInt8);
                            break;
                        case '\n':
                            arrayList3 = x4.f.t(parcel, readInt8, b.CREATOR);
                            break;
                        case 11:
                            arrayList4 = x4.f.t(parcel, readInt8, a.CREATOR);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            str23 = x4.f.q(parcel, readInt8);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            tVar2 = (t) x4.f.p(parcel, readInt8, t.CREATOR);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            j17 = x4.f.Q(parcel, readInt8);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            str24 = x4.f.q(parcel, readInt8);
                            break;
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            str25 = x4.f.q(parcel, readInt8);
                            break;
                        case 17:
                            str26 = x4.f.q(parcel, readInt8);
                            break;
                        case 18:
                            str27 = x4.f.q(parcel, readInt8);
                            break;
                        default:
                            x4.f.U(parcel, readInt8);
                            break;
                    }
                }
                x4.f.w(parcel, V8);
                return new MediaInfo(str20, i14, str21, lVar, j16, arrayList2, sVar, str22, arrayList3, arrayList4, str23, tVar2, j17, str24, str25, str26, str27);
            case 8:
                int V9 = x4.f.V(parcel);
                long j18 = 0;
                long j19 = 0;
                boolean z15 = false;
                boolean z16 = false;
                while (parcel.dataPosition() < V9) {
                    int readInt9 = parcel.readInt();
                    char c15 = (char) readInt9;
                    if (c15 == 2) {
                        j18 = x4.f.Q(parcel, readInt9);
                    } else if (c15 == 3) {
                        j19 = x4.f.Q(parcel, readInt9);
                    } else if (c15 == 4) {
                        z15 = x4.f.K(parcel, readInt9);
                    } else if (c15 != 5) {
                        x4.f.U(parcel, readInt9);
                    } else {
                        z16 = x4.f.K(parcel, readInt9);
                    }
                }
                x4.f.w(parcel, V9);
                return new j(j18, j19, z15, z16);
            case 9:
                int V10 = x4.f.V(parcel);
                long j20 = 0;
                long j21 = 0;
                long j22 = 0;
                String str28 = null;
                String str29 = null;
                while (parcel.dataPosition() < V10) {
                    int readInt10 = parcel.readInt();
                    char c16 = (char) readInt10;
                    if (c16 == 2) {
                        j20 = x4.f.Q(parcel, readInt10);
                    } else if (c16 == 3) {
                        j21 = x4.f.Q(parcel, readInt10);
                    } else if (c16 == 4) {
                        str28 = x4.f.q(parcel, readInt10);
                    } else if (c16 == 5) {
                        str29 = x4.f.q(parcel, readInt10);
                    } else if (c16 != 6) {
                        x4.f.U(parcel, readInt10);
                    } else {
                        j22 = x4.f.Q(parcel, readInt10);
                    }
                }
                x4.f.w(parcel, V10);
                return new c(j20, j21, str28, str29, j22);
            case 10:
                int V11 = x4.f.V(parcel);
                double d10 = 0.0d;
                long j23 = 0;
                long j24 = 0;
                String str30 = null;
                MediaInfo mediaInfo = null;
                n nVar = null;
                Boolean bool = null;
                long[] jArr = null;
                String str31 = null;
                String str32 = null;
                String str33 = null;
                String str34 = null;
                while (parcel.dataPosition() < V11) {
                    int readInt11 = parcel.readInt();
                    switch ((char) readInt11) {
                        case 2:
                            mediaInfo = (MediaInfo) x4.f.p(parcel, readInt11, MediaInfo.CREATOR);
                            break;
                        case 3:
                            nVar = (n) x4.f.p(parcel, readInt11, n.CREATOR);
                            break;
                        case 4:
                            bool = x4.f.L(parcel, readInt11);
                            break;
                        case 5:
                            j23 = x4.f.Q(parcel, readInt11);
                            break;
                        case 6:
                            d10 = x4.f.M(parcel, readInt11);
                            break;
                        case 7:
                            jArr = x4.f.o(parcel, readInt11);
                            break;
                        case '\b':
                            str30 = x4.f.q(parcel, readInt11);
                            break;
                        case '\t':
                            str31 = x4.f.q(parcel, readInt11);
                            break;
                        case '\n':
                            str32 = x4.f.q(parcel, readInt11);
                            break;
                        case 11:
                            str33 = x4.f.q(parcel, readInt11);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            str34 = x4.f.q(parcel, readInt11);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            j24 = x4.f.Q(parcel, readInt11);
                            break;
                        default:
                            x4.f.U(parcel, readInt11);
                            break;
                    }
                }
                x4.f.w(parcel, V11);
                Pattern pattern2 = l7.a.f8269a;
                if (str30 != null) {
                    try {
                        jSONObject2 = new JSONObject(str30);
                    } catch (JSONException unused2) {
                    }
                    return new k(mediaInfo, nVar, bool, j23, d10, jArr, jSONObject2, str31, str32, str33, str34, j24);
                }
                jSONObject2 = null;
                return new k(mediaInfo, nVar, bool, j23, d10, jArr, jSONObject2, str31, str32, str33, str34, j24);
            case 11:
                int V12 = x4.f.V(parcel);
                Bundle bundle = null;
                while (parcel.dataPosition() < V12) {
                    int readInt12 = parcel.readInt();
                    char c17 = (char) readInt12;
                    if (c17 == 2) {
                        arrayList = x4.f.t(parcel, readInt12, q7.a.CREATOR);
                    } else if (c17 == 3) {
                        bundle = x4.f.m(parcel, readInt12);
                    } else if (c17 != 4) {
                        x4.f.U(parcel, readInt12);
                    } else {
                        i13 = x4.f.O(parcel, readInt12);
                    }
                }
                x4.f.w(parcel, V12);
                return new l(arrayList, bundle, i13);
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                int V13 = x4.f.V(parcel);
                ArrayList arrayList5 = null;
                ArrayList arrayList6 = null;
                while (parcel.dataPosition() < V13) {
                    int readInt13 = parcel.readInt();
                    char c18 = (char) readInt13;
                    if (c18 == 2) {
                        i12 = x4.f.O(parcel, readInt13);
                    } else if (c18 == 3) {
                        str4 = x4.f.q(parcel, readInt13);
                    } else if (c18 == 4) {
                        arrayList5 = x4.f.t(parcel, readInt13, l.CREATOR);
                    } else if (c18 == 5) {
                        arrayList6 = x4.f.t(parcel, readInt13, q7.a.CREATOR);
                    } else if (c18 != 6) {
                        x4.f.U(parcel, readInt13);
                    } else {
                        d6 = x4.f.M(parcel, readInt13);
                    }
                }
                x4.f.w(parcel, V13);
                m mVar = new m();
                mVar.f5251o = i12;
                mVar.f5252p = str4;
                mVar.f5253q = arrayList5;
                mVar.f5254r = arrayList6;
                mVar.f5255s = d6;
                return mVar;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                int V14 = x4.f.V(parcel);
                int i15 = 0;
                int i16 = 0;
                boolean z17 = false;
                String str35 = null;
                String str36 = null;
                m mVar2 = null;
                ArrayList arrayList7 = null;
                while (parcel.dataPosition() < V14) {
                    int readInt14 = parcel.readInt();
                    switch ((char) readInt14) {
                        case 2:
                            str3 = x4.f.q(parcel, readInt14);
                            break;
                        case 3:
                            str35 = x4.f.q(parcel, readInt14);
                            break;
                        case 4:
                            i11 = x4.f.O(parcel, readInt14);
                            break;
                        case 5:
                            str36 = x4.f.q(parcel, readInt14);
                            break;
                        case 6:
                            mVar2 = (m) x4.f.p(parcel, readInt14, m.CREATOR);
                            break;
                        case 7:
                            i15 = x4.f.O(parcel, readInt14);
                            break;
                        case '\b':
                            arrayList7 = x4.f.t(parcel, readInt14, o.CREATOR);
                            break;
                        case '\t':
                            i16 = x4.f.O(parcel, readInt14);
                            break;
                        case '\n':
                            j10 = x4.f.Q(parcel, readInt14);
                            break;
                        case 11:
                            z17 = x4.f.K(parcel, readInt14);
                            break;
                        default:
                            x4.f.U(parcel, readInt14);
                            break;
                    }
                }
                x4.f.w(parcel, V14);
                n nVar2 = new n();
                nVar2.f5256o = str3;
                nVar2.f5257p = str35;
                nVar2.f5258q = i11;
                nVar2.f5259r = str36;
                nVar2.f5260s = mVar2;
                nVar2.f5261t = i15;
                nVar2.f5262u = arrayList7;
                nVar2.f5263v = i16;
                nVar2.f5264w = j10;
                nVar2.f5265x = z17;
                return nVar2;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                int V15 = x4.f.V(parcel);
                double d11 = 0.0d;
                double d12 = 0.0d;
                double d13 = 0.0d;
                int i17 = 0;
                boolean z18 = false;
                MediaInfo mediaInfo2 = null;
                long[] jArr2 = null;
                String str37 = null;
                while (parcel.dataPosition() < V15) {
                    int readInt15 = parcel.readInt();
                    switch ((char) readInt15) {
                        case 2:
                            mediaInfo2 = (MediaInfo) x4.f.p(parcel, readInt15, MediaInfo.CREATOR);
                            break;
                        case 3:
                            i17 = x4.f.O(parcel, readInt15);
                            break;
                        case 4:
                            z18 = x4.f.K(parcel, readInt15);
                            break;
                        case 5:
                            d11 = x4.f.M(parcel, readInt15);
                            break;
                        case 6:
                            d12 = x4.f.M(parcel, readInt15);
                            break;
                        case 7:
                            d13 = x4.f.M(parcel, readInt15);
                            break;
                        case '\b':
                            jArr2 = x4.f.o(parcel, readInt15);
                            break;
                        case '\t':
                            str37 = x4.f.q(parcel, readInt15);
                            break;
                        default:
                            x4.f.U(parcel, readInt15);
                            break;
                    }
                }
                x4.f.w(parcel, V15);
                return new o(mediaInfo2, i17, z18, d11, d12, d13, jArr2, str37);
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                int V16 = x4.f.V(parcel);
                double d14 = 0.0d;
                double d15 = 0.0d;
                long j25 = 0;
                long j26 = 0;
                long j27 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                boolean z19 = false;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                boolean z20 = false;
                MediaInfo mediaInfo3 = null;
                long[] jArr3 = null;
                String str38 = null;
                ArrayList arrayList8 = null;
                c cVar = null;
                u uVar = null;
                j jVar = null;
                n nVar3 = null;
                while (parcel.dataPosition() < V16) {
                    int readInt16 = parcel.readInt();
                    switch ((char) readInt16) {
                        case 2:
                            mediaInfo3 = (MediaInfo) x4.f.p(parcel, readInt16, MediaInfo.CREATOR);
                            break;
                        case 3:
                            j25 = x4.f.Q(parcel, readInt16);
                            break;
                        case 4:
                            i18 = x4.f.O(parcel, readInt16);
                            break;
                        case 5:
                            d14 = x4.f.M(parcel, readInt16);
                            break;
                        case 6:
                            i19 = x4.f.O(parcel, readInt16);
                            break;
                        case 7:
                            i20 = x4.f.O(parcel, readInt16);
                            break;
                        case '\b':
                            j26 = x4.f.Q(parcel, readInt16);
                            break;
                        case '\t':
                            j27 = x4.f.Q(parcel, readInt16);
                            break;
                        case '\n':
                            d15 = x4.f.M(parcel, readInt16);
                            break;
                        case 11:
                            z19 = x4.f.K(parcel, readInt16);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            jArr3 = x4.f.o(parcel, readInt16);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            i21 = x4.f.O(parcel, readInt16);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            i22 = x4.f.O(parcel, readInt16);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            str38 = x4.f.q(parcel, readInt16);
                            break;
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            i23 = x4.f.O(parcel, readInt16);
                            break;
                        case 17:
                            arrayList8 = x4.f.t(parcel, readInt16, o.CREATOR);
                            break;
                        case 18:
                            z20 = x4.f.K(parcel, readInt16);
                            break;
                        case 19:
                            cVar = (c) x4.f.p(parcel, readInt16, c.CREATOR);
                            break;
                        case 20:
                            uVar = (u) x4.f.p(parcel, readInt16, u.CREATOR);
                            break;
                        case 21:
                            jVar = (j) x4.f.p(parcel, readInt16, j.CREATOR);
                            break;
                        case 22:
                            nVar3 = (n) x4.f.p(parcel, readInt16, n.CREATOR);
                            break;
                        default:
                            x4.f.U(parcel, readInt16);
                            break;
                    }
                }
                x4.f.w(parcel, V16);
                return new q(mediaInfo3, j25, i18, d14, i19, i20, j26, j27, d15, z19, jArr3, i21, i22, str38, i23, arrayList8, z20, cVar, uVar, jVar, nVar3);
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                int V17 = x4.f.V(parcel);
                long j28 = 0;
                int i24 = 0;
                int i25 = 0;
                String str39 = null;
                String str40 = null;
                String str41 = null;
                String str42 = null;
                String str43 = null;
                ArrayList arrayList9 = null;
                while (parcel.dataPosition() < V17) {
                    int readInt17 = parcel.readInt();
                    switch ((char) readInt17) {
                        case 2:
                            j28 = x4.f.Q(parcel, readInt17);
                            break;
                        case 3:
                            i24 = x4.f.O(parcel, readInt17);
                            break;
                        case 4:
                            str40 = x4.f.q(parcel, readInt17);
                            break;
                        case 5:
                            str41 = x4.f.q(parcel, readInt17);
                            break;
                        case 6:
                            str42 = x4.f.q(parcel, readInt17);
                            break;
                        case 7:
                            str43 = x4.f.q(parcel, readInt17);
                            break;
                        case '\b':
                            i25 = x4.f.O(parcel, readInt17);
                            break;
                        case '\t':
                            arrayList9 = x4.f.r(parcel, readInt17);
                            break;
                        case '\n':
                            str39 = x4.f.q(parcel, readInt17);
                            break;
                        default:
                            x4.f.U(parcel, readInt17);
                            break;
                    }
                }
                x4.f.w(parcel, V17);
                Pattern pattern3 = l7.a.f8269a;
                if (str39 != null) {
                    try {
                        jSONObject3 = new JSONObject(str39);
                    } catch (JSONException unused3) {
                    }
                    return new MediaTrack(j28, i24, str40, str41, str42, str43, i25, arrayList9, jSONObject3);
                }
                jSONObject3 = null;
                return new MediaTrack(j28, i24, str40, str41, str42, str43, i25, arrayList9, jSONObject3);
            case 17:
                int V18 = x4.f.V(parcel);
                String str44 = null;
                String str45 = null;
                ArrayList arrayList10 = null;
                String str46 = null;
                Uri uri = null;
                String str47 = null;
                String str48 = null;
                Boolean bool2 = null;
                Boolean bool3 = null;
                while (parcel.dataPosition() < V18) {
                    int readInt18 = parcel.readInt();
                    switch ((char) readInt18) {
                        case 2:
                            str44 = x4.f.q(parcel, readInt18);
                            break;
                        case 3:
                            str45 = x4.f.q(parcel, readInt18);
                            break;
                        case 4:
                            x4.f.t(parcel, readInt18, q7.a.CREATOR);
                            break;
                        case 5:
                            arrayList10 = x4.f.r(parcel, readInt18);
                            break;
                        case 6:
                            str46 = x4.f.q(parcel, readInt18);
                            break;
                        case 7:
                            uri = (Uri) x4.f.p(parcel, readInt18, Uri.CREATOR);
                            break;
                        case '\b':
                            str47 = x4.f.q(parcel, readInt18);
                            break;
                        case '\t':
                            str48 = x4.f.q(parcel, readInt18);
                            break;
                        case '\n':
                            bool2 = x4.f.L(parcel, readInt18);
                            break;
                        case 11:
                            bool3 = x4.f.L(parcel, readInt18);
                            break;
                        default:
                            x4.f.U(parcel, readInt18);
                            break;
                    }
                }
                x4.f.w(parcel, V18);
                return new d(str44, str45, arrayList10, str46, uri, str47, str48, bool2, bool3);
            case 18:
                int V19 = x4.f.V(parcel);
                k kVar = null;
                String str49 = null;
                while (parcel.dataPosition() < V19) {
                    int readInt19 = parcel.readInt();
                    char c19 = (char) readInt19;
                    if (c19 == 2) {
                        kVar = (k) x4.f.p(parcel, readInt19, k.CREATOR);
                    } else if (c19 != 3) {
                        x4.f.U(parcel, readInt19);
                    } else {
                        str49 = x4.f.q(parcel, readInt19);
                    }
                }
                x4.f.w(parcel, V19);
                Pattern pattern4 = l7.a.f8269a;
                if (str49 != null) {
                    try {
                        jSONObject4 = new JSONObject(str49);
                    } catch (JSONException unused4) {
                    }
                }
                return new r(kVar, jSONObject4);
            case 19:
                int V20 = x4.f.V(parcel);
                float f13 = 0.0f;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                String str50 = null;
                String str51 = null;
                while (parcel.dataPosition() < V20) {
                    int readInt20 = parcel.readInt();
                    switch ((char) readInt20) {
                        case 2:
                            x4.f.X(parcel, readInt20, 4);
                            f13 = parcel.readFloat();
                            break;
                        case 3:
                            i26 = x4.f.O(parcel, readInt20);
                            break;
                        case 4:
                            i27 = x4.f.O(parcel, readInt20);
                            break;
                        case 5:
                            i28 = x4.f.O(parcel, readInt20);
                            break;
                        case 6:
                            i29 = x4.f.O(parcel, readInt20);
                            break;
                        case 7:
                            i30 = x4.f.O(parcel, readInt20);
                            break;
                        case '\b':
                            i31 = x4.f.O(parcel, readInt20);
                            break;
                        case '\t':
                            i32 = x4.f.O(parcel, readInt20);
                            break;
                        case '\n':
                            str50 = x4.f.q(parcel, readInt20);
                            break;
                        case 11:
                            i33 = x4.f.O(parcel, readInt20);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            i34 = x4.f.O(parcel, readInt20);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            str51 = x4.f.q(parcel, readInt20);
                            break;
                        default:
                            x4.f.U(parcel, readInt20);
                            break;
                    }
                }
                x4.f.w(parcel, V20);
                return new s(f13, i26, i27, i28, i29, i30, i31, i32, str50, i33, i34, str51);
            case 20:
                int V21 = x4.f.V(parcel);
                String str52 = null;
                while (parcel.dataPosition() < V21) {
                    int readInt21 = parcel.readInt();
                    char c20 = (char) readInt21;
                    if (c20 == 2) {
                        str2 = x4.f.q(parcel, readInt21);
                    } else if (c20 != 3) {
                        x4.f.U(parcel, readInt21);
                    } else {
                        str52 = x4.f.q(parcel, readInt21);
                    }
                }
                x4.f.w(parcel, V21);
                return new t(str2, str52);
            case 21:
                int V22 = x4.f.V(parcel);
                int i35 = 0;
                int i36 = 0;
                while (parcel.dataPosition() < V22) {
                    int readInt22 = parcel.readInt();
                    char c21 = (char) readInt22;
                    if (c21 == 2) {
                        i10 = x4.f.O(parcel, readInt22);
                    } else if (c21 == 3) {
                        i35 = x4.f.O(parcel, readInt22);
                    } else if (c21 != 4) {
                        x4.f.U(parcel, readInt22);
                    } else {
                        i36 = x4.f.O(parcel, readInt22);
                    }
                }
                x4.f.w(parcel, V22);
                return new u(i10, i35, i36);
            default:
                int V23 = x4.f.V(parcel);
                int i37 = -1;
                int i38 = 0;
                int i39 = 0;
                int i40 = 0;
                boolean z21 = false;
                String str53 = null;
                String str54 = null;
                String str55 = null;
                String str56 = null;
                String str57 = null;
                ArrayList arrayList11 = null;
                String str58 = null;
                String str59 = null;
                String str60 = null;
                byte[] bArr = null;
                String str61 = null;
                l7.y yVar = null;
                Integer num2 = null;
                while (parcel.dataPosition() < V23) {
                    int readInt23 = parcel.readInt();
                    switch ((char) readInt23) {
                        case 2:
                            str53 = x4.f.q(parcel, readInt23);
                            break;
                        case 3:
                            str54 = x4.f.q(parcel, readInt23);
                            break;
                        case 4:
                            str55 = x4.f.q(parcel, readInt23);
                            break;
                        case 5:
                            str56 = x4.f.q(parcel, readInt23);
                            break;
                        case 6:
                            str57 = x4.f.q(parcel, readInt23);
                            break;
                        case 7:
                            i38 = x4.f.O(parcel, readInt23);
                            break;
                        case '\b':
                            arrayList11 = x4.f.t(parcel, readInt23, q7.a.CREATOR);
                            break;
                        case '\t':
                            i39 = x4.f.O(parcel, readInt23);
                            break;
                        case '\n':
                            i37 = x4.f.O(parcel, readInt23);
                            break;
                        case 11:
                            str58 = x4.f.q(parcel, readInt23);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            str59 = x4.f.q(parcel, readInt23);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            i40 = x4.f.O(parcel, readInt23);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            str60 = x4.f.q(parcel, readInt23);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            int R2 = x4.f.R(parcel, readInt23);
                            int dataPosition2 = parcel.dataPosition();
                            if (R2 != 0) {
                                byte[] createByteArray = parcel.createByteArray();
                                parcel.setDataPosition(dataPosition2 + R2);
                                bArr = createByteArray;
                                break;
                            } else {
                                bArr = null;
                                break;
                            }
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            str61 = x4.f.q(parcel, readInt23);
                            break;
                        case 17:
                            z21 = x4.f.K(parcel, readInt23);
                            break;
                        case 18:
                            yVar = (l7.y) x4.f.p(parcel, readInt23, l7.y.CREATOR);
                            break;
                        case 19:
                            num2 = x4.f.P(parcel, readInt23);
                            break;
                        default:
                            x4.f.U(parcel, readInt23);
                            break;
                    }
                }
                x4.f.w(parcel, V23);
                return new CastDevice(str53, str54, str55, str56, str57, i38, arrayList11, i39, i37, str58, str59, i40, str60, bArr, str61, z21, yVar, num2);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i10) {
        switch (this.f5309a) {
            case 0:
                return new a[i10];
            case 1:
                return new h[i10];
            case 2:
                return new w[i10];
            case 3:
                return new x[i10];
            case 4:
                return new b[i10];
            case 5:
                return new i[i10];
            case 6:
                return new MediaError[i10];
            case 7:
                return new MediaInfo[i10];
            case 8:
                return new j[i10];
            case 9:
                return new c[i10];
            case 10:
                return new k[i10];
            case 11:
                return new l[i10];
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                return new m[i10];
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                return new n[i10];
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                return new o[i10];
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return new q[i10];
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                return new MediaTrack[i10];
            case 17:
                return new d[i10];
            case 18:
                return new r[i10];
            case 19:
                return new s[i10];
            case 20:
                return new t[i10];
            case 21:
                return new u[i10];
            default:
                return new CastDevice[i10];
        }
    }
}
