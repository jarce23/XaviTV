package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s4 extends t4 {

    /* renamed from: r, reason: collision with root package name */
    public final int f3451r;

    public s4(byte[] bArr) {
        super(bArr);
        t4.i(bArr.length);
        this.f3451r = 47;
    }

    @Override // com.google.android.gms.internal.cast.t4
    public final byte f(int i10) {
        int i11 = this.f3451r;
        if (((i11 - (i10 + 1)) | i10) >= 0) {
            return this.f3478p[i10];
        }
        if (i10 < 0) {
            throw new ArrayIndexOutOfBoundsException(android.support.v4.media.d.m(i10, "Index < 0: "));
        }
        throw new ArrayIndexOutOfBoundsException(android.support.v4.media.d.p("Index > length: ", ", ", i10, i11));
    }

    @Override // com.google.android.gms.internal.cast.t4
    public final byte g(int i10) {
        return this.f3478p[i10];
    }

    @Override // com.google.android.gms.internal.cast.t4
    public final int h() {
        return this.f3451r;
    }
}
