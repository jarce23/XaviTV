package i2;

import android.content.Context;
import android.opengl.GLSurfaceView;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w extends GLSurfaceView implements x {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f6302p = 0;

    /* renamed from: o, reason: collision with root package name */
    public final v f6303o;

    public w(Context context) {
        super(context, null);
        v vVar = new v(this);
        this.f6303o = vVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(vVar);
        setRenderMode(0);
    }

    public void setOutputBuffer(r1.i iVar) {
        v vVar = this.f6303o;
        if (vVar.f6300t.getAndSet(iVar) != null) {
            throw new ClassCastException();
        }
        vVar.f6295o.requestRender();
    }

    @Deprecated
    public x getVideoDecoderOutputBufferRenderer() {
        return this;
    }
}
