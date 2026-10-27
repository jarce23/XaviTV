package ub;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import pl.droidsonroids.gif.GifImageView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f12574a;

    /* renamed from: b, reason: collision with root package name */
    public final int f12575b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12576c;

    /* renamed from: d, reason: collision with root package name */
    public final int f12577d;

    public d(GifImageView gifImageView, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = gifImageView.getContext().obtainStyledAttributes(attributeSet, f.f12579a, 0, 0);
        this.f12574a = obtainStyledAttributes.getBoolean(0, false);
        this.f12575b = obtainStyledAttributes.getInt(1, -1);
        obtainStyledAttributes.recycle();
        this.f12576c = a(gifImageView, attributeSet, true);
        this.f12577d = a(gifImageView, attributeSet, false);
    }

    public static int a(GifImageView gifImageView, AttributeSet attributeSet, boolean z10) {
        int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", z10 ? "src" : "background", 0);
        if (attributeResourceValue > 0) {
            if (e.f12578a.contains(gifImageView.getResources().getResourceTypeName(attributeResourceValue)) && !e.a(gifImageView, z10, attributeResourceValue)) {
                return attributeResourceValue;
            }
        }
        return 0;
    }

    public d() {
        this.f12574a = false;
        this.f12575b = -1;
        this.f12576c = 0;
        this.f12577d = 0;
    }
}
