package m0;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f8637c = new View.AccessibilityDelegate();

    /* renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f8638a;

    /* renamed from: b, reason: collision with root package name */
    public final a f8639b;

    public b() {
        this(f8637c);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f8638a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public h5.i b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f8638a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new h5.i(22, accessibilityNodeProvider);
        }
        return null;
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f8638a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, n0.g gVar) {
        this.f8638a.onInitializeAccessibilityNodeInfo(view, gVar.f9111a);
    }

    public void e(View view, AccessibilityEvent accessibilityEvent) {
        this.f8638a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean f(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f8638a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean g(View view, int i10, Bundle bundle) {
        boolean z10;
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= list.size()) {
                break;
            }
            n0.d dVar = (n0.d) list.get(i11);
            if (dVar.a() == i10) {
                Class cls = dVar.f9108c;
                n0.q qVar = dVar.f9109d;
                if (qVar != null) {
                    if (cls != null) {
                        try {
                            if (cls.getDeclaredConstructor(null).newInstance(null) == null) {
                                throw null;
                            }
                            throw new ClassCastException();
                        } catch (Exception e7) {
                            Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: ".concat(cls.getName()), e7);
                        }
                    }
                    z10 = qVar.f(view);
                }
            } else {
                i11++;
            }
        }
        z10 = false;
        if (!z10) {
            z10 = this.f8638a.performAccessibilityAction(view, i10, bundle);
        }
        if (z10 || i10 != R.id.accessibility_action_clickable_span || bundle == null) {
            return z10;
        }
        int i12 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i12)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            int i13 = 0;
            while (true) {
                if (clickableSpanArr == null || i13 >= clickableSpanArr.length) {
                    break;
                }
                if (clickableSpan.equals(clickableSpanArr[i13])) {
                    clickableSpan.onClick(view);
                    z11 = true;
                    break;
                }
                i13++;
            }
        }
        return z11;
    }

    public void h(View view, int i10) {
        this.f8638a.sendAccessibilityEvent(view, i10);
    }

    public void i(View view, AccessibilityEvent accessibilityEvent) {
        this.f8638a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f8638a = accessibilityDelegate;
        this.f8639b = new a(this);
    }
}
