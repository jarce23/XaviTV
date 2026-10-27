package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.i0;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements f4.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f292a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f293b;

    public /* synthetic */ f(int i10, Object obj) {
        this.f292a = i10;
        this.f293b = obj;
    }

    @Override // f4.c
    public final Bundle a() {
        switch (this.f292a) {
            case 0:
                f.j jVar = (f.j) this.f293b;
                Bundle bundle = new Bundle();
                i iVar = jVar.f317y;
                iVar.getClass();
                HashMap hashMap = iVar.f342b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(hashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(hashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(iVar.f344d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) iVar.g.clone());
                return bundle;
            case 1:
                f.j jVar2 = (f.j) this.f293b;
                while (f.j.o(jVar2.n())) {
                }
                jVar2.H.d(androidx.lifecycle.l.ON_STOP);
                return new Bundle();
            default:
                return ((i0) this.f293b).S();
        }
    }
}
