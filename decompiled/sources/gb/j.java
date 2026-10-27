package gb;

import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class j extends com.bumptech.glide.d {
    public static String Q(String str) {
        List list;
        za.h.e("<this>", str);
        if (i.h0("|")) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.");
        }
        c cVar = new c(str);
        if (cVar.hasNext()) {
            Object next = cVar.next();
            if (cVar.hasNext()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(next);
                while (cVar.hasNext()) {
                    arrayList.add(cVar.next());
                }
                list = arrayList;
            } else {
                list = com.bumptech.glide.f.t(next);
            }
        } else {
            list = ma.p.f9051o;
        }
        int length = str.length();
        list.size();
        int w10 = ma.k.w(list);
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            String str2 = null;
            if (i10 < 0) {
                ma.k.y();
                throw null;
            }
            String str3 = (String) obj;
            if ((i10 != 0 && i10 != w10) || !i.h0(str3)) {
                int length2 = str3.length();
                int i12 = 0;
                while (true) {
                    if (i12 >= length2) {
                        i12 = -1;
                        break;
                    }
                    if (!com.bumptech.glide.c.q(str3.charAt(i12))) {
                        break;
                    }
                    i12++;
                }
                if (i12 != -1 && p.X(i12, str3, "|", false)) {
                    str2 = str3.substring("|".length() + i12);
                    za.h.d("substring(...)", str2);
                }
                if (str2 == null) {
                    str2 = str3;
                }
            }
            if (str2 != null) {
                arrayList2.add(str2);
            }
            i10 = i11;
        }
        StringBuilder sb2 = new StringBuilder(length);
        ma.j.D(arrayList2, sb2, "\n", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "...", null);
        return sb2.toString();
    }
}
