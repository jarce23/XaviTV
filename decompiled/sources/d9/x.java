package d9;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public float f4340a;

    /* renamed from: b, reason: collision with root package name */
    public float f4341b;

    /* renamed from: c, reason: collision with root package name */
    public float f4342c;

    /* renamed from: d, reason: collision with root package name */
    public float f4343d;

    /* renamed from: e, reason: collision with root package name */
    public float f4344e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f4345f = new ArrayList();
    public final ArrayList g = new ArrayList();

    public x() {
        d(0.0f, 270.0f, 0.0f);
    }

    public final void a(float f10) {
        float f11 = this.f4343d;
        if (f11 == f10) {
            return;
        }
        float f12 = ((f10 - f11) + 360.0f) % 360.0f;
        if (f12 > 180.0f) {
            return;
        }
        float f13 = this.f4341b;
        float f14 = this.f4342c;
        t tVar = new t(f13, f14, f13, f14);
        tVar.f4334f = this.f4343d;
        tVar.g = f12;
        this.g.add(new r(tVar));
        this.f4343d = f10;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.f4345f;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((v) arrayList.get(i10)).a(matrix, path);
        }
    }

    public final void c(float f10, float f11) {
        u uVar = new u();
        uVar.f4335b = f10;
        uVar.f4336c = f11;
        this.f4345f.add(uVar);
        s sVar = new s(uVar, this.f4341b, this.f4342c);
        float b2 = sVar.b() + 270.0f;
        float b10 = sVar.b() + 270.0f;
        a(b2);
        this.g.add(sVar);
        this.f4343d = b10;
        this.f4341b = f10;
        this.f4342c = f11;
    }

    public final void d(float f10, float f11, float f12) {
        this.f4340a = f10;
        this.f4341b = 0.0f;
        this.f4342c = f10;
        this.f4343d = f11;
        this.f4344e = (f11 + f12) % 360.0f;
        this.f4345f.clear();
        this.g.clear();
    }
}
