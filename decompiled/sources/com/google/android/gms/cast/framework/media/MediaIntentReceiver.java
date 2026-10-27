package com.google.android.gms.cast.framework.media;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.annotation.Keep;
import g7.p;
import h7.d;
import h7.i;
import i7.h;
import l7.b;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@Keep
/* loaded from: classes.dex */
public class MediaIntentReceiver extends BroadcastReceiver {
    public static final String ACTION_DISCONNECT = "com.google.android.gms.cast.framework.action.DISCONNECT";
    public static final String ACTION_FORWARD = "com.google.android.gms.cast.framework.action.FORWARD";
    public static final String ACTION_REWIND = "com.google.android.gms.cast.framework.action.REWIND";
    public static final String ACTION_SKIP_NEXT = "com.google.android.gms.cast.framework.action.SKIP_NEXT";
    public static final String ACTION_SKIP_PREV = "com.google.android.gms.cast.framework.action.SKIP_PREV";
    public static final String ACTION_STOP_CASTING = "com.google.android.gms.cast.framework.action.STOP_CASTING";
    public static final String ACTION_TOGGLE_PLAYBACK = "com.google.android.gms.cast.framework.action.TOGGLE_PLAYBACK";
    public static final String EXTRA_SKIP_STEP_MS = "googlecast-extra_skip_step_ms";
    private static final String TAG = "MediaIntentReceiver";
    private static final b log = new b(TAG, null);

    private static h getRemoteMediaClient(d dVar) {
        if (dVar == null || !dVar.a()) {
            return null;
        }
        r.b();
        return dVar.f5733j;
    }

    private void seek(d dVar, long j10) {
        h remoteMediaClient;
        if (j10 == 0 || (remoteMediaClient = getRemoteMediaClient(dVar)) == null || remoteMediaClient.i() || remoteMediaClient.m()) {
            return;
        }
        remoteMediaClient.r(new p(remoteMediaClient.a() + j10));
    }

    private void togglePlayback(d dVar) {
        h remoteMediaClient = getRemoteMediaClient(dVar);
        if (remoteMediaClient == null) {
            return;
        }
        remoteMediaClient.s();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        log.b("onReceive action: %s", action);
        if (action == null) {
            return;
        }
        h7.b a10 = h7.b.a(context);
        a10.getClass();
        r.b();
        i iVar = a10.f5702c;
        h7.h d6 = iVar.d();
        if (d6 != null) {
            switch (action.hashCode()) {
                case -1699820260:
                    if (action.equals(ACTION_REWIND)) {
                        onReceiveActionRewind(d6, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                        return;
                    }
                    break;
                case -945151566:
                    if (action.equals(ACTION_SKIP_NEXT)) {
                        onReceiveActionSkipNext(d6);
                        return;
                    }
                    break;
                case -945080078:
                    if (action.equals(ACTION_SKIP_PREV)) {
                        onReceiveActionSkipPrev(d6);
                        return;
                    }
                    break;
                case -668151673:
                    if (action.equals(ACTION_STOP_CASTING)) {
                        iVar.b(true);
                        return;
                    }
                    break;
                case -124479363:
                    if (action.equals(ACTION_DISCONNECT)) {
                        iVar.b(false);
                        return;
                    }
                    break;
                case 235550565:
                    if (action.equals(ACTION_TOGGLE_PLAYBACK)) {
                        onReceiveActionTogglePlayback(d6);
                        return;
                    }
                    break;
                case 1362116196:
                    if (action.equals(ACTION_FORWARD)) {
                        onReceiveActionForward(d6, intent.getLongExtra(EXTRA_SKIP_STEP_MS, 0L));
                        return;
                    }
                    break;
                case 1997055314:
                    if (action.equals("android.intent.action.MEDIA_BUTTON")) {
                        onReceiveActionMediaButton(d6, intent);
                        return;
                    }
                    break;
            }
            onReceiveOtherAction(context, action, intent);
        }
    }

    public void onReceiveActionForward(h7.h hVar, long j10) {
        if (hVar instanceof d) {
            seek((d) hVar, j10);
        }
    }

    public void onReceiveActionMediaButton(h7.h hVar, Intent intent) {
        if ((hVar instanceof d) && intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Bundle extras = intent.getExtras();
            r.e(extras);
            KeyEvent keyEvent = (KeyEvent) extras.get("android.intent.extra.KEY_EVENT");
            if (keyEvent != null && keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 85) {
                togglePlayback((d) hVar);
            }
        }
    }

    public void onReceiveActionRewind(h7.h hVar, long j10) {
        if (hVar instanceof d) {
            seek((d) hVar, -j10);
        }
    }

    public void onReceiveActionSkipNext(h7.h hVar) {
        h remoteMediaClient;
        if (!(hVar instanceof d) || (remoteMediaClient = getRemoteMediaClient((d) hVar)) == null || remoteMediaClient.m()) {
            return;
        }
        r.b();
        if (remoteMediaClient.x()) {
            h.y(new i7.i(remoteMediaClient, 2));
        } else {
            h.u();
        }
    }

    public void onReceiveActionSkipPrev(h7.h hVar) {
        h remoteMediaClient;
        if (!(hVar instanceof d) || (remoteMediaClient = getRemoteMediaClient((d) hVar)) == null || remoteMediaClient.m()) {
            return;
        }
        r.b();
        if (remoteMediaClient.x()) {
            h.y(new i7.i(remoteMediaClient, 1));
        } else {
            h.u();
        }
    }

    public void onReceiveActionTogglePlayback(h7.h hVar) {
        if (hVar instanceof d) {
            togglePlayback((d) hVar);
        }
    }

    public void onReceiveOtherAction(Context context, String str, Intent intent) {
    }

    @Deprecated
    public void onReceiveOtherAction(String str, Intent intent) {
        onReceiveOtherAction(null, str, intent);
    }
}
