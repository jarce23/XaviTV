package k2;

import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public int f7801a;

    /* renamed from: b, reason: collision with root package name */
    public int f7802b;

    /* renamed from: c, reason: collision with root package name */
    public int f7803c;

    /* renamed from: d, reason: collision with root package name */
    public int f7804d;

    /* renamed from: e, reason: collision with root package name */
    public int f7805e;

    /* renamed from: f, reason: collision with root package name */
    public int f7806f;
    public Serializable g;

    public boolean a(int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if ((i10 & (-2097152)) != -2097152 || (i11 = (i10 >>> 19) & 3) == 1 || (i12 = (i10 >>> 17) & 3) == 0 || (i13 = (i10 >>> 12) & 15) == 0 || i13 == 15 || (i14 = (i10 >>> 10) & 3) == 3) {
            return false;
        }
        this.f7801a = i11;
        this.g = b.f7680s[3 - i12];
        int i15 = b.f7681t[i14];
        this.f7803c = i15;
        if (i11 == 2) {
            this.f7803c = i15 / 2;
        } else if (i11 == 0) {
            this.f7803c = i15 / 4;
        }
        int i16 = (i10 >>> 9) & 1;
        int i17 = 1152;
        if (i12 != 1) {
            if (i12 != 2) {
                if (i12 != 3) {
                    throw new IllegalArgumentException();
                }
                i17 = 384;
            }
        } else if (i11 != 3) {
            i17 = 576;
        }
        this.f7806f = i17;
        if (i12 == 3) {
            int i18 = i11 == 3 ? b.f7682u[i13 - 1] : b.f7683v[i13 - 1];
            this.f7805e = i18;
            this.f7802b = (((i18 * 12) / this.f7803c) + i16) * 4;
        } else {
            if (i11 == 3) {
                int i19 = i12 == 2 ? b.f7684w[i13 - 1] : b.f7685x[i13 - 1];
                this.f7805e = i19;
                this.f7802b = ((i19 * 144) / this.f7803c) + i16;
            } else {
                int i20 = b.f7686y[i13 - 1];
                this.f7805e = i20;
                this.f7802b = (((i12 == 1 ? 72 : 144) * i20) / this.f7803c) + i16;
            }
        }
        this.f7804d = ((i10 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }
}
