package h5;

import android.content.ClipData;
import android.content.ClipDescription;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.SystemClock;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.Surface;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.gms.common.api.Status;
import com.google.android.material.behavior.SwipeDismissBehavior;
import i1.f1;
import j9.d1;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import m.a2;
import m.s2;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class i implements i2.l0, l7.o, i8.c, i8.b, k9.f, a2, l.w, l.j, m.t0, m0.c, m0.e, n0.q {

    /* renamed from: q, reason: collision with root package name */
    public static i f5608q;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f5609o;

    /* renamed from: p, reason: collision with root package name */
    public Object f5610p;

    public /* synthetic */ i(int i10, Object obj) {
        this.f5609o = i10;
        this.f5610p = obj;
    }

    public static String B(HashMap hashMap, String str) {
        String str2 = (String) hashMap.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = (String) hashMap.get("tvg-".concat(str));
        return str3 != null ? str3 : (String) hashMap.get(str.concat("-tvg"));
    }

    public static HashMap D(String str) {
        HashMap hashMap = new HashMap();
        if (str != null && !str.equals(_UrlKt.FRAGMENT_ENCODE_SET)) {
            StringBuffer stringBuffer = new StringBuffer();
            char charAt = str.charAt(0);
            if (charAt == '-' || Character.isDigit(charAt)) {
                stringBuffer.append(charAt);
                int i10 = 0;
                while (true) {
                    i10++;
                    if (i10 >= str.length()) {
                        break;
                    }
                    char charAt2 = str.charAt(i10);
                    if (!Character.isDigit(charAt2)) {
                        break;
                    }
                    stringBuffer.append(charAt2);
                }
                hashMap.put("duration", stringBuffer.toString());
                String replaceFirst = str.replaceFirst(stringBuffer.toString(), _UrlKt.FRAGMENT_ENCODE_SET);
                str = replaceFirst == null ? null : replaceFirst.trim();
                stringBuffer.delete(0, stringBuffer.length());
            }
            String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
            int i11 = 0;
            boolean z10 = false;
            int i12 = 1;
            while (i11 < str.length()) {
                int i13 = i11 + 1;
                char charAt3 = str.charAt(i11);
                int i14 = ja.b.f7515a[s.e.b(i12)];
                int i15 = 2;
                if (i14 != 1) {
                    if (i14 != 2) {
                        i15 = 4;
                        if (i14 != 3) {
                            if (i14 == 4) {
                                if (z10) {
                                    while (charAt3 != '\"' && i13 < str.length()) {
                                        stringBuffer.append(charAt3);
                                        charAt3 = str.charAt(i13);
                                        i13++;
                                    }
                                    if (stringBuffer.length() > 0) {
                                        hashMap.put(str2, stringBuffer.toString());
                                        stringBuffer.delete(0, stringBuffer.length());
                                    }
                                } else if (Character.isWhitespace(charAt3)) {
                                    if (stringBuffer.length() > 0) {
                                        hashMap.put(str2, stringBuffer.toString());
                                        stringBuffer.delete(0, stringBuffer.length());
                                    }
                                    str2 = _UrlKt.FRAGMENT_ENCODE_SET;
                                } else {
                                    stringBuffer.append(charAt3);
                                }
                                i12 = 1;
                            }
                        } else if (!Character.isWhitespace(charAt3)) {
                            if (charAt3 == '\"') {
                                z10 = true;
                            } else {
                                stringBuffer.append(charAt3);
                            }
                            i11 = i13;
                            i12 = i15;
                        }
                    } else if (charAt3 == '=') {
                        String str3 = str2 + stringBuffer.toString();
                        str2 = str3 == null ? null : str3.trim();
                        stringBuffer.delete(0, stringBuffer.length());
                        i11 = i13;
                        i12 = 3;
                    } else {
                        stringBuffer.append(charAt3);
                    }
                    i11 = i13;
                } else {
                    if (!Character.isWhitespace(charAt3)) {
                        if (charAt3 == ',') {
                            hashMap.put("channel_name", str.substring(i13));
                        } else {
                            stringBuffer.append(charAt3);
                            i11 = i13;
                            i12 = i15;
                        }
                    }
                    i11 = i13;
                }
            }
            if (!str2.equals(_UrlKt.FRAGMENT_ENCODE_SET) && stringBuffer.length() > 0) {
                hashMap.put(str2, stringBuffer.toString());
                stringBuffer.delete(0, stringBuffer.length());
                return hashMap;
            }
        }
        return hashMap;
    }

    public static x4.i E(String str) {
        HashMap D = D(str);
        x4.i iVar = new x4.i(7, false);
        iVar.f13554q = B(D, "name");
        iVar.f13556s = B(D, "type");
        iVar.f13553p = B(D, "dlna_extras");
        iVar.f13555r = B(D, "plugin");
        return iVar;
    }

    public static ja.a F(String str) {
        int i10;
        HashMap D = D(str);
        ja.a aVar = new ja.a();
        aVar.f7507a = B(D, "id");
        aVar.f7508b = B(D, "channel_name");
        try {
            i10 = Integer.parseInt(B(D, "duration"));
        } catch (Exception unused) {
            i10 = -1;
        }
        aVar.f7510d = i10;
        aVar.f7512f = B(D, "logo");
        aVar.f7511e = B(D, "group-title");
        aVar.f7514i = B(D, "type");
        aVar.f7509c = B(D, "dlna_extras");
        aVar.g = B(D, "plugin");
        return aVar;
    }

    public n0.g A(int i10) {
        return null;
    }

    public FileChannel C() {
        switch (this.f5609o) {
            case 26:
                return new FileInputStream((File) this.f5610p).getChannel();
            default:
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) this.f5610p;
                if (parcelFileDescriptor.getStatSize() != -1) {
                    return new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor).getChannel();
                }
                parcelFileDescriptor.close();
                throw new IllegalArgumentException("Not a file: " + parcelFileDescriptor);
        }
    }

    public boolean G(int i10, int i11, Bundle bundle) {
        return false;
    }

    public void H(m5.i iVar, c4.e eVar, app.shamel.tv.activities.y yVar) {
        synchronized (iVar.f8978s) {
            iVar.f8983x = true;
        }
        iVar.a("post-response");
        ((i0.d) this.f5610p).execute(new g7.c0(iVar, eVar, yVar, 6));
    }

    @Override // m0.e
    public ClipData b() {
        ClipData clip;
        clip = ((ContentInfo) this.f5610p).getClip();
        return clip;
    }

    @Override // m0.c
    public m0.f build() {
        ContentInfo build;
        build = ((ContentInfo.Builder) this.f5610p).build();
        return new m0.f(new i(build));
    }

    @Override // k9.f
    public Object c() {
        switch (this.f5609o) {
            case 8:
                return new j9.w(new k9.e(new i(12, (d1) this.f5610p)));
            case 9:
            default:
                return ((k9.f) this.f5610p).c();
            case 10:
                return ((androidx.emoji2.text.o) this.f5610p).f591o;
        }
    }

    @Override // m0.e
    public int d() {
        int flags;
        flags = ((ContentInfo) this.f5610p).getFlags();
        return flags;
    }

    @Override // l.w
    public void e(l.l lVar, boolean z10) {
        if (lVar instanceof l.d0) {
            ((l.d0) lVar).f7958z.k().c(false);
        }
        l.w wVar = ((m.k) this.f5610p).f8454s;
        if (wVar != null) {
            wVar.e(lVar, z10);
        }
    }

    @Override // n0.q
    public boolean f(View view) {
        SwipeDismissBehavior swipeDismissBehavior = (SwipeDismissBehavior) this.f5610p;
        if (!swipeDismissBehavior.r(view)) {
            return false;
        }
        boolean z10 = view.getLayoutDirection() == 1;
        int i10 = swipeDismissBehavior.f3677d;
        int width = (!(i10 == 0 && z10) && (i10 != 1 || z10)) ? view.getWidth() : -view.getWidth();
        WeakHashMap weakHashMap = m0.k0.f8683a;
        view.offsetLeftAndRight(width);
        view.setAlpha(0.0f);
        return true;
    }

    @Override // l7.o
    public void g(long j10, long j11, long j12, String str) {
        i7.n nVar = (i7.n) this.f5610p;
        try {
            nVar.R(new i7.l(new Status(2103, null, null, null), 1));
        } catch (IllegalStateException e7) {
            l7.b bVar = i7.h.f6496k;
            Log.e(bVar.f8271a, bVar.d("Result already set when calling onRequestReplaced", new Object[0]), e7);
        }
        Iterator it = nVar.f6515q.f6504i.iterator();
        while (it.hasNext()) {
            ((i7.g) it.next()).f(str, j10, 2103, j11, j12);
        }
    }

    @Override // m0.e
    public int getSource() {
        int source;
        source = ((ContentInfo) this.f5610p).getSource();
        return source;
    }

    @Override // l.j
    public boolean h(l.l lVar, MenuItem menuItem) {
        m.n nVar = ((ActionMenuView) this.f5610p).N;
        if (nVar == null) {
            return false;
        }
        Iterator it = ((CopyOnWriteArrayList) ((s2) nVar).f8554o.U.f13565q).iterator();
        while (it.hasNext()) {
            if (((androidx.fragment.app.b0) it.next()).f661a.o()) {
                return true;
            }
        }
        return false;
    }

    @Override // i2.l0
    public void i() {
        i2.l lVar = (i2.l) this.f5610p;
        Surface surface = lVar.f6237k1;
        if (surface != null) {
            i2.k0 k0Var = lVar.W0;
            Handler handler = k0Var.f6226b;
            if (handler != null) {
                handler.post(new i2.h0(k0Var, surface, SystemClock.elapsedRealtime()));
            }
            lVar.f6240n1 = true;
        }
    }

    @Override // i2.l0
    public void k() {
        i2.l lVar = (i2.l) this.f5610p;
        if (lVar.f6237k1 != null) {
            lVar.M0(0, 1);
        }
    }

    @Override // i8.c
    public void l(Object obj) {
        switch (this.f5609o) {
            case 7:
                ((CountDownLatch) this.f5610p).countDown();
                break;
            default:
                j9.p pVar = (j9.p) this.f5610p;
                List list = (List) obj;
                int a10 = pVar.f7412b.a();
                ArrayList e7 = pVar.e();
                int size = e7.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = e7.get(i10);
                    i10++;
                    File file = (File) obj2;
                    if (!list.contains(file.getName()) && j9.p.b(file) != a10) {
                        j9.p.f(file);
                    }
                }
                break;
        }
    }

    @Override // m.a2
    public void m(l.l lVar, l.n nVar) {
        l.f fVar = (l.f) this.f5610p;
        Handler handler = fVar.f7966t;
        handler.removeCallbacksAndMessages(null);
        ArrayList arrayList = fVar.f7968v;
        int size = arrayList.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                i10 = -1;
                break;
            } else if (lVar == ((l.e) arrayList.get(i10)).f7960b) {
                break;
            } else {
                i10++;
            }
        }
        if (i10 == -1) {
            return;
        }
        int i11 = i10 + 1;
        handler.postAtTime(new com.google.android.gms.internal.cast.o(this, i11 < arrayList.size() ? (l.e) arrayList.get(i11) : null, nVar, lVar, 1), lVar, SystemClock.uptimeMillis() + 200);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004d A[LOOP:0: B:16:0x0047->B:18:0x004d, LOOP_END] */
    @Override // l7.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(java.lang.String r14, long r15, int r17, java.lang.Object r18, long r19, long r21) {
        /*
            r13 = this;
            java.lang.Object r0 = r13.f5610p
            r1 = r0
            i7.n r1 = (i7.n) r1
            i7.l r0 = new i7.l     // Catch: java.lang.IllegalStateException -> L2c
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status     // Catch: java.lang.IllegalStateException -> L2c
            r3 = 0
            r8 = r17
            r2.<init>(r8, r3, r3, r3)     // Catch: java.lang.IllegalStateException -> L1e
            r4 = 1
            r5 = r18
            boolean r6 = r5 instanceof l7.m
            if (r4 == r6) goto L17
            goto L18
        L17:
            r3 = r5
        L18:
            if (r3 == 0) goto L20
            r4 = r3
            l7.m r4 = (l7.m) r4     // Catch: java.lang.IllegalStateException -> L1e
            goto L20
        L1e:
            r0 = move-exception
            goto L2f
        L20:
            if (r3 == 0) goto L24
            l7.m r3 = (l7.m) r3     // Catch: java.lang.IllegalStateException -> L1e
        L24:
            r3 = 2
            r0.<init>(r2, r3)     // Catch: java.lang.IllegalStateException -> L1e
            r1.R(r0)     // Catch: java.lang.IllegalStateException -> L1e
            goto L3f
        L2c:
            r0 = move-exception
            r8 = r17
        L2f:
            l7.b r2 = i7.h.f6496k
            r3 = 0
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r2.f8271a
            java.lang.String r5 = "Result already set when calling onRequestCompleted"
            java.lang.String r2 = r2.d(r5, r3)
            android.util.Log.e(r4, r2, r0)
        L3f:
            i7.h r0 = r1.f6515q
            java.util.concurrent.CopyOnWriteArrayList r0 = r0.f6504i
            java.util.Iterator r0 = r0.iterator()
        L47:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L60
            java.lang.Object r1 = r0.next()
            r4 = r1
            i7.g r4 = (i7.g) r4
            r5 = r14
            r6 = r15
            r9 = r19
            r11 = r21
            r4.f(r5, r6, r8, r9, r11)
            r8 = r17
            goto L47
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.i.n(java.lang.String, long, int, java.lang.Object, long, long):void");
    }

    @Override // i2.l0
    public void o() {
        s1.d0 d0Var = ((i2.l) this.f5610p).U;
        if (d0Var != null) {
            d0Var.a();
        }
    }

    @Override // l.w
    public boolean p(l.l lVar) {
        m.k kVar = (m.k) this.f5610p;
        if (lVar == kVar.f8452q) {
            return false;
        }
        ((l.d0) lVar).A.getClass();
        kVar.getClass();
        l.w wVar = kVar.f8454s;
        if (wVar != null) {
            return wVar.p(lVar);
        }
        return false;
    }

    @Override // m.a2
    public void q(l.l lVar, MenuItem menuItem) {
        ((l.f) this.f5610p).f7966t.removeCallbacksAndMessages(lVar);
    }

    @Override // l.j
    public void r(l.l lVar) {
        s2 s2Var = ((ActionMenuView) this.f5610p).I;
        if (s2Var != null) {
            s2Var.r(lVar);
        }
    }

    @Override // m0.e
    public ContentInfo s() {
        return (ContentInfo) this.f5610p;
    }

    @Override // m0.c
    public void setExtras(Bundle bundle) {
        ((ContentInfo.Builder) this.f5610p).setExtras(bundle);
    }

    public String toString() {
        switch (this.f5609o) {
            case 19:
                return "ContentInfoCompat{" + ((ContentInfo) this.f5610p) + "}";
            default:
                return super.toString();
        }
    }

    @Override // m0.c
    public void u(Uri uri) {
        ((ContentInfo.Builder) this.f5610p).setLinkUri(uri);
    }

    @Override // i8.b
    public void w(Exception exc) {
        ((CountDownLatch) this.f5610p).countDown();
    }

    @Override // m0.c
    public void x(int i10) {
        ((ContentInfo.Builder) this.f5610p).setFlags(i10);
    }

    public void y(int i10, boolean z10) {
        ea.a aVar = (ea.a) this.f5610p;
        if (z10) {
            aVar.a(i10);
        } else {
            aVar.getClass();
        }
    }

    public n0.g z(int i10) {
        return null;
    }

    public i(Handler handler) {
        this.f5609o = 20;
        this.f5610p = new i0.d(handler, 2);
    }

    public i(i1.d dVar) {
        this.f5609o = 2;
        AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            usage.setAllowedCapturePolicy(1);
        }
        if (i10 >= 32) {
            usage.setSpatializationBehavior(0);
            usage.setIsContentSpatialized(false);
        }
        this.f5610p = usage.build();
    }

    public i(Uri uri, ClipDescription clipDescription, Uri uri2) {
        this.f5609o = 24;
        if (Build.VERSION.SDK_INT >= 25) {
            this.f5610p = new o0.f(uri, clipDescription, uri2);
        } else {
            this.f5610p = new x4.m(uri, clipDescription, uri2, 17);
        }
    }

    public i(ContentInfo contentInfo) {
        this.f5609o = 19;
        contentInfo.getClass();
        this.f5610p = a9.e.n(contentInfo);
    }

    public i(int i10) {
        Handler handler;
        Handler handler2;
        this.f5609o = i10;
        switch (i10) {
            case 7:
                this.f5610p = new CountDownLatch(1);
                return;
            case 11:
                return;
            case 22:
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f5610p = new n0.i(this);
                    return;
                } else {
                    this.f5610p = new n0.h(this);
                    return;
                }
            case 29:
                Looper mainLooper = Looper.getMainLooper();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler2 = c0.b.a(mainLooper);
                } else {
                    try {
                        handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
                    } catch (IllegalAccessException e7) {
                        e = e7;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.f5610p = handler2;
                        return;
                    } catch (InstantiationException e8) {
                        e = e8;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.f5610p = handler2;
                        return;
                    } catch (NoSuchMethodException e10) {
                        e = e10;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.f5610p = handler2;
                        return;
                    } catch (InvocationTargetException e11) {
                        Throwable cause = e11.getCause();
                        if (!(cause instanceof RuntimeException)) {
                            if (cause instanceof Error) {
                                throw ((Error) cause);
                            }
                            throw new RuntimeException(cause);
                        }
                        throw ((RuntimeException) cause);
                    }
                    handler2 = handler;
                }
                this.f5610p = handler2;
                return;
            default:
                this.f5610p = new ea.a(1);
                return;
        }
    }

    @Override // i2.l0
    public void a(f1 f1Var) {
    }

    @Override // m.t0
    public void j(int i10) {
    }

    @Override // m.t0
    public void t(int i10) {
    }

    public i(ClipData clipData, int i10) {
        this.f5609o = 18;
        this.f5610p = a9.e.l(clipData, i10);
    }

    @Override // m.t0
    public void v(int i10, float f10) {
    }
}
