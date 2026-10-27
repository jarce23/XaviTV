package androidx.emoji2.text;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import com.google.android.gms.internal.cast.u5;
import i1.g0;
import j9.g1;
import j9.v1;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import m.d3;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class o implements k, m6.g, z1.l {

    /* renamed from: o, reason: collision with root package name */
    public Context f591o;

    public /* synthetic */ o(Context context, boolean z10) {
        this.f591o = context;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0073, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 26) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007a, code lost:
    
        if (android.os.Build.VERSION.SDK_INT >= 34) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(i1.p r5) {
        /*
            java.lang.String r0 = r5.f5991n
            r1 = 0
            if (r0 == 0) goto L86
            boolean r0 = i1.g0.j(r0)
            if (r0 != 0) goto Ld
            goto L86
        Ld:
            java.lang.String r5 = r5.f5991n
            int r0 = l1.a0.f8067a
            r5.getClass()
            int r0 = r5.hashCode()
            r2 = 4
            r3 = 1
            r4 = -1
            switch(r0) {
                case -1487656890: goto L61;
                case -1487464693: goto L56;
                case -1487464690: goto L4b;
                case -1487394660: goto L40;
                case -1487018032: goto L35;
                case -879272239: goto L2a;
                case -879258763: goto L1f;
                default: goto L1e;
            }
        L1e:
            goto L6b
        L1f:
            java.lang.String r0 = "image/png"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L28
            goto L6b
        L28:
            r4 = 6
            goto L6b
        L2a:
            java.lang.String r0 = "image/bmp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L33
            goto L6b
        L33:
            r4 = 5
            goto L6b
        L35:
            java.lang.String r0 = "image/webp"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L3e
            goto L6b
        L3e:
            r4 = r2
            goto L6b
        L40:
            java.lang.String r0 = "image/jpeg"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L49
            goto L6b
        L49:
            r4 = 3
            goto L6b
        L4b:
            java.lang.String r0 = "image/heif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L54
            goto L6b
        L54:
            r4 = 2
            goto L6b
        L56:
            java.lang.String r0 = "image/heic"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L5f
            goto L6b
        L5f:
            r4 = r3
            goto L6b
        L61:
            java.lang.String r0 = "image/avif"
            boolean r5 = r5.equals(r0)
            if (r5 != 0) goto L6a
            goto L6b
        L6a:
            r4 = r1
        L6b:
            switch(r4) {
                case 0: goto L76;
                case 1: goto L6f;
                case 2: goto L6f;
                case 3: goto L7c;
                case 4: goto L7c;
                case 5: goto L7c;
                case 6: goto L7c;
                default: goto L6e;
            }
        L6e:
            goto L81
        L6f:
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 26
            if (r5 < r0) goto L81
            goto L7c
        L76:
            int r5 = android.os.Build.VERSION.SDK_INT
            r0 = 34
            if (r5 < r0) goto L81
        L7c:
            int r5 = r.a.a(r2, r1, r1, r1)
            return r5
        L81:
            int r5 = r.a.a(r3, r1, r1, r1)
            return r5
        L86:
            int r5 = r.a.a(r1, r1, r1, r1)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.o.c(i1.p):int");
    }

    @Override // androidx.emoji2.text.k
    public void a(j1.c cVar) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("EmojiCompatInitializer", 0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new m(this, cVar, threadPoolExecutor, 0));
    }

    public s6.j b() {
        Context context = this.f591o;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        s6.j jVar = new s6.j();
        jVar.f11614o = v6.a.a(s6.l.f11621a);
        v6.c cVar = new v6.c(context);
        jVar.f11615p = cVar;
        jVar.f11616q = v6.a.a(new x4.l((Object) cVar, (Object) new p4.p(9, cVar), false));
        v6.c cVar2 = jVar.f11615p;
        ka.a a10 = v6.a.a(new x4.e(new a7.e(cVar2, 1), 1, new a7.e(cVar2, 0)));
        jVar.f11617r = a10;
        v1 v1Var = new v1(25);
        v6.c cVar3 = jVar.f11615p;
        android.support.v4.media.session.a0 a0Var = new android.support.v4.media.session.a0(cVar3, a10, v1Var, 28);
        ka.a aVar = jVar.f11614o;
        ka.a aVar2 = jVar.f11616q;
        jVar.f11618s = v6.a.a(new android.support.v4.media.session.a0(new u5(aVar, aVar2, a0Var, a10, a10), new d3(cVar3, aVar2, a10, a0Var, aVar, a10, a10), new x4.i(aVar, a10, a0Var, a10, 20), 22));
        return jVar;
    }

    @Override // m6.g
    public Object get() {
        return (ConnectivityManager) this.f591o.getSystemService("connectivity");
    }

    @Override // z1.l
    public z1.m h(g1 g1Var) {
        Context context;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 31 && ((context = this.f591o) == null || i10 < 28 || !context.getPackageManager().hasSystemFeature("com.amazon.hardware.tv_screen"))) {
            return new v1(27).h(g1Var);
        }
        int h10 = g0.h(((i1.p) g1Var.f7292q).f5991n);
        l1.b.l("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + l1.a0.E(h10));
        return new j5.g(new z1.c(h10, 0), new z1.c(h10, 1)).h(g1Var);
    }
}
