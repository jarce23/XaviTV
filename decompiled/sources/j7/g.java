package j7;

import a6.q;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat$Token;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.cast.framework.media.MediaIntentReceiver;
import com.google.android.gms.internal.cast.u5;
import com.google.android.gms.internal.cast.y1;
import com.google.android.gms.internal.cast.z0;
import i7.o;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;
import r7.r;
import x4.l;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: u, reason: collision with root package name */
    public static final l7.b f7136u = new l7.b("MediaNotificationProxy", null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f7137a;

    /* renamed from: b, reason: collision with root package name */
    public final NotificationManager f7138b;

    /* renamed from: c, reason: collision with root package name */
    public final i7.f f7139c;

    /* renamed from: d, reason: collision with root package name */
    public final ComponentName f7140d;

    /* renamed from: e, reason: collision with root package name */
    public final ComponentName f7141e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f7142f = new ArrayList();
    public int[] g;

    /* renamed from: h, reason: collision with root package name */
    public final long f7143h;

    /* renamed from: i, reason: collision with root package name */
    public final u5 f7144i;

    /* renamed from: j, reason: collision with root package name */
    public final Resources f7145j;

    /* renamed from: k, reason: collision with root package name */
    public f f7146k;

    /* renamed from: l, reason: collision with root package name */
    public l f7147l;

    /* renamed from: m, reason: collision with root package name */
    public b0.g f7148m;

    /* renamed from: n, reason: collision with root package name */
    public b0.g f7149n;

    /* renamed from: o, reason: collision with root package name */
    public b0.g f7150o;

    /* renamed from: p, reason: collision with root package name */
    public b0.g f7151p;

    /* renamed from: q, reason: collision with root package name */
    public b0.g f7152q;

    /* renamed from: r, reason: collision with root package name */
    public b0.g f7153r;

    /* renamed from: s, reason: collision with root package name */
    public b0.g f7154s;

    /* renamed from: t, reason: collision with root package name */
    public b0.g f7155t;

    public g(Context context) {
        this.f7137a = context;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        this.f7138b = notificationManager;
        l7.b bVar = h7.b.f5697l;
        r.b();
        h7.b bVar2 = h7.b.f5699n;
        r.e(bVar2);
        r.b();
        h7.c cVar = bVar2.f5704e;
        r.e(cVar);
        i7.a aVar = cVar.f5717t;
        r.e(aVar);
        i7.f fVar = aVar.f6463r;
        r.e(fVar);
        this.f7139c = fVar;
        aVar.b();
        Resources resources = context.getResources();
        this.f7145j = resources;
        this.f7140d = new ComponentName(context.getApplicationContext(), aVar.f6460o);
        String str = fVar.f6487r;
        if (TextUtils.isEmpty(str)) {
            this.f7141e = null;
        } else {
            this.f7141e = new ComponentName(context.getApplicationContext(), str);
        }
        this.f7143h = fVar.f6486q;
        int dimensionPixelSize = resources.getDimensionPixelSize(fVar.F);
        this.f7144i = new u5(context.getApplicationContext(), new i7.b(1, dimensionPixelSize, dimensionPixelSize));
        if (y7.d.k() && notificationManager != null) {
            NotificationChannel e7 = q.e(context.getResources().getString(R.string.media_notification_channel_name));
            e7.setShowBadge(false);
            notificationManager.createNotificationChannel(e7);
        }
        y1.a(z0.CAF_MEDIA_NOTIFICATION_PROXY);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final b0.g a(String str) {
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        int i10;
        int i11;
        int hashCode = str.hashCode();
        long j10 = this.f7143h;
        Resources resources = this.f7145j;
        Context context = this.f7137a;
        ComponentName componentName = this.f7140d;
        i7.f fVar = this.f7139c;
        switch (hashCode) {
            case -1699820260:
                if (str.equals(MediaIntentReceiver.ACTION_REWIND)) {
                    if (this.f7153r == null) {
                        Intent intent = new Intent(MediaIntentReceiver.ACTION_REWIND);
                        intent.setComponent(componentName);
                        intent.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j10);
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent, 201326592);
                        l7.b bVar = k.f7180a;
                        int i12 = fVar.B;
                        if (j10 == 10000) {
                            i12 = fVar.C;
                        } else if (j10 == 30000) {
                            i12 = fVar.D;
                        }
                        int i13 = fVar.P;
                        if (j10 == 10000) {
                            i13 = fVar.Q;
                        } else if (j10 == 30000) {
                            i13 = fVar.R;
                        }
                        String string = resources.getString(i13);
                        IconCompat b2 = i12 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i12);
                        Bundle bundle = new Bundle();
                        CharSequence b10 = b0.i.b(string);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        this.f7153r = new b0.g(b2, b10, broadcast, bundle, arrayList2.isEmpty() ? null : (b0.r[]) arrayList2.toArray(new b0.r[arrayList2.size()]), arrayList.isEmpty() ? null : (b0.r[]) arrayList.toArray(new b0.r[arrayList.size()]), true, true);
                    }
                    return this.f7153r;
                }
                break;
            case -945151566:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT)) {
                    boolean z10 = this.f7146k.f7135f;
                    if (this.f7150o == null) {
                        if (z10) {
                            Intent intent2 = new Intent(MediaIntentReceiver.ACTION_SKIP_NEXT);
                            intent2.setComponent(componentName);
                            pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, 67108864);
                        } else {
                            pendingIntent = null;
                        }
                        int i14 = fVar.f6492w;
                        String string2 = resources.getString(fVar.K);
                        IconCompat b11 = i14 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i14);
                        Bundle bundle2 = new Bundle();
                        CharSequence b12 = b0.i.b(string2);
                        ArrayList arrayList3 = new ArrayList();
                        ArrayList arrayList4 = new ArrayList();
                        this.f7150o = new b0.g(b11, b12, pendingIntent, bundle2, arrayList4.isEmpty() ? null : (b0.r[]) arrayList4.toArray(new b0.r[arrayList4.size()]), arrayList3.isEmpty() ? null : (b0.r[]) arrayList3.toArray(new b0.r[arrayList3.size()]), true, true);
                    }
                    return this.f7150o;
                }
                break;
            case -945080078:
                if (str.equals(MediaIntentReceiver.ACTION_SKIP_PREV)) {
                    boolean z11 = this.f7146k.g;
                    if (this.f7151p == null) {
                        if (z11) {
                            Intent intent3 = new Intent(MediaIntentReceiver.ACTION_SKIP_PREV);
                            intent3.setComponent(componentName);
                            pendingIntent2 = PendingIntent.getBroadcast(context, 0, intent3, 67108864);
                        } else {
                            pendingIntent2 = null;
                        }
                        int i15 = fVar.f6493x;
                        String string3 = resources.getString(fVar.L);
                        IconCompat b13 = i15 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i15);
                        Bundle bundle3 = new Bundle();
                        CharSequence b14 = b0.i.b(string3);
                        ArrayList arrayList5 = new ArrayList();
                        ArrayList arrayList6 = new ArrayList();
                        this.f7151p = new b0.g(b13, b14, pendingIntent2, bundle3, arrayList6.isEmpty() ? null : (b0.r[]) arrayList6.toArray(new b0.r[arrayList6.size()]), arrayList5.isEmpty() ? null : (b0.r[]) arrayList5.toArray(new b0.r[arrayList5.size()]), true, true);
                    }
                    return this.f7151p;
                }
                break;
            case -668151673:
                if (str.equals(MediaIntentReceiver.ACTION_STOP_CASTING)) {
                    if (this.f7155t == null) {
                        Intent intent4 = new Intent(MediaIntentReceiver.ACTION_STOP_CASTING);
                        intent4.setComponent(componentName);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, 0, intent4, 67108864);
                        int i16 = fVar.E;
                        String string4 = resources.getString(fVar.S);
                        IconCompat b15 = i16 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i16);
                        Bundle bundle4 = new Bundle();
                        CharSequence b16 = b0.i.b(string4);
                        ArrayList arrayList7 = new ArrayList();
                        ArrayList arrayList8 = new ArrayList();
                        this.f7155t = new b0.g(b15, b16, broadcast2, bundle4, arrayList8.isEmpty() ? null : (b0.r[]) arrayList8.toArray(new b0.r[arrayList8.size()]), arrayList7.isEmpty() ? null : (b0.r[]) arrayList7.toArray(new b0.r[arrayList7.size()]), true, true);
                    }
                    return this.f7155t;
                }
                break;
            case -124479363:
                if (str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                    if (this.f7154s == null) {
                        Intent intent5 = new Intent(MediaIntentReceiver.ACTION_DISCONNECT);
                        intent5.setComponent(componentName);
                        PendingIntent broadcast3 = PendingIntent.getBroadcast(context, 0, intent5, 67108864);
                        int i17 = fVar.E;
                        String string5 = resources.getString(fVar.S, _UrlKt.FRAGMENT_ENCODE_SET);
                        IconCompat b17 = i17 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i17);
                        Bundle bundle5 = new Bundle();
                        CharSequence b18 = b0.i.b(string5);
                        ArrayList arrayList9 = new ArrayList();
                        ArrayList arrayList10 = new ArrayList();
                        this.f7154s = new b0.g(b17, b18, broadcast3, bundle5, arrayList10.isEmpty() ? null : (b0.r[]) arrayList10.toArray(new b0.r[arrayList10.size()]), arrayList9.isEmpty() ? null : (b0.r[]) arrayList9.toArray(new b0.r[arrayList9.size()]), true, true);
                    }
                    return this.f7154s;
                }
                break;
            case 235550565:
                if (str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK)) {
                    f fVar2 = this.f7146k;
                    int i18 = fVar2.f7132c;
                    if (!fVar2.f7131b) {
                        if (this.f7148m == null) {
                            Intent intent6 = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                            intent6.setComponent(componentName);
                            PendingIntent broadcast4 = PendingIntent.getBroadcast(context, 0, intent6, 67108864);
                            int i19 = fVar.f6491v;
                            String string6 = resources.getString(fVar.J);
                            IconCompat b19 = i19 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i19);
                            Bundle bundle6 = new Bundle();
                            CharSequence b20 = b0.i.b(string6);
                            ArrayList arrayList11 = new ArrayList();
                            ArrayList arrayList12 = new ArrayList();
                            this.f7148m = new b0.g(b19, b20, broadcast4, bundle6, arrayList12.isEmpty() ? null : (b0.r[]) arrayList12.toArray(new b0.r[arrayList12.size()]), arrayList11.isEmpty() ? null : (b0.r[]) arrayList11.toArray(new b0.r[arrayList11.size()]), true, true);
                        }
                        return this.f7148m;
                    }
                    if (this.f7149n == null) {
                        if (i18 == 2) {
                            i10 = fVar.f6489t;
                            i11 = fVar.H;
                        } else {
                            i10 = fVar.f6490u;
                            i11 = fVar.I;
                        }
                        Intent intent7 = new Intent(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK);
                        intent7.setComponent(componentName);
                        PendingIntent broadcast5 = PendingIntent.getBroadcast(context, 0, intent7, 67108864);
                        String string7 = resources.getString(i11);
                        IconCompat b21 = i10 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i10);
                        Bundle bundle7 = new Bundle();
                        CharSequence b22 = b0.i.b(string7);
                        ArrayList arrayList13 = new ArrayList();
                        ArrayList arrayList14 = new ArrayList();
                        this.f7149n = new b0.g(b21, b22, broadcast5, bundle7, arrayList14.isEmpty() ? null : (b0.r[]) arrayList14.toArray(new b0.r[arrayList14.size()]), arrayList13.isEmpty() ? null : (b0.r[]) arrayList13.toArray(new b0.r[arrayList13.size()]), true, true);
                    }
                    return this.f7149n;
                }
                break;
            case 1362116196:
                if (str.equals(MediaIntentReceiver.ACTION_FORWARD)) {
                    if (this.f7152q == null) {
                        Intent intent8 = new Intent(MediaIntentReceiver.ACTION_FORWARD);
                        intent8.setComponent(componentName);
                        intent8.putExtra(MediaIntentReceiver.EXTRA_SKIP_STEP_MS, j10);
                        PendingIntent broadcast6 = PendingIntent.getBroadcast(context, 0, intent8, 201326592);
                        l7.b bVar2 = k.f7180a;
                        int i20 = fVar.f6494y;
                        if (j10 == 10000) {
                            i20 = fVar.f6495z;
                        } else if (j10 == 30000) {
                            i20 = fVar.A;
                        }
                        int i21 = fVar.M;
                        if (j10 == 10000) {
                            i21 = fVar.N;
                        } else if (j10 == 30000) {
                            i21 = fVar.O;
                        }
                        String string8 = resources.getString(i21);
                        IconCompat b23 = i20 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i20);
                        Bundle bundle8 = new Bundle();
                        CharSequence b24 = b0.i.b(string8);
                        ArrayList arrayList15 = new ArrayList();
                        ArrayList arrayList16 = new ArrayList();
                        this.f7152q = new b0.g(b23, b24, broadcast6, bundle8, arrayList16.isEmpty() ? null : (b0.r[]) arrayList16.toArray(new b0.r[arrayList16.size()]), arrayList15.isEmpty() ? null : (b0.r[]) arrayList15.toArray(new b0.r[arrayList15.size()]), true, true);
                    }
                    return this.f7152q;
                }
                break;
        }
        l7.b bVar3 = f7136u;
        Log.e(bVar3.f8271a, bVar3.d("Action: %s is not a pre-defined action.", str));
        return null;
    }

    public final void b() {
        IconCompat iconCompat;
        PendingIntent activities;
        b0.g a10;
        NotificationManager notificationManager = this.f7138b;
        if (notificationManager == null || this.f7146k == null) {
            return;
        }
        l lVar = this.f7147l;
        Bitmap bitmap = lVar == null ? null : (Bitmap) lVar.f13562p;
        Context context = this.f7137a;
        b0.i iVar = new b0.i(context, "cast_media_notification");
        if (bitmap == null) {
            iconCompat = null;
        } else {
            if (Build.VERSION.SDK_INT < 27) {
                Resources resources = iVar.f2145a.getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_width);
                int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.compat_notification_large_icon_max_height);
                if (bitmap.getWidth() > dimensionPixelSize || bitmap.getHeight() > dimensionPixelSize2) {
                    double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
                    bitmap = Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
                }
            }
            PorterDuff.Mode mode = IconCompat.f531k;
            bitmap.getClass();
            iconCompat = new IconCompat(1);
            iconCompat.f533b = bitmap;
        }
        iVar.f2151h = iconCompat;
        i7.f fVar = this.f7139c;
        int i10 = fVar.f6488s;
        Notification notification = iVar.f2160q;
        notification.icon = i10;
        iVar.f2149e = b0.i.b(this.f7146k.f7133d);
        int i11 = 0;
        iVar.f2150f = b0.i.b(this.f7145j.getString(fVar.G, this.f7146k.f7134e));
        notification.flags |= 2;
        iVar.f2153j = false;
        iVar.f2157n = 1;
        ComponentName componentName = this.f7141e;
        if (componentName == null) {
            activities = null;
        } else {
            Intent intent = new Intent();
            intent.putExtra("targetActivity", componentName);
            intent.setAction(componentName.flattenToString());
            intent.setComponent(componentName);
            ArrayList arrayList = new ArrayList();
            ComponentName component = intent.getComponent();
            if (component == null) {
                component = intent.resolveActivity(context.getPackageManager());
            }
            if (component != null) {
                int size = arrayList.size();
                try {
                    for (Intent a11 = b0.c.a(context, component); a11 != null; a11 = b0.c.a(context, a11.getComponent())) {
                        arrayList.add(size, a11);
                    }
                } catch (PackageManager.NameNotFoundException e7) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e7);
                }
            }
            arrayList.add(intent);
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot getPendingIntent");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            activities = PendingIntent.getActivities(context, 1, intentArr, 201326592, null);
        }
        if (activities != null) {
            iVar.g = activities;
        }
        o oVar = fVar.T;
        l7.b bVar = f7136u;
        if (oVar != null) {
            bVar.b("actionsProvider != null", new Object[0]);
            int[] b2 = k.b(oVar);
            this.g = b2 == null ? null : (int[]) b2.clone();
            ArrayList a12 = k.a(oVar);
            this.f7142f = new ArrayList();
            if (a12 != null) {
                int size2 = a12.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj = a12.get(i12);
                    i12++;
                    i7.d dVar = (i7.d) obj;
                    String str = dVar.f6481o;
                    if (str.equals(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK) || str.equals(MediaIntentReceiver.ACTION_SKIP_NEXT) || str.equals(MediaIntentReceiver.ACTION_SKIP_PREV) || str.equals(MediaIntentReceiver.ACTION_FORWARD) || str.equals(MediaIntentReceiver.ACTION_REWIND) || str.equals(MediaIntentReceiver.ACTION_STOP_CASTING) || str.equals(MediaIntentReceiver.ACTION_DISCONNECT)) {
                        a10 = a(str);
                    } else {
                        Intent intent2 = new Intent(str);
                        intent2.setComponent(this.f7140d);
                        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intent2, 67108864);
                        int i13 = dVar.f6482p;
                        String str2 = dVar.f6483q;
                        IconCompat b10 = i13 == 0 ? null : IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i13);
                        Bundle bundle = new Bundle();
                        CharSequence b11 = b0.i.b(str2);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        a10 = new b0.g(b10, b11, broadcast, bundle, arrayList3.isEmpty() ? null : (b0.r[]) arrayList3.toArray(new b0.r[arrayList3.size()]), arrayList2.isEmpty() ? null : (b0.r[]) arrayList2.toArray(new b0.r[arrayList2.size()]), true, true);
                    }
                    if (a10 != null) {
                        this.f7142f.add(a10);
                    }
                }
            }
        } else {
            bVar.b("actionsProvider == null", new Object[0]);
            this.f7142f = new ArrayList();
            ArrayList arrayList4 = fVar.f6484o;
            int size3 = arrayList4.size();
            int i14 = 0;
            while (i14 < size3) {
                Object obj2 = arrayList4.get(i14);
                i14++;
                b0.g a13 = a((String) obj2);
                if (a13 != null) {
                    this.f7142f.add(a13);
                }
            }
            int[] iArr = fVar.f6485p;
            this.g = (int[]) Arrays.copyOf(iArr, iArr.length).clone();
        }
        ArrayList arrayList5 = this.f7142f;
        int size4 = arrayList5.size();
        while (i11 < size4) {
            Object obj3 = arrayList5.get(i11);
            i11++;
            b0.g gVar = (b0.g) obj3;
            if (gVar != null) {
                iVar.f2146b.add(gVar);
            }
        }
        g1.b bVar2 = new g1.b();
        bVar2.f5075b = null;
        int[] iArr2 = this.g;
        if (iArr2 != null) {
            bVar2.f5075b = iArr2;
        }
        MediaSessionCompat$Token mediaSessionCompat$Token = this.f7146k.f7130a;
        if (mediaSessionCompat$Token != null) {
            bVar2.f5076c = mediaSessionCompat$Token;
        }
        iVar.c(bVar2);
        notificationManager.notify("castMediaNotification", 1, iVar.a());
    }
}
