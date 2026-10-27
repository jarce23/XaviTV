package io.realm;

import app.shamel.tv.models.MovieModel;
import io.realm.internal.OsObjectSchemaInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class w0 extends MovieModel implements io.realm.internal.y {

    /* renamed from: q, reason: collision with root package name */
    public static final OsObjectSchemaInfo f6869q;

    /* renamed from: o, reason: collision with root package name */
    public v0 f6870o;

    /* renamed from: p, reason: collision with root package name */
    public c2.q f6871p;

    static {
        io.realm.internal.p pVar = new io.realm.internal.p("MovieModel", 20);
        RealmFieldType realmFieldType = RealmFieldType.STRING;
        pVar.a("added", realmFieldType, false);
        pVar.a("category_id", realmFieldType, false);
        pVar.a("category_name", realmFieldType, false);
        pVar.a("custom_sid", realmFieldType, false);
        pVar.a("extension", realmFieldType, false);
        RealmFieldType realmFieldType2 = RealmFieldType.BOOLEAN;
        pVar.a("is_favorite", realmFieldType2, true);
        pVar.a("is_locked", realmFieldType2, true);
        pVar.a("is_recent", realmFieldType2, true);
        pVar.a("name", realmFieldType, false);
        RealmFieldType realmFieldType3 = RealmFieldType.INTEGER;
        pVar.a("num", realmFieldType3, true);
        pVar.a("pro", realmFieldType3, true);
        pVar.a("rating", realmFieldType, false);
        pVar.a("recent_mil", realmFieldType3, true);
        pVar.a("stream_icon", realmFieldType, false);
        pVar.a("stream_id", realmFieldType, false);
        pVar.a("stream_type", realmFieldType, false);
        pVar.a("time", realmFieldType3, true);
        pVar.a("tmdb_id", realmFieldType, false);
        pVar.a("type", realmFieldType, false);
        pVar.a("url", realmFieldType, false);
        f6869q = pVar.b();
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6871p;
    }

    @Override // io.realm.internal.y
    public final void b() {
        if (this.f6871p != null) {
            return;
        }
        c cVar = (c) d.f6642x.get();
        this.f6870o = (v0) cVar.f6631c;
        c2.q qVar = new c2.q(this);
        this.f6871p = qVar;
        qVar.f2684e = cVar.f6629a;
        qVar.f2682c = cVar.f6630b;
        qVar.f2685f = cVar.f6632d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w0.class != obj.getClass()) {
            return false;
        }
        w0 w0Var = (w0) obj;
        d dVar = (d) this.f6871p.f2684e;
        d dVar2 = (d) w0Var.f6871p.f2684e;
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
        String j10 = ((io.realm.internal.a0) this.f6871p.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) w0Var.f6871p.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) this.f6871p.f2682c).F() == ((io.realm.internal.a0) w0Var.f6871p.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6871p;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) this.f6871p.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$added() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6849e);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$category_id() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6850f);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$category_name() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.g);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$custom_sid() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6851h);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$extension() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6852i);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final boolean realmGet$is_favorite() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).q(this.f6870o.f6853j);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final boolean realmGet$is_locked() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).q(this.f6870o.f6854k);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final boolean realmGet$is_recent() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).q(this.f6870o.f6855l);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$name() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6856m);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final int realmGet$num() {
        ((d) this.f6871p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6871p.f2682c).t(this.f6870o.f6857n);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final int realmGet$pro() {
        ((d) this.f6871p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6871p.f2682c).t(this.f6870o.f6858o);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$rating() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6859p);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final long realmGet$recent_mil() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).t(this.f6870o.f6860q);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$stream_icon() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6861r);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$stream_id() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6862s);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$stream_type() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6863t);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final long realmGet$time() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).t(this.f6870o.f6864u);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$tmdb_id() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6865v);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$type() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6866w);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final String realmGet$url() {
        ((d) this.f6871p.f2684e).c();
        return ((io.realm.internal.a0) this.f6871p.f2682c).u(this.f6870o.f6867x);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$added(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6849e);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6849e, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$category_id(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6850f);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6850f, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$category_name(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.g);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.g, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$custom_sid(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6851h);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6851h, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$extension(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6852i);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6852i, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$is_favorite(boolean z10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).l(this.f6870o.f6853j, z10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$is_locked(boolean z10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).l(this.f6870o.f6854k, z10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$is_recent(boolean z10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).l(this.f6870o.f6855l, z10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$name(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6856m);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6856m, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$num(int i10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).x(this.f6870o.f6857n, i10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$pro(int i10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).x(this.f6870o.f6858o, i10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$rating(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6859p);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6859p, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$recent_mil(long j10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).x(this.f6870o.f6860q, j10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$stream_icon(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6861r);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6861r, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$stream_id(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6862s);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6862s, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$stream_type(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6863t);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6863t, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$time(long j10) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6871p.f2682c).x(this.f6870o.f6864u, j10);
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$tmdb_id(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6865v);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6865v, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$type(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6866w);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6866w, str);
        }
    }

    @Override // app.shamel.tv.models.MovieModel
    public final void realmSet$url(String str) {
        c2.q qVar = this.f6871p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6871p.f2682c).j(this.f6870o.f6867x);
        } else {
            ((io.realm.internal.a0) this.f6871p.f2682c).d(this.f6870o.f6867x, str);
        }
    }

    public final String toString() {
        if (!k0.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder("MovieModel = proxy[{added:");
        sb2.append(realmGet$added() != null ? realmGet$added() : "null");
        sb2.append("},{category_id:");
        sb2.append(realmGet$category_id() != null ? realmGet$category_id() : "null");
        sb2.append("},{category_name:");
        sb2.append(realmGet$category_name() != null ? realmGet$category_name() : "null");
        sb2.append("},{custom_sid:");
        sb2.append(realmGet$custom_sid() != null ? realmGet$custom_sid() : "null");
        sb2.append("},{extension:");
        sb2.append(realmGet$extension() != null ? realmGet$extension() : "null");
        sb2.append("},{is_favorite:");
        sb2.append(realmGet$is_favorite());
        sb2.append("},{is_locked:");
        sb2.append(realmGet$is_locked());
        sb2.append("},{is_recent:");
        sb2.append(realmGet$is_recent());
        sb2.append("},{name:");
        sb2.append(realmGet$name() != null ? realmGet$name() : "null");
        sb2.append("},{num:");
        sb2.append(realmGet$num());
        sb2.append("},{pro:");
        sb2.append(realmGet$pro());
        sb2.append("},{rating:");
        sb2.append(realmGet$rating() != null ? realmGet$rating() : "null");
        sb2.append("},{recent_mil:");
        sb2.append(realmGet$recent_mil());
        sb2.append("},{stream_icon:");
        sb2.append(realmGet$stream_icon() != null ? realmGet$stream_icon() : "null");
        sb2.append("},{stream_id:");
        sb2.append(realmGet$stream_id() != null ? realmGet$stream_id() : "null");
        sb2.append("},{stream_type:");
        sb2.append(realmGet$stream_type() != null ? realmGet$stream_type() : "null");
        sb2.append("},{time:");
        sb2.append(realmGet$time());
        sb2.append("},{tmdb_id:");
        sb2.append(realmGet$tmdb_id() != null ? realmGet$tmdb_id() : "null");
        sb2.append("},{type:");
        sb2.append(realmGet$type() != null ? realmGet$type() : "null");
        sb2.append("},{url:");
        return android.support.v4.media.d.r(sb2, realmGet$url() != null ? realmGet$url() : "null", "}]");
    }
}
