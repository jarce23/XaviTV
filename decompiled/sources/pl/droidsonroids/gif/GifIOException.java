package pl.droidsonroids.gif;

import java.io.IOException;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class GifIOException extends IOException {

    /* renamed from: o, reason: collision with root package name */
    public final ub.a f10194o;

    /* renamed from: p, reason: collision with root package name */
    public final String f10195p;

    public GifIOException(int i10, String str) {
        ub.a aVar;
        ub.a[] values = ub.a.values();
        int length = values.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                aVar = ub.a.UNKNOWN;
                aVar.f12571p = i10;
                break;
            } else {
                aVar = values[i11];
                if (aVar.f12571p == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.f10194o = aVar;
        this.f10195p = str;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        ub.a aVar = this.f10194o;
        String str = this.f10195p;
        if (str == null) {
            aVar.getClass();
            Locale locale = Locale.ENGLISH;
            return "GifError " + aVar.f12571p + ": " + aVar.f12570o;
        }
        StringBuilder sb2 = new StringBuilder();
        aVar.getClass();
        Locale locale2 = Locale.ENGLISH;
        sb2.append("GifError " + aVar.f12571p + ": " + aVar.f12570o);
        return android.support.v4.media.d.r(sb2, ": ", str);
    }
}
