package l1;

import android.graphics.SurfaceTexture;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.os.Handler;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* renamed from: u, reason: collision with root package name */
    public static final int[] f8092u = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* renamed from: o, reason: collision with root package name */
    public final Handler f8093o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f8094p = new int[1];

    /* renamed from: q, reason: collision with root package name */
    public EGLDisplay f8095q;

    /* renamed from: r, reason: collision with root package name */
    public EGLContext f8096r;

    /* renamed from: s, reason: collision with root package name */
    public EGLSurface f8097s;

    /* renamed from: t, reason: collision with root package name */
    public SurfaceTexture f8098t;

    public i(Handler handler) {
        this.f8093o = handler;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f8093o.post(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        SurfaceTexture surfaceTexture = this.f8098t;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
