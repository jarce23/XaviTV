package g9;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements TextWatcher {

    /* renamed from: o, reason: collision with root package name */
    public int f5439o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ EditText f5440p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ TextInputLayout f5441q;

    public z(TextInputLayout textInputLayout, EditText editText) {
        this.f5441q = textInputLayout;
        this.f5440p = editText;
        this.f5439o = editText.getLineCount();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextInputLayout textInputLayout = this.f5441q;
        textInputLayout.w(!textInputLayout.P0, false);
        if (textInputLayout.f3878z) {
            textInputLayout.p(editable);
        }
        if (textInputLayout.H) {
            textInputLayout.x(editable);
        }
        EditText editText = this.f5440p;
        int lineCount = editText.getLineCount();
        int i10 = this.f5439o;
        if (lineCount != i10) {
            if (lineCount < i10) {
                int minimumHeight = editText.getMinimumHeight();
                int i11 = textInputLayout.I0;
                if (minimumHeight != i11) {
                    editText.setMinimumHeight(i11);
                }
            }
            this.f5439o = lineCount;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
