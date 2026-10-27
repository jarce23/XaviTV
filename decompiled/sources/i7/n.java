package i7;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class n extends BasePendingResult {

    /* renamed from: o, reason: collision with root package name */
    public h5.i f6513o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f6514p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ h f6515q;

    public n(h hVar, boolean z10) {
        this.f6515q = hVar;
        this.f6514p = z10;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* synthetic */ o7.j N(Status status) {
        return new l(status, 1);
    }

    public abstract void V();

    public final l7.o W() {
        if (this.f6513o == null) {
            this.f6513o = new h5.i(5, this);
        }
        return this.f6513o;
    }

    public final void X() {
        if (!this.f6514p) {
            Iterator it = this.f6515q.f6503h.iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.d.l(it);
            }
            Iterator it2 = this.f6515q.f6504i.iterator();
            while (it2.hasNext()) {
                ((g) it2.next()).getClass();
            }
        }
        try {
            synchronized (this.f6515q.f6497a) {
                V();
            }
        } catch (l7.l unused) {
            R(new l(new Status(2100, null, null, null), 1));
        }
    }
}
