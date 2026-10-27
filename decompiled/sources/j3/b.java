package j3;

import android.text.TextUtils;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f7065a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7066b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7067c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7068d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7069e;

    /* renamed from: f, reason: collision with root package name */
    public final int f7070f;

    public /* synthetic */ b(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f7065a = i10;
        this.f7066b = i11;
        this.f7067c = i12;
        this.f7068d = i13;
        this.f7069e = i14;
        this.f7070f = i15;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static b a(String str) {
        char c10;
        l1.d.b(str.startsWith("Format:"));
        String[] split = TextUtils.split(str.substring(7), ",");
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < split.length; i15++) {
            String C = com.bumptech.glide.c.C(split[i15].trim());
            C.getClass();
            switch (C.hashCode()) {
                case 100571:
                    if (C.equals("end")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 3556653:
                    if (C.equals("text")) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 102749521:
                    if (C.equals("layer")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 109757538:
                    if (C.equals("start")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 109780401:
                    if (C.equals("style")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    i12 = i15;
                    break;
                case 1:
                    i14 = i15;
                    break;
                case 2:
                    i10 = i15;
                    break;
                case 3:
                    i11 = i15;
                    break;
                case 4:
                    i13 = i15;
                    break;
            }
        }
        if (i11 == -1 || i12 == -1 || i14 == -1) {
            return null;
        }
        return new b(i10, i11, i12, i13, i14, split.length);
    }
}
