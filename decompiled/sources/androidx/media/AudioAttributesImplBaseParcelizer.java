package androidx.media;

import n4.b;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(b bVar) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f1184a = bVar.f(audioAttributesImplBase.f1184a, 1);
        audioAttributesImplBase.f1185b = bVar.f(audioAttributesImplBase.f1185b, 2);
        audioAttributesImplBase.f1186c = bVar.f(audioAttributesImplBase.f1186c, 3);
        audioAttributesImplBase.f1187d = bVar.f(audioAttributesImplBase.f1187d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, b bVar) {
        bVar.getClass();
        bVar.j(audioAttributesImplBase.f1184a, 1);
        bVar.j(audioAttributesImplBase.f1185b, 2);
        bVar.j(audioAttributesImplBase.f1186c, 3);
        bVar.j(audioAttributesImplBase.f1187d, 4);
    }
}
