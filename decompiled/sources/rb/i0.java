package rb;

import j9.v1;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i0 implements Comparable {

    /* renamed from: p, reason: collision with root package name */
    public static final String f11020p;

    /* renamed from: o, reason: collision with root package name */
    public final o f11021o;

    static {
        String str = File.separator;
        za.h.d("separator", str);
        f11020p = str;
    }

    public i0(o oVar) {
        za.h.e("bytes", oVar);
        this.f11021o = oVar;
    }

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList();
        int a10 = sb.f.a(this);
        o oVar = this.f11021o;
        if (a10 == -1) {
            a10 = 0;
        } else if (a10 < oVar.d() && oVar.i(a10) == 92) {
            a10++;
        }
        int d6 = oVar.d();
        int i10 = a10;
        while (a10 < d6) {
            if (oVar.i(a10) == 47 || oVar.i(a10) == 92) {
                arrayList.add(oVar.o(i10, a10));
                i10 = a10 + 1;
            }
            a10++;
        }
        if (i10 < oVar.d()) {
            arrayList.add(oVar.o(i10, oVar.d()));
        }
        return arrayList;
    }

    public final i0 b() {
        o oVar = sb.f.f11694d;
        o oVar2 = this.f11021o;
        if (za.h.a(oVar2, oVar)) {
            return null;
        }
        o oVar3 = sb.f.f11691a;
        if (za.h.a(oVar2, oVar3)) {
            return null;
        }
        o oVar4 = sb.f.f11692b;
        if (za.h.a(oVar2, oVar4)) {
            return null;
        }
        o oVar5 = sb.f.f11695e;
        oVar2.getClass();
        za.h.e("suffix", oVar5);
        int d6 = oVar2.d();
        byte[] bArr = oVar5.f11049o;
        if (oVar2.m(d6 - bArr.length, oVar5, bArr.length) && (oVar2.d() == 2 || oVar2.m(oVar2.d() - 3, oVar3, 1) || oVar2.m(oVar2.d() - 3, oVar4, 1))) {
            return null;
        }
        int k10 = o.k(oVar2, oVar3);
        if (k10 == -1) {
            k10 = o.k(oVar2, oVar4);
        }
        if (k10 == 2 && g() != null) {
            if (oVar2.d() == 3) {
                return null;
            }
            return new i0(o.p(oVar2, 0, 3, 1));
        }
        if (k10 == 1) {
            za.h.e("prefix", oVar4);
            if (oVar2.m(0, oVar4, oVar4.d())) {
                return null;
            }
        }
        if (k10 != -1 || g() == null) {
            return k10 == -1 ? new i0(oVar) : k10 == 0 ? new i0(o.p(oVar2, 0, 1, 1)) : new i0(o.p(oVar2, 0, k10, 1));
        }
        if (oVar2.d() == 2) {
            return null;
        }
        return new i0(o.p(oVar2, 0, 2, 1));
    }

    public final i0 c(i0 i0Var) {
        za.h.e("other", i0Var);
        o oVar = i0Var.f11021o;
        int a10 = sb.f.a(this);
        o oVar2 = this.f11021o;
        i0 i0Var2 = a10 == -1 ? null : new i0(oVar2.o(0, a10));
        int a11 = sb.f.a(i0Var);
        if (!za.h.a(i0Var2, a11 != -1 ? new i0(oVar.o(0, a11)) : null)) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + i0Var).toString());
        }
        ArrayList a12 = a();
        ArrayList a13 = i0Var.a();
        int min = Math.min(a12.size(), a13.size());
        int i10 = 0;
        while (i10 < min && za.h.a(a12.get(i10), a13.get(i10))) {
            i10++;
        }
        if (i10 == min && oVar2.d() == oVar.d()) {
            return v1.u(".");
        }
        if (a13.subList(i10, a13.size()).indexOf(sb.f.f11695e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + i0Var).toString());
        }
        if (za.h.a(oVar, sb.f.f11694d)) {
            return this;
        }
        l lVar = new l();
        o c10 = sb.f.c(i0Var);
        if (c10 == null && (c10 = sb.f.c(this)) == null) {
            c10 = sb.f.f(f11020p);
        }
        int size = a13.size();
        for (int i11 = i10; i11 < size; i11++) {
            lVar.W(sb.f.f11695e);
            lVar.W(c10);
        }
        int size2 = a12.size();
        while (i10 < size2) {
            lVar.W((o) a12.get(i10));
            lVar.W(c10);
            i10++;
        }
        return sb.f.d(lVar, false);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        i0 i0Var = (i0) obj;
        za.h.e("other", i0Var);
        return this.f11021o.compareTo(i0Var.f11021o);
    }

    public final i0 d(String str) {
        za.h.e("child", str);
        l lVar = new l();
        lVar.e0(str);
        return sb.f.b(this, sb.f.d(lVar, false), false);
    }

    public final i0 e(i0 i0Var, boolean z10) {
        za.h.e("child", i0Var);
        return sb.f.b(this, i0Var, z10);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i0) && za.h.a(((i0) obj).f11021o, this.f11021o);
    }

    public final Path f() {
        Path path;
        path = Paths.get(this.f11021o.r(), new String[0]);
        za.h.d("get(...)", path);
        return path;
    }

    public final Character g() {
        o oVar = sb.f.f11691a;
        o oVar2 = this.f11021o;
        if (o.g(oVar2, oVar) != -1 || oVar2.d() < 2 || oVar2.i(1) != 58) {
            return null;
        }
        char i10 = (char) oVar2.i(0);
        if (('a' > i10 || i10 >= '{') && ('A' > i10 || i10 >= '[')) {
            return null;
        }
        return Character.valueOf(i10);
    }

    public final int hashCode() {
        return this.f11021o.hashCode();
    }

    public final File toFile() {
        return new File(this.f11021o.r());
    }

    public final String toString() {
        return this.f11021o.r();
    }
}
