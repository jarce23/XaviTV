package com.bumptech.glide.load;

import r5.c;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(0),
    JPEG(1),
    RAW(2),
    PNG_A(3),
    PNG(4),
    WEBP_A(5),
    WEBP(6),
    ANIMATED_WEBP(7),
    AVIF(8),
    ANIMATED_AVIF(9),
    UNKNOWN(10);


    /* renamed from: o, reason: collision with root package name */
    public final boolean f3034o;

    ImageHeaderParser$ImageType(int i10) {
        this.f3034o = r2;
    }

    public boolean hasAlpha() {
        return this.f3034o;
    }

    public boolean isWebp() {
        int i10 = c.f10788a[ordinal()];
        return i10 == 1 || i10 == 2 || i10 == 3;
    }
}
