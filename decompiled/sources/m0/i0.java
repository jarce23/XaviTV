package m0;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i0 {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static f b(View view, f fVar) {
        ContentInfo s10 = fVar.f8651a.s();
        Objects.requireNonNull(s10);
        ContentInfo performReceiveContent = view.performReceiveContent(s10);
        if (performReceiveContent == null) {
            return null;
        }
        return performReceiveContent == s10 ? fVar : new f(new h5.i(performReceiveContent));
    }
}
