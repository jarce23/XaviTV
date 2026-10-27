package j0;

import com.google.android.gms.internal.cast.v;
import i1.g0;
import i1.o;
import i1.p;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final int f6928a;

    /* renamed from: b, reason: collision with root package name */
    public final List f6929b;

    public i(int i10, List list) {
        this.f6928a = i10;
        this.f6929b = list;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public r3.f0 a(int r6, com.google.android.gms.internal.cast.v r7) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j0.i.a(int, com.google.android.gms.internal.cast.v):r3.f0");
    }

    public List b(v vVar) {
        String str;
        int i10;
        List list;
        boolean c10 = c(32);
        List list2 = this.f6929b;
        if (c10) {
            return list2;
        }
        t tVar = new t((byte[]) vVar.f3502r);
        while (tVar.a() > 0) {
            int w10 = tVar.w();
            int w11 = tVar.f8130b + tVar.w();
            if (w10 == 134) {
                ArrayList arrayList = new ArrayList();
                int w12 = tVar.w() & 31;
                for (int i11 = 0; i11 < w12; i11++) {
                    String u10 = tVar.u(3, StandardCharsets.UTF_8);
                    int w13 = tVar.w();
                    boolean z10 = (w13 & 128) != 0;
                    if (z10) {
                        i10 = w13 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i10 = 1;
                    }
                    byte w14 = (byte) tVar.w();
                    tVar.J(1);
                    if (z10) {
                        boolean z11 = (w14 & 64) != 0;
                        byte[] bArr = l1.e.f8083a;
                        list = Collections.singletonList(z11 ? new byte[]{1} : new byte[]{0});
                    } else {
                        list = null;
                    }
                    o oVar = new o();
                    oVar.f5940m = g0.m(str);
                    oVar.f5932d = u10;
                    oVar.J = i10;
                    oVar.f5943p = list;
                    arrayList.add(new p(oVar));
                }
                list2 = arrayList;
            }
            tVar.I(w11);
        }
        return list2;
    }

    public boolean c(int i10) {
        return (i10 & this.f6928a) != 0;
    }

    public i() {
        this.f6928a = 1;
        this.f6929b = Collections.singletonList(null);
    }

    public i(ArrayList arrayList) {
        this.f6928a = 0;
        this.f6929b = arrayList;
    }
}
