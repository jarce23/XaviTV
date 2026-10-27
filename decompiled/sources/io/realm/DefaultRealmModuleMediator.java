package io.realm;

import app.shamel.tv.models.EPGChannel;
import app.shamel.tv.models.EpisodeInfoModel;
import app.shamel.tv.models.EpisodeModel;
import app.shamel.tv.models.MovieModel;
import app.shamel.tv.models.SeriesModel;
import io.realm.annotations.RealmModule;
import io.realm.exceptions.RealmException;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@RealmModule
/* loaded from: classes.dex */
class DefaultRealmModuleMediator extends io.realm.internal.z {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f6620a;

    static {
        HashSet hashSet = new HashSet(5);
        hashSet.add(SeriesModel.class);
        hashSet.add(MovieModel.class);
        hashSet.add(EpisodeModel.class);
        hashSet.add(EpisodeInfoModel.class);
        hashSet.add(EPGChannel.class);
        f6620a = Collections.unmodifiableSet(hashSet);
    }

    @Override // io.realm.internal.z
    public final io.realm.internal.c a(Class cls, OsSchemaInfo osSchemaInfo) {
        if (cls == null) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
        if (cls.equals(SeriesModel.class)) {
            OsObjectSchemaInfo osObjectSchemaInfo = y0.f6895q;
            x0 x0Var = new x0(23, true);
            OsObjectSchemaInfo a10 = osSchemaInfo.a("SeriesModel");
            x0Var.f6873e = x0Var.a("cast", "cast", a10);
            x0Var.f6874f = x0Var.a("category_id", "category_id", a10);
            x0Var.g = x0Var.a("category_name", "category_name", a10);
            x0Var.f6875h = x0Var.a("director", "director", a10);
            x0Var.f6876i = x0Var.a("episode_pos", "episode_pos", a10);
            x0Var.f6877j = x0Var.a("genre", "genre", a10);
            x0Var.f6878k = x0Var.a("is_favorite", "is_favorite", a10);
            x0Var.f6879l = x0Var.a("is_recent", "is_recent", a10);
            x0Var.f6880m = x0Var.a("is_watched", "is_watched", a10);
            x0Var.f6881n = x0Var.a("last_modified", "last_modified", a10);
            x0Var.f6882o = x0Var.a("name", "name", a10);
            x0Var.f6883p = x0Var.a("num", "num", a10);
            x0Var.f6884q = x0Var.a("plot", "plot", a10);
            x0Var.f6885r = x0Var.a("rating", "rating", a10);
            x0Var.f6886s = x0Var.a("rating_5based", "rating_5based", a10);
            x0Var.f6887t = x0Var.a("releaseDate", "releaseDate", a10);
            x0Var.f6888u = x0Var.a("season_pos", "season_pos", a10);
            x0Var.f6889v = x0Var.a("series_id", "series_id", a10);
            x0Var.f6890w = x0Var.a("stream_icon", "stream_icon", a10);
            x0Var.f6891x = x0Var.a("stream_type", "stream_type", a10);
            x0Var.f6892y = x0Var.a("tmdb", "tmdb", a10);
            x0Var.f6893z = x0Var.a("url", "url", a10);
            x0Var.A = x0Var.a("youtube", "youtube", a10);
            return x0Var;
        }
        if (cls.equals(MovieModel.class)) {
            OsObjectSchemaInfo osObjectSchemaInfo2 = w0.f6869q;
            v0 v0Var = new v0(20, true);
            OsObjectSchemaInfo a11 = osSchemaInfo.a("MovieModel");
            v0Var.f6849e = v0Var.a("added", "added", a11);
            v0Var.f6850f = v0Var.a("category_id", "category_id", a11);
            v0Var.g = v0Var.a("category_name", "category_name", a11);
            v0Var.f6851h = v0Var.a("custom_sid", "custom_sid", a11);
            v0Var.f6852i = v0Var.a("extension", "extension", a11);
            v0Var.f6853j = v0Var.a("is_favorite", "is_favorite", a11);
            v0Var.f6854k = v0Var.a("is_locked", "is_locked", a11);
            v0Var.f6855l = v0Var.a("is_recent", "is_recent", a11);
            v0Var.f6856m = v0Var.a("name", "name", a11);
            v0Var.f6857n = v0Var.a("num", "num", a11);
            v0Var.f6858o = v0Var.a("pro", "pro", a11);
            v0Var.f6859p = v0Var.a("rating", "rating", a11);
            v0Var.f6860q = v0Var.a("recent_mil", "recent_mil", a11);
            v0Var.f6861r = v0Var.a("stream_icon", "stream_icon", a11);
            v0Var.f6862s = v0Var.a("stream_id", "stream_id", a11);
            v0Var.f6863t = v0Var.a("stream_type", "stream_type", a11);
            v0Var.f6864u = v0Var.a("time", "time", a11);
            v0Var.f6865v = v0Var.a("tmdb_id", "tmdb_id", a11);
            v0Var.f6866w = v0Var.a("type", "type", a11);
            v0Var.f6867x = v0Var.a("url", "url", a11);
            return v0Var;
        }
        if (cls.equals(EpisodeModel.class)) {
            OsObjectSchemaInfo osObjectSchemaInfo3 = u0.f6841q;
            t0 t0Var = new t0(11, true);
            OsObjectSchemaInfo a12 = osSchemaInfo.a("EpisodeModel");
            t0Var.f6829e = t0Var.a("category_name", "category_name", a12);
            t0Var.f6830f = t0Var.a("container_extension", "container_extension", a12);
            t0Var.g = t0Var.a("episode_num", "episode_num", a12);
            t0Var.f6831h = t0Var.a("id", "id", a12);
            t0Var.f6832i = t0Var.a("info_model", "info_model", a12);
            t0Var.f6833j = t0Var.a("season", "season", a12);
            t0Var.f6834k = t0Var.a("season_name", "season_name", a12);
            t0Var.f6835l = t0Var.a("series_name", "series_name", a12);
            t0Var.f6836m = t0Var.a("stream_icon", "stream_icon", a12);
            t0Var.f6837n = t0Var.a("title", "title", a12);
            t0Var.f6838o = t0Var.a("url", "url", a12);
            return t0Var;
        }
        if (cls.equals(EpisodeInfoModel.class)) {
            OsObjectSchemaInfo osObjectSchemaInfo4 = s0.f6826q;
            r0 r0Var = new r0(9, true);
            OsObjectSchemaInfo a13 = osSchemaInfo.a("EpisodeInfoModel");
            r0Var.f6812e = r0Var.a("bitrate", "bitrate", a13);
            r0Var.f6813f = r0Var.a("duration", "duration", a13);
            r0Var.g = r0Var.a("duration_secs", "duration_secs", a13);
            r0Var.f6814h = r0Var.a("movie_image", "movie_image", a13);
            r0Var.f6815i = r0Var.a("name", "name", a13);
            r0Var.f6816j = r0Var.a("plot", "plot", a13);
            r0Var.f6817k = r0Var.a("rating", "rating", a13);
            r0Var.f6818l = r0Var.a("releasedate", "releasedate", a13);
            r0Var.f6819m = r0Var.a("tmdb_id", "tmdb_id", a13);
            return r0Var;
        }
        if (!cls.equals(EPGChannel.class)) {
            throw io.realm.internal.z.d(cls);
        }
        OsObjectSchemaInfo osObjectSchemaInfo5 = q0.f6809q;
        p0 p0Var = new p0(21, true);
        OsObjectSchemaInfo a14 = osSchemaInfo.a("EPGChannel");
        p0Var.f6788e = p0Var.a("Id", "Id", a14);
        p0Var.f6789f = p0Var.a("added", "added", a14);
        p0Var.g = p0Var.a("category_id", "category_id", a14);
        p0Var.f6790h = p0Var.a("category_name", "category_name", a14);
        p0Var.f6791i = p0Var.a("cell", "cell", a14);
        p0Var.f6792j = p0Var.a("channelID", "channelID", a14);
        p0Var.f6793k = p0Var.a("custom_sid", "custom_sid", a14);
        p0Var.f6794l = p0Var.a("direct_source", "direct_source", a14);
        p0Var.f6795m = p0Var.a("is_favorite", "is_favorite", a14);
        p0Var.f6796n = p0Var.a("is_locked", "is_locked", a14);
        p0Var.f6797o = p0Var.a("is_recent", "is_recent", a14);
        p0Var.f6798p = p0Var.a("name", "name", a14);
        p0Var.f6799q = p0Var.a("num", "num", a14);
        p0Var.f6800r = p0Var.a("recent_pos", "recent_pos", a14);
        p0Var.f6801s = p0Var.a("selected", "selected", a14);
        p0Var.f6802t = p0Var.a("stream_icon", "stream_icon", a14);
        p0Var.f6803u = p0Var.a("stream_id", "stream_id", a14);
        p0Var.f6804v = p0Var.a("stream_type", "stream_type", a14);
        p0Var.f6805w = p0Var.a("tv_archive", "tv_archive", a14);
        p0Var.f6806x = p0Var.a("tv_archive_duration", "tv_archive_duration", a14);
        p0Var.f6807y = p0Var.a("url", "url", a14);
        return p0Var;
    }

    @Override // io.realm.internal.z
    public final Class b(String str) {
        if (str == null || str.isEmpty()) {
            throw new NullPointerException("A class extending RealmObject must be provided");
        }
        if (str.equals("SeriesModel")) {
            return SeriesModel.class;
        }
        if (str.equals("MovieModel")) {
            return MovieModel.class;
        }
        if (str.equals("EpisodeModel")) {
            return EpisodeModel.class;
        }
        if (str.equals("EpisodeInfoModel")) {
            return EpisodeInfoModel.class;
        }
        if (str.equals("EPGChannel")) {
            return EPGChannel.class;
        }
        throw new RealmException(android.support.v4.media.d.q("'", str, "' is not part of the schema for this Realm."));
    }

    @Override // io.realm.internal.z
    public final HashMap c() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(SeriesModel.class, y0.f6895q);
        hashMap.put(MovieModel.class, w0.f6869q);
        hashMap.put(EpisodeModel.class, u0.f6841q);
        hashMap.put(EpisodeInfoModel.class, s0.f6826q);
        hashMap.put(EPGChannel.class, q0.f6809q);
        return hashMap;
    }

    @Override // io.realm.internal.z
    public final Set e() {
        return f6620a;
    }

    @Override // io.realm.internal.z
    public final String g(Class cls) {
        if (cls.equals(SeriesModel.class)) {
            return "SeriesModel";
        }
        if (cls.equals(MovieModel.class)) {
            return "MovieModel";
        }
        if (cls.equals(EpisodeModel.class)) {
            return "EpisodeModel";
        }
        if (cls.equals(EpisodeInfoModel.class)) {
            return "EpisodeInfoModel";
        }
        if (cls.equals(EPGChannel.class)) {
            return "EPGChannel";
        }
        throw io.realm.internal.z.d(cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.realm.internal.z
    public final void h(u uVar, Collection collection) {
        p0 p0Var;
        long j10;
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        long j18;
        long j19;
        long j20;
        long j21;
        long j22;
        t0 t0Var;
        long j23;
        long j24;
        long j25;
        long j26;
        long j27;
        long j28;
        long j29;
        long j30;
        long j31;
        v0 v0Var;
        long j32;
        long j33;
        long j34;
        long j35;
        long j36;
        long j37;
        long j38;
        long j39;
        long j40;
        long j41;
        long j42;
        long j43;
        x0 x0Var;
        long j44;
        long j45;
        long j46;
        long j47;
        long j48;
        long j49;
        long j50;
        long j51;
        long j52;
        long j53;
        long j54;
        long j55;
        long j56;
        long j57;
        long j58;
        f0 f0Var = uVar.f6645q;
        k kVar = uVar.f6840y;
        Iterator it = collection.iterator();
        HashMap hashMap = new HashMap(collection.size());
        if (it.hasNext()) {
            i0 i0Var = (i0) it.next();
            Class<?> superclass = i0Var instanceof io.realm.internal.y ? i0Var.getClass().getSuperclass() : i0Var.getClass();
            if (superclass.equals(SeriesModel.class)) {
                SeriesModel seriesModel = (SeriesModel) i0Var;
                OsObjectSchemaInfo osObjectSchemaInfo = y0.f6895q;
                if ((seriesModel instanceof io.realm.internal.y) && !k0.isFrozen(seriesModel)) {
                    io.realm.internal.y yVar = (io.realm.internal.y) seriesModel;
                    if (((d) yVar.a().f2684e) != null && ((d) yVar.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                        ((io.realm.internal.a0) yVar.a().f2682c).F();
                    }
                }
                Table b2 = kVar.b(SeriesModel.class);
                long j59 = b2.f6717o;
                x0 x0Var2 = (x0) kVar.a(SeriesModel.class);
                long createRow = OsObject.createRow(b2);
                hashMap.put(seriesModel, Long.valueOf(createRow));
                String realmGet$cast = seriesModel.realmGet$cast();
                if (realmGet$cast != null) {
                    x0Var = x0Var2;
                    j44 = j59;
                    Table.nativeSetString(j44, x0Var2.f6873e, createRow, realmGet$cast, false);
                } else {
                    x0Var = x0Var2;
                    j44 = j59;
                    Table.nativeSetNull(j44, x0Var.f6873e, createRow, false);
                }
                String realmGet$category_id = seriesModel.realmGet$category_id();
                if (realmGet$category_id != null) {
                    j45 = j44;
                    Table.nativeSetString(j45, x0Var.f6874f, createRow, realmGet$category_id, false);
                } else {
                    j45 = j44;
                    Table.nativeSetNull(j45, x0Var.f6874f, createRow, false);
                }
                String realmGet$category_name = seriesModel.realmGet$category_name();
                if (realmGet$category_name != null) {
                    j46 = j45;
                    Table.nativeSetString(j46, x0Var.g, createRow, realmGet$category_name, false);
                } else {
                    j46 = j45;
                    Table.nativeSetNull(j46, x0Var.g, createRow, false);
                }
                String realmGet$director = seriesModel.realmGet$director();
                if (realmGet$director != null) {
                    long j60 = j46;
                    Table.nativeSetString(j60, x0Var.f6875h, createRow, realmGet$director, false);
                    j47 = j60;
                } else {
                    j47 = j46;
                    Table.nativeSetNull(j47, x0Var.f6875h, createRow, false);
                }
                long j61 = j47;
                Table.nativeSetLong(j61, x0Var.f6876i, createRow, seriesModel.realmGet$episode_pos(), false);
                String realmGet$genre = seriesModel.realmGet$genre();
                if (realmGet$genre != null) {
                    Table.nativeSetString(j61, x0Var.f6877j, createRow, realmGet$genre, false);
                    j48 = j61;
                } else {
                    j48 = j61;
                    Table.nativeSetNull(j48, x0Var.f6877j, createRow, false);
                }
                long j62 = j48;
                Table.nativeSetBoolean(j62, x0Var.f6878k, createRow, seriesModel.realmGet$is_favorite(), false);
                Table.nativeSetBoolean(j62, x0Var.f6879l, createRow, seriesModel.realmGet$is_recent(), false);
                Table.nativeSetBoolean(j62, x0Var.f6880m, createRow, seriesModel.realmGet$is_watched(), false);
                String realmGet$last_modified = seriesModel.realmGet$last_modified();
                if (realmGet$last_modified != null) {
                    j49 = j62;
                    Table.nativeSetString(j49, x0Var.f6881n, createRow, realmGet$last_modified, false);
                } else {
                    j49 = j62;
                    Table.nativeSetNull(j49, x0Var.f6881n, createRow, false);
                }
                String realmGet$name = seriesModel.realmGet$name();
                if (realmGet$name != null) {
                    long j63 = j49;
                    Table.nativeSetString(j63, x0Var.f6882o, createRow, realmGet$name, false);
                    j50 = j63;
                } else {
                    j50 = j49;
                    Table.nativeSetNull(j50, x0Var.f6882o, createRow, false);
                }
                long j64 = j50;
                Table.nativeSetLong(j64, x0Var.f6883p, createRow, seriesModel.realmGet$num(), false);
                String realmGet$plot = seriesModel.realmGet$plot();
                if (realmGet$plot != null) {
                    j51 = j64;
                    Table.nativeSetString(j51, x0Var.f6884q, createRow, realmGet$plot, false);
                } else {
                    j51 = j64;
                    Table.nativeSetNull(j51, x0Var.f6884q, createRow, false);
                }
                String realmGet$rating = seriesModel.realmGet$rating();
                if (realmGet$rating != null) {
                    long j65 = j51;
                    Table.nativeSetString(j65, x0Var.f6885r, createRow, realmGet$rating, false);
                    j52 = j65;
                } else {
                    j52 = j51;
                    Table.nativeSetNull(j52, x0Var.f6885r, createRow, false);
                }
                long j66 = j52;
                Table.nativeSetFloat(j66, x0Var.f6886s, createRow, seriesModel.realmGet$rating_5based(), false);
                String realmGet$releaseDate = seriesModel.realmGet$releaseDate();
                if (realmGet$releaseDate != null) {
                    Table.nativeSetString(j66, x0Var.f6887t, createRow, realmGet$releaseDate, false);
                    j53 = j66;
                } else {
                    j53 = j66;
                    Table.nativeSetNull(j53, x0Var.f6887t, createRow, false);
                }
                long j67 = j53;
                Table.nativeSetLong(j67, x0Var.f6888u, createRow, seriesModel.realmGet$season_pos(), false);
                String realmGet$series_id = seriesModel.realmGet$series_id();
                if (realmGet$series_id != null) {
                    j54 = j67;
                    Table.nativeSetString(j54, x0Var.f6889v, createRow, realmGet$series_id, false);
                } else {
                    j54 = j67;
                    Table.nativeSetNull(j54, x0Var.f6889v, createRow, false);
                }
                String realmGet$stream_icon = seriesModel.realmGet$stream_icon();
                if (realmGet$stream_icon != null) {
                    j55 = j54;
                    Table.nativeSetString(j55, x0Var.f6890w, createRow, realmGet$stream_icon, false);
                } else {
                    j55 = j54;
                    Table.nativeSetNull(j55, x0Var.f6890w, createRow, false);
                }
                String realmGet$stream_type = seriesModel.realmGet$stream_type();
                if (realmGet$stream_type != null) {
                    j56 = j55;
                    Table.nativeSetString(j56, x0Var.f6891x, createRow, realmGet$stream_type, false);
                } else {
                    j56 = j55;
                    Table.nativeSetNull(j56, x0Var.f6891x, createRow, false);
                }
                String realmGet$tmdb = seriesModel.realmGet$tmdb();
                if (realmGet$tmdb != null) {
                    j57 = j56;
                    Table.nativeSetString(j57, x0Var.f6892y, createRow, realmGet$tmdb, false);
                } else {
                    j57 = j56;
                    Table.nativeSetNull(j57, x0Var.f6892y, createRow, false);
                }
                String realmGet$url = seriesModel.realmGet$url();
                if (realmGet$url != null) {
                    j58 = j57;
                    Table.nativeSetString(j58, x0Var.f6893z, createRow, realmGet$url, false);
                } else {
                    j58 = j57;
                    Table.nativeSetNull(j58, x0Var.f6893z, createRow, false);
                }
                String realmGet$youtube = seriesModel.realmGet$youtube();
                if (realmGet$youtube != null) {
                    Table.nativeSetString(j58, x0Var.A, createRow, realmGet$youtube, false);
                } else {
                    Table.nativeSetNull(j58, x0Var.A, createRow, false);
                }
            } else if (superclass.equals(MovieModel.class)) {
                MovieModel movieModel = (MovieModel) i0Var;
                OsObjectSchemaInfo osObjectSchemaInfo2 = w0.f6869q;
                if ((movieModel instanceof io.realm.internal.y) && !k0.isFrozen(movieModel)) {
                    io.realm.internal.y yVar2 = (io.realm.internal.y) movieModel;
                    if (((d) yVar2.a().f2684e) != null && ((d) yVar2.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                        ((io.realm.internal.a0) yVar2.a().f2682c).F();
                    }
                }
                Table b10 = kVar.b(MovieModel.class);
                long j68 = b10.f6717o;
                v0 v0Var2 = (v0) kVar.a(MovieModel.class);
                long createRow2 = OsObject.createRow(b10);
                hashMap.put(movieModel, Long.valueOf(createRow2));
                String realmGet$added = movieModel.realmGet$added();
                if (realmGet$added != null) {
                    v0Var = v0Var2;
                    j32 = j68;
                    Table.nativeSetString(j32, v0Var2.f6849e, createRow2, realmGet$added, false);
                } else {
                    v0Var = v0Var2;
                    j32 = j68;
                    Table.nativeSetNull(j32, v0Var.f6849e, createRow2, false);
                }
                String realmGet$category_id2 = movieModel.realmGet$category_id();
                if (realmGet$category_id2 != null) {
                    j33 = j32;
                    Table.nativeSetString(j33, v0Var.f6850f, createRow2, realmGet$category_id2, false);
                } else {
                    j33 = j32;
                    Table.nativeSetNull(j33, v0Var.f6850f, createRow2, false);
                }
                String realmGet$category_name2 = movieModel.realmGet$category_name();
                if (realmGet$category_name2 != null) {
                    j34 = j33;
                    Table.nativeSetString(j34, v0Var.g, createRow2, realmGet$category_name2, false);
                } else {
                    j34 = j33;
                    Table.nativeSetNull(j34, v0Var.g, createRow2, false);
                }
                String realmGet$custom_sid = movieModel.realmGet$custom_sid();
                if (realmGet$custom_sid != null) {
                    j35 = j34;
                    Table.nativeSetString(j35, v0Var.f6851h, createRow2, realmGet$custom_sid, false);
                } else {
                    j35 = j34;
                    Table.nativeSetNull(j35, v0Var.f6851h, createRow2, false);
                }
                String realmGet$extension = movieModel.realmGet$extension();
                if (realmGet$extension != null) {
                    long j69 = j35;
                    Table.nativeSetString(j69, v0Var.f6852i, createRow2, realmGet$extension, false);
                    j36 = j69;
                } else {
                    j36 = j35;
                    Table.nativeSetNull(j36, v0Var.f6852i, createRow2, false);
                }
                long j70 = j36;
                Table.nativeSetBoolean(j70, v0Var.f6853j, createRow2, movieModel.realmGet$is_favorite(), false);
                Table.nativeSetBoolean(j70, v0Var.f6854k, createRow2, movieModel.realmGet$is_locked(), false);
                Table.nativeSetBoolean(j70, v0Var.f6855l, createRow2, movieModel.realmGet$is_recent(), false);
                String realmGet$name2 = movieModel.realmGet$name();
                if (realmGet$name2 != null) {
                    Table.nativeSetString(j70, v0Var.f6856m, createRow2, realmGet$name2, false);
                    j37 = j70;
                } else {
                    j37 = j70;
                    Table.nativeSetNull(j37, v0Var.f6856m, createRow2, false);
                }
                long j71 = j37;
                Table.nativeSetLong(j71, v0Var.f6857n, createRow2, movieModel.realmGet$num(), false);
                Table.nativeSetLong(j71, v0Var.f6858o, createRow2, movieModel.realmGet$pro(), false);
                String realmGet$rating2 = movieModel.realmGet$rating();
                if (realmGet$rating2 != null) {
                    Table.nativeSetString(j71, v0Var.f6859p, createRow2, realmGet$rating2, false);
                    j38 = j71;
                } else {
                    j38 = j71;
                    Table.nativeSetNull(j38, v0Var.f6859p, createRow2, false);
                }
                long j72 = j38;
                Table.nativeSetLong(j72, v0Var.f6860q, createRow2, movieModel.realmGet$recent_mil(), false);
                String realmGet$stream_icon2 = movieModel.realmGet$stream_icon();
                if (realmGet$stream_icon2 != null) {
                    j39 = j72;
                    Table.nativeSetString(j39, v0Var.f6861r, createRow2, realmGet$stream_icon2, false);
                } else {
                    j39 = j72;
                    Table.nativeSetNull(j39, v0Var.f6861r, createRow2, false);
                }
                String realmGet$stream_id = movieModel.realmGet$stream_id();
                if (realmGet$stream_id != null) {
                    j40 = j39;
                    Table.nativeSetString(j40, v0Var.f6862s, createRow2, realmGet$stream_id, false);
                } else {
                    j40 = j39;
                    Table.nativeSetNull(j40, v0Var.f6862s, createRow2, false);
                }
                String realmGet$stream_type2 = movieModel.realmGet$stream_type();
                if (realmGet$stream_type2 != null) {
                    long j73 = j40;
                    Table.nativeSetString(j73, v0Var.f6863t, createRow2, realmGet$stream_type2, false);
                    j41 = j73;
                } else {
                    j41 = j40;
                    Table.nativeSetNull(j41, v0Var.f6863t, createRow2, false);
                }
                long j74 = j41;
                Table.nativeSetLong(j74, v0Var.f6864u, createRow2, movieModel.realmGet$time(), false);
                String realmGet$tmdb_id = movieModel.realmGet$tmdb_id();
                if (realmGet$tmdb_id != null) {
                    j42 = j74;
                    Table.nativeSetString(j42, v0Var.f6865v, createRow2, realmGet$tmdb_id, false);
                } else {
                    j42 = j74;
                    Table.nativeSetNull(j42, v0Var.f6865v, createRow2, false);
                }
                String realmGet$type = movieModel.realmGet$type();
                if (realmGet$type != null) {
                    j43 = j42;
                    Table.nativeSetString(j43, v0Var.f6866w, createRow2, realmGet$type, false);
                } else {
                    j43 = j42;
                    Table.nativeSetNull(j43, v0Var.f6866w, createRow2, false);
                }
                String realmGet$url2 = movieModel.realmGet$url();
                if (realmGet$url2 != null) {
                    Table.nativeSetString(j43, v0Var.f6867x, createRow2, realmGet$url2, false);
                } else {
                    Table.nativeSetNull(j43, v0Var.f6867x, createRow2, false);
                }
            } else if (superclass.equals(EpisodeModel.class)) {
                EpisodeModel episodeModel = (EpisodeModel) i0Var;
                OsObjectSchemaInfo osObjectSchemaInfo3 = u0.f6841q;
                if ((episodeModel instanceof io.realm.internal.y) && !k0.isFrozen(episodeModel)) {
                    io.realm.internal.y yVar3 = (io.realm.internal.y) episodeModel;
                    if (((d) yVar3.a().f2684e) != null && ((d) yVar3.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                        ((io.realm.internal.a0) yVar3.a().f2682c).F();
                    }
                }
                Table b11 = kVar.b(EpisodeModel.class);
                long j75 = b11.f6717o;
                t0 t0Var2 = (t0) kVar.a(EpisodeModel.class);
                long createRow3 = OsObject.createRow(b11);
                hashMap.put(episodeModel, Long.valueOf(createRow3));
                String realmGet$category_name3 = episodeModel.realmGet$category_name();
                if (realmGet$category_name3 != null) {
                    t0Var = t0Var2;
                    j23 = j75;
                    Table.nativeSetString(j23, t0Var2.f6829e, createRow3, realmGet$category_name3, false);
                } else {
                    t0Var = t0Var2;
                    j23 = j75;
                    Table.nativeSetNull(j23, t0Var.f6829e, createRow3, false);
                }
                String realmGet$container_extension = episodeModel.realmGet$container_extension();
                if (realmGet$container_extension != null) {
                    j24 = j23;
                    Table.nativeSetString(j24, t0Var.f6830f, createRow3, realmGet$container_extension, false);
                } else {
                    j24 = j23;
                    Table.nativeSetNull(j24, t0Var.f6830f, createRow3, false);
                }
                String realmGet$episode_num = episodeModel.realmGet$episode_num();
                if (realmGet$episode_num != null) {
                    j25 = j24;
                    Table.nativeSetString(j25, t0Var.g, createRow3, realmGet$episode_num, false);
                } else {
                    j25 = j24;
                    Table.nativeSetNull(j25, t0Var.g, createRow3, false);
                }
                String realmGet$id = episodeModel.realmGet$id();
                if (realmGet$id != null) {
                    j26 = j25;
                    Table.nativeSetString(j26, t0Var.f6831h, createRow3, realmGet$id, false);
                } else {
                    j26 = j25;
                    Table.nativeSetNull(j26, t0Var.f6831h, createRow3, false);
                }
                EpisodeInfoModel realmGet$info_model = episodeModel.realmGet$info_model();
                if (realmGet$info_model != null) {
                    Long l10 = (Long) hashMap.get(realmGet$info_model);
                    if (l10 == null) {
                        l10 = Long.valueOf(s0.c(uVar, realmGet$info_model, hashMap));
                    }
                    long j76 = j26;
                    Table.nativeSetLink(j76, t0Var.f6832i, createRow3, l10.longValue(), false);
                    j27 = j76;
                } else {
                    j27 = j26;
                    Table.nativeNullifyLink(j27, t0Var.f6832i, createRow3);
                }
                long j77 = j27;
                Table.nativeSetLong(j77, t0Var.f6833j, createRow3, episodeModel.realmGet$season(), false);
                String realmGet$season_name = episodeModel.realmGet$season_name();
                if (realmGet$season_name != null) {
                    j28 = j77;
                    Table.nativeSetString(j28, t0Var.f6834k, createRow3, realmGet$season_name, false);
                } else {
                    j28 = j77;
                    Table.nativeSetNull(j28, t0Var.f6834k, createRow3, false);
                }
                String realmGet$series_name = episodeModel.realmGet$series_name();
                if (realmGet$series_name != null) {
                    j29 = j28;
                    Table.nativeSetString(j29, t0Var.f6835l, createRow3, realmGet$series_name, false);
                } else {
                    j29 = j28;
                    Table.nativeSetNull(j29, t0Var.f6835l, createRow3, false);
                }
                String realmGet$stream_icon3 = episodeModel.realmGet$stream_icon();
                if (realmGet$stream_icon3 != null) {
                    j30 = j29;
                    Table.nativeSetString(j30, t0Var.f6836m, createRow3, realmGet$stream_icon3, false);
                } else {
                    j30 = j29;
                    Table.nativeSetNull(j30, t0Var.f6836m, createRow3, false);
                }
                String realmGet$title = episodeModel.realmGet$title();
                if (realmGet$title != null) {
                    j31 = j30;
                    Table.nativeSetString(j31, t0Var.f6837n, createRow3, realmGet$title, false);
                } else {
                    j31 = j30;
                    Table.nativeSetNull(j31, t0Var.f6837n, createRow3, false);
                }
                String realmGet$url3 = episodeModel.realmGet$url();
                if (realmGet$url3 != null) {
                    Table.nativeSetString(j31, t0Var.f6838o, createRow3, realmGet$url3, false);
                } else {
                    Table.nativeSetNull(j31, t0Var.f6838o, createRow3, false);
                }
            } else if (superclass.equals(EpisodeInfoModel.class)) {
                s0.c(uVar, (EpisodeInfoModel) i0Var, hashMap);
            } else {
                if (!superclass.equals(EPGChannel.class)) {
                    throw io.realm.internal.z.d(superclass);
                }
                EPGChannel ePGChannel = (EPGChannel) i0Var;
                OsObjectSchemaInfo osObjectSchemaInfo4 = q0.f6809q;
                if ((ePGChannel instanceof io.realm.internal.y) && !k0.isFrozen(ePGChannel)) {
                    io.realm.internal.y yVar4 = (io.realm.internal.y) ePGChannel;
                    if (((d) yVar4.a().f2684e) != null && ((d) yVar4.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                        ((io.realm.internal.a0) yVar4.a().f2682c).F();
                    }
                }
                Table b12 = kVar.b(EPGChannel.class);
                long j78 = b12.f6717o;
                p0 p0Var2 = (p0) kVar.a(EPGChannel.class);
                long createRow4 = OsObject.createRow(b12);
                hashMap.put(ePGChannel, Long.valueOf(createRow4));
                String realmGet$Id = ePGChannel.realmGet$Id();
                if (realmGet$Id != null) {
                    p0Var = p0Var2;
                    j10 = j78;
                    Table.nativeSetString(j10, p0Var2.f6788e, createRow4, realmGet$Id, false);
                } else {
                    p0Var = p0Var2;
                    j10 = j78;
                    Table.nativeSetNull(j10, p0Var.f6788e, createRow4, false);
                }
                String realmGet$added2 = ePGChannel.realmGet$added();
                if (realmGet$added2 != null) {
                    j11 = j10;
                    Table.nativeSetString(j11, p0Var.f6789f, createRow4, realmGet$added2, false);
                } else {
                    j11 = j10;
                    Table.nativeSetNull(j11, p0Var.f6789f, createRow4, false);
                }
                String realmGet$category_id3 = ePGChannel.realmGet$category_id();
                if (realmGet$category_id3 != null) {
                    j12 = j11;
                    Table.nativeSetString(j12, p0Var.g, createRow4, realmGet$category_id3, false);
                } else {
                    j12 = j11;
                    Table.nativeSetNull(j12, p0Var.g, createRow4, false);
                }
                String realmGet$category_name4 = ePGChannel.realmGet$category_name();
                if (realmGet$category_name4 != null) {
                    long j79 = j12;
                    Table.nativeSetString(j79, p0Var.f6790h, createRow4, realmGet$category_name4, false);
                    j13 = j79;
                } else {
                    j13 = j12;
                    Table.nativeSetNull(j13, p0Var.f6790h, createRow4, false);
                }
                long j80 = j13;
                Table.nativeSetLong(j80, p0Var.f6791i, createRow4, ePGChannel.realmGet$cell(), false);
                Table.nativeSetLong(j80, p0Var.f6792j, createRow4, ePGChannel.realmGet$channelID(), false);
                String realmGet$custom_sid2 = ePGChannel.realmGet$custom_sid();
                if (realmGet$custom_sid2 != null) {
                    j14 = j80;
                    Table.nativeSetString(j14, p0Var.f6793k, createRow4, realmGet$custom_sid2, false);
                } else {
                    j14 = j80;
                    Table.nativeSetNull(j14, p0Var.f6793k, createRow4, false);
                }
                String realmGet$direct_source = ePGChannel.realmGet$direct_source();
                if (realmGet$direct_source != null) {
                    long j81 = j14;
                    Table.nativeSetString(j81, p0Var.f6794l, createRow4, realmGet$direct_source, false);
                    j15 = j81;
                } else {
                    j15 = j14;
                    Table.nativeSetNull(j15, p0Var.f6794l, createRow4, false);
                }
                long j82 = j15;
                Table.nativeSetBoolean(j82, p0Var.f6795m, createRow4, ePGChannel.realmGet$is_favorite(), false);
                Table.nativeSetBoolean(j82, p0Var.f6796n, createRow4, ePGChannel.realmGet$is_locked(), false);
                Table.nativeSetBoolean(j82, p0Var.f6797o, createRow4, ePGChannel.realmGet$is_recent(), false);
                String realmGet$name3 = ePGChannel.realmGet$name();
                if (realmGet$name3 != null) {
                    j16 = j82;
                    Table.nativeSetString(j16, p0Var.f6798p, createRow4, realmGet$name3, false);
                } else {
                    j16 = j82;
                    Table.nativeSetNull(j16, p0Var.f6798p, createRow4, false);
                }
                String realmGet$num = ePGChannel.realmGet$num();
                if (realmGet$num != null) {
                    long j83 = j16;
                    Table.nativeSetString(j83, p0Var.f6799q, createRow4, realmGet$num, false);
                    j17 = j83;
                } else {
                    j17 = j16;
                    Table.nativeSetNull(j17, p0Var.f6799q, createRow4, false);
                }
                long j84 = j17;
                Table.nativeSetLong(j84, p0Var.f6800r, createRow4, ePGChannel.realmGet$recent_pos(), false);
                Table.nativeSetBoolean(j84, p0Var.f6801s, createRow4, ePGChannel.realmGet$selected(), false);
                String realmGet$stream_icon4 = ePGChannel.realmGet$stream_icon();
                if (realmGet$stream_icon4 != null) {
                    j18 = j84;
                    Table.nativeSetString(j18, p0Var.f6802t, createRow4, realmGet$stream_icon4, false);
                } else {
                    j18 = j84;
                    Table.nativeSetNull(j18, p0Var.f6802t, createRow4, false);
                }
                String realmGet$stream_id2 = ePGChannel.realmGet$stream_id();
                if (realmGet$stream_id2 != null) {
                    j19 = j18;
                    Table.nativeSetString(j19, p0Var.f6803u, createRow4, realmGet$stream_id2, false);
                } else {
                    j19 = j18;
                    Table.nativeSetNull(j19, p0Var.f6803u, createRow4, false);
                }
                String realmGet$stream_type3 = ePGChannel.realmGet$stream_type();
                if (realmGet$stream_type3 != null) {
                    j20 = j19;
                    Table.nativeSetString(j20, p0Var.f6804v, createRow4, realmGet$stream_type3, false);
                } else {
                    j20 = j19;
                    Table.nativeSetNull(j20, p0Var.f6804v, createRow4, false);
                }
                String realmGet$tv_archive = ePGChannel.realmGet$tv_archive();
                if (realmGet$tv_archive != null) {
                    j21 = j20;
                    Table.nativeSetString(j21, p0Var.f6805w, createRow4, realmGet$tv_archive, false);
                } else {
                    j21 = j20;
                    Table.nativeSetNull(j21, p0Var.f6805w, createRow4, false);
                }
                String realmGet$tv_archive_duration = ePGChannel.realmGet$tv_archive_duration();
                if (realmGet$tv_archive_duration != null) {
                    j22 = j21;
                    Table.nativeSetString(j22, p0Var.f6806x, createRow4, realmGet$tv_archive_duration, false);
                } else {
                    j22 = j21;
                    Table.nativeSetNull(j22, p0Var.f6806x, createRow4, false);
                }
                String realmGet$url4 = ePGChannel.realmGet$url();
                if (realmGet$url4 != null) {
                    Table.nativeSetString(j22, p0Var.f6807y, createRow4, realmGet$url4, false);
                } else {
                    Table.nativeSetNull(j22, p0Var.f6807y, createRow4, false);
                }
            }
            if (it.hasNext()) {
                if (superclass.equals(SeriesModel.class)) {
                    OsObjectSchemaInfo osObjectSchemaInfo5 = y0.f6895q;
                    Table b13 = kVar.b(SeriesModel.class);
                    long j85 = b13.f6717o;
                    x0 x0Var3 = (x0) kVar.a(SeriesModel.class);
                    while (it.hasNext()) {
                        SeriesModel seriesModel2 = (SeriesModel) it.next();
                        if (!hashMap.containsKey(seriesModel2)) {
                            if ((seriesModel2 instanceof io.realm.internal.y) && !k0.isFrozen(seriesModel2)) {
                                io.realm.internal.y yVar5 = (io.realm.internal.y) seriesModel2;
                                if (((d) yVar5.a().f2684e) != null && ((d) yVar5.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                                    hashMap.put(seriesModel2, Long.valueOf(((io.realm.internal.a0) yVar5.a().f2682c).F()));
                                }
                            }
                            long createRow5 = OsObject.createRow(b13);
                            hashMap.put(seriesModel2, Long.valueOf(createRow5));
                            String realmGet$cast2 = seriesModel2.realmGet$cast();
                            if (realmGet$cast2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6873e, createRow5, realmGet$cast2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6873e, createRow5, false);
                            }
                            String realmGet$category_id4 = seriesModel2.realmGet$category_id();
                            if (realmGet$category_id4 != null) {
                                Table.nativeSetString(j85, x0Var3.f6874f, createRow5, realmGet$category_id4, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6874f, createRow5, false);
                            }
                            String realmGet$category_name5 = seriesModel2.realmGet$category_name();
                            if (realmGet$category_name5 != null) {
                                Table.nativeSetString(j85, x0Var3.g, createRow5, realmGet$category_name5, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.g, createRow5, false);
                            }
                            String realmGet$director2 = seriesModel2.realmGet$director();
                            if (realmGet$director2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6875h, createRow5, realmGet$director2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6875h, createRow5, false);
                            }
                            Table.nativeSetLong(j85, x0Var3.f6876i, createRow5, seriesModel2.realmGet$episode_pos(), false);
                            String realmGet$genre2 = seriesModel2.realmGet$genre();
                            if (realmGet$genre2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6877j, createRow5, realmGet$genre2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6877j, createRow5, false);
                            }
                            Table.nativeSetBoolean(j85, x0Var3.f6878k, createRow5, seriesModel2.realmGet$is_favorite(), false);
                            Table.nativeSetBoolean(j85, x0Var3.f6879l, createRow5, seriesModel2.realmGet$is_recent(), false);
                            Table.nativeSetBoolean(j85, x0Var3.f6880m, createRow5, seriesModel2.realmGet$is_watched(), false);
                            String realmGet$last_modified2 = seriesModel2.realmGet$last_modified();
                            if (realmGet$last_modified2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6881n, createRow5, realmGet$last_modified2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6881n, createRow5, false);
                            }
                            String realmGet$name4 = seriesModel2.realmGet$name();
                            if (realmGet$name4 != null) {
                                Table.nativeSetString(j85, x0Var3.f6882o, createRow5, realmGet$name4, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6882o, createRow5, false);
                            }
                            Table.nativeSetLong(j85, x0Var3.f6883p, createRow5, seriesModel2.realmGet$num(), false);
                            String realmGet$plot2 = seriesModel2.realmGet$plot();
                            if (realmGet$plot2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6884q, createRow5, realmGet$plot2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6884q, createRow5, false);
                            }
                            String realmGet$rating3 = seriesModel2.realmGet$rating();
                            if (realmGet$rating3 != null) {
                                Table.nativeSetString(j85, x0Var3.f6885r, createRow5, realmGet$rating3, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6885r, createRow5, false);
                            }
                            Table.nativeSetFloat(j85, x0Var3.f6886s, createRow5, seriesModel2.realmGet$rating_5based(), false);
                            String realmGet$releaseDate2 = seriesModel2.realmGet$releaseDate();
                            if (realmGet$releaseDate2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6887t, createRow5, realmGet$releaseDate2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6887t, createRow5, false);
                            }
                            Table.nativeSetLong(j85, x0Var3.f6888u, createRow5, seriesModel2.realmGet$season_pos(), false);
                            String realmGet$series_id2 = seriesModel2.realmGet$series_id();
                            if (realmGet$series_id2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6889v, createRow5, realmGet$series_id2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6889v, createRow5, false);
                            }
                            String realmGet$stream_icon5 = seriesModel2.realmGet$stream_icon();
                            if (realmGet$stream_icon5 != null) {
                                Table.nativeSetString(j85, x0Var3.f6890w, createRow5, realmGet$stream_icon5, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6890w, createRow5, false);
                            }
                            String realmGet$stream_type4 = seriesModel2.realmGet$stream_type();
                            if (realmGet$stream_type4 != null) {
                                Table.nativeSetString(j85, x0Var3.f6891x, createRow5, realmGet$stream_type4, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6891x, createRow5, false);
                            }
                            String realmGet$tmdb2 = seriesModel2.realmGet$tmdb();
                            if (realmGet$tmdb2 != null) {
                                Table.nativeSetString(j85, x0Var3.f6892y, createRow5, realmGet$tmdb2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6892y, createRow5, false);
                            }
                            String realmGet$url5 = seriesModel2.realmGet$url();
                            if (realmGet$url5 != null) {
                                Table.nativeSetString(j85, x0Var3.f6893z, createRow5, realmGet$url5, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.f6893z, createRow5, false);
                            }
                            String realmGet$youtube2 = seriesModel2.realmGet$youtube();
                            if (realmGet$youtube2 != null) {
                                Table.nativeSetString(j85, x0Var3.A, createRow5, realmGet$youtube2, false);
                            } else {
                                Table.nativeSetNull(j85, x0Var3.A, createRow5, false);
                            }
                        }
                    }
                    return;
                }
                if (!superclass.equals(MovieModel.class)) {
                    if (!superclass.equals(EpisodeModel.class)) {
                        if (superclass.equals(EpisodeInfoModel.class)) {
                            s0.d(uVar, it, hashMap);
                            return;
                        } else {
                            if (!superclass.equals(EPGChannel.class)) {
                                throw io.realm.internal.z.d(superclass);
                            }
                            q0.c(uVar, it, hashMap);
                            return;
                        }
                    }
                    OsObjectSchemaInfo osObjectSchemaInfo6 = u0.f6841q;
                    Table b14 = kVar.b(EpisodeModel.class);
                    long j86 = b14.f6717o;
                    t0 t0Var3 = (t0) kVar.a(EpisodeModel.class);
                    while (it.hasNext()) {
                        EpisodeModel episodeModel2 = (EpisodeModel) it.next();
                        if (!hashMap.containsKey(episodeModel2)) {
                            if ((episodeModel2 instanceof io.realm.internal.y) && !k0.isFrozen(episodeModel2)) {
                                io.realm.internal.y yVar6 = (io.realm.internal.y) episodeModel2;
                                if (((d) yVar6.a().f2684e) != null && ((d) yVar6.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                                    hashMap.put(episodeModel2, Long.valueOf(((io.realm.internal.a0) yVar6.a().f2682c).F()));
                                }
                            }
                            long createRow6 = OsObject.createRow(b14);
                            hashMap.put(episodeModel2, Long.valueOf(createRow6));
                            String realmGet$category_name6 = episodeModel2.realmGet$category_name();
                            if (realmGet$category_name6 != null) {
                                Table.nativeSetString(j86, t0Var3.f6829e, createRow6, realmGet$category_name6, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6829e, createRow6, false);
                            }
                            String realmGet$container_extension2 = episodeModel2.realmGet$container_extension();
                            if (realmGet$container_extension2 != null) {
                                Table.nativeSetString(j86, t0Var3.f6830f, createRow6, realmGet$container_extension2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6830f, createRow6, false);
                            }
                            String realmGet$episode_num2 = episodeModel2.realmGet$episode_num();
                            if (realmGet$episode_num2 != null) {
                                Table.nativeSetString(j86, t0Var3.g, createRow6, realmGet$episode_num2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.g, createRow6, false);
                            }
                            String realmGet$id2 = episodeModel2.realmGet$id();
                            if (realmGet$id2 != null) {
                                Table.nativeSetString(j86, t0Var3.f6831h, createRow6, realmGet$id2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6831h, createRow6, false);
                            }
                            EpisodeInfoModel realmGet$info_model2 = episodeModel2.realmGet$info_model();
                            if (realmGet$info_model2 != null) {
                                Long l11 = (Long) hashMap.get(realmGet$info_model2);
                                if (l11 == null) {
                                    l11 = Long.valueOf(s0.c(uVar, realmGet$info_model2, hashMap));
                                }
                                Table.nativeSetLink(j86, t0Var3.f6832i, createRow6, l11.longValue(), false);
                            } else {
                                Table.nativeNullifyLink(j86, t0Var3.f6832i, createRow6);
                            }
                            Table.nativeSetLong(j86, t0Var3.f6833j, createRow6, episodeModel2.realmGet$season(), false);
                            String realmGet$season_name2 = episodeModel2.realmGet$season_name();
                            if (realmGet$season_name2 != null) {
                                Table.nativeSetString(j86, t0Var3.f6834k, createRow6, realmGet$season_name2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6834k, createRow6, false);
                            }
                            String realmGet$series_name2 = episodeModel2.realmGet$series_name();
                            if (realmGet$series_name2 != null) {
                                Table.nativeSetString(j86, t0Var3.f6835l, createRow6, realmGet$series_name2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6835l, createRow6, false);
                            }
                            String realmGet$stream_icon6 = episodeModel2.realmGet$stream_icon();
                            if (realmGet$stream_icon6 != null) {
                                Table.nativeSetString(j86, t0Var3.f6836m, createRow6, realmGet$stream_icon6, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6836m, createRow6, false);
                            }
                            String realmGet$title2 = episodeModel2.realmGet$title();
                            if (realmGet$title2 != null) {
                                Table.nativeSetString(j86, t0Var3.f6837n, createRow6, realmGet$title2, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6837n, createRow6, false);
                            }
                            String realmGet$url6 = episodeModel2.realmGet$url();
                            if (realmGet$url6 != null) {
                                Table.nativeSetString(j86, t0Var3.f6838o, createRow6, realmGet$url6, false);
                            } else {
                                Table.nativeSetNull(j86, t0Var3.f6838o, createRow6, false);
                            }
                        }
                    }
                    return;
                }
                OsObjectSchemaInfo osObjectSchemaInfo7 = w0.f6869q;
                Table b15 = kVar.b(MovieModel.class);
                long j87 = b15.f6717o;
                v0 v0Var3 = (v0) kVar.a(MovieModel.class);
                while (it.hasNext()) {
                    MovieModel movieModel2 = (MovieModel) it.next();
                    if (!hashMap.containsKey(movieModel2)) {
                        if ((movieModel2 instanceof io.realm.internal.y) && !k0.isFrozen(movieModel2)) {
                            io.realm.internal.y yVar7 = (io.realm.internal.y) movieModel2;
                            if (((d) yVar7.a().f2684e) != null && ((d) yVar7.a().f2684e).f6645q.f6666c.equals(f0Var.f6666c)) {
                                hashMap.put(movieModel2, Long.valueOf(((io.realm.internal.a0) yVar7.a().f2682c).F()));
                            }
                        }
                        long createRow7 = OsObject.createRow(b15);
                        hashMap.put(movieModel2, Long.valueOf(createRow7));
                        String realmGet$added3 = movieModel2.realmGet$added();
                        if (realmGet$added3 != null) {
                            Table.nativeSetString(j87, v0Var3.f6849e, createRow7, realmGet$added3, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6849e, createRow7, false);
                        }
                        String realmGet$category_id5 = movieModel2.realmGet$category_id();
                        if (realmGet$category_id5 != null) {
                            Table.nativeSetString(j87, v0Var3.f6850f, createRow7, realmGet$category_id5, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6850f, createRow7, false);
                        }
                        String realmGet$category_name7 = movieModel2.realmGet$category_name();
                        if (realmGet$category_name7 != null) {
                            Table.nativeSetString(j87, v0Var3.g, createRow7, realmGet$category_name7, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.g, createRow7, false);
                        }
                        String realmGet$custom_sid3 = movieModel2.realmGet$custom_sid();
                        if (realmGet$custom_sid3 != null) {
                            Table.nativeSetString(j87, v0Var3.f6851h, createRow7, realmGet$custom_sid3, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6851h, createRow7, false);
                        }
                        String realmGet$extension2 = movieModel2.realmGet$extension();
                        if (realmGet$extension2 != null) {
                            Table.nativeSetString(j87, v0Var3.f6852i, createRow7, realmGet$extension2, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6852i, createRow7, false);
                        }
                        Table.nativeSetBoolean(j87, v0Var3.f6853j, createRow7, movieModel2.realmGet$is_favorite(), false);
                        Table.nativeSetBoolean(j87, v0Var3.f6854k, createRow7, movieModel2.realmGet$is_locked(), false);
                        Table.nativeSetBoolean(j87, v0Var3.f6855l, createRow7, movieModel2.realmGet$is_recent(), false);
                        String realmGet$name5 = movieModel2.realmGet$name();
                        if (realmGet$name5 != null) {
                            Table.nativeSetString(j87, v0Var3.f6856m, createRow7, realmGet$name5, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6856m, createRow7, false);
                        }
                        Table.nativeSetLong(j87, v0Var3.f6857n, createRow7, movieModel2.realmGet$num(), false);
                        Table.nativeSetLong(j87, v0Var3.f6858o, createRow7, movieModel2.realmGet$pro(), false);
                        String realmGet$rating4 = movieModel2.realmGet$rating();
                        if (realmGet$rating4 != null) {
                            Table.nativeSetString(j87, v0Var3.f6859p, createRow7, realmGet$rating4, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6859p, createRow7, false);
                        }
                        Table.nativeSetLong(j87, v0Var3.f6860q, createRow7, movieModel2.realmGet$recent_mil(), false);
                        String realmGet$stream_icon7 = movieModel2.realmGet$stream_icon();
                        if (realmGet$stream_icon7 != null) {
                            Table.nativeSetString(j87, v0Var3.f6861r, createRow7, realmGet$stream_icon7, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6861r, createRow7, false);
                        }
                        String realmGet$stream_id3 = movieModel2.realmGet$stream_id();
                        if (realmGet$stream_id3 != null) {
                            Table.nativeSetString(j87, v0Var3.f6862s, createRow7, realmGet$stream_id3, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6862s, createRow7, false);
                        }
                        String realmGet$stream_type5 = movieModel2.realmGet$stream_type();
                        if (realmGet$stream_type5 != null) {
                            Table.nativeSetString(j87, v0Var3.f6863t, createRow7, realmGet$stream_type5, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6863t, createRow7, false);
                        }
                        Table.nativeSetLong(j87, v0Var3.f6864u, createRow7, movieModel2.realmGet$time(), false);
                        String realmGet$tmdb_id2 = movieModel2.realmGet$tmdb_id();
                        if (realmGet$tmdb_id2 != null) {
                            Table.nativeSetString(j87, v0Var3.f6865v, createRow7, realmGet$tmdb_id2, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6865v, createRow7, false);
                        }
                        String realmGet$type2 = movieModel2.realmGet$type();
                        if (realmGet$type2 != null) {
                            Table.nativeSetString(j87, v0Var3.f6866w, createRow7, realmGet$type2, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6866w, createRow7, false);
                        }
                        String realmGet$url7 = movieModel2.realmGet$url();
                        if (realmGet$url7 != null) {
                            Table.nativeSetString(j87, v0Var3.f6867x, createRow7, realmGet$url7, false);
                        } else {
                            Table.nativeSetNull(j87, v0Var3.f6867x, createRow7, false);
                        }
                    }
                }
            }
        }
    }

    @Override // io.realm.internal.z
    public final i0 i(Class cls, Object obj, io.realm.internal.a0 a0Var, io.realm.internal.c cVar) {
        List list = Collections.EMPTY_LIST;
        c cVar2 = (c) d.f6642x.get();
        try {
            cVar2.getClass();
            List list2 = Collections.EMPTY_LIST;
            cVar2.f6629a = (d) obj;
            cVar2.f6630b = a0Var;
            cVar2.f6631c = cVar;
            cVar2.f6632d = list2;
            if (cls == null) {
                throw new NullPointerException("A class extending RealmObject must be provided");
            }
            if (cls.equals(SeriesModel.class)) {
                y0 y0Var = new y0();
                y0Var.f6897p.b();
                return (i0) cls.cast(y0Var);
            }
            if (cls.equals(MovieModel.class)) {
                w0 w0Var = new w0();
                w0Var.f6871p.b();
                return (i0) cls.cast(w0Var);
            }
            if (cls.equals(EpisodeModel.class)) {
                u0 u0Var = new u0();
                u0Var.f6843p.b();
                return (i0) cls.cast(u0Var);
            }
            if (cls.equals(EpisodeInfoModel.class)) {
                s0 s0Var = new s0();
                s0Var.f6828p.b();
                return (i0) cls.cast(s0Var);
            }
            if (!cls.equals(EPGChannel.class)) {
                throw io.realm.internal.z.d(cls);
            }
            q0 q0Var = new q0();
            q0Var.f6811p.b();
            return (i0) cls.cast(q0Var);
        } finally {
            cVar2.a();
        }
    }

    @Override // io.realm.internal.z
    public final boolean j() {
        return true;
    }
}
