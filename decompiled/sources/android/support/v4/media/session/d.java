package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.view.KeyEvent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public interface d extends IInterface {
    void B();

    void D(int i10);

    void E();

    void F(String str, Bundle bundle);

    void H();

    void K();

    void L(String str, Bundle bundle, MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper);

    void N();

    void O(int i10, int i11);

    void P(int i10);

    void Q();

    CharSequence T();

    MediaMetadataCompat U();

    void V(String str, Bundle bundle);

    Bundle X();

    void Y(b bVar);

    void b();

    void b0(String str, Bundle bundle);

    void c0();

    long d();

    void e(float f10);

    void e0(long j10);

    void f0(String str, Bundle bundle);

    void g0(int i10, int i11);

    Bundle getExtras();

    void h(String str, Bundle bundle);

    ParcelableVolumeInfo h0();

    void i(b bVar);

    void j(RatingCompat ratingCompat, Bundle bundle);

    void j0();

    void k0(Uri uri, Bundle bundle);

    void m(MediaDescriptionCompat mediaDescriptionCompat, int i10);

    void m0(long j10);

    void next();

    String o();

    void o0(int i10);

    void p(boolean z10);

    void pause();

    void previous();

    void q(RatingCompat ratingCompat);

    String q0();

    void s(Uri uri, Bundle bundle);

    void stop();

    PlaybackStateCompat t();

    void u(MediaDescriptionCompat mediaDescriptionCompat);

    boolean v0(KeyEvent keyEvent);

    boolean x();

    void y(MediaDescriptionCompat mediaDescriptionCompat);

    PendingIntent z();
}
