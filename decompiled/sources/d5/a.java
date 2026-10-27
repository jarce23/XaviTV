package d5;

import android.view.View;
import android.widget.TextView;
import b4.f1;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements View.OnFocusChangeListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4052o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f4053p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ f1 f4054q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4055r;

    public /* synthetic */ a(b4.f0 f0Var, f1 f1Var, int i10, int i11) {
        this.f4052o = i11;
        this.f4055r = f0Var;
        this.f4054q = f1Var;
        this.f4053p = i10;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z10) {
        switch (this.f4052o) {
            case 0:
                ((e) this.f4055r).l((d) this.f4054q, this.f4053p, z10);
                break;
            case 1:
                ((g) this.f4055r).l((f) this.f4054q, this.f4053p, z10);
                break;
            case 2:
                ((e) this.f4055r).m((n) this.f4054q, this.f4053p, z10);
                break;
            case 3:
                ((c0) this.f4055r).l((b0) this.f4054q, this.f4053p, z10);
                break;
            case 4:
                ((e) this.f4055r).n((v0) this.f4054q, this.f4053p, z10);
                break;
            case 5:
                x0 x0Var = (x0) this.f4055r;
                f.j jVar = x0Var.f4217h;
                w0 w0Var = (w0) this.f4054q;
                TextView textView = w0Var.f4212x;
                View view2 = w0Var.f2232a;
                if (!z10) {
                    textView.setTextColor(jVar.getResources().getColor(R.color.white));
                    view2.setBackgroundResource(R.drawable.item_group_bg);
                    view2.setScaleX(0.95f);
                    view2.setScaleY(0.95f);
                    textView.setSelected(false);
                    break;
                } else {
                    textView.setTextColor(jVar.getResources().getColor(R.color.black));
                    view2.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView.setSelected(true);
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                    ((a6.n) x0Var.f4220k).H(this.f4053p);
                    break;
                }
            case 6:
                View view3 = ((y0) this.f4054q).f2232a;
                if (!z10) {
                    view3.setBackgroundResource(R.drawable.home_item_bg);
                    break;
                } else {
                    y yVar = (y) this.f4055r;
                    app.shamel.tv.activities.b bVar = (app.shamel.tv.activities.b) yVar.f4222e;
                    ArrayList arrayList = (ArrayList) yVar.g;
                    int i10 = this.f4053p;
                    bVar.c((e5.m) arrayList.get(i10), Integer.valueOf(i10), Boolean.FALSE);
                    view3.setBackgroundResource(R.drawable.home_item_bg_focused);
                    break;
                }
            default:
                x0 x0Var2 = (x0) this.f4055r;
                f.j jVar2 = x0Var2.f4217h;
                b1 b1Var = (b1) this.f4054q;
                TextView textView2 = b1Var.f4075y;
                View view4 = b1Var.f2232a;
                if (!z10) {
                    view4.setBackgroundResource(R.drawable.item_group_bg);
                    textView2.setTextColor(jVar2.getResources().getColor(R.color.white));
                    view4.setScaleX(0.95f);
                    view4.setScaleY(0.95f);
                    textView2.setSelected(false);
                    break;
                } else {
                    view4.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView2.setSelected(true);
                    textView2.setTextColor(jVar2.getResources().getColor(R.color.black));
                    view4.setScaleX(1.0f);
                    view4.setScaleY(1.0f);
                    ((a6.n) x0Var2.f4220k).H(this.f4053p);
                    break;
                }
        }
    }
}
