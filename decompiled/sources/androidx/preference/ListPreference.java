package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import d0.b;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import y3.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: t, reason: collision with root package name */
    public final CharSequence[] f1437t;

    /* renamed from: u, reason: collision with root package name */
    public final String f1438u;

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f13809c, i10, 0);
        CharSequence[] textArray = obtainStyledAttributes.getTextArray(2);
        this.f1437t = textArray == null ? obtainStyledAttributes.getTextArray(0) : textArray;
        if (obtainStyledAttributes.getTextArray(3) == null) {
            obtainStyledAttributes.getTextArray(1);
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, a.f13811e, i10, 0);
        String string = obtainStyledAttributes2.getString(32);
        this.f1438u = string == null ? obtainStyledAttributes2.getString(7) : string;
        obtainStyledAttributes2.recycle();
    }

    @Override // androidx.preference.Preference
    public final CharSequence a() {
        String str = this.f1438u;
        return str == null ? this.f1441q : String.format(str, _UrlKt.FRAGMENT_ENCODE_SET);
    }

    @Override // androidx.preference.Preference
    public final Object b(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b(context, R.attr.dialogPreferenceStyle, android.R.attr.dialogPreferenceStyle));
    }
}
