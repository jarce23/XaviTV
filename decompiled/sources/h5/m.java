package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.activities.SettingActivity;
import app.shamel.tv.models.ResumeModel;
import app.shamel.tv.models.ResumeSeriesModel;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class m extends androidx.fragment.app.o implements View.OnClickListener {
    public Button A0;
    public boolean[] B0;
    public SettingActivity C0;
    public int D0;
    public String[] E0;
    public RecyclerView F0;
    public app.shamel.tv.helper.r G0;
    public TextView H0;
    public List I0 = new ArrayList();
    public List J0 = new ArrayList();
    public ArrayList K0 = new ArrayList();
    public WordModels L0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public d5.k f5624x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5625y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5626z0;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ResumeSeriesModel resumeSeriesModel;
        ResumeModel resumeModel;
        int id = view.getId();
        int i10 = 0;
        if (id == R.id.btn_all) {
            if (this.K0.size() < this.E0.length) {
                this.f5624x0.l(true);
                this.K0 = new ArrayList();
                return;
            } else {
                this.f5624x0.l(false);
                this.K0.addAll(Arrays.asList(this.E0));
                return;
            }
        }
        if (id == R.id.btn_cancel) {
            J(false, false);
            return;
        }
        if (id != R.id.btn_ok) {
            return;
        }
        J(false, false);
        int i11 = this.D0;
        if (i11 != 1) {
            if (i11 != 2) {
                return;
            }
            app.shamel.tv.helper.r rVar = this.G0;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = this.K0;
            int size = arrayList2.size();
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                String str = (String) obj;
                Iterator it = this.J0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        resumeSeriesModel = (ResumeSeriesModel) it.next();
                        if (str.equalsIgnoreCase(resumeSeriesModel.getName())) {
                            break;
                        }
                    }
                }
                arrayList.add(resumeSeriesModel);
            }
            rVar.W(arrayList);
            Iterator it2 = this.J0.iterator();
            while (it2.hasNext()) {
                a6.n.K().m(((ResumeSeriesModel) it2.next()).getName(), false, 0, 0, new d9.f(23));
            }
            for (ResumeSeriesModel resumeSeriesModel2 : this.G0.w()) {
                a6.n.K().m(resumeSeriesModel2.getName(), true, resumeSeriesModel2.getSeason_pos(), resumeSeriesModel2.getEpisode_pos(), new d9.f(24));
            }
            return;
        }
        app.shamel.tv.helper.r rVar2 = this.G0;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = this.K0;
        int size2 = arrayList4.size();
        while (i10 < size2) {
            Object obj2 = arrayList4.get(i10);
            i10++;
            String str2 = (String) obj2;
            Iterator it3 = this.I0.iterator();
            while (true) {
                if (it3.hasNext()) {
                    resumeModel = (ResumeModel) it3.next();
                    if (str2.equalsIgnoreCase(resumeModel.getName())) {
                        break;
                    }
                }
            }
            arrayList3.add(resumeModel);
        }
        rVar2.X(arrayList3);
        for (ResumeModel resumeModel2 : this.I0) {
            a6.n.K().d(resumeModel2.getName(), resumeModel2.getTmdb_id(), false, 0L, 0, new n7.i(22));
        }
        List<ResumeModel> x6 = this.G0.x();
        if (x6.size() > 0) {
            for (ResumeModel resumeModel3 : x6) {
                a6.n.K().d(resumeModel3.getName(), resumeModel3.getTmdb_id(), true, resumeModel3.getLast_position(), resumeModel3.getPro(), new n7.i(23));
            }
        }
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10 = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_hide_categories, viewGroup, false);
        this.H0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.F0 = (RecyclerView) inflate.findViewById(R.id.recyclerGroups);
        this.A0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5626z0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.f5625y0 = (Button) inflate.findViewById(R.id.btn_all);
        this.A0.setOnClickListener(this);
        this.f5626z0.setOnClickListener(this);
        this.f5625y0.setOnClickListener(this);
        this.G0 = new app.shamel.tv.helper.r(this.C0);
        WordModels k10 = app.shamel.tv.helper.a.k(this.C0);
        this.L0 = k10;
        int i11 = this.D0;
        if (i11 == 0) {
            this.H0.setText(k10.getClear_channel_header());
        } else if (i11 == 1) {
            this.H0.setText(k10.getClear_movie_header());
        } else if (i11 == 2) {
            this.H0.setText(k10.getClear_series_header());
        }
        this.A0.setText(this.L0.getOk());
        this.f5625y0.setText(this.L0.getSelect_all());
        this.f5626z0.setText(this.L0.getCancel());
        int i12 = this.D0;
        if (i12 == 1) {
            this.I0 = new ArrayList();
            this.K0 = new ArrayList();
            List x6 = this.G0.x();
            this.I0 = x6;
            this.E0 = new String[x6.size()];
            this.B0 = new boolean[this.I0.size()];
            while (i10 < this.I0.size()) {
                this.K0.add(((ResumeModel) this.I0.get(i10)).getName());
                this.E0[i10] = ((ResumeModel) this.I0.get(i10)).getName();
                i10++;
            }
        } else if (i12 == 2) {
            this.J0 = new ArrayList();
            this.K0 = new ArrayList();
            List w10 = this.G0.w();
            this.J0 = w10;
            this.E0 = new String[w10.size()];
            this.B0 = new boolean[this.J0.size()];
            while (i10 < this.J0.size()) {
                this.K0.add(((ResumeSeriesModel) this.J0.get(i10)).getName());
                this.E0[i10] = ((ResumeSeriesModel) this.J0.get(i10)).getName();
                i10++;
            }
        }
        this.f5624x0 = new d5.k(this.E0, this.B0, new l(this, 0));
        this.F0.setLayoutManager(new LinearLayoutManager(1));
        this.F0.setHasFixedSize(true);
        this.F0.setAdapter(this.f5624x0);
        return inflate;
    }
}
