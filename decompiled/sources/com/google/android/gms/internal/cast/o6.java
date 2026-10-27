package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class o6 {

    /* renamed from: a, reason: collision with root package name */
    public final Unsafe f3412a;

    public o6(Unsafe unsafe) {
        this.f3412a = unsafe;
    }

    public abstract double a(long j10, Object obj);

    public abstract float b(long j10, Object obj);

    public abstract void c(Object obj, long j10, boolean z10);

    public abstract void d(Object obj, long j10, byte b2);

    public abstract void e(Object obj, long j10, double d6);

    public abstract void f(Object obj, long j10, float f10);

    public abstract boolean g(long j10, Object obj);
}
