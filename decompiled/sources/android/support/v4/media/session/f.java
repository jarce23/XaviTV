package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public boolean f241a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.mediarouter.app.p f242b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(androidx.mediarouter.app.p pVar, Looper looper) {
        super(looper);
        this.f242b = pVar;
        this.f241a = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (this.f241a) {
            int i10 = message.what;
            androidx.mediarouter.app.p pVar = this.f242b;
            switch (i10) {
                case 1:
                    a0.G(message.getData());
                    break;
                case 2:
                    pVar.b((PlaybackStateCompat) message.obj);
                    break;
                case 3:
                    pVar.a((MediaMetadataCompat) message.obj);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    a0.G((Bundle) message.obj);
                    break;
                case 8:
                    pVar.d();
                    break;
                case 9:
                    ((Integer) message.obj).getClass();
                    break;
                case 11:
                    ((Boolean) message.obj).getClass();
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    ((Integer) message.obj).getClass();
                    break;
            }
        }
    }
}
