package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public a f13932a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13933b;

    /* renamed from: c, reason: collision with root package name */
    public final int f13934c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13935d;

    /* renamed from: e, reason: collision with root package name */
    public final int f13936e;

    /* renamed from: f, reason: collision with root package name */
    public final int f13937f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public int f13938h;

    /* renamed from: i, reason: collision with root package name */
    public int f13939i;

    /* renamed from: j, reason: collision with root package name */
    public int f13940j;

    /* renamed from: k, reason: collision with root package name */
    public View f13941k;

    /* renamed from: l, reason: collision with root package name */
    public View f13942l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f13943m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f13944n;

    /* renamed from: o, reason: collision with root package name */
    public final Rect f13945o;

    public d() {
        super(-2, -2);
        this.f13933b = false;
        this.f13934c = 0;
        this.f13935d = 0;
        this.f13936e = -1;
        this.f13937f = -1;
        this.g = 0;
        this.f13938h = 0;
        this.f13945o = new Rect();
    }

    public final boolean a(int i10) {
        if (i10 == 0) {
            return this.f13943m;
        }
        if (i10 != 1) {
            return false;
        }
        return this.f13944n;
    }

    public d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar;
        this.f13933b = false;
        this.f13934c = 0;
        this.f13935d = 0;
        this.f13936e = -1;
        this.f13937f = -1;
        this.g = 0;
        this.f13938h = 0;
        this.f13945o = new Rect();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y.a.f13753b);
        this.f13934c = obtainStyledAttributes.getInteger(0, 0);
        this.f13937f = obtainStyledAttributes.getResourceId(1, -1);
        this.f13935d = obtainStyledAttributes.getInteger(2, 0);
        this.f13936e = obtainStyledAttributes.getInteger(6, -1);
        this.g = obtainStyledAttributes.getInt(5, 0);
        this.f13938h = obtainStyledAttributes.getInt(4, 0);
        boolean hasValue = obtainStyledAttributes.hasValue(3);
        this.f13933b = hasValue;
        if (hasValue) {
            String string = obtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.H;
            if (TextUtils.isEmpty(string)) {
                aVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.H;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.J;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.I);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    aVar = (a) constructor.newInstance(context, attributeSet);
                } catch (Exception e7) {
                    throw new RuntimeException(r.a.l("Could not inflate Behavior subclass ", string), e7);
                }
            }
            this.f13932a = aVar;
        }
        obtainStyledAttributes.recycle();
        a aVar2 = this.f13932a;
        if (aVar2 != null) {
            aVar2.c(this);
        }
    }

    public d(d dVar) {
        super((ViewGroup.MarginLayoutParams) dVar);
        this.f13933b = false;
        this.f13934c = 0;
        this.f13935d = 0;
        this.f13936e = -1;
        this.f13937f = -1;
        this.g = 0;
        this.f13938h = 0;
        this.f13945o = new Rect();
    }

    public d(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f13933b = false;
        this.f13934c = 0;
        this.f13935d = 0;
        this.f13936e = -1;
        this.f13937f = -1;
        this.g = 0;
        this.f13938h = 0;
        this.f13945o = new Rect();
    }

    public d(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f13933b = false;
        this.f13934c = 0;
        this.f13935d = 0;
        this.f13936e = -1;
        this.f13937f = -1;
        this.g = 0;
        this.f13938h = 0;
        this.f13945o = new Rect();
    }
}
