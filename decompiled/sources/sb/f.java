package sb;

import j9.w1;
import rb.i0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final rb.o f11691a;

    /* renamed from: b, reason: collision with root package name */
    public static final rb.o f11692b;

    /* renamed from: c, reason: collision with root package name */
    public static final rb.o f11693c;

    /* renamed from: d, reason: collision with root package name */
    public static final rb.o f11694d;

    /* renamed from: e, reason: collision with root package name */
    public static final rb.o f11695e;

    static {
        rb.o oVar = rb.o.f11048r;
        f11691a = w1.F("/");
        f11692b = w1.F("\\");
        f11693c = w1.F("/\\");
        f11694d = w1.F(".");
        f11695e = w1.F("..");
    }

    public static final int a(i0 i0Var) {
        rb.o oVar = i0Var.f11021o;
        if (oVar.d() != 0) {
            if (oVar.i(0) != 47) {
                if (oVar.i(0) == 92) {
                    if (oVar.d() > 2 && oVar.i(1) == 92) {
                        rb.o oVar2 = f11692b;
                        za.h.e("other", oVar2);
                        int f10 = oVar.f(2, oVar2.h());
                        return f10 == -1 ? oVar.d() : f10;
                    }
                } else if (oVar.d() > 2 && oVar.i(1) == 58 && oVar.i(2) == 92) {
                    char i10 = (char) oVar.i(0);
                    if ('a' <= i10 && i10 < '{') {
                        return 3;
                    }
                    if ('A' <= i10 && i10 < '[') {
                        return 3;
                    }
                }
            }
            return 1;
        }
        return -1;
    }

    public static final i0 b(i0 i0Var, i0 i0Var2, boolean z10) {
        za.h.e("child", i0Var2);
        if (a(i0Var2) != -1 || i0Var2.g() != null) {
            return i0Var2;
        }
        rb.o c10 = c(i0Var);
        if (c10 == null && (c10 = c(i0Var2)) == null) {
            c10 = f(i0.f11020p);
        }
        rb.l lVar = new rb.l();
        lVar.W(i0Var.f11021o);
        if (lVar.f11035p > 0) {
            lVar.W(c10);
        }
        lVar.W(i0Var2.f11021o);
        return d(lVar, z10);
    }

    public static final rb.o c(i0 i0Var) {
        rb.o oVar = i0Var.f11021o;
        rb.o oVar2 = f11691a;
        if (rb.o.g(oVar, oVar2) != -1) {
            return oVar2;
        }
        rb.o oVar3 = i0Var.f11021o;
        rb.o oVar4 = f11692b;
        if (rb.o.g(oVar3, oVar4) != -1) {
            return oVar4;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011b A[EDGE_INSN: B:72:0x011b->B:73:0x011b BREAK  A[LOOP:1: B:20:0x00ab->B:36:0x00ab], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final rb.i0 d(rb.l r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: sb.f.d(rb.l, boolean):rb.i0");
    }

    public static final rb.o e(byte b2) {
        if (b2 == 47) {
            return f11691a;
        }
        if (b2 == 92) {
            return f11692b;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(b2, "not a directory separator: "));
    }

    public static final rb.o f(String str) {
        if (za.h.a(str, "/")) {
            return f11691a;
        }
        if (za.h.a(str, "\\")) {
            return f11692b;
        }
        throw new IllegalArgumentException(r.a.l("not a directory separator: ", str));
    }
}
