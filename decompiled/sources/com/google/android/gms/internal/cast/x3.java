package com.google.android.gms.internal.cast;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class x3 extends y7.d {
    @Override // y7.d
    public final v3 B(b4 b4Var) {
        v3 v3Var;
        v3 v3Var2 = v3.f3528d;
        synchronized (b4Var) {
            try {
                v3Var = b4Var.f3267q;
                if (v3Var != v3Var2) {
                    b4Var.f3267q = v3Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return v3Var;
    }

    @Override // y7.d
    public final a4 F(b4 b4Var) {
        a4 a4Var;
        a4 a4Var2 = a4.f3250c;
        synchronized (b4Var) {
            try {
                a4Var = b4Var.f3268r;
                if (a4Var != a4Var2) {
                    b4Var.f3268r = a4Var2;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return a4Var;
    }

    @Override // y7.d
    public final void H(a4 a4Var, a4 a4Var2) {
        a4Var.f3252b = a4Var2;
    }

    @Override // y7.d
    public final void I(a4 a4Var, Thread thread) {
        a4Var.f3251a = thread;
    }

    @Override // y7.d
    public final boolean J(b4 b4Var, v3 v3Var, v3 v3Var2) {
        synchronized (b4Var) {
            try {
                if (b4Var.f3267q != v3Var) {
                    return false;
                }
                b4Var.f3267q = v3Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y7.d
    public final boolean K(b4 b4Var, Object obj, Object obj2) {
        synchronized (b4Var) {
            try {
                if (b4Var.f3266p != obj) {
                    return false;
                }
                b4Var.f3266p = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // y7.d
    public final boolean L(b4 b4Var, a4 a4Var, a4 a4Var2) {
        synchronized (b4Var) {
            try {
                if (b4Var.f3268r != a4Var) {
                    return false;
                }
                b4Var.f3268r = a4Var2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
