package androidx.leanback.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class u {

    /* renamed from: a, reason: collision with root package name */
    public static final Rect f1086a = new Rect();

    public static int a(View view, t tVar, int i10) {
        View view2;
        int height;
        int width;
        int width2;
        int width3;
        m mVar = (m) view.getLayoutParams();
        int i11 = tVar.f1074a;
        if (i11 == 0 || (view2 = view.findViewById(i11)) == null) {
            view2 = view;
        }
        int i12 = tVar.f1075b;
        Rect rect = f1086a;
        if (i10 != 0) {
            if (tVar.f1077d) {
                float f10 = tVar.f1076c;
                if (f10 == 0.0f) {
                    i12 += view2.getPaddingTop();
                } else if (f10 == 100.0f) {
                    i12 -= view2.getPaddingBottom();
                }
            }
            if (tVar.f1076c != -1.0f) {
                if (view2 == view) {
                    mVar.getClass();
                    height = (view2.getHeight() - mVar.f1037f) - mVar.f1038h;
                } else {
                    height = view2.getHeight();
                }
                i12 += (int) ((height * tVar.f1076c) / 100.0f);
            }
            if (view == view2) {
                return i12;
            }
            rect.top = i12;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
            return rect.top - mVar.f1037f;
        }
        if (view.getLayoutDirection() != 1) {
            if (tVar.f1077d) {
                float f11 = tVar.f1076c;
                if (f11 == 0.0f) {
                    i12 += view2.getPaddingLeft();
                } else if (f11 == 100.0f) {
                    i12 -= view2.getPaddingRight();
                }
            }
            if (tVar.f1076c != -1.0f) {
                if (view2 == view) {
                    mVar.getClass();
                    width = (view2.getWidth() - mVar.f1036e) - mVar.g;
                } else {
                    width = view2.getWidth();
                }
                i12 += (int) ((width * tVar.f1076c) / 100.0f);
            }
            if (view == view2) {
                return i12;
            }
            rect.left = i12;
            ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
            return rect.left - mVar.f1036e;
        }
        if (view2 == view) {
            mVar.getClass();
            width2 = (view2.getWidth() - mVar.f1036e) - mVar.g;
        } else {
            width2 = view2.getWidth();
        }
        int i13 = width2 - i12;
        if (tVar.f1077d) {
            float f12 = tVar.f1076c;
            if (f12 == 0.0f) {
                i13 -= view2.getPaddingRight();
            } else if (f12 == 100.0f) {
                i13 += view2.getPaddingLeft();
            }
        }
        if (tVar.f1076c != -1.0f) {
            if (view2 == view) {
                mVar.getClass();
                width3 = (view2.getWidth() - mVar.f1036e) - mVar.g;
            } else {
                width3 = view2.getWidth();
            }
            i13 -= (int) ((width3 * tVar.f1076c) / 100.0f);
        }
        if (view == view2) {
            return i13;
        }
        rect.right = i13;
        ((ViewGroup) view).offsetDescendantRectToMyCoords(view2, rect);
        return rect.right + mVar.g;
    }
}
