package j9;

import android.app.Notification;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.play.core.assetpacks.ExtractionForegroundService;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d0 implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    public final androidx.emoji2.text.s f7248a = new androidx.emoji2.text.s("ExtractionForegroundServiceConnection", 3);

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f7249b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final Context f7250c;

    /* renamed from: d, reason: collision with root package name */
    public ExtractionForegroundService f7251d;

    /* renamed from: e, reason: collision with root package name */
    public Notification f7252e;

    public d0(Context context) {
        this.f7250c = context;
    }

    public final void a() {
        this.f7248a.d("Stopping foreground installation service.", new Object[0]);
        this.f7250c.unbindService(this);
        ExtractionForegroundService extractionForegroundService = this.f7251d;
        if (extractionForegroundService != null) {
            synchronized (extractionForegroundService) {
                extractionForegroundService.stopForeground(true);
                extractionForegroundService.stopSelf();
            }
        }
        c();
    }

    public final void b(k9.l lVar) {
        synchronized (this.f7249b) {
            this.f7249b.add(lVar);
        }
    }

    public final void c() {
        ArrayList arrayList;
        synchronized (this.f7249b) {
            arrayList = new ArrayList(this.f7249b);
            this.f7249b.clear();
        }
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            k9.l lVar = (k9.l) arrayList.get(i10);
            try {
                Bundle bundle = new Bundle();
                Bundle bundle2 = new Bundle();
                Parcel v10 = lVar.v();
                int i11 = k9.g.f7848a;
                v10.writeInt(1);
                bundle.writeToParcel(v10, 0);
                v10.writeInt(1);
                bundle2.writeToParcel(v10, 0);
                lVar.w(v10, 2);
            } catch (RemoteException unused) {
                this.f7248a.f("Could not resolve Play Store service state update callback.", new Object[0]);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f7248a.d("Starting foreground installation service.", new Object[0]);
        ExtractionForegroundService extractionForegroundService = ((c0) iBinder).f7240b;
        this.f7251d = extractionForegroundService;
        extractionForegroundService.startForeground(-1883842196, this.f7252e);
        c();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
