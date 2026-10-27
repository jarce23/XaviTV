package j9;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w1 implements k9.f, k2.p, l.w, v1.f, n6.a, x1.s, y7.b, z1.v, z3.b, z9.b {

    /* renamed from: p, reason: collision with root package name */
    public static w1 f7481p;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f7482o;

    public /* synthetic */ w1(int i10) {
        this.f7482o = i10;
    }

    public static final boolean B(rb.i0 i0Var) {
        rb.i0 i0Var2 = sb.j.f11705r;
        rb.o oVar = i0Var.f11021o;
        int k10 = rb.o.k(oVar, sb.f.f11691a);
        if (k10 == -1) {
            k10 = rb.o.k(i0Var.f11021o, sb.f.f11692b);
        }
        if (k10 != -1) {
            oVar = rb.o.p(oVar, k10 + 1, 0, 2);
        } else if (i0Var.g() != null && oVar.d() == 2) {
            oVar = rb.o.f11048r;
        }
        return !gb.p.R(oVar.r(), ".class", true);
    }

    public static void C(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x007c, code lost:
    
        r6 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static rb.o D(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.w1.D(java.lang.String):rb.o");
    }

    public static rb.o E(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (sb.b.a(str.charAt(i11 + 1)) + (sb.b.a(str.charAt(i11)) << 4));
        }
        return new rb.o(bArr);
    }

    public static rb.o F(String str) {
        za.h.e("<this>", str);
        byte[] bytes = str.getBytes(gb.a.f5445a);
        za.h.d("getBytes(...)", bytes);
        rb.o oVar = new rb.o(bytes);
        oVar.f11051q = str;
        return oVar;
    }

    public static x4.e G(Context context, String[] strArr, String str) {
        String[] M = M(context);
        int length = M.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i10 >= length) {
                return null;
            }
            String str2 = M[i10];
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i11 = i12;
                }
            }
            if (zipFile != null) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    if (i13 < 5) {
                        for (String str3 : strArr) {
                            StringBuilder sb2 = new StringBuilder("lib");
                            char c10 = File.separatorChar;
                            sb2.append(c10);
                            sb2.append(str3);
                            sb2.append(c10);
                            sb2.append(str);
                            String sb3 = sb2.toString();
                            x4.m.D("Looking for %s in APK %s...", sb3, str2);
                            ZipEntry entry = zipFile.getEntry(sb3);
                            if (entry != null) {
                                x4.e eVar = new x4.e(13, z10);
                                eVar.f13542p = zipFile;
                                eVar.f13543q = entry;
                                return eVar;
                            }
                        }
                        i13 = i14;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i10++;
        }
    }

    public static String[] H(Context context, String str) {
        StringBuilder sb2 = new StringBuilder("lib");
        char c10 = File.separatorChar;
        sb2.append(c10);
        sb2.append("([^\\");
        sb2.append(c10);
        sb2.append("]*)");
        sb2.append(c10);
        sb2.append(str);
        Pattern compile = Pattern.compile(sb2.toString());
        HashSet hashSet = new HashSet();
        for (String str2 : M(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0045, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0082, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0075, code lost:
    
        if (r11 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00a2, code lost:
    
        if (r10 != (-1)) goto L70;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean I(v0.b r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.w1.I(v0.b, android.text.Editable, int, int, boolean):boolean");
    }

    public static rb.o J(byte[] bArr) {
        rb.o oVar = rb.o.f11048r;
        int length = bArr.length;
        rb.b.e(bArr.length, 0, length);
        return new rb.o(ma.i.G(bArr, 0, length));
    }

    public static rb.i0 K(rb.i0 i0Var, rb.i0 i0Var2) {
        za.h.e("<this>", i0Var);
        za.h.e("base", i0Var2);
        return sb.j.f11705r.d(gb.p.V(gb.i.k0(i0Var.f11021o.r(), i0Var2.f11021o.r()), '\\', '/'));
    }

    public static String[] M(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    @Override // v1.f
    public p4.p A(c2.j0 j0Var, i1.p pVar) {
        if (pVar.f5995r == null) {
            return null;
        }
        return new p4.p(18, new v1.b(6001, new v1.h()));
    }

    @Override // k9.f
    public /* synthetic */ Object c() {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new j0.l(1));
        k5.a.a(newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    @Override // z1.v
    public MediaCodecInfo d(int i10) {
        return MediaCodecList.getCodecInfoAt(i10);
    }

    @Override // k2.p
    public void f() {
        throw new UnsupportedOperationException();
    }

    @Override // x1.s
    public g2.o g(x1.o oVar, x1.l lVar) {
        return new x1.r(oVar, lVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x018e, code lost:
    
        if (r8 != false) goto L99;
     */
    @Override // y7.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int h(android.content.Context r17, java.lang.String r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 578
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j9.w1.h(android.content.Context, java.lang.String, boolean):int");
    }

    @Override // y7.b
    public int i(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb2 = new StringBuilder(str.length() + 61);
            sb2.append("com.google.android.gms.dynamite.descriptors.");
            sb2.append(str);
            sb2.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb2.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (r7.r.h(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb3 = new StringBuilder(valueOf.length() + 50 + str.length() + 1);
            sb3.append("Module descriptor id '");
            sb3.append(valueOf);
            sb3.append("' didn't match expected id '");
            sb3.append(str);
            sb3.append("'");
            Log.e("DynamiteModule", sb3.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb4 = new StringBuilder(str.length() + 45);
            sb4.append("Local module descriptor class for ");
            sb4.append(str);
            sb4.append(" not found.");
            Log.w("DynamiteModule", sb4.toString());
            return 0;
        } catch (Exception e7) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e7.getMessage())));
            return 0;
        }
    }

    @Override // n6.a
    public Object j() {
        try {
            return new v5.e(MessageDigest.getInstance("SHA-256"));
        } catch (NoSuchAlgorithmException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // z1.v
    public boolean k(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    @Override // z1.v
    public int l() {
        return MediaCodecList.getCodecCount();
    }

    @Override // v1.f
    public /* synthetic */ v1.e m(c2.j0 j0Var, i1.p pVar) {
        return v1.e.f12652a;
    }

    @Override // l.w
    public boolean p(l.l lVar) {
        return false;
    }

    @Override // k2.p
    public k2.g0 q(int i10, int i11) {
        throw new UnsupportedOperationException();
    }

    @Override // z9.b
    public void r() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // k2.p
    public void t(k2.a0 a0Var) {
        throw new UnsupportedOperationException();
    }

    @Override // z9.b
    public float u() {
        return 1.0f;
    }

    @Override // x1.s
    public g2.o v() {
        return new x1.r(x1.o.f13440n, null);
    }

    @Override // v1.f
    public int w(i1.p pVar) {
        return pVar.f5995r != null ? 1 : 0;
    }

    @Override // z1.v
    public boolean x(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // z1.v
    public boolean z() {
        return false;
    }

    public w1(View view) {
        this.f7482o = 5;
        if (Build.VERSION.SDK_INT >= 30) {
            new m0.s(view).f8714b = view;
        } else {
            new i1.a(view);
        }
    }

    public w1(Context context) {
        this.f7482o = 15;
    }

    @Override // v1.f
    public /* synthetic */ void a() {
    }

    @Override // v1.f
    public /* synthetic */ void b() {
    }

    @Override // z9.b
    public void destroy() {
    }

    @Override // z3.b
    public void o() {
    }

    private final void L(Object obj) {
    }

    @Override // l.w
    public void e(l.l lVar, boolean z10) {
    }

    @Override // v1.f
    public void n(Looper looper, t1.u uVar) {
    }

    @Override // z3.b
    public void s(int i10, Object obj) {
    }

    @Override // z9.b
    public Bitmap y(Bitmap bitmap, float f10) {
        return bitmap;
    }
}
