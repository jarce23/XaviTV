package w3;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f13007a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f13008b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w f13009c;

    public t(w wVar) {
        this.f13009c = wVar;
    }

    public static void a(q qVar, int i10, Object obj, int i11) {
        boolean z10;
        b0 b0Var = qVar.f12993a;
        p pVar = qVar.f12994b;
        int i12 = 65280 & i10;
        if (i12 != 256) {
            if (i12 != 512) {
                if (i12 == 768 && i10 == 769) {
                    pVar.l((g0) obj);
                }
                return;
            }
            switch (i10) {
                case 513:
                    pVar.a();
                    break;
                case 514:
                    pVar.c();
                    break;
                case 515:
                    pVar.b();
                    break;
            }
        }
        z zVar = (i10 == 264 || i10 == 262) ? (z) ((l0.b) obj).f8061b : (z) obj;
        z zVar2 = (i10 == 264 || i10 == 262) ? (z) ((l0.b) obj).f8060a : null;
        if (zVar != null) {
            boolean z11 = true;
            if ((qVar.f12996d & 2) == 0 && !zVar.h(qVar.f12995c)) {
                w c10 = b0.c();
                if (c10 != null) {
                    g0 g0Var = c10.f13045q;
                    if (g0Var == null ? false : g0Var.f12927c) {
                        z10 = true;
                        z11 = (!z10 && zVar.d() && i10 == 262 && i11 == 3 && zVar2 != null) ? true ^ zVar2.d() : false;
                    }
                }
                z10 = false;
                if (!z10) {
                }
            }
            if (z11) {
                switch (i10) {
                    case 257:
                        pVar.d(zVar);
                        break;
                    case 258:
                        pVar.f(zVar);
                        break;
                    case 259:
                        pVar.e(zVar);
                        break;
                    case 260:
                        pVar.k(zVar);
                        break;
                    case 261:
                        pVar.getClass();
                        break;
                    case 262:
                        pVar.h(b0Var, zVar, i11);
                        break;
                    case 263:
                        pVar.j(b0Var, zVar, i11);
                        break;
                    case 264:
                        pVar.h(b0Var, zVar, i11);
                        break;
                }
            }
        }
    }

    public final void b(int i10, Object obj) {
        obtainMessage(i10, obj).sendToTarget();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int l10;
        ArrayList arrayList = this.f13007a;
        w wVar = this.f13009c;
        ArrayList arrayList2 = wVar.g;
        int i10 = message.what;
        Object obj = message.obj;
        int i11 = message.arg1;
        if (i10 == 259 && wVar.e().f13071c.equals(((z) obj).f13071c)) {
            wVar.p(true);
        }
        ArrayList arrayList3 = this.f13008b;
        if (i10 == 262) {
            z zVar = (z) ((l0.b) obj).f8061b;
            wVar.f13032c.t(zVar);
            if (wVar.f13046r != null && zVar.d()) {
                int size = arrayList3.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj2 = arrayList3.get(i12);
                    i12++;
                    wVar.f13032c.s((z) obj2);
                }
                arrayList3.clear();
            }
        } else if (i10 != 264) {
            switch (i10) {
                case 257:
                    wVar.f13032c.r((z) obj);
                    break;
                case 258:
                    wVar.f13032c.s((z) obj);
                    break;
                case 259:
                    v0 v0Var = wVar.f13032c;
                    z zVar2 = (z) obj;
                    v0Var.getClass();
                    if (zVar2.c() != v0Var && (l10 = v0Var.l(zVar2)) >= 0) {
                        v0Var.y((u0) v0Var.f13029r.get(l10));
                        break;
                    }
                    break;
            }
        } else {
            z zVar3 = (z) ((l0.b) obj).f8061b;
            arrayList3.add(zVar3);
            wVar.f13032c.r(zVar3);
            wVar.f13032c.t(zVar3);
        }
        try {
            int size2 = arrayList2.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    int size3 = arrayList.size();
                    for (int i13 = 0; i13 < size3; i13++) {
                        a((q) arrayList.get(i13), i10, obj, i11);
                    }
                    arrayList.clear();
                    return;
                }
                b0 b0Var = (b0) ((WeakReference) arrayList2.get(size2)).get();
                if (b0Var == null) {
                    arrayList2.remove(size2);
                } else {
                    arrayList.addAll(b0Var.f12897b);
                }
            }
        } catch (Throwable th) {
            arrayList.clear();
            throw th;
        }
    }
}
