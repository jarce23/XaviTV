package androidx.media;

import android.media.AudioAttributes;
import n4.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(b bVar) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f1182a = (AudioAttributes) bVar.g(audioAttributesImplApi21.f1182a, 1);
        audioAttributesImplApi21.f1183b = bVar.f(audioAttributesImplApi21.f1183b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi21.f1182a, 1);
        bVar.j(audioAttributesImplApi21.f1183b, 2);
    }
}
