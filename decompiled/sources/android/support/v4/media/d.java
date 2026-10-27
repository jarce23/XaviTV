package android.support.v4.media;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.i0;
import androidx.fragment.app.j0;
import androidx.fragment.app.s;
import androidx.fragment.app.v0;
import com.google.android.gms.internal.cast.u4;
import h3.j;
import h3.k;
import io.realm.RealmQuery;
import io.realm.u;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import l1.a0;
import o9.d0;
import o9.g0;
import p1.n;
import p1.o;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class d {
    public static /* synthetic */ String A(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String B(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static /* synthetic */ String C(int i10) {
        switch (i10) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String D(int i10) {
        switch (i10) {
            case 1:
                return "ENQUEUED";
            case 2:
                return "RUNNING";
            case 3:
                return "SUCCEEDED";
            case 4:
                return "FAILED";
            case 5:
                return "BLOCKED";
            case 6:
                return "CANCELLED";
            default:
                return "null";
        }
    }

    public static h3.c a(k kVar, byte[] bArr, int i10) {
        d0 m10 = g0.m();
        kVar.d(bArr, 0, i10, j.f5535c, new v0(8, m10));
        return new h3.c(m10.f());
    }

    public static final void b(View view, int i10) {
        h.e("view", view);
        int b2 = s.e.b(i10);
        if (b2 == 0) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                if (i0.F(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (b2 == 1) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (b2 == 2) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (b2 != 3) {
            return;
        }
        if (i0.F(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static final boolean c(int i10) {
        return i10 == 3 || i10 == 4 || i10 == 6;
    }

    public static long d(n nVar) {
        byte[] bArr = (byte[]) ((o) nVar).f9861b.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }

    public static /* synthetic */ boolean e(int i10) {
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return false;
        }
        if (i10 == 4 || i10 == 5) {
            return true;
        }
        throw null;
    }

    public static int f(int i10, int i11, int i12) {
        return u4.e0(i10) + i11 + i12;
    }

    public static int g(String str, int i10, int i11) {
        return (str.hashCode() + i10) * i11;
    }

    public static View h(ViewGroup viewGroup, int i10, ViewGroup viewGroup2, boolean z10) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup2, z10);
    }

    public static androidx.fragment.app.a i(j0 j0Var, j0 j0Var2) {
        j0Var.getClass();
        return new androidx.fragment.app.a(j0Var2);
    }

    public static io.realm.i0 j(u uVar, Class cls, String str, String str2) {
        RealmQuery V = uVar.V(cls);
        V.c(str, str2);
        return V.e();
    }

    public static ClassCastException k(int i10, ArrayList arrayList) {
        arrayList.get(i10).getClass();
        return new ClassCastException();
    }

    public static ClassCastException l(Iterator it) {
        it.next().getClass();
        return new ClassCastException();
    }

    public static String m(int i10, String str) {
        return str + i10;
    }

    public static String n(long j10, String str) {
        return str + j10;
    }

    public static String o(String str, int i10, String str2) {
        return str + i10 + str2;
    }

    public static String p(String str, String str2, int i10, int i11) {
        return str + i10 + str2 + i11;
    }

    public static String q(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String r(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static StringBuilder s(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static void t(int i10, int i11, int i12, int i13, int i14) {
        a0.J(i10);
        a0.J(i11);
        a0.J(i12);
        a0.J(i13);
        a0.J(i14);
    }

    public static void u(int i10, HashMap hashMap, String str, int i11, String str2) {
        hashMap.put(str, Integer.valueOf(i10));
        hashMap.put(str2, Integer.valueOf(i11));
    }

    public static void v(androidx.fragment.app.a aVar, s sVar, boolean z10) {
        aVar.h(sVar);
        aVar.c();
        aVar.e(z10);
    }

    public static void w(RealmQuery realmQuery, String str, String str2, String str3, int i10) {
        realmQuery.b(str);
        realmQuery.a(str3, i10, str2.toLowerCase());
    }

    public static void x(String str, int i10, String str2) {
        l1.b.q(str2, str + i10);
    }

    public static void y(String str, long j10, String str2, StringBuilder sb2) {
        sb2.append(str + j10 + str2);
    }

    public static void z(String str, String str2, String str3) {
        l1.b.q(str3, str + str2);
    }
}
