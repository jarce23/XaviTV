package x5;

import a6.n0;
import android.content.Context;
import android.net.Uri;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class p implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13660a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13661b;

    public p(Context context, int i10) {
        this.f13660a = i10;
        switch (i10) {
            case 1:
                this.f13661b = context.getApplicationContext();
                break;
            case 2:
                this.f13661b = context.getApplicationContext();
                break;
            default:
                this.f13661b = context;
                break;
        }
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        Long l10;
        switch (this.f13660a) {
            case 0:
                Uri uri = (Uri) obj;
                return new s(new l6.d(uri), new o(this.f13661b, 0, uri));
            case 1:
                Uri uri2 = (Uri) obj;
                if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE || i10 > 512 || i11 > 384) {
                    return null;
                }
                l6.d dVar = new l6.d(uri2);
                Context context = this.f13661b;
                return new s(dVar, s5.c.e(context, uri2, new s5.b(context.getContentResolver(), 0)));
            default:
                Uri uri3 = (Uri) obj;
                if (i10 == Integer.MIN_VALUE || i11 == Integer.MIN_VALUE || i10 > 512 || i11 > 384 || (l10 = (Long) hVar.c(n0.f75d)) == null || l10.longValue() != -1) {
                    return null;
                }
                l6.d dVar2 = new l6.d(uri3);
                Context context2 = this.f13661b;
                return new s(dVar2, s5.c.e(context2, uri3, new s5.b(context2.getContentResolver(), 1)));
        }
    }

    @Override // x5.t
    public final boolean b(Object obj) {
        switch (this.f13660a) {
            case 0:
                return w7.b.s((Uri) obj);
            case 1:
                Uri uri = (Uri) obj;
                return w7.b.s(uri) && !uri.getPathSegments().contains("video");
            default:
                Uri uri2 = (Uri) obj;
                return w7.b.s(uri2) && uri2.getPathSegments().contains("video");
        }
    }
}
