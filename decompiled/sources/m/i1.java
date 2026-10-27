package m;

import android.R;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class i1 {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f8438a = {R.attr.state_checked};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8439b = new int[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Rect f8440c = new Rect();

    public static void a(Drawable drawable) {
        String name = drawable.getClass().getName();
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 29 || i10 >= 31 || !"android.graphics.drawable.ColorStateListDrawable".equals(name)) {
            return;
        }
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(f8438a);
        } else {
            drawable.setState(f8439b);
        }
        drawable.setState(state);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Rect b(Drawable drawable) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14 = Build.VERSION.SDK_INT;
        if (i14 >= 29) {
            Insets a10 = h1.a(drawable);
            i10 = a10.left;
            i11 = a10.top;
            i12 = a10.right;
            i13 = a10.bottom;
            return new Rect(i10, i11, i12, i13);
        }
        boolean z10 = drawable instanceof f0.a;
        Object obj = drawable;
        if (z10) {
            ((f0.b) ((f0.a) drawable)).getClass();
            obj = null;
        }
        if (i14 >= 29) {
            boolean z11 = g1.f8414a;
        } else if (g1.f8414a) {
            try {
                Object invoke = g1.f8415b.invoke(obj, null);
                if (invoke != null) {
                    return new Rect(g1.f8416c.getInt(invoke), g1.f8417d.getInt(invoke), g1.f8418e.getInt(invoke), g1.f8419f.getInt(invoke));
                }
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        return f8440c;
    }

    public static PorterDuff.Mode c(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                return PorterDuff.Mode.SCREEN;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
