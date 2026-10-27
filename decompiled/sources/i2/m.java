package i2;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends HandlerThread implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public l1.i f6254o;

    /* renamed from: p, reason: collision with root package name */
    public Handler f6255p;

    /* renamed from: q, reason: collision with root package name */
    public Error f6256q;

    /* renamed from: r, reason: collision with root package name */
    public RuntimeException f6257r;

    /* renamed from: s, reason: collision with root package name */
    public n f6258s;

    public final void a(int i10) {
        EGLSurface eglCreatePbufferSurface;
        this.f6254o.getClass();
        l1.i iVar = this.f6254o;
        int[] iArr = iVar.f8094p;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        l1.b.d("eglGetDisplay failed", eglGetDisplay != null);
        int[] iArr2 = new int[2];
        l1.b.d("eglInitialize failed", EGL14.eglInitialize(eglGetDisplay, iArr2, 0, iArr2, 1));
        iVar.f8095q = eglGetDisplay;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr3 = new int[1];
        boolean eglChooseConfig = EGL14.eglChooseConfig(eglGetDisplay, l1.i.f8092u, 0, eGLConfigArr, 0, 1, iArr3, 0);
        boolean z10 = eglChooseConfig && iArr3[0] > 0 && eGLConfigArr[0] != null;
        Object[] objArr = {Boolean.valueOf(eglChooseConfig), Integer.valueOf(iArr3[0]), eGLConfigArr[0]};
        int i11 = l1.a0.f8067a;
        l1.b.d(String.format(Locale.US, "eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", objArr), z10);
        EGLConfig eGLConfig = eGLConfigArr[0];
        EGLContext eglCreateContext = EGL14.eglCreateContext(iVar.f8095q, eGLConfig, EGL14.EGL_NO_CONTEXT, i10 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        l1.b.d("eglCreateContext failed", eglCreateContext != null);
        iVar.f8096r = eglCreateContext;
        EGLDisplay eGLDisplay = iVar.f8095q;
        if (i10 == 1) {
            eglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i10 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            l1.b.d("eglCreatePbufferSurface failed", eglCreatePbufferSurface != null);
        }
        l1.b.d("eglMakeCurrent failed", EGL14.eglMakeCurrent(eGLDisplay, eglCreatePbufferSurface, eglCreatePbufferSurface, eglCreateContext));
        iVar.f8097s = eglCreatePbufferSurface;
        GLES20.glGenTextures(1, iArr, 0);
        l1.b.c();
        SurfaceTexture surfaceTexture = new SurfaceTexture(iArr[0]);
        iVar.f8098t = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(iVar);
        SurfaceTexture surfaceTexture2 = this.f6254o.f8098t;
        surfaceTexture2.getClass();
        this.f6258s = new n(this, surfaceTexture2, i10 != 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        this.f6254o.getClass();
        l1.i iVar = this.f6254o;
        iVar.f8093o.removeCallbacks(iVar);
        try {
            SurfaceTexture surfaceTexture = iVar.f8098t;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, iVar.f8094p, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = iVar.f8095q;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = iVar.f8095q;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = iVar.f8097s;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(iVar.f8095q, iVar.f8097s);
            }
            EGLContext eGLContext = iVar.f8096r;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(iVar.f8095q, eGLContext);
            }
            EGL14.eglReleaseThread();
            EGLDisplay eGLDisplay3 = iVar.f8095q;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(iVar.f8095q);
            }
            iVar.f8095q = null;
            iVar.f8096r = null;
            iVar.f8097s = null;
            iVar.f8098t = null;
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        try {
            if (i10 == 1) {
                try {
                    a(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                    return true;
                } catch (Error e7) {
                    l1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e7);
                    this.f6256q = e7;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e8) {
                    l1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e8);
                    this.f6257r = e8;
                    synchronized (this) {
                        notify();
                    }
                } catch (l1.j e10) {
                    l1.b.h("PlaceholderSurface", "Failed to initialize placeholder surface", e10);
                    this.f6257r = new IllegalStateException(e10);
                    synchronized (this) {
                        notify();
                    }
                }
            } else if (i10 == 2) {
                try {
                    b();
                    return true;
                } catch (Throwable th) {
                    try {
                        l1.b.h("PlaceholderSurface", "Failed to release placeholder surface", th);
                        return true;
                    } finally {
                        quit();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }
}
