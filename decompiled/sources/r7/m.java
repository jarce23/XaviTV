package r7;

import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiActivity;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements DialogInterface.OnClickListener {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f10932o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Intent f10933p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f10934q;

    public /* synthetic */ m(Intent intent, Object obj, int i10) {
        this.f10932o = i10;
        this.f10933p = intent;
        this.f10934q = obj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [java.lang.Object, p7.e] */
    public final void a() {
        switch (this.f10932o) {
            case 0:
                Intent intent = this.f10933p;
                if (intent != null) {
                    ((GoogleApiActivity) this.f10934q).startActivityForResult(intent, 2);
                    break;
                }
                break;
            default:
                Intent intent2 = this.f10933p;
                if (intent2 != null) {
                    this.f10934q.a(intent2, 2);
                    break;
                }
                break;
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i10) {
        try {
            try {
                a();
            } catch (ActivityNotFoundException e7) {
                Log.e("DialogRedirect", true == Build.FINGERPRINT.contains("generic") ? "Failed to start resolution intent. This may occur when resolving Google Play services connection issues on emulators with Google APIs but not Google Play Store." : "Failed to start resolution intent.", e7);
            }
        } finally {
            dialogInterface.dismiss();
        }
    }
}
