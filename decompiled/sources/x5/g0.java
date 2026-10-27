package x5;

import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g0 implements t {

    /* renamed from: b, reason: collision with root package name */
    public static final Set f13635b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "content", "android.resource")));

    /* renamed from: a, reason: collision with root package name */
    public final Object f13636a;

    public g0(f0 f0Var) {
        this.f13636a = f0Var;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        com.bumptech.glide.load.data.d aVar;
        Uri uri = (Uri) obj;
        l6.d dVar = new l6.d(uri);
        f0 f0Var = (f0) this.f13636a;
        switch (f0Var.f13630a) {
            case 0:
                aVar = new com.bumptech.glide.load.data.a(f0Var.f13631b, uri, f0Var.f13632c, 0);
                break;
            case 1:
                aVar = new com.bumptech.glide.load.data.a(f0Var.f13631b, uri, f0Var.f13632c, 1);
                break;
            default:
                aVar = new com.bumptech.glide.load.data.m(f0Var.f13631b, uri, f0Var.f13632c);
                break;
        }
        return new s(dVar, aVar);
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        return f13635b.contains(((Uri) obj).getScheme());
    }
}
