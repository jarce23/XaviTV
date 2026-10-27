package m0;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f8671a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f8672b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f8673c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8674d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f8675e;

    public j(ViewGroup viewGroup) {
        this.f8673c = viewGroup;
    }

    public final boolean a(float f10, float f11, boolean z10) {
        ViewParent e7;
        if (this.f8674d && (e7 = e(0)) != null) {
            try {
                return e7.onNestedFling(this.f8673c, f10, f11, z10);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + e7 + " does not implement interface method onNestedFling", e8);
            }
        }
        return false;
    }

    public final boolean b(float f10, float f11) {
        ViewParent e7;
        if (this.f8674d && (e7 = e(0)) != null) {
            try {
                return e7.onNestedPreFling(this.f8673c, f10, f11);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + e7 + " does not implement interface method onNestedPreFling", e8);
            }
        }
        return false;
    }

    public final boolean c(int i10, int i11, int i12, int[] iArr, int[] iArr2) {
        ViewParent e7;
        int i13;
        int i14;
        int[] iArr3;
        if (!this.f8674d || (e7 = e(i12)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f8673c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i13 = iArr2[0];
            i14 = iArr2[1];
        } else {
            i13 = 0;
            i14 = 0;
        }
        if (iArr == null) {
            if (this.f8675e == null) {
                this.f8675e = new int[2];
            }
            iArr3 = this.f8675e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (e7 instanceof k) {
            ((k) e7).c(viewGroup, i10, i11, iArr3, i12);
        } else if (i12 == 0) {
            try {
                e7.onNestedPreScroll(viewGroup, i10, i11, iArr3);
            } catch (AbstractMethodError e8) {
                Log.e("ViewParentCompat", "ViewParent " + e7 + " does not implement interface method onNestedPreScroll", e8);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i13;
            iArr2[1] = iArr2[1] - i14;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent e7;
        int i15;
        int i16;
        int[] iArr3;
        if (this.f8674d && (e7 = e(i14)) != null) {
            if (i10 != 0 || i11 != 0 || i12 != 0 || i13 != 0) {
                ViewGroup viewGroup = this.f8673c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i15 = iArr[0];
                    i16 = iArr[1];
                } else {
                    i15 = 0;
                    i16 = 0;
                }
                if (iArr2 == null) {
                    if (this.f8675e == null) {
                        this.f8675e = new int[2];
                    }
                    int[] iArr4 = this.f8675e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (e7 instanceof l) {
                    ((l) e7).d(viewGroup, i10, i11, i12, i13, i14, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i12;
                    iArr3[1] = iArr3[1] + i13;
                    if (e7 instanceof k) {
                        ((k) e7).e(viewGroup, i10, i11, i12, i13, i14);
                    } else if (i14 == 0) {
                        try {
                            e7.onNestedScroll(viewGroup, i10, i11, i12, i13);
                        } catch (AbstractMethodError e8) {
                            Log.e("ViewParentCompat", "ViewParent " + e7 + " does not implement interface method onNestedScroll", e8);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i15;
                    iArr[1] = iArr[1] - i16;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i10) {
        if (i10 == 0) {
            return this.f8671a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f8672b;
    }

    public final boolean f(int i10) {
        return e(i10) != null;
    }

    public final boolean g(int i10, int i11) {
        boolean onStartNestedScroll;
        if (!f(i11)) {
            if (this.f8674d) {
                View view = this.f8673c;
                View view2 = view;
                for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z10 = parent instanceof k;
                    if (z10) {
                        onStartNestedScroll = ((k) parent).f(view2, view, i10, i11);
                    } else {
                        if (i11 == 0) {
                            try {
                                onStartNestedScroll = parent.onStartNestedScroll(view2, view, i10);
                            } catch (AbstractMethodError e7) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e7);
                            }
                        }
                        onStartNestedScroll = false;
                    }
                    if (onStartNestedScroll) {
                        if (i11 == 0) {
                            this.f8671a = parent;
                        } else if (i11 == 1) {
                            this.f8672b = parent;
                        }
                        if (z10) {
                            ((k) parent).a(view2, view, i10, i11);
                        } else if (i11 == 0) {
                            try {
                                parent.onNestedScrollAccepted(view2, view, i10);
                            } catch (AbstractMethodError e8) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e8);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view2 = parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void h(int i10) {
        ViewParent e7 = e(i10);
        if (e7 != null) {
            boolean z10 = e7 instanceof k;
            ViewGroup viewGroup = this.f8673c;
            if (z10) {
                ((k) e7).b(viewGroup, i10);
            } else if (i10 == 0) {
                try {
                    e7.onStopNestedScroll(viewGroup);
                } catch (AbstractMethodError e8) {
                    Log.e("ViewParentCompat", "ViewParent " + e7 + " does not implement interface method onStopNestedScroll", e8);
                }
            }
            if (i10 == 0) {
                this.f8671a = null;
            } else {
                if (i10 != 1) {
                    return;
                }
                this.f8672b = null;
            }
        }
    }
}
