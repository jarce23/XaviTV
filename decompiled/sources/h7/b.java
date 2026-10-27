package h7;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.internal.cast.g4;
import com.google.android.gms.internal.cast.h4;
import com.google.android.gms.internal.cast.l0;
import com.google.android.gms.internal.cast.l4;
import com.google.android.gms.internal.cast.y1;
import com.google.android.gms.internal.cast.z0;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import k2.i0;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: l, reason: collision with root package name */
    public static final l7.b f5697l = new l7.b("CastContext", null);

    /* renamed from: m, reason: collision with root package name */
    public static final Object f5698m = new Object();

    /* renamed from: n, reason: collision with root package name */
    public static volatile b f5699n;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5700a;

    /* renamed from: b, reason: collision with root package name */
    public final o f5701b;

    /* renamed from: c, reason: collision with root package name */
    public final i f5702c;

    /* renamed from: d, reason: collision with root package name */
    public final l f5703d;

    /* renamed from: e, reason: collision with root package name */
    public final c f5704e;

    /* renamed from: f, reason: collision with root package name */
    public final l7.s f5705f;
    public final com.google.android.gms.internal.cast.c g;

    /* renamed from: h, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.m f5706h;

    /* renamed from: i, reason: collision with root package name */
    public final List f5707i;

    /* renamed from: j, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.t f5708j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.gms.internal.cast.e f5709k;

    public b(Context context, c cVar, List list, com.google.android.gms.internal.cast.q qVar, l7.s sVar) {
        s sVar2;
        z zVar;
        LinkProperties linkProperties;
        this.f5700a = context;
        this.f5704e = cVar;
        this.f5705f = sVar;
        this.f5707i = list;
        this.f5706h = new com.google.android.gms.internal.cast.m(context);
        this.f5708j = qVar.g;
        if (TextUtils.isEmpty(cVar.f5712o)) {
            this.f5709k = null;
        } else {
            this.f5709k = new com.google.android.gms.internal.cast.e(context, cVar, qVar);
        }
        HashMap hashMap = new HashMap();
        com.google.android.gms.internal.cast.e eVar = this.f5709k;
        if (eVar != null) {
            hashMap.put(eVar.f3296b, eVar.f3297c);
        }
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                com.google.android.gms.internal.cast.e eVar2 = (com.google.android.gms.internal.cast.e) it.next();
                r7.r.f("Additional SessionProvider must not be null.", eVar2);
                String str = eVar2.f3296b;
                r7.r.d(str, "Category for SessionProvider must not be null or empty string.");
                boolean containsKey = hashMap.containsKey(str);
                String q10 = android.support.v4.media.d.q("SessionProvider for category ", str, " already added");
                if (containsKey) {
                    throw new IllegalArgumentException(String.valueOf(q10));
                }
                hashMap.put(str, eVar2.f3297c);
            }
        }
        final int i10 = 1;
        cVar.D = new e0(1);
        try {
            o a10 = com.google.android.gms.internal.cast.d.a(context, cVar, qVar, hashMap);
            this.f5701b = a10;
            try {
                m mVar = (m) a10;
                Parcel x02 = mVar.x0(mVar.w0(), 6);
                IBinder readStrongBinder = x02.readStrongBinder();
                if (readStrongBinder == null) {
                    sVar2 = null;
                } else {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
                    sVar2 = queryLocalInterface instanceof s ? (s) queryLocalInterface : new s(readStrongBinder, "com.google.android.gms.cast.framework.IDiscoveryManager", 2);
                }
                x02.recycle();
                this.f5703d = new l(sVar2);
                try {
                    m mVar2 = (m) a10;
                    Parcel x03 = mVar2.x0(mVar2.w0(), 5);
                    IBinder readStrongBinder2 = x03.readStrongBinder();
                    if (readStrongBinder2 == null) {
                        zVar = null;
                    } else {
                        IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
                        zVar = queryLocalInterface2 instanceof z ? (z) queryLocalInterface2 : new z(readStrongBinder2, "com.google.android.gms.cast.framework.ISessionManager", 2);
                    }
                    x03.recycle();
                    i iVar = new i(zVar, context);
                    this.f5702c = iVar;
                    r7.r.d("PrecacheManager", "The log tag cannot be null or empty.");
                    TextUtils.isEmpty(null);
                    com.google.android.gms.internal.cast.t tVar = this.f5708j;
                    if (tVar != null) {
                        tVar.f3473f = iVar;
                        b8.e eVar3 = tVar.f3470c;
                        r7.r.e(eVar3);
                        eVar3.post(new com.google.android.gms.internal.cast.s(tVar, i10));
                    }
                    int i11 = 3;
                    ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
                    com.google.android.gms.internal.cast.x xVar = new com.google.android.gms.internal.cast.x(context, newFixedThreadPool instanceof g4 ? (g4) newFixedThreadPool : newFixedThreadPool instanceof ScheduledExecutorService ? new l4((ScheduledExecutorService) newFixedThreadPool) : new h4(newFixedThreadPool));
                    r7.r.d("BaseNetUtils", "The log tag cannot be null or empty.");
                    TextUtils.isEmpty(null);
                    ConnectivityManager connectivityManager = xVar.f3563c;
                    final int i12 = 0;
                    com.google.android.gms.internal.cast.x.f3560j.b("Start monitoring connectivity changes", new Object[0]);
                    if (!xVar.f3566f && connectivityManager != null && n4.a.e(xVar.g, "android.permission.ACCESS_NETWORK_STATE") == 0) {
                        Network activeNetwork = connectivityManager.getActiveNetwork();
                        if (activeNetwork != null && (linkProperties = connectivityManager.getLinkProperties(activeNetwork)) != null) {
                            xVar.a(activeNetwork, linkProperties);
                        }
                        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), xVar.f3562b);
                        xVar.f3566f = true;
                    }
                    com.google.android.gms.internal.cast.c cVar2 = new com.google.android.gms.internal.cast.c();
                    this.g = cVar2;
                    try {
                        m mVar3 = (m) a10;
                        Parcel w02 = mVar3.w0();
                        com.google.android.gms.internal.cast.u.d(w02, cVar2);
                        mVar3.y0(w02, 3);
                        cVar2.f3276d.add(this.f5706h.f3367a);
                        if (!Collections.unmodifiableList(cVar.f5723z).isEmpty()) {
                            l7.b bVar = f5697l;
                            Log.i(bVar.f8271a, bVar.d("Setting Route Discovery for appIds: ".concat(String.valueOf(Collections.unmodifiableList(this.f5704e.f5723z))), new Object[0]));
                            com.google.android.gms.internal.cast.m mVar4 = this.f5706h;
                            List unmodifiableList = Collections.unmodifiableList(this.f5704e.f5723z);
                            mVar4.getClass();
                            com.google.android.gms.internal.cast.m.f3366f.b(android.support.v4.media.d.o("SetRouteDiscovery for ", unmodifiableList.size(), " IDs"), new Object[0]);
                            LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
                            Iterator it2 = unmodifiableList.iterator();
                            while (it2.hasNext()) {
                                linkedHashSet.add(i7.e.C((String) it2.next()));
                            }
                            com.google.android.gms.internal.cast.m.f3366f.b("resetting routes. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(mVar4.f3369c.keySet())), new Object[0]);
                            HashMap hashMap2 = new HashMap();
                            synchronized (mVar4.f3369c) {
                                try {
                                    for (String str2 : linkedHashSet) {
                                        com.google.android.gms.internal.cast.k kVar = (com.google.android.gms.internal.cast.k) mVar4.f3369c.get(i7.e.C(str2));
                                        if (kVar != null) {
                                            hashMap2.put(str2, kVar);
                                        }
                                    }
                                    mVar4.f3369c.clear();
                                    mVar4.f3369c.putAll(hashMap2);
                                } finally {
                                }
                            }
                            com.google.android.gms.internal.cast.m.f3366f.b("Routes reset. appIdToRouteInfo has these appId route keys: ".concat(String.valueOf(mVar4.f3369c.keySet())), new Object[0]);
                            synchronized (mVar4.f3370d) {
                                mVar4.f3370d.clear();
                                mVar4.f3370d.addAll(linkedHashSet);
                            }
                            mVar4.m();
                        }
                        i8.i d6 = sVar.d(new String[]{"com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", "com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", "com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE", "com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE", "com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED"});
                        i8.c cVar3 = new i8.c(this) { // from class: h7.c0

                            /* renamed from: p, reason: collision with root package name */
                            public final /* synthetic */ b f5725p;

                            {
                                this.f5725p = this;
                            }

                            @Override // i8.c
                            public final void l(Object obj) {
                                byte[] bytes;
                                y1 y1Var;
                                z0 b2;
                                switch (i12) {
                                    case 0:
                                        b bVar2 = this.f5725p;
                                        Bundle bundle = (Bundle) obj;
                                        if (l0.f3357j) {
                                            Context context2 = bVar2.f5700a;
                                            l7.s sVar3 = bVar2.f5705f;
                                            l0 l0Var = new l0(context2, sVar3, bVar2.f5702c, bVar2.f5708j, bVar2.g);
                                            int i13 = bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            if (i13 == 0) {
                                                if (!z10) {
                                                    return;
                                                }
                                                i13 = 0;
                                                z10 = true;
                                            }
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String c10 = r.a.c(packageName, ".client_cast_analytics_data");
                                            l0Var.f3364h = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
                                            s6.o.b(context2);
                                            s6.o a11 = s6.o.a();
                                            q6.a aVar = q6.a.f10349e;
                                            a11.getClass();
                                            Set unmodifiableSet = aVar != null ? Collections.unmodifiableSet(q6.a.f10348d) : Collections.singleton(new p6.b("proto"));
                                            android.support.v4.media.session.a0 a12 = s6.i.a();
                                            aVar.getClass();
                                            a12.f230p = "cct";
                                            String str3 = aVar.f10350a;
                                            String str4 = aVar.f10351b;
                                            if (str4 == null && str3 == null) {
                                                bytes = null;
                                            } else {
                                                if (str4 == null) {
                                                    str4 = _UrlKt.FRAGMENT_ENCODE_SET;
                                                }
                                                bytes = ("1$" + str3 + "\\" + str4).getBytes(Charset.forName("UTF-8"));
                                            }
                                            a12.f231q = bytes;
                                            s6.i B = a12.B();
                                            p6.b bVar3 = new p6.b("proto");
                                            if (!unmodifiableSet.contains(bVar3)) {
                                                throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar3, unmodifiableSet));
                                            }
                                            l0Var.g = new x4.m(B, bVar3, a11, 23);
                                            if (bundle.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                l0Var.f3362e = Long.valueOf(bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(c10, 0);
                                            if (i13 != 0) {
                                                e9.d b10 = e9.d.b();
                                                b10.f4677d = new i0(sVar3, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"}, 1);
                                                b10.f4678e = new n7.c[]{g7.y.f5317c};
                                                b10.f4676c = false;
                                                b10.f4675b = 8426;
                                                i8.i c11 = sVar3.c(0, b10.a());
                                                com.google.android.gms.internal.cast.v vVar = new com.google.android.gms.internal.cast.v(l0Var, packageName, i13, sharedPreferences);
                                                c11.getClass();
                                                c11.j(i8.e.f6521a, vVar);
                                            }
                                            if (z10) {
                                                r7.r.e(sharedPreferences);
                                                l7.b bVar4 = y1.f3591i;
                                                synchronized (y1.class) {
                                                    try {
                                                        if (y1.f3593k == null) {
                                                            y1.f3593k = new y1(sharedPreferences, l0Var, packageName);
                                                        }
                                                        y1Var = y1.f3593k;
                                                    } catch (Throwable th) {
                                                        throw th;
                                                    }
                                                }
                                                String str5 = y1Var.f3596c;
                                                SharedPreferences sharedPreferences2 = y1Var.f3595b;
                                                HashSet hashSet = y1Var.f3599f;
                                                String string = sharedPreferences2.getString("feature_usage_sdk_version", null);
                                                String string2 = sharedPreferences2.getString("feature_usage_package_name", null);
                                                hashSet.clear();
                                                HashSet hashSet2 = y1Var.g;
                                                hashSet2.clear();
                                                y1Var.f3600h = 0L;
                                                String str6 = y1.f3592j;
                                                if (str6.equals(string) && str5.equals(string2)) {
                                                    y1Var.f3600h = sharedPreferences2.getLong("feature_usage_last_report_time", 0L);
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    HashSet hashSet3 = new HashSet();
                                                    for (String str7 : sharedPreferences2.getAll().keySet()) {
                                                        if (str7.startsWith("feature_usage_timestamp_")) {
                                                            long j10 = sharedPreferences2.getLong(str7, 0L);
                                                            if (j10 != 0 && currentTimeMillis - j10 > 1209600000) {
                                                                hashSet3.add(str7);
                                                            } else if (str7.startsWith("feature_usage_timestamp_reported_feature_")) {
                                                                z0 b11 = y1.b(str7.substring(41));
                                                                if (b11 != null) {
                                                                    hashSet2.add(b11);
                                                                    hashSet.add(b11);
                                                                }
                                                            } else if (str7.startsWith("feature_usage_timestamp_detected_feature_") && (b2 = y1.b(str7.substring(41))) != null) {
                                                                hashSet.add(b2);
                                                            }
                                                        }
                                                    }
                                                    y1Var.c(hashSet3);
                                                    r7.r.e(y1Var.f3598e);
                                                    r7.r.e(y1Var.f3597d);
                                                    y1Var.f3598e.post(y1Var.f3597d);
                                                } else {
                                                    HashSet hashSet4 = new HashSet();
                                                    for (String str8 : sharedPreferences2.getAll().keySet()) {
                                                        if (str8.startsWith("feature_usage_timestamp_")) {
                                                            hashSet4.add(str8);
                                                        }
                                                    }
                                                    hashSet4.add("feature_usage_last_report_time");
                                                    y1Var.c(hashSet4);
                                                    sharedPreferences2.edit().putString("feature_usage_sdk_version", str6).putString("feature_usage_package_name", str5).apply();
                                                }
                                                y1.a(z0.CAST_CONTEXT);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        this.f5725p.getClass();
                                        com.google.android.gms.internal.cast.n.y("com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES", (Bundle) obj);
                                        return;
                                }
                            }
                        };
                        d6.getClass();
                        a5.a aVar = i8.e.f6521a;
                        d6.j(aVar, cVar3);
                        e9.d b2 = e9.d.b();
                        b2.f4677d = new i0(sVar, new String[]{"com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES"}, i11);
                        b2.f4678e = new n7.c[]{g7.y.f5318d};
                        b2.f4676c = false;
                        b2.f4675b = 8427;
                        i8.i c10 = sVar.c(0, b2.a());
                        i8.c cVar4 = new i8.c(this) { // from class: h7.c0

                            /* renamed from: p, reason: collision with root package name */
                            public final /* synthetic */ b f5725p;

                            {
                                this.f5725p = this;
                            }

                            @Override // i8.c
                            public final void l(Object obj) {
                                byte[] bytes;
                                y1 y1Var;
                                z0 b22;
                                switch (i10) {
                                    case 0:
                                        b bVar2 = this.f5725p;
                                        Bundle bundle = (Bundle) obj;
                                        if (l0.f3357j) {
                                            Context context2 = bVar2.f5700a;
                                            l7.s sVar3 = bVar2.f5705f;
                                            l0 l0Var = new l0(context2, sVar3, bVar2.f5702c, bVar2.f5708j, bVar2.g);
                                            int i13 = bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE") ? bundle.getInt("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_MODE", 0) : (bundle.containsKey("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED") && bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_SESSION_ANALYTICS_ENABLED", false)) ? 1 : 0;
                                            boolean z10 = bundle.getBoolean("com.google.android.gms.cast.FLAG_CLIENT_FEATURE_USAGE_ANALYTICS_ENABLED", false);
                                            if (i13 == 0) {
                                                if (!z10) {
                                                    return;
                                                }
                                                i13 = 0;
                                                z10 = true;
                                            }
                                            String packageName = context2.getPackageName();
                                            Locale locale = Locale.ROOT;
                                            String c102 = r.a.c(packageName, ".client_cast_analytics_data");
                                            l0Var.f3364h = bundle.getLong("com.google.android.gms.cast.FLAG_FIRELOG_UPLOAD_MODE") == 0 ? 1 : 2;
                                            s6.o.b(context2);
                                            s6.o a11 = s6.o.a();
                                            q6.a aVar2 = q6.a.f10349e;
                                            a11.getClass();
                                            Set unmodifiableSet = aVar2 != null ? Collections.unmodifiableSet(q6.a.f10348d) : Collections.singleton(new p6.b("proto"));
                                            android.support.v4.media.session.a0 a12 = s6.i.a();
                                            aVar2.getClass();
                                            a12.f230p = "cct";
                                            String str3 = aVar2.f10350a;
                                            String str4 = aVar2.f10351b;
                                            if (str4 == null && str3 == null) {
                                                bytes = null;
                                            } else {
                                                if (str4 == null) {
                                                    str4 = _UrlKt.FRAGMENT_ENCODE_SET;
                                                }
                                                bytes = ("1$" + str3 + "\\" + str4).getBytes(Charset.forName("UTF-8"));
                                            }
                                            a12.f231q = bytes;
                                            s6.i B = a12.B();
                                            p6.b bVar3 = new p6.b("proto");
                                            if (!unmodifiableSet.contains(bVar3)) {
                                                throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar3, unmodifiableSet));
                                            }
                                            l0Var.g = new x4.m(B, bVar3, a11, 23);
                                            if (bundle.containsKey("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE")) {
                                                l0Var.f3362e = Long.valueOf(bundle.getLong("com.google.android.gms.cast.FLAG_ANALYTICS_LOGGING_BUCKET_SIZE"));
                                            }
                                            SharedPreferences sharedPreferences = context2.getApplicationContext().getSharedPreferences(c102, 0);
                                            if (i13 != 0) {
                                                e9.d b10 = e9.d.b();
                                                b10.f4677d = new i0(sVar3, new String[]{"com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_ERROR", "com.google.android.gms.cast.DICTIONARY_CAST_STATUS_CODES_TO_APP_SESSION_CHANGE_REASON"}, 1);
                                                b10.f4678e = new n7.c[]{g7.y.f5317c};
                                                b10.f4676c = false;
                                                b10.f4675b = 8426;
                                                i8.i c11 = sVar3.c(0, b10.a());
                                                com.google.android.gms.internal.cast.v vVar = new com.google.android.gms.internal.cast.v(l0Var, packageName, i13, sharedPreferences);
                                                c11.getClass();
                                                c11.j(i8.e.f6521a, vVar);
                                            }
                                            if (z10) {
                                                r7.r.e(sharedPreferences);
                                                l7.b bVar4 = y1.f3591i;
                                                synchronized (y1.class) {
                                                    try {
                                                        if (y1.f3593k == null) {
                                                            y1.f3593k = new y1(sharedPreferences, l0Var, packageName);
                                                        }
                                                        y1Var = y1.f3593k;
                                                    } catch (Throwable th) {
                                                        throw th;
                                                    }
                                                }
                                                String str5 = y1Var.f3596c;
                                                SharedPreferences sharedPreferences2 = y1Var.f3595b;
                                                HashSet hashSet = y1Var.f3599f;
                                                String string = sharedPreferences2.getString("feature_usage_sdk_version", null);
                                                String string2 = sharedPreferences2.getString("feature_usage_package_name", null);
                                                hashSet.clear();
                                                HashSet hashSet2 = y1Var.g;
                                                hashSet2.clear();
                                                y1Var.f3600h = 0L;
                                                String str6 = y1.f3592j;
                                                if (str6.equals(string) && str5.equals(string2)) {
                                                    y1Var.f3600h = sharedPreferences2.getLong("feature_usage_last_report_time", 0L);
                                                    long currentTimeMillis = System.currentTimeMillis();
                                                    HashSet hashSet3 = new HashSet();
                                                    for (String str7 : sharedPreferences2.getAll().keySet()) {
                                                        if (str7.startsWith("feature_usage_timestamp_")) {
                                                            long j10 = sharedPreferences2.getLong(str7, 0L);
                                                            if (j10 != 0 && currentTimeMillis - j10 > 1209600000) {
                                                                hashSet3.add(str7);
                                                            } else if (str7.startsWith("feature_usage_timestamp_reported_feature_")) {
                                                                z0 b11 = y1.b(str7.substring(41));
                                                                if (b11 != null) {
                                                                    hashSet2.add(b11);
                                                                    hashSet.add(b11);
                                                                }
                                                            } else if (str7.startsWith("feature_usage_timestamp_detected_feature_") && (b22 = y1.b(str7.substring(41))) != null) {
                                                                hashSet.add(b22);
                                                            }
                                                        }
                                                    }
                                                    y1Var.c(hashSet3);
                                                    r7.r.e(y1Var.f3598e);
                                                    r7.r.e(y1Var.f3597d);
                                                    y1Var.f3598e.post(y1Var.f3597d);
                                                } else {
                                                    HashSet hashSet4 = new HashSet();
                                                    for (String str8 : sharedPreferences2.getAll().keySet()) {
                                                        if (str8.startsWith("feature_usage_timestamp_")) {
                                                            hashSet4.add(str8);
                                                        }
                                                    }
                                                    hashSet4.add("feature_usage_last_report_time");
                                                    y1Var.c(hashSet4);
                                                    sharedPreferences2.edit().putString("feature_usage_sdk_version", str6).putString("feature_usage_package_name", str5).apply();
                                                }
                                                y1.a(z0.CAST_CONTEXT);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    default:
                                        this.f5725p.getClass();
                                        com.google.android.gms.internal.cast.n.y("com.google.android.gms.cast.MAP_CAST_STATUS_CODES_TO_CAST_REASON_CODES", (Bundle) obj);
                                        return;
                                }
                            }
                        };
                        c10.getClass();
                        c10.j(aVar, cVar4);
                    } catch (RemoteException e7) {
                        throw new IllegalStateException("Failed to call addAppVisibilityListener", e7);
                    }
                } catch (RemoteException e8) {
                    throw new IllegalStateException("Failed to call getSessionManagerImpl", e8);
                }
            } catch (RemoteException e10) {
                throw new IllegalStateException("Failed to call getDiscoveryManagerImpl", e10);
            }
        } catch (RemoteException e11) {
            throw new IllegalStateException("Failed to call newCastContextImpl", e11);
        }
    }

    public static b a(Context context) {
        r7.r.b();
        if (f5699n == null) {
            synchronized (f5698m) {
                if (f5699n == null) {
                    Context applicationContext = context.getApplicationContext();
                    f b2 = b(applicationContext);
                    c castOptions = b2.getCastOptions(applicationContext);
                    l7.s sVar = new l7.s(applicationContext, l7.s.f8314k, o7.b.f9545a, o7.e.f9547c);
                    try {
                        f5699n = new b(applicationContext, castOptions, b2.getAdditionalSessionProviders(applicationContext), new com.google.android.gms.internal.cast.q(applicationContext, w3.b0.d(applicationContext), castOptions, sVar), sVar);
                    } catch (e e7) {
                        throw new RuntimeException(e7);
                    }
                }
            }
        }
        return f5699n;
    }

    public static f b(Context context) {
        androidx.emoji2.text.o a10;
        try {
            a10 = w7.c.a(context);
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | NullPointerException | InvocationTargetException e7) {
            e = e7;
        }
        try {
            Bundle bundle = a10.f591o.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle == null) {
                f5697l.c(new Object[0]);
            }
            String string = bundle.getString("com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME");
            if (string != null) {
                return (f) Class.forName(string).asSubclass(f.class).getDeclaredConstructor(null).newInstance(null);
            }
            throw new IllegalStateException("The fully qualified name of the implementation of OptionsProvider must be provided as a metadata in the AndroidManifest.xml with key com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME.");
        } catch (ClassNotFoundException e8) {
            e = e8;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (IllegalAccessException e10) {
            e = e10;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (InstantiationException e11) {
            e = e11;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (NoSuchMethodException e12) {
            e = e12;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (NullPointerException e13) {
            e = e13;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        } catch (InvocationTargetException e14) {
            e = e14;
            throw new IllegalStateException("Failed to initialize CastContext.", e);
        }
    }
}
