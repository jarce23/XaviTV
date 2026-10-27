package p1;

import a6.d0;
import android.database.SQLException;
import android.os.ConditionVariable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import j9.g1;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;
import l1.a0;
import o9.j0;
import o9.k1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s implements b {

    /* renamed from: i, reason: collision with root package name */
    public static final HashSet f9865i = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    public final File f9866a;

    /* renamed from: b, reason: collision with root package name */
    public final p f9867b;

    /* renamed from: c, reason: collision with root package name */
    public final g1 f9868c;

    /* renamed from: d, reason: collision with root package name */
    public final g f9869d;

    /* renamed from: e, reason: collision with root package name */
    public final HashMap f9870e;

    /* renamed from: f, reason: collision with root package name */
    public final Random f9871f;
    public long g;

    /* renamed from: h, reason: collision with root package name */
    public a f9872h;

    public s(File file, p pVar, n1.a aVar) {
        boolean add;
        g1 g1Var = new g1();
        g1Var.f7290o = new HashMap();
        g1Var.f7291p = new SparseArray();
        g1Var.f7292q = new SparseBooleanArray();
        g1Var.f7293r = new SparseBooleanArray();
        l lVar = aVar != null ? new l(aVar) : null;
        i8.i iVar = new i8.i(new File(file, "cached_content_index.exi"));
        if (lVar != null) {
            g1Var.f7294s = lVar;
            g1Var.f7295t = iVar;
        } else {
            int i10 = a0.f8067a;
            g1Var.f7294s = iVar;
            g1Var.f7295t = lVar;
        }
        g gVar = aVar != null ? new g(aVar) : null;
        synchronized (s.class) {
            add = f9865i.add(file.getAbsoluteFile());
        }
        if (!add) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f9866a = file;
        this.f9867b = pVar;
        this.f9868c = g1Var;
        this.f9869d = gVar;
        this.f9870e = new HashMap();
        this.f9871f = new Random();
        this.g = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new r(this, conditionVariable).start();
        conditionVariable.block();
    }

    public static void a(s sVar) {
        long j10;
        g gVar = sVar.f9869d;
        g1 g1Var = sVar.f9868c;
        File file = sVar.f9866a;
        if (!file.exists()) {
            try {
                e(file);
            } catch (a e7) {
                sVar.f9872h = e7;
                return;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + file;
            l1.b.g("SimpleCache", str);
            sVar.f9872h = new a(str);
            return;
        }
        int length = listFiles.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                j10 = -1;
                break;
            }
            File file2 = listFiles[i10];
            String name = file2.getName();
            if (name.endsWith(".uid")) {
                try {
                    j10 = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    l1.b.g("SimpleCache", "Malformed UID file: " + file2);
                    file2.delete();
                }
            }
            i10++;
        }
        sVar.g = j10;
        if (j10 == -1) {
            try {
                sVar.g = f(file);
            } catch (IOException e8) {
                String str2 = "Failed to create cache UID: " + file;
                l1.b.h("SimpleCache", str2, e8);
                sVar.f9872h = new a(str2, e8);
                return;
            }
        }
        try {
            g1Var.n(sVar.g);
            if (gVar != null) {
                gVar.c(sVar.g);
                HashMap b2 = gVar.b();
                sVar.i(file, true, listFiles, b2);
                gVar.d(b2.keySet());
            } else {
                sVar.i(file, true, listFiles, null);
            }
            k1 it = j0.n(((HashMap) g1Var.f7290o).keySet()).iterator();
            while (it.hasNext()) {
                g1Var.p((String) it.next());
            }
            try {
                g1Var.r();
            } catch (IOException e10) {
                l1.b.h("SimpleCache", "Storing index file failed", e10);
            }
        } catch (IOException e11) {
            String str3 = "Failed to initialize cache indices: " + file;
            l1.b.h("SimpleCache", str3, e11);
            sVar.f9872h = new a(str3, e11);
        }
    }

    public static void e(File file) {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        l1.b.g("SimpleCache", str);
        throw new a(str);
    }

    public static long f(File file) {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        File file2 = new File(file, r.a.c(Long.toString(abs, 16), ".uid"));
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public final void b(t tVar) {
        String str = tVar.f9841o;
        this.f9868c.k(str).f9851c.add(tVar);
        ArrayList arrayList = (ArrayList) this.f9870e.get(str);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((p) arrayList.get(size)).getClass();
            }
        }
        this.f9867b.getClass();
    }

    public final synchronized void c(String str, g gVar) {
        d();
        g1 g1Var = this.f9868c;
        k k10 = g1Var.k(str);
        o oVar = k10.f9853e;
        o a10 = oVar.a(gVar);
        k10.f9853e = a10;
        if (!a10.equals(oVar)) {
            ((m) g1Var.f7294s).a(k10);
        }
        try {
            this.f9868c.r();
        } catch (IOException e7) {
            throw new a(e7);
        }
    }

    public final synchronized void d() {
        a aVar = this.f9872h;
        if (aVar != null) {
            throw aVar;
        }
    }

    public final synchronized o g(String str) {
        k j10;
        j10 = this.f9868c.j(str);
        return j10 != null ? j10.f9853e : o.f9859c;
    }

    public final t h(long j10, long j11, String str) {
        t tVar;
        long j12;
        k j13 = this.f9868c.j(str);
        if (j13 == null) {
            return new t(str, j10, j11, -9223372036854775807L, null);
        }
        while (true) {
            t tVar2 = new t(j13.f9850b, j10, -1L, -9223372036854775807L, null);
            TreeSet treeSet = j13.f9851c;
            tVar = (t) treeSet.floor(tVar2);
            if (tVar == null || tVar.f9842p + tVar.f9843q <= j10) {
                t tVar3 = (t) treeSet.ceiling(tVar2);
                if (tVar3 != null) {
                    long j14 = tVar3.f9842p - j10;
                    if (j11 != -1) {
                        j14 = Math.min(j14, j11);
                    }
                    j12 = j14;
                } else {
                    j12 = j11;
                }
                tVar = new t(j13.f9850b, j10, j12, -9223372036854775807L, null);
            }
            if (!tVar.f9844r) {
                break;
            }
            File file = tVar.f9845s;
            file.getClass();
            if (file.length() == tVar.f9843q) {
                break;
            }
            k();
        }
        return tVar;
    }

    public final void i(File file, boolean z10, File[] fileArr, Map map) {
        long j10;
        long j11;
        if (fileArr == null || fileArr.length == 0) {
            if (z10) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z10 && name.indexOf(46) == -1) {
                i(file2, false, file2.listFiles(), map);
            } else if (!z10 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                f fVar = map != null ? (f) map.remove(name) : null;
                if (fVar != null) {
                    j10 = fVar.f9835a;
                    j11 = fVar.f9836b;
                } else {
                    j10 = -1;
                    j11 = -9223372036854775807L;
                }
                t a10 = t.a(file2, j10, j11, this.f9868c);
                if (a10 != null) {
                    b(a10);
                } else {
                    file2.delete();
                }
            }
        }
    }

    public final synchronized void j(t tVar) {
        k j10 = this.f9868c.j(tVar.f9841o);
        j10.getClass();
        long j11 = tVar.f9842p;
        ArrayList arrayList = j10.f9852d;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (((j) arrayList.get(i10)).f9847a == j11) {
                arrayList.remove(i10);
                this.f9868c.p(j10.f9850b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    public final void k() {
        ArrayList arrayList = new ArrayList();
        g1 g1Var = this.f9868c;
        Iterator it = Collections.unmodifiableCollection(((HashMap) g1Var.f7290o).values()).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((k) it.next()).f9851c.iterator();
            while (it2.hasNext()) {
                i iVar = (i) it2.next();
                File file = iVar.f9845s;
                file.getClass();
                if (file.length() != iVar.f9843q) {
                    arrayList.add(iVar);
                }
            }
        }
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            i iVar2 = (i) arrayList.get(i10);
            String str = iVar2.f9841o;
            File file2 = iVar2.f9845s;
            k j10 = g1Var.j(str);
            if (j10 != null && j10.f9851c.remove(iVar2)) {
                if (file2 != null) {
                    file2.delete();
                }
                g gVar = this.f9869d;
                if (gVar != null) {
                    file2.getClass();
                    String name = file2.getName();
                    try {
                        ((String) gVar.f9839b).getClass();
                        try {
                            ((n1.a) gVar.f9838a).getWritableDatabase().delete((String) gVar.f9839b, "name = ?", new String[]{name});
                        } catch (SQLException e7) {
                            throw new d0(e7);
                        }
                    } catch (IOException unused) {
                        android.support.v4.media.d.z("Failed to remove file index entry for: ", name, "SimpleCache");
                    }
                }
                g1Var.p(j10.f9850b);
                ArrayList arrayList2 = (ArrayList) this.f9870e.get(iVar2.f9841o);
                if (arrayList2 != null) {
                    for (int size = arrayList2.size() - 1; size >= 0; size--) {
                        ((p) arrayList2.get(size)).getClass();
                    }
                }
                this.f9867b.getClass();
            }
        }
    }

    public final synchronized t l(long j10, long j11, String str) {
        int i10;
        d();
        t h10 = h(j10, j11, str);
        if (h10.f9844r) {
            return h10;
        }
        k k10 = this.f9868c.k(str);
        long j12 = h10.f9843q;
        ArrayList arrayList = k10.f9852d;
        while (i10 < arrayList.size()) {
            j jVar = (j) arrayList.get(i10);
            long j13 = jVar.f9847a;
            if (j13 <= j10) {
                long j14 = jVar.f9848b;
                i10 = (j14 != -1 && j13 + j14 <= j10) ? i10 + 1 : 0;
                return null;
            }
            if (j12 != -1 && j10 + j12 <= j13) {
            }
            return null;
        }
        arrayList.add(new j(j10, j12));
        return h10;
    }
}
