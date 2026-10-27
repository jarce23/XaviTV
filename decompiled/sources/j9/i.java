package j9;

import android.os.Bundle;
import com.google.android.play.core.assetpacks.bs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f7303e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ k f7304f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(k kVar, i8.d dVar, int i10) {
        super(kVar, dVar);
        this.f7303e = i10;
        this.f7304f = kVar;
    }

    @Override // j9.g, k9.k
    public void C(Bundle bundle, Bundle bundle2) {
        switch (this.f7303e) {
            case 1:
                super.C(bundle, bundle2);
                k kVar = this.f7304f;
                if (!kVar.f7325f.compareAndSet(true, false)) {
                    k.g.i("Expected keepingAlive to be true, but was false.", new Object[0]);
                }
                if (bundle.getBoolean("keep_alive")) {
                    kVar.f();
                    break;
                }
                break;
            default:
                super.C(bundle, bundle2);
                break;
        }
    }

    @Override // j9.g, k9.k
    public void J(Bundle bundle) {
        switch (this.f7303e) {
            case 1:
                k9.q qVar = this.f7304f.f7324e;
                i8.d dVar = this.f7280c;
                qVar.d(dVar);
                int i10 = bundle.getInt("error_code");
                k.g.f("onError(%d)", Integer.valueOf(i10));
                dVar.c(new a(i10));
                break;
            default:
                super.J(bundle);
                break;
        }
    }

    @Override // j9.g, k9.k
    public void S(List list) {
        switch (this.f7303e) {
            case 0:
                super.S(list);
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    Bundle bundle = (Bundle) it.next();
                    k kVar = this.f7304f;
                    n0 n0Var = kVar.f7321b;
                    i1 i1Var = kVar.f7322c;
                    d9.f fVar = new d9.f(28);
                    ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
                    HashMap hashMap = new HashMap();
                    int size = stringArrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        String str = stringArrayList.get(i10);
                        hashMap.put(str, bs.a(bundle, str, n0Var, i1Var, fVar));
                    }
                    bundle.getLong("total_bytes_to_download");
                    bs bsVar = (bs) hashMap.values().iterator().next();
                    if (bsVar == null) {
                        k.g.f("onGetSessionStates: Bundle contained no pack.", new Object[0]);
                    }
                    int i11 = bsVar.f3908b;
                    if (i11 == 1 || i11 == 7 || i11 == 2 || i11 == 9 || i11 == 3) {
                        arrayList.add(bsVar.f3907a);
                    }
                }
                this.f7280c.d(arrayList);
                break;
            default:
                super.S(list);
                break;
        }
    }
}
