package u1;

import java.nio.ByteBuffer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f0 extends j1.h {

    /* renamed from: i, reason: collision with root package name */
    public int f12203i;

    /* renamed from: j, reason: collision with root package name */
    public int f12204j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f12205k;

    /* renamed from: l, reason: collision with root package name */
    public int f12206l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f12207m;

    /* renamed from: n, reason: collision with root package name */
    public int f12208n;

    /* renamed from: o, reason: collision with root package name */
    public long f12209o;

    @Override // j1.h, j1.g
    public final boolean b() {
        return super.b() && this.f12208n == 0;
    }

    @Override // j1.h, j1.g
    public final ByteBuffer c() {
        int i10;
        if (super.b() && (i10 = this.f12208n) > 0) {
            k(i10).put(this.f12207m, 0, this.f12208n).flip();
            this.f12208n = 0;
        }
        return super.c();
    }

    @Override // j1.g
    public final void f(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i10 = limit - position;
        if (i10 == 0) {
            return;
        }
        int min = Math.min(i10, this.f12206l);
        this.f12209o += min / this.f6956b.f6954d;
        this.f12206l -= min;
        byteBuffer.position(position + min);
        if (this.f12206l > 0) {
            return;
        }
        int i11 = i10 - min;
        int length = (this.f12208n + i11) - this.f12207m.length;
        ByteBuffer k10 = k(length);
        int i12 = l1.a0.i(length, 0, this.f12208n);
        k10.put(this.f12207m, 0, i12);
        int i13 = l1.a0.i(length - i12, 0, i11);
        byteBuffer.limit(byteBuffer.position() + i13);
        k10.put(byteBuffer);
        byteBuffer.limit(limit);
        int i14 = i11 - i13;
        int i15 = this.f12208n - i12;
        this.f12208n = i15;
        byte[] bArr = this.f12207m;
        System.arraycopy(bArr, i12, bArr, 0, i15);
        byteBuffer.get(this.f12207m, this.f12208n, i14);
        this.f12208n += i14;
        k10.flip();
    }

    @Override // j1.h
    public final j1.e g(j1.e eVar) {
        if (!l1.a0.K(eVar.f6953c)) {
            throw new j1.f(eVar);
        }
        this.f12205k = true;
        return (this.f12203i == 0 && this.f12204j == 0) ? j1.e.f6950e : eVar;
    }

    @Override // j1.h
    public final void h() {
        if (this.f12205k) {
            this.f12205k = false;
            int i10 = this.f12204j;
            int i11 = this.f6956b.f6954d;
            this.f12207m = new byte[i10 * i11];
            this.f12206l = this.f12203i * i11;
        }
        this.f12208n = 0;
    }

    @Override // j1.h
    public final void i() {
        if (this.f12205k) {
            if (this.f12208n > 0) {
                this.f12209o += r0 / this.f6956b.f6954d;
            }
            this.f12208n = 0;
        }
    }

    @Override // j1.h
    public final void j() {
        this.f12207m = l1.a0.f8069c;
    }
}
