package k2;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7702a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7703b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7704c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7705d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7706e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7707f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final int f7708h;

    /* renamed from: i, reason: collision with root package name */
    public final int f7709i;

    /* renamed from: j, reason: collision with root package name */
    public final int f7710j;

    /* renamed from: k, reason: collision with root package name */
    public final float f7711k;

    /* renamed from: l, reason: collision with root package name */
    public final String f7712l;

    public d(ArrayList arrayList, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f10, String str) {
        this.f7702a = arrayList;
        this.f7703b = i10;
        this.f7704c = i11;
        this.f7705d = i12;
        this.f7706e = i13;
        this.f7707f = i14;
        this.g = i15;
        this.f7708h = i16;
        this.f7709i = i17;
        this.f7710j = i18;
        this.f7711k = f10;
        this.f7712l = str;
    }

    public static d a(l1.t tVar) {
        String str;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        float f10;
        int i16;
        int i17;
        try {
            tVar.J(4);
            int w10 = (tVar.w() & 3) + 1;
            if (w10 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int w11 = tVar.w() & 31;
            for (int i18 = 0; i18 < w11; i18++) {
                int C = tVar.C();
                int i19 = tVar.f8130b;
                tVar.J(C);
                byte[] bArr = tVar.f8129a;
                byte[] bArr2 = new byte[C + 4];
                System.arraycopy(l1.e.f8083a, 0, bArr2, 0, 4);
                System.arraycopy(bArr, i19, bArr2, 4, C);
                arrayList.add(bArr2);
            }
            int w12 = tVar.w();
            for (int i20 = 0; i20 < w12; i20++) {
                int C2 = tVar.C();
                int i21 = tVar.f8130b;
                tVar.J(C2);
                byte[] bArr3 = tVar.f8129a;
                byte[] bArr4 = new byte[C2 + 4];
                System.arraycopy(l1.e.f8083a, 0, bArr4, 0, 4);
                System.arraycopy(bArr3, i21, bArr4, 4, C2);
                arrayList.add(bArr4);
            }
            if (w11 > 0) {
                m1.n j10 = m1.o.j((byte[]) arrayList.get(0), 4, ((byte[]) arrayList.get(0)).length);
                int i22 = j10.f8799e;
                int i23 = j10.f8800f;
                int i24 = j10.f8801h + 8;
                int i25 = j10.f8802i + 8;
                int i26 = j10.f8809p;
                int i27 = j10.f8810q;
                int i28 = j10.f8811r;
                int i29 = j10.f8812s;
                float f11 = j10.g;
                int i30 = j10.f8795a;
                int i31 = j10.f8796b;
                int i32 = j10.f8797c;
                byte[] bArr5 = l1.e.f8083a;
                str = String.format("avc1.%02X%02X%02X", Integer.valueOf(i30), Integer.valueOf(i31), Integer.valueOf(i32));
                i15 = i29;
                f10 = f11;
                i16 = i27;
                i17 = i28;
                i13 = i25;
                i14 = i26;
                i11 = i23;
                i12 = i24;
                i10 = i22;
            } else {
                str = null;
                i10 = -1;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = 16;
                f10 = 1.0f;
                i16 = -1;
                i17 = -1;
            }
            return new d(arrayList, w10, i10, i11, i12, i13, i14, i16, i17, i15, f10, str);
        } catch (ArrayIndexOutOfBoundsException e7) {
            throw i1.h0.a(e7, "Error parsing AVC config");
        }
    }
}
