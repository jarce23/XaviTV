package android.support.v4.media.session;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: c, reason: collision with root package name */
    public boolean f256c;

    /* renamed from: e, reason: collision with root package name */
    public q f258e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f254a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final r f255b = new r(this);

    /* renamed from: d, reason: collision with root package name */
    public WeakReference f257d = new WeakReference(null);

    public final void a(u uVar, Handler handler) {
        if (this.f256c) {
            this.f256c = false;
            handler.removeMessages(1);
            PlaybackStateCompat d6 = uVar.d();
            long j10 = d6 == null ? 0L : d6.f213s;
            boolean z10 = d6 != null && d6.f209o == 3;
            boolean z11 = (516 & j10) != 0;
            boolean z12 = (j10 & 514) != 0;
            if (z10 && z12) {
                d();
            } else {
                if (z10 || !z11) {
                    return;
                }
                e();
            }
        }
    }

    public boolean c(Intent intent) {
        u uVar;
        q qVar;
        KeyEvent keyEvent;
        if (Build.VERSION.SDK_INT < 27) {
            synchronized (this.f254a) {
                uVar = (u) this.f257d.get();
                qVar = this.f258e;
            }
            if (uVar != null && qVar != null && (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) != null && keyEvent.getAction() == 0) {
                f1.a c10 = uVar.c();
                int keyCode = keyEvent.getKeyCode();
                if (keyCode != 79 && keyCode != 85) {
                    a(uVar, qVar);
                    return false;
                }
                if (keyEvent.getRepeatCount() != 0) {
                    a(uVar, qVar);
                    return true;
                }
                if (!this.f256c) {
                    this.f256c = true;
                    qVar.sendMessageDelayed(qVar.obtainMessage(1, c10), ViewConfiguration.getDoubleTapTimeout());
                    return true;
                }
                qVar.removeMessages(1);
                this.f256c = false;
                PlaybackStateCompat d6 = uVar.d();
                if (((d6 == null ? 0L : d6.f213s) & 32) != 0) {
                    g();
                }
                return true;
            }
        }
        return false;
    }

    public final void i(u uVar, Handler handler) {
        synchronized (this.f254a) {
            try {
                this.f257d = new WeakReference(uVar);
                q qVar = this.f258e;
                q qVar2 = null;
                if (qVar != null) {
                    qVar.removeCallbacksAndMessages(null);
                }
                if (uVar != null && handler != null) {
                    qVar2 = new q(this, handler.getLooper(), 0);
                }
                this.f258e = qVar2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void d() {
    }

    public void e() {
    }

    public void g() {
    }

    public void h() {
    }

    public void b(String str) {
    }

    public void f(long j10) {
    }
}
