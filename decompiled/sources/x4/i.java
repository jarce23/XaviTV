package x4;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.media.session.a0;
import android.util.Log;
import android.util.SparseArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import androidx.emoji2.text.w;
import androidx.fragment.app.i0;
import androidx.fragment.app.l0;
import androidx.fragment.app.p0;
import androidx.leanback.widget.x0;
import androidx.work.impl.WorkDatabase_Impl;
import c2.n1;
import ib.h0;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.z;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import l1.t;
import o9.e0;
import o9.g0;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import rb.q0;
import rb.r0;
import rb.s0;
import t5.s;
import t5.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i implements h3.k, r0, v6.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13552o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13553p;

    /* renamed from: q, reason: collision with root package name */
    public Object f13554q;

    /* renamed from: r, reason: collision with root package name */
    public Object f13555r;

    /* renamed from: s, reason: collision with root package name */
    public Object f13556s;

    public /* synthetic */ i(int i10, boolean z10) {
        this.f13552o = i10;
    }

    public synchronized void a(r5.e eVar, s sVar) {
        t5.a aVar = (t5.a) ((HashMap) this.f13554q).put(eVar, new t5.a(eVar, sVar, (ReferenceQueue) this.f13555r));
        if (aVar != null) {
            aVar.f11887c = null;
            aVar.clear();
        }
    }

    @Override // h3.k
    public /* synthetic */ h3.e b(byte[] bArr, int i10, int i11) {
        int i12 = this.f13552o;
        return android.support.v4.media.d.a(this, bArr, i11);
    }

    public void c(androidx.fragment.app.s sVar) {
        if (((ArrayList) this.f13553p).contains(sVar)) {
            throw new IllegalStateException("Fragment already added: " + sVar);
        }
        synchronized (((ArrayList) this.f13553p)) {
            ((ArrayList) this.f13553p).add(sVar);
        }
        sVar.f816y = true;
    }

    @Override // rb.r0
    public void cancel() {
        ((Socket) this.f13553p).close();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:78:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0213  */
    @Override // h3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(byte[] r44, int r45, int r46, h3.j r47, l1.h r48) {
        /*
            Method dump skipped, instructions count: 1242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.i.d(byte[], int, int, h3.j, l1.h):void");
    }

    public void e(t5.a aVar) {
        y yVar;
        synchronized (this) {
            ((HashMap) this.f13554q).remove(aVar.f11885a);
            if (aVar.f11886b && (yVar = aVar.f11887c) != null) {
                ((t5.k) this.f13556s).f(aVar.f11885a, new s(yVar, true, false, aVar.f11885a, (t5.k) this.f13556s));
            }
        }
    }

    public void f(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((p.i) this.f13554q).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i10 = 0; i10 < size; i10++) {
                f(arrayList2.get(i10), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public void g(Runnable runnable) {
        ((f.o) this.f13553p).execute(runnable);
    }

    @Override // ka.a
    public Object get() {
        return new i((Executor) ((ka.a) this.f13553p).get(), (a7.d) ((ka.a) this.f13554q).get(), (a0) ((a0) this.f13555r).get(), (b7.c) ((ka.a) this.f13556s).get(), 19);
    }

    @Override // rb.r0
    public q0 getSink() {
        return (sb.g) this.f13556s;
    }

    @Override // rb.r0
    public s0 getSource() {
        return (sb.h) this.f13555r;
    }

    public androidx.fragment.app.s h(String str) {
        p0 p0Var = (p0) ((HashMap) this.f13554q).get(str);
        if (p0Var != null) {
            return p0Var.f772c;
        }
        return null;
    }

    public androidx.fragment.app.s i(String str) {
        for (p0 p0Var : ((HashMap) this.f13554q).values()) {
            if (p0Var != null) {
                androidx.fragment.app.s sVar = p0Var.f772c;
                if (!str.equals(sVar.f810s)) {
                    sVar = sVar.H.f691c.i(str);
                }
                if (sVar != null) {
                    return sVar;
                }
            }
        }
        return null;
    }

    public k.e j(k.a aVar) {
        ArrayList arrayList = (ArrayList) this.f13555r;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k.e eVar = (k.e) arrayList.get(i10);
            if (eVar != null && eVar.f7534b == aVar) {
                return eVar;
            }
        }
        k.e eVar2 = new k.e((Context) this.f13554q, aVar);
        arrayList.add(eVar2);
        return eVar2;
    }

    public ArrayList k() {
        ArrayList arrayList = new ArrayList();
        for (p0 p0Var : ((HashMap) this.f13554q).values()) {
            if (p0Var != null) {
                arrayList.add(p0Var);
            }
        }
        return arrayList;
    }

    public ArrayList l() {
        ArrayList arrayList = new ArrayList();
        for (p0 p0Var : ((HashMap) this.f13554q).values()) {
            if (p0Var != null) {
                arrayList.add(p0Var.f772c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public List m() {
        ArrayList arrayList;
        if (((ArrayList) this.f13553p).isEmpty()) {
            return Collections.EMPTY_LIST;
        }
        synchronized (((ArrayList) this.f13553p)) {
            arrayList = new ArrayList((ArrayList) this.f13553p);
        }
        return arrayList;
    }

    public g n(j jVar) {
        String str = jVar.f13557a;
        int i10 = jVar.f13558b;
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f13553p;
        c4.m a10 = c4.m.a(2, "SELECT * FROM SystemIdInfo WHERE work_spec_id=? AND generation=?");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        a10.A(2, i10);
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int e7 = y7.d.e(m10, "work_spec_id");
            int e8 = y7.d.e(m10, "generation");
            int e10 = y7.d.e(m10, "system_id");
            g gVar = null;
            String string = null;
            if (m10.moveToFirst()) {
                if (!m10.isNull(e7)) {
                    string = m10.getString(e7);
                }
                gVar = new g(string, m10.getInt(e8), m10.getInt(e10));
            }
            return gVar;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public void o(g gVar) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f13553p;
        workDatabase_Impl.b();
        workDatabase_Impl.c();
        try {
            ((b) this.f13554q).f(gVar);
            workDatabase_Impl.o();
        } finally {
            workDatabase_Impl.k();
        }
    }

    public void p(p0 p0Var) {
        androidx.fragment.app.s sVar = p0Var.f772c;
        String str = sVar.f810s;
        HashMap hashMap = (HashMap) this.f13554q;
        if (hashMap.get(str) != null) {
            return;
        }
        hashMap.put(sVar.f810s, p0Var);
        if (i0.F(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + sVar);
        }
    }

    public void q(p0 p0Var) {
        HashMap hashMap = (HashMap) this.f13554q;
        androidx.fragment.app.s sVar = p0Var.f772c;
        if (sVar.O) {
            ((l0) this.f13556s).d(sVar);
        }
        if (hashMap.get(sVar.f810s) == p0Var && ((p0) hashMap.put(sVar.f810s, null)) != null && i0.F(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + sVar);
        }
    }

    public synchronized boolean r(m5.i iVar) {
        try {
            String f10 = iVar.f();
            if (!((HashMap) this.f13553p).containsKey(f10)) {
                ((HashMap) this.f13553p).put(f10, null);
                iVar.n(this);
                if (m5.p.f9002a) {
                    m5.p.b("new request, sending to network %s", f10);
                }
                return false;
            }
            List list = (List) ((HashMap) this.f13553p).get(f10);
            if (list == null) {
                list = new ArrayList();
            }
            iVar.a("waiting-for-response");
            list.add(iVar);
            ((HashMap) this.f13553p).put(f10, list);
            if (m5.p.f9002a) {
                m5.p.b("Request for cacheKey=%s is in flight, putting on hold.", f10);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // h3.k
    public /* synthetic */ void reset() {
        int i10 = this.f13552o;
    }

    public boolean s(k.a aVar, MenuItem menuItem) {
        return ((ActionMode.Callback) this.f13553p).onActionItemClicked(j(aVar), new l.s((Context) this.f13554q, (g0.a) menuItem));
    }

    public boolean t(k.a aVar, Menu menu) {
        ActionMode.Callback callback = (ActionMode.Callback) this.f13553p;
        k.e j10 = j(aVar);
        p.i iVar = (p.i) this.f13556s;
        Menu menu2 = (Menu) iVar.get(menu);
        if (menu2 == null) {
            menu2 = new l.a0((Context) this.f13554q, (l.l) menu);
            iVar.put(menu, menu2);
        }
        return callback.onCreateActionMode(j10, menu2);
    }

    public String toString() {
        switch (this.f13552o) {
            case 4:
                return "horizontal=" + ((x0) this.f13554q) + "; vertical=" + ((x0) this.f13553p);
            case 6:
                StringBuilder sb2 = new StringBuilder("ColumnIndices[");
                boolean z10 = false;
                for (Map.Entry entry : ((ConcurrentHashMap) this.f13553p).entrySet()) {
                    if (z10) {
                        sb2.append(",");
                    }
                    sb2.append(((Class) entry.getKey()).getSimpleName());
                    sb2.append("->");
                    sb2.append(entry.getValue());
                    z10 = true;
                }
                sb2.append("]");
                return sb2.toString();
            case 7:
                StringBuilder sb3 = new StringBuilder("[Head]");
                if (((String) this.f13554q) != null) {
                    sb3.append("\nName: ");
                    sb3.append((String) this.f13554q);
                }
                if (((String) this.f13556s) != null) {
                    sb3.append("\nType: ");
                    sb3.append((String) this.f13556s);
                }
                if (((String) this.f13553p) != null) {
                    sb3.append("\nDLNA Extras: ");
                    sb3.append((String) this.f13553p);
                }
                if (((String) this.f13555r) != null) {
                    sb3.append("\nPlugin: ");
                    sb3.append((String) this.f13555r);
                }
                return sb3.toString();
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                String socket = ((Socket) this.f13553p).toString();
                za.h.d("toString(...)", socket);
                return socket;
            default:
                return super.toString();
        }
    }

    public synchronized void u(m5.i iVar) {
        BlockingQueue blockingQueue;
        try {
            String f10 = iVar.f();
            List list = (List) ((HashMap) this.f13553p).remove(f10);
            if (list != null && !list.isEmpty()) {
                if (m5.p.f9002a) {
                    m5.p.d("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), f10);
                }
                m5.i iVar2 = (m5.i) list.remove(0);
                ((HashMap) this.f13553p).put(f10, list);
                iVar2.n(this);
                if (((m5.c) this.f13555r) != null && (blockingQueue = (BlockingQueue) this.f13556s) != null) {
                    try {
                        blockingQueue.put(iVar2);
                    } catch (InterruptedException e7) {
                        m5.p.c("Couldn't add request to queue. %s", e7.toString());
                        Thread.currentThread().interrupt();
                        m5.c cVar = (m5.c) this.f13555r;
                        cVar.f8962s = true;
                        cVar.interrupt();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void v(m5.i iVar, c4.e eVar) {
        List list;
        m5.b bVar = (m5.b) eVar.f2877q;
        if (bVar == null || bVar.f8954e < System.currentTimeMillis()) {
            u(iVar);
            return;
        }
        String f10 = iVar.f();
        synchronized (this) {
            list = (List) ((HashMap) this.f13553p).remove(f10);
        }
        if (list != null) {
            if (m5.p.f9002a) {
                m5.p.d("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), f10);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((h5.i) this.f13554q).H((m5.i) it.next(), eVar, null);
            }
        }
    }

    public Bundle y(String str, Bundle bundle) {
        HashMap hashMap = (HashMap) this.f13555r;
        return bundle != null ? (Bundle) hashMap.put(str, bundle) : (Bundle) hashMap.remove(str);
    }

    public /* synthetic */ i(Object obj, Object obj2, Object obj3, Object obj4, int i10) {
        this.f13552o = i10;
        this.f13553p = obj;
        this.f13554q = obj2;
        this.f13555r = obj3;
        this.f13556s = obj4;
    }

    public i(WorkDatabase_Impl workDatabase_Impl) {
        this.f13552o = 0;
        this.f13553p = workDatabase_Impl;
        this.f13554q = new b(workDatabase_Impl, 2);
        this.f13555r = new h(workDatabase_Impl, 0);
        this.f13556s = new h(workDatabase_Impl, 1);
    }

    public i(int i10) {
        this.f13552o = i10;
        switch (i10) {
            case 4:
                x0 x0Var = new x0();
                this.f13553p = x0Var;
                x0 x0Var2 = new x0();
                this.f13554q = x0Var2;
                this.f13555r = x0Var2;
                this.f13556s = x0Var;
                break;
            case 9:
                this.f13553p = new t();
                this.f13554q = new t();
                this.f13555r = new k3.a();
                break;
            case 10:
                this.f13553p = new p.e(0);
                this.f13554q = new SparseArray();
                this.f13555r = new p.g();
                this.f13556s = new p.e(0);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new j0.l(3));
                this.f13554q = new HashMap();
                this.f13555r = new ReferenceQueue();
                this.f13553p = newSingleThreadExecutor;
                newSingleThreadExecutor.execute(new p0.b(6, this));
                break;
            case 18:
                this.f13553p = new l0.d(10);
                this.f13554q = new p.i(0);
                this.f13555r = new ArrayList();
                this.f13556s = new HashSet();
                break;
            default:
                this.f13553p = new ArrayList();
                this.f13554q = new HashMap();
                this.f13555r = new HashMap();
                break;
        }
    }

    private final /* synthetic */ void w() {
    }

    private final /* synthetic */ void x() {
    }

    public i(Context context, i iVar) {
        Object jVar;
        this.f13552o = 16;
        Context applicationContext = context.getApplicationContext();
        za.h.d("context.applicationContext", applicationContext);
        v4.a aVar = new v4.a(applicationContext, iVar, 0);
        Context applicationContext2 = context.getApplicationContext();
        za.h.d("context.applicationContext", applicationContext2);
        v4.a aVar2 = new v4.a(applicationContext2, iVar, 1);
        Context applicationContext3 = context.getApplicationContext();
        za.h.d("context.applicationContext", applicationContext3);
        String str = v4.i.f12674a;
        if (Build.VERSION.SDK_INT >= 24) {
            jVar = new v4.h(applicationContext3, iVar);
        } else {
            jVar = new v4.j(applicationContext3, iVar);
        }
        Context applicationContext4 = context.getApplicationContext();
        za.h.d("context.applicationContext", applicationContext4);
        v4.a aVar3 = new v4.a(applicationContext4, iVar, 2);
        this.f13553p = aVar;
        this.f13554q = aVar2;
        this.f13555r = jVar;
        this.f13556s = aVar3;
    }

    public i(Socket socket) {
        this.f13552o = 14;
        this.f13553p = socket;
        this.f13554q = new AtomicInteger();
        this.f13555r = new sb.h(this);
        this.f13556s = new sb.g(this);
    }

    public i(ExecutorService executorService) {
        this.f13552o = 1;
        this.f13555r = new Handler(Looper.getMainLooper());
        this.f13556s = new a5.a(0, this);
        f.o oVar = new f.o(executorService);
        this.f13553p = oVar;
        this.f13554q = new h0(oVar);
    }

    public i(List list) {
        int i10;
        this.f13552o = 13;
        this.f13553p = new t();
        this.f13554q = new t();
        p3.a aVar = new p3.a();
        this.f13555r = aVar;
        String trim = new String((byte[]) list.get(0), StandardCharsets.UTF_8).trim();
        int i11 = l1.a0.f8067a;
        for (String str : trim.split("\\r?\\n", -1)) {
            if (str.startsWith("palette: ")) {
                String[] split = str.substring(9).split(",", -1);
                aVar.f9896d = new int[split.length];
                for (int i12 = 0; i12 < split.length; i12++) {
                    int[] iArr = aVar.f9896d;
                    try {
                        i10 = Integer.parseInt(split[i12].trim(), 16);
                    } catch (RuntimeException unused) {
                        i10 = 0;
                    }
                    iArr[i12] = i10;
                }
            } else if (str.startsWith("size: ")) {
                String[] split2 = str.substring(6).trim().split("x", -1);
                if (split2.length == 2) {
                    try {
                        aVar.f9897e = Integer.parseInt(split2[0]);
                        aVar.f9898f = Integer.parseInt(split2[1]);
                        aVar.f9894b = true;
                    } catch (RuntimeException e7) {
                        l1.b.r("VobsubParser", "Parsing IDX failed", e7);
                    }
                }
            }
        }
    }

    public i(z zVar, OsSchemaInfo osSchemaInfo) {
        this.f13552o = 6;
        this.f13553p = new ConcurrentHashMap();
        this.f13554q = new HashMap();
        this.f13555r = zVar;
        this.f13556s = osSchemaInfo;
    }

    public i(m5.c cVar, BlockingQueue blockingQueue, h5.i iVar) {
        this.f13552o = 12;
        this.f13553p = new HashMap();
        this.f13554q = iVar;
        this.f13555r = cVar;
        this.f13556s = blockingQueue;
    }

    public i(Typeface typeface, u0.b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        this.f13552o = 2;
        this.f13556s = typeface;
        this.f13553p = bVar;
        this.f13555r = new w(1024);
        int a10 = bVar.a(6);
        if (a10 != 0) {
            int i14 = a10 + bVar.f8745o;
            i10 = ((ByteBuffer) bVar.f8748r).getInt(((ByteBuffer) bVar.f8748r).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        this.f13554q = new char[i10 * 2];
        int a11 = bVar.a(6);
        if (a11 != 0) {
            int i15 = a11 + bVar.f8745o;
            i11 = ((ByteBuffer) bVar.f8748r).getInt(((ByteBuffer) bVar.f8748r).getInt(i15) + i15);
        } else {
            i11 = 0;
        }
        for (int i16 = 0; i16 < i11; i16++) {
            androidx.emoji2.text.z zVar = new androidx.emoji2.text.z(this, i16);
            u0.a b2 = zVar.b();
            int a12 = b2.a(4);
            Character.toChars(a12 != 0 ? ((ByteBuffer) b2.f8748r).getInt(a12 + b2.f8745o) : 0, (char[]) this.f13554q, i16 * 2);
            u0.a b10 = zVar.b();
            int a13 = b10.a(16);
            if (a13 != 0) {
                int i17 = a13 + b10.f8745o;
                i12 = ((ByteBuffer) b10.f8748r).getInt(((ByteBuffer) b10.f8748r).getInt(i17) + i17);
            } else {
                i12 = 0;
            }
            y7.d.a("invalid metadata codepoint length", i12 > 0);
            w wVar = (w) this.f13555r;
            u0.a b11 = zVar.b();
            int a14 = b11.a(16);
            if (a14 != 0) {
                int i18 = a14 + b11.f8745o;
                i13 = ((ByteBuffer) b11.f8748r).getInt(((ByteBuffer) b11.f8748r).getInt(i18) + i18);
            } else {
                i13 = 0;
            }
            wVar.a(zVar, 0, i13 - 1);
        }
    }

    public i(Context context, ActionMode.Callback callback) {
        this.f13552o = 8;
        this.f13554q = context;
        this.f13553p = callback;
        this.f13555r = new ArrayList();
        this.f13556s = new p.i(0);
    }

    public i(w0 w0Var, l lVar, r rVar, j5.g gVar) {
        Object obj;
        this.f13552o = 11;
        if (w0Var != null) {
            obj = g0.n(w0Var);
        } else {
            e0 e0Var = g0.f9617p;
            obj = w0.f9686s;
        }
        this.f13553p = obj;
        this.f13554q = lVar;
        this.f13555r = rVar;
        this.f13556s = gVar;
    }

    public i(n1 n1Var, boolean[] zArr) {
        this.f13552o = 5;
        this.f13553p = n1Var;
        this.f13554q = zArr;
        int i10 = n1Var.f2660a;
        this.f13555r = new boolean[i10];
        this.f13556s = new boolean[i10];
    }
}
