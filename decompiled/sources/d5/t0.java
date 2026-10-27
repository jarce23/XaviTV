package d5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.shamel.tv.models.CategoryModel;
import b4.f1;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final List f4193d;

    /* renamed from: e, reason: collision with root package name */
    public final ya.q f4194e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f4195f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f4196h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4197i;

    /* renamed from: j, reason: collision with root package name */
    public int f4198j;

    public t0(Context context, List list, int i10, boolean z10, boolean z11, boolean z12, ya.q qVar) {
        this.f4195f = context;
        this.f4193d = list;
        this.f4194e = qVar;
        this.f4198j = i10;
        this.g = z10;
        this.f4197i = z12;
        this.f4196h = z11;
    }

    @Override // b4.f0
    public final int a() {
        List list = this.f4193d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        s0 s0Var = (s0) f1Var;
        CategoryModel categoryModel = (CategoryModel) this.f4193d.get(i10);
        TextView textView = s0Var.f4187v;
        View view = s0Var.f2232a;
        TextView textView2 = s0Var.f4186u;
        textView.setText(categoryModel.getName());
        boolean z10 = this.f4197i;
        boolean z11 = this.g;
        boolean z12 = this.f4196h;
        if (z10) {
            io.realm.n0 A = a6.n.K().A(categoryModel, _UrlKt.FRAGMENT_ENCODE_SET, z12, 0);
            if (z11) {
                textView2.setText(A.size() + " movies");
            } else {
                textView2.setText(_UrlKt.FRAGMENT_ENCODE_SET + A.size());
            }
        } else {
            io.realm.n0 D = a6.n.K().D(categoryModel, _UrlKt.FRAGMENT_ENCODE_SET, z12, 0);
            if (z11) {
                textView2.setText(D.size() + " series");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(D.size());
                textView2.setText(sb2.toString());
            }
        }
        view.setOnFocusChangeListener(new p(this, s0Var, categoryModel, i10, 7));
        view.setOnClickListener(new b(this, i10, categoryModel, 13));
        int i11 = this.f4198j;
        Context context = this.f4195f;
        if (i11 == i10) {
            textView.setTextColor(context.getColor(R.color.yellow));
            textView2.setTextColor(context.getColor(R.color.yellow));
        } else {
            textView.setTextColor(context.getColor(R.color.white));
            textView2.setTextColor(context.getColor(R.color.white));
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        return this.g ? new s0(android.support.v4.media.d.h(viewGroup, R.layout.item_live_category_grid, viewGroup, false)) : new s0(android.support.v4.media.d.h(viewGroup, R.layout.item_live_category, viewGroup, false));
    }
}
