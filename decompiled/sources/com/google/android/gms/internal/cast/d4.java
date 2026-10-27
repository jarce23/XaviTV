package com.google.android.gms.internal.cast;

import sun.misc.Unsafe;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract /* synthetic */ class d4 {
    public static /* synthetic */ boolean a(Unsafe unsafe, b4 b4Var, long j10, Object obj, Object obj2) {
        while (!c4.a(unsafe, b4Var, j10, obj, obj2)) {
            if (unsafe.getObject(b4Var, j10) != obj) {
                return false;
            }
        }
        return true;
    }
}
