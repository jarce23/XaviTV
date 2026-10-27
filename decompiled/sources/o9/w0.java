package o9;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 extends g0 {

    /* renamed from: s, reason: collision with root package name */
    public static final w0 f9686s = new w0(0, new Object[0]);

    /* renamed from: q, reason: collision with root package name */
    public final transient Object[] f9687q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f9688r;

    public w0(int i10, Object[] objArr) {
        this.f9687q = objArr;
        this.f9688r = i10;
    }

    @Override // o9.g0, o9.b0
    public final int g(int i10, Object[] objArr) {
        Object[] objArr2 = this.f9687q;
        int i11 = this.f9688r;
        System.arraycopy(objArr2, 0, objArr, i10, i11);
        return i10 + i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        com.bumptech.glide.e.g(i10, this.f9688r);
        Object obj = this.f9687q[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // o9.b0
    public final Object[] h() {
        return this.f9687q;
    }

    @Override // o9.b0
    public final int i() {
        return this.f9688r;
    }

    @Override // o9.b0
    public final int j() {
        return 0;
    }

    @Override // o9.b0
    public final boolean k() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9688r;
    }
}
