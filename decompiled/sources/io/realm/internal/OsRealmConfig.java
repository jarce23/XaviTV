package io.realm.internal;

import io.realm.f0;
import io.realm.internal.OsSharedRealm;
import io.realm.log.RealmLog;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class OsRealmConfig implements h {

    /* renamed from: u, reason: collision with root package name */
    public static final long f6694u = nativeGetFinalizerPtr();

    /* renamed from: o, reason: collision with root package name */
    public final Object f6695o;

    /* renamed from: p, reason: collision with root package name */
    public final Object f6696p;

    /* renamed from: q, reason: collision with root package name */
    public final f0 f6697q;

    /* renamed from: r, reason: collision with root package name */
    public final URI f6698r;

    /* renamed from: s, reason: collision with root package name */
    public final long f6699s;

    /* renamed from: t, reason: collision with root package name */
    public final g f6700t = new g();

    public OsRealmConfig(f0 f0Var, String str, boolean z10, OsSchemaInfo osSchemaInfo, io.realm.b bVar) {
        boolean z11;
        long j10;
        String str2;
        String str3;
        byte b2;
        OsRealmConfig osRealmConfig;
        URI uri;
        String str4;
        int i10;
        URI uri2;
        String str5;
        this.f6697q = f0Var;
        this.f6699s = nativeCreate(f0Var.f6666c, str, true, f0Var.f6671i);
        g.f6744b.a(this);
        if (j.f6747a == null) {
            j jVar = j.f6747a;
        }
        Object[] objArr = new Object[19];
        String str6 = (String) objArr[0];
        String str7 = (String) objArr[1];
        String str8 = (String) objArr[2];
        String str9 = (String) objArr[3];
        String str10 = (String) objArr[4];
        String str11 = (String) objArr[5];
        String str12 = (String) objArr[6];
        Byte b10 = (Byte) objArr[7];
        String str13 = (String) objArr[8];
        String str14 = (String) objArr[9];
        Map map = (Map) objArr[10];
        Byte b11 = (Byte) objArr[11];
        this.f6695o = objArr[12];
        this.f6696p = objArr[13];
        String str15 = (String) objArr[14];
        Object obj = objArr[15];
        Long l10 = (Long) objArr[16];
        boolean equals = Boolean.TRUE.equals(objArr[17]);
        String str16 = (String) objArr[18];
        String[] strArr = new String[map != null ? map.size() * 2 : 0];
        if (map != null) {
            int i11 = 0;
            for (Map.Entry entry : map.entrySet()) {
                strArr[i11] = (String) entry.getKey();
                strArr[i11 + 1] = (String) entry.getValue();
                i11 += 2;
            }
        }
        nativeSetInMemory(this.f6699s, f0Var.f6669f == 2);
        nativeEnableChangeNotification(this.f6699s, z10);
        char c10 = str8 != null ? (char) 5 : f0Var.f6668e ? (char) 4 : (char) 6;
        long j11 = f0Var.f6667d;
        if (osSchemaInfo == null) {
            j10 = 0;
            z11 = equals;
        } else {
            z11 = equals;
            j10 = osSchemaInfo.f6710o;
        }
        long j12 = this.f6699s;
        switch (c10) {
            case 1:
                str2 = str16;
                str3 = str9;
                b2 = 0;
                break;
            case 2:
                str2 = str16;
                str3 = str9;
                b2 = 1;
                break;
            case 3:
                str2 = str16;
                str3 = str9;
                b2 = 2;
                break;
            case 4:
                str2 = str16;
                str3 = str9;
                b2 = 3;
                break;
            case 5:
                str2 = str16;
                str3 = str9;
                b2 = 5;
                break;
            case 6:
                str2 = str16;
                b2 = 7;
                str3 = str9;
                break;
            default:
                throw null;
        }
        boolean z12 = z11;
        String str17 = str2;
        nativeSetSchemaConfig(j12, b2, j11, j10, null);
        if (str8 != null) {
            osRealmConfig = this;
            String nativeCreateAndSetSyncConfig = osRealmConfig.nativeCreateAndSetSyncConfig(l10.longValue(), this.f6699s, str8, str6, str7, str10, str11, str12, b10.byteValue(), str13, str14, strArr, b11.byteValue(), this.f6695o, this.f6696p, str15, obj);
            try {
                nativeCreateAndSetSyncConfig = str3 + str13.substring(1);
                uri = new URI(nativeCreateAndSetSyncConfig);
                str4 = "Cannot create a URI from the Realm URL address";
            } catch (URISyntaxException e7) {
                str4 = "Cannot create a URI from the Realm URL address";
                RealmLog.a(e7, str4, new Object[0]);
                uri = null;
            }
            nativeSetSyncConfigSslSettings(osRealmConfig.f6699s, z12, str17);
            ProxySelector proxySelector = ProxySelector.getDefault();
            if (uri != null && proxySelector != null) {
                try {
                    uri2 = new URI(nativeCreateAndSetSyncConfig.replaceFirst("ws", "http"));
                    i10 = 0;
                } catch (URISyntaxException e8) {
                    i10 = 0;
                    RealmLog.a(e8, str4, new Object[0]);
                    uri2 = null;
                }
                List<Proxy> select = proxySelector.select(uri2);
                if (select != null && !select.isEmpty()) {
                    Proxy proxy = select.get(i10);
                    if (proxy.type() != Proxy.Type.DIRECT) {
                        byte b12 = q.f6760a[proxy.type().ordinal()] != 1 ? (byte) -1 : (byte) 0;
                        if (proxy.type() == Proxy.Type.HTTP) {
                            SocketAddress address = proxy.address();
                            if (address instanceof InetSocketAddress) {
                                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                                if (inetSocketAddress.getHostName() != null) {
                                    str5 = inetSocketAddress.getHostName();
                                } else if (inetSocketAddress.getAddress() != null) {
                                    InetAddress address2 = inetSocketAddress.getAddress();
                                    str5 = address2.getHostName() != null ? address2.getHostName() : address2.getHostAddress();
                                } else {
                                    str5 = null;
                                }
                                if (str5 != null) {
                                    nativeSetSyncConfigProxySettings(osRealmConfig.f6699s, b12, str5, inetSocketAddress.getPort());
                                } else {
                                    RealmLog.a(null, "Could not retrieve proxy's hostname.", new Object[0]);
                                }
                            } else {
                                RealmLog.a(null, "Unsupported proxy socket address type: ".concat(address.getClass().getName()), new Object[0]);
                            }
                        } else {
                            RealmLog.a(null, "SOCKS proxies are not supported.", new Object[0]);
                        }
                    }
                }
            }
        } else {
            osRealmConfig = this;
            uri = null;
        }
        osRealmConfig.f6698r = uri;
    }

    private static native long nativeCreate(String str, String str2, boolean z10, long j10);

    private native String nativeCreateAndSetSyncConfig(long j10, long j11, String str, String str2, String str3, String str4, String str5, String str6, byte b2, String str7, String str8, String[] strArr, byte b10, Object obj, Object obj2, String str9, Object obj3);

    private static native void nativeEnableChangeNotification(long j10, boolean z10);

    private static native long nativeGetFinalizerPtr();

    private static native void nativeSetInMemory(long j10, boolean z10);

    private native void nativeSetInitializationCallback(long j10, OsSharedRealm.InitializationCallback initializationCallback);

    private native void nativeSetSchemaConfig(long j10, byte b2, long j11, long j12, OsSharedRealm.MigrationCallback migrationCallback);

    private static native void nativeSetSyncConfigProxySettings(long j10, byte b2, String str, int i10);

    private static native void nativeSetSyncConfigSslSettings(long j10, boolean z10, String str);

    @Override // io.realm.internal.h
    public final long getNativeFinalizerPtr() {
        return f6694u;
    }

    @Override // io.realm.internal.h
    public final long getNativePtr() {
        return this.f6699s;
    }
}
