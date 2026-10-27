package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends Binder implements b {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f243c = 0;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f244b;

    public g(androidx.mediarouter.app.p pVar) {
        attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        this.f244b = new WeakReference(pVar);
    }

    @Override // android.support.v4.media.session.b
    public final void I(Bundle bundle) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.b
    public final void M(ArrayList arrayList) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.b
    public final void f(CharSequence charSequence) {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.b
    public final void l() {
        throw new AssertionError();
    }

    @Override // android.support.v4.media.session.b
    public final void n(MediaMetadataCompat mediaMetadataCompat) {
        throw new AssertionError();
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
        if (i10 == 1598968902) {
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
        WeakReference weakReference = this.f244b;
        switch (i10) {
            case 1:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                String readString = parcel.readString();
                Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                androidx.mediarouter.app.p pVar = (androidx.mediarouter.app.p) weakReference.get();
                if (pVar != null) {
                    pVar.e(1, readString, bundle);
                }
                return true;
            case 2:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                l();
                return true;
            case 3:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                s0(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 4:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                n(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 5:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                M(parcel.createTypedArrayList(MediaSessionCompat$QueueItem.CREATOR));
                return true;
            case 6:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                f(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                return true;
            case 7:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                I(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 8:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                u0(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                return true;
            case 9:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int readInt = parcel.readInt();
                androidx.mediarouter.app.p pVar2 = (androidx.mediarouter.app.p) weakReference.get();
                if (pVar2 != null) {
                    pVar2.e(9, Integer.valueOf(readInt), null);
                    return true;
                }
                return true;
            case 10:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                parcel.readInt();
                return true;
            case 11:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                boolean z10 = parcel.readInt() != 0;
                androidx.mediarouter.app.p pVar3 = (androidx.mediarouter.app.p) weakReference.get();
                if (pVar3 != null) {
                    pVar3.e(11, Boolean.valueOf(z10), null);
                    return true;
                }
                return true;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                int readInt2 = parcel.readInt();
                androidx.mediarouter.app.p pVar4 = (androidx.mediarouter.app.p) weakReference.get();
                if (pVar4 != null) {
                    pVar4.e(12, Integer.valueOf(readInt2), null);
                    return true;
                }
                return true;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                androidx.mediarouter.app.p pVar5 = (androidx.mediarouter.app.p) weakReference.get();
                if (pVar5 != null) {
                    pVar5.e(13, null, null);
                    return true;
                }
                return true;
            default:
                return super.onTransact(i10, parcel, parcel2, i11);
        }
    }

    @Override // android.support.v4.media.session.b
    public final void s0(PlaybackStateCompat playbackStateCompat) {
        androidx.mediarouter.app.p pVar = (androidx.mediarouter.app.p) this.f244b.get();
        if (pVar != null) {
            pVar.e(2, playbackStateCompat, null);
        }
    }

    @Override // android.support.v4.media.session.b
    public final void u0(ParcelableVolumeInfo parcelableVolumeInfo) {
        throw new AssertionError();
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }
}
