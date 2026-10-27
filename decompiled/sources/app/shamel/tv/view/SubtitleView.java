package app.shamel.tv.view;

import android.content.Context;
import android.util.AttributeSet;
import androidx.media3.exoplayer.ExoPlayer;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import l5.b;
import m.w0;
import okhttp3.internal.url._UrlKt;
import okhttp3.internal.ws.RealWebSocket;
import s1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class SubtitleView extends w0 implements Runnable {

    /* renamed from: v, reason: collision with root package name */
    public ExoPlayer f2115v;

    /* renamed from: w, reason: collision with root package name */
    public TreeMap f2116w;

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static long g(String str) {
        long parseLong = Long.parseLong(str.split(":")[0].trim());
        long parseLong2 = Long.parseLong(str.split(":")[1].trim());
        long j10 = parseLong * 3600000;
        return Long.parseLong(str.split(":")[2].split(",")[1].trim()) + j10 + (parseLong2 * RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS) + (Long.parseLong(str.split(":")[2].split(",")[0].trim()) * 1000);
    }

    public static TreeMap h(InputStream inputStream) {
        LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        TreeMap treeMap = new TreeMap();
        while (lineNumberReader.readLine() != null) {
            String readLine = lineNumberReader.readLine();
            StringBuilder sb2 = new StringBuilder();
            while (true) {
                String readLine2 = lineNumberReader.readLine();
                if (readLine2 != null && !readLine2.trim().isEmpty()) {
                    sb2.append(readLine2);
                    sb2.append("\n");
                }
            }
            String sb3 = sb2.toString();
            Long valueOf = Long.valueOf(g(readLine.split("-->")[0]));
            long g = g(readLine.split("-->")[1]);
            b bVar = new b();
            bVar.f8263b = g;
            bVar.f8262a = sb3;
            treeMap.put(valueOf, bVar);
        }
        return treeMap;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        postDelayed(this, 300L);
    }

    @Override // m.w0, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        ExoPlayer exoPlayer = this.f2115v;
        if (exoPlayer != null && this.f2116w != null) {
            ((a0) exoPlayer).y();
            long y8 = ((a0) this.f2115v).y();
            String str = _UrlKt.FRAGMENT_ENCODE_SET;
            for (Map.Entry entry : this.f2116w.entrySet()) {
                if (y8 < ((Long) entry.getKey()).longValue()) {
                    break;
                } else if (y8 < ((b) entry.getValue()).f8263b) {
                    str = ((b) entry.getValue()).f8262a;
                }
            }
            setText(String.valueOf(str));
        }
        postDelayed(this, 300L);
    }

    public void setPlayer(ExoPlayer exoPlayer) {
        this.f2115v = exoPlayer;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x001d: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:30), block:B:29:0x001d */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSubSource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "Failed to load subtitle file from: "
            r1 = 0
            java.net.URL r2 = new java.net.URL     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            r2.<init>(r7)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L34
            java.io.InputStream r3 = r2.getInputStream()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
            java.util.TreeMap r4 = h(r3)     // Catch: java.lang.Throwable -> L26
            if (r3 == 0) goto L21
            r3.close()     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
            goto L21
        L1c:
            r7 = move-exception
            r1 = r2
            goto L4f
        L1f:
            r3 = move-exception
            goto L36
        L21:
            r2.disconnect()
            r1 = r4
            goto L4c
        L26:
            r4 = move-exception
            if (r3 == 0) goto L31
            r3.close()     // Catch: java.lang.Throwable -> L2d
            goto L31
        L2d:
            r3 = move-exception
            r4.addSuppressed(r3)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
        L31:
            throw r4     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
        L32:
            r7 = move-exception
            goto L4f
        L34:
            r3 = move-exception
            r2 = r1
        L36:
            java.lang.String r4 = "SubtitleView"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L1c
            r5.append(r7)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r7 = r5.toString()     // Catch: java.lang.Throwable -> L1c
            android.util.Log.e(r4, r7, r3)     // Catch: java.lang.Throwable -> L1c
            if (r2 == 0) goto L4c
            r2.disconnect()
        L4c:
            r6.f2116w = r1
            return
        L4f:
            if (r1 == 0) goto L54
            r1.disconnect()
        L54:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: app.shamel.tv.view.SubtitleView.setSubSource(java.lang.String):void");
    }
}
