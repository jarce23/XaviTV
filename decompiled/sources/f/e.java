package f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e {
    public final int A;
    public final int B;
    public final int C;
    public final boolean D;
    public final c E;

    /* renamed from: a, reason: collision with root package name */
    public final Context f4749a;

    /* renamed from: b, reason: collision with root package name */
    public final g f4750b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f4751c;

    /* renamed from: d, reason: collision with root package name */
    public CharSequence f4752d;

    /* renamed from: e, reason: collision with root package name */
    public String f4753e;

    /* renamed from: f, reason: collision with root package name */
    public AlertController$RecycleListView f4754f;
    public View g;

    /* renamed from: i, reason: collision with root package name */
    public Button f4756i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f4757j;

    /* renamed from: k, reason: collision with root package name */
    public Message f4758k;

    /* renamed from: l, reason: collision with root package name */
    public Button f4759l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f4760m;

    /* renamed from: n, reason: collision with root package name */
    public Message f4761n;

    /* renamed from: o, reason: collision with root package name */
    public Button f4762o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f4763p;

    /* renamed from: q, reason: collision with root package name */
    public Message f4764q;

    /* renamed from: r, reason: collision with root package name */
    public NestedScrollView f4765r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f4766s;

    /* renamed from: t, reason: collision with root package name */
    public ImageView f4767t;

    /* renamed from: u, reason: collision with root package name */
    public TextView f4768u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f4769v;

    /* renamed from: w, reason: collision with root package name */
    public View f4770w;

    /* renamed from: x, reason: collision with root package name */
    public ListAdapter f4771x;

    /* renamed from: z, reason: collision with root package name */
    public final int f4773z;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4755h = false;

    /* renamed from: y, reason: collision with root package name */
    public int f4772y = -1;
    public final androidx.leanback.widget.g0 F = new androidx.leanback.widget.g0(8, this);

    public e(Context context, g gVar, Window window) {
        this.f4749a = context;
        this.f4750b = gVar;
        this.f4751c = window;
        c cVar = new c();
        cVar.f4745b = new WeakReference(gVar);
        this.E = cVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, e.a.f4362e, R.attr.alertDialogStyle, 0);
        this.f4773z = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.A = obtainStyledAttributes.getResourceId(4, 0);
        obtainStyledAttributes.getResourceId(5, 0);
        this.B = obtainStyledAttributes.getResourceId(7, 0);
        this.C = obtainStyledAttributes.getResourceId(3, 0);
        this.D = obtainStyledAttributes.getBoolean(6, true);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        gVar.d().f(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.E.obtainMessage(i10, onClickListener) : null;
        if (i10 == -3) {
            this.f4763p = charSequence;
            this.f4764q = obtainMessage;
        } else if (i10 == -2) {
            this.f4760m = charSequence;
            this.f4761n = obtainMessage;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f4757j = charSequence;
            this.f4758k = obtainMessage;
        }
    }
}
