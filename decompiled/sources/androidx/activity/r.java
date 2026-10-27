package androidx.activity;

import androidx.fragment.app.a0;
import java.util.ListIterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r extends za.i implements ya.a {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f324p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ y f325q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(y yVar, int i10) {
        super(0);
        this.f324p = i10;
        this.f325q = yVar;
    }

    @Override // ya.a
    public final Object invoke() {
        Object obj;
        switch (this.f324p) {
            case 0:
                this.f325q.b();
                break;
            case 1:
                y yVar = this.f325q;
                ma.h hVar = yVar.f363b;
                ListIterator listIterator = hVar.listIterator(hVar.f());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        obj = listIterator.previous();
                        if (((a0) obj).f644a) {
                        }
                    } else {
                        obj = null;
                    }
                }
                yVar.f364c = null;
                break;
            default:
                this.f325q.b();
                break;
        }
        return la.i.f8335a;
    }
}
