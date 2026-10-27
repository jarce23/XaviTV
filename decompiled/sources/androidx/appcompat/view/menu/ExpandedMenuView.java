package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.media.session.a0;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import l.k;
import l.l;
import l.n;
import l.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements k, z, AdapterView.OnItemClickListener {

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f375p = {R.attr.background, R.attr.divider};

    /* renamed from: o, reason: collision with root package name */
    public l f376o;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        a0 T = a0.T(context, attributeSet, f375p, R.attr.listViewStyle);
        TypedArray typedArray = (TypedArray) T.f231q;
        if (typedArray.hasValue(0)) {
            setBackgroundDrawable(T.K(0));
        }
        if (typedArray.hasValue(1)) {
            setDivider(T.K(1));
        }
        T.U();
    }

    @Override // l.z
    public final void a(l lVar) {
        this.f376o = lVar;
    }

    @Override // l.k
    public final boolean c(n nVar) {
        return this.f376o.q(nVar, null, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        c((n) getAdapter().getItem(i10));
    }
}
