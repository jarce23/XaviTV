package n5;

import j9.o0;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import m5.p;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f9198a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9199b;

    /* renamed from: c, reason: collision with root package name */
    public final String f9200c;

    /* renamed from: d, reason: collision with root package name */
    public final long f9201d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9202e;

    /* renamed from: f, reason: collision with root package name */
    public final long f9203f;
    public final long g;

    /* renamed from: h, reason: collision with root package name */
    public final List f9204h;

    public b(String str, String str2, long j10, long j11, long j12, long j13, List list) {
        this.f9199b = str;
        this.f9200c = _UrlKt.FRAGMENT_ENCODE_SET.equals(str2) ? null : str2;
        this.f9201d = j10;
        this.f9202e = j11;
        this.f9203f = j12;
        this.g = j13;
        this.f9204h = list;
    }

    public static b a(c cVar) {
        if (o0.j(cVar) != 538247942) {
            throw new IOException();
        }
        String l10 = o0.l(cVar);
        String l11 = o0.l(cVar);
        long k10 = o0.k(cVar);
        long k11 = o0.k(cVar);
        long k12 = o0.k(cVar);
        long k13 = o0.k(cVar);
        int j10 = o0.j(cVar);
        if (j10 < 0) {
            throw new IOException(android.support.v4.media.d.m(j10, "readHeaderList size="));
        }
        List arrayList = j10 == 0 ? Collections.EMPTY_LIST : new ArrayList();
        for (int i10 = 0; i10 < j10; i10++) {
            arrayList.add(new m5.e(o0.l(cVar).intern(), o0.l(cVar).intern()));
        }
        return new b(l10, l11, k10, k11, k12, k13, arrayList);
    }

    public final m5.b b(byte[] bArr) {
        m5.b bVar = new m5.b();
        bVar.f8950a = bArr;
        bVar.f8951b = this.f9200c;
        bVar.f8952c = this.f9201d;
        bVar.f8953d = this.f9202e;
        bVar.f8954e = this.f9203f;
        bVar.f8955f = this.g;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        List<m5.e> list = this.f9204h;
        for (m5.e eVar : list) {
            treeMap.put(eVar.f8964a, eVar.f8965b);
        }
        bVar.g = treeMap;
        bVar.f8956h = Collections.unmodifiableList(list);
        return bVar;
    }

    public final boolean c(BufferedOutputStream bufferedOutputStream) {
        try {
            o0.o(bufferedOutputStream, 538247942);
            o0.q(bufferedOutputStream, this.f9199b);
            String str = this.f9200c;
            if (str == null) {
                str = _UrlKt.FRAGMENT_ENCODE_SET;
            }
            o0.q(bufferedOutputStream, str);
            o0.p(bufferedOutputStream, this.f9201d);
            o0.p(bufferedOutputStream, this.f9202e);
            o0.p(bufferedOutputStream, this.f9203f);
            o0.p(bufferedOutputStream, this.g);
            List<m5.e> list = this.f9204h;
            if (list != null) {
                o0.o(bufferedOutputStream, list.size());
                for (m5.e eVar : list) {
                    o0.q(bufferedOutputStream, eVar.f8964a);
                    o0.q(bufferedOutputStream, eVar.f8965b);
                }
            } else {
                o0.o(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            return true;
        } catch (IOException e7) {
            p.b("%s", e7.toString());
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(java.lang.String r14, m5.b r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.f8951b
            long r3 = r15.f8952c
            long r5 = r15.f8953d
            long r7 = r15.f8954e
            long r9 = r15.f8955f
            java.util.List r0 = r15.f8956h
            if (r0 == 0) goto L12
        Le:
            r1 = r14
            r11 = r0
            r0 = r13
            goto L46
        L12:
            java.util.Map r15 = r15.g
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L25:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto Le
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            m5.e r11 = new m5.e
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L25
        L46:
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: n5.b.<init>(java.lang.String, m5.b):void");
    }
}
