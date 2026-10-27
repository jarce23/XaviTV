package r3;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final byte[] f10535e = {0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    public boolean f10536a;

    /* renamed from: b, reason: collision with root package name */
    public int f10537b;

    /* renamed from: c, reason: collision with root package name */
    public int f10538c;

    /* renamed from: d, reason: collision with root package name */
    public byte[] f10539d;

    public final void a(byte[] bArr, int i10, int i11) {
        if (this.f10536a) {
            int i12 = i11 - i10;
            byte[] bArr2 = this.f10539d;
            int length = bArr2.length;
            int i13 = this.f10537b + i12;
            if (length < i13) {
                this.f10539d = Arrays.copyOf(bArr2, i13 * 2);
            }
            System.arraycopy(bArr, i10, this.f10539d, this.f10537b, i12);
            this.f10537b += i12;
        }
    }
}
