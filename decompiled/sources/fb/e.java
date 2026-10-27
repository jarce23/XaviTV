package fb;

import gb.q;
import java.util.Iterator;
import ya.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5062a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5063b;

    /* renamed from: c, reason: collision with root package name */
    public final la.a f5064c;

    public e(f fVar, l lVar) {
        za.h.e("sequence", fVar);
        this.f5063b = fVar;
        this.f5064c = lVar;
    }

    @Override // fb.f
    public final Iterator iterator() {
        switch (this.f5062a) {
            case 0:
                return new d(this);
            case 1:
                return new k(this);
            default:
                return new gb.b(this);
        }
    }

    public e(androidx.activity.e eVar, okhttp3.internal.a aVar) {
        this.f5063b = eVar;
        this.f5064c = aVar;
    }

    public e(CharSequence charSequence, q qVar) {
        za.h.e("input", charSequence);
        this.f5063b = charSequence;
        this.f5064c = qVar;
    }
}
