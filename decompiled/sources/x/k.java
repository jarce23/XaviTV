package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public int f13294a;

    /* renamed from: b, reason: collision with root package name */
    public int f13295b;

    /* renamed from: c, reason: collision with root package name */
    public float f13296c;

    /* renamed from: d, reason: collision with root package name */
    public float f13297d;

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.g);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 1) {
                this.f13296c = obtainStyledAttributes.getFloat(index, this.f13296c);
            } else if (index == 0) {
                int i11 = obtainStyledAttributes.getInt(index, this.f13294a);
                this.f13294a = i11;
                this.f13294a = m.f13311d[i11];
            } else if (index == 4) {
                this.f13295b = obtainStyledAttributes.getInt(index, this.f13295b);
            } else if (index == 3) {
                this.f13297d = obtainStyledAttributes.getFloat(index, this.f13297d);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
