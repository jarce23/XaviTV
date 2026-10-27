package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import l7.d;
import r7.r;
import s7.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new d(7);

    /* renamed from: o, reason: collision with root package name */
    public final int f3188o;

    /* renamed from: p, reason: collision with root package name */
    public final String f3189p;

    public Scope(int i10, String str) {
        r.d(str, "scopeUri must not be null or empty");
        this.f3188o = i10;
        this.f3189p = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f3189p.equals(((Scope) obj).f3189p);
    }

    public final int hashCode() {
        return this.f3189p.hashCode();
    }

    public final String toString() {
        return this.f3189p;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int E = y7.d.E(parcel, 20293);
        y7.d.D(parcel, 1, 4);
        parcel.writeInt(this.f3188o);
        y7.d.w(parcel, 2, this.f3189p);
        y7.d.G(parcel, E);
    }
}
