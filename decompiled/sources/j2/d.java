package j2;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements SensorEventListener {

    /* renamed from: a, reason: collision with root package name */
    public final float[] f6998a = new float[16];

    /* renamed from: b, reason: collision with root package name */
    public final float[] f6999b = new float[16];

    /* renamed from: c, reason: collision with root package name */
    public final float[] f7000c = new float[16];

    /* renamed from: d, reason: collision with root package name */
    public final float[] f7001d = new float[3];

    /* renamed from: e, reason: collision with root package name */
    public final Display f7002e;

    /* renamed from: f, reason: collision with root package name */
    public final c[] f7003f;
    public boolean g;

    public d(Display display, c... cVarArr) {
        this.f7002e = display;
        this.f7003f = cVarArr;
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        int i10;
        float[] fArr = sensorEvent.values;
        float[] fArr2 = this.f6998a;
        SensorManager.getRotationMatrixFromVector(fArr2, fArr);
        int rotation = this.f7002e.getRotation();
        float[] fArr3 = this.f6999b;
        if (rotation != 0) {
            int i11 = 129;
            if (rotation != 1) {
                i10 = 130;
                if (rotation != 2) {
                    if (rotation != 3) {
                        throw new IllegalStateException();
                    }
                    i11 = 130;
                    i10 = 1;
                }
            } else {
                i10 = 129;
                i11 = 2;
            }
            System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
            SensorManager.remapCoordinateSystem(fArr3, i11, i10, fArr2);
        }
        SensorManager.remapCoordinateSystem(fArr2, 1, 131, fArr3);
        float[] fArr4 = this.f7001d;
        SensorManager.getOrientation(fArr3, fArr4);
        float f10 = fArr4[2];
        Matrix.rotateM(fArr2, 0, 90.0f, 1.0f, 0.0f, 0.0f);
        boolean z10 = this.g;
        float[] fArr5 = this.f7000c;
        if (!z10) {
            c4.e.d(fArr5, fArr2);
            this.g = true;
        }
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        Matrix.multiplyMM(fArr2, 0, fArr3, 0, fArr5, 0);
        for (int i12 = 0; i12 < 2; i12++) {
            this.f7003f[i12].a(fArr2, f10);
        }
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }
}
