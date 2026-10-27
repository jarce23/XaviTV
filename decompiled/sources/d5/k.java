package d5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import app.shamel.tv.activities.MovieInfoActivity;
import app.shamel.tv.models.CastModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.List;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4123d;

    /* renamed from: e, reason: collision with root package name */
    public Object f4124e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4125f;
    public Object g;

    public /* synthetic */ k(int i10) {
        this.f4123d = i10;
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4123d) {
            case 0:
                List list = (List) this.g;
                if (list == null) {
                    return 0;
                }
                return list.size();
            case 1:
                return ((String[]) this.f4124e).length;
            case 2:
                List list2 = (List) this.g;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
            case 3:
                List list3 = (List) this.g;
                if (list3 == null) {
                    return 0;
                }
                return list3.size();
            default:
                List list4 = (List) this.g;
                if (list4 == null) {
                    return 0;
                }
                return list4.size();
        }
    }

    @Override // b4.f0
    public long b(int i10) {
        switch (this.f4123d) {
            case 0:
                return i10;
            default:
                return super.b(i10);
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        switch (this.f4123d) {
            case 0:
                j jVar = (j) f1Var;
                RoundedImageView roundedImageView = jVar.f4118u;
                MovieInfoActivity movieInfoActivity = (MovieInfoActivity) this.f4125f;
                CastModel castModel = (CastModel) ((List) this.g).get(i10);
                if (castModel.getProfile_path() == null || castModel.getProfile_path().equals(_UrlKt.FRAGMENT_ENCODE_SET)) {
                    com.bumptech.glide.b.e(movieInfoActivity).q(Integer.valueOf(R.drawable.cast_icon)).E(roundedImageView);
                } else {
                    ((com.bumptech.glide.m) ((com.bumptech.glide.m) com.bumptech.glide.b.e(movieInfoActivity).r(e5.l.f4614j + castModel.getProfile_path()).p(R.drawable.cast_icon)).g(R.drawable.cast_icon)).E(roundedImageView);
                }
                TextView textView = jVar.f4119v;
                View view = jVar.f2232a;
                textView.setText(castModel.getName());
                view.setOnFocusChangeListener(new h(this, jVar, castModel));
                view.setOnClickListener(new i(this, jVar, castModel));
                break;
            case 1:
                w wVar = (w) f1Var;
                CheckedTextView checkedTextView = wVar.f4208u;
                checkedTextView.setText(((String[]) this.f4124e)[i10]);
                checkedTextView.setChecked(((boolean[]) this.f4125f)[i10]);
                View view2 = wVar.f2232a;
                view2.setOnClickListener(new u(this, i10, 0));
                view2.setOnFocusChangeListener(new v(wVar, 0));
                break;
            case 2:
                q0 q0Var = (q0) f1Var;
                EPGChannel ePGChannel = (EPGChannel) ((List) this.g).get(i10);
                q0Var.f4172w.setText(ePGChannel.getName());
                com.bumptech.glide.f.n((Context) this.f4125f, q0Var.f4170u, ePGChannel.getStream_icon(), q0Var.f4171v);
                View view3 = q0Var.f2232a;
                view3.setOnFocusChangeListener(new p(this, q0Var, ePGChannel, i10, 5));
                view3.setOnClickListener(new b(this, ePGChannel, i10, 11));
                view3.setOnTouchListener(new p0(this, q0Var, ePGChannel, i10, 0));
                break;
            case 3:
                r0 r0Var = (r0) f1Var;
                SeriesModel seriesModel = (SeriesModel) ((List) this.g).get(i10);
                r0Var.f4180w.setText(seriesModel.getName());
                com.bumptech.glide.f.n((Context) this.f4125f, r0Var.f4179v, seriesModel.getStream_icon(), r0Var.f4178u);
                View view4 = r0Var.f2232a;
                view4.setOnFocusChangeListener(new p(this, r0Var, seriesModel, i10, 6));
                view4.setOnClickListener(new b(this, seriesModel, i10, 12));
                view4.setOnTouchListener(new p0(this, r0Var, seriesModel, i10, 1));
                break;
            default:
                u0 u0Var = (u0) f1Var;
                MovieModel movieModel = (MovieModel) ((List) this.g).get(i10);
                u0Var.f4204w.setText(movieModel.getName());
                com.bumptech.glide.f.n((Context) this.f4125f, u0Var.f4203v, movieModel.getStream_icon(), u0Var.f4202u);
                View view5 = u0Var.f2232a;
                view5.setOnFocusChangeListener(new p(this, u0Var, movieModel, i10, 8));
                view5.setOnClickListener(new b(this, movieModel, i10, 14));
                view5.setOnTouchListener(new p0(this, u0Var, movieModel, i10, 2));
                break;
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4123d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_cast, viewGroup, false);
                j jVar = new j(h10);
                jVar.f4119v = (TextView) h10.findViewById(R.id.txt_name);
                jVar.f4118u = (RoundedImageView) h10.findViewById(R.id.image_vod);
                return jVar;
            case 1:
                View h11 = android.support.v4.media.d.h(viewGroup, R.layout.item_hide_category, viewGroup, false);
                w wVar = new w(h11);
                wVar.f4208u = (CheckedTextView) h11.findViewById(R.id.txt_name);
                return wVar;
            case 2:
                View h12 = android.support.v4.media.d.h(viewGroup, R.layout.item_home_live, viewGroup, false);
                q0 q0Var = new q0(h12);
                q0Var.f4172w = (TextView) h12.findViewById(R.id.txt_name);
                q0Var.f4170u = (ImageView) h12.findViewById(R.id.image_channel);
                q0Var.f4171v = (ImageView) h12.findViewById(R.id.image_logo);
                return q0Var;
            case 3:
                View h13 = android.support.v4.media.d.h(viewGroup, R.layout.item_home_vod, viewGroup, false);
                r0 r0Var = new r0(h13);
                r0Var.f4180w = (TextView) h13.findViewById(R.id.txt_name);
                r0Var.f4179v = (ImageView) h13.findViewById(R.id.image_channel);
                r0Var.f4178u = (ImageView) h13.findViewById(R.id.image_logo);
                return r0Var;
            default:
                View h14 = android.support.v4.media.d.h(viewGroup, R.layout.item_home_vod, viewGroup, false);
                u0 u0Var = new u0(h14);
                u0Var.f4204w = (TextView) h14.findViewById(R.id.txt_name);
                u0Var.f4203v = (ImageView) h14.findViewById(R.id.image_channel);
                u0Var.f4202u = (ImageView) h14.findViewById(R.id.image_logo);
                return u0Var;
        }
    }

    public void l(boolean z10) {
        for (int i10 = 0; i10 < ((String[]) this.f4124e).length; i10++) {
            ((boolean[]) this.f4125f)[i10] = z10;
        }
        d();
    }

    public k(String[] strArr, boolean[] zArr, ya.p pVar) {
        this.f4123d = 1;
        this.f4124e = strArr;
        this.f4125f = zArr;
        this.g = pVar;
    }
}
