package q8;

import com.google.android.material.carousel.CarouselLayoutManager;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends m1.e {

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f10366q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ CarouselLayoutManager f10367r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(CarouselLayoutManager carouselLayoutManager, int i10) {
        super(1, 1);
        this.f10366q = i10;
        switch (i10) {
            case 1:
                this.f10367r = carouselLayoutManager;
                super(0, 1);
                break;
            default:
                this.f10367r = carouselLayoutManager;
                break;
        }
    }

    @Override // m1.e
    public final int e() {
        switch (this.f10366q) {
            case 0:
                return this.f10367r.f2370o;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f10367r;
                return carouselLayoutManager.f2370o - carouselLayoutManager.J();
        }
    }

    @Override // m1.e
    public final int f() {
        switch (this.f10366q) {
            case 0:
                return this.f10367r.K();
            default:
                return 0;
        }
    }

    @Override // m1.e
    public final int g() {
        switch (this.f10366q) {
            case 0:
                CarouselLayoutManager carouselLayoutManager = this.f10367r;
                return carouselLayoutManager.f2369n - carouselLayoutManager.L();
            default:
                return this.f10367r.f2369n;
        }
    }

    @Override // m1.e
    public final int h() {
        switch (this.f10366q) {
            case 0:
                return 0;
            default:
                CarouselLayoutManager carouselLayoutManager = this.f10367r;
                if (carouselLayoutManager.U0()) {
                    return carouselLayoutManager.f2369n;
                }
                return 0;
        }
    }

    @Override // m1.e
    public final int i() {
        switch (this.f10366q) {
            case 0:
                return 0;
            default:
                return this.f10367r.M();
        }
    }
}
