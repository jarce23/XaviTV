package j7;

import android.content.Intent;
import android.support.v4.media.session.s;
import android.view.KeyEvent;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import g7.p;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends s {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j f7158f;

    public i(j jVar) {
        this.f7158f = jVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.support.v4.media.session.s
    public final void b(String str) {
        j.f7159v.b("onCustomAction with action = %s", str);
        int hashCode = str.hashCode();
        j jVar = this.f7158f;
        switch (hashCode) {
            case -1699820260:
                if (str.equals(MediaIntentReceiver.ACTION_REWIND)) {
                    long j10 = -jVar.f7164e.f6486q;
                    i7.h hVar = jVar.f7172n;
                    if (hVar == null) {
                        return;
                    }
                    long min = Math.min(hVar.f(), Math.max(0L, hVar.a() + j10));
                    i7.h hVar2 = jVar.f7172n;
                    if (hVar2 == null) {
                        return;
                    }
                    hVar2.r(new p(min));
                    return;
                }
                break;
            case -668151673:
                if (str.equals(MediaIntentReceiver.ACTION_STOP_CASTING)) {
                    h7.i iVar = jVar.f7163d;
                    if (iVar != null) {
                        iVar.b(true);
                        return;
                    }
                    return;
                }
                break;
            case -124479363:
                if (str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                    h7.i iVar2 = jVar.f7163d;
                    if (iVar2 != null) {
                        iVar2.b(false);
                        return;
                    }
                    return;
                }
                break;
            case 1362116196:
                if (str.equals(MediaIntentReceiver.ACTION_FORWARD)) {
                    long j11 = jVar.f7164e.f6486q;
                    i7.h hVar3 = jVar.f7172n;
                    if (hVar3 == null) {
                        return;
                    }
                    long min2 = Math.min(hVar3.f(), Math.max(0L, hVar3.a() + j11));
                    i7.h hVar4 = jVar.f7172n;
                    if (hVar4 == null) {
                        return;
                    }
                    hVar4.r(new p(min2));
                    return;
                }
                break;
        }
        Intent intent = new Intent(str);
        intent.setComponent(jVar.g);
        jVar.f7160a.sendBroadcast(intent);
    }

    @Override // android.support.v4.media.session.s
    public final boolean c(Intent intent) {
        i7.h hVar;
        j.f7159v.b("onMediaButtonEvent", new Object[0]);
        KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
        if (keyEvent == null) {
            return true;
        }
        if ((keyEvent.getKeyCode() != 127 && keyEvent.getKeyCode() != 126) || (hVar = this.f7158f.f7172n) == null) {
            return true;
        }
        hVar.s();
        return true;
    }

    @Override // android.support.v4.media.session.s
    public final void d() {
        j.f7159v.b("onPause", new Object[0]);
        i7.h hVar = this.f7158f.f7172n;
        if (hVar != null) {
            hVar.s();
        }
    }

    @Override // android.support.v4.media.session.s
    public final void e() {
        j.f7159v.b("onPlay", new Object[0]);
        i7.h hVar = this.f7158f.f7172n;
        if (hVar != null) {
            hVar.s();
        }
    }

    @Override // android.support.v4.media.session.s
    public final void f(long j10) {
        j.f7159v.b("onSeekTo %d", Long.valueOf(j10));
        i7.h hVar = this.f7158f.f7172n;
        if (hVar == null) {
            return;
        }
        hVar.r(new p(j10));
    }

    @Override // android.support.v4.media.session.s
    public final void g() {
        j.f7159v.b("onSkipToNext", new Object[0]);
        i7.h hVar = this.f7158f.f7172n;
        if (hVar != null) {
            r.b();
            if (hVar.x()) {
                i7.h.y(new i7.i(hVar, 2));
            } else {
                i7.h.u();
            }
        }
    }

    @Override // android.support.v4.media.session.s
    public final void h() {
        j.f7159v.b("onSkipToPrevious", new Object[0]);
        i7.h hVar = this.f7158f.f7172n;
        if (hVar != null) {
            r.b();
            if (hVar.x()) {
                i7.h.y(new i7.i(hVar, 1));
            } else {
                i7.h.u();
            }
        }
    }
}
