package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import androidx.leanback.transition.e;
import com.bumptech.glide.manager.t;
import com.google.android.gms.internal.cast.b4;
import com.google.android.gms.internal.cast.n;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.l;
import i8.b;
import i8.f;
import i8.g;
import i8.i;
import ib.j0;
import ib.k0;
import ib.v;
import j9.o0;
import j9.v1;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m5.j;
import pa.d;
import r7.r;
import ra.c;
import ya.p;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class a implements e {

    /* renamed from: o, reason: collision with root package name */
    public static SharedPreferences f0o = null;

    /* renamed from: p, reason: collision with root package name */
    public static volatile boolean f1p = true;

    /* renamed from: q, reason: collision with root package name */
    public static Boolean f2q;

    public static void a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static Object e(i iVar) {
        boolean z10;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && Objects.equals(myLooper.getThread().getName(), "GoogleApiHandler")) {
            throw new IllegalStateException("Must not be called on GoogleApiHandler thread.");
        }
        r.f("Task must not be null", iVar);
        synchronized (iVar.f6530b) {
            z10 = iVar.f6529a;
        }
        if (z10) {
            if (iVar.n()) {
                return iVar.l();
            }
            throw new ExecutionException(iVar.k());
        }
        h5.i iVar2 = new h5.i(7);
        Executor executor = i8.e.f6522b;
        iVar.j(executor, iVar2);
        ((t) iVar.f6532d).f(new g(executor, (b) iVar2));
        iVar.s();
        ((t) iVar.f6532d).f(new f(executor, iVar2));
        iVar.s();
        ((CountDownLatch) iVar2.f5610p).await();
        if (iVar.n()) {
            return iVar.l();
        }
        throw new ExecutionException(iVar.k());
    }

    public static ImageView.ScaleType i(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 5 ? i10 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static boolean j(String str, String str2) {
        h.e("current", str);
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i10 < str.length()) {
                    char charAt = str.charAt(i10);
                    int i13 = i12 + 1;
                    if (i12 == 0 && charAt != '(') {
                        break;
                    }
                    if (charAt != '(') {
                        if (charAt == ')' && i11 - 1 == 0 && i12 != str.length() - 1) {
                            break;
                        }
                    } else {
                        i11++;
                    }
                    i10++;
                    i12 = i13;
                } else if (i11 == 0) {
                    String substring = str.substring(1, str.length() - 1);
                    h.d("this as java.lang.String…ing(startIndex, endIndex)", substring);
                    return h.a(gb.i.o0(substring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static final sa.b k(Enum[] enumArr) {
        h.e("entries", enumArr);
        return new sa.b(enumArr);
    }

    public static Drawable l(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f1p) {
                return n(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e7) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e7;
            }
            return context2.getDrawable(i10);
        } catch (NoClassDefFoundError unused2) {
            f1p = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        Resources resources = context2.getResources();
        ThreadLocal threadLocal = l.f3981a;
        return resources.getDrawable(i10, theme);
    }

    public static d m(d dVar) {
        d<Object> intercepted;
        h.e("<this>", dVar);
        c cVar = dVar instanceof c ? (c) dVar : null;
        return (cVar == null || (intercepted = cVar.intercepted()) == null) ? dVar : intercepted;
    }

    public static Drawable n(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            k.c cVar = new k.c(context);
            cVar.f7523b = theme;
            cVar.a(theme.getResources().getConfiguration());
            context = cVar;
        }
        return n4.a.o(context, i10);
    }

    public static Integer o(String str) {
        if (str == null) {
            return null;
        }
        switch (str.hashCode()) {
            case -1118317585:
                return str.equals("REPEAT_ALL_AND_SHUFFLE") ? 3 : null;
            case -962896020:
                return str.equals("REPEAT_SINGLE") ? 2 : null;
            case 1645938909:
                return str.equals("REPEAT_ALL") ? 1 : null;
            case 1645952171:
                return str.equals("REPEAT_OFF") ? 0 : null;
            default:
                return null;
        }
    }

    public static j p(Context context) {
        x4.c cVar = new x4.c(new v1(6));
        Context applicationContext = context.getApplicationContext();
        x4.l lVar = new x4.l();
        lVar.f13562p = applicationContext;
        lVar.f13561o = null;
        j jVar = new j(new o0(lVar), cVar);
        m5.c cVar2 = jVar.f8993i;
        if (cVar2 != null) {
            cVar2.f8962s = true;
            cVar2.interrupt();
        }
        for (m5.f fVar : jVar.f8992h) {
            if (fVar != null) {
                fVar.f8970s = true;
                fVar.interrupt();
            }
        }
        m5.c cVar3 = new m5.c(jVar.f8988c, jVar.f8989d, jVar.f8990e, jVar.g);
        jVar.f8993i = cVar3;
        cVar3.start();
        for (int i10 = 0; i10 < jVar.f8992h.length; i10++) {
            m5.f fVar2 = new m5.f(jVar.f8989d, jVar.f8991f, jVar.f8990e, jVar.g);
            jVar.f8992h[i10] = fVar2;
            fVar2.start();
        }
        return jVar;
    }

    public static void s(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = drawable.mutate();
        mutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public static void t(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z10 = onLongClickListener != null;
        boolean z11 = hasOnClickListeners || z10;
        checkableImageButton.setFocusable(z11);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z10);
        checkableImageButton.setImportantForAccessibility(z11 ? 1 : 2);
    }

    public static final Object u(nb.t tVar, nb.t tVar2, p pVar) {
        Object lVar;
        Object E;
        j0 j0Var;
        try {
            za.p.b(2, pVar);
            lVar = pVar.b(tVar2, tVar);
        } catch (Throwable th) {
            lVar = new ib.l(th, false);
        }
        qa.a aVar = qa.a.f10374o;
        if (lVar == aVar || (E = tVar.E(lVar)) == v.f6598d) {
            return aVar;
        }
        if (E instanceof ib.l) {
            throw ((ib.l) E).f6575a;
        }
        k0 k0Var = E instanceof k0 ? (k0) E : null;
        return (k0Var == null || (j0Var = k0Var.f6573a) == null) ? E : j0Var;
    }

    public static SharedPreferences v(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            try {
                if (f0o == null) {
                    f0o = (SharedPreferences) n.x(new a8.b(0, context));
                }
                sharedPreferences = f0o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    public static /* synthetic */ boolean w(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, b4 b4Var, Object obj, Object obj2) {
        while (!atomicReferenceFieldUpdater.compareAndSet(b4Var, obj, obj2)) {
            if (atomicReferenceFieldUpdater.get(b4Var) != obj && atomicReferenceFieldUpdater.get(b4Var) != obj) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.leanback.transition.e
    public float c(View view) {
        return view.getTranslationX();
    }

    @Override // androidx.leanback.transition.e
    public Property d() {
        return View.TRANSLATION_X;
    }

    public abstract boolean f(z4.h hVar, z4.c cVar, z4.c cVar2);

    public abstract boolean g(z4.h hVar, Object obj, Object obj2);

    public abstract boolean h(z4.h hVar, z4.g gVar, z4.g gVar2);

    public abstract void q(z4.g gVar, z4.g gVar2);

    public abstract void r(z4.g gVar, Thread thread);
}
