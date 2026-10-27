package androidx.emoji2.text;

import android.util.SparseArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f611a;

    /* renamed from: b, reason: collision with root package name */
    public z f612b;

    public w(int i10) {
        this.f611a = new SparseArray(i10);
    }

    public final void a(z zVar, int i10, int i11) {
        int a10 = zVar.a(i10);
        SparseArray sparseArray = this.f611a;
        w wVar = sparseArray == null ? null : (w) sparseArray.get(a10);
        if (wVar == null) {
            wVar = new w(1);
            sparseArray.put(zVar.a(i10), wVar);
        }
        if (i11 > i10) {
            wVar.a(zVar, i10 + 1, i11);
        } else {
            wVar.f612b = zVar;
        }
    }
}
