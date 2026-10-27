package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.LinearLayout;
import androidx.leanback.widget.g0;
import f6.a;
import i1.a1;
import i1.u0;
import i1.v0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u3.i0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TrackSelectionView extends LinearLayout {

    /* renamed from: o, reason: collision with root package name */
    public final int f1226o;

    /* renamed from: p, reason: collision with root package name */
    public final LayoutInflater f1227p;

    /* renamed from: q, reason: collision with root package name */
    public final CheckedTextView f1228q;

    /* renamed from: r, reason: collision with root package name */
    public final CheckedTextView f1229r;

    /* renamed from: s, reason: collision with root package name */
    public final g0 f1230s;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f1231t;

    /* renamed from: u, reason: collision with root package name */
    public final HashMap f1232u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f1233v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f1234w;

    /* renamed from: x, reason: collision with root package name */
    public u3.g0 f1235x;

    /* renamed from: y, reason: collision with root package name */
    public CheckedTextView[][] f1236y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1237z;

    public TrackSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        setOrientation(1);
        setSaveFromParentEnabled(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.selectableItemBackground});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        this.f1226o = resourceId;
        obtainStyledAttributes.recycle();
        LayoutInflater from = LayoutInflater.from(context);
        this.f1227p = from;
        g0 g0Var = new g0(17, this);
        this.f1230s = g0Var;
        this.f1235x = new a(getResources(), 1);
        this.f1231t = new ArrayList();
        this.f1232u = new HashMap();
        CheckedTextView checkedTextView = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1228q = checkedTextView;
        checkedTextView.setBackgroundResource(resourceId);
        checkedTextView.setText(org.chromium.net.R.string.exo_track_selection_none);
        checkedTextView.setEnabled(false);
        checkedTextView.setFocusable(true);
        checkedTextView.setOnClickListener(g0Var);
        checkedTextView.setVisibility(8);
        addView(checkedTextView);
        addView(from.inflate(org.chromium.net.R.layout.exo_list_divider, (ViewGroup) this, false));
        CheckedTextView checkedTextView2 = (CheckedTextView) from.inflate(R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
        this.f1229r = checkedTextView2;
        checkedTextView2.setBackgroundResource(resourceId);
        checkedTextView2.setText(org.chromium.net.R.string.exo_track_selection_auto);
        checkedTextView2.setEnabled(false);
        checkedTextView2.setFocusable(true);
        checkedTextView2.setOnClickListener(g0Var);
        addView(checkedTextView2);
    }

    public static HashMap a(Map map, ArrayList arrayList, boolean z10) {
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            v0 v0Var = (v0) map.get(((a1) arrayList.get(i10)).f5799b);
            if (v0Var != null && (z10 || hashMap.isEmpty())) {
                hashMap.put(v0Var.f6051a, v0Var);
            }
        }
        return hashMap;
    }

    public final void b() {
        this.f1228q.setChecked(this.f1237z);
        boolean z10 = this.f1237z;
        HashMap hashMap = this.f1232u;
        this.f1229r.setChecked(!z10 && hashMap.isEmpty());
        for (int i10 = 0; i10 < this.f1236y.length; i10++) {
            v0 v0Var = (v0) hashMap.get(((a1) this.f1231t.get(i10)).f5799b);
            int i11 = 0;
            while (true) {
                CheckedTextView[] checkedTextViewArr = this.f1236y[i10];
                if (i11 < checkedTextViewArr.length) {
                    if (v0Var != null) {
                        Object tag = checkedTextViewArr[i11].getTag();
                        tag.getClass();
                        this.f1236y[i10][i11].setChecked(v0Var.f6052b.contains(Integer.valueOf(((i0) tag).f12411b)));
                    } else {
                        checkedTextViewArr[i11].setChecked(false);
                    }
                    i11++;
                }
            }
        }
    }

    public final void c() {
        for (int childCount = getChildCount() - 1; childCount >= 3; childCount--) {
            removeViewAt(childCount);
        }
        ArrayList arrayList = this.f1231t;
        boolean isEmpty = arrayList.isEmpty();
        CheckedTextView checkedTextView = this.f1229r;
        CheckedTextView checkedTextView2 = this.f1228q;
        if (isEmpty) {
            checkedTextView2.setEnabled(false);
            checkedTextView.setEnabled(false);
            return;
        }
        checkedTextView2.setEnabled(true);
        checkedTextView.setEnabled(true);
        this.f1236y = new CheckedTextView[arrayList.size()][];
        boolean z10 = this.f1234w && arrayList.size() > 1;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            a1 a1Var = (a1) arrayList.get(i10);
            boolean z11 = this.f1233v && a1Var.f5800c;
            CheckedTextView[][] checkedTextViewArr = this.f1236y;
            int i11 = a1Var.f5798a;
            checkedTextViewArr[i10] = new CheckedTextView[i11];
            i0[] i0VarArr = new i0[i11];
            for (int i12 = 0; i12 < a1Var.f5798a; i12++) {
                i0VarArr[i12] = new i0(a1Var, i12);
            }
            for (int i13 = 0; i13 < i11; i13++) {
                LayoutInflater layoutInflater = this.f1227p;
                if (i13 == 0) {
                    addView(layoutInflater.inflate(org.chromium.net.R.layout.exo_list_divider, (ViewGroup) this, false));
                }
                CheckedTextView checkedTextView3 = (CheckedTextView) layoutInflater.inflate((z11 || z10) ? R.layout.simple_list_item_multiple_choice : R.layout.simple_list_item_single_choice, (ViewGroup) this, false);
                checkedTextView3.setBackgroundResource(this.f1226o);
                u3.g0 g0Var = this.f1235x;
                i0 i0Var = i0VarArr[i13];
                checkedTextView3.setText(((a) g0Var).c(i0Var.f12410a.f5799b.f6042d[i0Var.f12411b]));
                checkedTextView3.setTag(i0VarArr[i13]);
                if (a1Var.a(i13)) {
                    checkedTextView3.setFocusable(true);
                    checkedTextView3.setOnClickListener(this.f1230s);
                } else {
                    checkedTextView3.setFocusable(false);
                    checkedTextView3.setEnabled(false);
                }
                this.f1236y[i10][i13] = checkedTextView3;
                addView(checkedTextView3);
            }
        }
        b();
    }

    public boolean getIsDisabled() {
        return this.f1237z;
    }

    public Map<u0, v0> getOverrides() {
        return this.f1232u;
    }

    public void setAllowAdaptiveSelections(boolean z10) {
        if (this.f1233v != z10) {
            this.f1233v = z10;
            c();
        }
    }

    public void setAllowMultipleOverrides(boolean z10) {
        if (this.f1234w != z10) {
            this.f1234w = z10;
            if (!z10) {
                HashMap hashMap = this.f1232u;
                if (hashMap.size() > 1) {
                    HashMap a10 = a(hashMap, this.f1231t, false);
                    hashMap.clear();
                    hashMap.putAll(a10);
                }
            }
            c();
        }
    }

    public void setShowDisableOption(boolean z10) {
        this.f1228q.setVisibility(z10 ? 0 : 8);
    }

    public void setTrackNameProvider(u3.g0 g0Var) {
        g0Var.getClass();
        this.f1235x = g0Var;
        c();
    }
}
