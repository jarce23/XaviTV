package s0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import h5.i;
import j9.v1;
import j9.w1;
import java.util.ArrayList;
import java.util.WeakHashMap;
import m0.k0;
import n0.g;
import s8.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class b extends m0.b {

    /* renamed from: n, reason: collision with root package name */
    public static final Rect f11143n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o, reason: collision with root package name */
    public static final w1 f11144o = new w1(13);

    /* renamed from: p, reason: collision with root package name */
    public static final v1 f11145p = new v1(14);

    /* renamed from: h, reason: collision with root package name */
    public final AccessibilityManager f11149h;

    /* renamed from: i, reason: collision with root package name */
    public final Chip f11150i;

    /* renamed from: j, reason: collision with root package name */
    public a f11151j;

    /* renamed from: d, reason: collision with root package name */
    public final Rect f11146d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    public final Rect f11147e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    public final Rect f11148f = new Rect();
    public final int[] g = new int[2];

    /* renamed from: k, reason: collision with root package name */
    public int f11152k = Integer.MIN_VALUE;

    /* renamed from: l, reason: collision with root package name */
    public int f11153l = Integer.MIN_VALUE;

    /* renamed from: m, reason: collision with root package name */
    public int f11154m = Integer.MIN_VALUE;

    public b(Chip chip) {
        this.f11150i = chip;
        this.f11149h = (AccessibilityManager) chip.getContext().getSystemService("accessibility");
        chip.setFocusable(true);
        WeakHashMap weakHashMap = k0.f8683a;
        if (chip.getImportantForAccessibility() == 0) {
            chip.setImportantForAccessibility(1);
        }
    }

    @Override // m0.b
    public final i b(View view) {
        if (this.f11151j == null) {
            this.f11151j = new a(this);
        }
        return this.f11151j;
    }

    @Override // m0.b
    public final void d(View view, g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        this.f8638a.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        Chip chip = ((s8.c) this).f11633q;
        e eVar = chip.f3725s;
        accessibilityNodeInfo.setCheckable(eVar != null && eVar.f11650n0);
        accessibilityNodeInfo.setClickable(chip.isClickable());
        gVar.i(chip.getAccessibilityClassName());
        gVar.m(chip.getText());
    }

    public final boolean j(int i10) {
        if (this.f11153l != i10) {
            return false;
        }
        this.f11153l = Integer.MIN_VALUE;
        p(i10, false);
        r(i10, 8);
        return true;
    }

    public final g k(int i10) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        g gVar = new g(obtain);
        obtain.setEnabled(true);
        obtain.setFocusable(true);
        gVar.i("android.view.View");
        Rect rect = f11143n;
        obtain.setBoundsInParent(rect);
        obtain.setBoundsInScreen(rect);
        Chip chip = this.f11150i;
        obtain.setParent(chip);
        o(i10, gVar);
        if (gVar.g() == null && obtain.getContentDescription() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        Rect rect2 = this.f11147e;
        gVar.f(rect2);
        if (rect2.equals(rect)) {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
        int actions = obtain.getActions();
        if ((actions & 64) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        if ((actions & 128) != 0) {
            throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        obtain.setPackageName(chip.getContext().getPackageName());
        gVar.f9112b = i10;
        obtain.setSource(chip, i10);
        if (this.f11152k == i10) {
            obtain.setAccessibilityFocused(true);
            gVar.a(128);
        } else {
            obtain.setAccessibilityFocused(false);
            gVar.a(64);
        }
        boolean z10 = this.f11153l == i10;
        if (z10) {
            gVar.a(2);
        } else if (obtain.isFocusable()) {
            gVar.a(1);
        }
        obtain.setFocused(z10);
        int[] iArr = this.g;
        chip.getLocationOnScreen(iArr);
        Rect rect3 = this.f11146d;
        obtain.getBoundsInScreen(rect3);
        if (rect3.equals(rect)) {
            gVar.f(rect3);
            rect3.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
        }
        Rect rect4 = this.f11148f;
        if (chip.getLocalVisibleRect(rect4)) {
            rect4.offset(iArr[0] - chip.getScrollX(), iArr[1] - chip.getScrollY());
            if (rect3.intersect(rect4)) {
                obtain.setBoundsInScreen(rect3);
                if (!rect3.isEmpty() && chip.getWindowVisibility() == 0) {
                    Object parent = chip.getParent();
                    while (true) {
                        if (parent instanceof View) {
                            View view = (View) parent;
                            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                                break;
                            }
                            parent = view.getParent();
                        } else if (parent != null) {
                            gVar.f9111a.setVisibleToUser(true);
                        }
                    }
                }
            }
        }
        return gVar;
    }

    public abstract void l(ArrayList arrayList);

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ea  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean m(int r19, android.graphics.Rect r20) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.b.m(int, android.graphics.Rect):boolean");
    }

    public final g n(int i10) {
        if (i10 != -1) {
            return k(i10);
        }
        Chip chip = this.f11150i;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(chip);
        g gVar = new g(obtain);
        WeakHashMap weakHashMap = k0.f8683a;
        chip.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        l(arrayList);
        if (obtain.getChildCount() > 0 && arrayList.size() > 0) {
            throw new RuntimeException("Views cannot have both real and virtual children");
        }
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            gVar.f9111a.addChild(chip, ((Integer) arrayList.get(i11)).intValue());
        }
        return gVar;
    }

    public abstract void o(int i10, g gVar);

    public abstract void p(int i10, boolean z10);

    public final boolean q(int i10) {
        int i11;
        Chip chip = this.f11150i;
        if ((!chip.isFocused() && !chip.requestFocus()) || (i11 = this.f11153l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            j(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f11153l = i10;
        p(i10, true);
        r(i10, 8);
        return true;
    }

    public final void r(int i10, int i11) {
        View view;
        ViewParent parent;
        AccessibilityEvent obtain;
        if (i10 == Integer.MIN_VALUE || !this.f11149h.isEnabled() || (parent = (view = this.f11150i).getParent()) == null) {
            return;
        }
        if (i10 != -1) {
            obtain = AccessibilityEvent.obtain(i11);
            g n10 = n(i10);
            obtain.getText().add(n10.g());
            AccessibilityNodeInfo accessibilityNodeInfo = n10.f9111a;
            obtain.setContentDescription(accessibilityNodeInfo.getContentDescription());
            obtain.setScrollable(accessibilityNodeInfo.isScrollable());
            obtain.setPassword(accessibilityNodeInfo.isPassword());
            obtain.setEnabled(accessibilityNodeInfo.isEnabled());
            obtain.setChecked(accessibilityNodeInfo.isChecked());
            if (obtain.getText().isEmpty() && obtain.getContentDescription() == null) {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
            obtain.setClassName(accessibilityNodeInfo.getClassName());
            obtain.setSource(view, i10);
            obtain.setPackageName(view.getContext().getPackageName());
        } else {
            obtain = AccessibilityEvent.obtain(i11);
            view.onInitializeAccessibilityEvent(obtain);
        }
        parent.requestSendAccessibilityEvent(view, obtain);
    }
}
