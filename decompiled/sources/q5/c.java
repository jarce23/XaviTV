package q5;

import okhttp3.Call;
import r5.h;
import x5.j;
import x5.s;
import x5.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements t {

    /* renamed from: a, reason: collision with root package name */
    public final Call.Factory f10346a;

    public c(Call.Factory factory) {
        this.f10346a = factory;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, h hVar) {
        j jVar = (j) obj;
        return new s(jVar, new a(this.f10346a, jVar));
    }

    @Override // x5.t
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        return true;
    }
}
