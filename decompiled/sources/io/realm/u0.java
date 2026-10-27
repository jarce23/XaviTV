package io.realm;

import app.shamel.tv.models.EpisodeInfoModel;
import app.shamel.tv.models.EpisodeModel;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.Table;
import io.realm.internal.UncheckedRow;
import java.util.Collections;
import java.util.List;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u0 extends EpisodeModel implements io.realm.internal.y {

    /* renamed from: q, reason: collision with root package name */
    public static final OsObjectSchemaInfo f6841q;

    /* renamed from: o, reason: collision with root package name */
    public t0 f6842o;

    /* renamed from: p, reason: collision with root package name */
    public c2.q f6843p;

    static {
        io.realm.internal.p pVar = new io.realm.internal.p("EpisodeModel", 11);
        RealmFieldType realmFieldType = RealmFieldType.STRING;
        pVar.a("category_name", realmFieldType, false);
        pVar.a("container_extension", realmFieldType, false);
        pVar.a("episode_num", realmFieldType, false);
        pVar.a("id", realmFieldType, false);
        long nativeCreatePersistedLinkProperty = Property.nativeCreatePersistedLinkProperty("info_model", _UrlKt.FRAGMENT_ENCODE_SET, Property.a(RealmFieldType.OBJECT, false), "EpisodeInfoModel");
        long[] jArr = (long[]) pVar.f6758r;
        int i10 = pVar.f6755o;
        jArr[i10] = nativeCreatePersistedLinkProperty;
        pVar.f6755o = i10 + 1;
        pVar.a("season", RealmFieldType.INTEGER, true);
        pVar.a("season_name", realmFieldType, false);
        pVar.a("series_name", realmFieldType, false);
        pVar.a("stream_icon", realmFieldType, false);
        pVar.a("title", realmFieldType, false);
        pVar.a("url", realmFieldType, false);
        f6841q = pVar.b();
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6843p;
    }

    @Override // io.realm.internal.y
    public final void b() {
        if (this.f6843p != null) {
            return;
        }
        c cVar = (c) d.f6642x.get();
        this.f6842o = (t0) cVar.f6631c;
        c2.q qVar = new c2.q(this);
        this.f6843p = qVar;
        qVar.f2684e = cVar.f6629a;
        qVar.f2682c = cVar.f6630b;
        qVar.f2685f = cVar.f6632d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || u0.class != obj.getClass()) {
            return false;
        }
        u0 u0Var = (u0) obj;
        d dVar = (d) this.f6843p.f2684e;
        d dVar2 = (d) u0Var.f6843p.f2684e;
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
        String j10 = ((io.realm.internal.a0) this.f6843p.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) u0Var.f6843p.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) this.f6843p.f2682c).F() == ((io.realm.internal.a0) u0Var.f6843p.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6843p;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) this.f6843p.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$category_name() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6829e);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$container_extension() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6830f);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$episode_num() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.g);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$id() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6831h);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final EpisodeInfoModel realmGet$info_model() {
        ((d) this.f6843p.f2684e).c();
        if (((io.realm.internal.a0) this.f6843p.f2682c).i(this.f6842o.f6832i)) {
            return null;
        }
        c2.q qVar = this.f6843p;
        d dVar = (d) qVar.f2684e;
        long r2 = ((io.realm.internal.a0) qVar.f2682c).r(this.f6842o.f6832i);
        List list = Collections.EMPTY_LIST;
        dVar.getClass();
        Table b2 = dVar.M().b(EpisodeInfoModel.class);
        io.realm.internal.g gVar = b2.f6718p;
        int i10 = UncheckedRow.f6726s;
        return (EpisodeInfoModel) dVar.f6645q.g.i(EpisodeInfoModel.class, dVar, new UncheckedRow(gVar, b2, b2.nativeGetRowPtr(b2.f6717o, r2)), dVar.M().a(EpisodeInfoModel.class));
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final int realmGet$season() {
        ((d) this.f6843p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6843p.f2682c).t(this.f6842o.f6833j);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$season_name() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6834k);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$series_name() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6835l);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$stream_icon() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6836m);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$title() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6837n);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final String realmGet$url() {
        ((d) this.f6843p.f2684e).c();
        return ((io.realm.internal.a0) this.f6843p.f2682c).u(this.f6842o.f6838o);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$category_name(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6829e);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6829e, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$container_extension(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6830f);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6830f, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$episode_num(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.g);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.g, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$id(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6831h);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6831h, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$info_model(EpisodeInfoModel episodeInfoModel) {
        c2.q qVar = this.f6843p;
        d dVar = (d) qVar.f2684e;
        if (qVar.f2680a) {
            return;
        }
        dVar.c();
        if (episodeInfoModel == 0) {
            ((io.realm.internal.a0) this.f6843p.f2682c).E(this.f6842o.f6832i);
            return;
        }
        c2.q qVar2 = this.f6843p;
        qVar2.getClass();
        if (!k0.isValid(episodeInfoModel) || !k0.isManaged(episodeInfoModel)) {
            throw new IllegalArgumentException("'value' is not a valid managed object.");
        }
        if (((d) ((io.realm.internal.y) episodeInfoModel).a().f2684e) != ((d) qVar2.f2684e)) {
            throw new IllegalArgumentException("'value' belongs to a different Realm.");
        }
        ((io.realm.internal.a0) this.f6843p.f2682c).v(this.f6842o.f6832i, ((io.realm.internal.a0) ((io.realm.internal.y) episodeInfoModel).a().f2682c).F());
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$season(int i10) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6843p.f2682c).x(this.f6842o.f6833j, i10);
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$season_name(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6834k);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6834k, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$series_name(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6835l);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6835l, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$stream_icon(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6836m);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6836m, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$title(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6837n);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6837n, str);
        }
    }

    @Override // app.shamel.tv.models.EpisodeModel
    public final void realmSet$url(String str) {
        c2.q qVar = this.f6843p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6843p.f2682c).j(this.f6842o.f6838o);
        } else {
            ((io.realm.internal.a0) this.f6843p.f2682c).d(this.f6842o.f6838o, str);
        }
    }

    public final String toString() {
        if (!k0.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder("EpisodeModel = proxy[{category_name:");
        sb2.append(realmGet$category_name() != null ? realmGet$category_name() : "null");
        sb2.append("},{container_extension:");
        sb2.append(realmGet$container_extension() != null ? realmGet$container_extension() : "null");
        sb2.append("},{episode_num:");
        sb2.append(realmGet$episode_num() != null ? realmGet$episode_num() : "null");
        sb2.append("},{id:");
        sb2.append(realmGet$id() != null ? realmGet$id() : "null");
        sb2.append("},{info_model:");
        sb2.append(realmGet$info_model() != null ? "EpisodeInfoModel" : "null");
        sb2.append("},{season:");
        sb2.append(realmGet$season());
        sb2.append("},{season_name:");
        sb2.append(realmGet$season_name() != null ? realmGet$season_name() : "null");
        sb2.append("},{series_name:");
        sb2.append(realmGet$series_name() != null ? realmGet$series_name() : "null");
        sb2.append("},{stream_icon:");
        sb2.append(realmGet$stream_icon() != null ? realmGet$stream_icon() : "null");
        sb2.append("},{title:");
        sb2.append(realmGet$title() != null ? realmGet$title() : "null");
        sb2.append("},{url:");
        return android.support.v4.media.d.r(sb2, realmGet$url() != null ? realmGet$url() : "null", "}]");
    }
}
