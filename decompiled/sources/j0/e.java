package j0;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6915a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f6916b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f6917c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f6918d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6919e;

    public /* synthetic */ e(String str, Context context, Object obj, int i10, int i11) {
        this.f6915a = i11;
        this.f6916b = str;
        this.f6917c = context;
        this.f6919e = obj;
        this.f6918d = i10;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i10 = this.f6915a;
        int i11 = this.f6918d;
        Object obj = this.f6919e;
        Context context = this.f6917c;
        String str = this.f6916b;
        switch (i10) {
            case 0:
                Object[] objArr = {(d) obj};
                ArrayList arrayList = new ArrayList(1);
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                arrayList.add(obj2);
                return h.b(str, context, Collections.unmodifiableList(arrayList), i11);
            default:
                try {
                    return h.b(str, context, (ArrayList) obj, i11);
                } catch (Throwable unused) {
                    return new g(-3);
                }
        }
    }
}
