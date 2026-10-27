package i3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l1.t;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends i {

    /* renamed from: i, reason: collision with root package name */
    public final int f6329i;

    /* renamed from: j, reason: collision with root package name */
    public final int f6330j;

    /* renamed from: k, reason: collision with root package name */
    public final int f6331k;

    /* renamed from: o, reason: collision with root package name */
    public List f6335o;

    /* renamed from: p, reason: collision with root package name */
    public List f6336p;

    /* renamed from: q, reason: collision with root package name */
    public int f6337q;

    /* renamed from: r, reason: collision with root package name */
    public int f6338r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f6339s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6340t;

    /* renamed from: u, reason: collision with root package name */
    public byte f6341u;

    /* renamed from: v, reason: collision with root package name */
    public byte f6342v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f6344x;

    /* renamed from: y, reason: collision with root package name */
    public long f6345y;

    /* renamed from: z, reason: collision with root package name */
    public static final int[] f6327z = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] A = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] B = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] C = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS, HttpStatusCodesKt.HTTP_PROCESSING, HttpStatusCodesKt.HTTP_EARLY_HINTS, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] D = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] E = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] F = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, WebSocketProtocol.PAYLOAD_SHORT, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] G = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};

    /* renamed from: h, reason: collision with root package name */
    public final t f6328h = new t();

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f6333m = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public b f6334n = new b(0, 4);

    /* renamed from: w, reason: collision with root package name */
    public int f6343w = 0;

    /* renamed from: l, reason: collision with root package name */
    public final long f6332l = 16000000;

    public c(String str, int i10) {
        this.f6329i = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i10 == 1) {
            this.f6331k = 0;
            this.f6330j = 0;
        } else if (i10 == 2) {
            this.f6331k = 1;
            this.f6330j = 0;
        } else if (i10 == 3) {
            this.f6331k = 0;
            this.f6330j = 1;
        } else if (i10 != 4) {
            l1.b.q("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
            this.f6331k = 0;
            this.f6330j = 0;
        } else {
            this.f6331k = 1;
            this.f6330j = 1;
        }
        m(0);
        l();
        this.f6344x = true;
        this.f6345y = -9223372036854775807L;
    }

    @Override // i3.i, r1.b
    public final void flush() {
        super.flush();
        this.f6335o = null;
        this.f6336p = null;
        m(0);
        this.f6338r = 4;
        this.f6334n.f6326h = 4;
        l();
        this.f6339s = false;
        this.f6340t = false;
        this.f6341u = (byte) 0;
        this.f6342v = (byte) 0;
        this.f6343w = 0;
        this.f6344x = true;
        this.f6345y = -9223372036854775807L;
    }

    @Override // i3.i
    public final a3.f g() {
        List list = this.f6335o;
        this.f6336p = list;
        list.getClass();
        return new a3.f(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:160:0x007e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[SYNTHETIC] */
    @Override // i3.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(i3.h r15) {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.c.h(i3.h):void");
    }

    @Override // i3.i, r1.b
    /* renamed from: i */
    public final h3.d e() {
        h3.d dVar;
        h3.d e7 = super.e();
        if (e7 != null) {
            return e7;
        }
        long j10 = this.f6332l;
        if (j10 == -9223372036854775807L) {
            return null;
        }
        long j11 = this.f6345y;
        if (j11 == -9223372036854775807L || this.f6394e - j11 < j10 || (dVar = (h3.d) this.f6391b.pollFirst()) == null) {
            return null;
        }
        this.f6335o = Collections.EMPTY_LIST;
        this.f6345y = -9223372036854775807L;
        a3.f g = g();
        long j12 = this.f6394e;
        dVar.f10415q = j12;
        dVar.f5529s = g;
        dVar.f5530t = j12;
        return dVar;
    }

    @Override // i3.i
    public final boolean j() {
        return this.f6335o != this.f6336p;
    }

    public final ArrayList k() {
        ArrayList arrayList = this.f6333m;
        int size = arrayList.size();
        ArrayList arrayList2 = new ArrayList(size);
        int i10 = 2;
        for (int i11 = 0; i11 < size; i11++) {
            k1.b c10 = ((b) arrayList.get(i11)).c(Integer.MIN_VALUE);
            arrayList2.add(c10);
            if (c10 != null) {
                i10 = Math.min(i10, c10.f7630i);
            }
        }
        ArrayList arrayList3 = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            k1.b bVar = (k1.b) arrayList2.get(i12);
            if (bVar != null) {
                if (bVar.f7630i != i10) {
                    bVar = ((b) arrayList.get(i12)).c(i10);
                    bVar.getClass();
                }
                arrayList3.add(bVar);
            }
        }
        return arrayList3;
    }

    public final void l() {
        b bVar = this.f6334n;
        bVar.g = this.f6337q;
        bVar.f6320a.clear();
        bVar.f6321b.clear();
        bVar.f6322c.setLength(0);
        bVar.f6323d = 15;
        bVar.f6324e = 0;
        bVar.f6325f = 0;
        ArrayList arrayList = this.f6333m;
        arrayList.clear();
        arrayList.add(this.f6334n);
    }

    public final void m(int i10) {
        int i11 = this.f6337q;
        if (i11 == i10) {
            return;
        }
        this.f6337q = i10;
        if (i10 != 3) {
            l();
            if (i11 == 3 || i10 == 1 || i10 == 0) {
                this.f6335o = Collections.EMPTY_LIST;
                return;
            }
            return;
        }
        int i12 = 0;
        while (true) {
            ArrayList arrayList = this.f6333m;
            if (i12 >= arrayList.size()) {
                return;
            }
            ((b) arrayList.get(i12)).g = i10;
            i12++;
        }
    }

    @Override // i3.i, r1.b
    public final void a() {
    }
}
