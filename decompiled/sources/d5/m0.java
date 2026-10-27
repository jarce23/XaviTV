package d5;

import android.view.View;
import android.widget.TextView;
import b4.f1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m0 extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final TextView f4136u;

    /* renamed from: v, reason: collision with root package name */
    public final TextView f4137v;

    public m0(View view) {
        super(view);
        this.f4137v = (TextView) view.findViewById(R.id.txt_name);
        this.f4136u = (TextView) view.findViewById(R.id.txt_count);
    }
}
