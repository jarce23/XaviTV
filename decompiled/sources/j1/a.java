package j1;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import l1.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class a implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f6938a;

    /* renamed from: b, reason: collision with root package name */
    public final AudioManager.OnAudioFocusChangeListener f6939b;

    public a(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.f6939b = onAudioFocusChangeListener;
        Looper looper = handler.getLooper();
        int i10 = a0.f8067a;
        this.f6938a = new Handler(looper, null);
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i10) {
        a0.S(this.f6938a, new d0.j(i10, 2, this));
    }
}
