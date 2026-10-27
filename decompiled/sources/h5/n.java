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
import eightbitlab.com.blurview.BlurView;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class n extends androidx.fragment.app.o {
    public ArrayList A0;
    public String B0;
    public RecyclerView C0;
    public app.shamel.tv.activities.q D0;
    public WordModels E0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public BlurView f5629x0;

    /* renamed from: y0, reason: collision with root package name */
    public Context f5630y0;

    /* renamed from: z0, reason: collision with root package name */
    public ImageButton f5631z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_connect, viewGroup);
        this.E0 = app.shamel.tv.helper.a.k(this.f5630y0);
        ArrayList arrayList = new ArrayList();
        this.A0 = arrayList;
        arrayList.add(new e5.m(this.E0.getConnect(), 0, 0));
        this.A0.add(new e5.m(this.E0.getEdit(), 1, 0));
        this.A0.add(new e5.m(this.E0.getDelete(), 2, 0));
        ((TextView) inflate.findViewById(R.id.txt_portal_name)).setText(this.B0);
        this.C0 = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f5631z0 = (ImageButton) inflate.findViewById(R.id.image_back);
        this.f5629x0 = (BlurView) inflate.findViewById(R.id.blur_view);
        androidx.fragment.app.u uVar = this.G;
        View decorView = (uVar == null ? null : uVar.f825s).getWindow().getDecorView();
        ViewGroup viewGroup2 = (ViewGroup) decorView.findViewById(android.R.id.content);
        BlurView blurView = this.f5629x0;
        z9.a aVar = new z9.a(blurView, viewGroup2, blurView.f4683p);
        blurView.f4682o.destroy();
        blurView.f4682o = aVar;
        aVar.f14160z = decorView.getBackground();
        aVar.f14150p = new io.realm.internal.p(i());
        aVar.f14149o = 20.0f;
        aVar.d(true);
        this.C0.setAdapter(new d5.m(this.A0, new app.shamel.tv.activities.f(7, this)));
        RecyclerView recyclerView = this.C0;
        E();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        this.f5631z0.setOnClickListener(new androidx.leanback.widget.g0(9, this));
        return inflate;
    }
}
