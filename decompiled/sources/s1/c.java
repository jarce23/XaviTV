package s1;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.Serializable;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final n9.h f11230a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f11231b;

    /* renamed from: c, reason: collision with root package name */
    public h0 f11232c;

    /* renamed from: d, reason: collision with root package name */
    public i1.d f11233d;

    /* renamed from: e, reason: collision with root package name */
    public int f11234e;

    /* renamed from: f, reason: collision with root package name */
    public int f11235f;
    public float g = 1.0f;

    /* renamed from: h, reason: collision with root package name */
    public j1.b f11236h;

    public c(Context context, Looper looper, h0 h0Var) {
        c2.p pVar = new c2.p(1, context);
        this.f11230a = pVar instanceof Serializable ? new n9.i(pVar) : new n9.j(pVar);
        this.f11232c = h0Var;
        this.f11231b = new Handler(looper);
        this.f11234e = 0;
    }

    public final void a() {
        int i10 = this.f11234e;
        if (i10 == 1 || i10 == 0 || this.f11236h == null) {
            return;
        }
        AudioManager audioManager = (AudioManager) this.f11230a.get();
        j1.b bVar = this.f11236h;
        if (Build.VERSION.SDK_INT < 26) {
            audioManager.abandonAudioFocus(bVar.f6941b);
            return;
        }
        Object obj = bVar.f6944e;
        obj.getClass();
        audioManager.abandonAudioFocusRequest(a6.q.m(obj));
    }

    public final void b(int i10) {
        h0 h0Var = this.f11232c;
        if (h0Var != null) {
            l1.x xVar = h0Var.f11343v;
            xVar.getClass();
            l1.w b2 = l1.x.b();
            b2.f8136a = xVar.f8138a.obtainMessage(33, i10, 0);
            b2.b();
        }
    }

    public final void c(int i10) {
        if (this.f11234e == i10) {
            return;
        }
        this.f11234e = i10;
        float f10 = i10 == 4 ? 0.2f : 1.0f;
        if (this.g == f10) {
            return;
        }
        this.g = f10;
        h0 h0Var = this.f11232c;
        if (h0Var != null) {
            h0Var.f11343v.e(34);
        }
    }

    public final int d(int i10, boolean z10) {
        int i11;
        int requestAudioFocus;
        app.shamel.tv.b bVar;
        if (i10 == 1 || (i11 = this.f11235f) != 1) {
            a();
            c(0);
            return 1;
        }
        if (!z10) {
            int i12 = this.f11234e;
            if (i12 == 1) {
                return -1;
            }
            if (i12 == 3) {
                return 0;
            }
        } else if (this.f11234e != 2) {
            j1.b bVar2 = this.f11236h;
            if (bVar2 == null) {
                if (bVar2 == null) {
                    bVar = new app.shamel.tv.b((byte) 0, 7);
                    bVar.f2096q = i1.d.f5843b;
                    bVar.f2095p = i11;
                } else {
                    app.shamel.tv.b bVar3 = new app.shamel.tv.b((byte) 0, 7);
                    bVar3.f2095p = bVar2.f6940a;
                    bVar3.f2096q = bVar2.f6943d;
                    bVar = bVar3;
                }
                i1.d dVar = this.f11233d;
                dVar.getClass();
                bVar.f2096q = dVar;
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: s1.b
                    @Override // android.media.AudioManager.OnAudioFocusChangeListener
                    public final void onAudioFocusChange(int i13) {
                        c cVar = c.this;
                        cVar.getClass();
                        if (i13 == -3 || i13 == -2) {
                            if (i13 != -2) {
                                cVar.c(4);
                                return;
                            } else {
                                cVar.b(0);
                                cVar.c(3);
                                return;
                            }
                        }
                        if (i13 == -1) {
                            cVar.b(-1);
                            cVar.a();
                            cVar.c(1);
                        } else if (i13 != 1) {
                            android.support.v4.media.d.x("Unknown focus change type: ", i13, "AudioFocusManager");
                        } else {
                            cVar.c(2);
                            cVar.b(1);
                        }
                    }
                };
                Handler handler = this.f11231b;
                handler.getClass();
                this.f11236h = new j1.b(bVar.f2095p, onAudioFocusChangeListener, handler, (i1.d) bVar.f2096q);
            }
            AudioManager audioManager = (AudioManager) this.f11230a.get();
            j1.b bVar4 = this.f11236h;
            if (Build.VERSION.SDK_INT >= 26) {
                Object obj = bVar4.f6944e;
                obj.getClass();
                requestAudioFocus = audioManager.requestAudioFocus(a6.q.m(obj));
            } else {
                AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener2 = bVar4.f6941b;
                bVar4.f6943d.getClass();
                requestAudioFocus = audioManager.requestAudioFocus(onAudioFocusChangeListener2, 3, bVar4.f6940a);
            }
            if (requestAudioFocus == 1) {
                c(2);
                return 1;
            }
            c(1);
            return -1;
        }
        return 1;
    }
}
