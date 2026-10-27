package n7;

import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n extends m {

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f9244d;

    public n(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f9244d = bArr;
    }

    @Override // n7.m
    public final byte[] y0() {
        return this.f9244d;
    }
}
