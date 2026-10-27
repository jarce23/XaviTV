package com.google.android.material.datepicker;

import android.view.View;
import java.util.NoSuchElementException;
import m0.q1;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m implements m0.m, e3.c {

    /* renamed from: o, reason: collision with root package name */
    public int f3771o;

    /* renamed from: p, reason: collision with root package name */
    public int f3772p;

    /* renamed from: q, reason: collision with root package name */
    public int f3773q;

    /* renamed from: r, reason: collision with root package name */
    public int f3774r;

    /* renamed from: s, reason: collision with root package name */
    public Object f3775s;

    @Override // e3.c
    public int a() {
        return -1;
    }

    @Override // e3.c
    public int b() {
        return this.f3771o;
    }

    @Override // e3.c
    public int c() {
        l1.t tVar = (l1.t) this.f3775s;
        int i10 = this.f3772p;
        if (i10 == 8) {
            return tVar.w();
        }
        if (i10 == 16) {
            return tVar.C();
        }
        int i11 = this.f3773q;
        this.f3773q = i11 + 1;
        if (i11 % 2 != 0) {
            return this.f3774r & 15;
        }
        int w10 = tVar.w();
        this.f3774r = w10;
        return (w10 & 240) >> 4;
    }

    public long d() {
        int i10 = this.f3773q;
        if (i10 == 0) {
            throw new NoSuchElementException();
        }
        long[] jArr = (long[]) this.f3775s;
        int i11 = this.f3771o;
        long j10 = jArr[i11];
        this.f3771o = this.f3774r & (i11 + 1);
        this.f3773q = i10 - 1;
        return j10;
    }

    @Override // m0.m
    public q1 f(View view, q1 q1Var) {
        View view2 = (View) this.f3775s;
        e0.c f10 = q1Var.f8706a.f(519);
        int i10 = this.f3771o;
        if (i10 >= 0) {
            view2.getLayoutParams().height = i10 + f10.f4386b;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(this.f3772p + f10.f4385a, this.f3773q + f10.f4386b, this.f3774r + f10.f4387c, view2.getPaddingBottom());
        return q1Var;
    }
}
