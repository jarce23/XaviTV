package g9;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import com.google.android.material.textfield.TextInputLayout;
import m.w0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends m0.b {

    /* renamed from: d, reason: collision with root package name */
    public final TextInputLayout f5327d;

    public a0(TextInputLayout textInputLayout) {
        this.f5327d = textInputLayout;
    }

    @Override // m0.b
    public final void d(View view, n0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        this.f8638a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        TextInputLayout textInputLayout = this.f5327d;
        EditText editText = textInputLayout.getEditText();
        CharSequence text = editText != null ? editText.getText() : null;
        CharSequence hint = textInputLayout.getHint();
        CharSequence error = textInputLayout.getError();
        CharSequence placeholderText = textInputLayout.getPlaceholderText();
        int counterMaxLength = textInputLayout.getCounterMaxLength();
        CharSequence counterOverflowDescription = textInputLayout.getCounterOverflowDescription();
        boolean isEmpty = TextUtils.isEmpty(text);
        boolean isEmpty2 = TextUtils.isEmpty(hint);
        boolean z10 = textInputLayout.J0;
        boolean isEmpty3 = TextUtils.isEmpty(error);
        boolean z11 = (isEmpty3 && TextUtils.isEmpty(counterOverflowDescription)) ? false : true;
        String charSequence = !isEmpty2 ? hint.toString() : _UrlKt.FRAGMENT_ENCODE_SET;
        y yVar = textInputLayout.f3858p;
        w0 w0Var = yVar.f5430p;
        if (w0Var.getVisibility() == 0) {
            accessibilityNodeInfo.setLabelFor(w0Var);
            accessibilityNodeInfo.setTraversalAfter(w0Var);
        } else {
            accessibilityNodeInfo.setTraversalAfter(yVar.f5432r);
        }
        if (!isEmpty) {
            gVar.m(text);
        } else if (!TextUtils.isEmpty(charSequence)) {
            gVar.m(charSequence);
            if (!z10 && placeholderText != null) {
                gVar.m(charSequence + ", " + ((Object) placeholderText));
            }
        } else if (placeholderText != null) {
            gVar.m(placeholderText);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 26) {
                if (!isEmpty) {
                    charSequence = ((Object) text) + ", " + charSequence;
                }
                gVar.m(charSequence);
            } else if (i10 >= 26) {
                accessibilityNodeInfo.setHintText(charSequence);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
            }
            if (i10 >= 26) {
                accessibilityNodeInfo.setShowingHintText(isEmpty);
            } else {
                gVar.h(4, isEmpty);
            }
        }
        if (text == null || text.length() != counterMaxLength) {
            counterMaxLength = -1;
        }
        accessibilityNodeInfo.setMaxTextLength(counterMaxLength);
        if (z11) {
            if (isEmpty3) {
                error = counterOverflowDescription;
            }
            accessibilityNodeInfo.setError(error);
        }
        w0 w0Var2 = textInputLayout.f3876y.f5412y;
        if (w0Var2 != null) {
            accessibilityNodeInfo.setLabelFor(w0Var2);
        }
        textInputLayout.f3860q.b().m(gVar);
    }

    @Override // m0.b
    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f5327d.f3860q.b().n(accessibilityEvent);
    }
}
