package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import com.bumptech.glide.d;
import com.google.android.material.button.MaterialButton;
import f.f0;
import g9.w;
import m.o;
import m.p;
import m.w0;
import m.z;
import org.chromium.net.R;
import r8.c;
import x8.k;
import z8.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends f0 {
    @Override // f.f0
    public final o a(Context context, AttributeSet attributeSet) {
        return new w(context, attributeSet);
    }

    @Override // f.f0
    public final AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // f.f0
    public final p c(Context context, AttributeSet attributeSet) {
        return new c(context, attributeSet);
    }

    @Override // f.f0
    public final z d(Context context, AttributeSet attributeSet) {
        a aVar = new a(i9.a.a(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = aVar.getContext();
        TypedArray e7 = k.e(context2, attributeSet, j8.a.f7196q, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (e7.hasValue(0)) {
            aVar.setButtonTintList(d.l(context2, e7, 0));
        }
        aVar.f14148t = e7.getBoolean(1, false);
        e7.recycle();
        return aVar;
    }

    @Override // f.f0
    public final w0 e(Context context, AttributeSet attributeSet) {
        h9.a aVar = new h9.a(i9.a.a(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = aVar.getContext();
        if (com.bumptech.glide.c.y(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = j8.a.f7200u;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int g = h9.a.g(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (g == -1) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, j8.a.f7199t);
                    int g6 = h9.a.g(aVar.getContext(), obtainStyledAttributes3, 2, 4);
                    obtainStyledAttributes3.recycle();
                    if (g6 >= 0) {
                        aVar.setLineHeight(g6);
                    }
                }
            }
        }
        return aVar;
    }
}
