package d5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import app.shamel.tv.models.EPGChannel;
import b4.f1;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4100d = 0;

    /* renamed from: e, reason: collision with root package name */
    public Object f4101e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4102f;
    public final Object g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4103h;

    public g(Context context, List list, boolean[] zArr, ya.q qVar) {
        this.g = context;
        this.f4103h = list;
        this.f4102f = qVar;
        this.f4101e = zArr;
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4100d) {
            case 0:
                List list = (List) this.f4103h;
                if (list == null) {
                    return 0;
                }
                return list.size();
            default:
                return ((String[]) this.f4101e).length;
        }
    }

    @Override // b4.f0
    public final long b(int i10) {
        switch (this.f4100d) {
        }
        return i10;
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        switch (this.f4100d) {
            case 0:
                f fVar = (f) f1Var;
                EPGChannel ePGChannel = (EPGChannel) ((List) this.f4103h).get(i10);
                ImageView imageView = fVar.f4095x;
                ImageView imageView2 = fVar.f4093v;
                View view = fVar.f2232a;
                imageView.setVisibility(0);
                if (((boolean[]) this.f4101e)[i10]) {
                    imageView2.setVisibility(8);
                } else {
                    imageView2.setVisibility(0);
                }
                com.bumptech.glide.f.n((Context) this.g, fVar.f4092u, ePGChannel.getStream_icon(), fVar.f4094w);
                fVar.f4096y.setText(ePGChannel.getName());
                view.setOnFocusChangeListener(new a(this, fVar, i10, 1));
                l(fVar, i10, view.isFocused());
                view.setOnClickListener(new b(this, i10, ePGChannel, 1));
                break;
            default:
                u3.j jVar = (u3.j) f1Var;
                View view2 = jVar.f2232a;
                if (n(i10)) {
                    view2.setLayoutParams(new b4.p0(-1, -2));
                } else {
                    view2.setLayoutParams(new b4.p0(0, 0));
                }
                TextView textView = jVar.f12412u;
                ImageView imageView3 = jVar.f12414w;
                TextView textView2 = jVar.f12413v;
                textView.setText(((String[]) this.f4101e)[i10]);
                String str = ((String[]) this.f4102f)[i10];
                if (str == null) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str);
                }
                Drawable drawable = ((Drawable[]) this.g)[i10];
                if (drawable != null) {
                    imageView3.setImageDrawable(drawable);
                    break;
                } else {
                    imageView3.setVisibility(8);
                    break;
                }
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4100d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_add_channel, viewGroup, false);
                f fVar = new f(h10);
                fVar.f4096y = (TextView) h10.findViewById(R.id.txt_name);
                fVar.f4092u = (ImageView) h10.findViewById(R.id.image_channel);
                fVar.f4093v = (ImageView) h10.findViewById(R.id.image_check);
                fVar.f4095x = (ImageView) h10.findViewById(R.id.image_round);
                fVar.f4094w = (ImageView) h10.findViewById(R.id.image_logo);
                return fVar;
            default:
                u3.o oVar = (u3.o) this.f4103h;
                return new u3.j(oVar, LayoutInflater.from(oVar.getContext()).inflate(R.layout.exo_styled_settings_list_item, viewGroup, false));
        }
    }

    public void l(f fVar, int i10, boolean z10) {
        TextView textView = fVar.f4096y;
        View view = fVar.f2232a;
        if (i10 >= a()) {
            return;
        }
        if (z10) {
            view.setBackgroundResource(R.drawable.live_teim_focus_bg);
            textView.setSelected(true);
        } else {
            view.setBackgroundResource(R.color.item_channel_bg);
            textView.setSelected(false);
        }
    }

    public void m(List list, boolean[] zArr) {
        this.f4103h = new ArrayList(list);
        this.f4101e = zArr;
        d();
    }

    public boolean n(int i10) {
        u3.o oVar = (u3.o) this.f4103h;
        i1.o0 o0Var = oVar.D0;
        if (o0Var == null) {
            return false;
        }
        if (i10 == 0) {
            return ((b0.j) o0Var).e(13);
        }
        if (i10 != 1) {
            return true;
        }
        return ((b0.j) o0Var).e(30) && ((b0.j) oVar.D0).e(29);
    }

    public g(u3.o oVar, String[] strArr, Drawable[] drawableArr) {
        this.f4103h = oVar;
        this.f4101e = strArr;
        this.f4102f = new String[strArr.length];
        this.g = drawableArr;
    }
}
