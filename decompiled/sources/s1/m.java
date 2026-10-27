package s1;

import android.content.Context;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class m implements n9.h {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f11375o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ f.j f11376p;

    public /* synthetic */ m(f.j jVar, int i10) {
        this.f11375o = i10;
        this.f11376p = jVar;
    }

    @Override // n9.h
    public final Object get() {
        g2.g gVar;
        switch (this.f11375o) {
            case 0:
                return new j(this.f11376p);
            case 1:
                f.j jVar = this.f11376p;
                return new c2.r(new x4.r((Context) jVar), new k2.l());
            case 2:
                return new f2.r(this.f11376p);
            default:
                f.j jVar2 = this.f11376p;
                o9.w0 w0Var = g2.g.f5094p;
                synchronized (g2.g.class) {
                    try {
                        if (g2.g.f5100v == null) {
                            Context applicationContext = jVar2.getApplicationContext();
                            HashMap hashMap = new HashMap(8);
                            hashMap.put(0, 1000000L);
                            hashMap.put(2, -9223372036854775807L);
                            hashMap.put(3, -9223372036854775807L);
                            hashMap.put(4, -9223372036854775807L);
                            hashMap.put(5, -9223372036854775807L);
                            hashMap.put(10, -9223372036854775807L);
                            hashMap.put(9, -9223372036854775807L);
                            hashMap.put(7, -9223372036854775807L);
                            g2.g.f5100v = new g2.g(applicationContext, hashMap);
                        }
                        gVar = g2.g.f5100v;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return gVar;
        }
    }
}
