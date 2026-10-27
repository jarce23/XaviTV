package j2;

import android.content.Context;
import android.graphics.PointF;
import android.opengl.Matrix;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener, c {

    /* renamed from: q, reason: collision with root package name */
    public final j f7057q;

    /* renamed from: s, reason: collision with root package name */
    public final GestureDetector f7059s;

    /* renamed from: o, reason: collision with root package name */
    public final PointF f7055o = new PointF();

    /* renamed from: p, reason: collision with root package name */
    public final PointF f7056p = new PointF();

    /* renamed from: r, reason: collision with root package name */
    public final float f7058r = 25.0f;

    /* renamed from: t, reason: collision with root package name */
    public volatile float f7060t = 3.1415927f;

    public l(Context context, j jVar) {
        this.f7057q = jVar;
        this.f7059s = new GestureDetector(context, this);
    }

    @Override // j2.c
    public final void a(float[] fArr, float f10) {
        this.f7060t = -f10;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f7055o.set(motionEvent.getX(), motionEvent.getY());
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float x6 = (motionEvent2.getX() - this.f7055o.x) / this.f7058r;
        float y8 = motionEvent2.getY();
        PointF pointF = this.f7055o;
        float f12 = (y8 - pointF.y) / this.f7058r;
        pointF.set(motionEvent2.getX(), motionEvent2.getY());
        double d6 = this.f7060t;
        float cos = (float) Math.cos(d6);
        float sin = (float) Math.sin(d6);
        PointF pointF2 = this.f7056p;
        pointF2.x -= (cos * x6) - (sin * f12);
        float f13 = (cos * f12) + (sin * x6) + pointF2.y;
        pointF2.y = f13;
        pointF2.y = Math.max(-45.0f, Math.min(45.0f, f13));
        j jVar = this.f7057q;
        PointF pointF3 = this.f7056p;
        synchronized (jVar) {
            float f14 = pointF3.y;
            jVar.f7038u = f14;
            Matrix.setRotateM(jVar.f7036s, 0, -f14, (float) Math.cos(jVar.f7039v), (float) Math.sin(jVar.f7039v), 0.0f);
            Matrix.setRotateM(jVar.f7037t, 0, -pointF3.x, 0.0f, 1.0f, 0.0f);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return this.f7057q.f7042y.performClick();
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f7059s.onTouchEvent(motionEvent);
    }
}
