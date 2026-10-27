package o1;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements h {

    /* renamed from: o, reason: collision with root package name */
    public final Context f9436o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f9437p;

    /* renamed from: q, reason: collision with root package name */
    public final h f9438q;

    /* renamed from: r, reason: collision with root package name */
    public s f9439r;

    /* renamed from: s, reason: collision with root package name */
    public b f9440s;

    /* renamed from: t, reason: collision with root package name */
    public e f9441t;

    /* renamed from: u, reason: collision with root package name */
    public h f9442u;

    /* renamed from: v, reason: collision with root package name */
    public g0 f9443v;

    /* renamed from: w, reason: collision with root package name */
    public f f9444w;

    /* renamed from: x, reason: collision with root package name */
    public b0 f9445x;

    /* renamed from: y, reason: collision with root package name */
    public h f9446y;

    public m(Context context, h hVar) {
        this.f9436o = context.getApplicationContext();
        hVar.getClass();
        this.f9438q = hVar;
        this.f9437p = new ArrayList();
    }

    public static void q(h hVar, e0 e0Var) {
        if (hVar != null) {
            hVar.g(e0Var);
        }
    }

    @Override // o1.h
    public final void close() {
        h hVar = this.f9446y;
        if (hVar != null) {
            try {
                hVar.close();
            } finally {
                this.f9446y = null;
            }
        }
    }

    @Override // o1.h
    public final Map e() {
        h hVar = this.f9446y;
        return hVar == null ? Collections.EMPTY_MAP : hVar.e();
    }

    public final void f(h hVar) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f9437p;
            if (i10 >= arrayList.size()) {
                return;
            }
            hVar.g((e0) arrayList.get(i10));
            i10++;
        }
    }

    @Override // o1.h
    public final void g(e0 e0Var) {
        e0Var.getClass();
        this.f9438q.g(e0Var);
        this.f9437p.add(e0Var);
        q(this.f9439r, e0Var);
        q(this.f9440s, e0Var);
        q(this.f9441t, e0Var);
        q(this.f9442u, e0Var);
        q(this.f9443v, e0Var);
        q(this.f9444w, e0Var);
        q(this.f9445x, e0Var);
    }

    @Override // o1.h
    public final long j(l lVar) {
        l1.d.g(this.f9446y == null);
        Uri uri = lVar.f9428a;
        String scheme = uri.getScheme();
        int i10 = l1.a0.f8067a;
        String scheme2 = uri.getScheme();
        boolean isEmpty = TextUtils.isEmpty(scheme2);
        Context context = this.f9436o;
        if (isEmpty || Objects.equals(scheme2, "file")) {
            String path = uri.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                if (this.f9439r == null) {
                    s sVar = new s(false);
                    this.f9439r = sVar;
                    f(sVar);
                }
                this.f9446y = this.f9439r;
            } else {
                if (this.f9440s == null) {
                    b bVar = new b(context);
                    this.f9440s = bVar;
                    f(bVar);
                }
                this.f9446y = this.f9440s;
            }
        } else if ("asset".equals(scheme)) {
            if (this.f9440s == null) {
                b bVar2 = new b(context);
                this.f9440s = bVar2;
                f(bVar2);
            }
            this.f9446y = this.f9440s;
        } else if ("content".equals(scheme)) {
            if (this.f9441t == null) {
                e eVar = new e(context);
                this.f9441t = eVar;
                f(eVar);
            }
            this.f9446y = this.f9441t;
        } else {
            boolean equals = "rtmp".equals(scheme);
            h hVar = this.f9438q;
            if (equals) {
                if (this.f9442u == null) {
                    try {
                        h hVar2 = (h) Class.forName("androidx.media3.datasource.rtmp.RtmpDataSource").getConstructor(null).newInstance(null);
                        this.f9442u = hVar2;
                        f(hVar2);
                    } catch (ClassNotFoundException unused) {
                        l1.b.q("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
                    } catch (Exception e7) {
                        throw new RuntimeException("Error instantiating RTMP extension", e7);
                    }
                    if (this.f9442u == null) {
                        this.f9442u = hVar;
                    }
                }
                this.f9446y = this.f9442u;
            } else if ("udp".equals(scheme)) {
                if (this.f9443v == null) {
                    g0 g0Var = new g0();
                    this.f9443v = g0Var;
                    f(g0Var);
                }
                this.f9446y = this.f9443v;
            } else if ("data".equals(scheme)) {
                if (this.f9444w == null) {
                    f fVar = new f(false);
                    this.f9444w = fVar;
                    f(fVar);
                }
                this.f9446y = this.f9444w;
            } else if ("rawresource".equals(scheme) || "android.resource".equals(scheme)) {
                if (this.f9445x == null) {
                    b0 b0Var = new b0(context);
                    this.f9445x = b0Var;
                    f(b0Var);
                }
                this.f9446y = this.f9445x;
            } else {
                this.f9446y = hVar;
            }
        }
        return this.f9446y.j(lVar);
    }

    @Override // o1.h
    public final Uri l() {
        h hVar = this.f9446y;
        if (hVar == null) {
            return null;
        }
        return hVar.l();
    }

    @Override // i1.h
    public final int read(byte[] bArr, int i10, int i11) {
        h hVar = this.f9446y;
        hVar.getClass();
        return hVar.read(bArr, i10, i11);
    }
}
