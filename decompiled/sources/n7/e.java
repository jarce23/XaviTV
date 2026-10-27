package n7;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static final int f9228a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f9229b;

    static {
        int i10 = h.f9232c;
        f9228a = 12451000;
        f9229b = new e();
    }

    public static void c(Context context) {
        int i10 = h.f9232c;
        e eVar = f9229b;
        int b2 = eVar.b(context, 11925000);
        if (b2 != 0) {
            Intent a10 = eVar.a(b2, context, "e");
            StringBuilder sb2 = new StringBuilder(String.valueOf(b2).length() + 46);
            sb2.append("GooglePlayServices not available due to error ");
            sb2.append(b2);
            Log.e("GooglePlayServicesUtil", sb2.toString());
            if (a10 != null) {
                throw new g("Google Play Services not available");
            }
            throw new f();
        }
    }

    public Intent a(int i10, Context context, String str) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(fromParts);
            return intent;
        }
        if (context != null && x4.f.D(context)) {
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        }
        StringBuilder sb2 = new StringBuilder("gcore_");
        sb2.append(f9228a);
        sb2.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append("-");
        if (context != null) {
            sb2.append(context.getPackageName());
        }
        sb2.append("-");
        if (context != null) {
            try {
                androidx.emoji2.text.o a10 = w7.c.a(context);
                sb2.append(a10.f591o.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        String sb3 = sb2.toString();
        Intent intent3 = new Intent("android.intent.action.VIEW");
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
        if (!TextUtils.isEmpty(sb3)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", sb3);
        }
        intent3.setData(appendQueryParameter.build());
        intent3.setPackage("com.android.vending");
        intent3.addFlags(524288);
        return intent3;
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0256 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0257 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int b(android.content.Context r10, int r11) {
        /*
            Method dump skipped, instructions count: 606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.e.b(android.content.Context, int):int");
    }
}
