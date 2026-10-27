package j1;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import o9.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final g0 f6946a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f6947b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public ByteBuffer[] f6948c = new ByteBuffer[0];

    /* renamed from: d, reason: collision with root package name */
    public boolean f6949d;

    public d(g0 g0Var) {
        this.f6946a = g0Var;
        e eVar = e.f6950e;
        this.f6949d = false;
    }

    public final void a() {
        ArrayList arrayList = this.f6947b;
        arrayList.clear();
        this.f6949d = false;
        int i10 = 0;
        while (true) {
            g0 g0Var = this.f6946a;
            if (i10 >= g0Var.size()) {
                break;
            }
            g gVar = (g) g0Var.get(i10);
            gVar.flush();
            if (gVar.a()) {
                arrayList.add(gVar);
            }
            i10++;
        }
        this.f6948c = new ByteBuffer[arrayList.size()];
        for (int i11 = 0; i11 <= b(); i11++) {
            this.f6948c[i11] = ((g) arrayList.get(i11)).c();
        }
    }

    public final int b() {
        return this.f6948c.length - 1;
    }

    public final boolean c() {
        return this.f6949d && ((g) this.f6947b.get(b())).b() && !this.f6948c[b()].hasRemaining();
    }

    public final boolean d() {
        return !this.f6947b.isEmpty();
    }

    public final void e(ByteBuffer byteBuffer) {
        boolean z10;
        for (boolean z11 = true; z11; z11 = z10) {
            z10 = false;
            int i10 = 0;
            while (i10 <= b()) {
                if (!this.f6948c[i10].hasRemaining()) {
                    ArrayList arrayList = this.f6947b;
                    g gVar = (g) arrayList.get(i10);
                    if (!gVar.b()) {
                        ByteBuffer byteBuffer2 = i10 > 0 ? this.f6948c[i10 - 1] : byteBuffer.hasRemaining() ? byteBuffer : g.f6955a;
                        long remaining = byteBuffer2.remaining();
                        gVar.f(byteBuffer2);
                        this.f6948c[i10] = gVar.c();
                        z10 |= remaining - ((long) byteBuffer2.remaining()) > 0 || this.f6948c[i10].hasRemaining();
                    } else if (!this.f6948c[i10].hasRemaining() && i10 < b()) {
                        ((g) arrayList.get(i10 + 1)).e();
                    }
                }
                i10++;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        g0 g0Var = ((d) obj).f6946a;
        g0 g0Var2 = this.f6946a;
        if (g0Var2.size() != g0Var.size()) {
            return false;
        }
        for (int i10 = 0; i10 < g0Var2.size(); i10++) {
            if (g0Var2.get(i10) != g0Var.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        return this.f6946a.hashCode();
    }
}
