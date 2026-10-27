package f;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;
import okhttp3.internal.ws.RealWebSocket;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y extends androidx.fragment.app.g {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f4856c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ b0 f4857d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f4858e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, android.support.v4.media.session.a0 a0Var) {
        super(b0Var);
        this.f4857d = b0Var;
        this.f4858e = a0Var;
    }

    @Override // androidx.fragment.app.g
    public final IntentFilter e() {
        switch (this.f4856c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // androidx.fragment.app.g
    public final int f() {
        Location location;
        boolean z10;
        long j10;
        Location location2;
        switch (this.f4856c) {
            case 0:
                return u.a((PowerManager) this.f4858e) ? 2 : 1;
            default:
                android.support.v4.media.session.a0 a0Var = (android.support.v4.media.session.a0) this.f4858e;
                j0 j0Var = (j0) a0Var.f232r;
                LocationManager locationManager = (LocationManager) a0Var.f231q;
                if (j0Var.f4797b > System.currentTimeMillis()) {
                    z10 = j0Var.f4796a;
                } else {
                    Context context = (Context) a0Var.f230p;
                    Location location3 = null;
                    if (w7.b.g(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e7) {
                            Log.d("TwilightManager", "Failed to get last known location", e7);
                        }
                        if (locationManager.isProviderEnabled("network")) {
                            location2 = locationManager.getLastKnownLocation("network");
                            location = location2;
                        }
                        location2 = null;
                        location = location2;
                    } else {
                        location = null;
                    }
                    if (w7.b.g(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                location3 = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e8) {
                            Log.d("TwilightManager", "Failed to get last known location", e8);
                        }
                    }
                    if (location3 == null || location == null ? location3 != null : location3.getTime() > location.getTime()) {
                        location = location3;
                    }
                    if (location != null) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (i0.f4792d == null) {
                            i0.f4792d = new i0();
                        }
                        i0 i0Var = i0.f4792d;
                        i0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis - 86400000);
                        i0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis);
                        z10 = i0Var.f4795c == 1;
                        long j11 = i0Var.f4794b;
                        long j12 = i0Var.f4793a;
                        i0Var.a(location.getLatitude(), location.getLongitude(), currentTimeMillis + 86400000);
                        long j13 = i0Var.f4794b;
                        if (j11 == -1 || j12 == -1) {
                            j10 = currentTimeMillis + 43200000;
                        } else {
                            if (currentTimeMillis > j12) {
                                j11 = j13;
                            } else if (currentTimeMillis > j11) {
                                j11 = j12;
                            }
                            j10 = j11 + RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS;
                        }
                        j0Var.f4796a = z10;
                        j0Var.f4797b = j10;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i10 = Calendar.getInstance().get(11);
                        if (i10 < 6 || i10 >= 22) {
                            z10 = true;
                        }
                    }
                }
                return z10 ? 2 : 1;
        }
    }

    @Override // androidx.fragment.app.g
    public final void i() {
        switch (this.f4856c) {
            case 0:
                this.f4857d.l(true, true);
                break;
            default:
                this.f4857d.l(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(b0 b0Var, Context context) {
        super(b0Var);
        this.f4857d = b0Var;
        this.f4858e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
