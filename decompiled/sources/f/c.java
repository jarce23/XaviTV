package f;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import androidx.fragment.app.v0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import w3.o0;
import w3.q0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4744a = 0;

    /* renamed from: b, reason: collision with root package name */
    public WeakReference f4745b;

    public /* synthetic */ c() {
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        w3.k kVar;
        switch (this.f4744a) {
            case 0:
                int i10 = message.what;
                if (i10 == -3 || i10 == -2 || i10 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f4745b.get(), message.what);
                    return;
                } else {
                    if (i10 != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            case 1:
                pl.droidsonroids.gif.c cVar = (pl.droidsonroids.gif.c) this.f4745b.get();
                if (cVar == null) {
                    return;
                }
                if (message.what == -1) {
                    cVar.invalidateSelf();
                    return;
                }
                Iterator it = cVar.f10209v.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.d.l(it);
                }
                return;
            default:
                w3.j0 j0Var = (w3.j0) this.f4745b.get();
                if (j0Var != null) {
                    SparseArray sparseArray = j0Var.f12946h;
                    o0 o0Var = j0Var.f12947i;
                    ArrayList arrayList = o0Var.f12987k;
                    int i11 = message.what;
                    int i12 = message.arg1;
                    int i13 = message.arg2;
                    Object obj = message.obj;
                    Bundle peekData = message.peekData();
                    int i14 = 0;
                    w3.k0 k0Var = null;
                    w3.k0 k0Var2 = null;
                    switch (i11) {
                        case 0:
                            if (i12 == j0Var.g) {
                                j0Var.g = 0;
                                if (o0Var.f12990n == j0Var) {
                                    o0Var.l();
                                }
                            }
                            if (((w3.l0) sparseArray.get(i12)) != null) {
                                sparseArray.remove(i12);
                                w3.l0.a(null, null);
                                return;
                            }
                            return;
                        case 1:
                            return;
                        case 2:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle = (Bundle) obj;
                                if (j0Var.f12945f == 0 && i12 == j0Var.g && i13 >= 1) {
                                    j0Var.g = 0;
                                    j0Var.f12945f = i13;
                                    ea.a e7 = ea.a.e(bundle);
                                    if (o0Var.f12990n == j0Var) {
                                        o0Var.g(e7);
                                    }
                                    if (o0Var.f12990n == j0Var) {
                                        o0Var.f12991o = true;
                                        int size = arrayList.size();
                                        while (i14 < size) {
                                            ((w3.k0) arrayList.get(i14)).c(o0Var.f12990n);
                                            i14++;
                                        }
                                        w3.j jVar = o0Var.f12971e;
                                        if (jVar != null) {
                                            w3.j0 j0Var2 = o0Var.f12990n;
                                            int i15 = j0Var2.f12943d;
                                            j0Var2.f12943d = i15 + 1;
                                            j0Var2.b(10, i15, 0, jVar.f12938a, null);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 3:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle2 = (Bundle) obj;
                                w3.l0 l0Var = (w3.l0) sparseArray.get(i12);
                                if (l0Var != null) {
                                    sparseArray.remove(i12);
                                    l0Var.b(bundle2);
                                    return;
                                }
                            }
                            break;
                        case 4:
                            if (obj == null || (obj instanceof Bundle)) {
                                String string = peekData != null ? peekData.getString("error") : null;
                                Bundle bundle3 = (Bundle) obj;
                                if (((w3.l0) sparseArray.get(i12)) != null) {
                                    sparseArray.remove(i12);
                                    w3.l0.a(string, bundle3);
                                    return;
                                }
                            }
                            break;
                        case 5:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle4 = (Bundle) obj;
                                if (j0Var.f12945f != 0) {
                                    ea.a e8 = ea.a.e(bundle4);
                                    if (o0Var.f12990n == j0Var) {
                                        o0Var.g(e8);
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 6:
                            if (!(obj instanceof Bundle)) {
                                Log.w("MediaRouteProviderProxy", "No further information on the dynamic group controller");
                                break;
                            } else {
                                Bundle bundle5 = (Bundle) obj;
                                w3.l0 l0Var2 = (w3.l0) sparseArray.get(i12);
                                if (!bundle5.containsKey("routeId")) {
                                    l0Var2.getClass();
                                    w3.l0.a("DynamicGroupRouteController is created without valid route id.", bundle5);
                                    break;
                                } else {
                                    sparseArray.remove(i12);
                                    l0Var2.b(bundle5);
                                    break;
                                }
                            }
                        case 7:
                            if (obj == null || (obj instanceof Bundle)) {
                                Bundle bundle6 = (Bundle) obj;
                                if (j0Var.f12945f != 0) {
                                    Bundle bundle7 = (Bundle) bundle6.getParcelable("groupRoute");
                                    w3.i iVar = bundle7 != null ? new w3.i(bundle7) : null;
                                    ArrayList parcelableArrayList = bundle6.getParcelableArrayList("dynamicRoutes");
                                    ArrayList arrayList2 = new ArrayList();
                                    int size2 = parcelableArrayList.size();
                                    int i16 = 0;
                                    while (i16 < size2) {
                                        Object obj2 = parcelableArrayList.get(i16);
                                        i16++;
                                        Bundle bundle8 = (Bundle) obj2;
                                        if (bundle8 == null) {
                                            kVar = null;
                                        } else {
                                            Bundle bundle9 = bundle8.getBundle("mrDescriptor");
                                            kVar = new w3.k(bundle9 != null ? new w3.i(bundle9) : null, bundle8.getInt("selectionState", 1), bundle8.getBoolean("isUnselectable", false), bundle8.getBoolean("isGroupable", false), bundle8.getBoolean("isTransferable", false));
                                        }
                                        arrayList2.add(kVar);
                                    }
                                    if (o0Var.f12990n == j0Var) {
                                        int size3 = arrayList.size();
                                        while (true) {
                                            if (i14 < size3) {
                                                Object obj3 = arrayList.get(i14);
                                                i14++;
                                                w3.k0 k0Var3 = (w3.k0) obj3;
                                                if (k0Var3.a() == i13) {
                                                    k0Var2 = k0Var3;
                                                }
                                            }
                                        }
                                        if (k0Var2 instanceof w3.m0) {
                                            ((w3.m0) k0Var2).l(iVar, arrayList2);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            break;
                        case 8:
                            if (o0Var.f12990n == j0Var) {
                                int size4 = arrayList.size();
                                while (true) {
                                    if (i14 < size4) {
                                        Object obj4 = arrayList.get(i14);
                                        i14++;
                                        w3.k0 k0Var4 = (w3.k0) obj4;
                                        if (k0Var4.a() == i13) {
                                            k0Var = k0Var4;
                                        }
                                    }
                                }
                                v0 v0Var = o0Var.f12992p;
                                if (v0Var != null && (k0Var instanceof w3.m)) {
                                    w3.m mVar = (w3.m) k0Var;
                                    w3.w wVar = (w3.w) ((q0) v0Var.f843p).f13000c;
                                    if (wVar.f13049u == mVar) {
                                        wVar.j(wVar.c(), 2);
                                    }
                                }
                                arrayList.remove(k0Var);
                                k0Var.b();
                                o0Var.m();
                                break;
                            }
                            break;
                    }
                    int i17 = o0.f12984q;
                    return;
                }
                return;
        }
    }

    public c(pl.droidsonroids.gif.c cVar) {
        super(Looper.getMainLooper());
        this.f4745b = new WeakReference(cVar);
    }

    public c(w3.j0 j0Var) {
        this.f4745b = new WeakReference(j0Var);
    }
}
