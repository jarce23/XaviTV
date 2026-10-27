package c1;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.leanback.widget.VerticalGridView;
import app.shamel.tv.activities.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c extends FrameLayout {
    public final int A;
    public int B;
    public final e C;

    /* renamed from: o, reason: collision with root package name */
    public final ViewGroup f2501o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f2502p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f2503q;

    /* renamed from: r, reason: collision with root package name */
    public final float f2504r;

    /* renamed from: s, reason: collision with root package name */
    public final float f2505s;

    /* renamed from: t, reason: collision with root package name */
    public final float f2506t;

    /* renamed from: u, reason: collision with root package name */
    public final int f2507u;

    /* renamed from: v, reason: collision with root package name */
    public final DecelerateInterpolator f2508v;

    /* renamed from: w, reason: collision with root package name */
    public float f2509w;

    /* renamed from: x, reason: collision with root package name */
    public float f2510x;

    /* renamed from: y, reason: collision with root package name */
    public int f2511y;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f2512z;

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f2502p = new ArrayList();
        this.f2509w = 3.0f;
        this.f2510x = 1.0f;
        this.f2511y = 0;
        this.f2512z = new ArrayList();
        this.A = R.layout.lb_picker_item;
        this.B = 0;
        this.C = new e(28, this);
        setEnabled(true);
        setDescendantFocusability(262144);
        this.f2505s = 1.0f;
        this.f2504r = 1.0f;
        this.f2506t = 0.5f;
        this.f2507u = 200;
        this.f2508v = new DecelerateInterpolator(2.5f);
        new AccelerateInterpolator(2.5f);
        this.f2501o = (ViewGroup) ((ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.lb_picker, (ViewGroup) this, true)).findViewById(R.id.picker);
    }

    public final void a(int i10, d dVar) {
        this.f2503q.set(i10, dVar);
        VerticalGridView verticalGridView = (VerticalGridView) this.f2502p.get(i10);
        a aVar = (a) verticalGridView.getAdapter();
        if (aVar != null) {
            aVar.d();
        }
        verticalGridView.setSelectedPosition(dVar.f2513a - dVar.f2514b);
    }

    public final void b(View view, boolean z10, float f10, DecelerateInterpolator decelerateInterpolator) {
        view.animate().cancel();
        if (z10) {
            view.animate().alpha(f10).setDuration(this.f2507u).setInterpolator(decelerateInterpolator).start();
        } else {
            view.setAlpha(f10);
        }
    }

    public final void c(View view, boolean z10, int i10, boolean z11) {
        boolean z12 = i10 == this.f2511y || !hasFocus();
        DecelerateInterpolator decelerateInterpolator = this.f2508v;
        if (z10) {
            if (z12) {
                b(view, z11, this.f2505s, decelerateInterpolator);
                return;
            } else {
                b(view, z11, this.f2504r, decelerateInterpolator);
                return;
            }
        }
        if (z12) {
            b(view, z11, this.f2506t, decelerateInterpolator);
        } else {
            b(view, z11, 0.0f, decelerateInterpolator);
        }
    }

    public final void d(int i10) {
        VerticalGridView verticalGridView = (VerticalGridView) this.f2502p.get(i10);
        int selectedPosition = verticalGridView.getSelectedPosition();
        int i11 = 0;
        while (i11 < verticalGridView.getAdapter().a()) {
            View s10 = verticalGridView.getLayoutManager().s(i11);
            if (s10 != null) {
                c(s10, selectedPosition == i11, i10, true);
            }
            i11++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!isActivated()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 23 && keyCode != 66) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (keyEvent.getAction() == 1) {
            performClick();
        }
        return true;
    }

    public final void e() {
        for (int i10 = 0; i10 < getColumnsCount(); i10++) {
            f((VerticalGridView) this.f2502p.get(i10));
        }
    }

    public final void f(VerticalGridView verticalGridView) {
        ViewGroup.LayoutParams layoutParams = verticalGridView.getLayoutParams();
        float activatedVisibleItemCount = isActivated() ? getActivatedVisibleItemCount() : getVisibleItemCount();
        layoutParams.height = (int) (((activatedVisibleItemCount - 1.0f) * verticalGridView.getVerticalSpacing()) + (getPickerItemHeightPixels() * activatedVisibleItemCount));
        verticalGridView.setLayoutParams(layoutParams);
    }

    public float getActivatedVisibleItemCount() {
        return this.f2509w;
    }

    public int getColumnsCount() {
        ArrayList arrayList = this.f2503q;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public int getPickerItemHeightPixels() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.picker_item_height);
    }

    public final int getPickerItemLayoutId() {
        return this.A;
    }

    public final int getPickerItemTextViewId() {
        return this.B;
    }

    public int getSelectedColumn() {
        return this.f2511y;
    }

    public final CharSequence getSeparator() {
        return (CharSequence) this.f2512z.get(0);
    }

    public final List<CharSequence> getSeparators() {
        return this.f2512z;
    }

    public float getVisibleItemCount() {
        return 1.0f;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int selectedColumn = getSelectedColumn();
        ArrayList arrayList = this.f2502p;
        if (selectedColumn < arrayList.size()) {
            return ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus(i10, rect);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f2502p;
            if (i10 >= arrayList.size()) {
                return;
            }
            if (((VerticalGridView) arrayList.get(i10)).hasFocus()) {
                setSelectedColumn(i10);
            }
            i10++;
        }
    }

    @Override // android.view.View
    public void setActivated(boolean z10) {
        ArrayList arrayList;
        if (z10 == isActivated()) {
            super.setActivated(z10);
            return;
        }
        super.setActivated(z10);
        boolean hasFocus = hasFocus();
        int selectedColumn = getSelectedColumn();
        setDescendantFocusability(131072);
        if (!z10 && hasFocus && isFocusable()) {
            requestFocus();
        }
        int i10 = 0;
        while (true) {
            int columnsCount = getColumnsCount();
            arrayList = this.f2502p;
            if (i10 >= columnsCount) {
                break;
            }
            ((VerticalGridView) arrayList.get(i10)).setFocusable(z10);
            i10++;
        }
        e();
        boolean isActivated = isActivated();
        for (int i11 = 0; i11 < getColumnsCount(); i11++) {
            VerticalGridView verticalGridView = (VerticalGridView) arrayList.get(i11);
            for (int i12 = 0; i12 < verticalGridView.getChildCount(); i12++) {
                verticalGridView.getChildAt(i12).setFocusable(isActivated);
            }
        }
        if (z10 && hasFocus && selectedColumn >= 0) {
            ((VerticalGridView) arrayList.get(selectedColumn)).requestFocus();
        }
        setDescendantFocusability(262144);
    }

    public void setActivatedVisibleItemCount(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f2509w != f10) {
            this.f2509w = f10;
            if (isActivated()) {
                e();
            }
        }
    }

    public void setColumns(List<d> list) {
        ArrayList arrayList = this.f2512z;
        if (arrayList.size() == 0) {
            throw new IllegalStateException("Separators size is: " + arrayList.size() + ". At least one separator must be provided");
        }
        if (arrayList.size() == 1) {
            CharSequence charSequence = (CharSequence) arrayList.get(0);
            arrayList.clear();
            arrayList.add(_UrlKt.FRAGMENT_ENCODE_SET);
            for (int i10 = 0; i10 < list.size() - 1; i10++) {
                arrayList.add(charSequence);
            }
            arrayList.add(_UrlKt.FRAGMENT_ENCODE_SET);
        } else if (arrayList.size() != list.size() + 1) {
            throw new IllegalStateException("Separators size: " + arrayList.size() + " mustequal the size of columns: " + list.size() + " + 1");
        }
        ArrayList arrayList2 = this.f2502p;
        arrayList2.clear();
        ViewGroup viewGroup = this.f2501o;
        viewGroup.removeAllViews();
        ArrayList arrayList3 = new ArrayList(list);
        this.f2503q = arrayList3;
        if (this.f2511y > arrayList3.size() - 1) {
            this.f2511y = this.f2503q.size() - 1;
        }
        LayoutInflater from = LayoutInflater.from(getContext());
        int columnsCount = getColumnsCount();
        if (!TextUtils.isEmpty((CharSequence) arrayList.get(0))) {
            TextView textView = (TextView) from.inflate(R.layout.lb_picker_separator, viewGroup, false);
            textView.setText((CharSequence) arrayList.get(0));
            viewGroup.addView(textView);
        }
        int i11 = 0;
        while (i11 < columnsCount) {
            VerticalGridView verticalGridView = (VerticalGridView) from.inflate(R.layout.lb_picker_column, viewGroup, false);
            f(verticalGridView);
            verticalGridView.setWindowAlignment(0);
            verticalGridView.setHasFixedSize(false);
            verticalGridView.setFocusable(isActivated());
            verticalGridView.setItemViewCacheSize(0);
            arrayList2.add(verticalGridView);
            viewGroup.addView(verticalGridView);
            int i12 = i11 + 1;
            if (!TextUtils.isEmpty((CharSequence) arrayList.get(i12))) {
                TextView textView2 = (TextView) from.inflate(R.layout.lb_picker_separator, viewGroup, false);
                textView2.setText((CharSequence) arrayList.get(i12));
                viewGroup.addView(textView2);
            }
            getContext();
            verticalGridView.setAdapter(new a(this, getPickerItemLayoutId(), getPickerItemTextViewId(), i11));
            verticalGridView.setOnChildViewHolderSelectedListener(this.C);
            i11 = i12;
        }
    }

    public final void setPickerItemTextViewId(int i10) {
        this.B = i10;
    }

    public void setSelectedColumn(int i10) {
        if (this.f2511y != i10) {
            this.f2511y = i10;
            for (int i11 = 0; i11 < this.f2502p.size(); i11++) {
                d(i11);
            }
        }
    }

    public final void setSeparator(CharSequence charSequence) {
        setSeparators(Arrays.asList(charSequence));
    }

    public final void setSeparators(List<CharSequence> list) {
        ArrayList arrayList = this.f2512z;
        arrayList.clear();
        arrayList.addAll(list);
    }

    public void setVisibleItemCount(float f10) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        if (this.f2510x != f10) {
            this.f2510x = f10;
            if (isActivated()) {
                return;
            }
            e();
        }
    }
}
