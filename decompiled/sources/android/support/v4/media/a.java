package android.support.v4.media;

import android.content.Intent;
import android.content.IntentSender;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.f0;
import androidx.fragment.app.k0;
import androidx.fragment.app.n0;
import androidx.leanback.widget.o;
import androidx.leanback.widget.p;
import b4.l1;
import b4.m1;
import b4.x;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import g7.i;
import h7.d0;
import h7.e0;
import java.util.ArrayList;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import x4.f;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f195a;

    public /* synthetic */ a(int i10) {
        this.f195a = i10;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        b.b bVar = null;
        String str = null;
        n7.a aVar = null;
        ArrayList arrayList = null;
        Intent intent = null;
        boolean z10 = false;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        switch (this.f195a) {
            case 0:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new a(0);

                    /* renamed from: o, reason: collision with root package name */
                    public final int f175o;

                    /* renamed from: p, reason: collision with root package name */
                    public final MediaDescriptionCompat f176p;

                    {
                        this.f175o = parcel.readInt();
                        this.f176p = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f175o + ", mDescription=" + this.f176p + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i15) {
                        parcel2.writeInt(this.f175o);
                        this.f176p.writeToParcel(parcel2, i15);
                    }
                };
            case 1:
                return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
            case 2:
                return new MediaMetadataCompat(parcel);
            case 3:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 4:
                return new androidx.activity.result.a(parcel);
            case 5:
                h.e("inParcel", parcel);
                Parcelable readParcelable = parcel.readParcelable(IntentSender.class.getClassLoader());
                h.b(readParcelable);
                return new androidx.activity.result.h((IntentSender) readParcelable, (Intent) parcel.readParcelable(Intent.class.getClassLoader()), parcel.readInt(), parcel.readInt());
            case 6:
                return new androidx.fragment.app.b(parcel);
            case 7:
                return new androidx.fragment.app.c(parcel);
            case 8:
                f0 f0Var = new f0();
                f0Var.f678o = parcel.readString();
                f0Var.f679p = parcel.readInt();
                return f0Var;
            case 9:
                k0 k0Var = new k0();
                k0Var.f727s = null;
                k0Var.f728t = new ArrayList();
                k0Var.f729u = new ArrayList();
                k0Var.f723o = parcel.createStringArrayList();
                k0Var.f724p = parcel.createStringArrayList();
                k0Var.f725q = (androidx.fragment.app.b[]) parcel.createTypedArray(androidx.fragment.app.b.CREATOR);
                k0Var.f726r = parcel.readInt();
                k0Var.f727s = parcel.readString();
                k0Var.f728t = parcel.createStringArrayList();
                k0Var.f729u = parcel.createTypedArrayList(androidx.fragment.app.c.CREATOR);
                k0Var.f730v = parcel.createTypedArrayList(f0.CREATOR);
                return k0Var;
            case 10:
                return new n0(parcel);
            case 11:
                o oVar = new o();
                oVar.f1048p = Bundle.EMPTY;
                oVar.f1047o = parcel.readInt();
                oVar.f1048p = parcel.readBundle(p.class.getClassLoader());
                return oVar;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                b.d dVar = new b.d();
                IBinder readStrongBinder = parcel.readStrongBinder();
                int i15 = b.c.f2119c;
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface(b.b.f2118a);
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof b.b)) {
                        b.a aVar2 = new b.a();
                        aVar2.f2117b = readStrongBinder;
                        bVar = aVar2;
                    } else {
                        bVar = (b.b) queryLocalInterface;
                    }
                }
                dVar.f2121o = bVar;
                return dVar;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                x xVar = new x();
                xVar.f2446o = parcel.readInt();
                xVar.f2447p = parcel.readInt();
                xVar.f2448q = parcel.readInt() == 1;
                return xVar;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                l1 l1Var = new l1();
                l1Var.f2303o = parcel.readInt();
                l1Var.f2304p = parcel.readInt();
                l1Var.f2306r = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    int[] iArr = new int[readInt];
                    l1Var.f2305q = iArr;
                    parcel.readIntArray(iArr);
                }
                return l1Var;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                m1 m1Var = new m1();
                m1Var.f2311o = parcel.readInt();
                m1Var.f2312p = parcel.readInt();
                int readInt2 = parcel.readInt();
                m1Var.f2313q = readInt2;
                if (readInt2 > 0) {
                    int[] iArr2 = new int[readInt2];
                    m1Var.f2314r = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int readInt3 = parcel.readInt();
                m1Var.f2315s = readInt3;
                if (readInt3 > 0) {
                    int[] iArr3 = new int[readInt3];
                    m1Var.f2316t = iArr3;
                    parcel.readIntArray(iArr3);
                }
                m1Var.f2318v = parcel.readInt() == 1;
                m1Var.f2319w = parcel.readInt() == 1;
                m1Var.f2320x = parcel.readInt() == 1;
                m1Var.f2317u = parcel.readArrayList(l1.class.getClassLoader());
                return m1Var;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                return new com.google.android.material.datepicker.b((com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), (com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), (com.google.android.material.datepicker.d) parcel.readParcelable(com.google.android.material.datepicker.d.class.getClassLoader()), (com.google.android.material.datepicker.p) parcel.readParcelable(com.google.android.material.datepicker.p.class.getClassLoader()), parcel.readInt());
            case 17:
                return new com.google.android.material.datepicker.d(parcel.readLong());
            case 18:
                return com.google.android.material.datepicker.p.a(parcel.readInt(), parcel.readInt());
            case 19:
                int V = f.V(parcel);
                long j10 = 0;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                String str5 = null;
                Uri uri = null;
                String str6 = null;
                String str7 = null;
                ArrayList arrayList2 = null;
                String str8 = null;
                String str9 = null;
                while (parcel.dataPosition() < V) {
                    int readInt4 = parcel.readInt();
                    switch ((char) readInt4) {
                        case 2:
                            str2 = f.q(parcel, readInt4);
                            break;
                        case 3:
                            str3 = f.q(parcel, readInt4);
                            break;
                        case 4:
                            str4 = f.q(parcel, readInt4);
                            break;
                        case 5:
                            str5 = f.q(parcel, readInt4);
                            break;
                        case 6:
                            uri = (Uri) f.p(parcel, readInt4, Uri.CREATOR);
                            break;
                        case 7:
                            str6 = f.q(parcel, readInt4);
                            break;
                        case '\b':
                            j10 = f.Q(parcel, readInt4);
                            break;
                        case '\t':
                            str7 = f.q(parcel, readInt4);
                            break;
                        case '\n':
                            arrayList2 = f.t(parcel, readInt4, Scope.CREATOR);
                            break;
                        case 11:
                            str8 = f.q(parcel, readInt4);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            str9 = f.q(parcel, readInt4);
                            break;
                        default:
                            f.U(parcel, readInt4);
                            break;
                    }
                }
                f.w(parcel, V);
                return new GoogleSignInAccount(str2, str3, str4, str5, uri, str6, j10, str7, arrayList2, str8, str9);
            case 20:
                int V2 = f.V(parcel);
                while (parcel.dataPosition() < V2) {
                    int readInt5 = parcel.readInt();
                    if (((char) readInt5) != 2) {
                        f.U(parcel, readInt5);
                    } else {
                        z10 = f.K(parcel, readInt5);
                    }
                }
                f.w(parcel, V2);
                return new d0(z10);
            case 21:
                int V3 = f.V(parcel);
                while (parcel.dataPosition() < V3) {
                    int readInt6 = parcel.readInt();
                    if (((char) readInt6) != 2) {
                        f.U(parcel, readInt6);
                    } else {
                        i14 = f.O(parcel, readInt6);
                    }
                }
                f.w(parcel, V3);
                return new e0(i14);
            case 22:
                int V4 = f.V(parcel);
                double d6 = 0.0d;
                String str10 = null;
                ArrayList arrayList3 = null;
                i iVar = null;
                i7.a aVar3 = null;
                ArrayList arrayList4 = null;
                d0 d0Var = null;
                e0 e0Var = null;
                boolean z11 = false;
                boolean z12 = false;
                boolean z13 = false;
                boolean z14 = false;
                boolean z15 = false;
                boolean z16 = false;
                boolean z17 = false;
                boolean z18 = false;
                while (parcel.dataPosition() < V4) {
                    int readInt7 = parcel.readInt();
                    switch ((char) readInt7) {
                        case 2:
                            str10 = f.q(parcel, readInt7);
                            break;
                        case 3:
                            arrayList3 = f.r(parcel, readInt7);
                            break;
                        case 4:
                            z11 = f.K(parcel, readInt7);
                            break;
                        case 5:
                            iVar = (i) f.p(parcel, readInt7, i.CREATOR);
                            break;
                        case 6:
                            z12 = f.K(parcel, readInt7);
                            break;
                        case 7:
                            aVar3 = (i7.a) f.p(parcel, readInt7, i7.a.CREATOR);
                            break;
                        case '\b':
                            z13 = f.K(parcel, readInt7);
                            break;
                        case '\t':
                            d6 = f.M(parcel, readInt7);
                            break;
                        case '\n':
                            z14 = f.K(parcel, readInt7);
                            break;
                        case 11:
                            z15 = f.K(parcel, readInt7);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            z16 = f.K(parcel, readInt7);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            arrayList4 = f.r(parcel, readInt7);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            z17 = f.K(parcel, readInt7);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            f.O(parcel, readInt7);
                            break;
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            z18 = f.K(parcel, readInt7);
                            break;
                        case 17:
                            d0Var = (d0) f.p(parcel, readInt7, d0.CREATOR);
                            break;
                        case 18:
                            e0Var = (e0) f.p(parcel, readInt7, e0.CREATOR);
                            break;
                        default:
                            f.U(parcel, readInt7);
                            break;
                    }
                }
                f.w(parcel, V4);
                return new h7.c(str10, arrayList3, z11, iVar, z12, aVar3, z13, d6, z14, z15, z16, arrayList4, z17, z18, d0Var, e0Var);
            case 23:
                int V5 = f.V(parcel);
                int i16 = 0;
                while (parcel.dataPosition() < V5) {
                    int readInt8 = parcel.readInt();
                    char c10 = (char) readInt8;
                    if (c10 == 1) {
                        i13 = f.O(parcel, readInt8);
                    } else if (c10 == 2) {
                        i16 = f.O(parcel, readInt8);
                    } else if (c10 != 3) {
                        f.U(parcel, readInt8);
                    } else {
                        intent = (Intent) f.p(parcel, readInt8, Intent.CREATOR);
                    }
                }
                f.w(parcel, V5);
                return new h8.b(i13, i16, intent);
            case 24:
                int V6 = f.V(parcel);
                String str11 = null;
                while (parcel.dataPosition() < V6) {
                    int readInt9 = parcel.readInt();
                    char c11 = (char) readInt9;
                    if (c11 == 1) {
                        arrayList = f.r(parcel, readInt9);
                    } else if (c11 != 2) {
                        f.U(parcel, readInt9);
                    } else {
                        str11 = f.q(parcel, readInt9);
                    }
                }
                f.w(parcel, V6);
                return new h8.d(str11, arrayList);
            case 25:
                int V7 = f.V(parcel);
                r7.o oVar2 = null;
                while (parcel.dataPosition() < V7) {
                    int readInt10 = parcel.readInt();
                    char c12 = (char) readInt10;
                    if (c12 == 1) {
                        i12 = f.O(parcel, readInt10);
                    } else if (c12 == 2) {
                        aVar = (n7.a) f.p(parcel, readInt10, n7.a.CREATOR);
                    } else if (c12 != 3) {
                        f.U(parcel, readInt10);
                    } else {
                        oVar2 = (r7.o) f.p(parcel, readInt10, r7.o.CREATOR);
                    }
                }
                f.w(parcel, V7);
                return new h8.e(i12, aVar, oVar2);
            case 26:
                int V8 = f.V(parcel);
                String str12 = null;
                String str13 = null;
                IBinder iBinder = null;
                i7.f fVar = null;
                boolean z19 = false;
                boolean z20 = false;
                while (parcel.dataPosition() < V8) {
                    int readInt11 = parcel.readInt();
                    switch ((char) readInt11) {
                        case 2:
                            str12 = f.q(parcel, readInt11);
                            break;
                        case 3:
                            str13 = f.q(parcel, readInt11);
                            break;
                        case 4:
                            iBinder = f.N(parcel, readInt11);
                            break;
                        case 5:
                            fVar = (i7.f) f.p(parcel, readInt11, i7.f.CREATOR);
                            break;
                        case 6:
                            z19 = f.K(parcel, readInt11);
                            break;
                        case 7:
                            z20 = f.K(parcel, readInt11);
                            break;
                        default:
                            f.U(parcel, readInt11);
                            break;
                    }
                }
                f.w(parcel, V8);
                return new i7.a(str12, str13, iBinder, fVar, z19, z20);
            case 27:
                int V9 = f.V(parcel);
                long j11 = 0;
                ArrayList arrayList5 = null;
                int[] iArr4 = null;
                String str14 = null;
                IBinder iBinder2 = null;
                int i17 = 0;
                int i18 = 0;
                int i19 = 0;
                int i20 = 0;
                int i21 = 0;
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                int i29 = 0;
                int i30 = 0;
                int i31 = 0;
                int i32 = 0;
                int i33 = 0;
                int i34 = 0;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                int i40 = 0;
                int i41 = 0;
                int i42 = 0;
                int i43 = 0;
                boolean z21 = false;
                boolean z22 = false;
                while (parcel.dataPosition() < V9) {
                    int readInt12 = parcel.readInt();
                    switch ((char) readInt12) {
                        case 2:
                            arrayList5 = f.r(parcel, readInt12);
                            break;
                        case 3:
                            iArr4 = f.n(parcel, readInt12);
                            break;
                        case 4:
                            j11 = f.Q(parcel, readInt12);
                            break;
                        case 5:
                            str14 = f.q(parcel, readInt12);
                            break;
                        case 6:
                            i17 = f.O(parcel, readInt12);
                            break;
                        case 7:
                            i18 = f.O(parcel, readInt12);
                            break;
                        case '\b':
                            i19 = f.O(parcel, readInt12);
                            break;
                        case '\t':
                            i20 = f.O(parcel, readInt12);
                            break;
                        case '\n':
                            i21 = f.O(parcel, readInt12);
                            break;
                        case 11:
                            i22 = f.O(parcel, readInt12);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            i23 = f.O(parcel, readInt12);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            i24 = f.O(parcel, readInt12);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            i25 = f.O(parcel, readInt12);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            i26 = f.O(parcel, readInt12);
                            break;
                        case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                            i27 = f.O(parcel, readInt12);
                            break;
                        case 17:
                            i28 = f.O(parcel, readInt12);
                            break;
                        case 18:
                            i29 = f.O(parcel, readInt12);
                            break;
                        case 19:
                            i30 = f.O(parcel, readInt12);
                            break;
                        case 20:
                            i31 = f.O(parcel, readInt12);
                            break;
                        case 21:
                            i32 = f.O(parcel, readInt12);
                            break;
                        case 22:
                            i33 = f.O(parcel, readInt12);
                            break;
                        case 23:
                            i34 = f.O(parcel, readInt12);
                            break;
                        case 24:
                            i35 = f.O(parcel, readInt12);
                            break;
                        case 25:
                            i36 = f.O(parcel, readInt12);
                            break;
                        case 26:
                            i37 = f.O(parcel, readInt12);
                            break;
                        case 27:
                            i38 = f.O(parcel, readInt12);
                            break;
                        case 28:
                            i39 = f.O(parcel, readInt12);
                            break;
                        case 29:
                            i40 = f.O(parcel, readInt12);
                            break;
                        case 30:
                            i41 = f.O(parcel, readInt12);
                            break;
                        case 31:
                            i42 = f.O(parcel, readInt12);
                            break;
                        case ' ':
                            i43 = f.O(parcel, readInt12);
                            break;
                        case '!':
                            iBinder2 = f.N(parcel, readInt12);
                            break;
                        case '\"':
                            z21 = f.K(parcel, readInt12);
                            break;
                        case '#':
                            z22 = f.K(parcel, readInt12);
                            break;
                        default:
                            f.U(parcel, readInt12);
                            break;
                    }
                }
                f.w(parcel, V9);
                return new i7.f(arrayList5, iArr4, j11, str14, i17, i18, i19, i20, i21, i22, i23, i24, i25, i26, i27, i28, i29, i30, i31, i32, i33, i34, i35, i36, i37, i38, i39, i40, i41, i42, i43, iBinder2, z21, z22);
            case 28:
                int V10 = f.V(parcel);
                int i44 = 0;
                int i45 = 0;
                while (parcel.dataPosition() < V10) {
                    int readInt13 = parcel.readInt();
                    char c13 = (char) readInt13;
                    if (c13 == 2) {
                        i11 = f.O(parcel, readInt13);
                    } else if (c13 == 3) {
                        i44 = f.O(parcel, readInt13);
                    } else if (c13 != 4) {
                        f.U(parcel, readInt13);
                    } else {
                        i45 = f.O(parcel, readInt13);
                    }
                }
                f.w(parcel, V10);
                return new i7.b(i11, i44, i45);
            default:
                int V11 = f.V(parcel);
                String str15 = null;
                while (parcel.dataPosition() < V11) {
                    int readInt14 = parcel.readInt();
                    char c14 = (char) readInt14;
                    if (c14 == 2) {
                        str = f.q(parcel, readInt14);
                    } else if (c14 == 3) {
                        i10 = f.O(parcel, readInt14);
                    } else if (c14 != 4) {
                        f.U(parcel, readInt14);
                    } else {
                        str15 = f.q(parcel, readInt14);
                    }
                }
                f.w(parcel, V11);
                return new i7.d(str, i10, str15);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        switch (this.f195a) {
            case 0:
                return new MediaBrowserCompat$MediaItem[i10];
            case 1:
                return new MediaDescriptionCompat[i10];
            case 2:
                return new MediaMetadataCompat[i10];
            case 3:
                return new RatingCompat[i10];
            case 4:
                return new androidx.activity.result.a[i10];
            case 5:
                return new androidx.activity.result.h[i10];
            case 6:
                return new androidx.fragment.app.b[i10];
            case 7:
                return new androidx.fragment.app.c[i10];
            case 8:
                return new f0[i10];
            case 9:
                return new k0[i10];
            case 10:
                return new n0[i10];
            case 11:
                return new o[i10];
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                return new b.d[i10];
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                return new x[i10];
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                return new l1[i10];
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return new m1[i10];
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                return new com.google.android.material.datepicker.b[i10];
            case 17:
                return new com.google.android.material.datepicker.d[i10];
            case 18:
                return new com.google.android.material.datepicker.p[i10];
            case 19:
                return new GoogleSignInAccount[i10];
            case 20:
                return new d0[i10];
            case 21:
                return new e0[i10];
            case 22:
                return new h7.c[i10];
            case 23:
                return new h8.b[i10];
            case 24:
                return new h8.d[i10];
            case 25:
                return new h8.e[i10];
            case 26:
                return new i7.a[i10];
            case 27:
                return new i7.f[i10];
            case 28:
                return new i7.b[i10];
            default:
                return new i7.d[i10];
        }
    }
}
