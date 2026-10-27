package r7;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements Handler.Callback {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ d0 f10884o;

    public /* synthetic */ c0(d0 d0Var) {
        this.f10884o = d0Var;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            d0 d0Var = this.f10884o;
            synchronized (d0Var.f10899a) {
                try {
                    a0 a0Var = (a0) message.obj;
                    b0 b0Var = (b0) d0Var.f10899a.get(a0Var);
                    if (b0Var != null && b0Var.f10872a.isEmpty()) {
                        if (b0Var.f10874c) {
                            a0 a0Var2 = b0Var.f10876e;
                            d0 d0Var2 = b0Var.g;
                            d0Var2.f10901c.removeMessages(1, a0Var2);
                            d0Var2.f10902d.a(d0Var2.f10900b, b0Var);
                            b0Var.f10874c = false;
                            b0Var.f10873b = 2;
                        }
                        d0Var.f10899a.remove(a0Var);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i10 != 1) {
            return false;
        }
        d0 d0Var3 = this.f10884o;
        synchronized (d0Var3.f10899a) {
            try {
                a0 a0Var3 = (a0) message.obj;
                b0 b0Var2 = (b0) d0Var3.f10899a.get(a0Var3);
                if (b0Var2 != null && b0Var2.f10873b == 3) {
                    String valueOf = String.valueOf(a0Var3);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
                    sb2.append("Timeout waiting for ServiceConnection callback ");
                    sb2.append(valueOf);
                    Log.e("GmsClientSupervisor", sb2.toString(), new Exception());
                    ComponentName componentName = b0Var2.f10877f;
                    if (componentName == null) {
                        a0Var3.getClass();
                        componentName = null;
                    }
                    if (componentName == null) {
                        String str = a0Var3.f10870b;
                        r.e(str);
                        componentName = new ComponentName(str, "unknown");
                    }
                    b0Var2.onServiceDisconnected(componentName);
                }
            } finally {
            }
        }
        return true;
    }
}
