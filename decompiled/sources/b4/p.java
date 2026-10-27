package b4;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2376a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2377b;

    /* renamed from: c, reason: collision with root package name */
    public int f2378c;

    /* renamed from: d, reason: collision with root package name */
    public int f2379d;

    /* renamed from: e, reason: collision with root package name */
    public int f2380e;

    public /* synthetic */ p(int i10) {
        this.f2376a = i10;
    }

    public void a(int i10) {
        int[] iArr = (int[]) this.f2377b;
        int i11 = this.f2379d;
        iArr[i11] = i10;
        int i12 = this.f2380e & (i11 + 1);
        this.f2379d = i12;
        int i13 = this.f2378c;
        if (i12 == i13) {
            int length = iArr.length;
            int i14 = length - i13;
            int i15 = length << 1;
            if (i15 < 0) {
                throw new RuntimeException("Max array capacity exceeded");
            }
            int[] iArr2 = new int[i15];
            ma.i.D(0, i13, length, iArr, iArr2);
            ma.i.D(i14, 0, this.f2378c, (int[]) this.f2377b, iArr2);
            this.f2377b = iArr2;
            this.f2378c = 0;
            this.f2379d = length;
            this.f2380e = i15 - 1;
        }
    }

    public void b(int i10, int i11) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i11 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i12 = this.f2380e;
        int i13 = i12 * 2;
        int[] iArr = (int[]) this.f2377b;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.f2377b = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i13 >= iArr.length) {
            int[] iArr3 = new int[i12 * 4];
            this.f2377b = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.f2377b;
        iArr4[i13] = i10;
        iArr4[i13 + 1] = i11;
        this.f2380e++;
    }

    public void c(RecyclerView recyclerView, boolean z10) {
        this.f2380e = 0;
        int[] iArr = (int[]) this.f2377b;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        o0 o0Var = recyclerView.B;
        if (recyclerView.A == null || o0Var == null || !o0Var.f2364i) {
            return;
        }
        if (z10) {
            if (!recyclerView.f1480s.l()) {
                o0Var.j(recyclerView.A.a(), this);
            }
        } else if (!recyclerView.L()) {
            o0Var.i(this.f2378c, this.f2379d, recyclerView.f1487v0, this);
        }
        int i10 = this.f2380e;
        if (i10 > o0Var.f2365j) {
            o0Var.f2365j = i10;
            o0Var.f2366k = z10;
            recyclerView.f1476q.n();
        }
    }

    public void d() {
        Object[] objArr = (Object[]) this.f2377b;
        int length = objArr.length;
        int i10 = this.f2378c;
        int i11 = length - i10;
        int i12 = length << 1;
        if (i12 < 0) {
            throw new RuntimeException("Max array capacity exceeded");
        }
        Object[] objArr2 = new Object[i12];
        ma.i.E(0, i10, length, objArr, objArr2);
        ma.i.E(i11, 0, this.f2378c, (Object[]) this.f2377b, objArr2);
        this.f2377b = objArr2;
        this.f2378c = 0;
        this.f2379d = length;
        this.f2380e = i12 - 1;
    }

    public int e(int i10) {
        if (i10 < 0 || i10 >= h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return ((int[]) this.f2377b)[this.f2380e & (this.f2378c + i10)];
    }

    public void f(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i11 = this.f2379d;
        int i12 = i10 < i11 ? i11 - i10 : 0;
        for (int i13 = i12; i13 < i11; i13++) {
            ((Object[]) this.f2377b)[i13] = null;
        }
        int i14 = this.f2379d;
        int i15 = i14 - i12;
        int i16 = i10 - i15;
        this.f2379d = i14 - i15;
        if (i16 > 0) {
            int length = ((Object[]) this.f2377b).length;
            this.f2379d = length;
            int i17 = length - i16;
            for (int i18 = i17; i18 < length; i18++) {
                ((Object[]) this.f2377b)[i18] = null;
            }
            this.f2379d = i17;
        }
    }

    public void g(int i10) {
        if (i10 <= 0) {
            return;
        }
        if (i10 > h()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int length = ((Object[]) this.f2377b).length;
        int i11 = this.f2378c;
        if (i10 < length - i11) {
            length = i11 + i10;
        }
        while (i11 < length) {
            ((Object[]) this.f2377b)[i11] = null;
            i11++;
        }
        int i12 = this.f2378c;
        int i13 = length - i12;
        int i14 = i10 - i13;
        this.f2378c = this.f2380e & (i12 + i13);
        if (i14 > 0) {
            for (int i15 = 0; i15 < i14; i15++) {
                ((Object[]) this.f2377b)[i15] = null;
            }
            this.f2378c = i14;
        }
    }

    public int h() {
        int i10;
        int i11;
        switch (this.f2376a) {
            case 1:
                i10 = this.f2379d - this.f2378c;
                i11 = this.f2380e;
                break;
            default:
                i10 = this.f2379d - this.f2378c;
                i11 = this.f2380e;
                break;
        }
        return i10 & i11;
    }

    public p() {
        this.f2376a = 1;
        int highestOneBit = Integer.bitCount(8) != 1 ? Integer.highestOneBit(7) << 1 : 8;
        this.f2380e = highestOneBit - 1;
        this.f2377b = new int[highestOneBit];
    }
}
