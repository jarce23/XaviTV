package androidx.mediarouter.app;

import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import okhttp3.internal.http2.Http2;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements View.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f1344o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ s f1345p;

    public /* synthetic */ n(s sVar, int i10) {
        this.f1344o = i10;
        this.f1345p = sVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10;
        PlaybackStateCompat playbackStateCompat;
        PendingIntent sessionActivity;
        switch (this.f1344o) {
            case 0:
                s sVar = this.f1345p;
                Context context = sVar.f1410x;
                AccessibilityManager accessibilityManager = sVar.B0;
                int id = view.getId();
                if (id != 16908313 && id != 16908314) {
                    if (id != R.id.mr_control_playback_ctrl) {
                        if (id == R.id.mr_close) {
                            sVar.dismiss();
                            break;
                        }
                    } else {
                        x4.l lVar = sVar.f1391g0;
                        if (lVar != null && (playbackStateCompat = sVar.f1392i0) != null) {
                            int i11 = 0;
                            i10 = playbackStateCompat.f209o != 3 ? 0 : 1;
                            if (i10 != 0 && (playbackStateCompat.f213s & 514) != 0) {
                                lVar.k().f250a.pause();
                                i11 = R.string.mr_controller_pause;
                            } else if (i10 != 0 && (playbackStateCompat.f213s & 1) != 0) {
                                lVar.k().f250a.stop();
                                i11 = R.string.mr_controller_stop;
                            } else if (i10 == 0 && (playbackStateCompat.f213s & 516) != 0) {
                                lVar.k().f250a.play();
                                i11 = R.string.mr_controller_play;
                            }
                            if (accessibilityManager != null && accessibilityManager.isEnabled() && i11 != 0) {
                                AccessibilityEvent obtain = AccessibilityEvent.obtain(Http2.INITIAL_MAX_FRAME_SIZE);
                                obtain.setPackageName(context.getPackageName());
                                obtain.setClassName(n.class.getName());
                                obtain.getText().add(context.getString(i11));
                                accessibilityManager.sendAccessibilityEvent(obtain);
                                break;
                            }
                        }
                    }
                } else {
                    if (sVar.f1408w.g()) {
                        w3.b0 b0Var = sVar.f1404u;
                        i10 = id == 16908313 ? 2 : 1;
                        b0Var.getClass();
                        w3.b0.j(i10);
                    }
                    sVar.dismiss();
                    break;
                }
                break;
            case 1:
                s sVar2 = this.f1345p;
                boolean z10 = sVar2.f1402s0;
                sVar2.f1402s0 = !z10;
                if (!z10) {
                    sVar2.S.setVisibility(0);
                }
                sVar2.f1413y0 = sVar2.f1402s0 ? sVar2.f1415z0 : sVar2.A0;
                sVar2.t(true);
                break;
            case 2:
                this.f1345p.dismiss();
                break;
            default:
                s sVar3 = this.f1345p;
                x4.l lVar2 = sVar3.f1391g0;
                if (lVar2 != null && (sessionActivity = ((android.support.v4.media.session.h) lVar2.f13561o).f245a.getSessionActivity()) != null) {
                    try {
                        sessionActivity.send();
                        sVar3.dismiss();
                        break;
                    } catch (PendingIntent.CanceledException unused) {
                        Log.e("MediaRouteCtrlDialog", sessionActivity + " was not sent, it had been canceled.");
                    }
                }
                break;
        }
    }
}
