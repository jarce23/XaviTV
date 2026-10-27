package x4;

import a6.h0;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.Choreographer;
import android.widget.Toast;
import androidx.emoji2.text.a0;
import androidx.emoji2.text.d0;
import androidx.emoji2.text.z;
import androidx.lifecycle.y;
import androidx.work.impl.WorkDatabase_Impl;
import app.shamel.tv.activities.MovieActivity;
import app.shamel.tv.activities.MovieInfoActivity;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.models.LoginModel;
import app.shamel.tv.models.LoginResponse;
import app.shamel.tv.models.MovieModel;
import h5.g0;
import j9.d1;
import j9.j1;
import j9.l1;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import o4.s;
import o4.u;
import o4.v;
import o9.w0;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class r implements androidx.emoji2.text.r, g0, Callback, k9.f, o1.g, v, i8.a, m0.m {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13606o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13607p;

    /* renamed from: q, reason: collision with root package name */
    public Object f13608q;

    public /* synthetic */ r(f.j jVar, Serializable serializable, int i10) {
        this.f13606o = i10;
        this.f13608q = jVar;
        this.f13607p = serializable;
    }

    public static h0 h(ImageDecoder.Source source, int i10, int i11, r5.h hVar) {
        Drawable decodeDrawable;
        decodeDrawable = ImageDecoder.decodeDrawable(source, new z5.b(i10, i11, hVar));
        if (a6.c.x(decodeDrawable)) {
            return new h0(2, a6.c.j(decodeDrawable));
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + decodeDrawable);
    }

    public static String o(r rVar) {
        Collection<String> collection = (Collection) rVar.f13608q;
        StringBuilder sb2 = new StringBuilder("com.google.android.gms.cast.CATEGORY_CAST");
        String str = (String) rVar.f13607p;
        if (str != null) {
            String upperCase = str.toUpperCase(Locale.ROOT);
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException("Invalid application ID: ".concat(str));
            }
            sb2.append("/");
            sb2.append(upperCase);
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str == null) {
                sb2.append("/");
            }
            sb2.append("/");
            boolean z10 = true;
            for (String str2 : collection) {
                l7.a.b(str2);
                if (!z10) {
                    sb2.append(",");
                }
                if (!l7.a.f8269a.matcher(str2).matches()) {
                    StringBuilder sb3 = new StringBuilder(str2.length());
                    for (int i10 = 0; i10 < str2.length(); i10++) {
                        char charAt = str2.charAt(i10);
                        if ((charAt < 'A' || charAt > 'Z') && ((charAt < 'a' || charAt > 'z') && !((charAt >= '0' && charAt <= '9') || charAt == '_' || charAt == '-' || charAt == '.' || charAt == ':'))) {
                            sb3.append(String.format("%%%04x", Integer.valueOf(charAt)));
                        } else {
                            sb3.append(charAt);
                        }
                    }
                    str2 = sb3.toString();
                }
                sb2.append(str2);
                z10 = false;
            }
        }
        if (str == null && collection == null) {
            sb2.append("/");
        }
        if (collection == null) {
            sb2.append("/");
        }
        sb2.append("//ALLOW_IPV6");
        return sb2.toString();
    }

    @Override // androidx.emoji2.text.r
    public Object a() {
        return (d0) this.f13607p;
    }

    @Override // androidx.emoji2.text.r
    public boolean b(CharSequence charSequence, int i10, int i11, z zVar) {
        if ((zVar.f620c & 4) > 0) {
            return true;
        }
        if (((d0) this.f13607p) == null) {
            this.f13607p = new d0(charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence));
        }
        ((d9.f) this.f13608q).getClass();
        ((d0) this.f13607p).setSpan(new a0(zVar), i10, i11, 33);
        return true;
    }

    @Override // k9.f
    public Object c() {
        switch (this.f13606o) {
            case 7:
                return new j9.p(((androidx.emoji2.text.o) ((h5.i) this.f13607p).f5610p).f591o, (j1) ((k9.e) this.f13608q).c());
            default:
                int i10 = 12;
                return new l1((j9.p) ((k9.e) this.f13607p).c(), new k9.e(new h5.i(i10, (d1) this.f13608q)));
        }
    }

    @Override // o1.g
    public o1.h d() {
        return new o1.m((Context) this.f13607p, ((o1.g) this.f13608q).d());
    }

    public void e(String str, Object obj) {
        int length = str.length();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(length + 1 + valueOf.length());
        sb2.append(str);
        sb2.append("=");
        sb2.append(valueOf);
        ((ArrayList) this.f13607p).add(sb2.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    @Override // m0.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public m0.q1 f(android.view.View r20, m0.q1 r21) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            java.lang.Object r3 = r0.f13607p
            ea.a r3 = (ea.a) r3
            java.lang.Object r4 = r0.f13608q
            i2.j r4 = (i2.j) r4
            int r5 = r4.f6217a
            int r6 = r4.f6218b
            int r4 = r4.f6219c
            m0.n1 r7 = r2.f8706a
            r8 = 519(0x207, float:7.27E-43)
            e0.c r8 = r7.f(r8)
            r9 = 32
            e0.c r7 = r7.f(r9)
            java.lang.Object r9 = r3.f4681c
            com.google.android.material.bottomsheet.BottomSheetBehavior r9 = (com.google.android.material.bottomsheet.BottomSheetBehavior) r9
            int r10 = r8.f4386b
            int r11 = r8.f4387c
            int r12 = r8.f4385a
            r9.f3707w = r10
            int r10 = r1.getLayoutDirection()
            r14 = 1
            if (r10 != r14) goto L37
            r10 = r14
            goto L38
        L37:
            r10 = 0
        L38:
            int r15 = r1.getPaddingBottom()
            int r16 = r1.getPaddingLeft()
            int r17 = r1.getPaddingRight()
            boolean r13 = r9.f3699o
            if (r13 == 0) goto L4f
            int r15 = r2.a()
            r9.f3706v = r15
            int r15 = r15 + r4
        L4f:
            boolean r4 = r9.f3700p
            if (r4 == 0) goto L5a
            if (r10 == 0) goto L57
            r4 = r6
            goto L58
        L57:
            r4 = r5
        L58:
            int r16 = r4 + r12
        L5a:
            r4 = r16
            boolean r14 = r9.f3701q
            if (r14 == 0) goto L66
            if (r10 == 0) goto L63
            goto L64
        L63:
            r5 = r6
        L64:
            int r17 = r5 + r11
        L66:
            r5 = r17
            android.view.ViewGroup$LayoutParams r6 = r1.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            boolean r10 = r9.f3703s
            if (r10 == 0) goto L7b
            int r10 = r6.leftMargin
            if (r10 == r12) goto L7b
            r6.leftMargin = r12
            r18 = 1
            goto L7d
        L7b:
            r18 = 0
        L7d:
            boolean r10 = r9.f3704t
            if (r10 == 0) goto L89
            int r10 = r6.rightMargin
            if (r10 == r11) goto L89
            r6.rightMargin = r11
            r18 = 1
        L89:
            boolean r10 = r9.f3705u
            if (r10 == 0) goto L97
            int r10 = r6.topMargin
            int r8 = r8.f4386b
            if (r10 == r8) goto L97
            r6.topMargin = r8
            r14 = 1
            goto L99
        L97:
            r14 = r18
        L99:
            if (r14 == 0) goto L9e
            r1.setLayoutParams(r6)
        L9e:
            int r6 = r1.getPaddingTop()
            r1.setPadding(r4, r6, r5, r15)
            boolean r1 = r3.f4680b
            if (r1 == 0) goto Lad
            int r3 = r7.f4388d
            r9.f3697m = r3
        Lad:
            if (r13 != 0) goto Lb3
            if (r1 == 0) goto Lb2
            goto Lb3
        Lb2:
            return r2
        Lb3:
            r9.I()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.r.f(android.view.View, m0.q1):m0.q1");
    }

    public void g() {
        int[] iArr = (int[]) this.f13607p;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f13608q = null;
    }

    public void i(int i10) {
        int[] iArr = (int[]) this.f13607p;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i10, 10) + 1];
            this.f13607p = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i10 >= iArr.length) {
            int length = iArr.length;
            while (length <= i10) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f13607p = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f13607p;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public ArrayList j(String str) {
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) this.f13607p;
        c4.m a10 = c4.m.a(1, "SELECT DISTINCT tag FROM worktag WHERE work_spec_id=?");
        if (str == null) {
            a10.o(1);
        } else {
            a10.j(1, str);
        }
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            ArrayList arrayList = new ArrayList(m10.getCount());
            while (m10.moveToNext()) {
                arrayList.add(m10.isNull(0) ? null : m10.getString(0));
            }
            return arrayList;
        } finally {
            m10.close();
            a10.s();
        }
    }

    public void k(n4.a aVar) {
        boolean z10;
        y yVar = (y) this.f13607p;
        synchronized (yVar.f1171a) {
            z10 = yVar.f1176f == y.f1170k;
            yVar.f1176f = aVar;
        }
        if (z10) {
            n.a.w().x(yVar.f1179j);
        }
        if (aVar instanceof u) {
            ((z4.j) this.f13608q).i((u) aVar);
        } else if (aVar instanceof s) {
            ((z4.j) this.f13608q).j(((s) aVar).f9517t);
        }
    }

    public void l(int i10, int i11) {
        int[] iArr = (int[]) this.f13607p;
        if (iArr == null || i10 >= iArr.length) {
            return;
        }
        int i12 = i10 + i11;
        i(i12);
        int[] iArr2 = (int[]) this.f13607p;
        System.arraycopy(iArr2, i10, iArr2, i12, (iArr2.length - i10) - i11);
        Arrays.fill((int[]) this.f13607p, i10, i12, -1);
        ArrayList arrayList = (ArrayList) this.f13608q;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b4.l1 l1Var = (b4.l1) ((ArrayList) this.f13608q).get(size);
            int i13 = l1Var.f2303o;
            if (i13 >= i10) {
                l1Var.f2303o = i13 + i11;
            }
        }
    }

    public void m(int i10, int i11) {
        int[] iArr = (int[]) this.f13607p;
        if (iArr == null || i10 >= iArr.length) {
            return;
        }
        int i12 = i10 + i11;
        i(i12);
        int[] iArr2 = (int[]) this.f13607p;
        System.arraycopy(iArr2, i12, iArr2, i10, (iArr2.length - i10) - i11);
        int[] iArr3 = (int[]) this.f13607p;
        Arrays.fill(iArr3, iArr3.length - i11, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f13608q;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            b4.l1 l1Var = (b4.l1) ((ArrayList) this.f13608q).get(size);
            int i13 = l1Var.f2303o;
            if (i13 >= i10) {
                if (i13 < i12) {
                    ((ArrayList) this.f13608q).remove(size);
                } else {
                    l1Var.f2303o = i13 - i11;
                }
            }
        }
    }

    public l1.a n() {
        File file = (File) this.f13608q;
        File file2 = (File) this.f13607p;
        if (file2.exists()) {
            if (file.exists()) {
                file2.delete();
            } else if (!file2.renameTo(file)) {
                l1.b.q("AtomicFile", "Couldn't rename file " + file2 + " to backup file " + file);
            }
        }
        try {
            return new l1.a(file2);
        } catch (FileNotFoundException e7) {
            File parentFile = file2.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + file2, e7);
            }
            try {
                return new l1.a(file2);
            } catch (FileNotFoundException e8) {
                throw new IOException("Couldn't create " + file2, e8);
            }
        }
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        String str = (String) this.f13607p;
        e5.k kVar = (e5.k) this.f13608q;
        if (kVar.Y) {
            return;
        }
        int i10 = kVar.Z;
        if (i10 < 2) {
            kVar.Z = i10 + 1;
            kVar.v(str);
        } else {
            kVar.T.P(true);
            kVar.N(str, kVar.X);
        }
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        e5.k kVar = (e5.k) this.f13608q;
        if (response.body() == null || ((LoginResponse) response.body()).getUser_info() == null || ((LoginResponse) response.body()).getUser_info().getStatus() == null) {
            kVar.T.P(true);
            kVar.N((String) this.f13607p, kVar.X);
            return;
        }
        kVar.Z = 0;
        if (!((LoginResponse) response.body()).getUser_info().getStatus().equalsIgnoreCase("Active")) {
            Toast.makeText(kVar.getApplicationContext(), kVar.X.getAccount_expired(), 1).show();
            kVar.w(false);
            return;
        }
        app.shamel.tv.helper.r rVar = kVar.T;
        LoginModel user_info = ((LoginResponse) response.body()).getUser_info();
        SharedPreferences.Editor edit = rVar.f2098b.edit();
        edit.putString("login_models", rVar.f2097a.toJson(user_info));
        edit.apply();
        app.shamel.tv.helper.r rVar2 = kVar.T;
        String str = kVar.V;
        SharedPreferences.Editor edit2 = rVar2.f2098b.edit();
        edit2.putString("user_name", str);
        edit2.apply();
        app.shamel.tv.helper.r rVar3 = kVar.T;
        String str2 = kVar.S;
        SharedPreferences.Editor edit3 = rVar3.f2098b.edit();
        edit3.putString("password", str2);
        edit3.apply();
        long timestamp_now = ((LoginResponse) response.body()).getServerModel().getTimestamp_now();
        try {
            Date parse = e5.l.g.parse(((LoginResponse) response.body()).getServerModel().getTime_now());
            if (parse != null) {
                LTVApp.f2083r = (timestamp_now * 1000) - parse.getTime();
            } else {
                LTVApp.f2083r = 0L;
            }
        } catch (ParseException e7) {
            Log.e("Constants", "setServerTimeOffset", e7);
            LTVApp.f2083r = 0L;
        }
        if (kVar.Y) {
            return;
        }
        e5.k.u(kVar);
    }

    @Override // h5.g0
    public void t() {
        MovieActivity movieActivity = (MovieActivity) this.f13608q;
        Toast.makeText(movieActivity, movieActivity.f1727e0.getPut_pin_code(), 0).show();
    }

    public String toString() {
        switch (this.f13606o) {
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                StringBuilder sb2 = new StringBuilder(100);
                sb2.append(this.f13608q.getClass().getSimpleName());
                sb2.append('{');
                ArrayList arrayList = (ArrayList) this.f13607p;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    sb2.append((String) arrayList.get(i10));
                    if (i10 < size - 1) {
                        sb2.append(", ");
                    }
                }
                sb2.append('}');
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    @Override // h5.g0
    public void u() {
        MovieActivity movieActivity = (MovieActivity) this.f13608q;
        Toast.makeText(movieActivity, movieActivity.f1727e0.getPin_incorrect(), 0).show();
    }

    @Override // h5.g0
    public void y() {
        MovieActivity movieActivity = (MovieActivity) this.f13608q;
        Intent intent = new Intent(movieActivity, (Class<?>) MovieInfoActivity.class);
        MovieModel movieModel = (MovieModel) this.f13607p;
        intent.putExtra("name", movieModel.getName());
        intent.putExtra("stream_id", movieModel.getStream_id());
        if (movieActivity.S.g()) {
            intent.putExtra("category_name", movieModel.getCategory_name());
        } else {
            intent.putExtra("category_name", MovieActivity.u(movieModel.getCategory_id()));
        }
        movieActivity.startActivity(intent);
    }

    @Override // i8.a
    public void z(i8.i iVar) {
        ((Map) ((e) this.f13608q).f13543q).remove((i8.d) this.f13607p);
    }

    public /* synthetic */ r(Object obj, int i10, Object obj2) {
        this.f13606o = i10;
        this.f13607p = obj;
        this.f13608q = obj2;
    }

    public /* synthetic */ r(Object obj) {
        this.f13606o = 14;
        this.f13608q = obj;
        this.f13607p = new ArrayList();
    }

    public r(e eVar, i8.d dVar) {
        this.f13606o = 13;
        this.f13607p = dVar;
        Objects.requireNonNull(eVar);
        this.f13608q = eVar;
    }

    public r(WorkDatabase_Impl workDatabase_Impl) {
        this.f13606o = 0;
        this.f13607p = workDatabase_Impl;
        this.f13608q = new b(workDatabase_Impl, 6);
        new h(workDatabase_Impl, 20);
    }

    public r(int i10) {
        this.f13606o = i10;
        switch (i10) {
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                this.f13607p = new y();
                this.f13608q = new z4.j();
                k(v.f9519m);
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                this.f13607p = Choreographer.getInstance();
                this.f13608q = Looper.myLooper();
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
                this.f13607p = byteArrayOutputStream;
                this.f13608q = new DataOutputStream(byteArrayOutputStream);
                break;
        }
    }

    public r(File file) {
        this.f13606o = 9;
        this.f13607p = file;
        this.f13608q = new File(file.getPath() + ".bak");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public r(Context context) {
        this(context, new f3.e(1));
        this.f13606o = 11;
    }

    public r(Context context, o1.u uVar) {
        this.f13606o = 11;
        this.f13607p = context.getApplicationContext();
        uVar.getClass();
        this.f13608q = uVar;
    }

    public r(w0 w0Var, int[] iArr) {
        this.f13606o = 10;
        this.f13607p = o9.g0.n(w0Var);
        this.f13608q = iArr;
    }
}
