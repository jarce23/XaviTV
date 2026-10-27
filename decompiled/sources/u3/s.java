package u3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class s extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12476a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f12477b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ t f12478c;

    public /* synthetic */ s(t tVar, o oVar, int i10) {
        this.f12476a = i10;
        this.f12478c = tVar;
        this.f12477b = oVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f12476a) {
            case 0:
                t tVar = this.f12478c;
                tVar.i(1);
                if (tVar.B) {
                    this.f12477b.post(tVar.f12496s);
                    tVar.B = false;
                    break;
                }
                break;
            case 1:
                t tVar2 = this.f12478c;
                tVar2.i(2);
                if (tVar2.B) {
                    this.f12477b.post(tVar2.f12496s);
                    tVar2.B = false;
                    break;
                }
                break;
            default:
                t tVar3 = this.f12478c;
                tVar3.i(2);
                if (tVar3.B) {
                    this.f12477b.post(tVar3.f12496s);
                    tVar3.B = false;
                    break;
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f12476a) {
            case 0:
                this.f12478c.i(3);
                break;
            case 1:
                this.f12478c.i(3);
                break;
            default:
                this.f12478c.i(3);
                break;
        }
    }
}
