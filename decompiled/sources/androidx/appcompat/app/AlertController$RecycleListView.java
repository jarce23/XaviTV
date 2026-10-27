package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import e.a;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AlertController$RecycleListView extends ListView {

    /* renamed from: o, reason: collision with root package name */
    public final int f368o;

    /* renamed from: p, reason: collision with root package name */
    public final int f369p;

    public AlertController$RecycleListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.f4376t);
        this.f369p = obtainStyledAttributes.getDimensionPixelOffset(0, -1);
        this.f368o = obtainStyledAttributes.getDimensionPixelOffset(1, -1);
    }
}
