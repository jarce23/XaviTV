package n9;

import c2.j1;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements Iterator {

    /* renamed from: p, reason: collision with root package name */
    public String f9256p;

    /* renamed from: q, reason: collision with root package name */
    public final CharSequence f9257q;

    /* renamed from: r, reason: collision with root package name */
    public final a f9258r;

    /* renamed from: t, reason: collision with root package name */
    public int f9260t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ h5.i f9261u;

    /* renamed from: o, reason: collision with root package name */
    public int f9255o = 2;

    /* renamed from: s, reason: collision with root package name */
    public int f9259s = 0;

    public g(h5.i iVar, j1 j1Var, CharSequence charSequence) {
        this.f9261u = iVar;
        this.f9258r = (a) j1Var.f2626q;
        this.f9260t = j1Var.f2625p;
        this.f9257q = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        String str;
        a aVar;
        int i10 = this.f9255o;
        if (i10 == 4) {
            throw new IllegalStateException();
        }
        int b2 = s.e.b(i10);
        if (b2 == 0) {
            return true;
        }
        if (b2 == 2) {
            return false;
        }
        this.f9255o = 4;
        int i11 = this.f9259s;
        while (true) {
            int i12 = this.f9259s;
            if (i12 == -1) {
                this.f9255o = 3;
                str = null;
                break;
            }
            b bVar = (b) this.f9261u.f5610p;
            CharSequence charSequence = this.f9257q;
            int length = charSequence.length();
            com.bumptech.glide.e.h(i12, length);
            while (true) {
                if (i12 >= length) {
                    i12 = -1;
                    break;
                }
                if (bVar.a(charSequence.charAt(i12))) {
                    break;
                }
                i12++;
            }
            if (i12 == -1) {
                i12 = charSequence.length();
                this.f9259s = -1;
            } else {
                this.f9259s = i12 + 1;
            }
            int i13 = this.f9259s;
            if (i13 == i11) {
                int i14 = i13 + 1;
                this.f9259s = i14;
                if (i14 > charSequence.length()) {
                    this.f9259s = -1;
                }
            } else {
                while (true) {
                    aVar = this.f9258r;
                    if (i11 >= i12 || !aVar.a(charSequence.charAt(i11))) {
                        break;
                    }
                    i11++;
                }
                while (i12 > i11 && aVar.a(charSequence.charAt(i12 - 1))) {
                    i12--;
                }
                int i15 = this.f9260t;
                if (i15 == 1) {
                    i12 = charSequence.length();
                    this.f9259s = -1;
                    while (i12 > i11 && aVar.a(charSequence.charAt(i12 - 1))) {
                        i12--;
                    }
                } else {
                    this.f9260t = i15 - 1;
                }
                str = charSequence.subSequence(i11, i12).toString();
            }
        }
        this.f9256p = str;
        if (this.f9255o == 3) {
            return false;
        }
        this.f9255o = 1;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f9255o = 2;
        String str = this.f9256p;
        this.f9256p = null;
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
