package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f1152a = new LinkedHashMap();

    public final void a() {
        for (l0 l0Var : this.f1152a.values()) {
            HashMap hashMap = l0Var.f1142a;
            if (hashMap != null) {
                synchronized (hashMap) {
                    try {
                        for (Object obj : l0Var.f1142a.values()) {
                            if (obj instanceof Closeable) {
                                try {
                                    ((Closeable) obj).close();
                                } catch (IOException e7) {
                                    throw new RuntimeException(e7);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            LinkedHashSet linkedHashSet = l0Var.f1143b;
            if (linkedHashSet != null) {
                synchronized (linkedHashSet) {
                    try {
                        for (Closeable closeable : l0Var.f1143b) {
                            if (r.a.k(closeable)) {
                                try {
                                    closeable.close();
                                } catch (IOException e8) {
                                    throw new RuntimeException(e8);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
            l0Var.a();
        }
        this.f1152a.clear();
    }
}
