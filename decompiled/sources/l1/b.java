package l1;

import android.net.Uri;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import android.util.Log;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static ExecutorService f8078a;

    /* renamed from: b, reason: collision with root package name */
    public static final Object f8079b = new Object();

    public static String a(String str, Throwable th) {
        String j10 = j(th);
        if (TextUtils.isEmpty(j10)) {
            return str;
        }
        StringBuilder a10 = s.e.a(str, "\n  ");
        a10.append(j10.replace("\n", "\n  "));
        a10.append('\n');
        return a10.toString();
    }

    public static void b(int i10, int i11) {
        GLES20.glBindTexture(i10, i11);
        c();
        GLES20.glTexParameteri(i10, 10240, 9729);
        c();
        GLES20.glTexParameteri(i10, 10241, 9729);
        c();
        GLES20.glTexParameteri(i10, 10242, 33071);
        c();
        GLES20.glTexParameteri(i10, 10243, 33071);
        c();
    }

    public static void c() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = false;
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                break;
            }
            if (z10) {
                sb2.append('\n');
            }
            String gluErrorString = GLU.gluErrorString(glGetError);
            if (gluErrorString == null) {
                gluErrorString = "error code: 0x" + Integer.toHexString(glGetError);
            }
            sb2.append("glError: ");
            sb2.append(gluErrorString);
            z10 = true;
        }
        if (z10) {
            throw new j(sb2.toString());
        }
    }

    public static void d(String str, boolean z10) {
        if (!z10) {
            throw new j(str);
        }
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(fArr).flip();
    }

    public static void f(String str, String str2) {
        synchronized (f8079b) {
            Log.d(str, a(str2, null));
        }
    }

    public static void g(String str, String str2) {
        synchronized (f8079b) {
            Log.e(str, a(str2, null));
        }
    }

    public static void h(String str, String str2, Throwable th) {
        synchronized (f8079b) {
            Log.e(str, a(str2, th));
        }
    }

    public static synchronized Executor i() {
        ExecutorService executorService;
        synchronized (b.class) {
            try {
                if (f8078a == null) {
                    int i10 = a0.f8067a;
                    f8078a = Executors.newSingleThreadExecutor(new androidx.emoji2.text.a("ExoPlayer:BackgroundExecutor", 1));
                }
                executorService = f8078a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return executorService;
    }

    public static String j(Throwable th) {
        boolean z10;
        if (th == null) {
            return null;
        }
        synchronized (f8079b) {
            Throwable th2 = th;
            while (true) {
                if (th2 == null) {
                    z10 = false;
                    break;
                }
                try {
                    if (th2 instanceof UnknownHostException) {
                        z10 = true;
                        break;
                    }
                    th2 = th2.getCause();
                } finally {
                }
            }
            if (z10) {
                return "UnknownHostException (no network)";
            }
            return Log.getStackTraceString(th).trim().replace("\t", "    ");
        }
    }

    public static int[] k(String str) {
        int i10;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i11 = indexOf4 + 2;
        if (i11 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i11) == '/') {
            i10 = str.indexOf(47, indexOf4 + 3);
            if (i10 == -1 || i10 > indexOf2) {
                i10 = indexOf2;
            }
        } else {
            i10 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i10;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static void l(String str, String str2) {
        synchronized (f8079b) {
            Log.i(str, a(str2, null));
        }
    }

    public static boolean m(String str) {
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        d("No EGL display.", !eglGetDisplay.equals(EGL14.EGL_NO_DISPLAY));
        d("Error in eglInitialize.", EGL14.eglInitialize(eglGetDisplay, new int[1], 0, new int[1], 0));
        c();
        String eglQueryString = EGL14.eglQueryString(eglGetDisplay, 12373);
        return eglQueryString != null && eglQueryString.contains(str);
    }

    public static String n(StringBuilder sb2, int i10, int i11) {
        int i12;
        int i13;
        if (i10 >= i11) {
            return sb2.toString();
        }
        if (sb2.charAt(i10) == '/') {
            i10++;
        }
        int i14 = i10;
        int i15 = i14;
        while (i14 <= i11) {
            if (i14 == i11) {
                i12 = i14;
            } else if (sb2.charAt(i14) == '/') {
                i12 = i14 + 1;
            } else {
                i14++;
            }
            int i16 = i15 + 1;
            if (i14 == i16 && sb2.charAt(i15) == '.') {
                sb2.delete(i15, i12);
                i11 -= i12 - i15;
            } else {
                if (i14 == i15 + 2 && sb2.charAt(i15) == '.' && sb2.charAt(i16) == '.') {
                    i13 = sb2.lastIndexOf("/", i15 - 2) + 1;
                    int i17 = i13 > i10 ? i13 : i10;
                    sb2.delete(i17, i12);
                    i11 -= i12 - i17;
                } else {
                    i13 = i14 + 1;
                }
                i15 = i13;
            }
            i14 = i15;
        }
        return sb2.toString();
    }

    public static String o(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        if (str2 == null) {
            str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int[] k10 = k(str2);
        if (k10[0] != -1) {
            sb2.append(str2);
            n(sb2, k10[1], k10[2]);
            return sb2.toString();
        }
        int[] k11 = k(str);
        if (k10[3] == 0) {
            sb2.append((CharSequence) str, 0, k11[3]);
            sb2.append(str2);
            return sb2.toString();
        }
        if (k10[2] == 0) {
            sb2.append((CharSequence) str, 0, k11[2]);
            sb2.append(str2);
            return sb2.toString();
        }
        int i10 = k10[1];
        if (i10 != 0) {
            int i11 = k11[0] + 1;
            sb2.append((CharSequence) str, 0, i11);
            sb2.append(str2);
            return n(sb2, k10[1] + i11, i11 + k10[2]);
        }
        if (str2.charAt(i10) == '/') {
            sb2.append((CharSequence) str, 0, k11[1]);
            sb2.append(str2);
            int i12 = k11[1];
            return n(sb2, i12, k10[2] + i12);
        }
        int i13 = k11[0] + 2;
        int i14 = k11[1];
        if (i13 >= i14 || i14 != k11[2]) {
            int lastIndexOf = str.lastIndexOf(47, k11[2] - 1);
            int i15 = lastIndexOf == -1 ? k11[1] : lastIndexOf + 1;
            sb2.append((CharSequence) str, 0, i15);
            sb2.append(str2);
            return n(sb2, k11[1], i15 + k10[2]);
        }
        sb2.append((CharSequence) str, 0, i14);
        sb2.append('/');
        sb2.append(str2);
        int i16 = k11[1];
        return n(sb2, i16, k10[2] + i16 + 1);
    }

    public static Uri p(String str, String str2) {
        return Uri.parse(o(str, str2));
    }

    public static void q(String str, String str2) {
        synchronized (f8079b) {
            Log.w(str, a(str2, null));
        }
    }

    public static void r(String str, String str2, Throwable th) {
        synchronized (f8079b) {
            Log.w(str, a(str2, th));
        }
    }
}
