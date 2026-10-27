package e5;

import a6.a0;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.fragment.app.v0;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.ResumeSeriesModel;
import app.shamel.tv.models.SeriesModel;
import app.shamel.tv.models.WordModels;
import io.realm.e0;
import io.realm.f0;
import io.realm.n0;
import io.realm.u;
import j9.w1;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k extends f.j {

    /* renamed from: b0, reason: collision with root package name */
    public static boolean f4604b0 = false;
    public HashMap M;
    public HashMap N;
    public i5.a O;
    public i5.a P;
    public i5.b Q;
    public i5.a R;
    public String S;
    public r T;
    public u U;
    public String V;
    public String W;
    public WordModels X = new WordModels();
    public boolean Y = false;
    public int Z = 0;

    /* renamed from: a0, reason: collision with root package name */
    public final LTVApp f4605a0 = LTVApp.a();

    public static synchronized void O(boolean z10) {
        synchronized (k.class) {
            f4604b0 = z10;
        }
    }

    public static void u(k kVar) {
        try {
            j5.f.a(kVar.T.B()).get_live_categories(kVar.V, kVar.S).enqueue(new f(kVar, 1));
        } catch (Exception unused) {
            if (kVar.Y) {
                return;
            }
            kVar.J();
        }
    }

    public final void A() {
        if (!this.U.V(EPGChannel.class).d().isEmpty()) {
            if (System.currentTimeMillis() / 1000 <= this.T.l() + (this.T.G() * 72000)) {
                if (this.Y) {
                    return;
                }
                K();
                return;
            }
        }
        try {
            j5.f.a(this.T.B()).get_live_streams(this.V, this.S).enqueue(new i(this, this.T.m(), this.T.n(), 0));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            D();
        }
    }

    public final void B(List list) {
        this.M = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            MovieModel movieModel = (MovieModel) it.next();
            String y8 = y(movieModel.getCategory_name());
            if (this.M.get(y8) == null) {
                y8 = new Date().getTime() + "!@#%" + movieModel.getCategory_name();
            }
            this.M.put(y8, movieModel.getCategory_name());
        }
        TreeSet treeSet = new TreeSet(this.M.keySet());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CategoryModel("resume_id", this.X.getResume_to_watch()));
        arrayList.add(new CategoryModel("all_id", this.X.getAll()));
        arrayList.add(new CategoryModel("fav_id", this.X.getFavorite()));
        Iterator it2 = treeSet.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            arrayList.add(new CategoryModel(String.valueOf(i10), (String) it2.next()));
            i10++;
        }
        this.T.c0(arrayList);
        if (this.Y) {
            return;
        }
        x();
    }

    public final void C() {
        n0 d6 = this.U.V(MovieModel.class).d();
        List K = this.T.K();
        List x6 = this.T.x();
        if (!d6.isEmpty() && System.currentTimeMillis() / 1000 <= this.T.l() + (this.T.G() * 72000)) {
            if (this.Y) {
                return;
            }
            B(new ArrayList(d6));
            return;
        }
        i5.a aVar = this.R;
        if (aVar != null && !aVar.g) {
            aVar.f6409h = true;
            aVar.cancel(true);
        }
        i5.a aVar2 = new i5.a(2);
        this.R = aVar2;
        aVar2.f6406d = new a(this, d6, K, x6, 0);
        aVar2.f6407e = new b(this, 0);
        aVar2.execute(null, null);
    }

    public final void D() {
        try {
            j5.f.a(this.T.B()).get_second_live_streams(this.V, this.S).enqueue(new j(this, this.T.m(), this.T.n(), 0));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            F();
        }
    }

    public final void E() {
        try {
            j5.f.a(this.T.B()).get_second_series(this.V, this.S).enqueue(new j(this, this.T.z(), this.T.w(), 1));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            w(true);
        }
    }

    public final void F() {
        try {
            j5.f.a(this.T.B()).get_second_vod_streams(this.V, this.S).enqueue(new i(this, this.T.K(), this.T.x(), 1));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            E();
        }
    }

    public final void G() {
        try {
            j5.f.a(this.T.B()).get_series_categories(this.V, this.S).enqueue(new f(this, 2));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            A();
        }
    }

    public final void H(List list) {
        int i10;
        List list2;
        List z10 = this.T.z();
        List w10 = this.T.w();
        this.N = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EpisodeModel episodeModel = (EpisodeModel) it.next();
            String series_name = episodeModel.getSeries_name();
            if (series_name == null || series_name.equals("null")) {
                series_name = "All";
            }
            List list3 = (List) this.N.get(series_name);
            if (list3 == null) {
                list3 = new ArrayList();
            }
            list3.add(episodeModel);
            this.N.put(series_name, list3);
        }
        ArrayList arrayList = new ArrayList();
        Iterator it2 = new TreeSet(this.N.keySet()).iterator();
        while (true) {
            i10 = 0;
            if (!it2.hasNext()) {
                break;
            }
            String str = (String) it2.next();
            if (str != null && (list2 = (List) this.N.get(str)) != null && !list2.isEmpty()) {
                SeriesModel seriesModel = new SeriesModel();
                seriesModel.setName(str);
                seriesModel.setCategory_name(((EpisodeModel) list2.get(0)).getCategory_name());
                seriesModel.setStream_icon(((EpisodeModel) list2.get(0)).getStream_icon());
                arrayList.add(seriesModel);
            }
        }
        this.U.P(new v0(5, arrayList));
        if (z10 != null && !z10.isEmpty()) {
            Iterator it3 = z10.iterator();
            while (it3.hasNext()) {
                this.U.P(new com.google.gson.internal.b((String) it3.next(), 7));
            }
        }
        if (w10 != null && !w10.isEmpty()) {
            Iterator it4 = w10.iterator();
            while (it4.hasNext()) {
                this.U.P(new e((ResumeSeriesModel) it4.next(), 0));
            }
        }
        this.M = new HashMap();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            SeriesModel seriesModel2 = (SeriesModel) obj;
            String y8 = y(seriesModel2.getCategory_name());
            if (this.M.get(y8) == null) {
                y8 = new Date().getTime() + "!@#%" + seriesModel2.getCategory_name();
            }
            this.M.put(y8, seriesModel2.getCategory_name());
        }
        this.M.keySet();
        TreeSet treeSet = new TreeSet(this.M.keySet());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new CategoryModel("resume_id", this.X.getRecently_viewed()));
        arrayList2.add(new CategoryModel("all_id", this.X.getAll()));
        arrayList2.add(new CategoryModel("fav_id", this.X.getFavorite()));
        Iterator it5 = treeSet.iterator();
        while (it5.hasNext()) {
            arrayList2.add(new CategoryModel(String.valueOf(i10), (String) it5.next()));
            i10++;
        }
        this.T.Y(arrayList2);
        this.T.Q(System.currentTimeMillis() / 1000);
        if (this.Y) {
            return;
        }
        w(true);
    }

    public final void I() {
        if (!this.U.V(SeriesModel.class).d().isEmpty()) {
            if (System.currentTimeMillis() / 1000 <= this.T.l() + (this.T.G() * 72000)) {
                if (this.Y) {
                    return;
                }
                w(true);
                return;
            }
        }
        try {
            j5.f.a(this.T.B()).get_series(this.V, this.S).enqueue(new i(this, this.T.z(), this.T.w(), 2));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            w(true);
        }
    }

    public final void J() {
        try {
            j5.f.a(this.T.B()).get_vod_categories(this.V, this.S).enqueue(new f(this, 3));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            G();
        }
    }

    public final void K() {
        if (!this.U.V(MovieModel.class).d().isEmpty()) {
            if (System.currentTimeMillis() / 1000 <= this.T.l() + (this.T.G() * 72000)) {
                if (this.Y) {
                    return;
                }
                I();
                return;
            }
        }
        try {
            j5.f.a(this.T.B()).get_vod_streams(this.V, this.S).enqueue(new j(this, this.T.K(), this.T.x(), 2));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            I();
        }
    }

    public final void L(String str, WordModels wordModels) {
        String str2;
        this.T = new r(this);
        if (this.Y) {
            return;
        }
        try {
            this.X = wordModels;
            String replaceAll = str.replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET);
            URL url = new URL(replaceAll.trim());
            r rVar = this.T;
            String str3 = url.getProtocol() + "://" + url.getAuthority();
            SharedPreferences.Editor edit = rVar.f2098b.edit();
            edit.putString("server_url", str3);
            edit.apply();
            String[] split = url.getQuery().split("&");
            this.V = split[0].split("=")[1];
            this.S = split[1].split("=")[1];
            w1[] w1VarArr = k5.j.f7826a;
            try {
                str2 = replaceAll.replaceAll("[:/.?=&]", _UrlKt.FRAGMENT_ENCODE_SET);
            } catch (Exception unused) {
                str2 = "m3u";
            }
            this.W = str2;
            if (!this.T.H().equalsIgnoreCase(this.W)) {
                this.U.P(new a0(23));
                r rVar2 = this.T;
                String str4 = this.W;
                SharedPreferences.Editor edit2 = rVar2.f2098b.edit();
                edit2.putString("user_id", str4);
                edit2.apply();
                this.T.R(app.shamel.tv.helper.a.c());
                this.T.c0(app.shamel.tv.helper.a.d());
                this.T.Y(app.shamel.tv.helper.a.c());
            }
            v(replaceAll);
        } catch (Exception unused2) {
            Toast.makeText(this, wordModels.getAdd_correct_alert(), 0).show();
            w(false);
        }
    }

    public final void M(String str, WordModels wordModels) {
        String str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        this.T = new r(this);
        if (this.Y) {
            return;
        }
        try {
            this.X = wordModels;
            String replaceAll = str.replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET);
            URL url = new URL(replaceAll.trim());
            r rVar = this.T;
            String str3 = url.getProtocol() + "://" + url.getAuthority();
            SharedPreferences.Editor edit = rVar.f2098b.edit();
            edit.putString("server_url", str3);
            edit.apply();
            String str4 = replaceAll.split("playlist/")[1];
            this.V = str4.contains("/") ? str4.split("/")[0] : _UrlKt.FRAGMENT_ENCODE_SET;
            String str5 = replaceAll.split("playlist/")[1];
            if (str5.contains("/")) {
                str2 = str5.split("/")[1];
            }
            this.S = str2;
            if (!this.T.H().equalsIgnoreCase(this.W)) {
                this.U.P(new a0(24));
                r rVar2 = this.T;
                String str6 = this.W;
                SharedPreferences.Editor edit2 = rVar2.f2098b.edit();
                edit2.putString("user_id", str6);
                edit2.apply();
                this.T.R(app.shamel.tv.helper.a.c());
                this.T.c0(app.shamel.tv.helper.a.d());
                this.T.Y(app.shamel.tv.helper.a.c());
            }
            v(replaceAll);
        } catch (Exception e7) {
            Log.e("goToXUILogin", "Invalid server URL", e7);
            Toast.makeText(this, "Invalid server URL", 0).show();
        }
    }

    public final void N(String str, WordModels wordModels) {
        boolean z10;
        String str2;
        this.X = wordModels;
        this.T = new r(this);
        synchronized (k.class) {
            z10 = f4604b0;
        }
        if (z10) {
            return;
        }
        O(true);
        String trim = str.replaceAll(" ", _UrlKt.FRAGMENT_ENCODE_SET).trim();
        w1[] w1VarArr = k5.j.f7826a;
        try {
            str2 = trim.replaceAll("[:/.?=&]", _UrlKt.FRAGMENT_ENCODE_SET);
        } catch (Exception unused) {
            str2 = "m3u";
        }
        this.W = str2;
        SharedPreferences.Editor edit = this.T.f2098b.edit();
        edit.putString("server_url", trim);
        edit.apply();
        if (!this.T.H().equalsIgnoreCase(this.W)) {
            this.U.P(new a0(25));
            r rVar = this.T;
            String str3 = this.W;
            SharedPreferences.Editor edit2 = rVar.f2098b.edit();
            edit2.putString("user_id", str3);
            edit2.apply();
        }
        if (this.Y) {
            return;
        }
        i5.b bVar = this.Q;
        if (bVar != null && !bVar.g) {
            bVar.f6409h = true;
            bVar.cancel(true);
        }
        i5.b bVar2 = new i5.b(trim);
        this.Q = bVar2;
        bVar2.f6406d = new b(this, 2);
        bVar2.f6407e = new f(this, 0);
        bVar2.f6408f = new b(this, 3);
        bVar2.execute(null, null);
    }

    @Override // f.j, androidx.activity.n, b0.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Object obj = u.f6839z;
        synchronized (u.class) {
            u.S(this);
        }
        e0 e0Var = new e0();
        e0Var.f6651b = "MTV.realm";
        e0Var.f6652c = 1L;
        e0Var.f6653d = true;
        e0Var.f6659k = true;
        f0 a10 = e0Var.a();
        u.U(a10);
        this.U = u.R(a10);
    }

    public final void v(String str) {
        try {
            j5.f.a(this.T.B()).authentication(this.V, this.S).enqueue(new x4.r(this, str, 5));
        } catch (Exception unused) {
            if (this.Y) {
                return;
            }
            this.T.P(true);
            N(str, this.X);
        }
    }

    public abstract void w(boolean z10);

    public final void x() {
        n0 d6 = this.U.V(EpisodeModel.class).d();
        if (!d6.isEmpty() && System.currentTimeMillis() / 1000 <= this.T.l() + (this.T.G() * 72000)) {
            if (this.Y) {
                return;
            }
            H(new ArrayList(d6));
            return;
        }
        i5.a aVar = this.P;
        int i10 = 1;
        if (aVar != null && !aVar.g) {
            aVar.f6409h = true;
            aVar.cancel(true);
        }
        i5.a aVar2 = new i5.a(i10);
        this.P = aVar2;
        aVar2.f6406d = new a7.g(this, 4, d6);
        aVar2.f6407e = new b(this, i10);
        aVar2.execute(null, null);
    }

    public final String y(String str) {
        Iterator it = new TreeSet(this.M.keySet()).iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if ((str2.contains("!@#%") ? str2.split("!@#%")[1] : "All").equalsIgnoreCase(str)) {
                return str2;
            }
        }
        return null;
    }

    public final void z(List list) {
        this.M = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EPGChannel ePGChannel = (EPGChannel) it.next();
            String y8 = y(ePGChannel.getCategory_name());
            if (this.M.get(y8) == null) {
                y8 = new Date().getTime() + "!@#%" + ePGChannel.getCategory_name();
            }
            this.M.put(y8, ePGChannel.getCategory_name());
        }
        TreeSet treeSet = new TreeSet(this.M.keySet());
        ArrayList arrayList = new ArrayList();
        arrayList.add(new CategoryModel("add_group", this.X.getAdd_group()));
        arrayList.add(new CategoryModel("resume_id", this.X.getRecently_viewed()));
        arrayList.add(new CategoryModel("all_id", this.X.getAll()));
        arrayList.add(new CategoryModel("fav_id", this.X.getFavorite()));
        arrayList.add(new CategoryModel("lock_id", this.X.getLock()));
        List s10 = this.T.s();
        int i10 = 0;
        int i11 = 6000;
        for (int i12 = 0; i12 < s10.size(); i12++) {
            arrayList.add(new CategoryModel(String.valueOf(i11), (String) s10.get(i12)));
            i11 += 1000;
        }
        Iterator it2 = treeSet.iterator();
        while (it2.hasNext()) {
            arrayList.add(new CategoryModel(String.valueOf(i10), (String) it2.next()));
            i10++;
        }
        this.T.R(arrayList);
        if (this.Y) {
            return;
        }
        C();
    }
}
