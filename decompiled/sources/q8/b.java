package q8;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import b4.l0;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends l0 {

    /* renamed from: a, reason: collision with root package name */
    public final Paint f10364a;

    /* renamed from: b, reason: collision with root package name */
    public final List f10365b;

    public b() {
        Paint paint = new Paint();
        this.f10364a = paint;
        this.f10365b = Collections.unmodifiableList(new ArrayList());
        paint.setStrokeWidth(5.0f);
        paint.setColor(-65281);
    }

    @Override // b4.l0
    public final void b(Canvas canvas, RecyclerView recyclerView) {
        Canvas canvas2;
        float dimension = recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width);
        Paint paint = this.f10364a;
        paint.setStrokeWidth(dimension);
        Iterator it = this.f10365b.iterator();
        while (it.hasNext()) {
            ((d) it.next()).getClass();
            ThreadLocal threadLocal = e0.a.f4383a;
            float f10 = 1.0f - 0.0f;
            paint.setColor(Color.argb((int) ((Color.alpha(-16776961) * 0.0f) + (Color.alpha(-65281) * f10)), (int) ((Color.red(-16776961) * 0.0f) + (Color.red(-65281) * f10)), (int) ((Color.green(-16776961) * 0.0f) + (Color.green(-65281) * f10)), (int) ((Color.blue(-16776961) * 0.0f) + (Color.blue(-65281) * f10))));
            if (((CarouselLayoutManager) recyclerView.getLayoutManager()).T0()) {
                canvas2 = canvas;
                canvas2.drawLine(0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3723q.i(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3723q.e(), paint);
            } else {
                canvas2 = canvas;
                canvas2.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).f3723q.f(), 0.0f, ((CarouselLayoutManager) recyclerView.getLayoutManager()).f3723q.g(), 0.0f, paint);
            }
            canvas = canvas2;
        }
    }
}
