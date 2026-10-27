package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.w0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import org.xmlpull.v1.XmlPullParserException;
import u.h;
import x.b;
import x.c;
import x.d;
import x.e;
import x.f;
import x.m;
import x.n;
import x.p;
import x.q;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {
    public static q F;
    public HashMap A;
    public final SparseArray B;
    public final e C;
    public int D;
    public int E;

    /* renamed from: o, reason: collision with root package name */
    public final SparseArray f495o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f496p;

    /* renamed from: q, reason: collision with root package name */
    public final u.e f497q;

    /* renamed from: r, reason: collision with root package name */
    public int f498r;

    /* renamed from: s, reason: collision with root package name */
    public int f499s;

    /* renamed from: t, reason: collision with root package name */
    public int f500t;

    /* renamed from: u, reason: collision with root package name */
    public int f501u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f502v;

    /* renamed from: w, reason: collision with root package name */
    public int f503w;

    /* renamed from: x, reason: collision with root package name */
    public m f504x;

    /* renamed from: y, reason: collision with root package name */
    public x4.e f505y;

    /* renamed from: z, reason: collision with root package name */
    public int f506z;

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f495o = new SparseArray();
        this.f496p = new ArrayList(4);
        this.f497q = new u.e();
        this.f498r = 0;
        this.f499s = 0;
        this.f500t = Integer.MAX_VALUE;
        this.f501u = Integer.MAX_VALUE;
        this.f502v = true;
        this.f503w = 257;
        this.f504x = null;
        this.f505y = null;
        this.f506z = -1;
        this.A = new HashMap();
        this.B = new SparseArray();
        this.C = new e(this, this);
        this.D = 0;
        this.E = 0;
        i(attributeSet, 0);
    }

    public static d g() {
        d dVar = new d(-2, -2);
        dVar.f13178a = -1;
        dVar.f13180b = -1;
        dVar.f13182c = -1.0f;
        dVar.f13184d = -1;
        dVar.f13186e = -1;
        dVar.f13188f = -1;
        dVar.g = -1;
        dVar.f13191h = -1;
        dVar.f13192i = -1;
        dVar.f13194j = -1;
        dVar.f13196k = -1;
        dVar.f13198l = -1;
        dVar.f13200m = -1;
        dVar.f13202n = -1;
        dVar.f13204o = -1;
        dVar.f13206p = 0;
        dVar.f13207q = 0.0f;
        dVar.f13208r = -1;
        dVar.f13209s = -1;
        dVar.f13210t = -1;
        dVar.f13211u = -1;
        dVar.f13212v = Integer.MIN_VALUE;
        dVar.f13213w = Integer.MIN_VALUE;
        dVar.f13214x = Integer.MIN_VALUE;
        dVar.f13215y = Integer.MIN_VALUE;
        dVar.f13216z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = 0;
        dVar.D = 0.5f;
        dVar.E = 0.5f;
        dVar.F = null;
        dVar.G = -1.0f;
        dVar.H = -1.0f;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 1.0f;
        dVar.R = 1.0f;
        dVar.S = -1;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = false;
        dVar.W = false;
        dVar.X = null;
        dVar.Y = 0;
        dVar.Z = true;
        dVar.f13179a0 = true;
        dVar.f13181b0 = false;
        dVar.f13183c0 = false;
        dVar.f13185d0 = false;
        dVar.f13187e0 = -1;
        dVar.f13189f0 = -1;
        dVar.f13190g0 = -1;
        dVar.h0 = -1;
        dVar.f13193i0 = Integer.MIN_VALUE;
        dVar.f13195j0 = Integer.MIN_VALUE;
        dVar.f13197k0 = 0.5f;
        dVar.f13205o0 = new u.d();
        return dVar;
    }

    private int getPaddingWidth() {
        int max = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int max2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return max2 > 0 ? max2 : max;
    }

    public static q getSharedValues() {
        if (F == null) {
            q qVar = new q();
            new SparseIntArray();
            new HashMap();
            F = qVar;
        }
        return F;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f496p;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((b) arrayList.get(i10)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] split = ((String) tag).split(",");
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i12 = (int) ((parseInt / 1080.0f) * width);
                        int i13 = (int) ((parseInt2 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i12;
                        float f11 = i13;
                        float f12 = i12 + ((int) ((parseInt3 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float parseInt4 = i13 + ((int) ((Integer.parseInt(split[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, parseInt4, paint);
                        canvas.drawLine(f12, parseInt4, f10, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, parseInt4, paint);
                        canvas.drawLine(f10, parseInt4, f12, f11, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f502v = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        d dVar = new d(context, attributeSet);
        dVar.f13178a = -1;
        dVar.f13180b = -1;
        dVar.f13182c = -1.0f;
        dVar.f13184d = -1;
        dVar.f13186e = -1;
        dVar.f13188f = -1;
        dVar.g = -1;
        dVar.f13191h = -1;
        dVar.f13192i = -1;
        dVar.f13194j = -1;
        dVar.f13196k = -1;
        dVar.f13198l = -1;
        dVar.f13200m = -1;
        dVar.f13202n = -1;
        dVar.f13204o = -1;
        dVar.f13206p = 0;
        dVar.f13207q = 0.0f;
        dVar.f13208r = -1;
        dVar.f13209s = -1;
        dVar.f13210t = -1;
        dVar.f13211u = -1;
        dVar.f13212v = Integer.MIN_VALUE;
        dVar.f13213w = Integer.MIN_VALUE;
        dVar.f13214x = Integer.MIN_VALUE;
        dVar.f13215y = Integer.MIN_VALUE;
        dVar.f13216z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = 0;
        dVar.D = 0.5f;
        dVar.E = 0.5f;
        dVar.F = null;
        dVar.G = -1.0f;
        dVar.H = -1.0f;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 1.0f;
        dVar.R = 1.0f;
        dVar.S = -1;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = false;
        dVar.W = false;
        dVar.X = null;
        dVar.Y = 0;
        dVar.Z = true;
        dVar.f13179a0 = true;
        dVar.f13181b0 = false;
        dVar.f13183c0 = false;
        dVar.f13185d0 = false;
        dVar.f13187e0 = -1;
        dVar.f13189f0 = -1;
        dVar.f13190g0 = -1;
        dVar.h0 = -1;
        dVar.f13193i0 = Integer.MIN_VALUE;
        dVar.f13195j0 = Integer.MIN_VALUE;
        dVar.f13197k0 = 0.5f;
        dVar.f13205o0 = new u.d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f13318b);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            int i11 = c.f13177a.get(index);
            switch (i11) {
                case 1:
                    dVar.U = obtainStyledAttributes.getInt(index, dVar.U);
                    break;
                case 2:
                    int resourceId = obtainStyledAttributes.getResourceId(index, dVar.f13204o);
                    dVar.f13204o = resourceId;
                    if (resourceId == -1) {
                        dVar.f13204o = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    dVar.f13206p = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13206p);
                    break;
                case 4:
                    float f10 = obtainStyledAttributes.getFloat(index, dVar.f13207q) % 360.0f;
                    dVar.f13207q = f10;
                    if (f10 < 0.0f) {
                        dVar.f13207q = (360.0f - f10) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    dVar.f13178a = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.f13178a);
                    break;
                case 6:
                    dVar.f13180b = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.f13180b);
                    break;
                case 7:
                    dVar.f13182c = obtainStyledAttributes.getFloat(index, dVar.f13182c);
                    break;
                case 8:
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, dVar.f13184d);
                    dVar.f13184d = resourceId2;
                    if (resourceId2 == -1) {
                        dVar.f13184d = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = obtainStyledAttributes.getResourceId(index, dVar.f13186e);
                    dVar.f13186e = resourceId3;
                    if (resourceId3 == -1) {
                        dVar.f13186e = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = obtainStyledAttributes.getResourceId(index, dVar.f13188f);
                    dVar.f13188f = resourceId4;
                    if (resourceId4 == -1) {
                        dVar.f13188f = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = obtainStyledAttributes.getResourceId(index, dVar.g);
                    dVar.g = resourceId5;
                    if (resourceId5 == -1) {
                        dVar.g = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    int resourceId6 = obtainStyledAttributes.getResourceId(index, dVar.f13191h);
                    dVar.f13191h = resourceId6;
                    if (resourceId6 == -1) {
                        dVar.f13191h = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    int resourceId7 = obtainStyledAttributes.getResourceId(index, dVar.f13192i);
                    dVar.f13192i = resourceId7;
                    if (resourceId7 == -1) {
                        dVar.f13192i = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    int resourceId8 = obtainStyledAttributes.getResourceId(index, dVar.f13194j);
                    dVar.f13194j = resourceId8;
                    if (resourceId8 == -1) {
                        dVar.f13194j = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    int resourceId9 = obtainStyledAttributes.getResourceId(index, dVar.f13196k);
                    dVar.f13196k = resourceId9;
                    if (resourceId9 == -1) {
                        dVar.f13196k = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    int resourceId10 = obtainStyledAttributes.getResourceId(index, dVar.f13198l);
                    dVar.f13198l = resourceId10;
                    if (resourceId10 == -1) {
                        dVar.f13198l = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    int resourceId11 = obtainStyledAttributes.getResourceId(index, dVar.f13208r);
                    dVar.f13208r = resourceId11;
                    if (resourceId11 == -1) {
                        dVar.f13208r = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = obtainStyledAttributes.getResourceId(index, dVar.f13209s);
                    dVar.f13209s = resourceId12;
                    if (resourceId12 == -1) {
                        dVar.f13209s = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 19:
                    int resourceId13 = obtainStyledAttributes.getResourceId(index, dVar.f13210t);
                    dVar.f13210t = resourceId13;
                    if (resourceId13 == -1) {
                        dVar.f13210t = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 20:
                    int resourceId14 = obtainStyledAttributes.getResourceId(index, dVar.f13211u);
                    dVar.f13211u = resourceId14;
                    if (resourceId14 == -1) {
                        dVar.f13211u = obtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 21:
                    dVar.f13212v = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13212v);
                    break;
                case 22:
                    dVar.f13213w = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13213w);
                    break;
                case 23:
                    dVar.f13214x = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13214x);
                    break;
                case 24:
                    dVar.f13215y = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13215y);
                    break;
                case 25:
                    dVar.f13216z = obtainStyledAttributes.getDimensionPixelSize(index, dVar.f13216z);
                    break;
                case 26:
                    dVar.A = obtainStyledAttributes.getDimensionPixelSize(index, dVar.A);
                    break;
                case 27:
                    dVar.V = obtainStyledAttributes.getBoolean(index, dVar.V);
                    break;
                case 28:
                    dVar.W = obtainStyledAttributes.getBoolean(index, dVar.W);
                    break;
                case 29:
                    dVar.D = obtainStyledAttributes.getFloat(index, dVar.D);
                    break;
                case 30:
                    dVar.E = obtainStyledAttributes.getFloat(index, dVar.E);
                    break;
                case 31:
                    int i12 = obtainStyledAttributes.getInt(index, 0);
                    dVar.K = i12;
                    if (i12 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i13 = obtainStyledAttributes.getInt(index, 0);
                    dVar.L = i13;
                    if (i13 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        dVar.M = obtainStyledAttributes.getDimensionPixelSize(index, dVar.M);
                        break;
                    } catch (Exception unused) {
                        if (obtainStyledAttributes.getInt(index, dVar.M) == -2) {
                            dVar.M = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        dVar.O = obtainStyledAttributes.getDimensionPixelSize(index, dVar.O);
                        break;
                    } catch (Exception unused2) {
                        if (obtainStyledAttributes.getInt(index, dVar.O) == -2) {
                            dVar.O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    dVar.Q = Math.max(0.0f, obtainStyledAttributes.getFloat(index, dVar.Q));
                    dVar.K = 2;
                    break;
                case 36:
                    try {
                        dVar.N = obtainStyledAttributes.getDimensionPixelSize(index, dVar.N);
                        break;
                    } catch (Exception unused3) {
                        if (obtainStyledAttributes.getInt(index, dVar.N) == -2) {
                            dVar.N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 37:
                    try {
                        dVar.P = obtainStyledAttributes.getDimensionPixelSize(index, dVar.P);
                        break;
                    } catch (Exception unused4) {
                        if (obtainStyledAttributes.getInt(index, dVar.P) == -2) {
                            dVar.P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    dVar.R = Math.max(0.0f, obtainStyledAttributes.getFloat(index, dVar.R));
                    dVar.L = 2;
                    break;
                default:
                    switch (i11) {
                        case 44:
                            m.k(dVar, obtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            dVar.G = obtainStyledAttributes.getFloat(index, dVar.G);
                            break;
                        case 46:
                            dVar.H = obtainStyledAttributes.getFloat(index, dVar.H);
                            break;
                        case 47:
                            dVar.I = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            dVar.J = obtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            dVar.S = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.S);
                            break;
                        case 50:
                            dVar.T = obtainStyledAttributes.getDimensionPixelOffset(index, dVar.T);
                            break;
                        case 51:
                            dVar.X = obtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = obtainStyledAttributes.getResourceId(index, dVar.f13200m);
                            dVar.f13200m = resourceId15;
                            if (resourceId15 == -1) {
                                dVar.f13200m = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = obtainStyledAttributes.getResourceId(index, dVar.f13202n);
                            dVar.f13202n = resourceId16;
                            if (resourceId16 == -1) {
                                dVar.f13202n = obtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            dVar.C = obtainStyledAttributes.getDimensionPixelSize(index, dVar.C);
                            break;
                        case 55:
                            dVar.B = obtainStyledAttributes.getDimensionPixelSize(index, dVar.B);
                            break;
                        default:
                            switch (i11) {
                                case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                                    m.j(dVar, obtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    m.j(dVar, obtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    dVar.Y = obtainStyledAttributes.getInt(index, dVar.Y);
                                    break;
                            }
                    }
            }
        }
        obtainStyledAttributes.recycle();
        dVar.a();
        return dVar;
    }

    public int getMaxHeight() {
        return this.f501u;
    }

    public int getMaxWidth() {
        return this.f500t;
    }

    public int getMinHeight() {
        return this.f499s;
    }

    public int getMinWidth() {
        return this.f498r;
    }

    public int getOptimizationLevel() {
        return this.f497q.C0;
    }

    public final u.d h(View view) {
        if (view == this) {
            return this.f497q;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof d) {
            return ((d) view.getLayoutParams()).f13205o0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof d) {
            return ((d) view.getLayoutParams()).f13205o0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i10) {
        u.e eVar = this.f497q;
        eVar.f12069e0 = this;
        e eVar2 = this.C;
        eVar.f12103t0 = eVar2;
        eVar.f12101r0.f12596f = eVar2;
        this.f495o.put(getId(), this);
        this.f504x = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, p.f13318b, i10, 0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == 16) {
                    this.f498r = obtainStyledAttributes.getDimensionPixelOffset(index, this.f498r);
                } else if (index == 17) {
                    this.f499s = obtainStyledAttributes.getDimensionPixelOffset(index, this.f499s);
                } else if (index == 14) {
                    this.f500t = obtainStyledAttributes.getDimensionPixelOffset(index, this.f500t);
                } else if (index == 15) {
                    this.f501u = obtainStyledAttributes.getDimensionPixelOffset(index, this.f501u);
                } else if (index == 112) {
                    this.f503w = obtainStyledAttributes.getInt(index, this.f503w);
                } else if (index == 55) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f505y = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        m mVar = new m();
                        this.f504x = mVar;
                        mVar.h(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f504x = null;
                    }
                    this.f506z = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        eVar.C0 = this.f503w;
        s.c.f11110p = eVar.R(512);
    }

    public final void j(int i10) {
        String str;
        Context context = getContext();
        x4.e eVar = new x4.e(19, false);
        eVar.f13542p = new SparseArray();
        eVar.f13543q = new SparseArray();
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            w0 w0Var = null;
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                eVar.l(context, xml);
                                break;
                            } else {
                                break;
                            }
                        case 80204913:
                            if (name.equals("State")) {
                                w0Var = new w0(context, xml);
                                ((SparseArray) eVar.f13542p).put(w0Var.f1087o, w0Var);
                                break;
                            } else {
                                break;
                            }
                        case 1382829617:
                            str = "StateSet";
                            name.equals(str);
                            break;
                        case 1657696882:
                            str = "layoutDescription";
                            name.equals(str);
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                f fVar = new f(context, xml);
                                if (w0Var != null) {
                                    ((ArrayList) w0Var.f1089q).add(fVar);
                                    break;
                                } else {
                                    break;
                                }
                            } else {
                                break;
                            }
                    }
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        } catch (XmlPullParserException e8) {
            e8.printStackTrace();
        }
        this.f505y = eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x034c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(u.e r29, int r30, int r31, int r32) {
        /*
            Method dump skipped, instructions count: 1762
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(u.e, int, int, int):void");
    }

    public final void l(u.d dVar, d dVar2, SparseArray sparseArray, int i10, int i11) {
        View view = (View) this.f495o.get(i10);
        u.d dVar3 = (u.d) sparseArray.get(i10);
        if (dVar3 == null || view == null || !(view.getLayoutParams() instanceof d)) {
            return;
        }
        dVar2.f13181b0 = true;
        if (i11 == 6) {
            d dVar4 = (d) view.getLayoutParams();
            dVar4.f13181b0 = true;
            dVar4.f13205o0.D = true;
        }
        dVar.i(6).b(dVar3.i(i11), dVar2.C, dVar2.B, true);
        dVar.D = true;
        dVar.i(3).j();
        dVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            d dVar = (d) childAt.getLayoutParams();
            u.d dVar2 = dVar.f13205o0;
            if (childAt.getVisibility() != 8 || dVar.f13183c0 || dVar.f13185d0 || isInEditMode) {
                int o2 = dVar2.o();
                int p10 = dVar2.p();
                childAt.layout(o2, p10, dVar2.n() + o2, dVar2.k() + p10);
            }
        }
        ArrayList arrayList = this.f496p;
        int size = arrayList.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                ((b) arrayList.get(i15)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:287:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03c6  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:327:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:333:0x035b  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r35, int r36) {
        /*
            Method dump skipped, instructions count: 1569
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        u.d h10 = h(view);
        if ((view instanceof Guideline) && !(h10 instanceof h)) {
            d dVar = (d) view.getLayoutParams();
            h hVar = new h();
            dVar.f13205o0 = hVar;
            dVar.f13183c0 = true;
            hVar.N(dVar.U);
        }
        if (view instanceof b) {
            b bVar = (b) view;
            bVar.i();
            ((d) view.getLayoutParams()).f13185d0 = true;
            ArrayList arrayList = this.f496p;
            if (!arrayList.contains(bVar)) {
                arrayList.add(bVar);
            }
        }
        this.f495o.put(view.getId(), view);
        this.f502v = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f495o.remove(view.getId());
        u.d h10 = h(view);
        this.f497q.f12099p0.remove(h10);
        h10.z();
        this.f496p.remove(view);
        this.f502v = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f502v = true;
        super.requestLayout();
    }

    public void setConstraintSet(m mVar) {
        this.f504x = mVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        int id = getId();
        SparseArray sparseArray = this.f495o;
        sparseArray.remove(id);
        super.setId(i10);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f501u) {
            return;
        }
        this.f501u = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.f500t) {
            return;
        }
        this.f500t = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f499s) {
            return;
        }
        this.f499s = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f498r) {
            return;
        }
        this.f498r = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(n nVar) {
        x4.e eVar = this.f505y;
        if (eVar != null) {
            eVar.getClass();
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f503w = i10;
        u.e eVar = this.f497q;
        eVar.C0 = i10;
        s.c.f11110p = eVar.R(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f495o = new SparseArray();
        this.f496p = new ArrayList(4);
        this.f497q = new u.e();
        this.f498r = 0;
        this.f499s = 0;
        this.f500t = Integer.MAX_VALUE;
        this.f501u = Integer.MAX_VALUE;
        this.f502v = true;
        this.f503w = 257;
        this.f504x = null;
        this.f505y = null;
        this.f506z = -1;
        this.A = new HashMap();
        this.B = new SparseArray();
        this.C = new e(this, this);
        this.D = 0;
        this.E = 0;
        i(attributeSet, i10);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        d dVar = new d(layoutParams);
        dVar.f13178a = -1;
        dVar.f13180b = -1;
        dVar.f13182c = -1.0f;
        dVar.f13184d = -1;
        dVar.f13186e = -1;
        dVar.f13188f = -1;
        dVar.g = -1;
        dVar.f13191h = -1;
        dVar.f13192i = -1;
        dVar.f13194j = -1;
        dVar.f13196k = -1;
        dVar.f13198l = -1;
        dVar.f13200m = -1;
        dVar.f13202n = -1;
        dVar.f13204o = -1;
        dVar.f13206p = 0;
        dVar.f13207q = 0.0f;
        dVar.f13208r = -1;
        dVar.f13209s = -1;
        dVar.f13210t = -1;
        dVar.f13211u = -1;
        dVar.f13212v = Integer.MIN_VALUE;
        dVar.f13213w = Integer.MIN_VALUE;
        dVar.f13214x = Integer.MIN_VALUE;
        dVar.f13215y = Integer.MIN_VALUE;
        dVar.f13216z = Integer.MIN_VALUE;
        dVar.A = Integer.MIN_VALUE;
        dVar.B = Integer.MIN_VALUE;
        dVar.C = 0;
        dVar.D = 0.5f;
        dVar.E = 0.5f;
        dVar.F = null;
        dVar.G = -1.0f;
        dVar.H = -1.0f;
        dVar.I = 0;
        dVar.J = 0;
        dVar.K = 0;
        dVar.L = 0;
        dVar.M = 0;
        dVar.N = 0;
        dVar.O = 0;
        dVar.P = 0;
        dVar.Q = 1.0f;
        dVar.R = 1.0f;
        dVar.S = -1;
        dVar.T = -1;
        dVar.U = -1;
        dVar.V = false;
        dVar.W = false;
        dVar.X = null;
        dVar.Y = 0;
        dVar.Z = true;
        dVar.f13179a0 = true;
        dVar.f13181b0 = false;
        dVar.f13183c0 = false;
        dVar.f13185d0 = false;
        dVar.f13187e0 = -1;
        dVar.f13189f0 = -1;
        dVar.f13190g0 = -1;
        dVar.h0 = -1;
        dVar.f13193i0 = Integer.MIN_VALUE;
        dVar.f13195j0 = Integer.MIN_VALUE;
        dVar.f13197k0 = 0.5f;
        dVar.f13205o0 = new u.d();
        return dVar;
    }
}
