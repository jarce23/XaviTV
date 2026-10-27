package io.realm;

import io.realm.exceptions.RealmException;
import io.realm.internal.Table;
import io.realm.internal.core.NativeRealmAny;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.WebSocketProtocol;
import org.bson.types.Decimal128;
import org.bson.types.ObjectId;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class i extends k0 implements io.realm.internal.y {

    /* renamed from: o, reason: collision with root package name */
    public final c2.q f6676o;

    public i(d dVar, io.realm.internal.a0 a0Var) {
        c2.q qVar = new c2.q(this);
        this.f6676o = qVar;
        qVar.f2684e = dVar;
        qVar.f2682c = a0Var;
        qVar.b();
    }

    @Override // io.realm.internal.y
    public final c2.q a() {
        return this.f6676o;
    }

    public final boolean equals(Object obj) {
        c2.q qVar = this.f6676o;
        ((d) qVar.f2684e).c();
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        c2.q qVar2 = ((i) obj).f6676o;
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String str2 = ((d) qVar2.f2684e).f6645q.f6666c;
        if (str != null) {
            if (!str.equals(str2)) {
                return false;
            }
        } else if (str2 != null) {
            return false;
        }
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        String j11 = ((io.realm.internal.a0) qVar2.f2682c).h().j();
        if (j10 != null) {
            if (!j10.equals(j11)) {
                return false;
            }
        } else if (j11 != null) {
            return false;
        }
        return ((io.realm.internal.a0) qVar.f2682c).F() == ((io.realm.internal.a0) qVar2.f2682c).F();
    }

    public final int hashCode() {
        c2.q qVar = this.f6676o;
        ((d) qVar.f2684e).c();
        String str = ((d) qVar.f2684e).f6645q.f6666c;
        String j10 = ((io.realm.internal.a0) qVar.f2682c).h().j();
        long F = ((io.realm.internal.a0) qVar.f2682c).F();
        return ((((527 + (str != null ? str.hashCode() : 0)) * 31) + (j10 != null ? j10.hashCode() : 0)) * 31) + ((int) ((F >>> 32) ^ F));
    }

    /* JADX WARN: Type inference failed for: r8v10, types: [byte[], java.io.Serializable] */
    public final String toString() {
        x lVar;
        x eVar;
        c2.q qVar = this.f6676o;
        ((d) qVar.f2684e).c();
        if (!((io.realm.internal.a0) qVar.f2682c).isValid()) {
            return "Invalid object";
        }
        StringBuilder sb2 = new StringBuilder(r.a.c(((io.realm.internal.a0) qVar.f2682c).h().d(), " = dynamic["));
        ((d) qVar.f2684e).c();
        for (String str : ((io.realm.internal.a0) qVar.f2682c).getColumnNames()) {
            long b2 = ((io.realm.internal.a0) qVar.f2682c).b(str);
            RealmFieldType C = ((io.realm.internal.a0) qVar.f2682c).C(b2);
            sb2.append("{");
            sb2.append(str);
            sb2.append(":");
            String str2 = "null";
            switch (h.f6674a[C.ordinal()]) {
                case 1:
                    Object obj = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj = Boolean.valueOf(((io.realm.internal.a0) qVar.f2682c).q(b2));
                    }
                    sb2.append(obj);
                    break;
                case 2:
                    Object obj2 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj2 = Long.valueOf(((io.realm.internal.a0) qVar.f2682c).t(b2));
                    }
                    sb2.append(obj2);
                    break;
                case 3:
                    Object obj3 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj3 = Float.valueOf(((io.realm.internal.a0) qVar.f2682c).s(b2));
                    }
                    sb2.append(obj3);
                    break;
                case 4:
                    Object obj4 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj4 = Double.valueOf(((io.realm.internal.a0) qVar.f2682c).p(b2));
                    }
                    sb2.append(obj4);
                    break;
                case 5:
                    sb2.append(((io.realm.internal.a0) qVar.f2682c).u(b2));
                    break;
                case 6:
                    sb2.append(Arrays.toString(((io.realm.internal.a0) qVar.f2682c).k(b2)));
                    break;
                case 7:
                    Object obj5 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj5 = ((io.realm.internal.a0) qVar.f2682c).y(b2);
                    }
                    sb2.append(obj5);
                    break;
                case 8:
                    Object obj6 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj6 = ((io.realm.internal.a0) qVar.f2682c).a(b2);
                    }
                    sb2.append(obj6);
                    break;
                case 9:
                    Object obj7 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj7 = ((io.realm.internal.a0) qVar.f2682c).n(b2);
                    }
                    sb2.append(obj7);
                    break;
                case 10:
                    Object obj8 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        NativeRealmAny g = ((io.realm.internal.a0) qVar.f2682c).g(b2);
                        d dVar = (d) qVar.f2684e;
                        v type = g.getType();
                        switch (type) {
                            case INTEGER:
                                Long valueOf = Long.valueOf(g.asLong());
                                v vVar = v.OBJECT;
                                lVar = new l(valueOf, g, 0);
                                obj8 = new w(lVar);
                                break;
                            case BOOLEAN:
                                Boolean valueOf2 = Boolean.valueOf(g.asBoolean());
                                v vVar2 = v.OBJECT;
                                eVar = new e(valueOf2, g, 1);
                                lVar = eVar;
                                obj8 = new w(lVar);
                                break;
                            case STRING:
                                String asString = g.asString();
                                v vVar3 = v.OBJECT;
                                lVar = new e(asString, g, 4);
                                obj8 = new w(lVar);
                                break;
                            case BINARY:
                                ?? asBinary = g.asBinary();
                                v vVar4 = v.OBJECT;
                                lVar = new e(asBinary, g, 0);
                                obj8 = new w(lVar);
                                break;
                            case DATE:
                                Date asDate = g.asDate();
                                v vVar5 = v.OBJECT;
                                eVar = new l(asDate, g, 1);
                                lVar = eVar;
                                obj8 = new w(lVar);
                                break;
                            case FLOAT:
                                Float valueOf3 = Float.valueOf(g.asFloat());
                                v vVar6 = v.OBJECT;
                                lVar = new e(valueOf3, g, 3);
                                obj8 = new w(lVar);
                                break;
                            case DOUBLE:
                                Double valueOf4 = Double.valueOf(g.asDouble());
                                v vVar7 = v.OBJECT;
                                lVar = new l(valueOf4, g, 2);
                                obj8 = new w(lVar);
                                break;
                            case DECIMAL128:
                                Decimal128 asDecimal128 = g.asDecimal128();
                                v vVar8 = v.OBJECT;
                                lVar = new e(asDecimal128, g, 2);
                                obj8 = new w(lVar);
                                break;
                            case OBJECT_ID:
                                ObjectId asObjectId = g.asObjectId();
                                v vVar9 = v.OBJECT;
                                lVar = new l(asObjectId, g, 3);
                                obj8 = new w(lVar);
                                break;
                            case OBJECT:
                                if (dVar instanceof u) {
                                    try {
                                        lVar = new j0(dVar, g, g.getModelClass(dVar.f6647s, dVar.f6645q.g));
                                    } catch (RealmException unused) {
                                    }
                                    obj8 = new w(lVar);
                                    break;
                                }
                                lVar = new g(dVar.K(i.class, Table.e(g.getRealmModelTableName(dVar.f6647s)), g.getRealmModelRowKey()));
                                obj8 = new w(lVar);
                            case UUID:
                                UUID asUUID = g.asUUID();
                                v vVar10 = v.OBJECT;
                                lVar = new l(asUUID, g, 4);
                                obj8 = new w(lVar);
                                break;
                            case NULL:
                                v vVar11 = v.OBJECT;
                                lVar = new n(g);
                                obj8 = new w(lVar);
                                break;
                            default:
                                throw new ClassCastException("Couldn't cast to " + type);
                        }
                    }
                    sb2.append(obj8);
                    break;
                case 11:
                    Object obj9 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).B(b2)) {
                        obj9 = ((io.realm.internal.a0) qVar.f2682c).o(b2);
                    }
                    sb2.append(obj9);
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    String str3 = str2;
                    if (!((io.realm.internal.a0) qVar.f2682c).i(b2)) {
                        str3 = ((io.realm.internal.a0) qVar.f2682c).h().i(b2).d();
                    }
                    sb2.append(str3);
                    break;
                case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                    String d6 = ((io.realm.internal.a0) qVar.f2682c).h().i(b2).d();
                    Locale locale = Locale.US;
                    sb2.append("RealmList<" + d6 + ">[" + ((io.realm.internal.a0) qVar.f2682c).w(b2).a() + "]");
                    break;
                case UrlRequest.Status.READING_RESPONSE /* 14 */:
                    Locale locale2 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Long>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                    Locale locale3 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Boolean>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                    Locale locale4 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<String>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 17:
                    Locale locale5 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<byte[]>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 18:
                    Locale locale6 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Date>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 19:
                    Locale locale7 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Float>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 20:
                    Locale locale8 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Double>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 21:
                    Locale locale9 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<Decimal128>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 22:
                    Locale locale10 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<ObjectId>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 23:
                    Locale locale11 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<UUID>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 24:
                    Locale locale12 = Locale.US;
                    android.support.v4.media.d.y("RealmDictionary<RealmAny>[", ((io.realm.internal.a0) qVar.f2682c).A(b2, C).a(), "]", sb2);
                    break;
                case 25:
                    String d10 = ((io.realm.internal.a0) qVar.f2682c).h().i(b2).d();
                    Locale locale13 = Locale.US;
                    sb2.append("RealmDictionary<" + d10 + ">[" + ((io.realm.internal.a0) qVar.f2682c).c(b2).a() + "]");
                    break;
                case 26:
                    Locale locale14 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Long>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 27:
                    Locale locale15 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Boolean>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 28:
                    Locale locale16 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<String>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 29:
                    Locale locale17 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<byte[]>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 30:
                    Locale locale18 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Date>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 31:
                    Locale locale19 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Float>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 32:
                    Locale locale20 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Double>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 33:
                    Locale locale21 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<Decimal128>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 34:
                    Locale locale22 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<ObjectId>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 35:
                    Locale locale23 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<UUID>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 36:
                    String d11 = ((io.realm.internal.a0) qVar.f2682c).h().i(b2).d();
                    Locale locale24 = Locale.US;
                    sb2.append("RealmSet<" + d11 + ">[" + ((io.realm.internal.a0) qVar.f2682c).m(b2).a() + "]");
                    break;
                case 37:
                    Locale locale25 = Locale.US;
                    android.support.v4.media.d.y("RealmSet<RealmAny>[", ((io.realm.internal.a0) qVar.f2682c).e(b2, C).a(), "]", sb2);
                    break;
                case 38:
                default:
                    sb2.append("?");
                    break;
                case 39:
                    Locale locale26 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Long>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 40:
                    Locale locale27 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Boolean>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 41:
                    Locale locale28 = Locale.US;
                    android.support.v4.media.d.y("RealmList<String>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 42:
                    Locale locale29 = Locale.US;
                    android.support.v4.media.d.y("RealmList<byte[]>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 43:
                    Locale locale30 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Date>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 44:
                    Locale locale31 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Float>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 45:
                    Locale locale32 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Double>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 46:
                    Locale locale33 = Locale.US;
                    android.support.v4.media.d.y("RealmList<Decimal128>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 47:
                    Locale locale34 = Locale.US;
                    android.support.v4.media.d.y("RealmList<ObjectId>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 48:
                    Locale locale35 = Locale.US;
                    android.support.v4.media.d.y("RealmList<UUID>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
                case 49:
                    Locale locale36 = Locale.US;
                    android.support.v4.media.d.y("RealmList<RealmAny>[", ((io.realm.internal.a0) qVar.f2682c).z(b2, C).a(), "]", sb2);
                    break;
            }
            sb2.append("},");
        }
        sb2.replace(sb2.length() - 1, sb2.length(), _UrlKt.FRAGMENT_ENCODE_SET);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // io.realm.internal.y
    public final void b() {
    }
}
