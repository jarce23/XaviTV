package i5;

import android.accounts.NetworkErrorException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.widget.Toast;
import app.shamel.tv.apps.LTVApp;
import e5.k;
import java.io.IOException;
import org.json.JSONException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class e extends AsyncTask {

    /* renamed from: a, reason: collision with root package name */
    public IOException f6403a;

    /* renamed from: b, reason: collision with root package name */
    public JSONException f6404b;

    /* renamed from: c, reason: collision with root package name */
    public Exception f6405c;

    /* renamed from: d, reason: collision with root package name */
    public c f6406d;

    /* renamed from: e, reason: collision with root package name */
    public d f6407e;

    /* renamed from: f, reason: collision with root package name */
    public e5.b f6408f;
    public boolean g = false;

    /* renamed from: h, reason: collision with root package name */
    public boolean f6409h = false;

    public abstract Object a();

    @Override // android.os.AsyncTask
    public final Object doInBackground(Object... objArr) {
        if (isCancelled()) {
            return null;
        }
        try {
            return a();
        } catch (IOException e7) {
            this.f6403a = e7;
            return null;
        } catch (JSONException e8) {
            this.f6404b = e8;
            return null;
        } catch (Exception e10) {
            this.f6405c = e10;
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        this.g = true;
        if (isCancelled() || this.f6409h) {
            return;
        }
        if (this.f6404b != null) {
            d dVar = this.f6407e;
            if (dVar != null) {
                dVar.a();
                return;
            }
            return;
        }
        if (this.f6403a != null) {
            d dVar2 = this.f6407e;
            if (dVar2 != null) {
                dVar2.a();
                return;
            }
            return;
        }
        if (this.f6405c != null) {
            d dVar3 = this.f6407e;
            if (dVar3 != null) {
                dVar3.a();
                return;
            }
            return;
        }
        c cVar = this.f6406d;
        if (cVar != null) {
            cVar.c(obj);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        this.g = false;
        this.f6409h = false;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) LTVApp.a().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            e5.b bVar = this.f6408f;
            if (bVar != null) {
                new NetworkErrorException("Not available connection");
                k kVar = bVar.f4583p;
                if (!kVar.Y) {
                    kVar.w(false);
                    Toast.makeText(kVar.getApplicationContext(), kVar.X.getUser_incorrect(), 0).show();
                }
                k.O(false);
            }
            this.f6409h = true;
            cancel(true);
        }
    }

    @Override // android.os.AsyncTask
    public final void onProgressUpdate(Object... objArr) {
        super.onProgressUpdate(objArr);
    }
}
