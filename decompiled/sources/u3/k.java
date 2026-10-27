package u3;

import android.os.Build;
import android.view.View;
import android.widget.TextView;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f12416u;

    /* renamed from: v, reason: collision with root package name */
    public final View f12417v;

    public k(View view) {
        super(view);
        if (Build.VERSION.SDK_INT < 26) {
            view.setFocusable(true);
        }
        this.f12416u = (TextView) view.findViewById(R.id.exo_text);
        this.f12417v = view.findViewById(R.id.exo_check);
    }
}
