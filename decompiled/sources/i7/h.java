package i7;

import android.os.Looper;
import android.support.v4.media.session.a0;
import android.text.TextUtils;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import g7.e0;
import g7.f0;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements g7.f {

    /* renamed from: k, reason: collision with root package name */
    public static final l7.b f6496k = new l7.b("RemoteMediaClient", null);

    /* renamed from: a, reason: collision with root package name */
    public final Object f6497a;

    /* renamed from: b, reason: collision with root package name */
    public final b8.e f6498b;

    /* renamed from: c, reason: collision with root package name */
    public final l7.n f6499c;

    /* renamed from: d, reason: collision with root package name */
    public final a0 f6500d;

    /* renamed from: e, reason: collision with root package name */
    public final c f6501e;

    /* renamed from: f, reason: collision with root package name */
    public f0 f6502f;
    public i8.d g;

    /* renamed from: h, reason: collision with root package name */
    public final CopyOnWriteArrayList f6503h = new CopyOnWriteArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList f6504i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f6505j;

    static {
        String str = l7.n.f8284u;
    }

    public h(l7.n nVar) {
        new ConcurrentHashMap();
        this.f6505j = new ConcurrentHashMap();
        this.f6497a = new Object();
        this.f6498b = new b8.e(Looper.getMainLooper(), 2);
        a0 a0Var = new a0(this);
        this.f6500d = a0Var;
        this.f6499c = nVar;
        nVar.f8287h = new h5.i(6, this);
        nVar.f8310c = a0Var;
        this.f6501e = new c(this);
    }

    public static m u() {
        m mVar = new m();
        mVar.R(new l(new Status(17, null, null, null), 0));
        return mVar;
    }

    public static final void y(n nVar) {
        try {
            nVar.X();
        } catch (IllegalArgumentException e7) {
            throw e7;
        } catch (Throwable unused) {
            nVar.R(new l(new Status(2100, null, null, null), 1));
        }
    }

    public final long a() {
        long o2;
        synchronized (this.f6497a) {
            r7.r.b();
            o2 = this.f6499c.o();
        }
        return o2;
    }

    public final g7.o b() {
        r7.r.b();
        g7.q d6 = d();
        if (d6 == null) {
            return null;
        }
        Integer num = (Integer) d6.L.get(d6.f5287z);
        if (num == null) {
            return null;
        }
        return (g7.o) d6.E.get(num.intValue());
    }

    public final MediaInfo c() {
        MediaInfo mediaInfo;
        synchronized (this.f6497a) {
            r7.r.b();
            g7.q qVar = this.f6499c.f8286f;
            mediaInfo = qVar == null ? null : qVar.f5276o;
        }
        return mediaInfo;
    }

    public final g7.q d() {
        g7.q qVar;
        synchronized (this.f6497a) {
            r7.r.b();
            qVar = this.f6499c.f8286f;
        }
        return qVar;
    }

    public final int e() {
        int i10;
        synchronized (this.f6497a) {
            try {
                r7.r.b();
                g7.q d6 = d();
                i10 = d6 != null ? d6.f5280s : 1;
            } catch (Throwable th) {
                throw th;
            }
        }
        return i10;
    }

    public final long f() {
        long j10;
        synchronized (this.f6497a) {
            r7.r.b();
            g7.q qVar = this.f6499c.f8286f;
            MediaInfo mediaInfo = qVar == null ? null : qVar.f5276o;
            j10 = mediaInfo != null ? mediaInfo.f3150s : 0L;
        }
        return j10;
    }

    public final boolean g() {
        r7.r.b();
        if (h()) {
            return true;
        }
        r7.r.b();
        g7.q d6 = d();
        return (d6 != null && d6.f5280s == 5) || l() || k() || j();
    }

    public final boolean h() {
        r7.r.b();
        g7.q d6 = d();
        return d6 != null && d6.f5280s == 4;
    }

    public final boolean i() {
        r7.r.b();
        MediaInfo c10 = c();
        return c10 != null && c10.f3147p == 2;
    }

    public final boolean j() {
        r7.r.b();
        g7.q d6 = d();
        return (d6 == null || d6.f5287z == 0) ? false : true;
    }

    public final boolean k() {
        int i10;
        r7.r.b();
        g7.q d6 = d();
        if (d6 != null) {
            if (d6.f5280s == 3) {
                return true;
            }
            if (i()) {
                synchronized (this.f6497a) {
                    try {
                        r7.r.b();
                        g7.q d10 = d();
                        i10 = d10 != null ? d10.f5281t : 0;
                    } finally {
                    }
                }
                if (i10 == 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l() {
        r7.r.b();
        g7.q d6 = d();
        return d6 != null && d6.f5280s == 2;
    }

    public final boolean m() {
        r7.r.b();
        g7.q d6 = d();
        return d6 != null && d6.F;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c1 A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x010e A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011e A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012b A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0135 A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013c A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0143 A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x014a A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0183 A[Catch: JSONException -> 0x0082, TryCatch #0 {JSONException -> 0x0082, blocks: (B:12:0x004b, B:14:0x0058, B:16:0x0062, B:17:0x006e, B:19:0x0074, B:28:0x008c, B:30:0x0098, B:32:0x00a7, B:37:0x00c1, B:40:0x00c6, B:41:0x010a, B:43:0x010e, B:44:0x011a, B:46:0x011e, B:47:0x0127, B:49:0x012b, B:50:0x0131, B:52:0x0135, B:53:0x0138, B:55:0x013c, B:56:0x013f, B:58:0x0143, B:59:0x0146, B:61:0x014a, B:63:0x0154, B:65:0x0164, B:66:0x016a, B:68:0x0170, B:70:0x017a, B:71:0x017e, B:72:0x017f, B:74:0x0183, B:75:0x019b, B:76:0x019f, B:78:0x01a5, B:81:0x00cb, B:82:0x00b1, B:84:0x00b7, B:88:0x018d, B:92:0x01b8), top: B:8:0x003e }] */
    /* JADX WARN: Type inference failed for: r3v0, types: [l7.p] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(java.lang.String r47) {
        /*
            Method dump skipped, instructions count: 1086
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.h.n(java.lang.String):void");
    }

    public final void o() {
        r7.r.b();
        if (x()) {
            y(new i(this, 4));
        } else {
            u();
        }
    }

    public final void p() {
        r7.r.b();
        if (x()) {
            y(new i(this, 5));
        } else {
            u();
        }
    }

    public final void q(g gVar) {
        r7.r.b();
        if (gVar != null) {
            this.f6504i.add(gVar);
        }
    }

    public final BasePendingResult r(g7.p pVar) {
        r7.r.b();
        if (!x()) {
            return u();
        }
        j jVar = new j(this, pVar, 2);
        y(jVar);
        return jVar;
    }

    public final void s() {
        r7.r.b();
        int e7 = e();
        if (e7 == 4 || e7 == 2) {
            o();
        } else {
            p();
        }
    }

    public final int t() {
        g7.o b2;
        if (c() != null && g()) {
            if (h()) {
                return 6;
            }
            if (l()) {
                return 3;
            }
            if (k()) {
                return 2;
            }
            if (j() && (b2 = b()) != null && b2.f5266o != null) {
                return 6;
            }
        }
        return 0;
    }

    public final void v() {
        f0 f0Var = this.f6502f;
        if (f0Var == null) {
            return;
        }
        r7.r.b();
        String str = this.f6499c.f8309b;
        e0 e0Var = (e0) f0Var;
        l7.a.b(str);
        synchronized (e0Var.C) {
            e0Var.C.put(str, this);
        }
        e9.d b2 = e9.d.b();
        b2.f4677d = new x4.m(e0Var, str, this, 9);
        b2.f4675b = 8413;
        e0Var.c(1, b2.a());
        r7.r.b();
        if (x()) {
            y(new i(this, 0));
        } else {
            u();
        }
    }

    public final void w(e0 e0Var) {
        g7.f fVar;
        f0 f0Var = this.f6502f;
        if (f0Var == e0Var) {
            return;
        }
        if (f0Var != null) {
            this.f6499c.n();
            this.f6501e.c();
            r7.r.b();
            String str = this.f6499c.f8309b;
            e0 e0Var2 = (e0) f0Var;
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Channel namespace cannot be null or empty");
            }
            synchronized (e0Var2.C) {
                fVar = (g7.f) e0Var2.C.remove(str);
            }
            e9.d b2 = e9.d.b();
            b2.f4677d = new a0(e0Var2, fVar, str, 8);
            b2.f4675b = 8414;
            e0Var2.c(1, b2.a());
            this.f6500d.f230p = null;
            this.f6498b.removeCallbacksAndMessages(null);
        }
        this.f6502f = e0Var;
        if (e0Var != null) {
            this.f6500d.f230p = e0Var;
        }
    }

    public final boolean x() {
        return this.f6502f != null;
    }
}
