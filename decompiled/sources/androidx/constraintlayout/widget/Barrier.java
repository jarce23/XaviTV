package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import java.util.HashMap;
import u.a;
import u.d;
import x.b;
import x.p;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Barrier extends b {

    /* renamed from: v, reason: collision with root package name */
    public int f492v;

    /* renamed from: w, reason: collision with root package name */
    public int f493w;

    /* renamed from: x, reason: collision with root package name */
    public a f494x;

    public Barrier(Context context) {
        super(context);
        this.f13170o = new int[32];
        this.f13176u = new HashMap();
        this.f13172q = context;
        g(null);
        super.setVisibility(8);
    }

    @Override // x.b
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        a aVar = new a();
        aVar.f12032r0 = 0;
        aVar.f12033s0 = true;
        aVar.f12034t0 = 0;
        aVar.f12035u0 = false;
        this.f494x = aVar;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f13318b);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == 26) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == 25) {
                    this.f494x.f12033s0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == 27) {
                    this.f494x.f12034t0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f13173r = this.f494x;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f494x.f12033s0;
    }

    public int getMargin() {
        return this.f494x.f12034t0;
    }

    public int getType() {
        return this.f492v;
    }

    @Override // x.b
    public final void h(d dVar, boolean z10) {
        int i10 = this.f492v;
        this.f493w = i10;
        if (z10) {
            if (i10 == 5) {
                this.f493w = 1;
            } else if (i10 == 6) {
                this.f493w = 0;
            }
        } else if (i10 == 5) {
            this.f493w = 0;
        } else if (i10 == 6) {
            this.f493w = 1;
        }
        if (dVar instanceof a) {
            ((a) dVar).f12032r0 = this.f493w;
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f494x.f12033s0 = z10;
    }

    public void setDpMargin(int i10) {
        this.f494x.f12034t0 = (int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i10) {
        this.f494x.f12034t0 = i10;
    }

    public void setType(int i10) {
        this.f492v = i10;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
