package x5;

import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final z f13668a;

    /* renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.h f13669b;

    public w(android.support.v4.media.session.a0 a0Var) {
        z zVar = new z(a0Var);
        this.f13669b = new com.bumptech.glide.h(3);
        this.f13668a = zVar;
    }

    public final synchronized ArrayList a(Class cls) {
        return this.f13668a.d(cls);
    }
}
