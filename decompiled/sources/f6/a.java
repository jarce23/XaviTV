package f6;

import a6.e;
import android.content.res.Resources;
import android.text.TextUtils;
import i1.p;
import l1.a0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import r5.h;
import t5.y;
import u3.g0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements b, g0 {

    /* renamed from: o, reason: collision with root package name */
    public final Resources f5025o;

    public a(Resources resources, int i10) {
        switch (i10) {
            case 1:
                resources.getClass();
                this.f5025o = resources;
                break;
            default:
                this.f5025o = resources;
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String a(i1.p r8) {
        /*
            r7 = this;
            java.lang.String r0 = r8.f5982d
            java.lang.String r1 = r8.f5980b
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r3 = ""
            if (r2 != 0) goto L37
            java.lang.String r2 = "und"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L15
            goto L37
        L15:
            java.util.Locale r0 = java.util.Locale.forLanguageTag(r0)
            int r2 = l1.a0.f8067a
            int r2 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r2 < r4) goto L29
            k0.c.h()
            java.util.Locale r2 = k0.c.i()
            goto L2d
        L29:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L2d:
            java.lang.String r0 = r0.getDisplayName(r2)
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 == 0) goto L39
        L37:
            r0 = r3
            goto L5a
        L39:
            r4 = 1
            r5 = 0
            int r4 = r0.offsetByCodePoints(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            r6.<init>()     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            java.lang.String r5 = r0.substring(r5, r4)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            java.lang.String r2 = r0.substring(r4)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            r6.append(r2)     // Catch: java.lang.IndexOutOfBoundsException -> L5a
            java.lang.String r0 = r6.toString()     // Catch: java.lang.IndexOutOfBoundsException -> L5a
        L5a:
            java.lang.String r8 = r7.b(r8)
            java.lang.String[] r8 = new java.lang.String[]{r0, r8}
            java.lang.String r8 = r7.d(r8)
            boolean r0 = android.text.TextUtils.isEmpty(r8)
            if (r0 == 0) goto L74
            boolean r8 = android.text.TextUtils.isEmpty(r1)
            if (r8 == 0) goto L73
            r1 = r3
        L73:
            r8 = r1
        L74:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.a.a(i1.p):java.lang.String");
    }

    public String b(p pVar) {
        int i10 = pVar.f5984f;
        int i11 = pVar.f5984f;
        int i12 = i10 & 2;
        Resources resources = this.f5025o;
        String string = i12 != 0 ? resources.getString(R.string.exo_track_role_alternate) : _UrlKt.FRAGMENT_ENCODE_SET;
        if ((i11 & 4) != 0) {
            string = d(string, resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((i11 & 8) != 0) {
            string = d(string, resources.getString(R.string.exo_track_role_commentary));
        }
        return (i11 & 1088) != 0 ? d(string, resources.getString(R.string.exo_track_role_closed_captions)) : string;
    }

    public String c(p pVar) {
        String a10;
        String d6;
        String str = pVar.f5991n;
        int i10 = pVar.f5987j;
        int i11 = pVar.F;
        int i12 = pVar.f5999v;
        int i13 = pVar.f5998u;
        String str2 = pVar.f5988k;
        int h10 = i1.g0.h(str);
        if (h10 == -1) {
            String str3 = null;
            if (str2 != null) {
                for (String str4 : a0.Y(str2)) {
                    d6 = i1.g0.d(str4);
                    if (d6 != null && i1.g0.l(d6)) {
                        break;
                    }
                }
            }
            d6 = null;
            if (d6 == null) {
                if (str2 != null) {
                    String[] Y = a0.Y(str2);
                    int length = Y.length;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= length) {
                            break;
                        }
                        String d10 = i1.g0.d(Y[i14]);
                        if (d10 != null && i1.g0.i(d10)) {
                            str3 = d10;
                            break;
                        }
                        i14++;
                    }
                }
                if (str3 == null) {
                    if (i13 == -1 && i12 == -1) {
                        if (i11 == -1 && pVar.G == -1) {
                            h10 = -1;
                        }
                    }
                }
                h10 = 1;
            }
            h10 = 2;
        }
        String str5 = _UrlKt.FRAGMENT_ENCODE_SET;
        Resources resources = this.f5025o;
        if (h10 == 2) {
            String b2 = b(pVar);
            String string = (i13 == -1 || i12 == -1) ? _UrlKt.FRAGMENT_ENCODE_SET : resources.getString(R.string.exo_track_resolution, Integer.valueOf(i13), Integer.valueOf(i12));
            if (i10 != -1) {
                str5 = resources.getString(R.string.exo_track_bitrate, Float.valueOf(i10 / 1000000.0f));
            }
            a10 = d(b2, string, str5);
        } else if (h10 == 1) {
            String a11 = a(pVar);
            String string2 = (i11 == -1 || i11 < 1) ? _UrlKt.FRAGMENT_ENCODE_SET : i11 != 1 ? i11 != 2 ? (i11 == 6 || i11 == 7) ? resources.getString(R.string.exo_track_surround_5_point_1) : i11 != 8 ? resources.getString(R.string.exo_track_surround) : resources.getString(R.string.exo_track_surround_7_point_1) : resources.getString(R.string.exo_track_stereo) : resources.getString(R.string.exo_track_mono);
            if (i10 != -1) {
                str5 = resources.getString(R.string.exo_track_bitrate, Float.valueOf(i10 / 1000000.0f));
            }
            a10 = d(a11, string2, str5);
        } else {
            a10 = a(pVar);
        }
        if (!a10.isEmpty()) {
            return a10;
        }
        String str6 = pVar.f5982d;
        return (str6 == null || str6.trim().isEmpty()) ? resources.getString(R.string.exo_track_unknown) : resources.getString(R.string.exo_track_unknown_name, str6);
    }

    public String d(String... strArr) {
        String str = _UrlKt.FRAGMENT_ENCODE_SET;
        for (String str2 : strArr) {
            if (!str2.isEmpty()) {
                str = TextUtils.isEmpty(str) ? str2 : this.f5025o.getString(R.string.exo_item_list, str, str2);
            }
        }
        return str;
    }

    @Override // f6.b
    public y r(y yVar, h hVar) {
        if (yVar == null) {
            return null;
        }
        return new e(this.f5025o, yVar);
    }
}
