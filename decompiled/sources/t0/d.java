package t0;

import android.view.View;
import d9.y;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class d extends com.bumptech.glide.c {

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f11753p;

    public /* synthetic */ d(int i10) {
        this.f11753p = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.c
    public final void A(y yVar, float f10) {
        switch (this.f11753p) {
            case 0:
                ((View) yVar).setAlpha(f10);
                break;
            case 1:
                ((View) yVar).setScaleX(f10);
                break;
            case 2:
                ((View) yVar).setScaleY(f10);
                break;
            case 3:
                ((View) yVar).setRotation(f10);
                break;
            case 4:
                ((View) yVar).setRotationX(f10);
                break;
            default:
                ((View) yVar).setRotationY(f10);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bumptech.glide.c
    public final float n(y yVar) {
        switch (this.f11753p) {
            case 0:
                return ((View) yVar).getAlpha();
            case 1:
                return ((View) yVar).getScaleX();
            case 2:
                return ((View) yVar).getScaleY();
            case 3:
                return ((View) yVar).getRotation();
            case 4:
                return ((View) yVar).getRotationX();
            default:
                return ((View) yVar).getRotationY();
        }
    }
}
