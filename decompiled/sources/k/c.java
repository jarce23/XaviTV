package k;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f7521f;

    /* renamed from: a, reason: collision with root package name */
    public int f7522a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f7523b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f7524c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f7525d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f7526e;

    public c(Context context, int i10) {
        super(context);
        this.f7522a = i10;
    }

    public final void a(Configuration configuration) {
        if (this.f7526e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f7525d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f7525d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f7523b == null) {
            this.f7523b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f7523b.setTo(theme);
            }
        }
        this.f7523b.applyStyle(this.f7522a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
    
        if (r0.equals(k.c.f7521f) != false) goto L15;
     */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f7526e
            if (r0 != 0) goto L38
            android.content.res.Configuration r0 = r3.f7525d
            if (r0 == 0) goto L32
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L25
            android.content.res.Configuration r1 = k.c.f7521f
            if (r1 != 0) goto L1c
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            k.c.f7521f = r1
        L1c:
            android.content.res.Configuration r1 = k.c.f7521f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L25
            goto L32
        L25:
            android.content.res.Configuration r0 = r3.f7525d
            android.content.Context r0 = r3.createConfigurationContext(r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f7526e = r0
            goto L38
        L32:
            android.content.res.Resources r0 = super.getResources()
            r3.f7526e = r0
        L38:
            android.content.res.Resources r0 = r3.f7526e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k.c.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f7524c == null) {
            this.f7524c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f7524c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f7523b;
        if (theme != null) {
            return theme;
        }
        if (this.f7522a == 0) {
            this.f7522a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f7523b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i10) {
        if (this.f7522a != i10) {
            this.f7522a = i10;
            b();
        }
    }
}
