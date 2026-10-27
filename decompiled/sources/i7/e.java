package i7;

import a6.m0;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.widget.ProgressBar;
import d9.x;
import i1.h0;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.LinkedHashSet;
import java.util.Locale;
import l1.a0;
import okhttp3.internal.url._UrlKt;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e {
    public static final int A(int i10) {
        r.a.h(i10, "state");
        int b2 = s.e.b(i10);
        if (b2 == 0) {
            return 0;
        }
        int i11 = 1;
        if (b2 != 1) {
            i11 = 2;
            if (b2 != 2) {
                i11 = 3;
                if (b2 != 3) {
                    i11 = 4;
                    if (b2 != 4) {
                        if (b2 == 5) {
                            return 5;
                        }
                        throw new m0();
                    }
                }
            }
        }
        return i11;
    }

    public static String B(int i10) {
        Object[] objArr = {Integer.valueOf(Color.red(i10)), Integer.valueOf(Color.green(i10)), Integer.valueOf(Color.blue(i10)), Double.valueOf(Color.alpha(i10) / 255.0d)};
        int i11 = a0.f8067a;
        return String.format(Locale.US, "rgba(%d,%d,%d,%.3f)", objArr);
    }

    public static String C(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt >= 'a' && charAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (c10 >= 'a' && c10 <= 'z') {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static String a(File file) {
        if (!file.getName().endsWith(".apk")) {
            throw new IllegalArgumentException("Non-apk found in splits directory.");
        }
        String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", _UrlKt.FRAGMENT_ENCODE_SET);
        return (replaceFirst.equals("base-master") || replaceFirst.equals("base-main")) ? _UrlKt.FRAGMENT_ENCODE_SET : replaceFirst.startsWith("base-") ? replaceFirst.replace("base-", "config.") : replaceFirst.replace("-", ".config.").replace(".config.master", _UrlKt.FRAGMENT_ENCODE_SET).replace(".config.main", _UrlKt.FRAGMENT_ENCODE_SET);
    }

    public static na.i b(na.i iVar) {
        na.f fVar = iVar.f9304o;
        fVar.b();
        return fVar.f9296w > 0 ? iVar : na.i.f9303p;
    }

    public static final LinkedHashSet c(byte[] bArr) {
        ObjectInputStream objectInputStream;
        za.h.e("bytes", bArr);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bArr.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } finally {
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        }
        try {
            int readInt = objectInputStream.readInt();
            for (int i10 = 0; i10 < readInt; i10++) {
                Uri parse = Uri.parse(objectInputStream.readUTF());
                boolean readBoolean = objectInputStream.readBoolean();
                za.h.d("uri", parse);
                linkedHashSet.add(new o4.c(parse, readBoolean));
            }
            objectInputStream.close();
            byteArrayInputStream.close();
            return linkedHashSet;
        } finally {
        }
    }

    public static long[] d(long[]... jArr) {
        long j10 = 0;
        for (long[] jArr2 : jArr) {
            j10 += jArr2.length;
        }
        int i10 = (int) j10;
        com.bumptech.glide.e.f(j10, j10 == ((long) i10), "the total number of elements (%s) in the arrays must fit in an int");
        long[] jArr3 = new long[i10];
        int i11 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i11, jArr4.length);
            i11 += jArr4.length;
        }
        return jArr3;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.emoji2.text.v e(android.content.Context r13) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Ld
            androidx.emoji2.text.c r0 = new androidx.emoji2.text.c
            r1 = 4
            r0.<init>(r1)
            goto L13
        Ld:
            n7.i r0 = new n7.i
            r1 = 4
            r0.<init>(r1)
        L13:
            android.content.pm.PackageManager r1 = r13.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            y7.d.d(r2, r1)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2c:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L48
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2c
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2c
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2c
            goto L49
        L48:
            r4 = r5
        L49:
            if (r4 != 0) goto L4d
        L4b:
            r6 = r5
            goto L7e
        L4d:
            java.lang.String r7 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.lang.String r8 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            android.content.pm.Signature[] r0 = r0.F(r1, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            int r2 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
        L5b:
            if (r3 >= r2) goto L69
            r4 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            byte[] r4 = r4.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            r1.add(r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            int r3 = r3 + 1
            goto L5b
        L69:
            java.util.List r10 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            j0.d r6 = new j0.d     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.lang.String r9 = "emojicompat-emoji-font"
            r11 = 0
            r12 = 0
            r6.<init>(r7, r8, r9, r10, r11, r12)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            goto L7e
        L77:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4b
        L7e:
            if (r6 != 0) goto L81
            goto L8b
        L81:
            androidx.emoji2.text.v r5 = new androidx.emoji2.text.v
            androidx.emoji2.text.u r0 = new androidx.emoji2.text.u
            r0.<init>(r13, r6)
            r5.<init>(r0)
        L8b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.e.e(android.content.Context):androidx.emoji2.text.v");
    }

    public static ContextThemeWrapper f(Context context, boolean z10) {
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, o(context, !z10 ? R.attr.dialogTheme : R.attr.alertDialogTheme));
        return o(contextThemeWrapper, R.attr.mediaRouteTheme) != 0 ? new ContextThemeWrapper(contextThemeWrapper, m(contextThemeWrapper)) : contextThemeWrapper;
    }

    public static Bitmap g(byte[] bArr, int i10, int i11) {
        BitmapFactory.Options options;
        int i12 = 0;
        int i13 = 1;
        if (i11 != -1) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, i10, options);
            options.inJustDecodeBounds = false;
            options.inSampleSize = 1;
            for (int max = Math.max(options.outWidth, options.outHeight); max > i11; max /= 2) {
                options.inSampleSize *= 2;
            }
        } else {
            options = null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, i10, options);
        if (options != null) {
            options.inSampleSize = 1;
        }
        if (decodeByteArray == null) {
            throw h0.a(new IllegalStateException(), "Could not decode image data");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            w0.g gVar = new w0.g(byteArrayInputStream);
            byteArrayInputStream.close();
            w0.c c10 = gVar.c("Orientation");
            if (c10 != null) {
                try {
                    i13 = c10.e(gVar.f12745f);
                } catch (NumberFormatException unused) {
                }
            }
            switch (i13) {
                case 3:
                case 4:
                    i12 = 180;
                    break;
                case 5:
                case 8:
                    i12 = 270;
                    break;
                case 6:
                case 7:
                    i12 = 90;
                    break;
            }
            if (i12 == 0) {
                return decodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate(i12);
            return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
        } finally {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0090, code lost:
    
        if (r2.a(r11, r0) == r1) goto L36;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0076 A[Catch: all -> 0x0036, TryCatch #1 {all -> 0x0036, blocks: (B:12:0x002f, B:14:0x005a, B:20:0x006e, B:22:0x0076, B:24:0x007c, B:26:0x0082, B:28:0x0093, B:30:0x009b, B:31:0x00a2, B:32:0x00a4, B:33:0x00a5, B:34:0x00ac, B:42:0x0049, B:44:0x0050), top: B:7:0x0021 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r9v4, types: [kb.u] */
    /* JADX WARN: Type inference failed for: r9v6, types: [kb.u] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0090 -> B:13:0x0032). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object h(lb.g r8, kb.r r9, boolean r10, ra.c r11) {
        /*
            Method dump skipped, instructions count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i7.e.h(lb.g, kb.r, boolean, ra.c):java.lang.Object");
    }

    public static int i(Context context) {
        return e0.a.c(-1, n(context, R.attr.colorPrimary)) >= 3.0d ? -1 : -570425344;
    }

    public static float k(Context context) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.disabledAlpha, typedValue, true)) {
            return typedValue.getFloat();
        }
        return 0.5f;
    }

    public static Drawable l(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(new int[]{i10});
        Drawable o2 = n4.a.o(context, obtainStyledAttributes.getResourceId(0, 0));
        if (v(context)) {
            o2.setTint(context.getColor(R.color.mr_dynamic_dialog_icon_light));
        }
        obtainStyledAttributes.recycle();
        return o2;
    }

    public static int m(Context context) {
        return v(context) ? i(context) == -570425344 ? R.style.Theme_MediaRouter_Light : R.style.Theme_MediaRouter_Light_DarkControlPanel : i(context) == -570425344 ? R.style.Theme_MediaRouter_LightControlPanel : R.style.Theme_MediaRouter;
    }

    public static int n(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId != 0 ? context.getResources().getColor(typedValue.resourceId) : typedValue.data;
    }

    public static int o(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue.resourceId;
        }
        return 0;
    }

    public static h4.c p(a6.n nVar, SQLiteDatabase sQLiteDatabase) {
        za.h.e("refHolder", nVar);
        h4.c cVar = (h4.c) nVar.f74p;
        if (cVar != null && cVar.f5553o.equals(sQLiteDatabase)) {
            return cVar;
        }
        h4.c cVar2 = new h4.c(sQLiteDatabase);
        nVar.f74p = cVar2;
        return cVar2;
    }

    public static int q(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static final int r(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.o("Could not convert ", i10, " to BackoffPolicy"));
    }

    public static final int s(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 == 2) {
            return 3;
        }
        if (i10 == 3) {
            return 4;
        }
        if (i10 == 4) {
            return 5;
        }
        if (Build.VERSION.SDK_INT < 30 || i10 != 5) {
            throw new IllegalArgumentException(android.support.v4.media.d.o("Could not convert ", i10, " to NetworkType"));
        }
        return 6;
    }

    public static final int t(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.o("Could not convert ", i10, " to OutOfQuotaPolicy"));
    }

    public static final int u(int i10) {
        if (i10 == 0) {
            return 1;
        }
        if (i10 == 1) {
            return 2;
        }
        if (i10 == 2) {
            return 3;
        }
        if (i10 == 3) {
            return 4;
        }
        if (i10 == 4) {
            return 5;
        }
        if (i10 == 5) {
            return 6;
        }
        throw new IllegalArgumentException(android.support.v4.media.d.o("Could not convert ", i10, " to State"));
    }

    public static boolean v(Context context) {
        TypedValue typedValue = new TypedValue();
        return context.getTheme().resolveAttribute(R.attr.isLightTheme, typedValue, true) && typedValue.data != 0;
    }

    public static pa.i w(pa.g gVar, pa.h hVar) {
        za.h.e("key", hVar);
        return za.h.a(gVar.getKey(), hVar) ? pa.j.f10146o : gVar;
    }

    public static pa.i x(pa.g gVar, pa.i iVar) {
        za.h.e("context", iVar);
        return com.google.android.gms.internal.cast.n.q(gVar, iVar);
    }

    public static void y(Context context, ProgressBar progressBar) {
        if (progressBar.isIndeterminate()) {
            progressBar.getIndeterminateDrawable().setColorFilter(context.getColor(v(context) ? R.color.mr_cast_progressbar_progress_and_thumb_light : R.color.mr_cast_progressbar_progress_and_thumb_dark), PorterDuff.Mode.SRC_IN);
        }
    }

    public static void z(Drawable drawable, int i10) {
        drawable.setTint(i10);
    }

    public abstract void j(x xVar, float f10, float f11);
}
