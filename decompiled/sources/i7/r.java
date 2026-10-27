package i7;

import android.util.LruCache;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f6519a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(c cVar) {
        super(20);
        this.f6519a = cVar;
    }

    @Override // android.util.LruCache
    public final /* bridge */ /* synthetic */ void entryRemoved(boolean z10, Object obj, Object obj2, Object obj3) {
        ArrayList arrayList = this.f6519a.g;
        Integer num = (Integer) obj;
        if (z10) {
            r7.r.e(arrayList);
            arrayList.add(num);
        }
    }
}
