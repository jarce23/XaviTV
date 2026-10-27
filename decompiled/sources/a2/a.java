package a2;

import a3.c;
import com.bumptech.glide.d;
import i1.p;
import y2.i;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f17a = new a();

    public final d a(p pVar) {
        String str = pVar.f5991n;
        if (str != null) {
            switch (str) {
                case "application/vnd.dvb.ait":
                    return new u2.b(0);
                case "application/x-icy":
                    return new x2.a();
                case "application/id3":
                    return new i(null);
                case "application/x-emsg":
                    return new u2.b(1);
                case "application/x-scte35":
                    return new c();
            }
        }
        throw new IllegalArgumentException(r.a.l("Attempted to create decoder for unsupported MIME type: ", str));
    }

    public final boolean b(p pVar) {
        String str = pVar.f5991n;
        return "application/id3".equals(str) || "application/x-emsg".equals(str) || "application/x-scte35".equals(str) || "application/x-icy".equals(str) || "application/vnd.dvb.ait".equals(str);
    }
}
