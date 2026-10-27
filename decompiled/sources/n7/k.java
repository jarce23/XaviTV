package n7;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k extends b8.e {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9238a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f9239b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d dVar, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f9239b = dVar;
        this.f9238a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 1) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(i10).length() + 39);
            sb2.append("Don't know how to handle this message: ");
            sb2.append(i10);
            Log.w("GoogleApiAvailability", sb2.toString());
            return;
        }
        int i11 = e.f9228a;
        d dVar = this.f9239b;
        Context context = this.f9238a;
        int b2 = dVar.b(context, i11);
        int i12 = h.f9232c;
        if (b2 == 1 || b2 == 2 || b2 == 3 || b2 == 9) {
            Intent a10 = dVar.a(b2, context, "n");
            dVar.g(context, b2, a10 == null ? null : PendingIntent.getActivity(context, 0, a10, 201326592));
        }
    }
}
