package g9;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends d9.h {

    /* renamed from: r, reason: collision with root package name */
    public final RectF f5343r;

    public f(d9.n nVar, RectF rectF) {
        super(nVar);
        this.f5343r = rectF;
    }

    @Override // d9.h, android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        g gVar = new g(this);
        gVar.U = this;
        gVar.invalidateSelf();
        return gVar;
    }

    public f(f fVar) {
        super(fVar);
        this.f5343r = fVar.f5343r;
    }
}
