package r3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10721a;

    /* renamed from: b, reason: collision with root package name */
    public final l1.y f10722b;

    /* renamed from: c, reason: collision with root package name */
    public final l1.t f10723c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f10724d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f10725e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10726f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public long f10727h;

    /* renamed from: i, reason: collision with root package name */
    public long f10728i;

    public x(int i10) {
        this.f10721a = i10;
        switch (i10) {
            case 1:
                this.f10722b = new l1.y(0L);
                this.g = -9223372036854775807L;
                this.f10727h = -9223372036854775807L;
                this.f10728i = -9223372036854775807L;
                this.f10723c = new l1.t();
                break;
            default:
                this.f10722b = new l1.y(0L);
                this.g = -9223372036854775807L;
                this.f10727h = -9223372036854775807L;
                this.f10728i = -9223372036854775807L;
                this.f10723c = new l1.t();
                break;
        }
    }

    public static int b(int i10, byte[] bArr) {
        return (bArr[i10 + 3] & 255) | ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8);
    }

    public static long c(l1.t tVar) {
        int i10 = tVar.f8130b;
        if (tVar.a() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        tVar.h(bArr, 0, 9);
        tVar.I(i10);
        byte b2 = bArr[0];
        if ((b2 & 196) == 68) {
            byte b10 = bArr[2];
            if ((b10 & 4) == 4) {
                byte b11 = bArr[4];
                if ((b11 & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
                    long j10 = b2;
                    long j11 = b10;
                    return ((j11 & 3) << 13) | ((j10 & 3) << 28) | (((56 & j10) >> 3) << 30) | ((bArr[1] & 255) << 20) | (((j11 & 248) >> 3) << 15) | ((bArr[3] & 255) << 5) | ((b11 & 248) >> 3);
                }
            }
        }
        return -9223372036854775807L;
    }

    public final void a(k2.o oVar) {
        switch (this.f10721a) {
            case 0:
                byte[] bArr = l1.a0.f8069c;
                l1.t tVar = this.f10723c;
                tVar.getClass();
                tVar.G(bArr.length, bArr);
                this.f10724d = true;
                oVar.h();
                break;
            default:
                byte[] bArr2 = l1.a0.f8069c;
                l1.t tVar2 = this.f10723c;
                tVar2.getClass();
                tVar2.G(bArr2.length, bArr2);
                this.f10724d = true;
                oVar.h();
                break;
        }
    }
}
