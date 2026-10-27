package j9;

import android.os.ParcelFileDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 {

    /* renamed from: d, reason: collision with root package name */
    public static final androidx.emoji2.text.s f7477d = new androidx.emoji2.text.s("ExtractorTaskFinder", 3);

    /* renamed from: a, reason: collision with root package name */
    public final u0 f7478a;

    /* renamed from: b, reason: collision with root package name */
    public final p f7479b;

    /* renamed from: c, reason: collision with root package name */
    public final w f7480c;

    public w0(u0 u0Var, p pVar, w wVar) {
        this.f7478a = u0Var;
        this.f7479b = pVar;
        this.f7480c = wVar;
    }

    public final v0 a() {
        int i10;
        int i11;
        androidx.emoji2.text.s sVar;
        int i12;
        v0 v0Var;
        v0 v0Var2;
        int i13;
        v0 v0Var3;
        int i14;
        int i15;
        v0 v0Var4;
        w wVar;
        p pVar;
        int i16;
        k1 k1Var;
        int i17;
        p pVar2 = this.f7479b;
        u0 u0Var = this.f7478a;
        try {
            u0Var.f7461d.lock();
            ArrayList arrayList = new ArrayList();
            for (r0 r0Var : u0Var.f7460c.values()) {
                if (k0.d(r0Var.f7426c.f7419d)) {
                    arrayList.add(r0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                HashMap l10 = pVar2.l();
                int size = arrayList.size();
                int i18 = 0;
                while (true) {
                    i10 = 2;
                    i11 = 1;
                    sVar = f7477d;
                    if (i18 >= size) {
                        i12 = 0;
                        v0Var = null;
                        break;
                    }
                    Object obj = arrayList.get(i18);
                    i18++;
                    r0 r0Var2 = (r0) obj;
                    q0 q0Var = r0Var2.f7426c;
                    Long l11 = (Long) l10.get(q0Var.f7416a);
                    if (l11 != null) {
                        int i19 = size;
                        if (q0Var.f7417b == l11.longValue()) {
                            sVar.d("Found promote pack task for session %s with pack %s.", Integer.valueOf(r0Var2.f7424a), q0Var.f7416a);
                            int i20 = r0Var2.f7424a;
                            String str = q0Var.f7416a;
                            i12 = 0;
                            v0Var = new m1(i20, (int) p.b(new File(pVar2.d(), str)), r0Var2.f7425b, q0Var.f7417b, str);
                            break;
                        }
                        size = i19;
                    }
                }
                if (v0Var == null) {
                    int size2 = arrayList.size();
                    int i21 = i12;
                    while (true) {
                        if (i21 >= size2) {
                            i13 = i12;
                            v0Var3 = null;
                            break;
                        }
                        Object obj2 = arrayList.get(i21);
                        i21++;
                        r0 r0Var3 = (r0) obj2;
                        try {
                            q0 q0Var2 = r0Var3.f7426c;
                            i13 = i12;
                            if (pVar2.g(r0Var3.f7425b, q0Var2.f7416a, q0Var2.f7417b) == q0Var2.f7421f.size()) {
                                Integer valueOf = Integer.valueOf(r0Var3.f7424a);
                                String str2 = q0Var2.f7416a;
                                Object[] objArr = new Object[2];
                                objArr[i13] = valueOf;
                                objArr[1] = str2;
                                sVar.d("Found final move task for session %s with pack %s.", objArr);
                                v0Var3 = new e1(r0Var3.f7424a, q0Var2.f7416a, r0Var3.f7425b, q0Var2.f7417b, q0Var2.f7418c);
                                break;
                            }
                            i12 = i13;
                        } catch (IOException e7) {
                            throw new j0("Failed to check number of completed merges for session " + r0Var3.f7424a + ", pack " + r0Var3.f7426c.f7416a, e7, r0Var3.f7424a);
                        }
                    }
                    if (v0Var3 == null) {
                        int size3 = arrayList.size();
                        int i22 = i13;
                        loop3: while (true) {
                            if (i22 >= size3) {
                                i14 = i10;
                                i15 = i11;
                                v0Var4 = null;
                                break;
                            }
                            Object obj3 = arrayList.get(i22);
                            i22++;
                            r0 r0Var4 = (r0) obj3;
                            q0 q0Var3 = r0Var4.f7426c;
                            if (k0.d(q0Var3.f7419d)) {
                                ArrayList arrayList2 = q0Var3.f7421f;
                                int size4 = arrayList2.size();
                                int i23 = i13;
                                while (i23 < size4) {
                                    Object obj4 = arrayList2.get(i23);
                                    i23++;
                                    s0 s0Var = (s0) obj4;
                                    i14 = i10;
                                    i15 = i11;
                                    ArrayList arrayList3 = arrayList2;
                                    int i24 = size3;
                                    if (this.f7479b.j(q0Var3.f7416a, r0Var4.f7425b, q0Var3.f7417b, s0Var.f7433a).exists()) {
                                        Integer valueOf2 = Integer.valueOf(r0Var4.f7424a);
                                        String str3 = q0Var3.f7416a;
                                        String str4 = s0Var.f7433a;
                                        Object[] objArr2 = new Object[3];
                                        objArr2[i13] = valueOf2;
                                        objArr2[i15] = str3;
                                        objArr2[i14] = str4;
                                        sVar.d("Found merge task for session %s with pack %s and slice %s.", objArr2);
                                        v0Var4 = new b1(r0Var4.f7424a, q0Var3.f7416a, r0Var4.f7425b, q0Var3.f7417b, s0Var.f7433a);
                                        break loop3;
                                    }
                                    arrayList2 = arrayList3;
                                    i10 = i14;
                                    i11 = i15;
                                    size3 = i24;
                                }
                            }
                        }
                        if (v0Var4 == null) {
                            int size5 = arrayList.size();
                            int i25 = i13;
                            loop5: while (true) {
                                if (i25 >= size5) {
                                    v0Var4 = null;
                                    break;
                                }
                                Object obj5 = arrayList.get(i25);
                                i25++;
                                r0 r0Var5 = (r0) obj5;
                                q0 q0Var4 = r0Var5.f7426c;
                                if (k0.d(q0Var4.f7419d)) {
                                    ArrayList arrayList4 = q0Var4.f7421f;
                                    int size6 = arrayList4.size();
                                    int i26 = i13;
                                    while (i26 < size6) {
                                        Object obj6 = arrayList4.get(i26);
                                        i26++;
                                        s0 s0Var2 = (s0) obj6;
                                        if (b(r0Var5, s0Var2)) {
                                            ArrayList arrayList5 = arrayList4;
                                            int i27 = size6;
                                            int i28 = size5;
                                            if (this.f7479b.i(q0Var4.f7416a, r0Var5.f7425b, q0Var4.f7417b, s0Var2.f7433a).exists()) {
                                                Integer valueOf3 = Integer.valueOf(r0Var5.f7424a);
                                                String str5 = q0Var4.f7416a;
                                                String str6 = s0Var2.f7433a;
                                                Object[] objArr3 = new Object[3];
                                                objArr3[i13] = valueOf3;
                                                objArr3[i15] = str5;
                                                objArr3[i14] = str6;
                                                sVar.d("Found verify task for session %s with pack %s and slice %s.", objArr3);
                                                v0Var4 = new r1(r0Var5.f7424a, q0Var4.f7416a, r0Var5.f7425b, q0Var4.f7417b, s0Var2.f7433a, s0Var2.f7434b);
                                                break loop5;
                                            }
                                            arrayList4 = arrayList5;
                                            size6 = i27;
                                            size5 = i28;
                                        }
                                    }
                                }
                            }
                            if (v0Var4 == null) {
                                int size7 = arrayList.size();
                                int i29 = i13;
                                loop7: while (true) {
                                    wVar = this.f7480c;
                                    if (i29 >= size7) {
                                        pVar = pVar2;
                                        i16 = 4;
                                        v0Var4 = null;
                                        break;
                                    }
                                    Object obj7 = arrayList.get(i29);
                                    i29++;
                                    r0 r0Var6 = (r0) obj7;
                                    q0 q0Var5 = r0Var6.f7426c;
                                    if (k0.d(q0Var5.f7419d)) {
                                        ArrayList arrayList6 = q0Var5.f7421f;
                                        int size8 = arrayList6.size();
                                        int i30 = i13;
                                        while (i30 < size8) {
                                            int i31 = i30 + 1;
                                            s0 s0Var3 = (s0) arrayList6.get(i30);
                                            int i32 = s0Var3.f7438f;
                                            int i33 = (i32 == i15 || i32 == i14) ? 1 : i13;
                                            String str7 = s0Var3.f7433a;
                                            i16 = 4;
                                            ArrayList arrayList7 = s0Var3.f7436d;
                                            if (i33 == 0) {
                                                p pVar3 = this.f7479b;
                                                q0 q0Var6 = r0Var6.f7426c;
                                                pVar = pVar2;
                                                ArrayList arrayList8 = arrayList6;
                                                int i34 = size8;
                                                try {
                                                    i17 = new o1(pVar3, q0Var6.f7416a, r0Var6.f7425b, q0Var6.f7417b, s0Var3.f7433a).a();
                                                } catch (IOException e8) {
                                                    Object[] objArr4 = new Object[1];
                                                    objArr4[i13] = e8;
                                                    sVar.f("Slice checkpoint corrupt, restarting extraction. %s", objArr4);
                                                    i17 = i13;
                                                }
                                                if (i17 != -1 && ((p0) arrayList7.get(i17)).f7413a) {
                                                    Integer valueOf4 = Integer.valueOf(s0Var3.f7437e);
                                                    Integer valueOf5 = Integer.valueOf(r0Var6.f7424a);
                                                    String str8 = r0Var6.f7426c.f7416a;
                                                    Integer valueOf6 = Integer.valueOf(i17);
                                                    Object[] objArr5 = new Object[5];
                                                    objArr5[i13] = valueOf4;
                                                    objArr5[1] = valueOf5;
                                                    objArr5[2] = str8;
                                                    objArr5[3] = str7;
                                                    objArr5[4] = valueOf6;
                                                    sVar.d("Found extraction task using compression format %s for session %s, pack %s, slice %s, chunk %s.", objArr5);
                                                    ParcelFileDescriptor.AutoCloseInputStream a10 = wVar.a(r0Var6.f7426c.f7416a, str7, r0Var6.f7424a, i17);
                                                    int i35 = r0Var6.f7424a;
                                                    q0 q0Var7 = r0Var6.f7426c;
                                                    String str9 = q0Var7.f7416a;
                                                    int i36 = r0Var6.f7425b;
                                                    long j10 = q0Var7.f7417b;
                                                    String str10 = q0Var7.f7418c;
                                                    String str11 = s0Var3.f7433a;
                                                    int i37 = s0Var3.f7437e;
                                                    int size9 = arrayList7.size();
                                                    q0 q0Var8 = r0Var6.f7426c;
                                                    v0Var4 = new z(i35, str9, i36, j10, str10, str11, i37, i17, size9, q0Var8.f7420e, q0Var8.f7419d, a10);
                                                    break loop7;
                                                }
                                                i30 = i31;
                                                pVar2 = pVar;
                                                arrayList6 = arrayList8;
                                                size8 = i34;
                                            } else {
                                                i30 = i31;
                                            }
                                            i14 = 2;
                                            i15 = 1;
                                        }
                                    }
                                    i14 = 2;
                                    i15 = 1;
                                }
                                if (v0Var4 == null) {
                                    int size10 = arrayList.size();
                                    int i38 = i13;
                                    loop9: while (true) {
                                        if (i38 >= size10) {
                                            k1Var = null;
                                            break;
                                        }
                                        int i39 = i38 + 1;
                                        r0 r0Var7 = (r0) arrayList.get(i38);
                                        q0 q0Var9 = r0Var7.f7426c;
                                        if (k0.d(q0Var9.f7419d)) {
                                            ArrayList arrayList9 = q0Var9.f7421f;
                                            int size11 = arrayList9.size();
                                            int i40 = i13;
                                            while (i40 < size11) {
                                                int i41 = i40 + 1;
                                                s0 s0Var4 = (s0) arrayList9.get(i40);
                                                int i42 = s0Var4.f7438f;
                                                int i43 = (i42 == 1 || i42 == 2) ? 1 : i13;
                                                String str12 = s0Var4.f7433a;
                                                if (i43 != 0) {
                                                    if (((p0) s0Var4.f7436d.get(i13)).f7413a && !b(r0Var7, s0Var4)) {
                                                        Integer valueOf7 = Integer.valueOf(s0Var4.f7438f);
                                                        Integer valueOf8 = Integer.valueOf(r0Var7.f7424a);
                                                        String str13 = r0Var7.f7426c.f7416a;
                                                        Object[] objArr6 = new Object[i16];
                                                        objArr6[0] = valueOf7;
                                                        objArr6[1] = valueOf8;
                                                        objArr6[2] = str13;
                                                        objArr6[3] = str12;
                                                        sVar.d("Found patch slice task using patch format %s for session %s, pack %s, slice %s.", objArr6);
                                                        ParcelFileDescriptor.AutoCloseInputStream a11 = wVar.a(r0Var7.f7426c.f7416a, str12, r0Var7.f7424a, 0);
                                                        int i44 = r0Var7.f7424a;
                                                        String str14 = r0Var7.f7426c.f7416a;
                                                        int b2 = (int) p.b(new File(pVar.d(), str14));
                                                        String str15 = r0Var7.f7426c.f7416a;
                                                        k1Var = new k1(i44, str14, b2, p.b(new File(new File(pVar.d(), str15), String.valueOf((int) p.b(new File(pVar.d(), str15))))), r0Var7.f7425b, r0Var7.f7426c.f7417b, s0Var4.f7438f, s0Var4.f7433a, s0Var4.f7435c, a11);
                                                        break loop9;
                                                    }
                                                    i13 = 0;
                                                }
                                                i40 = i41;
                                            }
                                        }
                                        i38 = i39;
                                    }
                                    if (k1Var != null) {
                                        u0Var.f7461d.unlock();
                                        return k1Var;
                                    }
                                }
                            }
                        }
                        v0Var2 = v0Var4;
                    } else {
                        v0Var2 = v0Var3;
                    }
                } else {
                    v0Var2 = v0Var;
                }
                return v0Var2;
            }
            v0Var2 = null;
            return v0Var2;
        } finally {
            u0Var.f7461d.unlock();
        }
    }

    public final boolean b(r0 r0Var, s0 s0Var) {
        q0 q0Var = r0Var.f7426c;
        String str = q0Var.f7416a;
        long j10 = q0Var.f7417b;
        int i10 = r0Var.f7425b;
        String str2 = s0Var.f7433a;
        androidx.emoji2.text.s sVar = o1.f7403h;
        p pVar = this.f7479b;
        pVar.getClass();
        File file = new File(new File(new File(new File(pVar.c(i10, str, j10), "_slices"), "_metadata"), str2), "checkpoint.dat");
        if (file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    Properties properties = new Properties();
                    properties.load(fileInputStream);
                    fileInputStream.close();
                    if (properties.getProperty("fileStatus") == null) {
                        sVar.f("Slice checkpoint file corrupt while checking if extraction finished.", new Object[0]);
                        return false;
                    }
                    if (Integer.parseInt(properties.getProperty("fileStatus")) == 4) {
                        return true;
                    }
                } finally {
                }
            } catch (IOException e7) {
                sVar.f("Could not read checkpoint while checking if extraction finished. %s", e7);
                return false;
            }
        }
        return false;
    }
}
