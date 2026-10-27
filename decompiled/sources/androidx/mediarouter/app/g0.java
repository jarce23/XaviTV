package androidx.mediarouter.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g0 extends f1 {
    public final /* synthetic */ l0 A;

    /* renamed from: u, reason: collision with root package name */
    public final View f1308u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f1309v;

    /* renamed from: w, reason: collision with root package name */
    public final ProgressBar f1310w;

    /* renamed from: x, reason: collision with root package name */
    public final TextView f1311x;

    /* renamed from: y, reason: collision with root package name */
    public final float f1312y;

    /* renamed from: z, reason: collision with root package name */
    public w3.z f1313z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(l0 l0Var, View view) {
        super(view);
        this.A = l0Var;
        this.f1308u = view;
        this.f1309v = (ImageView) view.findViewById(R.id.mr_cast_group_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_cast_group_progress_bar);
        this.f1310w = progressBar;
        this.f1311x = (TextView) view.findViewById(R.id.mr_cast_group_name);
        n0 n0Var = l0Var.f1340m;
        this.f1312y = i7.e.k(n0Var.B);
        i7.e.y(n0Var.B, progressBar);
    }
}
