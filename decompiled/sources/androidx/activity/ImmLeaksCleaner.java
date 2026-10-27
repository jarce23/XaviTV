package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.lang.reflect.Field;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements androidx.lifecycle.p {

    /* renamed from: p, reason: collision with root package name */
    public static int f274p;

    /* renamed from: q, reason: collision with root package name */
    public static Field f275q;

    /* renamed from: r, reason: collision with root package name */
    public static Field f276r;

    /* renamed from: s, reason: collision with root package name */
    public static Field f277s;

    /* renamed from: o, reason: collision with root package name */
    public f.j f278o;

    @Override // androidx.lifecycle.p
    public final void a(androidx.lifecycle.r rVar, androidx.lifecycle.l lVar) {
        if (lVar != androidx.lifecycle.l.ON_DESTROY) {
            return;
        }
        if (f274p == 0) {
            try {
                f274p = 2;
                Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
                f276r = declaredField;
                declaredField.setAccessible(true);
                Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
                f277s = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
                f275q = declaredField3;
                declaredField3.setAccessible(true);
                f274p = 1;
            } catch (NoSuchFieldException unused) {
            }
        }
        if (f274p == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f278o.getSystemService("input_method");
            try {
                Object obj = f275q.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        View view = (View) f276r.get(inputMethodManager);
                        if (view != null) {
                            if (!view.isAttachedToWindow()) {
                                f277s.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            }
                        }
                    } catch (IllegalAccessException unused2) {
                    } catch (ClassCastException unused3) {
                    } catch (IllegalAccessException unused4) {
                    } finally {
                    }
                }
            } catch (IllegalAccessException unused5) {
            }
        }
    }
}
