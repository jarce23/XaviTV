package c4;

import android.content.Context;
import android.media.AudioManager;
import android.media.Spatializer;
import android.net.ConnectivityManager;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.util.Log;
import android.util.SparseArray;
import app.shamel.tv.activities.v;
import f2.r;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import k2.a0;
import k2.g0;
import k2.p;
import l1.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements m6.g, com.bumptech.glide.manager.n, p {

    /* renamed from: o, reason: collision with root package name */
    public boolean f2875o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f2876p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f2877q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f2878r;

    public e() {
        this.f2876p = new float[16];
        this.f2877q = new float[16];
        this.f2878r = new v();
    }

    public static void d(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f10 = fArr2[10];
        float f11 = fArr2[8];
        float sqrt = (float) Math.sqrt((f11 * f11) + (f10 * f10));
        float f12 = fArr2[10] / sqrt;
        fArr[0] = f12;
        float f13 = fArr2[8];
        fArr[2] = f13 / sqrt;
        fArr[8] = (-f13) / sqrt;
        fArr[10] = f12;
    }

    @Override // com.bumptech.glide.manager.n
    public void a() {
        ((ConnectivityManager) ((c.a) this.f2877q).get()).unregisterNetworkCallback((com.bumptech.glide.manager.p) this.f2878r);
    }

    @Override // com.bumptech.glide.manager.n
    public boolean b() {
        c.a aVar = (c.a) this.f2877q;
        this.f2875o = ((ConnectivityManager) aVar.get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) aVar.get()).registerDefaultNetworkCallback((com.bumptech.glide.manager.p) this.f2878r);
            return true;
        } catch (RuntimeException e7) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e7);
            }
            return false;
        }
    }

    public void c() {
        o5.c.a((o5.c) this.f2878r, this, false);
    }

    public File e() {
        File file;
        synchronized (((o5.c) this.f2878r)) {
            try {
                o5.b bVar = (o5.b) this.f2876p;
                if (bVar.f9526f != this) {
                    throw new IllegalStateException();
                }
                if (!bVar.f9525e) {
                    ((boolean[]) this.f2877q)[0] = true;
                }
                file = bVar.f9524d[0];
                ((o5.c) this.f2878r).f9527o.mkdirs();
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    @Override // k2.p
    public void f() {
        SparseArray sparseArray = (SparseArray) this.f2878r;
        ((p) this.f2876p).f();
        if (this.f2875o) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                ((h3.m) sparseArray.valueAt(i10)).f5548i = true;
            }
        }
    }

    public int[] g() {
        synchronized (this) {
            try {
                if (!this.f2875o) {
                    return null;
                }
                long[] jArr = (long[]) this.f2876p;
                int length = jArr.length;
                int i10 = 0;
                int i11 = 0;
                while (i10 < length) {
                    int i12 = i11 + 1;
                    int i13 = 1;
                    boolean z10 = jArr[i10] > 0;
                    boolean[] zArr = (boolean[]) this.f2877q;
                    if (z10 != zArr[i11]) {
                        int[] iArr = (int[]) this.f2878r;
                        if (!z10) {
                            i13 = 2;
                        }
                        iArr[i11] = i13;
                    } else {
                        ((int[]) this.f2878r)[i11] = 0;
                    }
                    zArr[i11] = z10;
                    i10++;
                    i11 = i12;
                }
                this.f2875o = false;
                return (int[]) ((int[]) this.f2878r).clone();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // m6.g
    public Object get() {
        if (this.f2875o) {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
        com.bumptech.glide.e.d("Glide registry");
        this.f2875o = true;
        try {
            return com.bumptech.glide.f.e((com.bumptech.glide.b) this.f2876p, (List) this.f2877q, (x4.f) this.f2878r);
        } finally {
            this.f2875o = false;
            Trace.endSection();
        }
    }

    public void h() {
        x xVar = (x) this.f2878r;
        if (this.f2875o) {
            xVar.c(new androidx.activity.d(20, this));
            this.f2875o = false;
        }
    }

    @Override // k2.p
    public g0 q(int i10, int i11) {
        SparseArray sparseArray = (SparseArray) this.f2878r;
        p pVar = (p) this.f2876p;
        if (i11 != 3) {
            this.f2875o = true;
            return pVar.q(i10, i11);
        }
        h3.m mVar = (h3.m) sparseArray.get(i10);
        if (mVar != null) {
            return mVar;
        }
        h3.m mVar2 = new h3.m(pVar.q(i10, i11), (h3.i) this.f2877q);
        sparseArray.put(i10, mVar2);
        return mVar2;
    }

    @Override // k2.p
    public void t(a0 a0Var) {
        ((p) this.f2876p).t(a0Var);
    }

    public e(p pVar, h3.i iVar) {
        this.f2876p = pVar;
        this.f2877q = iVar;
        this.f2878r = new SparseArray();
    }

    public e(f.j jVar, Looper looper, Looper looper2, s1.x xVar, l1.v vVar) {
        this.f2876p = jVar.getApplicationContext();
        this.f2878r = vVar.a(looper, null);
        this.f2877q = new s1.a(this, vVar.a(looper2, null), xVar);
    }

    public e(Object obj, m5.b bVar) {
        this.f2875o = false;
        this.f2876p = obj;
        this.f2877q = bVar;
        this.f2878r = null;
    }

    public e(m5.m mVar) {
        this.f2875o = false;
        this.f2876p = null;
        this.f2877q = null;
        this.f2878r = mVar;
    }

    public e(com.bumptech.glide.b bVar, List list, x4.f fVar) {
        this.f2876p = bVar;
        this.f2877q = list;
        this.f2878r = fVar;
    }

    public e(byte[] bArr, Map map, List list, boolean z10) {
        this.f2876p = bArr;
        this.f2877q = map;
        if (list == null) {
            this.f2878r = null;
        } else {
            this.f2878r = Collections.unmodifiableList(list);
        }
        this.f2875o = z10;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(byte[] r5, boolean r6, java.util.List r7) {
        /*
            r4 = this;
            if (r7 != 0) goto L4
            r0 = 0
            goto L2c
        L4:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto Ld
            java.util.Map r0 = java.util.Collections.EMPTY_MAP
            goto L2c
        Ld:
            java.util.TreeMap r0 = new java.util.TreeMap
            java.util.Comparator r1 = java.lang.String.CASE_INSENSITIVE_ORDER
            r0.<init>(r1)
            java.util.Iterator r1 = r7.iterator()
        L18:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L2c
            java.lang.Object r2 = r1.next()
            m5.e r2 = (m5.e) r2
            java.lang.String r3 = r2.f8964a
            java.lang.String r2 = r2.f8965b
            r0.put(r3, r2)
            goto L18
        L2c:
            r4.<init>(r5, r0, r7, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.e.<init>(byte[], boolean, java.util.List):void");
    }

    public e(c.a aVar, com.bumptech.glide.manager.m mVar) {
        this.f2878r = new com.bumptech.glide.manager.p(0, this);
        this.f2877q = aVar;
        this.f2876p = mVar;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e(byte[] r6, java.util.Map r7) {
        /*
            r5 = this;
            if (r7 != 0) goto L4
            r0 = 0
            goto L3f
        L4:
            boolean r0 = r7.isEmpty()
            if (r0 == 0) goto Ld
            java.util.List r0 = java.util.Collections.EMPTY_LIST
            goto L3f
        Ld:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r7.size()
            r0.<init>(r1)
            java.util.Set r1 = r7.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L1e:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            m5.e r3 = new m5.e
            java.lang.Object r4 = r2.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r3.<init>(r4, r2)
            r0.add(r3)
            goto L1e
        L3f:
            r1 = 0
            r5.<init>(r6, r7, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.e.<init>(byte[], java.util.Map):void");
    }

    public e(int i10) {
        this.f2876p = new long[i10];
        this.f2877q = new boolean[i10];
        this.f2878r = new int[i10];
    }

    public e(o5.c cVar, o5.b bVar) {
        this.f2878r = cVar;
        this.f2876p = bVar;
        this.f2877q = bVar.f9525e ? null : new boolean[cVar.f9533u];
    }

    public e(Context context, r rVar, Boolean bool) {
        Spatializer spatializer;
        int immersiveAudioLevel;
        AudioManager k10 = context == null ? null : j1.c.k(context);
        if (k10 != null && (bool == null || !bool.booleanValue())) {
            spatializer = k10.getSpatializer();
            this.f2876p = spatializer;
            immersiveAudioLevel = spatializer.getImmersiveAudioLevel();
            this.f2875o = immersiveAudioLevel != 0;
            f2.m mVar = new f2.m(rVar);
            this.f2878r = mVar;
            Looper myLooper = Looper.myLooper();
            l1.d.h(myLooper);
            Handler handler = new Handler(myLooper);
            this.f2877q = handler;
            spatializer.addOnSpatializerStateChangedListener(new u1.x(handler, 0), mVar);
            return;
        }
        this.f2876p = null;
        this.f2875o = false;
        this.f2877q = null;
        this.f2878r = null;
    }
}
