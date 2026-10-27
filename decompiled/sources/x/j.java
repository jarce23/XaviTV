package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: j, reason: collision with root package name */
    public static final SparseIntArray f13285j;

    /* renamed from: a, reason: collision with root package name */
    public int f13286a;

    /* renamed from: b, reason: collision with root package name */
    public int f13287b;

    /* renamed from: c, reason: collision with root package name */
    public int f13288c;

    /* renamed from: d, reason: collision with root package name */
    public float f13289d;

    /* renamed from: e, reason: collision with root package name */
    public float f13290e;

    /* renamed from: f, reason: collision with root package name */
    public float f13291f;
    public int g;

    /* renamed from: h, reason: collision with root package name */
    public String f13292h;

    /* renamed from: i, reason: collision with root package name */
    public int f13293i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13285j = sparseIntArray;
        sparseIntArray.append(3, 1);
        sparseIntArray.append(5, 2);
        sparseIntArray.append(9, 3);
        sparseIntArray.append(2, 4);
        sparseIntArray.append(1, 5);
        sparseIntArray.append(0, 6);
        sparseIntArray.append(4, 7);
        sparseIntArray.append(8, 8);
        sparseIntArray.append(7, 9);
        sparseIntArray.append(6, 10);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p.f13322f);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            switch (f13285j.get(index)) {
                case 1:
                    this.f13290e = obtainStyledAttributes.getFloat(index, this.f13290e);
                    break;
                case 2:
                    this.f13288c = obtainStyledAttributes.getInt(index, this.f13288c);
                    break;
                case 3:
                    if (obtainStyledAttributes.peekValue(index).type == 3) {
                        obtainStyledAttributes.getString(index);
                        break;
                    } else {
                        String str = t.a.f11741a[obtainStyledAttributes.getInteger(index, 0)];
                        break;
                    }
                case 4:
                    obtainStyledAttributes.getInt(index, 0);
                    break;
                case 5:
                    this.f13286a = m.i(obtainStyledAttributes, index, this.f13286a);
                    break;
                case 6:
                    this.f13287b = obtainStyledAttributes.getInteger(index, this.f13287b);
                    break;
                case 7:
                    this.f13289d = obtainStyledAttributes.getFloat(index, this.f13289d);
                    break;
                case 8:
                    this.g = obtainStyledAttributes.getInteger(index, this.g);
                    break;
                case 9:
                    this.f13291f = obtainStyledAttributes.getFloat(index, this.f13291f);
                    break;
                case 10:
                    int i11 = obtainStyledAttributes.peekValue(index).type;
                    if (i11 == 1) {
                        this.f13293i = obtainStyledAttributes.getResourceId(index, -1);
                        break;
                    } else if (i11 == 3) {
                        String string = obtainStyledAttributes.getString(index);
                        this.f13292h = string;
                        if (string.indexOf("/") > 0) {
                            this.f13293i = obtainStyledAttributes.getResourceId(index, -1);
                            break;
                        } else {
                            break;
                        }
                    } else {
                        obtainStyledAttributes.getInteger(index, this.f13293i);
                        break;
                    }
            }
        }
        obtainStyledAttributes.recycle();
    }
}
