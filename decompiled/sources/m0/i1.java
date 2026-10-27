package m0;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i1 extends g1 {
    public i1(q1 q1Var, WindowInsets windowInsets) {
        super(q1Var, windowInsets);
    }

    @Override // m0.n1
    public q1 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f8657c.consumeDisplayCutout();
        return q1.g(null, consumeDisplayCutout);
    }

    @Override // m0.n1
    public h e() {
        DisplayCutout displayCutout;
        displayCutout = this.f8657c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new h(displayCutout);
    }

    @Override // m0.f1, m0.n1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i1)) {
            return false;
        }
        i1 i1Var = (i1) obj;
        return Objects.equals(this.f8657c, i1Var.f8657c) && Objects.equals(this.g, i1Var.g) && f1.y(this.f8661h, i1Var.f8661h);
    }

    @Override // m0.n1
    public int hashCode() {
        return this.f8657c.hashCode();
    }
}
