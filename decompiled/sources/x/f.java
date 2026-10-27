package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final float f13224a;

    /* renamed from: b, reason: collision with root package name */
    public final float f13225b;

    /* renamed from: c, reason: collision with root package name */
    public final float f13226c;

    /* renamed from: d, reason: collision with root package name */
    public final float f13227d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13228e;

    public f(Context context, XmlResourceParser xmlResourceParser) {
        this.f13224a = Float.NaN;
        this.f13225b = Float.NaN;
        this.f13226c = Float.NaN;
        this.f13227d = Float.NaN;
        this.f13228e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), p.f13325j);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.f13228e);
                this.f13228e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                if ("layout".equals(resourceTypeName)) {
                    new m().c((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == 1) {
                this.f13227d = obtainStyledAttributes.getDimension(index, this.f13227d);
            } else if (index == 2) {
                this.f13225b = obtainStyledAttributes.getDimension(index, this.f13225b);
            } else if (index == 3) {
                this.f13226c = obtainStyledAttributes.getDimension(index, this.f13226c);
            } else if (index == 4) {
                this.f13224a = obtainStyledAttributes.getDimension(index, this.f13224a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }
}
