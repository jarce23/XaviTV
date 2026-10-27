package androidx.fragment.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e0 extends com.bumptech.glide.f {

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ int f674h;

    public /* synthetic */ e0(int i10) {
        this.f674h = i10;
    }

    @Override // com.bumptech.glide.f
    public final Intent f(f.j jVar, Object obj) {
        Bundle bundleExtra;
        switch (this.f674h) {
            case 0:
                androidx.activity.result.h hVar = (androidx.activity.result.h) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = hVar.f348p;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        hVar = new androidx.activity.result.h(hVar.f347o, null, hVar.f349q, hVar.f350r);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", hVar);
                if (i0.F(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                za.h.e("input", strArr);
                Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                za.h.d("Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)", putExtra);
                return putExtra;
            default:
                Intent intent3 = (Intent) obj;
                za.h.e("input", intent3);
                return intent3;
        }
    }

    @Override // com.bumptech.glide.f
    public d.a k(f.j jVar, Object obj) {
        switch (this.f674h) {
            case 1:
                String[] strArr = (String[]) obj;
                za.h.e("input", strArr);
                if (strArr.length == 0) {
                    return new d.a(ma.q.f9052o);
                }
                for (String str : strArr) {
                    if (n4.a.e(jVar, str) != 0) {
                        return null;
                    }
                }
                int z10 = ma.t.z(strArr.length);
                if (z10 < 16) {
                    z10 = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(z10);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new d.a(linkedHashMap);
            default:
                return super.k(jVar, obj);
        }
    }

    @Override // com.bumptech.glide.f
    public final Object v(Intent intent, int i10) {
        switch (this.f674h) {
            case 0:
                return new androidx.activity.result.a(intent, i10);
            case 1:
                if (i10 == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i11 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i11 == 0));
                        }
                        ArrayList K = ma.i.K(stringArrayExtra);
                        Iterator it = K.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList2 = new ArrayList(Math.min(ma.l.z(K), ma.l.z(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList2.add(new la.d(it.next(), it2.next()));
                        }
                        return ma.t.A(arrayList2);
                    }
                }
                return ma.q.f9052o;
            default:
                return new androidx.activity.result.a(intent, i10);
        }
    }
}
