package x1;

import android.net.Uri;
import i1.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o extends p {

    /* renamed from: n, reason: collision with root package name */
    public static final o f13440n;

    /* renamed from: d, reason: collision with root package name */
    public final List f13441d;

    /* renamed from: e, reason: collision with root package name */
    public final List f13442e;

    /* renamed from: f, reason: collision with root package name */
    public final List f13443f;
    public final List g;

    /* renamed from: h, reason: collision with root package name */
    public final List f13444h;

    /* renamed from: i, reason: collision with root package name */
    public final List f13445i;

    /* renamed from: j, reason: collision with root package name */
    public final i1.p f13446j;

    /* renamed from: k, reason: collision with root package name */
    public final List f13447k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f13448l;

    /* renamed from: m, reason: collision with root package name */
    public final List f13449m;

    static {
        List list = Collections.EMPTY_LIST;
        f13440n = new o(_UrlKt.FRAGMENT_ENCODE_SET, list, list, list, list, list, list, null, list, false, Collections.EMPTY_MAP, list);
    }

    public o(String str, List list, List list2, List list3, List list4, List list5, List list6, i1.p pVar, List list7, boolean z10, Map map, List list8) {
        super(str, list, z10);
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list2.size(); i10++) {
            Uri uri = ((n) list2.get(i10)).f13434a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        b(list3, arrayList);
        b(list4, arrayList);
        b(list5, arrayList);
        b(list6, arrayList);
        this.f13441d = Collections.unmodifiableList(arrayList);
        this.f13442e = Collections.unmodifiableList(list2);
        this.f13443f = Collections.unmodifiableList(list3);
        this.g = Collections.unmodifiableList(list4);
        this.f13444h = Collections.unmodifiableList(list5);
        this.f13445i = Collections.unmodifiableList(list6);
        this.f13446j = pVar;
        this.f13447k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f13448l = Collections.unmodifiableMap(map);
        this.f13449m = Collections.unmodifiableList(list8);
    }

    public static void b(List list, ArrayList arrayList) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            Uri uri = ((m) list.get(i10)).f13431a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
    }

    public static ArrayList c(List list, int i10, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            Object obj = list.get(i11);
            int i12 = 0;
            while (true) {
                if (i12 < list2.size()) {
                    p0 p0Var = (p0) list2.get(i12);
                    if (p0Var.f6005p == i10 && p0Var.f6006q == i11) {
                        arrayList.add(obj);
                        break;
                    }
                    i12++;
                }
            }
        }
        return arrayList;
    }

    @Override // x1.p
    public final Object a(List list) {
        ArrayList c10 = c(this.f13442e, 0, list);
        List list2 = Collections.EMPTY_LIST;
        return new o(this.f13450a, this.f13451b, c10, list2, c(this.g, 1, list), c(this.f13444h, 2, list), list2, this.f13446j, this.f13447k, this.f13452c, this.f13448l, this.f13449m);
    }
}
