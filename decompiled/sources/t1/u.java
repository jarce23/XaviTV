package t1;

import android.media.metrics.LogSessionId;
import android.os.Build;
import java.util.Objects;
import okhttp3.internal.url._UrlKt;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final String f11870a;

    /* renamed from: b, reason: collision with root package name */
    public final p4.p f11871b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f11872c;

    static {
        new u(_UrlKt.FRAGMENT_ENCODE_SET);
    }

    public u(String str) {
        p4.p pVar;
        LogSessionId logSessionId;
        this.f11870a = str;
        if (Build.VERSION.SDK_INT >= 31) {
            pVar = new p4.p(6, false);
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            pVar.f9953p = logSessionId;
        } else {
            pVar = null;
        }
        this.f11871b = pVar;
        this.f11872c = new Object();
    }

    public final synchronized LogSessionId a() {
        p4.p pVar;
        pVar = this.f11871b;
        pVar.getClass();
        return (LogSessionId) pVar.f9953p;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return Objects.equals(this.f11870a, uVar.f11870a) && Objects.equals(this.f11871b, uVar.f11871b) && Objects.equals(this.f11872c, uVar.f11872c);
    }

    public final int hashCode() {
        return Objects.hash(this.f11870a, this.f11871b, this.f11872c);
    }
}
