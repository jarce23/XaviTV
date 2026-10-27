package g7;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.gms.cast.MediaInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends s7.a {
    public static final Parcelable.Creator<q> CREATOR;
    public int A;
    public String B;
    public JSONObject C;
    public int D;
    public boolean F;
    public c G;
    public u H;
    public j I;
    public n J;
    public boolean K;

    /* renamed from: o, reason: collision with root package name */
    public MediaInfo f5276o;

    /* renamed from: p, reason: collision with root package name */
    public long f5277p;

    /* renamed from: q, reason: collision with root package name */
    public int f5278q;

    /* renamed from: r, reason: collision with root package name */
    public double f5279r;

    /* renamed from: s, reason: collision with root package name */
    public int f5280s;

    /* renamed from: t, reason: collision with root package name */
    public int f5281t;

    /* renamed from: u, reason: collision with root package name */
    public long f5282u;

    /* renamed from: v, reason: collision with root package name */
    public long f5283v;

    /* renamed from: w, reason: collision with root package name */
    public double f5284w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f5285x;

    /* renamed from: y, reason: collision with root package name */
    public long[] f5286y;

    /* renamed from: z, reason: collision with root package name */
    public int f5287z;
    public final ArrayList E = new ArrayList();
    public final SparseArray L = new SparseArray();

    static {
        r7.r.d("MediaStatus", "The log tag cannot be null or empty.");
        TextUtils.isEmpty(null);
        CREATOR = new v(15);
    }

    public q(MediaInfo mediaInfo, long j10, int i10, double d6, int i11, int i12, long j11, long j12, double d10, boolean z10, long[] jArr, int i13, int i14, String str, int i15, ArrayList arrayList, boolean z11, c cVar, u uVar, j jVar, n nVar) {
        this.f5276o = mediaInfo;
        this.f5277p = j10;
        this.f5278q = i10;
        this.f5279r = d6;
        this.f5280s = i11;
        this.f5281t = i12;
        this.f5282u = j11;
        this.f5283v = j12;
        this.f5284w = d10;
        this.f5285x = z10;
        this.f5286y = jArr;
        this.f5287z = i13;
        this.A = i14;
        this.B = str;
        if (str != null) {
            try {
                this.C = new JSONObject(this.B);
            } catch (JSONException unused) {
                this.C = null;
                this.B = null;
            }
        } else {
            this.C = null;
        }
        this.D = i15;
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        this.F = z11;
        this.G = cVar;
        this.H = uVar;
        this.I = jVar;
        this.J = nVar;
        boolean z12 = false;
        if (nVar != null && nVar.f5265x) {
            z12 = true;
        }
        this.K = z12;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x023f, code lost:
    
        if (r12 != 3) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:329:0x0242, code lost:
    
        if (r2 != 2) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:330:0x0245, code lost:
    
        if (r13 == 0) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x01af, code lost:
    
        if (r34.f5286y != null) goto L110;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x03b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0461 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0477  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x048c  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x065c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x059e  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x05a7  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0650  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03de A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x0390 A[Catch: JSONException -> 0x039b, TryCatch #1 {JSONException -> 0x039b, blocks: (B:319:0x036a, B:321:0x0390, B:322:0x0391), top: B:318:0x036a }] */
    /* JADX WARN: Removed duplicated region for block: B:333:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:370:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:372:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:375:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(org.json.JSONObject r35, int r36) {
        /*
            Method dump skipped, instructions count: 1768
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.q.b(org.json.JSONObject, int):int");
    }

    public final void c(List list) {
        ArrayList arrayList = this.E;
        arrayList.clear();
        SparseArray sparseArray = this.L;
        sparseArray.clear();
        if (list != null) {
            for (int i10 = 0; i10 < list.size(); i10++) {
                o oVar = (o) list.get(i10);
                arrayList.add(oVar);
                sparseArray.put(oVar.f5267p, Integer.valueOf(i10));
            }
        }
    }

    public final boolean equals(Object obj) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (this != obj) {
            if (obj instanceof q) {
                q qVar = (q) obj;
                if ((this.C == null) == (qVar.C == null) && this.f5277p == qVar.f5277p && this.f5278q == qVar.f5278q && this.f5279r == qVar.f5279r && this.f5280s == qVar.f5280s && this.f5281t == qVar.f5281t && this.f5282u == qVar.f5282u && this.f5284w == qVar.f5284w && this.f5285x == qVar.f5285x && this.f5287z == qVar.f5287z && this.A == qVar.A && this.D == qVar.D && Arrays.equals(this.f5286y, qVar.f5286y) && l7.a.d(Long.valueOf(this.f5283v), Long.valueOf(qVar.f5283v)) && l7.a.d(this.E, qVar.E) && l7.a.d(this.f5276o, qVar.f5276o) && (((jSONObject = this.C) == null || (jSONObject2 = qVar.C) == null || v7.a.a(jSONObject, jSONObject2)) && this.F == qVar.F && l7.a.d(this.G, qVar.G) && l7.a.d(this.H, qVar.H) && l7.a.d(this.I, qVar.I) && r7.r.h(this.J, qVar.J) && this.K == qVar.K)) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5276o, Long.valueOf(this.f5277p), Integer.valueOf(this.f5278q), Double.valueOf(this.f5279r), Integer.valueOf(this.f5280s), Integer.valueOf(this.f5281t), Long.valueOf(this.f5282u), Long.valueOf(this.f5283v), Double.valueOf(this.f5284w), Boolean.valueOf(this.f5285x), Integer.valueOf(Arrays.hashCode(this.f5286y)), Integer.valueOf(this.f5287z), Integer.valueOf(this.A), String.valueOf(this.C), Integer.valueOf(this.D), this.E, Boolean.valueOf(this.F), this.G, this.H, this.I, this.J});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONObject jSONObject = this.C;
        this.B = jSONObject == null ? null : jSONObject.toString();
        int E = y7.d.E(parcel, 20293);
        y7.d.v(parcel, 2, this.f5276o, i10);
        long j10 = this.f5277p;
        y7.d.D(parcel, 3, 8);
        parcel.writeLong(j10);
        int i11 = this.f5278q;
        y7.d.D(parcel, 4, 4);
        parcel.writeInt(i11);
        double d6 = this.f5279r;
        y7.d.D(parcel, 5, 8);
        parcel.writeDouble(d6);
        int i12 = this.f5280s;
        y7.d.D(parcel, 6, 4);
        parcel.writeInt(i12);
        int i13 = this.f5281t;
        y7.d.D(parcel, 7, 4);
        parcel.writeInt(i13);
        long j11 = this.f5282u;
        y7.d.D(parcel, 8, 8);
        parcel.writeLong(j11);
        long j12 = this.f5283v;
        y7.d.D(parcel, 9, 8);
        parcel.writeLong(j12);
        double d10 = this.f5284w;
        y7.d.D(parcel, 10, 8);
        parcel.writeDouble(d10);
        boolean z10 = this.f5285x;
        y7.d.D(parcel, 11, 4);
        parcel.writeInt(z10 ? 1 : 0);
        y7.d.u(parcel, 12, this.f5286y);
        int i14 = this.f5287z;
        y7.d.D(parcel, 13, 4);
        parcel.writeInt(i14);
        int i15 = this.A;
        y7.d.D(parcel, 14, 4);
        parcel.writeInt(i15);
        y7.d.w(parcel, 15, this.B);
        int i16 = this.D;
        y7.d.D(parcel, 16, 4);
        parcel.writeInt(i16);
        y7.d.z(parcel, 17, this.E);
        boolean z11 = this.F;
        y7.d.D(parcel, 18, 4);
        parcel.writeInt(z11 ? 1 : 0);
        y7.d.v(parcel, 19, this.G, i10);
        y7.d.v(parcel, 20, this.H, i10);
        y7.d.v(parcel, 21, this.I, i10);
        y7.d.v(parcel, 22, this.J, i10);
        y7.d.G(parcel, E);
    }
}
