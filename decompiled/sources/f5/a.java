package f5;

import c2.y0;
import com.google.android.gms.cast.MediaInfo;
import i7.g;
import i7.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f5023a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ y0 f5024b;

    public a(y0 y0Var, h hVar) {
        this.f5024b = y0Var;
        this.f5023a = hVar;
    }

    @Override // i7.g
    public final void e() {
        h hVar = this.f5023a;
        try {
            MediaInfo c10 = hVar.c();
            y0 y0Var = this.f5024b;
            if (c10 != null) {
                y0Var.f2773p = hVar.c().f3150s;
            }
            y0Var.f2772o = hVar.a();
        } catch (Exception unused) {
        }
    }
}
