package a6;

import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h0 implements t5.y {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f63o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f64p;

    public /* synthetic */ h0(int i10, Object obj) {
        this.f63o = i10;
        this.f64p = obj;
    }

    @Override // t5.y
    public final int c() {
        int intrinsicWidth;
        int intrinsicHeight;
        switch (this.f63o) {
            case 0:
                return m6.n.c((Bitmap) this.f64p);
            case 1:
                return ((byte[]) this.f64p).length;
            case 2:
                intrinsicWidth = ((AnimatedImageDrawable) this.f64p).getIntrinsicWidth();
                intrinsicHeight = ((AnimatedImageDrawable) this.f64p).getIntrinsicHeight();
                return m6.n.d(Bitmap.Config.ARGB_8888) * intrinsicHeight * intrinsicWidth * 2;
            default:
                return 1;
        }
    }

    @Override // t5.y
    public final Class d() {
        switch (this.f63o) {
            case 0:
                return Bitmap.class;
            case 1:
                return byte[].class;
            case 2:
                return Drawable.class;
            default:
                return ((File) this.f64p).getClass();
        }
    }

    @Override // t5.y
    public final void e() {
        switch (this.f63o) {
            case 2:
                ((AnimatedImageDrawable) this.f64p).stop();
                ((AnimatedImageDrawable) this.f64p).clearAnimationCallbacks();
                break;
        }
    }

    @Override // t5.y
    public final Object get() {
        switch (this.f63o) {
            case 0:
                return (Bitmap) this.f64p;
            case 1:
                return (byte[]) this.f64p;
            case 2:
                return (AnimatedImageDrawable) this.f64p;
            default:
                return (File) this.f64p;
        }
    }

    public h0(byte[] bArr) {
        this.f63o = 1;
        m6.f.c("Argument must not be null", bArr);
        this.f64p = bArr;
    }

    public h0(File file) {
        this.f63o = 3;
        m6.f.c("Argument must not be null", file);
        this.f64p = file;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void f() {
    }
}
