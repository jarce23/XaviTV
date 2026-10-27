package a7;

import android.content.Context;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements v6.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f117o;

    /* renamed from: p, reason: collision with root package name */
    public final ka.a f118p;

    public /* synthetic */ e(ka.a aVar, int i10) {
        this.f117o = i10;
        this.f118p = aVar;
    }

    @Override // ka.a
    public final Object get() {
        switch (this.f117o) {
            case 0:
                String packageName = ((Context) this.f118p.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
            default:
                return new n(Integer.valueOf(n.f141r).intValue(), (Context) this.f118p.get(), "com.google.android.datatransport.events");
        }
    }
}
