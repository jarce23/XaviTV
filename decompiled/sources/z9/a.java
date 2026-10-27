package z9;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import eightbitlab.com.blurview.BlurView;
import j9.w1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements c {

    /* renamed from: q, reason: collision with root package name */
    public d f14151q;

    /* renamed from: r, reason: collision with root package name */
    public Bitmap f14152r;

    /* renamed from: s, reason: collision with root package name */
    public final BlurView f14153s;

    /* renamed from: t, reason: collision with root package name */
    public int f14154t;

    /* renamed from: u, reason: collision with root package name */
    public final ViewGroup f14155u;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14159y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f14160z;

    /* renamed from: o, reason: collision with root package name */
    public float f14149o = 16.0f;

    /* renamed from: v, reason: collision with root package name */
    public final int[] f14156v = new int[2];

    /* renamed from: w, reason: collision with root package name */
    public final int[] f14157w = new int[2];

    /* renamed from: x, reason: collision with root package name */
    public final j6.d f14158x = new j6.d(2, this);
    public final Paint A = new Paint(2);

    /* renamed from: p, reason: collision with root package name */
    public b f14150p = new w1(29);

    public a(BlurView blurView, ViewGroup viewGroup, int i10) {
        this.f14155u = viewGroup;
        this.f14153s = blurView;
        this.f14154t = i10;
        c(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }

    @Override // z9.c
    public final void a() {
        BlurView blurView = this.f14153s;
        c(blurView.getMeasuredWidth(), blurView.getMeasuredHeight());
    }

    @Override // z9.c
    public final boolean b(Canvas canvas) {
        if (this.f14159y) {
            if (canvas instanceof d) {
                return false;
            }
            e();
            BlurView blurView = this.f14153s;
            float height = blurView.getHeight() / this.f14152r.getHeight();
            canvas.save();
            canvas.scale(blurView.getWidth() / this.f14152r.getWidth(), height);
            canvas.drawBitmap(this.f14152r, 0.0f, 0.0f, this.A);
            canvas.restore();
            int i10 = this.f14154t;
            if (i10 != 0) {
                canvas.drawColor(i10);
            }
        }
        return true;
    }

    public final void c(int i10, int i11) {
        float u10 = this.f14150p.u();
        float f10 = i11;
        int ceil = (int) Math.ceil(f10 / u10);
        BlurView blurView = this.f14153s;
        if (ceil != 0) {
            double d6 = i10 / u10;
            if (((int) Math.ceil(d6)) != 0) {
                blurView.setWillNotDraw(false);
                int ceil2 = (int) Math.ceil(d6);
                int i12 = ceil2 % 64;
                if (i12 != 0) {
                    ceil2 = (ceil2 - i12) + 64;
                }
                int ceil3 = (int) Math.ceil(f10 / (r7 / ceil2));
                this.f14150p.r();
                this.f14152r = Bitmap.createBitmap(ceil2, ceil3, Bitmap.Config.ARGB_8888);
                this.f14151q = new d(this.f14152r);
                this.f14159y = true;
                return;
            }
        }
        blurView.setWillNotDraw(true);
    }

    @Override // z9.c
    public final c d(boolean z10) {
        ViewGroup viewGroup = this.f14155u;
        ViewTreeObserver viewTreeObserver = viewGroup.getViewTreeObserver();
        j6.d dVar = this.f14158x;
        viewTreeObserver.removeOnPreDrawListener(dVar);
        if (z10) {
            viewGroup.getViewTreeObserver().addOnPreDrawListener(dVar);
        }
        return this;
    }

    @Override // z9.c
    public final void destroy() {
        d(false);
        this.f14150p.destroy();
        this.f14159y = false;
    }

    public final void e() {
        if (this.f14159y) {
            Drawable drawable = this.f14160z;
            if (drawable == null) {
                this.f14152r.eraseColor(0);
            } else {
                drawable.draw(this.f14151q);
            }
            this.f14151q.save();
            ViewGroup viewGroup = this.f14155u;
            int[] iArr = this.f14156v;
            viewGroup.getLocationOnScreen(iArr);
            BlurView blurView = this.f14153s;
            int[] iArr2 = this.f14157w;
            blurView.getLocationOnScreen(iArr2);
            int i10 = iArr2[0] - iArr[0];
            int i11 = iArr2[1] - iArr[1];
            float height = blurView.getHeight() / this.f14152r.getHeight();
            float width = blurView.getWidth() / this.f14152r.getWidth();
            this.f14151q.translate((-i10) / width, (-i11) / height);
            this.f14151q.scale(1.0f / width, 1.0f / height);
            viewGroup.draw(this.f14151q);
            this.f14151q.restore();
            this.f14152r = this.f14150p.y(this.f14152r, this.f14149o);
            this.f14150p.getClass();
        }
    }
}
