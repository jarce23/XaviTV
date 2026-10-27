package j1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements g {

    /* renamed from: b, reason: collision with root package name */
    public int f6984b;

    /* renamed from: c, reason: collision with root package name */
    public float f6985c;

    /* renamed from: d, reason: collision with root package name */
    public float f6986d;

    /* renamed from: e, reason: collision with root package name */
    public e f6987e;

    /* renamed from: f, reason: collision with root package name */
    public e f6988f;
    public e g;

    /* renamed from: h, reason: collision with root package name */
    public e f6989h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f6990i;

    /* renamed from: j, reason: collision with root package name */
    public i f6991j;

    /* renamed from: k, reason: collision with root package name */
    public ByteBuffer f6992k;

    /* renamed from: l, reason: collision with root package name */
    public ShortBuffer f6993l;

    /* renamed from: m, reason: collision with root package name */
    public ByteBuffer f6994m;

    /* renamed from: n, reason: collision with root package name */
    public long f6995n;

    /* renamed from: o, reason: collision with root package name */
    public long f6996o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f6997p;

    @Override // j1.g
    public final boolean a() {
        if (this.f6988f.f6951a != -1) {
            return Math.abs(this.f6985c - 1.0f) >= 1.0E-4f || Math.abs(this.f6986d - 1.0f) >= 1.0E-4f || this.f6988f.f6951a != this.f6987e.f6951a;
        }
        return false;
    }

    @Override // j1.g
    public final boolean b() {
        if (this.f6997p) {
            i iVar = this.f6991j;
            if (iVar != null) {
                l1.d.g(iVar.f6973m >= 0);
                if (iVar.f6973m * iVar.f6963b * 2 == 0) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // j1.g
    public final ByteBuffer c() {
        i iVar = this.f6991j;
        if (iVar != null) {
            int i10 = iVar.f6963b;
            l1.d.g(iVar.f6973m >= 0);
            int i11 = iVar.f6973m * i10 * 2;
            if (i11 > 0) {
                if (this.f6992k.capacity() < i11) {
                    ByteBuffer order = ByteBuffer.allocateDirect(i11).order(ByteOrder.nativeOrder());
                    this.f6992k = order;
                    this.f6993l = order.asShortBuffer();
                } else {
                    this.f6992k.clear();
                    this.f6993l.clear();
                }
                ShortBuffer shortBuffer = this.f6993l;
                l1.d.g(iVar.f6973m >= 0);
                int min = Math.min(shortBuffer.remaining() / i10, iVar.f6973m);
                int i12 = min * i10;
                shortBuffer.put(iVar.f6972l, 0, i12);
                int i13 = iVar.f6973m - min;
                iVar.f6973m = i13;
                short[] sArr = iVar.f6972l;
                System.arraycopy(sArr, i12, sArr, 0, i13 * i10);
                this.f6996o += i11;
                this.f6992k.limit(i11);
                this.f6994m = this.f6992k;
            }
        }
        ByteBuffer byteBuffer = this.f6994m;
        this.f6994m = g.f6955a;
        return byteBuffer;
    }

    @Override // j1.g
    public final e d(e eVar) {
        if (eVar.f6953c != 2) {
            throw new f(eVar);
        }
        int i10 = this.f6984b;
        if (i10 == -1) {
            i10 = eVar.f6951a;
        }
        this.f6987e = eVar;
        e eVar2 = new e(i10, eVar.f6952b, 2);
        this.f6988f = eVar2;
        this.f6990i = true;
        return eVar2;
    }

    @Override // j1.g
    public final void e() {
        i iVar = this.f6991j;
        if (iVar != null) {
            int i10 = iVar.f6971k;
            float f10 = iVar.f6964c;
            float f11 = iVar.f6965d;
            double d6 = f10 / f11;
            int i11 = iVar.f6973m + ((int) (((((((i10 - r6) / d6) + iVar.f6978r) + iVar.f6983w) + iVar.f6975o) / (iVar.f6966e * f11)) + 0.5d));
            iVar.f6983w = 0.0d;
            short[] sArr = iVar.f6970j;
            int i12 = iVar.f6968h * 2;
            iVar.f6970j = iVar.c(sArr, i10, i12 + i10);
            int i13 = 0;
            while (true) {
                int i14 = iVar.f6963b;
                if (i13 >= i12 * i14) {
                    break;
                }
                iVar.f6970j[(i14 * i10) + i13] = 0;
                i13++;
            }
            iVar.f6971k = i12 + iVar.f6971k;
            iVar.f();
            if (iVar.f6973m > i11) {
                iVar.f6973m = Math.max(i11, 0);
            }
            iVar.f6971k = 0;
            iVar.f6978r = 0;
            iVar.f6975o = 0;
        }
        this.f6997p = true;
    }

    @Override // j1.g
    public final void f(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            i iVar = this.f6991j;
            iVar.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f6995n += remaining;
            int remaining2 = asShortBuffer.remaining();
            int i10 = iVar.f6963b;
            int i11 = remaining2 / i10;
            short[] c10 = iVar.c(iVar.f6970j, iVar.f6971k, i11);
            iVar.f6970j = c10;
            asShortBuffer.get(c10, iVar.f6971k * i10, ((i11 * i10) * 2) / 2);
            iVar.f6971k += i11;
            iVar.f();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    @Override // j1.g
    public final void flush() {
        if (a()) {
            e eVar = this.f6987e;
            this.g = eVar;
            e eVar2 = this.f6988f;
            this.f6989h = eVar2;
            if (this.f6990i) {
                this.f6991j = new i(eVar.f6951a, eVar.f6952b, this.f6985c, this.f6986d, eVar2.f6951a);
            } else {
                i iVar = this.f6991j;
                if (iVar != null) {
                    iVar.f6971k = 0;
                    iVar.f6973m = 0;
                    iVar.f6975o = 0;
                    iVar.f6976p = 0;
                    iVar.f6977q = 0;
                    iVar.f6978r = 0;
                    iVar.f6979s = 0;
                    iVar.f6980t = 0;
                    iVar.f6981u = 0;
                    iVar.f6982v = 0;
                    iVar.f6983w = 0.0d;
                }
            }
        }
        this.f6994m = g.f6955a;
        this.f6995n = 0L;
        this.f6996o = 0L;
        this.f6997p = false;
    }

    @Override // j1.g
    public final void reset() {
        this.f6985c = 1.0f;
        this.f6986d = 1.0f;
        e eVar = e.f6950e;
        this.f6987e = eVar;
        this.f6988f = eVar;
        this.g = eVar;
        this.f6989h = eVar;
        ByteBuffer byteBuffer = g.f6955a;
        this.f6992k = byteBuffer;
        this.f6993l = byteBuffer.asShortBuffer();
        this.f6994m = byteBuffer;
        this.f6984b = -1;
        this.f6990i = false;
        this.f6991j = null;
        this.f6995n = 0L;
        this.f6996o = 0L;
        this.f6997p = false;
    }
}
