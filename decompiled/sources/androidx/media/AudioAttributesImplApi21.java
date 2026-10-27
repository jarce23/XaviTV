package androidx.media;

import android.media.AudioAttributes;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f1182a;

    /* renamed from: b, reason: collision with root package name */
    public int f1183b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f1182a.equals(((AudioAttributesImplApi21) obj).f1182a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f1182a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f1182a;
    }
}
