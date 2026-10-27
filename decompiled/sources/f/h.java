package f;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements f4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4788a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4789b;

    public h(f4.d dVar) {
        this.f4788a = 1;
        this.f4789b = new LinkedHashSet();
        dVar.e("androidx.savedstate.Restarter", this);
    }

    @Override // f4.c
    public final Bundle a() {
        switch (this.f4788a) {
            case 0:
                Bundle bundle = new Bundle();
                ((j) this.f4789b).m().getClass();
                return bundle;
            default:
                Bundle bundle2 = new Bundle();
                bundle2.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.f4789b));
                return bundle2;
        }
    }

    public h(j jVar) {
        this.f4788a = 0;
        this.f4789b = jVar;
    }
}
