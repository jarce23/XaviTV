package androidx.media;

import android.util.SparseIntArray;
import n4.d;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public class AudioAttributesCompat implements d {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f1180b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f1181a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f1181a;
        return audioAttributesImpl == null ? audioAttributesCompat.f1181a == null : audioAttributesImpl.equals(audioAttributesCompat.f1181a);
    }

    public final int hashCode() {
        return this.f1181a.hashCode();
    }

    public final String toString() {
        return this.f1181a.toString();
    }
}
