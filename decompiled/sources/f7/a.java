package f7;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f5031c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static a f5032d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f5033a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f5034b;

    public a(Context context) {
        this.f5034b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public final String a(String str) {
        ReentrantLock reentrantLock = this.f5033a;
        reentrantLock.lock();
        try {
            return this.f5034b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }
}
