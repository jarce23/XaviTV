package g7;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends s7.a {
    public static final Parcelable.Creator<i> CREATOR = new v(5);

    /* renamed from: o, reason: collision with root package name */
    public final boolean f5225o;

    /* renamed from: p, reason: collision with root package name */
    public final String f5226p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f5227q;

    /* renamed from: r, reason: collision with root package name */
    public final h f5228r;

    public i(boolean z10, String str, boolean z11, h hVar) {
        this.f5225o = z10;
        this.f5226p = str;
        this.f5227q = z11;
        this.f5228r = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f5225o == iVar.f5225o && l7.a.d(this.f5226p, iVar.f5226p) && this.f5227q == iVar.f5227q && l7.a.d(this.f5228r, iVar.f5228r);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f5225o), this.f5226p, Boolean.valueOf(this.f5227q), this.f5228r});
    }

    public final String toString() {
        return "LaunchOptions(relaunchIfRunning=" + this.f5225o + ", language=" + this.f5226p + ", androidReceiverCompatible: " + this.f5227q + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 2, 4);
        parcel.writeInt(this.f5225o ? 1 : 0);
        y7.d.w(parcel, 3, this.f5226p);
        boolean z10 = this.f5227q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(z10 ? 1 : 0);
        y7.d.v(parcel, 5, this.f5228r, i10);
        y7.d.G(parcel, E);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public i() {
        /*
            r5 = this;
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.util.regex.Pattern r1 = l7.a.f8269a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = 20
            r1.<init>(r2)
            java.lang.String r2 = r0.getLanguage()
            r1.append(r2)
            java.lang.String r2 = r0.getCountry()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            r4 = 45
            if (r3 != 0) goto L26
            r1.append(r4)
            r1.append(r2)
        L26:
            java.lang.String r0 = r0.getVariant()
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L36
            r1.append(r4)
            r1.append(r0)
        L36:
            java.lang.String r0 = r1.toString()
            r1 = 0
            r2 = 0
            r5.<init>(r2, r0, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.i.<init>():void");
    }
}
