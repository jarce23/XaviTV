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
import com.google.gson.Gson;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class r0 extends androidx.fragment.app.o {
    public app.shamel.tv.activities.d A0;
    public TextView B0;
    public WordModels C0;

    /* renamed from: x0, reason: collision with root package name */
    public ImageButton f5650x0;

    /* renamed from: y0, reason: collision with root package name */
    public RecyclerView f5651y0;

    /* renamed from: z0, reason: collision with root package name */
    public ArrayList f5652z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_rename, viewGroup);
        this.f5651y0 = (RecyclerView) inflate.findViewById(R.id.recycler_view);
        this.f5650x0 = (ImageButton) inflate.findViewById(R.id.image_back);
        this.B0 = (TextView) inflate.findViewById(R.id.txt_name);
        Context i10 = i();
        new Gson();
        i10.getSharedPreferences("PREF", 0);
        WordModels k10 = app.shamel.tv.helper.a.k(i());
        this.C0 = k10;
        this.B0.setText(k10.getChange_my_group());
        ArrayList arrayList = new ArrayList();
        this.f5652z0 = arrayList;
        arrayList.add(new e5.m(this.C0.getRename(), 0, 0));
        this.f5652z0.add(new e5.m(this.C0.getStr_delete(), 1, 1));
        this.f5651y0.setAdapter(new d5.m(this.f5652z0, new app.shamel.tv.activities.f(9, this)));
        RecyclerView recyclerView = this.f5651y0;
        E();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        this.f5650x0.setOnClickListener(new androidx.leanback.widget.g0(14, this));
        return inflate;
    }
}
