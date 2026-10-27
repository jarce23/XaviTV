package v0;

import android.text.InputFilter;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements InputFilter {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f12638a;

    /* renamed from: b, reason: collision with root package name */
    public c f12639b;

    public d(TextView textView) {
        this.f12638a = textView;
    }

    @Override // android.text.InputFilter
    public final CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
        TextView textView = this.f12638a;
        if (textView.isInEditMode()) {
            return charSequence;
        }
        int b2 = l.a().b();
        if (b2 != 0) {
            if (b2 == 1) {
                if ((i13 == 0 && i12 == 0 && spanned.length() == 0 && charSequence == textView.getText()) || charSequence == null) {
                    return charSequence;
                }
                if (i10 != 0 || i11 != charSequence.length()) {
                    charSequence = charSequence.subSequence(i10, i11);
                }
                return l.a().e(charSequence, 0, charSequence.length());
            }
            if (b2 != 3) {
                return charSequence;
            }
        }
        l a10 = l.a();
        if (this.f12639b == null) {
            this.f12639b = new c(textView, this);
        }
        a10.f(this.f12639b);
        return charSequence;
    }
}
