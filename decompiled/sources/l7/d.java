package l7;

import android.accounts.Account;
import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BinderWrapper;
import java.util.ArrayList;
import m.j0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import r7.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8275a;

    public /* synthetic */ d(int i10) {
        this.f8275a = i10;
    }

    public static void a(r7.d dVar, Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        int i11 = dVar.f10885o;
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(i11);
        int i12 = dVar.f10886p;
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(i12);
        int i13 = dVar.f10887q;
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(i13);
        y7.d.w(parcel, 4, dVar.f10888r);
        y7.d.r(parcel, 5, dVar.f10889s);
        y7.d.y(parcel, 6, dVar.f10890t, i10);
        y7.d.q(parcel, 7, dVar.f10891u);
        y7.d.v(parcel, 8, dVar.f10892v, i10);
        y7.d.y(parcel, 10, dVar.f10893w, i10);
        y7.d.y(parcel, 11, dVar.f10894x, i10);
        boolean z10 = dVar.f10895y;
        y7.d.D(parcel, 12, 4);
        parcel.writeInt(z10 ? 1 : 0);
        int i14 = dVar.f10896z;
        y7.d.D(parcel, 13, 4);
        parcel.writeInt(i14);
        boolean z11 = dVar.A;
        y7.d.D(parcel, 14, 4);
        parcel.writeInt(z11 ? 1 : 0);
        y7.d.w(parcel, 15, dVar.B);
        y7.d.G(parcel, E);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f8275a) {
            case 0:
                int V = x4.f.V(parcel);
                int i10 = 0;
                boolean z10 = false;
                boolean z11 = false;
                while (parcel.dataPosition() < V) {
                    int readInt = parcel.readInt();
                    char c10 = (char) readInt;
                    if (c10 == 2) {
                        i10 = x4.f.O(parcel, readInt);
                    } else if (c10 == 3) {
                        z10 = x4.f.K(parcel, readInt);
                    } else if (c10 != 4) {
                        x4.f.U(parcel, readInt);
                    } else {
                        z11 = x4.f.K(parcel, readInt);
                    }
                }
                x4.f.w(parcel, V);
                return new y(i10, z10, z11);
            case 1:
                int V2 = x4.f.V(parcel);
                double d6 = 0.0d;
                g7.d dVar = null;
                g7.x xVar = null;
                boolean z12 = false;
                int i11 = 0;
                int i12 = 0;
                double d10 = 0.0d;
                while (parcel.dataPosition() < V2) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 2:
                            d6 = x4.f.M(parcel, readInt2);
                            break;
                        case 3:
                            z12 = x4.f.K(parcel, readInt2);
                            break;
                        case 4:
                            i11 = x4.f.O(parcel, readInt2);
                            break;
                        case 5:
                            dVar = (g7.d) x4.f.p(parcel, readInt2, g7.d.CREATOR);
                            break;
                        case 6:
                            i12 = x4.f.O(parcel, readInt2);
                            break;
                        case 7:
                            xVar = (g7.x) x4.f.p(parcel, readInt2, g7.x.CREATOR);
                            break;
                        case '\b':
                            d10 = x4.f.M(parcel, readInt2);
                            break;
                        default:
                            x4.f.U(parcel, readInt2);
                            break;
                    }
                }
                x4.f.w(parcel, V2);
                e eVar = new e();
                eVar.f8276o = d6;
                eVar.f8277p = z12;
                eVar.f8278q = i11;
                eVar.f8279r = dVar;
                eVar.f8280s = i12;
                eVar.f8281t = xVar;
                eVar.f8282u = d10;
                return eVar;
            case 2:
                int V3 = x4.f.V(parcel);
                String str = null;
                while (parcel.dataPosition() < V3) {
                    int readInt3 = parcel.readInt();
                    if (((char) readInt3) != 2) {
                        x4.f.U(parcel, readInt3);
                    } else {
                        str = x4.f.q(parcel, readInt3);
                    }
                }
                x4.f.w(parcel, V3);
                return new c(str);
            case 3:
                j0 j0Var = new j0(parcel);
                j0Var.f8442o = parcel.readByte() != 0;
                return j0Var;
            case 4:
                return new ParcelImpl(parcel);
            case 5:
                int V4 = x4.f.V(parcel);
                PendingIntent pendingIntent = null;
                String str2 = null;
                Integer num = null;
                int i13 = 0;
                int i14 = 0;
                while (parcel.dataPosition() < V4) {
                    int readInt4 = parcel.readInt();
                    char c11 = (char) readInt4;
                    if (c11 == 1) {
                        i13 = x4.f.O(parcel, readInt4);
                    } else if (c11 == 2) {
                        i14 = x4.f.O(parcel, readInt4);
                    } else if (c11 == 3) {
                        pendingIntent = (PendingIntent) x4.f.p(parcel, readInt4, PendingIntent.CREATOR);
                    } else if (c11 == 4) {
                        str2 = x4.f.q(parcel, readInt4);
                    } else if (c11 != 5) {
                        x4.f.U(parcel, readInt4);
                    } else {
                        num = x4.f.P(parcel, readInt4);
                    }
                }
                x4.f.w(parcel, V4);
                return new n7.a(i13, i14, pendingIntent, str2, num);
            case 6:
                int V5 = x4.f.V(parcel);
                int i15 = 0;
                boolean z13 = false;
                long j10 = -1;
                String str3 = null;
                while (parcel.dataPosition() < V5) {
                    int readInt5 = parcel.readInt();
                    char c12 = (char) readInt5;
                    if (c12 == 1) {
                        str3 = x4.f.q(parcel, readInt5);
                    } else if (c12 == 2) {
                        i15 = x4.f.O(parcel, readInt5);
                    } else if (c12 == 3) {
                        j10 = x4.f.Q(parcel, readInt5);
                    } else if (c12 != 4) {
                        x4.f.U(parcel, readInt5);
                    } else {
                        z13 = x4.f.K(parcel, readInt5);
                    }
                }
                x4.f.w(parcel, V5);
                return new n7.c(str3, i15, j10, z13);
            case 7:
                int V6 = x4.f.V(parcel);
                String str4 = null;
                int i16 = 0;
                while (parcel.dataPosition() < V6) {
                    int readInt6 = parcel.readInt();
                    char c13 = (char) readInt6;
                    if (c13 == 1) {
                        i16 = x4.f.O(parcel, readInt6);
                    } else if (c13 != 2) {
                        x4.f.U(parcel, readInt6);
                    } else {
                        str4 = x4.f.q(parcel, readInt6);
                    }
                }
                x4.f.w(parcel, V6);
                return new Scope(i16, str4);
            case 8:
                int V7 = x4.f.V(parcel);
                String str5 = null;
                n7.a aVar = null;
                int i17 = 0;
                PendingIntent pendingIntent2 = null;
                while (parcel.dataPosition() < V7) {
                    int readInt7 = parcel.readInt();
                    char c14 = (char) readInt7;
                    if (c14 == 1) {
                        i17 = x4.f.O(parcel, readInt7);
                    } else if (c14 == 2) {
                        str5 = x4.f.q(parcel, readInt7);
                    } else if (c14 == 3) {
                        pendingIntent2 = (PendingIntent) x4.f.p(parcel, readInt7, PendingIntent.CREATOR);
                    } else if (c14 != 4) {
                        x4.f.U(parcel, readInt7);
                    } else {
                        aVar = (n7.a) x4.f.p(parcel, readInt7, n7.a.CREATOR);
                    }
                }
                x4.f.w(parcel, V7);
                return new Status(i17, str5, pendingIntent2, aVar);
            case 9:
                p0.h hVar = new p0.h(parcel);
                hVar.f9807o = parcel.readInt();
                return hVar;
            case 10:
                int V8 = x4.f.V(parcel);
                int i18 = 0;
                int i19 = 0;
                Uri uri = null;
                int i20 = 0;
                while (parcel.dataPosition() < V8) {
                    int readInt8 = parcel.readInt();
                    char c15 = (char) readInt8;
                    if (c15 == 1) {
                        i18 = x4.f.O(parcel, readInt8);
                    } else if (c15 == 2) {
                        uri = (Uri) x4.f.p(parcel, readInt8, Uri.CREATOR);
                    } else if (c15 == 3) {
                        i20 = x4.f.O(parcel, readInt8);
                    } else if (c15 != 4) {
                        x4.f.U(parcel, readInt8);
                    } else {
                        i19 = x4.f.O(parcel, readInt8);
                    }
                }
                x4.f.w(parcel, V8);
                return new q7.a(i18, uri, i20, i19);
            case 11:
                int V9 = x4.f.V(parcel);
                ArrayList arrayList = null;
                int i21 = 0;
                while (parcel.dataPosition() < V9) {
                    int readInt9 = parcel.readInt();
                    char c16 = (char) readInt9;
                    if (c16 == 1) {
                        i21 = x4.f.O(parcel, readInt9);
                    } else if (c16 != 2) {
                        x4.f.U(parcel, readInt9);
                    } else {
                        arrayList = x4.f.t(parcel, readInt9, r7.f.CREATOR);
                    }
                }
                x4.f.w(parcel, V9);
                return new r7.i(i21, arrayList);
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                int V10 = x4.f.V(parcel);
                int i22 = 0;
                int i23 = 0;
                boolean z14 = false;
                long j11 = 0;
                String str6 = null;
                while (parcel.dataPosition() < V10) {
                    int readInt10 = parcel.readInt();
                    char c17 = (char) readInt10;
                    if (c17 == 1) {
                        i22 = x4.f.O(parcel, readInt10);
                    } else if (c17 == 2) {
                        str6 = x4.f.q(parcel, readInt10);
                    } else if (c17 == 3) {
                        j11 = x4.f.Q(parcel, readInt10);
                    } else if (c17 == 4) {
                        i23 = x4.f.O(parcel, readInt10);
                    } else if (c17 != 5) {
                        x4.f.U(parcel, readInt10);
                    } else {
                        z14 = x4.f.K(parcel, readInt10);
                    }
                }
                x4.f.w(parcel, V10);
                return new r7.k(i22, str6, j11, i23, z14);
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                int V11 = x4.f.V(parcel);
                int i24 = -1;
                int i25 = 0;
                int i26 = 0;
                int i27 = 0;
                int i28 = 0;
                String str7 = null;
                String str8 = null;
                long j12 = 0;
                long j13 = 0;
                while (parcel.dataPosition() < V11) {
                    int readInt11 = parcel.readInt();
                    switch ((char) readInt11) {
                        case 1:
                            i25 = x4.f.O(parcel, readInt11);
                            break;
                        case 2:
                            i26 = x4.f.O(parcel, readInt11);
                            break;
                        case 3:
                            i27 = x4.f.O(parcel, readInt11);
                            break;
                        case 4:
                            j12 = x4.f.Q(parcel, readInt11);
                            break;
                        case 5:
                            j13 = x4.f.Q(parcel, readInt11);
                            break;
                        case 6:
                            str7 = x4.f.q(parcel, readInt11);
                            break;
                        case 7:
                            str8 = x4.f.q(parcel, readInt11);
                            break;
                        case '\b':
                            i28 = x4.f.O(parcel, readInt11);
                            break;
                        case '\t':
                            i24 = x4.f.O(parcel, readInt11);
                            break;
                        default:
                            x4.f.U(parcel, readInt11);
                            break;
                    }
                }
                x4.f.w(parcel, V11);
                return new r7.f(i25, i26, i27, j12, j13, str7, str8, i28, i24);
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                int V12 = x4.f.V(parcel);
                Account account = null;
                int i29 = 0;
                int i30 = 0;
                GoogleSignInAccount googleSignInAccount = null;
                while (parcel.dataPosition() < V12) {
                    int readInt12 = parcel.readInt();
                    char c18 = (char) readInt12;
                    if (c18 == 1) {
                        i29 = x4.f.O(parcel, readInt12);
                    } else if (c18 == 2) {
                        account = (Account) x4.f.p(parcel, readInt12, Account.CREATOR);
                    } else if (c18 == 3) {
                        i30 = x4.f.O(parcel, readInt12);
                    } else if (c18 != 4) {
                        x4.f.U(parcel, readInt12);
                    } else {
                        googleSignInAccount = (GoogleSignInAccount) x4.f.p(parcel, readInt12, GoogleSignInAccount.CREATOR);
                    }
                }
                x4.f.w(parcel, V12);
                return new r7.n(i29, account, i30, googleSignInAccount);
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                int V13 = x4.f.V(parcel);
                int i31 = 0;
                boolean z15 = false;
                boolean z16 = false;
                IBinder iBinder = null;
                n7.a aVar2 = null;
                while (parcel.dataPosition() < V13) {
                    int readInt13 = parcel.readInt();
                    char c19 = (char) readInt13;
                    if (c19 == 1) {
                        i31 = x4.f.O(parcel, readInt13);
                    } else if (c19 == 2) {
                        iBinder = x4.f.N(parcel, readInt13);
                    } else if (c19 == 3) {
                        aVar2 = (n7.a) x4.f.p(parcel, readInt13, n7.a.CREATOR);
                    } else if (c19 == 4) {
                        z15 = x4.f.K(parcel, readInt13);
                    } else if (c19 != 5) {
                        x4.f.U(parcel, readInt13);
                    } else {
                        z16 = x4.f.K(parcel, readInt13);
                    }
                }
                x4.f.w(parcel, V13);
                return new r7.o(i31, iBinder, aVar2, z15, z16);
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                int V14 = x4.f.V(parcel);
                int i32 = 0;
                boolean z17 = false;
                boolean z18 = false;
                int i33 = 0;
                int i34 = 0;
                while (parcel.dataPosition() < V14) {
                    int readInt14 = parcel.readInt();
                    char c20 = (char) readInt14;
                    if (c20 == 1) {
                        i32 = x4.f.O(parcel, readInt14);
                    } else if (c20 == 2) {
                        z17 = x4.f.K(parcel, readInt14);
                    } else if (c20 == 3) {
                        z18 = x4.f.K(parcel, readInt14);
                    } else if (c20 == 4) {
                        i33 = x4.f.O(parcel, readInt14);
                    } else if (c20 != 5) {
                        x4.f.U(parcel, readInt14);
                    } else {
                        i34 = x4.f.O(parcel, readInt14);
                    }
                }
                x4.f.w(parcel, V14);
                return new r7.h(i32, z17, z18, i33, i34);
            case 17:
                return new BinderWrapper(parcel);
            case 18:
                int V15 = x4.f.V(parcel);
                Bundle bundle = null;
                r7.c cVar = null;
                int i35 = 0;
                n7.c[] cVarArr = null;
                while (parcel.dataPosition() < V15) {
                    int readInt15 = parcel.readInt();
                    char c21 = (char) readInt15;
                    if (c21 == 1) {
                        bundle = x4.f.m(parcel, readInt15);
                    } else if (c21 == 2) {
                        cVarArr = (n7.c[]) x4.f.s(parcel, readInt15, n7.c.CREATOR);
                    } else if (c21 == 3) {
                        i35 = x4.f.O(parcel, readInt15);
                    } else if (c21 != 4) {
                        x4.f.U(parcel, readInt15);
                    } else {
                        cVar = (r7.c) x4.f.p(parcel, readInt15, r7.c.CREATOR);
                    }
                }
                x4.f.w(parcel, V15);
                z zVar = new z();
                zVar.f10962o = bundle;
                zVar.f10963p = cVarArr;
                zVar.f10964q = i35;
                zVar.f10965r = cVar;
                return zVar;
            case 19:
                int V16 = x4.f.V(parcel);
                r7.h hVar2 = null;
                int[] iArr = null;
                int[] iArr2 = null;
                boolean z19 = false;
                boolean z20 = false;
                int i36 = 0;
                while (parcel.dataPosition() < V16) {
                    int readInt16 = parcel.readInt();
                    switch ((char) readInt16) {
                        case 1:
                            hVar2 = (r7.h) x4.f.p(parcel, readInt16, r7.h.CREATOR);
                            break;
                        case 2:
                            z19 = x4.f.K(parcel, readInt16);
                            break;
                        case 3:
                            z20 = x4.f.K(parcel, readInt16);
                            break;
                        case 4:
                            iArr = x4.f.n(parcel, readInt16);
                            break;
                        case 5:
                            i36 = x4.f.O(parcel, readInt16);
                            break;
                        case 6:
                            iArr2 = x4.f.n(parcel, readInt16);
                            break;
                        default:
                            x4.f.U(parcel, readInt16);
                            break;
                    }
                }
                x4.f.w(parcel, V16);
                return new r7.c(hVar2, z19, z20, iArr, i36, iArr2);
            case 20:
                int V17 = x4.f.V(parcel);
                Bundle bundle2 = new Bundle();
                Scope[] scopeArr = r7.d.C;
                String str9 = null;
                IBinder iBinder2 = null;
                Account account2 = null;
                String str10 = null;
                int i37 = 0;
                int i38 = 0;
                int i39 = 0;
                boolean z21 = false;
                int i40 = 0;
                boolean z22 = false;
                n7.c[] cVarArr2 = r7.d.D;
                n7.c[] cVarArr3 = cVarArr2;
                while (parcel.dataPosition() < V17) {
                    int readInt17 = parcel.readInt();
                    switch ((char) readInt17) {
                        case 1:
                            i37 = x4.f.O(parcel, readInt17);
                            break;
                        case 2:
                            i38 = x4.f.O(parcel, readInt17);
                            break;
                        case 3:
                            i39 = x4.f.O(parcel, readInt17);
                            break;
                        case 4:
                            str9 = x4.f.q(parcel, readInt17);
                            break;
                        case 5:
                            iBinder2 = x4.f.N(parcel, readInt17);
                            break;
                        case 6:
                            scopeArr = (Scope[]) x4.f.s(parcel, readInt17, Scope.CREATOR);
                            break;
                        case 7:
                            bundle2 = x4.f.m(parcel, readInt17);
                            break;
                        case '\b':
                            account2 = (Account) x4.f.p(parcel, readInt17, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            x4.f.U(parcel, readInt17);
                            break;
                        case '\n':
                            cVarArr2 = (n7.c[]) x4.f.s(parcel, readInt17, n7.c.CREATOR);
                            break;
                        case 11:
                            cVarArr3 = (n7.c[]) x4.f.s(parcel, readInt17, n7.c.CREATOR);
                            break;
                        case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                            z21 = x4.f.K(parcel, readInt17);
                            break;
                        case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                            i40 = x4.f.O(parcel, readInt17);
                            break;
                        case UrlRequest.Status.READING_RESPONSE /* 14 */:
                            z22 = x4.f.K(parcel, readInt17);
                            break;
                        case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                            str10 = x4.f.q(parcel, readInt17);
                            break;
                    }
                }
                x4.f.w(parcel, V17);
                return new r7.d(i37, i38, i39, str9, iBinder2, scopeArr, bundle2, account2, cVarArr2, cVarArr3, z21, i40, z22, str10);
            case 21:
                r8.b bVar = new r8.b(parcel);
                bVar.f10968o = ((Integer) parcel.readValue(r8.b.class.getClassLoader())).intValue();
                return bVar;
            case 22:
                return new pl.droidsonroids.gif.d(parcel);
            default:
                x9.e eVar2 = new x9.e(parcel);
                eVar2.f13751o = 0.0f;
                eVar2.f13751o = parcel.readFloat();
                return eVar2;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i10) {
        switch (this.f8275a) {
            case 0:
                return new y[i10];
            case 1:
                return new e[i10];
            case 2:
                return new c[i10];
            case 3:
                return new j0[i10];
            case 4:
                return new ParcelImpl[i10];
            case 5:
                return new n7.a[i10];
            case 6:
                return new n7.c[i10];
            case 7:
                return new Scope[i10];
            case 8:
                return new Status[i10];
            case 9:
                return new p0.h[i10];
            case 10:
                return new q7.a[i10];
            case 11:
                return new r7.i[i10];
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                return new r7.k[i10];
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                return new r7.f[i10];
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                return new r7.n[i10];
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return new r7.o[i10];
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                return new r7.h[i10];
            case 17:
                return new BinderWrapper[i10];
            case 18:
                return new z[i10];
            case 19:
                return new r7.c[i10];
            case 20:
                return new r7.d[i10];
            case 21:
                return new r8.b[i10];
            case 22:
                return new pl.droidsonroids.gif.d[i10];
            default:
                return new x9.e[i10];
        }
    }
}
