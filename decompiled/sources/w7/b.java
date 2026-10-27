package w7;

import android.R;
import android.animation.TimeInterpolator;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import b0.d;
import d0.e;
import j0.j;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import m0.q0;
import n3.g;
import v1.f;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b implements q0, f {

    /* renamed from: o, reason: collision with root package name */
    public static Context f13137o;

    /* renamed from: p, reason: collision with root package name */
    public static Boolean f13138p;

    public b() {
        new ConcurrentHashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object f(kb.s r4, u4.b r5, ra.c r6) {
        /*
            boolean r0 = r6 instanceof kb.p
            if (r0 == 0) goto L13
            r0 = r6
            kb.p r0 = (kb.p) r0
            int r1 = r0.f7921q
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7921q = r1
            goto L18
        L13:
            kb.p r0 = new kb.p
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f7920p
            qa.a r1 = qa.a.f10374o
            int r2 = r0.f7921q
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            u4.b r5 = r0.f7919o
            com.google.android.gms.internal.cast.n.t(r6)     // Catch: java.lang.Throwable -> L29
            goto L64
        L29:
            r4 = move-exception
            goto L6a
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            com.google.android.gms.internal.cast.n.t(r6)
            pa.i r6 = r0.getContext()
            ib.r r2 = ib.r.f6589p
            pa.g r6 = r6.s(r2)
            if (r6 != r4) goto L6e
            r0.f7919o = r5     // Catch: java.lang.Throwable -> L29
            r0.f7921q = r3     // Catch: java.lang.Throwable -> L29
            ib.f r6 = new ib.f     // Catch: java.lang.Throwable -> L29
            pa.d r0 = a.a.m(r0)     // Catch: java.lang.Throwable -> L29
            r6.<init>(r3, r0)     // Catch: java.lang.Throwable -> L29
            r6.o()     // Catch: java.lang.Throwable -> L29
            kb.q r0 = new kb.q     // Catch: java.lang.Throwable -> L29
            r2 = 0
            r0.<init>(r2, r6)     // Catch: java.lang.Throwable -> L29
            kb.r r4 = (kb.r) r4     // Catch: java.lang.Throwable -> L29
            r4.Q(r0)     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.n()     // Catch: java.lang.Throwable -> L29
            if (r4 != r1) goto L64
            return r1
        L64:
            r5.invoke()
            la.i r4 = la.i.f8335a
            return r4
        L6a:
            r5.invoke()
            throw r4
        L6e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w7.b.f(kb.s, u4.b, ra.c):java.lang.Object");
    }

    public static int g(Context context, String str) {
        int noteProxyOpNoThrow;
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) != -1) {
            String permissionToOp = AppOpsManager.permissionToOp(str);
            if (permissionToOp != null) {
                if (packageName == null) {
                    String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                    if (packagesForUid != null && packagesForUid.length > 0) {
                        packageName = packagesForUid[0];
                    }
                }
                int myUid2 = Process.myUid();
                String packageName2 = context.getPackageName();
                if (myUid2 != myUid || !Objects.equals(packageName2, packageName)) {
                    noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName);
                } else if (Build.VERSION.SDK_INT >= 29) {
                    AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService(AppOpsManager.class);
                    noteProxyOpNoThrow = appOpsManager == null ? 1 : appOpsManager.checkOpNoThrow(permissionToOp, Binder.getCallingUid(), packageName);
                    if (noteProxyOpNoThrow == 0) {
                        noteProxyOpNoThrow = appOpsManager != null ? appOpsManager.checkOpNoThrow(permissionToOp, myUid, d.a(context)) : 1;
                    }
                } else {
                    noteProxyOpNoThrow = ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName);
                }
                if (noteProxyOpNoThrow != 0) {
                    return -2;
                }
            }
            return 0;
        }
        return -1;
    }

    public static int h(int i10, int i11) {
        long j10 = i10 + i11;
        int i12 = (int) j10;
        if (j10 == ((long) i12)) {
            return i12;
        }
        throw new ArithmeticException("overflow: checkedAdd(" + i10 + ", " + i11 + ")");
    }

    public static float q(int i10, String[] strArr) {
        float parseFloat = Float.parseFloat(strArr[i10]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static boolean r(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean s(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static g t(g gVar, String[] strArr, Map map) {
        int i10 = 0;
        if (gVar == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return (g) map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                g gVar2 = new g();
                int length = strArr.length;
                while (i10 < length) {
                    gVar2.a((g) map.get(strArr[i10]));
                    i10++;
                }
                return gVar2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                gVar.a((g) map.get(strArr[0]));
                return gVar;
            }
            if (strArr != null && strArr.length > 1) {
                int length2 = strArr.length;
                while (i10 < length2) {
                    gVar.a((g) map.get(strArr[i10]));
                    i10++;
                }
            }
        }
        return gVar;
    }

    public static int u(Context context, int i10, int i11) {
        TypedValue x6 = com.bumptech.glide.c.x(context, i10);
        return (x6 == null || x6.type != 16) ? i11 : x6.data;
    }

    public static TimeInterpolator v(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String valueOf = String.valueOf(typedValue.string);
        if (!r(valueOf, "cubic-bezier") && !r(valueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (!r(valueOf, "cubic-bezier")) {
            if (r(valueOf, "path")) {
                return new PathInterpolator(n4.a.j(valueOf.substring(5, valueOf.length() - 1)));
            }
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
        }
        String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
        if (split.length == 4) {
            return new PathInterpolator(q(0, split), q(1, split), q(2, split), q(3, split));
        }
        throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
    }

    public static int x(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i10});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int z(int i10) {
        return (int) (Integer.rotateLeft((int) (i10 * (-862048943)), 15) * 461845907);
    }

    public abstract Typeface i(Context context, e eVar, Resources resources, int i10);

    public abstract Typeface j(Context context, j[] jVarArr, int i10);

    public Typeface k(Context context, List list, int i10) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface l(Context context, InputStream inputStream) {
        File A = x4.f.A(context);
        if (A == null) {
            return null;
        }
        try {
            if (x4.f.l(A, inputStream)) {
                return Typeface.createFromFile(A.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            A.delete();
        }
    }

    public Typeface o(Context context, Resources resources, int i10, String str, int i11) {
        File A = x4.f.A(context);
        if (A == null) {
            return null;
        }
        try {
            if (x4.f.k(A, resources, i10)) {
                return Typeface.createFromFile(A.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            A.delete();
        }
    }

    public j p(j[] jVarArr, int i10) {
        new d9.f(16);
        int i11 = (i10 & 1) == 0 ? 400 : 700;
        boolean z10 = (i10 & 2) != 0;
        j jVar = null;
        int i12 = Integer.MAX_VALUE;
        for (j jVar2 : jVarArr) {
            int abs = (Math.abs(jVar2.f6932c - i11) * 2) + (jVar2.f6933d == z10 ? 0 : 1);
            if (jVar == null || i12 > abs) {
                jVar = jVar2;
                i12 = abs;
            }
        }
        return jVar;
    }

    public abstract void y(ArrayList arrayList);

    @Override // m0.q0
    public void d() {
    }

    @Override // m0.q0
    public void e() {
    }
}
