package m0;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatEditText;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class k0 {

    /* renamed from: a, reason: collision with root package name */
    public static WeakHashMap f8683a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Field f8684b = null;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8685c = false;

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f8686d = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};

    /* renamed from: e, reason: collision with root package name */
    public static final w f8687e = new w();

    /* renamed from: f, reason: collision with root package name */
    public static final y f8688f = new y();

    public static p0 a(View view) {
        if (f8683a == null) {
            f8683a = new WeakHashMap();
        }
        p0 p0Var = (p0) f8683a.get(view);
        if (p0Var != null) {
            return p0Var;
        }
        p0 p0Var2 = new p0(view);
        f8683a.put(view, p0Var2);
        return p0Var2;
    }

    public static void b(View view, q1 q1Var) {
        int i10 = Build.VERSION.SDK_INT;
        WindowInsets f10 = q1Var.f();
        if (f10 != null) {
            WindowInsets a10 = i10 >= 30 ? h0.a(view, f10) : a0.a(view, f10);
            if (a10.equals(f10)) {
                return;
            }
            q1.g(view, a10);
        }
    }

    public static boolean c(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList = j0.f8676d;
        j0 j0Var = (j0) view.getTag(R.id.tag_unhandled_key_event_manager);
        if (j0Var == null) {
            j0Var = new j0();
            j0Var.f8677a = null;
            j0Var.f8678b = null;
            j0Var.f8679c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, j0Var);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap weakHashMap = j0Var.f8677a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList2 = j0.f8676d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    try {
                        if (j0Var.f8677a == null) {
                            j0Var.f8677a = new WeakHashMap();
                        }
                        for (int size = arrayList2.size() - 1; size >= 0; size--) {
                            ArrayList arrayList3 = j0.f8676d;
                            View view2 = (View) ((WeakReference) arrayList3.get(size)).get();
                            if (view2 == null) {
                                arrayList3.remove(size);
                            } else {
                                j0Var.f8677a.put(view2, Boolean.TRUE);
                                for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                    j0Var.f8677a.put((View) parent, Boolean.TRUE);
                                }
                            }
                        }
                    } finally {
                    }
                }
            }
        }
        View a10 = j0Var.a(view);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a10 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (j0Var.f8678b == null) {
                    j0Var.f8678b = new SparseArray();
                }
                j0Var.f8678b.put(keyCode, new WeakReference(a10));
            }
        }
        return a10 != null;
    }

    public static View.AccessibilityDelegate d(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return g0.a(view);
        }
        if (f8685c) {
            return null;
        }
        if (f8684b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f8684b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f8685c = true;
                return null;
            }
        }
        try {
            Object obj = f8684b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            f8685c = true;
            return null;
        }
    }

    public static CharSequence e(View view) {
        Object tag;
        if (Build.VERSION.SDK_INT >= 28) {
            tag = f0.a(view);
        } else {
            tag = view.getTag(R.id.tag_accessibility_pane_title);
            if (!CharSequence.class.isInstance(tag)) {
                tag = null;
            }
        }
        return (CharSequence) tag;
    }

    public static ArrayList f(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_accessibility_actions);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(R.id.tag_accessibility_actions, arrayList2);
        return arrayList2;
    }

    public static String[] g(AppCompatEditText appCompatEditText) {
        return Build.VERSION.SDK_INT >= 31 ? i0.a(appCompatEditText) : (String[]) appCompatEditText.getTag(R.id.tag_on_receive_content_mime_types);
    }

    public static void h(View view, int i10) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z10 = e(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z10) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z10 ? 32 : 2048);
                obtain.setContentChangeTypes(i10);
                if (z10) {
                    obtain.getText().add(e(view));
                    if (view.getImportantForAccessibility() == 0) {
                        view.setImportantForAccessibility(1);
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
                return;
            }
            if (i10 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i10);
                        return;
                    } catch (AbstractMethodError e7) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e7);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(obtain2);
            obtain2.setEventType(32);
            obtain2.setContentChangeTypes(i10);
            obtain2.setSource(view);
            view.onPopulateAccessibilityEvent(obtain2);
            obtain2.getText().add(e(view));
            accessibilityManager.sendAccessibilityEvent(obtain2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static f i(View view, f fVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + fVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return i0.b(view, fVar);
        }
        p0.j jVar = (p0.j) view.getTag(R.id.tag_on_receive_content_listener);
        n nVar = f8687e;
        if (jVar == null) {
            if (view instanceof n) {
                nVar = (n) view;
            }
            return nVar.a(fVar);
        }
        f a10 = p0.j.a(view, fVar);
        if (a10 == null) {
            return null;
        }
        if (view instanceof n) {
            nVar = (n) view;
        }
        return nVar.a(a10);
    }

    public static void j(View view, int i10) {
        ArrayList f10 = f(view);
        for (int i11 = 0; i11 < f10.size(); i11++) {
            if (((n0.d) f10.get(i11)).a() == i10) {
                f10.remove(i11);
                return;
            }
        }
    }

    public static void k(View view, n0.d dVar, n0.q qVar) {
        n0.d dVar2 = new n0.d(null, dVar.f9107b, null, qVar, dVar.f9108c);
        View.AccessibilityDelegate d6 = d(view);
        b bVar = d6 == null ? null : d6 instanceof a ? ((a) d6).f8635a : new b(d6);
        if (bVar == null) {
            bVar = new b();
        }
        m(view, bVar);
        j(view, dVar2.a());
        f(view).add(dVar2);
        h(view, 0);
    }

    public static void l(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i10) {
        if (Build.VERSION.SDK_INT >= 29) {
            g0.b(view, context, iArr, attributeSet, typedArray, i10, 0);
        }
    }

    public static void m(View view, b bVar) {
        if (bVar == null && (d(view) instanceof a)) {
            bVar = new b();
        }
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
        view.setAccessibilityDelegate(bVar == null ? null : bVar.f8639b);
    }

    public static void n(View view, CharSequence charSequence) {
        new x(R.id.tag_accessibility_pane_title, CharSequence.class, 8, 28, 1).f(view, charSequence);
        y yVar = f8688f;
        if (charSequence == null) {
            yVar.f8739o.remove(view);
            view.removeOnAttachStateChangeListener(yVar);
            view.getViewTreeObserver().removeOnGlobalLayoutListener(yVar);
        } else {
            yVar.f8739o.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(yVar);
            if (view.isAttachedToWindow()) {
                view.getViewTreeObserver().addOnGlobalLayoutListener(yVar);
            }
        }
    }
}
