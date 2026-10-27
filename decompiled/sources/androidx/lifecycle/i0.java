package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements f4.c {

    /* renamed from: a, reason: collision with root package name */
    public final f4.d f1133a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1134b;

    /* renamed from: c, reason: collision with root package name */
    public Bundle f1135c;

    /* renamed from: d, reason: collision with root package name */
    public final la.g f1136d;

    public i0(f4.d dVar, o0 o0Var) {
        za.h.e("savedStateRegistry", dVar);
        this.f1133a = dVar;
        this.f1136d = new la.g(new h0(0, o0Var));
    }

    @Override // f4.c
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1135c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        Iterator it = ((j0) this.f1136d.a()).f1137c.entrySet().iterator();
        if (!it.hasNext()) {
            this.f1134b = false;
            return bundle;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getValue().getClass();
        throw new ClassCastException();
    }
}
