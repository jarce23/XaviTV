package io.realm;

import app.shamel.tv.models.SeriesModel;
import io.realm.internal.OsObjectSchemaInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class y0 extends SeriesModel implements io.realm.internal.y {

    /* renamed from: q, reason: collision with root package name */
    public static final OsObjectSchemaInfo f6895q;

    /* renamed from: o, reason: collision with root package name */
    public x0 f6896o;

    /* renamed from: p, reason: collision with root package name */
    public c2.q f6897p;

    static {
        io.realm.internal.p pVar = new io.realm.internal.p("SeriesModel", 23);
        RealmFieldType realmFieldType = RealmFieldType.STRING;
        pVar.a("cast", realmFieldType, false);
        pVar.a("category_id", realmFieldType, false);
        pVar.a("category_name", realmFieldType, false);
        pVar.a("director", realmFieldType, false);
        RealmFieldType realmFieldType2 = RealmFieldType.INTEGER;
        pVar.a("episode_pos", realmFieldType2, true);
        pVar.a("genre", realmFieldType, false);
        RealmFieldType realmFieldType3 = RealmFieldType.BOOLEAN;
        pVar.a("is_favorite", realmFieldType3, true);
        pVar.a("is_recent", realmFieldType3, true);
        pVar.a("is_watched", realmFieldType3, true);
        pVar.a("last_modified", realmFieldType, false);
        pVar.a("name", realmFieldType, false);
        pVar.a("num", realmFieldType2, true);
        pVar.a("plot", realmFieldType, false);
        pVar.a("rating", realmFieldType, false);
        pVar.a("rating_5based", RealmFieldType.FLOAT, true);
        pVar.a("releaseDate", realmFieldType, false);
        pVar.a("season_pos", realmFieldType2, true);
        pVar.a("series_id", realmFieldType, false);
        pVar.a("stream_icon", realmFieldType, false);
        pVar.a("stream_type", realmFieldType, false);
        pVar.a("tmdb", realmFieldType, false);
        pVar.a("url", realmFieldType, false);
        pVar.a("youtube", realmFieldType, false);
        f6895q = pVar.b();
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6897p;
    }

    @Override // io.realm.internal.y
    public final void b() {
        if (this.f6897p != null) {
            return;
        }
        c cVar = (c) d.f6642x.get();
        this.f6896o = (x0) cVar.f6631c;
        c2.q qVar = new c2.q(this);
        this.f6897p = qVar;
        qVar.f2684e = cVar.f6629a;
        qVar.f2682c = cVar.f6630b;
        qVar.f2685f = cVar.f6632d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || y0.class != obj.getClass()) {
            return false;
        }
        y0 y0Var = (y0) obj;
        d dVar = (d) this.f6897p.f2684e;
        d dVar2 = (d) y0Var.f6897p.f2684e;
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
        String j10 = ((io.realm.internal.a0) this.f6897p.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) y0Var.f6897p.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) this.f6897p.f2682c).F() == ((io.realm.internal.a0) y0Var.f6897p.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6897p;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) this.f6897p.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$cast() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6873e);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$category_id() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6874f);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$category_name() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.g);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$director() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6875h);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final int realmGet$episode_pos() {
        ((d) this.f6897p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6897p.f2682c).t(this.f6896o.f6876i);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$genre() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6877j);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final boolean realmGet$is_favorite() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).q(this.f6896o.f6878k);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final boolean realmGet$is_recent() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).q(this.f6896o.f6879l);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final boolean realmGet$is_watched() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).q(this.f6896o.f6880m);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$last_modified() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6881n);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$name() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6882o);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final int realmGet$num() {
        ((d) this.f6897p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6897p.f2682c).t(this.f6896o.f6883p);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$plot() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6884q);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$rating() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6885r);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final float realmGet$rating_5based() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).s(this.f6896o.f6886s);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$releaseDate() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6887t);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final int realmGet$season_pos() {
        ((d) this.f6897p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6897p.f2682c).t(this.f6896o.f6888u);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$series_id() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6889v);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$stream_icon() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6890w);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$stream_type() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6891x);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$tmdb() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6892y);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$url() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.f6893z);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final String realmGet$youtube() {
        ((d) this.f6897p.f2684e).c();
        return ((io.realm.internal.a0) this.f6897p.f2682c).u(this.f6896o.A);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$cast(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6873e);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6873e, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$category_id(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6874f);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6874f, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$category_name(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.g);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.g, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$director(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6875h);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6875h, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$episode_pos(int i10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).x(this.f6896o.f6876i, i10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$genre(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6877j);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6877j, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$is_favorite(boolean z10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).l(this.f6896o.f6878k, z10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$is_recent(boolean z10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).l(this.f6896o.f6879l, z10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$is_watched(boolean z10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).l(this.f6896o.f6880m, z10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$last_modified(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6881n);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6881n, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$name(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6882o);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6882o, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$num(int i10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).x(this.f6896o.f6883p, i10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$plot(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6884q);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6884q, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$rating(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6885r);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6885r, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$rating_5based(float f10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).f(this.f6896o.f6886s, f10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$releaseDate(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6887t);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6887t, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$season_pos(int i10) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6897p.f2682c).x(this.f6896o.f6888u, i10);
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$series_id(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6889v);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6889v, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$stream_icon(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6890w);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6890w, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$stream_type(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6891x);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6891x, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$tmdb(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6892y);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6892y, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$url(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.f6893z);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.f6893z, str);
        }
    }

    @Override // app.shamel.tv.models.SeriesModel
    public final void realmSet$youtube(String str) {
        c2.q qVar = this.f6897p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6897p.f2682c).j(this.f6896o.A);
        } else {
            ((io.realm.internal.a0) this.f6897p.f2682c).d(this.f6896o.A, str);
        }
    }

    public final String toString() {
        if (!k0.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder("SeriesModel = proxy[{cast:");
        sb2.append(realmGet$cast() != null ? realmGet$cast() : "null");
        sb2.append("},{category_id:");
        sb2.append(realmGet$category_id() != null ? realmGet$category_id() : "null");
        sb2.append("},{category_name:");
        sb2.append(realmGet$category_name() != null ? realmGet$category_name() : "null");
        sb2.append("},{director:");
        sb2.append(realmGet$director() != null ? realmGet$director() : "null");
        sb2.append("},{episode_pos:");
        sb2.append(realmGet$episode_pos());
        sb2.append("},{genre:");
        sb2.append(realmGet$genre() != null ? realmGet$genre() : "null");
        sb2.append("},{is_favorite:");
        sb2.append(realmGet$is_favorite());
        sb2.append("},{is_recent:");
        sb2.append(realmGet$is_recent());
        sb2.append("},{is_watched:");
        sb2.append(realmGet$is_watched());
        sb2.append("},{last_modified:");
        sb2.append(realmGet$last_modified() != null ? realmGet$last_modified() : "null");
        sb2.append("},{name:");
        sb2.append(realmGet$name() != null ? realmGet$name() : "null");
        sb2.append("},{num:");
        sb2.append(realmGet$num());
        sb2.append("},{plot:");
        sb2.append(realmGet$plot() != null ? realmGet$plot() : "null");
        sb2.append("},{rating:");
        sb2.append(realmGet$rating() != null ? realmGet$rating() : "null");
        sb2.append("},{rating_5based:");
        sb2.append(realmGet$rating_5based());
        sb2.append("},{releaseDate:");
        sb2.append(realmGet$releaseDate() != null ? realmGet$releaseDate() : "null");
        sb2.append("},{season_pos:");
        sb2.append(realmGet$season_pos());
        sb2.append("},{series_id:");
        sb2.append(realmGet$series_id() != null ? realmGet$series_id() : "null");
        sb2.append("},{stream_icon:");
        sb2.append(realmGet$stream_icon() != null ? realmGet$stream_icon() : "null");
        sb2.append("},{stream_type:");
        sb2.append(realmGet$stream_type() != null ? realmGet$stream_type() : "null");
        sb2.append("},{tmdb:");
        sb2.append(realmGet$tmdb() != null ? realmGet$tmdb() : "null");
        sb2.append("},{url:");
        sb2.append(realmGet$url() != null ? realmGet$url() : "null");
        sb2.append("},{youtube:");
        return android.support.v4.media.d.r(sb2, realmGet$youtube() != null ? realmGet$youtube() : "null", "}]");
    }
}
