package u4;

import android.os.Build;
import o4.p;
import x4.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends d {

    /* renamed from: c, reason: collision with root package name */
    public static final String f12520c;

    /* renamed from: b, reason: collision with root package name */
    public final int f12521b;

    static {
        String f10 = p.f("NetworkMeteredCtrlr");
        h.d("tagWithPrefix(\"NetworkMeteredCtrlr\")", f10);
        f12520c = f10;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(v4.f fVar) {
        super(fVar);
        h.e("tracker", fVar);
        this.f12521b = 7;
    }

    @Override // u4.d
    public final int a() {
        return this.f12521b;
    }

    @Override // u4.d
    public final boolean b(o oVar) {
        return oVar.f13577j.f9487a == 5;
    }

    @Override // u4.d
    public final boolean c(Object obj) {
        t4.d dVar = (t4.d) obj;
        h.e("value", dVar);
        boolean z10 = dVar.f11876a;
        if (Build.VERSION.SDK_INT >= 26) {
            return (z10 && dVar.f11878c) ? false : true;
        }
        p.d().a(f12520c, "Metered network constraint is not supported before API 26, only checking for connected state.");
        return !z10;
    }
}
