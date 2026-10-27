package b0;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.d0;
import androidx.lifecycle.f0;
import androidx.lifecycle.t;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e extends Activity implements androidx.lifecycle.r, m0.i {

    /* renamed from: o, reason: collision with root package name */
    public final t f2135o = new t(this);

    @Override // m0.i
    public final boolean c(KeyEvent keyEvent) {
        za.h.e("event", keyEvent);
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        za.h.e("event", keyEvent);
        View decorView = getWindow().getDecorView();
        za.h.d("getDecorView(...)", decorView);
        if (n4.a.l(decorView, keyEvent)) {
            return true;
        }
        return n4.a.m(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        za.h.e("event", keyEvent);
        View decorView = getWindow().getDecorView();
        za.h.d("getDecorView(...)", decorView);
        if (n4.a.l(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i10 = f0.f1126p;
        d0.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        za.h.e("outState", bundle);
        this.f2135o.g();
        super.onSaveInstanceState(bundle);
    }
}
