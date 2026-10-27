package m0;

import android.graphics.Insets;
import android.view.WindowInsets;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j1 extends i1 {

    /* renamed from: o, reason: collision with root package name */
    public e0.c f8680o;

    /* renamed from: p, reason: collision with root package name */
    public e0.c f8681p;

    /* renamed from: q, reason: collision with root package name */
    public e0.c f8682q;

    public j1(q1 q1Var, WindowInsets windowInsets) {
        super(q1Var, windowInsets);
        this.f8680o = null;
        this.f8681p = null;
        this.f8682q = null;
    }

    @Override // m0.n1
    public e0.c g() {
        Insets mandatorySystemGestureInsets;
        if (this.f8681p == null) {
            mandatorySystemGestureInsets = this.f8657c.getMandatorySystemGestureInsets();
            this.f8681p = e0.c.c(mandatorySystemGestureInsets);
        }
        return this.f8681p;
    }

    @Override // m0.n1
    public e0.c i() {
        Insets systemGestureInsets;
        if (this.f8680o == null) {
            systemGestureInsets = this.f8657c.getSystemGestureInsets();
            this.f8680o = e0.c.c(systemGestureInsets);
        }
        return this.f8680o;
    }

    @Override // m0.n1
    public e0.c k() {
        Insets tappableElementInsets;
        if (this.f8682q == null) {
            tappableElementInsets = this.f8657c.getTappableElementInsets();
            this.f8682q = e0.c.c(tappableElementInsets);
        }
        return this.f8682q;
    }

    @Override // m0.f1, m0.n1
    public q1 l(int i10, int i11, int i12, int i13) {
        WindowInsets inset;
        inset = this.f8657c.inset(i10, i11, i12, i13);
        return q1.g(null, inset);
    }

    @Override // m0.g1, m0.n1
    public void q(e0.c cVar) {
    }
}
