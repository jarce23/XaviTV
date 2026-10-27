package c2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.widget.ImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import m.p2;
import org.json.JSONObject;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j1 implements k2.i {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f2624o;

    /* renamed from: p, reason: collision with root package name */
    public int f2625p;

    /* renamed from: q, reason: collision with root package name */
    public Object f2626q;

    /* renamed from: r, reason: collision with root package name */
    public Object f2627r;

    public /* synthetic */ j1(int i10, int i11) {
        this.f2624o = i11;
        this.f2625p = i10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x021b, code lost:
    
        r0 = new x4.l();
        r0.f13561o = new int[]{r6, r5, r12};
        r0.f13562p = new float[]{0.0f, 0.5f, 1.0f};
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x022f, code lost:
    
        r0 = new x4.l();
        r0.f13561o = new int[]{r6, r12};
        r15 = 2;
        r0.f13562p = new float[]{0.0f, 1.0f};
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0213, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01da, code lost:
    
        if (r13.size() <= 0) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01dc, code lost:
    
        r0 = new x4.l();
        r1 = r13.size();
        r0.f13561o = new int[r1];
        r0.f13562p = new float[r1];
        r2 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01ee, code lost:
    
        if (r2 >= r1) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f0, code lost:
    
        ((int[]) r0.f13561o)[r2] = ((java.lang.Integer) r13.get(r2)).intValue();
        ((float[]) r0.f13562p)[r2] = ((java.lang.Float) r7.get(r2)).floatValue();
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0214, code lost:
    
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0216, code lost:
    
        r14 = 1;
        r15 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0243, code lost:
    
        if (r11 == r14) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0245, code lost:
    
        if (r11 == r15) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0247, code lost:
    
        r16 = (int[]) r0.f13561o;
        r17 = (float[]) r0.f13562p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0255, code lost:
    
        if (r10 == r14) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0257, code lost:
    
        if (r10 == r15) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0259, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x026c, code lost:
    
        r11 = new android.graphics.LinearGradient(r21, r22, r26, r27, r16, r17, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x02b5, code lost:
    
        return new c2.j1(r11, (android.content.res.ColorStateList) null, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0266, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0269, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0270, code lost:
    
        r11 = new android.graphics.SweepGradient(r8, r9, (int[]) r0.f13561o, (float[]) r0.f13562p);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0282, code lost:
    
        if (r25 <= 0.0f) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0284, code lost:
    
        r20 = (int[]) r0.f13561o;
        r21 = (float[]) r0.f13562p;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0293, code lost:
    
        if (r10 == 1) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0296, code lost:
    
        if (r10 == 2) goto L121;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0298, code lost:
    
        r0 = android.graphics.Shader.TileMode.CLAMP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x02a9, code lost:
    
        r11 = new android.graphics.RadialGradient(r8, r9, r25, r20, r21, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02a3, code lost:
    
        r0 = android.graphics.Shader.TileMode.MIRROR;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x02a6, code lost:
    
        r0 = android.graphics.Shader.TileMode.REPEAT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x02bd, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0219, code lost:
    
        if (r20 == false) goto L101;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static c2.j1 d(android.content.res.Resources r30, int r31, android.content.res.Resources.Theme r32) {
        /*
            Method dump skipped, instructions count: 760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.d(android.content.res.Resources, int, android.content.res.Resources$Theme):c2.j1");
    }

    public static void f(String str) {
        if (str.equalsIgnoreCase(":memory:")) {
            return;
        }
        int length = str.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean z11 = za.h.f(str.charAt(!z10 ? i10 : length), 32) <= 0;
            if (z10) {
                if (!z11) {
                    break;
                } else {
                    length--;
                }
            } else if (z11) {
                i10++;
            } else {
                z10 = true;
            }
        }
        if (str.subSequence(i10, length + 1).toString().length() == 0) {
            return;
        }
        Log.w("SupportSQLite", "deleting the database file: ".concat(str));
        try {
            SQLiteDatabase.deleteDatabase(new File(str));
        } catch (Exception e7) {
            Log.w("SupportSQLite", "delete failed: ", e7);
        }
    }

    public void a() {
        p2 p2Var;
        ImageView imageView = (ImageView) this.f2626q;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            m.i1.a(drawable);
        }
        if (drawable == null || (p2Var = (p2) this.f2627r) == null) {
            return;
        }
        m.r.e(drawable, p2Var, imageView.getDrawableState());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae  */
    @Override // k2.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k2.h b(k2.o r23, long r24) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.b(k2.o, long):k2.h");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01a3  */
    /* JADX WARN: Type inference failed for: r17v11 */
    /* JADX WARN: Type inference failed for: r17v12 */
    /* JADX WARN: Type inference failed for: r17v13 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public o9.b1 c() {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.c():o9.b1");
    }

    @Override // k2.i
    public void e() {
        switch (this.f2624o) {
            case 8:
                break;
            default:
                l1.t tVar = (l1.t) this.f2627r;
                byte[] bArr = l1.a0.f8069c;
                tVar.getClass();
                tVar.G(bArr.length, bArr);
                break;
        }
    }

    public long g(k2.o oVar) {
        int d6;
        i1.s sVar = (i1.s) this.f2627r;
        k2.s sVar2 = (k2.s) this.f2626q;
        while (oVar.n() < oVar.c() - 6) {
            int i10 = this.f2625p;
            long n10 = oVar.n();
            byte[] bArr = new byte[2];
            int i11 = 0;
            boolean b2 = false;
            oVar.o(bArr, 0, 2);
            if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
                oVar.h();
                oVar.p((int) (n10 - oVar.getPosition()));
            } else {
                l1.t tVar = new l1.t(16);
                System.arraycopy(bArr, 0, tVar.f8129a, 0, 2);
                byte[] bArr2 = tVar.f8129a;
                while (i11 < 14 && (d6 = oVar.d(bArr2, 2 + i11, 14 - i11)) != -1) {
                    i11 += d6;
                }
                tVar.H(i11);
                oVar.h();
                oVar.p((int) (n10 - oVar.getPosition()));
                b2 = k2.b.b(tVar, sVar2, i10, sVar);
            }
            if (b2) {
                break;
            }
            oVar.p(1);
        }
        if (oVar.n() < oVar.c() - 6) {
            return sVar.f6018a;
        }
        oVar.p((int) (oVar.c() - oVar.n()));
        return sVar2.f7776j;
    }

    public Object h(int i10) {
        SparseArray sparseArray = (SparseArray) this.f2626q;
        if (this.f2625p == -1) {
            this.f2625p = 0;
        }
        while (true) {
            int i11 = this.f2625p;
            if (i11 <= 0 || i10 >= sparseArray.keyAt(i11)) {
                break;
            }
            this.f2625p--;
        }
        while (this.f2625p < sparseArray.size() - 1 && i10 >= sparseArray.keyAt(this.f2625p + 1)) {
            this.f2625p++;
        }
        return sparseArray.valueAt(this.f2625p);
    }

    public void i(JSONObject jSONObject, String str) {
        j5.g gVar;
        a.a.p((Context) this.f2626q);
        try {
            j5.c cVar = new j5.c(str, jSONObject.toString(), new j5.b(this), new j5.b(this));
            cVar.f8984y = new b4.j0(20000);
            Context context = (Context) this.f2626q;
            synchronized (j5.g.class) {
                try {
                    if (j5.g.f7113q == null) {
                        j5.g.f7113q = new j5.g(context, 0);
                    }
                    gVar = j5.g.f7113q;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (((m5.j) gVar.f7114o) == null) {
                gVar.f7114o = a.a.p(((Context) gVar.f7115p).getApplicationContext());
            }
            ((m5.j) gVar.f7114o).a(cVar);
        } catch (Exception unused) {
            ((j5.d) this.f2627r).a(null, this.f2625p);
        }
    }

    public boolean j() {
        ColorStateList colorStateList;
        return ((Shader) this.f2626q) == null && (colorStateList = (ColorStateList) this.f2627r) != null && colorStateList.isStateful();
    }

    public void k(AttributeSet attributeSet, int i10) {
        int resourceId;
        ImageView imageView = (ImageView) this.f2626q;
        Context context = imageView.getContext();
        int[] iArr = e.a.f4363f;
        android.support.v4.media.session.a0 T = android.support.v4.media.session.a0.T(context, attributeSet, iArr, i10);
        TypedArray typedArray = (TypedArray) T.f231q;
        m0.k0.l(imageView, imageView.getContext(), iArr, attributeSet, (TypedArray) T.f231q, i10);
        try {
            Drawable drawable = imageView.getDrawable();
            if (drawable == null && (resourceId = typedArray.getResourceId(1, -1)) != -1 && (drawable = n4.a.o(imageView.getContext(), resourceId)) != null) {
                imageView.setImageDrawable(drawable);
            }
            if (drawable != null) {
                m.i1.a(drawable);
            }
            if (typedArray.hasValue(2)) {
                imageView.setImageTintList(T.J(2));
            }
            if (typedArray.hasValue(3)) {
                imageView.setImageTintMode(m.i1.c(typedArray.getInt(3, -1), null));
            }
            T.U();
        } catch (Throwable th) {
            T.U();
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0062 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m(h4.c r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f2627r
            p4.p r0 = (p4.p) r0
            java.lang.String r1 = "SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'"
            android.database.Cursor r1 = r5.P(r1)
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L19
            r3 = 0
            if (r2 == 0) goto L1b
            int r2 = r1.getInt(r3)     // Catch: java.lang.Throwable -> L19
            if (r2 != 0) goto L1b
            r2 = 1
            goto L1c
        L19:
            r5 = move-exception
            goto L63
        L1b:
            r2 = r3
        L1c:
            r1.close()
            p4.p.d(r5)
            if (r2 != 0) goto L43
            c4.l r1 = p4.p.l(r5)
            boolean r2 = r1.f2910b
            if (r2 == 0) goto L2d
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Pre-packaged database has an invalid schema: "
            r0.<init>(r2)
            java.lang.String r1 = r1.f2909a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r5.<init>(r0)
            throw r5
        L43:
            r4.s(r5)
            java.lang.Object r5 = r0.f9953p
            androidx.work.impl.WorkDatabase_Impl r5 = (androidx.work.impl.WorkDatabase_Impl) r5
            java.util.List r0 = r5.f1528f
            if (r0 == 0) goto L62
            int r0 = r0.size()
        L52:
            if (r3 >= r0) goto L62
            java.util.List r1 = r5.f1528f
            java.lang.Object r1 = r1.get(r3)
            p4.b r1 = (p4.b) r1
            r1.getClass()
            int r3 = r3 + 1
            goto L52
        L62:
            return
        L63:
            throw r5     // Catch: java.lang.Throwable -> L64
        L64:
            r0 = move-exception
            com.bumptech.glide.f.d(r1, r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.m(h4.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void n(h4.c r11) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.n(h4.c):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0083 A[EDGE_INSN: B:86:0x0083->B:69:0x0083 BREAK  A[LOOP:3: B:48:0x0022->B:70:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void p(h4.c r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.j1.p(h4.c, int, int):void");
    }

    public void q(Object obj, Object obj2) {
        int i10 = (this.f2625p + 1) * 2;
        Object[] objArr = (Object[]) this.f2626q;
        if (i10 > objArr.length) {
            this.f2626q = Arrays.copyOf(objArr, o9.a0.e(objArr.length, i10));
        }
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
        Object[] objArr2 = (Object[]) this.f2626q;
        int i11 = this.f2625p;
        int i12 = i11 * 2;
        objArr2[i12] = obj;
        objArr2[i12 + 1] = obj2;
        this.f2625p = i11 + 1;
    }

    public List r(CharSequence charSequence) {
        charSequence.getClass();
        h5.i iVar = (h5.i) this.f2627r;
        iVar.getClass();
        n9.g gVar = new n9.g(iVar, this, charSequence);
        ArrayList arrayList = new ArrayList();
        while (gVar.hasNext()) {
            arrayList.add((String) gVar.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void s(h4.c cVar) {
        cVar.x("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        cVar.x("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '7d73d21f1bd82c9e5268b6dcf9fde2cb')");
    }

    public j1(Context context, int i10) {
        this.f2624o = 4;
        this.f2626q = context;
        this.f2625p = i10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j1(c4.b bVar, p4.p pVar) {
        this(20, 1);
        this.f2624o = 1;
        this.f2626q = bVar;
        this.f2627r = pVar;
    }

    public j1(ImageView imageView) {
        this.f2624o = 5;
        this.f2625p = 0;
        this.f2626q = imageView;
    }

    public j1(a6.a0 a0Var) {
        this.f2624o = 0;
        this.f2626q = new SparseArray();
        this.f2627r = a0Var;
        this.f2625p = -1;
    }

    public j1(Shader shader, ColorStateList colorStateList, int i10) {
        this.f2624o = 3;
        this.f2626q = shader;
        this.f2627r = colorStateList;
        this.f2625p = i10;
    }

    public j1(k2.s sVar, int i10) {
        this.f2624o = 8;
        this.f2626q = sVar;
        this.f2625p = i10;
        this.f2627r = new i1.s();
    }

    public j1(int i10, l1.y yVar) {
        this.f2624o = 9;
        this.f2625p = i10;
        this.f2626q = yVar;
        this.f2627r = new l1.t();
    }

    public j1(h5.i iVar) {
        this.f2624o = 6;
        this.f2627r = iVar;
        this.f2626q = n9.c.f9253o;
        this.f2625p = Integer.MAX_VALUE;
    }

    private final /* synthetic */ void o() {
    }

    public j1(int i10) {
        this.f2624o = 7;
        this.f2626q = new Object[i10 * 2];
        this.f2625p = 0;
    }

    public j1(c.a aVar) {
        this.f2624o = 11;
        this.f2627r = n6.c.a(150, new p4.p(7, this));
        this.f2626q = aVar;
    }

    public void l(h4.c cVar) {
    }

    public j1(i1.p pVar, int i10, String str) {
        this.f2624o = 10;
        this.f2626q = pVar;
        this.f2625p = i10;
        this.f2627r = str;
    }
}
