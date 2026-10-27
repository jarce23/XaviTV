package k5;

import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import b4.b1;
import b4.o0;
import i1.g0;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import l1.s;
import m.a3;
import m.c3;
import o1.q;
import o1.u;
import org.chromium.net.CronetEngine;
import p1.p;
import x4.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static s f7817a;

    /* renamed from: b, reason: collision with root package name */
    public static n1.b f7818b;

    /* renamed from: c, reason: collision with root package name */
    public static p1.s f7819c;

    /* renamed from: d, reason: collision with root package name */
    public static File f7820d;

    /* renamed from: e, reason: collision with root package name */
    public static u f7821e;

    /* renamed from: f, reason: collision with root package name */
    public static Context f7822f;

    public static void a(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
        }
    }

    public static final ExecutorService b(boolean z10) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new o4.b(z10));
        za.h.d("newFixedThreadPool(\n    …)),\n        factory\n    )", newFixedThreadPool);
        return newFixedThreadPool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0025, code lost:
    
        if (r9.bottom <= r11.top) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r8 == 17) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (r8 != 66) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0047, code lost:
    
        r10 = t(r8, r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004b, code lost:
    
        if (r8 == 17) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r8 == 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r8 == 66) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r8 != 130) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
    
        r8 = r11.bottom;
        r9 = r9.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0072, code lost:
    
        if (r10 >= java.lang.Math.max(1, r8 - r9)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r8 = r11.right;
        r9 = r9.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        r8 = r9.top;
        r9 = r11.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0069, code lost:
    
        r8 = r9.left;
        r9 = r11.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0032, code lost:
    
        if (r9.right <= r11.left) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0039, code lost:
    
        if (r9.top >= r11.bottom) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0040, code lost:
    
        if (r9.left >= r11.right) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean c(int r8, android.graphics.Rect r9, android.graphics.Rect r10, android.graphics.Rect r11) {
        /*
            boolean r0 = d(r8, r9, r10)
            boolean r1 = d(r8, r9, r11)
            if (r1 != 0) goto L75
            if (r0 != 0) goto Le
            goto L75
        Le:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r2 = 33
            r3 = 66
            r4 = 17
            r5 = 1
            if (r8 == r4) goto L3c
            if (r8 == r2) goto L35
            if (r8 == r3) goto L2e
            if (r8 != r1) goto L28
            int r6 = r9.bottom
            int r7 = r11.top
            if (r6 > r7) goto L74
            goto L42
        L28:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L2e:
            int r6 = r9.right
            int r7 = r11.left
            if (r6 > r7) goto L74
            goto L42
        L35:
            int r6 = r9.top
            int r7 = r11.bottom
            if (r6 < r7) goto L74
            goto L42
        L3c:
            int r6 = r9.left
            int r7 = r11.right
            if (r6 < r7) goto L74
        L42:
            if (r8 == r4) goto L74
            if (r8 != r3) goto L47
            goto L74
        L47:
            int r10 = t(r8, r9, r10)
            if (r8 == r4) goto L69
            if (r8 == r2) goto L64
            if (r8 == r3) goto L5f
            if (r8 != r1) goto L59
            int r8 = r11.bottom
            int r9 = r9.bottom
        L57:
            int r8 = r8 - r9
            goto L6e
        L59:
            java.lang.IllegalArgumentException r8 = new java.lang.IllegalArgumentException
            r8.<init>(r0)
            throw r8
        L5f:
            int r8 = r11.right
            int r9 = r9.right
            goto L57
        L64:
            int r8 = r9.top
            int r9 = r11.top
            goto L57
        L69:
            int r8 = r9.left
            int r9 = r11.left
            goto L57
        L6e:
            int r8 = java.lang.Math.max(r5, r8)
            if (r10 >= r8) goto L75
        L74:
            return r5
        L75:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.a.c(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean d(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static s1.j e(Context context, boolean z10) {
        s1.j jVar = new s1.j(context.getApplicationContext());
        jVar.f11361c = z10 ? 2 : 1;
        return jVar;
    }

    public static int f(b1 b1Var, androidx.emoji2.text.g gVar, View view, View view2, o0 o0Var, boolean z10) {
        if (o0Var.x() == 0 || b1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return Math.abs(o0.N(view) - o0.N(view2)) + 1;
        }
        return Math.min(gVar.l(), gVar.b(view2) - gVar.e(view));
    }

    public static int g(b1 b1Var, androidx.emoji2.text.g gVar, View view, View view2, o0 o0Var, boolean z10, boolean z11) {
        if (o0Var.x() == 0 || b1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z11 ? Math.max(0, (b1Var.b() - Math.max(o0.N(view), o0.N(view2))) - 1) : Math.max(0, Math.min(o0.N(view), o0.N(view2)));
        if (z10) {
            return Math.round((max * (Math.abs(gVar.b(view2) - gVar.e(view)) / (Math.abs(o0.N(view) - o0.N(view2)) + 1))) + (gVar.k() - gVar.e(view)));
        }
        return max;
    }

    public static int h(b1 b1Var, androidx.emoji2.text.g gVar, View view, View view2, o0 o0Var, boolean z10) {
        if (o0Var.x() == 0 || b1Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z10) {
            return b1Var.b();
        }
        return (int) (((gVar.b(view2) - gVar.e(view)) / (Math.abs(o0.N(view) - o0.N(view2)) + 1)) * b1Var.b());
    }

    public static synchronized o1.g i(f.j jVar, boolean z10) {
        s sVar;
        synchronized (a.class) {
            try {
                if (f7817a == null) {
                    Context applicationContext = jVar.getApplicationContext();
                    r rVar = new r(applicationContext, n(applicationContext, z10));
                    p1.b k10 = k(applicationContext);
                    s sVar2 = new s();
                    sVar2.f8124r = new q();
                    sVar2.f8123q = k10;
                    sVar2.f8125s = rVar;
                    sVar2.f8121o = true;
                    sVar2.f8122p = 2;
                    f7817a = sVar2;
                }
                sVar = f7817a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public static synchronized n1.a j(Context context) {
        n1.b bVar;
        synchronized (a.class) {
            try {
                if (f7818b == null) {
                    f7818b = new n1.b(context.getApplicationContext(), "exoplayer_internal.db", null, 1);
                }
                bVar = f7818b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public static synchronized p1.b k(Context context) {
        p1.s sVar;
        synchronized (a.class) {
            try {
                if (f7819c == null) {
                    f7819c = new p1.s(new File(l(context), "downloads"), new p(), j(context));
                }
                sVar = f7819c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public static synchronized File l(Context context) {
        File file;
        synchronized (a.class) {
            try {
                if (f7820d == null) {
                    File externalFilesDir = context.getExternalFilesDir(null);
                    f7820d = externalFilesDir;
                    if (externalFilesDir == null) {
                        f7820d = context.getFilesDir();
                    }
                }
                file = f7820d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return file;
    }

    public static Set m() {
        try {
            Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", null).invoke(null, null);
            if (invoke == null) {
                return Collections.EMPTY_SET;
            }
            Set set = (Set) invoke;
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (!(it.next() instanceof int[])) {
                    return Collections.EMPTY_SET;
                }
            }
            return set;
        } catch (Throwable unused) {
            return Collections.EMPTY_SET;
        }
    }

    public static synchronized u n(Context context, boolean z10) {
        u uVar;
        synchronized (a.class) {
            try {
                if (f7821e == null) {
                    CronetEngine a10 = q1.g.a(context.getApplicationContext());
                    if (a10 != null) {
                        f7821e = new q1.c(a10, Executors.newSingleThreadExecutor());
                    }
                    if (f7821e == null) {
                        CookieManager cookieManager = new CookieManager();
                        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                        CookieHandler.setDefault(cookieManager);
                        f3.e eVar = new f3.e(1);
                        eVar.f4982q = z10;
                        eVar.f4984s = "samsung-agent/1";
                        f7821e = eVar;
                    }
                }
                uVar = f7821e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return uVar;
    }

    public static final Class o(eb.b bVar) {
        Class a10 = ((za.c) bVar).a();
        za.h.c("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>", a10);
        return a10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final Class p(eb.b bVar) {
        za.h.e("<this>", bVar);
        Class a10 = ((za.c) bVar).a();
        if (a10.isPrimitive()) {
            String name = a10.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.class;
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return Integer.class;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return Byte.class;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return Character.class;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return Long.class;
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return Void.class;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return Boolean.class;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.class;
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return Short.class;
                    }
                    break;
            }
        }
        return a10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int q(String str) {
        char c10;
        if (str == null) {
            return -1;
        }
        String m10 = g0.m(str);
        m10.getClass();
        switch (m10.hashCode()) {
            case -2123537834:
                if (m10.equals("audio/eac3-joc")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1662384011:
                if (m10.equals("video/mp2p")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1662384007:
                if (m10.equals("video/mp2t")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -1662095187:
                if (m10.equals("video/webm")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -1606874997:
                if (m10.equals("audio/amr-wb")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -1487656890:
                if (m10.equals("image/avif")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case -1487464693:
                if (m10.equals("image/heic")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case -1487464690:
                if (m10.equals("image/heif")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case -1487394660:
                if (m10.equals("image/jpeg")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case -1487018032:
                if (m10.equals("image/webp")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            case -1248337486:
                if (m10.equals("application/mp4")) {
                    c10 = '\n';
                    break;
                }
                c10 = 65535;
                break;
            case -1079884372:
                if (m10.equals("video/x-msvideo")) {
                    c10 = 11;
                    break;
                }
                c10 = 65535;
                break;
            case -1004728940:
                if (m10.equals("text/vtt")) {
                    c10 = '\f';
                    break;
                }
                c10 = 65535;
                break;
            case -879272239:
                if (m10.equals("image/bmp")) {
                    c10 = '\r';
                    break;
                }
                c10 = 65535;
                break;
            case -879258763:
                if (m10.equals("image/png")) {
                    c10 = 14;
                    break;
                }
                c10 = 65535;
                break;
            case -387023398:
                if (m10.equals("audio/x-matroska")) {
                    c10 = 15;
                    break;
                }
                c10 = 65535;
                break;
            case -43467528:
                if (m10.equals("application/webm")) {
                    c10 = 16;
                    break;
                }
                c10 = 65535;
                break;
            case 13915911:
                if (m10.equals("video/x-flv")) {
                    c10 = 17;
                    break;
                }
                c10 = 65535;
                break;
            case 187078296:
                if (m10.equals("audio/ac3")) {
                    c10 = 18;
                    break;
                }
                c10 = 65535;
                break;
            case 187078297:
                if (m10.equals("audio/ac4")) {
                    c10 = 19;
                    break;
                }
                c10 = 65535;
                break;
            case 187078669:
                if (m10.equals("audio/amr")) {
                    c10 = 20;
                    break;
                }
                c10 = 65535;
                break;
            case 187090232:
                if (m10.equals("audio/mp4")) {
                    c10 = 21;
                    break;
                }
                c10 = 65535;
                break;
            case 187091926:
                if (m10.equals("audio/ogg")) {
                    c10 = 22;
                    break;
                }
                c10 = 65535;
                break;
            case 187099443:
                if (m10.equals("audio/wav")) {
                    c10 = 23;
                    break;
                }
                c10 = 65535;
                break;
            case 1331848029:
                if (m10.equals("video/mp4")) {
                    c10 = 24;
                    break;
                }
                c10 = 65535;
                break;
            case 1503095341:
                if (m10.equals("audio/3gpp")) {
                    c10 = 25;
                    break;
                }
                c10 = 65535;
                break;
            case 1504578661:
                if (m10.equals("audio/eac3")) {
                    c10 = 26;
                    break;
                }
                c10 = 65535;
                break;
            case 1504619009:
                if (m10.equals("audio/flac")) {
                    c10 = 27;
                    break;
                }
                c10 = 65535;
                break;
            case 1504824762:
                if (m10.equals("audio/midi")) {
                    c10 = 28;
                    break;
                }
                c10 = 65535;
                break;
            case 1504831518:
                if (m10.equals("audio/mpeg")) {
                    c10 = 29;
                    break;
                }
                c10 = 65535;
                break;
            case 1505118770:
                if (m10.equals("audio/webm")) {
                    c10 = 30;
                    break;
                }
                c10 = 65535;
                break;
            case 2039520277:
                if (m10.equals("video/x-matroska")) {
                    c10 = 31;
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
        }
        return -1;
    }

    public static int r(Uri uri) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return -1;
        }
        if (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) {
            return 0;
        }
        if (lastPathSegment.endsWith(".ac4")) {
            return 1;
        }
        if (lastPathSegment.endsWith(".adts") || lastPathSegment.endsWith(".aac")) {
            return 2;
        }
        if (lastPathSegment.endsWith(".amr")) {
            return 3;
        }
        if (lastPathSegment.endsWith(".flac")) {
            return 4;
        }
        if (lastPathSegment.endsWith(".flv")) {
            return 5;
        }
        if (lastPathSegment.endsWith(".mid") || lastPathSegment.endsWith(".midi") || lastPathSegment.endsWith(".smf")) {
            return 15;
        }
        if (lastPathSegment.startsWith(".mk", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".webm")) {
            return 6;
        }
        if (lastPathSegment.endsWith(".mp3")) {
            return 7;
        }
        if (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() - 4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() - 5)) {
            return 8;
        }
        if (lastPathSegment.startsWith(".og", lastPathSegment.length() - 4) || lastPathSegment.endsWith(".opus")) {
            return 9;
        }
        if (lastPathSegment.endsWith(".ps") || lastPathSegment.endsWith(".mpeg") || lastPathSegment.endsWith(".mpg") || lastPathSegment.endsWith(".m2p")) {
            return 10;
        }
        if (lastPathSegment.endsWith(".ts") || lastPathSegment.startsWith(".ts", lastPathSegment.length() - 4)) {
            return 11;
        }
        if (lastPathSegment.endsWith(".wav") || lastPathSegment.endsWith(".wave")) {
            return 12;
        }
        if (lastPathSegment.endsWith(".vtt") || lastPathSegment.endsWith(".webvtt")) {
            return 13;
        }
        if (lastPathSegment.endsWith(".jpg") || lastPathSegment.endsWith(".jpeg")) {
            return 14;
        }
        if (lastPathSegment.endsWith(".avi")) {
            return 16;
        }
        if (lastPathSegment.endsWith(".png")) {
            return 17;
        }
        if (lastPathSegment.endsWith(".webp")) {
            return 18;
        }
        if (lastPathSegment.endsWith(".bmp") || lastPathSegment.endsWith(".dib")) {
            return 19;
        }
        if (lastPathSegment.endsWith(".heic") || lastPathSegment.endsWith(".heif")) {
            return 20;
        }
        return lastPathSegment.endsWith(".avif") ? 21 : -1;
    }

    public static boolean s(int i10, Rect rect, Rect rect2) {
        if (i10 == 17) {
            int i11 = rect.right;
            int i12 = rect2.right;
            return (i11 > i12 || rect.left >= i12) && rect.left > rect2.left;
        }
        if (i10 == 33) {
            int i13 = rect.bottom;
            int i14 = rect2.bottom;
            return (i13 > i14 || rect.top >= i14) && rect.top > rect2.top;
        }
        if (i10 == 66) {
            int i15 = rect.left;
            int i16 = rect2.left;
            return (i15 < i16 || rect.right <= i16) && rect.right < rect2.right;
        }
        if (i10 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i17 = rect.top;
        int i18 = rect2.top;
        return (i17 < i18 || rect.bottom <= i18) && rect.bottom < rect2.bottom;
    }

    public static int t(int i10, Rect rect, Rect rect2) {
        int i11;
        int i12;
        if (i10 == 17) {
            i11 = rect.left;
            i12 = rect2.right;
        } else if (i10 == 33) {
            i11 = rect.top;
            i12 = rect2.bottom;
        } else if (i10 == 66) {
            i11 = rect2.left;
            i12 = rect.right;
        } else {
            if (i10 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i11 = rect2.top;
            i12 = rect.bottom;
        }
        return Math.max(0, i11 - i12);
    }

    public static String u(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb2 = new StringBuilder(str2.length() + str.length());
        for (int i10 = 0; i10 < str.length(); i10++) {
            sb2.append(str.charAt(i10));
            if (str2.length() > i10) {
                sb2.append(str2.charAt(i10));
            }
        }
        return sb2.toString();
    }

    public static int v(int i10, Rect rect, Rect rect2) {
        if (i10 != 17) {
            if (i10 != 33) {
                if (i10 != 66) {
                    if (i10 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void w(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            a3.a(view, charSequence);
            return;
        }
        c3 c3Var = c3.f8384y;
        if (c3Var != null && c3Var.f8386o == view) {
            c3.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new c3(view, charSequence);
            return;
        }
        c3 c3Var2 = c3.f8385z;
        if (c3Var2 != null && c3Var2.f8386o == view) {
            c3Var2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static db.a x(db.c cVar, int i10) {
        za.h.e("<this>", cVar);
        boolean z10 = i10 > 0;
        Integer valueOf = Integer.valueOf(i10);
        if (!z10) {
            throw new IllegalArgumentException("Step must be positive, was: " + valueOf + '.');
        }
        int i11 = cVar.f4350o;
        int i12 = cVar.f4351p;
        if (cVar.f4352q <= 0) {
            i10 = -i10;
        }
        return new db.a(i11, i12, i10);
    }

    public static db.c y(int i10, int i11) {
        if (i11 > Integer.MIN_VALUE) {
            return new db.c(i10, i11 - 1, 1);
        }
        db.c cVar = db.c.f4357r;
        return db.c.f4357r;
    }

    public static String z(String str, Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String str2;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            length = objArr.length;
            if (i11 >= length) {
                break;
            }
            Object obj = objArr[i11];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e7) {
                    String str3 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str3), (Throwable) e7);
                    str2 = "<" + str3 + " threw " + e7.getClass().getName() + ">";
                }
            }
            objArr[i11] = str2;
            i11++;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + (length * 16));
        int i12 = 0;
        while (true) {
            length2 = objArr.length;
            if (i10 >= length2 || (indexOf = str.indexOf("%s", i12)) == -1) {
                break;
            }
            sb2.append((CharSequence) str, i12, indexOf);
            sb2.append(objArr[i10]);
            i10++;
            i12 = indexOf + 2;
        }
        sb2.append((CharSequence) str, i12, str.length());
        if (i10 < length2) {
            sb2.append(" [");
            sb2.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb2.append(", ");
                sb2.append(objArr[i13]);
            }
            sb2.append(']');
        }
        return sb2.toString();
    }
}
