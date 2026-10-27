package com.google.android.gms.internal.cast;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g5 {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f3312a;

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f3313b;

    static {
        Charset.forName("US-ASCII");
        f3312a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f3313b = bArr;
        ByteBuffer.wrap(bArr);
    }
}
