package u1;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends AudioDeviceCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f12166a;

    public c(e eVar) {
        this.f12166a = eVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        e eVar = this.f12166a;
        eVar.a(b.c(eVar.f12189a, eVar.f12196i, eVar.f12195h));
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        e eVar = this.f12166a;
        if (l1.a0.l(audioDeviceInfoArr, eVar.f12195h)) {
            eVar.f12195h = null;
        }
        eVar.a(b.c(eVar.f12189a, eVar.f12196i, eVar.f12195h));
    }
}
