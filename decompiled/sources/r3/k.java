package r3;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: f, reason: collision with root package name */
    public static final byte[] f10557f = {0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public boolean f10558a;

    /* renamed from: b, reason: collision with root package name */
    public int f10559b;

    /* renamed from: c, reason: collision with root package name */
    public int f10560c;

    /* renamed from: d, reason: collision with root package name */
    public int f10561d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f10562e;

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f10558a) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f10562e;
            int length = bArr2.length;
            int i13 = this.f10560c + i12;
            if (length < i13) {
                this.f10562e = Arrays.copyOf(bArr2, i13 * 2);
            }
            System.arraycopy(bArr, i10, this.f10562e, this.f10560c, i12);
            this.f10560c += i12;
        }
    }
}
