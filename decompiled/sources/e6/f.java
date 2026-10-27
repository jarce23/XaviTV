package e6;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import m6.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class f implements j6.c {

    /* renamed from: o, reason: collision with root package name */
    public final int f4640o;

    /* renamed from: p, reason: collision with root package name */
    public final int f4641p;

    /* renamed from: q, reason: collision with root package name */
    public i6.c f4642q;

    /* renamed from: r, reason: collision with root package name */
    public final Handler f4643r;

    /* renamed from: s, reason: collision with root package name */
    public final int f4644s;

    /* renamed from: t, reason: collision with root package name */
    public final long f4645t;

    /* renamed from: u, reason: collision with root package name */
    public Bitmap f4646u;

    public f(Handler handler, int i10, long j10) {
        if (!n.i(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
        }
        this.f4640o = Integer.MIN_VALUE;
        this.f4641p = Integer.MIN_VALUE;
        this.f4643r = handler;
        this.f4644s = i10;
        this.f4645t = j10;
    }

    @Override // j6.c
    public final void e(i6.f fVar) {
        fVar.l(this.f4640o, this.f4641p);
    }

    @Override // j6.c
    public final i6.c f() {
        return this.f4642q;
    }

    @Override // j6.c
    public final void g(Drawable drawable) {
        this.f4646u = null;
    }

    @Override // j6.c
    public final void h(Object obj) {
        this.f4646u = (Bitmap) obj;
        Handler handler = this.f4643r;
        handler.sendMessageAtTime(handler.obtainMessage(1, this), this.f4645t);
    }

    @Override // j6.c
    public final void i(i6.c cVar) {
        this.f4642q = cVar;
    }

    @Override // com.bumptech.glide.manager.h
    public final void b() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void j() {
    }

    @Override // com.bumptech.glide.manager.h
    public final void k() {
    }

    @Override // j6.c
    public final void a(Drawable drawable) {
    }

    @Override // j6.c
    public final void c(i6.f fVar) {
    }

    @Override // j6.c
    public final void d(Drawable drawable) {
    }
}
