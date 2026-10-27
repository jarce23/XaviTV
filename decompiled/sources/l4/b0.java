package l4;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class b0 extends com.bumptech.glide.d {

    /* renamed from: d, reason: collision with root package name */
    public static boolean f8192d = true;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f8193e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f8194f = true;
    public static boolean g = true;

    @Override // com.bumptech.glide.d
    public void G(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.G(view, i10);
        } else if (g) {
            try {
                a0.a(view, i10);
            } catch (NoSuchMethodError unused) {
                g = false;
            }
        }
    }

    public void Q(View view, int i10, int i11, int i12, int i13) {
        if (f8194f) {
            try {
                z.a(view, i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f8194f = false;
            }
        }
    }

    public void R(View view, Matrix matrix) {
        if (f8192d) {
            try {
                y.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                f8192d = false;
            }
        }
    }

    public void S(View view, Matrix matrix) {
        if (f8193e) {
            try {
                y.c(view, matrix);
            } catch (NoSuchMethodError unused) {
                f8193e = false;
            }
        }
    }
}
