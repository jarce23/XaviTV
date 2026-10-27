package d5;

import android.content.Context;
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
public final class c0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public List f4080d;

    /* renamed from: e, reason: collision with root package name */
    public final ya.q f4081e;

    /* renamed from: f, reason: collision with root package name */
    public final Context f4082f;
    public final boolean g;

    public c0(Context context, List list, boolean z10, ya.q qVar) {
        this.f4082f = context;
        this.f4080d = list;
        this.g = z10;
        this.f4081e = qVar;
    }

    @Override // b4.f0
    public final int a() {
        List list = this.f4080d;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // b4.f0
    public final long b(int i10) {
        return i10;
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        b0 b0Var = (b0) f1Var;
        String str = (String) this.f4080d.get(i10);
        EPGChannel ePGChannel = (EPGChannel) android.support.v4.media.d.j((io.realm.u) a6.n.K().f74p, EPGChannel.class, "name", str);
        com.bumptech.glide.f.n(this.f4082f, b0Var.f4066u, ePGChannel.getStream_icon(), b0Var.f4068w);
        b0Var.f4069x.setText(ePGChannel.getName());
        View view = b0Var.f2232a;
        view.setOnFocusChangeListener(new a(this, b0Var, i10, 3));
        l(b0Var, i10, view.isFocused());
        view.setOnClickListener(new b(this, str, i10, 6));
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_add_channel, viewGroup, false);
        b0 b0Var = new b0(h10);
        b0Var.f4070y = (TextView) h10.findViewById(R.id.txt_num);
        b0Var.f4069x = (TextView) h10.findViewById(R.id.txt_name);
        b0Var.f4066u = (ImageView) h10.findViewById(R.id.image_channel);
        b0Var.f4067v = (ImageView) h10.findViewById(R.id.image_delete);
        b0Var.f4068w = (ImageView) h10.findViewById(R.id.image_logo);
        return b0Var;
    }

    public final void l(b0 b0Var, int i10, boolean z10) {
        TextView textView = b0Var.f4070y;
        if (i10 >= a()) {
            return;
        }
        String str = (String) this.f4080d.get(i10);
        ImageView imageView = b0Var.f4067v;
        TextView textView2 = b0Var.f4069x;
        View view = b0Var.f2232a;
        textView.setVisibility(0);
        textView.setText(String.valueOf(i10 + 1));
        if (!z10) {
            view.setBackgroundResource(R.color.item_channel_bg);
            textView2.setSelected(false);
            imageView.setVisibility(8);
            return;
        }
        this.f4081e.c(str, Integer.valueOf(i10), Boolean.FALSE);
        view.setBackgroundResource(R.drawable.live_teim_focus_bg);
        textView2.setSelected(true);
        if (this.g) {
            return;
        }
        imageView.setVisibility(0);
    }

    public final void m(List list) {
        this.f4080d = new ArrayList(list);
        d();
    }
}
