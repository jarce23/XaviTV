package v0;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends n4.a {

    /* renamed from: t, reason: collision with root package name */
    public final f f12645t;

    public g(TextView textView) {
        super(13);
        this.f12645t = new f(textView);
    }

    @Override // n4.a
    public final void A(boolean z10) {
        if (l.f576k != null) {
            this.f12645t.A(z10);
        }
    }

    @Override // n4.a
    public final void B(boolean z10) {
        f fVar = this.f12645t;
        if (l.f576k != null) {
            fVar.B(z10);
        } else {
            fVar.f12644v = z10;
        }
    }

    @Override // n4.a
    public final TransformationMethod D(TransformationMethod transformationMethod) {
        return !(l.f576k != null) ? transformationMethod : this.f12645t.D(transformationMethod);
    }

    @Override // n4.a
    public final InputFilter[] p(InputFilter[] inputFilterArr) {
        return !(l.f576k != null) ? inputFilterArr : this.f12645t.p(inputFilterArr);
    }

    @Override // n4.a
    public final boolean t() {
        return this.f12645t.f12644v;
    }
}
