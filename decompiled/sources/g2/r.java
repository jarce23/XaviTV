package g2;

import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r {
    public static final f2.c g = new f2.c(8);

    /* renamed from: h, reason: collision with root package name */
    public static final f2.c f5142h = new f2.c(9);

    /* renamed from: d, reason: collision with root package name */
    public int f5146d;

    /* renamed from: e, reason: collision with root package name */
    public int f5147e;

    /* renamed from: f, reason: collision with root package name */
    public int f5148f;

    /* renamed from: b, reason: collision with root package name */
    public final q[] f5144b = new q[5];

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f5143a = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public int f5145c = -1;

    public final void a(int i10, float f10) {
        q qVar;
        int i11 = this.f5145c;
        ArrayList arrayList = this.f5143a;
        if (i11 != 1) {
            Collections.sort(arrayList, g);
            this.f5145c = 1;
        }
        int i12 = this.f5148f;
        q[] qVarArr = this.f5144b;
        if (i12 > 0) {
            int i13 = i12 - 1;
            this.f5148f = i13;
            qVar = qVarArr[i13];
        } else {
            qVar = new q();
        }
        int i14 = this.f5146d;
        this.f5146d = i14 + 1;
        qVar.f5139a = i14;
        qVar.f5140b = i10;
        qVar.f5141c = f10;
        arrayList.add(qVar);
        this.f5147e += i10;
        while (true) {
            int i15 = this.f5147e;
            if (i15 <= 2000) {
                return;
            }
            int i16 = i15 - 2000;
            q qVar2 = (q) arrayList.get(0);
            int i17 = qVar2.f5140b;
            if (i17 <= i16) {
                this.f5147e -= i17;
                arrayList.remove(0);
                int i18 = this.f5148f;
                if (i18 < 5) {
                    this.f5148f = i18 + 1;
                    qVarArr[i18] = qVar2;
                }
            } else {
                qVar2.f5140b = i17 - i16;
                this.f5147e -= i16;
            }
        }
    }

    public final float b() {
        int i10 = this.f5145c;
        ArrayList arrayList = this.f5143a;
        if (i10 != 0) {
            Collections.sort(arrayList, f5142h);
            this.f5145c = 0;
        }
        float f10 = 0.5f * this.f5147e;
        int i11 = 0;
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            q qVar = (q) arrayList.get(i12);
            i11 += qVar.f5140b;
            if (i11 >= f10) {
                return qVar.f5141c;
            }
        }
        if (arrayList.isEmpty()) {
            return Float.NaN;
        }
        return ((q) arrayList.get(arrayList.size() - 1)).f5141c;
    }
}
