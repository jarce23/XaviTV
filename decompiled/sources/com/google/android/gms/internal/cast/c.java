package com.google.android.gms.internal.cast;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: f, reason: collision with root package name */
    public static final l7.b f3275f = new l7.b("AppVisibilityProxy", null);
    public static final int g = 1;

    /* renamed from: d, reason: collision with root package name */
    public final Set f3276d;

    /* renamed from: e, reason: collision with root package name */
    public int f3277e;

    public c() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener", 1);
        this.f3276d = Collections.synchronizedSet(new HashSet());
        this.f3277e = g;
    }
}
