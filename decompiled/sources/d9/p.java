package d9;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import c2.e0;
import c2.h1;
import c2.i0;
import c2.j0;
import i1.t0;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import s1.c1;
import s1.h0;
import s1.v0;
import s1.w0;
import s1.x0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public boolean f4312a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4313b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f4314c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f4315d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4316e;

    /* renamed from: f, reason: collision with root package name */
    public final Object f4317f;
    public final Object g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f4318h;

    /* renamed from: i, reason: collision with root package name */
    public final Object f4319i;

    /* renamed from: j, reason: collision with root package name */
    public final Object f4320j;

    /* renamed from: k, reason: collision with root package name */
    public Object f4321k;

    /* renamed from: l, reason: collision with root package name */
    public Object f4322l;

    public p() {
        this.f4313b = new x[4];
        this.f4314c = new Matrix[4];
        this.f4315d = new Matrix[4];
        this.f4316e = new PointF();
        this.f4317f = new Path();
        this.g = new Path();
        this.f4320j = new x();
        this.f4321k = new float[2];
        this.f4322l = new float[2];
        this.f4318h = new Path();
        this.f4319i = new Path();
        this.f4312a = true;
        for (int i10 = 0; i10 < 4; i10++) {
            ((x[]) this.f4313b)[i10] = new x();
            ((Matrix[]) this.f4314c)[i10] = new Matrix();
            ((Matrix[]) this.f4315d)[i10] = new Matrix();
        }
    }

    public t0 a(int i10, ArrayList arrayList, h1 h1Var) {
        ArrayList arrayList2 = (ArrayList) this.f4314c;
        if (!arrayList.isEmpty()) {
            this.f4321k = h1Var;
            for (int i11 = i10; i11 < arrayList.size() + i10; i11++) {
                x0 x0Var = (x0) arrayList.get(i11 - i10);
                if (i11 > 0) {
                    x0 x0Var2 = (x0) arrayList2.get(i11 - 1);
                    x0Var.f11486d = x0Var2.f11483a.f2767o.f2707b.o() + x0Var2.f11486d;
                    x0Var.f11487e = false;
                    x0Var.f11485c.clear();
                } else {
                    x0Var.f11486d = 0;
                    x0Var.f11487e = false;
                    x0Var.f11485c.clear();
                }
                int o2 = x0Var.f11483a.f2767o.f2707b.o();
                for (int i12 = i11; i12 < arrayList2.size(); i12++) {
                    ((x0) arrayList2.get(i12)).f11486d += o2;
                }
                arrayList2.add(i11, x0Var);
                ((HashMap) this.f4316e).put(x0Var.f11484b, x0Var);
                if (this.f4312a) {
                    g(x0Var);
                    if (((IdentityHashMap) this.f4315d).isEmpty()) {
                        ((HashSet) this.f4318h).add(x0Var);
                    } else {
                        w0 w0Var = (w0) ((HashMap) this.g).get(x0Var);
                        if (w0Var != null) {
                            w0Var.f11479a.b(w0Var.f11480b);
                        }
                    }
                }
            }
        }
        return c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v5 */
    public void b(n nVar, float[] fArr, float f10, RectF rectF, g gVar, Path path) {
        int i10;
        boolean z10;
        float f11;
        g gVar2;
        boolean z11;
        g gVar3 = gVar;
        Matrix[] matrixArr = (Matrix[]) this.f4315d;
        float[] fArr2 = (float[]) this.f4321k;
        x[] xVarArr = (x[]) this.f4313b;
        Matrix[] matrixArr2 = (Matrix[]) this.f4314c;
        path.rewind();
        Path path2 = (Path) this.f4317f;
        path2.rewind();
        Path path3 = (Path) this.g;
        path3.rewind();
        path3.addRect(rectF, Path.Direction.CW);
        int i11 = 0;
        while (true) {
            z10 = 0;
            if (i11 >= 4) {
                break;
            }
            PointF pointF = (PointF) this.f4316e;
            d cVar = fArr == null ? i11 != 1 ? i11 != 2 ? i11 != 3 ? nVar.f4305f : nVar.f4304e : nVar.f4306h : nVar.g : new c(fArr[i11]);
            i7.e eVar = i11 != 1 ? i11 != 2 ? i11 != 3 ? nVar.f4301b : nVar.f4300a : nVar.f4303d : nVar.f4302c;
            x xVar = xVarArr[i11];
            eVar.getClass();
            Matrix[] matrixArr3 = matrixArr;
            eVar.j(xVar, f10, cVar.a(rectF));
            int i12 = i11 + 1;
            float f12 = (i12 % 4) * 90;
            matrixArr2[i11].reset();
            if (i11 == 1) {
                pointF.set(rectF.right, rectF.bottom);
            } else if (i11 == 2) {
                pointF.set(rectF.left, rectF.bottom);
            } else if (i11 != 3) {
                pointF.set(rectF.right, rectF.top);
            } else {
                pointF.set(rectF.left, rectF.top);
            }
            matrixArr2[i11].setTranslate(pointF.x, pointF.y);
            matrixArr2[i11].preRotate(f12);
            x xVar2 = xVarArr[i11];
            fArr2[0] = xVar2.f4341b;
            fArr2[1] = xVar2.f4342c;
            matrixArr2[i11].mapPoints(fArr2);
            matrixArr3[i11].reset();
            matrixArr3[i11].setTranslate(fArr2[0], fArr2[1]);
            matrixArr3[i11].preRotate(f12);
            i11 = i12;
            matrixArr = matrixArr3;
        }
        Matrix[] matrixArr4 = matrixArr;
        int i13 = 0;
        for (i10 = 4; i13 < i10; i10 = 4) {
            x xVar3 = xVarArr[i13];
            xVar3.getClass();
            fArr2[z10] = 0.0f;
            fArr2[1] = xVar3.f4340a;
            matrixArr2[i13].mapPoints(fArr2);
            if (i13 == 0) {
                path.moveTo(fArr2[z10], fArr2[1]);
            } else {
                path.lineTo(fArr2[z10], fArr2[1]);
            }
            xVarArr[i13].b(matrixArr2[i13], path);
            if (gVar3 != null) {
                x xVar4 = xVarArr[i13];
                Matrix matrix = matrixArr2[i13];
                j jVar = gVar3.f4258a;
                BitSet bitSet = jVar.f4280s;
                xVar4.getClass();
                f11 = 0.0f;
                bitSet.set(i13, z10);
                w[] wVarArr = jVar.f4278q;
                xVar4.a(xVar4.f4344e);
                wVarArr[i13] = new q(new ArrayList(xVar4.g), new Matrix(matrix));
            } else {
                f11 = 0.0f;
            }
            Path path4 = (Path) this.f4318h;
            x xVar5 = (x) this.f4320j;
            int i14 = i13 + 1;
            int i15 = i14 % 4;
            x xVar6 = xVarArr[i13];
            fArr2[0] = xVar6.f4341b;
            fArr2[1] = xVar6.f4342c;
            matrixArr2[i13].mapPoints(fArr2);
            float[] fArr3 = (float[]) this.f4322l;
            x xVar7 = xVarArr[i15];
            xVar7.getClass();
            fArr3[0] = f11;
            fArr3[1] = xVar7.f4340a;
            matrixArr2[i15].mapPoints(fArr3);
            x[] xVarArr2 = xVarArr;
            Matrix[] matrixArr5 = matrixArr2;
            float max = Math.max(((float) Math.hypot(fArr2[0] - fArr3[0], fArr2[1] - fArr3[1])) - 0.001f, f11);
            x xVar8 = xVarArr2[i13];
            fArr2[0] = xVar8.f4341b;
            fArr2[1] = xVar8.f4342c;
            matrixArr5[i13].mapPoints(fArr2);
            if (i13 == 1 || i13 == 3) {
                Math.abs(rectF.centerX() - fArr2[0]);
            } else {
                Math.abs(rectF.centerY() - fArr2[1]);
            }
            xVar5.d(0.0f, 270.0f, 0.0f);
            (i13 != 1 ? i13 != 2 ? i13 != 3 ? nVar.f4308j : nVar.f4307i : nVar.f4310l : nVar.f4309k).getClass();
            xVar5.c(max, 0.0f);
            path4.reset();
            xVar5.b(matrixArr4[i13], path4);
            if (this.f4312a && (f(path4, i13) || f(path4, i15))) {
                path4.op(path4, path3, Path.Op.DIFFERENCE);
                fArr2[0] = 0.0f;
                fArr2[1] = xVar5.f4340a;
                matrixArr4[i13].mapPoints(fArr2);
                path2.moveTo(fArr2[0], fArr2[1]);
                xVar5.b(matrixArr4[i13], path2);
            } else {
                xVar5.b(matrixArr4[i13], path);
            }
            if (gVar != null) {
                Matrix matrix2 = matrixArr4[i13];
                gVar2 = gVar;
                j jVar2 = gVar2.f4258a;
                z11 = false;
                jVar2.f4280s.set(i13 + 4, false);
                w[] wVarArr2 = jVar2.f4279r;
                xVar5.a(xVar5.f4344e);
                wVarArr2[i13] = new q(new ArrayList(xVar5.g), new Matrix(matrix2));
            } else {
                gVar2 = gVar;
                z11 = false;
            }
            z10 = z11;
            gVar3 = gVar2;
            i13 = i14;
            xVarArr = xVarArr2;
            matrixArr2 = matrixArr5;
        }
        path.close();
        path2.close();
        if (path2.isEmpty()) {
            return;
        }
        path.op(path2, Path.Op.UNION);
    }

    public t0 c() {
        ArrayList arrayList = (ArrayList) this.f4314c;
        if (arrayList.isEmpty()) {
            return t0.f6037a;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            x0 x0Var = (x0) arrayList.get(i11);
            x0Var.f11486d = i10;
            i10 += x0Var.f11483a.f2767o.f2707b.o();
        }
        return new c1(arrayList, (h1) this.f4321k);
    }

    public void d() {
        Iterator it = ((HashSet) this.f4318h).iterator();
        while (it.hasNext()) {
            x0 x0Var = (x0) it.next();
            if (x0Var.f11485c.isEmpty()) {
                w0 w0Var = (w0) ((HashMap) this.g).get(x0Var);
                if (w0Var != null) {
                    w0Var.f11479a.b(w0Var.f11480b);
                }
                it.remove();
            }
        }
    }

    public void e(x0 x0Var) {
        if (x0Var.f11487e && x0Var.f11485c.isEmpty()) {
            w0 w0Var = (w0) ((HashMap) this.g).remove(x0Var);
            w0Var.getClass();
            v0 v0Var = w0Var.f11481c;
            c2.a aVar = w0Var.f11479a;
            aVar.n(w0Var.f11480b);
            aVar.q(v0Var);
            aVar.p(v0Var);
            ((HashSet) this.f4318h).remove(x0Var);
        }
    }

    public boolean f(Path path, int i10) {
        Path path2 = (Path) this.f4319i;
        path2.reset();
        ((x[]) this.f4313b)[i10].b(((Matrix[]) this.f4314c)[i10], path2);
        RectF rectF = new RectF();
        path.computeBounds(rectF, true);
        path2.computeBounds(rectF, true);
        path.op(path2, Path.Op.INTERSECT);
        path.computeBounds(rectF, true);
        return !rectF.isEmpty() || (rectF.width() > 1.0f && rectF.height() > 1.0f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [c2.e0, s1.q0] */
    public void g(x0 x0Var) {
        c2.y yVar = x0Var.f11483a;
        ?? r12 = new e0() { // from class: s1.q0
            @Override // c2.e0
            public final void a(c2.a aVar, i1.t0 t0Var) {
                l1.x xVar = ((h0) d9.p.this.f4317f).f11343v;
                xVar.d(2);
                xVar.e(22);
            }
        };
        v0 v0Var = new v0(this, x0Var);
        ((HashMap) this.g).put(x0Var, new w0(yVar, r12, v0Var));
        int i10 = l1.a0.f8067a;
        Looper myLooper = Looper.myLooper();
        if (myLooper == null) {
            myLooper = Looper.getMainLooper();
        }
        Handler handler = new Handler(myLooper, null);
        yVar.getClass();
        j0 j0Var = yVar.f2520c;
        j0Var.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList = j0Var.f2623c;
        i0 i0Var = new i0();
        i0Var.f2603a = handler;
        i0Var.f2604b = v0Var;
        copyOnWriteArrayList.add(i0Var);
        Looper myLooper2 = Looper.myLooper();
        if (myLooper2 == null) {
            myLooper2 = Looper.getMainLooper();
        }
        new Handler(myLooper2, null);
        j0 j0Var2 = yVar.f2521d;
        j0Var2.getClass();
        CopyOnWriteArrayList copyOnWriteArrayList2 = j0Var2.f2623c;
        v1.c cVar = new v1.c();
        cVar.f12651a = v0Var;
        copyOnWriteArrayList2.add(cVar);
        yVar.j(r12, (o1.e0) this.f4322l, (t1.u) this.f4313b);
    }

    public void h(c2.b0 b0Var) {
        IdentityHashMap identityHashMap = (IdentityHashMap) this.f4315d;
        x0 x0Var = (x0) identityHashMap.remove(b0Var);
        x0Var.getClass();
        x0Var.f11483a.m(b0Var);
        x0Var.f11485c.remove(((c2.v) b0Var).f2736o);
        if (!identityHashMap.isEmpty()) {
            d();
        }
        e(x0Var);
    }

    public void i(int i10, int i11) {
        ArrayList arrayList = (ArrayList) this.f4314c;
        for (int i12 = i11 - 1; i12 >= i10; i12--) {
            x0 x0Var = (x0) arrayList.remove(i12);
            ((HashMap) this.f4316e).remove(x0Var.f11484b);
            int i13 = -x0Var.f11483a.f2767o.f2707b.o();
            for (int i14 = i12; i14 < arrayList.size(); i14++) {
                ((x0) arrayList.get(i14)).f11486d += i13;
            }
            x0Var.f11487e = true;
            if (this.f4312a) {
                e(x0Var);
            }
        }
    }

    public p(h0 h0Var, t1.o oVar, l1.x xVar, t1.u uVar) {
        this.f4313b = uVar;
        this.f4317f = h0Var;
        this.f4321k = new h1();
        this.f4315d = new IdentityHashMap();
        this.f4316e = new HashMap();
        this.f4314c = new ArrayList();
        this.f4319i = oVar;
        this.f4320j = xVar;
        this.g = new HashMap();
        this.f4318h = new HashSet();
    }
}
