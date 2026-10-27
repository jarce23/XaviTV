package r7;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends s7.a {
    public static final Parcelable.Creator<n> CREATOR = new l7.d(14);

    /* renamed from: o, reason: collision with root package name */
    public final int f10935o;

    /* renamed from: p, reason: collision with root package name */
    public final Account f10936p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10937q;

    /* renamed from: r, reason: collision with root package name */
    public final GoogleSignInAccount f10938r;

    public n(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f10935o = i10;
        this.f10936p = account;
        this.f10937q = i11;
        this.f10938r = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f10935o);
        y7.d.v(parcel, 2, this.f10936p, i10);
        y7.d.D(parcel, 3, 4);
        parcel.writeInt(this.f10937q);
        y7.d.v(parcel, 4, this.f10938r, i10);
        y7.d.G(parcel, E);
    }
}
