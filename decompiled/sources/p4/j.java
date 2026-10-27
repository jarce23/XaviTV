package p4;

import android.media.AudioTrack;
import android.os.Handler;
import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;
import u1.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9933o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f9934p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f9935q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f9936r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ Object f9937s;

    public /* synthetic */ j(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f9933o = i10;
        this.f9934p = obj;
        this.f9935q = obj2;
        this.f9936r = obj3;
        this.f9937s = obj4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9933o) {
            case 0:
                List list = (List) this.f9934p;
                x4.j jVar = (x4.j) this.f9935q;
                o4.a aVar = (o4.a) this.f9936r;
                WorkDatabase workDatabase = (WorkDatabase) this.f9937s;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).c(jVar.f13557a);
                }
                k.b(aVar, workDatabase, list);
                return;
            default:
                AudioTrack audioTrack = (AudioTrack) this.f9934p;
                p pVar = (p) this.f9935q;
                Handler handler = (Handler) this.f9936r;
                u1.l lVar = (u1.l) this.f9937s;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    if (pVar != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new androidx.fragment.app.d(pVar, 25, lVar));
                    }
                    synchronized (z.f12295n0) {
                        try {
                            int i10 = z.f12297p0 - 1;
                            z.f12297p0 = i10;
                            if (i10 == 0) {
                                z.f12296o0.shutdown();
                                z.f12296o0 = null;
                            }
                        } finally {
                        }
                    }
                    return;
                } catch (Throwable th) {
                    if (pVar != null && handler.getLooper().getThread().isAlive()) {
                        handler.post(new androidx.fragment.app.d(pVar, 25, lVar));
                    }
                    synchronized (z.f12295n0) {
                        try {
                            int i11 = z.f12297p0 - 1;
                            z.f12297p0 = i11;
                            if (i11 == 0) {
                                z.f12296o0.shutdown();
                                z.f12296o0 = null;
                            }
                            throw th;
                        } finally {
                        }
                    }
                }
        }
    }
}
