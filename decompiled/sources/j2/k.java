package j2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import i2.y;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends GLSurfaceView {

    /* renamed from: z, reason: collision with root package name */
    public static final /* synthetic */ int f7043z = 0;

    /* renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList f7044o;

    /* renamed from: p, reason: collision with root package name */
    public final SensorManager f7045p;

    /* renamed from: q, reason: collision with root package name */
    public final Sensor f7046q;

    /* renamed from: r, reason: collision with root package name */
    public final d f7047r;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f7048s;

    /* renamed from: t, reason: collision with root package name */
    public final i f7049t;

    /* renamed from: u, reason: collision with root package name */
    public SurfaceTexture f7050u;

    /* renamed from: v, reason: collision with root package name */
    public Surface f7051v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f7052w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7053x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f7054y;

    public k(Context context) {
        super(context, null);
        this.f7044o = new CopyOnWriteArrayList();
        this.f7048s = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f7045p = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.f7046q = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        i iVar = new i();
        this.f7049t = iVar;
        j jVar = new j(this, iVar);
        View.OnTouchListener lVar = new l(context, jVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f7047r = new d(windowManager.getDefaultDisplay(), lVar, jVar);
        this.f7052w = true;
        setEGLContextClientVersion(2);
        setRenderer(jVar);
        setOnTouchListener(lVar);
    }

    public final void a() {
        boolean z10 = this.f7052w && this.f7053x;
        Sensor sensor = this.f7046q;
        if (sensor == null || z10 == this.f7054y) {
            return;
        }
        d dVar = this.f7047r;
        SensorManager sensorManager = this.f7045p;
        if (z10) {
            sensorManager.registerListener(dVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(dVar);
        }
        this.f7054y = z10;
    }

    public a getCameraMotionListener() {
        return this.f7049t;
    }

    public y getVideoFrameMetadataListener() {
        return this.f7049t;
    }

    public Surface getVideoSurface() {
        return this.f7051v;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f7048s.post(new androidx.activity.d(15, this));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.f7053x = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.f7053x = true;
        a();
    }

    public void setDefaultStereoMode(int i10) {
        this.f7049t.f7030y = i10;
    }

    public void setUseSensorRotation(boolean z10) {
        this.f7052w = z10;
        a();
    }
}
