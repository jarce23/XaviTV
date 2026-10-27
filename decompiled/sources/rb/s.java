package rb;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11066a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11067b;

    /* renamed from: c, reason: collision with root package name */
    public final i0 f11068c;

    /* renamed from: d, reason: collision with root package name */
    public final Long f11069d;

    /* renamed from: e, reason: collision with root package name */
    public final Long f11070e;

    /* renamed from: f, reason: collision with root package name */
    public final Long f11071f;
    public final Long g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f11072h;

    public s(boolean z10, boolean z11, i0 i0Var, Long l10, Long l11, Long l12, Long l13, Map map) {
        za.h.e("extras", map);
        this.f11066a = z10;
        this.f11067b = z11;
        this.f11068c = i0Var;
        this.f11069d = l10;
        this.f11070e = l11;
        this.f11071f = l12;
        this.g = l13;
        int size = map.size();
        this.f11072h = size != 0 ? size != 1 ? new LinkedHashMap(map) : ma.t.B(map) : ma.q.f9052o;
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.f11066a) {
            arrayList.add("isRegularFile");
        }
        if (this.f11067b) {
            arrayList.add("isDirectory");
        }
        Long l10 = this.f11069d;
        if (l10 != null) {
            arrayList.add("byteCount=" + l10.longValue());
        }
        Long l11 = this.f11070e;
        if (l11 != null) {
            arrayList.add("createdAt=" + l11.longValue());
        }
        Long l12 = this.f11071f;
        if (l12 != null) {
            arrayList.add("lastModifiedAt=" + l12.longValue());
        }
        Long l13 = this.g;
        if (l13 != null) {
            arrayList.add("lastAccessedAt=" + l13.longValue());
        }
        Map map = this.f11072h;
        if (!map.isEmpty()) {
            arrayList.add("extras=" + map);
        }
        return ma.j.F(arrayList, ", ", "FileMetadata(", ")", null, 56);
    }

    public /* synthetic */ s(boolean z10, boolean z11, i0 i0Var, Long l10, Long l11, Long l12, Long l13) {
        this(z10, z11, i0Var, l10, l11, l12, l13, ma.q.f9052o);
    }
}
