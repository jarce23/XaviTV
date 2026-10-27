package a8;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f145a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f146b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f147c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f148d;

    public /* synthetic */ a(SharedPreferences sharedPreferences, String str, Object obj, int i10) {
        this.f145a = i10;
        this.f146b = sharedPreferences;
        this.f147c = str;
        this.f148d = obj;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        switch (this.f145a) {
            case 0:
                return Boolean.valueOf(this.f146b.getBoolean(this.f147c, ((Boolean) this.f148d).booleanValue()));
            case 1:
                return Integer.valueOf(this.f146b.getInt(this.f147c, ((Integer) this.f148d).intValue()));
            case 2:
                return Long.valueOf(this.f146b.getLong(this.f147c, ((Long) this.f148d).longValue()));
            default:
                return this.f146b.getString(this.f147c, (String) this.f148d);
        }
    }
}
