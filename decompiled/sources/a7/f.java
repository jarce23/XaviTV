package a7;

import android.util.Log;
import c2.d0;
import c2.j0;
import c2.k0;
import c2.u;
import c2.z;
import f2.o;
import i1.u0;
import java.io.IOException;
import o9.g0;
import o9.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements j, l1.h, o, l1.m, b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f119o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f120p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f121q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f122r;

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, int i10) {
        this.f119o = i10;
        this.f120p = obj;
        this.f122r = obj2;
        this.f121q = obj3;
    }

    @Override // l1.h
    public void accept(Object obj) {
        j0 j0Var = (j0) this.f120p;
        ((k0) obj).G(j0Var.f2621a, (d0) this.f122r, (z) this.f121q);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007f A[SYNTHETIC] */
    @Override // a7.j, n9.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object apply(java.lang.Object r27) {
        /*
            Method dump skipped, instructions count: 976
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a7.f.apply(java.lang.Object):java.lang.Object");
    }

    @Override // f2.o
    public w0 b(int i10, u0 u0Var, int[] iArr) {
        f2.k kVar = (f2.k) this.f120p;
        String str = (String) this.f122r;
        String str2 = (String) this.f121q;
        o9.d0 m10 = g0.m();
        for (int i11 = 0; i11 < u0Var.f6039a; i11++) {
            m10.a(new f2.n(i10, u0Var, i11, kVar, iArr[i11], str, str2));
        }
        return m10.f();
    }

    @Override // b7.b
    public Object execute() {
        y6.a aVar = (y6.a) this.f120p;
        s6.i iVar = (s6.i) this.f121q;
        s6.h hVar = (s6.h) this.f122r;
        l lVar = (l) aVar.f13891d;
        lVar.getClass();
        p6.c cVar = iVar.f11613c;
        String str = hVar.f11605a;
        String str2 = iVar.f11611a;
        Log.d("TransportRuntime.".concat("SQLiteEventStore"), "Storing event with priority=" + cVar + ", name=" + str + " for destination " + str2);
        ((Long) lVar.n(new f(lVar, hVar, iVar, 0))).getClass();
        aVar.f13888a.V(iVar, 1, false);
        return null;
    }

    @Override // l1.m
    public void invoke(Object obj) {
        ((t1.b) obj).A((t1.a) this.f120p, (z) this.f122r, (IOException) this.f121q);
    }

    public /* synthetic */ f(t1.a aVar, u uVar, z zVar, IOException iOException, boolean z10) {
        this.f119o = 5;
        this.f120p = aVar;
        this.f122r = zVar;
        this.f121q = iOException;
    }

    public /* synthetic */ f(y6.a aVar, s6.i iVar, s6.h hVar) {
        this.f119o = 6;
        this.f120p = aVar;
        this.f121q = iVar;
        this.f122r = hVar;
    }
}
