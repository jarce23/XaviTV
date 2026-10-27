package a3;

import i1.e0;
import i1.f0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l1.t;
import l1.y;
import n7.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends com.bumptech.glide.d {

    /* renamed from: d, reason: collision with root package name */
    public final t f21d = new t();

    /* renamed from: e, reason: collision with root package name */
    public final i3.f f22e = new i3.f();

    /* renamed from: f, reason: collision with root package name */
    public y f23f;

    @Override // com.bumptech.glide.d
    public final f0 j(t2.a aVar, ByteBuffer byteBuffer) {
        int i10;
        e0 eVar;
        long j10;
        y yVar = this.f23f;
        if (yVar == null || aVar.f11873x != yVar.e()) {
            y yVar2 = new y(aVar.f10412u);
            this.f23f = yVar2;
            yVar2.a(aVar.f10412u - aVar.f11873x);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        t tVar = this.f21d;
        tVar.G(limit, array);
        i3.f fVar = this.f22e;
        fVar.o(limit, array);
        fVar.t(39);
        long i11 = (fVar.i(1) << 32) | fVar.i(32);
        fVar.t(20);
        int i12 = fVar.i(12);
        int i13 = fVar.i(8);
        tVar.J(14);
        if (i13 == 0) {
            i10 = 0;
            eVar = new e();
        } else if (i13 != 255) {
            if (i13 == 4) {
                int w10 = tVar.w();
                ArrayList arrayList = new ArrayList(w10);
                for (int i14 = 0; i14 < w10; i14++) {
                    tVar.y();
                    boolean z10 = (tVar.w() & 128) != 0;
                    ArrayList arrayList2 = new ArrayList();
                    if (!z10) {
                        int w11 = tVar.w();
                        boolean z11 = (w11 & 64) != 0;
                        boolean z12 = (w11 & 32) != 0;
                        if (z11) {
                            tVar.y();
                        }
                        if (!z11) {
                            int w12 = tVar.w();
                            ArrayList arrayList3 = new ArrayList(w12);
                            for (int i15 = 0; i15 < w12; i15++) {
                                tVar.w();
                                tVar.y();
                                arrayList3.add(new i(1));
                            }
                            arrayList2 = arrayList3;
                        }
                        if (z12) {
                            tVar.w();
                            tVar.y();
                        }
                        tVar.C();
                        tVar.w();
                        tVar.w();
                    }
                    arrayList.add(new f(arrayList2));
                }
                eVar = new g(arrayList);
            } else if (i13 == 5) {
                y yVar3 = this.f23f;
                tVar.y();
                boolean z13 = (tVar.w() & 128) != 0;
                List list = Collections.EMPTY_LIST;
                if (z13) {
                    j10 = -9223372036854775807L;
                } else {
                    int w13 = tVar.w();
                    boolean z14 = (w13 & 64) != 0;
                    boolean z15 = (w13 & 32) != 0;
                    boolean z16 = (w13 & 16) != 0;
                    long d6 = (!z14 || z16) ? -9223372036854775807L : a.d(i11, tVar);
                    if (!z14) {
                        int w14 = tVar.w();
                        ArrayList arrayList4 = new ArrayList(w14);
                        for (int i16 = 0; i16 < w14; i16++) {
                            tVar.w();
                            yVar3.b(!z16 ? a.d(i11, tVar) : -9223372036854775807L);
                            arrayList4.add(new d9.f(1));
                        }
                        list = arrayList4;
                    }
                    if (z15) {
                        tVar.w();
                        tVar.y();
                    }
                    tVar.C();
                    tVar.w();
                    tVar.w();
                    j10 = d6;
                }
                eVar = new d(j10, yVar3.b(j10), list);
            } else if (i13 != 6) {
                eVar = null;
            } else {
                y yVar4 = this.f23f;
                long d10 = a.d(i11, tVar);
                eVar = new a(1, d10, yVar4.b(d10));
            }
            i10 = 0;
        } else {
            long y8 = tVar.y();
            int i17 = i12 - 4;
            i10 = 0;
            tVar.h(new byte[i17], 0, i17);
            eVar = new a(0, y8, i11);
        }
        if (eVar == null) {
            return new f0(new e0[i10]);
        }
        e0[] e0VarArr = new e0[1];
        e0VarArr[i10] = eVar;
        return new f0(e0VarArr);
    }
}
