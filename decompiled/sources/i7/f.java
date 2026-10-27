package i7;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.internal.cast.c0;
import com.google.android.gms.internal.cast.e0;
import com.google.android.gms.internal.cast.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends s7.a {
    public static final Parcelable.Creator<f> CREATOR;
    public static final i0 W;
    public static final int[] X;
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final int L;
    public final int M;
    public final int N;
    public final int O;
    public final int P;
    public final int Q;
    public final int R;
    public final int S;
    public final o T;
    public final boolean U;
    public final boolean V;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f6484o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f6485p;

    /* renamed from: q, reason: collision with root package name */
    public final long f6486q;

    /* renamed from: r, reason: collision with root package name */
    public final String f6487r;

    /* renamed from: s, reason: collision with root package name */
    public final int f6488s;

    /* renamed from: t, reason: collision with root package name */
    public final int f6489t;

    /* renamed from: u, reason: collision with root package name */
    public final int f6490u;

    /* renamed from: v, reason: collision with root package name */
    public final int f6491v;

    /* renamed from: w, reason: collision with root package name */
    public final int f6492w;

    /* renamed from: x, reason: collision with root package name */
    public final int f6493x;

    /* renamed from: y, reason: collision with root package name */
    public final int f6494y;

    /* renamed from: z, reason: collision with root package name */
    public final int f6495z;

    static {
        c0 c0Var = e0.f3300p;
        Object[] objArr = {MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING};
        for (int i10 = 0; i10 < 2; i10++) {
            if (objArr[i10] == null) {
                throw new NullPointerException(android.support.v4.media.d.m(i10, "at index "));
            }
        }
        W = e0.k(2, objArr);
        X = new int[]{0, 1};
        CREATOR = new android.support.v4.media.a(27);
    }

    public f(List list, int[] iArr, long j10, String str, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, int i28, int i29, int i30, int i31, int i32, int i33, int i34, int i35, int i36, IBinder iBinder, boolean z10, boolean z11) {
        o oVar;
        this.f6484o = new ArrayList(list);
        this.f6485p = Arrays.copyOf(iArr, iArr.length);
        this.f6486q = j10;
        this.f6487r = str;
        this.f6488s = i10;
        this.f6489t = i11;
        this.f6490u = i12;
        this.f6491v = i13;
        this.f6492w = i14;
        this.f6493x = i15;
        this.f6494y = i16;
        this.f6495z = i17;
        this.A = i18;
        this.B = i19;
        this.C = i20;
        this.D = i21;
        this.E = i22;
        this.F = i23;
        this.G = i24;
        this.H = i25;
        this.I = i26;
        this.J = i27;
        this.K = i28;
        this.L = i29;
        this.M = i30;
        this.N = i31;
        this.O = i32;
        this.P = i33;
        this.Q = i34;
        this.R = i35;
        this.S = i36;
        this.U = z10;
        this.V = z11;
        if (iBinder == null) {
            oVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
            oVar = queryLocalInterface instanceof o ? (o) queryLocalInterface : new o(iBinder, "com.google.android.gms.cast.framework.media.INotificationActionsProvider", 2);
        }
        this.T = oVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.x(parcel, 2, this.f6484o);
        int[] iArr = this.f6485p;
        y7.d.s(parcel, 3, Arrays.copyOf(iArr, iArr.length));
        y7.d.D(parcel, 4, 8);
        parcel.writeLong(this.f6486q);
        y7.d.w(parcel, 5, this.f6487r);
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(this.f6488s);
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(this.f6489t);
        y7.d.D(parcel, 8, 4);
        parcel.writeInt(this.f6490u);
        y7.d.D(parcel, 9, 4);
        parcel.writeInt(this.f6491v);
        y7.d.D(parcel, 10, 4);
        parcel.writeInt(this.f6492w);
        y7.d.D(parcel, 11, 4);
        parcel.writeInt(this.f6493x);
        y7.d.D(parcel, 12, 4);
        parcel.writeInt(this.f6494y);
        y7.d.D(parcel, 13, 4);
        parcel.writeInt(this.f6495z);
        y7.d.D(parcel, 14, 4);
        parcel.writeInt(this.A);
        y7.d.D(parcel, 15, 4);
        parcel.writeInt(this.B);
        y7.d.D(parcel, 16, 4);
        parcel.writeInt(this.C);
        y7.d.D(parcel, 17, 4);
        parcel.writeInt(this.D);
        y7.d.D(parcel, 18, 4);
        parcel.writeInt(this.E);
        y7.d.D(parcel, 19, 4);
        parcel.writeInt(this.F);
        y7.d.D(parcel, 20, 4);
        parcel.writeInt(this.G);
        y7.d.D(parcel, 21, 4);
        parcel.writeInt(this.H);
        y7.d.D(parcel, 22, 4);
        parcel.writeInt(this.I);
        y7.d.D(parcel, 23, 4);
        parcel.writeInt(this.J);
        y7.d.D(parcel, 24, 4);
        parcel.writeInt(this.K);
        y7.d.D(parcel, 25, 4);
        parcel.writeInt(this.L);
        y7.d.D(parcel, 26, 4);
        parcel.writeInt(this.M);
        y7.d.D(parcel, 27, 4);
        parcel.writeInt(this.N);
        y7.d.D(parcel, 28, 4);
        parcel.writeInt(this.O);
        y7.d.D(parcel, 29, 4);
        parcel.writeInt(this.P);
        y7.d.D(parcel, 30, 4);
        parcel.writeInt(this.Q);
        y7.d.D(parcel, 31, 4);
        parcel.writeInt(this.R);
        y7.d.D(parcel, 32, 4);
        parcel.writeInt(this.S);
        o oVar = this.T;
        y7.d.r(parcel, 33, oVar == null ? null : oVar.f2477c);
        y7.d.D(parcel, 34, 4);
        parcel.writeInt(this.U ? 1 : 0);
        y7.d.D(parcel, 35, 4);
        parcel.writeInt(this.V ? 1 : 0);
        y7.d.G(parcel, E);
    }
}
