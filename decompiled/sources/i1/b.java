package i1;

import android.net.Uri;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f5803a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5804b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri[] f5805c;

    /* renamed from: d, reason: collision with root package name */
    public final a0[] f5806d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f5807e;

    /* renamed from: f, reason: collision with root package name */
    public final long[] f5808f;
    public final String[] g;

    static {
        android.support.v4.media.d.t(0, 1, 2, 3, 4);
        android.support.v4.media.d.t(5, 6, 7, 8, 9);
        l1.a0.J(10);
    }

    public b(int i10, int i11, int[] iArr, a0[] a0VarArr, long[] jArr, String[] strArr) {
        Uri uri;
        int i12 = 0;
        l1.d.b(iArr.length == a0VarArr.length);
        this.f5803a = i10;
        this.f5804b = i11;
        this.f5807e = iArr;
        this.f5806d = a0VarArr;
        this.f5808f = jArr;
        this.f5805c = new Uri[a0VarArr.length];
        while (true) {
            Uri[] uriArr = this.f5805c;
            if (i12 >= uriArr.length) {
                this.g = strArr;
                return;
            }
            a0 a0Var = a0VarArr[i12];
            if (a0Var == null) {
                uri = null;
            } else {
                x xVar = a0Var.f5793b;
                xVar.getClass();
                uri = xVar.f6061a;
            }
            uriArr[i12] = uri;
            i12++;
        }
    }

    public final int a(int i10) {
        int i11;
        int i12 = i10 + 1;
        while (true) {
            int[] iArr = this.f5807e;
            if (i12 >= iArr.length || (i11 = iArr[i12]) == 0 || i11 == 1) {
                break;
            }
            i12++;
        }
        return i12;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f5803a == bVar.f5803a && this.f5804b == bVar.f5804b && Arrays.equals(this.f5806d, bVar.f5806d) && Arrays.equals(this.f5807e, bVar.f5807e) && Arrays.equals(this.f5808f, bVar.f5808f) && Arrays.equals(this.g, bVar.g);
    }

    public final int hashCode() {
        int i10 = ((this.f5803a * 31) + this.f5804b) * 31;
        int i11 = (int) 0;
        return (((((Arrays.hashCode(this.f5808f) + ((Arrays.hashCode(this.f5807e) + ((Arrays.hashCode(this.f5806d) + ((i10 + i11) * 31)) * 31)) * 31)) * 31) + i11) * 961) + Arrays.hashCode(this.g)) * 31;
    }
}
