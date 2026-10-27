package i1;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: c, reason: collision with root package name */
    public static final c f5813c = new c(new b[0]);

    /* renamed from: d, reason: collision with root package name */
    public static final b f5814d;

    /* renamed from: a, reason: collision with root package name */
    public final int f5815a;

    /* renamed from: b, reason: collision with root package name */
    public final b[] f5816b;

    static {
        b bVar = new b(-1, -1, new int[0], new a0[0], new long[0], new String[0]);
        int[] iArr = bVar.f5807e;
        int length = iArr.length;
        int max = Math.max(0, length);
        int[] copyOf = Arrays.copyOf(iArr, max);
        Arrays.fill(copyOf, length, max, 0);
        long[] jArr = bVar.f5808f;
        int length2 = jArr.length;
        int max2 = Math.max(0, length2);
        long[] copyOf2 = Arrays.copyOf(jArr, max2);
        Arrays.fill(copyOf2, length2, max2, -9223372036854775807L);
        f5814d = new b(0, bVar.f5804b, copyOf, (a0[]) Arrays.copyOf(bVar.f5806d, 0), copyOf2, (String[]) Arrays.copyOf(bVar.g, 0));
        l1.a0.J(1);
        l1.a0.J(2);
        l1.a0.J(3);
        l1.a0.J(4);
    }

    public c(b[] bVarArr) {
        this.f5815a = bVarArr.length;
        this.f5816b = bVarArr;
    }

    public final b a(int i10) {
        return i10 < 0 ? f5814d : this.f5816b[i10];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f5815a == cVar.f5815a && Arrays.equals(this.f5816b, cVar.f5816b);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f5816b) + (((((this.f5815a * 961) + ((int) 0)) * 31) + ((int) (-9223372036854775807L))) * 961);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AdPlaybackState(adsId=null, adResumePositionUs=0, adGroups=[");
        int i10 = 0;
        while (true) {
            b[] bVarArr = this.f5816b;
            if (i10 >= bVarArr.length) {
                sb2.append("])");
                return sb2.toString();
            }
            sb2.append("adGroup(timeUs=0, ads=[");
            bVarArr[i10].getClass();
            for (int i11 = 0; i11 < bVarArr[i10].f5807e.length; i11++) {
                sb2.append("ad(state=");
                int i12 = bVarArr[i10].f5807e[i11];
                if (i12 == 0) {
                    sb2.append('_');
                } else if (i12 == 1) {
                    sb2.append('R');
                } else if (i12 == 2) {
                    sb2.append('S');
                } else if (i12 == 3) {
                    sb2.append('P');
                } else if (i12 != 4) {
                    sb2.append('?');
                } else {
                    sb2.append('!');
                }
                sb2.append(", durationUs=");
                sb2.append(bVarArr[i10].f5808f[i11]);
                sb2.append(')');
                if (i11 < bVarArr[i10].f5807e.length - 1) {
                    sb2.append(", ");
                }
            }
            sb2.append("])");
            if (i10 < bVarArr.length - 1) {
                sb2.append(", ");
            }
            i10++;
        }
    }
}
