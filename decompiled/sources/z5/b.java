package z5;

import a6.b0;
import a6.p;
import a6.s;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import r5.g;
import r5.h;
import r5.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements ImageDecoder$OnHeaderDecodedListener {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f14116a = b0.a();

    /* renamed from: b, reason: collision with root package name */
    public final int f14117b;

    /* renamed from: c, reason: collision with root package name */
    public final int f14118c;

    /* renamed from: d, reason: collision with root package name */
    public final r5.a f14119d;

    /* renamed from: e, reason: collision with root package name */
    public final p f14120e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14121f;
    public final i g;

    public b(int i10, int i11, h hVar) {
        this.f14117b = i10;
        this.f14118c = i11;
        this.f14119d = (r5.a) hVar.c(s.f91f);
        this.f14120e = (p) hVar.c(p.g);
        g gVar = s.f93i;
        this.f14121f = hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue();
        this.g = (i) hVar.c(s.g);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace colorSpace;
        ColorSpace.Named named;
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        ColorSpace colorSpace4;
        boolean isWideGamut;
        ColorSpace.Named unused;
        if (this.f14116a.c(this.f14117b, this.f14118c, this.f14121f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f14119d == r5.a.f10785p) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        size = imageInfo.getSize();
        int i10 = this.f14117b;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getWidth();
        }
        int i11 = this.f14118c;
        if (i11 == Integer.MIN_VALUE) {
            i11 = size.getHeight();
        }
        float b2 = this.f14120e.b(size.getWidth(), size.getHeight(), i10, i11);
        int round = Math.round(size.getWidth() * b2);
        int round2 = Math.round(size.getHeight() * b2);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b2);
        }
        imageDecoder.setTargetSize(round, round2);
        i iVar = this.g;
        if (iVar != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 < 28) {
                if (i12 >= 26) {
                    unused = ColorSpace.Named.SRGB;
                    colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
                    imageDecoder.setTargetColorSpace(colorSpace);
                    return;
                }
                return;
            }
            if (iVar == i.f10796o) {
                colorSpace3 = imageInfo.getColorSpace();
                if (colorSpace3 != null) {
                    colorSpace4 = imageInfo.getColorSpace();
                    isWideGamut = colorSpace4.isWideGamut();
                    if (isWideGamut) {
                        named = ColorSpace.Named.DISPLAY_P3;
                        colorSpace2 = ColorSpace.get(named);
                        imageDecoder.setTargetColorSpace(colorSpace2);
                    }
                }
            }
            named = ColorSpace.Named.SRGB;
            colorSpace2 = ColorSpace.get(named);
            imageDecoder.setTargetColorSpace(colorSpace2);
        }
    }
}
