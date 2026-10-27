package w3;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o {

    /* renamed from: c, reason: collision with root package name */
    public static final o f12981c = new o(new Bundle(), null);

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f12982a;

    /* renamed from: b, reason: collision with root package name */
    public List f12983b;

    public o(Bundle bundle, ArrayList arrayList) {
        this.f12982a = bundle;
        this.f12983b = arrayList;
    }

    public static o b(Bundle bundle) {
        if (bundle != null) {
            return new o(bundle, null);
        }
        return null;
    }

    public final void a() {
        if (this.f12983b == null) {
            ArrayList<String> stringArrayList = this.f12982a.getStringArrayList("controlCategories");
            this.f12983b = stringArrayList;
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                this.f12983b = Collections.EMPTY_LIST;
            }
        }
    }

    public final ArrayList c() {
        a();
        return new ArrayList(this.f12983b);
    }

    public final boolean d() {
        a();
        return this.f12983b.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        a();
        oVar.a();
        return this.f12983b.equals(oVar.f12983b);
    }

    public final int hashCode() {
        a();
        return this.f12983b.hashCode();
    }

    public final String toString() {
        return "MediaRouteSelector{ controlCategories=" + Arrays.toString(c().toArray()) + " }";
    }
}
