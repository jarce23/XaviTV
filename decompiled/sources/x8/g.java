package x8;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.fragment.app.v0;
import com.google.android.material.textfield.TextInputLayout;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public CharSequence f13725a;

    /* renamed from: b, reason: collision with root package name */
    public final TextPaint f13726b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13727c;

    /* renamed from: d, reason: collision with root package name */
    public int f13728d;

    /* renamed from: k, reason: collision with root package name */
    public boolean f13734k;

    /* renamed from: m, reason: collision with root package name */
    public v0 f13736m;

    /* renamed from: e, reason: collision with root package name */
    public Layout.Alignment f13729e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f, reason: collision with root package name */
    public int f13730f = Integer.MAX_VALUE;
    public float g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f13731h = 1.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f13732i = 1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13733j = true;

    /* renamed from: l, reason: collision with root package name */
    public TextUtils.TruncateAt f13735l = null;

    public g(CharSequence charSequence, TextPaint textPaint, int i10) {
        this.f13725a = charSequence;
        this.f13726b = textPaint;
        this.f13727c = i10;
        this.f13728d = charSequence.length();
    }

    public final StaticLayout a() {
        if (this.f13725a == null) {
            this.f13725a = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int max = Math.max(0, this.f13727c);
        CharSequence charSequence = this.f13725a;
        int i10 = this.f13730f;
        TextPaint textPaint = this.f13726b;
        if (i10 == 1) {
            charSequence = TextUtils.ellipsize(charSequence, textPaint, max, this.f13735l);
        }
        int min = Math.min(charSequence.length(), this.f13728d);
        this.f13728d = min;
        if (this.f13734k && this.f13730f == 1) {
            this.f13729e = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, textPaint, max);
        obtain.setAlignment(this.f13729e);
        obtain.setIncludePad(this.f13733j);
        obtain.setTextDirection(this.f13734k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
        TextUtils.TruncateAt truncateAt = this.f13735l;
        if (truncateAt != null) {
            obtain.setEllipsize(truncateAt);
        }
        obtain.setMaxLines(this.f13730f);
        float f10 = this.g;
        if (f10 != 0.0f || this.f13731h != 1.0f) {
            obtain.setLineSpacing(f10, this.f13731h);
        }
        if (this.f13730f > 1) {
            obtain.setHyphenationFrequency(this.f13732i);
        }
        v0 v0Var = this.f13736m;
        if (v0Var != null) {
            obtain.setBreakStrategy(((TextInputLayout) v0Var.f843p).I.getBreakStrategy());
        }
        return obtain.build();
    }
}
