package u5;

import android.graphics.Bitmap;
import m6.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: a, reason: collision with root package name */
    public final e f12550a;

    /* renamed from: b, reason: collision with root package name */
    public int f12551b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap.Config f12552c;

    public j(e eVar) {
        this.f12550a = eVar;
    }

    @Override // u5.h
    public final void a() {
        this.f12550a.i(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (this.f12551b == jVar.f12551b && n.b(this.f12552c, jVar.f12552c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i10 = this.f12551b * 31;
        Bitmap.Config config = this.f12552c;
        return i10 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return k.c(this.f12551b, this.f12552c);
    }
}
