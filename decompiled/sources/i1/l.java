package i1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements Comparator, Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new j(0);

    /* renamed from: o, reason: collision with root package name */
    public final k[] f5915o;

    /* renamed from: p, reason: collision with root package name */
    public int f5916p;

    /* renamed from: q, reason: collision with root package name */
    public final String f5917q;

    /* renamed from: r, reason: collision with root package name */
    public final int f5918r;

    public l(String str, boolean z10, k... kVarArr) {
        this.f5917q = str;
        kVarArr = z10 ? (k[]) kVarArr.clone() : kVarArr;
        this.f5915o = kVarArr;
        this.f5918r = kVarArr.length;
        Arrays.sort(kVarArr, this);
    }

    public final l a(String str) {
        return Objects.equals(this.f5917q, str) ? this : new l(str, false, this.f5915o);
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        k kVar = (k) obj;
        k kVar2 = (k) obj2;
        UUID uuid = f.f5871a;
        return uuid.equals(kVar.f5910p) ? uuid.equals(kVar2.f5910p) ? 0 : 1 : kVar.f5910p.compareTo(kVar2.f5910p);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && l.class == obj.getClass()) {
            l lVar = (l) obj;
            if (Objects.equals(this.f5917q, lVar.f5917q) && Arrays.equals(this.f5915o, lVar.f5915o)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.f5916p == 0) {
            String str = this.f5917q;
            this.f5916p = ((str == null ? 0 : str.hashCode()) * 31) + Arrays.hashCode(this.f5915o);
        }
        return this.f5916p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f5917q);
        parcel.writeTypedArray(this.f5915o, 0);
    }

    public l(Parcel parcel) {
        this.f5917q = parcel.readString();
        k[] kVarArr = (k[]) parcel.createTypedArray(k.CREATOR);
        int i10 = l1.a0.f8067a;
        this.f5915o = kVarArr;
        this.f5918r = kVarArr.length;
    }
}
