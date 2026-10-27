package io.realm.internal;

import io.realm.internal.objectstore.OsKeyPathMapping;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class TableQuery implements h {

    /* renamed from: s, reason: collision with root package name */
    public static final long f6720s = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final Table f6721o;

    /* renamed from: p, reason: collision with root package name */
    public final long f6722p;

    /* renamed from: q, reason: collision with root package name */
    public final n7.i f6723q = new n7.i(25);

    /* renamed from: r, reason: collision with root package name */
    public boolean f6724r = true;

    public TableQuery(g gVar, Table table, long j10) {
        this.f6721o = table;
        this.f6722p = j10;
        gVar.a(this);
    }

    public static String d(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(" ", "\\ ");
    }

    private native void nativeBeginGroup(long j10);

    private native void nativeEndGroup(long j10);

    private native long nativeFind(long j10);

    private static native long nativeGetFinalizerPtr();

    private native void nativeNot(long j10);

    private native void nativeOr(long j10);

    private native void nativeRawDescriptor(long j10, String str, long j11);

    private native void nativeRawPredicate(long j10, String str, long[] jArr, long j11);

    private native String nativeValidateQuery(long j10);

    public final void a() {
        nativeBeginGroup(this.f6722p);
        this.f6724r = false;
    }

    public final void b() {
        nativeEndGroup(this.f6722p);
        this.f6724r = false;
    }

    public final void c(OsKeyPathMapping osKeyPathMapping, String str, io.realm.w wVar) {
        n7.i.z(this, osKeyPathMapping, d(str) + " = $0", wVar);
        this.f6724r = false;
    }

    public final long e() {
        j();
        return nativeFind(this.f6722p);
    }

    public final void f() {
        nativeNot(this.f6722p);
        this.f6724r = false;
    }

    public final void g() {
        nativeOr(this.f6722p);
        this.f6724r = false;
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6720s;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6722p;
    }

    public final void h(OsKeyPathMapping osKeyPathMapping, String str, long... jArr) {
        nativeRawPredicate(this.f6722p, str, jArr, osKeyPathMapping != null ? osKeyPathMapping.f6754o : 0L);
    }

    public final void i(OsKeyPathMapping osKeyPathMapping, String[] strArr, int[] iArr) {
        StringBuilder sb2 = new StringBuilder("SORT(");
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        int i10 = 0;
        while (i10 < strArr.length) {
            String str2 = strArr[i10];
            sb2.append(str);
            sb2.append(d(str2));
            sb2.append(" ");
            sb2.append(iArr[i10] == 1 ? "ASC" : "DESC");
            i10++;
            str = ", ";
        }
        sb2.append(")");
        nativeRawDescriptor(this.f6722p, sb2.toString(), osKeyPathMapping != null ? osKeyPathMapping.f6754o : 0L);
    }

    public final void j() {
        if (this.f6724r) {
            return;
        }
        String nativeValidateQuery = nativeValidateQuery(this.f6722p);
        if (!_UrlKt.FRAGMENT_ENCODE_SET.equals(nativeValidateQuery)) {
            throw new UnsupportedOperationException(nativeValidateQuery);
        }
        this.f6724r = true;
    }
}
