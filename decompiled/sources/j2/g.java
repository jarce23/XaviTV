package j2;

import android.opengl.GLES20;
import android.util.Log;
import app.shamel.tv.activities.v;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: i, reason: collision with root package name */
    public static final float[] f7009i = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: j, reason: collision with root package name */
    public static final float[] f7010j = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: k, reason: collision with root package name */
    public static final float[] f7011k = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* renamed from: a, reason: collision with root package name */
    public int f7012a;

    /* renamed from: b, reason: collision with root package name */
    public v f7013b;

    /* renamed from: c, reason: collision with root package name */
    public f3.j f7014c;

    /* renamed from: d, reason: collision with root package name */
    public int f7015d;

    /* renamed from: e, reason: collision with root package name */
    public int f7016e;

    /* renamed from: f, reason: collision with root package name */
    public int f7017f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public int f7018h;

    public static boolean b(f fVar) {
        e eVar = fVar.f7005a;
        e eVar2 = fVar.f7006b;
        v[] vVarArr = eVar.f7004a;
        if (vVarArr.length == 1 && vVarArr[0].f2061p == 0) {
            v[] vVarArr2 = eVar2.f7004a;
            if (vVarArr2.length == 1 && vVarArr2[0].f2061p == 0) {
                return true;
            }
        }
        return false;
    }

    public final void a() {
        try {
            f3.j jVar = new f3.j("uniform mat4 uMvpMatrix;\nuniform mat3 uTexMatrix;\nattribute vec4 aPosition;\nattribute vec2 aTexCoords;\nvarying vec2 vTexCoords;\n// Standard transformation.\nvoid main() {\n  gl_Position = uMvpMatrix * aPosition;\n  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;\n}\n", "// This is required since the texture data is GL_TEXTURE_EXTERNAL_OES.\n#extension GL_OES_EGL_image_external : require\nprecision mediump float;\n// Standard texture rendering shader.\nuniform samplerExternalOES uTexture;\nvarying vec2 vTexCoords;\nvoid main() {\n  gl_FragColor = texture2D(uTexture, vTexCoords);\n}\n");
            this.f7014c = jVar;
            this.f7015d = GLES20.glGetUniformLocation(jVar.f5006o, "uMvpMatrix");
            this.f7016e = GLES20.glGetUniformLocation(this.f7014c.f5006o, "uTexMatrix");
            this.f7017f = this.f7014c.c("aPosition");
            this.g = this.f7014c.c("aTexCoords");
            this.f7018h = GLES20.glGetUniformLocation(this.f7014c.f5006o, "uTexture");
        } catch (l1.j e7) {
            Log.e("ProjectionRenderer", "Failed to initialize the program", e7);
        }
    }
}
