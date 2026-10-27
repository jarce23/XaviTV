package w3;

import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    public final m f13055a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13056b;

    /* renamed from: c, reason: collision with root package name */
    public final z f13057c;

    /* renamed from: d, reason: collision with root package name */
    public final z f13058d;

    /* renamed from: e, reason: collision with root package name */
    public final z f13059e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f13060f;
    public final WeakReference g;

    /* renamed from: h, reason: collision with root package name */
    public r.k f13061h = null;

    /* renamed from: i, reason: collision with root package name */
    public boolean f13062i = false;

    /* renamed from: j, reason: collision with root package name */
    public boolean f13063j = false;

    public x(w wVar, z zVar, m mVar, int i10, z zVar2, Collection collection) {
        this.g = new WeakReference(wVar);
        this.f13058d = zVar;
        this.f13055a = mVar;
        this.f13056b = i10;
        this.f13057c = wVar.f13048t;
        this.f13059e = zVar2;
        this.f13060f = collection != null ? new ArrayList(collection) : null;
        wVar.f13042n.postDelayed(new w1.o(2, this), 15000L);
    }

    public final void a() {
        if (this.f13062i || this.f13063j) {
            return;
        }
        this.f13063j = true;
        m mVar = this.f13055a;
        if (mVar != null) {
            mVar.h(0);
            mVar.d();
        }
    }

    public final void b() {
        r.k kVar;
        b0.b();
        if (this.f13062i || this.f13063j) {
            return;
        }
        WeakReference weakReference = this.g;
        w wVar = (w) weakReference.get();
        if (wVar == null || wVar.C != this || ((kVar = this.f13061h) != null && kVar.isCancelled())) {
            a();
            return;
        }
        this.f13062i = true;
        wVar.C = null;
        w wVar2 = (w) weakReference.get();
        z zVar = this.f13057c;
        int i10 = this.f13056b;
        if (wVar2 != null) {
            HashMap hashMap = wVar2.f13052x;
            if (wVar2.f13048t == zVar) {
                Message obtainMessage = wVar2.f13042n.obtainMessage(263, zVar);
                obtainMessage.arg1 = i10;
                obtainMessage.sendToTarget();
                m mVar = wVar2.f13049u;
                if (mVar != null) {
                    mVar.h(i10);
                    wVar2.f13049u.d();
                }
                if (!hashMap.isEmpty()) {
                    for (m mVar2 : hashMap.values()) {
                        mVar2.h(i10);
                        mVar2.d();
                    }
                    hashMap.clear();
                }
                wVar2.f13049u = null;
            }
        }
        w wVar3 = (w) weakReference.get();
        if (wVar3 == null) {
            return;
        }
        t tVar = wVar3.f13042n;
        z zVar2 = this.f13058d;
        wVar3.f13048t = zVar2;
        wVar3.f13049u = this.f13055a;
        z zVar3 = this.f13059e;
        if (zVar3 == null) {
            Message obtainMessage2 = tVar.obtainMessage(262, new l0.b(zVar, zVar2));
            obtainMessage2.arg1 = i10;
            obtainMessage2.sendToTarget();
        } else {
            Message obtainMessage3 = tVar.obtainMessage(264, new l0.b(zVar3, zVar2));
            obtainMessage3.arg1 = i10;
            obtainMessage3.sendToTarget();
        }
        wVar3.f13052x.clear();
        wVar3.g();
        wVar3.m();
        ArrayList arrayList = this.f13060f;
        if (arrayList != null) {
            wVar3.f13048t.n(arrayList);
        }
    }
}
