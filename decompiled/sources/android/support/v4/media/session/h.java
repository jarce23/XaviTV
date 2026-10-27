package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.RemoteException;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final MediaController f245a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f246b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f247c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f248d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    public final MediaSessionCompat$Token f249e;

    public h(Context context, MediaSessionCompat$Token mediaSessionCompat$Token) {
        this.f249e = mediaSessionCompat$Token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) mediaSessionCompat$Token.f201p);
        this.f245a = mediaController;
        if (mediaSessionCompat$Token.a() == null) {
            MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver = new MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver(null);
            mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver.f196o = new WeakReference(this);
            mediaController.sendCommand("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, mediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver);
        }
    }

    public final void a() {
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f249e;
        if (mediaSessionCompat$Token.a() == null) {
            return;
        }
        ArrayList arrayList = this.f247c;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            androidx.mediarouter.app.p pVar = (androidx.mediarouter.app.p) obj;
            g gVar = new g(pVar);
            this.f248d.put(pVar, gVar);
            pVar.f1378c = gVar;
            try {
                mediaSessionCompat$Token.a().i(gVar);
                pVar.e(13, null, null);
            } catch (RemoteException e7) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e7);
            }
        }
        arrayList.clear();
    }

    public final void b(androidx.mediarouter.app.p pVar) {
        this.f245a.unregisterCallback(pVar.f1376a);
        synchronized (this.f246b) {
            if (this.f249e.a() != null) {
                try {
                    g gVar = (g) this.f248d.remove(pVar);
                    if (gVar != null) {
                        pVar.f1378c = null;
                        this.f249e.a().Y(gVar);
                    }
                } catch (RemoteException e7) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e7);
                }
            } else {
                this.f247c.remove(pVar);
            }
        }
    }
}
