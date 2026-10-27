package androidx.mediarouter.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements IBinder.DeathRecipient {

    /* renamed from: a, reason: collision with root package name */
    public final android.support.v4.media.session.e f1376a = new android.support.v4.media.session.e(this);

    /* renamed from: b, reason: collision with root package name */
    public android.support.v4.media.session.f f1377b;

    /* renamed from: c, reason: collision with root package name */
    public android.support.v4.media.session.g f1378c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f1379d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f.d0 f1380e;

    public p(f.d0 d0Var, int i10) {
        this.f1379d = i10;
        this.f1380e = d0Var;
    }

    public final void a(MediaMetadataCompat mediaMetadataCompat) {
        switch (this.f1379d) {
            case 0:
                s sVar = (s) this.f1380e;
                sVar.f1393j0 = mediaMetadataCompat == null ? null : mediaMetadataCompat.a();
                sVar.r();
                sVar.q(false);
                break;
            default:
                n0 n0Var = (n0) this.f1380e;
                n0Var.Z = mediaMetadataCompat == null ? null : mediaMetadataCompat.a();
                n0Var.h();
                n0Var.l();
                break;
        }
    }

    public void b(PlaybackStateCompat playbackStateCompat) {
        switch (this.f1379d) {
            case 0:
                s sVar = (s) this.f1380e;
                sVar.f1392i0 = playbackStateCompat;
                sVar.q(false);
                break;
        }
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        e(8, null, null);
    }

    public final void d() {
        switch (this.f1379d) {
            case 0:
                s sVar = (s) this.f1380e;
                x4.l lVar = sVar.f1391g0;
                if (lVar != null) {
                    lVar.n(sVar.h0);
                    sVar.f1391g0 = null;
                    break;
                }
                break;
            default:
                n0 n0Var = (n0) this.f1380e;
                x4.l lVar2 = n0Var.X;
                if (lVar2 != null) {
                    lVar2.n(n0Var.Y);
                    n0Var.X = null;
                    break;
                }
                break;
        }
    }

    public final void e(int i10, Object obj, Bundle bundle) {
        android.support.v4.media.session.f fVar = this.f1377b;
        if (fVar != null) {
            Message obtainMessage = fVar.obtainMessage(i10, obj);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public final void f(Handler handler) {
        if (handler != null) {
            android.support.v4.media.session.f fVar = new android.support.v4.media.session.f(this, handler.getLooper());
            this.f1377b = fVar;
            fVar.f241a = true;
        } else {
            android.support.v4.media.session.f fVar2 = this.f1377b;
            if (fVar2 != null) {
                fVar2.f241a = false;
                fVar2.removeCallbacksAndMessages(null);
                this.f1377b = null;
            }
        }
    }

    public final void c(PlaybackStateCompat playbackStateCompat) {
    }
}
