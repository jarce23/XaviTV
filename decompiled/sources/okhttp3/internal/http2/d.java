package okhttp3.internal.http2;

import java.util.List;
import la.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9725o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Http2Connection f9726p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f9727q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f9728r;

    public /* synthetic */ d(Http2Connection http2Connection, int i10, Object obj, int i11) {
        this.f9725o = i11;
        this.f9726p = http2Connection;
        this.f9727q = i10;
        this.f9728r = obj;
    }

    @Override // ya.a
    public final Object invoke() {
        i writeSynResetLater$lambda$0;
        i pushResetLater$lambda$0;
        i pushRequestLater$lambda$1;
        switch (this.f9725o) {
            case 0:
                writeSynResetLater$lambda$0 = Http2Connection.writeSynResetLater$lambda$0(this.f9726p, this.f9727q, (ErrorCode) this.f9728r);
                return writeSynResetLater$lambda$0;
            case 1:
                pushResetLater$lambda$0 = Http2Connection.pushResetLater$lambda$0(this.f9726p, this.f9727q, (ErrorCode) this.f9728r);
                return pushResetLater$lambda$0;
            default:
                pushRequestLater$lambda$1 = Http2Connection.pushRequestLater$lambda$1(this.f9726p, this.f9727q, (List) this.f9728r);
                return pushRequestLater$lambda$1;
        }
    }
}
