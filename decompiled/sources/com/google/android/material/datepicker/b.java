package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(16);

    /* renamed from: o, reason: collision with root package name */
    public final p f3736o;

    /* renamed from: p, reason: collision with root package name */
    public final p f3737p;

    /* renamed from: q, reason: collision with root package name */
    public final d f3738q;

    /* renamed from: r, reason: collision with root package name */
    public final p f3739r;

    /* renamed from: s, reason: collision with root package name */
    public final int f3740s;

    /* renamed from: t, reason: collision with root package name */
    public final int f3741t;

    /* renamed from: u, reason: collision with root package name */
    public final int f3742u;

    public b(p pVar, p pVar2, d dVar, p pVar3, int i10) {
        Objects.requireNonNull(pVar, "start cannot be null");
        Objects.requireNonNull(pVar2, "end cannot be null");
        Objects.requireNonNull(dVar, "validator cannot be null");
        this.f3736o = pVar;
        this.f3737p = pVar2;
        this.f3739r = pVar3;
        this.f3740s = i10;
        this.f3738q = dVar;
        if (pVar3 != null && pVar.f3781o.compareTo(pVar3.f3781o) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (pVar3 != null && pVar3.f3781o.compareTo(pVar2.f3781o) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i10 < 0 || i10 > x.c(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f3742u = pVar.d(pVar2) + 1;
        this.f3741t = (pVar2.f3783q - pVar.f3783q) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f3736o.equals(bVar.f3736o) && this.f3737p.equals(bVar.f3737p) && Objects.equals(this.f3739r, bVar.f3739r) && this.f3740s == bVar.f3740s && this.f3738q.equals(bVar.f3738q);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3736o, this.f3737p, this.f3739r, Integer.valueOf(this.f3740s), this.f3738q});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f3736o, 0);
        parcel.writeParcelable(this.f3737p, 0);
        parcel.writeParcelable(this.f3739r, 0);
        parcel.writeParcelable(this.f3738q, 0);
        parcel.writeInt(this.f3740s);
    }
}
