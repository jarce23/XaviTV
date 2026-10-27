package m1;

import i1.c0;
import i1.e0;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements e0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f8749a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f8750b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8751c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8752d;

    public a(String str, byte[] bArr, int i10, int i11) {
        boolean z10;
        byte b2;
        str.getClass();
        switch (str) {
            case "com.android.capture.fps":
                if (i11 == 23 && bArr.length == 4) {
                    z10 = true;
                }
                l1.d.b(z10);
                break;
            case "auxiliary.tracks.interleaved":
                if (i11 == 75 && bArr.length == 1 && ((b2 = bArr[0]) == 0 || b2 == 1)) {
                    z10 = true;
                }
                l1.d.b(z10);
                break;
            case "auxiliary.tracks.length":
            case "auxiliary.tracks.offset":
                if (i11 == 78 && bArr.length == 8) {
                    z10 = true;
                }
                l1.d.b(z10);
                break;
            case "auxiliary.tracks.map":
                l1.d.b(i11 == 0);
                break;
        }
        this.f8749a = str;
        this.f8750b = bArr;
        this.f8751c = i10;
        this.f8752d = i11;
    }

    @Override // i1.e0
    public final /* synthetic */ i1.p a() {
        return null;
    }

    @Override // i1.e0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final ArrayList d() {
        l1.d.f("Metadata is not an auxiliary tracks map", this.f8749a.equals("auxiliary.tracks.map"));
        byte[] bArr = this.f8750b;
        byte b2 = bArr[1];
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < b2; i10++) {
            arrayList.add(Integer.valueOf(bArr[i10 + 2]));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f8749a.equals(aVar.f8749a) && Arrays.equals(this.f8750b, aVar.f8750b) && this.f8751c == aVar.f8751c && this.f8752d == aVar.f8752d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Arrays.hashCode(this.f8750b) + android.support.v4.media.d.g(this.f8749a, 527, 31)) * 31) + this.f8751c) * 31) + this.f8752d;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e0 A[LOOP:0: B:18:0x00dd->B:20:0x00e0, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m1.a.toString():java.lang.String");
    }

    @Override // i1.e0
    public final /* synthetic */ void c(c0 c0Var) {
    }
}
