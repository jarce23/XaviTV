package io.realm.internal;

import b4.j0;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsCollectionChangeSet implements h {

    /* renamed from: q, reason: collision with root package name */
    public static final long f6684q = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final long f6685o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f6686p;

    public OsCollectionChangeSet(long j10, boolean z10) {
        this.f6685o = j10;
        this.f6686p = z10;
        g.f6744b.a(this);
    }

    public static j0[] f(int[] iArr) {
        if (iArr == null) {
            return new j0[0];
        }
        int length = iArr.length / 2;
        j0[] j0VarArr = new j0[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            j0VarArr[i10] = new j0(iArr[i11], iArr[i11 + 1], 3);
        }
        return j0VarArr;
    }

    private static native long nativeGetFinalizerPtr();

    private static native int[] nativeGetRanges(long j10, int i10);

    public j0[] a() {
        return f(nativeGetRanges(this.f6685o, 2));
    }

    public j0[] b() {
        return f(nativeGetRanges(this.f6685o, 0));
    }

    public j0[] c() {
        return f(nativeGetRanges(this.f6685o, 1));
    }

    public boolean d() {
        return this.f6685o == 0;
    }

    public boolean e() {
        return this.f6686p;
    }

    @Override // io.realm.internal.h
    public long getNativeFinalizerPtr() {
        return f6684q;
    }

    @Override // io.realm.internal.h
    public long getNativePtr() {
        return this.f6685o;
    }

    public String toString() {
        if (this.f6685o == 0) {
            return "Change set is empty.";
        }
        return "Deletion Ranges: " + Arrays.toString(b()) + "\nInsertion Ranges: " + Arrays.toString(c()) + "\nChange Ranges: " + Arrays.toString(a());
    }
}
