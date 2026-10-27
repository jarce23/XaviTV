package g7;

import android.os.Bundle;
import com.google.android.gms.cast.CastDevice;
import h7.h0;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements o7.b {

    /* renamed from: b, reason: collision with root package name */
    public final CastDevice f5202b;

    /* renamed from: c, reason: collision with root package name */
    public final h0 f5203c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f5204d;

    /* renamed from: e, reason: collision with root package name */
    public final String f5205e = UUID.randomUUID().toString();

    public /* synthetic */ e(android.support.v4.media.session.a0 a0Var) {
        this.f5202b = (CastDevice) a0Var.f230p;
        this.f5203c = (h0) a0Var.f231q;
        this.f5204d = (Bundle) a0Var.f232r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
    
        if (r3 == r1) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L4
            return r0
        L4:
            boolean r1 = r8 instanceof g7.e
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            g7.e r8 = (g7.e) r8
            com.google.android.gms.cast.CastDevice r1 = r7.f5202b
            com.google.android.gms.cast.CastDevice r3 = r8.f5202b
            boolean r1 = r7.r.h(r1, r3)
            if (r1 == 0) goto L65
            android.os.Bundle r1 = r8.f5204d
            android.os.Bundle r3 = r7.f5204d
            if (r3 == 0) goto L58
            if (r1 != 0) goto L1f
            goto L58
        L1f:
            int r4 = r3.size()
            int r5 = r1.size()
            if (r4 == r5) goto L2a
            goto L65
        L2a:
            java.util.Set r4 = r3.keySet()
            java.util.Set r5 = r1.keySet()
            boolean r5 = r4.containsAll(r5)
            if (r5 != 0) goto L39
            goto L65
        L39:
            java.util.Iterator r4 = r4.iterator()
        L3d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L5a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.get(r5)
            java.lang.Object r5 = r1.get(r5)
            boolean r5 = r7.r.h(r6, r5)
            if (r5 != 0) goto L3d
            goto L65
        L58:
            if (r3 != r1) goto L65
        L5a:
            java.lang.String r1 = r7.f5205e
            java.lang.String r8 = r8.f5205e
            boolean r8 = r7.r.h(r1, r8)
            if (r8 == 0) goto L65
            return r0
        L65:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: g7.e.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5202b, this.f5204d, 0, this.f5205e});
    }
}
