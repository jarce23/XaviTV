package j1;

import a6.q;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import java.util.Objects;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f6940a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f6941b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f6942c;

    /* renamed from: d, reason: collision with root package name */
    public final i1.d f6943d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f6944e;

    public b(int i10, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, i1.d dVar) {
        AudioFocusRequest.Builder audioAttributes;
        AudioFocusRequest.Builder willPauseWhenDucked;
        AudioFocusRequest.Builder onAudioFocusChangeListener2;
        AudioFocusRequest build;
        this.f6940a = i10;
        this.f6942c = handler;
        this.f6943d = dVar;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 < 26) {
            this.f6941b = new a(onAudioFocusChangeListener, handler);
        } else {
            this.f6941b = onAudioFocusChangeListener;
        }
        if (i11 < 26) {
            this.f6944e = null;
            return;
        }
        audioAttributes = q.h(i10).setAudioAttributes((AudioAttributes) dVar.a().f5610p);
        willPauseWhenDucked = audioAttributes.setWillPauseWhenDucked(false);
        onAudioFocusChangeListener2 = willPauseWhenDucked.setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler);
        build = onAudioFocusChangeListener2.build();
        this.f6944e = build;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f6940a == bVar.f6940a && Objects.equals(this.f6941b, bVar.f6941b) && Objects.equals(this.f6942c, bVar.f6942c) && Objects.equals(this.f6943d, bVar.f6943d);
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f6940a), this.f6941b, this.f6942c, this.f6943d, Boolean.FALSE);
    }
}
