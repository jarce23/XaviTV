package h5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.models.WordModels;
import java.util.ArrayList;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class f0 extends androidx.fragment.app.o {
    public Context A0;
    public ArrayList B0;
    public e0 C0;
    public RecyclerView D0;
    public TextView E0;
    public WordModels F0 = new WordModels();
    public int G0 = 0;
    public String H0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: x0, reason: collision with root package name */
    public d5.y f5597x0;

    /* renamed from: y0, reason: collision with root package name */
    public Button f5598y0;

    /* renamed from: z0, reason: collision with root package name */
    public Button f5599z0;

    public static f0 N(Context context, ArrayList arrayList, int i10, String str, e0 e0Var) {
        f0 f0Var = new f0();
        f0Var.A0 = context;
        f0Var.B0 = arrayList;
        f0Var.G0 = i10;
        f0Var.C0 = e0Var;
        f0Var.H0 = str;
        return f0Var;
    }

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_live_sort, viewGroup, false);
        this.F0 = app.shamel.tv.helper.a.k(this.A0);
        this.f5599z0 = (Button) inflate.findViewById(R.id.btn_ok);
        this.f5598y0 = (Button) inflate.findViewById(R.id.btn_cancel);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.D0 = (RecyclerView) inflate.findViewById(R.id.recyclerGroups);
        this.f5599z0.setText(this.F0.getOk());
        this.f5598y0.setText(this.F0.getCancel());
        this.E0.setText(this.H0);
        this.f5597x0 = new d5.y(this.B0, this.G0, new l(this, 5));
        this.D0.setLayoutManager(new LinearLayoutManager(1));
        this.D0.setAdapter(this.f5597x0);
        this.D0.h0(this.G0);
        this.D0.requestFocus();
        this.f5599z0.setOnClickListener(new d0(this, 0));
        this.f5598y0.setOnClickListener(new d0(this, 1));
        return inflate;
    }
}
