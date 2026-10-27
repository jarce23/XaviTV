package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g7.v;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import l7.y;
import okhttp3.internal.url._UrlKt;
import s7.a;
import y7.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class CastDevice extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<CastDevice> CREATOR = new v(22);
    public final int A;
    public final String B;
    public final byte[] C;
    public final String D;
    public final boolean E;
    public final y F;
    public final Integer G;

    /* renamed from: o, reason: collision with root package name */
    public final String f3128o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3129p;

    /* renamed from: q, reason: collision with root package name */
    public final InetAddress f3130q;

    /* renamed from: r, reason: collision with root package name */
    public final String f3131r;

    /* renamed from: s, reason: collision with root package name */
    public final String f3132s;

    /* renamed from: t, reason: collision with root package name */
    public final String f3133t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3134u;

    /* renamed from: v, reason: collision with root package name */
    public final List f3135v;

    /* renamed from: w, reason: collision with root package name */
    public final int f3136w;

    /* renamed from: x, reason: collision with root package name */
    public final int f3137x;

    /* renamed from: y, reason: collision with root package name */
    public final String f3138y;

    /* renamed from: z, reason: collision with root package name */
    public final String f3139z;

    public CastDevice(String str, String str2, String str3, String str4, String str5, int i10, ArrayList arrayList, int i11, int i12, String str6, String str7, int i13, String str8, byte[] bArr, String str9, boolean z10, y yVar, Integer num) {
        this.f3128o = str == null ? _UrlKt.FRAGMENT_ENCODE_SET : str;
        str2 = str2 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str2;
        this.f3129p = str2;
        if (!TextUtils.isEmpty(str2)) {
            try {
                this.f3130q = InetAddress.getByName(str2);
            } catch (UnknownHostException e7) {
                Log.i("CastDevice", "Unable to convert host address (" + this.f3129p + ") to ipaddress: " + e7.getMessage());
            }
        }
        this.f3131r = str3 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str3;
        this.f3132s = str4 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str4;
        this.f3133t = str5 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str5;
        this.f3134u = i10;
        this.f3135v = arrayList == null ? new ArrayList() : arrayList;
        this.f3136w = i11;
        this.f3137x = i12;
        this.f3138y = str6 == null ? _UrlKt.FRAGMENT_ENCODE_SET : str6;
        this.f3139z = str7;
        this.A = i13;
        this.B = str8;
        this.C = bArr;
        this.D = str9;
        this.E = z10;
        this.F = yVar;
        this.G = num;
    }

    public static CastDevice b(Bundle bundle) {
        ClassLoader classLoader;
        if (bundle == null || (classLoader = CastDevice.class.getClassLoader()) == null) {
            return null;
        }
        bundle.setClassLoader(classLoader);
        return (CastDevice) bundle.getParcelable("com.google.android.gms.cast.EXTRA_CAST_DEVICE");
    }

    public final boolean c(int i10) {
        return (this.f3136w & i10) == i10;
    }

    public final y d() {
        y yVar = this.F;
        if (yVar == null) {
            return (c(32) || c(64)) ? new y(1, false, false) : yVar;
        }
        return yVar;
    }

    public final boolean equals(Object obj) {
        int i10;
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CastDevice)) {
            return false;
        }
        CastDevice castDevice = (CastDevice) obj;
        byte[] bArr2 = castDevice.C;
        int i11 = castDevice.f3134u;
        String str = castDevice.f3133t;
        String str2 = castDevice.f3128o;
        String str3 = this.f3128o;
        if (str3 == null) {
            return str2 == null;
        }
        if (l7.a.d(str3, str2) && l7.a.d(this.f3130q, castDevice.f3130q) && l7.a.d(this.f3132s, castDevice.f3132s) && l7.a.d(this.f3131r, castDevice.f3131r)) {
            String str4 = this.f3133t;
            if (l7.a.d(str4, str) && (i10 = this.f3134u) == i11 && l7.a.d(this.f3135v, castDevice.f3135v) && this.f3136w == castDevice.f3136w && this.f3137x == castDevice.f3137x && l7.a.d(this.f3138y, castDevice.f3138y) && l7.a.d(Integer.valueOf(this.A), Integer.valueOf(castDevice.A)) && l7.a.d(this.B, castDevice.B) && l7.a.d(this.f3139z, castDevice.f3139z) && l7.a.d(str4, str) && i10 == i11 && ((((bArr = this.C) == null && bArr2 == null) || Arrays.equals(bArr, bArr2)) && l7.a.d(this.D, castDevice.D) && this.E == castDevice.E && l7.a.d(d(), castDevice.d()))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.f3128o;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        String str = this.f3131r;
        if (!TextUtils.isEmpty(str)) {
            int length = str.length();
            str = length <= 2 ? length == 2 ? "xx" : "x" : String.format(locale, "%c%d%c", Character.valueOf(str.charAt(0)), Integer.valueOf(length - 2), Character.valueOf(str.charAt(length - 1)));
        }
        return "\"" + str + "\" (" + this.f3128o + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = d.E(parcel, 20293);
        d.w(parcel, 2, this.f3128o);
        d.w(parcel, 3, this.f3129p);
        d.w(parcel, 4, this.f3131r);
        d.w(parcel, 5, this.f3132s);
        d.w(parcel, 6, this.f3133t);
        d.D(parcel, 7, 4);
        parcel.writeInt(this.f3134u);
        d.z(parcel, 8, Collections.unmodifiableList(this.f3135v));
        d.D(parcel, 9, 4);
        parcel.writeInt(this.f3136w);
        d.D(parcel, 10, 4);
        parcel.writeInt(this.f3137x);
        d.w(parcel, 11, this.f3138y);
        d.w(parcel, 12, this.f3139z);
        d.D(parcel, 13, 4);
        parcel.writeInt(this.A);
        d.w(parcel, 14, this.B);
        byte[] bArr = this.C;
        if (bArr != null) {
            int E2 = d.E(parcel, 15);
            parcel.writeByteArray(bArr);
            d.G(parcel, E2);
        }
        d.w(parcel, 16, this.D);
        d.D(parcel, 17, 4);
        parcel.writeInt(this.E ? 1 : 0);
        d.v(parcel, 18, d(), i10);
        d.t(parcel, 19, this.G);
        d.G(parcel, E);
    }
}
