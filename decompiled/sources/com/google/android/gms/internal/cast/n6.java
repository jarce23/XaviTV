package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n6 extends o6 {
    @Override // com.google.android.gms.internal.cast.o6
    public final double a(long j10, Object obj) {
        return Double.longBitsToDouble(this.f3412a.getLong(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final float b(long j10, Object obj) {
        return Float.intBitsToFloat(this.f3412a.getInt(obj, j10));
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final void c(Object obj, long j10, boolean z10) {
        if (p6.g) {
            p6.c(obj, j10, z10 ? (byte) 1 : (byte) 0);
        } else {
            p6.d(obj, j10, z10 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final void d(Object obj, long j10, byte b2) {
        if (p6.g) {
            p6.c(obj, j10, b2);
        } else {
            p6.d(obj, j10, b2);
        }
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final void e(Object obj, long j10, double d6) {
        this.f3412a.putLong(obj, j10, Double.doubleToLongBits(d6));
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final void f(Object obj, long j10, float f10) {
        this.f3412a.putInt(obj, j10, Float.floatToIntBits(f10));
    }

    @Override // com.google.android.gms.internal.cast.o6
    public final boolean g(long j10, Object obj) {
        return p6.g ? p6.m(j10, obj) : p6.n(j10, obj);
    }
}
