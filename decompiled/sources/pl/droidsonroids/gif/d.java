package pl.droidsonroids.gif;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends View.BaseSavedState {
    public static final Parcelable.Creator<d> CREATOR = new l7.d(22);

    /* renamed from: o, reason: collision with root package name */
    public final long[][] f10214o;

    public d(Parcelable parcelable, Drawable... drawableArr) {
        super(parcelable);
        this.f10214o = new long[drawableArr.length][];
        for (int i10 = 0; i10 < drawableArr.length; i10++) {
            Drawable drawable = drawableArr[i10];
            if (drawable instanceof c) {
                this.f10214o[i10] = ((c) drawable).f10208u.i();
            } else {
                this.f10214o[i10] = null;
            }
        }
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        long[][] jArr = this.f10214o;
        parcel.writeInt(jArr.length);
        for (long[] jArr2 : jArr) {
            parcel.writeLongArray(jArr2);
        }
    }

    public d(Parcel parcel) {
        super(parcel);
        this.f10214o = new long[parcel.readInt()][];
        int i10 = 0;
        while (true) {
            long[][] jArr = this.f10214o;
            if (i10 >= jArr.length) {
                return;
            }
            jArr[i10] = parcel.createLongArray();
            i10++;
        }
    }
}
