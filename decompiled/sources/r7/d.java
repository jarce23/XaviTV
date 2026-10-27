package r7;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends s7.a {
    public boolean A;
    public final String B;

    /* renamed from: o, reason: collision with root package name */
    public final int f10885o;

    /* renamed from: p, reason: collision with root package name */
    public final int f10886p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10887q;

    /* renamed from: r, reason: collision with root package name */
    public String f10888r;

    /* renamed from: s, reason: collision with root package name */
    public IBinder f10889s;

    /* renamed from: t, reason: collision with root package name */
    public Scope[] f10890t;

    /* renamed from: u, reason: collision with root package name */
    public Bundle f10891u;

    /* renamed from: v, reason: collision with root package name */
    public Account f10892v;

    /* renamed from: w, reason: collision with root package name */
    public n7.c[] f10893w;

    /* renamed from: x, reason: collision with root package name */
    public n7.c[] f10894x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f10895y;

    /* renamed from: z, reason: collision with root package name */
    public final int f10896z;
    public static final Parcelable.Creator<d> CREATOR = new l7.d(20);
    public static final Scope[] C = new Scope[0];
    public static final n7.c[] D = new n7.c[0];

    public d(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, n7.c[] cVarArr, n7.c[] cVarArr2, boolean z10, int i13, boolean z11, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? C : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        n7.c[] cVarArr3 = D;
        n7.c[] cVarArr4 = cVarArr == null ? cVarArr3 : cVarArr;
        cVarArr3 = cVarArr2 != null ? cVarArr2 : cVarArr3;
        this.f10885o = i10;
        this.f10886p = i11;
        this.f10887q = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f10888r = "com.google.android.gms";
        } else {
            this.f10888r = str;
        }
        if (i10 < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i14 = a.f10868c;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface e0Var = queryLocalInterface instanceof e ? (e) queryLocalInterface : new e0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        e0 e0Var2 = (e0) e0Var;
                        Parcel G = e0Var2.G(e0Var2.w0(), 2);
                        Account account3 = (Account) c8.i.a(G, Account.CREATOR);
                        G.recycle();
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    throw th;
                }
            }
            this.f10892v = account2;
        } else {
            this.f10889s = iBinder;
            this.f10892v = account;
        }
        this.f10890t = scopeArr2;
        this.f10891u = bundle2;
        this.f10893w = cVarArr4;
        this.f10894x = cVarArr3;
        this.f10895y = z10;
        this.f10896z = i13;
        this.A = z11;
        this.B = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        l7.d.a(this, parcel, i10);
    }
}
