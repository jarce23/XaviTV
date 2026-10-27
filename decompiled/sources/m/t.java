package m;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8555a;

    /* renamed from: b, reason: collision with root package name */
    public final p4.p f8556b;

    public t(TextView textView) {
        this.f8555a = textView;
        this.f8556b = new p4.p(textView);
    }

    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return ((n4.a) this.f8556b.f9953p).p(inputFilterArr);
    }

    public final void b(AttributeSet attributeSet, int i10) {
        TypedArray obtainStyledAttributes = this.f8555a.getContext().obtainStyledAttributes(attributeSet, e.a.f4365i, i10, 0);
        try {
            boolean z10 = obtainStyledAttributes.hasValue(14) ? obtainStyledAttributes.getBoolean(14, true) : true;
            obtainStyledAttributes.recycle();
            d(z10);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void c(boolean z10) {
        ((n4.a) this.f8556b.f9953p).A(z10);
    }

    public final void d(boolean z10) {
        ((n4.a) this.f8556b.f9953p).B(z10);
    }
}
