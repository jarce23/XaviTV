package t5;

import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public final Class f11943a;

    /* renamed from: b, reason: collision with root package name */
    public final List f11944b;

    /* renamed from: c, reason: collision with root package name */
    public final f6.b f11945c;

    /* renamed from: d, reason: collision with root package name */
    public final l0.c f11946d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11947e;

    public i(Class cls, Class cls2, Class cls3, List list, f6.b bVar, android.support.v4.media.session.a0 a0Var) {
        this.f11943a = cls;
        this.f11944b = list;
        this.f11945c = bVar;
        this.f11946d = a0Var;
        this.f11947e = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b7, code lost:
    
        if (r0 == 3) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        if (r2 != 2) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        if (r0 == 1) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final t5.y a(int r17, int r18, app.shamel.tv.b r19, com.bumptech.glide.load.data.f r20, r5.h r21) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.i.a(int, int, app.shamel.tv.b, com.bumptech.glide.load.data.f, r5.h):t5.y");
    }

    public final y b(com.bumptech.glide.load.data.f fVar, int i10, int i11, r5.h hVar, List list) {
        List list2 = this.f11944b;
        int size = list2.size();
        y yVar = null;
        for (int i12 = 0; i12 < size; i12++) {
            r5.j jVar = (r5.j) list2.get(i12);
            try {
                if (jVar.a(fVar.a(), hVar)) {
                    yVar = jVar.b(fVar.a(), i10, i11, hVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e7) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + jVar, e7);
                }
                list.add(e7);
            }
            if (yVar != null) {
                break;
            }
        }
        if (yVar != null) {
            return yVar;
        }
        throw new u(this.f11947e, new ArrayList(list));
    }

    public final String toString() {
        return "DecodePath{ dataClass=" + this.f11943a + ", decoders=" + this.f11944b + ", transcoder=" + this.f11945c + '}';
    }
}
