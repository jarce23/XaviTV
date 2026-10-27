package t5;

import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t implements Appendable {

    /* renamed from: o, reason: collision with root package name */
    public final Appendable f11992o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f11993p = true;

    public t(Appendable appendable) {
        this.f11992o = appendable;
    }

    @Override // java.lang.Appendable
    public final Appendable append(char c10) {
        boolean z10 = this.f11993p;
        Appendable appendable = this.f11992o;
        if (z10) {
            this.f11993p = false;
            appendable.append("  ");
        }
        this.f11993p = c10 == '\n';
        appendable.append(c10);
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        append(charSequence, 0, charSequence.length());
        return this;
    }

    @Override // java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i10, int i11) {
        if (charSequence == null) {
            charSequence = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        boolean z10 = this.f11993p;
        Appendable appendable = this.f11992o;
        boolean z11 = false;
        if (z10) {
            this.f11993p = false;
            appendable.append("  ");
        }
        if (charSequence.length() > 0 && charSequence.charAt(i11 - 1) == '\n') {
            z11 = true;
        }
        this.f11993p = z11;
        appendable.append(charSequence, i10, i11);
        return this;
    }
}
