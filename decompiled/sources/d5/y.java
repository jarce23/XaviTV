package d5;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import app.shamel.tv.models.LanguageModel;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4221d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4222e;

    /* renamed from: f, reason: collision with root package name */
    public int f4223f;
    public Object g;

    public /* synthetic */ y(int i10) {
        this.f4221d = i10;
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4221d) {
            case 0:
                List list = (List) this.f4222e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            case 1:
                List list2 = (List) this.f4222e;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
            case 2:
                return ((ArrayList) this.g).size();
            default:
                String[] strArr = (String[]) this.g;
                if (strArr == null) {
                    return 0;
                }
                return strArr.length;
        }
    }

    @Override // b4.f0
    public long b(int i10) {
        switch (this.f4221d) {
            case 2:
                return i10;
            default:
                return super.b(i10);
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        switch (this.f4221d) {
            case 0:
                x xVar = (x) f1Var;
                CheckedTextView checkedTextView = xVar.f4213u;
                View view = xVar.f2232a;
                checkedTextView.setText(((LanguageModel) ((List) this.f4222e).get(i10)).getName());
                checkedTextView.setChecked(this.f4223f == i10);
                view.setOnClickListener(new u(this, i10, 1));
                view.setOnFocusChangeListener(new v(xVar, 1));
                if (this.f4223f == i10) {
                    view.requestFocus();
                    break;
                }
                break;
            case 1:
                z zVar = (z) f1Var;
                CheckedTextView checkedTextView2 = zVar.f4227u;
                View view2 = zVar.f2232a;
                checkedTextView2.setText((CharSequence) ((List) this.f4222e).get(i10));
                if (this.f4223f == i10) {
                    checkedTextView2.setChecked(true);
                    view2.requestFocus();
                } else {
                    checkedTextView2.setChecked(false);
                }
                view2.setOnClickListener(new u(this, i10, 2));
                view2.setOnFocusChangeListener(new v(zVar, 2));
                break;
            case 2:
                y0 y0Var = (y0) f1Var;
                ImageView imageView = y0Var.f4224u;
                View view3 = y0Var.f2232a;
                ImageView imageView2 = y0Var.f4225v;
                imageView.setImageResource(((e5.m) ((ArrayList) this.g).get(i10)).f4617a);
                y0Var.f4226w.setText(((e5.m) ((ArrayList) this.g).get(i10)).f4618b);
                int i11 = this.f4223f;
                if (i11 <= 0 || i11 != i10) {
                    imageView2.setVisibility(8);
                } else {
                    imageView2.setVisibility(0);
                }
                view3.setOnFocusChangeListener(new a(this, y0Var, i10, 6));
                view3.setOnClickListener(new u(this, i10, 5));
                break;
            default:
                a1 a1Var = (a1) f1Var;
                RoundedImageView roundedImageView = a1Var.f4061v;
                ImageView imageView3 = a1Var.f4060u;
                roundedImageView.setColorFilter(Color.parseColor(((String[]) this.g)[i10]));
                View view4 = a1Var.f2232a;
                view4.setOnClickListener(new u(this, i10, 6));
                view4.setOnFocusChangeListener(new v(a1Var, 4));
                if (this.f4223f != i10) {
                    imageView3.setVisibility(8);
                    break;
                } else {
                    imageView3.setVisibility(0);
                    break;
                }
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4221d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_hide_category, viewGroup, false);
                x xVar = new x(h10);
                xVar.f4213u = (CheckedTextView) h10.findViewById(R.id.txt_name);
                return xVar;
            case 1:
                View h11 = android.support.v4.media.d.h(viewGroup, R.layout.item_hide_category, viewGroup, false);
                z zVar = new z(h11);
                zVar.f4227u = (CheckedTextView) h11.findViewById(R.id.txt_name);
                return zVar;
            case 2:
                View h12 = android.support.v4.media.d.h(viewGroup, R.layout.item_setting, viewGroup, false);
                y0 y0Var = new y0(h12);
                y0Var.f4224u = (ImageView) h12.findViewById(R.id.image_setting);
                y0Var.f4226w = (TextView) h12.findViewById(R.id.txt_setting);
                y0Var.f4225v = (ImageView) h12.findViewById(R.id.image_update);
                return y0Var;
            default:
                View h13 = android.support.v4.media.d.h(viewGroup, R.layout.item_subtitle_color, viewGroup, false);
                a1 a1Var = new a1(h13);
                a1Var.f4061v = (RoundedImageView) h13.findViewById(R.id.image_color);
                a1Var.f4060u = (ImageView) h13.findViewById(R.id.image_check);
                return a1Var;
        }
    }

    public y(ArrayList arrayList, int i10, ya.p pVar) {
        this.f4221d = 1;
        this.f4222e = arrayList;
        this.f4223f = i10;
        this.g = pVar;
    }
}
