package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class e extends f {
    @Override // pl.droidsonroids.gif.f
    public final void a() {
        c cVar = this.f10215o;
        long l10 = cVar.f10208u.l(cVar.f10207t);
        if (l10 >= 0) {
            this.f10215o.f10204q = SystemClock.uptimeMillis() + l10;
            if (this.f10215o.isVisible() && this.f10215o.f10203p) {
                c cVar2 = this.f10215o;
                if (!cVar2.f10213z) {
                    cVar2.f10202o.remove(this);
                    c cVar3 = this.f10215o;
                    cVar3.D = cVar3.f10202o.schedule(this, l10, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f10215o.f10209v.isEmpty() && this.f10215o.f10208u.a() == this.f10215o.f10208u.h() - 1) {
                c cVar4 = this.f10215o;
                f.c cVar5 = cVar4.A;
                GifInfoHandle gifInfoHandle = cVar4.f10208u;
                int b2 = gifInfoHandle.b();
                if (b2 != 0 && b2 >= gifInfoHandle.f()) {
                    b2--;
                }
                cVar5.sendEmptyMessageAtTime(b2, this.f10215o.f10204q);
            }
        } else {
            c cVar6 = this.f10215o;
            cVar6.f10204q = Long.MIN_VALUE;
            cVar6.f10203p = false;
        }
        if (!this.f10215o.isVisible() || this.f10215o.A.hasMessages(-1)) {
            return;
        }
        this.f10215o.A.sendEmptyMessageAtTime(-1, 0L);
    }
}
