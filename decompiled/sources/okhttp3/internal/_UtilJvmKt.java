package okhttp3.internal;

import androidx.fragment.app.v0;
import gb.i;
import gb.p;
import hb.c;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.internal.http2.Header;
import rb.l;
import rb.n;
import rb.s0;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class _UtilJvmKt {
    public static final TimeZone UTC;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        h.b(timeZone);
        UTC = timeZone;
        assertionsEnabled = false;
        String k02 = i.k0(OkHttpClient.class.getName(), "okhttp3.");
        if (p.R(k02, "Client", false)) {
            k02 = k02.substring(0, k02.length() - 6);
            h.d("substring(...)", k02);
        }
        okHttpName = k02;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        h.e("<this>", eventListener);
        return new v0(12, eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$0(EventListener eventListener, Call call) {
        h.e("it", call);
        return eventListener;
    }

    public static final void assertLockNotHeld(Dispatcher dispatcher) {
        h.e("<this>", dispatcher);
        if (assertionsEnabled && Thread.holdsLock(dispatcher)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + dispatcher);
        }
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        h.e("<this>", httpUrl);
        h.e("other", httpUrl2);
        return h.a(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && h.a(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j10, TimeUnit timeUnit) {
        h.e("name", str);
        h.e("unit", timeUnit);
        if (j10 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        long millis = timeUnit.toMillis(j10);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large").toString());
        }
        if (millis != 0 || j10 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small").toString());
    }

    /* renamed from: checkDuration-HG0u8IE, reason: not valid java name */
    public static final int m144checkDurationHG0u8IE(String str, long j10) {
        h.e("name", str);
        int i10 = hb.a.f5768q;
        if (j10 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        long a10 = ((((int) j10) & 1) != 1 || j10 == hb.a.f5766o || j10 == hb.a.f5767p) ? hb.a.a(j10, c.f5771q) : j10 >> 1;
        if (a10 > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large").toString());
        }
        if (a10 != 0 || j10 <= 0) {
            return (int) a10;
        }
        throw new IllegalArgumentException(str.concat(" too small").toString());
    }

    public static final void closeQuietly(Socket socket) {
        h.e("<this>", socket);
        try {
            socket.close();
        } catch (AssertionError e7) {
            throw e7;
        } catch (RuntimeException e8) {
            if (!h.a(e8.getMessage(), "bio == null")) {
                throw e8;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean discard(s0 s0Var, int i10, TimeUnit timeUnit) {
        h.e("<this>", s0Var);
        h.e("timeUnit", timeUnit);
        try {
            return skipAll(s0Var, i10, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String format(String str, Object... objArr) {
        h.e("format", str);
        h.e("args", objArr);
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
    }

    public static final long headersContentLength(Response response) {
        h.e("<this>", response);
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return _UtilCommonKt.toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        h.e("elements", tArr);
        return toImmutableList(tArr);
    }

    public static final boolean isHealthy(Socket socket, n nVar) {
        h.e("<this>", socket);
        h.e("source", nVar);
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !nVar.t();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final Charset readBomAsCharset(n nVar, Charset charset) {
        h.e("<this>", nVar);
        h.e("default", charset);
        int e7 = nVar.e(_UtilCommonKt.getUNICODE_BOMS());
        if (e7 == -1) {
            return charset;
        }
        if (e7 == 0) {
            return gb.a.f5445a;
        }
        if (e7 == 1) {
            return gb.a.f5446b;
        }
        if (e7 == 2) {
            Charset charset2 = gb.a.f5445a;
            Charset charset3 = gb.a.f5449e;
            if (charset3 != null) {
                return charset3;
            }
            Charset forName = Charset.forName("UTF-32LE");
            h.d("forName(...)", forName);
            gb.a.f5449e = forName;
            return forName;
        }
        if (e7 == 3) {
            return gb.a.f5447c;
        }
        if (e7 != 4) {
            throw new AssertionError();
        }
        Charset charset4 = gb.a.f5445a;
        Charset charset5 = gb.a.f5450f;
        if (charset5 != null) {
            return charset5;
        }
        Charset forName2 = Charset.forName("UTF-32BE");
        h.d("forName(...)", forName2);
        gb.a.f5450f = forName2;
        return forName2;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) {
        T t3;
        Object readFieldOrNull;
        h.e("instance", obj);
        h.e("fieldType", cls);
        h.e("fieldName", str);
        Class<?> cls2 = obj.getClass();
        while (true) {
            t3 = null;
            if (cls2.equals(Object.class)) {
                if (str.equals("delegate") || (readFieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(readFieldOrNull, cls, str);
            }
            try {
                Field declaredField = cls2.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                t3 = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                cls2 = cls2.getSuperclass();
                h.d("getSuperclass(...)", cls2);
            }
        }
        return t3;
    }

    public static final boolean skipAll(s0 s0Var, int i10, TimeUnit timeUnit) {
        h.e("<this>", s0Var);
        h.e("timeUnit", timeUnit);
        long nanoTime = System.nanoTime();
        long deadlineNanoTime = s0Var.timeout().hasDeadline() ? s0Var.timeout().deadlineNanoTime() - nanoTime : Long.MAX_VALUE;
        s0Var.timeout().deadlineNanoTime(Math.min(deadlineNanoTime, timeUnit.toNanos(i10)) + nanoTime);
        try {
            l lVar = new l();
            while (s0Var.read(lVar, 8192L) != -1) {
                lVar.a();
            }
            if (deadlineNanoTime == Long.MAX_VALUE) {
                s0Var.timeout().clearDeadline();
                return true;
            }
            s0Var.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return true;
        } catch (InterruptedIOException unused) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                s0Var.timeout().clearDeadline();
                return false;
            }
            s0Var.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            return false;
        } catch (Throwable th) {
            if (deadlineNanoTime == Long.MAX_VALUE) {
                s0Var.timeout().clearDeadline();
            } else {
                s0Var.timeout().deadlineNanoTime(nanoTime + deadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z10) {
        h.e("name", str);
        return new ThreadFactory() { // from class: okhttp3.internal.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread threadFactory$lambda$0;
                threadFactory$lambda$0 = _UtilJvmKt.threadFactory$lambda$0(str, z10, runnable);
                return threadFactory$lambda$0;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$0(String str, boolean z10, Runnable runnable) {
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z10);
        return thread;
    }

    public static final void threadName(String str, ya.a aVar) {
        h.e("name", str);
        h.e("block", aVar);
        Thread currentThread = Thread.currentThread();
        String name = currentThread.getName();
        currentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            currentThread.setName(name);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        h.e("<this>", headers);
        db.c y8 = k5.a.y(0, headers.size());
        ArrayList arrayList = new ArrayList(ma.l.z(y8));
        Iterator it = y8.iterator();
        while (true) {
            db.b bVar = (db.b) it;
            boolean z10 = bVar.f4355q;
            if (!z10) {
                return arrayList;
            }
            int i10 = bVar.f4356r;
            if (i10 != bVar.f4354p) {
                bVar.f4356r = bVar.f4353o + i10;
            } else {
                if (!z10) {
                    throw new NoSuchElementException();
                }
                bVar.f4355q = false;
            }
            arrayList.add(new Header(headers.name(i10), headers.value(i10)));
        }
    }

    public static final Headers toHeaders(List<Header> list) {
        h.e("<this>", list);
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().r(), header.component2().r());
        }
        return builder.build();
    }

    public static final String toHexString(long j10) {
        String hexString = Long.toHexString(j10);
        h.d("toHexString(...)", hexString);
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z10) {
        String host;
        h.e("<this>", httpUrl);
        if (i.b0(httpUrl.host(), ":")) {
            host = "[" + httpUrl.host() + ']';
        } else {
            host = httpUrl.host();
        }
        if (!z10 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return host;
        }
        return host + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return toHostHeader(httpUrl, z10);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        h.e("<this>", list);
        if (list.isEmpty()) {
            return ma.p.f9051o;
        }
        if (list.size() == 1) {
            List<T> singletonList = Collections.singletonList(list.get(0));
            h.d("singletonList(...)", singletonList);
            return singletonList;
        }
        Object[] array = list.toArray();
        h.d("toArray(...)", array);
        List<T> unmodifiableList = Collections.unmodifiableList(ma.i.B(array));
        h.d("unmodifiableList(...)", unmodifiableList);
        return unmodifiableList;
    }

    public static final <T> List<T> unmodifiable(List<? extends T> list) {
        h.e("<this>", list);
        List<T> unmodifiableList = Collections.unmodifiableList(list);
        h.d("unmodifiableList(...)", unmodifiableList);
        return unmodifiableList;
    }

    public static final String toHexString(int i10) {
        String hexString = Integer.toHexString(i10);
        h.d("toHexString(...)", hexString);
        return hexString;
    }

    public static final <T> Set<T> unmodifiable(Set<? extends T> set) {
        h.e("<this>", set);
        Set<T> unmodifiableSet = Collections.unmodifiableSet(set);
        h.d("unmodifiableSet(...)", unmodifiableSet);
        return unmodifiableSet;
    }

    public static final <K, V> Map<K, V> unmodifiable(Map<K, ? extends V> map) {
        h.e("<this>", map);
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(map);
        h.d("unmodifiableMap(...)", unmodifiableMap);
        return unmodifiableMap;
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        h.e("<this>", serverSocket);
        try {
            serverSocket.close();
        } catch (RuntimeException e7) {
            throw e7;
        } catch (Exception unused) {
        }
    }

    public static final <T> List<T> toImmutableList(T[] tArr) {
        if (tArr != null && tArr.length != 0) {
            if (tArr.length == 1) {
                List<T> singletonList = Collections.singletonList(tArr[0]);
                h.d("singletonList(...)", singletonList);
                return singletonList;
            }
            List<T> unmodifiableList = Collections.unmodifiableList(ma.i.B((Object[]) tArr.clone()));
            h.d("unmodifiableList(...)", unmodifiableList);
            return unmodifiableList;
        }
        return ma.p.f9051o;
    }

    public static final void skipAll(n nVar) {
        h.e("<this>", nVar);
        while (!nVar.t()) {
            nVar.skip(nVar.b().f11035p);
        }
    }
}
