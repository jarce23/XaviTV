package c4;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements g4.e, g4.d {

    /* renamed from: w, reason: collision with root package name */
    public static final TreeMap f2911w = new TreeMap();

    /* renamed from: o, reason: collision with root package name */
    public final int f2912o;

    /* renamed from: p, reason: collision with root package name */
    public volatile String f2913p;

    /* renamed from: q, reason: collision with root package name */
    public final long[] f2914q;

    /* renamed from: r, reason: collision with root package name */
    public final double[] f2915r;

    /* renamed from: s, reason: collision with root package name */
    public final String[] f2916s;

    /* renamed from: t, reason: collision with root package name */
    public final byte[][] f2917t;

    /* renamed from: u, reason: collision with root package name */
    public final int[] f2918u;

    /* renamed from: v, reason: collision with root package name */
    public int f2919v;

    public m(int i10) {
        this.f2912o = i10;
        int i11 = i10 + 1;
        this.f2918u = new int[i11];
        this.f2914q = new long[i11];
        this.f2915r = new double[i11];
        this.f2916s = new String[i11];
        this.f2917t = new byte[i11][];
    }

    public static final m a(int i10, String str) {
        TreeMap treeMap = f2911w;
        synchronized (treeMap) {
            Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i10));
            if (ceilingEntry == null) {
                m mVar = new m(i10);
                mVar.f2913p = str;
                mVar.f2919v = i10;
                return mVar;
            }
            treeMap.remove(ceilingEntry.getKey());
            m mVar2 = (m) ceilingEntry.getValue();
            mVar2.f2913p = str;
            mVar2.f2919v = i10;
            return mVar2;
        }
    }

    @Override // g4.d
    public final void A(int i10, long j10) {
        this.f2918u[i10] = 2;
        this.f2914q[i10] = j10;
    }

    @Override // g4.d
    public final void C(int i10, byte[] bArr) {
        this.f2918u[i10] = 5;
        this.f2917t[i10] = bArr;
    }

    @Override // g4.e
    public final String c() {
        String str = this.f2913p;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // g4.d
    public final void j(int i10, String str) {
        za.h.e("value", str);
        this.f2918u[i10] = 4;
        this.f2916s[i10] = str;
    }

    @Override // g4.e
    public final void n(g4.d dVar) {
        int i10 = this.f2919v;
        if (1 > i10) {
            return;
        }
        int i11 = 1;
        while (true) {
            int i12 = this.f2918u[i11];
            if (i12 == 1) {
                dVar.o(i11);
            } else if (i12 == 2) {
                dVar.A(i11, this.f2914q[i11]);
            } else if (i12 == 3) {
                dVar.q(i11, this.f2915r[i11]);
            } else if (i12 == 4) {
                String str = this.f2916s[i11];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                dVar.j(i11, str);
            } else if (i12 == 5) {
                byte[] bArr = this.f2917t[i11];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                dVar.C(i11, bArr);
            }
            if (i11 == i10) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // g4.d
    public final void o(int i10) {
        this.f2918u[i10] = 1;
    }

    @Override // g4.d
    public final void q(int i10, double d6) {
        this.f2918u[i10] = 3;
        this.f2915r[i10] = d6;
    }

    public final void s() {
        TreeMap treeMap = f2911w;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f2912o), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                za.h.d("queryPool.descendingKeySet().iterator()", it);
                while (true) {
                    int i10 = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i10;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
