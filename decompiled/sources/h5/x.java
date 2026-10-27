package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class x extends androidx.fragment.app.o {
    public int A0 = 0;
    public d B0;
    public d5.m C0;
    public TextView D0;
    public WordModels E0;

    /* renamed from: x0, reason: collision with root package name */
    public ImageButton f5675x0;

    /* renamed from: y0, reason: collision with root package name */
    public ArrayList f5676y0;

    /* renamed from: z0, reason: collision with root package name */
    public LiveVerticalGridView f5677z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_group, viewGroup);
        this.E0 = app.shamel.tv.helper.a.k(i());
        this.f5675x0 = (ImageButton) inflate.findViewById(R.id.btn_back);
        this.D0 = (TextView) inflate.findViewById(R.id.txt_add);
        this.f5675x0.setOnClickListener(new androidx.leanback.widget.g0(10, this));
        this.f5677z0 = (LiveVerticalGridView) inflate.findViewById(R.id.category_list);
        this.D0.setText(this.E0.getStr_my_group());
        ArrayList arrayList = this.f5676y0;
        app.shamel.tv.activities.f fVar = new app.shamel.tv.activities.f(8, this);
        d5.m mVar = new d5.m();
        mVar.f4134e = arrayList;
        mVar.f4135f = fVar;
        this.C0 = mVar;
        if (app.shamel.tv.helper.a.l(i())) {
            this.f5677z0.setSelectedPosition(this.A0);
            this.f5677z0.setNumColumns(1);
            this.f5677z0.setLoop(false);
            this.f5677z0.setPreserveFocusAfterLayout(true);
            this.f5677z0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(24, new View[]{null}));
        } else {
            this.f5677z0.setLayoutManager(new LinearLayoutManager(1));
        }
        this.f5677z0.setAdapter(this.C0);
        return inflate;
    }
}
