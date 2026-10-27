package m4;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l extends k {

    /* renamed from: a, reason: collision with root package name */
    public e0.e[] f8911a;

    /* renamed from: b, reason: collision with root package name */
    public String f8912b;

    /* renamed from: c, reason: collision with root package name */
    public int f8913c;

    public l() {
        this.f8911a = null;
        this.f8913c = 0;
    }

    public e0.e[] getPathData() {
        return this.f8911a;
    }

    public String getPathName() {
        return this.f8912b;
    }

    public void setPathData(e0.e[] eVarArr) {
        if (!n4.a.c(this.f8911a, eVarArr)) {
            this.f8911a = n4.a.k(eVarArr);
            return;
        }
        e0.e[] eVarArr2 = this.f8911a;
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            eVarArr2[i10].f4390a = eVarArr[i10].f4390a;
            int i11 = 0;
            while (true) {
                float[] fArr = eVarArr[i10].f4391b;
                if (i11 < fArr.length) {
                    eVarArr2[i10].f4391b[i11] = fArr[i11];
                    i11++;
                }
            }
        }
    }

    public l(l lVar) {
        this.f8911a = null;
        this.f8913c = 0;
        this.f8912b = lVar.f8912b;
        this.f8911a = n4.a.k(lVar.f8911a);
    }
}
