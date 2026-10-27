package androidx.activity;

import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements Executor, ViewTreeObserver.OnDrawListener, Runnable {

    /* renamed from: p, reason: collision with root package name */
    public Runnable f305p;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ f.j f307r;

    /* renamed from: o, reason: collision with root package name */
    public final long f304o = SystemClock.uptimeMillis() + 10000;

    /* renamed from: q, reason: collision with root package name */
    public boolean f306q = false;

    public m(f.j jVar) {
        this.f307r = jVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f305p = runnable;
        View decorView = this.f307r.getWindow().getDecorView();
        if (!this.f306q) {
            decorView.postOnAnimation(new d(1, this));
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            decorView.invalidate();
        } else {
            decorView.postInvalidate();
        }
    }

    @Override // android.view.ViewTreeObserver.OnDrawListener
    public final void onDraw() {
        boolean z10;
        Runnable runnable = this.f305p;
        if (runnable == null) {
            if (SystemClock.uptimeMillis() > this.f304o) {
                this.f306q = false;
                this.f307r.getWindow().getDecorView().post(this);
                return;
            }
            return;
        }
        runnable.run();
        this.f305p = null;
        com.bumptech.glide.manager.t tVar = this.f307r.f315w;
        synchronized (tVar.f3098c) {
            z10 = tVar.f3097b;
        }
        if (z10) {
            this.f306q = false;
            this.f307r.getWindow().getDecorView().post(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f307r.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
    }
}
