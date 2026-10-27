package io.realm;

import app.shamel.tv.models.EPGChannel;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.Table;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class q0 extends EPGChannel implements io.realm.internal.y {

    /* renamed from: q, reason: collision with root package name */
    public static final OsObjectSchemaInfo f6809q;

    /* renamed from: o, reason: collision with root package name */
    public p0 f6810o;

    /* renamed from: p, reason: collision with root package name */
    public c2.q f6811p;

    static {
        io.realm.internal.p pVar = new io.realm.internal.p("EPGChannel", 21);
        RealmFieldType realmFieldType = RealmFieldType.STRING;
        pVar.a("Id", realmFieldType, false);
        pVar.a("added", realmFieldType, false);
        pVar.a("category_id", realmFieldType, false);
        pVar.a("category_name", realmFieldType, false);
        RealmFieldType realmFieldType2 = RealmFieldType.INTEGER;
        pVar.a("cell", realmFieldType2, true);
        pVar.a("channelID", realmFieldType2, true);
        pVar.a("custom_sid", realmFieldType, false);
        pVar.a("direct_source", realmFieldType, false);
        RealmFieldType realmFieldType3 = RealmFieldType.BOOLEAN;
        pVar.a("is_favorite", realmFieldType3, true);
        pVar.a("is_locked", realmFieldType3, true);
        pVar.a("is_recent", realmFieldType3, true);
        pVar.a("name", realmFieldType, false);
        pVar.a("num", realmFieldType, false);
        pVar.a("recent_pos", realmFieldType2, true);
        pVar.a("selected", realmFieldType3, true);
        pVar.a("stream_icon", realmFieldType, false);
        pVar.a("stream_id", realmFieldType, false);
        pVar.a("stream_type", realmFieldType, false);
        pVar.a("tv_archive", realmFieldType, false);
        pVar.a("tv_archive_duration", realmFieldType, false);
        pVar.a("url", realmFieldType, false);
        f6809q = pVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void c(u uVar, Iterator it, HashMap hashMap) {
        k kVar = uVar.f6840y;
        Table b2 = kVar.b(EPGChannel.class);
        long j10 = b2.f6717o;
        p0 p0Var = (p0) kVar.a(EPGChannel.class);
        while (it.hasNext()) {
            EPGChannel ePGChannel = (EPGChannel) it.next();
            if (!hashMap.containsKey(ePGChannel)) {
                if ((ePGChannel instanceof io.realm.internal.y) && !k0.isFrozen(ePGChannel)) {
                    io.realm.internal.y yVar = (io.realm.internal.y) ePGChannel;
                    if (((d) yVar.a().f2684e) != null && ((d) yVar.a().f2684e).f6645q.f6666c.equals(uVar.f6645q.f6666c)) {
                        hashMap.put(ePGChannel, Long.valueOf(((io.realm.internal.a0) yVar.a().f2682c).F()));
                    }
                }
                long createRow = OsObject.createRow(b2);
                hashMap.put(ePGChannel, Long.valueOf(createRow));
                String realmGet$Id = ePGChannel.realmGet$Id();
                if (realmGet$Id != null) {
                    Table.nativeSetString(j10, p0Var.f6788e, createRow, realmGet$Id, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6788e, createRow, false);
                }
                String realmGet$added = ePGChannel.realmGet$added();
                if (realmGet$added != null) {
                    Table.nativeSetString(j10, p0Var.f6789f, createRow, realmGet$added, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6789f, createRow, false);
                }
                String realmGet$category_id = ePGChannel.realmGet$category_id();
                if (realmGet$category_id != null) {
                    Table.nativeSetString(j10, p0Var.g, createRow, realmGet$category_id, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.g, createRow, false);
                }
                String realmGet$category_name = ePGChannel.realmGet$category_name();
                if (realmGet$category_name != null) {
                    Table.nativeSetString(j10, p0Var.f6790h, createRow, realmGet$category_name, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6790h, createRow, false);
                }
                Table.nativeSetLong(j10, p0Var.f6791i, createRow, ePGChannel.realmGet$cell(), false);
                Table.nativeSetLong(j10, p0Var.f6792j, createRow, ePGChannel.realmGet$channelID(), false);
                String realmGet$custom_sid = ePGChannel.realmGet$custom_sid();
                if (realmGet$custom_sid != null) {
                    Table.nativeSetString(j10, p0Var.f6793k, createRow, realmGet$custom_sid, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6793k, createRow, false);
                }
                String realmGet$direct_source = ePGChannel.realmGet$direct_source();
                if (realmGet$direct_source != null) {
                    Table.nativeSetString(j10, p0Var.f6794l, createRow, realmGet$direct_source, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6794l, createRow, false);
                }
                Table.nativeSetBoolean(j10, p0Var.f6795m, createRow, ePGChannel.realmGet$is_favorite(), false);
                Table.nativeSetBoolean(j10, p0Var.f6796n, createRow, ePGChannel.realmGet$is_locked(), false);
                Table.nativeSetBoolean(j10, p0Var.f6797o, createRow, ePGChannel.realmGet$is_recent(), false);
                String realmGet$name = ePGChannel.realmGet$name();
                if (realmGet$name != null) {
                    Table.nativeSetString(j10, p0Var.f6798p, createRow, realmGet$name, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6798p, createRow, false);
                }
                String realmGet$num = ePGChannel.realmGet$num();
                if (realmGet$num != null) {
                    Table.nativeSetString(j10, p0Var.f6799q, createRow, realmGet$num, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6799q, createRow, false);
                }
                Table.nativeSetLong(j10, p0Var.f6800r, createRow, ePGChannel.realmGet$recent_pos(), false);
                Table.nativeSetBoolean(j10, p0Var.f6801s, createRow, ePGChannel.realmGet$selected(), false);
                String realmGet$stream_icon = ePGChannel.realmGet$stream_icon();
                if (realmGet$stream_icon != null) {
                    Table.nativeSetString(j10, p0Var.f6802t, createRow, realmGet$stream_icon, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6802t, createRow, false);
                }
                String realmGet$stream_id = ePGChannel.realmGet$stream_id();
                if (realmGet$stream_id != null) {
                    Table.nativeSetString(j10, p0Var.f6803u, createRow, realmGet$stream_id, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6803u, createRow, false);
                }
                String realmGet$stream_type = ePGChannel.realmGet$stream_type();
                if (realmGet$stream_type != null) {
                    Table.nativeSetString(j10, p0Var.f6804v, createRow, realmGet$stream_type, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6804v, createRow, false);
                }
                String realmGet$tv_archive = ePGChannel.realmGet$tv_archive();
                if (realmGet$tv_archive != null) {
                    Table.nativeSetString(j10, p0Var.f6805w, createRow, realmGet$tv_archive, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6805w, createRow, false);
                }
                String realmGet$tv_archive_duration = ePGChannel.realmGet$tv_archive_duration();
                if (realmGet$tv_archive_duration != null) {
                    Table.nativeSetString(j10, p0Var.f6806x, createRow, realmGet$tv_archive_duration, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6806x, createRow, false);
                }
                String realmGet$url = ePGChannel.realmGet$url();
                if (realmGet$url != null) {
                    Table.nativeSetString(j10, p0Var.f6807y, createRow, realmGet$url, false);
                } else {
                    Table.nativeSetNull(j10, p0Var.f6807y, createRow, false);
                }
            }
        }
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6811p;
    }

    @Override // io.realm.internal.y
    public final void b() {
        if (this.f6811p != null) {
            return;
        }
        c cVar = (c) d.f6642x.get();
        this.f6810o = (p0) cVar.f6631c;
        c2.q qVar = new c2.q(this);
        this.f6811p = qVar;
        qVar.f2684e = cVar.f6629a;
        qVar.f2682c = cVar.f6630b;
        qVar.f2685f = cVar.f6632d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q0.class != obj.getClass()) {
            return false;
        }
        q0 q0Var = (q0) obj;
        d dVar = (d) this.f6811p.f2684e;
        d dVar2 = (d) q0Var.f6811p.f2684e;
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
        String j10 = ((io.realm.internal.a0) this.f6811p.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) q0Var.f6811p.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) this.f6811p.f2682c).F() == ((io.realm.internal.a0) q0Var.f6811p.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6811p;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) this.f6811p.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$Id() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6788e);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$added() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6789f);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$category_id() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.g);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$category_name() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6790h);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final int realmGet$cell() {
        ((d) this.f6811p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6811p.f2682c).t(this.f6810o.f6791i);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final int realmGet$channelID() {
        ((d) this.f6811p.f2684e).c();
        return (int) ((io.realm.internal.a0) this.f6811p.f2682c).t(this.f6810o.f6792j);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$custom_sid() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6793k);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$direct_source() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6794l);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final boolean realmGet$is_favorite() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).q(this.f6810o.f6795m);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final boolean realmGet$is_locked() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).q(this.f6810o.f6796n);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final boolean realmGet$is_recent() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).q(this.f6810o.f6797o);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$name() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6798p);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$num() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6799q);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final long realmGet$recent_pos() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).t(this.f6810o.f6800r);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final boolean realmGet$selected() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).q(this.f6810o.f6801s);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$stream_icon() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6802t);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$stream_id() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6803u);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$stream_type() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6804v);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$tv_archive() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6805w);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$tv_archive_duration() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6806x);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final String realmGet$url() {
        ((d) this.f6811p.f2684e).c();
        return ((io.realm.internal.a0) this.f6811p.f2682c).u(this.f6810o.f6807y);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$Id(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6788e);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6788e, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$added(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6789f);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6789f, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$category_id(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.g);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.g, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$category_name(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6790h);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6790h, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$cell(int i10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).x(this.f6810o.f6791i, i10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$channelID(int i10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).x(this.f6810o.f6792j, i10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$custom_sid(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6793k);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6793k, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$direct_source(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6794l);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6794l, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$is_favorite(boolean z10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).l(this.f6810o.f6795m, z10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$is_locked(boolean z10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).l(this.f6810o.f6796n, z10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$is_recent(boolean z10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).l(this.f6810o.f6797o, z10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$name(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6798p);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6798p, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$num(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6799q);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6799q, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$recent_pos(long j10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).x(this.f6810o.f6800r, j10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$selected(boolean z10) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        ((io.realm.internal.a0) this.f6811p.f2682c).l(this.f6810o.f6801s, z10);
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$stream_icon(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6802t);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6802t, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$stream_id(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6803u);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6803u, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$stream_type(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6804v);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6804v, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$tv_archive(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6805w);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6805w, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$tv_archive_duration(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6806x);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6806x, str);
        }
    }

    @Override // app.shamel.tv.models.EPGChannel
    public final void realmSet$url(String str) {
        c2.q qVar = this.f6811p;
        if (qVar.f2680a) {
            return;
        }
        ((d) qVar.f2684e).c();
        if (str == null) {
            ((io.realm.internal.a0) this.f6811p.f2682c).j(this.f6810o.f6807y);
        } else {
            ((io.realm.internal.a0) this.f6811p.f2682c).d(this.f6810o.f6807y, str);
        }
    }

    public final String toString() {
        if (!k0.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder("EPGChannel = proxy[{Id:");
        sb2.append(realmGet$Id() != null ? realmGet$Id() : "null");
        sb2.append("},{added:");
        sb2.append(realmGet$added() != null ? realmGet$added() : "null");
        sb2.append("},{category_id:");
        sb2.append(realmGet$category_id() != null ? realmGet$category_id() : "null");
        sb2.append("},{category_name:");
        sb2.append(realmGet$category_name() != null ? realmGet$category_name() : "null");
        sb2.append("},{cell:");
        sb2.append(realmGet$cell());
        sb2.append("},{channelID:");
        sb2.append(realmGet$channelID());
        sb2.append("},{custom_sid:");
        sb2.append(realmGet$custom_sid() != null ? realmGet$custom_sid() : "null");
        sb2.append("},{direct_source:");
        sb2.append(realmGet$direct_source() != null ? realmGet$direct_source() : "null");
        sb2.append("},{is_favorite:");
        sb2.append(realmGet$is_favorite());
        sb2.append("},{is_locked:");
        sb2.append(realmGet$is_locked());
        sb2.append("},{is_recent:");
        sb2.append(realmGet$is_recent());
        sb2.append("},{name:");
        sb2.append(realmGet$name() != null ? realmGet$name() : "null");
        sb2.append("},{num:");
        sb2.append(realmGet$num() != null ? realmGet$num() : "null");
        sb2.append("},{recent_pos:");
        sb2.append(realmGet$recent_pos());
        sb2.append("},{selected:");
        sb2.append(realmGet$selected());
        sb2.append("},{stream_icon:");
        sb2.append(realmGet$stream_icon() != null ? realmGet$stream_icon() : "null");
        sb2.append("},{stream_id:");
        sb2.append(realmGet$stream_id() != null ? realmGet$stream_id() : "null");
        sb2.append("},{stream_type:");
        sb2.append(realmGet$stream_type() != null ? realmGet$stream_type() : "null");
        sb2.append("},{tv_archive:");
        sb2.append(realmGet$tv_archive() != null ? realmGet$tv_archive() : "null");
        sb2.append("},{tv_archive_duration:");
        sb2.append(realmGet$tv_archive_duration() != null ? realmGet$tv_archive_duration() : "null");
        sb2.append("},{url:");
        return android.support.v4.media.d.r(sb2, realmGet$url() != null ? realmGet$url() : "null", "}]");
    }
}
