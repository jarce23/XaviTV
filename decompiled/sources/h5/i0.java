package h5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.makeramen.roundedimageview.RoundedImageView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i0 extends androidx.fragment.app.o {
    public String A0;
    public String B0;
    public String C0;
    public TextView D0;
    public TextView E0;
    public TextView F0;

    /* renamed from: x0, reason: collision with root package name */
    public String f5611x0;

    /* renamed from: y0, reason: collision with root package name */
    public ImageView f5612y0;

    /* renamed from: z0, reason: collision with root package name */
    public RoundedImageView f5613z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.dlg_movie_info, viewGroup, false);
        this.E0 = (TextView) inflate.findViewById(R.id.txt_name);
        this.D0 = (TextView) inflate.findViewById(R.id.txt_description);
        this.F0 = (TextView) inflate.findViewById(R.id.txt_resolution);
        this.f5612y0 = (ImageView) inflate.findViewById(R.id.image_logo);
        this.f5613z0 = (RoundedImageView) inflate.findViewById(R.id.image_movie);
        inflate.findViewById(R.id.view_click).setOnClickListener(new androidx.leanback.widget.g0(12, this));
        this.E0.setText(this.B0);
        this.D0.setText(this.f5611x0);
        this.F0.setText(this.C0);
        com.bumptech.glide.f.n(i(), this.f5613z0, this.A0, this.f5612y0);
        return inflate;
    }
}
