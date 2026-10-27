package y0;

import android.util.Log;
import androidx.fragment.app.i0;
import androidx.fragment.app.s;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final b f13756a = b.f13755a;

    public static b a(s sVar) {
        while (sVar != null) {
            if (sVar.o()) {
                sVar.k();
            }
            sVar = sVar.I;
        }
        return f13756a;
    }

    public static void b(a aVar) {
        if (i0.F(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(aVar.f13754o.getClass().getName()), aVar);
        }
    }

    public static final void c(s sVar, String str) {
        h.e("previousFragmentId", str);
        b(new a(sVar, "Attempting to reuse fragment " + sVar + " with previous ID " + str));
        a(sVar).getClass();
    }
}
