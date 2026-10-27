package a6;

import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f39e;

    /* renamed from: f, reason: collision with root package name */
    public static final boolean f40f;
    public static final File g;

    /* renamed from: h, reason: collision with root package name */
    public static volatile b0 f41h;

    /* renamed from: b, reason: collision with root package name */
    public int f43b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f44c = true;

    /* renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f45d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final int f42a = 20000;

    static {
        int i10 = Build.VERSION.SDK_INT;
        f39e = i10 < 29;
        f40f = i10 >= 28;
        g = new File("/proc/self/fd");
    }

    public static b0 a() {
        if (f41h == null) {
            synchronized (b0.class) {
                try {
                    if (f41h == null) {
                        f41h = new b0();
                    }
                } finally {
                }
            }
        }
        return f41h;
    }

    public final int b() {
        if (Build.VERSION.SDK_INT == 28) {
            Iterator it = Arrays.asList("GM1900", "GM1901", "GM1903", "GM1911", "GM1915", "ONEPLUS A3000", "ONEPLUS A3010", "ONEPLUS A5010", "ONEPLUS A5000", "ONEPLUS A3003", "ONEPLUS A6000", "ONEPLUS A6003", "ONEPLUS A6010", "ONEPLUS A6013").iterator();
            while (it.hasNext()) {
                if (Build.MODEL.startsWith((String) it.next())) {
                    return 500;
                }
            }
        }
        return this.f42a;
    }

    public final boolean c(int i10, int i11, boolean z10, boolean z11) {
        boolean z12;
        if (z10) {
            if (f40f) {
                if (!f39e || this.f45d.get()) {
                    if (z11) {
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because exif orientation is required");
                            return false;
                        }
                    } else if (i10 >= 0 && i11 >= 0) {
                        synchronized (this) {
                            try {
                                int i12 = this.f43b + 1;
                                this.f43b = i12;
                                if (i12 >= 50) {
                                    this.f43b = 0;
                                    int length = g.list().length;
                                    long b2 = b();
                                    boolean z13 = ((long) length) < b2;
                                    this.f44c = z13;
                                    if (!z13 && Log.isLoggable("Downsampler", 5)) {
                                        Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + b2);
                                    }
                                }
                                z12 = this.f44c;
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z12) {
                            return true;
                        }
                        if (Log.isLoggable("HardwareConfig", 2)) {
                            Log.v("HardwareConfig", "Hardware config disallowed because there are insufficient FDs");
                            return false;
                        }
                    } else if (Log.isLoggable("HardwareConfig", 2)) {
                        Log.v("HardwareConfig", "Hardware config disallowed because of invalid dimensions");
                    }
                } else if (Log.isLoggable("HardwareConfig", 2)) {
                    Log.v("HardwareConfig", "Hardware config disallowed by app state");
                    return false;
                }
            } else if (Log.isLoggable("HardwareConfig", 2)) {
                Log.v("HardwareConfig", "Hardware config disallowed by sdk");
                return false;
            }
        } else if (Log.isLoggable("HardwareConfig", 2)) {
            Log.v("HardwareConfig", "Hardware config disallowed by caller");
            return false;
        }
        return false;
    }
}
