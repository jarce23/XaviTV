package q1;

import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends UrlRequest.StatusListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int[] f10221a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l1.g f10222b;

    public b(int[] iArr, l1.g gVar) {
        this.f10221a = iArr;
        this.f10222b = gVar;
    }

    @Override // org.chromium.net.UrlRequest.StatusListener
    public final void onStatus(int i10) {
        this.f10221a[0] = i10;
        this.f10222b.f();
    }
}
