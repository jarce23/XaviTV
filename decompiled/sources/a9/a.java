package a9;

import android.graphics.Typeface;
import x5.b0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends com.bumptech.glide.e {

    /* renamed from: c, reason: collision with root package name */
    public final Typeface f151c;

    /* renamed from: d, reason: collision with root package name */
    public final b0 f152d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f153e;

    public a(b0 b0Var, Typeface typeface) {
        this.f151c = typeface;
        this.f152d = b0Var;
    }

    @Override // com.bumptech.glide.e
    public final void r(int i10) {
        if (this.f153e) {
            return;
        }
        x8.b bVar = (x8.b) this.f152d.f13616o;
        if (bVar.l(this.f151c)) {
            bVar.j(false);
        }
    }

    @Override // com.bumptech.glide.e
    public final void s(Typeface typeface, boolean z10) {
        if (this.f153e) {
            return;
        }
        x8.b bVar = (x8.b) this.f152d.f13616o;
        if (bVar.l(typeface)) {
            bVar.j(false);
        }
    }
}
