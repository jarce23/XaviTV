package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: o0, reason: collision with root package name */
    public static final SparseIntArray f13246o0;
    public float A;
    public int B;
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public float S;
    public float T;
    public int U;
    public int V;
    public int W;
    public int X;
    public int Y;
    public int Z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f13247a;

    /* renamed from: a0, reason: collision with root package name */
    public int f13248a0;

    /* renamed from: b, reason: collision with root package name */
    public int f13249b;

    /* renamed from: b0, reason: collision with root package name */
    public int f13250b0;

    /* renamed from: c, reason: collision with root package name */
    public int f13251c;

    /* renamed from: c0, reason: collision with root package name */
    public float f13252c0;

    /* renamed from: d, reason: collision with root package name */
    public int f13253d;

    /* renamed from: d0, reason: collision with root package name */
    public float f13254d0;

    /* renamed from: e, reason: collision with root package name */
    public int f13255e;

    /* renamed from: e0, reason: collision with root package name */
    public int f13256e0;

    /* renamed from: f, reason: collision with root package name */
    public float f13257f;

    /* renamed from: f0, reason: collision with root package name */
    public int f13258f0;
    public int g;

    /* renamed from: g0, reason: collision with root package name */
    public int f13259g0;

    /* renamed from: h, reason: collision with root package name */
    public int f13260h;
    public int[] h0;

    /* renamed from: i, reason: collision with root package name */
    public int f13261i;

    /* renamed from: i0, reason: collision with root package name */
    public String f13262i0;

    /* renamed from: j, reason: collision with root package name */
    public int f13263j;

    /* renamed from: j0, reason: collision with root package name */
    public String f13264j0;

    /* renamed from: k, reason: collision with root package name */
    public int f13265k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f13266k0;

    /* renamed from: l, reason: collision with root package name */
    public int f13267l;

    /* renamed from: l0, reason: collision with root package name */
    public boolean f13268l0;

    /* renamed from: m, reason: collision with root package name */
    public int f13269m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f13270m0;

    /* renamed from: n, reason: collision with root package name */
    public int f13271n;

    /* renamed from: n0, reason: collision with root package name */
    public int f13272n0;

    /* renamed from: o, reason: collision with root package name */
    public int f13273o;

    /* renamed from: p, reason: collision with root package name */
    public int f13274p;

    /* renamed from: q, reason: collision with root package name */
    public int f13275q;

    /* renamed from: r, reason: collision with root package name */
    public int f13276r;

    /* renamed from: s, reason: collision with root package name */
    public int f13277s;

    /* renamed from: t, reason: collision with root package name */
    public int f13278t;

    /* renamed from: u, reason: collision with root package name */
    public int f13279u;

    /* renamed from: v, reason: collision with root package name */
    public float f13280v;

    /* renamed from: w, reason: collision with root package name */
    public float f13281w;

    /* renamed from: x, reason: collision with root package name */
    public String f13282x;

    /* renamed from: y, reason: collision with root package name */
    public int f13283y;

    /* renamed from: z, reason: collision with root package name */
    public int f13284z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13246o0 = sparseIntArray;
        sparseIntArray.append(42, 24);
        sparseIntArray.append(43, 25);
        sparseIntArray.append(45, 28);
        sparseIntArray.append(46, 29);
        sparseIntArray.append(51, 35);
        sparseIntArray.append(50, 34);
        sparseIntArray.append(23, 4);
        sparseIntArray.append(22, 3);
        sparseIntArray.append(18, 1);
        sparseIntArray.append(60, 6);
        sparseIntArray.append(61, 7);
        sparseIntArray.append(30, 17);
        sparseIntArray.append(31, 18);
        sparseIntArray.append(32, 19);
        sparseIntArray.append(0, 26);
        sparseIntArray.append(47, 31);
        sparseIntArray.append(48, 32);
        sparseIntArray.append(29, 10);
        sparseIntArray.append(28, 9);
        sparseIntArray.append(65, 13);
        sparseIntArray.append(68, 16);
        sparseIntArray.append(66, 14);
        sparseIntArray.append(63, 11);
        sparseIntArray.append(67, 15);
        sparseIntArray.append(64, 12);
        sparseIntArray.append(54, 38);
        sparseIntArray.append(40, 37);
        sparseIntArray.append(39, 39);
        sparseIntArray.append(53, 40);
        sparseIntArray.append(38, 20);
        sparseIntArray.append(52, 36);
        sparseIntArray.append(27, 5);
        sparseIntArray.append(41, 76);
        sparseIntArray.append(49, 76);
        sparseIntArray.append(44, 76);
        sparseIntArray.append(21, 76);
        sparseIntArray.append(17, 76);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(5, 27);
        sparseIntArray.append(7, 30);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(4, 33);
        sparseIntArray.append(6, 2);
        sparseIntArray.append(1, 22);
        sparseIntArray.append(2, 21);
        sparseIntArray.append(55, 41);
        sparseIntArray.append(33, 42);
        sparseIntArray.append(16, 41);
        sparseIntArray.append(15, 42);
        sparseIntArray.append(70, 97);
        sparseIntArray.append(24, 61);
        sparseIntArray.append(26, 62);
        sparseIntArray.append(25, 63);
        sparseIntArray.append(59, 69);
        sparseIntArray.append(37, 70);
        sparseIntArray.append(12, 71);
        sparseIntArray.append(10, 72);
        sparseIntArray.append(11, 73);
        sparseIntArray.append(13, 74);
        sparseIntArray.append(9, 75);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f13321e);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            SparseIntArray sparseIntArray = f13246o0;
            int i11 = sparseIntArray.get(index);
            if (i11 == 80) {
                this.f13266k0 = obtainStyledAttributes.getBoolean(index, this.f13266k0);
            } else if (i11 == 81) {
                this.f13268l0 = obtainStyledAttributes.getBoolean(index, this.f13268l0);
            } else if (i11 != 97) {
                switch (i11) {
                    case 1:
                        this.f13273o = m.i(obtainStyledAttributes, index, this.f13273o);
                        break;
                    case 2:
                        this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                        break;
                    case 3:
                        this.f13271n = m.i(obtainStyledAttributes, index, this.f13271n);
                        break;
                    case 4:
                        this.f13269m = m.i(obtainStyledAttributes, index, this.f13269m);
                        break;
                    case 5:
                        this.f13282x = obtainStyledAttributes.getString(index);
                        break;
                    case 6:
                        this.B = obtainStyledAttributes.getDimensionPixelOffset(index, this.B);
                        break;
                    case 7:
                        this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                        break;
                    case 8:
                        this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                        break;
                    case 9:
                        this.f13279u = m.i(obtainStyledAttributes, index, this.f13279u);
                        break;
                    case 10:
                        this.f13278t = m.i(obtainStyledAttributes, index, this.f13278t);
                        break;
                    case 11:
                        this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                        break;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                        break;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                        break;
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                        break;
                    case 17:
                        this.f13253d = obtainStyledAttributes.getDimensionPixelOffset(index, this.f13253d);
                        break;
                    case 18:
                        this.f13255e = obtainStyledAttributes.getDimensionPixelOffset(index, this.f13255e);
                        break;
                    case 19:
                        this.f13257f = obtainStyledAttributes.getFloat(index, this.f13257f);
                        break;
                    case 20:
                        this.f13280v = obtainStyledAttributes.getFloat(index, this.f13280v);
                        break;
                    case 21:
                        this.f13251c = obtainStyledAttributes.getLayoutDimension(index, this.f13251c);
                        break;
                    case 22:
                        this.f13249b = obtainStyledAttributes.getLayoutDimension(index, this.f13249b);
                        break;
                    case 23:
                        this.E = obtainStyledAttributes.getDimensionPixelSize(index, this.E);
                        break;
                    case 24:
                        this.g = m.i(obtainStyledAttributes, index, this.g);
                        break;
                    case 25:
                        this.f13260h = m.i(obtainStyledAttributes, index, this.f13260h);
                        break;
                    case 26:
                        this.D = obtainStyledAttributes.getInt(index, this.D);
                        break;
                    case 27:
                        this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                        break;
                    case 28:
                        this.f13261i = m.i(obtainStyledAttributes, index, this.f13261i);
                        break;
                    case 29:
                        this.f13263j = m.i(obtainStyledAttributes, index, this.f13263j);
                        break;
                    case 30:
                        this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                        break;
                    case 31:
                        this.f13276r = m.i(obtainStyledAttributes, index, this.f13276r);
                        break;
                    case 32:
                        this.f13277s = m.i(obtainStyledAttributes, index, this.f13277s);
                        break;
                    case 33:
                        this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                        break;
                    case 34:
                        this.f13267l = m.i(obtainStyledAttributes, index, this.f13267l);
                        break;
                    case 35:
                        this.f13265k = m.i(obtainStyledAttributes, index, this.f13265k);
                        break;
                    case 36:
                        this.f13281w = obtainStyledAttributes.getFloat(index, this.f13281w);
                        break;
                    case 37:
                        this.T = obtainStyledAttributes.getFloat(index, this.T);
                        break;
                    case 38:
                        this.S = obtainStyledAttributes.getFloat(index, this.S);
                        break;
                    case 39:
                        this.U = obtainStyledAttributes.getInt(index, this.U);
                        break;
                    case 40:
                        this.V = obtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 41:
                        m.j(this, obtainStyledAttributes, index, 0);
                        break;
                    case 42:
                        m.j(this, obtainStyledAttributes, index, 1);
                        break;
                    default:
                        switch (i11) {
                            case 54:
                                this.W = obtainStyledAttributes.getInt(index, this.W);
                                break;
                            case 55:
                                this.X = obtainStyledAttributes.getInt(index, this.X);
                                break;
                            case 56:
                                this.Y = obtainStyledAttributes.getDimensionPixelSize(index, this.Y);
                                break;
                            case 57:
                                this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                break;
                            case 58:
                                this.f13248a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f13248a0);
                                break;
                            case 59:
                                this.f13250b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f13250b0);
                                break;
                            default:
                                switch (i11) {
                                    case 61:
                                        this.f13283y = m.i(obtainStyledAttributes, index, this.f13283y);
                                        break;
                                    case 62:
                                        this.f13284z = obtainStyledAttributes.getDimensionPixelSize(index, this.f13284z);
                                        break;
                                    case 63:
                                        this.A = obtainStyledAttributes.getFloat(index, this.A);
                                        break;
                                    default:
                                        switch (i11) {
                                            case 69:
                                                this.f13252c0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 70:
                                                this.f13254d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                break;
                                            case 71:
                                                Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                break;
                                            case 72:
                                                this.f13256e0 = obtainStyledAttributes.getInt(index, this.f13256e0);
                                                break;
                                            case 73:
                                                this.f13258f0 = obtainStyledAttributes.getDimensionPixelSize(index, this.f13258f0);
                                                break;
                                            case 74:
                                                this.f13262i0 = obtainStyledAttributes.getString(index);
                                                break;
                                            case 75:
                                                this.f13270m0 = obtainStyledAttributes.getBoolean(index, this.f13270m0);
                                                break;
                                            case 76:
                                                Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                break;
                                            case 77:
                                                this.f13264j0 = obtainStyledAttributes.getString(index);
                                                break;
                                            default:
                                                switch (i11) {
                                                    case 91:
                                                        this.f13274p = m.i(obtainStyledAttributes, index, this.f13274p);
                                                        break;
                                                    case 92:
                                                        this.f13275q = m.i(obtainStyledAttributes, index, this.f13275q);
                                                        break;
                                                    case 93:
                                                        this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                                                        break;
                                                    case 94:
                                                        this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                                                        break;
                                                    default:
                                                        Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                                                        break;
                                                }
                                        }
                                }
                        }
                }
            } else {
                this.f13272n0 = obtainStyledAttributes.getInt(index, this.f13272n0);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
