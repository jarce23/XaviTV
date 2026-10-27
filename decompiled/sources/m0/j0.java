package m0;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f8676d = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public WeakHashMap f8677a;

    /* renamed from: b, reason: collision with root package name */
    public SparseArray f8678b;

    /* renamed from: c, reason: collision with root package name */
    public WeakReference f8679c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.f8677a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View a10 = a(viewGroup.getChildAt(childCount));
                if (a10 != null) {
                    return a10;
                }
            }
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return null;
        }
        throw android.support.v4.media.d.k(size, arrayList);
    }
}
