package j9;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.play.core.assetpacks.ExtractionForegroundService;
import java.util.Arrays;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l extends c8.h {

    /* renamed from: c, reason: collision with root package name */
    public final androidx.emoji2.text.s f7339c;

    /* renamed from: d, reason: collision with root package name */
    public final Context f7340d;

    /* renamed from: e, reason: collision with root package name */
    public final p f7341e;

    /* renamed from: f, reason: collision with root package name */
    public final t1 f7342f;
    public final d0 g;

    /* renamed from: h, reason: collision with root package name */
    public final h1 f7343h;

    public l(Context context, p pVar, t1 t1Var, d0 d0Var, h1 h1Var) {
        super("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionService", 3);
        this.f7339c = new androidx.emoji2.text.s("AssetPackExtractionService", 3);
        this.f7340d = context;
        this.f7341e = pVar;
        this.f7342f = t1Var;
        this.g = d0Var;
        this.f7343h = h1Var;
    }

    @Override // c8.h
    public final boolean w0(Parcel parcel, int i10) {
        String[] packagesForUid;
        k9.l lVar = null;
        if (i10 != 2) {
            if (i10 != 3) {
                return false;
            }
            Parcelable.Creator creator = Bundle.CREATOR;
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
                lVar = queryLocalInterface instanceof k9.l ? (k9.l) queryLocalInterface : new k9.l(readStrongBinder);
            }
            k9.g.b(parcel);
            this.f7339c.d("clearAssetPackStorage AIDL call", new Object[0]);
            Context context = this.f7340d;
            if (!k9.b.a(context) || (packagesForUid = context.getPackageManager().getPackagesForUid(Binder.getCallingUid())) == null || !Arrays.asList(packagesForUid).contains("com.android.vending")) {
                lVar.J(new Bundle());
                return true;
            }
            p.f(this.f7341e.d());
            Bundle bundle = new Bundle();
            Parcel v10 = lVar.v();
            v10.writeInt(1);
            bundle.writeToParcel(v10, 0);
            lVar.w(v10, 4);
            return true;
        }
        Parcelable.Creator creator2 = Bundle.CREATOR;
        Bundle bundle2 = (Bundle) k9.g.a(parcel);
        IBinder readStrongBinder2 = parcel.readStrongBinder();
        if (readStrongBinder2 != null) {
            IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
            lVar = queryLocalInterface2 instanceof k9.l ? (k9.l) queryLocalInterface2 : new k9.l(readStrongBinder2);
        }
        k9.g.b(parcel);
        synchronized (this) {
            this.f7339c.d("updateServiceState AIDL call", new Object[0]);
            if (k9.b.a(this.f7340d)) {
                String[] packagesForUid2 = this.f7340d.getPackageManager().getPackagesForUid(Binder.getCallingUid());
                if (packagesForUid2 != null && Arrays.asList(packagesForUid2).contains("com.android.vending")) {
                    int i11 = bundle2.getInt("action_type");
                    this.g.b(lVar);
                    if (i11 == 1) {
                        this.f7343h.b(bundle2);
                        this.f7342f.a(true);
                        this.g.f7252e = this.f7343h.a(bundle2);
                        this.f7340d.bindService(new Intent(this.f7340d, (Class<?>) ExtractionForegroundService.class), this.g, 1);
                        return true;
                    }
                    if (i11 == 2) {
                        this.f7342f.a(false);
                        this.g.a();
                        return true;
                    }
                    this.f7339c.f("Unknown action type received: %d", Integer.valueOf(i11));
                    lVar.J(new Bundle());
                    return true;
                }
            }
            lVar.J(new Bundle());
            return true;
        }
    }
}
