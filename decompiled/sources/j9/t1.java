package j9;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class t1 {

    /* renamed from: e, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7446e = new androidx.emoji2.text.s("AssetPackManager", 3);

    /* renamed from: a, reason: collision with root package name */
    public final p f7447a;

    /* renamed from: b, reason: collision with root package name */
    public final m f7448b;

    /* renamed from: c, reason: collision with root package name */
    public final k9.e f7449c;

    /* renamed from: d, reason: collision with root package name */
    public final k9.e f7450d;

    public t1(p pVar, k9.e eVar, m mVar, k9.e eVar2) {
        new Handler(Looper.getMainLooper());
        this.f7447a = pVar;
        this.f7449c = eVar;
        this.f7448b = mVar;
        this.f7450d = eVar2;
    }

    public final void a(boolean z10) {
        com.bumptech.glide.manager.q qVar;
        m mVar = this.f7448b;
        synchronized (mVar) {
            qVar = mVar.f7361e;
        }
        boolean z11 = qVar != null;
        mVar.c(z10);
        if (!z10 || z11) {
            return;
        }
        ((Executor) this.f7450d.c()).execute(new androidx.activity.j(23, this));
    }
}
