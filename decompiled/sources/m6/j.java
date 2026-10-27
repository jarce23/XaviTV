package m6;

import android.os.SystemClock;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import u1.z;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public long f9019a;

    /* renamed from: b, reason: collision with root package name */
    public long f9020b;

    /* renamed from: c, reason: collision with root package name */
    public Serializable f9021c;

    public j(long j10) {
        this.f9021c = new LinkedHashMap(100, 0.75f, true);
        this.f9019a = j10;
    }

    public synchronized Object a(Object obj) {
        i iVar;
        iVar = (i) ((LinkedHashMap) this.f9021c).get(obj);
        return iVar != null ? iVar.f9017a : null;
    }

    public int b(Object obj) {
        return 1;
    }

    public synchronized Object d(Object obj, Object obj2) {
        int b2 = b(obj2);
        long j10 = b2;
        if (j10 >= this.f9019a) {
            c(obj, obj2);
            return null;
        }
        if (obj2 != null) {
            this.f9020b += j10;
        }
        i iVar = (i) ((LinkedHashMap) this.f9021c).put(obj, obj2 == null ? null : new i(b2, obj2));
        if (iVar != null) {
            this.f9020b -= iVar.f9018b;
            if (!iVar.f9017a.equals(obj2)) {
                c(obj, iVar.f9017a);
            }
        }
        f(this.f9019a);
        return iVar != null ? iVar.f9017a : null;
    }

    public void e(Exception exc) {
        boolean z10;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (((Exception) this.f9021c) == null) {
            this.f9021c = exc;
        }
        if (this.f9019a == -9223372036854775807L) {
            synchronized (z.f12295n0) {
                z10 = z.f12297p0 > 0;
            }
            if (!z10) {
                this.f9019a = 200 + elapsedRealtime;
            }
        }
        long j10 = this.f9019a;
        if (j10 == -9223372036854775807L || elapsedRealtime < j10) {
            this.f9020b = elapsedRealtime + 50;
            return;
        }
        Exception exc2 = (Exception) this.f9021c;
        if (exc2 != exc) {
            exc2.addSuppressed(exc);
        }
        Exception exc3 = (Exception) this.f9021c;
        this.f9021c = null;
        this.f9019a = -9223372036854775807L;
        this.f9020b = -9223372036854775807L;
        throw exc3;
    }

    public synchronized void f(long j10) {
        while (this.f9020b > j10) {
            Iterator it = ((LinkedHashMap) this.f9021c).entrySet().iterator();
            Map.Entry entry = (Map.Entry) it.next();
            i iVar = (i) entry.getValue();
            this.f9020b -= iVar.f9018b;
            Object key = entry.getKey();
            it.remove();
            c(key, iVar.f9017a);
        }
    }

    public j() {
        this.f9019a = -9223372036854775807L;
        this.f9020b = -9223372036854775807L;
    }

    public void c(Object obj, Object obj2) {
    }
}
