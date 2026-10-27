package androidx.fragment.app;

import android.content.ClipData;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import androidx.appcompat.widget.AppCompatEditText;
import app.shamel.tv.models.SeriesModel;
import c2.a1;
import c2.j1;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import i1.f1;
import i1.z0;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.url._UrlKt;
import org.json.JSONException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class v0 implements i0.a, ObjectConstructor, io.realm.t, f2.o, l1.h, h5.j0, EventListener.Factory, k2.g, g4.b, m1.s, l1.m, z1.w, b7.b {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f842o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f843p;

    public /* synthetic */ v0(int i10, Object obj) {
        this.f842o = i10;
        this.f843p = obj;
    }

    @Override // m1.s
    public void a(long j10, l1.t tVar) {
        switch (this.f842o) {
            case 17:
                k2.b.d(j10, tVar, (k2.g0[]) ((x4.m) this.f843p).f13565q);
                break;
            default:
                k2.b.e(j10, tVar, (k2.g0[]) ((android.support.v4.media.session.a0) this.f843p).f231q);
                break;
        }
    }

    @Override // l1.h
    public void accept(Object obj) {
        ((o9.d0) this.f843p).a((h3.a) obj);
    }

    @Override // f2.o
    public o9.w0 b(int i10, i1.u0 u0Var, int[] iArr) {
        f2.k kVar = (f2.k) this.f843p;
        o9.d0 m10 = o9.g0.m();
        for (int i11 = 0; i11 < u0Var.f6039a; i11++) {
            m10.a(new f2.h(i10, u0Var, i11, kVar, iArr[i11]));
        }
        return m10.f();
    }

    @Override // g4.b
    public g4.c c(g4.a aVar) {
        Context context = (Context) this.f843p;
        String str = aVar.f5152b;
        j1 j1Var = aVar.f5153c;
        za.h.e("callback", j1Var);
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        return new h4.g(context, str, j1Var, true, true);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        Object lambda$newDefaultConstructor$9;
        Object lambda$newUnsafeAllocator$19;
        switch (this.f842o) {
            case 3:
                lambda$newDefaultConstructor$9 = ConstructorConstructor.lambda$newDefaultConstructor$9((Constructor) this.f843p);
                return lambda$newDefaultConstructor$9;
            default:
                lambda$newUnsafeAllocator$19 = ConstructorConstructor.lambda$newUnsafeAllocator$19((Class) this.f843p);
                return lambda$newUnsafeAllocator$19;
        }
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        EventListener asFactory$lambda$0;
        asFactory$lambda$0 = _UtilJvmKt.asFactory$lambda$0((EventListener) this.f843p, call);
        return asFactory$lambda$0;
    }

    @Override // z1.w
    public int d(Object obj) {
        i1.p pVar = (i1.p) this.f843p;
        z1.p pVar2 = (z1.p) obj;
        String str = pVar2.f14001b;
        return ((str.equals(pVar.f5991n) || str.equals(z1.x.b(pVar))) && pVar2.c(pVar, false) && pVar2.d(pVar)) ? 1 : 0;
    }

    @Override // io.realm.t
    public void e(io.realm.u uVar) {
        ArrayList arrayList = (ArrayList) this.f843p;
        uVar.V(SeriesModel.class).d().f();
        uVar.T(arrayList);
    }

    @Override // b7.b
    public Object execute() {
        a7.l lVar = (a7.l) ((a7.c) this.f843p);
        lVar.getClass();
        int i10 = w6.a.f13113e;
        x4.i iVar = new x4.i(17, false);
        iVar.f13553p = null;
        iVar.f13554q = new ArrayList();
        iVar.f13555r = null;
        iVar.f13556s = _UrlKt.FRAGMENT_ENCODE_SET;
        HashMap hashMap = new HashMap();
        SQLiteDatabase a10 = lVar.a();
        a10.beginTransaction();
        try {
            w6.a aVar = (w6.a) a7.l.M(a10.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new a7.f(lVar, hashMap, iVar, 2));
            a10.setTransactionSuccessful();
            return aVar;
        } finally {
            a10.endTransaction();
        }
    }

    @Override // h5.j0
    public void f() {
        h5.k kVar = (h5.k) this.f843p;
        kVar.getClass();
        try {
            kVar.N(kVar.V0);
        } catch (JSONException e7) {
            e7.printStackTrace();
        }
    }

    public a1 g(x4.m mVar) {
        q6.b bVar = (q6.b) this.f843p;
        URL url = (URL) mVar.f13564p;
        j1.c.j("CctTransportBackend", "Making request to: %s", url);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(bVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.1.3 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) mVar.f13566r;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    p4.p pVar = bVar.f10352a;
                    r6.i iVar = (r6.i) mVar.f13565q;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    v9.d dVar = (v9.d) pVar.f9953p;
                    v9.e eVar = new v9.e(bufferedWriter, dVar.f12696a, dVar.f12697b, dVar.f12698c, dVar.f12699d);
                    eVar.e(iVar);
                    eVar.g();
                    eVar.f12701b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), android.support.v4.media.d.m(responseCode, "Status Code: "));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Type: " + httpURLConnection.getHeaderField("Content-Type"));
                    Log.i("TransportRuntime.".concat("CctTransportBackend"), "Content-Encoding: " + httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new a1(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new a1(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            a1 a1Var = new a1(responseCode, null, r6.m.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f10857a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return a1Var;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (ConnectException e7) {
            e = e7;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new a1(500, null, 0L);
        } catch (UnknownHostException e8) {
            e = e8;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't open connection, returning with 500", e);
            return new a1(500, null, 0L);
        } catch (IOException e10) {
            e = e10;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new a1(400, null, 0L);
        } catch (t9.b e11) {
            e = e11;
            Log.e("TransportRuntime.".concat("CctTransportBackend"), "Couldn't encode request, returning with 400", e);
            return new a1(400, null, 0L);
        }
    }

    public boolean h(h5.i iVar, int i10, Bundle bundle) {
        m0.c cVar;
        AppCompatEditText appCompatEditText = (AppCompatEditText) this.f843p;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 25 && (i10 & 1) != 0) {
            try {
                ((o0.g) iVar.f5610p).l();
                Parcelable parcelable = (Parcelable) ((o0.g) iVar.f5610p).b();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e7) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e7);
                return false;
            }
        }
        o0.g gVar = (o0.g) iVar.f5610p;
        ClipData clipData = new ClipData(gVar.a(), new ClipData.Item(gVar.d()));
        if (i11 >= 31) {
            cVar = new h5.i(clipData, 2);
        } else {
            m0.d dVar = new m0.d();
            dVar.f8644p = clipData;
            dVar.f8645q = 2;
            cVar = dVar;
        }
        cVar.u(gVar.m());
        cVar.setExtras(bundle);
        return m0.k0.i(appCompatEditText, cVar.build()) == null;
    }

    @Override // k2.g
    public long i(long j10) {
        return l1.a0.j((j10 * r0.f7772e) / 1000000, 0L, ((k2.s) this.f843p).f7776j - 1);
    }

    @Override // l1.m
    public void invoke(Object obj) {
        switch (this.f842o) {
            case 19:
                ((i1.m0) obj).f((i1.d0) this.f843p);
                break;
            case 20:
                ((i1.m0) obj).H((z0) this.f843p);
                break;
            case 21:
                ((i1.m0) obj).w((k1.c) this.f843p);
                break;
            case 22:
                ((i1.m0) obj).f(((s1.x) this.f843p).f11482o.S);
                break;
            case 23:
                ((i1.m0) obj).x((i1.f0) this.f843p);
                break;
            default:
                ((i1.m0) obj).a((f1) this.f843p);
                break;
        }
    }

    public void j() {
        ((app.shamel.tv.helper.s) this.f843p).j();
    }

    @Override // i0.a
    public void onCancel() {
        u0 u0Var = (u0) this.f843p;
        za.h.e("this$0", u0Var);
        u0Var.a();
    }

    public /* synthetic */ v0(w3.q0 q0Var, w3.o0 o0Var) {
        this.f842o = 27;
        this.f843p = q0Var;
    }
}
