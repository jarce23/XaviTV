package c8;

import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f extends e {

    /* renamed from: s, reason: collision with root package name */
    public static final f f2966s = new f(0, new Object[0]);

    /* renamed from: q, reason: collision with root package name */
    public final transient Object[] f2967q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f2968r;

    public f(int i10, Object[] objArr) {
        this.f2967q = objArr;
        this.f2968r = i10;
    }

    @Override // c8.a
    public final Object[] f() {
        return this.f2967q;
    }

    @Override // c8.a
    public final int g() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        com.bumptech.glide.d.N(i10, this.f2968r);
        Object obj = this.f2967q[i10];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // c8.a
    public final int h() {
        return this.f2968r;
    }

    @Override // c8.e, c8.a
    public final int i(Object[] objArr) {
        Object[] objArr2 = this.f2967q;
        int i10 = this.f2968r;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f2968r;
    }
}
