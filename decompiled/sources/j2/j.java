package j2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements GLSurfaceView.Renderer, c {

    /* renamed from: o, reason: collision with root package name */
    public final i f7032o;

    /* renamed from: r, reason: collision with root package name */
    public final float[] f7035r;

    /* renamed from: s, reason: collision with root package name */
    public final float[] f7036s;

    /* renamed from: t, reason: collision with root package name */
    public final float[] f7037t;

    /* renamed from: u, reason: collision with root package name */
    public float f7038u;

    /* renamed from: v, reason: collision with root package name */
    public float f7039v;

    /* renamed from: y, reason: collision with root package name */
    public final /* synthetic */ k f7042y;

    /* renamed from: p, reason: collision with root package name */
    public final float[] f7033p = new float[16];

    /* renamed from: q, reason: collision with root package name */
    public final float[] f7034q = new float[16];

    /* renamed from: w, reason: collision with root package name */
    public final float[] f7040w = new float[16];

    /* renamed from: x, reason: collision with root package name */
    public final float[] f7041x = new float[16];

    public j(k kVar, i iVar) {
        this.f7042y = kVar;
        float[] fArr = new float[16];
        this.f7035r = fArr;
        float[] fArr2 = new float[16];
        this.f7036s = fArr2;
        float[] fArr3 = new float[16];
        this.f7037t = fArr3;
        this.f7032o = iVar;
        Matrix.setIdentityM(fArr, 0);
        Matrix.setIdentityM(fArr2, 0);
        Matrix.setIdentityM(fArr3, 0);
        this.f7039v = 3.1415927f;
    }

    @Override // j2.c
    public final synchronized void a(float[] fArr, float f10) {
        float[] fArr2 = this.f7035r;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        float f11 = -f10;
        this.f7039v = f11;
        Matrix.setRotateM(this.f7036s, 0, -this.f7038u, (float) Math.cos(f11), (float) Math.sin(this.f7039v), 0.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        synchronized (this) {
            Matrix.multiplyMM(this.f7041x, 0, this.f7035r, 0, this.f7037t, 0);
            Matrix.multiplyMM(this.f7040w, 0, this.f7036s, 0, this.f7041x, 0);
        }
        Matrix.multiplyMM(this.f7034q, 0, this.f7033p, 0, this.f7040w, 0);
        this.f7032o.c(this.f7034q);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
        float f10 = i10 / i11;
        Matrix.perspectiveM(this.f7033p, 0, f10 > 1.0f ? (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / f10)) * 2.0d) : 90.0f, f10, 0.1f, 100.0f);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        k kVar = this.f7042y;
        kVar.f7048s.post(new androidx.fragment.app.d(kVar, 11, this.f7032o.e()));
    }
}
