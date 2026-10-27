package d5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.shamel.tv.activities.AddGroupActivity;
import app.shamel.tv.activities.CatchUpActivity;
import app.shamel.tv.activities.MovieCreditActivity;
import app.shamel.tv.activities.SeasonActivity;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchupModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieCreditModel;
import app.shamel.tv.models.Season;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4085d;

    /* renamed from: e, reason: collision with root package name */
    public int f4086e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4087f;
    public Object g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4088h;

    public /* synthetic */ e(int i10) {
        this.f4085d = i10;
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4085d) {
            case 0:
                return ((List) this.f4087f).size();
            case 1:
                ArrayList arrayList = (ArrayList) this.f4087f;
                if (arrayList == null) {
                    return 0;
                }
                return arrayList.size();
            case 2:
                ArrayList arrayList2 = (ArrayList) this.f4088h;
                if (arrayList2 == null) {
                    return 0;
                }
                return arrayList2.size();
            case 3:
                List list = (List) this.f4087f;
                if (list == null) {
                    return 0;
                }
                return list.size();
            case 4:
                List list2 = (List) this.f4087f;
                if (list2 == null) {
                    return 0;
                }
                return list2.size();
            case 5:
                List list3 = (List) this.f4087f;
                if (list3 == null) {
                    return 0;
                }
                return list3.size();
            default:
                return ((String[]) this.f4087f).length;
        }
    }

    @Override // b4.f0
    public long b(int i10) {
        switch (this.f4085d) {
            case 0:
                return i10;
            default:
                return super.b(i10);
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, final int i10) {
        switch (this.f4085d) {
            case 0:
                d dVar = (d) f1Var;
                AddGroupActivity addGroupActivity = (AddGroupActivity) this.f4088h;
                String str = (String) ((List) this.f4087f).get(i10);
                TextView textView = dVar.f4083u;
                textView.setText(str);
                View view = dVar.f2232a;
                view.setOnFocusChangeListener(new a(this, dVar, i10, 0));
                l(dVar, i10, view.isFocused());
                int i11 = 0;
                view.setOnClickListener(new b(this, i10, str, i11));
                view.setOnLongClickListener(new c(this, str, i10, i11));
                if (this.f4086e == i10 && i10 != 0) {
                    textView.setTextColor(addGroupActivity.getColor(R.color.yellow));
                    break;
                } else {
                    textView.setTextColor(addGroupActivity.getColor(R.color.white));
                    break;
                }
            case 1:
                n nVar = (n) f1Var;
                CatchupModel catchupModel = (CatchupModel) ((ArrayList) this.f4087f).get(i10);
                nVar.f4139v.setText(catchupModel.getDayofweek());
                nVar.f4138u.setText(catchupModel.getName());
                View view2 = nVar.f2232a;
                int i12 = 2;
                view2.setOnFocusChangeListener(new a(this, nVar, i10, i12));
                view2.setOnClickListener(new b(this, i10, catchupModel, i12));
                m(nVar, i10, view2.isFocused());
                break;
            case 2:
                a0 a0Var = (a0) f1Var;
                MovieCreditModel movieCreditModel = (MovieCreditModel) ((ArrayList) this.f4088h).get(i10);
                TextView textView2 = a0Var.f4059x;
                textView2.setText(movieCreditModel.getTitle());
                a0Var.f4058w.setVisibility(8);
                MovieCreditActivity movieCreditActivity = (MovieCreditActivity) this.f4087f;
                com.bumptech.glide.f.n(movieCreditActivity, a0Var.f4057v, e5.l.f4614j + movieCreditModel.getPoster_path(), a0Var.f4056u);
                View view3 = a0Var.f2232a;
                view3.setOnClickListener(new b(this, i10, movieCreditModel, 5));
                view3.setOnFocusChangeListener(new h(this, a0Var, movieCreditModel, i10));
                if (this.f4086e == i10) {
                    view3.setBackgroundResource(R.drawable.item_vod_selected_bg);
                    textView2.setTextColor(movieCreditActivity.getColor(R.color.black));
                    textView2.setSelected(true);
                    view3.setScaleX(1.0f);
                    view3.setScaleY(1.0f);
                    ((app.shamel.tv.activities.h0) this.g).f1896p.u(movieCreditModel);
                    break;
                } else {
                    view3.setBackgroundResource(R.drawable.item_group_bg);
                    textView2.setTextColor(movieCreditActivity.getColor(R.color.white));
                    view3.setScaleX(0.95f);
                    view3.setScaleY(0.95f);
                    break;
                }
            case 3:
                k0 k0Var = (k0) f1Var;
                CatchUpEpg catchUpEpg = (CatchUpEpg) ((List) this.f4087f).get(i10);
                TextView textView3 = k0Var.f4128w;
                TextView textView4 = k0Var.f4127v;
                ImageView imageView = k0Var.f4126u;
                View view4 = k0Var.f2232a;
                textView3.setText(k5.j.e(catchUpEpg.getTitle()));
                k0Var.f4130y.setText(k5.j.c(catchUpEpg.getStart_timestamp() * 1000, (CatchUpActivity) this.f4088h));
                if (catchUpEpg.getHas_archive() == 1) {
                    imageView.setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                }
                if (this.f4086e == i10) {
                    textView4.setVisibility(0);
                } else {
                    textView4.setVisibility(8);
                }
                view4.setOnFocusChangeListener(new p(this, k0Var, catchUpEpg, i10, 2));
                view4.setOnClickListener(new b(this, catchUpEpg, i10, 8));
                view4.setBackgroundColor(Color.parseColor("#00FFFFFF"));
                break;
            case 4:
                o0 o0Var = (o0) f1Var;
                Context context = (Context) this.f4088h;
                EPGChannel ePGChannel = (EPGChannel) ((List) this.f4087f).get(i10);
                TextView textView5 = o0Var.f4155z;
                ImageView imageView2 = o0Var.f4150u;
                ImageView imageView3 = o0Var.f4153x;
                ImageView imageView4 = o0Var.f4152w;
                View view5 = o0Var.f2232a;
                textView5.setText(ePGChannel.getName());
                o0Var.A.setText(String.valueOf(ePGChannel.getNum()));
                if (ePGChannel.is_favorite()) {
                    imageView4.setVisibility(0);
                } else {
                    imageView4.setVisibility(8);
                }
                if (ePGChannel.is_locked()) {
                    imageView3.setVisibility(0);
                } else {
                    imageView3.setVisibility(8);
                }
                if (ePGChannel.getTv_archive().equalsIgnoreCase("1")) {
                    imageView2.setVisibility(0);
                } else {
                    imageView2.setVisibility(8);
                }
                com.bumptech.glide.f.n(context, o0Var.f4151v, ePGChannel.getStream_icon(), o0Var.f4154y);
                view5.setOnClickListener(new b(this, i10, ePGChannel, 10));
                view5.setOnFocusChangeListener(new p(this, o0Var, i10, ePGChannel));
                view5.setOnLongClickListener(new c(this, ePGChannel, i10, 1));
                if (this.f4086e != i10) {
                    textView5.setTextColor(context.getColor(R.color.white));
                    break;
                } else {
                    textView5.setTextColor(context.getColor(R.color.yellow));
                    break;
                }
            case 5:
                v0 v0Var = (v0) f1Var;
                v0Var.f4207u.setText(((Season) ((List) this.f4087f).get(i10)).getName());
                View view6 = v0Var.f2232a;
                view6.setOnFocusChangeListener(new a(this, v0Var, i10, 4));
                n(v0Var, i10, view6.isFocused());
                view6.setOnClickListener(new u(this, i10, 4));
                break;
            default:
                u3.k kVar = (u3.k) f1Var;
                View view7 = kVar.f12417v;
                View view8 = kVar.f2232a;
                String[] strArr = (String[]) this.f4087f;
                if (i10 < strArr.length) {
                    kVar.f12416u.setText(strArr[i10]);
                }
                if (i10 == this.f4086e) {
                    view8.setSelected(true);
                    view7.setVisibility(0);
                } else {
                    view8.setSelected(false);
                    view7.setVisibility(4);
                }
                view8.setOnClickListener(new View.OnClickListener() { // from class: u3.h
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view9) {
                        d5.e eVar = d5.e.this;
                        o oVar = (o) eVar.f4088h;
                        int i13 = eVar.f4086e;
                        int i14 = i10;
                        if (i14 != i13) {
                            oVar.setPlaybackSpeed(((float[]) eVar.g)[i14]);
                        }
                        oVar.E.dismiss();
                    }
                });
                break;
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4085d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_live_category, viewGroup, false);
                d dVar = new d(h10);
                dVar.f4083u = (TextView) h10.findViewById(R.id.txt_name);
                return dVar;
            case 1:
                View h11 = android.support.v4.media.d.h(viewGroup, R.layout.item_date, viewGroup, false);
                n nVar = new n(h11);
                nVar.f4139v = (TextView) h11.findViewById(R.id.txt_week);
                nVar.f4138u = (TextView) h11.findViewById(R.id.txt_date);
                return nVar;
            case 2:
                View h12 = android.support.v4.media.d.h(viewGroup, R.layout.item_vod_credit, viewGroup, false);
                a0 a0Var = new a0(h12);
                a0Var.f4057v = (RoundedImageView) h12.findViewById(R.id.image_vod);
                a0Var.f4056u = (RoundedImageView) h12.findViewById(R.id.image_logo);
                a0Var.f4059x = (TextView) h12.findViewById(R.id.txt_name);
                a0Var.f4058w = (ProgressBar) h12.findViewById(R.id.seekBar);
                return a0Var;
            case 3:
                View h13 = android.support.v4.media.d.h(viewGroup, R.layout.item_program, viewGroup, false);
                k0 k0Var = new k0(h13);
                k0Var.f4130y = (TextView) h13.findViewById(R.id.txt_time);
                k0Var.f4127v = (TextView) h13.findViewById(R.id.txt_live);
                k0Var.f4128w = (TextView) h13.findViewById(R.id.txt_program);
                k0Var.f4129x = (TextView) h13.findViewById(R.id.txt_program_description);
                k0Var.f4126u = (ImageView) h13.findViewById(R.id.catch_image);
                return k0Var;
            case 4:
                View h14 = android.support.v4.media.d.h(viewGroup, R.layout.item_live_channel, viewGroup, false);
                o0 o0Var = new o0(h14);
                o0Var.f4155z = (TextView) h14.findViewById(R.id.txt_name);
                o0Var.A = (TextView) h14.findViewById(R.id.txt_num);
                o0Var.f4151v = (ImageView) h14.findViewById(R.id.image_channel);
                o0Var.f4154y = (ImageView) h14.findViewById(R.id.image_logo);
                o0Var.f4152w = (ImageView) h14.findViewById(R.id.image_fav);
                o0Var.f4150u = (ImageView) h14.findViewById(R.id.image_catch);
                o0Var.f4153x = (ImageView) h14.findViewById(R.id.image_lock);
                return o0Var;
            case 5:
                View h15 = android.support.v4.media.d.h(viewGroup, R.layout.item_season, viewGroup, false);
                v0 v0Var = new v0(h15);
                v0Var.f4207u = (TextView) h15.findViewById(R.id.txt_name);
                return v0Var;
            default:
                return new u3.k(LayoutInflater.from(((u3.o) this.f4088h).getContext()).inflate(R.layout.exo_styled_sub_settings_list_item, viewGroup, false));
        }
    }

    public void l(d dVar, int i10, boolean z10) {
        View view = dVar.f2232a;
        if (!z10) {
            view.setBackgroundResource(R.color.item_channel_bg);
            return;
        }
        String str = (String) ((List) this.f4087f).get(i10);
        app.shamel.tv.activities.a aVar = (app.shamel.tv.activities.a) this.g;
        Integer valueOf = Integer.valueOf(i10);
        Boolean bool = Boolean.FALSE;
        aVar.d(str, valueOf, bool, bool);
        view.setBackgroundResource(R.drawable.live_teim_focus_bg);
    }

    public void m(n nVar, int i10, boolean z10) {
        TextView textView = nVar.f4138u;
        View view = nVar.f2232a;
        CatchUpActivity catchUpActivity = (CatchUpActivity) this.f4088h;
        CatchupModel catchupModel = (CatchupModel) ((ArrayList) this.f4087f).get(i10);
        if (z10) {
            ((app.shamel.tv.activities.f) this.g).c(catchupModel, Integer.valueOf(i10), Boolean.FALSE);
            view.setBackgroundResource(R.color.item_channel_bg);
        } else {
            view.setBackgroundColor(Color.parseColor("#00FFFFFF"));
        }
        if (i10 == this.f4086e) {
            textView.setTextColor(catchUpActivity.getColor(R.color.yellow));
        } else {
            textView.setTextColor(catchUpActivity.getColor(R.color.white));
        }
    }

    public void n(v0 v0Var, int i10, boolean z10) {
        TextView textView = v0Var.f4207u;
        View view = v0Var.f2232a;
        SeasonActivity seasonActivity = (SeasonActivity) this.f4088h;
        if (z10) {
            ((app.shamel.tv.activities.b) this.g).c((Season) ((List) this.f4087f).get(i10), Integer.valueOf(i10), Boolean.FALSE);
            view.setBackgroundResource(R.color.item_channel_bg);
        } else {
            view.setBackgroundResource(R.color.trans_parent);
        }
        if (i10 == this.f4086e) {
            textView.setTextColor(seasonActivity.getColor(R.color.yellow));
        } else {
            textView.setTextColor(seasonActivity.getColor(R.color.white));
        }
    }

    public void o(int i10) {
        int i11 = this.f4086e;
        this.f4086e = i10;
        if (i11 != -1) {
            e(i11);
        }
        e(i10);
    }

    public void p(int i10) {
        this.f4086e = i10;
        d();
    }

    public void q(int i10, List list) {
        this.f4087f = list;
        this.f4086e = i10;
        d();
    }

    public e(f.j jVar, List list, int i10, ya.r rVar) {
        this.f4085d = 4;
        this.f4088h = jVar;
        this.f4087f = list;
        this.f4086e = i10;
        this.g = rVar;
    }

    public e(u3.o oVar, String[] strArr, float[] fArr) {
        this.f4085d = 6;
        this.f4088h = oVar;
        this.f4087f = strArr;
        this.g = fArr;
    }
}
