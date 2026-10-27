package u4;

import android.os.Build;
import x4.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a extends d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12513b;

    /* renamed from: c, reason: collision with root package name */
    public final int f12514c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(v4.f fVar, int i10) {
        super(fVar);
        this.f12513b = i10;
        switch (i10) {
            case 2:
                h.e("tracker", fVar);
                super(fVar);
                this.f12514c = 7;
                break;
            case 3:
                h.e("tracker", fVar);
                super(fVar);
                this.f12514c = 7;
                break;
            case 4:
                h.e("tracker", fVar);
                super(fVar);
                this.f12514c = 9;
                break;
            default:
                h.e("tracker", fVar);
                this.f12514c = 6;
                break;
        }
    }

    @Override // u4.d
    public final int a() {
        switch (this.f12513b) {
        }
        return this.f12514c;
    }

    @Override // u4.d
    public final boolean b(o oVar) {
        switch (this.f12513b) {
            case 0:
                return oVar.f13577j.f9488b;
            case 1:
                return oVar.f13577j.f9490d;
            case 2:
                return oVar.f13577j.f9487a == 2;
            case 3:
                int i10 = oVar.f13577j.f9487a;
                return i10 == 3 || (Build.VERSION.SDK_INT >= 30 && i10 == 6);
            default:
                return oVar.f13577j.f9491e;
        }
    }

    @Override // u4.d
    public final boolean c(Object obj) {
        boolean booleanValue;
        switch (this.f12513b) {
            case 0:
                booleanValue = ((Boolean) obj).booleanValue();
                break;
            case 1:
                booleanValue = ((Boolean) obj).booleanValue();
                break;
            case 2:
                t4.d dVar = (t4.d) obj;
                h.e("value", dVar);
                boolean z10 = dVar.f11876a;
                return Build.VERSION.SDK_INT < 26 ? !z10 : !(z10 && dVar.f11877b);
            case 3:
                t4.d dVar2 = (t4.d) obj;
                h.e("value", dVar2);
                return !dVar2.f11876a || dVar2.f11878c;
            default:
                booleanValue = ((Boolean) obj).booleanValue();
                break;
        }
        return !booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(v4.a aVar) {
        super(aVar);
        this.f12513b = 1;
        h.e("tracker", aVar);
        this.f12514c = 5;
    }
}
