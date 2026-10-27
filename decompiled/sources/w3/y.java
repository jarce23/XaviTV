package w3;

import android.content.ComponentName;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public final n f13064a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13065b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13066c;

    /* renamed from: d, reason: collision with root package name */
    public final p4.p f13067d;

    /* renamed from: e, reason: collision with root package name */
    public ea.a f13068e;

    public y(n nVar, boolean z10) {
        this.f13064a = nVar;
        this.f13067d = nVar.f12968b;
        this.f13066c = z10;
    }

    public final z a(String str) {
        ArrayList arrayList = this.f13065b;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (((z) arrayList.get(i10)).f13070b.equals(str)) {
                return (z) arrayList.get(i10);
            }
        }
        return null;
    }

    public final String toString() {
        return "MediaRouter.RouteProviderInfo{ packageName=" + ((ComponentName) this.f13067d.f9953p).getPackageName() + " }";
    }
}
