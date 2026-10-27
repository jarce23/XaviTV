package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.chromium.net.R;
import y3.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {

    /* renamed from: t, reason: collision with root package name */
    public final int f1444t;

    /* renamed from: u, reason: collision with root package name */
    public final int f1445u;

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.seekBarPreferenceStyle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f13813h, R.attr.seekBarPreferenceStyle, 0);
        int i10 = obtainStyledAttributes.getInt(3, 0);
        int i11 = obtainStyledAttributes.getInt(1, 100);
        i11 = i11 < i10 ? i10 : i11;
        if (i11 != this.f1444t) {
            this.f1444t = i11;
        }
        int i12 = obtainStyledAttributes.getInt(4, 0);
        if (i12 != this.f1445u) {
            this.f1445u = Math.min(this.f1444t - i10, Math.abs(i12));
        }
        obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.getBoolean(5, true);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    public final Object b(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }
}
