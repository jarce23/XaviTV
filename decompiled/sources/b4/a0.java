package b4;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 extends y {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f2173q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f2174r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(Object obj, Context context, int i10) {
        super(context);
        this.f2173q = i10;
        this.f2174r = obj;
    }

    @Override // b4.y
    public int b(View view, int i10) {
        switch (this.f2173q) {
            case 1:
                ((CarouselLayoutManager) this.f2174r).getClass();
                return 0;
            default:
                return super.b(view, i10);
        }
    }

    @Override // b4.y
    public int c(View view, int i10) {
        switch (this.f2173q) {
            case 1:
                ((CarouselLayoutManager) this.f2174r).getClass();
                return 0;
            default:
                return super.c(view, i10);
        }
    }

    @Override // b4.y
    public float d(DisplayMetrics displayMetrics) {
        switch (this.f2173q) {
            case 0:
                return 100.0f / displayMetrics.densityDpi;
            default:
                return super.d(displayMetrics);
        }
    }

    @Override // b4.y
    public int e(int i10) {
        switch (this.f2173q) {
            case 0:
                return Math.min(100, super.e(i10));
            default:
                return super.e(i10);
        }
    }

    @Override // b4.y
    public PointF f(int i10) {
        switch (this.f2173q) {
            case 1:
                return null;
            default:
                return super.f(i10);
        }
    }

    @Override // b4.y
    public void i(View view, z0 z0Var) {
        switch (this.f2173q) {
            case 0:
                b0 b0Var = (b0) this.f2174r;
                int[] a10 = b0Var.a(b0Var.f2181a.getLayoutManager(), view);
                int i10 = a10[0];
                int i11 = a10[1];
                int ceil = (int) Math.ceil(e(Math.max(Math.abs(i10), Math.abs(i11))) / 0.3356d);
                if (ceil > 0) {
                    z0Var.f2467a = i10;
                    z0Var.f2468b = i11;
                    z0Var.f2469c = ceil;
                    z0Var.f2471e = this.f2458j;
                    z0Var.f2472f = true;
                    break;
                }
                break;
            default:
                super.i(view, z0Var);
                break;
        }
    }
}
