package h5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.models.WordModels;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class r extends androidx.fragment.app.o {
    public int A0;
    public c5.n B0;
    public RecyclerView C0;
    public int D0;
    public TextView E0;
    public TextView F0;
    public WordModels G0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public d5.r f5647x0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageButton f5648y0;

    /* renamed from: z0, reason: collision with root package name */
    public List f5649z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_episode, viewGroup, false);
        this.G0 = app.shamel.tv.helper.a.k(i());
        this.E0 = (TextView) inflate.findViewById(R.id.str_episodes);
        this.F0 = (TextView) inflate.findViewById(R.id.txt_see_all);
        this.f5648y0 = (ImageButton) inflate.findViewById(R.id.btn_close);
        this.C0 = (RecyclerView) inflate.findViewById(R.id.recycler_episodes);
        this.E0.setText(this.G0.getStr_more_episodes());
        this.F0.setText(this.G0.getSee_all());
        this.f5648y0.setOnTouchListener(new q(0, this));
        this.F0.setOnTouchListener(new q(1, this));
        Context i10 = i();
        List list = this.f5649z0;
        int i11 = this.D0;
        int i12 = this.A0;
        int i13 = 1;
        l lVar = new l(this, i13);
        d5.r rVar = new d5.r(i13);
        rVar.f4177i = i10;
        rVar.f4174e = list;
        rVar.f4175f = i11;
        rVar.g = i12;
        rVar.f4176h = lVar;
        this.f5647x0 = rVar;
        this.C0.setLayoutManager(new LinearLayoutManager(0));
        this.C0.setHasFixedSize(true);
        this.C0.setAdapter(this.f5647x0);
        this.C0.e0(this.A0);
        this.C0.requestFocus();
        this.f762s0.setOnKeyListener(new e(this, 2));
        return inflate;
    }
}
