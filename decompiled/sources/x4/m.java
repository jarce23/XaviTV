package x4;

import a6.c0;
import a6.m0;
import android.app.Notification;
import android.app.RemoteInput;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.text.Editable;
import android.text.Selection;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import androidx.core.graphics.drawable.IconCompat;
import androidx.emoji2.text.a0;
import androidx.emoji2.text.s;
import androidx.emoji2.text.w;
import androidx.emoji2.text.z;
import androidx.fragment.app.v0;
import androidx.lifecycle.k0;
import androidx.lifecycle.t;
import androidx.work.impl.WorkDatabase_Impl;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.google.android.gms.internal.cast.u;
import com.google.android.gms.internal.cast.u5;
import g7.e0;
import io.realm.internal.OsResults;
import j9.b0;
import j9.d1;
import j9.g1;
import j9.i0;
import j9.u1;
import j9.v;
import j9.v1;
import j9.w1;
import j9.x0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import k2.g0;
import l7.x;
import m.d3;
import okhttp3.internal.url._UrlKt;
import t5.y;
import u1.d0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements c0, f6.b, p7.h, v, k9.f, o0.g {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f13563o;

    /* renamed from: p, reason: collision with root package name */
    public Object f13564p;

    /* renamed from: q, reason: collision with root package name */
    public Object f13565q;

    /* renamed from: r, reason: collision with root package name */
    public Object f13566r;

    public /* synthetic */ m(int i10) {
        this.f13563o = i10;
    }

    public static void D(String str, Object... objArr) {
        String.format(Locale.US, str, objArr);
    }

    private final void t(Object obj, Object obj2) {
        e0 e0Var = (e0) this.f13564p;
        String str = (String) this.f13565q;
        String str2 = (String) this.f13566r;
        x xVar = (x) obj;
        i8.d dVar = (i8.d) obj2;
        r7.r.g("Not connected to device", e0Var.F == 2);
        l7.g gVar = (l7.g) xVar.j();
        Parcel w02 = gVar.w0();
        w02.writeString(str);
        w02.writeString(str2);
        int i10 = u.f3485a;
        w02.writeInt(0);
        gVar.z0(w02, 14);
        synchronized (e0Var.f5213r) {
            try {
                if (e0Var.f5210o != null) {
                    e0Var.h(2477);
                }
                e0Var.f5210o = dVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean w(Editable editable, KeyEvent keyEvent, boolean z10) {
        a0[] a0VarArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (a0VarArr = (a0[]) editable.getSpans(selectionStart, selectionEnd, a0.class)) != null && a0VarArr.length > 0) {
                for (a0 a0Var : a0VarArr) {
                    int spanStart = editable.getSpanStart(a0Var);
                    int spanEnd = editable.getSpanEnd(a0Var);
                    if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean A(CharSequence charSequence, int i10, int i11, z zVar) {
        if ((zVar.f620c & 3) == 0) {
            androidx.emoji2.text.h hVar = (androidx.emoji2.text.h) this.f13566r;
            u0.a b2 = zVar.b();
            int a10 = b2.a(8);
            if (a10 != 0) {
                ((ByteBuffer) b2.f8748r).getShort(a10 + b2.f8745o);
            }
            androidx.emoji2.text.d dVar = (androidx.emoji2.text.d) hVar;
            dVar.getClass();
            ThreadLocal threadLocal = androidx.emoji2.text.d.f561b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb2 = (StringBuilder) threadLocal.get();
            sb2.setLength(0);
            while (i10 < i11) {
                sb2.append(charSequence.charAt(i10));
                i10++;
            }
            TextPaint textPaint = dVar.f562a;
            String sb3 = sb2.toString();
            int i12 = e0.d.f4389a;
            boolean hasGlyph = textPaint.hasGlyph(sb3);
            int i13 = zVar.f620c & 4;
            zVar.f620c = hasGlyph ? i13 | 2 : i13 | 1;
        }
        return (zVar.f620c & 3) == 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0056, code lost:
    
        if (r1.f7753r != r11) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0080, code lost:
    
        if (r1.f7753r != r11) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B(o1.h r8, android.net.Uri r9, java.util.Map r10, long r11, long r13, c2.u0 r15) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.m.B(o1.h, android.net.Uri, java.util.Map, long, long, c2.u0):void");
    }

    public void C(Context context, String str, String str2) {
        e eVar;
        String[] strArr;
        InputStream inputStream;
        InputStream inputStream2;
        FileOutputStream fileOutputStream;
        v1 v1Var = (v1) this.f13565q;
        HashSet hashSet = (HashSet) this.f13564p;
        if (hashSet.contains(str)) {
            D("%s already loaded previously!", str);
            return;
        }
        try {
            v1Var.getClass();
            System.loadLibrary(str);
            hashSet.add(str);
            D("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e7) {
            D("Loading the library normally failed: %s", Log.getStackTraceString(e7));
            D("%s (%s) was not loaded normally, re-linking...", str, str2);
            File z10 = z(context, str, str2);
            if (!z10.exists()) {
                File dir = context.getDir("lib", 0);
                File z11 = z(context, str, str2);
                v1Var.getClass();
                File[] listFiles = dir.listFiles(new x0(v1.y(str), 1));
                if (listFiles != null) {
                    for (File file : listFiles) {
                        if (!file.getAbsolutePath().equals(z11.getAbsolutePath())) {
                            file.delete();
                        }
                    }
                }
                w1 w1Var = (w1) this.f13566r;
                String[] strArr2 = Build.SUPPORTED_ABIS;
                if (strArr2.length <= 0) {
                    String str3 = Build.CPU_ABI2;
                    strArr2 = (str3 == null || str3.length() == 0) ? new String[]{Build.CPU_ABI} : new String[]{Build.CPU_ABI, str3};
                }
                String y8 = v1.y(str);
                w1Var.getClass();
                try {
                    e G = w1.G(context, strArr2, y8);
                    try {
                        if (G == null) {
                            try {
                                strArr = w1.H(context, y8);
                            } catch (Exception e8) {
                                strArr = new String[]{e8.toString()};
                            }
                            StringBuilder s10 = android.support.v4.media.d.s("Could not find '", y8, "'. Looked for: ");
                            s10.append(Arrays.toString(strArr2));
                            s10.append(", but only found: ");
                            throw new m0(android.support.v4.media.d.r(s10, Arrays.toString(strArr), "."));
                        }
                        ZipFile zipFile = (ZipFile) G.f13542p;
                        int i10 = 0;
                        while (true) {
                            int i11 = i10 + 1;
                            if (i10 < 5) {
                                D("Found %s! Extracting...", y8);
                                try {
                                    if (z10.exists() || z10.createNewFile()) {
                                        try {
                                            inputStream2 = zipFile.getInputStream((ZipEntry) G.f13543q);
                                        } catch (FileNotFoundException unused) {
                                            inputStream2 = null;
                                        } catch (IOException unused2) {
                                            inputStream2 = null;
                                        } catch (Throwable th) {
                                            th = th;
                                            inputStream = null;
                                        }
                                        try {
                                            fileOutputStream = new FileOutputStream(z10);
                                            try {
                                                try {
                                                    byte[] bArr = new byte[4096];
                                                    long j10 = 0;
                                                    while (true) {
                                                        int read = inputStream2.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        fileOutputStream.write(bArr, 0, read);
                                                        j10 += read;
                                                    }
                                                    fileOutputStream.flush();
                                                    fileOutputStream.getFD().sync();
                                                    if (j10 == z10.length()) {
                                                        w1.C(inputStream2);
                                                        w1.C(fileOutputStream);
                                                        z10.setReadable(true, false);
                                                        z10.setExecutable(true, false);
                                                        z10.setWritable(true);
                                                        break;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    inputStream = inputStream2;
                                                    w1.C(inputStream);
                                                    w1.C(fileOutputStream);
                                                    throw th;
                                                }
                                            } catch (FileNotFoundException | IOException unused3) {
                                            }
                                        } catch (FileNotFoundException unused4) {
                                            fileOutputStream = null;
                                            w1.C(inputStream2);
                                            w1.C(fileOutputStream);
                                            i10 = i11;
                                        } catch (IOException unused5) {
                                            fileOutputStream = null;
                                            w1.C(inputStream2);
                                            w1.C(fileOutputStream);
                                            i10 = i11;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            inputStream = inputStream2;
                                            fileOutputStream = null;
                                            w1.C(inputStream);
                                            w1.C(fileOutputStream);
                                            throw th;
                                        }
                                        w1.C(inputStream2);
                                        w1.C(fileOutputStream);
                                    }
                                } catch (IOException unused6) {
                                }
                                i10 = i11;
                            }
                        }
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused7) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        eVar = G;
                        if (eVar != null) {
                            try {
                                ((ZipFile) eVar.f13542p).close();
                            } catch (IOException unused8) {
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    eVar = null;
                }
            }
            String absolutePath = z10.getAbsolutePath();
            v1Var.getClass();
            System.load(absolutePath);
            hashSet.add(str);
            D("%s (%s) was re-linked!", str, str2);
        }
    }

    public void E(androidx.lifecycle.l lVar) {
        k0 k0Var = (k0) this.f13566r;
        if (k0Var != null) {
            k0Var.run();
        }
        k0 k0Var2 = new k0((t) this.f13564p, lVar);
        this.f13566r = k0Var2;
        ((Handler) this.f13565q).postAtFrontOfQueue(k0Var2);
    }

    public Object F(CharSequence charSequence, int i10, int i11, int i12, boolean z10, androidx.emoji2.text.r rVar) {
        int i13;
        char c10;
        androidx.emoji2.text.t tVar = new androidx.emoji2.text.t((w) ((i) this.f13565q).f13555r);
        int codePointAt = Character.codePointAt(charSequence, i10);
        int i14 = 0;
        boolean z11 = true;
        int i15 = i10;
        loop0: while (true) {
            i13 = i15;
            while (i15 < i11 && i14 < i12 && z11) {
                SparseArray sparseArray = ((w) tVar.f600e).f611a;
                w wVar = sparseArray == null ? null : (w) sparseArray.get(codePointAt);
                if (tVar.f596a == 2) {
                    if (wVar != null) {
                        tVar.f600e = wVar;
                        tVar.f598c++;
                    } else {
                        if (codePointAt == 65038) {
                            tVar.c();
                        } else if (codePointAt != 65039) {
                            w wVar2 = (w) tVar.f600e;
                            if (wVar2.f612b != null) {
                                if (tVar.f598c != 1) {
                                    tVar.f601f = wVar2;
                                    tVar.c();
                                } else if (tVar.d()) {
                                    tVar.f601f = (w) tVar.f600e;
                                    tVar.c();
                                } else {
                                    tVar.c();
                                }
                                c10 = 3;
                            } else {
                                tVar.c();
                            }
                        }
                        c10 = 1;
                    }
                    c10 = 2;
                } else if (wVar == null) {
                    tVar.c();
                    c10 = 1;
                } else {
                    tVar.f596a = 2;
                    tVar.f600e = wVar;
                    tVar.f598c = 1;
                    c10 = 2;
                }
                tVar.f597b = codePointAt;
                if (c10 == 1) {
                    i15 = Character.charCount(Character.codePointAt(charSequence, i13)) + i13;
                    if (i15 < i11) {
                        codePointAt = Character.codePointAt(charSequence, i15);
                    }
                } else if (c10 == 2) {
                    int charCount = Character.charCount(codePointAt) + i15;
                    if (charCount < i11) {
                        codePointAt = Character.codePointAt(charSequence, charCount);
                    }
                    i15 = charCount;
                } else if (c10 == 3) {
                    if (z10 || !A(charSequence, i13, i15, ((w) tVar.f601f).f612b)) {
                        z11 = rVar.b(charSequence, i13, i15, ((w) tVar.f601f).f612b);
                        i14++;
                    }
                }
            }
        }
        if (tVar.f596a == 2 && ((w) tVar.f600e).f612b != null && ((tVar.f598c > 1 || tVar.d()) && i14 < i12 && z11 && (z10 || !A(charSequence, i13, i15, ((w) tVar.f600e).f612b)))) {
            rVar.b(charSequence, i13, i15, ((w) tVar.f600e).f612b);
        }
        return rVar.a();
    }

    @Override // o0.g
    public ClipDescription a() {
        return (ClipDescription) this.f13565q;
    }

    @Override // p7.h
    public void accept(Object obj, Object obj2) {
        switch (this.f13563o) {
            case 7:
                e0 e0Var = (e0) this.f13564p;
                String str = (String) this.f13565q;
                g7.i iVar = (g7.i) this.f13566r;
                x xVar = (x) obj;
                i8.d dVar = (i8.d) obj2;
                r7.r.g("Not connected to device", e0Var.F == 2);
                l7.g gVar = (l7.g) xVar.j();
                Parcel w02 = gVar.w0();
                w02.writeString(str);
                u.c(w02, iVar);
                gVar.z0(w02, 13);
                synchronized (e0Var.f5213r) {
                    try {
                        if (e0Var.f5210o != null) {
                            e0Var.h(2477);
                        }
                        e0Var.f5210o = dVar;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
            case 8:
                t(obj, obj2);
                return;
            default:
                e0 e0Var2 = (e0) this.f13564p;
                String str2 = (String) this.f13565q;
                g7.f fVar = (g7.f) this.f13566r;
                x xVar2 = (x) obj;
                i8.d dVar2 = (i8.d) obj2;
                r7.r.g("Not active connection", e0Var2.F != 1);
                l7.g gVar2 = (l7.g) xVar2.j();
                Parcel w03 = gVar2.w0();
                w03.writeString(str2);
                gVar2.z0(w03, 12);
                if (fVar != null) {
                    l7.g gVar3 = (l7.g) xVar2.j();
                    Parcel w04 = gVar3.w0();
                    w04.writeString(str2);
                    gVar3.z0(w04, 11);
                }
                dVar2.b(null);
                return;
        }
    }

    @Override // o0.g
    public Object b() {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004c  */
    @Override // k9.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c() {
        /*
            r5 = this;
            int r0 = r5.f13563o
            switch(r0) {
                case 14: goto L5d;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r5.f13564p
            h5.i r0 = (h5.i) r0
            java.lang.Object r0 = r0.f5610p
            androidx.emoji2.text.o r0 = (androidx.emoji2.text.o) r0
            android.content.Context r0 = r0.f591o
            java.lang.Object r1 = r5.f13565q
            k9.e r1 = (k9.e) r1
            h5.i r2 = new h5.i
            r3 = 12
            r2.<init>(r3, r1)
            k9.e r1 = new k9.e
            r1.<init>(r2)
            java.lang.Object r2 = r5.f13566r
            k9.e r2 = (k9.e) r2
            h5.i r3 = new h5.i
            r4 = 12
            r3.<init>(r4, r2)
            k9.e r2 = new k9.e
            r2.<init>(r3)
            android.content.pm.PackageManager r3 = r0.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            r4 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r0 = r3.getApplicationInfo(r0, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            android.os.Bundle r0 = r0.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L49
            if (r0 != 0) goto L42
            goto L49
        L42:
            java.lang.String r3 = "local_testing_dir"
            java.lang.String r0 = r0.getString(r3)
            goto L4a
        L49:
            r0 = 0
        L4a:
            if (r0 != 0) goto L53
            java.lang.Object r0 = r1.c()
            j9.x1 r0 = (j9.x1) r0
            goto L59
        L53:
            java.lang.Object r0 = r2.c()
            j9.x1 r0 = (j9.x1) r0
        L59:
            k5.a.a(r0)
            return r0
        L5d:
            java.lang.Object r0 = r5.f13564p
            k9.e r0 = (k9.e) r0
            java.lang.Object r0 = r0.c()
            java.lang.Object r1 = r5.f13565q
            j9.d1 r1 = (j9.d1) r1
            h5.i r2 = new h5.i
            r3 = 12
            r2.<init>(r3, r1)
            k9.e r1 = new k9.e
            r1.<init>(r2)
            java.lang.Object r2 = r5.f13566r
            k9.e r2 = (k9.e) r2
            java.lang.Object r2 = r2.c()
            j9.u0 r3 = new j9.u0
            j9.p r0 = (j9.p) r0
            j9.n0 r2 = (j9.n0) r2
            r3.<init>(r0, r1, r2)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.m.c():java.lang.Object");
    }

    @Override // o0.g
    public Uri d() {
        return (Uri) this.f13564p;
    }

    @Override // a6.c0
    public Bitmap e(BitmapFactory.Options options) {
        a6.e0 e0Var = (a6.e0) ((com.bumptech.glide.load.data.g) this.f13564p).f3043p;
        e0Var.reset();
        return a6.u.c(e0Var, options, this);
    }

    @Override // j9.v
    public void f(String str) {
        h(0L, str);
    }

    @Override // j9.v
    public ArrayList g(String str) {
        ArrayList<String> stringArrayList = ((Bundle) this.f13565q).getStringArrayList(str);
        if (stringArrayList == null) {
            return new ArrayList();
        }
        String[] strArr = new String[stringArrayList.size()];
        for (int i10 = 0; i10 < stringArrayList.size(); i10++) {
            String str2 = stringArrayList.get(i10);
            if (str2 == null) {
                str2 = _UrlKt.FRAGMENT_ENCODE_SET;
            }
            strArr[i10] = str2;
        }
        com.bumptech.glide.h hVar = (com.bumptech.glide.h) this.f13566r;
        hVar.f3017a.put(((String) this.f13564p).concat(str), strArr);
        return stringArrayList;
    }

    @Override // j9.v
    public void h(long j10, String str) {
        Bundle bundle = (Bundle) this.f13565q;
        String str2 = (String) this.f13564p;
        com.bumptech.glide.h hVar = (com.bumptech.glide.h) this.f13566r;
        hVar.f3017a.put(str2.concat(str), Long.valueOf(bundle.getLong(str, j10)));
    }

    /* JADX WARN: Finally extract failed */
    @Override // a6.c0
    public boolean i() {
        List list = (List) this.f13566r;
        a6.e0 e0Var = (a6.e0) ((com.bumptech.glide.load.data.g) this.f13564p).f3043p;
        e0Var.reset();
        u5.f fVar = (u5.f) this.f13565q;
        e0Var.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                boolean f10 = ((r5.d) list.get(i10)).f(e0Var, fVar);
                e0Var.reset();
                if (f10) {
                    return true;
                }
            } catch (Throwable th) {
                e0Var.reset();
                throw th;
            }
        }
        return false;
    }

    @Override // j9.v
    public void j() {
        Bundle bundle = (Bundle) this.f13565q;
        String str = (String) this.f13564p;
        com.bumptech.glide.h hVar = (com.bumptech.glide.h) this.f13566r;
        hVar.f3017a.put(str.concat("notification_intent_reconstruct_from_data"), Boolean.valueOf(bundle.getBoolean("notification_intent_reconstruct_from_data")));
    }

    @Override // j9.v
    public void k(String str) {
        ArrayList parcelableArrayList = ((Bundle) this.f13565q).getParcelableArrayList(str);
        if (parcelableArrayList == null) {
            return;
        }
        String[] strArr = new String[parcelableArrayList.size()];
        for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
            Intent intent = (Intent) parcelableArrayList.get(i10);
            strArr[i10] = (intent == null || intent.getData() == null) ? _UrlKt.FRAGMENT_ENCODE_SET : intent.getData().toString();
        }
        ((com.bumptech.glide.h) this.f13566r).f3017a.put(((String) this.f13564p) + str + ":intent_data", strArr);
    }

    @Override // o0.g
    public Uri m() {
        return (Uri) this.f13566r;
    }

    @Override // a6.c0
    public void n() {
        a6.e0 e0Var = (a6.e0) ((com.bumptech.glide.load.data.g) this.f13564p).f3043p;
        synchronized (e0Var) {
            e0Var.f53q = e0Var.f51o.length;
        }
    }

    @Override // a6.c0
    public int o() {
        List list = (List) this.f13566r;
        a6.e0 e0Var = (a6.e0) ((com.bumptech.glide.load.data.g) this.f13564p).f3043p;
        e0Var.reset();
        return com.bumptech.glide.f.i(list, e0Var, (u5.f) this.f13565q);
    }

    @Override // j9.v
    public void p(String str) {
        String string = ((Bundle) this.f13565q).getString(str);
        if (string == null) {
            return;
        }
        com.bumptech.glide.h hVar = (com.bumptech.glide.h) this.f13566r;
        hVar.f3017a.put(((String) this.f13564p).concat(str), string);
    }

    @Override // j9.v
    public void q(String str) {
        Bundle bundle = (Bundle) this.f13565q;
        String str2 = (String) this.f13564p;
        com.bumptech.glide.h hVar = (com.bumptech.glide.h) this.f13566r;
        hVar.f3017a.put(str2.concat(str), Integer.valueOf(bundle.getInt(str)));
    }

    @Override // f6.b
    public y r(y yVar, r5.h hVar) {
        Drawable drawable = (Drawable) yVar.get();
        if (drawable instanceof BitmapDrawable) {
            return ((app.shamel.tv.b) this.f13565q).r(a6.e.b(((BitmapDrawable) drawable).getBitmap(), (u5.a) this.f13564p), hVar);
        }
        if (drawable instanceof e6.d) {
            return ((f6.d) this.f13566r).r(yVar, hVar);
        }
        return null;
    }

    @Override // a6.c0
    public ImageHeaderParser$ImageType s() {
        List list = (List) this.f13566r;
        a6.e0 e0Var = (a6.e0) ((com.bumptech.glide.load.data.g) this.f13564p).f3043p;
        e0Var.reset();
        return com.bumptech.glide.f.l(list, e0Var, (u5.f) this.f13565q);
    }

    public void u() {
        android.support.v4.media.session.a0 a0Var = (android.support.v4.media.session.a0) this.f13564p;
        if (a0Var != null) {
            int i10 = ((w3.w) this.f13566r).f13040l.f3774r;
            android.support.v4.media.session.u uVar = (android.support.v4.media.session.u) a0Var.f230p;
            uVar.getClass();
            AudioAttributes.Builder builder = new AudioAttributes.Builder();
            builder.setLegacyStreamType(i10);
            uVar.f261a.setPlaybackToLocal(builder.build());
            this.f13565q = null;
        }
    }

    public void v(k2.p pVar, r3.e0 e0Var) {
        g0[] g0VarArr = (g0[]) this.f13565q;
        for (int i10 = 0; i10 < g0VarArr.length; i10++) {
            e0Var.a();
            e0Var.b();
            g0 q10 = pVar.q(e0Var.f10511d, 3);
            i1.p pVar2 = (i1.p) ((List) this.f13564p).get(i10);
            String str = pVar2.f5991n;
            l1.d.a("Invalid closed caption MIME type provided: " + str, "application/cea-608".equals(str) || "application/cea-708".equals(str));
            String str2 = pVar2.f5979a;
            if (str2 == null) {
                e0Var.b();
                str2 = e0Var.f10512e;
            }
            i1.o oVar = new i1.o();
            oVar.f5929a = str2;
            oVar.f5939l = i1.g0.m("video/mp2t");
            oVar.f5940m = i1.g0.m(str);
            oVar.f5933e = pVar2.f5983e;
            oVar.f5932d = pVar2.f5982d;
            oVar.J = pVar2.K;
            oVar.f5943p = pVar2.f5994q;
            r.a.i(oVar, q10);
            g0VarArr[i10] = q10;
        }
    }

    public long x() {
        k2.k kVar = (k2.k) this.f13566r;
        if (kVar != null) {
            return kVar.f7753r;
        }
        return -1L;
    }

    public Object y(int i10, OsResults osResults) {
        return ((io.realm.u) this.f13564p).x((Class) this.f13566r, osResults.d(i10));
    }

    public File z(Context context, String str, String str2) {
        ((v1) this.f13565q).getClass();
        String y8 = v1.y(str);
        if (str2 == null || str2.length() == 0) {
            return new File(context.getDir("lib", 0), y8);
        }
        return new File(context.getDir("lib", 0), y8 + "." + str2);
    }

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i10) {
        this.f13563o = i10;
        this.f13564p = obj;
        this.f13565q = obj2;
        this.f13566r = obj3;
    }

    public m(k9.e eVar, d1 d1Var, k9.e eVar2, k9.e eVar3) {
        this.f13563o = 14;
        this.f13564p = eVar;
        this.f13565q = d1Var;
        this.f13566r = eVar2;
    }

    public m(androidx.emoji2.text.o oVar) {
        this.f13563o = 13;
        h5.i iVar = new h5.i(10, oVar);
        k9.e a10 = k9.e.a(new j9.e0(iVar, 2));
        k9.e a11 = k9.e.a(new r(iVar, 7, a10));
        k9.e a12 = k9.e.a(j9.k0.f7329d);
        k9.e a13 = k9.e.a(new l((Object) a11, (Object) a10, false));
        k9.e a14 = k9.e.a(new android.support.v4.media.session.a0(iVar, a12, a13, 12));
        k9.e a15 = k9.e.a(new j9.e0(iVar, 3));
        d1 d1Var = new d1();
        k9.e a16 = k9.e.a(j9.k0.f7330e);
        k9.e a17 = k9.e.a(new m(a11, d1Var, a12, a16));
        k9.e a18 = k9.e.a(j9.k0.f7327b);
        k9.e a19 = k9.e.a(new b0(a11, d1Var, a18, a12, a13, 0));
        k9.e a20 = k9.e.a(new d1(a11, 1));
        k9.e a21 = k9.e.a(new d1(a11, 0));
        g1 g1Var = new g1();
        g1Var.f7290o = a11;
        g1Var.f7295t = d1Var;
        g1Var.f7291p = a17;
        g1Var.f7292q = a16;
        g1Var.f7293r = a12;
        g1Var.f7294s = a13;
        k9.e a22 = k9.e.a(new j9.n(a17, d1Var, a19, a20, a21, k9.e.a(g1Var), k9.e.a(new r(a11, 8, d1Var)), k9.e.a(new b0(a11, d1Var, a17, a16, a12, 1)), k9.e.a(new i0(a17, a11, k9.e.a(new h5.i(8, d1Var)), 1))));
        k9.e a23 = k9.e.a(j9.k0.f7328c);
        k9.e a24 = k9.e.a(j9.k0.f7331f);
        k9.e a25 = k9.e.a(new j9.n(iVar, a17, a22, d1Var, a12, a23, a16, a24, a13));
        k9.e a26 = k9.e.a(new m(iVar, a14, k9.e.a(new d3(a15, a25, a12, iVar, a10, a16, a13)), 15));
        if (d1Var.f7254p == null) {
            d1Var.f7254p = a26;
            k9.e a27 = k9.e.a(new u1(a11, d1Var, a25, a18, k9.e.a(new j9.e0(iVar, 5)), a17, a12, a23, a16, a13));
            k9.e a28 = k9.e.a(new j9.e0(iVar, 0));
            k9.e a29 = k9.e.a(new j9.e0(iVar, 1));
            this.f13564p = k9.e.a(new u5(iVar, a11, a27, a28, a29));
            this.f13565q = k9.e.a(new i0(a17, a22, a29, 0));
            this.f13566r = k9.e.a(new j9.g0(a17, a12, a13, a23, k9.e.a(new j9.e0(iVar, 4)), d1Var, a18, a24));
            return;
        }
        throw new IllegalStateException();
    }

    public m(androidx.lifecycle.u uVar) {
        this.f13563o = 3;
        this.f13564p = new t(uVar);
        this.f13565q = new Handler();
    }

    public m(WorkDatabase_Impl workDatabase_Impl) {
        this.f13563o = 0;
        this.f13564p = workDatabase_Impl;
        new b(workDatabase_Impl, 4);
        this.f13565q = new h(workDatabase_Impl, 2);
        this.f13566r = new h(workDatabase_Impl, 3);
    }

    public m() {
        this.f13563o = 18;
        v1 v1Var = new v1(9);
        w1 w1Var = new w1(8);
        this.f13564p = new HashSet();
        this.f13565q = v1Var;
        this.f13566r = w1Var;
    }

    @Override // o0.g
    public void l() {
    }

    public m(List list) {
        this.f13563o = 20;
        this.f13564p = list;
        this.f13565q = new g0[list.size()];
        this.f13566r = new b4.b(new v0(17, this));
    }

    public m(k2.q qVar) {
        this.f13563o = 5;
        this.f13564p = qVar;
    }

    public m(Runnable runnable) {
        this.f13563o = 16;
        this.f13565q = new CopyOnWriteArrayList();
        this.f13566r = new HashMap();
        this.f13564p = runnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.content.Context, android.content.res.Resources] */
    /* JADX WARN: Type inference failed for: r18v0, types: [android.app.Notification, java.lang.String] */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r4v13, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r4v19, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r4v7, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r4v9, types: [android.app.Notification$Builder] */
    /* JADX WARN: Type inference failed for: r7v14, types: [androidx.core.graphics.drawable.IconCompat] */
    public m(b0.i iVar) {
        Bundle bundle;
        Bundle[] bundleArr;
        int i10;
        ArrayList arrayList;
        Icon icon;
        ?? r18;
        ArrayList arrayList2;
        Bundle bundle2;
        int i11;
        this.f13563o = 4;
        new ArrayList();
        this.f13566r = new Bundle();
        this.f13565q = iVar;
        Context context = iVar.f2145a;
        ArrayList arrayList3 = iVar.f2161r;
        ArrayList arrayList4 = iVar.f2147c;
        ArrayList arrayList5 = iVar.f2148d;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f13564p = b0.l.a(context, iVar.f2158o);
        } else {
            this.f13564p = new Notification.Builder(context);
        }
        Notification notification = iVar.f2160q;
        ?? r10 = 0;
        int i12 = 0;
        ((Notification.Builder) this.f13564p).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(iVar.f2149e).setContentText(iVar.f2150f).setContentInfo(null).setContentIntent(iVar.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setNumber(0).setProgress(0, 0, false);
        Notification.Builder builder = (Notification.Builder) this.f13564p;
        IconCompat iconCompat = iVar.f2151h;
        builder.setLargeIcon(iconCompat == null ? null : iconCompat.e(context));
        ((Notification.Builder) this.f13564p).setSubText(null).setUsesChronometer(false).setPriority(iVar.f2152i);
        ArrayList arrayList6 = iVar.f2146b;
        int size = arrayList6.size();
        int i13 = 0;
        while (i13 < size) {
            Object obj = arrayList6.get(i13);
            i13++;
            b0.g gVar = (b0.g) obj;
            if (gVar.f2138b == null && (i11 = gVar.f2142f) != 0) {
                gVar.f2138b = IconCompat.b(r10, _UrlKt.FRAGMENT_ENCODE_SET, i11);
            }
            ?? r72 = gVar.f2138b;
            boolean z10 = gVar.f2140d;
            int i14 = i12;
            Bundle bundle3 = gVar.f2137a;
            if (r72 != 0) {
                icon = r72.e(r10);
                r18 = r10;
            } else {
                icon = r10;
                r18 = icon;
            }
            ArrayList arrayList7 = arrayList6;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(icon, gVar.g, gVar.f2143h);
            b0.r[] rVarArr = gVar.f2139c;
            if (rVarArr != null) {
                int length = rVarArr.length;
                RemoteInput[] remoteInputArr = new RemoteInput[length];
                arrayList2 = arrayList4;
                if (rVarArr.length > 0) {
                    b0.r rVar = rVarArr[i14];
                    throw r18;
                }
                for (int i15 = i14; i15 < length; i15++) {
                    builder2.addRemoteInput(remoteInputArr[i15]);
                }
            } else {
                arrayList2 = arrayList4;
            }
            if (bundle3 != null) {
                bundle2 = new Bundle(bundle3);
            } else {
                bundle2 = new Bundle();
            }
            bundle2.putBoolean("android.support.allowGeneratedReplies", z10);
            int i16 = Build.VERSION.SDK_INT;
            if (i16 >= 24) {
                b0.k.b(builder2, z10);
            }
            bundle2.putInt("android.support.action.semanticAction", i14);
            if (i16 >= 28) {
                b0.m.a(builder2);
            }
            if (i16 >= 29) {
                b0.d.d(builder2);
            }
            if (i16 >= 31) {
                b0.n.a(builder2);
            }
            bundle2.putBoolean("android.support.action.showsUserInterface", gVar.f2141e);
            builder2.addExtras(bundle2);
            ((Notification.Builder) this.f13564p).addAction(builder2.build());
            r10 = r18;
            arrayList6 = arrayList7;
            arrayList4 = arrayList2;
            i12 = 0;
        }
        ArrayList arrayList8 = arrayList4;
        ?? r182 = r10;
        Bundle bundle4 = iVar.f2156m;
        if (bundle4 != null) {
            ((Bundle) this.f13566r).putAll(bundle4);
        }
        int i17 = Build.VERSION.SDK_INT;
        ((Notification.Builder) this.f13564p).setShowWhen(iVar.f2153j);
        ((Notification.Builder) this.f13564p).setLocalOnly(iVar.f2155l);
        ((Notification.Builder) this.f13564p).setGroup(r182);
        ((Notification.Builder) this.f13564p).setSortKey(r182);
        ((Notification.Builder) this.f13564p).setGroupSummary(false);
        ((Notification.Builder) this.f13564p).setCategory(r182);
        ((Notification.Builder) this.f13564p).setColor(0);
        ((Notification.Builder) this.f13564p).setVisibility(iVar.f2157n);
        ((Notification.Builder) this.f13564p).setPublicVersion(r182);
        ((Notification.Builder) this.f13564p).setSound(notification.sound, notification.audioAttributes);
        if (i17 < 28) {
            if (arrayList8 == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList(arrayList8.size());
                Iterator it = arrayList8.iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.d.l(it);
                }
            }
            if (arrayList != null) {
                if (arrayList3 == null) {
                    arrayList3 = arrayList;
                } else {
                    p.f fVar = new p.f(arrayList3.size() + arrayList.size());
                    fVar.addAll(arrayList);
                    fVar.addAll(arrayList3);
                    arrayList3 = new ArrayList(fVar);
                }
            }
        }
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            int size2 = arrayList3.size();
            int i18 = 0;
            while (i18 < size2) {
                Object obj2 = arrayList3.get(i18);
                i18++;
                ((Notification.Builder) this.f13564p).addPerson((String) obj2);
            }
        }
        if (arrayList5.size() > 0) {
            if (iVar.f2156m == null) {
                iVar.f2156m = new Bundle();
            }
            Bundle bundle5 = iVar.f2156m.getBundle("android.car.EXTENSIONS");
            bundle5 = bundle5 == null ? new Bundle() : bundle5;
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i19 = 0; i19 < arrayList5.size(); i19++) {
                String num = Integer.toString(i19);
                b0.g gVar2 = (b0.g) arrayList5.get(i19);
                Bundle bundle8 = new Bundle();
                if (gVar2.f2138b == null && (i10 = gVar2.f2142f) != 0) {
                    gVar2.f2138b = IconCompat.b(null, _UrlKt.FRAGMENT_ENCODE_SET, i10);
                }
                IconCompat iconCompat2 = gVar2.f2138b;
                Bundle bundle9 = gVar2.f2137a;
                bundle8.putInt("icon", iconCompat2 != null ? iconCompat2.c() : 0);
                bundle8.putCharSequence("title", gVar2.g);
                bundle8.putParcelable("actionIntent", gVar2.f2143h);
                if (bundle9 != null) {
                    bundle = new Bundle(bundle9);
                } else {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android.support.allowGeneratedReplies", gVar2.f2140d);
                bundle8.putBundle("extras", bundle);
                b0.r[] rVarArr2 = gVar2.f2139c;
                if (rVarArr2 == null) {
                    bundleArr = null;
                } else {
                    bundleArr = new Bundle[rVarArr2.length];
                    if (rVarArr2.length > 0) {
                        b0.r rVar2 = rVarArr2[0];
                        new Bundle();
                        throw null;
                    }
                }
                bundle8.putParcelableArray("remoteInputs", bundleArr);
                bundle8.putBoolean("showsUserInterface", gVar2.f2141e);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(num, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (iVar.f2156m == null) {
                iVar.f2156m = new Bundle();
            }
            iVar.f2156m.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) this.f13566r).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i20 = Build.VERSION.SDK_INT;
        if (i20 >= 24) {
            ((Notification.Builder) this.f13564p).setExtras(iVar.f2156m);
            b0.k.c((Notification.Builder) this.f13564p);
        }
        if (i20 >= 26) {
            b0.l.b((Notification.Builder) this.f13564p);
            b0.l.d((Notification.Builder) this.f13564p);
            b0.l.e((Notification.Builder) this.f13564p);
            b0.l.f((Notification.Builder) this.f13564p);
            b0.l.c((Notification.Builder) this.f13564p);
            if (!TextUtils.isEmpty(iVar.f2158o)) {
                ((Notification.Builder) this.f13564p).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i20 >= 28) {
            Iterator it2 = arrayList8.iterator();
            if (it2.hasNext()) {
                throw android.support.v4.media.d.l(it2);
            }
        }
        if (i20 >= 29) {
            b0.d.b((Notification.Builder) this.f13564p, iVar.f2159p);
            b0.d.c((Notification.Builder) this.f13564p);
        }
        if (i20 >= 36) {
            b0.o.a((Notification.Builder) this.f13564p);
        }
    }

    public m(i iVar, d9.f fVar, androidx.emoji2.text.d dVar, Set set) {
        this.f13563o = 2;
        this.f13564p = fVar;
        this.f13565q = iVar;
        this.f13566r = dVar;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            F(str, 0, str.length(), 1, true, new s(str, false, 0));
        }
    }

    public m(j1.g[] gVarArr) {
        this.f13563o = 26;
        d0 d0Var = new d0();
        j1.j jVar = new j1.j();
        jVar.f6985c = 1.0f;
        jVar.f6986d = 1.0f;
        j1.e eVar = j1.e.f6950e;
        jVar.f6987e = eVar;
        jVar.f6988f = eVar;
        jVar.g = eVar;
        jVar.f6989h = eVar;
        ByteBuffer byteBuffer = j1.g.f6955a;
        jVar.f6992k = byteBuffer;
        jVar.f6993l = byteBuffer.asShortBuffer();
        jVar.f6994m = byteBuffer;
        jVar.f6984b = -1;
        j1.g[] gVarArr2 = new j1.g[gVarArr.length + 2];
        this.f13564p = gVarArr2;
        System.arraycopy(gVarArr, 0, gVarArr2, 0, gVarArr.length);
        this.f13565q = d0Var;
        this.f13566r = jVar;
        gVarArr2[gVarArr.length] = d0Var;
        gVarArr2[gVarArr.length + 1] = jVar;
    }

    public m(m6.k kVar, ArrayList arrayList, u5.f fVar) {
        this.f13563o = 1;
        m6.f.c("Argument must not be null", fVar);
        this.f13565q = fVar;
        m6.f.c("Argument must not be null", arrayList);
        this.f13566r = arrayList;
        this.f13564p = new com.bumptech.glide.load.data.g(kVar, fVar);
    }

    public m(Matcher matcher, CharSequence charSequence) {
        this.f13563o = 10;
        za.h.e("input", charSequence);
        this.f13564p = matcher;
        this.f13565q = new gb.g(this);
    }

    public m(t5.k kVar, i6.f fVar, t5.o oVar) {
        this.f13563o = 25;
        this.f13566r = kVar;
        this.f13565q = fVar;
        this.f13564p = oVar;
    }

    public m(u1.z zVar) {
        this.f13563o = 27;
        this.f13566r = zVar;
        this.f13564p = new Handler(Looper.myLooper());
        this.f13565q = new u1.y(this);
    }

    public m(w3.w wVar, android.support.v4.media.session.a0 a0Var) {
        this.f13563o = 28;
        this.f13566r = wVar;
        this.f13564p = a0Var;
    }
}
