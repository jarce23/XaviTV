package androidx.activity;

import android.app.Notification;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.Typeface;
import android.support.v4.media.session.a0;
import android.view.View;
import android.widget.TextView;
import androidx.work.impl.foreground.SystemForegroundService;
import com.google.android.gms.internal.cast.a6;
import com.google.android.gms.internal.cast.d6;
import com.google.android.gms.internal.cast.l0;
import com.google.android.gms.internal.cast.m1;
import com.google.android.gms.internal.cast.n1;
import com.google.android.gms.internal.cast.p5;
import com.google.android.gms.internal.cast.u4;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import j9.g1;
import j9.y0;
import java.io.IOException;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f296o;

    /* renamed from: p, reason: collision with root package name */
    public final int f297p;

    /* renamed from: q, reason: collision with root package name */
    public final Object f298q;

    /* renamed from: r, reason: collision with root package name */
    public final Object f299r;

    public /* synthetic */ h(y0 y0Var, int i10, String str) {
        this.f296o = 4;
        this.f299r = y0Var;
        this.f297p = i10;
        this.f298q = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f296o) {
            case 0:
                i iVar = (i) this.f298q;
                int i10 = this.f297p;
                Object obj = ((d.a) this.f299r).f3948a;
                String str = (String) iVar.f341a.get(Integer.valueOf(i10));
                if (str == null) {
                    return;
                }
                androidx.activity.result.e eVar = (androidx.activity.result.e) iVar.f345e.get(str);
                if (eVar == null) {
                    iVar.g.remove(str);
                    iVar.f346f.put(str, obj);
                    return;
                } else {
                    androidx.activity.result.b bVar = eVar.f337a;
                    if (iVar.f344d.remove(str)) {
                        bVar.c(obj);
                        return;
                    }
                    return;
                }
            case 1:
                ((i) this.f298q).a(this.f297p, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) this.f299r));
                return;
            case 2:
                com.google.android.gms.internal.cast.q qVar = (com.google.android.gms.internal.cast.q) this.f299r;
                w3.o oVar = (w3.o) this.f298q;
                int i11 = this.f297p;
                synchronized (qVar.f3435f) {
                    qVar.z0(oVar, i11);
                }
                return;
            case 3:
                l0 l0Var = (l0) this.f299r;
                n1 n1Var = (n1) this.f298q;
                int i12 = this.f297p;
                m1 n10 = n1.n(n1Var);
                String str2 = l0Var.f3361d;
                n10.c();
                n1.v((n1) n10.f3641p, str2);
                n10.c();
                n1.w((n1) n10.f3641p, str2);
                Long l10 = l0Var.f3362e;
                if (l10 != null) {
                    int longValue = (int) l10.longValue();
                    n10.c();
                    n1.x((n1) n10.f3641p, longValue);
                }
                n1 n1Var2 = (n1) n10.a();
                int i13 = l0Var.f3364h;
                int i14 = i13 - 1;
                p6.a aVar = null;
                if (i13 == 0) {
                    throw null;
                }
                if (i14 == 0) {
                    aVar = new p6.a(Integer.valueOf(i12 - 1), n1Var2, p6.c.f10026p);
                } else if (i14 == 1) {
                    aVar = new p6.a(Integer.valueOf(i12 - 1), n1Var2, p6.c.f10025o);
                }
                l0.f3356i.b("analytics event: %s", aVar);
                r7.r.e(aVar);
                x4.m mVar = l0Var.g;
                if (mVar != null) {
                    h3.b bVar2 = new h3.b(19);
                    s6.o oVar2 = (s6.o) mVar.f13566r;
                    s6.i iVar2 = (s6.i) mVar.f13564p;
                    p6.b bVar3 = (p6.b) mVar.f13565q;
                    y6.b bVar4 = oVar2.f11628c;
                    p6.c cVar = aVar.f10023c;
                    a0 a10 = s6.i.a();
                    a10.X(iVar2.f11611a);
                    a10.f232r = cVar;
                    a10.f231q = iVar2.f11612b;
                    s6.i B = a10.B();
                    g1 g1Var = new g1();
                    g1Var.f7295t = new HashMap();
                    g1Var.f7293r = Long.valueOf(oVar2.f11626a.h());
                    g1Var.f7294s = Long.valueOf(oVar2.f11627b.h());
                    g1Var.f7290o = "CAST_SENDER_SDK";
                    n1 n1Var3 = aVar.f10022b;
                    try {
                        int i15 = n1Var3.i();
                        byte[] bArr = new byte[i15];
                        u4 u4Var = new u4(i15, bArr);
                        d6 a11 = a6.f3253c.a(n1.class);
                        p5 p5Var = u4Var.f3491d;
                        if (p5Var == null) {
                            p5Var = new p5(u4Var);
                        }
                        a11.c(n1Var3, p5Var);
                        if (i15 - u4Var.g != 0) {
                            throw new IllegalStateException("Did not write as much data as expected.");
                        }
                        g1Var.f7292q = new s6.k(bVar3, bArr);
                        g1Var.f7291p = aVar.f10021a;
                        y6.a aVar2 = (y6.a) bVar4;
                        aVar2.f13889b.execute(new androidx.emoji2.text.m(aVar2, B, bVar2, g1Var.g()));
                        return;
                    } catch (IOException e7) {
                        throw new RuntimeException(android.support.v4.media.d.q("Serializing ", n1.class.getName(), " to a byte array threw an IOException (should never happen)."), e7);
                    }
                }
                return;
            case 4:
                try {
                    ((y0) this.f299r).g(this.f297p, (String) this.f298q);
                    return;
                } catch (m9.a e8) {
                    y0.f7490f.i("notifyModuleCompleted failed", e8);
                    return;
                }
            case 5:
                ((TextView) this.f299r).setTypeface((Typeface) this.f298q, this.f297p);
                return;
            case 6:
                ((BottomSheetBehavior) this.f298q).E((View) this.f299r, this.f297p, false);
                return;
            case 7:
                ((r4.i) this.f299r).a((Intent) this.f298q, this.f297p);
                return;
            default:
                ((SystemForegroundService) this.f298q).f1554s.notify(this.f297p, (Notification) this.f299r);
                return;
        }
    }

    public /* synthetic */ h(Object obj, int i10, Object obj2, int i11) {
        this.f296o = i11;
        this.f298q = obj;
        this.f297p = i10;
        this.f299r = obj2;
    }

    public /* synthetic */ h(Object obj, Object obj2, int i10, int i11) {
        this.f296o = i11;
        this.f299r = obj;
        this.f298q = obj2;
        this.f297p = i10;
    }

    public h(BottomSheetBehavior bottomSheetBehavior, View view, int i10) {
        this.f296o = 6;
        this.f298q = bottomSheetBehavior;
        this.f299r = view;
        this.f297p = i10;
    }
}
