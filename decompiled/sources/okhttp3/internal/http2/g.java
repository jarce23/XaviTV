package okhttp3.internal.http2;

import la.i;
import okhttp3.internal.http2.Http2Connection;
import za.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9736o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Http2Connection f9737p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f9738q;

    public /* synthetic */ g(Http2Connection http2Connection, Object obj, int i10) {
        this.f9736o = i10;
        this.f9737p = http2Connection;
        this.f9738q = obj;
    }

    @Override // ya.a
    public final Object invoke() {
        i headers$lambda$0$0;
        i applyAndAckSettings$lambda$0$0$1;
        switch (this.f9736o) {
            case 0:
                headers$lambda$0$0 = Http2Connection.ReaderRunnable.headers$lambda$0$0(this.f9737p, (Http2Stream) this.f9738q);
                return headers$lambda$0$0;
            default:
                applyAndAckSettings$lambda$0$0$1 = Http2Connection.ReaderRunnable.applyAndAckSettings$lambda$0$0$1(this.f9737p, (m) this.f9738q);
                return applyAndAckSettings$lambda$0$0$1;
        }
    }
}
