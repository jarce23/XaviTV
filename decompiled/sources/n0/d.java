package n0;

import android.R;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import m0.t;
import okhttp3.internal.http2.Http2;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: e, reason: collision with root package name */
    public static final d f9097e;

    /* renamed from: f, reason: collision with root package name */
    public static final d f9098f;
    public static final d g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f9099h;

    /* renamed from: i, reason: collision with root package name */
    public static final d f9100i;

    /* renamed from: j, reason: collision with root package name */
    public static final d f9101j;

    /* renamed from: k, reason: collision with root package name */
    public static final d f9102k;

    /* renamed from: l, reason: collision with root package name */
    public static final d f9103l;

    /* renamed from: m, reason: collision with root package name */
    public static final d f9104m;

    /* renamed from: n, reason: collision with root package name */
    public static final d f9105n;

    /* renamed from: a, reason: collision with root package name */
    public final Object f9106a;

    /* renamed from: b, reason: collision with root package name */
    public final int f9107b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f9108c;

    /* renamed from: d, reason: collision with root package name */
    public final q f9109d;

    static {
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction14;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction15;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction16;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction17;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction18;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction19;
        AccessibilityNodeInfo.AccessibilityAction accessibilityAction20;
        new d(1, (String) null);
        new d(2, (String) null);
        new d(4, (String) null);
        new d(8, (String) null);
        f9097e = new d(16, (String) null);
        new d(32, (String) null);
        new d(64, (String) null);
        new d(128, (String) null);
        new d(256, j.class);
        new d(512, j.class);
        new d(1024, k.class);
        new d(2048, k.class);
        f9098f = new d(4096, (String) null);
        g = new d(8192, (String) null);
        new d(Http2.INITIAL_MAX_FRAME_SIZE, (String) null);
        new d(32768, (String) null);
        new d(65536, (String) null);
        new d(131072, o.class);
        f9099h = new d(262144, (String) null);
        f9100i = new d(524288, (String) null);
        f9101j = new d(1048576, (String) null);
        new d(2097152, p.class);
        int i10 = Build.VERSION.SDK_INT;
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, m.class);
        f9102k = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
        f9103l = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
        f9104m = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
        f9105n = new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
        if (i10 >= 29) {
            accessibilityAction20 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            accessibilityAction = accessibilityAction20;
        } else {
            accessibilityAction = null;
        }
        new d(accessibilityAction, R.id.accessibilityActionPageUp, null, null, null);
        if (i10 >= 29) {
            accessibilityAction19 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            accessibilityAction2 = accessibilityAction19;
        } else {
            accessibilityAction2 = null;
        }
        new d(accessibilityAction2, R.id.accessibilityActionPageDown, null, null, null);
        new d(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
        if (i10 >= 29) {
            accessibilityAction18 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            accessibilityAction3 = accessibilityAction18;
        } else {
            accessibilityAction3 = null;
        }
        new d(accessibilityAction3, R.id.accessibilityActionPageRight, null, null, null);
        new d(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
        if (i10 >= 24) {
            accessibilityAction17 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            accessibilityAction4 = accessibilityAction17;
        } else {
            accessibilityAction4 = null;
        }
        new d(accessibilityAction4, R.id.accessibilityActionSetProgress, null, null, n.class);
        new d(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, l.class);
        if (i10 >= 28) {
            accessibilityAction16 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            accessibilityAction5 = accessibilityAction16;
        } else {
            accessibilityAction5 = null;
        }
        new d(accessibilityAction5, R.id.accessibilityActionShowTooltip, null, null, null);
        if (i10 >= 28) {
            accessibilityAction15 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            accessibilityAction6 = accessibilityAction15;
        } else {
            accessibilityAction6 = null;
        }
        new d(accessibilityAction6, R.id.accessibilityActionHideTooltip, null, null, null);
        new d(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
        if (i10 >= 30) {
            accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            accessibilityAction7 = accessibilityAction14;
        } else {
            accessibilityAction7 = null;
        }
        new d(accessibilityAction7, R.id.accessibilityActionImeEnter, null, null, null);
        new d(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
        if (i10 >= 32) {
            accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            accessibilityAction8 = accessibilityAction13;
        } else {
            accessibilityAction8 = null;
        }
        new d(accessibilityAction8, R.id.accessibilityActionDragDrop, null, null, null);
        if (i10 >= 32) {
            accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            accessibilityAction9 = accessibilityAction12;
        } else {
            accessibilityAction9 = null;
        }
        new d(accessibilityAction9, R.id.accessibilityActionDragCancel, null, null, null);
        if (i10 >= 33) {
            accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            accessibilityAction10 = accessibilityAction11;
        } else {
            accessibilityAction10 = null;
        }
        new d(accessibilityAction10, R.id.accessibilityActionShowTextSuggestions, null, null, null);
        new d(i10 >= 34 ? t.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
    }

    public d(int i10, String str) {
        this(null, i10, str, null, null);
    }

    public final int a() {
        return ((AccessibilityNodeInfo.AccessibilityAction) this.f9106a).getId();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        Object obj2 = ((d) obj).f9106a;
        Object obj3 = this.f9106a;
        return obj3 == null ? obj2 == null : obj3.equals(obj2);
    }

    public final int hashCode() {
        Object obj = this.f9106a;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("AccessibilityActionCompat: ");
        String d6 = g.d(this.f9107b);
        if (d6.equals("ACTION_UNKNOWN")) {
            Object obj = this.f9106a;
            if (((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel() != null) {
                d6 = ((AccessibilityNodeInfo.AccessibilityAction) obj).getLabel().toString();
            }
        }
        sb2.append(d6);
        return sb2.toString();
    }

    public d(int i10, Class cls) {
        this(null, i10, null, null, cls);
    }

    public d(Object obj, int i10, CharSequence charSequence, q qVar, Class cls) {
        this.f9107b = i10;
        this.f9109d = qVar;
        if (obj == null) {
            this.f9106a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
        } else {
            this.f9106a = obj;
        }
        this.f9108c = cls;
    }
}
