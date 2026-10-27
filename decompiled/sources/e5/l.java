package e5;

import android.content.Context;
import app.shamel.tv.apps.LTVApp;
import app.shamel.tv.helper.r;
import app.shamel.tv.models.CategoryModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final ArrayList f4606a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f4607b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final String f4608c = k5.b.a(new byte[]{106, 78, 15, -91, 39, -44, 62, -40, -10, -9, 94, 101, 94, 42, -70, 30, -11, -72, 55, -20, 102, 45, 15, 8, -84, -47, 111, 11, 106, 118, 87, -58, 29, 20, 42, 97, -30, -41, 27, 84, -11, -16, -23, -6, -7, 82, 72, -49});

    /* renamed from: d, reason: collision with root package name */
    public static final String f4609d = k5.b.a(new byte[]{106, 78, 15, -91, 39, -44, 62, -40, -10, -9, 94, 101, 94, 42, -70, 30, -113, -47, -9, -127, -97, -118, 125, -42, 30, -111, -8, -117, 6, -18, 83, Byte.MIN_VALUE, -12, 7, 27, 49, -108, 5, -92, 19, 79, -110, -7, -23, -74, 107, -95, -113});

    /* renamed from: e, reason: collision with root package name */
    public static final String f4610e = k5.b.a(new byte[]{106, 78, 15, -91, 39, -44, 62, -40, -10, -9, 94, 101, 94, 42, -70, 30, -30, 119, -84, -26, -106, 83, -87, -121, -16, -72, -1, -69, 23, -100, 124, -44, -105, 57, -37, 69, 64, -111, -29, -29, 114, -37, -89, 52, -81, -7, 75, -110});

    /* renamed from: f, reason: collision with root package name */
    public static final String f4611f = k5.b.a(new byte[]{106, 78, 15, -91, 39, -44, 62, -40, -10, -9, 94, 101, 94, 42, -70, 30, -96, 38, 3, 106, 39, 87, -31, -103, -104, 34, 69, -118, 85, -47, -63, -42, -104, 21, 64, 101, -35, 29, -118, 84, -64, -60, 121, 66, 64, -59, 4, -38});
    public static final SimpleDateFormat g = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: h, reason: collision with root package name */
    public static final String f4612h = k5.b.a(new byte[]{-52, -36, -81, 7, -89, 79, -74, -125, 48, 61, -124, -11, 19, -106, -123, 23, 11, -46, 92, -114, 119, -10, 97, 93, 31, 27, 126, 69, 107, -63, -28, -102, -57, 32, -30, -54, 75, 122, 24, -119, 19, -28, Byte.MAX_VALUE, -70, 112, 80, -54, -110});

    /* renamed from: i, reason: collision with root package name */
    public static final String f4613i;

    /* renamed from: j, reason: collision with root package name */
    public static final String f4614j;

    /* renamed from: k, reason: collision with root package name */
    public static final String f4615k;

    /* renamed from: l, reason: collision with root package name */
    public static final String f4616l;

    static {
        k5.b.a(new byte[]{-52, -36, -81, 7, -89, 79, -74, -125, 48, 61, -124, -11, 19, -106, -123, 23, 70, 37, 119, -110, 115, -113, -23, -31, 92, 16, -98, Byte.MIN_VALUE, 104, -31, -68, -40, 42, -30, 111, -89, 69, 121, -99, 10, 12, -4, -53, -76, 12, -35, 104, 7});
        f4613i = k5.b.a(new byte[]{-52, -36, -81, 7, -89, 79, -74, -125, 48, 61, -124, -11, 19, -106, -123, 23, 29, 75, 34, -85, 117, -107, -101, 7, -32, -1, 60, -72, 41, -62, -32, -10, -35, 37, 43, -38, 118, -41, 113, -44, -115, 96, -14, -108, -100, -109, -115, 5});
        f4614j = k5.b.a(new byte[]{-37, 48, 34, -43, -115, 31, -83, 100, -16, -63, 32, 8, -123, -98, -73, 91, -118, 23, -55, 61, 80, -104, -4, 45, 110, -59, 119, 99, 96, -82, 61, -83});
        k5.b.a(new byte[]{-24, 93, -104, 93, 26, -82, 18, 21, 11, 32, 42, 70, -68, 100, 66, -46, -93, 15, -55, -67, 126, -65, 35, 56, -79, -75, 20, 31, 121, 12, -76, 16, 70, -108, 61, 23, -84, -26, -95, -25, -86, -35, 56, 33, 21, -53, -83, -89});
        f4615k = k5.b.a(new byte[]{57, -62, 122, -29, -64, -122, 0, -24, -44, 74, 4, 44, 44, 45, 96, -63});
        f4616l = k5.b.a(new byte[]{-117, -43, 110, -55, -14, -109, 96, -22, 8, -61, -70, 31, -18, -98, 39, 108});
        k5.b.a(new byte[]{-24, 93, -104, 93, 26, -82, 18, 21, 11, 32, 42, 70, -68, 100, 66, -46, -93, 15, -55, -67, 126, -65, 35, 56, -79, -75, 20, 31, 121, 12, -76, 16, -16, -27, -70, 69, 81, 9, 38, 44, 79, -9, -9, 30, 27, 54, -58, 41, 57, -40, 101, -42, -84, -72, -22, 41, 62, 15, 65, -80, -58, -41, -52, 113});
        k5.b.a(new byte[]{-24, 93, -104, 93, 26, -82, 18, 21, 11, 32, 42, 70, -68, 100, 66, -46, -93, 15, -55, -67, 126, -65, 35, 56, -79, -75, 20, 31, 121, 12, -76, 16, -16, -27, -70, 69, 81, 9, 38, 44, 79, -9, -9, 30, 27, 54, -58, 41, -1, 86, -121, -84, 73, 82, 66, 47, 123, -34, -76, -13, -101, 93, -104, -114, 110, -8, 32, -31, -104, -93, 40, -40, 67, 29, -113, -123, 10, 102, -67, -122});
        k5.b.a(new byte[]{-24, 93, -104, 93, 26, -82, 18, 21, 11, 32, 42, 70, -68, 100, 66, -46, -93, 15, -55, -67, 126, -65, 35, 56, -79, -75, 20, 31, 121, 12, -76, 16, -92, 12, 0, -73, -22, 60, 113, -18, 124, 22, -85, 73, -117, 7, -17, 38});
        k5.b.a(new byte[]{99, 44, -10, 107, -112, -55, 17, 1, -82, 106, 73, -30, -68, -51, -105, -24, -60, 9, 91, 82, -32, -95, -103, 59, 81, 17, 79, -105, -44, -98, -45, -98, 119, 105, 84, -54, -88, 33, -6, -40, -46, 36, -96, 50, 26, -101, -117, 115});
    }

    public static void a(Context context, List list) {
        r rVar = new r(context);
        LTVApp.f2087v = new ArrayList();
        List a10 = rVar.a();
        LTVApp.f2087v.addAll(a10);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < a10.size(); i10++) {
            CategoryModel categoryModel = (CategoryModel) a10.get(i10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(categoryModel.getId())) {
                    LTVApp.f2087v.remove(categoryModel);
                }
            }
        }
    }

    public static void b(List list, f.j jVar) {
        r rVar = new r(jVar);
        LTVApp.f2088w = new ArrayList();
        List y8 = rVar.y();
        LTVApp.f2088w.addAll(y8);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < y8.size(); i10++) {
            CategoryModel categoryModel = (CategoryModel) y8.get(i10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(categoryModel.getId())) {
                    LTVApp.f2088w.remove(categoryModel);
                }
            }
        }
    }

    public static void c(List list, f.j jVar) {
        r rVar = new r(jVar);
        LTVApp.f2086u = new ArrayList();
        List J = rVar.J();
        LTVApp.f2086u.addAll(J);
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i10 = 0; i10 < J.size(); i10++) {
            CategoryModel categoryModel = (CategoryModel) J.get(i10);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (((String) it.next()).equalsIgnoreCase(categoryModel.getId())) {
                    LTVApp.f2086u.remove(categoryModel);
                }
            }
        }
    }
}
