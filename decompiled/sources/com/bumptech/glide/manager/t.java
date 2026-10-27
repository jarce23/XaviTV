package com.bumptech.glide.manager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.lifecycle.l;
import androidx.lifecycle.r;
import androidx.savedstate.Recreator;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static volatile t f3095e;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3096a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3097b;

    /* renamed from: c, reason: collision with root package name */
    public Object f3098c;

    /* renamed from: d, reason: collision with root package name */
    public Object f3099d;

    public t(int i10) {
        this.f3096a = i10;
        switch (i10) {
            case 4:
                this.f3098c = new Object();
                break;
            case 5:
                break;
            default:
                this.f3098c = Collections.newSetFromMap(new WeakHashMap());
                this.f3099d = new HashSet();
                break;
        }
    }

    public static t b(Context context) {
        if (f3095e == null) {
            synchronized (t.class) {
                try {
                    if (f3095e == null) {
                        f3095e = new t(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f3095e;
    }

    public boolean a(i6.c cVar) {
        boolean z10 = true;
        if (cVar == null) {
            return true;
        }
        boolean remove = ((Set) this.f3098c).remove(cVar);
        if (!((HashSet) this.f3099d).remove(cVar) && !remove) {
            z10 = false;
        }
        if (z10) {
            cVar.clear();
        }
        return z10;
    }

    public void c() {
        f4.e eVar = (f4.e) this.f3098c;
        androidx.lifecycle.t f10 = eVar.f();
        if (f10.f1158c != androidx.lifecycle.m.f1145p) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        f10.a(new Recreator(eVar));
        final f4.d dVar = (f4.d) this.f3099d;
        dVar.getClass();
        if (dVar.f5017a) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        f10.a(new androidx.lifecycle.p() { // from class: f4.a
            @Override // androidx.lifecycle.p
            public final void a(r rVar, l lVar) {
                d dVar2 = d.this;
                h.e("this$0", dVar2);
                if (lVar == l.ON_START) {
                    dVar2.f5019c = true;
                } else if (lVar == l.ON_STOP) {
                    dVar2.f5019c = false;
                }
            }
        });
        dVar.f5017a = true;
        this.f3097b = true;
    }

    public void d(Bundle bundle) {
        if (!this.f3097b) {
            c();
        }
        androidx.lifecycle.t f10 = ((f4.e) this.f3098c).f();
        if (f10.f1158c.compareTo(androidx.lifecycle.m.f1147r) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + f10.f1158c).toString());
        }
        f4.d dVar = (f4.d) this.f3099d;
        if (!dVar.f5017a) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (dVar.f5018b) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        dVar.f5021e = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        dVar.f5018b = true;
    }

    public void e(Bundle bundle) {
        f4.d dVar = (f4.d) this.f3099d;
        dVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) dVar.f5021e;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        o.f fVar = (o.f) dVar.f5020d;
        fVar.getClass();
        o.d dVar2 = new o.d(fVar);
        fVar.f9367q.put(dVar2, Boolean.FALSE);
        while (dVar2.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar2.next();
            bundle2.putBundle((String) entry.getKey(), ((f4.c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void f(i8.h hVar) {
        synchronized (this.f3098c) {
            try {
                if (((ArrayDeque) this.f3099d) == null) {
                    this.f3099d = new ArrayDeque();
                }
                ((ArrayDeque) this.f3099d).add(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void g(i8.i iVar) {
        i8.h hVar;
        synchronized (this.f3098c) {
            if (((ArrayDeque) this.f3099d) != null && !this.f3097b) {
                this.f3097b = true;
                while (true) {
                    synchronized (this.f3098c) {
                        try {
                            hVar = (i8.h) ((ArrayDeque) this.f3099d).poll();
                            if (hVar == null) {
                                this.f3097b = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    hVar.a(iVar);
                }
            }
        }
    }

    public String toString() {
        switch (this.f3096a) {
            case 2:
                return super.toString() + "{numRequests=" + ((Set) this.f3098c).size() + ", isPaused=" + this.f3097b + "}";
            default:
                return super.toString();
        }
    }

    public t(f4.e eVar) {
        this.f3096a = 3;
        this.f3098c = eVar;
        this.f3099d = new f4.d();
    }

    public t(androidx.activity.m mVar, androidx.activity.e eVar) {
        this.f3096a = 1;
        this.f3098c = new Object();
        this.f3099d = new ArrayList();
    }

    public t(Context context) {
        Object sVar;
        this.f3096a = 0;
        this.f3099d = new HashSet();
        c.a aVar = new c.a(2, new androidx.emoji2.text.o(context, false));
        m mVar = new m(this);
        if (Build.VERSION.SDK_INT >= 24) {
            sVar = new c4.e(aVar, mVar);
        } else {
            sVar = new s(context, aVar, mVar);
        }
        this.f3098c = sVar;
    }
}
