package q2;

import b0.j;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import l1.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends j {

    /* renamed from: b, reason: collision with root package name */
    public long f10259b;

    /* renamed from: c, reason: collision with root package name */
    public long[] f10260c;

    /* renamed from: d, reason: collision with root package name */
    public long[] f10261d;

    public static Serializable q(int i10, t tVar) {
        if (i10 == 0) {
            return Double.valueOf(Double.longBitsToDouble(tVar.q()));
        }
        if (i10 == 1) {
            return Boolean.valueOf(tVar.w() == 1);
        }
        if (i10 == 2) {
            return s(tVar);
        }
        if (i10 != 3) {
            if (i10 == 8) {
                return r(tVar);
            }
            if (i10 != 10) {
                if (i10 != 11) {
                    return null;
                }
                Date date = new Date((long) Double.longBitsToDouble(tVar.q()));
                tVar.J(2);
                return date;
            }
            int A = tVar.A();
            ArrayList arrayList = new ArrayList(A);
            for (int i11 = 0; i11 < A; i11++) {
                Serializable q10 = q(tVar.w(), tVar);
                if (q10 != null) {
                    arrayList.add(q10);
                }
            }
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        while (true) {
            String s10 = s(tVar);
            int w10 = tVar.w();
            if (w10 == 9) {
                return hashMap;
            }
            Serializable q11 = q(w10, tVar);
            if (q11 != null) {
                hashMap.put(s10, q11);
            }
        }
    }

    public static HashMap r(t tVar) {
        int A = tVar.A();
        HashMap hashMap = new HashMap(A);
        for (int i10 = 0; i10 < A; i10++) {
            String s10 = s(tVar);
            Serializable q10 = q(tVar.w(), tVar);
            if (q10 != null) {
                hashMap.put(s10, q10);
            }
        }
        return hashMap;
    }

    public static String s(t tVar) {
        int C = tVar.C();
        int i10 = tVar.f8130b;
        tVar.J(C);
        return new String(tVar.f8129a, i10, C);
    }
}
