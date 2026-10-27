package q6;

import android.content.Context;
import android.net.ConnectivityManager;
import java.net.MalformedURLException;
import java.net.URL;
import p4.p;
import r6.c;
import r6.f;
import r6.g;
import r6.h;
import r6.i;
import r6.j;
import r6.k;
import r6.l;
import r6.n;
import r6.o;
import r6.q;
import r6.r;
import r6.s;
import r6.v;
import t6.e;
import v9.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    public final p f10352a;

    /* renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f10353b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f10354c;

    /* renamed from: d, reason: collision with root package name */
    public final URL f10355d;

    /* renamed from: e, reason: collision with root package name */
    public final c7.a f10356e;

    /* renamed from: f, reason: collision with root package name */
    public final c7.a f10357f;
    public final int g;

    public b(Context context, c7.a aVar, c7.a aVar2) {
        d dVar = new d();
        c cVar = c.f10810a;
        dVar.a(o.class, cVar);
        dVar.a(i.class, cVar);
        f fVar = f.f10822a;
        dVar.a(s.class, fVar);
        dVar.a(l.class, fVar);
        r6.d dVar2 = r6.d.f10812a;
        dVar.a(q.class, dVar2);
        dVar.a(j.class, dVar2);
        r6.b bVar = r6.b.f10798a;
        dVar.a(r6.a.class, bVar);
        dVar.a(h.class, bVar);
        r6.e eVar = r6.e.f10815a;
        dVar.a(r.class, eVar);
        dVar.a(k.class, eVar);
        g gVar = g.f10829a;
        dVar.a(v.class, gVar);
        dVar.a(n.class, gVar);
        dVar.f12699d = true;
        this.f10352a = new p(21, dVar);
        this.f10354c = context;
        this.f10353b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f10355d = b(a.f10347c);
        this.f10356e = aVar2;
        this.f10357f = aVar;
        this.g = 40000;
    }

    public static URL b(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e7) {
            throw new IllegalArgumentException(r.a.l("Invalid url: ", str), e7);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        if (((r6.t) r6.t.f10862o.get(r0)) != null) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0110  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final s6.h a(s6.h r7) {
        /*
            Method dump skipped, instructions count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q6.b.a(s6.h):s6.h");
    }
}
