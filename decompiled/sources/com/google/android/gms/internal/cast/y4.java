package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y4 implements s5 {

    /* renamed from: b, reason: collision with root package name */
    public static final y4 f3601b = new y4(0);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3602a;

    public /* synthetic */ y4(int i10) {
        this.f3602a = i10;
    }

    @Override // com.google.android.gms.internal.cast.s5
    public final c6 a(Class cls) {
        switch (this.f3602a) {
            case 0:
                if (!a5.class.isAssignableFrom(cls)) {
                    throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
                }
                try {
                    return (c6) a5.k(cls.asSubclass(a5.class)).h(3, null);
                } catch (Exception e7) {
                    throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e7);
                }
            default:
                throw new IllegalStateException("This should never be called.");
        }
    }

    @Override // com.google.android.gms.internal.cast.s5
    public final boolean b(Class cls) {
        switch (this.f3602a) {
            case 0:
                return a5.class.isAssignableFrom(cls);
            default:
                return false;
        }
    }
}
