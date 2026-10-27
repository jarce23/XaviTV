package j9;

import android.content.Context;
import android.content.pm.PackageManager;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: c, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7316c = new androidx.emoji2.text.s("PackageStateCache", 3);

    /* renamed from: a, reason: collision with root package name */
    public final Context f7317a;

    /* renamed from: b, reason: collision with root package name */
    public int f7318b = -1;

    public j1(Context context) {
        this.f7317a = context;
    }

    public final synchronized int a() {
        if (this.f7318b == -1) {
            try {
                this.f7318b = this.f7317a.getPackageManager().getPackageInfo(this.f7317a.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException unused) {
                f7316c.f("The current version of the app could not be retrieved", new Object[0]);
            }
        }
        return this.f7318b;
    }
}
