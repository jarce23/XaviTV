package f;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;
import m.s1;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class g extends d0 implements DialogInterface {

    /* renamed from: t, reason: collision with root package name */
    public final e f4787t;

    public g(ContextThemeWrapper contextThemeWrapper, int i10) {
        super(contextThemeWrapper, g(contextThemeWrapper, i10));
        this.f4787t = new e(getContext(), this, getWindow());
    }

    public static int g(Context context, int i10) {
        if (((i10 >>> 24) & 255) >= 1) {
            return i10;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // f.d0, androidx.activity.p, android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i10;
        ListAdapter listAdapter;
        View findViewById;
        super.onCreate(bundle);
        e eVar = this.f4787t;
        eVar.f4750b.setContentView(eVar.f4773z);
        Context context = eVar.f4749a;
        Window window = eVar.f4751c;
        View findViewById2 = window.findViewById(R.id.parentPanel);
        View findViewById3 = findViewById2.findViewById(R.id.topPanel);
        View findViewById4 = findViewById2.findViewById(R.id.contentPanel);
        View findViewById5 = findViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById2.findViewById(R.id.customPanel);
        View view = eVar.g;
        if (view == null) {
            view = null;
        }
        boolean z10 = view != null;
        if (!z10 || !e.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (eVar.f4755h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (eVar.f4754f != null) {
                ((LinearLayout.LayoutParams) ((s1) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View findViewById6 = viewGroup.findViewById(R.id.topPanel);
        View findViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View findViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup b2 = e.b(findViewById6, findViewById3);
        ViewGroup b10 = e.b(findViewById7, findViewById4);
        ViewGroup b11 = e.b(findViewById8, findViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        eVar.f4765r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        eVar.f4765r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) b10.findViewById(android.R.id.message);
        eVar.f4769v = textView;
        if (textView != null) {
            String str = eVar.f4753e;
            if (str != null) {
                textView.setText(str);
            } else {
                textView.setVisibility(8);
                eVar.f4765r.removeView(eVar.f4769v);
                if (eVar.f4754f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) eVar.f4765r.getParent();
                    int indexOfChild = viewGroup2.indexOfChild(eVar.f4765r);
                    viewGroup2.removeViewAt(indexOfChild);
                    viewGroup2.addView(eVar.f4754f, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    b10.setVisibility(8);
                }
            }
        }
        Button button = (Button) b11.findViewById(android.R.id.button1);
        eVar.f4756i = button;
        androidx.leanback.widget.g0 g0Var = eVar.F;
        button.setOnClickListener(g0Var);
        if (TextUtils.isEmpty(eVar.f4757j)) {
            eVar.f4756i.setVisibility(8);
            i10 = 0;
        } else {
            eVar.f4756i.setText(eVar.f4757j);
            eVar.f4756i.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) b11.findViewById(android.R.id.button2);
        eVar.f4759l = button2;
        button2.setOnClickListener(g0Var);
        if (TextUtils.isEmpty(eVar.f4760m)) {
            eVar.f4759l.setVisibility(8);
        } else {
            eVar.f4759l.setText(eVar.f4760m);
            eVar.f4759l.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) b11.findViewById(android.R.id.button3);
        eVar.f4762o = button3;
        button3.setOnClickListener(g0Var);
        if (TextUtils.isEmpty(eVar.f4763p)) {
            eVar.f4762o.setVisibility(8);
        } else {
            eVar.f4762o.setText(eVar.f4763p);
            eVar.f4762o.setVisibility(0);
            i10 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i10 == 1) {
                Button button4 = eVar.f4756i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i10 == 2) {
                Button button5 = eVar.f4759l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i10 == 4) {
                Button button6 = eVar.f4762o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i10 == 0) {
            b11.setVisibility(8);
        }
        if (eVar.f4770w != null) {
            b2.addView(eVar.f4770w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            eVar.f4767t = (ImageView) window.findViewById(android.R.id.icon);
            if (TextUtils.isEmpty(eVar.f4752d) || !eVar.D) {
                window.findViewById(R.id.title_template).setVisibility(8);
                eVar.f4767t.setVisibility(8);
                b2.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                eVar.f4768u = textView2;
                textView2.setText(eVar.f4752d);
                Drawable drawable = eVar.f4766s;
                if (drawable != null) {
                    eVar.f4767t.setImageDrawable(drawable);
                } else {
                    eVar.f4768u.setPadding(eVar.f4767t.getPaddingLeft(), eVar.f4767t.getPaddingTop(), eVar.f4767t.getPaddingRight(), eVar.f4767t.getPaddingBottom());
                    eVar.f4767t.setVisibility(8);
                }
            }
        }
        boolean z11 = viewGroup.getVisibility() != 8;
        int i11 = (b2 == null || b2.getVisibility() == 8) ? 0 : 1;
        boolean z12 = b11.getVisibility() != 8;
        if (!z12 && (findViewById = b10.findViewById(R.id.textSpacerNoButtons)) != null) {
            findViewById.setVisibility(0);
        }
        if (i11 != 0) {
            NestedScrollView nestedScrollView2 = eVar.f4765r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View findViewById9 = (eVar.f4753e == null && eVar.f4754f == null) ? null : b2.findViewById(R.id.titleDividerNoCustom);
            if (findViewById9 != null) {
                findViewById9.setVisibility(0);
            }
        } else {
            View findViewById10 = b10.findViewById(R.id.textSpacerNoTitle);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = eVar.f4754f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z12 || i11 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i11 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f368o, alertController$RecycleListView.getPaddingRight(), z12 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f369p);
            }
        }
        if (!z11) {
            View view2 = eVar.f4754f;
            if (view2 == null) {
                view2 = eVar.f4765r;
            }
            if (view2 != null) {
                int i12 = z12 ? 2 : 0;
                View findViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View findViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = m0.k0.f8683a;
                m0.d0.b(view2, i11 | i12, 3);
                if (findViewById11 != null) {
                    b10.removeView(findViewById11);
                }
                if (findViewById12 != null) {
                    b10.removeView(findViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = eVar.f4754f;
        if (alertController$RecycleListView2 == null || (listAdapter = eVar.f4771x) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i13 = eVar.f4772y;
        if (i13 > -1) {
            alertController$RecycleListView2.setItemChecked(i13, true);
            alertController$RecycleListView2.setSelection(i13);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4787t.f4765r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i10, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.f4787t.f4765r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i10, keyEvent);
        }
        return true;
    }

    @Override // f.d0, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        e eVar = this.f4787t;
        eVar.f4752d = charSequence;
        TextView textView = eVar.f4768u;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
