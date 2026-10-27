package gb;

import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache;
import rb.i0;
import rb.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements ya.l {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5464o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f5465p;

    public /* synthetic */ f(int i10, Object obj) {
        this.f5464o = i10;
        this.f5465p = obj;
    }

    @Override // ya.l
    public final Object invoke(Object obj) {
        la.i newJournalWriter$lambda$0;
        switch (this.f5464o) {
            case 0:
                return ((g) this.f5465p).g(((Integer) obj).intValue());
            case 1:
                return obj == ((ma.a) this.f5465p) ? "(this Collection)" : String.valueOf(obj);
            case 2:
                newJournalWriter$lambda$0 = DiskLruCache.newJournalWriter$lambda$0((DiskLruCache) this.f5465p, (IOException) obj);
                return newJournalWriter$lambda$0;
            default:
                v vVar = (v) this.f5465p;
                i0 i0Var = (i0) obj;
                za.h.e("it", i0Var);
                return vVar.onPathResult(i0Var, "listRecursively");
        }
    }
}
