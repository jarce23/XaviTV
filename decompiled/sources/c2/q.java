package c2;

import android.content.Context;
import androidx.media3.exoplayer.hls.HlsMediaSource$Factory;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2680a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2681b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2682c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2683d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2684e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2685f;
    public Object g;

    public q(io.realm.k0 k0Var) {
        this.f2680a = true;
        this.g = new io.realm.internal.n();
        this.f2681b = k0Var;
    }

    public c0 a(int i10) {
        n9.h hVar;
        HashMap hashMap = (HashMap) this.f2683d;
        c0 c0Var = (c0) hashMap.get(Integer.valueOf(i10));
        if (c0Var != null) {
            return c0Var;
        }
        HashMap hashMap2 = (HashMap) this.f2682c;
        n9.h hVar2 = (n9.h) hashMap2.get(Integer.valueOf(i10));
        if (hVar2 == null) {
            final o1.g gVar = (o1.g) this.f2684e;
            gVar.getClass();
            final int i11 = 0;
            if (i10 != 0) {
                final int i12 = 1;
                if (i10 != 1) {
                    final int i13 = 2;
                    if (i10 != 2) {
                        final int i14 = 3;
                        if (i10 == 3) {
                            hVar = new p(i11, Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(c0.class));
                        } else {
                            if (i10 != 4) {
                                throw new IllegalArgumentException(android.support.v4.media.d.m(i10, "Unrecognized contentType: "));
                            }
                            hVar2 = new n9.h() { // from class: c2.o
                                @Override // n9.h
                                public final Object get() {
                                    switch (i14) {
                                        case 0:
                                            return r.f((Class) this, gVar);
                                        case 1:
                                            return r.f((Class) this, gVar);
                                        case 2:
                                            return r.f((Class) this, gVar);
                                        default:
                                            return new w0(gVar, (k2.l) ((q) this).f2681b);
                                    }
                                }
                            };
                        }
                    } else {
                        final Class asSubclass = HlsMediaSource$Factory.class.asSubclass(c0.class);
                        hVar = new n9.h() { // from class: c2.o
                            @Override // n9.h
                            public final Object get() {
                                switch (i13) {
                                    case 0:
                                        return r.f((Class) asSubclass, gVar);
                                    case 1:
                                        return r.f((Class) asSubclass, gVar);
                                    case 2:
                                        return r.f((Class) asSubclass, gVar);
                                    default:
                                        return new w0(gVar, (k2.l) ((q) asSubclass).f2681b);
                                }
                            }
                        };
                    }
                } else {
                    final GenericDeclaration asSubclass2 = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(c0.class);
                    hVar = new n9.h() { // from class: c2.o
                        @Override // n9.h
                        public final Object get() {
                            switch (i12) {
                                case 0:
                                    return r.f((Class) asSubclass2, gVar);
                                case 1:
                                    return r.f((Class) asSubclass2, gVar);
                                case 2:
                                    return r.f((Class) asSubclass2, gVar);
                                default:
                                    return new w0(gVar, (k2.l) ((q) asSubclass2).f2681b);
                            }
                        }
                    };
                }
                hVar2 = hVar;
            } else {
                final GenericDeclaration asSubclass3 = Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(c0.class);
                hVar2 = new n9.h() { // from class: c2.o
                    @Override // n9.h
                    public final Object get() {
                        switch (i11) {
                            case 0:
                                return r.f((Class) asSubclass3, gVar);
                            case 1:
                                return r.f((Class) asSubclass3, gVar);
                            case 2:
                                return r.f((Class) asSubclass3, gVar);
                            default:
                                return new w0(gVar, (k2.l) ((q) asSubclass3).f2681b);
                        }
                    }
                };
            }
            hashMap2.put(Integer.valueOf(i10), hVar2);
        }
        c0 c0Var2 = (c0) hVar2.get();
        x4.l lVar = (x4.l) this.g;
        if (lVar != null) {
            c0Var2.c(lVar);
        }
        c0Var2.e((d9.f) this.f2685f);
        c0Var2.a(this.f2680a);
        c0Var2.b();
        hashMap.put(Integer.valueOf(i10), c0Var2);
        return c0Var2;
    }

    public void b() {
        this.f2680a = false;
        this.f2685f = null;
    }

    public q(Context context) {
        this.f2681b = context;
        this.f2682c = u1.b.f12152c;
        this.f2684e = u1.a0.f12150a;
        this.f2685f = u1.a0.f12151b;
    }

    public q(k2.l lVar, d9.f fVar) {
        this.f2681b = lVar;
        this.f2685f = fVar;
        this.f2682c = new HashMap();
        this.f2683d = new HashMap();
        this.f2680a = true;
    }
}
