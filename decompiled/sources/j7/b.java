package j7;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.u;
import com.google.android.gms.internal.cast.u5;
import h7.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends AsyncTask {

    /* renamed from: c, reason: collision with root package name */
    public static final l7.b f7126c = new l7.b("FetchBitmapTask", null);

    /* renamed from: a, reason: collision with root package name */
    public final e f7127a;

    /* renamed from: b, reason: collision with root package name */
    public final u5 f7128b;

    public b(Context context, int i10, int i11, u5 u5Var) {
        e eVar;
        this.f7128b = u5Var;
        Context applicationContext = context.getApplicationContext();
        a0 a0Var = new a0(this);
        l7.b bVar = com.google.android.gms.internal.cast.d.f3291a;
        try {
            com.google.android.gms.internal.cast.f b2 = com.google.android.gms.internal.cast.d.b(applicationContext.getApplicationContext());
            x7.b bVar2 = new x7.b(applicationContext.getApplicationContext());
            Parcel x02 = b2.x0(b2.w0(), 8);
            int readInt = x02.readInt();
            x02.recycle();
            eVar = readInt >= 233700000 ? b2.E0(bVar2, new x7.b(this), a0Var, i10, i11) : b2.D0(new x7.b(this), a0Var, i10, i11);
        } catch (RemoteException e7) {
            e = e7;
            com.google.android.gms.internal.cast.d.f3291a.a(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", com.google.android.gms.internal.cast.f.class.getSimpleName());
            eVar = null;
            this.f7127a = eVar;
        } catch (h7.e e8) {
            e = e8;
            com.google.android.gms.internal.cast.d.f3291a.a(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", com.google.android.gms.internal.cast.f.class.getSimpleName());
            eVar = null;
            this.f7127a = eVar;
        }
        this.f7127a = eVar;
    }

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object[] objArr) {
        Uri uri;
        e eVar;
        Uri[] uriArr = (Uri[]) objArr;
        if (uriArr.length == 1 && (uri = uriArr[0]) != null && (eVar = this.f7127a) != null) {
            try {
                c cVar = (c) eVar;
                Parcel w02 = cVar.w0();
                u.c(w02, uri);
                Parcel x02 = cVar.x0(w02, 1);
                Bitmap bitmap = (Bitmap) u.a(x02, Bitmap.CREATOR);
                x02.recycle();
                return bitmap;
            } catch (RemoteException e7) {
                f7126c.a(e7, "Unable to call %s on %s.", "doFetch", e.class.getSimpleName());
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        u5 u5Var = this.f7128b;
        if (u5Var != null) {
            a aVar = (a) u5Var.f3498s;
            if (aVar != null) {
                aVar.d(bitmap);
            }
            u5Var.f3497r = null;
        }
    }
}
