package j9;

import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends g {

    /* renamed from: e, reason: collision with root package name */
    public final int f7312e;

    /* renamed from: f, reason: collision with root package name */
    public final String f7313f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ k f7314h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, i8.d dVar, int i10, String str, int i11) {
        super(kVar, dVar);
        this.f7314h = kVar;
        this.f7312e = i10;
        this.f7313f = str;
        this.g = i11;
    }

    @Override // j9.g, k9.k
    public final void J(Bundle bundle) {
        k kVar = this.f7314h;
        kVar.f7323d.d(this.f7280c);
        k.g.f("onError(%d), retrying notifyModuleCompleted...", Integer.valueOf(bundle.getInt("error_code")));
        int i10 = this.g;
        if (i10 > 0) {
            kVar.h(this.f7313f, this.f7312e, i10 - 1);
        }
    }
}
