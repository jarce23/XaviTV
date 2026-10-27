package n4;

import android.os.Parcel;
import android.util.SparseIntArray;
import okhttp3.internal.url._UrlKt;
import p.e;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class c extends b {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f9186d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f9187e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9188f;
    public final int g;

    /* renamed from: h, reason: collision with root package name */
    public final String f9189h;

    /* renamed from: i, reason: collision with root package name */
    public int f9190i;

    /* renamed from: j, reason: collision with root package name */
    public int f9191j;

    /* renamed from: k, reason: collision with root package name */
    public int f9192k;

    public c(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), _UrlKt.FRAGMENT_ENCODE_SET, new e(0), new e(0), new e(0));
    }

    @Override // n4.b
    public final c a() {
        Parcel parcel = this.f9187e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f9191j;
        if (i10 == this.f9188f) {
            i10 = this.g;
        }
        return new c(parcel, dataPosition, i10, android.support.v4.media.d.r(new StringBuilder(), this.f9189h, "  "), this.f9183a, this.f9184b, this.f9185c);
    }

    @Override // n4.b
    public final boolean e(int i10) {
        while (this.f9191j < this.g) {
            int i11 = this.f9192k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            int i12 = this.f9191j;
            Parcel parcel = this.f9187e;
            parcel.setDataPosition(i12);
            int readInt = parcel.readInt();
            this.f9192k = parcel.readInt();
            this.f9191j += readInt;
        }
        return this.f9192k == i10;
    }

    @Override // n4.b
    public final void i(int i10) {
        int i11 = this.f9190i;
        SparseIntArray sparseIntArray = this.f9186d;
        Parcel parcel = this.f9187e;
        if (i11 >= 0) {
            int i12 = sparseIntArray.get(i11);
            int dataPosition = parcel.dataPosition();
            parcel.setDataPosition(i12);
            parcel.writeInt(dataPosition - i12);
            parcel.setDataPosition(dataPosition);
        }
        this.f9190i = i10;
        sparseIntArray.put(i10, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i10);
    }

    public c(Parcel parcel, int i10, int i11, String str, e eVar, e eVar2, e eVar3) {
        super(eVar, eVar2, eVar3);
        this.f9186d = new SparseIntArray();
        this.f9190i = -1;
        this.f9192k = -1;
        this.f9187e = parcel;
        this.f9188f = i10;
        this.g = i11;
        this.f9191j = i10;
        this.f9189h = str;
    }
}
