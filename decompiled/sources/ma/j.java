package ma;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import okhttp3.internal.url._UrlKt;

/* loaded from: classes.dex */
public abstract class j extends n {
    public static void B(Collection collection, Iterable iterable) {
        za.h.e("<this>", collection);
        za.h.e("elements", iterable);
        if (iterable instanceof Collection) {
            collection.addAll((Collection) iterable);
            return;
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            collection.add(it.next());
        }
    }

    public static Object C(List list) {
        za.h.e("<this>", list);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final void D(Collection collection, StringBuilder sb2, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, ya.l lVar) {
        sb2.append(charSequence2);
        int i10 = 0;
        for (Object obj : collection) {
            i10++;
            if (i10 > 1) {
                sb2.append(charSequence);
            }
            com.bumptech.glide.d.b(sb2, obj, lVar);
        }
        sb2.append(charSequence3);
    }

    public static String F(Collection collection, String str, String str2, String str3, ya.l lVar, int i10) {
        if ((i10 & 1) != 0) {
            str = ", ";
        }
        String str4 = str;
        String str5 = (i10 & 2) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : str2;
        String str6 = (i10 & 4) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : str3;
        if ((i10 & 32) != 0) {
            lVar = null;
        }
        StringBuilder sb2 = new StringBuilder();
        D(collection, sb2, str4, str5, str6, "...", lVar);
        return sb2.toString();
    }

    public static Object G(List list) {
        za.h.e("<this>", list);
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(k.w(list));
    }

    public static ArrayList H(Collection collection, Iterable iterable) {
        za.h.e("<this>", collection);
        za.h.e("elements", iterable);
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            B(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection2.size() + collection.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }

    public static final void I(Iterable iterable, AbstractCollection abstractCollection) {
        za.h.e("<this>", iterable);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            abstractCollection.add(it.next());
        }
    }

    public static List J(Iterable iterable) {
        ArrayList arrayList;
        za.h.e("<this>", iterable);
        boolean z10 = iterable instanceof Collection;
        p pVar = p.f9051o;
        if (z10) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                return pVar;
            }
            if (size != 1) {
                return K(collection);
            }
            return com.bumptech.glide.f.t(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
        }
        if (z10) {
            arrayList = K((Collection) iterable);
        } else {
            ArrayList arrayList2 = new ArrayList();
            I(iterable, arrayList2);
            arrayList = arrayList2;
        }
        int size2 = arrayList.size();
        return size2 != 0 ? size2 != 1 ? arrayList : com.bumptech.glide.f.t(arrayList.get(0)) : pVar;
    }

    public static ArrayList K(Collection collection) {
        za.h.e("<this>", collection);
        return new ArrayList(collection);
    }

    public static Set L(Iterable iterable) {
        za.h.e("<this>", iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size != 0) {
                if (size != 1) {
                    LinkedHashSet linkedHashSet = new LinkedHashSet(t.z(collection.size()));
                    I(iterable, linkedHashSet);
                    return linkedHashSet;
                }
                Set singleton = Collections.singleton(iterable instanceof List ? ((List) iterable).get(0) : collection.iterator().next());
                za.h.d("singleton(...)", singleton);
                return singleton;
            }
        } else {
            LinkedHashSet linkedHashSet2 = new LinkedHashSet();
            I(iterable, linkedHashSet2);
            int size2 = linkedHashSet2.size();
            if (size2 != 0) {
                if (size2 != 1) {
                    return linkedHashSet2;
                }
                Set singleton2 = Collections.singleton(linkedHashSet2.iterator().next());
                za.h.d("singleton(...)", singleton2);
                return singleton2;
            }
        }
        return r.f9053o;
    }
}
