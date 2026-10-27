package v0;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.widget.TextView;
import androidx.emoji2.text.l;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends androidx.emoji2.text.i {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f12636a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f12637b;

    public c(TextView textView, d dVar) {
        this.f12636a = new WeakReference(textView);
        this.f12637b = new WeakReference(dVar);
    }

    @Override // androidx.emoji2.text.i
    public final void b() {
        InputFilter[] filters;
        int length;
        TextView textView = (TextView) this.f12636a.get();
        InputFilter inputFilter = (InputFilter) this.f12637b.get();
        if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
            return;
        }
        for (InputFilter inputFilter2 : filters) {
            if (inputFilter2 == inputFilter) {
                if (textView.isAttachedToWindow()) {
                    CharSequence text = textView.getText();
                    l a10 = l.a();
                    if (text == null) {
                        length = 0;
                    } else {
                        a10.getClass();
                        length = text.length();
                    }
                    CharSequence e7 = a10.e(text, 0, length);
                    if (text == e7) {
                        return;
                    }
                    int selectionStart = Selection.getSelectionStart(e7);
                    int selectionEnd = Selection.getSelectionEnd(e7);
                    textView.setText(e7);
                    if (e7 instanceof Spannable) {
                        Spannable spannable = (Spannable) e7;
                        if (selectionStart >= 0 && selectionEnd >= 0) {
                            Selection.setSelection(spannable, selectionStart, selectionEnd);
                            return;
                        } else if (selectionStart >= 0) {
                            Selection.setSelection(spannable, selectionStart);
                            return;
                        } else {
                            if (selectionEnd >= 0) {
                                Selection.setSelection(spannable, selectionEnd);
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                return;
            }
        }
    }
}
