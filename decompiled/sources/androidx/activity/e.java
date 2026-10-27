package androidx.activity;

import j9.v1;
import j9.w1;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.internal.connection.ConnectPlan;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.WebSocketWriter;
import rb.i0;
import rb.m0;
import rb.w0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class e implements ya.a {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f290o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f291p;

    public /* synthetic */ e(int i10, Object obj) {
        this.f290o = i10;
        this.f291p = obj;
    }

    @Override // ya.a
    public final Object invoke() {
        List peerCertificates_delegate$lambda$0;
        List connectTls$lambda$1;
        la.i sendDegradedPingLater$lambda$1;
        la.i writeOneFrame$lambda$0$0;
        la.i finishReader$lambda$0$0;
        la.i failWebSocket$lambda$0$0;
        long size;
        long j10;
        int i10;
        Throwable th;
        la.d dVar;
        Throwable th2;
        Throwable th3;
        int c10;
        la.d dVar2;
        int i11 = this.f290o;
        Object obj = this.f291p;
        switch (i11) {
            case 0:
                ((f.j) obj).reportFullyDrawn();
                return null;
            case 1:
                return obj;
            case 2:
                peerCertificates_delegate$lambda$0 = Handshake.peerCertificates_delegate$lambda$0((ya.a) obj);
                return peerCertificates_delegate$lambda$0;
            case 3:
                connectTls$lambda$1 = ConnectPlan.connectTls$lambda$1((Handshake) obj);
                return connectTls$lambda$1;
            case 4:
                sendDegradedPingLater$lambda$1 = Http2Connection.sendDegradedPingLater$lambda$1((Http2Connection) obj);
                return sendDegradedPingLater$lambda$1;
            case 5:
                writeOneFrame$lambda$0$0 = RealWebSocket.writeOneFrame$lambda$0$0((RealWebSocket) obj);
                return writeOneFrame$lambda$0$0;
            case 6:
                finishReader$lambda$0$0 = RealWebSocket.finishReader$lambda$0$0((WebSocketWriter) obj);
                return finishReader$lambda$0$0;
            case 7:
                failWebSocket$lambda$0$0 = RealWebSocket.failWebSocket$lambda$0$0((za.m) obj);
                return failWebSocket$lambda$0$0;
            default:
                sb.j jVar = (sb.j) obj;
                ClassLoader classLoader = jVar.f11706o;
                rb.u uVar = jVar.f11707p;
                Enumeration<URL> resources = classLoader.getResources(_UrlKt.FRAGMENT_ENCODE_SET);
                za.h.d("getResources(...)", resources);
                ArrayList list = Collections.list(resources);
                za.h.d("list(...)", list);
                ArrayList arrayList = new ArrayList();
                int size2 = list.size();
                boolean z10 = false;
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = list.get(i12);
                    i12++;
                    URL url = (URL) obj2;
                    za.h.b(url);
                    if (za.h.a(url.getProtocol(), "file")) {
                        String str = i0.f11020p;
                        dVar2 = new la.d(uVar, v1.v(new File(url.toURI())));
                    } else {
                        dVar2 = null;
                    }
                    if (dVar2 != null) {
                        arrayList.add(dVar2);
                    }
                }
                Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
                za.h.d("getResources(...)", resources2);
                ArrayList list2 = Collections.list(resources2);
                za.h.d("list(...)", list2);
                ArrayList arrayList2 = new ArrayList();
                int size3 = list2.size();
                int i13 = 0;
                while (i13 < size3) {
                    int i14 = i13 + 1;
                    URL url2 = (URL) list2.get(i13);
                    za.h.b(url2);
                    String url3 = url2.toString();
                    za.h.d("toString(...)", url3);
                    if (gb.p.Y(url3, "jar:file:", z10)) {
                        int c02 = gb.i.c0(url3);
                        za.h.e("<this>", url3);
                        int lastIndexOf = url3.lastIndexOf("!", c02);
                        if (lastIndexOf != -1) {
                            String str2 = i0.f11020p;
                            String substring = url3.substring(4, lastIndexOf);
                            za.h.d("substring(...)", substring);
                            i0 v10 = v1.v(new File(URI.create(substring)));
                            rb.r openReadOnly = uVar.openReadOnly(v10);
                            try {
                                size = openReadOnly.size() - 22;
                                j10 = 0;
                            } finally {
                            }
                            if (size < 0) {
                                throw new IOException("not a zip: size=" + openReadOnly.size());
                            }
                            i10 = i14;
                            long max = Math.max(size - 65536, 0L);
                            while (true) {
                                m0 c11 = rb.b.c(openReadOnly.s(size));
                                try {
                                    long j11 = j10;
                                    if (c11.c() == 101010256) {
                                        int s10 = c11.s() & 65535;
                                        int s11 = c11.s() & 65535;
                                        long s12 = c11.s() & 65535;
                                        if (s12 != (c11.s() & 65535) || s10 != 0 || s11 != 0) {
                                            throw new IOException("unsupported zip: spanned");
                                        }
                                        c11.skip(4L);
                                        int s13 = c11.s() & 65535;
                                        e3.a aVar = new e3.a(s13, s12, c11.c() & 4294967295L);
                                        c11.x(s13);
                                        c11.close();
                                        long j12 = size - 20;
                                        if (j12 > j11) {
                                            c11 = rb.b.c(openReadOnly.s(j12));
                                            try {
                                                if (c11.c() == 117853008) {
                                                    int c12 = c11.c();
                                                    long n10 = c11.n();
                                                    if (c11.c() != 1 || c12 != 0) {
                                                        throw new IOException("unsupported zip: spanned");
                                                    }
                                                    c11 = rb.b.c(openReadOnly.s(n10));
                                                    try {
                                                        c10 = c11.c();
                                                    } catch (Throwable th4) {
                                                        try {
                                                        } catch (Throwable th5) {
                                                            com.bumptech.glide.f.a(th4, th5);
                                                        }
                                                        th3 = th4;
                                                    }
                                                    if (c10 != 101075792) {
                                                        throw new IOException("bad zip: expected " + sb.b.e(101075792) + " but was " + sb.b.e(c10));
                                                    }
                                                    c11.skip(12L);
                                                    int c13 = c11.c();
                                                    int c14 = c11.c();
                                                    long n11 = c11.n();
                                                    if (n11 != c11.n() || c13 != 0 || c14 != 0) {
                                                        throw new IOException("unsupported zip: spanned");
                                                    }
                                                    c11.skip(8L);
                                                    try {
                                                        th3 = null;
                                                    } catch (Throwable th6) {
                                                        th3 = th6;
                                                    }
                                                    aVar = new e3.a(s13, n11, c11.n());
                                                    if (th3 != null) {
                                                        throw th3;
                                                    }
                                                }
                                                try {
                                                    th2 = null;
                                                } catch (Throwable th7) {
                                                    th2 = th7;
                                                }
                                            } catch (Throwable th8) {
                                                try {
                                                } catch (Throwable th9) {
                                                    com.bumptech.glide.f.a(th8, th9);
                                                }
                                                th2 = th8;
                                            }
                                            if (th2 != null) {
                                                throw th2;
                                            }
                                        }
                                        e3.a aVar2 = aVar;
                                        ArrayList arrayList3 = new ArrayList();
                                        c11 = rb.b.c(openReadOnly.s(aVar2.f4416b));
                                        try {
                                            long j13 = aVar2.f4415a;
                                            long j14 = j11;
                                            while (j14 < j13) {
                                                sb.l f10 = sb.b.f(c11);
                                                long j15 = j13;
                                                if (f10.f11716h >= aVar2.f4416b) {
                                                    throw new IOException("bad zip: local file header offset >= central directory offset");
                                                    break;
                                                } else {
                                                    i0 i0Var = sb.j.f11705r;
                                                    if (w1.B(f10.f11710a)) {
                                                        arrayList3.add(f10);
                                                    }
                                                    j14++;
                                                    j13 = j15;
                                                }
                                            }
                                            try {
                                                th = null;
                                            } catch (Throwable th10) {
                                                th = th10;
                                            }
                                        } catch (Throwable th11) {
                                            try {
                                            } catch (Throwable th12) {
                                                com.bumptech.glide.f.a(th11, th12);
                                            }
                                            th = th11;
                                        }
                                        if (th != null) {
                                            throw th;
                                        }
                                        w0 w0Var = new w0(v10, uVar, sb.b.b(arrayList3));
                                        try {
                                            openReadOnly.close();
                                        } catch (Throwable unused) {
                                        }
                                        dVar = new la.d(w0Var, sb.j.f11705r);
                                    } else {
                                        c11.close();
                                        size--;
                                        if (size < max) {
                                            throw new IOException("not a zip: end of central directory signature not found");
                                        }
                                        j10 = j11;
                                    }
                                } finally {
                                    c11.close();
                                }
                            }
                        }
                    }
                    i10 = i14;
                    dVar = null;
                    if (dVar != null) {
                        arrayList2.add(dVar);
                    }
                    i13 = i10;
                    z10 = false;
                }
                return ma.j.H(arrayList, arrayList2);
        }
    }
}
