package androidx.media;

import android.media.AudioAttributes;
import n4.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(b bVar) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f1182a = (AudioAttributes) bVar.g(audioAttributesImplApi26.f1182a, 1);
        audioAttributesImplApi26.f1183b = bVar.f(audioAttributesImplApi26.f1183b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, b bVar) {
        bVar.getClass();
        bVar.k(audioAttributesImplApi26.f1182a, 1);
        bVar.j(audioAttributesImplApi26.f1183b, 2);
    }
}
