package m;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e2 extends z1 implements a2 {
    public static final Method S;
    public h5.i R;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                S = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // m.a2
    public final void m(l.l lVar, l.n nVar) {
        h5.i iVar = this.R;
        if (iVar != null) {
            iVar.m(lVar, nVar);
        }
    }

    @Override // m.z1
    public final o1 p(Context context, boolean z10) {
        d2 d2Var = new d2(context, z10);
        d2Var.setHoverListener(this);
        return d2Var;
    }

    @Override // m.a2
    public final void q(l.l lVar, MenuItem menuItem) {
        h5.i iVar = this.R;
        if (iVar != null) {
            iVar.q(lVar, menuItem);
        }
    }
}
