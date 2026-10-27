package h;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.StateSet;
import p.g;
import p.h;
import p.j;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b extends Drawable.ConstantState {
    public boolean A;
    public ColorFilter B;
    public boolean C;
    public ColorStateList D;
    public PorterDuff.Mode E;
    public boolean F;
    public boolean G;
    public int[][] H;
    public g I;
    public j J;

    /* renamed from: a, reason: collision with root package name */
    public final e f5471a;

    /* renamed from: b, reason: collision with root package name */
    public Resources f5472b;

    /* renamed from: c, reason: collision with root package name */
    public int f5473c;

    /* renamed from: d, reason: collision with root package name */
    public int f5474d;

    /* renamed from: e, reason: collision with root package name */
    public int f5475e;

    /* renamed from: f, reason: collision with root package name */
    public SparseArray f5476f;
    public Drawable[] g;

    /* renamed from: h, reason: collision with root package name */
    public int f5477h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f5478i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5479j;

    /* renamed from: k, reason: collision with root package name */
    public Rect f5480k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f5481l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5482m;

    /* renamed from: n, reason: collision with root package name */
    public int f5483n;

    /* renamed from: o, reason: collision with root package name */
    public int f5484o;

    /* renamed from: p, reason: collision with root package name */
    public int f5485p;

    /* renamed from: q, reason: collision with root package name */
    public int f5486q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f5487r;

    /* renamed from: s, reason: collision with root package name */
    public int f5488s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f5489t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f5490u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5491v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f5492w;

    /* renamed from: x, reason: collision with root package name */
    public int f5493x;

    /* renamed from: y, reason: collision with root package name */
    public int f5494y;

    /* renamed from: z, reason: collision with root package name */
    public int f5495z;

    public b(b bVar, e eVar, Resources resources) {
        this.f5478i = false;
        this.f5481l = false;
        this.f5492w = true;
        this.f5494y = 0;
        this.f5495z = 0;
        this.f5471a = eVar;
        this.f5472b = resources != null ? resources : bVar != null ? bVar.f5472b : null;
        int i10 = bVar != null ? bVar.f5473c : 0;
        int i11 = e.H;
        i10 = resources != null ? resources.getDisplayMetrics().densityDpi : i10;
        i10 = i10 == 0 ? 160 : i10;
        this.f5473c = i10;
        if (bVar != null) {
            this.f5474d = bVar.f5474d;
            this.f5475e = bVar.f5475e;
            this.f5490u = true;
            this.f5491v = true;
            this.f5478i = bVar.f5478i;
            this.f5481l = bVar.f5481l;
            this.f5492w = bVar.f5492w;
            this.f5493x = bVar.f5493x;
            this.f5494y = bVar.f5494y;
            this.f5495z = bVar.f5495z;
            this.A = bVar.A;
            this.B = bVar.B;
            this.C = bVar.C;
            this.D = bVar.D;
            this.E = bVar.E;
            this.F = bVar.F;
            this.G = bVar.G;
            if (bVar.f5473c == i10) {
                if (bVar.f5479j) {
                    this.f5480k = bVar.f5480k != null ? new Rect(bVar.f5480k) : null;
                    this.f5479j = true;
                }
                if (bVar.f5482m) {
                    this.f5483n = bVar.f5483n;
                    this.f5484o = bVar.f5484o;
                    this.f5485p = bVar.f5485p;
                    this.f5486q = bVar.f5486q;
                    this.f5482m = true;
                }
            }
            if (bVar.f5487r) {
                this.f5488s = bVar.f5488s;
                this.f5487r = true;
            }
            if (bVar.f5489t) {
                this.f5489t = true;
            }
            Drawable[] drawableArr = bVar.g;
            this.g = new Drawable[drawableArr.length];
            this.f5477h = bVar.f5477h;
            SparseArray sparseArray = bVar.f5476f;
            if (sparseArray != null) {
                this.f5476f = sparseArray.clone();
            } else {
                this.f5476f = new SparseArray(this.f5477h);
            }
            int i12 = this.f5477h;
            for (int i13 = 0; i13 < i12; i13++) {
                Drawable drawable = drawableArr[i13];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f5476f.put(i13, constantState);
                    } else {
                        this.g[i13] = drawableArr[i13];
                    }
                }
            }
        } else {
            this.g = new Drawable[10];
            this.f5477h = 0;
        }
        if (bVar != null) {
            this.H = bVar.H;
        } else {
            this.H = new int[this.g.length][];
        }
        if (bVar != null) {
            this.I = bVar.I;
            this.J = bVar.J;
        } else {
            this.I = new g();
            this.J = new j();
        }
    }

    public final int a(Drawable drawable) {
        int i10 = this.f5477h;
        if (i10 >= this.g.length) {
            int i11 = i10 + 10;
            Drawable[] drawableArr = new Drawable[i11];
            Drawable[] drawableArr2 = this.g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i10);
            }
            this.g = drawableArr;
            int[][] iArr = new int[i11][];
            System.arraycopy(this.H, 0, iArr, 0, i10);
            this.H = iArr;
        }
        drawable.mutate();
        drawable.setVisible(false, true);
        drawable.setCallback(this.f5471a);
        this.g[i10] = drawable;
        this.f5477h++;
        this.f5475e = drawable.getChangingConfigurations() | this.f5475e;
        this.f5487r = false;
        this.f5489t = false;
        this.f5480k = null;
        this.f5479j = false;
        this.f5482m = false;
        this.f5490u = false;
        return i10;
    }

    public final void b() {
        this.f5482m = true;
        c();
        int i10 = this.f5477h;
        Drawable[] drawableArr = this.g;
        this.f5484o = -1;
        this.f5483n = -1;
        this.f5486q = 0;
        this.f5485p = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            int intrinsicWidth = drawable.getIntrinsicWidth();
            if (intrinsicWidth > this.f5483n) {
                this.f5483n = intrinsicWidth;
            }
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicHeight > this.f5484o) {
                this.f5484o = intrinsicHeight;
            }
            int minimumWidth = drawable.getMinimumWidth();
            if (minimumWidth > this.f5485p) {
                this.f5485p = minimumWidth;
            }
            int minimumHeight = drawable.getMinimumHeight();
            if (minimumHeight > this.f5486q) {
                this.f5486q = minimumHeight;
            }
        }
    }

    public final void c() {
        SparseArray sparseArray = this.f5476f;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i10 = 0; i10 < size; i10++) {
                int keyAt = this.f5476f.keyAt(i10);
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f5476f.valueAt(i10);
                Drawable[] drawableArr = this.g;
                Drawable newDrawable = constantState.newDrawable(this.f5472b);
                newDrawable.setLayoutDirection(this.f5493x);
                Drawable mutate = newDrawable.mutate();
                mutate.setCallback(this.f5471a);
                drawableArr[keyAt] = mutate;
            }
            this.f5476f = null;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        int i10 = this.f5477h;
        Drawable[] drawableArr = this.g;
        for (int i11 = 0; i11 < i10; i11++) {
            Drawable drawable = drawableArr[i11];
            if (drawable == null) {
                Drawable.ConstantState constantState = (Drawable.ConstantState) this.f5476f.get(i11);
                if (constantState != null && constantState.canApplyTheme()) {
                    return true;
                }
            } else if (drawable.canApplyTheme()) {
                return true;
            }
        }
        return false;
    }

    public final Drawable d(int i10) {
        int indexOfKey;
        Drawable drawable = this.g[i10];
        if (drawable != null) {
            return drawable;
        }
        SparseArray sparseArray = this.f5476f;
        if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i10)) < 0) {
            return null;
        }
        Drawable newDrawable = ((Drawable.ConstantState) this.f5476f.valueAt(indexOfKey)).newDrawable(this.f5472b);
        newDrawable.setLayoutDirection(this.f5493x);
        Drawable mutate = newDrawable.mutate();
        mutate.setCallback(this.f5471a);
        this.g[i10] = mutate;
        this.f5476f.removeAt(indexOfKey);
        if (this.f5476f.size() == 0) {
            this.f5476f = null;
        }
        return mutate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public final int e(int i10) {
        ?? r52;
        if (i10 < 0) {
            return 0;
        }
        j jVar = this.J;
        int i11 = 0;
        int a10 = q.a.a(jVar.f9784q, i10, jVar.f9782o);
        if (a10 >= 0 && (r52 = jVar.f9783p[a10]) != h.f9778b) {
            i11 = r52;
        }
        return i11.intValue();
    }

    public final int f(int[] iArr) {
        int[][] iArr2 = this.H;
        int i10 = this.f5477h;
        for (int i11 = 0; i11 < i10; i11++) {
            if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                return i11;
            }
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return this.f5474d | this.f5475e;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new e(this, null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        return new e(this, resources);
    }
}
