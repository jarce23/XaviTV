package d9;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends w {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f4323c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f4324d;

    public q(ArrayList arrayList, Matrix matrix) {
        this.f4323c = arrayList;
        this.f4324d = matrix;
    }

    @Override // d9.w
    public final void a(Matrix matrix, c9.a aVar, int i10, Canvas canvas) {
        ArrayList arrayList = this.f4323c;
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            ((w) obj).a(this.f4324d, aVar, i10, canvas);
        }
    }
}
