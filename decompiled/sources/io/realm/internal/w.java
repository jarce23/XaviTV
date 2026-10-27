package io.realm.internal;

import android.content.Context;
import java.io.File;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f6771a;

    static {
        String str = File.separator;
        String str2 = File.pathSeparator;
        f6771a = false;
    }

    public static synchronized void a(Context context) {
        synchronized (w.class) {
            if (f6771a) {
                return;
            }
            x4.m mVar = new x4.m();
            if (context == null) {
                throw new IllegalArgumentException("Given context is null");
            }
            x4.m.D("Beginning load of %s...", "realm-jni");
            mVar.C(context, "realm-jni", "10.19.0");
            f6771a = true;
        }
    }
}
