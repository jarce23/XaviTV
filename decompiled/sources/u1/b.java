package u1;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.util.SparseArray;
import c2.j1;
import java.util.Objects;
import o9.b1;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final b f12152c = new b(g0.r(a.f12146d));

    /* renamed from: d, reason: collision with root package name */
    public static final w0 f12153d;

    /* renamed from: e, reason: collision with root package name */
    public static final b1 f12154e;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f12155a = new SparseArray();

    /* renamed from: b, reason: collision with root package name */
    public final int f12156b;

    static {
        Object[] objArr = {2, 5, 6};
        o9.q.a(3, objArr);
        f12153d = g0.l(3, objArr);
        j1 j1Var = new j1(4);
        j1Var.q(5, 6);
        j1Var.q(17, 6);
        j1Var.q(7, 6);
        j1Var.q(30, 10);
        j1Var.q(18, 6);
        j1Var.q(6, 8);
        j1Var.q(8, 8);
        j1Var.q(14, 8);
        f12154e = j1Var.c();
    }

    public b(w0 w0Var) {
        for (int i10 = 0; i10 < w0Var.f9688r; i10++) {
            a aVar = (a) w0Var.get(i10);
            this.f12155a.put(aVar.f12147a, aVar);
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f12155a.size(); i12++) {
            i11 = Math.max(i11, ((a) this.f12155a.valueAt(i12)).f12148b);
        }
        this.f12156b = i11;
    }

    public static w0 a(int[] iArr, int i10) {
        o9.d0 m10 = g0.m();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i11 : iArr) {
            m10.a(new a(i11, i10));
        }
        return m10.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:86:0x025a, code lost:
    
        if (r4.equals("Xiaomi") == false) goto L86;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static u1.b b(android.content.Context r16, android.content.Intent r17, i1.d r18, p4.p r19) {
        /*
            Method dump skipped, instructions count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b.b(android.content.Context, android.content.Intent, i1.d, p4.p):u1.b");
    }

    public static b c(Context context, i1.d dVar, p4.p pVar) {
        return b(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), dVar, pVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ff, code lost:
    
        if (r11 != 5) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Pair d(i1.p r17, i1.d r18) {
        /*
            Method dump skipped, instructions count: 297
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b.d(i1.p, i1.d):android.util.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r1 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 1
            if (r8 != r9) goto L4
            goto L54
        L4:
            boolean r1 = r9 instanceof u1.b
            r2 = 0
            if (r1 != 0) goto La
            goto L55
        La:
            u1.b r9 = (u1.b) r9
            android.util.SparseArray r1 = r9.f12155a
            int r3 = l1.a0.f8067a
            android.util.SparseArray r3 = r8.f12155a
            if (r3 != 0) goto L1a
            if (r1 != 0) goto L18
        L16:
            r1 = r0
            goto L4c
        L18:
            r1 = r2
            goto L4c
        L1a:
            if (r1 != 0) goto L1d
            goto L18
        L1d:
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L28
            boolean r1 = a9.e.y(r3, r1)
            goto L4c
        L28:
            int r4 = r3.size()
            int r5 = r1.size()
            if (r4 == r5) goto L33
            goto L18
        L33:
            r5 = r2
        L34:
            if (r5 >= r4) goto L16
            int r6 = r3.keyAt(r5)
            java.lang.Object r7 = r3.valueAt(r5)
            java.lang.Object r6 = r1.get(r6)
            boolean r6 = java.util.Objects.equals(r7, r6)
            if (r6 != 0) goto L49
            goto L18
        L49:
            int r5 = r5 + 1
            goto L34
        L4c:
            if (r1 == 0) goto L55
            int r1 = r8.f12156b
            int r9 = r9.f12156b
            if (r1 != r9) goto L55
        L54:
            return r0
        L55:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: u1.b.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int i10;
        int i11 = l1.a0.f8067a;
        int i12 = Build.VERSION.SDK_INT;
        SparseArray sparseArray = this.f12155a;
        if (i12 >= 31) {
            i10 = sparseArray.contentHashCode();
        } else {
            i10 = 17;
            for (int i13 = 0; i13 < sparseArray.size(); i13++) {
                i10 = Objects.hashCode(sparseArray.valueAt(i13)) + ((sparseArray.keyAt(i13) + (i10 * 31)) * 31);
            }
        }
        return (i10 * 31) + this.f12156b;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f12156b + ", audioProfiles=" + this.f12155a + "]";
    }
}
