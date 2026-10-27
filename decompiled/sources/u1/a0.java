package u1;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a0 f12150a = new a0();

    /* renamed from: b, reason: collision with root package name */
    public static final a0 f12151b = new a0();

    public AudioTrack a(l lVar, i1.d dVar, int i10, Context context) {
        int i11 = Build.VERSION.SDK_INT;
        int i12 = lVar.f12224b;
        int i13 = lVar.f12225c;
        int i14 = lVar.f12223a;
        int i15 = l1.a0.f8067a;
        AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(lVar.f12226d ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : (AudioAttributes) dVar.a().f5610p).setAudioFormat(new AudioFormat.Builder().setSampleRate(i12).setChannelMask(i13).setEncoding(i14).build()).setTransferMode(1).setBufferSizeInBytes(lVar.f12228f).setSessionId(i10);
        if (i11 >= 29) {
            sessionId.setOffloadedPlayback(lVar.f12227e);
        }
        if (i11 >= 34 && context != null) {
            sessionId.setContext(context);
        }
        return sessionId.build();
    }
}
