package x4;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.EditText;
import androidx.work.impl.WorkDatabase;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import j9.j0;
import j9.k0;
import j9.r0;
import j9.t0;
import j9.u0;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.WeakHashMap;
import l1.a0;
import l1.t;
import l1.y;
import org.chromium.net.UrlRequest;
import r3.x;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements v6.b, g2.o, j7.a, t0, k2.i {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13541o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13542p;

    /* renamed from: q, reason: collision with root package name */
    public Object f13543q;

    public /* synthetic */ e(int i10, boolean z10) {
        this.f13541o = i10;
    }

    @Override // g2.o
    public x1.p a(Uri uri, o1.j jVar) {
        x1.p a10 = ((g2.o) this.f13542p).a(uri, jVar);
        List list = (List) this.f13543q;
        return (list == null || list.isEmpty()) ? a10 : (x1.p) a10.a(list);
    }

    @Override // k2.i
    public k2.h b(k2.o oVar, long j10) {
        long position = oVar.getPosition();
        int min = (int) Math.min(20000L, oVar.c() - position);
        t tVar = (t) this.f13543q;
        tVar.F(min);
        oVar.o(tVar.f8129a, 0, min);
        int i10 = -1;
        int i11 = -1;
        long j11 = -9223372036854775807L;
        while (tVar.a() >= 4) {
            if (p2.a.a(tVar.f8130b, tVar.f8129a) != 442) {
                tVar.J(1);
            } else {
                tVar.J(4);
                long c10 = x.c(tVar);
                if (c10 != -9223372036854775807L) {
                    long b2 = ((y) this.f13542p).b(c10);
                    if (b2 > j10) {
                        return j11 == -9223372036854775807L ? new k2.h(-1, b2, position) : new k2.h(0, -9223372036854775807L, position + i11);
                    }
                    if (b2 + 100000 > j10) {
                        return new k2.h(0, -9223372036854775807L, position + tVar.f8130b);
                    }
                    j11 = b2;
                    i11 = tVar.f8130b;
                }
                int i12 = tVar.f8131c;
                if (tVar.a() >= 10) {
                    tVar.J(9);
                    int w10 = tVar.w() & 7;
                    if (tVar.a() >= w10) {
                        tVar.J(w10);
                        if (tVar.a() >= 4) {
                            if (p2.a.a(tVar.f8130b, tVar.f8129a) == 443) {
                                tVar.J(4);
                                int C = tVar.C();
                                if (tVar.a() < C) {
                                    tVar.I(i12);
                                } else {
                                    tVar.J(C);
                                }
                            }
                            while (true) {
                                if (tVar.a() < 4) {
                                    break;
                                }
                                int a10 = p2.a.a(tVar.f8130b, tVar.f8129a);
                                if (a10 == 442 || a10 == 441 || (a10 >>> 8) != 1) {
                                    break;
                                }
                                tVar.J(4);
                                if (tVar.a() < 2) {
                                    tVar.I(i12);
                                    break;
                                }
                                tVar.I(Math.min(tVar.f8131c, tVar.f8130b + tVar.C()));
                            }
                        } else {
                            tVar.I(i12);
                        }
                    } else {
                        tVar.I(i12);
                    }
                } else {
                    tVar.I(i12);
                }
                i10 = tVar.f8130b;
            }
        }
        return j11 != -9223372036854775807L ? new k2.h(-2, j11, position + i10) : k2.h.f7730d;
    }

    @Override // j9.t0
    public Object c() {
        u0 u0Var = (u0) this.f13542p;
        Bundle bundle = (Bundle) this.f13543q;
        int i10 = bundle.getInt("session_id");
        if (i10 == 0) {
            return Boolean.TRUE;
        }
        HashMap hashMap = u0Var.f7460c;
        Integer valueOf = Integer.valueOf(i10);
        if (!hashMap.containsKey(valueOf)) {
            return Boolean.TRUE;
        }
        if (((r0) u0Var.f7460c.get(valueOf)).f7426c.f7419d == 6) {
            return Boolean.FALSE;
        }
        ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
        if (stringArrayList == null || stringArrayList.isEmpty()) {
            throw new j0("Session without pack received.");
        }
        return Boolean.valueOf(!k0.f(r0.f7426c.f7419d, bundle.getInt(com.bumptech.glide.e.a("status", stringArrayList.get(0)))));
    }

    @Override // j7.a
    public void d(Bitmap bitmap) {
        l lVar = (l) this.f13542p;
        lVar.f13562p = bitmap;
        j7.g gVar = (j7.g) this.f13543q;
        gVar.f7147l = lVar;
        gVar.b();
    }

    @Override // k2.i
    public void e() {
        t tVar = (t) this.f13543q;
        byte[] bArr = a0.f8069c;
        tVar.getClass();
        tVar.G(bArr.length, bArr);
    }

    public void f() {
        this.f13542p = null;
        this.f13543q = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.datatransport.cct.CctBackendFactory g(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.e.g(java.lang.String):com.google.android.datatransport.cct.CctBackendFactory");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [u6.a] */
    @Override // ka.a
    public Object get() {
        int i10 = 9;
        n7.i iVar = new n7.i(i10);
        d9.f fVar = new d9.f(i10);
        Object obj = ((a7.e) this.f13542p).get();
        v6.b bVar = (a7.e) this.f13543q;
        return new a7.l(iVar, fVar, a7.a.f108f, (a7.n) obj, bVar instanceof u6.a ? (u6.a) bVar : new v6.a(bVar));
    }

    public Long h(String str) {
        WorkDatabase workDatabase = (WorkDatabase) this.f13542p;
        c4.m a10 = c4.m.a(1, "SELECT long_value FROM Preference where `key`=?");
        a10.j(1, str);
        workDatabase.b();
        Cursor m10 = workDatabase.m(a10);
        try {
            Long l10 = null;
            if (m10.moveToFirst() && !m10.isNull(0)) {
                l10 = Long.valueOf(m10.getLong(0));
            }
            return l10;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public synchronized List i(String str) {
        List list;
        try {
            if (!((ArrayList) this.f13542p).contains(str)) {
                ((ArrayList) this.f13542p).add(str);
            }
            list = (List) ((HashMap) this.f13543q).get(str);
            if (list == null) {
                list = new ArrayList();
                ((HashMap) this.f13543q).put(str, list);
            }
        } catch (Throwable th) {
            throw th;
        }
        return list;
    }

    public synchronized ArrayList j(Class cls, Class cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        ArrayList arrayList2 = (ArrayList) this.f13542p;
        int size = arrayList2.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList2.get(i10);
            i10++;
            List<h6.c> list = (List) ((HashMap) this.f13543q).get((String) obj);
            if (list != null) {
                for (h6.c cVar : list) {
                    if ((cVar.f5688a.isAssignableFrom(cls) && cls2.isAssignableFrom(cVar.f5689b)) && !arrayList.contains(cVar.f5689b)) {
                        arrayList.add(cVar.f5689b);
                    }
                }
            }
        }
        return arrayList;
    }

    public void k(d dVar) {
        WorkDatabase workDatabase = (WorkDatabase) this.f13542p;
        workDatabase.b();
        workDatabase.c();
        try {
            ((b) this.f13543q).f(dVar);
            workDatabase.o();
        } finally {
            workDatabase.k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0205, code lost:
    
        continue;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0105 A[Catch: IOException -> 0x008d, XmlPullParserException -> 0x0090, TryCatch #2 {IOException -> 0x008d, XmlPullParserException -> 0x0090, blocks: (B:18:0x005e, B:27:0x0205, B:28:0x0070, B:29:0x007e, B:32:0x0083, B:40:0x0093, B:43:0x00ad, B:46:0x009c, B:50:0x00a5, B:53:0x00bb, B:56:0x00ca, B:58:0x00d2, B:61:0x00dc, B:65:0x0105, B:68:0x010c, B:69:0x0124, B:71:0x00e5, B:73:0x00ed, B:76:0x00fb, B:79:0x0125, B:81:0x012d, B:84:0x013b, B:87:0x0145, B:90:0x0150, B:91:0x0168, B:93:0x0169, B:96:0x0173, B:99:0x017e, B:100:0x0196, B:102:0x0197, B:104:0x019f, B:107:0x01a8, B:110:0x01b2, B:113:0x01bc, B:114:0x01d4, B:116:0x01d5, B:119:0x01df, B:122:0x01e9, B:123:0x0201, B:126:0x0202), top: B:17:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x010c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void l(android.content.Context r10, android.content.res.XmlResourceParser r11) {
        /*
            Method dump skipped, instructions count: 604
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.e.l(android.content.Context, android.content.res.XmlResourceParser):void");
    }

    public void m(boolean z10, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        Map map = (Map) this.f13542p;
        synchronized (map) {
            hashMap = new HashMap(map);
        }
        Map map2 = (Map) this.f13543q;
        synchronized (map2) {
            hashMap2 = new HashMap(map2);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z10 || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).O(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z10 || ((Boolean) entry2.getValue()).booleanValue()) {
                ((i8.d) entry2.getKey()).c(new o7.d(status));
            }
        }
    }

    public String toString() {
        switch (this.f13541o) {
            case 11:
                return "Bounds{lower=" + ((e0.c) this.f13542p) + " upper=" + ((e0.c) this.f13543q) + "}";
            default:
                return super.toString();
        }
    }

    public e(Context context, int i10) {
        this.f13541o = i10;
        switch (i10) {
            case 17:
                this.f13543q = null;
                this.f13542p = context;
                break;
            default:
                this.f13542p = context;
                break;
        }
    }

    public /* synthetic */ e(Object obj, int i10, Object obj2) {
        this.f13541o = i10;
        this.f13542p = obj;
        this.f13543q = obj2;
    }

    public /* synthetic */ e(Object obj, Object obj2, int i10, boolean z10) {
        this.f13541o = i10;
        this.f13543q = obj;
        this.f13542p = obj2;
    }

    public e(int i10) {
        this.f13541o = i10;
        switch (i10) {
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                this.f13542p = Collections.synchronizedMap(new WeakHashMap());
                this.f13543q = Collections.synchronizedMap(new WeakHashMap());
                break;
            default:
                this.f13542p = new ArrayList();
                this.f13543q = new HashMap();
                break;
        }
    }

    public e(WorkDatabase workDatabase) {
        this.f13541o = 0;
        this.f13542p = workDatabase;
        this.f13543q = new b(workDatabase);
    }

    public e(Locale locale) {
        this.f13541o = 4;
        this.f13542p = locale;
        this.f13543q = DateFormatSymbols.getInstance(locale).getShortMonths();
        Calendar calendar = Calendar.getInstance(locale);
        int minimum = calendar.getMinimum(5);
        int maximum = calendar.getMaximum(5);
        String[] strArr = new String[(maximum - minimum) + 1];
        for (int i10 = minimum; i10 <= maximum; i10++) {
            strArr[i10 - minimum] = String.format("%02d", Integer.valueOf(i10));
        }
    }

    public e(y yVar) {
        this.f13541o = 15;
        this.f13542p = yVar;
        this.f13543q = new t();
    }

    public e(EditText editText) {
        this.f13541o = 18;
        this.f13542p = editText;
        v0.h hVar = new v0.h(editText);
        this.f13543q = hVar;
        editText.addTextChangedListener(hVar);
        if (v0.a.f12632b == null) {
            synchronized (v0.a.f12631a) {
                try {
                    if (v0.a.f12632b == null) {
                        v0.a aVar = new v0.a();
                        try {
                            v0.a.f12633c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, v0.a.class.getClassLoader());
                        } catch (Throwable unused) {
                        }
                        v0.a.f12632b = aVar;
                    }
                } finally {
                }
            }
        }
        editText.setEditableFactory(v0.a.f12632b);
    }
}
