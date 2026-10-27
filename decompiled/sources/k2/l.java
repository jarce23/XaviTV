package k2;

import java.util.ArrayList;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l implements q {

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f7757e = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14, 17, 18, 19, 20, 21};

    /* renamed from: f, reason: collision with root package name */
    public static final j5.g f7758f = new j5.g(new h3.b(5));
    public static final j5.g g = new j5.g(new h3.b(6));

    /* renamed from: a, reason: collision with root package name */
    public w0 f7759a;

    /* renamed from: d, reason: collision with root package name */
    public int f7762d;

    /* renamed from: c, reason: collision with root package name */
    public d9.f f7761c = new d9.f(21);

    /* renamed from: b, reason: collision with root package name */
    public boolean f7760b = true;

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:3:0x0001, B:5:0x0015, B:8:0x001c, B:9:0x0024, B:11:0x002b, B:12:0x0031, B:15:0x0039, B:18:0x003f, B:21:0x0045, B:23:0x0048, B:27:0x004b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003f A[Catch: all -> 0x002f, TryCatch #0 {all -> 0x002f, blocks: (B:3:0x0001, B:5:0x0015, B:8:0x001c, B:9:0x0024, B:11:0x002b, B:12:0x0031, B:15:0x0039, B:18:0x003f, B:21:0x0045, B:23:0x0048, B:27:0x004b), top: B:2:0x0001 }] */
    @Override // k2.q
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized k2.n[] a(android.net.Uri r7, java.util.Map r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L2f
            int[] r1 = k2.l.f7757e     // Catch: java.lang.Throwable -> L2f
            r2 = 21
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r3 = "Content-Type"
            java.lang.Object r8 = r8.get(r3)     // Catch: java.lang.Throwable -> L2f
            java.util.List r8 = (java.util.List) r8     // Catch: java.lang.Throwable -> L2f
            r3 = 0
            if (r8 == 0) goto L23
            boolean r4 = r8.isEmpty()     // Catch: java.lang.Throwable -> L2f
            if (r4 == 0) goto L1c
            goto L23
        L1c:
            java.lang.Object r8 = r8.get(r3)     // Catch: java.lang.Throwable -> L2f
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L2f
            goto L24
        L23:
            r8 = 0
        L24:
            int r8 = k5.a.q(r8)     // Catch: java.lang.Throwable -> L2f
            r4 = -1
            if (r8 == r4) goto L31
            r6.b(r8, r0)     // Catch: java.lang.Throwable -> L2f
            goto L31
        L2f:
            r7 = move-exception
            goto L55
        L31:
            int r7 = k5.a.r(r7)     // Catch: java.lang.Throwable -> L2f
            if (r7 == r4) goto L3c
            if (r7 == r8) goto L3c
            r6.b(r7, r0)     // Catch: java.lang.Throwable -> L2f
        L3c:
            r4 = r3
        L3d:
            if (r4 >= r2) goto L4b
            r5 = r1[r4]     // Catch: java.lang.Throwable -> L2f
            if (r5 == r8) goto L48
            if (r5 == r7) goto L48
            r6.b(r5, r0)     // Catch: java.lang.Throwable -> L2f
        L48:
            int r4 = r4 + 1
            goto L3d
        L4b:
            k2.n[] r7 = new k2.n[r3]     // Catch: java.lang.Throwable -> L2f
            java.lang.Object[] r7 = r0.toArray(r7)     // Catch: java.lang.Throwable -> L2f
            k2.n[] r7 = (k2.n[]) r7     // Catch: java.lang.Throwable -> L2f
            monitor-exit(r6)
            return r7
        L55:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L2f
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.l.a(android.net.Uri, java.util.Map):k2.n[]");
    }

    public final void b(int i10, ArrayList arrayList) {
        switch (i10) {
            case 0:
                arrayList.add(new r3.a());
                break;
            case 1:
                arrayList.add(new r3.c());
                break;
            case 2:
                arrayList.add(new r3.d(0));
                break;
            case 3:
                arrayList.add(new l2.a());
                break;
            case 4:
                n m10 = f7758f.m(0);
                if (m10 == null) {
                    arrayList.add(new p2.b());
                    break;
                } else {
                    arrayList.add(m10);
                    break;
                }
            case 5:
                arrayList.add(new q2.b());
                break;
            case 6:
                arrayList.add(new c3.d(this.f7761c, this.f7760b ? 0 : 2));
                break;
            case 7:
                arrayList.add(new d3.d(0));
                break;
            case 8:
                d9.f fVar = this.f7761c;
                int i11 = this.f7760b ? 0 : 32;
                o9.e0 e0Var = o9.g0.f9617p;
                arrayList.add(new e3.j(fVar, i11, null, w0.f9686s));
                arrayList.add(new e3.m(this.f7761c, this.f7760b ? 0 : 16));
                break;
            case 9:
                arrayList.add(new f3.d());
                break;
            case 10:
                arrayList.add(new r3.z());
                break;
            case 11:
                if (this.f7759a == null) {
                    o9.e0 e0Var2 = o9.g0.f9617p;
                    this.f7759a = w0.f9686s;
                }
                arrayList.add(new r3.c0(1, !this.f7760b ? 1 : 0, this.f7761c, new l1.y(0L), new j0.i(0, this.f7759a)));
                break;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                s3.d dVar = new s3.d();
                dVar.f11553c = 0;
                dVar.f11554d = -1L;
                dVar.f11556f = -1;
                dVar.g = -1L;
                arrayList.add(dVar);
                break;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                arrayList.add(new g3.a(this.f7762d));
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                n m11 = g.m(new Object[0]);
                if (m11 != null) {
                    arrayList.add(m11);
                    break;
                }
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                arrayList.add(new m2.b(!this.f7760b ? 1 : 0, this.f7761c));
                break;
            case 17:
                arrayList.add(new g3.a((byte) 0, 0));
                break;
            case 18:
                arrayList.add(new n2.a(2));
                break;
            case 19:
                arrayList.add(new g3.a((byte) 0, 1));
                break;
            case 20:
                arrayList.add(new n2.a(1));
                break;
            case 21:
                arrayList.add(new n2.a(0));
                break;
        }
    }
}
