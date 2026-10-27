package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.activity.n;
import androidx.fragment.app.e0;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import androidx.lifecycle.t;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f341a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f342b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f343c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f344d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final transient HashMap f345e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f346f = new HashMap();
    public final Bundle g = new Bundle();

    public final boolean a(int i10, int i11, Intent intent) {
        String str = (String) this.f341a.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        e eVar = (e) this.f345e.get(str);
        if (eVar != null) {
            b bVar = eVar.f337a;
            if (this.f344d.contains(str)) {
                bVar.c(eVar.f338b.v(intent, i11));
                this.f344d.remove(str);
                return true;
            }
        }
        this.f346f.remove(str);
        this.g.putParcelable(str, new a(intent, i11));
        return true;
    }

    public abstract void b(int i10, com.bumptech.glide.f fVar, Object obj);

    public final c c(final String str, n nVar, final e0 e0Var, final b bVar) {
        t tVar = nVar.f310r;
        if (tVar.f1158c.compareTo(m.f1147r) >= 0) {
            throw new IllegalStateException("LifecycleOwner " + nVar + " is attempting to register while current state is " + tVar.f1158c + ". LifecycleOwners must call register before they are STARTED.");
        }
        e(str);
        HashMap hashMap = this.f343c;
        f fVar = (f) hashMap.get(str);
        if (fVar == null) {
            fVar = new f(tVar);
        }
        p pVar = new p() { // from class: androidx.activity.result.ActivityResultRegistry$1
            @Override // androidx.lifecycle.p
            public final void a(r rVar, l lVar) {
                boolean equals = l.ON_START.equals(lVar);
                String str2 = str;
                g gVar = g.this;
                if (!equals) {
                    if (l.ON_STOP.equals(lVar)) {
                        gVar.f345e.remove(str2);
                        return;
                    } else {
                        if (l.ON_DESTROY.equals(lVar)) {
                            gVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                HashMap hashMap2 = gVar.f345e;
                Bundle bundle = gVar.g;
                HashMap hashMap3 = gVar.f346f;
                b bVar2 = bVar;
                hashMap2.put(str2, new e(bVar2, e0Var));
                if (hashMap3.containsKey(str2)) {
                    Object obj = hashMap3.get(str2);
                    hashMap3.remove(str2);
                    bVar2.c(obj);
                }
                a aVar = (a) bundle.getParcelable(str2);
                if (aVar != null) {
                    bundle.remove(str2);
                    bVar2.c(new a(aVar.f331p, aVar.f330o));
                }
            }
        };
        fVar.f339a.a(pVar);
        fVar.f340b.add(pVar);
        hashMap.put(str, fVar);
        return new c(this, str, e0Var);
    }

    public final d d(String str, com.bumptech.glide.f fVar, b bVar) {
        e(str);
        this.f345e.put(str, new e(bVar, fVar));
        HashMap hashMap = this.f346f;
        if (hashMap.containsKey(str)) {
            Object obj = hashMap.get(str);
            hashMap.remove(str);
            bVar.c(obj);
        }
        Bundle bundle = this.g;
        a aVar = (a) bundle.getParcelable(str);
        if (aVar != null) {
            bundle.remove(str);
            bVar.c(fVar.v(aVar.f331p, aVar.f330o));
        }
        return new d(this, str, fVar);
    }

    public final void e(String str) {
        HashMap hashMap = this.f342b;
        if (((Integer) hashMap.get(str)) != null) {
            return;
        }
        bb.a aVar = bb.e.f2490o;
        int nextInt = bb.e.f2490o.a().nextInt(2147418112);
        while (true) {
            int i10 = nextInt + 65536;
            Integer valueOf = Integer.valueOf(i10);
            HashMap hashMap2 = this.f341a;
            if (!hashMap2.containsKey(valueOf)) {
                hashMap2.put(Integer.valueOf(i10), str);
                hashMap.put(str, Integer.valueOf(i10));
                return;
            } else {
                bb.a aVar2 = bb.e.f2490o;
                nextInt = bb.e.f2490o.a().nextInt(2147418112);
            }
        }
    }

    public final void f(String str) {
        Integer num;
        if (!this.f344d.contains(str) && (num = (Integer) this.f342b.remove(str)) != null) {
            this.f341a.remove(num);
        }
        this.f345e.remove(str);
        HashMap hashMap = this.f346f;
        if (hashMap.containsKey(str)) {
            StringBuilder s10 = android.support.v4.media.d.s("Dropping pending result for request ", str, ": ");
            s10.append(hashMap.get(str));
            Log.w("ActivityResultRegistry", s10.toString());
            hashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            StringBuilder s11 = android.support.v4.media.d.s("Dropping pending result for request ", str, ": ");
            s11.append(bundle.getParcelable(str));
            Log.w("ActivityResultRegistry", s11.toString());
            bundle.remove(str);
        }
        HashMap hashMap2 = this.f343c;
        f fVar = (f) hashMap2.get(str);
        if (fVar != null) {
            ArrayList arrayList = fVar.f340b;
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj = arrayList.get(i10);
                i10++;
                fVar.f339a.f((p) obj);
            }
            arrayList.clear();
            hashMap2.remove(str);
        }
    }
}
