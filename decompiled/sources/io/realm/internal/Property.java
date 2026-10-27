package io.realm.internal;

import io.realm.RealmFieldType;
import java.util.Locale;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class Property implements h {

    /* renamed from: p, reason: collision with root package name */
    public static final long f6713p = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public long f6714o;

    public static int a(RealmFieldType realmFieldType, boolean z10) {
        int i10;
        switch (v.f6770a[realmFieldType.ordinal()]) {
            case 1:
                return 71;
            case 2:
                return 135;
            case 3:
                return 136;
            case 4:
                i10 = 0;
                break;
            case 5:
                i10 = 1;
                break;
            case 6:
                i10 = 2;
                break;
            case 7:
                i10 = 3;
                break;
            case 8:
                i10 = 4;
                break;
            case 9:
                i10 = 5;
                break;
            case 10:
                i10 = 11;
                break;
            case 11:
                i10 = 10;
                break;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                i10 = 12;
                break;
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                i10 = 9;
                break;
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                i10 = 6;
                break;
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                i10 = 128;
                break;
            case WebSocketProtocol.B0_FLAG_RSV3 /* 16 */:
                i10 = 129;
                break;
            case 17:
                i10 = 130;
                break;
            case 18:
                i10 = 131;
                break;
            case 19:
                i10 = 132;
                break;
            case 20:
                i10 = 133;
                break;
            case 21:
                i10 = 139;
                break;
            case 22:
                i10 = 138;
                break;
            case 23:
                i10 = 140;
                break;
            case 24:
                i10 = 134;
                break;
            case 25:
                i10 = 137;
                break;
            case 26:
                i10 = 521;
                break;
            case 27:
                i10 = 513;
                break;
            case 28:
                i10 = 514;
                break;
            case 29:
                i10 = 512;
                break;
            case 30:
                i10 = 517;
                break;
            case 31:
                i10 = 518;
                break;
            case 32:
                i10 = 515;
                break;
            case 33:
                i10 = 516;
                break;
            case 34:
                i10 = 523;
                break;
            case 35:
                i10 = 522;
                break;
            case 36:
                i10 = 524;
                break;
            case 37:
                i10 = 519;
                break;
            case 38:
                i10 = 257;
                break;
            case 39:
                i10 = 258;
                break;
            case 40:
                i10 = 256;
                break;
            case 41:
                i10 = 261;
                break;
            case 42:
                i10 = 262;
                break;
            case 43:
                i10 = 259;
                break;
            case 44:
                i10 = 260;
                break;
            case 45:
                i10 = 267;
                break;
            case 46:
                i10 = 266;
                break;
            case 47:
                i10 = 268;
                break;
            case 48:
                return 263;
            case 49:
                i10 = 265;
                break;
            default:
                Locale locale = Locale.US;
                throw new IllegalArgumentException(android.support.v4.media.d.q("Unsupported filed type: '", realmFieldType.name(), "'."));
        }
        return i10 | (z10 ? 0 : 64);
    }

    public static native long nativeCreatePersistedLinkProperty(String str, String str2, int i10, String str3);

    public static native long nativeCreatePersistedProperty(String str, String str2, int i10, boolean z10, boolean z11);

    private static native long nativeGetColumnKey(long j10);

    private static native long nativeGetFinalizerPtr();

    private static native String nativeGetLinkedObjectName(long j10);

    private static native int nativeGetType(long j10);

    public final long b() {
        return nativeGetColumnKey(this.f6714o);
    }

    public final String c() {
        return nativeGetLinkedObjectName(this.f6714o);
    }

    public final RealmFieldType d() {
        int nativeGetType = nativeGetType(this.f6714o);
        int i10 = nativeGetType & (-65);
        switch (i10) {
            case 0:
                return RealmFieldType.INTEGER;
            case 1:
                return RealmFieldType.BOOLEAN;
            case 2:
                return RealmFieldType.STRING;
            case 3:
                return RealmFieldType.BINARY;
            case 4:
                return RealmFieldType.DATE;
            case 5:
                return RealmFieldType.FLOAT;
            case 6:
                return RealmFieldType.DOUBLE;
            case 7:
                return RealmFieldType.OBJECT;
            default:
                switch (i10) {
                    case 9:
                        return RealmFieldType.MIXED;
                    case 10:
                        return RealmFieldType.OBJECT_ID;
                    case 11:
                        return RealmFieldType.DECIMAL128;
                    case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                        return RealmFieldType.UUID;
                    default:
                        switch (i10) {
                            case 128:
                                return RealmFieldType.INTEGER_LIST;
                            case 129:
                                return RealmFieldType.BOOLEAN_LIST;
                            case 130:
                                return RealmFieldType.STRING_LIST;
                            case 131:
                                return RealmFieldType.BINARY_LIST;
                            case 132:
                                return RealmFieldType.DATE_LIST;
                            case 133:
                                return RealmFieldType.FLOAT_LIST;
                            case 134:
                                return RealmFieldType.DOUBLE_LIST;
                            case 135:
                                return RealmFieldType.LIST;
                            case 136:
                                return RealmFieldType.LINKING_OBJECTS;
                            case 137:
                                return RealmFieldType.MIXED_LIST;
                            case 138:
                                return RealmFieldType.OBJECT_ID_LIST;
                            case 139:
                                return RealmFieldType.DECIMAL128_LIST;
                            case 140:
                                return RealmFieldType.UUID_LIST;
                            default:
                                switch (i10) {
                                    case 256:
                                        return RealmFieldType.INTEGER_SET;
                                    case 257:
                                        return RealmFieldType.BOOLEAN_SET;
                                    case 258:
                                        return RealmFieldType.STRING_SET;
                                    case 259:
                                        return RealmFieldType.BINARY_SET;
                                    case 260:
                                        return RealmFieldType.DATE_SET;
                                    case 261:
                                        return RealmFieldType.FLOAT_SET;
                                    case 262:
                                        return RealmFieldType.DOUBLE_SET;
                                    case 263:
                                        return RealmFieldType.LINK_SET;
                                    default:
                                        switch (i10) {
                                            case 265:
                                                return RealmFieldType.MIXED_SET;
                                            case 266:
                                                return RealmFieldType.OBJECT_ID_SET;
                                            case 267:
                                                return RealmFieldType.DECIMAL128_SET;
                                            case 268:
                                                return RealmFieldType.UUID_SET;
                                            default:
                                                switch (i10) {
                                                    case 512:
                                                        return RealmFieldType.STRING_TO_INTEGER_MAP;
                                                    case 513:
                                                        return RealmFieldType.STRING_TO_BOOLEAN_MAP;
                                                    case 514:
                                                        return RealmFieldType.STRING_TO_STRING_MAP;
                                                    case 515:
                                                        return RealmFieldType.STRING_TO_BINARY_MAP;
                                                    case 516:
                                                        return RealmFieldType.STRING_TO_DATE_MAP;
                                                    case 517:
                                                        return RealmFieldType.STRING_TO_FLOAT_MAP;
                                                    case 518:
                                                        return RealmFieldType.STRING_TO_DOUBLE_MAP;
                                                    case 519:
                                                        return RealmFieldType.STRING_TO_LINK_MAP;
                                                    default:
                                                        switch (i10) {
                                                            case 521:
                                                                return RealmFieldType.STRING_TO_MIXED_MAP;
                                                            case 522:
                                                                return RealmFieldType.STRING_TO_OBJECT_ID_MAP;
                                                            case 523:
                                                                return RealmFieldType.STRING_TO_DECIMAL128_MAP;
                                                            case 524:
                                                                return RealmFieldType.STRING_TO_UUID_MAP;
                                                            default:
                                                                Locale locale = Locale.US;
                                                                throw new IllegalArgumentException(android.support.v4.media.d.o("Unsupported property type: '", nativeGetType, "'"));
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6713p;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6714o;
    }
}
