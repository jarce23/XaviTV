package x5;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13613a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13614b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13615c;

    public /* synthetic */ b(Object obj, int i10, Object obj2) {
        this.f13613a = i10;
        this.f13615c = obj;
        this.f13614b = obj2;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        com.bumptech.glide.load.data.i iVar;
        s a10;
        Uri uri;
        switch (this.f13613a) {
            case 0:
                Uri uri2 = (Uri) obj;
                String substring = uri2.toString().substring(22);
                l6.d dVar = new l6.d(uri2);
                AssetManager assetManager = (AssetManager) this.f13615c;
                switch (((a) this.f13614b).f13609a) {
                    case 0:
                        iVar = new com.bumptech.glide.load.data.i(assetManager, substring, 0);
                        break;
                    default:
                        iVar = new com.bumptech.glide.load.data.i(assetManager, substring, 1);
                        break;
                }
                return new s(dVar, iVar);
            case 1:
                Integer num = (Integer) obj;
                Resources.Theme theme = (Resources.Theme) hVar.c(c6.c.f2955b);
                return new s(new l6.d(num), new h(theme, theme != null ? theme.getResources() : ((Context) this.f13615c).getResources(), (g) this.f13614b, num.intValue()));
            case 2:
                ArrayList arrayList = (ArrayList) this.f13615c;
                int size = arrayList.size();
                ArrayList arrayList2 = new ArrayList(size);
                r5.e eVar = null;
                for (int i12 = 0; i12 < size; i12++) {
                    t tVar = (t) arrayList.get(i12);
                    if (tVar.b(obj) && (a10 = tVar.a(obj, i10, i11, hVar)) != null) {
                        eVar = a10.f13664a;
                        arrayList2.add(a10.f13666c);
                    }
                }
                if (arrayList2.isEmpty() || eVar == null) {
                    return null;
                }
                return new s(eVar, new x(arrayList2, (l0.c) this.f13614b));
            case 3:
                Integer num2 = (Integer) obj;
                try {
                    uri = Uri.parse("android.resource://" + ((Resources) this.f13614b).getResourcePackageName(num2.intValue()) + '/' + num2);
                } catch (Resources.NotFoundException e7) {
                    if (Log.isLoggable("ResourceLoader", 5)) {
                        Log.w("ResourceLoader", "Received invalid resource id: " + num2, e7);
                    }
                    uri = null;
                }
                if (uri == null) {
                    return null;
                }
                return ((t) this.f13615c).a(uri, i10, i11, hVar);
            default:
                Uri uri3 = (Uri) obj;
                t tVar2 = (t) this.f13614b;
                List<String> pathSegments = uri3.getPathSegments();
                s sVar = null;
                if (pathSegments.size() == 1) {
                    try {
                        int parseInt = Integer.parseInt(uri3.getPathSegments().get(0));
                        if (parseInt != 0) {
                            sVar = tVar2.a(Integer.valueOf(parseInt), i10, i11, hVar);
                        } else if (Log.isLoggable("ResourceUriLoader", 5)) {
                            Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri3);
                        }
                        return sVar;
                    } catch (NumberFormatException e8) {
                        if (!Log.isLoggable("ResourceUriLoader", 5)) {
                            return sVar;
                        }
                        Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri3, e8);
                        return sVar;
                    }
                }
                if (pathSegments.size() != 2) {
                    if (!Log.isLoggable("ResourceUriLoader", 5)) {
                        return null;
                    }
                    Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri3);
                    return null;
                }
                List<String> pathSegments2 = uri3.getPathSegments();
                String str = pathSegments2.get(0);
                String str2 = pathSegments2.get(1);
                Context context = (Context) this.f13615c;
                int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
                if (identifier != 0) {
                    return tVar2.a(Integer.valueOf(identifier), i10, i11, hVar);
                }
                if (!Log.isLoggable("ResourceUriLoader", 5)) {
                    return null;
                }
                Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri3);
                return null;
        }
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        switch (this.f13613a) {
            case 0:
                Uri uri = (Uri) obj;
                return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
            case 1:
                return true;
            case 2:
                ArrayList arrayList = (ArrayList) this.f13615c;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj2 = arrayList.get(i10);
                    i10++;
                    if (((t) obj2).b(obj)) {
                        return true;
                    }
                }
                return false;
            case 3:
                return true;
            default:
                Uri uri2 = (Uri) obj;
                return "android.resource".equals(uri2.getScheme()) && ((Context) this.f13615c).getPackageName().equals(uri2.getAuthority());
        }
    }

    public String toString() {
        switch (this.f13613a) {
            case 2:
                return "MultiModelLoader{modelLoaders=" + Arrays.toString(((ArrayList) this.f13615c).toArray()) + '}';
            default:
                return super.toString();
        }
    }

    public b(Resources resources, t tVar) {
        this.f13613a = 3;
        this.f13614b = resources;
        this.f13615c = tVar;
    }

    public b(Context context, g gVar) {
        this.f13613a = 1;
        this.f13615c = context.getApplicationContext();
        this.f13614b = gVar;
    }

    public b(Context context, t tVar) {
        this.f13613a = 4;
        this.f13615c = context.getApplicationContext();
        this.f13614b = tVar;
    }
}
