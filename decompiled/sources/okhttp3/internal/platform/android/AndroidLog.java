package okhttp3.internal.platform.android;

import android.util.Log;
import gb.i;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.q;
import ma.t;
import okhttp3.OkHttpClient;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http2.Http2;
import za.h;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
@SuppressSignatureCheck
/* loaded from: classes.dex */
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        linkedHashMap.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        linkedHashMap.put(Http2.class.getName(), "okhttp.Http2");
        linkedHashMap.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        int size = linkedHashMap.size();
        knownLoggers = size != 0 ? size != 1 ? new LinkedHashMap<>(linkedHashMap) : t.B(linkedHashMap) : q.f9052o;
    }

    private AndroidLog() {
    }

    public static /* synthetic */ void androidLog$okhttp$default(AndroidLog androidLog, String str, int i10, String str2, Throwable th, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i10, str2, th);
    }

    private final void enableLogging(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (configuredLoggers.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(AndroidLogHandler.INSTANCE);
        }
    }

    private final String loggerTag(String str) {
        String str2 = knownLoggers.get(str);
        return str2 == null ? i.n0(23, str) : str2;
    }

    public final void androidLog$okhttp(String str, int i10, String str2, Throwable th) {
        int min;
        h.e("loggerName", str);
        h.e("message", str2);
        String loggerTag = loggerTag(str);
        if (Log.isLoggable(loggerTag, i10)) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i11 = 0;
            while (i11 < length) {
                int e02 = i.e0(str2, '\n', i11, 4);
                if (e02 == -1) {
                    e02 = length;
                }
                while (true) {
                    min = Math.min(e02, i11 + MAX_LOG_LENGTH);
                    String substring = str2.substring(i11, min);
                    h.d("substring(...)", substring);
                    Log.println(i10, loggerTag, substring);
                    if (min >= e02) {
                        break;
                    } else {
                        i11 = min;
                    }
                }
                i11 = min + 1;
            }
        }
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                enableLogging(entry.getKey(), entry.getValue());
            }
        } catch (RuntimeException e7) {
            System.err.println("Possibly running android unit test without robolectric");
            e7.printStackTrace();
        } catch (UnsatisfiedLinkError e8) {
            System.err.println("Possibly running android unit test without robolectric");
            e8.printStackTrace();
        }
    }
}
