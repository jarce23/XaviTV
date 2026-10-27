package fb;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ma.p;

/* loaded from: classes.dex */
public abstract class h extends k5.a {
    public static List A(f fVar) {
        Iterator it = fVar.iterator();
        if (!it.hasNext()) {
            return p.f9051o;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return com.bumptech.glide.f.t(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
