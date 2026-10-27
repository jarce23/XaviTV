package u3;

import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f12412u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f12413v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f12414w;

    /* renamed from: x, reason: collision with root package name */
    public final /* synthetic */ o f12415x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(o oVar, View view) {
        super(view);
        this.f12415x = oVar;
        if (Build.VERSION.SDK_INT < 26) {
            view.setFocusable(true);
        }
        this.f12412u = (TextView) view.findViewById(R.id.exo_main_text);
        this.f12413v = (TextView) view.findViewById(R.id.exo_sub_text);
        this.f12414w = (ImageView) view.findViewById(R.id.exo_icon);
        view.setOnClickListener(new androidx.mediarouter.app.b(8, this));
    }
}
