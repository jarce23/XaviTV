package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.SavedStateHandleController;
import androidx.lifecycle.i;
import androidx.lifecycle.l;
import androidx.lifecycle.l0;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import f4.b;
import f4.d;
import f4.e;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import r.a;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class Recreator implements p {

    /* renamed from: o, reason: collision with root package name */
    public final e f1511o;

    public Recreator(e eVar) {
        this.f1511o = eVar;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        Object obj;
        boolean z10;
        if (lVar != l.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        rVar.f().f(this);
        Bundle c10 = this.f1511o.b().c("androidx.savedstate.Restarter");
        if (c10 == null) {
            return;
        }
        ArrayList<String> stringArrayList = c10.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i10 = 0;
        while (i10 < size) {
            String str = stringArrayList.get(i10);
            i10++;
            String str2 = str;
            try {
                Class<? extends U> asSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                h.d("{\n                Class.…class.java)\n            }", asSubclass);
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(null);
                        h.d("{\n                constr…wInstance()\n            }", newInstance);
                        e eVar = this.f1511o;
                        if (!(eVar instanceof o0)) {
                            throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
                        }
                        n0 e7 = ((o0) eVar).e();
                        d b2 = eVar.b();
                        e7.getClass();
                        Iterator it = new HashSet(e7.f1152a.keySet()).iterator();
                        while (it.hasNext()) {
                            String str3 = (String) it.next();
                            h.e("key", str3);
                            l0 l0Var = (l0) e7.f1152a.get(str3);
                            h.b(l0Var);
                            t f10 = eVar.f();
                            h.e("registry", b2);
                            h.e("lifecycle", f10);
                            HashMap hashMap = l0Var.f1142a;
                            if (hashMap == null) {
                                obj = null;
                            } else {
                                synchronized (hashMap) {
                                    obj = l0Var.f1142a.get("androidx.lifecycle.savedstate.vm.tag");
                                }
                            }
                            SavedStateHandleController savedStateHandleController = (SavedStateHandleController) obj;
                            if (savedStateHandleController != null && !(z10 = savedStateHandleController.f1108o)) {
                                if (z10) {
                                    throw new IllegalStateException("Already attached to lifecycleOwner");
                                }
                                savedStateHandleController.f1108o = true;
                                f10.a(savedStateHandleController);
                                throw null;
                            }
                        }
                        if (!new HashSet(e7.f1152a.keySet()).isEmpty()) {
                            if (!b2.f5019c) {
                                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
                            }
                            f.h hVar = (f.h) b2.f5022f;
                            if (hVar == null) {
                                hVar = new f.h(b2);
                            }
                            b2.f5022f = hVar;
                            try {
                                i.class.getDeclaredConstructor(null);
                                f.h hVar2 = (f.h) b2.f5022f;
                                if (hVar2 != null) {
                                    ((LinkedHashSet) hVar2.f4789b).add(i.class.getName());
                                }
                            } catch (NoSuchMethodException e8) {
                                throw new IllegalArgumentException("Class " + i.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e8);
                            }
                        }
                    } catch (Exception e10) {
                        throw new RuntimeException(a.l("Failed to instantiate ", str2), e10);
                    }
                } catch (NoSuchMethodException e11) {
                    throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e11);
                }
            } catch (ClassNotFoundException e12) {
                throw new RuntimeException(android.support.v4.media.d.q("Class ", str2, " wasn't found"), e12);
            }
        }
    }
}
