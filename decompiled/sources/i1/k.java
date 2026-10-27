package i1;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k implements Parcelable {
    public static final Parcelable.Creator<k> CREATOR = new j(1);

    /* renamed from: o, reason: collision with root package name */
    public int f5909o;

    /* renamed from: p, reason: collision with root package name */
    public final UUID f5910p;

    /* renamed from: q, reason: collision with root package name */
    public final String f5911q;

    /* renamed from: r, reason: collision with root package name */
    public final String f5912r;

    /* renamed from: s, reason: collision with root package name */
    public final byte[] f5913s;

    public k(UUID uuid, String str, String str2, byte[] bArr) {
        uuid.getClass();
        this.f5910p = uuid;
        this.f5911q = str;
        str2.getClass();
        this.f5912r = g0.m(str2);
        this.f5913s = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f5911q, kVar.f5911q) && Objects.equals(this.f5912r, kVar.f5912r) && Objects.equals(this.f5910p, kVar.f5910p) && Arrays.equals(this.f5913s, kVar.f5913s);
    }

    public final int hashCode() {
        if (this.f5909o == 0) {
            int hashCode = this.f5910p.hashCode() * 31;
            String str = this.f5911q;
            this.f5909o = Arrays.hashCode(this.f5913s) + android.support.v4.media.d.g(this.f5912r, (hashCode + (str == null ? 0 : str.hashCode())) * 31, 31);
        }
        return this.f5909o;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        UUID uuid = this.f5910p;
        parcel.writeLong(uuid.getMostSignificantBits());
        parcel.writeLong(uuid.getLeastSignificantBits());
        parcel.writeString(this.f5911q);
        parcel.writeString(this.f5912r);
        parcel.writeByteArray(this.f5913s);
    }

    public k(Parcel parcel) {
        this.f5910p = new UUID(parcel.readLong(), parcel.readLong());
        this.f5911q = parcel.readString();
        String readString = parcel.readString();
        int i10 = l1.a0.f8067a;
        this.f5912r = readString;
        this.f5913s = parcel.createByteArray();
    }
}
