package x4;

import a6.e0;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.a0;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.i0;
import androidx.fragment.app.s;
import androidx.work.impl.WorkDatabase_Impl;
import app.shamel.tv.activities.MovieInfoActivity;
import app.shamel.tv.activities.MovieSecondActivity;
import app.shamel.tv.activities.y;
import app.shamel.tv.models.MovieModel;
import b4.f1;
import b4.j0;
import b4.p1;
import com.google.android.gms.internal.cast.y1;
import com.google.android.gms.internal.cast.z0;
import f.b0;
import f.t;
import h5.g0;
import j9.q0;
import j9.r0;
import j9.s0;
import j9.t0;
import j9.u0;
import j9.v1;
import j9.w1;
import j9.x1;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicReference;
import m0.k0;
import m0.p0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import w3.w;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c implements a6.r, g0, i8.a, t0, l7.o, com.bumptech.glide.load.data.c, z1.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13536o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13537p;

    /* renamed from: q, reason: collision with root package name */
    public Object f13538q;

    public /* synthetic */ c(Object obj, int i10, Object obj2) {
        this.f13536o = i10;
        this.f13537p = obj;
        this.f13538q = obj2;
    }

    @Override // a6.r
    public void A() {
        e0 e0Var = (e0) this.f13537p;
        synchronized (e0Var) {
            e0Var.f53q = e0Var.f51o.length;
        }
    }

    public void B(f1 f1Var, j0 j0Var) {
        p.i iVar = (p.i) this.f13537p;
        p1 p1Var = (p1) iVar.get(f1Var);
        if (p1Var == null) {
            p1Var = p1.a();
            iVar.put(f1Var, p1Var);
        }
        p1Var.f2388c = j0Var;
        p1Var.f2386a |= 8;
    }

    public String C(r5.e eVar) {
        String str;
        v5.e eVar2 = (v5.e) ((a0) this.f13538q).v();
        try {
            eVar.b(eVar2.f12684o);
            byte[] digest = eVar2.f12684o.digest();
            char[] cArr = m6.n.f9028b;
            synchronized (cArr) {
                for (int i10 = 0; i10 < digest.length; i10++) {
                    byte b2 = digest[i10];
                    int i11 = i10 * 2;
                    char[] cArr2 = m6.n.f9027a;
                    cArr[i11] = cArr2[(b2 & 255) >>> 4];
                    cArr[i11 + 1] = cArr2[b2 & 15];
                }
                str = new String(cArr);
            }
            return str;
        } finally {
            ((a0) this.f13538q).m(eVar2);
        }
    }

    public void D(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.D(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void E(boolean z10) {
        i0 i0Var = (i0) this.f13538q;
        f.j jVar = i0Var.f707t.f826t;
        s sVar = i0Var.f709v;
        if (sVar != null) {
            sVar.k().f699l.E(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void F(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.F(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void G(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.G(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void H(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.H(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void I(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.I(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void J(boolean z10) {
        i0 i0Var = (i0) this.f13538q;
        f.j jVar = i0Var.f707t.f826t;
        s sVar = i0Var.f709v;
        if (sVar != null) {
            sVar.k().f699l.J(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void K(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.K(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void L(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.L(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void M(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.M(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void N(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.N(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void O(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.O(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void P(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.P(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public void Q(boolean z10) {
        s sVar = ((i0) this.f13538q).f709v;
        if (sVar != null) {
            sVar.k().f699l.Q(true);
        }
        Iterator it = ((CopyOnWriteArrayList) this.f13537p).iterator();
        if (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (!z10) {
                throw null;
            }
            throw null;
        }
    }

    public Object R(u5.h hVar) {
        HashMap hashMap = (HashMap) this.f13538q;
        u5.c cVar = (u5.c) hashMap.get(hVar);
        if (cVar == null) {
            cVar = new u5.c(hVar);
            hashMap.put(hVar, cVar);
        } else {
            hVar.a();
        }
        u5.c cVar2 = cVar.f12528d;
        cVar2.f12527c = cVar.f12527c;
        cVar.f12527c.f12528d = cVar2;
        u5.c cVar3 = (u5.c) this.f13537p;
        cVar.f12528d = cVar3;
        u5.c cVar4 = cVar3.f12527c;
        cVar.f12527c = cVar4;
        cVar4.f12528d = cVar;
        cVar.f12528d.f12527c = cVar;
        ArrayList arrayList = cVar.f12526b;
        int size = arrayList != null ? arrayList.size() : 0;
        if (size > 0) {
            return cVar.f12526b.remove(size - 1);
        }
        return null;
    }

    public ArrayList S(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f13537p;
        c4.m a10 = c4.m.a(1, "SELECT work_spec_id FROM dependency WHERE prerequisite_id=?");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            ArrayList arrayList = new ArrayList(m10.getCount());
            while (m10.moveToNext()) {
                arrayList.add(m10.isNull(0) ? null : m10.getString(0));
            }
            return arrayList;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public String T(r5.e eVar) {
        String str;
        synchronized (((m6.j) this.f13537p)) {
            str = (String) ((m6.j) this.f13537p).a(eVar);
        }
        if (str == null) {
            str = C(eVar);
        }
        synchronized (((m6.j) this.f13537p)) {
            ((m6.j) this.f13537p).d(eVar, str);
        }
        return str;
    }

    public void U(k.a aVar) {
        i iVar = (i) this.f13537p;
        ((ActionMode.Callback) iVar.f13553p).onDestroyActionMode(iVar.j(aVar));
        b0 b0Var = (b0) this.f13538q;
        if (b0Var.K != null) {
            b0Var.f4743z.getDecorView().removeCallbacks(b0Var.L);
        }
        if (b0Var.J != null) {
            p0 p0Var = b0Var.M;
            if (p0Var != null) {
                p0Var.b();
            }
            p0 a10 = k0.a(b0Var.J);
            a10.a(0.0f);
            b0Var.M = a10;
            a10.d(new t(2, this));
        }
        b0Var.I = null;
        ViewGroup viewGroup = b0Var.P;
        WeakHashMap weakHashMap = k0.f8683a;
        m0.a0.c(viewGroup);
        b0Var.I();
    }

    public boolean V(k.a aVar, Menu menu) {
        ViewGroup viewGroup = ((b0) this.f13538q).P;
        WeakHashMap weakHashMap = k0.f8683a;
        m0.a0.c(viewGroup);
        i iVar = (i) this.f13537p;
        ActionMode.Callback callback = (ActionMode.Callback) iVar.f13553p;
        k.e j10 = iVar.j(aVar);
        p.i iVar2 = (p.i) iVar.f13556s;
        Menu menu2 = (Menu) iVar2.get(menu);
        if (menu2 == null) {
            menu2 = new l.a0((Context) iVar.f13554q, (l.l) menu);
            iVar2.put(menu, menu2);
        }
        return callback.onPrepareActionMode(j10, menu2);
    }

    public void W(j0.g gVar) {
        i0.d dVar = (i0.d) this.f13538q;
        a6.n nVar = (a6.n) this.f13537p;
        int i10 = gVar.f6923b;
        if (i10 == 0) {
            dVar.execute(new y(nVar, gVar.f6922a, 16, false));
        } else {
            dVar.execute(new androidx.emoji2.text.j(i10, 3, nVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d2, code lost:
    
        if (r0 < 200) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d6, code lost:
    
        if (r0 > 299) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d8, code lost:
    
        android.os.SystemClock.elapsedRealtime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
    
        return new c4.e(r9, false, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ea, code lost:
    
        throw new java.io.IOException();
     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bd A[LOOP:0: B:2:0x000a->B:63:0x01bd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c4.e X(m5.i r19) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.c.X(m5.i):c4.e");
    }

    public j0 Y(f1 f1Var, int i10) {
        p1 p1Var;
        j0 j0Var;
        p.i iVar = (p.i) this.f13537p;
        int d6 = iVar.d(f1Var);
        if (d6 >= 0 && (p1Var = (p1) iVar.j(d6)) != null) {
            int i11 = p1Var.f2386a;
            if ((i11 & i10) != 0) {
                int i12 = i11 & (~i10);
                p1Var.f2386a = i12;
                if (i10 == 4) {
                    j0Var = p1Var.f2387b;
                } else {
                    if (i10 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    j0Var = p1Var.f2388c;
                }
                if ((i12 & 12) == 0) {
                    iVar.h(d6);
                    p1Var.f2386a = 0;
                    p1Var.f2387b = null;
                    p1Var.f2388c = null;
                    p1.f2385d.m(p1Var);
                }
                return j0Var;
            }
        }
        return null;
    }

    public void Z(Class cls, Class cls2, Class cls3, List list) {
        synchronized (((p.e) this.f13538q)) {
            ((p.e) this.f13538q).put(new m6.l(cls, cls2, cls3), list);
        }
    }

    @Override // z1.m
    public void a() {
        z1.k kVar = (z1.k) this.f13538q;
        MediaCodec mediaCodec = (MediaCodec) this.f13537p;
        try {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && i10 < 33) {
                mediaCodec.stop();
            }
            if (i10 >= 35 && kVar != null) {
                kVar.c(mediaCodec);
            }
            mediaCodec.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && kVar != null) {
                kVar.c(mediaCodec);
            }
            mediaCodec.release();
            throw th;
        }
    }

    public void a0(u5.h hVar, Object obj) {
        HashMap hashMap = (HashMap) this.f13538q;
        u5.c cVar = (u5.c) hashMap.get(hVar);
        if (cVar == null) {
            cVar = new u5.c(hVar);
            cVar.f12528d = cVar;
            u5.c cVar2 = (u5.c) this.f13537p;
            cVar.f12528d = cVar2.f12528d;
            cVar.f12527c = cVar2;
            cVar2.f12528d = cVar;
            cVar.f12528d.f12527c = cVar;
            hashMap.put(hVar, cVar);
        } else {
            hVar.a();
        }
        if (cVar.f12526b == null) {
            cVar.f12526b = new ArrayList();
        }
        cVar.f12526b.add(obj);
    }

    @Override // z1.m
    public void b(int i10, o4.a aVar, long j10, int i11) {
        ((MediaCodec) this.f13537p).queueSecureInputBuffer(i10, 0, (MediaCodec.CryptoInfo) aVar.f9480i, j10, i11);
    }

    public void b0(f1 f1Var) {
        p1 p1Var = (p1) ((p.i) this.f13537p).get(f1Var);
        if (p1Var == null) {
            return;
        }
        p1Var.f2386a &= -2;
    }

    @Override // j9.t0
    public Object c() {
        u0 u0Var = (u0) this.f13537p;
        Bundle bundle = (Bundle) this.f13538q;
        int i10 = bundle.getInt("session_id");
        if (i10 == 0) {
            return Boolean.FALSE;
        }
        HashMap hashMap = u0Var.f7460c;
        k9.e eVar = u0Var.f7462e;
        Integer valueOf = Integer.valueOf(i10);
        if (hashMap.containsKey(valueOf)) {
            q0 q0Var = u0Var.a(i10).f7426c;
            String str = q0Var.f7416a;
            int i11 = bundle.getInt(com.bumptech.glide.e.a("status", str));
            int i12 = q0Var.f7419d;
            if (j9.k0.f(i12, i11)) {
                u0.f7457f.d("Found stale update for session %s with status %d.", valueOf, Integer.valueOf(i12));
                int i13 = q0Var.f7419d;
                if (i13 == 4) {
                    ((x1) eVar.c()).d(i10, str);
                } else if (i13 == 5) {
                    ((x1) eVar.c()).c(i10);
                } else if (i13 == 6) {
                    ((x1) eVar.c()).a(Arrays.asList(str));
                }
            } else {
                q0Var.f7419d = i11;
                if (i11 == 5 || i11 == 6 || i11 == 4) {
                    u0Var.b(new app.shamel.tv.b(i10, 8, u0Var));
                    u0Var.f7459b.a(str);
                } else {
                    ArrayList arrayList = q0Var.f7421f;
                    int size = arrayList.size();
                    int i14 = 0;
                    while (i14 < size) {
                        Object obj = arrayList.get(i14);
                        i14++;
                        s0 s0Var = (s0) obj;
                        ArrayList parcelableArrayList = bundle.getParcelableArrayList(com.bumptech.glide.e.b("chunk_intents", str, s0Var.f7433a));
                        if (parcelableArrayList != null) {
                            for (int i15 = 0; i15 < parcelableArrayList.size(); i15++) {
                                if (parcelableArrayList.get(i15) != null && ((Intent) parcelableArrayList.get(i15)).getData() != null) {
                                    ((j9.p0) s0Var.f7436d.get(i15)).f7413a = true;
                                }
                            }
                        }
                    }
                }
            }
        } else {
            ArrayList<String> stringArrayList = bundle.getStringArrayList("pack_names");
            if (stringArrayList == null || stringArrayList.isEmpty()) {
                throw new j9.j0("Session without pack received.");
            }
            String str2 = stringArrayList.get(0);
            long j10 = bundle.getLong(com.bumptech.glide.e.a("pack_version", str2));
            String string = bundle.getString(com.bumptech.glide.e.a("pack_version_tag", str2), _UrlKt.FRAGMENT_ENCODE_SET);
            int i16 = bundle.getInt(com.bumptech.glide.e.a("status", str2));
            long j11 = bundle.getLong(com.bumptech.glide.e.a("total_bytes_to_download", str2));
            List<String> stringArrayList2 = bundle.getStringArrayList(com.bumptech.glide.e.a("slice_ids", str2));
            ArrayList arrayList2 = new ArrayList();
            if (stringArrayList2 == null) {
                stringArrayList2 = Collections.EMPTY_LIST;
            }
            for (String str3 : stringArrayList2) {
                List parcelableArrayList2 = bundle.getParcelableArrayList(com.bumptech.glide.e.b("chunk_intents", str2, str3));
                ArrayList arrayList3 = new ArrayList();
                if (parcelableArrayList2 == null) {
                    parcelableArrayList2 = Collections.EMPTY_LIST;
                }
                Iterator it = parcelableArrayList2.iterator();
                while (it.hasNext()) {
                    boolean z10 = ((Intent) it.next()) != null;
                    long j12 = j11;
                    j9.p0 p0Var = new j9.p0();
                    p0Var.f7413a = z10;
                    arrayList3.add(p0Var);
                    j11 = j12;
                }
                long j13 = j11;
                String string2 = bundle.getString(com.bumptech.glide.e.b("uncompressed_hash_sha256", str2, str3));
                long j14 = bundle.getLong(com.bumptech.glide.e.b("uncompressed_size", str2, str3));
                int i17 = bundle.getInt(com.bumptech.glide.e.b("patch_format", str2, str3), 0);
                arrayList2.add(i17 != 0 ? new s0(str3, string2, j14, arrayList3, 0, i17) : new s0(str3, string2, j14, arrayList3, bundle.getInt(com.bumptech.glide.e.b("compression_format", str2, str3), 0), 0));
                j11 = j13;
            }
            u0Var.f7460c.put(Integer.valueOf(i10), new r0(i10, bundle.getInt("app_version_code"), new q0(str2, j10, i16, j11, arrayList2, string)));
        }
        return Boolean.TRUE;
    }

    public Object c0() {
        u5.c cVar = (u5.c) this.f13537p;
        u5.c cVar2 = cVar.f12528d;
        while (true) {
            boolean equals = cVar2.equals(cVar);
            Object obj = cVar2.f12525a;
            if (equals) {
                return null;
            }
            ArrayList arrayList = cVar2.f12526b;
            int size = arrayList != null ? arrayList.size() : 0;
            Object remove = size > 0 ? cVar2.f12526b.remove(size - 1) : null;
            if (remove != null) {
                return remove;
            }
            u5.c cVar3 = cVar2.f12528d;
            cVar3.f12527c = cVar2.f12527c;
            cVar2.f12527c.f12528d = cVar3;
            ((HashMap) this.f13538q).remove(obj);
            ((u5.h) obj).a();
            cVar2 = cVar2.f12528d;
        }
    }

    @Override // z1.m
    public void d(Bundle bundle) {
        ((MediaCodec) this.f13537p).setParameters(bundle);
    }

    public void d0(f1 f1Var) {
        p.g gVar = (p.g) this.f13538q;
        int h10 = gVar.h() - 1;
        while (true) {
            if (h10 < 0) {
                break;
            }
            if (f1Var == gVar.i(h10)) {
                Object[] objArr = gVar.f9775q;
                Object obj = objArr[h10];
                Object obj2 = p.h.f9777a;
                if (obj != obj2) {
                    objArr[h10] = obj2;
                    gVar.f9773o = true;
                }
            } else {
                h10--;
            }
        }
        p1 p1Var = (p1) ((p.i) this.f13537p).remove(f1Var);
        if (p1Var != null) {
            p1Var.f2386a = 0;
            p1Var.f2387b = null;
            p1Var.f2388c = null;
            p1.f2385d.m(p1Var);
        }
    }

    @Override // z1.m
    public void e(int i10, int i11, long j10, int i12) {
        ((MediaCodec) this.f13537p).queueInputBuffer(i10, 0, i11, j10, i12);
    }

    public void e0(p4.l lVar, int i10) {
        za.h.e("workSpecId", lVar);
        ((i) this.f13538q).g(new y4.m((p4.f) this.f13537p, lVar, false, i10));
    }

    @Override // z1.m
    public int f(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = ((MediaCodec) this.f13537p).dequeueOutputBuffer(bufferInfo, 0L);
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    @Override // z1.m
    public void flush() {
        ((MediaCodec) this.f13537p).flush();
    }

    @Override // l7.o
    public void g(long j10, long j11, long j12, String str) {
        l7.o oVar = (l7.o) this.f13537p;
        if (oVar != null) {
            oVar.g(j10, j11, j12, str);
        }
    }

    @Override // z1.m
    public void h(int i10) {
        ((MediaCodec) this.f13537p).releaseOutputBuffer(i10, false);
    }

    @Override // z1.m
    public void i(i2.k kVar, Handler handler) {
        ((MediaCodec) this.f13537p).setOnFrameRenderedListener(new z1.b(this, kVar, 1), handler);
    }

    @Override // z1.m
    public /* synthetic */ boolean j(x5.b0 b0Var) {
        return false;
    }

    @Override // a6.r
    public void k(Bitmap bitmap, u5.a aVar) {
        IOException iOException = ((m6.e) this.f13538q).f9012p;
        if (iOException != null) {
            if (bitmap == null) {
                throw iOException;
            }
            aVar.g(bitmap);
            throw iOException;
        }
    }

    @Override // com.bumptech.glide.load.data.c
    public void l(Exception exc) {
        t5.b0 b0Var = (t5.b0) this.f13538q;
        x5.s sVar = (x5.s) this.f13537p;
        x5.s sVar2 = b0Var.f11901t;
        if (sVar2 == null || sVar2 != sVar) {
            return;
        }
        t5.b0 b0Var2 = (t5.b0) this.f13538q;
        x5.s sVar3 = (x5.s) this.f13537p;
        t5.h hVar = b0Var2.f11897p;
        t5.d dVar = b0Var2.f11902u;
        com.bumptech.glide.load.data.d dVar2 = sVar3.f13666c;
        hVar.a(dVar, exc, dVar2, dVar2.c());
    }

    @Override // z1.m
    public void m(int i10) {
        ((MediaCodec) this.f13537p).setVideoScalingMode(i10);
    }

    @Override // l7.o
    public void n(String str, long j10, int i10, Object obj, long j11, long j12) {
        int i11;
        l7.n nVar = (l7.n) this.f13538q;
        if (((l7.o) this.f13537p) != null) {
            if (i10 == 2001) {
                Object[] objArr = {Integer.valueOf(nVar.f8288i)};
                l7.b bVar = nVar.f8308a;
                Log.w(bVar.f8271a, bVar.d("Possibility of local queue out of sync with receiver queue. Refetching sequence number. Current Local Sequence Number = %d", objArr));
                Iterator it = ((i7.h) nVar.f8287h.f5610p).f6504i.iterator();
                while (it.hasNext()) {
                    ((i7.g) it.next()).m();
                }
                i11 = 2001;
            } else {
                i11 = i10;
            }
            ((l7.o) this.f13537p).n(str, j10, i11, obj, j11, j12);
        }
    }

    @Override // z1.m
    public MediaFormat o() {
        return ((MediaCodec) this.f13537p).getOutputFormat();
    }

    @Override // com.bumptech.glide.load.data.c
    public void p(Object obj) {
        t5.b0 b0Var = (t5.b0) this.f13538q;
        x5.s sVar = (x5.s) this.f13537p;
        x5.s sVar2 = b0Var.f11901t;
        if (sVar2 == null || sVar2 != sVar) {
            return;
        }
        t5.b0 b0Var2 = (t5.b0) this.f13538q;
        x5.s sVar3 = (x5.s) this.f13537p;
        t5.j jVar = b0Var2.f11896o.f11928p;
        if (obj != null && jVar.a(sVar3.f13666c.c())) {
            b0Var2.f11900s = obj;
            b0Var2.f11897p.o(2);
        } else {
            t5.h hVar = b0Var2.f11897p;
            r5.e eVar = sVar3.f13664a;
            com.bumptech.glide.load.data.d dVar = sVar3.f13666c;
            hVar.c(eVar, obj, dVar, dVar.c(), b0Var2.f11902u);
        }
    }

    @Override // z1.m
    public void q() {
        ((MediaCodec) this.f13537p).detachOutputSurface();
    }

    @Override // z1.m
    public ByteBuffer r(int i10) {
        return ((MediaCodec) this.f13537p).getInputBuffer(i10);
    }

    @Override // z1.m
    public void s(Surface surface) {
        ((MediaCodec) this.f13537p).setOutputSurface(surface);
    }

    @Override // h5.g0
    public void t() {
        MovieSecondActivity movieSecondActivity = (MovieSecondActivity) this.f13538q;
        Toast.makeText(movieSecondActivity, movieSecondActivity.Z.getPut_pin_code(), 0).show();
    }

    public String toString() {
        switch (this.f13536o) {
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                String str = "[ ";
                if (((s.f) this.f13537p) != null) {
                    for (int i10 = 0; i10 < 9; i10++) {
                        str = str + ((s.f) this.f13537p).f11137v[i10] + " ";
                    }
                }
                StringBuilder a10 = s.e.a(str, "] ");
                a10.append((s.f) this.f13537p);
                return a10.toString();
            case 17:
            default:
                return super.toString();
            case 18:
                StringBuilder sb2 = new StringBuilder("GroupedLinkedMap( ");
                u5.c cVar = (u5.c) this.f13537p;
                u5.c cVar2 = cVar.f12527c;
                boolean z10 = false;
                while (!cVar2.equals(cVar)) {
                    sb2.append('{');
                    sb2.append(cVar2.f12525a);
                    sb2.append(':');
                    ArrayList arrayList = cVar2.f12526b;
                    sb2.append(arrayList != null ? arrayList.size() : 0);
                    sb2.append("}, ");
                    cVar2 = cVar2.f12527c;
                    z10 = true;
                }
                if (z10) {
                    sb2.delete(sb2.length() - 2, sb2.length());
                }
                sb2.append(" )");
                return sb2.toString();
        }
    }

    @Override // h5.g0
    public void u() {
        MovieSecondActivity movieSecondActivity = (MovieSecondActivity) this.f13538q;
        Toast.makeText(movieSecondActivity, movieSecondActivity.Z.getPin_incorrect(), 0).show();
    }

    @Override // z1.m
    public ByteBuffer v(int i10) {
        return ((MediaCodec) this.f13537p).getOutputBuffer(i10);
    }

    @Override // z1.m
    public void w(int i10, long j10) {
        ((MediaCodec) this.f13537p).releaseOutputBuffer(i10, j10);
    }

    @Override // z1.m
    public int x() {
        return ((MediaCodec) this.f13537p).dequeueInputBuffer(0L);
    }

    @Override // h5.g0
    public void y() {
        MovieSecondActivity movieSecondActivity = (MovieSecondActivity) this.f13538q;
        Intent intent = new Intent(movieSecondActivity, (Class<?>) MovieInfoActivity.class);
        MovieModel movieModel = (MovieModel) this.f13537p;
        intent.putExtra("name", movieModel.getName());
        intent.putExtra("stream_id", movieModel.getStream_id());
        if (movieSecondActivity.P.g()) {
            intent.putExtra("category_name", movieModel.getCategory_name());
        } else {
            intent.putExtra("category_name", MovieSecondActivity.u(movieModel.getCategory_id()));
        }
        movieSecondActivity.startActivity(intent);
    }

    @Override // i8.a
    public void z(i8.i iVar) {
        boolean z10;
        h7.c cVar;
        com.google.android.gms.internal.cast.q qVar = (com.google.android.gms.internal.cast.q) this.f13537p;
        h7.c cVar2 = (h7.c) this.f13538q;
        w3.b0 b0Var = qVar.f3433d;
        l7.b bVar = com.google.android.gms.internal.cast.q.f3432i;
        if (iVar.n()) {
            Bundle bundle = (Bundle) iVar.l();
            boolean z11 = bundle != null && bundle.containsKey("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
            bVar.b("The module-to-client output switcher flag %s", true != z11 ? "not existed" : "existed");
            if (z11) {
                z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_OUTPUT_SWITCHER_ENABLED");
                Log.i(bVar.f8271a, bVar.d("Set up output switcher flags: %b (from module), %b (from CastOptions)", Boolean.valueOf(z10), Boolean.valueOf(cVar2.A)));
                boolean z12 = !z10 && cVar2.A;
                if (b0Var != null || (cVar = qVar.f3434e) == null) {
                }
                boolean z13 = cVar.f5722y;
                boolean z14 = cVar.f5721x;
                e3.d dVar = new e3.d();
                int i10 = Build.VERSION.SDK_INT;
                dVar.f4425a = i10 >= 30;
                if (i10 >= 30) {
                    dVar.f4425a = z12;
                }
                if (i10 >= 30) {
                    dVar.f4427c = z13;
                }
                if (i10 >= 30) {
                    dVar.f4426b = z14;
                }
                w3.g0 g0Var = new w3.g0(dVar);
                w3.b0.b();
                w c10 = w3.b0.c();
                w3.g0 g0Var2 = c10.f13045q;
                c10.f13045q = g0Var;
                if (c10.f()) {
                    if (c10.f13035f == null) {
                        w3.g gVar = new w3.g(c10.f13030a, new w3.s(c10));
                        c10.f13035f = gVar;
                        c10.a(gVar, true);
                        c10.l();
                        w3.q0 q0Var = c10.f13033d;
                        ((Handler) q0Var.f13001d).post((p0.b) q0Var.f13004h);
                    }
                    if ((g0Var2 != null && g0Var2.f12927c) != g0Var.f12927c) {
                        w3.g gVar2 = c10.f13035f;
                        gVar2.f12971e = c10.f13054z;
                        if (!gVar2.f12972f) {
                            gVar2.f12972f = true;
                            gVar2.f12969c.sendEmptyMessage(2);
                        }
                    }
                } else {
                    w3.g gVar3 = c10.f13035f;
                    if (gVar3 != null) {
                        c10.i(gVar3);
                        c10.f13035f = null;
                        w3.q0 q0Var2 = c10.f13033d;
                        ((Handler) q0Var2.f13001d).post((p0.b) q0Var2.f13004h);
                    }
                }
                c10.f13042n.b(769, g0Var);
                Log.i(bVar.f8271a, bVar.d("media transfer = %b, session transfer = %b, transfer to local = %b, in-app output switcher = %b", Boolean.valueOf(qVar.f3436h), Boolean.valueOf(z12), Boolean.valueOf(z13), Boolean.valueOf(z14)));
                if (z13) {
                    com.google.android.gms.internal.cast.t tVar = qVar.g;
                    r7.r.e(tVar);
                    com.google.android.gms.internal.cast.p pVar = new com.google.android.gms.internal.cast.p(tVar);
                    w3.b0.b();
                    w3.b0.c().B = pVar;
                    y1.a(z0.CAST_TRANSFER_TO_LOCAL_ENABLED);
                    return;
                }
                return;
            }
        }
        z10 = true;
        Log.i(bVar.f8271a, bVar.d("Set up output switcher flags: %b (from module), %b (from CastOptions)", Boolean.valueOf(z10), Boolean.valueOf(cVar2.A)));
        if (z10) {
        }
        if (b0Var != null) {
        }
    }

    public /* synthetic */ c(Object obj, Object obj2, int i10, boolean z10) {
        this.f13536o = i10;
        this.f13538q = obj;
        this.f13537p = obj2;
    }

    public c(WorkDatabase_Impl workDatabase_Impl) {
        this.f13536o = 0;
        this.f13537p = workDatabase_Impl;
        this.f13538q = new b(workDatabase_Impl, 0);
    }

    public c(int i10) {
        this.f13536o = i10;
        switch (i10) {
            case 7:
                this.f13537p = new AtomicReference();
                this.f13538q = new p.e(0);
                break;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                List list = Collections.EMPTY_LIST;
                this.f13537p = list;
                this.f13538q = list;
                break;
            case 18:
                this.f13537p = new u5.c(null);
                this.f13538q = new HashMap();
                break;
            case 19:
                this.f13537p = new m6.j(1000L);
                this.f13538q = n6.c.a(10, new w1(23));
                break;
            default:
                this.f13537p = new p.i(0);
                this.f13538q = new p.g();
                break;
        }
    }

    public c(s.d dVar) {
        this.f13536o = 16;
        this.f13538q = dVar;
    }

    public c(i0 i0Var) {
        this.f13536o = 2;
        this.f13537p = new CopyOnWriteArrayList();
        this.f13538q = i0Var;
    }

    public c(p4.f fVar, i iVar) {
        this.f13536o = 14;
        za.h.e("processor", fVar);
        za.h.e("workTaskExecutor", iVar);
        this.f13537p = fVar;
        this.f13538q = iVar;
    }

    public c(v1 v1Var) {
        this.f13536o = 12;
        n5.a aVar = new n5.a();
        this.f13537p = v1Var;
        this.f13538q = aVar;
    }

    public c(MediaCodec mediaCodec, z1.k kVar) {
        boolean addMediaCodec;
        this.f13536o = 20;
        this.f13537p = mediaCodec;
        this.f13538q = kVar;
        if (Build.VERSION.SDK_INT < 35 || kVar == null) {
            return;
        }
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) kVar.f13998c;
        if (loudnessCodecController != null) {
            addMediaCodec = loudnessCodecController.addMediaCodec(mediaCodec);
            if (!addMediaCodec) {
                return;
            }
        }
        l1.d.g(((HashSet) kVar.f13996a).add(mediaCodec));
    }

    public c(MediaCodec.CryptoInfo cryptoInfo) {
        this.f13536o = 15;
        this.f13537p = cryptoInfo;
        this.f13538q = k0.c.b();
    }
}
