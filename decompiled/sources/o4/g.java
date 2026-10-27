package o4;

import android.app.Notification;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public final int f9499a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9500b;

    /* renamed from: c, reason: collision with root package name */
    public final Notification f9501c;

    public g(int i10, Notification notification, int i11) {
        this.f9499a = i10;
        this.f9501c = notification;
        this.f9500b = i11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f9499a == gVar.f9499a && this.f9500b == gVar.f9500b) {
            return this.f9501c.equals(gVar.f9501c);
        }
        return false;
    }

    public final int hashCode() {
        return this.f9501c.hashCode() + (((this.f9499a * 31) + this.f9500b) * 31);
    }

    public final String toString() {
        return "ForegroundInfo{mNotificationId=" + this.f9499a + ", mForegroundServiceType=" + this.f9500b + ", mNotification=" + this.f9501c + '}';
    }
}
