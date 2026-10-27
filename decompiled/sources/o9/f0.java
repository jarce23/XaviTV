package o9;

import java.util.Iterator;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends g0 {

    /* renamed from: q, reason: collision with root package name */
    public final transient int f9611q;

    /* renamed from: r, reason: collision with root package name */
    public final transient int f9612r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ g0 f9613s;

    public f0(g0 g0Var, int i10, int i11) {
        this.f9613s = g0Var;
        this.f9611q = i10;
        this.f9612r = i11;
    }

    @Override // java.util.List
    public final Object get(int i10) {
        com.bumptech.glide.e.g(i10, this.f9612r);
        return this.f9613s.get(i10 + this.f9611q);
    }

    @Override // o9.b0
    public final Object[] h() {
        return this.f9613s.h();
    }

    @Override // o9.b0
    public final int i() {
        return this.f9613s.j() + this.f9611q + this.f9612r;
    }

    @Override // o9.g0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return listIterator(0);
    }

    @Override // o9.b0
    public final int j() {
        return this.f9613s.j() + this.f9611q;
    }

    @Override // o9.b0
    public final boolean k() {
        return true;
    }

    @Override // o9.g0, java.util.List
    public final ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9612r;
    }

    @Override // o9.g0, java.util.List
    /* renamed from: u */
    public final g0 subList(int i10, int i11) {
        com.bumptech.glide.e.i(i10, i11, this.f9612r);
        int i12 = this.f9611q;
        return this.f9613s.subList(i10 + i12, i11 + i12);
    }

    @Override // o9.g0, java.util.List
    public final /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
        return listIterator(i10);
    }
}
