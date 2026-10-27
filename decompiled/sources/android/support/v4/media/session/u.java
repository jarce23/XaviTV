package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.support.v4.media.MediaMetadataCompat;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    public final MediaSession f261a;

    /* renamed from: b, reason: collision with root package name */
    public final MediaSessionCompat$Token f262b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f263c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public boolean f264d = false;

    /* renamed from: e, reason: collision with root package name */
    public final RemoteCallbackList f265e = new RemoteCallbackList();

    /* renamed from: f, reason: collision with root package name */
    public PlaybackStateCompat f266f;
    public MediaMetadataCompat g;

    /* renamed from: h, reason: collision with root package name */
    public s f267h;

    /* renamed from: i, reason: collision with root package name */
    public f1.a f268i;

    public u(Context context) {
        MediaSession a10 = a(context);
        this.f261a = a10;
        this.f262b = new MediaSessionCompat$Token(a10.getSessionToken(), new t(this));
        a10.setFlags(3);
    }

    public MediaSession a(Context context) {
        return new MediaSession(context, "CastMediaSession");
    }

    public final s b() {
        s sVar;
        synchronized (this.f263c) {
            sVar = this.f267h;
        }
        return sVar;
    }

    public f1.a c() {
        f1.a aVar;
        synchronized (this.f263c) {
            aVar = this.f268i;
        }
        return aVar;
    }

    public final PlaybackStateCompat d() {
        return this.f266f;
    }

    public final void e(s sVar, Handler handler) {
        synchronized (this.f263c) {
            try {
                this.f267h = sVar;
                this.f261a.setCallback(sVar == null ? null : sVar.f255b, handler);
                if (sVar != null) {
                    sVar.i(this, handler);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(f1.a aVar) {
        synchronized (this.f263c) {
            this.f268i = aVar;
        }
    }
}
