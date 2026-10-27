package g9;

import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f5365a;

    public o(p pVar) {
        this.f5365a = pVar;
    }

    public final void a(TextInputLayout textInputLayout) {
        p pVar = this.f5365a;
        n nVar = pVar.J;
        if (pVar.G == textInputLayout.getEditText()) {
            return;
        }
        EditText editText = pVar.G;
        if (editText != null) {
            editText.removeTextChangedListener(nVar);
            if (pVar.G.getOnFocusChangeListener() == pVar.b().e()) {
                pVar.G.setOnFocusChangeListener(null);
            }
        }
        EditText editText2 = textInputLayout.getEditText();
        pVar.G = editText2;
        if (editText2 != null) {
            editText2.addTextChangedListener(nVar);
        }
        pVar.b().l(pVar.G);
        pVar.j(pVar.b());
    }
}
