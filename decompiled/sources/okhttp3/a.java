package okhttp3;

import java.util.List;
import okhttp3.internal.connection.ConnectPlan;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9703o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ CertificatePinner f9704p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f9705q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f9706r;

    public /* synthetic */ a(CertificatePinner certificatePinner, Object obj, Object obj2, int i10) {
        this.f9703o = i10;
        this.f9704p = certificatePinner;
        this.f9705q = obj;
        this.f9706r = obj2;
    }

    @Override // ya.a
    public final Object invoke() {
        List check$lambda$0;
        List connectTls$lambda$0;
        switch (this.f9703o) {
            case 0:
                check$lambda$0 = CertificatePinner.check$lambda$0(this.f9704p, (List) this.f9705q, (String) this.f9706r);
                return check$lambda$0;
            default:
                connectTls$lambda$0 = ConnectPlan.connectTls$lambda$0(this.f9704p, (Handshake) this.f9705q, (Address) this.f9706r);
                return connectTls$lambda$0;
        }
    }
}
