package g9;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.material.textfield.TextInputLayout;
import org.chromium.net.R;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m extends q {

    /* renamed from: e, reason: collision with root package name */
    public final int f5351e;

    /* renamed from: f, reason: collision with root package name */
    public final int f5352f;
    public final TimeInterpolator g;

    /* renamed from: h, reason: collision with root package name */
    public AutoCompleteTextView f5353h;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.mediarouter.app.b f5354i;

    /* renamed from: j, reason: collision with root package name */
    public final a f5355j;

    /* renamed from: k, reason: collision with root package name */
    public final k f5356k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5357l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5358m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f5359n;

    /* renamed from: o, reason: collision with root package name */
    public long f5360o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f5361p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f5362q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f5363r;

    /* JADX WARN: Type inference failed for: r0v2, types: [g9.k] */
    public m(p pVar) {
        super(pVar);
        this.f5354i = new androidx.mediarouter.app.b(4, this);
        this.f5355j = new a(this, 1);
        this.f5356k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: g9.k
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z10) {
                m mVar = m.this;
                AutoCompleteTextView autoCompleteTextView = mVar.f5353h;
                if (autoCompleteTextView == null || autoCompleteTextView.getInputType() != 0) {
                    return;
                }
                mVar.f5381d.setImportantForAccessibility(z10 ? 2 : 1);
            }
        };
        this.f5360o = Long.MAX_VALUE;
        this.f5352f = w7.b.u(pVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f5351e = w7.b.u(pVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = w7.b.v(pVar.getContext(), R.attr.motionEasingLinearInterpolator, k8.a.f7830a);
    }

    @Override // g9.q
    public final void a() {
        if (this.f5361p.isTouchExplorationEnabled() && this.f5353h.getInputType() != 0 && !this.f5381d.hasFocus()) {
            this.f5353h.dismissDropDown();
        }
        this.f5353h.post(new androidx.activity.d(11, this));
    }

    @Override // g9.q
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // g9.q
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // g9.q
    public final View.OnFocusChangeListener e() {
        return this.f5355j;
    }

    @Override // g9.q
    public final View.OnClickListener f() {
        return this.f5354i;
    }

    @Override // g9.q
    public final AccessibilityManager.TouchExplorationStateChangeListener h() {
        return this.f5356k;
    }

    @Override // g9.q
    public final boolean i(int i10) {
        return i10 != 0;
    }

    @Override // g9.q
    public final boolean k() {
        return this.f5359n;
    }

    @Override // g9.q
    public final void l(EditText editText) {
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.f5353h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new View.OnTouchListener() { // from class: g9.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    m mVar = m.this;
                    long j10 = uptimeMillis - mVar.f5360o;
                    if (j10 < 0 || j10 > 300) {
                        mVar.f5358m = false;
                    }
                    mVar.t();
                    mVar.f5358m = true;
                    mVar.f5360o = SystemClock.uptimeMillis();
                }
                return false;
            }
        });
        this.f5353h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: g9.j
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                m mVar = m.this;
                mVar.f5358m = true;
                mVar.f5360o = SystemClock.uptimeMillis();
                mVar.s(false);
            }
        });
        this.f5353h.setThreshold(0);
        TextInputLayout textInputLayout = this.f5378a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (editText.getInputType() == 0 && this.f5361p.isTouchExplorationEnabled()) {
            this.f5381d.setImportantForAccessibility(2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // g9.q
    public final void m(n0.g gVar) {
        AccessibilityNodeInfo accessibilityNodeInfo = gVar.f9111a;
        if (this.f5353h.getInputType() == 0) {
            gVar.i(Spinner.class.getName());
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 26 ? accessibilityNodeInfo.isShowingHintText() : gVar.e(4)) {
            if (i10 >= 26) {
                accessibilityNodeInfo.setHintText(null);
            } else {
                accessibilityNodeInfo.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", null);
            }
        }
    }

    @Override // g9.q
    public final void n(AccessibilityEvent accessibilityEvent) {
        if (this.f5361p.isEnabled() && this.f5353h.getInputType() == 0) {
            boolean z10 = (accessibilityEvent.getEventType() == 32768 || accessibilityEvent.getEventType() == 8) && this.f5359n && !this.f5353h.isPopupShowing();
            if (accessibilityEvent.getEventType() == 1 || z10) {
                t();
                this.f5358m = true;
                this.f5360o = SystemClock.uptimeMillis();
            }
        }
    }

    @Override // g9.q
    public final void q() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat.setInterpolator(timeInterpolator);
        ofFloat.setDuration(this.f5352f);
        int i10 = 0;
        ofFloat.addUpdateListener(new h(i10, this));
        this.f5363r = ofFloat;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.setInterpolator(timeInterpolator);
        ofFloat2.setDuration(this.f5351e);
        ofFloat2.addUpdateListener(new h(i10, this));
        this.f5362q = ofFloat2;
        ofFloat2.addListener(new l(i10, this));
        this.f5361p = (AccessibilityManager) this.f5380c.getSystemService("accessibility");
    }

    @Override // g9.q
    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.f5353h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.f5353h.setOnDismissListener(null);
        }
    }

    public final void s(boolean z10) {
        if (this.f5359n != z10) {
            this.f5359n = z10;
            this.f5363r.cancel();
            this.f5362q.start();
        }
    }

    public final void t() {
        if (this.f5353h == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - this.f5360o;
        if (uptimeMillis < 0 || uptimeMillis > 300) {
            this.f5358m = false;
        }
        if (this.f5358m) {
            this.f5358m = false;
            return;
        }
        s(!this.f5359n);
        if (!this.f5359n) {
            this.f5353h.dismissDropDown();
        } else {
            this.f5353h.requestFocus();
            this.f5353h.showDropDown();
        }
    }
}
