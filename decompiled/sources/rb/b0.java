package rb;

import java.security.MessageDigest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 extends w {

    /* renamed from: o, reason: collision with root package name */
    public final MessageDigest f10996o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(h hVar) {
        super(hVar);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        za.h.d("getInstance(...)", messageDigest);
        this.f10996o = messageDigest;
    }

    @Override // rb.w, rb.q0
    public final void write(l lVar, long j10) {
        za.h.e("source", lVar);
        b.e(lVar.f11035p, 0L, j10);
        n0 n0Var = lVar.f11034o;
        za.h.b(n0Var);
        long j11 = 0;
        while (j11 < j10) {
            int min = (int) Math.min(j10 - j11, n0Var.f11044c - n0Var.f11043b);
            MessageDigest messageDigest = this.f10996o;
            if (messageDigest == null) {
                za.h.b(null);
                throw null;
            }
            messageDigest.update(n0Var.f11042a, n0Var.f11043b, min);
            j11 += min;
            n0Var = n0Var.f11047f;
            za.h.b(n0Var);
        }
        super.write(lVar, j10);
    }
}
