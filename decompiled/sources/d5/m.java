package d5;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CategoryModel;
import b4.f1;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends b4.f0 {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f4133d = 2;

    /* renamed from: e, reason: collision with root package name */
    public List f4134e;

    /* renamed from: f, reason: collision with root package name */
    public Object f4135f;

    public /* synthetic */ m() {
    }

    @Override // b4.f0
    public final int a() {
        switch (this.f4133d) {
            case 0:
                return this.f4134e.size();
            case 1:
                List list = this.f4134e;
                if (list == null) {
                    return 0;
                }
                return list.size();
            default:
                return ((ArrayList) this.f4134e).size();
        }
    }

    @Override // b4.f0
    public long b(int i10) {
        switch (this.f4133d) {
            case 2:
                return i10;
            default:
                return super.b(i10);
        }
    }

    @Override // b4.f0
    public final void g(f1 f1Var, int i10) {
        switch (this.f4133d) {
            case 0:
                l lVar = (l) f1Var;
                lVar.f4131u.setText(((e5.m) this.f4134e.get(i10)).f4618b);
                lVar.f2232a.setOnClickListener(new androidx.mediarouter.app.x(this, 1, lVar));
                break;
            case 1:
                o oVar = (o) f1Var;
                f.j jVar = (f.j) this.f4135f;
                CatchUpEpg catchUpEpg = (CatchUpEpg) this.f4134e.get(i10);
                TextView textView = oVar.f4148u;
                TextView textView2 = oVar.f4149v;
                textView.setText(k5.j.e(catchUpEpg.getTitle()));
                try {
                    textView2.setText(k5.j.c(catchUpEpg.getStart_timestamp() * 1000, jVar) + " ~ " + k5.j.c(catchUpEpg.getStop_timestamp() * 1000, jVar));
                } catch (Exception unused) {
                }
                if (i10 == 0) {
                    textView.setTextColor(jVar.getColor(R.color.yellow));
                    textView2.setTextColor(jVar.getColor(R.color.yellow));
                    oVar.f2232a.requestFocus();
                    break;
                } else {
                    textView.setTextColor(jVar.getColor(R.color.white));
                    textView2.setTextColor(jVar.getColor(R.color.white));
                    break;
                }
            default:
                d0 d0Var = (d0) f1Var;
                d0Var.f4084u.setText(((CategoryModel) ((ArrayList) this.f4134e).get(i10)).getName());
                View view = d0Var.f2232a;
                view.setOnFocusChangeListener(new v(d0Var, 3));
                view.setOnClickListener(new u(this, i10, 3));
                if (i10 == 0) {
                    view.requestFocus();
                    break;
                }
                break;
        }
    }

    @Override // b4.f0
    public final f1 h(ViewGroup viewGroup, int i10) {
        switch (this.f4133d) {
            case 0:
                View h10 = android.support.v4.media.d.h(viewGroup, R.layout.item_connect, viewGroup, false);
                l lVar = new l(h10);
                lVar.f4131u = (TextView) h10.findViewById(R.id.txt_name);
                return lVar;
            case 1:
                View h11 = android.support.v4.media.d.h(viewGroup, R.layout.item_epg, viewGroup, false);
                o oVar = new o(h11);
                oVar.f4149v = (TextView) h11.findViewById(R.id.txt_time);
                oVar.f4148u = (TextView) h11.findViewById(R.id.txt_name);
                return oVar;
            default:
                View h12 = android.support.v4.media.d.h(viewGroup, R.layout.item_my_group, viewGroup, false);
                d0 d0Var = new d0(h12);
                d0Var.f4084u = (TextView) h12.findViewById(R.id.txt_name);
                return d0Var;
        }
    }

    public void l(List list) {
        this.f4134e = list;
        d();
    }

    public m(ArrayList arrayList, ya.q qVar) {
        this.f4134e = arrayList;
        this.f4135f = qVar;
    }

    public m(f.j jVar, ArrayList arrayList) {
        this.f4135f = jVar;
        this.f4134e = arrayList;
    }
}
