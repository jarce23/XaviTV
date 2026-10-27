package g9;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v extends ArrayAdapter {

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f5416o;

    /* renamed from: p, reason: collision with root package name */
    public ColorStateList f5417p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ w f5418q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(w wVar, Context context, int i10, String[] strArr) {
        super(context, i10, strArr);
        this.f5418q = wVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        w wVar = this.f5418q;
        ColorStateList colorStateList2 = wVar.f5426z;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f5417p = colorStateList;
        if (wVar.f5425y != 0 && wVar.f5426z != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{e0.a.f(wVar.f5426z.getColorForState(iArr3, 0), wVar.f5425y), e0.a.f(wVar.f5426z.getColorForState(iArr2, 0), wVar.f5425y), wVar.f5425y});
        }
        this.f5416o = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i10, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i10, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            w wVar = this.f5418q;
            Drawable drawable = null;
            if (wVar.getText().toString().contentEquals(textView.getText()) && wVar.f5425y != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(wVar.f5425y);
                if (this.f5417p != null) {
                    colorDrawable.setTintList(this.f5416o);
                    drawable = new RippleDrawable(this.f5417p, colorDrawable, null);
                } else {
                    drawable = colorDrawable;
                }
            }
            textView.setBackground(drawable);
        }
        return view2;
    }
}
