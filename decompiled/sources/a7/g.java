package a7;

import android.animation.Animator;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.fragment.app.u0;
import c2.j0;
import c2.k0;
import c2.z;
import i1.b1;
import i1.f0;
import i1.f1;
import i1.i0;
import i1.o0;
import io.realm.n0;
import j9.g1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.chromium.net.UrlRequest;
import t1.o;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements j, i0.a, l1.h, i5.c, l1.m, l1.n, b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f123o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f124p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f125q;

    public /* synthetic */ g(Object obj, int i10, Object obj2) {
        this.f123o = i10;
        this.f124p = obj;
        this.f125q = obj2;
    }

    @Override // l1.h
    public void accept(Object obj) {
        j0 j0Var = (j0) this.f124p;
        ((k0) obj).F(j0Var.f2621a, j0Var.f2622b, (z) this.f125q);
    }

    @Override // a7.j, n9.d
    public Object apply(Object obj) {
        l lVar = (l) this.f124p;
        s6.i iVar = (s6.i) this.f125q;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        lVar.getClass();
        ArrayList arrayList = new ArrayList();
        Long c10 = l.c(sQLiteDatabase, iVar);
        if (c10 != null) {
            l.M(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline"}, "context_id = ?", new String[]{c10.toString()}, null, null, null, String.valueOf(lVar.f137r.f110b)), new f(lVar, arrayList, iVar, 1));
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            sb2.append(((b) arrayList.get(i10)).f114a);
            if (i10 < arrayList.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb2.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j10 = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j10));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j10), set);
                }
                set.add(new k(query.getString(1), query.getString(2)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = arrayList.listIterator();
        while (listIterator.hasNext()) {
            b bVar = (b) listIterator.next();
            long j11 = bVar.f114a;
            if (hashMap.containsKey(Long.valueOf(j11))) {
                g1 c11 = bVar.f116c.c();
                for (k kVar : (Set) hashMap.get(Long.valueOf(j11))) {
                    c11.d(kVar.f131a, kVar.f132b);
                }
                listIterator.set(new b(j11, bVar.f115b, c11.g()));
            }
        }
        return arrayList;
    }

    @Override // l1.n
    public void b(Object obj, i1.n nVar) {
        o oVar = (o) this.f124p;
        o0 o0Var = (o0) this.f125q;
        t1.b bVar = (t1.b) obj;
        SparseArray sparseArray = oVar.f11826s;
        j5.g gVar = new j5.g();
        gVar.f7114o = nVar;
        SparseBooleanArray sparseBooleanArray = nVar.f5920a;
        SparseArray sparseArray2 = new SparseArray(sparseBooleanArray.size());
        for (int i10 = 0; i10 < sparseBooleanArray.size(); i10++) {
            int a10 = nVar.a(i10);
            t1.a aVar = (t1.a) sparseArray.get(a10);
            aVar.getClass();
            sparseArray2.append(a10, aVar);
        }
        gVar.f7115p = sparseArray2;
        bVar.J(o0Var, gVar);
    }

    @Override // i5.c
    public void c(Object obj) {
        e5.k kVar = (e5.k) this.f124p;
        List list = (List) obj;
        if (((n0) this.f125q).size() != list.size()) {
            kVar.U.P(new e5.c(1, list));
        }
        if (kVar.Y) {
            return;
        }
        kVar.H(list);
    }

    @Override // b7.b
    public Object execute() {
        switch (this.f123o) {
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                j9.n nVar = (j9.n) this.f124p;
                Iterable iterable = (Iterable) this.f125q;
                l lVar = (l) ((d) nVar.f7384r);
                lVar.getClass();
                if (iterable.iterator().hasNext()) {
                    lVar.a().compileStatement("DELETE FROM events WHERE _id in " + l.K(iterable)).execute();
                    break;
                }
                break;
            default:
                j9.n nVar2 = (j9.n) this.f124p;
                for (Map.Entry entry : ((HashMap) this.f125q).entrySet()) {
                    ((l) ((c) nVar2.f7383q)).s(((Integer) entry.getValue()).intValue(), w6.c.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f123o) {
            case 5:
                ((t1.b) obj).x((t1.a) this.f124p, (i1.j0) this.f125q);
                break;
            case 6:
            default:
                ((t1.b) obj).g((t1.a) this.f124p, this.f125q);
                break;
            case 7:
                ((t1.b) obj).r((t1.a) this.f124p, (f0) this.f125q);
                break;
            case 8:
                ((t1.b) obj).K((t1.a) this.f124p, (b1) this.f125q);
                break;
            case 9:
                ((t1.b) obj).d((t1.a) this.f124p, (i0) this.f125q);
                break;
            case 10:
                ((t1.b) obj).l((t1.a) this.f124p, (s1.e) this.f125q);
                break;
            case 11:
                t1.a aVar = (t1.a) this.f124p;
                f1 f1Var = (f1) this.f125q;
                ((t1.b) obj).s(aVar, f1Var);
                int i10 = f1Var.f5879a;
                break;
        }
    }

    @Override // i0.a
    public void onCancel() {
        Animator animator = (Animator) this.f124p;
        u0 u0Var = (u0) this.f125q;
        za.h.e("$operation", u0Var);
        animator.end();
        if (androidx.fragment.app.i0.F(2)) {
            Log.v("FragmentManager", "Animator from operation " + u0Var + " has been canceled.");
        }
    }

    public /* synthetic */ g(t1.a aVar, Object obj, long j10) {
        this.f123o = 12;
        this.f124p = aVar;
        this.f125q = obj;
    }
}
