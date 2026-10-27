package r7;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u extends b8.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.internal.a f10956a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(com.google.android.gms.common.internal.a aVar, Looper looper) {
        super(looper, 1);
        this.f10956a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        p pVar;
        com.google.android.gms.common.internal.a aVar = this.f10956a;
        if (aVar.f3231x.get() != message.arg1) {
            int i10 = message.what;
            if ((i10 == 2 || i10 == 1 || i10 == 7) && (pVar = (p) message.obj) != null) {
                pVar.c();
                return;
            }
            return;
        }
        int i11 = message.what;
        if ((i11 == 1 || i11 == 7 || i11 == 4 || i11 == 5) && !aVar.o()) {
            p pVar2 = (p) message.obj;
            if (pVar2 != null) {
                pVar2.c();
                return;
            }
            return;
        }
        int i12 = message.what;
        if (i12 == 4) {
            aVar.f3228u = new n7.a(message.arg2, null, null);
            if (!aVar.f3229v && !TextUtils.isEmpty(aVar.k()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.k());
                    if (!aVar.f3229v) {
                        aVar.u(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            n7.a aVar2 = aVar.f3228u;
            if (aVar2 == null) {
                aVar2 = new n7.a(8, null, null);
            }
            aVar.f3217j.a(aVar2);
            aVar.p(aVar2);
            return;
        }
        if (i12 == 5) {
            n7.a aVar3 = aVar.f3228u;
            if (aVar3 == null) {
                aVar3 = new n7.a(8, null, null);
            }
            aVar.f3217j.a(aVar3);
            aVar.p(aVar3);
            return;
        }
        if (i12 == 3) {
            Object obj = message.obj;
            n7.a aVar4 = new n7.a(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null, null);
            aVar.f3217j.a(aVar4);
            aVar.p(aVar4);
            return;
        }
        if (i12 == 6) {
            aVar.u(5, null);
            g gVar = aVar.f3222o;
            if (gVar != null) {
                ((o7.g) gVar.f10916a).v(message.arg2);
            }
            System.currentTimeMillis();
            aVar.s(5, 1, null);
            return;
        }
        if (i12 == 2 && !aVar.n()) {
            p pVar3 = (p) message.obj;
            if (pVar3 != null) {
                pVar3.c();
                return;
            }
            return;
        }
        int i13 = message.what;
        if (i13 != 2 && i13 != 1 && i13 != 7) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i13).length() + 34);
            sb2.append("Don't know how to handle message: ");
            sb2.append(i13);
            Log.wtf("GmsClient", sb2.toString(), new Exception());
            return;
        }
        p pVar4 = (p) message.obj;
        synchronized (pVar4) {
            try {
                bool = pVar4.f10944a;
                if (pVar4.f10945b) {
                    String obj2 = pVar4.toString();
                    StringBuilder sb3 = new StringBuilder(obj2.length() + 47);
                    sb3.append("Callback proxy ");
                    sb3.append(obj2);
                    sb3.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb3.toString());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            com.google.android.gms.common.internal.a aVar5 = pVar4.f10949f;
            int i14 = pVar4.f10947d;
            if (i14 != 0) {
                aVar5.u(1, null);
                Bundle bundle = pVar4.f10948e;
                pVar4.b(new n7.a(i14, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null, null));
            } else if (!pVar4.a()) {
                aVar5.u(1, null);
                pVar4.b(new n7.a(8, null, null));
            }
        }
        synchronized (pVar4) {
            pVar4.f10945b = true;
        }
        pVar4.c();
    }
}
