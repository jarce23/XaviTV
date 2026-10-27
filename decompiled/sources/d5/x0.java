package d5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import io.realm.OrderedRealmCollection;
import io.realm.log.RealmLog;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x0 extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public OrderedRealmCollection f4214d;
    public final /* synthetic */ int g;

    /* renamed from: h, reason: collision with root package name */
    public final f.j f4217h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f4218i;

    /* renamed from: k, reason: collision with root package name */
    public Object f4220k;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f4215e = true;

    /* renamed from: f, reason: collision with root package name */
    public final l0 f4216f = new l0(this);

    /* renamed from: j, reason: collision with root package name */
    public int f4219j = -1;

    public x0(f.j jVar, io.realm.n0 n0Var, boolean z10, int i10) {
        this.g = i10;
        this.f4214d = n0Var;
        this.f4217h = jVar;
        this.f4218i = z10;
    }

    @Override // b4.f0
    public final int a() {
        if (n()) {
            return this.f4214d.size();
        }
        return 0;
    }

    @Override // b4.f0
    public final void f() {
        if (this.f4215e && n()) {
            l(this.f4214d);
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        switch (this.g) {
            case 0:
                w0 w0Var = (w0) f1Var;
                SeriesModel seriesModel = (SeriesModel) m(i10);
                TextView textView = w0Var.f4212x;
                ImageView imageView = w0Var.f4209u;
                View view = w0Var.f2232a;
                textView.setText(seriesModel.getName());
                if (seriesModel.is_favorite()) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                RoundedImageView roundedImageView = w0Var.f4211w;
                String stream_icon = seriesModel.getStream_icon();
                RoundedImageView roundedImageView2 = w0Var.f4210v;
                f.j jVar = this.f4217h;
                com.bumptech.glide.f.n(jVar, roundedImageView, stream_icon, roundedImageView2);
                view.setOnClickListener(new b(this, i10, seriesModel, 15));
                view.setOnFocusChangeListener(new a(this, w0Var, i10, 5));
                view.setOnLongClickListener(new c(this, seriesModel, i10, 2));
                if (this.f4219j == i10) {
                    view.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView.setSelected(true);
                    view.setScaleX(1.0f);
                    view.setScaleY(1.0f);
                    textView.setTextColor(jVar.getColor(R.color.black));
                    ((a6.n) this.f4220k).H(i10);
                    break;
                } else {
                    view.setBackgroundResource(R.drawable.item_group_bg);
                    view.setScaleX(0.95f);
                    view.setScaleY(0.95f);
                    textView.setSelected(false);
                    textView.setTextColor(jVar.getColor(R.color.white));
                    break;
                }
            default:
                b1 b1Var = (b1) f1Var;
                MovieModel movieModel = (MovieModel) m(i10);
                TextView textView2 = b1Var.f4075y;
                ImageView imageView2 = b1Var.f4071u;
                ProgressBar progressBar = b1Var.f4074x;
                View view2 = b1Var.f2232a;
                textView2.setText(movieModel.getName());
                if (movieModel.isIs_favorite()) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
                if (movieModel.getPro() == 0) {
                    progressBar.setVisibility(8);
                } else {
                    progressBar.setProgress(movieModel.getPro());
                    progressBar.setVisibility(0);
                }
                RoundedImageView roundedImageView3 = b1Var.f4073w;
                String stream_icon2 = movieModel.getStream_icon();
                RoundedImageView roundedImageView4 = b1Var.f4072v;
                f.j jVar2 = this.f4217h;
                com.bumptech.glide.f.n(jVar2, roundedImageView3, stream_icon2, roundedImageView4);
                view2.setOnClickListener(new b(this, i10, movieModel, 16));
                view2.setOnFocusChangeListener(new a(this, b1Var, i10, 7));
                view2.setOnLongClickListener(new c(this, movieModel, i10, 3));
                if (this.f4219j == i10) {
                    view2.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView2.setTextColor(jVar2.getColor(R.color.black));
                    textView2.setSelected(true);
                    view2.setScaleX(1.0f);
                    view2.setScaleY(1.0f);
                    ((a6.n) this.f4220k).H(i10);
                    break;
                } else {
                    view2.setBackgroundResource(R.drawable.item_group_bg);
                    textView2.setTextColor(jVar2.getColor(R.color.white));
                    view2.setScaleX(0.95f);
                    view2.setScaleY(0.95f);
                    break;
                }
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.g) {
            case 0:
                return this.f4218i ? new w0(android.support.v4.media.d.h(viewGroup, R.layout.item_vod_grid, viewGroup, false)) : new w0(android.support.v4.media.d.h(viewGroup, R.layout.item_vod, viewGroup, false));
            default:
                return this.f4218i ? new b1(android.support.v4.media.d.h(viewGroup, R.layout.item_vod_grid, viewGroup, false)) : new b1(android.support.v4.media.d.h(viewGroup, R.layout.item_vod, viewGroup, false));
        }
    }

    @Override // b4.f0
    public final void i() {
        if (this.f4215e && n()) {
            o(this.f4214d);
        }
    }

    public final void l(OrderedRealmCollection orderedRealmCollection) {
        if (!(orderedRealmCollection instanceof io.realm.n0)) {
            throw new IllegalArgumentException("RealmCollection not supported: " + orderedRealmCollection.getClass());
        }
        io.realm.n0 n0Var = (io.realm.n0) orderedRealmCollection;
        io.realm.u uVar = n0Var.f6783o;
        l0 l0Var = this.f4216f;
        if (l0Var == null) {
            throw new IllegalArgumentException("Listener should not be null");
        }
        uVar.c();
        ((ea.a) uVar.f6647s.capabilities).c("Listeners cannot be used on current thread.");
        n0Var.f6784p.a(n0Var, l0Var);
    }

    public final io.realm.i0 m(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Only indexes >= 0 are allowed. Input was: "));
        }
        OrderedRealmCollection orderedRealmCollection = this.f4214d;
        if ((orderedRealmCollection == null || i10 < orderedRealmCollection.size()) && n()) {
            return (io.realm.i0) this.f4214d.get(i10);
        }
        return null;
    }

    public final boolean n() {
        OrderedRealmCollection orderedRealmCollection = this.f4214d;
        return orderedRealmCollection != null && orderedRealmCollection.isValid();
    }

    public final void o(OrderedRealmCollection orderedRealmCollection) {
        if (!(orderedRealmCollection instanceof io.realm.n0)) {
            throw new IllegalArgumentException("RealmCollection not supported: " + orderedRealmCollection.getClass());
        }
        io.realm.n0 n0Var = (io.realm.n0) orderedRealmCollection;
        io.realm.u uVar = n0Var.f6783o;
        l0 l0Var = this.f4216f;
        if (l0Var == null) {
            throw new IllegalArgumentException("Listener should not be null");
        }
        if (uVar.isClosed()) {
            RealmLog.c("Calling removeChangeListener on a closed Realm %s, make sure to close all listeners before closing the Realm.", uVar.f6645q.f6666c);
        }
        n0Var.f6784p.g(n0Var, l0Var);
    }

    public final void p(OrderedRealmCollection orderedRealmCollection) {
        if (this.f4215e) {
            if (n()) {
                o(this.f4214d);
            }
            if (orderedRealmCollection != null) {
                l(orderedRealmCollection);
            }
        }
        this.f4214d = orderedRealmCollection;
        d();
    }
}
