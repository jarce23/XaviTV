package t5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final l0.c f12000a;

    /* renamed from: b, reason: collision with root package name */
    public final List f12001b;

    /* renamed from: c, reason: collision with root package name */
    public final String f12002c;

    public w(Class cls, Class cls2, Class cls3, List list, l0.c cVar) {
        this.f12000a = cVar;
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        this.f12001b = list;
        this.f12002c = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public final y a(int i10, int i11, app.shamel.tv.b bVar, com.bumptech.glide.load.data.f fVar, r5.h hVar) {
        l0.c cVar = this.f12000a;
        List list = (List) cVar.v();
        m6.f.c("Argument must not be null", list);
        try {
            List list2 = this.f12001b;
            int size = list2.size();
            y yVar = null;
            for (int i12 = 0; i12 < size; i12++) {
                try {
                    yVar = ((i) list2.get(i12)).a(i10, i11, bVar, fVar, hVar);
                } catch (u e7) {
                    list.add(e7);
                }
                if (yVar != null) {
                    break;
                }
            }
            if (yVar != null) {
                return yVar;
            }
            throw new u(this.f12002c, new ArrayList(list));
        } finally {
            cVar.m(list);
        }
    }

    public final String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f12001b.toArray()) + '}';
    }
}
