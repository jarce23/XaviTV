package io.realm;

import app.shamel.tv.models.EpisodeInfoModel;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.Table;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s0 extends EpisodeInfoModel implements io.realm.internal.y {

    /* renamed from: q, reason: collision with root package name */
    public static final OsObjectSchemaInfo f6826q;

    /* renamed from: o, reason: collision with root package name */
    public r0 f6827o;

    /* renamed from: p, reason: collision with root package name */
    public c2.q f6828p;

    static {
        io.realm.internal.p pVar = new io.realm.internal.p("EpisodeInfoModel", 9);
        RealmFieldType realmFieldType = RealmFieldType.INTEGER;
        pVar.a("bitrate", realmFieldType, true);
        RealmFieldType realmFieldType2 = RealmFieldType.STRING;
        pVar.a("duration", realmFieldType2, false);
        pVar.a("duration_secs", realmFieldType, true);
        pVar.a("movie_image", realmFieldType2, false);
        pVar.a("name", realmFieldType2, false);
        pVar.a("plot", realmFieldType2, false);
        pVar.a("rating", realmFieldType2, false);
        pVar.a("releasedate", realmFieldType2, false);
        pVar.a("tmdb_id", realmFieldType2, false);
        f6826q = pVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static long c(u uVar, EpisodeInfoModel episodeInfoModel, HashMap hashMap) {
        k kVar = uVar.f6840y;
        if ((episodeInfoModel instanceof io.realm.internal.y) && !k0.isFrozen(episodeInfoModel)) {
            io.realm.internal.y yVar = (io.realm.internal.y) episodeInfoModel;
            if (((d) yVar.a().f2684e) != null && ((d) yVar.a().f2684e).f6645q.f6666c.equals(uVar.f6645q.f6666c)) {
                return ((io.realm.internal.a0) yVar.a().f2682c).F();
            }
        }
        Table b2 = kVar.b(EpisodeInfoModel.class);
        long j10 = b2.f6717o;
        r0 r0Var = (r0) kVar.a(EpisodeInfoModel.class);
        long createRow = OsObject.createRow(b2);
        hashMap.put(episodeInfoModel, Long.valueOf(createRow));
        Table.nativeSetLong(j10, r0Var.f6812e, createRow, episodeInfoModel.realmGet$bitrate(), false);
        String realmGet$duration = episodeInfoModel.realmGet$duration();
        if (realmGet$duration != null) {
            Table.nativeSetString(j10, r0Var.f6813f, createRow, realmGet$duration, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6813f, createRow, false);
        }
        Table.nativeSetLong(j10, r0Var.g, createRow, episodeInfoModel.realmGet$duration_secs(), false);
        String realmGet$movie_image = episodeInfoModel.realmGet$movie_image();
        if (realmGet$movie_image != null) {
            Table.nativeSetString(j10, r0Var.f6814h, createRow, realmGet$movie_image, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6814h, createRow, false);
        }
        String realmGet$name = episodeInfoModel.realmGet$name();
        if (realmGet$name != null) {
            Table.nativeSetString(j10, r0Var.f6815i, createRow, realmGet$name, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6815i, createRow, false);
        }
        String realmGet$plot = episodeInfoModel.realmGet$plot();
        if (realmGet$plot != null) {
            Table.nativeSetString(j10, r0Var.f6816j, createRow, realmGet$plot, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6816j, createRow, false);
        }
        String realmGet$rating = episodeInfoModel.realmGet$rating();
        if (realmGet$rating != null) {
            Table.nativeSetString(j10, r0Var.f6817k, createRow, realmGet$rating, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6817k, createRow, false);
        }
        String realmGet$releasedate = episodeInfoModel.realmGet$releasedate();
        if (realmGet$releasedate != null) {
            Table.nativeSetString(j10, r0Var.f6818l, createRow, realmGet$releasedate, false);
        } else {
            Table.nativeSetNull(j10, r0Var.f6818l, createRow, false);
        }
        String realmGet$tmdb_id = episodeInfoModel.realmGet$tmdb_id();
        if (realmGet$tmdb_id != null) {
            Table.nativeSetString(j10, r0Var.f6819m, createRow, realmGet$tmdb_id, false);
            return createRow;
        }
        Table.nativeSetNull(j10, r0Var.f6819m, createRow, false);
        return createRow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(u uVar, Iterator it, HashMap hashMap) {
        k kVar = uVar.f6840y;
        Table b2 = kVar.b(EpisodeInfoModel.class);
        long j10 = b2.f6717o;
        r0 r0Var = (r0) kVar.a(EpisodeInfoModel.class);
        while (it.hasNext()) {
            EpisodeInfoModel episodeInfoModel = (EpisodeInfoModel) it.next();
            if (!hashMap.containsKey(episodeInfoModel)) {
                if ((episodeInfoModel instanceof io.realm.internal.y) && !k0.isFrozen(episodeInfoModel)) {
                    io.realm.internal.y yVar = (io.realm.internal.y) episodeInfoModel;
                    if (((d) yVar.a().f2684e) != null && ((d) yVar.a().f2684e).f6645q.f6666c.equals(uVar.f6645q.f6666c)) {
                        hashMap.put(episodeInfoModel, Long.valueOf(((io.realm.internal.a0) yVar.a().f2682c).F()));
                    }
                }
                long createRow = OsObject.createRow(b2);
                hashMap.put(episodeInfoModel, Long.valueOf(createRow));
                Table.nativeSetLong(j10, r0Var.f6812e, createRow, episodeInfoModel.realmGet$bitrate(), false);
                String realmGet$duration = episodeInfoModel.realmGet$duration();
                if (realmGet$duration != null) {
                    Table.nativeSetString(j10, r0Var.f6813f, createRow, realmGet$duration, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6813f, createRow, false);
                }
                Table.nativeSetLong(j10, r0Var.g, createRow, episodeInfoModel.realmGet$duration_secs(), false);
                String realmGet$movie_image = episodeInfoModel.realmGet$movie_image();
                if (realmGet$movie_image != null) {
                    Table.nativeSetString(j10, r0Var.f6814h, createRow, realmGet$movie_image, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6814h, createRow, false);
                }
                String realmGet$name = episodeInfoModel.realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(j10, r0Var.f6815i, createRow, realmGet$name, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6815i, createRow, false);
                }
                String realmGet$plot = episodeInfoModel.realmGet$plot();
                if (realmGet$plot != null) {
                    Table.nativeSetString(j10, r0Var.f6816j, createRow, realmGet$plot, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6816j, createRow, false);
                }
                String realmGet$rating = episodeInfoModel.realmGet$rating();
                if (realmGet$rating != null) {
                    Table.nativeSetString(j10, r0Var.f6817k, createRow, realmGet$rating, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6817k, createRow, false);
                }
                String realmGet$releasedate = episodeInfoModel.realmGet$releasedate();
                if (realmGet$releasedate != null) {
                    Table.nativeSetString(j10, r0Var.f6818l, createRow, realmGet$releasedate, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6818l, createRow, false);
                }
                String realmGet$tmdb_id = episodeInfoModel.realmGet$tmdb_id();
                if (realmGet$tmdb_id != null) {
                    Table.nativeSetString(j10, r0Var.f6819m, createRow, realmGet$tmdb_id, false);
                } else {
                    Table.nativeSetNull(j10, r0Var.f6819m, createRow, false);
                }
            }
        }
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6828p;
    }

    @Override // io.realm.internal.y
    public final void b() {
        if (this.f6828p != null) {
            return;
        }
        c cVar = (c) d.f6642x.get();
        this.f6827o = (r0) cVar.f6631c;
        c2.q qVar = new c2.q(this);
        this.f6828p = qVar;
        qVar.f2684e = cVar.f6629a;
        qVar.f2682c = cVar.f6630b;
        qVar.f2685f = cVar.f6632d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || s0.class != obj.getClass()) {
            return false;
        }
        s0 s0Var = (s0) obj;
        d dVar = (d) this.f6828p.f2684e;
        d dVar2 = (d) s0Var.f6828p.f2684e;
        String str = dVar.f6645q.f6666c;
        String str2 = dVar2.f6645q.f6666c;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
        } else if (str2 != null) {
            return false;
        }
        if (dVar.N() != dVar2.N() || !dVar.f6647s.getVersionID().equals(dVar2.f6647s.getVersionID())) {
            return false;
        }
        String j10 = ((io.realm.internal.a0) this.f6828p.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) s0Var.f6828p.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) this.f6828p.f2682c).F() == ((io.realm.internal.a0) s0Var.f6828p.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6828p;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) this.f6828p.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final int realmGet$bitrate() {
        ((d) this.f6828p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6828p.f2682c).t(this.f6827o.f6812e);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$duration() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6813f);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final int realmGet$duration_secs() {
        ((d) this.f6828p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6828p.f2682c).t(this.f6827o.g);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$movie_image() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6814h);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$name() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6815i);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$plot() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6816j);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$rating() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6817k);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$releasedate() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6818l);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final String realmGet$tmdb_id() {
        ((d) this.f6828p.f2684e).c();
        return ((io.realm.internal.a0) this.f6828p.f2682c).u(this.f6827o.f6819m);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$bitrate(int i10) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6828p.f2682c).x(this.f6827o.f6812e, i10);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$duration(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6813f);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6813f, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$duration_secs(int i10) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6828p.f2682c).x(this.f6827o.g, i10);
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$movie_image(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6814h);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6814h, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$name(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6815i);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6815i, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$plot(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6816j);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6816j, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$rating(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6817k);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6817k, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$releasedate(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6818l);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6818l, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeInfoModel
    public final void realmSet$tmdb_id(String str) {
        c2.q qVar = this.f6828p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6828p.f2682c).j(this.f6827o.f6819m);
        } else {
            ((io.realm.internal.a0) this.f6828p.f2682c).d(this.f6827o.f6819m, str);
        }
    }

    public final String toString() {
        if (!k0.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder("EpisodeInfoModel = proxy[{bitrate:");
        sb2.append(realmGet$bitrate());
        sb2.append("},{duration:");
        sb2.append(realmGet$duration() != null ? realmGet$duration() : "null");
        sb2.append("},{duration_secs:");
        sb2.append(realmGet$duration_secs());
        sb2.append("},{movie_image:");
        sb2.append(realmGet$movie_image() != null ? realmGet$movie_image() : "null");
        sb2.append("},{name:");
        sb2.append(realmGet$name() != null ? realmGet$name() : "null");
        sb2.append("},{plot:");
        sb2.append(realmGet$plot() != null ? realmGet$plot() : "null");
        sb2.append("},{rating:");
        sb2.append(realmGet$rating() != null ? realmGet$rating() : "null");
        sb2.append("},{releasedate:");
        sb2.append(realmGet$releasedate() != null ? realmGet$releasedate() : "null");
        sb2.append("},{tmdb_id:");
        return android.support.v4.media.d.r(sb2, realmGet$tmdb_id() != null ? realmGet$tmdb_id() : "null", "}]");
    }
}
