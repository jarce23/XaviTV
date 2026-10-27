package b4;

import android.view.View;
import java.util.Locale;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2284a;

    /* renamed from: b, reason: collision with root package name */
    public int f2285b;

    /* renamed from: c, reason: collision with root package name */
    public int f2286c;

    public /* synthetic */ j0(byte b2, int i10) {
        this.f2284a = i10;
    }

    public int a() {
        int i10 = this.f2286c;
        if (i10 == 2) {
            return 10;
        }
        if (i10 == 5) {
            return 11;
        }
        if (i10 == 29) {
            return 12;
        }
        if (i10 == 42) {
            return 16;
        }
        if (i10 != 22) {
            return i10 != 23 ? 0 : 15;
        }
        return 1073741824;
    }

    public void b(f1 f1Var) {
        View view = f1Var.f2232a;
        this.f2285b = view.getLeft();
        this.f2286c = view.getTop();
        view.getRight();
        view.getBottom();
    }

    public String toString() {
        switch (this.f2284a) {
            case 3:
                Locale locale = Locale.ENGLISH;
                return android.support.v4.media.d.p("startIndex: ", ", length: ", this.f2285b, this.f2286c);
            default:
                return super.toString();
        }
    }

    public /* synthetic */ j0(int i10, int i11, int i12) {
        this.f2284a = i12;
        this.f2285b = i10;
        this.f2286c = i11;
    }

    public j0(int i10) {
        this.f2284a = 5;
        this.f2285b = i10;
    }
}
