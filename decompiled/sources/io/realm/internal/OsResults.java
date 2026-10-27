package io.realm.internal;

import d5.l0;
import io.realm.n0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsResults implements h, ObservableCollection {

    /* renamed from: u, reason: collision with root package name */
    public static final long f6701u = nativeGetFinalizerPtr();

    /* renamed from: v, reason: collision with root package name */
    public static final /* synthetic */ int f6702v = 0;

    /* renamed from: o, reason: collision with root package name */
    public final long f6703o;

    /* renamed from: p, reason: collision with root package name */
    public final OsSharedRealm f6704p;

    /* renamed from: q, reason: collision with root package name */
    public final Table f6705q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f6706r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6707s = false;

    /* renamed from: t, reason: collision with root package name */
    public final n f6708t = new n();

    public OsResults(OsSharedRealm osSharedRealm, Table table, long j10) {
        boolean z10 = false;
        this.f6704p = osSharedRealm;
        g gVar = osSharedRealm.context;
        this.f6705q = table;
        this.f6703o = j10;
        gVar.a(this);
        byte nativeGetMode = nativeGetMode(j10);
        if (nativeGetMode != 0 && nativeGetMode != 1 && nativeGetMode != 2) {
            if (nativeGetMode != 3) {
                if (nativeGetMode != 4) {
                    throw new IllegalArgumentException(android.support.v4.media.d.m(nativeGetMode, "Invalid value: "));
                }
            }
            this.f6706r = z10;
        }
        z10 = true;
        this.f6706r = z10;
    }

    private static native void nativeClear(long j10);

    public static native long nativeCreateResults(long j10, long j11);

    private static native long nativeCreateSnapshot(long j10);

    private static native void nativeEvaluateQueryIfNeeded(long j10, boolean z10);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j10);

    private static native long nativeGetRow(long j10, int i10);

    private static native boolean nativeIsValid(long j10);

    private static native long nativeSize(long j10);

    private native void nativeStartListening(long j10);

    private native void nativeStopListening(long j10);

    public final void a(n0 n0Var, l0 l0Var) {
        n nVar = this.f6708t;
        if (nVar.f6751a.isEmpty()) {
            nativeStartListening(this.f6703o);
        }
        nVar.a(new k(n0Var, l0Var));
    }

    public final void b() {
        nativeClear(this.f6703o);
    }

    public final OsResults c() {
        if (this.f6707s) {
            return this;
        }
        OsResults osResults = new OsResults(this.f6704p, this.f6705q, nativeCreateSnapshot(this.f6703o));
        osResults.f6707s = true;
        return osResults;
    }

    public final UncheckedRow d(int i10) {
        long nativeGetRow = nativeGetRow(this.f6703o, i10);
        Table table = this.f6705q;
        return new UncheckedRow(table.f6718p, table, nativeGetRow);
    }

    public final boolean e() {
        return nativeIsValid(this.f6703o);
    }

    public final void f() {
        if (this.f6706r) {
            return;
        }
        try {
            nativeEvaluateQueryIfNeeded(this.f6703o, false);
        } catch (IllegalArgumentException e7) {
            if (e7.getMessage().contains("Cannot sort on a collection property")) {
                throw new IllegalStateException("Illegal Argument: " + e7.getMessage());
            }
        } catch (IllegalStateException e8) {
            throw new IllegalArgumentException("Illegal Argument: " + e8.getMessage());
        }
        notifyChangeListeners(0L);
    }

    public final void g(n0 n0Var, l0 l0Var) {
        n nVar = this.f6708t;
        nVar.c(n0Var, l0Var);
        if (nVar.f6751a.isEmpty()) {
            nativeStopListening(this.f6703o);
        }
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6701u;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6703o;
    }

    public final long h() {
        return nativeSize(this.f6703o);
    }

    @Override // io.realm.internal.ObservableCollection
    public final void notifyChangeListeners(long j10) {
        OsCollectionChangeSet dVar = j10 == 0 ? new d(0L, true) : new OsCollectionChangeSet(j10, !this.f6706r);
        if (dVar.d() && this.f6706r) {
            return;
        }
        this.f6706r = true;
        this.f6708t.b(new i(1, dVar));
    }
}
