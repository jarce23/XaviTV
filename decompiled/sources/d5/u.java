package d5;

import android.view.View;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.Season;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4199o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f4200p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ b4.f0 f4201q;

    public /* synthetic */ u(b4.f0 f0Var, int i10, int i11) {
        this.f4199o = i11;
        this.f4201q = f0Var;
        this.f4200p = i10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4199o) {
            case 0:
                k kVar = (k) this.f4201q;
                boolean[] zArr = (boolean[]) kVar.f4125f;
                int i10 = this.f4200p;
                zArr[i10] = !zArr[i10];
                kVar.e(i10);
                ((ya.p) kVar.g).b(Integer.valueOf(i10), Boolean.valueOf(zArr[i10]));
                break;
            case 1:
                y yVar = (y) this.f4201q;
                int i11 = yVar.f4223f;
                int i12 = this.f4200p;
                yVar.f4223f = i12;
                yVar.e(i11);
                yVar.e(yVar.f4223f);
                ((h5.l) yVar.g).b(Integer.valueOf(i12), Boolean.TRUE);
                break;
            case 2:
                y yVar2 = (y) this.f4201q;
                int i13 = yVar2.f4223f;
                int i14 = this.f4200p;
                yVar2.f4223f = i14;
                yVar2.e(i13);
                yVar2.e(yVar2.f4223f);
                ((ya.p) yVar2.g).b(Integer.valueOf(i14), Boolean.TRUE);
                break;
            case 3:
                m mVar = (m) this.f4201q;
                app.shamel.tv.activities.f fVar = (app.shamel.tv.activities.f) mVar.f4135f;
                ArrayList arrayList = (ArrayList) mVar.f4134e;
                int i15 = this.f4200p;
                fVar.c((CategoryModel) arrayList.get(i15), Integer.valueOf(i15), Boolean.TRUE);
                break;
            case 4:
                e eVar = (e) this.f4201q;
                int i16 = this.f4200p;
                eVar.o(i16);
                ((app.shamel.tv.activities.b) eVar.g).c((Season) ((List) eVar.f4087f).get(i16), Integer.valueOf(i16), Boolean.TRUE);
                break;
            case 5:
                y yVar3 = (y) this.f4201q;
                app.shamel.tv.activities.b bVar = (app.shamel.tv.activities.b) yVar3.f4222e;
                ArrayList arrayList2 = (ArrayList) yVar3.g;
                int i17 = this.f4200p;
                bVar.c((e5.m) arrayList2.get(i17), Integer.valueOf(i17), Boolean.TRUE);
                break;
            default:
                y yVar4 = (y) this.f4201q;
                int i18 = yVar4.f4223f;
                int i19 = this.f4200p;
                yVar4.f4223f = i19;
                yVar4.e(i18);
                yVar4.e(yVar4.f4223f);
                ((h5.l) yVar4.f4222e).b(Integer.valueOf(i19), Boolean.TRUE);
                break;
        }
    }
}
