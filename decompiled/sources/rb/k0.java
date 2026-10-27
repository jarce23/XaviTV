package rb;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    public int f11032a;

    /* renamed from: b, reason: collision with root package name */
    public g[] f11033b;

    public final void a(g gVar, int i10) {
        while (true) {
            int i11 = i10 >> 1;
            if (i11 == 0) {
                break;
            }
            g gVar2 = this.f11033b[i11];
            za.h.b(gVar2);
            long timeoutNanos = gVar.timeoutNanos() - gVar2.timeoutNanos();
            if (0 < timeoutNanos || 0 == timeoutNanos) {
                break;
            }
            gVar2.index = i10;
            this.f11033b[i10] = gVar2;
            i10 = i11;
        }
        this.f11033b[i10] = gVar;
        gVar.index = i10;
    }

    public final void b(g gVar) {
        g gVar2;
        int i10 = gVar.index;
        if (i10 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i11 = this.f11032a;
        g gVar3 = this.f11033b[i11];
        za.h.b(gVar3);
        gVar.index = -1;
        this.f11033b[i11] = null;
        this.f11032a = i11 - 1;
        if (gVar == gVar3) {
            return;
        }
        long timeoutNanos = gVar3.timeoutNanos() - gVar.timeoutNanos();
        char c10 = 0 >= timeoutNanos ? 0 == timeoutNanos ? (char) 0 : (char) 1 : (char) 65535;
        if (c10 == 0) {
            this.f11033b[i10] = gVar3;
            gVar3.index = i10;
            return;
        }
        if (c10 >= 0) {
            a(gVar3, i10);
            return;
        }
        while (true) {
            int i12 = i10 << 1;
            int i13 = i12 + 1;
            int i14 = this.f11032a;
            if (i13 > i14) {
                if (i12 > i14) {
                    break;
                }
                gVar2 = this.f11033b[i12];
                za.h.b(gVar2);
            } else {
                gVar2 = this.f11033b[i12];
                za.h.b(gVar2);
                g gVar4 = this.f11033b[i13];
                za.h.b(gVar4);
                if (0 >= gVar4.timeoutNanos() - gVar2.timeoutNanos()) {
                    gVar2 = gVar4;
                }
            }
            long timeoutNanos2 = gVar2.timeoutNanos() - gVar3.timeoutNanos();
            if (0 < timeoutNanos2 || 0 == timeoutNanos2) {
                break;
            }
            int i15 = gVar2.index;
            gVar2.index = i10;
            this.f11033b[i10] = gVar2;
            i10 = i15;
        }
        this.f11033b[i10] = gVar3;
        gVar3.index = i10;
    }
}
