package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class z implements androidx.activity.result.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f850o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ i0 f851p;

    public /* synthetic */ z(j0 j0Var, int i10) {
        this.f850o = i10;
        this.f851p = j0Var;
    }

    @Override // androidx.activity.result.b
    public final void c(Object obj) {
        switch (this.f850o) {
            case 0:
                Map map = (Map) obj;
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
                }
                i0 i0Var = this.f851p;
                f0 f0Var = (f0) i0Var.C.pollFirst();
                if (f0Var == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    String str = f0Var.f678o;
                    if (i0Var.f691c.i(str) == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                        break;
                    }
                }
                break;
            case 1:
                androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
                i0 i0Var2 = this.f851p;
                f0 f0Var2 = (f0) i0Var2.C.pollLast();
                if (f0Var2 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                } else {
                    String str2 = f0Var2.f678o;
                    int i11 = f0Var2.f679p;
                    s i12 = i0Var2.f691c.i(str2);
                    if (i12 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                        break;
                    } else {
                        i12.s(i11, aVar.f330o, aVar.f331p);
                        break;
                    }
                }
            default:
                androidx.activity.result.a aVar2 = (androidx.activity.result.a) obj;
                i0 i0Var3 = this.f851p;
                f0 f0Var3 = (f0) i0Var3.C.pollFirst();
                if (f0Var3 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                } else {
                    String str3 = f0Var3.f678o;
                    int i13 = f0Var3.f679p;
                    s i14 = i0Var3.f691c.i(str3);
                    if (i14 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                        break;
                    } else {
                        i14.s(i13, aVar2.f330o, aVar2.f331p);
                        break;
                    }
                }
        }
    }
}
