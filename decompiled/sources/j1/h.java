package j1;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class h implements g {

    /* renamed from: b, reason: collision with root package name */
    public e f6956b;

    /* renamed from: c, reason: collision with root package name */
    public e f6957c;

    /* renamed from: d, reason: collision with root package name */
    public e f6958d;

    /* renamed from: e, reason: collision with root package name */
    public e f6959e;

    /* renamed from: f, reason: collision with root package name */
    public ByteBuffer f6960f;
    public ByteBuffer g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6961h;

    public h() {
        ByteBuffer byteBuffer = g.f6955a;
        this.f6960f = byteBuffer;
        this.g = byteBuffer;
        e eVar = e.f6950e;
        this.f6958d = eVar;
        this.f6959e = eVar;
        this.f6956b = eVar;
        this.f6957c = eVar;
    }

    @Override // j1.g
    public boolean a() {
        return this.f6959e != e.f6950e;
    }

    @Override // j1.g
    public boolean b() {
        return this.f6961h && this.g == g.f6955a;
    }

    @Override // j1.g
    public ByteBuffer c() {
        ByteBuffer byteBuffer = this.g;
        this.g = g.f6955a;
        return byteBuffer;
    }

    @Override // j1.g
    public final e d(e eVar) {
        this.f6958d = eVar;
        this.f6959e = g(eVar);
        return a() ? this.f6959e : e.f6950e;
    }

    @Override // j1.g
    public final void e() {
        this.f6961h = true;
        i();
    }

    @Override // j1.g
    public final void flush() {
        this.g = g.f6955a;
        this.f6961h = false;
        this.f6956b = this.f6958d;
        this.f6957c = this.f6959e;
        h();
    }

    public abstract e g(e eVar);

    public final ByteBuffer k(int i10) {
        if (this.f6960f.capacity() < i10) {
            this.f6960f = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        } else {
            this.f6960f.clear();
        }
        ByteBuffer byteBuffer = this.f6960f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    @Override // j1.g
    public final void reset() {
        ByteBuffer byteBuffer = g.f6955a;
        this.g = byteBuffer;
        this.f6961h = false;
        this.f6960f = byteBuffer;
        e eVar = e.f6950e;
        this.f6958d = eVar;
        this.f6959e = eVar;
        this.f6956b = eVar;
        this.f6957c = eVar;
        j();
    }

    public void h() {
    }

    public void i() {
    }

    public void j() {
    }
}
