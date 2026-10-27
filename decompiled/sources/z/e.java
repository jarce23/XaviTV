package z;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import b4.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends r0.b {
    public static final Parcelable.Creator<e> CREATOR = new x0(8);

    /* renamed from: q, reason: collision with root package name */
    public SparseArray f13946q;

    public e(Parcel parcel, ClassLoader classLoader) {
        super(parcel, classLoader);
        int readInt = parcel.readInt();
        int[] iArr = new int[readInt];
        parcel.readIntArray(iArr);
        Parcelable[] readParcelableArray = parcel.readParcelableArray(classLoader);
        this.f13946q = new SparseArray(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f13946q.append(iArr[i10], readParcelableArray[i10]);
        }
    }

    @Override // r0.b, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        SparseArray sparseArray = this.f13946q;
        int size = sparseArray != null ? sparseArray.size() : 0;
        parcel.writeInt(size);
        int[] iArr = new int[size];
        Parcelable[] parcelableArr = new Parcelable[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr[i11] = this.f13946q.keyAt(i11);
            parcelableArr[i11] = (Parcelable) this.f13946q.valueAt(i11);
        }
        parcel.writeIntArray(iArr);
        parcel.writeParcelableArray(parcelableArr, i10);
    }
}
