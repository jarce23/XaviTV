package gb;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements Iterator, ab.a {

    /* renamed from: o, reason: collision with root package name */
    public final CharSequence f5456o;

    /* renamed from: p, reason: collision with root package name */
    public int f5457p;

    /* renamed from: q, reason: collision with root package name */
    public int f5458q;

    /* renamed from: r, reason: collision with root package name */
    public int f5459r;

    /* renamed from: s, reason: collision with root package name */
    public int f5460s;

    public c(CharSequence charSequence) {
        za.h.e("string", charSequence);
        this.f5456o = charSequence;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i10;
        int i11;
        int i12 = this.f5457p;
        if (i12 != 0) {
            return i12 == 1;
        }
        if (this.f5460s < 0) {
            this.f5457p = 2;
            return false;
        }
        CharSequence charSequence = this.f5456o;
        int length = charSequence.length();
        int length2 = charSequence.length();
        for (int i13 = this.f5458q; i13 < length2; i13++) {
            char charAt = charSequence.charAt(i13);
            if (charAt == '\n' || charAt == '\r') {
                i10 = (charAt == '\r' && (i11 = i13 + 1) < charSequence.length() && charSequence.charAt(i11) == '\n') ? 2 : 1;
                length = i13;
                this.f5457p = 1;
                this.f5460s = i10;
                this.f5459r = length;
                return true;
            }
        }
        i10 = -1;
        this.f5457p = 1;
        this.f5460s = i10;
        this.f5459r = length;
        return true;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f5457p = 0;
        int i10 = this.f5459r;
        int i11 = this.f5458q;
        this.f5458q = this.f5460s + i10;
        return this.f5456o.subSequence(i11, i10).toString();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
