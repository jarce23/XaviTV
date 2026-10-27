package h7;

import android.content.Context;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.internal.cast.j4;
import com.google.android.gms.internal.cast.u5;
import java.lang.reflect.Field;
import java.util.HashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends h {

    /* renamed from: m, reason: collision with root package name */
    public static final l7.b f5726m = new l7.b("CastSession", null);

    /* renamed from: c, reason: collision with root package name */
    public final Context f5727c;

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f5728d;

    /* renamed from: e, reason: collision with root package name */
    public final r f5729e;

    /* renamed from: f, reason: collision with root package name */
    public final c f5730f;
    public final com.google.android.gms.internal.cast.q g;

    /* renamed from: h, reason: collision with root package name */
    public final j7.j f5731h;

    /* renamed from: i, reason: collision with root package name */
    public g7.e0 f5732i;

    /* renamed from: j, reason: collision with root package name */
    public i7.h f5733j;

    /* renamed from: k, reason: collision with root package name */
    public CastDevice f5734k;

    /* renamed from: l, reason: collision with root package name */
    public j4 f5735l;

    public d(Context context, String str, String str2, c cVar, com.google.android.gms.internal.cast.q qVar, j7.j jVar) {
        super(context, str, str2);
        this.f5728d = new HashSet();
        this.f5727c = context.getApplicationContext();
        this.f5730f = cVar;
        this.g = qVar;
        this.f5731h = jVar;
        x7.a d6 = d();
        a0 a0Var = new a0(this);
        l7.b bVar = com.google.android.gms.internal.cast.d.f3291a;
        r rVar = null;
        if (d6 != null) {
            try {
                rVar = com.google.android.gms.internal.cast.d.b(context).A0(cVar, d6, a0Var);
            } catch (RemoteException | e e7) {
                com.google.android.gms.internal.cast.d.f3291a.a(e7, "Unable to call %s on %s.", "newCastSessionImpl", com.google.android.gms.internal.cast.f.class.getSimpleName());
            }
        }
        this.f5729e = rVar;
    }

    public static void e(d dVar, int i10) {
        j7.j jVar = dVar.f5731h;
        if (jVar.f7175q) {
            jVar.f7175q = false;
            i7.h hVar = jVar.f7172n;
            if (hVar != null) {
                f0 f0Var = jVar.f7171m;
                r7.r.b();
                if (f0Var != null) {
                    hVar.f6504i.remove(f0Var);
                }
            }
            jVar.f7162c.y0(null);
            u5 u5Var = jVar.f7166h;
            if (u5Var != null) {
                u5Var.d();
                u5Var.f3498s = null;
            }
            u5 u5Var2 = jVar.f7167i;
            if (u5Var2 != null) {
                u5Var2.d();
                u5Var2.f3498s = null;
            }
            android.support.v4.media.session.a0 a0Var = jVar.f7174p;
            if (a0Var != null) {
                a0Var.Y(null, null);
                jVar.f7174p.Z(new MediaMetadataCompat(new Bundle()));
                jVar.j(0, null);
            }
            android.support.v4.media.session.a0 a0Var2 = jVar.f7174p;
            if (a0Var2 != null) {
                a0Var2.W(false);
                android.support.v4.media.session.u uVar = (android.support.v4.media.session.u) jVar.f7174p.f230p;
                MediaSession mediaSession = uVar.f261a;
                uVar.f264d = true;
                uVar.f265e.kill();
                if (Build.VERSION.SDK_INT == 27) {
                    try {
                        Field declaredField = mediaSession.getClass().getDeclaredField("mCallback");
                        declaredField.setAccessible(true);
                        Handler handler = (Handler) declaredField.get(mediaSession);
                        if (handler != null) {
                            handler.removeCallbacksAndMessages(null);
                        }
                    } catch (Exception e7) {
                        Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e7);
                    }
                }
                mediaSession.setCallback(null);
                mediaSession.release();
                jVar.f7174p = null;
            }
            jVar.f7172n = null;
            jVar.f7173o = null;
            jVar.h();
            if (i10 == 0) {
                jVar.i();
            }
        }
        g7.e0 e0Var = dVar.f5732i;
        if (e0Var != null) {
            e9.d b2 = e9.d.b();
            b2.f4677d = g7.z.f5320p;
            b2.f4675b = 8403;
            e0Var.c(1, b2.a());
            e0Var.g();
            e0Var.f(e0Var.f5206k);
            dVar.f5732i = null;
        }
        dVar.f5734k = null;
        i7.h hVar2 = dVar.f5733j;
        if (hVar2 != null) {
            hVar2.w(null);
            dVar.f5733j = null;
        }
    }

    public static void f(d dVar, String str, i8.i iVar) {
        l7.b bVar = f5726m;
        r rVar = dVar.f5729e;
        if (rVar == null) {
            return;
        }
        int i10 = 0;
        try {
            if (!iVar.n()) {
                Exception k10 = iVar.k();
                if (!(k10 instanceof o7.d)) {
                    p pVar = (p) rVar;
                    Parcel w02 = pVar.w0();
                    w02.writeInt(2476);
                    pVar.y0(w02, 5);
                    return;
                }
                int i11 = ((o7.d) k10).f9546o.f3193o;
                p pVar2 = (p) rVar;
                Parcel w03 = pVar2.w0();
                w03.writeInt(i11);
                pVar2.y0(w03, 5);
                return;
            }
            l7.u uVar = (l7.u) iVar.l();
            if (uVar.f8315o.f3193o > 0) {
                bVar.b("%s() -> failure result", str);
                int i12 = uVar.f8315o.f3193o;
                p pVar3 = (p) rVar;
                Parcel w04 = pVar3.w0();
                w04.writeInt(i12);
                pVar3.y0(w04, 5);
                return;
            }
            bVar.b("%s() -> success result", str);
            i7.h hVar = new i7.h(new l7.n());
            dVar.f5733j = hVar;
            hVar.w(dVar.f5732i);
            dVar.f5733j.q(new f0(i10, dVar));
            dVar.f5733j.v();
            j7.j jVar = dVar.f5731h;
            i7.h hVar2 = dVar.f5733j;
            r7.r.b();
            jVar.a(hVar2, dVar.f5734k);
            g7.d dVar2 = uVar.f8316p;
            r7.r.e(dVar2);
            String str2 = uVar.f8317q;
            String str3 = uVar.f8318r;
            r7.r.e(str3);
            boolean z10 = uVar.f8319s;
            p pVar4 = (p) rVar;
            Parcel w05 = pVar4.w0();
            com.google.android.gms.internal.cast.u.c(w05, dVar2);
            w05.writeString(str2);
            w05.writeString(str3);
            w05.writeInt(z10 ? 1 : 0);
            pVar4.y0(w05, 4);
        } catch (RemoteException e7) {
            bVar.a(e7, "Unable to call %s on %s.", "methods", r.class.getSimpleName());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(android.os.Bundle r10) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h7.d.g(android.os.Bundle):void");
    }
}
