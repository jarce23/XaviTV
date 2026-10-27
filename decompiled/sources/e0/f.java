package e0;

import a6.n;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.text.PositionedGlyphs;
import android.graphics.text.TextRunShaper;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.support.v4.media.session.w;
import android.text.TextUtils;
import android.util.Log;
import app.shamel.tv.activities.y;
import b4.n1;
import g7.c0;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final w7.b f4392a;

    /* renamed from: b, reason: collision with root package name */
    public static final n1 f4393b;

    /* renamed from: c, reason: collision with root package name */
    public static Paint f4394c;

    static {
        com.bumptech.glide.e.d("TypefaceCompat static init");
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 31) {
            f4392a = new l();
        } else if (i10 >= 29) {
            f4392a = new k();
        } else if (i10 >= 28) {
            f4392a = new j();
        } else if (i10 >= 26) {
            f4392a = new i();
        } else {
            if (i10 >= 24) {
                Method method = h.f4402s;
                if (method == null) {
                    Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
                }
                if (method != null) {
                    f4392a = new h();
                }
            }
            f4392a = new g();
        }
        f4393b = new n1(16);
        f4394c = null;
        Trace.endSection();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Typeface a(Context context, d0.d dVar, Resources resources, int i10, String str, int i11, int i12, d0.b bVar, boolean z10) {
        Typeface i13;
        Typeface build;
        Font.Builder fontVariationSettings;
        Font build2;
        FontFamily build3;
        int i14 = 4;
        int i15 = -3;
        if (dVar instanceof d0.g) {
            d0.g gVar = (d0.g) dVar;
            String str2 = gVar.f3972d;
            i13 = null;
            int i16 = 1;
            boolean z11 = false;
            Object[] objArr = 0;
            Object[] objArr2 = 0;
            Object[] objArr3 = 0;
            if (TextUtils.isEmpty(str2) || (build = c(str2)) == null) {
                ArrayList arrayList = gVar.f3969a;
                if (arrayList.size() == 1) {
                    build = c(((j0.d) arrayList.get(0)).f6913e);
                } else {
                    if (Build.VERSION.SDK_INT >= 31) {
                        int i17 = 0;
                        while (true) {
                            if (i17 >= arrayList.size()) {
                                Typeface.CustomFallbackBuilder customFallbackBuilder = null;
                                int i18 = 0;
                                while (true) {
                                    if (i18 >= arrayList.size()) {
                                        break;
                                    }
                                    j0.d dVar2 = (j0.d) arrayList.get(i18);
                                    if (i18 == arrayList.size() - 1 && TextUtils.isEmpty(dVar2.f6914f)) {
                                        customFallbackBuilder.setSystemFallback(dVar2.f6913e);
                                        break;
                                    }
                                    String str3 = dVar2.f6913e;
                                    String str4 = dVar2.f6914f;
                                    Font d6 = d(c(str3));
                                    if (d6 == null) {
                                        Log.w("TypefaceCompat", "Unable identify the primary font for " + dVar2.f6913e + ". Falling back to provider font.");
                                        break;
                                    }
                                    if (TextUtils.isEmpty(str4)) {
                                        try {
                                            w.l();
                                            w.x();
                                            fontVariationSettings = a9.e.h(d6).setFontVariationSettings(str4);
                                            build2 = fontVariationSettings.build();
                                            build3 = w.h(build2).build();
                                        } catch (IOException unused) {
                                            Log.e("TypefaceCompat", "Failed to clone Font instance. Fall back to provider font.");
                                        }
                                    } else {
                                        build3 = w.h(d6).build();
                                    }
                                    if (customFallbackBuilder == null) {
                                        customFallbackBuilder = w.c(build3);
                                    } else {
                                        customFallbackBuilder.addCustomFallback(build3);
                                    }
                                    i18++;
                                }
                                build = customFallbackBuilder.build();
                            } else {
                                if (c(((j0.d) arrayList.get(i17)).f6913e) == null) {
                                    break;
                                }
                                i17++;
                            }
                        }
                    }
                    build = null;
                }
            }
            if (build != null) {
                if (bVar != null) {
                    new Handler(Looper.getMainLooper()).post(new androidx.fragment.app.d(bVar, i14, build));
                }
                f4393b.k(b(resources, i10, str, i11, i12), build);
                return build;
            }
            Object[] objArr4 = !z10 ? bVar != null : gVar.f3971c != 0;
            int i19 = z10 ? gVar.f3970b : -1;
            Handler handler = new Handler(Looper.getMainLooper());
            n nVar = new n(19, z11);
            nVar.f74p = bVar;
            ArrayList arrayList2 = gVar.f3969a;
            i0.d dVar3 = new i0.d(handler, 1);
            x4.c cVar = new x4.c(nVar, 8, dVar3);
            int i20 = 16;
            if (objArr4 != true) {
                String a10 = j0.h.a(i12, arrayList2);
                Typeface typeface = (Typeface) j0.h.f6924a.f(a10);
                if (typeface != null) {
                    dVar3.execute(new y(nVar, typeface, i20, objArr2 == true ? 1 : 0));
                    i13 = typeface;
                } else {
                    j0.f fVar = new j0.f(objArr == true ? 1 : 0, cVar);
                    synchronized (j0.h.f6926c) {
                        try {
                            p.i iVar = j0.h.f6927d;
                            ArrayList arrayList3 = (ArrayList) iVar.get(a10);
                            if (arrayList3 != null) {
                                arrayList3.add(fVar);
                            } else {
                                ArrayList arrayList4 = new ArrayList();
                                arrayList4.add(fVar);
                                iVar.put(a10, arrayList4);
                                j0.e eVar = new j0.e(a10, context, arrayList2, i12, 1);
                                ThreadPoolExecutor threadPoolExecutor = j0.h.f6925b;
                                j0.f fVar2 = new j0.f(i16, a10);
                                Handler handler2 = Looper.myLooper() == null ? new Handler(Looper.getMainLooper()) : new Handler();
                                c0 c0Var = new c0();
                                c0Var.f5189p = eVar;
                                c0Var.f5190q = fVar2;
                                c0Var.f5191r = handler2;
                                threadPoolExecutor.execute(c0Var);
                            }
                        } finally {
                        }
                    }
                }
            } else {
                if (arrayList2.size() > 1) {
                    throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
                }
                j0.d dVar4 = (j0.d) arrayList2.get(0);
                n1 n1Var = j0.h.f6924a;
                ArrayList arrayList5 = new ArrayList(1);
                Object obj = new Object[]{dVar4}[0];
                Objects.requireNonNull(obj);
                arrayList5.add(obj);
                String a11 = j0.h.a(i12, Collections.unmodifiableList(arrayList5));
                Typeface typeface2 = (Typeface) j0.h.f6924a.f(a11);
                if (typeface2 != null) {
                    dVar3.execute(new y(nVar, typeface2, i20, objArr3 == true ? 1 : 0));
                    i13 = typeface2;
                } else if (i19 == -1) {
                    Object[] objArr5 = {dVar4};
                    ArrayList arrayList6 = new ArrayList(1);
                    Object obj2 = objArr5[0];
                    Objects.requireNonNull(obj2);
                    arrayList6.add(obj2);
                    j0.g b2 = j0.h.b(a11, context, Collections.unmodifiableList(arrayList6), i12);
                    cVar.W(b2);
                    i13 = b2.f6922a;
                } else {
                    try {
                        try {
                            try {
                                try {
                                    j0.g gVar2 = (j0.g) j0.h.f6925b.submit(new j0.e(a11, context, dVar4, i12, 0)).get(i19, TimeUnit.MILLISECONDS);
                                    cVar.W(gVar2);
                                    i13 = gVar2.f6922a;
                                } catch (TimeoutException unused2) {
                                    throw new InterruptedException("timeout");
                                }
                            } catch (InterruptedException e7) {
                                throw e7;
                            }
                        } catch (ExecutionException e8) {
                            throw new RuntimeException(e8);
                        }
                    } catch (InterruptedException unused3) {
                        ((i0.d) cVar.f13538q).execute(new androidx.emoji2.text.j(i15, 3, (n) cVar.f13537p));
                    }
                }
            }
        } else {
            i13 = f4392a.i(context, (d0.e) dVar, resources, i12);
            if (bVar != null) {
                if (i13 != null) {
                    new Handler(Looper.getMainLooper()).post(new androidx.fragment.app.d(bVar, i14, i13));
                } else {
                    bVar.a(-3);
                }
            }
        }
        if (i13 != null) {
            f4393b.k(b(resources, i10, str, i11, i12), i13);
        }
        return i13;
    }

    public static String b(Resources resources, int i10, String str, int i11, int i12) {
        return resources.getResourcePackageName(i10) + '-' + str + '-' + i11 + '-' + i10 + '-' + i12;
    }

    public static Typeface c(String str) {
        if (str != null && !str.isEmpty()) {
            Typeface create = Typeface.create(str, 0);
            Typeface create2 = Typeface.create(Typeface.DEFAULT, 0);
            if (create != null && !create.equals(create2)) {
                return create;
            }
        }
        return null;
    }

    public static Font d(Typeface typeface) {
        PositionedGlyphs shapeTextRun;
        int glyphCount;
        Font font;
        if (f4394c == null) {
            f4394c = new Paint();
        }
        f4394c.setTextSize(10.0f);
        f4394c.setTypeface(typeface);
        shapeTextRun = TextRunShaper.shapeTextRun((CharSequence) " ", 0, 1, 0, 1, 0.0f, 0.0f, false, f4394c);
        glyphCount = shapeTextRun.glyphCount();
        if (glyphCount == 0) {
            return null;
        }
        font = shapeTextRun.getFont(0);
        return font;
    }
}
