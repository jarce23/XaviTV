package k9;

import j9.j0;
import j9.r;
import j9.z0;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: o, reason: collision with root package name */
    public final r f7842o;

    /* renamed from: p, reason: collision with root package name */
    public final long f7843p;

    /* renamed from: q, reason: collision with root package name */
    public final long f7844q;

    public d(r rVar, long j10, long j11) {
        this.f7842o = rVar;
        long c10 = c(j10);
        this.f7843p = c10;
        this.f7844q = c(c10 + j11);
    }

    public final InputStream a(long j10, long j11) {
        long c10 = c(this.f7843p);
        long c11 = c(j11 + c10) - c10;
        r rVar = this.f7842o;
        TreeMap treeMap = rVar.f7423o;
        if (c10 < 0 || c11 < 0) {
            throw new j0("Invalid input parameters " + c10 + ", " + c11);
        }
        long j12 = c10 + c11;
        if (j12 > rVar.a()) {
            throw new j0("Trying to access archive out of bounds. Archive ends at: " + rVar.a() + ". Tried accessing: " + j12);
        }
        Long l10 = (Long) treeMap.floorKey(Long.valueOf(c10));
        Long l11 = (Long) treeMap.floorKey(Long.valueOf(j12));
        if (l10.equals(l11)) {
            return new j9.q(rVar.c(c10, l10), c11);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(rVar.c(c10, l10));
        Collection values = treeMap.subMap(l10, false, l11, false).values();
        if (!values.isEmpty()) {
            arrayList.add(new z0(Collections.enumeration(values)));
        }
        arrayList.add(new j9.q(new FileInputStream((File) treeMap.get(l11)), c11 - (l11.longValue() - c10)));
        return new SequenceInputStream(Collections.enumeration(arrayList));
    }

    public final long c(long j10) {
        if (j10 < 0) {
            return 0L;
        }
        r rVar = this.f7842o;
        return j10 > rVar.a() ? rVar.a() : j10;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
