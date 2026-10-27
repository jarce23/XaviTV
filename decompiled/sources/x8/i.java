package x8;

import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: c, reason: collision with root package name */
    public float f13739c;

    /* renamed from: e, reason: collision with root package name */
    public final WeakReference f13741e;

    /* renamed from: f, reason: collision with root package name */
    public a9.d f13742f;

    /* renamed from: a, reason: collision with root package name */
    public final TextPaint f13737a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    public final s8.b f13738b = new s8.b(1, this);

    /* renamed from: d, reason: collision with root package name */
    public boolean f13740d = true;

    public i(s8.e eVar) {
        this.f13741e = new WeakReference(null);
        this.f13741e = new WeakReference(eVar);
    }

    public final float a(String str) {
        if (!this.f13740d) {
            return this.f13739c;
        }
        TextPaint textPaint = this.f13737a;
        this.f13739c = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        if (str != null) {
            Math.abs(textPaint.getFontMetrics().ascent);
        }
        this.f13740d = false;
        return this.f13739c;
    }
}
