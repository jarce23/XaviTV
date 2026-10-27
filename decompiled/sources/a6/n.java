package a6;

import android.app.ActivityManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.support.v4.media.MediaMetadataCompat;
import android.util.SparseArray;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.v0;
import androidx.leanback.widget.w0;
import androidx.leanback.widget.x0;
import app.shamel.tv.MainActivity;
import app.shamel.tv.activities.CatchUpActivity;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.MovieSecondActivity;
import app.shamel.tv.activities.SeriesActivity;
import app.shamel.tv.activities.SeriesSecondActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.CatchUpEpg;
import app.shamel.tv.models.CatchUpEpgResponse;
import app.shamel.tv.models.CatchupModel;
import app.shamel.tv.models.CategoryModel;
import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.ResumeModel;
import app.shamel.tv.models.SeriesModel;
import b4.n1;
import com.google.android.gms.cast.MediaInfo;
import io.realm.RealmQuery;
import io.realm.internal.TableQuery;
import io.realm.internal.objectstore.OsKeyPathMapping;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class n implements m, androidx.leanback.widget.k0, h5.t, Callback, e2.e, p7.h {

    /* renamed from: q, reason: collision with root package name */
    public static HashMap f71q;

    /* renamed from: r, reason: collision with root package name */
    public static n f72r;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f73o;

    /* renamed from: p, reason: collision with root package name */
    public Object f74p;

    public /* synthetic */ n(int i10, Object obj) {
        this.f73o = i10;
        this.f74p = obj;
    }

    public static n K() {
        if (f72r == null) {
            LTVApp a10 = LTVApp.a();
            Object obj = io.realm.u.f6839z;
            synchronized (io.realm.u.class) {
                io.realm.u.S(a10);
            }
            n nVar = new n(13, false);
            io.realm.e0 e0Var = new io.realm.e0();
            e0Var.f6651b = "MTV.realm";
            e0Var.f6652c = 1L;
            e0Var.f6653d = true;
            e0Var.f6659k = true;
            nVar.f74p = io.realm.u.R(e0Var.a());
            f72r = nVar;
        }
        return f72r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0055, code lost:
    
        if (r20 != 4) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0057, code lost:
    
        r2 = r3.V(app.shamel.tv.models.MovieModel.class);
        android.support.v4.media.d.w(r2, r4, r18, "name", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
    
        r2 = r3.V(app.shamel.tv.models.MovieModel.class);
        android.support.v4.media.d.w(r2, r4, r18, "name", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f8, code lost:
    
        if (r20 != 4) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.realm.n0 A(app.shamel.tv.models.CategoryModel r17, java.lang.String r18, boolean r19, int r20) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n.A(app.shamel.tv.models.CategoryModel, java.lang.String, boolean, int):io.realm.n0");
    }

    public ArrayList B() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(EPGChannel.class);
        V.b("is_recent");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            arrayList.add(((EPGChannel) oVar.next()).getName());
        }
        return arrayList;
    }

    public ArrayList C() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(MovieModel.class);
        V.b("is_recent");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            MovieModel movieModel = (MovieModel) oVar.next();
            ResumeModel resumeModel = new ResumeModel();
            resumeModel.setName(movieModel.getName());
            resumeModel.setPro(movieModel.getPro());
            resumeModel.setLast_position(movieModel.getTime());
            resumeModel.setTmdb_id(movieModel.getTmdb_id());
            arrayList.add(resumeModel);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b9, code lost:
    
        if (r20 != 4) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00bb, code lost:
    
        r2 = r3.V(app.shamel.tv.models.SeriesModel.class);
        android.support.v4.media.d.w(r2, r4, r18, "name", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c3, code lost:
    
        r2 = r3.V(app.shamel.tv.models.SeriesModel.class);
        android.support.v4.media.d.w(r2, r4, r18, "name", 2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00f8, code lost:
    
        if (r20 != 4) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public io.realm.n0 D(app.shamel.tv.models.CategoryModel r17, java.lang.String r18, boolean r19, int r20) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a6.n.D(app.shamel.tv.models.CategoryModel, java.lang.String, boolean, int):io.realm.n0");
    }

    public int E(int i10) {
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        View s10 = pVar.s(i10 - pVar.f1059u);
        Rect rect = androidx.leanback.widget.p.f1050c0;
        pVar.B(s10, rect);
        return pVar.f1056r == 0 ? rect.width() : rect.height();
    }

    public void F(int i10, long j10) {
        c3.d dVar = (c3.d) this.f74p;
        if (i10 == 20529) {
            if (j10 == 0) {
                return;
            }
            throw i1.h0.a(null, "ContentEncodingOrder " + j10 + " not supported");
        }
        if (i10 == 20530) {
            if (j10 == 1) {
                return;
            }
            throw i1.h0.a(null, "ContentEncodingScope " + j10 + " not supported");
        }
        switch (i10) {
            case 131:
                dVar.h(i10);
                dVar.f2854x.f2801e = (int) j10;
                return;
            case 136:
                dVar.h(i10);
                dVar.f2854x.X = j10 == 1;
                return;
            case 155:
                dVar.L = dVar.n(j10);
                return;
            case 159:
                dVar.h(i10);
                dVar.f2854x.Q = (int) j10;
                return;
            case 176:
                dVar.h(i10);
                dVar.f2854x.f2809n = (int) j10;
                return;
            case 179:
                dVar.d(i10);
                dVar.F.a(dVar.n(j10));
                return;
            case 186:
                dVar.h(i10);
                dVar.f2854x.f2810o = (int) j10;
                return;
            case 215:
                dVar.h(i10);
                dVar.f2854x.f2800d = (int) j10;
                return;
            case 231:
                dVar.E = dVar.n(j10);
                return;
            case 238:
                dVar.S = (int) j10;
                return;
            case 241:
                if (dVar.H) {
                    return;
                }
                dVar.d(i10);
                dVar.G.a(j10);
                dVar.H = true;
                return;
            case 251:
                dVar.T = true;
                return;
            case 16871:
                dVar.h(i10);
                dVar.f2854x.f2803h = (int) j10;
                return;
            case 16980:
                if (j10 == 3) {
                    return;
                }
                throw i1.h0.a(null, "ContentCompAlgo " + j10 + " not supported");
            case 17029:
                if (j10 < 1 || j10 > 2) {
                    throw i1.h0.a(null, "DocTypeReadVersion " + j10 + " not supported");
                }
                return;
            case 17143:
                if (j10 == 1) {
                    return;
                }
                throw i1.h0.a(null, "EBMLReadVersion " + j10 + " not supported");
            case 18401:
                if (j10 == 5) {
                    return;
                }
                throw i1.h0.a(null, "ContentEncAlgo " + j10 + " not supported");
            case 18408:
                if (j10 == 1) {
                    return;
                }
                throw i1.h0.a(null, "AESSettingsCipherMode " + j10 + " not supported");
            case 21420:
                dVar.A = j10 + dVar.f2849s;
                return;
            case 21432:
                int i11 = (int) j10;
                dVar.h(i10);
                if (i11 == 0) {
                    dVar.f2854x.f2820y = 0;
                    return;
                }
                if (i11 == 1) {
                    dVar.f2854x.f2820y = 2;
                    return;
                } else if (i11 == 3) {
                    dVar.f2854x.f2820y = 1;
                    return;
                } else {
                    if (i11 != 15) {
                        return;
                    }
                    dVar.f2854x.f2820y = 3;
                    return;
                }
            case 21680:
                dVar.h(i10);
                dVar.f2854x.f2812q = (int) j10;
                return;
            case 21682:
                dVar.h(i10);
                dVar.f2854x.f2814s = (int) j10;
                return;
            case 21690:
                dVar.h(i10);
                dVar.f2854x.f2813r = (int) j10;
                return;
            case 21930:
                dVar.h(i10);
                dVar.f2854x.W = j10 == 1;
                return;
            case 21938:
                dVar.h(i10);
                c3.c cVar = dVar.f2854x;
                cVar.f2821z = true;
                cVar.f2811p = (int) j10;
                return;
            case 21998:
                dVar.h(i10);
                dVar.f2854x.g = (int) j10;
                return;
            case 22186:
                dVar.h(i10);
                dVar.f2854x.T = j10;
                return;
            case 22203:
                dVar.h(i10);
                dVar.f2854x.U = j10;
                return;
            case 25188:
                dVar.h(i10);
                dVar.f2854x.R = (int) j10;
                return;
            case 30114:
                dVar.U = j10;
                return;
            case 30321:
                dVar.h(i10);
                int i12 = (int) j10;
                if (i12 == 0) {
                    dVar.f2854x.f2815t = 0;
                    return;
                }
                if (i12 == 1) {
                    dVar.f2854x.f2815t = 1;
                    return;
                } else if (i12 == 2) {
                    dVar.f2854x.f2815t = 2;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    dVar.f2854x.f2815t = 3;
                    return;
                }
            case 2352003:
                dVar.h(i10);
                dVar.f2854x.f2802f = (int) j10;
                return;
            case 2807729:
                dVar.f2850t = j10;
                return;
            default:
                switch (i10) {
                    case 21945:
                        dVar.h(i10);
                        int i13 = (int) j10;
                        if (i13 == 1) {
                            dVar.f2854x.C = 2;
                            return;
                        } else {
                            if (i13 != 2) {
                                return;
                            }
                            dVar.f2854x.C = 1;
                            return;
                        }
                    case 21946:
                        dVar.h(i10);
                        int g = i1.g.g((int) j10);
                        if (g != -1) {
                            dVar.f2854x.B = g;
                            return;
                        }
                        return;
                    case 21947:
                        dVar.h(i10);
                        dVar.f2854x.f2821z = true;
                        int f10 = i1.g.f((int) j10);
                        if (f10 != -1) {
                            dVar.f2854x.A = f10;
                            return;
                        }
                        return;
                    case 21948:
                        dVar.h(i10);
                        dVar.f2854x.D = (int) j10;
                        return;
                    case 21949:
                        dVar.h(i10);
                        dVar.f2854x.E = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    public void G() {
        ((androidx.fragment.app.u) this.f74p).f828v.L();
    }

    public void H(int i10) {
        switch (this.f73o) {
            case 9:
                ((MovieActivity) this.f74p).f1731j0 = i10;
                break;
            case 10:
                ((MovieSecondActivity) this.f74p).f1783d0 = i10;
                break;
            case 11:
                ((SeriesActivity) this.f74p).f1804j0 = i10;
                break;
            default:
                ((SeriesSecondActivity) this.f74p).f1844d0 = i10;
                break;
        }
    }

    public void I(String str, String str2) {
        p.e eVar = MediaMetadataCompat.f186r;
        if (eVar.containsKey(str) && ((Integer) eVar.get(str)).intValue() != 1) {
            throw new IllegalArgumentException(android.support.v4.media.d.q("The ", str, " key cannot be used to put a String"));
        }
        ((Bundle) this.f74p).putCharSequence(str, str2);
    }

    public void J(int i10) {
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        View s10 = pVar.s(i10 - pVar.f1059u);
        if ((pVar.f1064z & 3) == 1) {
            pVar.D0(pVar.f1063y, pVar.f2357a.R(s10), s10);
        } else {
            pVar.x0(s10, pVar.f1063y);
        }
    }

    @Override // h5.t
    public void a() {
        List<ActivityManager.AppTask> appTasks;
        System.exit(0);
        Process.killProcess(Process.myPid());
        MainActivity mainActivity = (MainActivity) this.f74p;
        ActivityManager activityManager = (ActivityManager) mainActivity.getSystemService("activity");
        if (activityManager != null && (appTasks = activityManager.getAppTasks()) != null && !appTasks.isEmpty()) {
            appTasks.get(0).setExcludeFromRecents(true);
        }
        mainActivity.finishAndRemoveTask();
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        l7.x xVar = (l7.x) obj;
        l7.g gVar = (l7.g) xVar.j();
        g7.d0 d0Var = ((g7.e0) this.f74p).f5206k;
        Parcel w02 = gVar.w0();
        com.google.android.gms.internal.cast.u.d(w02, d0Var);
        gVar.z0(w02, 18);
        l7.g gVar2 = (l7.g) xVar.j();
        gVar2.z0(gVar2.w0(), 17);
        ((i8.d) obj2).b(null);
    }

    public void b(Object obj, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        androidx.leanback.widget.n nVar;
        int i16;
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        x4.i iVar = pVar.U;
        View view = (View) obj;
        if (i13 == Integer.MIN_VALUE || i13 == Integer.MAX_VALUE) {
            if (pVar.S.f1025c) {
                x0 x0Var = (x0) iVar.f13555r;
                i13 = x0Var.f1097i - x0Var.f1099k;
            } else {
                i13 = ((x0) iVar.f13555r).f1098j;
            }
        }
        if (pVar.S.f1025c) {
            i14 = i13 - i11;
            i15 = i13;
        } else {
            i15 = i11 + i13;
            i14 = i13;
        }
        int a12 = (pVar.a1(i12) + ((x0) iVar.f13556s).f1098j) - pVar.G;
        w0 w0Var = pVar.Z;
        if (((n1) w0Var.f1089q) != null) {
            SparseArray<Parcelable> sparseArray = (SparseArray) ((n1) w0Var.f1089q).l(Integer.toString(i10));
            if (sparseArray != null) {
                view.restoreHierarchyState(sparseArray);
            }
        }
        pVar.f1(view, i12, i14, i15, a12);
        if (!pVar.f1058t.g) {
            pVar.B1();
        }
        if ((pVar.f1064z & 3) == 1 || (nVar = pVar.D) == null) {
            return;
        }
        androidx.leanback.widget.p pVar2 = nVar.f1046u;
        if (nVar.f1044s && (i16 = nVar.f1045t) != 0) {
            nVar.f1045t = pVar2.l1(i16, true);
        }
        int i17 = nVar.f1045t;
        if (i17 != 0 && (i17 <= 0 || !pVar2.d1())) {
            if (nVar.f1045t >= 0) {
                return;
            }
            if (pVar2.H() != 0 && pVar2.f1055q.F(0) == null) {
                return;
            }
        }
        nVar.f2450a = pVar2.B;
        nVar.j();
    }

    @Override // a6.m
    public short c() {
        int read = ((InputStream) this.f74p).read();
        if (read != -1) {
            return (short) read;
        }
        throw new l();
    }

    public void d(final String str, final String str2, final boolean z10, final long j10, final int i10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new io.realm.t() { // from class: app.shamel.tv.helper.v
            @Override // io.realm.t
            public final void e(io.realm.u uVar) {
                MovieModel movieModel = (MovieModel) android.support.v4.media.d.j(uVar, MovieModel.class, "name", str);
                if (movieModel != null) {
                    movieModel.setIs_recent(z10);
                    movieModel.setTime(j10);
                    movieModel.setPro(i10);
                    movieModel.setTmdb_id(str2);
                }
            }
        }, new v0(1, sVar));
    }

    @Override // a6.m
    public int f() {
        return (c() << 8) | c();
    }

    @Override // a6.m
    public int g(int i10, byte[] bArr) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10 && (i12 = ((InputStream) this.f74p).read(bArr, i11, i10 - i11)) != -1) {
            i11 += i12;
        }
        if (i11 == 0 && i12 == -1) {
            throw new l();
        }
        return i11;
    }

    public void h(String str, boolean z10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.t(str, z10, 1), new v0(1, sVar));
    }

    public void i(String str, boolean z10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.t(str, z10, 2), new v0(1, sVar));
    }

    public void j(String str, boolean z10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.t(str, z10, 0), new v0(1, sVar));
    }

    public void k(String str, boolean z10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.t(str, z10, 4), new v0(1, sVar));
    }

    public void l(String str, boolean z10, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.t(str, z10, 3), new v0(1, sVar));
    }

    public void m(String str, boolean z10, int i10, int i11, app.shamel.tv.helper.s sVar) {
        ((io.realm.u) this.f74p).Q(new app.shamel.tv.helper.u(str, i10, i11, z10), new v0(1, sVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void n(int i10, int i11, k2.o oVar) {
        int i12;
        int i13;
        int i14;
        long j10;
        int i15;
        int i16;
        int i17;
        int i18;
        c3.d dVar = (c3.d) this.f74p;
        c3.e eVar = dVar.f2829b;
        SparseArray sparseArray = dVar.f2831c;
        l1.t tVar = dVar.f2841k;
        l1.t tVar2 = dVar.f2839i;
        int i19 = 1;
        int i20 = 0;
        if (i10 != 161 && i10 != 163) {
            if (i10 == 165) {
                if (dVar.J != 2) {
                    return;
                }
                c3.c cVar = (c3.c) sparseArray.get(dVar.P);
                int i21 = dVar.S;
                l1.t tVar3 = dVar.f2846p;
                if (i21 != 4 || !"V_VP9".equals(cVar.f2799c)) {
                    oVar.i(i11);
                    return;
                } else {
                    tVar3.F(i11);
                    oVar.readFully(tVar3.f8129a, 0, i11);
                    return;
                }
            }
            if (i10 == 16877) {
                dVar.h(i10);
                c3.c cVar2 = dVar.f2854x;
                int i22 = cVar2.f2803h;
                if (i22 != 1685485123 && i22 != 1685480259) {
                    oVar.i(i11);
                    return;
                }
                byte[] bArr = new byte[i11];
                cVar2.P = bArr;
                oVar.readFully(bArr, 0, i11);
                return;
            }
            if (i10 == 16981) {
                dVar.h(i10);
                byte[] bArr2 = new byte[i11];
                dVar.f2854x.f2805j = bArr2;
                oVar.readFully(bArr2, 0, i11);
                return;
            }
            if (i10 == 18402) {
                byte[] bArr3 = new byte[i11];
                oVar.readFully(bArr3, 0, i11);
                dVar.h(i10);
                dVar.f2854x.f2806k = new k2.f0(1, 0, 0, bArr3);
                return;
            }
            if (i10 == 21419) {
                Arrays.fill(tVar.f8129a, (byte) 0);
                oVar.readFully(tVar.f8129a, 4 - i11, i11);
                tVar.I(0);
                dVar.f2856z = (int) tVar.y();
                return;
            }
            if (i10 == 25506) {
                dVar.h(i10);
                byte[] bArr4 = new byte[i11];
                dVar.f2854x.f2807l = bArr4;
                oVar.readFully(bArr4, 0, i11);
                return;
            }
            if (i10 != 30322) {
                throw i1.h0.a(null, "Unexpected id: " + i10);
            }
            dVar.h(i10);
            byte[] bArr5 = new byte[i11];
            dVar.f2854x.f2819x = bArr5;
            oVar.readFully(bArr5, 0, i11);
            return;
        }
        if (dVar.J == 0) {
            dVar.P = (int) eVar.b(oVar, false, true, 8);
            dVar.Q = eVar.f2860c;
            dVar.L = -9223372036854775807L;
            dVar.J = 1;
            tVar2.F(0);
        }
        c3.c cVar3 = (c3.c) sparseArray.get(dVar.P);
        if (cVar3 == null) {
            oVar.i(i11 - dVar.Q);
            dVar.J = 0;
            return;
        }
        cVar3.Z.getClass();
        if (dVar.J == 1) {
            dVar.k(oVar, 3);
            int i23 = (tVar2.f8129a[2] & 6) >> 1;
            int i24 = 255;
            if (i23 == 0) {
                dVar.N = 1;
                int[] iArr = dVar.O;
                if (iArr == null) {
                    iArr = new int[1];
                } else if (iArr.length < 1) {
                    iArr = new int[Math.max(iArr.length * 2, 1)];
                }
                dVar.O = iArr;
                iArr[0] = (i11 - dVar.Q) - 3;
            } else {
                dVar.k(oVar, 4);
                int i25 = (tVar2.f8129a[3] & 255) + 1;
                dVar.N = i25;
                int[] iArr2 = dVar.O;
                if (iArr2 == null) {
                    iArr2 = new int[i25];
                } else if (iArr2.length < i25) {
                    iArr2 = new int[Math.max(iArr2.length * 2, i25)];
                }
                dVar.O = iArr2;
                if (i23 == 2) {
                    int i26 = (i11 - dVar.Q) - 4;
                    int i27 = dVar.N;
                    Arrays.fill(iArr2, 0, i27, i26 / i27);
                } else {
                    if (i23 != 1) {
                        if (i23 != 3) {
                            throw i1.h0.a(null, "Unexpected lacing value: " + i23);
                        }
                        int i28 = 0;
                        int i29 = 0;
                        int i30 = 4;
                        while (true) {
                            int i31 = dVar.N - i19;
                            if (i28 >= i31) {
                                i12 = i19;
                                i13 = i20;
                                dVar.O[i31] = ((i11 - dVar.Q) - i30) - i29;
                                break;
                            }
                            dVar.O[i28] = i20;
                            int i32 = i30 + 1;
                            dVar.k(oVar, i32);
                            if (tVar2.f8129a[i30] == 0) {
                                throw i1.h0.a(null, "No valid varint length mask found");
                            }
                            int i33 = i19;
                            int i34 = i20;
                            while (true) {
                                if (i34 >= 8) {
                                    i14 = i20;
                                    j10 = 0;
                                    i15 = i32;
                                    break;
                                }
                                int i35 = i33 << (7 - i34);
                                i14 = i20;
                                if ((tVar2.f8129a[i30] & i35) != 0) {
                                    i15 = i32 + i34;
                                    dVar.k(oVar, i15);
                                    j10 = tVar2.f8129a[i30] & i24 & (~i35);
                                    while (i32 < i15) {
                                        j10 = (j10 << 8) | (tVar2.f8129a[i32] & i24);
                                        i32++;
                                        i24 = 255;
                                    }
                                    if (i28 > 0) {
                                        j10 -= (1 << ((i34 * 7) + 6)) - 1;
                                    }
                                } else {
                                    i34++;
                                    i20 = i14;
                                    i24 = 255;
                                }
                            }
                            if (j10 < -2147483648L || j10 > 2147483647L) {
                                break;
                            }
                            int i36 = (int) j10;
                            int[] iArr3 = dVar.O;
                            if (i28 != 0) {
                                i36 += iArr3[i28 - 1];
                            }
                            iArr3[i28] = i36;
                            i29 += i36;
                            i28++;
                            i30 = i15;
                            i19 = i33;
                            i20 = i14;
                            i24 = 255;
                        }
                        throw i1.h0.a(null, "EBML lacing sample size out of range.");
                    }
                    int i37 = 0;
                    int i38 = 0;
                    int i39 = 4;
                    while (true) {
                        i16 = dVar.N - 1;
                        if (i37 >= i16) {
                            break;
                        }
                        dVar.O[i37] = 0;
                        while (true) {
                            i17 = i39 + 1;
                            dVar.k(oVar, i17);
                            int i40 = tVar2.f8129a[i39] & 255;
                            int[] iArr4 = dVar.O;
                            i18 = iArr4[i37] + i40;
                            iArr4[i37] = i18;
                            if (i40 != 255) {
                                break;
                            } else {
                                i39 = i17;
                            }
                        }
                        i38 += i18;
                        i37++;
                        i39 = i17;
                    }
                    dVar.O[i16] = ((i11 - dVar.Q) - i39) - i38;
                }
            }
            i12 = 1;
            i13 = 0;
            byte[] bArr6 = tVar2.f8129a;
            dVar.K = dVar.n((bArr6[i12] & 255) | (bArr6[i13] << 8)) + dVar.E;
            dVar.R = (cVar3.f2801e == 2 || (i10 == 163 && (tVar2.f8129a[2] & 128) == 128)) ? i12 : i13;
            dVar.J = 2;
            dVar.M = i13;
        } else {
            i12 = 1;
        }
        if (i10 == 163) {
            while (true) {
                int i41 = dVar.M;
                if (i41 >= dVar.N) {
                    dVar.J = 0;
                    return;
                } else {
                    dVar.i(cVar3, ((dVar.M * cVar3.f2802f) / 1000) + dVar.K, dVar.R, dVar.o(oVar, cVar3, dVar.O[i41], false), 0);
                    dVar.M++;
                }
            }
        } else {
            while (true) {
                int i42 = dVar.M;
                if (i42 >= dVar.N) {
                    return;
                }
                int[] iArr5 = dVar.O;
                boolean z10 = i12;
                iArr5[i42] = dVar.o(oVar, cVar3, iArr5[i42], z10);
                dVar.M += z10 ? 1 : 0;
            }
        }
    }

    public g7.o o() {
        g7.o oVar = (g7.o) this.f74p;
        if (oVar.f5266o == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (!Double.isNaN(oVar.f5269r) && oVar.f5269r < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(oVar.f5270s)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(oVar.f5271t) || oVar.f5271t < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
        return oVar;
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        CatchUpActivity catchUpActivity = (CatchUpActivity) this.f74p;
        catchUpActivity.X.setVisibility(8);
        Toast.makeText(catchUpActivity, catchUpActivity.f1582f0.getNo_epg_avaliable(), 0).show();
        catchUpActivity.M = new ArrayList();
        catchUpActivity.U.setFocusable(true);
        catchUpActivity.U.requestFocus();
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        CatchUpActivity catchUpActivity = (CatchUpActivity) this.f74p;
        if (response.body() == null || ((CatchUpEpgResponse) response.body()).getEpg_listings().isEmpty()) {
            catchUpActivity.M = new ArrayList();
            catchUpActivity.X.setVisibility(8);
            Toast.makeText(catchUpActivity, catchUpActivity.f1582f0.getNo_epg_avaliable(), 0).show();
            return;
        }
        List<CatchUpEpg> epg_listings = ((CatchUpEpgResponse) response.body()).getEpg_listings();
        catchUpActivity.M = epg_listings;
        SimpleDateFormat simpleDateFormat = catchUpActivity.f1580d0;
        SimpleDateFormat simpleDateFormat2 = catchUpActivity.f1581e0;
        catchUpActivity.N = new ArrayList();
        ArrayList arrayList = new ArrayList();
        String str = null;
        int i10 = 0;
        String str2 = null;
        for (CatchUpEpg catchUpEpg : epg_listings) {
            i10++;
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(catchUpEpg.getStart_timestamp() * 1000);
            String format = simpleDateFormat.format(calendar.getTime());
            if (str == null) {
                str2 = simpleDateFormat2.format(calendar.getTime());
                arrayList = new ArrayList();
                str = format;
            }
            if (!format.equals(str)) {
                CatchupModel catchupModel = new CatchupModel();
                catchupModel.setName(str);
                catchupModel.setDayofweek(str2);
                catchupModel.setEpgEvents(arrayList);
                catchUpActivity.N.add(catchupModel);
                str2 = simpleDateFormat2.format(calendar.getTime());
                arrayList = new ArrayList();
                str = format;
            }
            arrayList.add(catchUpEpg);
            if (i10 == epg_listings.size()) {
                CatchupModel catchupModel2 = new CatchupModel();
                catchupModel2.setName(str);
                String format2 = simpleDateFormat2.format(calendar.getTime());
                catchupModel2.setDayofweek(format2);
                catchupModel2.setEpgEvents(arrayList);
                catchUpActivity.N.add(catchupModel2);
                str2 = format2;
            }
        }
        catchUpActivity.X.setVisibility(8);
        if (catchUpActivity.N.size() <= 0) {
            Toast.makeText(catchUpActivity, catchUpActivity.f1582f0.getNo_epg_avaliable(), 0).show();
            return;
        }
        ArrayList arrayList2 = catchUpActivity.N;
        int i11 = 0;
        while (true) {
            if (i11 >= arrayList2.size()) {
                i11 = 0;
                break;
            } else if (simpleDateFormat.format(new Date()).equalsIgnoreCase(((CatchupModel) arrayList2.get(i11)).getName())) {
                break;
            } else {
                i11++;
            }
        }
        catchUpActivity.f1577a0 = i11;
        d5.e eVar = catchUpActivity.R;
        eVar.f4087f = catchUpActivity.N;
        eVar.f4086e = i11;
        eVar.d();
        catchUpActivity.Q = ((CatchupModel) catchUpActivity.N.get(catchUpActivity.f1577a0)).getEpgEvents();
        int i12 = -1;
        for (int i13 = 0; i13 < catchUpActivity.Q.size(); i13++) {
            if (((CatchUpEpg) catchUpActivity.Q.get(i13)).getNow_playing() == 1) {
                i12 = i13;
            }
        }
        if (i12 == -1) {
            catchUpActivity.f1578b0 = 0;
        } else {
            catchUpActivity.f1578b0 = i12;
        }
        d5.e eVar2 = catchUpActivity.W;
        eVar2.f4087f = catchUpActivity.Q;
        eVar2.d();
        catchUpActivity.T.setSelectedPosition(catchUpActivity.f1578b0);
        d5.e eVar3 = catchUpActivity.W;
        int i14 = catchUpActivity.f1578b0;
        eVar3.getClass();
        eVar3.e(i14);
        d5.e eVar4 = catchUpActivity.W;
        eVar4.f4086e = i12;
        eVar4.e(i12);
        catchUpActivity.S.requestFocus();
        catchUpActivity.S.setSelectedPosition(catchUpActivity.f1577a0);
    }

    public int p(int i10, boolean z10, Object[] objArr, boolean z11) {
        int i11;
        View s10;
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        View d6 = pVar.f1063y.d(i10 - pVar.f1059u);
        androidx.leanback.widget.m mVar = (androidx.leanback.widget.m) d6.getLayoutParams();
        pVar.f1055q.I(d6);
        mVar.getClass();
        if (!mVar.f2381a.i()) {
            if (z11) {
                if (z10) {
                    pVar.b(d6, -1, true);
                } else {
                    pVar.b(d6, 0, true);
                }
            } else if (z10) {
                pVar.b(d6, -1, false);
            } else {
                pVar.b(d6, 0, false);
            }
            int i12 = pVar.F;
            if (i12 != -1) {
                d6.setVisibility(i12);
            }
            androidx.leanback.widget.n nVar = pVar.D;
            if (nVar != null) {
                androidx.leanback.widget.p pVar2 = nVar.f1046u;
                if (!nVar.f1044s && (i11 = nVar.f1045t) != 0) {
                    int i13 = i11 > 0 ? pVar2.B + pVar2.Q : pVar2.B - pVar2.Q;
                    View view = null;
                    while (nVar.f1045t != 0 && (s10 = nVar.f2451b.B.s(i13)) != null) {
                        if (s10.getVisibility() == 0 && (!pVar2.R() || s10.hasFocusable())) {
                            pVar2.B = i13;
                            int i14 = nVar.f1045t;
                            if (i14 > 0) {
                                nVar.f1045t = i14 - 1;
                            } else {
                                nVar.f1045t = i14 + 1;
                            }
                            view = s10;
                        }
                        i13 = nVar.f1045t > 0 ? i13 + pVar2.Q : i13 - pVar2.Q;
                    }
                    if (view != null && pVar2.R()) {
                        pVar2.f1064z |= 32;
                        view.requestFocus();
                        pVar2.f1064z &= -33;
                    }
                }
            }
            if (d6.findFocus() != null) {
                ((androidx.leanback.widget.m) d6.getLayoutParams()).getClass();
            }
            int i15 = pVar.f1064z;
            if ((i15 & 3) != 1) {
                if (i10 == pVar.B && pVar.D == null) {
                    pVar.T0();
                }
            } else if ((i15 & 4) == 0) {
                int i16 = i15 & 16;
                if (i16 == 0 && i10 == pVar.B) {
                    pVar.T0();
                } else if (i16 != 0 && i10 >= pVar.B && d6.hasFocusable()) {
                    pVar.B = i10;
                    pVar.f1064z &= -17;
                    pVar.T0();
                }
            }
            pVar.h1(d6);
        }
        objArr[0] = d6;
        return pVar.f1056r == 0 ? androidx.leanback.widget.p.X0(d6) : androidx.leanback.widget.p.W0(d6);
    }

    public int q() {
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        return pVar.f1058t.b() + pVar.f1059u;
    }

    public int r(int i10) {
        androidx.leanback.widget.p pVar = (androidx.leanback.widget.p) this.f74p;
        View s10 = pVar.s(i10 - pVar.f1059u);
        return (pVar.f1064z & 262144) != 0 ? pVar.f1057s.b(s10) : pVar.f1057s.e(s10);
    }

    public io.realm.n0 s(String str, List list) {
        RealmQuery V = ((io.realm.u) this.f74p).V(EPGChannel.class);
        String[] strArr = (String[]) list.toArray(new String[0]);
        TableQuery tableQuery = V.f6622b;
        io.realm.u uVar = V.f6621a;
        uVar.c();
        if (strArr == null || strArr.length == 0) {
            uVar.c();
            tableQuery.h(null, "FALSEPREDICATE", new long[0]);
            tableQuery.f6724r = false;
        } else {
            int length = strArr.length;
            io.realm.w[] wVarArr = new io.realm.w[length];
            for (int i10 = 0; i10 < strArr.length; i10++) {
                String str2 = strArr[i10];
                if (str2 != null) {
                    wVarArr[i10] = io.realm.w.a(str2);
                } else {
                    wVarArr[i10] = null;
                }
            }
            OsKeyPathMapping osKeyPathMapping = uVar.f6840y.f6777e;
            tableQuery.getClass();
            String replace = "name".replace(" ", "\\ ");
            tableQuery.a();
            boolean z10 = true;
            int i11 = 0;
            while (i11 < length) {
                io.realm.w wVar = wVarArr[i11];
                if (!z10) {
                    tableQuery.g();
                }
                if (wVar == null) {
                    tableQuery.h(osKeyPathMapping, TableQuery.d(replace) + " = NULL", new long[0]);
                    tableQuery.f6724r = false;
                } else {
                    tableQuery.c(osKeyPathMapping, replace, wVar);
                }
                i11++;
                z10 = false;
            }
            tableQuery.b();
            tableQuery.f6724r = false;
        }
        V.a("name", 2, str.toLowerCase());
        return V.d();
    }

    @Override // a6.m
    public long skip(long j10) {
        InputStream inputStream = (InputStream) this.f74p;
        if (j10 < 0) {
            return 0L;
        }
        long j11 = j10;
        while (j11 > 0) {
            long skip = inputStream.skip(j11);
            if (skip <= 0) {
                if (inputStream.read() == -1) {
                    break;
                }
                skip = 1;
            }
            j11 -= skip;
        }
        return j10 - j11;
    }

    public ArrayList t() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(EPGChannel.class);
        V.b("is_favorite");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            arrayList.add(((EPGChannel) oVar.next()).getName());
        }
        return arrayList;
    }

    public ArrayList u() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(MovieModel.class);
        V.b("is_favorite");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            arrayList.add(((MovieModel) oVar.next()).getName());
        }
        return arrayList;
    }

    public ArrayList v() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(SeriesModel.class);
        V.b("is_favorite");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            arrayList.add(((SeriesModel) oVar.next()).getName());
        }
        return arrayList;
    }

    public io.realm.n0 w(CategoryModel categoryModel, String str, boolean z10, int i10) {
        io.realm.u uVar = (io.realm.u) this.f74p;
        String str2 = z10 ? "category_name" : "category_id";
        String name = z10 ? categoryModel.getName().contains("!@#%") ? categoryModel.getName().split("!@#%")[1] : categoryModel.getName() : categoryModel.getId();
        if (categoryModel.getId().equalsIgnoreCase("fav_id")) {
            RealmQuery V = uVar.V(EPGChannel.class);
            if (i10 == 1) {
                android.support.v4.media.d.w(V, "is_favorite", str, "name", 2);
                V.h(1, "name");
                return V.d();
            }
            if (i10 != 2) {
                V.b("is_favorite");
                V.a("name", 2, str.toLowerCase());
                return V.d();
            }
            android.support.v4.media.d.w(V, "is_favorite", str, "name", 2);
            V.h(2, "name");
            return V.d();
        }
        if (categoryModel.getId().equalsIgnoreCase("resume_id")) {
            RealmQuery V2 = uVar.V(EPGChannel.class);
            android.support.v4.media.d.w(V2, "is_recent", str, "name", 2);
            V2.h(2, "recent_pos");
            return V2.d();
        }
        if (categoryModel.getId().equalsIgnoreCase("all_id")) {
            RealmQuery V3 = uVar.V(EPGChannel.class);
            V3.a("name", 2, str.toLowerCase());
            if (i10 == 1) {
                V3.h(1, "name");
                return V3.d();
            }
            if (i10 != 2) {
                return V3.d();
            }
            V3.h(2, "name");
            return V3.d();
        }
        if (!categoryModel.getId().equalsIgnoreCase("lock_id")) {
            RealmQuery V4 = uVar.V(EPGChannel.class);
            V4.c(str2, name);
            V4.a("name", 2, str.toLowerCase());
            if (i10 == 1) {
                V4.h(1, "name");
                return V4.d();
            }
            if (i10 != 2) {
                return V4.d();
            }
            V4.h(2, "name");
            return V4.d();
        }
        RealmQuery V5 = uVar.V(EPGChannel.class);
        if (i10 == 1) {
            android.support.v4.media.d.w(V5, "is_locked", str, "name", 2);
            V5.h(1, "name");
            return V5.d();
        }
        if (i10 != 2) {
            V5.b("is_locked");
            V5.a("name", 2, str.toLowerCase());
            return V5.d();
        }
        android.support.v4.media.d.w(V5, "is_locked", str, "name", 2);
        V5.h(2, "name");
        return V5.d();
    }

    public ArrayList x() {
        ArrayList arrayList = new ArrayList();
        RealmQuery V = ((io.realm.u) this.f74p).V(EPGChannel.class);
        V.b("is_locked");
        io.realm.o oVar = new io.realm.o(V.d());
        while (oVar.hasNext()) {
            arrayList.add(((EPGChannel) oVar.next()).getName());
        }
        return arrayList;
    }

    public MovieModel y(String str) {
        return (MovieModel) android.support.v4.media.d.j((io.realm.u) this.f74p, MovieModel.class, "stream_id", str);
    }

    public MovieModel z(String str) {
        return (MovieModel) android.support.v4.media.d.j((io.realm.u) this.f74p, MovieModel.class, "name", str);
    }

    public /* synthetic */ n(int i10, boolean z10) {
        this.f73o = i10;
    }

    public n(MediaInfo mediaInfo) {
        this.f73o = 27;
        g7.o oVar = new g7.o(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        if (mediaInfo != null) {
            this.f74p = oVar;
            return;
        }
        throw new IllegalArgumentException("media cannot be null.");
    }

    public n(JSONObject jSONObject) {
        this.f73o = 27;
        this.f74p = new g7.o(jSONObject);
    }

    public n(com.bumptech.glide.h hVar) {
        this.f73o = 16;
        this.f74p = Collections.unmodifiableMap(new HashMap(hVar.f3017a));
    }

    public n(UUID uuid, int i10, byte[] bArr, UUID[] uuidArr) {
        this.f73o = 23;
        this.f74p = uuid;
    }

    public n(int i10) {
        this.f73o = i10;
        switch (i10) {
            case 20:
                this.f74p = new d9.f(21);
                break;
            case 26:
                this.f74p = new CopyOnWriteArrayList();
                break;
            case 29:
                this.f74p = null;
                break;
            default:
                this.f74p = new Bundle();
                break;
        }
    }

    public n(MediaMetadataCompat mediaMetadataCompat) {
        this.f73o = 1;
        Bundle bundle = new Bundle(mediaMetadataCompat.f190o);
        this.f74p = bundle;
        android.support.v4.media.session.a0.G(bundle);
    }

    @Override // h5.t
    public void e() {
    }
}
