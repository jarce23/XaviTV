package h5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import app.shamel.tv.models.WordModels;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class k0 extends androidx.fragment.app.o {
    public TextView A0;
    public TextView B0;
    public WordModels C0 = new WordModels();
    public String D0 = _UrlKt.FRAGMENT_ENCODE_SET;

    /* renamed from: x0, reason: collision with root package name */
    public Button f5617x0;

    /* renamed from: y0, reason: collision with root package name */
    public Context f5618y0;

    /* renamed from: z0, reason: collision with root package name */
    public j0 f5619z0;

    @Override // androidx.fragment.app.o, androidx.fragment.app.s
    public final void u(Bundle bundle) {
        super.u(bundle);
        L();
    }

    @Override // androidx.fragment.app.s
    public final View v(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_no_connection, viewGroup, false);
        this.C0 = app.shamel.tv.helper.a.k(this.f5618y0);
        this.B0 = (TextView) inflate.findViewById(R.id.txt_no_connection);
        this.A0 = (TextView) inflate.findViewById(R.id.txt_check_network);
        this.B0.setText(this.C0.getNo_connection());
        this.A0.setText(this.D0);
        Button button = (Button) inflate.findViewById(R.id.btn_retry);
        this.f5617x0 = button;
        button.setText(this.C0.getRetry());
        this.f5617x0.setOnClickListener(new androidx.leanback.widget.g0(13, this));
        this.f5617x0.requestFocus();
        this.f762s0.setOnKeyListener(new e(this, 7));
        return inflate;
    }
}
