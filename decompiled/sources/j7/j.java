package j7;

import a6.n;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.a0;
import android.support.v4.media.session.b0;
import android.support.v4.media.session.c0;
import android.support.v4.media.session.d0;
import android.support.v4.media.session.u;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.framework.ReconnectionService;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.internal.cast.q;
import com.google.android.gms.internal.cast.u5;
import g7.l;
import h7.f0;
import i7.o;
import java.util.ArrayList;
import java.util.List;
import org.chromium.net.R;
import r7.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: v, reason: collision with root package name */
    public static final l7.b f7159v = new l7.b("MediaSessionManager", null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f7160a;

    /* renamed from: b, reason: collision with root package name */
    public final h7.c f7161b;

    /* renamed from: c, reason: collision with root package name */
    public final q f7162c;

    /* renamed from: d, reason: collision with root package name */
    public final h7.i f7163d;

    /* renamed from: e, reason: collision with root package name */
    public final i7.f f7164e;

    /* renamed from: f, reason: collision with root package name */
    public final ComponentName f7165f;
    public final ComponentName g;

    /* renamed from: h, reason: collision with root package name */
    public final u5 f7166h;

    /* renamed from: i, reason: collision with root package name */
    public final u5 f7167i;

    /* renamed from: j, reason: collision with root package name */
    public final g f7168j;

    /* renamed from: k, reason: collision with root package name */
    public final b8.e f7169k;

    /* renamed from: l, reason: collision with root package name */
    public final androidx.activity.j f7170l;

    /* renamed from: m, reason: collision with root package name */
    public final f0 f7171m;

    /* renamed from: n, reason: collision with root package name */
    public i7.h f7172n;

    /* renamed from: o, reason: collision with root package name */
    public CastDevice f7173o;

    /* renamed from: p, reason: collision with root package name */
    public a0 f7174p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7175q;

    /* renamed from: r, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f7176r;

    /* renamed from: s, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f7177s;

    /* renamed from: t, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f7178t;

    /* renamed from: u, reason: collision with root package name */
    public PlaybackStateCompat.CustomAction f7179u;

    public j(Context context, h7.c cVar, q qVar) {
        h7.i iVar;
        i7.f fVar;
        this.f7160a = context;
        this.f7161b = cVar;
        this.f7162c = qVar;
        l7.b bVar = h7.b.f5697l;
        r.b();
        h7.b bVar2 = h7.b.f5699n;
        g gVar = null;
        if (bVar2 != null) {
            r.b();
            iVar = bVar2.f5702c;
        } else {
            iVar = null;
        }
        this.f7163d = iVar;
        i7.a aVar = cVar.f5717t;
        this.f7164e = aVar == null ? null : aVar.f6463r;
        this.f7171m = new f0(2, this);
        String str = aVar == null ? null : aVar.f6461p;
        this.f7165f = !TextUtils.isEmpty(str) ? new ComponentName(context, str) : null;
        String str2 = aVar == null ? null : aVar.f6460o;
        this.g = !TextUtils.isEmpty(str2) ? new ComponentName(context, str2) : null;
        u5 u5Var = new u5(context);
        this.f7166h = u5Var;
        u5Var.f3498s = new h(this, 0);
        u5 u5Var2 = new u5(context);
        this.f7167i = u5Var2;
        u5Var2.f3498s = new h(this, 1);
        this.f7169k = new b8.e(Looper.getMainLooper(), 2);
        l7.b bVar3 = g.f7136u;
        i7.a aVar2 = cVar.f5717t;
        if (aVar2 != null && (fVar = aVar2.f6463r) != null) {
            o oVar = fVar.T;
            if (oVar != null) {
                ArrayList a10 = k.a(oVar);
                int[] b2 = k.b(oVar);
                int size = a10 == null ? 0 : a10.size();
                if (a10 == null || a10.isEmpty()) {
                    Log.e(bVar3.f8271a, bVar3.d(i7.e.class.getSimpleName().concat(" doesn't provide any action."), new Object[0]));
                } else if (a10.size() > 5) {
                    Log.e(bVar3.f8271a, bVar3.d(i7.e.class.getSimpleName().concat(" provides more than 5 actions."), new Object[0]));
                } else if (b2 == null || (b2.length) == 0) {
                    Log.e(bVar3.f8271a, bVar3.d(i7.e.class.getSimpleName().concat(" doesn't provide any actions for compact view."), new Object[0]));
                } else {
                    for (int i10 : b2) {
                        if (i10 < 0 || i10 >= size) {
                            Log.e(bVar3.f8271a, bVar3.d(i7.e.class.getSimpleName().concat("provides a compact view action whose index is out of bounds."), new Object[0]));
                            break;
                        }
                    }
                }
            }
            gVar = new g(context);
        }
        this.f7168j = gVar;
        this.f7170l = new androidx.activity.j(20, this);
    }

    public final void a(i7.h hVar, CastDevice castDevice) {
        ComponentName componentName;
        h7.c cVar = this.f7161b;
        i7.a aVar = cVar == null ? null : cVar.f5717t;
        if (this.f7175q || cVar == null || aVar == null || this.f7164e == null || hVar == null || castDevice == null || (componentName = this.g) == null) {
            f7159v.b("skip attaching media session", new Object[0]);
            return;
        }
        this.f7172n = hVar;
        hVar.q(this.f7171m);
        this.f7173o = castDevice;
        Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
        intent.setComponent(componentName);
        Context context = this.f7160a;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 67108864);
        if (aVar.f6465t) {
            a0 a0Var = new a0(context, componentName, broadcast);
            this.f7174p = a0Var;
            j(0, null);
            CastDevice castDevice2 = this.f7173o;
            if (castDevice2 != null && !TextUtils.isEmpty(castDevice2.f3131r)) {
                Bundle bundle = new Bundle();
                String string = context.getResources().getString(R.string.cast_casting_to_device, this.f7173o.f3131r);
                p.e eVar = MediaMetadataCompat.f186r;
                if (eVar.containsKey("android.media.metadata.ALBUM_ARTIST") && ((Integer) eVar.get("android.media.metadata.ALBUM_ARTIST")).intValue() != 1) {
                    throw new IllegalArgumentException("The android.media.metadata.ALBUM_ARTIST key cannot be used to put a String");
                }
                bundle.putCharSequence("android.media.metadata.ALBUM_ARTIST", string);
                a0Var.Z(new MediaMetadataCompat(bundle));
            }
            a0Var.Y(new i(this), null);
            a0Var.W(true);
            this.f7162c.y0(a0Var);
        }
        this.f7175q = true;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b() {
        /*
            Method dump skipped, instructions count: 327
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j7.j.b():void");
    }

    public final long c(String str, int i10, Bundle bundle) {
        long j10;
        int hashCode = str.hashCode();
        if (hashCode != -945151566) {
            if (hashCode != -945080078) {
                if (hashCode == 235550565 && str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK)) {
                    if (i10 == 3) {
                        j10 = 514;
                        i10 = 3;
                    } else {
                        j10 = 512;
                    }
                    if (i10 != 2) {
                        return j10;
                    }
                    return 516L;
                }
            } else if (str.equals(MediaIntentReceiver.ACTION_SKIP_PREV)) {
                i7.h hVar = this.f7172n;
                if (hVar != null && hVar.g()) {
                    g7.q d6 = hVar.d();
                    r.e(d6);
                    if ((128 & d6.f5283v) != 0 || d6.D != 0) {
                        return 16L;
                    }
                    Integer num = (Integer) d6.L.get(d6.f5278q);
                    if (num != null && num.intValue() > 0) {
                        return 16L;
                    }
                }
                bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
                return 0L;
            }
        } else if (str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT)) {
            i7.h hVar2 = this.f7172n;
            if (hVar2 != null && hVar2.g()) {
                g7.q d10 = hVar2.d();
                r.e(d10);
                if ((64 & d10.f5283v) != 0 || d10.D != 0) {
                    return 32L;
                }
                Integer num2 = (Integer) d10.L.get(d10.f5278q);
                if (num2 != null && num2.intValue() < d10.E.size() - 1) {
                    return 32L;
                }
            }
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        }
        return 0L;
    }

    public final Uri d(l lVar) {
        i7.a aVar = this.f7161b.f5717t;
        if (aVar != null) {
            aVar.b();
        }
        List list = lVar.f5248o;
        q7.a aVar2 = (list == null || list.isEmpty()) ? null : (q7.a) lVar.f5248o.get(0);
        if (aVar2 == null) {
            return null;
        }
        return aVar2.f10359p;
    }

    public final void e(int i10, Bitmap bitmap) {
        MediaMetadata metadata;
        a0 a0Var = this.f7174p;
        if (a0Var == null) {
            return;
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            bitmap.eraseColor(0);
        }
        a0 a0Var2 = this.f7174p;
        MediaMetadataCompat mediaMetadataCompat = null;
        if (a0Var2 != null && (metadata = ((android.support.v4.media.session.h) ((x4.l) a0Var2.f231q).f13561o).f245a.getMetadata()) != null) {
            p.e eVar = MediaMetadataCompat.f186r;
            Parcel obtain = Parcel.obtain();
            metadata.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            MediaMetadataCompat createFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            createFromParcel.f191p = metadata;
            mediaMetadataCompat = createFromParcel;
        }
        Bundle bundle = (Bundle) (mediaMetadataCompat == null ? new n(1) : new n(mediaMetadataCompat)).f74p;
        String str = i10 == 0 ? "android.media.metadata.DISPLAY_ICON" : "android.media.metadata.ALBUM_ART";
        p.e eVar2 = MediaMetadataCompat.f186r;
        if (eVar2.containsKey(str) && ((Integer) eVar2.get(str)).intValue() != 2) {
            throw new IllegalArgumentException(android.support.v4.media.d.q("The ", str, " key cannot be used to put a Bitmap"));
        }
        bundle.putParcelable(str, bitmap);
        a0Var.Z(new MediaMetadataCompat(bundle));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:105:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.support.v4.media.session.d0 r13, java.lang.String r14, i7.d r15) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j7.j.f(android.support.v4.media.session.d0, java.lang.String, i7.d):void");
    }

    public final void g(boolean z10) {
        if (this.f7161b.f5718u) {
            b8.e eVar = this.f7169k;
            androidx.activity.j jVar = this.f7170l;
            if (jVar != null) {
                eVar.removeCallbacks(jVar);
            }
            Context context = this.f7160a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            try {
                context.startService(intent);
            } catch (IllegalStateException unused) {
                if (z10) {
                    eVar.postDelayed(jVar, 1000L);
                }
            }
        }
    }

    public final void h() {
        g gVar = this.f7168j;
        if (gVar != null) {
            f7159v.b("Stopping media notification.", new Object[0]);
            u5 u5Var = gVar.f7144i;
            u5Var.d();
            u5Var.f3498s = null;
            NotificationManager notificationManager = gVar.f7138b;
            if (notificationManager != null) {
                notificationManager.cancel("castMediaNotification", 1);
            }
        }
    }

    public final void i() {
        if (this.f7161b.f5718u) {
            this.f7169k.removeCallbacks(this.f7170l);
            Context context = this.f7160a;
            Intent intent = new Intent(context, (Class<?>) ReconnectionService.class);
            intent.setPackage(context.getPackageName());
            context.stopService(intent);
        }
    }

    public final void j(int i10, MediaInfo mediaInfo) {
        PlaybackStateCompat a10;
        a0 a0Var;
        l lVar;
        MediaMetadata metadata;
        MediaMetadataCompat createFromParcel;
        Bitmap bitmap;
        PendingIntent activity;
        a0 a0Var2 = this.f7174p;
        if (a0Var2 == null) {
            return;
        }
        Bundle bundle = new Bundle();
        d0 d0Var = new d0();
        i7.h hVar = this.f7172n;
        if (hVar == null || this.f7168j == null) {
            a10 = d0Var.a();
        } else {
            long a11 = (hVar.t() == 0 || hVar.i()) ? 0L : hVar.a();
            long elapsedRealtime = SystemClock.elapsedRealtime();
            d0Var.f235b = i10;
            d0Var.f236c = a11;
            d0Var.f239f = elapsedRealtime;
            d0Var.f237d = 1.0f;
            if (i10 == 0) {
                a10 = d0Var.a();
            } else {
                i7.f fVar = this.f7164e;
                o oVar = fVar != null ? fVar.T : null;
                i7.h hVar2 = this.f7172n;
                long j10 = (hVar2 == null || hVar2.i() || this.f7172n.m()) ? 0L : 256L;
                if (oVar != null) {
                    ArrayList a12 = k.a(oVar);
                    if (a12 != null) {
                        int size = a12.size();
                        int i11 = 0;
                        while (i11 < size) {
                            Object obj = a12.get(i11);
                            i11++;
                            i7.d dVar = (i7.d) obj;
                            String str = dVar.f6481o;
                            if (TextUtils.equals(str, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str, MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                                j10 = c(str, i10, bundle) | j10;
                            } else {
                                f(d0Var, str, dVar);
                            }
                        }
                    }
                } else {
                    i7.f fVar2 = this.f7164e;
                    if (fVar2 != null) {
                        ArrayList arrayList = fVar2.f6484o;
                        int size2 = arrayList.size();
                        int i12 = 0;
                        while (i12 < size2) {
                            Object obj2 = arrayList.get(i12);
                            i12++;
                            String str2 = (String) obj2;
                            if (TextUtils.equals(str2, MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || TextUtils.equals(str2, MediaIntentReceiver.ACTION_SKIP_PREV) || TextUtils.equals(str2, MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                                j10 |= c(str2, i10, bundle);
                            } else {
                                f(d0Var, str2, null);
                            }
                        }
                    }
                }
                d0Var.f238e = j10;
                a10 = d0Var.a();
            }
        }
        u uVar = (u) a0Var2.f230p;
        uVar.f266f = a10;
        synchronized (uVar.f263c) {
            for (int beginBroadcast = uVar.f265e.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                try {
                    ((android.support.v4.media.session.b) uVar.f265e.getBroadcastItem(beginBroadcast)).s0(a10);
                } catch (RemoteException unused) {
                }
            }
            uVar.f265e.finishBroadcast();
        }
        MediaSession mediaSession = uVar.f261a;
        if (a10.f220z == null) {
            PlaybackState.Builder d6 = b0.d();
            b0.x(d6, a10.f209o, a10.f210p, a10.f212r, a10.f216v);
            b0.u(d6, a10.f211q);
            b0.s(d6, a10.f213s);
            b0.v(d6, a10.f215u);
            ArrayList arrayList2 = a10.f217w;
            int size3 = arrayList2.size();
            int i13 = 0;
            while (i13 < size3) {
                Object obj3 = arrayList2.get(i13);
                i13++;
                PlaybackStateCompat.CustomAction customAction = (PlaybackStateCompat.CustomAction) obj3;
                PlaybackState.CustomAction customAction2 = customAction.f225s;
                if (customAction2 == null) {
                    PlaybackState.CustomAction.Builder e7 = b0.e(customAction.f221o, customAction.f222p, customAction.f223q);
                    b0.w(e7, customAction.f224r);
                    customAction2 = b0.b(e7);
                }
                b0.a(d6, customAction2);
            }
            b0.t(d6, a10.f218x);
            c0.b(d6, a10.f219y);
            a10.f220z = b0.c(d6);
        }
        mediaSession.setPlaybackState(a10.f220z);
        i7.f fVar3 = this.f7164e;
        if (fVar3 != null && fVar3.U) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS", true);
        }
        i7.f fVar4 = this.f7164e;
        if (fVar4 != null && fVar4.V) {
            bundle.putBoolean("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT", true);
        }
        if (bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_PREVIOUS") || bundle.containsKey("android.media.playback.ALWAYS_RESERVE_SPACE_FOR.ACTION_SKIP_TO_NEXT")) {
            ((u) a0Var2.f230p).f261a.setExtras(bundle);
        }
        if (i10 == 0) {
            a0Var2.Z(new MediaMetadataCompat(new Bundle()));
            return;
        }
        if (this.f7172n != null) {
            if (this.f7165f == null) {
                activity = null;
            } else {
                Intent intent = new Intent();
                intent.setComponent(this.f7165f);
                activity = PendingIntent.getActivity(this.f7160a, 0, intent, 201326592);
            }
            if (activity != null) {
                ((u) a0Var2.f230p).f261a.setSessionActivity(activity);
            }
        }
        i7.h hVar3 = this.f7172n;
        if (hVar3 == null || (a0Var = this.f7174p) == null || mediaInfo == null || (lVar = mediaInfo.f3149r) == null) {
            return;
        }
        long j11 = hVar3.i() ? 0L : mediaInfo.f3150s;
        l.b("com.google.android.gms.cast.metadata.TITLE");
        String string = lVar.f5249p.getString("com.google.android.gms.cast.metadata.TITLE");
        l.b("com.google.android.gms.cast.metadata.SUBTITLE");
        String string2 = lVar.f5249p.getString("com.google.android.gms.cast.metadata.SUBTITLE");
        a0 a0Var3 = this.f7174p;
        if (a0Var3 == null || (metadata = ((android.support.v4.media.session.h) ((x4.l) a0Var3.f231q).f13561o).f245a.getMetadata()) == null) {
            createFromParcel = null;
        } else {
            p.e eVar = MediaMetadataCompat.f186r;
            Parcel obtain = Parcel.obtain();
            metadata.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            createFromParcel = MediaMetadataCompat.CREATOR.createFromParcel(obtain);
            obtain.recycle();
            createFromParcel.f191p = metadata;
        }
        n nVar = createFromParcel == null ? new n(1) : new n(createFromParcel);
        p.e eVar2 = MediaMetadataCompat.f186r;
        if (eVar2.containsKey("android.media.metadata.DURATION") && ((Integer) eVar2.get("android.media.metadata.DURATION")).intValue() != 0) {
            throw new IllegalArgumentException("The android.media.metadata.DURATION key cannot be used to put a long");
        }
        ((Bundle) nVar.f74p).putLong("android.media.metadata.DURATION", j11);
        if (string != null) {
            nVar.I("android.media.metadata.TITLE", string);
            nVar.I("android.media.metadata.DISPLAY_TITLE", string);
        }
        if (string2 != null) {
            nVar.I("android.media.metadata.DISPLAY_SUBTITLE", string2);
        }
        a0Var.Z(new MediaMetadataCompat((Bundle) nVar.f74p));
        Uri d10 = d(lVar);
        if (d10 != null) {
            this.f7166h.b(d10);
            bitmap = null;
        } else {
            bitmap = null;
            e(0, null);
        }
        Uri d11 = d(lVar);
        if (d11 != null) {
            this.f7167i.b(d11);
        } else {
            e(3, bitmap);
        }
    }
}
