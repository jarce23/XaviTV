package k0;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f7589a;

    /* renamed from: b, reason: collision with root package name */
    public final TextDirectionHeuristic f7590b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7591c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7592d;

    public d(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
        PrecomputedText.Params.Builder breakStrategy;
        PrecomputedText.Params.Builder hyphenationFrequency;
        PrecomputedText.Params.Builder textDirection;
        if (Build.VERSION.SDK_INT >= 29) {
            breakStrategy = a6.c.p(textPaint).setBreakStrategy(i10);
            hyphenationFrequency = breakStrategy.setHyphenationFrequency(i11);
            textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
            textDirection.build();
        }
        this.f7589a = textPaint;
        this.f7590b = textDirectionHeuristic;
        this.f7591c = i10;
        this.f7592d = i11;
    }

    public final boolean equals(Object obj) {
        LocaleList textLocales;
        LocaleList textLocales2;
        boolean equals;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        int i10 = Build.VERSION.SDK_INT;
        if (this.f7591c != dVar.f7591c || this.f7592d != dVar.f7592d) {
            return false;
        }
        TextPaint textPaint = this.f7589a;
        float textSize = textPaint.getTextSize();
        TextPaint textPaint2 = dVar.f7589a;
        if (textSize != textPaint2.getTextSize() || textPaint.getTextScaleX() != textPaint2.getTextScaleX() || textPaint.getTextSkewX() != textPaint2.getTextSkewX() || textPaint.getLetterSpacing() != textPaint2.getLetterSpacing() || !TextUtils.equals(textPaint.getFontFeatureSettings(), textPaint2.getFontFeatureSettings()) || textPaint.getFlags() != textPaint2.getFlags()) {
            return false;
        }
        if (i10 >= 24) {
            textLocales = textPaint.getTextLocales();
            textLocales2 = textPaint2.getTextLocales();
            equals = textLocales.equals(textLocales2);
            if (!equals) {
                return false;
            }
        } else if (!textPaint.getTextLocale().equals(textPaint2.getTextLocale())) {
            return false;
        }
        if (textPaint.getTypeface() == null) {
            if (textPaint2.getTypeface() != null) {
                return false;
            }
        } else if (!textPaint.getTypeface().equals(textPaint2.getTypeface())) {
            return false;
        }
        return this.f7590b == dVar.f7590b;
    }

    public final int hashCode() {
        LocaleList textLocales;
        int i10 = Build.VERSION.SDK_INT;
        TextDirectionHeuristic textDirectionHeuristic = this.f7590b;
        int i11 = this.f7592d;
        int i12 = this.f7591c;
        TextPaint textPaint = this.f7589a;
        if (i10 < 24) {
            return Objects.hash(Float.valueOf(textPaint.getTextSize()), Float.valueOf(textPaint.getTextScaleX()), Float.valueOf(textPaint.getTextSkewX()), Float.valueOf(textPaint.getLetterSpacing()), Integer.valueOf(textPaint.getFlags()), textPaint.getTextLocale(), textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11));
        }
        Float valueOf = Float.valueOf(textPaint.getTextSize());
        Float valueOf2 = Float.valueOf(textPaint.getTextScaleX());
        Float valueOf3 = Float.valueOf(textPaint.getTextSkewX());
        Float valueOf4 = Float.valueOf(textPaint.getLetterSpacing());
        Integer valueOf5 = Integer.valueOf(textPaint.getFlags());
        textLocales = textPaint.getTextLocales();
        return Objects.hash(valueOf, valueOf2, valueOf3, valueOf4, valueOf5, textLocales, textPaint.getTypeface(), Boolean.valueOf(textPaint.isElegantTextHeight()), textDirectionHeuristic, Integer.valueOf(i12), Integer.valueOf(i11));
    }

    public final String toString() {
        String fontVariationSettings;
        LocaleList textLocales;
        StringBuilder sb2 = new StringBuilder("{");
        StringBuilder sb3 = new StringBuilder("textSize=");
        TextPaint textPaint = this.f7589a;
        sb3.append(textPaint.getTextSize());
        sb2.append(sb3.toString());
        sb2.append(", textScaleX=" + textPaint.getTextScaleX());
        sb2.append(", textSkewX=" + textPaint.getTextSkewX());
        int i10 = Build.VERSION.SDK_INT;
        sb2.append(", letterSpacing=" + textPaint.getLetterSpacing());
        sb2.append(", elegantTextHeight=" + textPaint.isElegantTextHeight());
        if (i10 >= 24) {
            StringBuilder sb4 = new StringBuilder(", textLocale=");
            textLocales = textPaint.getTextLocales();
            sb4.append(textLocales);
            sb2.append(sb4.toString());
        } else {
            sb2.append(", textLocale=" + textPaint.getTextLocale());
        }
        sb2.append(", typeface=" + textPaint.getTypeface());
        if (i10 >= 26) {
            StringBuilder sb5 = new StringBuilder(", variationSettings=");
            fontVariationSettings = textPaint.getFontVariationSettings();
            sb5.append(fontVariationSettings);
            sb2.append(sb5.toString());
        }
        sb2.append(", textDir=" + this.f7590b);
        sb2.append(", breakStrategy=" + this.f7591c);
        sb2.append(", hyphenationFrequency=" + this.f7592d);
        sb2.append("}");
        return sb2.toString();
    }

    public d(PrecomputedText.Params params) {
        TextPaint textPaint;
        TextDirectionHeuristic textDirection;
        int breakStrategy;
        int hyphenationFrequency;
        textPaint = params.getTextPaint();
        this.f7589a = textPaint;
        textDirection = params.getTextDirection();
        this.f7590b = textDirection;
        breakStrategy = params.getBreakStrategy();
        this.f7591c = breakStrategy;
        hyphenationFrequency = params.getHyphenationFrequency();
        this.f7592d = hyphenationFrequency;
    }
}
