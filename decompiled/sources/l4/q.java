package l4;

import android.widget.FrameLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final a f8251a;

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f8252b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f8253c;

    static {
        a aVar = new a();
        aVar.O = new ArrayList();
        aVar.R = false;
        aVar.S = 0;
        aVar.P = false;
        aVar.H(new g(2));
        aVar.H(new e());
        aVar.H(new g(1));
        f8251a = aVar;
        f8252b = new ThreadLocal();
        f8253c = new ArrayList();
    }

    public static void a(FrameLayout frameLayout, m mVar) {
        ArrayList arrayList = f8253c;
        if (arrayList.contains(frameLayout) || !frameLayout.isLaidOut()) {
            return;
        }
        arrayList.add(frameLayout);
        if (mVar == null) {
            mVar = f8251a;
        }
        m clone = mVar.clone();
        ArrayList arrayList2 = (ArrayList) b().get(frameLayout);
        if (arrayList2 != null && arrayList2.size() > 0) {
            int size = arrayList2.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList2.get(i10);
                i10++;
                ((m) obj).v(frameLayout);
            }
        }
        clone.g(frameLayout, true);
        if (frameLayout.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        frameLayout.setTag(R.id.transition_current_scene, null);
        p pVar = new p();
        pVar.f8249o = clone;
        pVar.f8250p = frameLayout;
        frameLayout.addOnAttachStateChangeListener(pVar);
        frameLayout.getViewTreeObserver().addOnPreDrawListener(pVar);
    }

    public static p.e b() {
        p.e eVar;
        ThreadLocal threadLocal = f8252b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (eVar = (p.e) weakReference.get()) != null) {
            return eVar;
        }
        p.e eVar2 = new p.e(0);
        threadLocal.set(new WeakReference(eVar2));
        return eVar2;
    }
}
