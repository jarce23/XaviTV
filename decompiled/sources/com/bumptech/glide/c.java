package com.bumptech.glide;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.EdgeEffect;
import d9.y;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;
import l4.v;
import m0.z0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class c implements androidx.leanback.transition.e {

    /* renamed from: o, reason: collision with root package name */
    public static boolean f2995o = true;

    public static void B(ViewGroup viewGroup, boolean z10) {
        if (Build.VERSION.SDK_INT >= 29) {
            v.b(viewGroup, z10);
        } else if (f2995o) {
            try {
                v.b(viewGroup, z10);
            } catch (NoSuchMethodError unused) {
                f2995o = false;
            }
        }
    }

    public static String C(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt >= 'A' && charAt <= 'Z') {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (c10 >= 'A' && c10 <= 'Z') {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static String D(String str) {
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt >= 'a' && charAt <= 'z') {
                char[] charArray = str.toCharArray();
                while (i10 < length) {
                    char c10 = charArray[i10];
                    if (c10 >= 'a' && c10 <= 'z') {
                        charArray[i10] = (char) (c10 ^ ' ');
                    }
                    i10++;
                }
                return String.valueOf(charArray);
            }
            i10++;
        }
        return str;
    }

    public static void E(int i10, Object[] objArr) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (objArr[i11] == null) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(i11).length() + 9);
                sb2.append("at index ");
                sb2.append(i11);
                throw new NullPointerException(sb2.toString());
            }
        }
    }

    public static void h(int i10) {
        if (2 > i10 || i10 >= 37) {
            StringBuilder f10 = r.a.f("radix ", i10, " was not in valid range ");
            f10.append(new db.c(2, 36, 1));
            throw new IllegalArgumentException(f10.toString());
        }
    }

    public static final boolean i(char c10, char c11, boolean z10) {
        if (c10 == c11) {
            return true;
        }
        if (!z10) {
            return false;
        }
        char upperCase = Character.toUpperCase(c10);
        char upperCase2 = Character.toUpperCase(c11);
        return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
    }

    /*  JADX ERROR: NullPointerException in pass: LoopRegionVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.nodes.InsnNode.rebindArgs(InsnNode.java:493)
        	at jadx.core.dex.instructions.mods.TernaryInsn.rebindArgs(TernaryInsn.java:92)
        	at jadx.core.dex.visitors.regions.TernaryMod.replaceWithTernary(TernaryMod.java:340)
        	at jadx.core.dex.visitors.regions.TernaryMod.processOneBranchTernary(TernaryMod.java:272)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:77)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.LoopRegionVisitor.visit(LoopRegionVisitor.java:57)
        */
    public static boolean j(java.lang.String r6, java.lang.String r7) {
        /*
            int r0 = r6.length()
            if (r6 != r7) goto L7
            goto L31
        L7:
            int r1 = r7.length()
            r2 = 0
            if (r0 == r1) goto Lf
            goto L30
        Lf:
            r1 = r2
        L10:
            if (r1 >= r0) goto L31
            char r3 = r6.charAt(r1)
            char r4 = r7.charAt(r1)
            if (r3 != r4) goto L1d
            goto L2d
        L1d:
            r3 = r3 | 32
            int r3 = r3 + (-97)
            char r3 = (char) r3
            r5 = 26
            if (r3 >= r5) goto L30
            r4 = r4 | 32
            int r4 = r4 + (-97)
            char r4 = (char) r4
            if (r3 != r4) goto L30
        L2d:
            int r1 = r1 + 1
            goto L10
        L30:
            return r2
        L31:
            r6 = 1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.j(java.lang.String, java.lang.String):boolean");
    }

    public static ColorStateList k(Drawable drawable) {
        ColorStateList colorStateList;
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !z0.t(drawable)) {
            return null;
        }
        colorStateList = z0.b(drawable).getColorStateList();
        return colorStateList;
    }

    public static float l(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return p0.d.b(edgeEffect);
        }
        return 0.0f;
    }

    public static final boolean q(char c10) {
        return Character.isWhitespace(c10) || Character.isSpaceChar(c10);
    }

    public static float r(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 31) {
            return p0.d.c(edgeEffect, f10, f11);
        }
        p0.c.a(edgeEffect, f10, f11);
        return f10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x003c, code lost:
    
        if (r3 != 1918990112) goto L4;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v15, types: [j2.e] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList s(l1.t r30) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.c.s(l1.t):java.util.ArrayList");
    }

    public static final List v(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        na.c g = f.g();
        while (cursor.moveToNext()) {
            int i10 = cursor.getInt(columnIndex);
            int i11 = cursor.getInt(columnIndex2);
            String string = cursor.getString(columnIndex3);
            za.h.d("cursor.getString(fromColumnIndex)", string);
            String string2 = cursor.getString(columnIndex4);
            za.h.d("cursor.getString(toColumnIndex)", string2);
            g.add(new e4.c(string, string2, i10, i11));
        }
        na.c b2 = f.b(g);
        za.h.e("<this>", b2);
        if (b2.f() <= 1) {
            return ma.j.J(b2);
        }
        Object[] array = b2.toArray(new Comparable[0]);
        Comparable[] comparableArr = (Comparable[]) array;
        if (comparableArr.length > 1) {
            Arrays.sort(comparableArr);
        }
        return ma.i.B(array);
    }

    public static final e4.d w(h4.c cVar, String str, boolean z10) {
        Cursor P = cVar.P("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = P.getColumnIndex("seqno");
            int columnIndex2 = P.getColumnIndex("cid");
            int columnIndex3 = P.getColumnIndex("name");
            int columnIndex4 = P.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (P.moveToNext()) {
                    if (P.getInt(columnIndex2) >= 0) {
                        int i10 = P.getInt(columnIndex);
                        String string = P.getString(columnIndex3);
                        String str2 = P.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        Integer valueOf = Integer.valueOf(i10);
                        za.h.d("columnName", string);
                        treeMap.put(valueOf, string);
                        treeMap2.put(Integer.valueOf(i10), str2);
                    }
                }
                Collection values = treeMap.values();
                za.h.d("columnsMap.values", values);
                List J = ma.j.J(values);
                Collection values2 = treeMap2.values();
                za.h.d("ordersMap.values", values2);
                e4.d dVar = new e4.d(str, z10, J, ma.j.J(values2));
                P.close();
                return dVar;
            }
            P.close();
            return null;
        } finally {
        }
    }

    public static TypedValue x(Context context, int i10) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean y(Context context, int i10, boolean z10) {
        TypedValue x6 = x(context, i10);
        return (x6 == null || x6.type != 18) ? z10 : x6.data != 0;
    }

    public static TypedValue z(int i10, Context context, String str) {
        TypedValue x6 = x(context, i10);
        if (x6 != null) {
            return x6;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i10)));
    }

    public abstract void A(y yVar, float f10);

    @Override // androidx.leanback.transition.e
    public float c(View view) {
        return view.getTranslationY();
    }

    @Override // androidx.leanback.transition.e
    public Property d() {
        return View.TRANSLATION_Y;
    }

    public abstract boolean e(r.h hVar, r.d dVar, r.d dVar2);

    public abstract boolean f(r.h hVar, Object obj, Object obj2);

    public abstract boolean g(r.h hVar, r.g gVar, r.g gVar2);

    public abstract int m(View view, ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float n(y yVar);

    public abstract int o();

    public abstract ViewPropertyAnimator p(View view, int i10);

    public abstract void t(r.g gVar, r.g gVar2);

    public abstract void u(r.g gVar, Thread thread);
}
