package v0;

import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends n4.a {

    /* renamed from: t, reason: collision with root package name */
    public final TextView f12642t;

    /* renamed from: u, reason: collision with root package name */
    public final d f12643u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f12644v;

    public f(TextView textView) {
        super(13);
        this.f12642t = textView;
        this.f12644v = true;
        this.f12643u = new d(textView);
    }

    @Override // n4.a
    public final void A(boolean z10) {
        if (z10) {
            TextView textView = this.f12642t;
            textView.setTransformationMethod(D(textView.getTransformationMethod()));
        }
    }

    @Override // n4.a
    public final void B(boolean z10) {
        this.f12644v = z10;
        TextView textView = this.f12642t;
        textView.setTransformationMethod(D(textView.getTransformationMethod()));
        textView.setFilters(p(textView.getFilters()));
    }

    @Override // n4.a
    public final TransformationMethod D(TransformationMethod transformationMethod) {
        return this.f12644v ? transformationMethod instanceof i ? transformationMethod : transformationMethod instanceof PasswordTransformationMethod ? transformationMethod : new i(transformationMethod) : transformationMethod instanceof i ? ((i) transformationMethod).f12649o : transformationMethod;
    }

    @Override // n4.a
    public final InputFilter[] p(InputFilter[] inputFilterArr) {
        if (!this.f12644v) {
            SparseArray sparseArray = new SparseArray(1);
            for (int i10 = 0; i10 < inputFilterArr.length; i10++) {
                InputFilter inputFilter = inputFilterArr[i10];
                if (inputFilter instanceof d) {
                    sparseArray.put(i10, inputFilter);
                }
            }
            if (sparseArray.size() == 0) {
                return inputFilterArr;
            }
            int length = inputFilterArr.length;
            InputFilter[] inputFilterArr2 = new InputFilter[inputFilterArr.length - sparseArray.size()];
            int i11 = 0;
            for (int i12 = 0; i12 < length; i12++) {
                if (sparseArray.indexOfKey(i12) < 0) {
                    inputFilterArr2[i11] = inputFilterArr[i12];
                    i11++;
                }
            }
            return inputFilterArr2;
        }
        int length2 = inputFilterArr.length;
        int i13 = 0;
        while (true) {
            d dVar = this.f12643u;
            if (i13 >= length2) {
                InputFilter[] inputFilterArr3 = new InputFilter[inputFilterArr.length + 1];
                System.arraycopy(inputFilterArr, 0, inputFilterArr3, 0, length2);
                inputFilterArr3[length2] = dVar;
                return inputFilterArr3;
            }
            if (inputFilterArr[i13] == dVar) {
                return inputFilterArr;
            }
            i13++;
        }
    }

    @Override // n4.a
    public final boolean t() {
        return this.f12644v;
    }
}
