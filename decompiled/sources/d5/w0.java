package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f4209u;

    /* renamed from: v, reason: collision with root package name */
    public final RoundedImageView f4210v;

    /* renamed from: w, reason: collision with root package name */
    public final RoundedImageView f4211w;

    /* renamed from: x, reason: collision with root package name */
    public final TextView f4212x;

    public w0(View view) {
        super(view);
        this.f4211w = (RoundedImageView) view.findViewById(R.id.image_vod);
        this.f4210v = (RoundedImageView) view.findViewById(R.id.image_logo);
        this.f4212x = (TextView) view.findViewById(R.id.txt_name);
        this.f4209u = (ImageView) view.findViewById(R.id.image_fav);
    }
}
