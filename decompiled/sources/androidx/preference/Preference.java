package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import d0.b;
import org.chromium.net.R;
import y3.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: o, reason: collision with root package name */
    public final int f1439o;

    /* renamed from: p, reason: collision with root package name */
    public final CharSequence f1440p;

    /* renamed from: q, reason: collision with root package name */
    public final CharSequence f1441q;

    /* renamed from: r, reason: collision with root package name */
    public final String f1442r;

    /* renamed from: s, reason: collision with root package name */
    public final Object f1443s;

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this.f1439o = Integer.MAX_VALUE;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f13811e, i10, 0);
        obtainStyledAttributes.getResourceId(22, obtainStyledAttributes.getResourceId(0, 0));
        String string = obtainStyledAttributes.getString(25);
        this.f1442r = string == null ? obtainStyledAttributes.getString(6) : string;
        CharSequence text = obtainStyledAttributes.getText(33);
        this.f1440p = text == null ? obtainStyledAttributes.getText(4) : text;
        CharSequence text2 = obtainStyledAttributes.getText(32);
        this.f1441q = text2 == null ? obtainStyledAttributes.getText(7) : text2;
        this.f1439o = obtainStyledAttributes.getInt(27, obtainStyledAttributes.getInt(8, Integer.MAX_VALUE));
        if (obtainStyledAttributes.getString(21) == null) {
            obtainStyledAttributes.getString(13);
        }
        obtainStyledAttributes.getResourceId(26, obtainStyledAttributes.getResourceId(3, R.layout.preference));
        obtainStyledAttributes.getResourceId(34, obtainStyledAttributes.getResourceId(9, 0));
        obtainStyledAttributes.getBoolean(20, obtainStyledAttributes.getBoolean(2, true));
        boolean z10 = obtainStyledAttributes.getBoolean(29, obtainStyledAttributes.getBoolean(5, true));
        obtainStyledAttributes.getBoolean(28, obtainStyledAttributes.getBoolean(1, true));
        if (obtainStyledAttributes.getString(19) == null) {
            obtainStyledAttributes.getString(10);
        }
        obtainStyledAttributes.getBoolean(16, obtainStyledAttributes.getBoolean(16, z10));
        obtainStyledAttributes.getBoolean(17, obtainStyledAttributes.getBoolean(17, z10));
        if (obtainStyledAttributes.hasValue(18)) {
            this.f1443s = b(obtainStyledAttributes, 18);
        } else if (obtainStyledAttributes.hasValue(11)) {
            this.f1443s = b(obtainStyledAttributes, 11);
        }
        obtainStyledAttributes.getBoolean(30, obtainStyledAttributes.getBoolean(12, true));
        if (obtainStyledAttributes.hasValue(31)) {
            obtainStyledAttributes.getBoolean(31, obtainStyledAttributes.getBoolean(14, true));
        }
        obtainStyledAttributes.getBoolean(23, obtainStyledAttributes.getBoolean(15, false));
        obtainStyledAttributes.getBoolean(24, obtainStyledAttributes.getBoolean(24, true));
        obtainStyledAttributes.recycle();
    }

    public CharSequence a() {
        return this.f1441q;
    }

    public Object b(TypedArray typedArray, int i10) {
        return null;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Preference preference) {
        Preference preference2 = preference;
        int i10 = preference2.f1439o;
        CharSequence charSequence = preference2.f1440p;
        int i11 = this.f1439o;
        if (i11 != i10) {
            return i11 - i10;
        }
        CharSequence charSequence2 = this.f1440p;
        if (charSequence2 == charSequence) {
            return 0;
        }
        if (charSequence2 == null) {
            return 1;
        }
        if (charSequence == null) {
            return -1;
        }
        return charSequence2.toString().compareToIgnoreCase(charSequence.toString());
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence charSequence = this.f1440p;
        if (!TextUtils.isEmpty(charSequence)) {
            sb2.append(charSequence);
            sb2.append(' ');
        }
        CharSequence a10 = a();
        if (!TextUtils.isEmpty(a10)) {
            sb2.append(a10);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2.toString();
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b(context, R.attr.preferenceStyle, android.R.attr.preferenceStyle));
    }
}
