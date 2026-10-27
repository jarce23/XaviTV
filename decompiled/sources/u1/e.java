package u1;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.fragment.app.v0;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f12189a;

    /* renamed from: b, reason: collision with root package name */
    public final v0 f12190b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f12191c;

    /* renamed from: d, reason: collision with root package name */
    public final c f12192d;

    /* renamed from: e, reason: collision with root package name */
    public final com.bumptech.glide.manager.q f12193e;

    /* renamed from: f, reason: collision with root package name */
    public final d f12194f;
    public b g;

    /* renamed from: h, reason: collision with root package name */
    public p4.p f12195h;

    /* renamed from: i, reason: collision with root package name */
    public i1.d f12196i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f12197j;

    public e(Context context, v0 v0Var, i1.d dVar, p4.p pVar) {
        Context applicationContext = context.getApplicationContext();
        this.f12189a = applicationContext;
        this.f12190b = v0Var;
        this.f12196i = dVar;
        this.f12195h = pVar;
        int i10 = l1.a0.f8067a;
        Looper myLooper = Looper.myLooper();
        Handler handler = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper, null);
        this.f12191c = handler;
        this.f12192d = new c(this);
        this.f12193e = new com.bumptech.glide.manager.q(4, this);
        b bVar = b.f12152c;
        String str = Build.MANUFACTURER;
        Uri uriFor = (str.equals("Amazon") || str.equals("Xiaomi")) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.f12194f = uriFor != null ? new d(this, handler, applicationContext.getContentResolver(), uriFor) : null;
    }

    public final void a(b bVar) {
        f2.r rVar;
        if (!this.f12197j || bVar.equals(this.g)) {
            return;
        }
        this.g = bVar;
        z zVar = (z) this.f12190b.f843p;
        Looper myLooper = Looper.myLooper();
        boolean z10 = zVar.h0 == myLooper;
        StringBuilder sb2 = new StringBuilder("Current looper (");
        sb2.append(myLooper == null ? "null" : myLooper.getThread().getName());
        sb2.append(") is not the playback looper (");
        Looper looper = zVar.h0;
        sb2.append(looper == null ? "null" : looper.getThread().getName());
        sb2.append(")");
        l1.d.f(sb2.toString(), z10);
        b bVar2 = zVar.f12332x;
        if (bVar2 == null || bVar.equals(bVar2)) {
            return;
        }
        zVar.f12332x = bVar;
        p4.p pVar = zVar.f12327s;
        if (pVar != null) {
            b0 b0Var = (b0) pVar.f9953p;
            synchronized (b0Var.f11248o) {
                rVar = b0Var.F;
            }
            if (rVar != null) {
                rVar.h();
            }
        }
    }

    public final void b(AudioDeviceInfo audioDeviceInfo) {
        p4.p pVar = this.f12195h;
        if (Objects.equals(audioDeviceInfo, pVar == null ? null : (AudioDeviceInfo) pVar.f9953p)) {
            return;
        }
        p4.p pVar2 = audioDeviceInfo != null ? new p4.p(12, audioDeviceInfo) : null;
        this.f12195h = pVar2;
        a(b.c(this.f12189a, this.f12196i, pVar2));
    }
}
