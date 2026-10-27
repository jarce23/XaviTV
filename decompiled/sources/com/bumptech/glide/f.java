package com.bumptech.glide;

import a6.e0;
import a6.i0;
import a6.n0;
import a6.s;
import a6.w;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.ImageView;
import com.bumptech.glide.integration.okhttp3.OkHttpGlideModule;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import x4.r;
import x5.a0;
import x5.b0;
import x5.d0;
import x5.f0;
import x5.u;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f implements p0.g {

    /* renamed from: a, reason: collision with root package name */
    public static Boolean f3001a;

    /* renamed from: b, reason: collision with root package name */
    public static Boolean f3002b;

    /* renamed from: c, reason: collision with root package name */
    public static Boolean f3003c;

    /* renamed from: d, reason: collision with root package name */
    public static Boolean f3004d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f3005e;

    /* renamed from: f, reason: collision with root package name */
    public static Boolean f3006f;
    public static Boolean g;

    public static void a(Throwable th, Throwable th2) {
        za.h.e("<this>", th);
        za.h.e("exception", th2);
        if (th != th2) {
            Integer num = ua.a.f12566a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = ta.a.f12031a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static na.c b(na.c cVar) {
        cVar.k();
        cVar.f9283q = true;
        return cVar.f9282p > 0 ? cVar : na.c.f9280r;
    }

    public static int c(int i10, int i11, int i12) {
        return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
    }

    public static final void d(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                a(th, th2);
            }
        }
    }

    public static k e(b bVar, List list, x4.f fVar) {
        r5.j aVar;
        r5.j jVar;
        int i10;
        u5.a aVar2;
        ContentResolver contentResolver;
        Class cls;
        u5.a aVar3 = bVar.f2988o;
        u5.f fVar2 = bVar.f2991r;
        g gVar = bVar.f2990q;
        Context applicationContext = gVar.getApplicationContext();
        a6.n nVar = gVar.f3014h;
        k kVar = new k();
        a6.o oVar = new a6.o();
        e2.d dVar = kVar.g;
        synchronized (dVar) {
            dVar.f4413a.add(oVar);
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 27) {
            kVar.k(new w());
        }
        Resources resources = applicationContext.getResources();
        ArrayList f10 = kVar.f();
        e6.b bVar2 = new e6.b(applicationContext, f10, aVar3, fVar2);
        r5.j n0Var = new n0(aVar3, new d9.f(4));
        s sVar = new s(kVar.f(), resources.getDisplayMetrics(), aVar3, fVar2);
        if (i11 < 28 || !((Map) nVar.f74p).containsKey(c.class)) {
            r5.j gVar2 = new a6.g(sVar, 0);
            aVar = new a6.a(sVar, 2, fVar2);
            jVar = gVar2;
        } else {
            r5.j hVar = new a6.h(1);
            jVar = new a6.h(0);
            aVar = hVar;
        }
        if (i11 >= 28) {
            i10 = i11;
            aVar2 = aVar3;
            kVar.d("Animation", InputStream.class, Drawable.class, new c6.a(new r(f10, 4, fVar2), 1));
            kVar.d("Animation", ByteBuffer.class, Drawable.class, new c6.a(new r(f10, 4, fVar2), 0));
        } else {
            i10 = i11;
            aVar2 = aVar3;
        }
        r5.j cVar = new c6.c(applicationContext);
        r5.k bVar3 = new a6.b(fVar2);
        f6.b bVar4 = new app.shamel.tv.b((byte) 0, 5);
        f6.b dVar2 = new f6.d(1);
        ContentResolver contentResolver2 = applicationContext.getContentResolver();
        kVar.b(ByteBuffer.class, new x5.c(2));
        kVar.b(InputStream.class, new b0(fVar2));
        kVar.d("Bitmap", ByteBuffer.class, Bitmap.class, jVar);
        kVar.d("Bitmap", InputStream.class, Bitmap.class, aVar);
        String str = Build.FINGERPRINT;
        if ("robolectric".equals(str)) {
            contentResolver = contentResolver2;
            cls = ParcelFileDescriptor.class;
        } else {
            contentResolver = contentResolver2;
            r5.j gVar3 = new a6.g(sVar, 1);
            cls = ParcelFileDescriptor.class;
            kVar.d("Bitmap", cls, Bitmap.class, gVar3);
        }
        u5.a aVar4 = aVar2;
        kVar.d("Bitmap", AssetFileDescriptor.class, Bitmap.class, new n0(aVar4, new n7.i(2)));
        kVar.d("Bitmap", cls, Bitmap.class, n0Var);
        u uVar = d0.f13622b;
        kVar.a(Bitmap.class, Bitmap.class, uVar);
        kVar.d("Bitmap", Bitmap.class, Bitmap.class, new i0(0));
        kVar.c(Bitmap.class, bVar3);
        kVar.d("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new a6.a(resources, jVar));
        kVar.d("BitmapDrawable", InputStream.class, BitmapDrawable.class, new a6.a(resources, aVar));
        kVar.d("BitmapDrawable", cls, BitmapDrawable.class, new a6.a(resources, n0Var));
        kVar.c(BitmapDrawable.class, new j5.g(aVar4, bVar3));
        kVar.d("Animation", InputStream.class, e6.d.class, new e6.k(f10, bVar2, fVar2));
        kVar.d("Animation", ByteBuffer.class, e6.d.class, bVar2);
        kVar.c(e6.d.class, new n7.i(17));
        kVar.a(p5.d.class, p5.d.class, uVar);
        kVar.d("Bitmap", p5.d.class, Bitmap.class, new a6.d(aVar4));
        kVar.d("legacy_append", Uri.class, Drawable.class, cVar);
        kVar.d("legacy_append", Uri.class, Bitmap.class, new a6.a(cVar, 1, aVar4));
        kVar.i(new b6.a(0));
        kVar.a(File.class, ByteBuffer.class, new d0(3));
        kVar.a(File.class, InputStream.class, new x5.i(new x5.c(5)));
        kVar.d("legacy_append", File.class, File.class, new i0(2));
        kVar.a(File.class, cls, new x5.i(new x5.c(4)));
        kVar.a(File.class, File.class, uVar);
        kVar.i(new com.bumptech.glide.load.data.k(fVar2));
        if (!"robolectric".equals(str)) {
            kVar.i(new b6.a(2));
        }
        u gVar4 = new x5.g(applicationContext, 2);
        u gVar5 = new x5.g(applicationContext, 0);
        u gVar6 = new x5.g(applicationContext, 1);
        Class cls2 = Integer.TYPE;
        kVar.a(cls2, InputStream.class, gVar4);
        kVar.a(Integer.class, InputStream.class, gVar4);
        kVar.a(cls2, AssetFileDescriptor.class, gVar5);
        kVar.a(Integer.class, AssetFileDescriptor.class, gVar5);
        kVar.a(cls2, Drawable.class, gVar6);
        kVar.a(Integer.class, Drawable.class, gVar6);
        kVar.a(Uri.class, InputStream.class, new x5.g(applicationContext, 5));
        kVar.a(Uri.class, AssetFileDescriptor.class, new x5.g(applicationContext, 4));
        u a0Var = new a0(resources, 2);
        u a0Var2 = new a0(resources, 0);
        u a0Var3 = new a0(resources, 1);
        kVar.a(Integer.class, Uri.class, a0Var);
        kVar.a(cls2, Uri.class, a0Var);
        kVar.a(Integer.class, AssetFileDescriptor.class, a0Var2);
        kVar.a(cls2, AssetFileDescriptor.class, a0Var2);
        kVar.a(Integer.class, InputStream.class, a0Var3);
        kVar.a(cls2, InputStream.class, a0Var3);
        kVar.a(String.class, InputStream.class, new x5.f(0));
        kVar.a(Uri.class, InputStream.class, new x5.f(0));
        kVar.a(String.class, InputStream.class, new d0(6));
        kVar.a(String.class, cls, new d0(5));
        kVar.a(String.class, AssetFileDescriptor.class, new d0(4));
        kVar.a(Uri.class, InputStream.class, new x5.a(applicationContext.getAssets(), 1));
        kVar.a(Uri.class, AssetFileDescriptor.class, new x5.a(applicationContext.getAssets(), 0));
        kVar.a(Uri.class, InputStream.class, new x5.g(applicationContext, 6));
        kVar.a(Uri.class, InputStream.class, new x5.g(applicationContext, 7));
        if (i10 >= 29) {
            kVar.a(Uri.class, InputStream.class, new y5.b(applicationContext, InputStream.class));
            kVar.a(Uri.class, cls, new y5.b(applicationContext, cls));
        }
        boolean containsKey = ((Map) nVar.f74p).containsKey(f.class);
        ContentResolver contentResolver3 = contentResolver;
        kVar.a(Uri.class, InputStream.class, new f0(contentResolver3, containsKey, 2));
        kVar.a(Uri.class, cls, new f0(contentResolver3, containsKey, 1));
        kVar.a(Uri.class, AssetFileDescriptor.class, new f0(contentResolver3, containsKey, 0));
        kVar.a(Uri.class, InputStream.class, new d0(7));
        kVar.a(URL.class, InputStream.class, new y5.e());
        kVar.a(Uri.class, File.class, new x5.g(applicationContext, 3));
        kVar.a(x5.j.class, InputStream.class, new x5.f(1));
        kVar.a(byte[].class, ByteBuffer.class, new d0(1));
        kVar.a(byte[].class, InputStream.class, new d0(2));
        kVar.a(Uri.class, Uri.class, uVar);
        kVar.a(Drawable.class, Drawable.class, uVar);
        kVar.d("legacy_append", Drawable.class, Drawable.class, new i0(1));
        kVar.j(Bitmap.class, BitmapDrawable.class, new f6.a(resources, 0));
        kVar.j(Bitmap.class, byte[].class, bVar4);
        kVar.j(Drawable.class, byte[].class, new x4.m(aVar4, bVar4, dVar2, 6));
        kVar.j(e6.d.class, byte[].class, dVar2);
        r5.j n0Var2 = new n0(aVar4, new d9.f(3));
        kVar.d("legacy_append", ByteBuffer.class, Bitmap.class, n0Var2);
        kVar.d("legacy_append", ByteBuffer.class, BitmapDrawable.class, new a6.a(resources, n0Var2));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            OkHttpGlideModule okHttpGlideModule = (OkHttpGlideModule) it.next();
            try {
                okHttpGlideModule.getClass();
                kVar.l(new q5.b());
            } catch (AbstractMethodError e7) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ".concat(okHttpGlideModule.getClass().getName()), e7);
            }
        }
        if (fVar != null) {
            fVar.S(applicationContext, bVar, kVar);
        }
        return kVar;
    }

    public static na.c g() {
        return new na.c(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x03cf A[LOOP:6: B:108:0x0398->B:122:0x03cf, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03d9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03cb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final p4.r h(android.content.Context r26, o4.a r27) {
        /*
            Method dump skipped, instructions count: 1266
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.f.h(android.content.Context, o4.a):p4.r");
    }

    public static int i(List list, InputStream inputStream, u5.f fVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                int c10 = ((r5.d) list.get(i10)).c(inputStream, fVar);
                if (c10 != -1) {
                    return c10;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static final int j(int i10, int i11, int i12) {
        if (i12 > 0) {
            if (i10 < i11) {
                int i13 = i11 % i12;
                if (i13 < 0) {
                    i13 += i12;
                }
                int i14 = i10 % i12;
                if (i14 < 0) {
                    i14 += i12;
                }
                int i15 = (i13 - i14) % i12;
                if (i15 < 0) {
                    i15 += i12;
                }
                return i11 - i15;
            }
        } else {
            if (i12 >= 0) {
                throw new IllegalArgumentException("Step is zero.");
            }
            if (i10 > i11) {
                int i16 = -i12;
                int i17 = i10 % i16;
                if (i17 < 0) {
                    i17 += i16;
                }
                int i18 = i11 % i16;
                if (i18 < 0) {
                    i18 += i16;
                }
                int i19 = (i17 - i18) % i16;
                if (i19 < 0) {
                    i19 += i16;
                }
                return i19 + i11;
            }
        }
        return i11;
    }

    public static ImageHeaderParser$ImageType l(List list, InputStream inputStream, u5.f fVar) {
        if (inputStream == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, fVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ImageHeaderParser$ImageType e7 = ((r5.d) list.get(i10)).e(inputStream);
                inputStream.reset();
                if (e7 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return e7;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static ImageHeaderParser$ImageType m(List list, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ImageHeaderParser$ImageType a10 = ((r5.d) list.get(i10)).a(byteBuffer);
                AtomicReference atomicReference = m6.b.f9006a;
                if (a10 != ImageHeaderParser$ImageType.UNKNOWN) {
                    return a10;
                }
            } catch (Throwable th) {
                AtomicReference atomicReference2 = m6.b.f9006a;
                throw th;
            }
        }
        return ImageHeaderParser$ImageType.UNKNOWN;
    }

    public static void n(Context context, ImageView imageView, String str, ImageView imageView2) {
        try {
            ((k5.e) b.e(context)).w(str.trim()).M().G(new k5.f(imageView2, imageView)).E(imageView);
        } catch (Exception e7) {
            Log.e("EnigmaUtils", "imageLoadUrlWithVodHolder", e7);
        }
    }

    public static boolean o(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f3006f == null) {
            f3006f = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        return f3006f.booleanValue();
    }

    public static boolean p(Resources resources) {
        boolean z10 = false;
        if (resources == null) {
            return false;
        }
        if (f3004d == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z10 = true;
            }
            f3004d = Boolean.valueOf(z10);
        }
        return f3004d.booleanValue();
    }

    public static boolean q(Context context) {
        Resources resources = context.getResources();
        if (resources == null) {
            return false;
        }
        if (f3002b == null) {
            f3002b = Boolean.valueOf((resources.getConfiguration().screenLayout & 15) > 3 || p(resources));
        }
        return f3002b.booleanValue();
    }

    public static boolean r(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (g == null) {
            g = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return g.booleanValue();
    }

    public static String s(String str, Object... objArr) {
        int indexOf;
        String sb2;
        int i10 = 0;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj == null) {
                sb2 = "null";
            } else {
                try {
                    sb2 = obj.toString();
                } catch (Exception e7) {
                    String str2 = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str2, (Throwable) e7);
                    StringBuilder s10 = android.support.v4.media.d.s("<", str2, " threw ");
                    s10.append(e7.getClass().getName());
                    s10.append(">");
                    sb2 = s10.toString();
                }
            }
            objArr[i11] = sb2;
        }
        StringBuilder sb3 = new StringBuilder((objArr.length * 16) + str.length());
        int i12 = 0;
        while (i10 < objArr.length && (indexOf = str.indexOf("%s", i12)) != -1) {
            sb3.append((CharSequence) str, i12, indexOf);
            sb3.append(objArr[i10]);
            i12 = indexOf + 2;
            i10++;
        }
        sb3.append((CharSequence) str, i12, str.length());
        if (i10 < objArr.length) {
            sb3.append(" [");
            sb3.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb3.append(", ");
                sb3.append(objArr[i13]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static List t(Object obj) {
        List singletonList = Collections.singletonList(obj);
        za.h.d("singletonList(...)", singletonList);
        return singletonList;
    }

    public static Typeface u(Configuration configuration, Typeface typeface) {
        int i10;
        int i11;
        int weight;
        int i12;
        Typeface create;
        if (Build.VERSION.SDK_INT < 31) {
            return null;
        }
        i10 = configuration.fontWeightAdjustment;
        if (i10 == Integer.MAX_VALUE) {
            return null;
        }
        i11 = configuration.fontWeightAdjustment;
        if (i11 == 0 || typeface == null) {
            return null;
        }
        weight = typeface.getWeight();
        i12 = configuration.fontWeightAdjustment;
        create = Typeface.create(typeface, c(i12 + weight, 1, 1000), typeface.isItalic());
        return create;
    }

    public abstract Intent f(f.j jVar, Object obj);

    public d.a k(f.j jVar, Object obj) {
        return null;
    }

    public abstract Object v(Intent intent, int i10);
}
