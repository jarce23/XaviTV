package androidx.emoji2.text;

import android.text.TextPaint;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements h {

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f561b = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f562a;

    public d() {
        TextPaint textPaint = new TextPaint();
        this.f562a = textPaint;
        textPaint.setTextSize(10.0f);
    }
}
