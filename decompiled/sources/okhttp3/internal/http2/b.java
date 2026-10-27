package okhttp3.internal.http2;

import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9719o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ long f9720p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Lockable f9721q;

    public /* synthetic */ b(Lockable lockable, long j10, int i10) {
        this.f9719o = i10;
        this.f9721q = lockable;
        this.f9720p = j10;
    }

    @Override // ya.a
    public final Object invoke() {
        long _init_$lambda$0;
        switch (this.f9719o) {
            case 0:
                _init_$lambda$0 = Http2Connection._init_$lambda$0((Http2Connection) this.f9721q, this.f9720p);
                break;
            default:
                _init_$lambda$0 = RealWebSocket.initReaderAndWriter$lambda$0$0((RealWebSocket) this.f9721q, this.f9720p);
                break;
        }
        return Long.valueOf(_init_$lambda$0);
    }
}
