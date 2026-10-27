package d9;

import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class h extends Drawable.ConstantState {

    /* renamed from: a, reason: collision with root package name */
    public n f4259a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f4260b;

    /* renamed from: c, reason: collision with root package name */
    public w8.a f4261c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f4262d;

    /* renamed from: e, reason: collision with root package name */
    public ColorStateList f4263e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f4264f;
    public PorterDuff.Mode g;

    /* renamed from: h, reason: collision with root package name */
    public Rect f4265h;

    /* renamed from: i, reason: collision with root package name */
    public final float f4266i;

    /* renamed from: j, reason: collision with root package name */
    public float f4267j;

    /* renamed from: k, reason: collision with root package name */
    public float f4268k;

    /* renamed from: l, reason: collision with root package name */
    public int f4269l;

    /* renamed from: m, reason: collision with root package name */
    public float f4270m;

    /* renamed from: n, reason: collision with root package name */
    public float f4271n;

    /* renamed from: o, reason: collision with root package name */
    public int f4272o;

    /* renamed from: p, reason: collision with root package name */
    public int f4273p;

    /* renamed from: q, reason: collision with root package name */
    public final Paint.Style f4274q;

    public h(n nVar) {
        this.f4262d = null;
        this.f4263e = null;
        this.f4264f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.f4265h = null;
        this.f4266i = 1.0f;
        this.f4267j = 1.0f;
        this.f4269l = 255;
        this.f4270m = 0.0f;
        this.f4271n = 0.0f;
        this.f4272o = 0;
        this.f4273p = 0;
        this.f4274q = Paint.Style.FILL_AND_STROKE;
        this.f4259a = nVar;
        this.f4261c = null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        j jVar = new j(this);
        jVar.f4281t = true;
        jVar.f4282u = true;
        return jVar;
    }

    public h(h hVar) {
        this.f4262d = null;
        this.f4263e = null;
        this.f4264f = null;
        this.g = PorterDuff.Mode.SRC_IN;
        this.f4265h = null;
        this.f4266i = 1.0f;
        this.f4267j = 1.0f;
        this.f4269l = 255;
        this.f4270m = 0.0f;
        this.f4271n = 0.0f;
        this.f4272o = 0;
        this.f4273p = 0;
        this.f4274q = Paint.Style.FILL_AND_STROKE;
        this.f4259a = hVar.f4259a;
        this.f4260b = hVar.f4260b;
        this.f4261c = hVar.f4261c;
        this.f4268k = hVar.f4268k;
        this.f4262d = hVar.f4262d;
        this.f4263e = hVar.f4263e;
        this.g = hVar.g;
        this.f4264f = hVar.f4264f;
        this.f4269l = hVar.f4269l;
        this.f4266i = hVar.f4266i;
        this.f4273p = hVar.f4273p;
        this.f4267j = hVar.f4267j;
        this.f4270m = hVar.f4270m;
        this.f4271n = hVar.f4271n;
        this.f4272o = hVar.f4272o;
        this.f4274q = hVar.f4274q;
        if (hVar.f4265h != null) {
            this.f4265h = new Rect(hVar.f4265h);
        }
    }
}
