package l3;

import android.graphics.Color;
import com.google.android.gms.internal.cast.n;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final String f8183a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8184b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f8185c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f8186d;

    /* renamed from: e, reason: collision with root package name */
    public final float f8187e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8188f;
    public final boolean g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f8189h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f8190i;

    /* renamed from: j, reason: collision with root package name */
    public final int f8191j;

    public d(String str, int i10, Integer num, Integer num2, float f10, boolean z10, boolean z11, boolean z12, boolean z13, int i11) {
        this.f8183a = str;
        this.f8184b = i10;
        this.f8185c = num;
        this.f8186d = num2;
        this.f8187e = f10;
        this.f8188f = z10;
        this.g = z11;
        this.f8189h = z12;
        this.f8190i = z13;
        this.f8191j = i11;
    }

    public static int a(String str) {
        boolean z10;
        try {
            int parseInt = Integer.parseInt(str.trim());
            switch (parseInt) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    z10 = true;
                    break;
                default:
                    z10 = false;
                    break;
            }
            if (z10) {
                return parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        android.support.v4.media.d.z("Ignoring unknown alignment: ", str, "SsaStyle");
        return -1;
    }

    public static boolean b(String str) {
        try {
            int parseInt = Integer.parseInt(str);
            return parseInt == 1 || parseInt == -1;
        } catch (NumberFormatException e7) {
            l1.b.r("SsaStyle", "Failed to parse boolean value: '" + str + "'", e7);
            return false;
        }
    }

    public static Integer c(String str) {
        try {
            long parseLong = str.startsWith("&H") ? Long.parseLong(str.substring(2), 16) : Long.parseLong(str);
            l1.d.b(parseLong <= 4294967295L);
            return Integer.valueOf(Color.argb(n.c(((parseLong >> 24) & 255) ^ 255), n.c(parseLong & 255), n.c((parseLong >> 8) & 255), n.c((parseLong >> 16) & 255)));
        } catch (IllegalArgumentException e7) {
            l1.b.r("SsaStyle", "Failed to parse color expression: '" + str + "'", e7);
            return null;
        }
    }
}
