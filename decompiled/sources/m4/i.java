package m4;

import android.graphics.Paint;
import c2.j1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends l {

    /* renamed from: d, reason: collision with root package name */
    public j1 f8891d;

    /* renamed from: e, reason: collision with root package name */
    public float f8892e;

    /* renamed from: f, reason: collision with root package name */
    public j1 f8893f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public float f8894h;

    /* renamed from: i, reason: collision with root package name */
    public float f8895i;

    /* renamed from: j, reason: collision with root package name */
    public float f8896j;

    /* renamed from: k, reason: collision with root package name */
    public float f8897k;

    /* renamed from: l, reason: collision with root package name */
    public Paint.Cap f8898l;

    /* renamed from: m, reason: collision with root package name */
    public Paint.Join f8899m;

    /* renamed from: n, reason: collision with root package name */
    public float f8900n;

    @Override // m4.k
    public final boolean a() {
        return this.f8893f.j() || this.f8891d.j();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // m4.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(int[] r7) {
        /*
            r6 = this;
            c2.j1 r0 = r6.f8893f
            boolean r1 = r0.j()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L1e
            java.lang.Object r1 = r0.f2627r
            android.content.res.ColorStateList r1 = (android.content.res.ColorStateList) r1
            int r4 = r1.getDefaultColor()
            int r1 = r1.getColorForState(r7, r4)
            int r4 = r0.f2625p
            if (r1 == r4) goto L1e
            r0.f2625p = r1
            r0 = r2
            goto L1f
        L1e:
            r0 = r3
        L1f:
            c2.j1 r1 = r6.f8891d
            boolean r4 = r1.j()
            if (r4 == 0) goto L3a
            java.lang.Object r4 = r1.f2627r
            android.content.res.ColorStateList r4 = (android.content.res.ColorStateList) r4
            int r5 = r4.getDefaultColor()
            int r7 = r4.getColorForState(r7, r5)
            int r4 = r1.f2625p
            if (r7 == r4) goto L3a
            r1.f2625p = r7
            goto L3b
        L3a:
            r2 = r3
        L3b:
            r7 = r0 | r2
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.i.b(int[]):boolean");
    }

    public float getFillAlpha() {
        return this.f8894h;
    }

    public int getFillColor() {
        return this.f8893f.f2625p;
    }

    public float getStrokeAlpha() {
        return this.g;
    }

    public int getStrokeColor() {
        return this.f8891d.f2625p;
    }

    public float getStrokeWidth() {
        return this.f8892e;
    }

    public float getTrimPathEnd() {
        return this.f8896j;
    }

    public float getTrimPathOffset() {
        return this.f8897k;
    }

    public float getTrimPathStart() {
        return this.f8895i;
    }

    public void setFillAlpha(float f10) {
        this.f8894h = f10;
    }

    public void setFillColor(int i10) {
        this.f8893f.f2625p = i10;
    }

    public void setStrokeAlpha(float f10) {
        this.g = f10;
    }

    public void setStrokeColor(int i10) {
        this.f8891d.f2625p = i10;
    }

    public void setStrokeWidth(float f10) {
        this.f8892e = f10;
    }

    public void setTrimPathEnd(float f10) {
        this.f8896j = f10;
    }

    public void setTrimPathOffset(float f10) {
        this.f8897k = f10;
    }

    public void setTrimPathStart(float f10) {
        this.f8895i = f10;
    }
}
