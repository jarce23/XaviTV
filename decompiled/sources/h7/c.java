package h7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends s7.a {
    public static final Parcelable.Creator<c> CREATOR;
    public static final d0 E = new d0(false);
    public static final e0 F = new e0(0);
    public static final i7.a G;
    public final boolean A;
    public final boolean B;
    public final d0 C;
    public e0 D;

    /* renamed from: o, reason: collision with root package name */
    public final String f5712o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f5713p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f5714q;

    /* renamed from: r, reason: collision with root package name */
    public final g7.i f5715r;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f5716s;

    /* renamed from: t, reason: collision with root package name */
    public final i7.a f5717t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f5718u;

    /* renamed from: v, reason: collision with root package name */
    public final double f5719v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f5720w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f5721x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f5722y;

    /* renamed from: z, reason: collision with root package name */
    public final List f5723z;

    static {
        new i7.f(i7.f.W, i7.f.X, 10000L, null, y7.d.A("smallIconDrawableResId"), y7.d.A("stopLiveStreamDrawableResId"), y7.d.A("pauseDrawableResId"), y7.d.A("playDrawableResId"), y7.d.A("skipNextDrawableResId"), y7.d.A("skipPrevDrawableResId"), y7.d.A("forwardDrawableResId"), y7.d.A("forward10DrawableResId"), y7.d.A("forward30DrawableResId"), y7.d.A("rewindDrawableResId"), y7.d.A("rewind10DrawableResId"), y7.d.A("rewind30DrawableResId"), y7.d.A("disconnectDrawableResId"), y7.d.A("notificationImageSizeDimenResId"), y7.d.A("castingToDeviceStringResId"), y7.d.A("stopLiveStreamStringResId"), y7.d.A("pauseStringResId"), y7.d.A("playStringResId"), y7.d.A("skipNextStringResId"), y7.d.A("skipPrevStringResId"), y7.d.A("forwardStringResId"), y7.d.A("forward10StringResId"), y7.d.A("forward30StringResId"), y7.d.A("rewindStringResId"), y7.d.A("rewind10StringResId"), y7.d.A("rewind30StringResId"), y7.d.A("disconnectStringResId"), null, false, false);
        G = new i7.a("com.google.android.gms.cast.framework.media.MediaIntentReceiver", null, null, null, false, false);
        CREATOR = new android.support.v4.media.a(22);
    }

    public c(String str, ArrayList arrayList, boolean z10, g7.i iVar, boolean z11, i7.a aVar, boolean z12, double d6, boolean z13, boolean z14, boolean z15, ArrayList arrayList2, boolean z16, boolean z17, d0 d0Var, e0 e0Var) {
        this.f5712o = true == TextUtils.isEmpty(str) ? _UrlKt.FRAGMENT_ENCODE_SET : str;
        int size = arrayList == null ? 0 : arrayList.size();
        ArrayList arrayList3 = new ArrayList(size);
        this.f5713p = arrayList3;
        if (size > 0) {
            arrayList3.addAll(arrayList);
        }
        this.f5714q = z10;
        this.f5715r = iVar == null ? new g7.i() : iVar;
        this.f5716s = z11;
        this.f5717t = aVar;
        this.f5718u = z12;
        this.f5719v = d6;
        this.f5720w = z13;
        this.f5721x = z14;
        this.f5722y = z15;
        this.f5723z = arrayList2;
        this.A = z16;
        this.B = z17;
        this.C = d0Var;
        this.D = e0Var;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E2 = y7.d.E(parcel, 20293);
        y7.d.w(parcel, 2, this.f5712o);
        y7.d.x(parcel, 3, Collections.unmodifiableList(this.f5713p));
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(this.f5714q ? 1 : 0);
        y7.d.v(parcel, 5, this.f5715r, i10);
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(this.f5716s ? 1 : 0);
        y7.d.v(parcel, 7, this.f5717t, i10);
        y7.d.D(parcel, 8, 4);
        parcel.writeInt(this.f5718u ? 1 : 0);
        y7.d.D(parcel, 9, 8);
        parcel.writeDouble(this.f5719v);
        y7.d.D(parcel, 10, 4);
        parcel.writeInt(this.f5720w ? 1 : 0);
        y7.d.D(parcel, 11, 4);
        parcel.writeInt(this.f5721x ? 1 : 0);
        y7.d.D(parcel, 12, 4);
        parcel.writeInt(this.f5722y ? 1 : 0);
        y7.d.x(parcel, 13, Collections.unmodifiableList(this.f5723z));
        y7.d.D(parcel, 14, 4);
        parcel.writeInt(this.A ? 1 : 0);
        y7.d.D(parcel, 15, 4);
        parcel.writeInt(0);
        y7.d.D(parcel, 16, 4);
        parcel.writeInt(this.B ? 1 : 0);
        y7.d.v(parcel, 17, this.C, i10);
        y7.d.v(parcel, 18, this.D, i10);
        y7.d.G(parcel, E2);
    }
}
