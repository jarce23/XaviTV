package h5;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import app.shamel.tv.models.WordModels;
import app.shamel.tv.view.LiveVerticalGridView;
import com.google.gson.Gson;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t0 extends androidx.fragment.app.o {
    public app.shamel.tv.helper.r A0;
    public LiveVerticalGridView B0;
    public String[] C0;
    public TextView D0;
    public TextView E0;
    public int F0 = 0;
    public boolean G0 = true;
    public WordModels H0 = new WordModels();

    /* renamed from: x0, reason: collision with root package name */
    public String[] f5658x0;

    /* renamed from: y0, reason: collision with root package name */
    public Context f5659y0;

    /* renamed from: z0, reason: collision with root package name */
    public i f5660z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10 = 0;
        View inflate = layoutInflater.inflate(R.layout.fragment_select_color, viewGroup, false);
        this.A0 = new app.shamel.tv.helper.r(this.f5659y0);
        this.H0 = app.shamel.tv.helper.a.k(this.f5659y0);
        this.D0 = (TextView) inflate.findViewById(R.id.txt_header);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_subtitle);
        this.B0 = (LiveVerticalGridView) inflate.findViewById(R.id.recycler_colors);
        if (app.shamel.tv.helper.a.l(this.f5659y0)) {
            this.B0.setNumColumns(5);
            this.B0.setLoop(false);
            this.B0.setPreserveFocusAfterLayout(true);
            this.B0.setOnChildViewHolderSelectedListener(new app.shamel.tv.activities.e(27, new View[]{null}));
        } else {
            this.B0.setLayoutManager(new GridLayoutManager(5));
            this.B0.setHasFixedSize(true);
        }
        if (this.G0) {
            this.D0.setText(this.H0.getSubtitel_color());
        } else {
            this.D0.setText(this.H0.getSubtitel_background());
        }
        this.C0 = l().getStringArray(R.array.subtitle_colors);
        String[] stringArray = l().getStringArray(R.array.subtitle_background_colors);
        this.f5658x0 = stringArray;
        if (this.G0) {
            Context context = this.f5659y0;
            String[] strArr = this.C0;
            new Gson();
            String str = "#ffffff";
            try {
                str = context.getSharedPreferences("PREF", 0).getString("subtitle_color", "#ffffff");
            } catch (Exception unused) {
            }
            int i11 = 0;
            while (true) {
                if (i11 >= strArr.length) {
                    break;
                }
                if (str.equalsIgnoreCase(strArr[i11])) {
                    i10 = i11;
                    break;
                }
                i11++;
            }
            this.F0 = i10;
        } else {
            Context context2 = this.f5659y0;
            new Gson();
            String str2 = "#00ffffff";
            try {
                str2 = context2.getSharedPreferences("PREF", 0).getString("subtitle_bg_color", "#00ffffff");
            } catch (Exception unused2) {
            }
            int i12 = 0;
            while (true) {
                if (i12 >= stringArray.length) {
                    break;
                }
                if (str2.equalsIgnoreCase(stringArray[i12])) {
                    i10 = i12;
                    break;
                }
                i12++;
            }
            this.F0 = i10;
        }
        this.E0.setBackgroundColor(Color.parseColor(this.A0.C()));
        this.E0.setTextColor(Color.parseColor(this.A0.D()));
        this.E0.setTextSize(3, this.A0.F());
        LiveVerticalGridView liveVerticalGridView = this.B0;
        String[] strArr2 = this.G0 ? this.C0 : this.f5658x0;
        int i13 = this.F0;
        l lVar = new l(this, 6);
        d5.y yVar = new d5.y(3);
        yVar.g = strArr2;
        yVar.f4223f = i13;
        yVar.f4222e = lVar;
        liveVerticalGridView.setAdapter(yVar);
        this.f762s0.setOnKeyListener(new e(this, 10));
        return inflate;
    }
}
