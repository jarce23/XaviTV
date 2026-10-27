package bb;

import d9.f;
import java.util.Random;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2488a;

    public /* synthetic */ b(int i10) {
        this.f2488a = i10;
    }

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f2488a) {
            case 0:
                return new Random();
            case 1:
                return new f();
            case 2:
                return new f();
            case 3:
                return new f();
            case 4:
                return new io.realm.c();
            case 5:
                return Boolean.FALSE;
            default:
                return 0L;
        }
    }
}
