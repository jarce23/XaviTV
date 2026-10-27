package v9;

import java.util.Date;
import java.util.HashMap;
import t9.f;
import t9.g;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d implements u9.a {

    /* renamed from: f, reason: collision with root package name */
    public static final b f12694f;
    public static final b g;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f12696a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f12697b;

    /* renamed from: c, reason: collision with root package name */
    public final a f12698c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f12699d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f12693e = new a(0);

    /* renamed from: h, reason: collision with root package name */
    public static final c f12695h = new c();

    /* JADX WARN: Type inference failed for: r0v1, types: [v9.b] */
    /* JADX WARN: Type inference failed for: r0v2, types: [v9.b] */
    static {
        final int i10 = 0;
        f12694f = new f() { // from class: v9.b
            @Override // t9.a
            public final void a(Object obj, Object obj2) {
                switch (i10) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
        final int i11 = 1;
        g = new f() { // from class: v9.b
            @Override // t9.a
            public final void a(Object obj, Object obj2) {
                switch (i11) {
                    case 0:
                        ((g) obj2).b((String) obj);
                        break;
                    default:
                        ((g) obj2).c(((Boolean) obj).booleanValue());
                        break;
                }
            }
        };
    }

    public d() {
        HashMap hashMap = new HashMap();
        this.f12696a = hashMap;
        HashMap hashMap2 = new HashMap();
        this.f12697b = hashMap2;
        this.f12698c = f12693e;
        this.f12699d = false;
        hashMap2.put(String.class, f12694f);
        hashMap.remove(String.class);
        hashMap2.put(Boolean.class, g);
        hashMap.remove(Boolean.class);
        hashMap2.put(Date.class, f12695h);
        hashMap.remove(Date.class);
    }

    public final u9.a a(Class cls, t9.d dVar) {
        this.f12696a.put(cls, dVar);
        this.f12697b.remove(cls);
        return this;
    }
}
