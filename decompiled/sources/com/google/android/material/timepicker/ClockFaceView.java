package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m0.k0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import x.m;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
class ClockFaceView extends h implements f {
    public final ClockHandView J;
    public final Rect K;
    public final RectF L;
    public final Rect M;
    public final SparseArray N;
    public final c O;
    public final int[] P;
    public final float[] Q;
    public final int R;
    public final int S;
    public final int T;
    public final int U;
    public final String[] V;
    public float W;

    /* renamed from: a0, reason: collision with root package name */
    public final ColorStateList f3882a0;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = new Rect();
        this.L = new RectF();
        this.M = new Rect();
        SparseArray sparseArray = new SparseArray();
        this.N = sparseArray;
        this.Q = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j8.a.f7184d, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList l10 = com.bumptech.glide.d.l(context, obtainStyledAttributes, 1);
        this.f3882a0 = l10;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.J = clockHandView;
        this.R = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = l10.getColorForState(new int[]{android.R.attr.state_selected}, l10.getDefaultColor());
        this.P = new int[]{colorForState, colorForState, l10.getDefaultColor()};
        clockHandView.f3885q.add(this);
        int defaultColor = n4.a.n(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList l11 = com.bumptech.glide.d.l(context, obtainStyledAttributes, 0);
        setBackgroundColor(l11 != null ? l11.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(false);
        obtainStyledAttributes.recycle();
        this.O = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, _UrlKt.FRAGMENT_ENCODE_SET);
        this.V = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < Math.max(this.V.length, size); i10++) {
            TextView textView = (TextView) sparseArray.get(i10);
            if (i10 >= this.V.length) {
                removeView(textView);
                sparseArray.remove(i10);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i10, textView);
                    addView(textView);
                }
                textView.setText(this.V[i10]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i10));
                int i11 = (i10 / 12) + 1;
                textView.setTag(R.id.material_clock_level, Integer.valueOf(i11));
                z10 = i11 > 1 ? true : z10;
                k0.m(textView, this.O);
                textView.setTextColor(this.f3882a0);
            }
        }
        ClockHandView clockHandView2 = this.J;
        if (clockHandView2.f3884p && !z10) {
            clockHandView2.A = 1;
        }
        clockHandView2.f3884p = z10;
        clockHandView2.invalidate();
        this.S = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_height);
        this.T = resources.getDimensionPixelSize(R.dimen.material_time_picker_minimum_screen_width);
        this.U = resources.getDimensionPixelSize(R.dimen.material_clock_size);
    }

    @Override // com.google.android.material.timepicker.h
    public final void m() {
        m mVar = new m();
        mVar.c(this);
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getId() != R.id.circle_center && !"skip".equals(childAt.getTag())) {
                int i11 = (Integer) childAt.getTag(R.id.material_clock_level);
                if (i11 == null) {
                    i11 = 1;
                }
                if (!hashMap.containsKey(i11)) {
                    hashMap.put(i11, new ArrayList());
                }
                ((List) hashMap.get(i11)).add(childAt);
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            List list = (List) entry.getValue();
            int round = ((Integer) entry.getKey()).intValue() == 2 ? Math.round(this.H * 0.66f) : this.H;
            Iterator it = list.iterator();
            float f10 = 0.0f;
            while (it.hasNext()) {
                x.i iVar = mVar.g(((View) it.next()).getId()).f13243d;
                iVar.f13283y = R.id.circle_center;
                iVar.f13284z = round;
                iVar.A = f10;
                f10 += 360.0f / list.size();
            }
        }
        mVar.a(this);
        int i12 = 0;
        while (true) {
            SparseArray sparseArray = this.N;
            if (i12 >= sparseArray.size()) {
                return;
            }
            ((TextView) sparseArray.get(i12)).setVisibility(0);
            i12++;
        }
    }

    public final void n() {
        SparseArray sparseArray;
        Rect rect;
        RectF rectF;
        RectF rectF2 = this.J.f3889u;
        float f10 = Float.MAX_VALUE;
        TextView textView = null;
        int i10 = 0;
        while (true) {
            sparseArray = this.N;
            int size = sparseArray.size();
            rect = this.K;
            rectF = this.L;
            if (i10 >= size) {
                break;
            }
            TextView textView2 = (TextView) sparseArray.get(i10);
            if (textView2 != null) {
                textView2.getHitRect(rect);
                rectF.set(rect);
                rectF.union(rectF2);
                float height = rectF.height() * rectF.width();
                if (height < f10) {
                    textView = textView2;
                    f10 = height;
                }
            }
            i10++;
        }
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            TextView textView3 = (TextView) sparseArray.get(i11);
            if (textView3 != null) {
                textView3.setSelected(textView3 == textView);
                textView3.getHitRect(rect);
                rectF.set(rect);
                textView3.getLineBounds(0, this.M);
                rectF.inset(r8.left, r8.top);
                textView3.getPaint().setShader(!RectF.intersects(rectF2, rectF) ? null : new RadialGradient(rectF2.centerX() - rectF.left, rectF2.centerY() - rectF.top, 0.5f * rectF2.width(), this.P, this.Q, Shader.TileMode.CLAMP));
                textView3.invalidate();
            }
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, this.V.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        n();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i10, int i11) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.U / Math.max(Math.max(this.S / displayMetrics.heightPixels, this.T / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }
}
