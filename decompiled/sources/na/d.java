package na;

import java.util.Iterator;
import java.util.NoSuchElementException;
import m0.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends z implements Iterator, ab.a {

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f9284s;

    public d(f fVar, int i10) {
        this.f9284s = i10;
        za.h.e("map", fVar);
        this.f8748r = fVar;
        this.f8746p = -1;
        this.f8747q = fVar.f9295v;
        e();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f9284s) {
            case 0:
                b();
                int i10 = this.f8745o;
                f fVar = (f) this.f8748r;
                if (i10 >= fVar.f9293t) {
                    throw new NoSuchElementException();
                }
                this.f8745o = i10 + 1;
                this.f8746p = i10;
                e eVar = new e(fVar, i10);
                e();
                return eVar;
            case 1:
                b();
                int i11 = this.f8745o;
                f fVar2 = (f) this.f8748r;
                if (i11 >= fVar2.f9293t) {
                    throw new NoSuchElementException();
                }
                this.f8745o = i11 + 1;
                this.f8746p = i11;
                Object obj = fVar2.f9288o[i11];
                e();
                return obj;
            default:
                b();
                int i12 = this.f8745o;
                f fVar3 = (f) this.f8748r;
                if (i12 >= fVar3.f9293t) {
                    throw new NoSuchElementException();
                }
                this.f8745o = i12 + 1;
                this.f8746p = i12;
                Object[] objArr = fVar3.f9289p;
                za.h.b(objArr);
                Object obj2 = objArr[this.f8746p];
                e();
                return obj2;
        }
    }
}
