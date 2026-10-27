package android.support.v4.media.session;

import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.MediaMetadata;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.v0;
import androidx.recyclerview.widget.RecyclerView;
import app.shamel.tv.activities.MovieInfoActivity;
import app.shamel.tv.activities.SearchActivity;
import b4.f0;
import b4.f1;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.internal.cast.u5;
import f.j0;
import h5.g0;
import h7.h0;
import j9.i1;
import j9.v1;
import j9.w1;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.zip.Adler32;
import m.d3;
import m.n0;
import m0.k0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 implements a6.c0, g0, p7.h, k9.f, j9.v, l0.c, h3.e, r3.a0, v6.b {

    /* renamed from: s, reason: collision with root package name */
    public static int f227s;

    /* renamed from: t, reason: collision with root package name */
    public static a0 f228t;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f229o;

    /* renamed from: p, reason: collision with root package name */
    public Object f230p;

    /* renamed from: q, reason: collision with root package name */
    public Object f231q;

    /* renamed from: r, reason: collision with root package name */
    public Object f232r;

    public /* synthetic */ a0(int i10, boolean z10) {
        this.f229o = i10;
    }

    public static void G(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(a0.class.getClassLoader());
        }
    }

    public static a0 T(Context context, AttributeSet attributeSet, int[] iArr, int i10) {
        return new a0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, 0));
    }

    public static Bundle e0(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        G(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public o4.r A() {
        o4.r rVar = new o4.r((UUID) this.f230p, (x4.o) this.f231q, (LinkedHashSet) this.f232r);
        o4.d dVar = ((x4.o) this.f231q).f13577j;
        boolean z10 = (Build.VERSION.SDK_INT >= 24 && dVar.a()) || dVar.f9490d || dVar.f9488b || dVar.f9489c;
        x4.o oVar = (x4.o) this.f231q;
        if (oVar.f13584q) {
            if (z10) {
                throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
            }
            if (oVar.g > 0) {
                throw new IllegalArgumentException("Expedited jobs cannot be delayed");
            }
        }
        UUID randomUUID = UUID.randomUUID();
        za.h.d("randomUUID()", randomUUID);
        this.f230p = randomUUID;
        String uuid = randomUUID.toString();
        za.h.d("id.toString()", uuid);
        x4.o oVar2 = (x4.o) this.f231q;
        za.h.e("other", oVar2);
        this.f231q = new x4.o(uuid, oVar2.f13570b, oVar2.f13571c, oVar2.f13572d, new o4.f(oVar2.f13573e), new o4.f(oVar2.f13574f), oVar2.g, oVar2.f13575h, oVar2.f13576i, new o4.d(oVar2.f13577j), oVar2.f13578k, oVar2.f13579l, oVar2.f13580m, oVar2.f13581n, oVar2.f13582o, oVar2.f13583p, oVar2.f13584q, oVar2.f13585r, oVar2.f13586s, oVar2.f13588u, oVar2.f13589v, oVar2.f13590w, 524288);
        return rVar;
    }

    public s6.i B() {
        String str = ((String) this.f230p) == null ? " backendName" : _UrlKt.FRAGMENT_ENCODE_SET;
        if (((p6.c) this.f232r) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new s6.i((String) this.f230p, (byte[]) this.f231q, (p6.c) this.f232r);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public void C(long j10, l1.t tVar) {
        if (tVar.a() < 9) {
            return;
        }
        int j11 = tVar.j();
        int j12 = tVar.j();
        int w10 = tVar.w();
        if (j11 == 434 && j12 == 1195456820 && w10 == 3) {
            ((b4.b) this.f232r).a(j10, tVar);
        }
    }

    public void D(k2.p pVar, r3.e0 e0Var) {
        k2.g0[] g0VarArr = (k2.g0[]) this.f231q;
        for (int i10 = 0; i10 < g0VarArr.length; i10++) {
            e0Var.a();
            e0Var.b();
            k2.g0 q10 = pVar.q(e0Var.f10511d, 3);
            i1.p pVar2 = (i1.p) ((List) this.f230p).get(i10);
            String str = pVar2.f5991n;
            l1.d.a("Invalid closed caption MIME type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
            i1.o oVar = new i1.o();
            e0Var.b();
            oVar.f5929a = e0Var.f10512e;
            oVar.f5939l = i1.g0.m("video/mp2t");
            oVar.f5940m = i1.g0.m(str);
            oVar.f5933e = pVar2.f5983e;
            oVar.f5932d = pVar2.f5982d;
            oVar.J = pVar2.K;
            oVar.f5943p = pVar2.f5994q;
            r.a.i(oVar, q10);
            g0VarArr[i10] = q10;
        }
    }

    public void E(int i10) {
        f1 J;
        int N = N(i10);
        ((b4.c) this.f231q).y(N);
        RecyclerView recyclerView = ((b4.e0) this.f230p).f2214a;
        View childAt = recyclerView.getChildAt(N);
        if (childAt != null && (J = RecyclerView.J(childAt)) != null) {
            if (J.k() && !J.p()) {
                throw new IllegalArgumentException("called detach on an already detached child " + J + recyclerView.z());
            }
            J.a(256);
        }
        recyclerView.detachViewFromParent(N);
    }

    public void F(w6.a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap hashMap = (HashMap) this.f230p;
        w9.e eVar = new w9.e(byteArrayOutputStream, hashMap, (HashMap) this.f231q, (t9.d) this.f232r);
        t9.d dVar = (t9.d) hashMap.get(w6.a.class);
        if (dVar != null) {
            dVar.a(aVar, eVar);
        } else {
            throw new t9.b("No encoder for " + w6.a.class);
        }
    }

    public View H(int i10) {
        return ((b4.e0) this.f230p).f2214a.getChildAt(N(i10));
    }

    public int I() {
        return ((b4.e0) this.f230p).f2214a.getChildCount() - ((ArrayList) this.f232r).size();
    }

    public ColorStateList J(int i10) {
        int resourceId;
        ColorStateList n10;
        TypedArray typedArray = (TypedArray) this.f231q;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0 || (n10 = n4.a.n((Context) this.f230p, resourceId)) == null) ? typedArray.getColorStateList(i10) : n10;
    }

    public Drawable K(int i10) {
        int resourceId;
        TypedArray typedArray = (TypedArray) this.f231q;
        return (!typedArray.hasValue(i10) || (resourceId = typedArray.getResourceId(i10, 0)) == 0) ? typedArray.getDrawable(i10) : n4.a.o((Context) this.f230p, resourceId);
    }

    public Drawable L(int i10) {
        int resourceId;
        Drawable g;
        if (!((TypedArray) this.f231q).hasValue(i10) || (resourceId = ((TypedArray) this.f231q).getResourceId(i10, 0)) == 0) {
            return null;
        }
        m.r a10 = m.r.a();
        Context context = (Context) this.f230p;
        synchronized (a10) {
            g = a10.f8529a.g(context, resourceId, true);
        }
        return g;
    }

    public Typeface M(int i10, int i11, n0 n0Var) {
        int resourceId = ((TypedArray) this.f231q).getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (((TypedValue) this.f232r) == null) {
            this.f232r = new TypedValue();
        }
        Context context = (Context) this.f230p;
        TypedValue typedValue = (TypedValue) this.f232r;
        ThreadLocal threadLocal = d0.l.f3981a;
        if (context.isRestricted()) {
            return null;
        }
        return d0.l.b(context, resourceId, typedValue, i11, n0Var, true, false);
    }

    public int N(int i10) {
        b4.c cVar = (b4.c) this.f231q;
        if (i10 < 0) {
            return -1;
        }
        int childCount = ((b4.e0) this.f230p).f2214a.getChildCount();
        int i11 = i10;
        while (i11 < childCount) {
            int s10 = i10 - (i11 - cVar.s(i11));
            if (s10 == 0) {
                while (cVar.v(i11)) {
                    i11++;
                }
                return i11;
            }
            i11 += s10;
        }
        return -1;
    }

    public View O(int i10) {
        return ((b4.e0) this.f230p).f2214a.getChildAt(i10);
    }

    public int P() {
        return ((b4.e0) this.f230p).f2214a.getChildCount();
    }

    public void Q(View view) {
        ((ArrayList) this.f232r).add(view);
        b4.e0 e0Var = (b4.e0) this.f230p;
        f1 J = RecyclerView.J(view);
        if (J != null) {
            View view2 = J.f2232a;
            RecyclerView recyclerView = e0Var.f2214a;
            int i10 = J.f2247q;
            if (i10 != -1) {
                J.f2246p = i10;
            } else {
                WeakHashMap weakHashMap = k0.f8683a;
                J.f2246p = view2.getImportantForAccessibility();
            }
            if (recyclerView.N()) {
                J.f2247q = 4;
                recyclerView.I0.add(J);
            } else {
                WeakHashMap weakHashMap2 = k0.f8683a;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    public int R(View view) {
        b4.c cVar = (b4.c) this.f231q;
        int indexOfChild = ((b4.e0) this.f230p).f2214a.indexOfChild(view);
        if (indexOfChild == -1 || cVar.v(indexOfChild)) {
            return -1;
        }
        return indexOfChild - cVar.s(indexOfChild);
    }

    public boolean S(int i10, u.d dVar, x.e eVar) {
        v.b bVar = (v.b) this.f230p;
        int[] iArr = dVar.f12087o0;
        int[] iArr2 = dVar.f12091s;
        bVar.f12580a = iArr[0];
        bVar.f12581b = iArr[1];
        bVar.f12582c = dVar.n();
        bVar.f12583d = dVar.k();
        bVar.f12587i = false;
        bVar.f12588j = i10;
        boolean z10 = bVar.f12580a == 3;
        boolean z11 = bVar.f12581b == 3;
        boolean z12 = z10 && dVar.V > 0.0f;
        boolean z13 = z11 && dVar.V > 0.0f;
        if (z12 && iArr2[0] == 4) {
            bVar.f12580a = 1;
        }
        if (z13 && iArr2[1] == 4) {
            bVar.f12581b = 1;
        }
        eVar.b(dVar, bVar);
        dVar.J(bVar.f12584e);
        dVar.G(bVar.f12585f);
        dVar.D = bVar.f12586h;
        dVar.D(bVar.g);
        bVar.f12588j = 0;
        return bVar.f12587i;
    }

    public void U() {
        ((TypedArray) this.f231q).recycle();
    }

    public void V(s6.i iVar, int i10, boolean z10) {
        char c10;
        z6.a aVar = (z6.a) this.f232r;
        Context context = (Context) this.f230p;
        ComponentName componentName = new ComponentName(context, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        Adler32 adler32 = new Adler32();
        adler32.update(context.getPackageName().getBytes(Charset.forName("UTF-8")));
        String str = iVar.f11611a;
        String str2 = iVar.f11611a;
        adler32.update(str.getBytes(Charset.forName("UTF-8")));
        ByteBuffer allocate = ByteBuffer.allocate(4);
        p6.c cVar = iVar.f11613c;
        adler32.update(allocate.putInt(d7.a.a(cVar)).array());
        byte[] bArr = iVar.f11612b;
        if (bArr != null) {
            adler32.update(bArr);
        }
        int value = (int) adler32.getValue();
        if (!z10) {
            Iterator<JobInfo> it = jobScheduler.getAllPendingJobs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                JobInfo next = it.next();
                int i11 = next.getExtras().getInt("attemptNumber");
                if (next.getId() == value) {
                    if (i11 >= i10) {
                        j1.c.j("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", iVar);
                        return;
                    }
                }
            }
        }
        Cursor rawQuery = ((a7.l) ((a7.d) this.f231q)).a().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{str2, String.valueOf(d7.a.a(cVar))});
        try {
            Long valueOf = rawQuery.moveToNext() ? Long.valueOf(rawQuery.getLong(0)) : 0L;
            rawQuery.close();
            long longValue = valueOf.longValue();
            JobInfo.Builder builder = new JobInfo.Builder(value, componentName);
            builder.setMinimumLatency(aVar.a(cVar, longValue, i10));
            Set set = ((z6.b) aVar.f14124b.get(cVar)).f14127c;
            if (set.contains(z6.c.f14128o)) {
                builder.setRequiredNetworkType(2);
            } else {
                builder.setRequiredNetworkType(1);
            }
            if (set.contains(z6.c.f14130q)) {
                builder.setRequiresCharging(true);
            }
            if (set.contains(z6.c.f14129p)) {
                builder.setRequiresDeviceIdle(true);
            }
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putInt("attemptNumber", i10);
            persistableBundle.putString("backendName", str2);
            persistableBundle.putInt("priority", d7.a.a(cVar));
            if (bArr != null) {
                c10 = 0;
                persistableBundle.putString("extras", Base64.encodeToString(bArr, 0));
            } else {
                c10 = 0;
            }
            builder.setExtras(persistableBundle);
            Integer valueOf2 = Integer.valueOf(value);
            Long valueOf3 = Long.valueOf(aVar.a(cVar, longValue, i10));
            Integer valueOf4 = Integer.valueOf(i10);
            Object[] objArr = new Object[5];
            objArr[c10] = iVar;
            objArr[1] = valueOf2;
            objArr[2] = valueOf3;
            objArr[3] = valueOf;
            objArr[4] = valueOf4;
            Log.d("TransportRuntime.".concat("JobInfoScheduler"), String.format("Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", objArr));
            jobScheduler.schedule(builder.build());
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
    }

    public void W(boolean z10) {
        ((u) this.f230p).f261a.setActive(z10);
        ArrayList arrayList = (ArrayList) this.f232r;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((w3.r) obj).getClass();
        }
    }

    public void X(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f230p = str;
    }

    public void Y(s sVar, Handler handler) {
        u uVar = (u) this.f230p;
        if (sVar == null) {
            uVar.e(null, null);
            return;
        }
        if (handler == null) {
            handler = new Handler();
        }
        uVar.e(sVar, handler);
    }

    public void Z(MediaMetadataCompat mediaMetadataCompat) {
        u uVar = (u) this.f230p;
        uVar.g = mediaMetadataCompat;
        MediaSession mediaSession = uVar.f261a;
        if (mediaMetadataCompat.f191p == null) {
            Parcel obtain = Parcel.obtain();
            mediaMetadataCompat.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            mediaMetadataCompat.f191p = (MediaMetadata) MediaMetadata.CREATOR.createFromParcel(obtain);
            obtain.recycle();
        }
        mediaSession.setMetadata(mediaMetadataCompat.f191p);
    }

    @Override // h3.e
    public int a(long j10) {
        long[] jArr = (long[]) this.f232r;
        int a10 = l1.a0.a(jArr, j10, false);
        if (a10 < jArr.length) {
            return a10;
        }
        return -1;
    }

    public void a0(u.e eVar, int i10, int i11, int i12) {
        int i13 = eVar.f12061a0;
        int i14 = eVar.f12063b0;
        eVar.f12061a0 = 0;
        eVar.f12063b0 = 0;
        eVar.J(i11);
        eVar.G(i12);
        if (i13 < 0) {
            eVar.f12061a0 = 0;
        } else {
            eVar.f12061a0 = i13;
        }
        if (i14 < 0) {
            eVar.f12063b0 = 0;
        } else {
            eVar.f12063b0 = i14;
        }
        u.e eVar2 = (u.e) this.f231q;
        eVar2.f12102s0 = i10;
        eVar2.P();
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        switch (this.f229o) {
            case 8:
                g7.e0 e0Var = (g7.e0) this.f230p;
                g7.f fVar = (g7.f) this.f231q;
                String str = (String) this.f232r;
                l7.x xVar = (l7.x) obj;
                i8.d dVar = (i8.d) obj2;
                r7.r.g("Not active connection", e0Var.F != 1);
                if (fVar != null) {
                    l7.g gVar = (l7.g) xVar.j();
                    Parcel w02 = gVar.w0();
                    w02.writeString(str);
                    gVar.z0(w02, 12);
                }
                dVar.b(null);
                break;
            default:
                g7.e0 e0Var2 = (g7.e0) this.f230p;
                String str2 = (String) this.f231q;
                String str3 = (String) this.f232r;
                l7.x xVar2 = (l7.x) obj;
                i8.d dVar2 = (i8.d) obj2;
                HashMap hashMap = e0Var2.B;
                long incrementAndGet = e0Var2.f5212q.incrementAndGet();
                r7.r.g("Not connected to device", e0Var2.F == 2);
                try {
                    hashMap.put(Long.valueOf(incrementAndGet), dVar2);
                    l7.g gVar2 = (l7.g) xVar2.j();
                    Parcel w03 = gVar2.w0();
                    w03.writeString(str2);
                    w03.writeString(str3);
                    w03.writeLong(incrementAndGet);
                    gVar2.z0(w03, 9);
                    break;
                } catch (RemoteException e7) {
                    hashMap.remove(Long.valueOf(incrementAndGet));
                    dVar2.a(e7);
                }
        }
    }

    @Override // r3.a0
    public void b(l1.t tVar) {
        long d6;
        l1.d.h((l1.y) this.f231q);
        int i10 = l1.a0.f8067a;
        l1.y yVar = (l1.y) this.f231q;
        synchronized (yVar) {
            try {
                long j10 = yVar.f8141c;
                d6 = j10 != -9223372036854775807L ? j10 + yVar.f8140b : yVar.d();
            } finally {
            }
        }
        long e7 = ((l1.y) this.f231q).e();
        if (d6 == -9223372036854775807L || e7 == -9223372036854775807L) {
            return;
        }
        i1.p pVar = (i1.p) this.f230p;
        if (e7 != pVar.f5996s) {
            i1.o a10 = pVar.a();
            a10.f5945r = e7;
            i1.p pVar2 = new i1.p(a10);
            this.f230p = pVar2;
            ((k2.g0) this.f232r).a(pVar2);
        }
        int a11 = tVar.a();
        ((k2.g0) this.f232r).c(a11, tVar);
        ((k2.g0) this.f232r).e(d6, 1, a11, 0, null);
    }

    @Override // k9.f
    public Object c() {
        return new j9.k(((androidx.emoji2.text.o) ((h5.i) this.f230p).f5610p).f591o, (j9.n0) ((k9.e) this.f231q).c(), (i1) ((k9.e) this.f232r).c());
    }

    @Override // r3.a0
    public void d(l1.y yVar, k2.p pVar, r3.e0 e0Var) {
        this.f231q = yVar;
        e0Var.a();
        e0Var.b();
        k2.g0 q10 = pVar.q(e0Var.f10511d, 5);
        this.f232r = q10;
        q10.a((i1.p) this.f230p);
    }

    public void d0(View view) {
        if (((ArrayList) this.f232r).remove(view)) {
            b4.e0 e0Var = (b4.e0) this.f230p;
            f1 J = RecyclerView.J(view);
            if (J != null) {
                RecyclerView recyclerView = e0Var.f2214a;
                int i10 = J.f2246p;
                if (recyclerView.N()) {
                    J.f2247q = i10;
                    recyclerView.I0.add(J);
                } else {
                    View view2 = J.f2232a;
                    WeakHashMap weakHashMap = k0.f8683a;
                    view2.setImportantForAccessibility(i10);
                }
                J.f2246p = 0;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r0 != null) goto L21;
     */
    @Override // a6.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap e(android.graphics.BitmapFactory.Options r5) {
        /*
            r4 = this;
            int r0 = r4.f229o
            switch(r0) {
                case 1: goto L65;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r4.f232r
            com.bumptech.glide.load.data.g r0 = (com.bumptech.glide.load.data.g) r0
            android.os.ParcelFileDescriptor r0 = r0.e()
            java.io.FileDescriptor r0 = r0.getFileDescriptor()
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 34
            r3 = 0
            if (r1 != r2) goto L60
            boolean r1 = a6.u.a(r5)
            if (r1 == 0) goto L60
            boolean r1 = a6.u.d(r4)
            if (r1 == 0) goto L60
            android.graphics.Bitmap$Config r1 = r5.inPreferredConfig
            android.graphics.Bitmap$Config r2 = n0.b.e()
            if (r1 != r2) goto L2e
            r1 = 1
            goto L2f
        L2e:
            r1 = 0
        L2f:
            java.lang.String r2 = ""
            m6.f.a(r2, r1)
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
            r5.inPreferredConfig = r1
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFileDescriptor(r0, r3, r5)     // Catch: java.lang.Throwable -> L53
            if (r0 != 0) goto L48
            if (r0 == 0) goto L41
            goto L4c
        L41:
            android.graphics.Bitmap$Config r0 = n0.b.e()
            r5.inPreferredConfig = r0
            goto L64
        L48:
            android.graphics.Bitmap r3 = a6.u.e(r0)     // Catch: java.lang.Throwable -> L50
        L4c:
            r0.recycle()
            goto L41
        L50:
            r1 = move-exception
            r3 = r0
            goto L54
        L53:
            r1 = move-exception
        L54:
            if (r3 == 0) goto L59
            r3.recycle()
        L59:
            android.graphics.Bitmap$Config r0 = n0.b.e()
            r5.inPreferredConfig = r0
            throw r1
        L60:
            android.graphics.Bitmap r3 = android.graphics.BitmapFactory.decodeFileDescriptor(r0, r3, r5)
        L64:
            return r3
        L65:
            java.lang.Object r0 = r4.f230p
            java.nio.ByteBuffer r0 = (java.nio.ByteBuffer) r0
            java.nio.ByteBuffer r0 = m6.b.c(r0)
            m6.a r1 = new m6.a
            r1.<init>(r0)
            android.graphics.Bitmap r5 = a6.u.c(r1, r5, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.session.a0.e(android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @Override // j9.v
    public void f(String str) {
        h(0L, str);
    }

    public void f0(u.e eVar) {
        ArrayList arrayList = (ArrayList) this.f232r;
        arrayList.clear();
        int size = eVar.f12099p0.size();
        for (int i10 = 0; i10 < size; i10++) {
            u.d dVar = (u.d) eVar.f12099p0.get(i10);
            int[] iArr = dVar.f12087o0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(dVar);
            }
        }
        eVar.f12101r0.f12592b = true;
    }

    @Override // j9.v
    public ArrayList g(String str) {
        Object obj = ((o4.f) this.f231q).f9498a.get(((String) this.f230p).concat(str));
        String[] strArr = obj instanceof String[] ? (String[]) obj : null;
        if (strArr == null) {
            return new ArrayList();
        }
        ArrayList<String> arrayList = new ArrayList<>(strArr.length);
        for (String str2 : strArr) {
            if (true == str2.isEmpty()) {
                str2 = null;
            }
            arrayList.add(str2);
        }
        ((Bundle) this.f232r).putStringArrayList(str, arrayList);
        return arrayList;
    }

    public void g0(String str, int i10, String str2) {
        ((HashMap) this.f230p).put(str, str2);
        ((HashMap) this.f231q).put(str2, str);
        ((HashMap) this.f232r).put(str, Integer.valueOf(i10));
    }

    @Override // ka.a
    public Object get() {
        switch (this.f229o) {
            case 22:
                int i10 = 9;
                return new s6.o(new n7.i(i10), new d9.f(i10), (y6.b) ((u5) this.f230p).get(), (j9.n) ((d3) this.f231q).get(), (x4.i) ((x4.i) this.f232r).get());
            default:
                return new a0((Context) ((ka.a) this.f230p).get(), (a7.d) ((ka.a) this.f231q).get(), (z6.a) ((v1) this.f232r).get(), 29);
        }
    }

    @Override // j9.v
    public void h(long j10, String str) {
        String str2 = (String) this.f230p;
        o4.f fVar = (o4.f) this.f231q;
        Object obj = fVar.f9498a.get(str2.concat(str));
        if (obj instanceof Long) {
            j10 = ((Long) obj).longValue();
        }
        ((Bundle) this.f232r).putLong(str, j10);
    }

    @Override // a6.c0
    public boolean i() {
        switch (this.f229o) {
            case 1:
                List list = (List) this.f231q;
                ByteBuffer c10 = m6.b.c((ByteBuffer) this.f230p);
                u5.f fVar = (u5.f) this.f232r;
                if (c10 == null) {
                    return false;
                }
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    try {
                        if (((r5.d) list.get(i10)).d(c10, fVar)) {
                            return true;
                        }
                    } finally {
                    }
                }
                return false;
            default:
                List list2 = (List) this.f231q;
                com.bumptech.glide.load.data.g gVar = (com.bumptech.glide.load.data.g) this.f232r;
                u5.f fVar2 = (u5.f) this.f230p;
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    r5.d dVar = (r5.d) list2.get(i11);
                    a6.e0 e0Var = null;
                    try {
                        a6.e0 e0Var2 = new a6.e0(new FileInputStream(gVar.e().getFileDescriptor()), fVar2);
                        try {
                            boolean f10 = dVar.f(e0Var2, fVar2);
                            e0Var2.c();
                            gVar.e();
                            if (f10) {
                                return true;
                            }
                        } catch (Throwable th) {
                            th = th;
                            e0Var = e0Var2;
                            if (e0Var != null) {
                                e0Var.c();
                            }
                            gVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return false;
        }
    }

    @Override // j9.v
    public void j() {
        String str = (String) this.f230p;
        Bundle bundle = (Bundle) this.f232r;
        Object obj = ((o4.f) this.f231q).f9498a.get(str.concat("notification_intent_reconstruct_from_data"));
        bundle.putBoolean("notification_intent_reconstruct_from_data", obj instanceof Boolean ? ((Boolean) obj).booleanValue() : false);
    }

    @Override // j9.v
    public void k(String str) {
        Object obj = ((o4.f) this.f231q).f9498a.get(((String) this.f230p) + str + ":intent_data");
        String[] strArr = obj instanceof String[] ? (String[]) obj : null;
        if (strArr == null) {
            return;
        }
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(strArr.length);
        for (String str2 : strArr) {
            arrayList.add(str2.isEmpty() ? null : new Intent().setData(Uri.parse(str2)));
        }
        ((Bundle) this.f232r).putParcelableArrayList(str, arrayList);
    }

    @Override // h3.e
    public long l(int i10) {
        long[] jArr = (long[]) this.f232r;
        l1.d.b(i10 >= 0);
        l1.d.b(i10 < jArr.length);
        return jArr[i10];
    }

    @Override // l0.c
    public boolean m(Object obj) {
        if (obj instanceof n6.b) {
            ((n6.b) obj).b().f9211a = true;
        }
        switch (((w1) this.f231q).f7482o) {
            case 6:
                break;
            default:
                ((List) obj).clear();
                break;
        }
        return ((l0.e) this.f232r).m(obj);
    }

    @Override // a6.c0
    public void n() {
        int i10 = this.f229o;
    }

    @Override // a6.c0
    public int o() {
        switch (this.f229o) {
            case 1:
                List list = (List) this.f231q;
                ByteBuffer c10 = m6.b.c((ByteBuffer) this.f230p);
                u5.f fVar = (u5.f) this.f232r;
                if (c10 == null) {
                    return -1;
                }
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    try {
                        int b2 = ((r5.d) list.get(i10)).b(c10, fVar);
                        if (b2 != -1) {
                            return b2;
                        }
                    } finally {
                    }
                }
                return -1;
            default:
                List list2 = (List) this.f231q;
                com.bumptech.glide.load.data.g gVar = (com.bumptech.glide.load.data.g) this.f232r;
                u5.f fVar2 = (u5.f) this.f230p;
                int size2 = list2.size();
                for (int i11 = 0; i11 < size2; i11++) {
                    r5.d dVar = (r5.d) list2.get(i11);
                    a6.e0 e0Var = null;
                    try {
                        a6.e0 e0Var2 = new a6.e0(new FileInputStream(gVar.e().getFileDescriptor()), fVar2);
                        try {
                            int c11 = dVar.c(e0Var2, fVar2);
                            e0Var2.c();
                            gVar.e();
                            if (c11 != -1) {
                                return c11;
                            }
                        } catch (Throwable th) {
                            th = th;
                            e0Var = e0Var2;
                            if (e0Var != null) {
                                e0Var.c();
                            }
                            gVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return -1;
        }
    }

    @Override // j9.v
    public void p(String str) {
        String str2 = (String) this.f230p;
        Object obj = ((o4.f) this.f231q).f9498a.get(str2.concat(str));
        ((Bundle) this.f232r).putString(str, obj instanceof String ? (String) obj : null);
    }

    @Override // j9.v
    public void q(String str) {
        String str2 = (String) this.f230p;
        Object obj = ((o4.f) this.f231q).f9498a.get(str2.concat(str));
        ((Bundle) this.f232r).putInt(str, obj instanceof Integer ? ((Integer) obj).intValue() : 0);
    }

    @Override // h3.e
    public List r(long j10) {
        List list = (List) this.f230p;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            long[] jArr = (long[]) this.f231q;
            int i11 = i10 * 2;
            if (jArr[i11] <= j10 && j10 < jArr[i11 + 1]) {
                q3.c cVar = (q3.c) list.get(i10);
                k1.b bVar = cVar.f10287a;
                if (bVar.f7627e == -3.4028235E38f) {
                    arrayList2.add(cVar);
                } else {
                    arrayList.add(bVar);
                }
            }
        }
        Collections.sort(arrayList2, new f2.c(13));
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            k1.a a10 = ((q3.c) arrayList2.get(i12)).f10287a.a();
            a10.f7602e = (-1) - i12;
            a10.f7603f = 1;
            arrayList.add(a10.a());
        }
        return arrayList;
    }

    @Override // a6.c0
    public ImageHeaderParser$ImageType s() {
        switch (this.f229o) {
            case 1:
                return com.bumptech.glide.f.m((List) this.f231q, m6.b.c((ByteBuffer) this.f230p));
            default:
                List list = (List) this.f231q;
                com.bumptech.glide.load.data.g gVar = (com.bumptech.glide.load.data.g) this.f232r;
                u5.f fVar = (u5.f) this.f230p;
                int size = list.size();
                for (int i10 = 0; i10 < size; i10++) {
                    r5.d dVar = (r5.d) list.get(i10);
                    a6.e0 e0Var = null;
                    try {
                        a6.e0 e0Var2 = new a6.e0(new FileInputStream(gVar.e().getFileDescriptor()), fVar);
                        try {
                            ImageHeaderParser$ImageType e7 = dVar.e(e0Var2);
                            e0Var2.c();
                            gVar.e();
                            if (e7 != ImageHeaderParser$ImageType.UNKNOWN) {
                                return e7;
                            }
                        } catch (Throwable th) {
                            th = th;
                            e0Var = e0Var2;
                            if (e0Var != null) {
                                e0Var.c();
                            }
                            gVar.e();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                return ImageHeaderParser$ImageType.UNKNOWN;
        }
    }

    @Override // h5.g0
    public void t() {
        SearchActivity searchActivity = (SearchActivity) this.f232r;
        Toast.makeText(searchActivity, searchActivity.f1785a0.getPut_pin_code(), 0).show();
    }

    public String toString() {
        switch (this.f229o) {
            case 5:
                return ((b4.c) this.f231q).toString() + ", hidden list:" + ((ArrayList) this.f232r).size();
            default:
                return super.toString();
        }
    }

    @Override // h5.g0
    public void u() {
        SearchActivity searchActivity = (SearchActivity) this.f232r;
        Toast.makeText(searchActivity, searchActivity.f1785a0.getPin_incorrect(), 0).show();
    }

    @Override // l0.c
    public Object v() {
        Object v10 = ((l0.e) this.f232r).v();
        if (v10 == null) {
            v10 = ((n6.a) this.f230p).j();
            if (Log.isLoggable("FactoryPools", 2)) {
                Log.v("FactoryPools", "Created new " + v10.getClass());
            }
        }
        if (v10 instanceof n6.b) {
            ((n6.b) v10).b().f9211a = false;
        }
        return v10;
    }

    @Override // h3.e
    public int w() {
        return ((long[]) this.f232r).length;
    }

    public void x(View view, int i10, boolean z10) {
        RecyclerView recyclerView = ((b4.e0) this.f230p).f2214a;
        int childCount = i10 < 0 ? recyclerView.getChildCount() : N(i10);
        ((b4.c) this.f231q).x(childCount, z10);
        if (z10) {
            Q(view);
        }
        recyclerView.addView(view, childCount);
        f1 J = RecyclerView.J(view);
        f0 f0Var = recyclerView.A;
        if (f0Var == null || J == null) {
            return;
        }
        f0Var.j(J);
    }

    @Override // h5.g0
    public void y() {
        SearchActivity searchActivity = (SearchActivity) this.f232r;
        Intent intent = new Intent(searchActivity, (Class<?>) MovieInfoActivity.class);
        intent.putExtra("name", (String) this.f230p);
        intent.putExtra("stream_id", (String) this.f231q);
        searchActivity.startActivity(intent);
    }

    public void z(View view, int i10, ViewGroup.LayoutParams layoutParams, boolean z10) {
        RecyclerView recyclerView = ((b4.e0) this.f230p).f2214a;
        int childCount = i10 < 0 ? recyclerView.getChildCount() : N(i10);
        ((b4.c) this.f231q).x(childCount, z10);
        if (z10) {
            Q(view);
        }
        f1 J = RecyclerView.J(view);
        if (J != null) {
            if (!J.k() && !J.p()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + J + recyclerView.z());
            }
            J.f2240j &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, int i10) {
        this.f229o = i10;
        this.f230p = obj;
        this.f231q = obj2;
        this.f232r = obj3;
    }

    public /* synthetic */ a0(Object obj, Object obj2, Object obj3, int i10, boolean z10) {
        this.f229o = i10;
        this.f232r = obj;
        this.f230p = obj2;
        this.f231q = obj3;
    }

    public a0(CastDevice castDevice, h0 h0Var) {
        this.f229o = 7;
        r7.r.f("CastDevice parameter cannot be null", castDevice);
        this.f230p = castDevice;
        this.f231q = h0Var;
    }

    public a0(i7.h hVar) {
        this.f229o = 11;
        this.f232r = hVar;
        this.f231q = new AtomicLong((l7.a.f8270b.nextLong() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * 10000);
    }

    public /* synthetic */ a0(String str, o4.f fVar) {
        this.f229o = 13;
        this.f232r = new Bundle();
        this.f230p = str;
        this.f231q = fVar;
    }

    public a0(int i10) {
        this.f229o = i10;
        switch (i10) {
            case 10:
                this.f230p = new HashMap();
                this.f231q = new HashMap();
                this.f232r = new HashMap();
                break;
            default:
                this.f230p = new androidx.leanback.widget.t(1);
                androidx.leanback.widget.t tVar = new androidx.leanback.widget.t(0);
                this.f231q = tVar;
                this.f232r = tVar;
                break;
        }
    }

    public a0(ArrayList arrayList) {
        this.f229o = 17;
        this.f230p = Collections.unmodifiableList(new ArrayList(arrayList));
        this.f231q = new long[arrayList.size() * 2];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            q3.c cVar = (q3.c) arrayList.get(i10);
            int i11 = i10 * 2;
            long[] jArr = (long[]) this.f231q;
            jArr[i11] = cVar.f10288b;
            jArr[i11 + 1] = cVar.f10289c;
        }
        long[] jArr2 = (long[]) this.f231q;
        long[] copyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.f232r = copyOf;
        Arrays.sort(copyOf);
    }

    public a0(List list) {
        this.f229o = 19;
        this.f230p = list;
        this.f231q = new k2.g0[list.size()];
        b4.b bVar = new b4.b(new v0(18, this));
        this.f232r = bVar;
        bVar.v(3);
    }

    public a0(b4.e0 e0Var) {
        this.f229o = 5;
        this.f230p = e0Var;
        this.f231q = new b4.c();
        this.f232r = new ArrayList();
    }

    private final void b0() {
    }

    private final void c0() {
    }

    public a0(String str) {
        this.f229o = 18;
        i1.o oVar = new i1.o();
        oVar.f5939l = i1.g0.m("video/mp2t");
        oVar.f5940m = i1.g0.m(str);
        this.f230p = new i1.p(oVar);
    }

    public a0(Class cls) {
        this.f229o = 16;
        UUID randomUUID = UUID.randomUUID();
        za.h.d("randomUUID()", randomUUID);
        this.f230p = randomUUID;
        String uuid = ((UUID) this.f230p).toString();
        za.h.d("id.toString()", uuid);
        this.f231q = new x4.o(uuid, 0, cls.getName(), (String) null, (o4.f) null, (o4.f) null, 0L, 0L, 0L, (o4.d) null, 0, 0, 0L, 0L, 0L, 0L, false, 0, 0, 0L, 0, 0, 8388602);
        String[] strArr = {cls.getName()};
        LinkedHashSet linkedHashSet = new LinkedHashSet(ma.t.z(1));
        linkedHashSet.add(strArr[0]);
        this.f232r = linkedHashSet;
    }

    public a0(Context context, TypedArray typedArray) {
        this.f229o = 14;
        this.f230p = context;
        this.f231q = typedArray;
    }

    public a0(Context context, LocationManager locationManager) {
        this.f229o = 6;
        this.f232r = new j0();
        this.f230p = context;
        this.f231q = locationManager;
    }

    public a0(u.e eVar) {
        this.f229o = 26;
        this.f232r = new ArrayList();
        this.f230p = new v.b();
        this.f231q = eVar;
    }

    public a0(ParcelFileDescriptor parcelFileDescriptor, ArrayList arrayList, u5.f fVar) {
        this.f229o = 2;
        m6.f.c("Argument must not be null", fVar);
        this.f230p = fVar;
        m6.f.c("Argument must not be null", arrayList);
        this.f231q = arrayList;
        this.f232r = new com.bumptech.glide.load.data.g(parcelFileDescriptor);
    }

    public a0(Context context, ComponentName componentName, PendingIntent pendingIntent) {
        this.f229o = 0;
        this.f232r = new ArrayList();
        if (context != null) {
            if (!TextUtils.isEmpty("CastMediaSession")) {
                if (componentName == null) {
                    int i10 = w3.h0.f12934b;
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setPackage(context.getPackageName());
                    List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 0);
                    if (queryBroadcastReceivers.size() == 1) {
                        ActivityInfo activityInfo = queryBroadcastReceivers.get(0).activityInfo;
                        componentName = new ComponentName(activityInfo.packageName, activityInfo.name);
                    } else {
                        if (queryBroadcastReceivers.size() > 1) {
                            Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
                        }
                        componentName = null;
                    }
                    if (componentName == null) {
                        Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                    }
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent2 = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent2.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent2, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
                }
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 29) {
                    this.f230p = new x(context);
                } else if (i11 >= 28) {
                    this.f230p = new v(context);
                } else {
                    this.f230p = new u(context);
                }
                Y(new p(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                ((u) this.f230p).f261a.setMediaButtonReceiver(pendingIntent);
                x4.l lVar = new x4.l();
                lVar.f13562p = new ConcurrentHashMap();
                MediaSessionCompat$Token mediaSessionCompat$Token = ((u) this.f230p).f262b;
                if (Build.VERSION.SDK_INT >= 29) {
                    lVar.f13561o = new i(context, mediaSessionCompat$Token);
                } else {
                    lVar.f13561o = new h(context, mediaSessionCompat$Token);
                }
                this.f231q = lVar;
                if (f227s == 0) {
                    f227s = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    public a0(AudioTrack audioTrack, u1.e eVar) {
        this.f229o = 25;
        this.f230p = audioTrack;
        this.f231q = eVar;
        this.f232r = new AudioRouting.OnRoutingChangedListener() { // from class: u1.w
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
            
                r3 = r3.getRoutedDevice();
             */
            @Override // android.media.AudioRouting.OnRoutingChangedListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void onRoutingChanged(android.media.AudioRouting r3) {
                /*
                    r2 = this;
                    android.support.v4.media.session.a0 r0 = android.support.v4.media.session.a0.this
                    java.lang.Object r1 = r0.f232r
                    u1.w r1 = (u1.w) r1
                    if (r1 != 0) goto L9
                    goto L16
                L9:
                    android.media.AudioDeviceInfo r3 = s4.a.c(r3)
                    if (r3 == 0) goto L16
                    java.lang.Object r0 = r0.f231q
                    u1.e r0 = (u1.e) r0
                    r0.b(r3)
                L16:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: u1.w.onRoutingChanged(android.media.AudioRouting):void");
            }
        };
        audioTrack.addOnRoutingChangedListener((u1.w) this.f232r, new Handler(Looper.myLooper()));
    }
}
