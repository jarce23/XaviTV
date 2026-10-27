package f;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallerInitializer;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4800o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Context f4801p;

    public /* synthetic */ l(Context context, int i10) {
        this.f4800o = i10;
        this.f4801p = context;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00c2, code lost:
    
        if (r2 != null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cf  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r11 = this;
            int r0 = r11.f4800o
            switch(r0) {
                case 0: goto L67;
                case 1: goto L30;
                case 2: goto L14;
                default: goto L5;
            }
        L5:
            i2.a r0 = new i2.a
            r1 = 2
            r0.<init>(r1)
            j9.w1 r1 = z3.c.f14068a
            r2 = 0
            android.content.Context r3 = r11.f4801p
            z3.c.s(r3, r0, r1, r2)
            return
        L14:
            java.util.concurrent.ThreadPoolExecutor r4 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4.<init>(r5, r6, r7, r9, r10)
            f.l r0 = new f.l
            r1 = 3
            android.content.Context r2 = r11.f4801p
            r0.<init>(r2, r1)
            r4.execute(r0)
            return
        L30:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto L3f
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            android.os.Handler r0 = z3.e.a(r0)
            goto L48
        L3f:
            android.os.Handler r0 = new android.os.Handler
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            r0.<init>(r1)
        L48:
            java.util.Random r1 = new java.util.Random
            r1.<init>()
            r2 = 1000(0x3e8, float:1.401E-42)
            r3 = 1
            int r2 = java.lang.Math.max(r2, r3)
            int r1 = r1.nextInt(r2)
            f.l r2 = new f.l
            r3 = 2
            android.content.Context r4 = r11.f4801p
            r2.<init>(r4, r3)
            int r1 = r1 + 5000
            long r3 = (long) r1
            r0.postDelayed(r2, r3)
            return
        L67:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 1
            r2 = 33
            if (r0 < r2) goto Le7
            android.content.ComponentName r3 = new android.content.ComponentName
            java.lang.String r4 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            android.content.Context r5 = r11.f4801p
            r3.<init>(r5, r4)
            android.content.pm.PackageManager r4 = r5.getPackageManager()
            int r4 = r4.getComponentEnabledSetting(r3)
            if (r4 == r1) goto Le7
            java.lang.String r4 = "locale"
            if (r0 < r2) goto Lc0
            p.f r0 = f.q.f4842u
            r0.getClass()
            p.a r2 = new p.a
            r2.<init>(r0)
        L8f:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto Lae
            java.lang.Object r0 = r2.next()
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0
            java.lang.Object r0 = r0.get()
            f.q r0 = (f.q) r0
            if (r0 == 0) goto L8f
            f.b0 r0 = (f.b0) r0
            android.content.Context r0 = r0.f4742y
            if (r0 == 0) goto L8f
            java.lang.Object r0 = r0.getSystemService(r4)
            goto Laf
        Lae:
            r0 = 0
        Laf:
            if (r0 == 0) goto Lc5
            android.os.LocaleList r0 = f.n.a(r0)
            i0.f r2 = new i0.f
            i0.i r6 = new i0.i
            r6.<init>(r0)
            r2.<init>(r6)
            goto Lc7
        Lc0:
            i0.f r2 = f.q.f4838q
            if (r2 == 0) goto Lc5
            goto Lc7
        Lc5:
            i0.f r2 = i0.f.f5784b
        Lc7:
            i0.h r0 = r2.f5785a
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto Le0
            java.lang.String r0 = b0.c.e(r5)
            java.lang.Object r2 = r5.getSystemService(r4)
            if (r2 == 0) goto Le0
            android.os.LocaleList r0 = f.m.a(r0)
            f.n.b(r2, r0)
        Le0:
            android.content.pm.PackageManager r0 = r5.getPackageManager()
            r0.setComponentEnabledSetting(r3, r1, r1)
        Le7:
            f.q.f4841t = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.l.run():void");
    }

    public /* synthetic */ l(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f4800o = 1;
        this.f4801p = context;
    }
}
