package f2;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import c2.n1;
import i1.y0;
import i1.z0;
import java.util.Map;
import java.util.Objects;
import l1.a0;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends z0 {

    /* renamed from: x0, reason: collision with root package name */
    public static final k f4907x0 = new k(new j());

    /* renamed from: o0, reason: collision with root package name */
    public final boolean f4908o0;

    /* renamed from: p0, reason: collision with root package name */
    public final boolean f4909p0;

    /* renamed from: q0, reason: collision with root package name */
    public final boolean f4910q0;

    /* renamed from: r0, reason: collision with root package name */
    public final boolean f4911r0;

    /* renamed from: s0, reason: collision with root package name */
    public final boolean f4912s0;

    /* renamed from: t0, reason: collision with root package name */
    public final boolean f4913t0;

    /* renamed from: u0, reason: collision with root package name */
    public final boolean f4914u0;

    /* renamed from: v0, reason: collision with root package name */
    public final SparseArray f4915v0;

    /* renamed from: w0, reason: collision with root package name */
    public final SparseBooleanArray f4916w0;

    static {
        android.support.v4.media.d.t(1000, WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, 1002, 1003, 1004);
        android.support.v4.media.d.t(WebSocketProtocol.CLOSE_NO_STATUS_CODE, 1006, 1007, 1008, 1009);
        android.support.v4.media.d.t(1010, 1011, 1012, 1013, 1014);
        a0.J(1015);
        a0.J(1016);
        a0.J(1017);
        a0.J(1018);
    }

    public k(j jVar) {
        super(jVar);
        this.f4908o0 = jVar.F;
        this.f4909p0 = jVar.G;
        this.f4910q0 = jVar.H;
        this.f4911r0 = jVar.I;
        this.f4912s0 = jVar.J;
        this.f4913t0 = jVar.K;
        this.f4914u0 = jVar.L;
        this.f4915v0 = jVar.M;
        this.f4916w0 = jVar.N;
    }

    @Override // i1.z0
    public final y0 a() {
        return new j(this);
    }

    @Override // i1.z0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && k.class == obj.getClass()) {
            k kVar = (k) obj;
            if (super.equals(kVar) && this.f4908o0 == kVar.f4908o0 && this.f4909p0 == kVar.f4909p0 && this.f4910q0 == kVar.f4910q0 && this.f4911r0 == kVar.f4911r0 && this.f4912s0 == kVar.f4912s0 && this.f4913t0 == kVar.f4913t0 && this.f4914u0 == kVar.f4914u0) {
                SparseBooleanArray sparseBooleanArray = kVar.f4916w0;
                SparseBooleanArray sparseBooleanArray2 = this.f4916w0;
                int size = sparseBooleanArray2.size();
                if (sparseBooleanArray.size() == size) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            SparseArray sparseArray = kVar.f4915v0;
                            SparseArray sparseArray2 = this.f4915v0;
                            int size2 = sparseArray2.size();
                            if (sparseArray.size() == size2) {
                                for (int i11 = 0; i11 < size2; i11++) {
                                    int indexOfKey = sparseArray.indexOfKey(sparseArray2.keyAt(i11));
                                    if (indexOfKey >= 0) {
                                        Map map = (Map) sparseArray2.valueAt(i11);
                                        Map map2 = (Map) sparseArray.valueAt(indexOfKey);
                                        if (map2.size() == map.size()) {
                                            for (Map.Entry entry : map.entrySet()) {
                                                n1 n1Var = (n1) entry.getKey();
                                                if (map2.containsKey(n1Var) && Objects.equals(entry.getValue(), map2.get(n1Var))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray.indexOfKey(sparseBooleanArray2.keyAt(i10)) < 0) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // i1.z0
    public final int hashCode() {
        return (((((((((((((((super.hashCode() + 31) * 31) + (this.f4908o0 ? 1 : 0)) * 961) + (this.f4909p0 ? 1 : 0)) * 961) + (this.f4910q0 ? 1 : 0)) * 28629151) + (this.f4911r0 ? 1 : 0)) * 31) + (this.f4912s0 ? 1 : 0)) * 31) + (this.f4913t0 ? 1 : 0)) * 961) + (this.f4914u0 ? 1 : 0)) * 31;
    }
}
