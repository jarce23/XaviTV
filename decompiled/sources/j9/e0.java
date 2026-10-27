package j9;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 implements k9.f {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7258o;

    /* renamed from: p, reason: collision with root package name */
    public final h5.i f7259p;

    public /* synthetic */ e0(h5.i iVar, int i10) {
        this.f7258o = i10;
        this.f7259p = iVar;
    }

    @Override // k9.f
    public final Object c() {
        switch (this.f7258o) {
            case 0:
                return new d0(((androidx.emoji2.text.o) this.f7259p.f5610p).f591o);
            case 1:
                return new h1(((androidx.emoji2.text.o) this.f7259p.f5610p).f591o);
            case 2:
                return new j1(((androidx.emoji2.text.o) this.f7259p.f5610p).f591o);
            case 3:
                Context context = ((androidx.emoji2.text.o) this.f7259p.f5610p).f591o;
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        return bundle.getString("local_testing_dir");
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                }
                return null;
            case 4:
                return p4.r.b(((androidx.emoji2.text.o) this.f7259p.f5610p).f591o);
            default:
                Context context2 = ((androidx.emoji2.text.o) this.f7259p.f5610p).f591o;
                k9.a aVar = new k9.a();
                context2.getPackageName();
                return aVar;
        }
    }
}
