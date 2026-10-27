package androidx.activity.result;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new android.support.v4.media.a(5);

    /* renamed from: o, reason: collision with root package name */
    public final IntentSender f347o;

    /* renamed from: p, reason: collision with root package name */
    public final Intent f348p;

    /* renamed from: q, reason: collision with root package name */
    public final int f349q;

    /* renamed from: r, reason: collision with root package name */
    public final int f350r;

    public h(IntentSender intentSender, Intent intent, int i10, int i11) {
        this.f347o = intentSender;
        this.f348p = intent;
        this.f349q = i10;
        this.f350r = i11;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        za.h.e("dest", parcel);
        parcel.writeParcelable(this.f347o, i10);
        parcel.writeParcelable(this.f348p, i10);
        parcel.writeInt(this.f349q);
        parcel.writeInt(this.f350r);
    }
}
