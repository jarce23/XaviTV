package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import org.chromium.net.UrlRequest;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class l {

    /* renamed from: n, reason: collision with root package name */
    public static final SparseIntArray f13298n;

    /* renamed from: a, reason: collision with root package name */
    public float f13299a;

    /* renamed from: b, reason: collision with root package name */
    public float f13300b;

    /* renamed from: c, reason: collision with root package name */
    public float f13301c;

    /* renamed from: d, reason: collision with root package name */
    public float f13302d;

    /* renamed from: e, reason: collision with root package name */
    public float f13303e;

    /* renamed from: f, reason: collision with root package name */
    public float f13304f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public int f13305h;

    /* renamed from: i, reason: collision with root package name */
    public float f13306i;

    /* renamed from: j, reason: collision with root package name */
    public float f13307j;

    /* renamed from: k, reason: collision with root package name */
    public float f13308k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f13309l;

    /* renamed from: m, reason: collision with root package name */
    public float f13310m;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13298n = sparseIntArray;
        sparseIntArray.append(6, 1);
        sparseIntArray.append(7, 2);
        sparseIntArray.append(8, 3);
        sparseIntArray.append(4, 4);
        sparseIntArray.append(5, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(1, 7);
        sparseIntArray.append(2, 8);
        sparseIntArray.append(3, 9);
        sparseIntArray.append(9, 10);
        sparseIntArray.append(10, 11);
        sparseIntArray.append(11, 12);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f13324i);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            switch (f13298n.get(index)) {
                case 1:
                    this.f13299a = obtainStyledAttributes.getFloat(index, this.f13299a);
                    break;
                case 2:
                    this.f13300b = obtainStyledAttributes.getFloat(index, this.f13300b);
                    break;
                case 3:
                    this.f13301c = obtainStyledAttributes.getFloat(index, this.f13301c);
                    break;
                case 4:
                    this.f13302d = obtainStyledAttributes.getFloat(index, this.f13302d);
                    break;
                case 5:
                    this.f13303e = obtainStyledAttributes.getFloat(index, this.f13303e);
                    break;
                case 6:
                    this.f13304f = obtainStyledAttributes.getDimension(index, this.f13304f);
                    break;
                case 7:
                    this.g = obtainStyledAttributes.getDimension(index, this.g);
                    break;
                case 8:
                    this.f13306i = obtainStyledAttributes.getDimension(index, this.f13306i);
                    break;
                case 9:
                    this.f13307j = obtainStyledAttributes.getDimension(index, this.f13307j);
                    break;
                case 10:
                    this.f13308k = obtainStyledAttributes.getDimension(index, this.f13308k);
                    break;
                case 11:
                    this.f13309l = true;
                    this.f13310m = obtainStyledAttributes.getDimension(index, this.f13310m);
                    break;
                case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                    this.f13305h = m.i(obtainStyledAttributes, index, this.f13305h);
                    break;
            }
        }
        obtainStyledAttributes.recycle();
    }
}
