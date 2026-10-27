package androidx.activity;

import androidx.fragment.app.a0;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q extends za.i implements ya.l {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f322p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ y f323q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(y yVar, int i10) {
        super(1);
        this.f322p = i10;
        this.f323q = yVar;
    }

    @Override // ya.l
    public final Object invoke(Object obj) {
        Object obj2;
        Object obj3;
        switch (this.f322p) {
            case 0:
                za.h.e("backEvent", (b) obj);
                y yVar = this.f323q;
                ma.h hVar = yVar.f363b;
                ListIterator listIterator = hVar.listIterator(hVar.f());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj2 = listIterator.previous();
                        if (((a0) obj2).f644a) {
                        }
                    } else {
                        obj2 = null;
                    }
                }
                yVar.f364c = (a0) obj2;
                break;
            default:
                za.h.e("backEvent", (b) obj);
                ma.h hVar2 = this.f323q.f363b;
                ListIterator listIterator2 = hVar2.listIterator(hVar2.f());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        obj3 = listIterator2.previous();
                        if (((a0) obj3).f644a) {
                        }
                    } else {
                        obj3 = null;
                    }
                }
                break;
        }
        return la.i.f8335a;
    }
}
