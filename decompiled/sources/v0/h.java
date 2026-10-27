package v0;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.l;
import m.m2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements TextWatcher {

    /* renamed from: o, reason: collision with root package name */
    public final EditText f12646o;

    /* renamed from: p, reason: collision with root package name */
    public m2 f12647p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f12648q = true;

    public h(EditText editText) {
        this.f12646o = editText;
    }

    public static void a(EditText editText, int i10) {
        int length;
        if (i10 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            l a10 = l.a();
            if (editableText == null) {
                length = 0;
            } else {
                a10.getClass();
                length = editableText.length();
            }
            a10.e(editableText, 0, length);
            if (selectionStart >= 0 && selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionStart, selectionEnd);
            } else if (selectionStart >= 0) {
                Selection.setSelection(editableText, selectionStart);
            } else if (selectionEnd >= 0) {
                Selection.setSelection(editableText, selectionEnd);
            }
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        EditText editText = this.f12646o;
        if (editText.isInEditMode() || !this.f12648q || l.f576k == null || i11 > i12 || !(charSequence instanceof Spannable)) {
            return;
        }
        int b2 = l.a().b();
        if (b2 != 0) {
            if (b2 == 1) {
                l.a().e((Spannable) charSequence, i10, i12 + i10);
                return;
            } else if (b2 != 3) {
                return;
            }
        }
        l a10 = l.a();
        if (this.f12647p == null) {
            this.f12647p = new m2(editText);
        }
        a10.f(this.f12647p);
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
