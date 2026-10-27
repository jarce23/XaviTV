package androidx.activity;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements c.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f294a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f.j f295b;

    public /* synthetic */ g(f.j jVar, int i10) {
        this.f294a = i10;
        this.f295b = jVar;
    }

    @Override // c.b
    public final void a() {
        switch (this.f294a) {
            case 0:
                f.j jVar = this.f295b;
                Bundle c10 = ((f4.d) jVar.f311s.f3099d).c("android:support:activity-result");
                if (c10 != null) {
                    i iVar = jVar.f317y;
                    HashMap hashMap = iVar.f342b;
                    HashMap hashMap2 = iVar.f341a;
                    Bundle bundle = iVar.g;
                    ArrayList<Integer> integerArrayList = c10.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = c10.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList != null && integerArrayList != null) {
                        iVar.f344d = c10.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                        bundle.putAll(c10.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
                        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
                            String str = stringArrayList.get(i10);
                            if (hashMap.containsKey(str)) {
                                Integer num = (Integer) hashMap.remove(str);
                                if (!bundle.containsKey(str)) {
                                    hashMap2.remove(num);
                                }
                            }
                            Integer num2 = integerArrayList.get(i10);
                            num2.intValue();
                            String str2 = stringArrayList.get(i10);
                            hashMap2.put(num2, str2);
                            iVar.f342b.put(str2, num2);
                        }
                        break;
                    }
                }
                break;
            default:
                androidx.fragment.app.u uVar = (androidx.fragment.app.u) this.f295b.G.f74p;
                uVar.f828v.b(uVar, uVar, null);
                break;
        }
    }
}
