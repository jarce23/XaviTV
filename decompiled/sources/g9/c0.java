package g9;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b4.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 extends r0.b {
    public static final Parcelable.Creator<c0> CREATOR = new x0(2);

    /* renamed from: q, reason: collision with root package name */
    public CharSequence f5332q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5333r;

    public c0(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        this.f5332q = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f5333r = parcel.readInt() == 1;
    }

    public final String toString() {
        return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f5332q) + "}";
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        TextUtils.writeToParcel(this.f5332q, parcel, i10);
        parcel.writeInt(this.f5333r ? 1 : 0);
    }
}
