package com.google.android.gms.internal.cast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k5 extends m5 {

    /* renamed from: c, reason: collision with root package name */
    public static final Class f3353c = Collections.unmodifiableList(Collections.EMPTY_LIST).getClass();

    @Override // com.google.android.gms.internal.cast.m5
    public final void a(long j10, Object obj) {
        Object unmodifiableList;
        List list = (List) p6.h(j10, obj);
        if (list instanceof j5) {
            unmodifiableList = ((j5) list).e();
        } else {
            if (f3353c.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof z5) && (list instanceof f5)) {
                p4 p4Var = (p4) ((f5) list);
                boolean z10 = p4Var.f3423o;
                if (z10 && z10) {
                    p4Var.f3423o = false;
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        p6.l(j10, obj, unmodifiableList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.m5
    public final void b(long j10, Object obj, Object obj2) {
        i5 i5Var;
        List list = (List) p6.h(j10, obj2);
        int size = list.size();
        List list2 = (List) p6.h(j10, obj);
        if (list2.isEmpty()) {
            list2 = list2 instanceof j5 ? new i5(size) : ((list2 instanceof z5) && (list2 instanceof f5)) ? ((f5) list2).c(size) : new ArrayList(size);
            p6.l(j10, obj, list2);
        } else {
            if (f3353c.isAssignableFrom(list2.getClass())) {
                ArrayList arrayList = new ArrayList(list2.size() + size);
                arrayList.addAll(list2);
                p6.l(j10, obj, arrayList);
                i5Var = arrayList;
            } else if (list2 instanceof k6) {
                i5 i5Var2 = new i5(list2.size() + size);
                i5Var2.addAll(i5Var2.f3340p.size(), (k6) list2);
                p6.l(j10, obj, i5Var2);
                i5Var = i5Var2;
            } else if ((list2 instanceof z5) && (list2 instanceof f5)) {
                f5 f5Var = (f5) list2;
                if (!((p4) f5Var).f3423o) {
                    list2 = f5Var.c(list2.size() + size);
                    p6.l(j10, obj, list2);
                }
            }
            list2 = i5Var;
        }
        int size2 = list2.size();
        int size3 = list.size();
        if (size2 > 0 && size3 > 0) {
            list2.addAll(list);
        }
        if (size2 > 0) {
            list = list2;
        }
        p6.l(j10, obj, list);
    }
}
