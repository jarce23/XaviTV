package z1;

import android.media.LoudnessCodecController;
import android.media.MediaCodec;
import java.io.BufferedReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13996a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13997b;

    /* renamed from: c, reason: collision with root package name */
    public Object f13998c;

    public k() {
        j jVar = j.f13994o;
        this.f13996a = new HashSet();
        this.f13997b = jVar;
    }

    public boolean a() {
        String trim;
        ArrayDeque arrayDeque = (ArrayDeque) this.f13997b;
        if (((String) this.f13998c) == null) {
            if (!arrayDeque.isEmpty()) {
                String str = (String) arrayDeque.poll();
                str.getClass();
                this.f13998c = str;
                return true;
            }
            do {
                String readLine = ((BufferedReader) this.f13996a).readLine();
                this.f13998c = readLine;
                if (readLine == null) {
                    return false;
                }
                trim = readLine.trim();
                this.f13998c = trim;
            } while (trim.isEmpty());
        }
        return true;
    }

    public String b() {
        if (!a()) {
            throw new NoSuchElementException();
        }
        String str = (String) this.f13998c;
        this.f13998c = null;
        return str;
    }

    public void c(MediaCodec mediaCodec) {
        LoudnessCodecController loudnessCodecController;
        if (!((HashSet) this.f13996a).remove(mediaCodec) || (loudnessCodecController = (LoudnessCodecController) this.f13998c) == null) {
            return;
        }
        loudnessCodecController.removeMediaCodec(mediaCodec);
    }

    public void d(int i10) {
        LoudnessCodecController create;
        boolean addMediaCodec;
        LoudnessCodecController loudnessCodecController = (LoudnessCodecController) this.f13998c;
        if (loudnessCodecController != null) {
            loudnessCodecController.close();
            this.f13998c = null;
        }
        create = LoudnessCodecController.create(i10, s9.a.f11663o, new i(this));
        this.f13998c = create;
        Iterator it = ((HashSet) this.f13996a).iterator();
        while (it.hasNext()) {
            addMediaCodec = create.addMediaCodec((MediaCodec) it.next());
            if (!addMediaCodec) {
                it.remove();
            }
        }
    }

    public k(ArrayDeque arrayDeque, BufferedReader bufferedReader) {
        this.f13997b = arrayDeque;
        this.f13996a = bufferedReader;
    }
}
