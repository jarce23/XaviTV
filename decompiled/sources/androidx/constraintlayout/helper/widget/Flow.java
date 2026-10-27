package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.ArrayList;
import u.d;
import u.g;
import v.b;
import x.p;
import x.r;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Flow extends r {

    /* renamed from: x, reason: collision with root package name */
    public g f491x;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // x.r, x.b
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        g gVar = new g();
        gVar.f12128r0 = 0;
        gVar.f12129s0 = 0;
        gVar.f12130t0 = 0;
        gVar.f12131u0 = 0;
        gVar.f12132v0 = 0;
        gVar.f12133w0 = 0;
        gVar.f12134x0 = false;
        gVar.f12135y0 = 0;
        gVar.f12136z0 = 0;
        gVar.A0 = new b();
        gVar.B0 = null;
        gVar.C0 = -1;
        gVar.D0 = -1;
        gVar.E0 = -1;
        gVar.F0 = -1;
        gVar.G0 = -1;
        gVar.H0 = -1;
        gVar.I0 = 0.5f;
        gVar.J0 = 0.5f;
        gVar.K0 = 0.5f;
        gVar.L0 = 0.5f;
        gVar.M0 = 0.5f;
        gVar.N0 = 0.5f;
        gVar.O0 = 0;
        gVar.P0 = 0;
        gVar.Q0 = 2;
        gVar.R0 = 2;
        gVar.S0 = 0;
        gVar.T0 = -1;
        gVar.U0 = 0;
        gVar.V0 = new ArrayList();
        gVar.W0 = null;
        gVar.X0 = null;
        gVar.Y0 = null;
        gVar.f12127a1 = 0;
        this.f491x = gVar;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f13318b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 0) {
                    this.f491x.U0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    g gVar2 = this.f491x;
                    int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f12128r0 = dimensionPixelSize;
                    gVar2.f12129s0 = dimensionPixelSize;
                    gVar2.f12130t0 = dimensionPixelSize;
                    gVar2.f12131u0 = dimensionPixelSize;
                } else if (index == 18) {
                    g gVar3 = this.f491x;
                    int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar3.f12130t0 = dimensionPixelSize2;
                    gVar3.f12132v0 = dimensionPixelSize2;
                    gVar3.f12133w0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f491x.f12131u0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f491x.f12132v0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f491x.f12128r0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f491x.f12133w0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f491x.f12129s0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f491x.S0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f491x.C0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f491x.D0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f491x.E0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f491x.G0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f491x.F0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f491x.H0 = obtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f491x.I0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f491x.K0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f491x.M0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f491x.L0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f491x.N0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f491x.J0 = obtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f491x.Q0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f491x.R0 = obtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f491x.O0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f491x.P0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f491x.T0 = obtainStyledAttributes.getInt(index, -1);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f13173r = this.f491x;
        i();
    }

    @Override // x.b
    public final void h(d dVar, boolean z10) {
        g gVar = this.f491x;
        int i10 = gVar.f12130t0;
        if (i10 > 0 || gVar.f12131u0 > 0) {
            if (z10) {
                gVar.f12132v0 = gVar.f12131u0;
                gVar.f12133w0 = i10;
            } else {
                gVar.f12132v0 = i10;
                gVar.f12133w0 = gVar.f12131u0;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x053c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x054b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0565  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0568  */
    /* JADX WARN: Type inference failed for: r28v2 */
    /* JADX WARN: Type inference failed for: r28v5 */
    /* JADX WARN: Type inference failed for: r28v6 */
    /* JADX WARN: Type inference failed for: r28v7 */
    @Override // x.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(u.g r37, int r38, int r39) {
        /*
            Method dump skipped, instructions count: 1404
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.helper.widget.Flow.j(u.g, int, int):void");
    }

    @Override // x.b, android.view.View
    public final void onMeasure(int i10, int i11) {
        j(this.f491x, i10, i11);
    }

    public void setFirstHorizontalBias(float f10) {
        this.f491x.K0 = f10;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i10) {
        this.f491x.E0 = i10;
        requestLayout();
    }

    public void setFirstVerticalBias(float f10) {
        this.f491x.L0 = f10;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i10) {
        this.f491x.F0 = i10;
        requestLayout();
    }

    public void setHorizontalAlign(int i10) {
        this.f491x.Q0 = i10;
        requestLayout();
    }

    public void setHorizontalBias(float f10) {
        this.f491x.I0 = f10;
        requestLayout();
    }

    public void setHorizontalGap(int i10) {
        this.f491x.O0 = i10;
        requestLayout();
    }

    public void setHorizontalStyle(int i10) {
        this.f491x.C0 = i10;
        requestLayout();
    }

    public void setMaxElementsWrap(int i10) {
        this.f491x.T0 = i10;
        requestLayout();
    }

    public void setOrientation(int i10) {
        this.f491x.U0 = i10;
        requestLayout();
    }

    public void setPadding(int i10) {
        g gVar = this.f491x;
        gVar.f12128r0 = i10;
        gVar.f12129s0 = i10;
        gVar.f12130t0 = i10;
        gVar.f12131u0 = i10;
        requestLayout();
    }

    public void setPaddingBottom(int i10) {
        this.f491x.f12129s0 = i10;
        requestLayout();
    }

    public void setPaddingLeft(int i10) {
        this.f491x.f12132v0 = i10;
        requestLayout();
    }

    public void setPaddingRight(int i10) {
        this.f491x.f12133w0 = i10;
        requestLayout();
    }

    public void setPaddingTop(int i10) {
        this.f491x.f12128r0 = i10;
        requestLayout();
    }

    public void setVerticalAlign(int i10) {
        this.f491x.R0 = i10;
        requestLayout();
    }

    public void setVerticalBias(float f10) {
        this.f491x.J0 = f10;
        requestLayout();
    }

    public void setVerticalGap(int i10) {
        this.f491x.P0 = i10;
        requestLayout();
    }

    public void setVerticalStyle(int i10) {
        this.f491x.D0 = i10;
        requestLayout();
    }

    public void setWrapMode(int i10) {
        this.f491x.S0 = i10;
        requestLayout();
    }
}
