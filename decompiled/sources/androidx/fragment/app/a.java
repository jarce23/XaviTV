package androidx.fragment.app;

import android.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements g0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f626a;

    /* renamed from: b, reason: collision with root package name */
    public int f627b;

    /* renamed from: c, reason: collision with root package name */
    public int f628c;

    /* renamed from: d, reason: collision with root package name */
    public int f629d;

    /* renamed from: e, reason: collision with root package name */
    public int f630e;

    /* renamed from: f, reason: collision with root package name */
    public int f631f;
    public boolean g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f632h;

    /* renamed from: i, reason: collision with root package name */
    public String f633i;

    /* renamed from: j, reason: collision with root package name */
    public int f634j;

    /* renamed from: k, reason: collision with root package name */
    public CharSequence f635k;

    /* renamed from: l, reason: collision with root package name */
    public int f636l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f637m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f638n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f639o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f640p;

    /* renamed from: q, reason: collision with root package name */
    public final i0 f641q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f642r;

    /* renamed from: s, reason: collision with root package name */
    public int f643s;

    public a(i0 i0Var) {
        i0Var.C();
        u uVar = i0Var.f707t;
        if (uVar != null) {
            uVar.f826t.getClassLoader();
        }
        this.f626a = new ArrayList();
        this.f632h = true;
        this.f640p = false;
        this.f643s = -1;
        this.f641q = i0Var;
    }

    @Override // androidx.fragment.app.g0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        if (i0.F(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.g) {
            return true;
        }
        i0 i0Var = this.f641q;
        if (i0Var.f692d == null) {
            i0Var.f692d = new ArrayList();
        }
        i0Var.f692d.add(this);
        return true;
    }

    public final void b(q0 q0Var) {
        this.f626a.add(q0Var);
        q0Var.f779d = this.f627b;
        q0Var.f780e = this.f628c;
        q0Var.f781f = this.f629d;
        q0Var.g = this.f630e;
    }

    public final void c() {
        if (!this.f632h) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        this.g = true;
        this.f633i = null;
    }

    public final void d(int i10) {
        if (this.g) {
            if (i0.F(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i10);
            }
            ArrayList arrayList = this.f626a;
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                q0 q0Var = (q0) arrayList.get(i11);
                s sVar = q0Var.f777b;
                if (sVar != null) {
                    sVar.E += i10;
                    if (i0.F(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + q0Var.f777b + " to " + q0Var.f777b.E);
                    }
                }
            }
        }
    }

    public final int e(boolean z10) {
        if (this.f642r) {
            throw new IllegalStateException("commit already called");
        }
        if (i0.F(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new s0());
            g("  ", printWriter, true);
            printWriter.close();
        }
        this.f642r = true;
        boolean z11 = this.g;
        i0 i0Var = this.f641q;
        if (z11) {
            this.f643s = i0Var.f696i.getAndIncrement();
        } else {
            this.f643s = -1;
        }
        i0Var.v(this, z10);
        return this.f643s;
    }

    public final void f(int i10, s sVar, String str, int i11) {
        String str2 = sVar.Y;
        if (str2 != null) {
            y0.c.c(sVar, str2);
        }
        Class<?> cls = sVar.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str3 = sVar.L;
            if (str3 != null && !str.equals(str3)) {
                throw new IllegalStateException("Can't change tag of fragment " + sVar + ": was " + sVar.L + " now " + str);
            }
            sVar.L = str;
        }
        if (i10 != 0) {
            if (i10 == -1) {
                throw new IllegalArgumentException("Can't add fragment " + sVar + " with tag " + str + " to container view with no id");
            }
            int i12 = sVar.J;
            if (i12 != 0 && i12 != i10) {
                throw new IllegalStateException("Can't change container ID of fragment " + sVar + ": was " + sVar.J + " now " + i10);
            }
            sVar.J = i10;
            sVar.K = i10;
        }
        b(new q0(i11, sVar));
        sVar.F = this.f641q;
    }

    public final void g(String str, PrintWriter printWriter, boolean z10) {
        String str2;
        if (z10) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f633i);
            printWriter.print(" mIndex=");
            printWriter.print(this.f643s);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f642r);
            if (this.f631f != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f631f));
            }
            if (this.f627b != 0 || this.f628c != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f627b));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f628c));
            }
            if (this.f629d != 0 || this.f630e != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f629d));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f630e));
            }
            if (this.f634j != 0 || this.f635k != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f634j));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f635k);
            }
            if (this.f636l != 0 || this.f637m != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f636l));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f637m);
            }
        }
        ArrayList arrayList = this.f626a;
        if (arrayList.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            q0 q0Var = (q0) arrayList.get(i10);
            switch (q0Var.f776a) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + q0Var.f776a;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i10);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(q0Var.f777b);
            if (z10) {
                if (q0Var.f779d != 0 || q0Var.f780e != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(q0Var.f779d));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(q0Var.f780e));
                }
                if (q0Var.f781f != 0 || q0Var.g != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(q0Var.f781f));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(q0Var.g));
                }
            }
        }
    }

    public final void h(s sVar) {
        i0 i0Var = sVar.F;
        if (i0Var == null || i0Var == this.f641q) {
            b(new q0(3, sVar));
            return;
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + sVar.toString() + " is already attached to a FragmentManager.");
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("BackStackEntry{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f643s >= 0) {
            sb2.append(" #");
            sb2.append(this.f643s);
        }
        if (this.f633i != null) {
            sb2.append(" ");
            sb2.append(this.f633i);
        }
        sb2.append("}");
        return sb2.toString();
    }
}
