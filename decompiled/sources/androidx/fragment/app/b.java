package androidx.fragment.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(6);
    public final ArrayList A;
    public final boolean B;

    /* renamed from: o, reason: collision with root package name */
    public final int[] f649o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayList f650p;

    /* renamed from: q, reason: collision with root package name */
    public final int[] f651q;

    /* renamed from: r, reason: collision with root package name */
    public final int[] f652r;

    /* renamed from: s, reason: collision with root package name */
    public final int f653s;

    /* renamed from: t, reason: collision with root package name */
    public final String f654t;

    /* renamed from: u, reason: collision with root package name */
    public final int f655u;

    /* renamed from: v, reason: collision with root package name */
    public final int f656v;

    /* renamed from: w, reason: collision with root package name */
    public final CharSequence f657w;

    /* renamed from: x, reason: collision with root package name */
    public final int f658x;

    /* renamed from: y, reason: collision with root package name */
    public final CharSequence f659y;

    /* renamed from: z, reason: collision with root package name */
    public final ArrayList f660z;

    public b(a aVar) {
        int size = aVar.f626a.size();
        this.f649o = new int[size * 6];
        if (!aVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.f650p = new ArrayList(size);
        this.f651q = new int[size];
        this.f652r = new int[size];
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            q0 q0Var = (q0) aVar.f626a.get(i11);
            int i12 = i10 + 1;
            this.f649o[i10] = q0Var.f776a;
            ArrayList arrayList = this.f650p;
            s sVar = q0Var.f777b;
            arrayList.add(sVar != null ? sVar.f810s : null);
            int[] iArr = this.f649o;
            iArr[i12] = q0Var.f778c ? 1 : 0;
            iArr[i10 + 2] = q0Var.f779d;
            iArr[i10 + 3] = q0Var.f780e;
            int i13 = i10 + 5;
            iArr[i10 + 4] = q0Var.f781f;
            i10 += 6;
            iArr[i13] = q0Var.g;
            this.f651q[i11] = q0Var.f782h.ordinal();
            this.f652r[i11] = q0Var.f783i.ordinal();
        }
        this.f653s = aVar.f631f;
        this.f654t = aVar.f633i;
        this.f655u = aVar.f643s;
        this.f656v = aVar.f634j;
        this.f657w = aVar.f635k;
        this.f658x = aVar.f636l;
        this.f659y = aVar.f637m;
        this.f660z = aVar.f638n;
        this.A = aVar.f639o;
        this.B = aVar.f640p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeIntArray(this.f649o);
        parcel.writeStringList(this.f650p);
        parcel.writeIntArray(this.f651q);
        parcel.writeIntArray(this.f652r);
        parcel.writeInt(this.f653s);
        parcel.writeString(this.f654t);
        parcel.writeInt(this.f655u);
        parcel.writeInt(this.f656v);
        TextUtils.writeToParcel(this.f657w, parcel, 0);
        parcel.writeInt(this.f658x);
        TextUtils.writeToParcel(this.f659y, parcel, 0);
        parcel.writeStringList(this.f660z);
        parcel.writeStringList(this.A);
        parcel.writeInt(this.B ? 1 : 0);
    }

    public b(Parcel parcel) {
        this.f649o = parcel.createIntArray();
        this.f650p = parcel.createStringArrayList();
        this.f651q = parcel.createIntArray();
        this.f652r = parcel.createIntArray();
        this.f653s = parcel.readInt();
        this.f654t = parcel.readString();
        this.f655u = parcel.readInt();
        this.f656v = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f657w = (CharSequence) creator.createFromParcel(parcel);
        this.f658x = parcel.readInt();
        this.f659y = (CharSequence) creator.createFromParcel(parcel);
        this.f660z = parcel.createStringArrayList();
        this.A = parcel.createStringArrayList();
        this.B = parcel.readInt() != 0;
    }
}
