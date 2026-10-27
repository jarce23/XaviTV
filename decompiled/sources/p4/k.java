package p4;

import android.os.Build;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9938a = o4.p.f("Schedulers");

    public static void a(x4.p pVar, o4.q qVar, ArrayList arrayList) {
        if (arrayList.size() > 0) {
            qVar.getClass();
            long currentTimeMillis = System.currentTimeMillis();
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                pVar.k(currentTimeMillis, ((x4.o) obj).f13569a);
            }
        }
    }

    public static void b(o4.a aVar, WorkDatabase workDatabase, List list) {
        ArrayList arrayList;
        if (list == null || list.size() == 0) {
            return;
        }
        x4.p t3 = workDatabase.t();
        workDatabase.c();
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                arrayList = t3.d();
                a(t3, (o4.q) aVar.g, arrayList);
            } else {
                arrayList = null;
            }
            ArrayList c10 = t3.c(aVar.f9476d);
            a(t3, (o4.q) aVar.g, c10);
            if (arrayList != null) {
                c10.addAll(arrayList);
            }
            ArrayList b2 = t3.b();
            workDatabase.o();
            workDatabase.k();
            if (c10.size() > 0) {
                x4.o[] oVarArr = (x4.o[]) c10.toArray(new x4.o[c10.size()]);
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    h hVar = (h) it.next();
                    if (hVar.d()) {
                        hVar.a(oVarArr);
                    }
                }
            }
            if (b2.size() > 0) {
                x4.o[] oVarArr2 = (x4.o[]) b2.toArray(new x4.o[b2.size()]);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    h hVar2 = (h) it2.next();
                    if (!hVar2.d()) {
                        hVar2.a(oVarArr2);
                    }
                }
            }
        } catch (Throwable th) {
            workDatabase.k();
            throw th;
        }
    }
}
