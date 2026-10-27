package androidx.mediarouter.app;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final View f1426u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f1427v;

    /* renamed from: w, reason: collision with root package name */
    public final ProgressBar f1428w;

    /* renamed from: x, reason: collision with root package name */
    public final TextView f1429x;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ z f1430y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(z zVar, View view) {
        super(view);
        this.f1430y = zVar;
        this.f1426u = view;
        this.f1427v = (ImageView) view.findViewById(R.id.mr_picker_route_icon);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.mr_picker_route_progress_bar);
        this.f1428w = progressBar;
        this.f1429x = (TextView) view.findViewById(R.id.mr_picker_route_name);
        i7.e.y(zVar.f1436j.f1267v, progressBar);
    }
}
