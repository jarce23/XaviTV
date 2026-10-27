package i2;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class v implements GLSurfaceView.Renderer {

    /* renamed from: v, reason: collision with root package name */
    public static final String[] f6293v = {"y_tex", "u_tex", "v_tex"};

    /* renamed from: w, reason: collision with root package name */
    public static final FloatBuffer f6294w = l1.b.e(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});

    /* renamed from: o, reason: collision with root package name */
    public final w f6295o;

    /* renamed from: p, reason: collision with root package name */
    public final int[] f6296p = new int[3];

    /* renamed from: q, reason: collision with root package name */
    public final int[] f6297q = new int[3];

    /* renamed from: r, reason: collision with root package name */
    public final int[] f6298r = new int[3];

    /* renamed from: s, reason: collision with root package name */
    public final int[] f6299s = new int[3];

    /* renamed from: t, reason: collision with root package name */
    public final AtomicReference f6300t = new AtomicReference();

    /* renamed from: u, reason: collision with root package name */
    public f3.j f6301u;

    public v(w wVar) {
        this.f6295o = wVar;
        for (int i10 = 0; i10 < 3; i10++) {
            int[] iArr = this.f6298r;
            this.f6299s[i10] = -1;
            iArr[i10] = -1;
        }
    }

    public final void a() {
        int[] iArr = this.f6296p;
        try {
            GLES20.glGenTextures(3, iArr, 0);
            for (int i10 = 0; i10 < 3; i10++) {
                f3.j jVar = this.f6301u;
                GLES20.glUniform1i(GLES20.glGetUniformLocation(jVar.f5006o, f6293v[i10]), i10);
                GLES20.glActiveTexture(33984 + i10);
                l1.b.b(3553, iArr[i10]);
            }
            l1.b.c();
        } catch (l1.j e7) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures", e7);
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onDrawFrame(GL10 gl10) {
        if (this.f6300t.getAndSet(null) != null) {
            throw new ClassCastException();
        }
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceChanged(GL10 gl10, int i10, int i11) {
        GLES20.glViewport(0, 0, i10, i11);
    }

    @Override // android.opengl.GLSurfaceView.Renderer
    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        int[] iArr = this.f6297q;
        try {
            f3.j jVar = new f3.j("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
            this.f6301u = jVar;
            GLES20.glVertexAttribPointer(jVar.c("in_pos"), 2, 5126, false, 0, (Buffer) f6294w);
            iArr[0] = this.f6301u.c("in_tc_y");
            iArr[1] = this.f6301u.c("in_tc_u");
            iArr[2] = this.f6301u.c("in_tc_v");
            GLES20.glGetUniformLocation(this.f6301u.f5006o, "mColorConversion");
            l1.b.c();
            a();
            l1.b.c();
        } catch (l1.j e7) {
            Log.e("VideoDecoderGLSV", "Failed to set up the textures and program", e7);
        }
    }
}
