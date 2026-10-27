package p3;

import android.graphics.Rect;
import i3.f;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public boolean f9894b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f9895c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f9896d;

    /* renamed from: e, reason: collision with root package name */
    public int f9897e;

    /* renamed from: f, reason: collision with root package name */
    public int f9898f;
    public Rect g;

    /* renamed from: a, reason: collision with root package name */
    public final int[] f9893a = new int[4];

    /* renamed from: h, reason: collision with root package name */
    public int f9899h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f9900i = -1;

    public static int a(int[] iArr, int i10) {
        return (i10 < 0 || i10 >= iArr.length) ? iArr[0] : iArr[i10];
    }

    public static int c(int i10, int i11) {
        return (i10 & 16777215) | ((i11 * 17) << 24);
    }

    public final void b(f fVar, boolean z10, Rect rect, int[] iArr) {
        int i10;
        int i11;
        int width = rect.width();
        int height = rect.height();
        int i12 = !z10 ? 1 : 0;
        int i13 = i12 * width;
        while (true) {
            int i14 = 0;
            do {
                int i15 = 0;
                for (int i16 = 1; i15 < i16 && i16 <= 64; i16 <<= 2) {
                    if (fVar.b() < 4) {
                        i10 = -1;
                        i11 = 0;
                        break;
                    }
                    i15 = (i15 << 4) | fVar.i(4);
                }
                i10 = i15 & 3;
                i11 = i15 < 4 ? width : i15 >> 2;
                int min = Math.min(i11, width - i14);
                if (min > 0) {
                    int i17 = i13 + min;
                    Arrays.fill(iArr, i13, i17, this.f9893a[i10]);
                    i14 += min;
                    i13 = i17;
                }
            } while (i14 < width);
            i12 += 2;
            if (i12 >= height) {
                return;
            }
            i13 = i12 * width;
            fVar.c();
        }
    }
}
