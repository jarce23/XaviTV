package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i5 extends p4 implements RandomAccess, j5 {

    /* renamed from: p, reason: collision with root package name */
    public final List f3340p;

    static {
        new i5();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i5(int i10) {
        super(true);
        ArrayList arrayList = new ArrayList(i10);
        this.f3340p = arrayList;
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final Object a(int i10) {
        return this.f3340p.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        f();
        this.f3340p.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection collection) {
        f();
        if (collection instanceof j5) {
            collection = ((j5) collection).d();
        }
        boolean addAll = this.f3340p.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.cast.f5
    public final f5 c(int i10) {
        List list = this.f3340p;
        if (i10 < list.size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(list);
        return new i5(arrayList);
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        f();
        this.f3340p.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final List d() {
        return Collections.unmodifiableList(this.f3340p);
    }

    @Override // com.google.android.gms.internal.cast.j5
    public final j5 e() {
        return this.f3423o ? new k6(this) : this;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final String get(int i10) {
        String str;
        List list = this.f3340p;
        Object obj = list.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (!(obj instanceof t4)) {
            byte[] bArr = (byte[]) obj;
            String str2 = new String(bArr, g5.f3312a);
            f6 f6Var = r6.f3444a;
            int length = bArr.length;
            f6Var.getClass();
            if (f6.b(length, bArr)) {
                list.set(i10, str2);
            }
            return str2;
        }
        t4 t4Var = (t4) obj;
        Charset charset = g5.f3312a;
        if (t4Var.h() == 0) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        } else {
            str = new String(t4Var.f3478p, 0, t4Var.h(), charset);
        }
        int h10 = t4Var.h();
        byte[] bArr2 = t4Var.f3478p;
        r6.f3444a.getClass();
        if (f6.b(h10, bArr2)) {
            list.set(i10, str);
        }
        return str;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractList, java.util.List
    public final Object remove(int i10) {
        f();
        Object remove = this.f3340p.remove(i10);
        ((AbstractList) this).modCount++;
        if (remove instanceof String) {
            return (String) remove;
        }
        if (!(remove instanceof t4)) {
            return new String((byte[]) remove, g5.f3312a);
        }
        t4 t4Var = (t4) remove;
        Charset charset = g5.f3312a;
        if (t4Var.h() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        return new String(t4Var.f3478p, 0, t4Var.h(), charset);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i10, Object obj) {
        f();
        Object obj2 = this.f3340p.set(i10, (String) obj);
        if (obj2 instanceof String) {
            return (String) obj2;
        }
        if (!(obj2 instanceof t4)) {
            return new String((byte[]) obj2, g5.f3312a);
        }
        t4 t4Var = (t4) obj2;
        Charset charset = g5.f3312a;
        if (t4Var.h() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        return new String(t4Var.f3478p, 0, t4Var.h(), charset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f3340p.size();
    }

    public i5(ArrayList arrayList) {
        super(true);
        this.f3340p = arrayList;
    }

    public i5() {
        super(false);
        this.f3340p = Collections.EMPTY_LIST;
    }

    @Override // com.google.android.gms.internal.cast.p4, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(this.f3340p.size(), collection);
    }
}
