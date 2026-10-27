package com.google.android.gms.internal.cast;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a6 {

    /* renamed from: c, reason: collision with root package name */
    public static final a6 f3253c = new a6();

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3255b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final p5 f3254a = new p5();

    public final d6 a(Class cls) {
        d6 k10;
        Class cls2;
        Charset charset = g5.f3312a;
        if (cls == null) {
            throw new NullPointerException("messageType");
        }
        ConcurrentHashMap concurrentHashMap = this.f3255b;
        d6 d6Var = (d6) concurrentHashMap.get(cls);
        if (d6Var != null) {
            return d6Var;
        }
        p5 p5Var = this.f3254a;
        p5Var.getClass();
        Class cls3 = e6.f3302a;
        if (!a5.class.isAssignableFrom(cls) && (cls2 = e6.f3302a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        c6 a10 = ((o5) p5Var.f3425o).a(cls);
        int i10 = a10.f3290d;
        o4 o4Var = a10.f3287a;
        if ((i10 & 2) == 2) {
            if (a5.class.isAssignableFrom(cls)) {
                k10 = new w5(e6.f3304c, w4.f3555a, o4Var);
            } else {
                h6 h6Var = e6.f3303b;
                v4 v4Var = w4.f3556b;
                if (v4Var == null) {
                    throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                }
                k10 = new w5(h6Var, v4Var, o4Var);
            }
        } else if (a5.class.isAssignableFrom(cls)) {
            if (a10.a() - 1 != 1) {
                int i11 = y5.f3603a;
                l5 l5Var = m5.f3379b;
                h6 h6Var2 = e6.f3304c;
                v4 v4Var2 = w4.f3555a;
                int i12 = r5.f3443a;
                k10 = v5.k(a10, l5Var, h6Var2, v4Var2);
            } else {
                int i13 = y5.f3603a;
                l5 l5Var2 = m5.f3379b;
                h6 h6Var3 = e6.f3304c;
                int i14 = r5.f3443a;
                k10 = v5.k(a10, l5Var2, h6Var3, null);
            }
        } else if (a10.a() - 1 != 1) {
            int i15 = y5.f3603a;
            k5 k5Var = m5.f3378a;
            h6 h6Var4 = e6.f3303b;
            v4 v4Var3 = w4.f3556b;
            if (v4Var3 == null) {
                throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
            }
            int i16 = r5.f3443a;
            k10 = v5.k(a10, k5Var, h6Var4, v4Var3);
        } else {
            int i17 = y5.f3603a;
            k5 k5Var2 = m5.f3378a;
            h6 h6Var5 = e6.f3303b;
            int i18 = r5.f3443a;
            k10 = v5.k(a10, k5Var2, h6Var5, null);
        }
        d6 d6Var2 = (d6) concurrentHashMap.putIfAbsent(cls, k10);
        return d6Var2 == null ? k10 : d6Var2;
    }
}
