package com.google.android.gms.internal.cast;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class t4 implements Iterable, Serializable {

    /* renamed from: q, reason: collision with root package name */
    public static final t4 f3476q = new t4(g5.f3313b);

    /* renamed from: o, reason: collision with root package name */
    public int f3477o = 0;

    /* renamed from: p, reason: collision with root package name */
    public final byte[] f3478p;

    static {
        int i10 = q4.f3438a;
    }

    public t4(byte[] bArr) {
        bArr.getClass();
        this.f3478p = bArr;
    }

    public static void i(int i10) {
        if (((i10 - 47) | 47) < 0) {
            throw new IndexOutOfBoundsException(android.support.v4.media.d.m(i10, "End index: 47 >= "));
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof t4) && h() == ((t4) obj).h()) {
            if (h() == 0) {
                return true;
            }
            if (!(obj instanceof t4)) {
                return obj.equals(this);
            }
            t4 t4Var = (t4) obj;
            int i10 = this.f3477o;
            int i11 = t4Var.f3477o;
            if (i10 == 0 || i11 == 0 || i10 == i11) {
                int h10 = h();
                if (h10 > t4Var.h()) {
                    throw new IllegalArgumentException("Length too large: " + h10 + h());
                }
                if (h10 > t4Var.h()) {
                    throw new IllegalArgumentException(android.support.v4.media.d.p("Ran off end of other: 0, ", ", ", h10, t4Var.h()));
                }
                byte[] bArr = t4Var.f3478p;
                int i12 = 0;
                int i13 = 0;
                while (i12 < h10) {
                    if (this.f3478p[i12] == bArr[i13]) {
                        i12++;
                        i13++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public byte f(int i10) {
        return this.f3478p[i10];
    }

    public byte g(int i10) {
        return this.f3478p[i10];
    }

    public int h() {
        return this.f3478p.length;
    }

    public final int hashCode() {
        int i10 = this.f3477o;
        if (i10 != 0) {
            return i10;
        }
        int h10 = h();
        Charset charset = g5.f3312a;
        int i11 = h10;
        for (int i12 = 0; i12 < h10; i12++) {
            i11 = (i11 * 31) + this.f3478p[i12];
        }
        if (i11 == 0) {
            i11 = 1;
        }
        this.f3477o = i11;
        return i11;
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new r4(this);
    }

    public final String toString() {
        String concat;
        Locale locale = Locale.ROOT;
        String hexString = Integer.toHexString(System.identityHashCode(this));
        int h10 = h();
        if (h() <= 50) {
            concat = com.bumptech.glide.e.y(this);
        } else {
            i(h());
            concat = com.bumptech.glide.e.y(new s4(this.f3478p)).concat("...");
        }
        StringBuilder sb2 = new StringBuilder("<ByteString@");
        sb2.append(hexString);
        sb2.append(" size=");
        sb2.append(h10);
        sb2.append(" contents=\"");
        return android.support.v4.media.d.r(sb2, concat, "\">");
    }
}
