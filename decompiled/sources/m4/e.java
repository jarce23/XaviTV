package m4;

import android.animation.TypeEvaluator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements TypeEvaluator {

    /* renamed from: a, reason: collision with root package name */
    public e0.e[] f8888a;

    @Override // android.animation.TypeEvaluator
    public final Object evaluate(float f10, Object obj, Object obj2) {
        e0.e[] eVarArr = (e0.e[]) obj;
        e0.e[] eVarArr2 = (e0.e[]) obj2;
        if (!n4.a.c(eVarArr, eVarArr2)) {
            throw new IllegalArgumentException("Can't interpolate between two incompatible pathData");
        }
        if (!n4.a.c(this.f8888a, eVarArr)) {
            this.f8888a = n4.a.k(eVarArr);
        }
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            e0.e eVar = this.f8888a[i10];
            e0.e eVar2 = eVarArr[i10];
            e0.e eVar3 = eVarArr2[i10];
            eVar.getClass();
            eVar.f4390a = eVar2.f4390a;
            int i11 = 0;
            while (true) {
                float[] fArr = eVar2.f4391b;
                if (i11 < fArr.length) {
                    eVar.f4391b[i11] = (eVar3.f4391b[i11] * f10) + ((1.0f - f10) * fArr[i11]);
                    i11++;
                }
            }
        }
        return this.f8888a;
    }
}
