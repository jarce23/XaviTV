package androidx.activity;

import android.window.BackEvent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final float f284a;

    /* renamed from: b, reason: collision with root package name */
    public final float f285b;

    /* renamed from: c, reason: collision with root package name */
    public final float f286c;

    /* renamed from: d, reason: collision with root package name */
    public final int f287d;

    public b(BackEvent backEvent) {
        a aVar = a.f283a;
        float d6 = aVar.d(backEvent);
        float e7 = aVar.e(backEvent);
        float b2 = aVar.b(backEvent);
        int c10 = aVar.c(backEvent);
        this.f284a = d6;
        this.f285b = e7;
        this.f286c = b2;
        this.f287d = c10;
    }

    public final String toString() {
        return "BackEventCompat{touchX=" + this.f284a + ", touchY=" + this.f285b + ", progress=" + this.f286c + ", swipeEdge=" + this.f287d + '}';
    }
}
