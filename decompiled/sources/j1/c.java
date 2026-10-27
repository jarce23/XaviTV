package j1;

import a6.d0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.media.AudioManager;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import b4.j0;
import d9.l;
import f2.t;
import j9.m0;
import j9.r;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import m0.n0;
import okhttp3.internal.http2.Http2;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static AudioManager f6945a;

    public static void a(r rVar, InputStream inputStream, m0 m0Var, long j10) {
        m0 m0Var2;
        DataInputStream dataInputStream;
        r rVar2;
        int readUnsignedShort;
        byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
        DataInputStream dataInputStream2 = new DataInputStream(new BufferedInputStream(inputStream, 4096));
        int readInt = dataInputStream2.readInt();
        if (readInt != -771763713) {
            throw new d0("Unexpected magic=".concat(String.format("%x", Integer.valueOf(readInt))));
        }
        int read = dataInputStream2.read();
        if (read != 4) {
            throw new d0(android.support.v4.media.d.m(read, "Unexpected version="));
        }
        long j11 = 0;
        while (true) {
            long j12 = j10 - j11;
            try {
                int read2 = dataInputStream2.read();
                if (read2 == -1) {
                    throw new IOException("Patch file overrun");
                }
                if (read2 == 0) {
                    m0Var.flush();
                    return;
                }
                switch (read2) {
                    case 247:
                        m0Var2 = m0Var;
                        read2 = dataInputStream2.readUnsignedShort();
                        c(bArr, dataInputStream2, m0Var2, read2, j12);
                        j11 += read2;
                        m0Var = m0Var2;
                    case 248:
                        m0Var2 = m0Var;
                        read2 = dataInputStream2.readInt();
                        c(bArr, dataInputStream2, m0Var2, read2, j12);
                        j11 += read2;
                        m0Var = m0Var2;
                    case 249:
                        m0Var2 = m0Var;
                        DataInputStream dataInputStream3 = dataInputStream2;
                        r rVar3 = rVar;
                        long readUnsignedShort2 = dataInputStream3.readUnsignedShort();
                        int read3 = dataInputStream3.read();
                        if (read3 == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        b(bArr, rVar3, m0Var2, readUnsignedShort2, read3, j12);
                        rVar = rVar3;
                        dataInputStream2 = dataInputStream3;
                        read2 = read3;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 250:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        rVar2 = rVar;
                        long readUnsignedShort3 = dataInputStream.readUnsignedShort();
                        readUnsignedShort = dataInputStream.readUnsignedShort();
                        b(bArr, rVar2, m0Var2, readUnsignedShort3, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 251:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        rVar2 = rVar;
                        long readUnsignedShort4 = dataInputStream.readUnsignedShort();
                        readUnsignedShort = dataInputStream.readInt();
                        b(bArr, rVar2, m0Var2, readUnsignedShort4, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 252:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        rVar2 = rVar;
                        long readInt2 = dataInputStream.readInt();
                        readUnsignedShort = dataInputStream.read();
                        if (readUnsignedShort == -1) {
                            throw new IOException("Unexpected end of patch");
                        }
                        b(bArr, rVar2, m0Var2, readInt2, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 253:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        rVar2 = rVar;
                        long readInt3 = dataInputStream.readInt();
                        readUnsignedShort = dataInputStream.readUnsignedShort();
                        b(bArr, rVar2, m0Var2, readInt3, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 254:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        rVar2 = rVar;
                        long readInt4 = dataInputStream.readInt();
                        readUnsignedShort = dataInputStream.readInt();
                        b(bArr, rVar2, m0Var2, readInt4, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    case 255:
                        m0Var2 = m0Var;
                        dataInputStream = dataInputStream2;
                        long readLong = dataInputStream.readLong();
                        readUnsignedShort = dataInputStream.readInt();
                        rVar2 = rVar;
                        b(bArr, rVar2, m0Var2, readLong, readUnsignedShort, j12);
                        rVar = rVar2;
                        read2 = readUnsignedShort;
                        dataInputStream2 = dataInputStream;
                        j11 += read2;
                        m0Var = m0Var2;
                    default:
                        m0Var2 = m0Var;
                        try {
                            c(bArr, dataInputStream2, m0Var2, read2, j12);
                            dataInputStream = dataInputStream2;
                            dataInputStream2 = dataInputStream;
                            j11 += read2;
                            m0Var = m0Var2;
                        } catch (Throwable th) {
                            th = th;
                            Throwable th2 = th;
                            m0Var2.flush();
                            throw th2;
                        }
                }
            } catch (Throwable th3) {
                th = th3;
                m0Var2 = m0Var;
            }
        }
    }

    public static void b(byte[] bArr, r rVar, m0 m0Var, long j10, int i10, long j11) {
        InputStream a10;
        if (i10 < 0) {
            throw new IOException("copyLength negative");
        }
        if (j10 < 0) {
            throw new IOException("inputOffset negative");
        }
        long j12 = i10;
        if (j12 > j11) {
            throw new IOException("Output length overrun");
        }
        try {
            k9.d dVar = new k9.d(rVar, j10, j12);
            synchronized (dVar) {
                a10 = dVar.a(0L, dVar.f7844q - dVar.f7843p);
            }
            int i11 = i10;
            while (i11 > 0) {
                try {
                    int min = Math.min(i11, Http2.INITIAL_MAX_FRAME_SIZE);
                    int i12 = 0;
                    while (i12 < min) {
                        int read = a10.read(bArr, i12, min - i12);
                        if (read == -1) {
                            throw new IOException("truncated input stream");
                        }
                        i12 += read;
                    }
                    m0Var.write(bArr, 0, min);
                    i11 -= min;
                } finally {
                }
            }
            a10.close();
        } catch (EOFException e7) {
            throw new IOException("patch underrun", e7);
        }
    }

    public static void c(byte[] bArr, DataInputStream dataInputStream, m0 m0Var, int i10, long j10) {
        if (i10 < 0) {
            throw new IOException("copyLength negative");
        }
        if (i10 > j10) {
            throw new IOException("Output length overrun");
        }
        while (i10 > 0) {
            try {
                int min = Math.min(i10, Http2.INITIAL_MAX_FRAME_SIZE);
                dataInputStream.readFully(bArr, 0, min);
                m0Var.write(bArr, 0, min);
                i10 -= min;
            } catch (EOFException unused) {
                throw new IOException("patch underrun");
            }
        }
    }

    public static final void d(View view) {
        za.h.e("<this>", view);
        n0 n0Var = new n0(view, null);
        fb.g gVar = new fb.g();
        gVar.f5068r = n0Var.create(gVar, gVar);
        while (gVar.hasNext()) {
            View view2 = (View) gVar.next();
            q0.a aVar = (q0.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new q0.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList = aVar.f10218a;
            int w10 = ma.k.w(arrayList);
            if (-1 < w10) {
                throw android.support.v4.media.d.k(w10, arrayList);
            }
        }
    }

    public static byte e(long j10) {
        com.bumptech.glide.e.f(j10, (j10 >> 8) == 0, "out of range: %s");
        return (byte) j10;
    }

    public static void f(o1.h hVar) {
        if (hVar != null) {
            try {
                hVar.close();
            } catch (IOException unused) {
            }
        }
    }

    public static final long g(long j10, hb.c cVar, hb.c cVar2) {
        za.h.e("sourceUnit", cVar);
        za.h.e("targetUnit", cVar2);
        return cVar2.f5774o.convert(j10, cVar.f5774o);
    }

    public static i7.e h(int i10) {
        return i10 != 0 ? i10 != 1 ? new l() : new d9.e() : new l();
    }

    public static j0 i(t tVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int length = tVar.length();
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            if (tVar.b(i11, elapsedRealtime)) {
                i10++;
            }
        }
        return new j0(length, i10, 1);
    }

    public static void j(String str, String str2, Object obj) {
        Log.d("TransportRuntime.".concat(str), String.format(str2, obj));
    }

    public static synchronized AudioManager k(Context context) {
        synchronized (c.class) {
            try {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext != null) {
                    f6945a = null;
                }
                AudioManager audioManager = f6945a;
                if (audioManager != null) {
                    return audioManager;
                }
                Looper myLooper = Looper.myLooper();
                if (myLooper != null && myLooper != Looper.getMainLooper()) {
                    l1.g gVar = new l1.g();
                    l1.b.i().execute(new androidx.fragment.app.d(applicationContext, 10, gVar));
                    gVar.c();
                    AudioManager audioManager2 = f6945a;
                    audioManager2.getClass();
                    return audioManager2;
                }
                AudioManager audioManager3 = (AudioManager) applicationContext.getSystemService("audio");
                f6945a = audioManager3;
                audioManager3.getClass();
                return audioManager3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void l(EditorInfo editorInfo, InputConnection inputConnection, TextView textView) {
        if (inputConnection == null || editorInfo.hintText != null) {
            return;
        }
        for (ViewParent parent = textView.getParent(); parent instanceof View; parent = parent.getParent()) {
        }
    }

    public static void o(k1.a aVar) {
        aVar.f7607k = -3.4028235E38f;
        aVar.f7606j = Integer.MIN_VALUE;
        CharSequence charSequence = aVar.f7598a;
        if (charSequence instanceof Spanned) {
            if (!(charSequence instanceof Spannable)) {
                aVar.f7598a = SpannableString.valueOf(charSequence);
                aVar.f7599b = null;
            }
            CharSequence charSequence2 = aVar.f7598a;
            charSequence2.getClass();
            Spannable spannable = (Spannable) charSequence2;
            for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
                if ((obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan)) {
                    spannable.removeSpan(obj);
                }
            }
        }
    }

    public static float p(int i10, float f10, int i11, int i12) {
        float f11;
        if (f10 == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i10 == 0) {
            f11 = i12;
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    return -3.4028235E38f;
                }
                return f10;
            }
            f11 = i11;
        }
        return f10 * f11;
    }

    public static void q(View view, d9.j jVar) {
        w8.a aVar = jVar.f4277p.f4261c;
        if (aVar == null || !aVar.f13142a) {
            return;
        }
        float f10 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f10 += ((View) parent).getElevation();
        }
        d9.h hVar = jVar.f4277p;
        if (hVar.f4270m != f10) {
            hVar.f4270m = f10;
            jVar.s();
        }
    }

    public static boolean r(Context context) {
        ApplicationInfo applicationInfo;
        Intent putExtra = new Intent().addFlags(268435456).setAction("com.android.settings.panel.action.MEDIA_OUTPUT").putExtra("com.android.settings.panel.extra.PACKAGE_NAME", context.getPackageName());
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(putExtra, 0).iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && (applicationInfo = activityInfo.applicationInfo) != null && (applicationInfo.flags & 129) != 0) {
                context.startActivity(putExtra);
                return true;
            }
        }
        return false;
    }

    public static void s(int i10, int i11) {
        String z10;
        if (i10 < 0 || i10 >= i11) {
            if (i10 < 0) {
                z10 = k5.a.z("%s (%s) must not be negative", "index", Integer.valueOf(i10));
            } else {
                if (i11 < 0) {
                    throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "negative size: "));
                }
                z10 = k5.a.z("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
            }
            throw new IndexOutOfBoundsException(z10);
        }
    }

    public static void t(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(v("index", i10, i11));
        }
    }

    public static void u(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException((i10 < 0 || i10 > i12) ? v("start index", i10, i12) : (i11 < 0 || i11 > i12) ? v("end index", i11, i12) : k5.a.z("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10)));
        }
    }

    public static String v(String str, int i10, int i11) {
        if (i10 < 0) {
            return k5.a.z("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return k5.a.z("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        throw new IllegalArgumentException(android.support.v4.media.d.m(i11, "negative size: "));
    }

    public abstract void m(Throwable th);

    public abstract void n(x4.i iVar);
}
