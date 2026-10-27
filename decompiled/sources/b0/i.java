package b0;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Context f2145a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f2149e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f2150f;
    public PendingIntent g;

    /* renamed from: h, reason: collision with root package name */
    public IconCompat f2151h;

    /* renamed from: i, reason: collision with root package name */
    public int f2152i;

    /* renamed from: k, reason: collision with root package name */
    public j f2154k;

    /* renamed from: m, reason: collision with root package name */
    public Bundle f2156m;

    /* renamed from: o, reason: collision with root package name */
    public String f2158o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f2159p;

    /* renamed from: q, reason: collision with root package name */
    public final Notification f2160q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f2161r;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2146b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2147c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2148d = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public boolean f2153j = true;

    /* renamed from: l, reason: collision with root package name */
    public boolean f2155l = false;

    /* renamed from: n, reason: collision with root package name */
    public int f2157n = 0;

    public i(Context context, String str) {
        Notification notification = new Notification();
        this.f2160q = notification;
        this.f2145a = context;
        this.f2158o = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f2152i = 0;
        this.f2161r = new ArrayList();
        this.f2159p = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return charSequence == null ? charSequence : charSequence.length() > 5120 ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Notification build;
        Bundle bundle;
        String b2;
        x4.m mVar = new x4.m(this);
        i iVar = (i) mVar.f13565q;
        j jVar = iVar.f2154k;
        if (jVar != null) {
            jVar.a(mVar);
        }
        Notification.Builder builder = (Notification.Builder) mVar.f13564p;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26) {
            build = builder.build();
        } else if (i10 >= 24) {
            build = builder.build();
        } else {
            builder.setExtras((Bundle) mVar.f13566r);
            build = builder.build();
        }
        if (jVar != null) {
            iVar.f2154k.getClass();
        }
        if (jVar != null && (bundle = build.extras) != null && (b2 = jVar.b()) != null) {
            bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", b2);
        }
        return build;
    }

    public final void c(j jVar) {
        if (this.f2154k != jVar) {
            this.f2154k = jVar;
            if (((i) jVar.f2162a) != this) {
                jVar.f2162a = this;
                c(jVar);
            }
        }
    }
}
