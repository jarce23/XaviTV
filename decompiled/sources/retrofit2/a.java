package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11092o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f11093p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Callback f11094q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f11095r;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 anonymousClass1, Callback callback, Object obj, int i10) {
        this.f11092o = i10;
        this.f11093p = anonymousClass1;
        this.f11094q = callback;
        this.f11095r = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11092o) {
            case 0:
                this.f11093p.lambda$onResponse$0(this.f11094q, (Response) this.f11095r);
                break;
            default:
                this.f11093p.lambda$onFailure$1(this.f11094q, (Throwable) this.f11095r);
                break;
        }
    }
}
