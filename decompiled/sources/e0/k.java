package e0;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class k extends w7.b {
    public static Font B(FontFamily fontFamily, int i10) {
        FontStyle fontStyle = new FontStyle((i10 & 1) != 0 ? 700 : 400, (i10 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int E = E(fontStyle, font.getStyle());
        for (int i11 = 1; i11 < fontFamily.getSize(); i11++) {
            Font font2 = fontFamily.getFont(i11);
            int E2 = E(fontStyle, font2.getStyle());
            if (E2 < E) {
                font = font2;
                E = E2;
            }
        }
        return font;
    }

    public static int E(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    public final FontFamily C(j0.j[] jVarArr, ContentResolver contentResolver) {
        Font font;
        String str;
        ParcelFileDescriptor openFileDescriptor;
        FontFamily.Builder builder = null;
        for (j0.j jVar : jVarArr) {
            if (Objects.equals(jVar.f6930a.getScheme(), "systemfont")) {
                font = D(jVar);
            } else {
                try {
                    Uri uri = jVar.f6930a;
                    str = jVar.f6934e;
                    openFileDescriptor = contentResolver.openFileDescriptor(uri, "r", null);
                } catch (IOException e7) {
                    Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
                }
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    font = null;
                } else {
                    try {
                        Font.Builder ttcIndex = new Font.Builder(openFileDescriptor).setWeight(jVar.f6932c).setSlant(jVar.f6933d ? 1 : 0).setTtcIndex(jVar.f6931b);
                        if (!TextUtils.isEmpty(str)) {
                            ttcIndex.setFontVariationSettings(str);
                        }
                        font = ttcIndex.build();
                        openFileDescriptor.close();
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
            }
            if (font != null) {
                if (builder == null) {
                    builder = new FontFamily.Builder(font);
                } else {
                    builder.addFont(font);
                }
            }
        }
        if (builder == null) {
            return null;
        }
        return builder.build();
    }

    public Font D(j0.j jVar) {
        throw new UnsupportedOperationException("Getting font from Typeface is not supported before API31");
    }

    @Override // w7.b
    public final Typeface i(Context context, d0.e eVar, Resources resources, int i10) {
        try {
            FontFamily.Builder builder = null;
            for (d0.f fVar : eVar.f3962a) {
                try {
                    Font build = new Font.Builder(resources, fVar.f3968f).setWeight(fVar.f3964b).setSlant(fVar.f3965c ? 1 : 0).setTtcIndex(fVar.f3967e).setFontVariationSettings(fVar.f3966d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily build2 = builder.build();
            return new Typeface.CustomFallbackBuilder(build2).setStyle(B(build2, i10).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // w7.b
    public final Typeface j(Context context, j0.j[] jVarArr, int i10) {
        try {
            FontFamily C = C(jVarArr, context.getContentResolver());
            if (C == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(C).setStyle(B(C, i10).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // w7.b
    public final Typeface k(Context context, List list, int i10) {
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily C = C((j0.j[]) list.get(0), contentResolver);
            if (C == null) {
                return null;
            }
            Typeface.CustomFallbackBuilder customFallbackBuilder = new Typeface.CustomFallbackBuilder(C);
            for (int i11 = 1; i11 < list.size(); i11++) {
                FontFamily C2 = C((j0.j[]) list.get(i11), contentResolver);
                if (C2 != null) {
                    customFallbackBuilder.addCustomFallback(C2);
                }
            }
            return customFallbackBuilder.setStyle(B(C, i10).getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // w7.b
    public final Typeface l(Context context, InputStream inputStream) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // w7.b
    public final Typeface o(Context context, Resources resources, int i10, String str, int i11) {
        try {
            Font build = new Font.Builder(resources, i10).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception e7) {
            Log.w("TypefaceCompatApi29Impl", "Font load failed", e7);
            return null;
        }
    }

    @Override // w7.b
    public final j0.j p(j0.j[] jVarArr, int i10) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
