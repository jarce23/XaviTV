package n4;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import com.google.android.gms.internal.cast.i4;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.WeakHashMap;
import kb.e;
import kb.h;
import kb.i;
import kb.o;
import m.h2;
import m0.j0;
import m0.k0;
import ma.g;
import ma.k;
import o4.r;
import org.chromium.net.R;
import p4.m;
import x4.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: p, reason: collision with root package name */
    public static boolean f9178p = false;

    /* renamed from: q, reason: collision with root package name */
    public static Method f9179q = null;

    /* renamed from: r, reason: collision with root package name */
    public static boolean f9180r = false;

    /* renamed from: s, reason: collision with root package name */
    public static Field f9181s;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f9182o;

    public /* synthetic */ a(int i10) {
        this.f9182o = i10;
    }

    public static e b(int i10, kb.a aVar, int i11) {
        if ((i11 & 2) != 0) {
            aVar = kb.a.f7868o;
        }
        if (i10 == -2) {
            if (aVar != kb.a.f7868o) {
                return new o(1, aVar);
            }
            i.f7912f.getClass();
            return new e(h.f7911b);
        }
        if (i10 != -1) {
            return i10 != 0 ? i10 != Integer.MAX_VALUE ? aVar == kb.a.f7868o ? new e(i10) : new o(i10, aVar) : new e(Integer.MAX_VALUE) : aVar == kb.a.f7868o ? new e(0) : new o(1, aVar);
        }
        if (aVar == kb.a.f7868o) {
            return new o(1, kb.a.f7869p);
        }
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    }

    public static boolean c(e0.e[] eVarArr, e0.e[] eVarArr2) {
        if (eVarArr == null || eVarArr2 == null || eVarArr.length != eVarArr2.length) {
            return false;
        }
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            e0.e eVar = eVarArr[i10];
            char c10 = eVar.f4390a;
            e0.e eVar2 = eVarArr2[i10];
            if (c10 != eVar2.f4390a || eVar.f4391b.length != eVar2.f4391b.length) {
                return false;
            }
        }
        return true;
    }

    public static final void d(WorkDatabase workDatabase, o4.a aVar, m mVar) {
        int i10;
        za.h.e("workDatabase", workDatabase);
        za.h.e("configuration", aVar);
        za.h.e("continuation", mVar);
        if (Build.VERSION.SDK_INT < 24) {
            return;
        }
        ArrayList arrayList = new ArrayList(new g(new m[]{mVar}, true));
        int i11 = 0;
        while (!arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            List list = ((m) arrayList.remove(k.w(arrayList))).f9944t;
            za.h.d("current.work", list);
            if (list.isEmpty()) {
                i10 = 0;
            } else {
                Iterator it = list.iterator();
                i10 = 0;
                while (it.hasNext()) {
                    if (((r) it.next()).f9515b.f13577j.a() && (i10 = i10 + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i11 += i10;
        }
        if (i11 == 0) {
            return;
        }
        p t3 = workDatabase.t();
        t3.getClass();
        c4.m a10 = c4.m.a(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        WorkDatabase_Impl workDatabase_Impl = t3.f13591a;
        workDatabase_Impl.b();
        Cursor m10 = workDatabase_Impl.m(a10);
        try {
            int i12 = m10.moveToFirst() ? m10.getInt(0) : 0;
            m10.close();
            a10.s();
            int i13 = aVar.f9475c;
            if (i12 + i11 > i13) {
                throw new IllegalArgumentException(r.a.d(r.a.g("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ", i13, ";\nalready enqueued count: ", i12, ";\ncurrent enqueue operation count: "), i11, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
            }
        } catch (Throwable th) {
            m10.close();
            a10.s();
            throw th;
        }
    }

    public static int e(Context context, String str) {
        boolean z10;
        if (str == null) {
            throw new NullPointerException("permission must be non-null");
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        b0.p pVar = new b0.p(context);
        if (i10 >= 24) {
            z10 = b0.k.a(pVar.f2163a);
        } else {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i11 = applicationInfo.uid;
            try {
                Class<?> cls = Class.forName(AppOpsManager.class.getName());
                Class<?> cls2 = Integer.TYPE;
                Method method = cls.getMethod("checkOpNoThrow", cls2, cls2, String.class);
                Integer num = (Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
                num.getClass();
                if (((Integer) method.invoke(appOpsManager, num, Integer.valueOf(i11), packageName)).intValue() != 0) {
                    z10 = false;
                }
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            }
            z10 = true;
        }
        return z10 ? 0 : -1;
    }

    public static float[] h(float[] fArr, int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (length < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int min = Math.min(i10, length);
        float[] fArr2 = new float[i10];
        System.arraycopy(fArr, 0, fArr2, 0, min);
        return fArr2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0096 A[Catch: NumberFormatException -> 0x00aa, LOOP:3: B:25:0x0068->B:35:0x0096, LOOP_END, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b1 A[Catch: NumberFormatException -> 0x00aa, TryCatch #0 {NumberFormatException -> 0x00aa, blocks: (B:22:0x0054, B:25:0x0068, B:27:0x006e, B:31:0x007a, B:35:0x0096, B:39:0x009c, B:44:0x00b1, B:56:0x00b4), top: B:21:0x0054 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static e0.e[] i(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.a.i(java.lang.String):e0.e[]");
    }

    public static Path j(String str) {
        Path path = new Path();
        try {
            e0.e.b(i(str), path);
            return path;
        } catch (RuntimeException e7) {
            throw new RuntimeException("Error in parsing ".concat(str), e7);
        }
    }

    public static e0.e[] k(e0.e[] eVarArr) {
        e0.e[] eVarArr2 = new e0.e[eVarArr.length];
        for (int i10 = 0; i10 < eVarArr.length; i10++) {
            eVarArr2[i10] = new e0.e(eVarArr[i10]);
        }
        return eVarArr2;
    }

    public static boolean l(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = k0.f8683a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = j0.f8676d;
        j0 j0Var = (j0) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (j0Var == null) {
            j0Var = new j0();
            j0Var.f8677a = null;
            j0Var.f8678b = null;
            j0Var.f8679c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, j0Var);
        }
        WeakReference weakReference2 = j0Var.f8679c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        j0Var.f8679c = new WeakReference(keyEvent);
        if (j0Var.f8678b == null) {
            j0Var.f8678b = new SparseArray();
        }
        SparseArray sparseArray = j0Var.f8678b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        throw android.support.v4.media.d.k(size, arrayList);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m(m0.i r7, android.view.View r8, android.view.Window.Callback r9, android.view.KeyEvent r10) {
        /*
            r0 = 0
            if (r7 != 0) goto L5
            goto Le4
        L5:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 28
            if (r1 < r2) goto L10
            boolean r7 = r7.c(r10)
            return r7
        L10:
            boolean r1 = r9 instanceof android.app.Activity
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L82
            android.app.Activity r9 = (android.app.Activity) r9
            r9.onUserInteraction()
            android.view.Window r7 = r9.getWindow()
            r8 = 8
            boolean r8 = r7.hasFeature(r8)
            if (r8 == 0) goto L65
            android.app.ActionBar r8 = r9.getActionBar()
            int r1 = r10.getKeyCode()
            r4 = 82
            if (r1 != r4) goto L65
            if (r8 == 0) goto L65
            boolean r1 = n4.a.f9178p
            if (r1 != 0) goto L4d
            java.lang.Class r1 = r8.getClass()     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.String r4 = "onMenuKeyEvent"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.Class<android.view.KeyEvent> r6 = android.view.KeyEvent.class
            r5[r0] = r6     // Catch: java.lang.NoSuchMethodException -> L4b
            java.lang.reflect.Method r1 = r1.getMethod(r4, r5)     // Catch: java.lang.NoSuchMethodException -> L4b
            n4.a.f9179q = r1     // Catch: java.lang.NoSuchMethodException -> L4b
        L4b:
            n4.a.f9178p = r3
        L4d:
            java.lang.reflect.Method r1 = n4.a.f9179q
            if (r1 == 0) goto L62
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L62
            r4[r0] = r10     // Catch: java.lang.Throwable -> L62
            java.lang.Object r8 = r1.invoke(r8, r4)     // Catch: java.lang.Throwable -> L62
            if (r8 != 0) goto L5c
            goto L62
        L5c:
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch: java.lang.Throwable -> L62
            boolean r0 = r8.booleanValue()     // Catch: java.lang.Throwable -> L62
        L62:
            if (r0 == 0) goto L65
            goto L81
        L65:
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto L6c
            goto L81
        L6c:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = m0.k0.c(r7, r10)
            if (r8 == 0) goto L77
            goto L81
        L77:
            if (r7 == 0) goto L7d
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        L7d:
            boolean r3 = r10.dispatch(r9, r2, r9)
        L81:
            return r3
        L82:
            boolean r1 = r9 instanceof android.app.Dialog
            if (r1 == 0) goto Ld5
            android.app.Dialog r9 = (android.app.Dialog) r9
            boolean r7 = n4.a.f9180r
            if (r7 != 0) goto L9b
            java.lang.Class<android.app.Dialog> r7 = android.app.Dialog.class
            java.lang.String r8 = "mOnKeyListener"
            java.lang.reflect.Field r7 = r7.getDeclaredField(r8)     // Catch: java.lang.NoSuchFieldException -> L99
            n4.a.f9181s = r7     // Catch: java.lang.NoSuchFieldException -> L99
            r7.setAccessible(r3)     // Catch: java.lang.NoSuchFieldException -> L99
        L99:
            n4.a.f9180r = r3
        L9b:
            java.lang.reflect.Field r7 = n4.a.f9181s
            if (r7 == 0) goto La6
            java.lang.Object r7 = r7.get(r9)     // Catch: java.lang.IllegalAccessException -> La6
            android.content.DialogInterface$OnKeyListener r7 = (android.content.DialogInterface.OnKeyListener) r7     // Catch: java.lang.IllegalAccessException -> La6
            goto La7
        La6:
            r7 = r2
        La7:
            if (r7 == 0) goto Lb4
            int r8 = r10.getKeyCode()
            boolean r7 = r7.onKey(r9, r8, r10)
            if (r7 == 0) goto Lb4
            goto Ld4
        Lb4:
            android.view.Window r7 = r9.getWindow()
            boolean r8 = r7.superDispatchKeyEvent(r10)
            if (r8 == 0) goto Lbf
            goto Ld4
        Lbf:
            android.view.View r7 = r7.getDecorView()
            boolean r8 = m0.k0.c(r7, r10)
            if (r8 == 0) goto Lca
            goto Ld4
        Lca:
            if (r7 == 0) goto Ld0
            android.view.KeyEvent$DispatcherState r2 = r7.getKeyDispatcherState()
        Ld0:
            boolean r3 = r10.dispatch(r9, r2, r9)
        Ld4:
            return r3
        Ld5:
            if (r8 == 0) goto Ldd
            boolean r8 = m0.k0.c(r8, r10)
            if (r8 != 0) goto Le3
        Ldd:
            boolean r7 = r7.c(r10)
            if (r7 == 0) goto Le4
        Le3:
            return r3
        Le4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.a.m(m0.i, android.view.View, android.view.Window$Callback, android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0046, code lost:
    
        if (r5.f3975c == r8.hashCode()) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.content.res.ColorStateList n(android.content.Context r8, int r9) {
        /*
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.Resources$Theme r8 = r8.getTheme()
            d0.i r1 = new d0.i
            r1.<init>(r0, r8)
            java.lang.Object r2 = d0.l.f3983c
            monitor-enter(r2)
            java.util.WeakHashMap r3 = d0.l.f3982b     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r3 = r3.get(r1)     // Catch: java.lang.Throwable -> L3c
            android.util.SparseArray r3 = (android.util.SparseArray) r3     // Catch: java.lang.Throwable -> L3c
            r4 = 0
            if (r3 == 0) goto L4f
            int r5 = r3.size()     // Catch: java.lang.Throwable -> L3c
            if (r5 <= 0) goto L4f
            java.lang.Object r5 = r3.get(r9)     // Catch: java.lang.Throwable -> L3c
            d0.h r5 = (d0.h) r5     // Catch: java.lang.Throwable -> L3c
            if (r5 == 0) goto L4f
            android.content.res.Configuration r6 = r5.f3974b     // Catch: java.lang.Throwable -> L3c
            android.content.res.Configuration r7 = r0.getConfiguration()     // Catch: java.lang.Throwable -> L3c
            boolean r6 = r6.equals(r7)     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L4c
            if (r8 != 0) goto L3e
            int r6 = r5.f3975c     // Catch: java.lang.Throwable -> L3c
            if (r6 == 0) goto L48
            goto L3e
        L3c:
            r8 = move-exception
            goto L91
        L3e:
            if (r8 == 0) goto L4c
            int r6 = r5.f3975c     // Catch: java.lang.Throwable -> L3c
            int r7 = r8.hashCode()     // Catch: java.lang.Throwable -> L3c
            if (r6 != r7) goto L4c
        L48:
            android.content.res.ColorStateList r3 = r5.f3973a     // Catch: java.lang.Throwable -> L3c
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            goto L51
        L4c:
            r3.remove(r9)     // Catch: java.lang.Throwable -> L3c
        L4f:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            r3 = r4
        L51:
            if (r3 == 0) goto L54
            return r3
        L54:
            java.lang.ThreadLocal r2 = d0.l.f3981a
            java.lang.Object r3 = r2.get()
            android.util.TypedValue r3 = (android.util.TypedValue) r3
            if (r3 != 0) goto L66
            android.util.TypedValue r3 = new android.util.TypedValue
            r3.<init>()
            r2.set(r3)
        L66:
            r2 = 1
            r0.getValue(r9, r3, r2)
            int r2 = r3.type
            r3 = 28
            if (r2 < r3) goto L75
            r3 = 31
            if (r2 > r3) goto L75
            goto L86
        L75:
            android.content.res.XmlResourceParser r2 = r0.getXml(r9)
            android.content.res.ColorStateList r4 = d0.c.a(r0, r2, r8)     // Catch: java.lang.Exception -> L7e
            goto L86
        L7e:
            r2 = move-exception
            java.lang.String r3 = "ResourcesCompat"
            java.lang.String r5 = "Failed to inflate ColorStateList, leaving it to the framework"
            android.util.Log.w(r3, r5, r2)
        L86:
            if (r4 == 0) goto L8c
            d0.l.a(r1, r9, r4, r8)
            goto L90
        L8c:
            android.content.res.ColorStateList r4 = r0.getColorStateList(r9, r8)
        L90:
            return r4
        L91:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L3c
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.a.n(android.content.Context, int):android.content.res.ColorStateList");
    }

    public static Drawable o(Context context, int i10) {
        return h2.d().f(context, i10);
    }

    public static long q(double d6) {
        if (!u(d6)) {
            throw new IllegalArgumentException("not a normal value");
        }
        int exponent = Math.getExponent(d6);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d6) & 4503599627370495L;
        return exponent == -1023 ? doubleToRawLongBits << 1 : doubleToRawLongBits | 4503599627370496L;
    }

    public static boolean u(double d6) {
        return Math.getExponent(d6) <= 1023;
    }

    public static u0.b z(MappedByteBuffer mappedByteBuffer) {
        long j10;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i10 = duplicate.getShort() & 65535;
        if (i10 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        duplicate.position(duplicate.position() + 6);
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                j10 = -1;
                break;
            }
            int i12 = duplicate.getInt();
            duplicate.position(duplicate.position() + 4);
            j10 = duplicate.getInt() & 4294967295L;
            duplicate.position(duplicate.position() + 4);
            if (1835365473 == i12) {
                break;
            }
            i11++;
        }
        if (j10 != -1) {
            duplicate.position(duplicate.position() + ((int) (j10 - duplicate.position())));
            duplicate.position(duplicate.position() + 12);
            long j11 = duplicate.getInt() & 4294967295L;
            for (int i13 = 0; i13 < j11; i13++) {
                int i14 = duplicate.getInt();
                long j12 = duplicate.getInt() & 4294967295L;
                duplicate.getInt();
                if (1164798569 == i14 || 1701669481 == i14) {
                    duplicate.position((int) (j12 + j10));
                    u0.b bVar = new u0.b();
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int position = duplicate.position() + duplicate.getInt(duplicate.position());
                    bVar.f8748r = duplicate;
                    bVar.f8745o = position;
                    int i15 = position - duplicate.getInt(position);
                    bVar.f8746p = i15;
                    bVar.f8747q = ((ByteBuffer) bVar.f8748r).getShort(i15);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public abstract void A(boolean z10);

    public abstract void B(boolean z10);

    public abstract boolean C(View view, int i10);

    public abstract TransformationMethod D(TransformationMethod transformationMethod);

    public abstract int f(View view, int i10);

    public abstract int g(View view, int i10);

    public abstract InputFilter[] p(InputFilter[] inputFilterArr);

    public int r(View view) {
        return 0;
    }

    public int s() {
        return 0;
    }

    public abstract boolean t();

    public String toString() {
        switch (this.f9182o) {
            case 3:
                return ((i4) this).f3338t.toString();
            default:
                return super.toString();
        }
    }

    public abstract void w(int i10);

    public abstract void x(View view, int i10, int i11);

    public abstract void y(View view, float f10, float f11);

    public void v(View view, int i10) {
    }
}
