package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new z(4);

    /* renamed from: o, reason: collision with root package name */
    public final int f209o;

    /* renamed from: p, reason: collision with root package name */
    public final long f210p;

    /* renamed from: q, reason: collision with root package name */
    public final long f211q;

    /* renamed from: r, reason: collision with root package name */
    public final float f212r;

    /* renamed from: s, reason: collision with root package name */
    public final long f213s;

    /* renamed from: t, reason: collision with root package name */
    public final int f214t;

    /* renamed from: u, reason: collision with root package name */
    public final CharSequence f215u;

    /* renamed from: v, reason: collision with root package name */
    public final long f216v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f217w;

    /* renamed from: x, reason: collision with root package name */
    public final long f218x;

    /* renamed from: y, reason: collision with root package name */
    public final Bundle f219y;

    /* renamed from: z, reason: collision with root package name */
    public PlaybackState f220z;

    public PlaybackStateCompat(int i10, long j10, long j11, float f10, long j12, int i11, CharSequence charSequence, long j13, ArrayList arrayList, long j14, Bundle bundle) {
        this.f209o = i10;
        this.f210p = j10;
        this.f211q = j11;
        this.f212r = f10;
        this.f213s = j12;
        this.f214t = i11;
        this.f215u = charSequence;
        this.f216v = j13;
        this.f217w = new ArrayList(arrayList);
        this.f218x = j14;
        this.f219y = bundle;
    }

    public static PlaybackStateCompat a(PlaybackState playbackState) {
        ArrayList arrayList;
        CustomAction customAction;
        if (playbackState == null) {
            return null;
        }
        List<PlaybackState.CustomAction> j10 = b0.j(playbackState);
        if (j10 != null) {
            ArrayList arrayList2 = new ArrayList(j10.size());
            for (PlaybackState.CustomAction customAction2 : j10) {
                if (customAction2 != null) {
                    PlaybackState.CustomAction customAction3 = customAction2;
                    Bundle l10 = b0.l(customAction3);
                    a0.G(l10);
                    customAction = new CustomAction(b0.f(customAction3), b0.o(customAction3), b0.m(customAction3), l10);
                    customAction.f225s = customAction3;
                } else {
                    customAction = null;
                }
                arrayList2.add(customAction);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Bundle a10 = c0.a(playbackState);
        a0.G(a10);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(b0.r(playbackState), b0.q(playbackState), b0.i(playbackState), b0.p(playbackState), b0.g(playbackState), 0, b0.k(playbackState), b0.n(playbackState), arrayList, b0.h(playbackState), a10);
        playbackStateCompat.f220z = playbackState;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.f209o + ", position=" + this.f210p + ", buffered position=" + this.f211q + ", speed=" + this.f212r + ", updated=" + this.f216v + ", actions=" + this.f213s + ", error code=" + this.f214t + ", error message=" + this.f215u + ", custom actions=" + this.f217w + ", active item id=" + this.f218x + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f209o);
        parcel.writeLong(this.f210p);
        parcel.writeFloat(this.f212r);
        parcel.writeLong(this.f216v);
        parcel.writeLong(this.f211q);
        parcel.writeLong(this.f213s);
        TextUtils.writeToParcel(this.f215u, parcel, i10);
        parcel.writeTypedList(this.f217w);
        parcel.writeLong(this.f218x);
        parcel.writeBundle(this.f219y);
        parcel.writeInt(this.f214t);
    }

    /* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new e0();

        /* renamed from: o, reason: collision with root package name */
        public final String f221o;

        /* renamed from: p, reason: collision with root package name */
        public final CharSequence f222p;

        /* renamed from: q, reason: collision with root package name */
        public final int f223q;

        /* renamed from: r, reason: collision with root package name */
        public final Bundle f224r;

        /* renamed from: s, reason: collision with root package name */
        public PlaybackState.CustomAction f225s;

        public CustomAction(String str, CharSequence charSequence, int i10, Bundle bundle) {
            this.f221o = str;
            this.f222p = charSequence;
            this.f223q = i10;
            this.f224r = bundle;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.f222p) + ", mIcon=" + this.f223q + ", mExtras=" + this.f224r;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f221o);
            TextUtils.writeToParcel(this.f222p, parcel, i10);
            parcel.writeInt(this.f223q);
            parcel.writeBundle(this.f224r);
        }

        public CustomAction(Parcel parcel) {
            this.f221o = parcel.readString();
            this.f222p = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f223q = parcel.readInt();
            this.f224r = parcel.readBundle(a0.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f209o = parcel.readInt();
        this.f210p = parcel.readLong();
        this.f212r = parcel.readFloat();
        this.f216v = parcel.readLong();
        this.f211q = parcel.readLong();
        this.f213s = parcel.readLong();
        this.f215u = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f217w = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f218x = parcel.readLong();
        this.f219y = parcel.readBundle(a0.class.getClassLoader());
        this.f214t = parcel.readInt();
    }
}
