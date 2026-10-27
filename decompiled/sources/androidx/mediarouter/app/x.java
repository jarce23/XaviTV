package androidx.mediarouter.app;

import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1423o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1424p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1425q;

    public /* synthetic */ x(Object obj, int i10, Object obj2) {
        this.f1423o = i10;
        this.f1425q = obj;
        this.f1424p = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f1423o) {
            case 0:
                y yVar = (y) this.f1425q;
                a0 a0Var = yVar.f1430y.f1436j;
                w3.z zVar = (w3.z) this.f1424p;
                a0Var.B = zVar;
                zVar.l();
                yVar.f1427v.setVisibility(4);
                yVar.f1428w.setVisibility(0);
                break;
            default:
                int b2 = ((d5.l) this.f1424p).b();
                if (b2 != -1) {
                    d5.m mVar = (d5.m) this.f1425q;
                    ((ya.q) mVar.f4135f).c((e5.m) mVar.f4134e.get(b2), Integer.valueOf(b2), Boolean.TRUE);
                    break;
                }
                break;
        }
    }
}
