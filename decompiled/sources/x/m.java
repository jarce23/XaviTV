package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.http.HttpStatusCodesKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import org.xmlpull.v1.XmlPullParserException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f13311d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f13312e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f13313f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f13314a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13315b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f13316c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13312e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f13313f = sparseIntArray2;
        sparseIntArray.append(81, 25);
        sparseIntArray.append(82, 26);
        sparseIntArray.append(84, 29);
        sparseIntArray.append(85, 30);
        sparseIntArray.append(91, 36);
        sparseIntArray.append(90, 35);
        sparseIntArray.append(62, 4);
        sparseIntArray.append(61, 3);
        sparseIntArray.append(57, 1);
        sparseIntArray.append(59, 91);
        sparseIntArray.append(58, 92);
        sparseIntArray.append(100, 6);
        sparseIntArray.append(HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS, 7);
        sparseIntArray.append(69, 17);
        sparseIntArray.append(70, 18);
        sparseIntArray.append(71, 19);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(86, 32);
        sparseIntArray.append(87, 33);
        sparseIntArray.append(68, 10);
        sparseIntArray.append(67, 9);
        sparseIntArray.append(105, 13);
        sparseIntArray.append(108, 16);
        sparseIntArray.append(106, 14);
        sparseIntArray.append(HttpStatusCodesKt.HTTP_EARLY_HINTS, 11);
        sparseIntArray.append(107, 15);
        sparseIntArray.append(104, 12);
        sparseIntArray.append(94, 40);
        sparseIntArray.append(79, 39);
        sparseIntArray.append(78, 41);
        sparseIntArray.append(93, 42);
        sparseIntArray.append(77, 20);
        sparseIntArray.append(92, 37);
        sparseIntArray.append(66, 5);
        sparseIntArray.append(80, 87);
        sparseIntArray.append(89, 87);
        sparseIntArray.append(83, 87);
        sparseIntArray.append(60, 87);
        sparseIntArray.append(56, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(95, 95);
        sparseIntArray.append(72, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(96, 54);
        sparseIntArray.append(73, 55);
        sparseIntArray.append(97, 56);
        sparseIntArray.append(74, 57);
        sparseIntArray.append(98, 58);
        sparseIntArray.append(75, 59);
        sparseIntArray.append(63, 61);
        sparseIntArray.append(65, 62);
        sparseIntArray.append(64, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(120, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(121, 67);
        sparseIntArray.append(112, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(111, 68);
        sparseIntArray.append(99, 69);
        sparseIntArray.append(76, 70);
        sparseIntArray.append(110, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(113, 76);
        sparseIntArray.append(88, 77);
        sparseIntArray.append(122, 78);
        sparseIntArray.append(55, 80);
        sparseIntArray.append(54, 81);
        sparseIntArray.append(115, 82);
        sparseIntArray.append(119, 83);
        sparseIntArray.append(118, 84);
        sparseIntArray.append(117, 85);
        sparseIntArray.append(116, 86);
        sparseIntArray2.append(84, 6);
        sparseIntArray2.append(84, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(88, 13);
        sparseIntArray2.append(91, 16);
        sparseIntArray2.append(89, 14);
        sparseIntArray2.append(86, 11);
        sparseIntArray2.append(90, 15);
        sparseIntArray2.append(87, 12);
        sparseIntArray2.append(77, 40);
        sparseIntArray2.append(70, 39);
        sparseIntArray2.append(69, 41);
        sparseIntArray2.append(76, 42);
        sparseIntArray2.append(68, 20);
        sparseIntArray2.append(75, 37);
        sparseIntArray2.append(59, 5);
        sparseIntArray2.append(71, 87);
        sparseIntArray2.append(74, 87);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(55, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(78, 95);
        sparseIntArray2.append(63, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(79, 54);
        sparseIntArray2.append(64, 55);
        sparseIntArray2.append(80, 56);
        sparseIntArray2.append(65, 57);
        sparseIntArray2.append(81, 58);
        sparseIntArray2.append(66, 59);
        sparseIntArray2.append(58, 62);
        sparseIntArray2.append(57, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(104, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(105, 67);
        sparseIntArray2.append(95, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(96, 98);
        sparseIntArray2.append(94, 68);
        sparseIntArray2.append(82, 69);
        sparseIntArray2.append(67, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(97, 76);
        sparseIntArray2.append(73, 77);
        sparseIntArray2.append(106, 78);
        sparseIntArray2.append(54, 80);
        sparseIntArray2.append(53, 81);
        sparseIntArray2.append(99, 82);
        sparseIntArray2.append(HttpStatusCodesKt.HTTP_EARLY_HINTS, 83);
        sparseIntArray2.append(HttpStatusCodesKt.HTTP_PROCESSING, 84);
        sparseIntArray2.append(HttpStatusCodesKt.HTTP_SWITCHING_PROTOCOLS, 85);
        sparseIntArray2.append(100, 86);
        sparseIntArray2.append(93, 97);
    }

    public static int[] e(Barrier barrier, String str) {
        int i10;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            Object obj = null;
            try {
                i10 = o.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                if (r.a.k(trim)) {
                    HashMap hashMap = constraintLayout.A;
                    if (hashMap != null && hashMap.containsKey(trim)) {
                        obj = constraintLayout.A.get(trim);
                    }
                } else {
                    constraintLayout.getClass();
                }
                if (obj != null && (obj instanceof Integer)) {
                    i10 = ((Integer) obj).intValue();
                }
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        return i12 != split.length ? Arrays.copyOf(iArr, i12) : iArr;
    }

    public static h f(Context context, AttributeSet attributeSet, boolean z10) {
        int i10;
        int i11;
        h hVar = new h();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z10 ? p.f13319c : p.f13317a);
        k kVar = hVar.f13241b;
        l lVar = hVar.f13244e;
        j jVar = hVar.f13242c;
        i iVar = hVar.f13243d;
        int[] iArr = f13311d;
        String[] strArr = t.a.f11741a;
        SparseIntArray sparseIntArray = f13312e;
        if (z10) {
            g gVar = new g();
            gVar.f13229a = new int[10];
            gVar.f13230b = new int[10];
            gVar.f13231c = 0;
            gVar.f13232d = new int[10];
            gVar.f13233e = new float[10];
            gVar.f13234f = 0;
            gVar.g = new int[5];
            gVar.f13235h = new String[5];
            gVar.f13236i = 0;
            gVar.f13237j = new int[4];
            gVar.f13238k = new boolean[4];
            gVar.f13239l = 0;
            jVar.getClass();
            iVar.getClass();
            lVar.getClass();
            int i12 = 0;
            for (int indexCount = obtainStyledAttributes.getIndexCount(); i12 < indexCount; indexCount = i11) {
                int index = obtainStyledAttributes.getIndex(i12);
                int i13 = i12;
                switch (f13313f.get(index)) {
                    case 2:
                        i11 = indexCount;
                        gVar.b(2, obtainStyledAttributes.getDimensionPixelSize(index, iVar.H));
                        continue;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb2 = new StringBuilder("Unknown attribute 0x");
                        i11 = indexCount;
                        sb2.append(Integer.toHexString(index));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb2.toString());
                        break;
                    case 5:
                        i11 = indexCount;
                        gVar.c(5, obtainStyledAttributes.getString(index));
                        continue;
                    case 6:
                        i11 = indexCount;
                        gVar.b(6, obtainStyledAttributes.getDimensionPixelOffset(index, iVar.B));
                        break;
                    case 7:
                        i11 = indexCount;
                        gVar.b(7, obtainStyledAttributes.getDimensionPixelOffset(index, iVar.C));
                        break;
                    case 8:
                        i11 = indexCount;
                        gVar.b(8, obtainStyledAttributes.getDimensionPixelSize(index, iVar.I));
                        break;
                    case 11:
                        i11 = indexCount;
                        gVar.b(11, obtainStyledAttributes.getDimensionPixelSize(index, iVar.O));
                        break;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        i11 = indexCount;
                        gVar.b(12, obtainStyledAttributes.getDimensionPixelSize(index, iVar.P));
                        break;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        i11 = indexCount;
                        gVar.b(13, obtainStyledAttributes.getDimensionPixelSize(index, iVar.L));
                        break;
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        i11 = indexCount;
                        gVar.b(14, obtainStyledAttributes.getDimensionPixelSize(index, iVar.N));
                        break;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        i11 = indexCount;
                        gVar.b(15, obtainStyledAttributes.getDimensionPixelSize(index, iVar.Q));
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        i11 = indexCount;
                        gVar.b(16, obtainStyledAttributes.getDimensionPixelSize(index, iVar.M));
                        break;
                    case 17:
                        i11 = indexCount;
                        gVar.b(17, obtainStyledAttributes.getDimensionPixelOffset(index, iVar.f13253d));
                        break;
                    case 18:
                        i11 = indexCount;
                        gVar.b(18, obtainStyledAttributes.getDimensionPixelOffset(index, iVar.f13255e));
                        break;
                    case 19:
                        i11 = indexCount;
                        gVar.a(19, obtainStyledAttributes.getFloat(index, iVar.f13257f));
                        break;
                    case 20:
                        i11 = indexCount;
                        gVar.a(20, obtainStyledAttributes.getFloat(index, iVar.f13280v));
                        break;
                    case 21:
                        i11 = indexCount;
                        gVar.b(21, obtainStyledAttributes.getLayoutDimension(index, iVar.f13251c));
                        break;
                    case 22:
                        i11 = indexCount;
                        gVar.b(22, iArr[obtainStyledAttributes.getInt(index, kVar.f13294a)]);
                        break;
                    case 23:
                        i11 = indexCount;
                        gVar.b(23, obtainStyledAttributes.getLayoutDimension(index, iVar.f13249b));
                        break;
                    case 24:
                        i11 = indexCount;
                        gVar.b(24, obtainStyledAttributes.getDimensionPixelSize(index, iVar.E));
                        break;
                    case 27:
                        i11 = indexCount;
                        gVar.b(27, obtainStyledAttributes.getInt(index, iVar.D));
                        break;
                    case 28:
                        i11 = indexCount;
                        gVar.b(28, obtainStyledAttributes.getDimensionPixelSize(index, iVar.F));
                        break;
                    case 31:
                        i11 = indexCount;
                        gVar.b(31, obtainStyledAttributes.getDimensionPixelSize(index, iVar.J));
                        break;
                    case 34:
                        i11 = indexCount;
                        gVar.b(34, obtainStyledAttributes.getDimensionPixelSize(index, iVar.G));
                        break;
                    case 37:
                        i11 = indexCount;
                        gVar.a(37, obtainStyledAttributes.getFloat(index, iVar.f13281w));
                        break;
                    case 38:
                        i11 = indexCount;
                        int resourceId = obtainStyledAttributes.getResourceId(index, hVar.f13240a);
                        hVar.f13240a = resourceId;
                        gVar.b(38, resourceId);
                        break;
                    case 39:
                        i11 = indexCount;
                        gVar.a(39, obtainStyledAttributes.getFloat(index, iVar.T));
                        break;
                    case 40:
                        i11 = indexCount;
                        gVar.a(40, obtainStyledAttributes.getFloat(index, iVar.S));
                        break;
                    case 41:
                        i11 = indexCount;
                        gVar.b(41, obtainStyledAttributes.getInt(index, iVar.U));
                        break;
                    case 42:
                        i11 = indexCount;
                        gVar.b(42, obtainStyledAttributes.getInt(index, iVar.V));
                        break;
                    case 43:
                        i11 = indexCount;
                        gVar.a(43, obtainStyledAttributes.getFloat(index, kVar.f13296c));
                        break;
                    case 44:
                        i11 = indexCount;
                        gVar.d(44, true);
                        gVar.a(44, obtainStyledAttributes.getDimension(index, lVar.f13310m));
                        break;
                    case 45:
                        i11 = indexCount;
                        gVar.a(45, obtainStyledAttributes.getFloat(index, lVar.f13300b));
                        break;
                    case 46:
                        i11 = indexCount;
                        gVar.a(46, obtainStyledAttributes.getFloat(index, lVar.f13301c));
                        break;
                    case 47:
                        i11 = indexCount;
                        gVar.a(47, obtainStyledAttributes.getFloat(index, lVar.f13302d));
                        break;
                    case 48:
                        i11 = indexCount;
                        gVar.a(48, obtainStyledAttributes.getFloat(index, lVar.f13303e));
                        break;
                    case 49:
                        i11 = indexCount;
                        gVar.a(49, obtainStyledAttributes.getDimension(index, lVar.f13304f));
                        break;
                    case 50:
                        i11 = indexCount;
                        gVar.a(50, obtainStyledAttributes.getDimension(index, lVar.g));
                        break;
                    case 51:
                        i11 = indexCount;
                        gVar.a(51, obtainStyledAttributes.getDimension(index, lVar.f13306i));
                        break;
                    case 52:
                        i11 = indexCount;
                        gVar.a(52, obtainStyledAttributes.getDimension(index, lVar.f13307j));
                        break;
                    case 53:
                        i11 = indexCount;
                        gVar.a(53, obtainStyledAttributes.getDimension(index, lVar.f13308k));
                        break;
                    case 54:
                        i11 = indexCount;
                        gVar.b(54, obtainStyledAttributes.getInt(index, iVar.W));
                        break;
                    case 55:
                        i11 = indexCount;
                        gVar.b(55, obtainStyledAttributes.getInt(index, iVar.X));
                        break;
                    case 56:
                        i11 = indexCount;
                        gVar.b(56, obtainStyledAttributes.getDimensionPixelSize(index, iVar.Y));
                        break;
                    case 57:
                        i11 = indexCount;
                        gVar.b(57, obtainStyledAttributes.getDimensionPixelSize(index, iVar.Z));
                        break;
                    case 58:
                        i11 = indexCount;
                        gVar.b(58, obtainStyledAttributes.getDimensionPixelSize(index, iVar.f13248a0));
                        break;
                    case 59:
                        i11 = indexCount;
                        gVar.b(59, obtainStyledAttributes.getDimensionPixelSize(index, iVar.f13250b0));
                        break;
                    case 60:
                        i11 = indexCount;
                        gVar.a(60, obtainStyledAttributes.getFloat(index, lVar.f13299a));
                        break;
                    case 62:
                        i11 = indexCount;
                        gVar.b(62, obtainStyledAttributes.getDimensionPixelSize(index, iVar.f13284z));
                        break;
                    case 63:
                        i11 = indexCount;
                        gVar.a(63, obtainStyledAttributes.getFloat(index, iVar.A));
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                        i11 = indexCount;
                        gVar.b(64, i(obtainStyledAttributes, index, jVar.f13286a));
                        break;
                    case 65:
                        i11 = indexCount;
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            gVar.c(65, obtainStyledAttributes.getString(index));
                            break;
                        } else {
                            gVar.c(65, strArr[obtainStyledAttributes.getInteger(index, 0)]);
                            break;
                        }
                    case 66:
                        i11 = indexCount;
                        gVar.b(66, obtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        i11 = indexCount;
                        gVar.a(67, obtainStyledAttributes.getFloat(index, jVar.f13290e));
                        break;
                    case 68:
                        i11 = indexCount;
                        gVar.a(68, obtainStyledAttributes.getFloat(index, kVar.f13297d));
                        break;
                    case 69:
                        i11 = indexCount;
                        gVar.a(69, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        i11 = indexCount;
                        gVar.a(70, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        i11 = indexCount;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i11 = indexCount;
                        gVar.b(72, obtainStyledAttributes.getInt(index, iVar.f13256e0));
                        break;
                    case 73:
                        i11 = indexCount;
                        gVar.b(73, obtainStyledAttributes.getDimensionPixelSize(index, iVar.f13258f0));
                        break;
                    case 74:
                        i11 = indexCount;
                        gVar.c(74, obtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        i11 = indexCount;
                        gVar.d(75, obtainStyledAttributes.getBoolean(index, iVar.f13270m0));
                        break;
                    case 76:
                        i11 = indexCount;
                        gVar.b(76, obtainStyledAttributes.getInt(index, jVar.f13288c));
                        break;
                    case 77:
                        i11 = indexCount;
                        gVar.c(77, obtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        i11 = indexCount;
                        gVar.b(78, obtainStyledAttributes.getInt(index, kVar.f13295b));
                        break;
                    case 79:
                        i11 = indexCount;
                        gVar.a(79, obtainStyledAttributes.getFloat(index, jVar.f13289d));
                        break;
                    case 80:
                        i11 = indexCount;
                        gVar.d(80, obtainStyledAttributes.getBoolean(index, iVar.f13266k0));
                        break;
                    case 81:
                        i11 = indexCount;
                        gVar.d(81, obtainStyledAttributes.getBoolean(index, iVar.f13268l0));
                        break;
                    case 82:
                        i11 = indexCount;
                        gVar.b(82, obtainStyledAttributes.getInteger(index, jVar.f13287b));
                        break;
                    case 83:
                        i11 = indexCount;
                        gVar.b(83, i(obtainStyledAttributes, index, lVar.f13305h));
                        break;
                    case 84:
                        i11 = indexCount;
                        gVar.b(84, obtainStyledAttributes.getInteger(index, jVar.g));
                        break;
                    case 85:
                        i11 = indexCount;
                        gVar.a(85, obtainStyledAttributes.getFloat(index, jVar.f13291f));
                        break;
                    case 86:
                        i11 = indexCount;
                        int i14 = obtainStyledAttributes.peekValue(index).type;
                        if (i14 == 1) {
                            int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                            jVar.f13293i = resourceId2;
                            gVar.b(89, resourceId2);
                            if (jVar.f13293i != -1) {
                                gVar.b(88, -2);
                                break;
                            }
                        } else if (i14 == 3) {
                            String string = obtainStyledAttributes.getString(index);
                            jVar.f13292h = string;
                            gVar.c(90, string);
                            if (jVar.f13292h.indexOf("/") > 0) {
                                int resourceId3 = obtainStyledAttributes.getResourceId(index, -1);
                                jVar.f13293i = resourceId3;
                                gVar.b(89, resourceId3);
                                gVar.b(88, -2);
                                break;
                            } else {
                                gVar.b(88, -1);
                                break;
                            }
                        } else {
                            gVar.b(88, obtainStyledAttributes.getInteger(index, jVar.f13293i));
                            break;
                        }
                        break;
                    case 87:
                        i11 = indexCount;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        break;
                    case 93:
                        i11 = indexCount;
                        gVar.b(93, obtainStyledAttributes.getDimensionPixelSize(index, iVar.K));
                        break;
                    case 94:
                        i11 = indexCount;
                        gVar.b(94, obtainStyledAttributes.getDimensionPixelSize(index, iVar.R));
                        break;
                    case 95:
                        i11 = indexCount;
                        j(gVar, obtainStyledAttributes, index, 0);
                        break;
                    case 96:
                        i11 = indexCount;
                        j(gVar, obtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        i11 = indexCount;
                        gVar.b(97, obtainStyledAttributes.getInt(index, iVar.f13272n0));
                        break;
                    case 98:
                        i11 = indexCount;
                        int i15 = w.a.G;
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            hVar.f13240a = obtainStyledAttributes.getResourceId(index, hVar.f13240a);
                            break;
                        }
                }
                i12 = i13 + 1;
            }
        } else {
            int i16 = 0;
            for (int indexCount2 = obtainStyledAttributes.getIndexCount(); i16 < indexCount2; indexCount2 = i10) {
                int index2 = obtainStyledAttributes.getIndex(i16);
                if (index2 != 1 && 23 != index2) {
                    if (24 != index2) {
                        jVar.getClass();
                        iVar.getClass();
                        lVar.getClass();
                    }
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i10 = indexCount2;
                        iVar.f13273o = i(obtainStyledAttributes, index2, iVar.f13273o);
                        continue;
                    case 2:
                        i10 = indexCount2;
                        iVar.H = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.H);
                        continue;
                    case 3:
                        i10 = indexCount2;
                        iVar.f13271n = i(obtainStyledAttributes, index2, iVar.f13271n);
                        continue;
                    case 4:
                        i10 = indexCount2;
                        iVar.f13269m = i(obtainStyledAttributes, index2, iVar.f13269m);
                        continue;
                    case 5:
                        i10 = indexCount2;
                        iVar.f13282x = obtainStyledAttributes.getString(index2);
                        continue;
                    case 6:
                        i10 = indexCount2;
                        iVar.B = obtainStyledAttributes.getDimensionPixelOffset(index2, iVar.B);
                        continue;
                    case 7:
                        i10 = indexCount2;
                        iVar.C = obtainStyledAttributes.getDimensionPixelOffset(index2, iVar.C);
                        continue;
                    case 8:
                        i10 = indexCount2;
                        iVar.I = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.I);
                        continue;
                    case 9:
                        i10 = indexCount2;
                        iVar.f13279u = i(obtainStyledAttributes, index2, iVar.f13279u);
                        continue;
                    case 10:
                        i10 = indexCount2;
                        iVar.f13278t = i(obtainStyledAttributes, index2, iVar.f13278t);
                        continue;
                    case 11:
                        i10 = indexCount2;
                        iVar.O = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.O);
                        continue;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        i10 = indexCount2;
                        iVar.P = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.P);
                        continue;
                    case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                        i10 = indexCount2;
                        iVar.L = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.L);
                        continue;
                    case UrlRequest.Status.READING_RESPONSE /* 14 */:
                        i10 = indexCount2;
                        iVar.N = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.N);
                        continue;
                    case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                        i10 = indexCount2;
                        iVar.Q = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.Q);
                        continue;
                    case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                        i10 = indexCount2;
                        iVar.M = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.M);
                        continue;
                    case 17:
                        i10 = indexCount2;
                        iVar.f13253d = obtainStyledAttributes.getDimensionPixelOffset(index2, iVar.f13253d);
                        continue;
                    case 18:
                        i10 = indexCount2;
                        iVar.f13255e = obtainStyledAttributes.getDimensionPixelOffset(index2, iVar.f13255e);
                        continue;
                    case 19:
                        i10 = indexCount2;
                        iVar.f13257f = obtainStyledAttributes.getFloat(index2, iVar.f13257f);
                        continue;
                    case 20:
                        i10 = indexCount2;
                        iVar.f13280v = obtainStyledAttributes.getFloat(index2, iVar.f13280v);
                        continue;
                    case 21:
                        i10 = indexCount2;
                        iVar.f13251c = obtainStyledAttributes.getLayoutDimension(index2, iVar.f13251c);
                        continue;
                    case 22:
                        i10 = indexCount2;
                        int i17 = obtainStyledAttributes.getInt(index2, kVar.f13294a);
                        kVar.f13294a = i17;
                        kVar.f13294a = iArr[i17];
                        continue;
                    case 23:
                        i10 = indexCount2;
                        iVar.f13249b = obtainStyledAttributes.getLayoutDimension(index2, iVar.f13249b);
                        continue;
                    case 24:
                        i10 = indexCount2;
                        iVar.E = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.E);
                        continue;
                    case 25:
                        i10 = indexCount2;
                        iVar.g = i(obtainStyledAttributes, index2, iVar.g);
                        continue;
                    case 26:
                        i10 = indexCount2;
                        iVar.f13260h = i(obtainStyledAttributes, index2, iVar.f13260h);
                        continue;
                    case 27:
                        i10 = indexCount2;
                        iVar.D = obtainStyledAttributes.getInt(index2, iVar.D);
                        continue;
                    case 28:
                        i10 = indexCount2;
                        iVar.F = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.F);
                        continue;
                    case 29:
                        i10 = indexCount2;
                        iVar.f13261i = i(obtainStyledAttributes, index2, iVar.f13261i);
                        continue;
                    case 30:
                        i10 = indexCount2;
                        iVar.f13263j = i(obtainStyledAttributes, index2, iVar.f13263j);
                        continue;
                    case 31:
                        i10 = indexCount2;
                        iVar.J = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.J);
                        continue;
                    case 32:
                        i10 = indexCount2;
                        iVar.f13276r = i(obtainStyledAttributes, index2, iVar.f13276r);
                        continue;
                    case 33:
                        i10 = indexCount2;
                        iVar.f13277s = i(obtainStyledAttributes, index2, iVar.f13277s);
                        continue;
                    case 34:
                        i10 = indexCount2;
                        iVar.G = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.G);
                        continue;
                    case 35:
                        i10 = indexCount2;
                        iVar.f13267l = i(obtainStyledAttributes, index2, iVar.f13267l);
                        continue;
                    case 36:
                        i10 = indexCount2;
                        iVar.f13265k = i(obtainStyledAttributes, index2, iVar.f13265k);
                        continue;
                    case 37:
                        i10 = indexCount2;
                        iVar.f13281w = obtainStyledAttributes.getFloat(index2, iVar.f13281w);
                        continue;
                    case 38:
                        i10 = indexCount2;
                        hVar.f13240a = obtainStyledAttributes.getResourceId(index2, hVar.f13240a);
                        continue;
                    case 39:
                        i10 = indexCount2;
                        iVar.T = obtainStyledAttributes.getFloat(index2, iVar.T);
                        continue;
                    case 40:
                        i10 = indexCount2;
                        iVar.S = obtainStyledAttributes.getFloat(index2, iVar.S);
                        continue;
                    case 41:
                        i10 = indexCount2;
                        iVar.U = obtainStyledAttributes.getInt(index2, iVar.U);
                        continue;
                    case 42:
                        i10 = indexCount2;
                        iVar.V = obtainStyledAttributes.getInt(index2, iVar.V);
                        continue;
                    case 43:
                        i10 = indexCount2;
                        kVar.f13296c = obtainStyledAttributes.getFloat(index2, kVar.f13296c);
                        continue;
                    case 44:
                        i10 = indexCount2;
                        lVar.f13309l = true;
                        lVar.f13310m = obtainStyledAttributes.getDimension(index2, lVar.f13310m);
                        continue;
                    case 45:
                        i10 = indexCount2;
                        lVar.f13300b = obtainStyledAttributes.getFloat(index2, lVar.f13300b);
                        continue;
                    case 46:
                        i10 = indexCount2;
                        lVar.f13301c = obtainStyledAttributes.getFloat(index2, lVar.f13301c);
                        continue;
                    case 47:
                        i10 = indexCount2;
                        lVar.f13302d = obtainStyledAttributes.getFloat(index2, lVar.f13302d);
                        continue;
                    case 48:
                        i10 = indexCount2;
                        lVar.f13303e = obtainStyledAttributes.getFloat(index2, lVar.f13303e);
                        continue;
                    case 49:
                        i10 = indexCount2;
                        lVar.f13304f = obtainStyledAttributes.getDimension(index2, lVar.f13304f);
                        continue;
                    case 50:
                        i10 = indexCount2;
                        lVar.g = obtainStyledAttributes.getDimension(index2, lVar.g);
                        continue;
                    case 51:
                        i10 = indexCount2;
                        lVar.f13306i = obtainStyledAttributes.getDimension(index2, lVar.f13306i);
                        continue;
                    case 52:
                        i10 = indexCount2;
                        lVar.f13307j = obtainStyledAttributes.getDimension(index2, lVar.f13307j);
                        continue;
                    case 53:
                        i10 = indexCount2;
                        lVar.f13308k = obtainStyledAttributes.getDimension(index2, lVar.f13308k);
                        continue;
                    case 54:
                        i10 = indexCount2;
                        iVar.W = obtainStyledAttributes.getInt(index2, iVar.W);
                        continue;
                    case 55:
                        i10 = indexCount2;
                        iVar.X = obtainStyledAttributes.getInt(index2, iVar.X);
                        continue;
                    case 56:
                        i10 = indexCount2;
                        iVar.Y = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.Y);
                        continue;
                    case 57:
                        i10 = indexCount2;
                        iVar.Z = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.Z);
                        continue;
                    case 58:
                        i10 = indexCount2;
                        iVar.f13248a0 = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.f13248a0);
                        continue;
                    case 59:
                        i10 = indexCount2;
                        iVar.f13250b0 = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.f13250b0);
                        continue;
                    case 60:
                        i10 = indexCount2;
                        lVar.f13299a = obtainStyledAttributes.getFloat(index2, lVar.f13299a);
                        continue;
                    case 61:
                        i10 = indexCount2;
                        iVar.f13283y = i(obtainStyledAttributes, index2, iVar.f13283y);
                        continue;
                    case 62:
                        i10 = indexCount2;
                        iVar.f13284z = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.f13284z);
                        continue;
                    case 63:
                        i10 = indexCount2;
                        iVar.A = obtainStyledAttributes.getFloat(index2, iVar.A);
                        continue;
                    case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                        i10 = indexCount2;
                        jVar.f13286a = i(obtainStyledAttributes, index2, jVar.f13286a);
                        continue;
                    case 65:
                        i10 = indexCount2;
                        if (obtainStyledAttributes.peekValue(index2).type == 3) {
                            obtainStyledAttributes.getString(index2);
                            jVar.getClass();
                            break;
                        } else {
                            String str = strArr[obtainStyledAttributes.getInteger(index2, 0)];
                            jVar.getClass();
                            break;
                        }
                    case 66:
                        i10 = indexCount2;
                        obtainStyledAttributes.getInt(index2, 0);
                        jVar.getClass();
                        continue;
                    case 67:
                        i10 = indexCount2;
                        jVar.f13290e = obtainStyledAttributes.getFloat(index2, jVar.f13290e);
                        break;
                    case 68:
                        i10 = indexCount2;
                        kVar.f13297d = obtainStyledAttributes.getFloat(index2, kVar.f13297d);
                        break;
                    case 69:
                        i10 = indexCount2;
                        iVar.f13252c0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        i10 = indexCount2;
                        iVar.f13254d0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        i10 = indexCount2;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        i10 = indexCount2;
                        iVar.f13256e0 = obtainStyledAttributes.getInt(index2, iVar.f13256e0);
                        break;
                    case 73:
                        i10 = indexCount2;
                        iVar.f13258f0 = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.f13258f0);
                        break;
                    case 74:
                        i10 = indexCount2;
                        iVar.f13262i0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        i10 = indexCount2;
                        iVar.f13270m0 = obtainStyledAttributes.getBoolean(index2, iVar.f13270m0);
                        break;
                    case 76:
                        i10 = indexCount2;
                        jVar.f13288c = obtainStyledAttributes.getInt(index2, jVar.f13288c);
                        break;
                    case 77:
                        i10 = indexCount2;
                        iVar.f13264j0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        i10 = indexCount2;
                        kVar.f13295b = obtainStyledAttributes.getInt(index2, kVar.f13295b);
                        break;
                    case 79:
                        i10 = indexCount2;
                        jVar.f13289d = obtainStyledAttributes.getFloat(index2, jVar.f13289d);
                        break;
                    case 80:
                        i10 = indexCount2;
                        iVar.f13266k0 = obtainStyledAttributes.getBoolean(index2, iVar.f13266k0);
                        break;
                    case 81:
                        i10 = indexCount2;
                        iVar.f13268l0 = obtainStyledAttributes.getBoolean(index2, iVar.f13268l0);
                        break;
                    case 82:
                        i10 = indexCount2;
                        jVar.f13287b = obtainStyledAttributes.getInteger(index2, jVar.f13287b);
                        break;
                    case 83:
                        i10 = indexCount2;
                        lVar.f13305h = i(obtainStyledAttributes, index2, lVar.f13305h);
                        break;
                    case 84:
                        i10 = indexCount2;
                        jVar.g = obtainStyledAttributes.getInteger(index2, jVar.g);
                        break;
                    case 85:
                        i10 = indexCount2;
                        jVar.f13291f = obtainStyledAttributes.getFloat(index2, jVar.f13291f);
                        break;
                    case 86:
                        i10 = indexCount2;
                        int i18 = obtainStyledAttributes.peekValue(index2).type;
                        if (i18 == 1) {
                            jVar.f13293i = obtainStyledAttributes.getResourceId(index2, -1);
                            break;
                        } else if (i18 == 3) {
                            String string2 = obtainStyledAttributes.getString(index2);
                            jVar.f13292h = string2;
                            if (string2.indexOf("/") > 0) {
                                jVar.f13293i = obtainStyledAttributes.getResourceId(index2, -1);
                                break;
                            }
                        } else {
                            obtainStyledAttributes.getInteger(index2, jVar.f13293i);
                            break;
                        }
                        break;
                    case 87:
                        i10 = indexCount2;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder sb3 = new StringBuilder("Unknown attribute 0x");
                        i10 = indexCount2;
                        sb3.append(Integer.toHexString(index2));
                        sb3.append("   ");
                        sb3.append(sparseIntArray.get(index2));
                        Log.w("ConstraintSet", sb3.toString());
                        break;
                    case 91:
                        i10 = indexCount2;
                        iVar.f13274p = i(obtainStyledAttributes, index2, iVar.f13274p);
                        break;
                    case 92:
                        i10 = indexCount2;
                        iVar.f13275q = i(obtainStyledAttributes, index2, iVar.f13275q);
                        break;
                    case 93:
                        i10 = indexCount2;
                        iVar.K = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.K);
                        break;
                    case 94:
                        i10 = indexCount2;
                        iVar.R = obtainStyledAttributes.getDimensionPixelSize(index2, iVar.R);
                        break;
                    case 95:
                        i10 = indexCount2;
                        j(iVar, obtainStyledAttributes, index2, 0);
                        continue;
                    case 96:
                        i10 = indexCount2;
                        j(iVar, obtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        i10 = indexCount2;
                        iVar.f13272n0 = obtainStyledAttributes.getInt(index2, iVar.f13272n0);
                        break;
                }
                i16++;
            }
        }
        obtainStyledAttributes.recycle();
        return hVar;
    }

    public static int i(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void j(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.m.j(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void k(d dVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                i10 = substring.equalsIgnoreCase("W") ? 0 : substring.equalsIgnoreCase("H") ? 1 : -1;
                r2 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            try {
                if (indexOf2 < 0 || indexOf2 >= length - 1) {
                    String substring2 = str.substring(r2);
                    if (substring2.length() > 0) {
                        Float.parseFloat(substring2);
                    }
                } else {
                    String substring3 = str.substring(r2, indexOf2);
                    String substring4 = str.substring(indexOf2 + 1);
                    if (substring3.length() > 0 && substring4.length() > 0) {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i10 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        dVar.F = str;
    }

    public static String m(int i10) {
        switch (i10) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public final void a(ConstraintLayout constraintLayout) {
        b(constraintLayout);
        constraintLayout.setConstraintSet(null);
        constraintLayout.requestLayout();
    }

    public final void b(ConstraintLayout constraintLayout) {
        HashSet hashSet;
        int i10;
        HashMap hashMap;
        String str;
        m mVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap2 = mVar.f13316c;
        HashSet hashSet2 = new HashSet(hashMap2.keySet());
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            int id = childAt.getId();
            if (!hashMap2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb2 = new StringBuilder("id unknown ");
                try {
                    str = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str = "UNKNOWN";
                }
                sb2.append(str);
                Log.w("ConstraintSet", sb2.toString());
            } else {
                if (mVar.f13315b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (hashMap2.containsKey(Integer.valueOf(id))) {
                        hashSet2.remove(Integer.valueOf(id));
                        h hVar = (h) hashMap2.get(Integer.valueOf(id));
                        if (hVar != null) {
                            k kVar = hVar.f13241b;
                            i iVar = hVar.f13243d;
                            l lVar = hVar.f13244e;
                            if (childAt instanceof Barrier) {
                                iVar.f13259g0 = 1;
                                Barrier barrier = (Barrier) childAt;
                                barrier.setId(id);
                                barrier.setType(iVar.f13256e0);
                                barrier.setMargin(iVar.f13258f0);
                                barrier.setAllowsGoneWidget(iVar.f13270m0);
                                int[] iArr = iVar.h0;
                                if (iArr != null) {
                                    barrier.setReferencedIds(iArr);
                                } else {
                                    String str2 = iVar.f13262i0;
                                    if (str2 != null) {
                                        int[] e7 = e(barrier, str2);
                                        iVar.h0 = e7;
                                        barrier.setReferencedIds(e7);
                                    }
                                }
                            }
                            d dVar = (d) childAt.getLayoutParams();
                            dVar.a();
                            hVar.a(dVar);
                            HashMap hashMap3 = hVar.f13245f;
                            Class<?> cls = childAt.getClass();
                            for (String str3 : hashMap3.keySet()) {
                                a aVar = (a) hashMap3.get(str3);
                                HashSet hashSet3 = hashSet2;
                                String l10 = !aVar.f13164a ? r.a.l("set", str3) : str3;
                                int i12 = i11;
                                try {
                                    int b2 = s.e.b(aVar.f13165b);
                                    Class<?> cls2 = Float.TYPE;
                                    Class<?> cls3 = Integer.TYPE;
                                    switch (b2) {
                                        case 0:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, cls3).invoke(childAt, Integer.valueOf(aVar.f13166c));
                                            break;
                                        case 1:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, cls2).invoke(childAt, Float.valueOf(aVar.f13167d));
                                            break;
                                        case 2:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, cls3).invoke(childAt, Integer.valueOf(aVar.g));
                                            break;
                                        case 3:
                                            hashMap = hashMap3;
                                            Method method = cls.getMethod(l10, Drawable.class);
                                            ColorDrawable colorDrawable = new ColorDrawable();
                                            colorDrawable.setColor(aVar.g);
                                            method.invoke(childAt, colorDrawable);
                                            break;
                                        case 4:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, CharSequence.class).invoke(childAt, aVar.f13168e);
                                            break;
                                        case 5:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, Boolean.TYPE).invoke(childAt, Boolean.valueOf(aVar.f13169f));
                                            break;
                                        case 6:
                                            hashMap = hashMap3;
                                            cls.getMethod(l10, cls2).invoke(childAt, Float.valueOf(aVar.f13167d));
                                            break;
                                        case 7:
                                            hashMap = hashMap3;
                                            try {
                                                cls.getMethod(l10, cls3).invoke(childAt, Integer.valueOf(aVar.f13166c));
                                            } catch (IllegalAccessException e8) {
                                                e = e8;
                                                StringBuilder s10 = android.support.v4.media.d.s(" Custom Attribute \"", str3, "\" not found on ");
                                                s10.append(cls.getName());
                                                Log.e("TransitionLayout", s10.toString());
                                                e.printStackTrace();
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                hashMap3 = hashMap;
                                            } catch (NoSuchMethodException e10) {
                                                e = e10;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str3 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + l10);
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                hashMap3 = hashMap;
                                            } catch (InvocationTargetException e11) {
                                                e = e11;
                                                StringBuilder s11 = android.support.v4.media.d.s(" Custom Attribute \"", str3, "\" not found on ");
                                                s11.append(cls.getName());
                                                Log.e("TransitionLayout", s11.toString());
                                                e.printStackTrace();
                                                hashSet2 = hashSet3;
                                                i11 = i12;
                                                hashMap3 = hashMap;
                                            }
                                        default:
                                            hashMap = hashMap3;
                                            break;
                                    }
                                } catch (IllegalAccessException e12) {
                                    e = e12;
                                    hashMap = hashMap3;
                                } catch (NoSuchMethodException e13) {
                                    e = e13;
                                    hashMap = hashMap3;
                                } catch (InvocationTargetException e14) {
                                    e = e14;
                                    hashMap = hashMap3;
                                }
                                hashSet2 = hashSet3;
                                i11 = i12;
                                hashMap3 = hashMap;
                            }
                            hashSet = hashSet2;
                            i10 = i11;
                            childAt.setLayoutParams(dVar);
                            if (kVar.f13295b == 0) {
                                childAt.setVisibility(kVar.f13294a);
                            }
                            childAt.setAlpha(kVar.f13296c);
                            childAt.setRotation(lVar.f13299a);
                            childAt.setRotationX(lVar.f13300b);
                            childAt.setRotationY(lVar.f13301c);
                            childAt.setScaleX(lVar.f13302d);
                            childAt.setScaleY(lVar.f13303e);
                            if (lVar.f13305h != -1) {
                                if (((View) childAt.getParent()).findViewById(lVar.f13305h) != null) {
                                    float bottom = (r0.getBottom() + r0.getTop()) / 2.0f;
                                    float right = (r0.getRight() + r0.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(lVar.f13304f)) {
                                    childAt.setPivotX(lVar.f13304f);
                                }
                                if (!Float.isNaN(lVar.g)) {
                                    childAt.setPivotY(lVar.g);
                                }
                            }
                            childAt.setTranslationX(lVar.f13306i);
                            childAt.setTranslationY(lVar.f13307j);
                            childAt.setTranslationZ(lVar.f13308k);
                            if (lVar.f13309l) {
                                childAt.setElevation(lVar.f13310m);
                            }
                        }
                    } else {
                        hashSet = hashSet2;
                        i10 = i11;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                    i11 = i10 + 1;
                    mVar = this;
                    hashSet2 = hashSet;
                }
            }
            hashSet = hashSet2;
            i10 = i11;
            i11 = i10 + 1;
            mVar = this;
            hashSet2 = hashSet;
        }
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            h hVar2 = (h) hashMap2.get(num);
            if (hVar2 != null) {
                i iVar2 = hVar2.f13243d;
                if (iVar2.f13259g0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = iVar2.h0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str4 = iVar2.f13262i0;
                        if (str4 != null) {
                            int[] e15 = e(barrier2, str4);
                            iVar2.h0 = e15;
                            barrier2.setReferencedIds(e15);
                        }
                    }
                    barrier2.setType(iVar2.f13256e0);
                    barrier2.setMargin(iVar2.f13258f0);
                    d g = ConstraintLayout.g();
                    barrier2.i();
                    hVar2.a(g);
                    constraintLayout.addView(barrier2, g);
                }
                if (iVar2.f13247a) {
                    View guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    d g6 = ConstraintLayout.g();
                    hVar2.a(g6);
                    constraintLayout.addView(guideline, g6);
                }
            }
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt2 = constraintLayout.getChildAt(i13);
            if (childAt2 instanceof b) {
                ((b) childAt2).e(constraintLayout);
            }
        }
    }

    public final void c(ConstraintLayout constraintLayout) {
        int i10;
        HashMap hashMap;
        HashMap hashMap2;
        m mVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap3 = mVar.f13316c;
        hashMap3.clear();
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = constraintLayout.getChildAt(i11);
            d dVar = (d) childAt.getLayoutParams();
            int id = childAt.getId();
            if (mVar.f13315b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!hashMap3.containsKey(Integer.valueOf(id))) {
                hashMap3.put(Integer.valueOf(id), new h());
            }
            h hVar = (h) hashMap3.get(Integer.valueOf(id));
            if (hVar == null) {
                i10 = childCount;
                hashMap = hashMap3;
            } else {
                k kVar = hVar.f13241b;
                i iVar = hVar.f13243d;
                l lVar = hVar.f13244e;
                HashMap hashMap4 = new HashMap();
                Class<?> cls = childAt.getClass();
                HashMap hashMap5 = mVar.f13314a;
                for (String str : hashMap5.keySet()) {
                    a aVar = (a) hashMap5.get(str);
                    int i12 = childCount;
                    try {
                        if (str.equals("BackgroundColor")) {
                            hashMap2 = hashMap3;
                            try {
                                hashMap4.put(str, new a(aVar, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                            } catch (IllegalAccessException e7) {
                                e = e7;
                                e.printStackTrace();
                                childCount = i12;
                                hashMap3 = hashMap2;
                            } catch (NoSuchMethodException e8) {
                                e = e8;
                                e.printStackTrace();
                                childCount = i12;
                                hashMap3 = hashMap2;
                            } catch (InvocationTargetException e10) {
                                e = e10;
                                e.printStackTrace();
                                childCount = i12;
                                hashMap3 = hashMap2;
                            }
                        } else {
                            hashMap2 = hashMap3;
                            hashMap4.put(str, new a(aVar, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e11) {
                        e = e11;
                        hashMap2 = hashMap3;
                    } catch (NoSuchMethodException e12) {
                        e = e12;
                        hashMap2 = hashMap3;
                    } catch (InvocationTargetException e13) {
                        e = e13;
                        hashMap2 = hashMap3;
                    }
                    childCount = i12;
                    hashMap3 = hashMap2;
                }
                i10 = childCount;
                hashMap = hashMap3;
                hVar.f13245f = hashMap4;
                hVar.f13240a = id;
                iVar.g = dVar.f13184d;
                iVar.f13260h = dVar.f13186e;
                iVar.f13261i = dVar.f13188f;
                iVar.f13263j = dVar.g;
                iVar.f13265k = dVar.f13191h;
                iVar.f13267l = dVar.f13192i;
                iVar.f13269m = dVar.f13194j;
                iVar.f13271n = dVar.f13196k;
                iVar.f13273o = dVar.f13198l;
                iVar.f13274p = dVar.f13200m;
                iVar.f13275q = dVar.f13202n;
                iVar.f13276r = dVar.f13208r;
                iVar.f13277s = dVar.f13209s;
                iVar.f13278t = dVar.f13210t;
                iVar.f13279u = dVar.f13211u;
                iVar.f13280v = dVar.D;
                iVar.f13281w = dVar.E;
                iVar.f13282x = dVar.F;
                iVar.f13283y = dVar.f13204o;
                iVar.f13284z = dVar.f13206p;
                iVar.A = dVar.f13207q;
                iVar.B = dVar.S;
                iVar.C = dVar.T;
                iVar.D = dVar.U;
                iVar.f13257f = dVar.f13182c;
                iVar.f13253d = dVar.f13178a;
                iVar.f13255e = dVar.f13180b;
                iVar.f13249b = ((ViewGroup.MarginLayoutParams) dVar).width;
                iVar.f13251c = ((ViewGroup.MarginLayoutParams) dVar).height;
                iVar.E = ((ViewGroup.MarginLayoutParams) dVar).leftMargin;
                iVar.F = ((ViewGroup.MarginLayoutParams) dVar).rightMargin;
                iVar.G = ((ViewGroup.MarginLayoutParams) dVar).topMargin;
                iVar.H = ((ViewGroup.MarginLayoutParams) dVar).bottomMargin;
                iVar.K = dVar.C;
                iVar.S = dVar.H;
                iVar.T = dVar.G;
                iVar.V = dVar.J;
                iVar.U = dVar.I;
                iVar.f13266k0 = dVar.V;
                iVar.f13268l0 = dVar.W;
                iVar.W = dVar.K;
                iVar.X = dVar.L;
                iVar.Y = dVar.O;
                iVar.Z = dVar.P;
                iVar.f13248a0 = dVar.M;
                iVar.f13250b0 = dVar.N;
                iVar.f13252c0 = dVar.Q;
                iVar.f13254d0 = dVar.R;
                iVar.f13264j0 = dVar.X;
                iVar.M = dVar.f13213w;
                iVar.O = dVar.f13215y;
                iVar.L = dVar.f13212v;
                iVar.N = dVar.f13214x;
                iVar.Q = dVar.f13216z;
                iVar.P = dVar.A;
                iVar.R = dVar.B;
                iVar.f13272n0 = dVar.Y;
                iVar.I = dVar.getMarginEnd();
                iVar.J = dVar.getMarginStart();
                kVar.f13294a = childAt.getVisibility();
                kVar.f13296c = childAt.getAlpha();
                lVar.f13299a = childAt.getRotation();
                lVar.f13300b = childAt.getRotationX();
                lVar.f13301c = childAt.getRotationY();
                lVar.f13302d = childAt.getScaleX();
                lVar.f13303e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    lVar.f13304f = pivotX;
                    lVar.g = pivotY;
                }
                lVar.f13306i = childAt.getTranslationX();
                lVar.f13307j = childAt.getTranslationY();
                lVar.f13308k = childAt.getTranslationZ();
                if (lVar.f13309l) {
                    lVar.f13310m = childAt.getElevation();
                }
                if (childAt instanceof Barrier) {
                    Barrier barrier = (Barrier) childAt;
                    iVar.f13270m0 = barrier.getAllowsGoneWidget();
                    iVar.h0 = barrier.getReferencedIds();
                    iVar.f13256e0 = barrier.getType();
                    iVar.f13258f0 = barrier.getMargin();
                }
            }
            i11++;
            mVar = this;
            childCount = i10;
            hashMap3 = hashMap;
        }
    }

    public final void d(int i10, int i11, int i12, int i13) {
        Integer valueOf = Integer.valueOf(i10);
        HashMap hashMap = this.f13316c;
        if (!hashMap.containsKey(valueOf)) {
            hashMap.put(Integer.valueOf(i10), new h());
        }
        h hVar = (h) hashMap.get(Integer.valueOf(i10));
        if (hVar == null) {
            return;
        }
        i iVar = hVar.f13243d;
        switch (i11) {
            case 1:
                if (i13 == 1) {
                    iVar.g = i12;
                    iVar.f13260h = -1;
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException("Left to " + m(i13) + " undefined");
                    }
                    iVar.f13260h = i12;
                    iVar.g = -1;
                }
                iVar.E = 0;
                return;
            case 2:
                if (i13 == 1) {
                    iVar.f13261i = i12;
                    iVar.f13263j = -1;
                } else {
                    if (i13 != 2) {
                        throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                    }
                    iVar.f13263j = i12;
                    iVar.f13261i = -1;
                }
                iVar.F = 0;
                return;
            case 3:
                if (i13 == 3) {
                    iVar.f13265k = i12;
                    iVar.f13267l = -1;
                    iVar.f13273o = -1;
                    iVar.f13274p = -1;
                    iVar.f13275q = -1;
                } else {
                    if (i13 != 4) {
                        throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                    }
                    iVar.f13267l = i12;
                    iVar.f13265k = -1;
                    iVar.f13273o = -1;
                    iVar.f13274p = -1;
                    iVar.f13275q = -1;
                }
                iVar.G = 0;
                return;
            case 4:
                if (i13 == 4) {
                    iVar.f13271n = i12;
                    iVar.f13269m = -1;
                    iVar.f13273o = -1;
                    iVar.f13274p = -1;
                    iVar.f13275q = -1;
                } else {
                    if (i13 != 3) {
                        throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                    }
                    iVar.f13269m = i12;
                    iVar.f13271n = -1;
                    iVar.f13273o = -1;
                    iVar.f13274p = -1;
                    iVar.f13275q = -1;
                }
                iVar.H = 0;
                return;
            case 5:
                if (i13 == 5) {
                    iVar.f13273o = i12;
                    iVar.f13271n = -1;
                    iVar.f13269m = -1;
                    iVar.f13265k = -1;
                    iVar.f13267l = -1;
                    return;
                }
                if (i13 == 3) {
                    iVar.f13274p = i12;
                    iVar.f13271n = -1;
                    iVar.f13269m = -1;
                    iVar.f13265k = -1;
                    iVar.f13267l = -1;
                    return;
                }
                if (i13 != 4) {
                    throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                }
                iVar.f13275q = i12;
                iVar.f13271n = -1;
                iVar.f13269m = -1;
                iVar.f13265k = -1;
                iVar.f13267l = -1;
                return;
            case 6:
                if (i13 == 6) {
                    iVar.f13277s = i12;
                    iVar.f13276r = -1;
                } else {
                    if (i13 != 7) {
                        throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                    }
                    iVar.f13276r = i12;
                    iVar.f13277s = -1;
                }
                iVar.J = 0;
                return;
            case 7:
                if (i13 == 7) {
                    iVar.f13279u = i12;
                    iVar.f13278t = -1;
                } else {
                    if (i13 != 6) {
                        throw new IllegalArgumentException("right to " + m(i13) + " undefined");
                    }
                    iVar.f13278t = i12;
                    iVar.f13279u = -1;
                }
                iVar.I = 0;
                return;
            default:
                throw new IllegalArgumentException(m(i11) + " to " + m(i13) + " unknown");
        }
    }

    public final h g(int i10) {
        Integer valueOf = Integer.valueOf(i10);
        HashMap hashMap = this.f13316c;
        if (!hashMap.containsKey(valueOf)) {
            hashMap.put(Integer.valueOf(i10), new h());
        }
        return (h) hashMap.get(Integer.valueOf(i10));
    }

    public final void h(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    h f10 = f(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        f10.f13243d.f13247a = true;
                    }
                    this.f13316c.put(Integer.valueOf(f10.f13240a), f10);
                }
            }
        } catch (IOException e7) {
            e7.printStackTrace();
        } catch (XmlPullParserException e8) {
            e8.printStackTrace();
        }
    }

    public final void l(int i10, float f10) {
        g(i10).f13243d.f13257f = f10;
        g(i10).f13243d.f13255e = -1;
        g(i10).f13243d.f13253d = -1;
    }
}
