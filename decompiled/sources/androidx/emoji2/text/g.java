package androidx.emoji2.text;

import android.graphics.Rect;
import android.view.View;
import b4.o0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public int f569a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f570b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f571c;

    public g(o0 o0Var) {
        this.f569a = Integer.MIN_VALUE;
        this.f571c = new Rect();
        this.f570b = o0Var;
    }

    public static g a(o0 o0Var, int i10) {
        if (i10 == 0) {
            return new b4.z(o0Var, 0);
        }
        if (i10 == 1) {
            return new b4.z(o0Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i10);

    public g(k kVar) {
        this.f569a = 0;
        this.f571c = new d();
        this.f570b = kVar;
    }
}
