package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaSessionCompat$Token implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new z(2);

    /* renamed from: p, reason: collision with root package name */
    public final Object f201p;

    /* renamed from: q, reason: collision with root package name */
    public d f202q;

    /* renamed from: o, reason: collision with root package name */
    public final Object f200o = new Object();

    /* renamed from: r, reason: collision with root package name */
    public n4.d f203r = null;

    public MediaSessionCompat$Token(Object obj, t tVar) {
        this.f201p = obj;
        this.f202q = tVar;
    }

    public final d a() {
        d dVar;
        synchronized (this.f200o) {
            dVar = this.f202q;
        }
        return dVar;
    }

    public final void b(d dVar) {
        synchronized (this.f200o) {
            this.f202q = dVar;
        }
    }

    public final void c(n4.d dVar) {
        synchronized (this.f200o) {
            this.f203r = dVar;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaSessionCompat$Token)) {
            return false;
        }
        Object obj2 = ((MediaSessionCompat$Token) obj).f201p;
        Object obj3 = this.f201p;
        if (obj3 == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f201p;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable((Parcelable) this.f201p, i10);
    }
}
