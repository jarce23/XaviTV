package okhttp3;

import java.util.List;
import okhttp3.Handshake;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9707o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ List f9708p;

    public /* synthetic */ b(int i10, List list) {
        this.f9707o = i10;
        this.f9708p = list;
    }

    @Override // ya.a
    public final Object invoke() {
        List list;
        List handshake$lambda$2;
        switch (this.f9707o) {
            case 0:
                list = Handshake.Companion.get$lambda$0(this.f9708p);
                return list;
            default:
                handshake$lambda$2 = Handshake.Companion.handshake$lambda$2(this.f9708p);
                return handshake$lambda$2;
        }
    }
}
