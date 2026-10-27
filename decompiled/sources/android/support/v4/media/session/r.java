package android.support.v4.media.session;

import android.content.Intent;
import android.media.Rating;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.ParcelImpl;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends MediaSession.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f253a;

    public r(s sVar) {
        this.f253a = sVar;
    }

    public static void b(u uVar) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return;
        }
        MediaSession mediaSession = uVar.f261a;
        String str = null;
        if (i10 >= 24) {
            try {
                str = (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
            } catch (Exception e7) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e7);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = "android.media.session.MediaController";
        }
        uVar.f(new f1.a(str, -1, -1));
    }

    public final u a() {
        u uVar;
        synchronized (this.f253a.f254a) {
            uVar = (u) this.f253a.f257d.get();
        }
        if (uVar == null || this.f253a != uVar.b()) {
            return null;
        }
        return uVar;
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
        n4.d dVar;
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        try {
            if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                Bundle bundle2 = new Bundle();
                MediaSessionCompat$Token mediaSessionCompat$Token = a10.f262b;
                d a11 = mediaSessionCompat$Token.a();
                bundle2.putBinder("android.support.v4.media.session.EXTRA_BINDER", a11 == null ? null : a11.asBinder());
                synchronized (mediaSessionCompat$Token.f200o) {
                    dVar = mediaSessionCompat$Token.f203r;
                }
                if (dVar != null) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable("a", new ParcelImpl(dVar));
                    bundle2.putParcelable("android.support.v4.media.session.SESSION_TOKEN2", bundle3);
                }
                resultReceiver.send(0, bundle2);
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
            } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX");
            } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
            } else {
                str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT");
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
        }
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onCustomAction(String str, Bundle bundle) {
        s sVar = this.f253a;
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        try {
            if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                a0.G(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
            } else if (!str.equals("android.support.v4.media.session.action.PREPARE")) {
                if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                    bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                    a0.G(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                    bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                    a0.G(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                    a0.G(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                    bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED");
                } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                    bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE");
                } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                    bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE");
                } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                    a0.G(bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS"));
                } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                    bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f);
                } else {
                    sVar.b(str);
                }
            }
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
        }
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onFastForward() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final boolean onMediaButtonEvent(Intent intent) {
        u a10 = a();
        if (a10 == null) {
            return false;
        }
        b(a10);
        boolean c10 = this.f253a.c(intent);
        a10.f(null);
        return c10 || super.onMediaButtonEvent(intent);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPause() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        this.f253a.d();
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlay() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        this.f253a.e();
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromMediaId(String str, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromSearch(String str, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPlayFromUri(Uri uri, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepare() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromMediaId(String str, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromSearch(String str, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onPrepareFromUri(Uri uri, Bundle bundle) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        a0.G(bundle);
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onRewind() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSeekTo(long j10) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        this.f253a.f(j10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetPlaybackSpeed(float f10) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSetRating(Rating rating) {
        float f10;
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        if (rating != null) {
            int b2 = android.support.v4.media.e.b(rating);
            RatingCompat ratingCompat = null;
            if (!android.support.v4.media.e.e(rating)) {
                switch (b2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        ratingCompat = new RatingCompat(b2, -1.0f);
                        break;
                }
            } else {
                switch (b2) {
                    case 1:
                        ratingCompat = new RatingCompat(1, android.support.v4.media.e.d(rating) ? 1.0f : 0.0f);
                        break;
                    case 2:
                        ratingCompat = new RatingCompat(2, android.support.v4.media.e.f(rating) ? 1.0f : 0.0f);
                        break;
                    case 3:
                    case 4:
                    case 5:
                        float c10 = android.support.v4.media.e.c(rating);
                        if (b2 == 3) {
                            f10 = 3.0f;
                        } else if (b2 == 4) {
                            f10 = 4.0f;
                        } else if (b2 != 5) {
                            Log.e("Rating", "Invalid rating style (" + b2 + ") for a star rating");
                            break;
                        } else {
                            f10 = 5.0f;
                        }
                        if (c10 >= 0.0f && c10 <= f10) {
                            ratingCompat = new RatingCompat(b2, c10);
                            break;
                        } else {
                            Log.e("Rating", "Trying to set out of range star-based rating");
                            break;
                        }
                        break;
                    case 6:
                        float a11 = android.support.v4.media.e.a(rating);
                        if (a11 >= 0.0f && a11 <= 100.0f) {
                            ratingCompat = new RatingCompat(6, a11);
                            break;
                        } else {
                            Log.e("Rating", "Invalid percentage-based rating value");
                            break;
                        }
                        break;
                }
            }
            ratingCompat.getClass();
        }
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToNext() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        this.f253a.g();
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToPrevious() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        this.f253a.h();
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onSkipToQueueItem(long j10) {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }

    @Override // android.media.session.MediaSession.Callback
    public final void onStop() {
        u a10 = a();
        if (a10 == null) {
            return;
        }
        b(a10);
        a10.f(null);
    }
}
