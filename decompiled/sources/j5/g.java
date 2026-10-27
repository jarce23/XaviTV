package j5;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Toast;
import app.shamel.tv.activities.MoviePlayerActivity;
import app.shamel.tv.models.EPGChannel;
import b4.m0;
import b4.o1;
import h5.g0;
import h5.t;
import i1.n;
import io.realm.c0;
import io.realm.internal.OsObjectStore;
import j9.g1;
import j9.r0;
import j9.t0;
import j9.u0;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import l7.o;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import r5.h;
import r5.k;
import r7.r;
import t5.y;
import x4.j;
import z1.l;
import z1.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g implements k, t, g0, t0, o, h3.k, l {

    /* renamed from: q, reason: collision with root package name */
    public static g f7113q;

    /* renamed from: o, reason: collision with root package name */
    public Object f7114o;

    /* renamed from: p, reason: collision with root package name */
    public Object f7115p;

    public /* synthetic */ g(Object obj, Object obj2) {
        this.f7114o = obj;
        this.f7115p = obj2;
    }

    public int A(int i10) {
        int i11;
        SparseIntArray sparseIntArray = (SparseIntArray) this.f7114o;
        synchronized (sparseIntArray) {
            i11 = sparseIntArray.get(i10, -1);
        }
        return i11;
    }

    @Override // h5.t
    public void a() {
        MoviePlayerActivity moviePlayerActivity = (MoviePlayerActivity) this.f7115p;
        moviePlayerActivity.f1763k0.J(false, false);
        moviePlayerActivity.v(moviePlayerActivity.f1776x0, (String) this.f7114o);
        moviePlayerActivity.f1757d0.setVisibility(0);
        moviePlayerActivity.u();
    }

    @Override // h3.k
    public /* synthetic */ h3.e b(byte[] bArr, int i10, int i11) {
        return android.support.v4.media.d.a(this, bArr, i11);
    }

    @Override // j9.t0
    public Object c() {
        u0 u0Var = (u0) this.f7114o;
        List list = (List) this.f7115p;
        HashMap hashMap = new HashMap();
        for (r0 r0Var : u0Var.f7460c.values()) {
            String str = r0Var.f7426c.f7416a;
            if (list.contains(str)) {
                r0 r0Var2 = (r0) hashMap.get(str);
                if ((r0Var2 == null ? -1 : r0Var2.f7424a) < r0Var.f7424a) {
                    hashMap.put(str, r0Var);
                }
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:195:0x03a5, code lost:
    
        r0.addAll(r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:222:0x0116, code lost:
    
        if (")".equals(q3.a.b(r11, r6)) == false) goto L37;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v11, types: [java.util.regex.Matcher] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34, types: [int] */
    /* JADX WARN: Type inference failed for: r1v35 */
    /* JADX WARN: Type inference failed for: r1v49 */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r4v32, types: [java.util.regex.Matcher] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int] */
    /* JADX WARN: Type inference failed for: r9v3 */
    @Override // h3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(byte[] r19, int r20, int r21, h3.j r22, l1.h r23) {
        /*
            Method dump skipped, instructions count: 1062
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.g.d(byte[], int, int, h3.j, l1.h):void");
    }

    @Override // h5.t
    public void e() {
        MoviePlayerActivity moviePlayerActivity = (MoviePlayerActivity) this.f7115p;
        moviePlayerActivity.v(0L, (String) this.f7114o);
        moviePlayerActivity.f1757d0.setVisibility(0);
        moviePlayerActivity.u();
    }

    public boolean f(int i10) {
        return ((n) this.f7114o).f5920a.get(i10);
    }

    @Override // l7.o
    public void g(long j10, long j11, long j12, String str) {
        o oVar = (o) this.f7114o;
        if (oVar != null) {
            oVar.g(j10, j11, j12, str);
        }
    }

    public boolean i(j jVar) {
        boolean containsKey;
        synchronized (this.f7114o) {
            containsKey = ((LinkedHashMap) this.f7115p).containsKey(jVar);
        }
        return containsKey;
    }

    @Override // z1.l
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public z1.d h(g1 g1Var) {
        MediaCodec mediaCodec;
        String str = ((p) g1Var.f7290o).f14000a;
        z1.d dVar = null;
        try {
            Trace.beginSection("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            try {
                z1.d dVar2 = new z1.d(mediaCodec, (HandlerThread) ((z1.c) this.f7114o).get(), new z1.f(mediaCodec, (HandlerThread) ((z1.c) this.f7115p).get()), (z1.k) g1Var.f7295t);
                try {
                    Trace.endSection();
                    Surface surface = (Surface) g1Var.f7293r;
                    z1.d.c(dVar2, (MediaFormat) g1Var.f7291p, surface, (MediaCrypto) g1Var.f7294s, (surface == null && ((p) g1Var.f7290o).f14006h && Build.VERSION.SDK_INT >= 35) ? 8 : 0);
                    return dVar2;
                } catch (Exception e7) {
                    e = e7;
                    dVar = dVar2;
                    if (dVar != null) {
                        dVar.a();
                    } else if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    throw e;
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Exception e10) {
            e = e10;
            mediaCodec = null;
        }
    }

    public View k(int i10, int i11, int i12, int i13) {
        View w10;
        o1 o1Var = (o1) this.f7115p;
        m0 m0Var = (m0) this.f7114o;
        int d6 = m0Var.d();
        int c10 = m0Var.c();
        int i14 = i11 > i10 ? 1 : -1;
        View view = null;
        while (i10 != i11) {
            switch (m0Var.f2309a) {
                case 0:
                    w10 = m0Var.f2310b.w(i10);
                    break;
                default:
                    w10 = m0Var.f2310b.w(i10);
                    break;
            }
            int b2 = m0Var.b(w10);
            int a10 = m0Var.a(w10);
            o1Var.f2372b = d6;
            o1Var.f2373c = c10;
            o1Var.f2374d = b2;
            o1Var.f2375e = a10;
            if (i12 != 0) {
                o1Var.f2371a = i12;
                if (o1Var.a()) {
                    return w10;
                }
            }
            if (i13 != 0) {
                o1Var.f2371a = i13;
                if (o1Var.a()) {
                    view = w10;
                }
            }
            i10 += i14;
        }
        return view;
    }

    @Override // r5.b
    public boolean l(Object obj, File file, h hVar) {
        return ((a6.b) this.f7115p).l(new a6.e(((BitmapDrawable) ((y) obj).get()).getBitmap(), (u5.a) this.f7114o), file, hVar);
    }

    public k2.n m(Object... objArr) {
        Constructor c10;
        synchronized (((AtomicBoolean) this.f7115p)) {
            if (!((AtomicBoolean) this.f7115p).get()) {
                try {
                    c10 = ((h3.b) this.f7114o).c();
                } catch (ClassNotFoundException unused) {
                    ((AtomicBoolean) this.f7115p).set(true);
                } catch (Exception e7) {
                    throw new RuntimeException("Error instantiating extension", e7);
                }
            }
            c10 = null;
        }
        if (c10 == null) {
            return null;
        }
        try {
            return (k2.n) c10.newInstance(objArr);
        } catch (Exception e8) {
            throw new IllegalStateException("Unexpected error creating extractor", e8);
        }
    }

    @Override // l7.o
    public void n(String str, long j10, int i10, Object obj, long j11, long j12) {
        ((l7.n) this.f7115p).g = null;
        o oVar = (o) this.f7114o;
        if (oVar != null) {
            oVar.n(str, j10, i10, obj, j11, j12);
        }
    }

    public synchronized Map o() {
        try {
            if (((Map) this.f7115p) == null) {
                this.f7115p = Collections.unmodifiableMap(new HashMap((HashMap) this.f7114o));
            }
        } catch (Throwable th) {
            throw th;
        }
        return (Map) this.f7115p;
    }

    public boolean p(View view) {
        o1 o1Var = (o1) this.f7115p;
        m0 m0Var = (m0) this.f7114o;
        int d6 = m0Var.d();
        int c10 = m0Var.c();
        int b2 = m0Var.b(view);
        int a10 = m0Var.a(view);
        o1Var.f2372b = d6;
        o1Var.f2373c = c10;
        o1Var.f2374d = b2;
        o1Var.f2375e = a10;
        o1Var.f2371a = 24579;
        return o1Var.a();
    }

    public void q(int i10) {
        io.realm.f fVar = (io.realm.f) this.f7115p;
        if (i10 > 0) {
            return;
        }
        ((c0) this.f7114o).f6637c.getClass();
        if (OsObjectStore.b(fVar.f6647s) != -1) {
            return;
        }
        fVar.f6647s.beginTransaction();
        if (OsObjectStore.b(fVar.f6647s) == -1) {
            OsObjectStore.c(fVar.f6647s);
        }
        fVar.f6647s.commitTransaction();
    }

    public void r(String str) {
        v5.b bVar;
        synchronized (this) {
            try {
                bVar = (v5.b) ((HashMap) this.f7114o).get(str);
                m6.f.c("Argument must not be null", bVar);
                int i10 = bVar.f12677b;
                if (i10 < 1) {
                    throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + bVar.f12677b);
                }
                int i11 = i10 - 1;
                bVar.f12677b = i11;
                if (i11 == 0) {
                    v5.b bVar2 = (v5.b) ((HashMap) this.f7114o).remove(str);
                    if (!bVar2.equals(bVar)) {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", safeKey: " + str);
                    }
                    ((e6.a) this.f7115p).b(bVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.f12676a.unlock();
    }

    public List s(String str) {
        List J;
        za.h.e("workSpecId", str);
        synchronized (this.f7114o) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7115p;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (za.h.a(((j) entry.getKey()).f13557a, str)) {
                        linkedHashMap2.put(entry.getKey(), entry.getValue());
                    }
                }
                Iterator it = linkedHashMap2.keySet().iterator();
                while (it.hasNext()) {
                    ((LinkedHashMap) this.f7115p).remove((j) it.next());
                }
                J = ma.j.J(linkedHashMap2.values());
            } catch (Throwable th) {
                throw th;
            }
        }
        return J;
    }

    @Override // h5.g0
    public void t() {
        h5.c0 c0Var = (h5.c0) this.f7115p;
        Toast.makeText(c0Var.f5587y0, c0Var.H0.getPut_pin_code(), 0).show();
    }

    @Override // h5.g0
    public void u() {
        h5.c0 c0Var = (h5.c0) this.f7115p;
        Toast.makeText(c0Var.f5587y0, c0Var.H0.getPin_incorrect(), 0).show();
    }

    @Override // r5.k
    public int v(h hVar) {
        return 2;
    }

    public p4.l w(j jVar) {
        p4.l lVar;
        synchronized (this.f7114o) {
            lVar = (p4.l) ((LinkedHashMap) this.f7115p).remove(jVar);
        }
        return lVar;
    }

    public p4.l x(j jVar) {
        p4.l lVar;
        synchronized (this.f7114o) {
            try {
                LinkedHashMap linkedHashMap = (LinkedHashMap) this.f7115p;
                Object obj = linkedHashMap.get(jVar);
                if (obj == null) {
                    obj = new p4.l(jVar);
                    linkedHashMap.put(jVar, obj);
                }
                lVar = (p4.l) obj;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // h5.g0
    public void y() {
        h5.c0 c0Var = (h5.c0) this.f7115p;
        c0Var.B0.a((EPGChannel) this.f7114o);
        c0Var.J(false, false);
    }

    public int z(Context context, o7.c cVar) {
        int i10;
        r.e(context);
        r.e(cVar);
        int a10 = cVar.a();
        int A = A(a10);
        if (A != -1) {
            return A;
        }
        SparseIntArray sparseIntArray = (SparseIntArray) this.f7114o;
        synchronized (sparseIntArray) {
            i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    if (i11 >= sparseIntArray.size()) {
                        i10 = -1;
                        break;
                    }
                    int keyAt = sparseIntArray.keyAt(i11);
                    if (keyAt > a10 && sparseIntArray.get(keyAt) == 0) {
                        break;
                    }
                    i11++;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i10 == -1) {
                i10 = ((n7.d) this.f7115p).b(context, a10);
            }
            sparseIntArray.put(a10, i10);
        }
        return i10;
    }

    public /* synthetic */ g(Object obj, Object obj2, boolean z10) {
        this.f7115p = obj;
        this.f7114o = obj2;
    }

    public g(Context context, int i10) {
        switch (i10) {
            case 18:
                this.f7115p = context == null ? null : context.getApplicationContext();
                break;
            default:
                Context applicationContext = context.getApplicationContext();
                this.f7115p = applicationContext;
                if (((m5.j) this.f7114o) == null) {
                    this.f7114o = a.a.p(applicationContext.getApplicationContext());
                }
                this.f7114o = (m5.j) this.f7114o;
                break;
        }
    }

    public g(int i10) {
        switch (i10) {
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                this.f7114o = new Object();
                this.f7115p = new LinkedHashMap();
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                this.f7114o = new l1.t();
                this.f7115p = new q3.a();
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                n7.d dVar = n7.d.f9226e;
                this.f7114o = new SparseIntArray();
                this.f7115p = dVar;
                break;
            case 17:
            case 18:
            default:
                this.f7114o = new HashMap();
                break;
            case 19:
                this.f7114o = new HashMap();
                this.f7115p = new e6.a(1);
                break;
        }
    }

    public g(m0 m0Var) {
        this.f7114o = m0Var;
        o1 o1Var = new o1();
        o1Var.f2371a = 0;
        this.f7115p = o1Var;
    }

    public g(Animation animation) {
        this.f7114o = animation;
        this.f7115p = null;
    }

    @Override // h3.k
    public /* synthetic */ void reset() {
    }

    public g(h3.b bVar) {
        this.f7114o = bVar;
        this.f7115p = new AtomicBoolean(false);
    }
}
