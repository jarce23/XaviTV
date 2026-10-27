package x5;

import android.net.Uri;
import android.text.TextUtils;
import java.io.File;
import java.net.URL;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c0 implements t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13618a;

    /* renamed from: b, reason: collision with root package name */
    public final t f13619b;

    public /* synthetic */ c0(t tVar, int i10) {
        this.f13618a = i10;
        this.f13619b = tVar;
    }

    @Override // x5.t
    public final s a(Object obj, int i10, int i11, r5.h hVar) {
        Uri fromFile;
        switch (this.f13618a) {
            case 0:
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    fromFile = null;
                } else if (str.charAt(0) == '/') {
                    fromFile = Uri.fromFile(new File(str));
                } else {
                    Uri parse = Uri.parse(str);
                    fromFile = parse.getScheme() == null ? Uri.fromFile(new File(str)) : parse;
                }
                if (fromFile == null) {
                    return null;
                }
                t tVar = this.f13619b;
                if (tVar.b(fromFile)) {
                    return tVar.a(fromFile, i10, i11, hVar);
                }
                return null;
            default:
                return this.f13619b.a(new j((URL) obj), i10, i11, hVar);
        }
    }

    @Override // x5.t
    public final /* bridge */ /* synthetic */ boolean b(Object obj) {
        switch (this.f13618a) {
            case 0:
                break;
            default:
                break;
        }
        return true;
    }
}
