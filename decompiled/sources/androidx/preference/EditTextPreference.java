package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d0.b;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {
    public EditTextPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, b.b(context, R.attr.editTextPreferenceStyle, android.R.attr.editTextPreferenceStyle));
    }

    @Override // androidx.preference.Preference
    public final Object b(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }
}
