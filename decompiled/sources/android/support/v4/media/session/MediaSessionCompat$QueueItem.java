package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new z(1);

    /* renamed from: o, reason: collision with root package name */
    public final MediaDescriptionCompat f197o;

    /* renamed from: p, reason: collision with root package name */
    public final long f198p;

    public MediaSessionCompat$QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j10) {
        if (mediaDescriptionCompat == null) {
            throw new IllegalArgumentException("Description cannot be null");
        }
        if (j10 == -1) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.f197o = mediaDescriptionCompat;
        this.f198p = j10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "MediaSession.QueueItem {Description=" + this.f197o + ", Id=" + this.f198p + " }";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        this.f197o.writeToParcel(parcel, i10);
        parcel.writeLong(this.f198p);
    }

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.f197o = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.f198p = parcel.readLong();
    }
}
