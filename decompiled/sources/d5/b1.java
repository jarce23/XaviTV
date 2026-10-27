package d5;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import b4.f1;
import com.makeramen.roundedimageview.RoundedImageView;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b1 extends f1 {

    /* renamed from: u, reason: collision with root package name */
    public final ImageView f4071u;

    /* renamed from: v, reason: collision with root package name */
    public final RoundedImageView f4072v;

    /* renamed from: w, reason: collision with root package name */
    public final RoundedImageView f4073w;

    /* renamed from: x, reason: collision with root package name */
    public final ProgressBar f4074x;

    /* renamed from: y, reason: collision with root package name */
    public final TextView f4075y;

    public b1(View view) {
        super(view);
        this.f4073w = (RoundedImageView) view.findViewById(R.id.image_vod);
        this.f4072v = (RoundedImageView) view.findViewById(R.id.image_logo);
        this.f4075y = (TextView) view.findViewById(R.id.txt_name);
        this.f4071u = (ImageView) view.findViewById(R.id.image_fav);
        this.f4074x = (ProgressBar) view.findViewById(R.id.seekBar);
    }
}
