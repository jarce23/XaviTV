package m4;

import android.graphics.Matrix;
import android.graphics.Paint;
import java.util.ArrayList;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f8901a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8902b;

    /* renamed from: c, reason: collision with root package name */
    public float f8903c;

    /* renamed from: d, reason: collision with root package name */
    public float f8904d;

    /* renamed from: e, reason: collision with root package name */
    public float f8905e;

    /* renamed from: f, reason: collision with root package name */
    public float f8906f;
    public float g;

    /* renamed from: h, reason: collision with root package name */
    public float f8907h;

    /* renamed from: i, reason: collision with root package name */
    public float f8908i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f8909j;

    /* renamed from: k, reason: collision with root package name */
    public String f8910k;

    public j() {
        this.f8901a = new Matrix();
        this.f8902b = new ArrayList();
        this.f8903c = 0.0f;
        this.f8904d = 0.0f;
        this.f8905e = 0.0f;
        this.f8906f = 1.0f;
        this.g = 1.0f;
        this.f8907h = 0.0f;
        this.f8908i = 0.0f;
        this.f8909j = new Matrix();
        this.f8910k = null;
    }

    @Override // m4.k
    public final boolean a() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f8902b;
            if (i10 >= arrayList.size()) {
                return false;
            }
            if (((k) arrayList.get(i10)).a()) {
                return true;
            }
            i10++;
        }
    }

    @Override // m4.k
    public final boolean b(int[] iArr) {
        int i10 = 0;
        boolean z10 = false;
        while (true) {
            ArrayList arrayList = this.f8902b;
            if (i10 >= arrayList.size()) {
                return z10;
            }
            z10 |= ((k) arrayList.get(i10)).b(iArr);
            i10++;
        }
    }

    public final void c() {
        Matrix matrix = this.f8909j;
        matrix.reset();
        matrix.postTranslate(-this.f8904d, -this.f8905e);
        matrix.postScale(this.f8906f, this.g);
        matrix.postRotate(this.f8903c, 0.0f, 0.0f);
        matrix.postTranslate(this.f8907h + this.f8904d, this.f8908i + this.f8905e);
    }

    public String getGroupName() {
        return this.f8910k;
    }

    public Matrix getLocalMatrix() {
        return this.f8909j;
    }

    public float getPivotX() {
        return this.f8904d;
    }

    public float getPivotY() {
        return this.f8905e;
    }

    public float getRotation() {
        return this.f8903c;
    }

    public float getScaleX() {
        return this.f8906f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.f8907h;
    }

    public float getTranslateY() {
        return this.f8908i;
    }

    public void setPivotX(float f10) {
        if (f10 != this.f8904d) {
            this.f8904d = f10;
            c();
        }
    }

    public void setPivotY(float f10) {
        if (f10 != this.f8905e) {
            this.f8905e = f10;
            c();
        }
    }

    public void setRotation(float f10) {
        if (f10 != this.f8903c) {
            this.f8903c = f10;
            c();
        }
    }

    public void setScaleX(float f10) {
        if (f10 != this.f8906f) {
            this.f8906f = f10;
            c();
        }
    }

    public void setScaleY(float f10) {
        if (f10 != this.g) {
            this.g = f10;
            c();
        }
    }

    public void setTranslateX(float f10) {
        if (f10 != this.f8907h) {
            this.f8907h = f10;
            c();
        }
    }

    public void setTranslateY(float f10) {
        if (f10 != this.f8908i) {
            this.f8908i = f10;
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(j jVar, p.e eVar) {
        h hVar;
        this.f8901a = new Matrix();
        this.f8902b = new ArrayList();
        this.f8903c = 0.0f;
        this.f8904d = 0.0f;
        this.f8905e = 0.0f;
        this.f8906f = 1.0f;
        this.g = 1.0f;
        this.f8907h = 0.0f;
        this.f8908i = 0.0f;
        Matrix matrix = new Matrix();
        this.f8909j = matrix;
        this.f8910k = null;
        this.f8903c = jVar.f8903c;
        this.f8904d = jVar.f8904d;
        this.f8905e = jVar.f8905e;
        this.f8906f = jVar.f8906f;
        this.g = jVar.g;
        this.f8907h = jVar.f8907h;
        this.f8908i = jVar.f8908i;
        String str = jVar.f8910k;
        this.f8910k = str;
        if (str != null) {
            eVar.put(str, this);
        }
        matrix.set(jVar.f8909j);
        ArrayList arrayList = jVar.f8902b;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            Object obj = arrayList.get(i10);
            if (obj instanceof j) {
                this.f8902b.add(new j((j) obj, eVar));
            } else {
                if (obj instanceof i) {
                    i iVar = (i) obj;
                    i iVar2 = new i(iVar);
                    iVar2.f8892e = 0.0f;
                    iVar2.g = 1.0f;
                    iVar2.f8894h = 1.0f;
                    iVar2.f8895i = 0.0f;
                    iVar2.f8896j = 1.0f;
                    iVar2.f8897k = 0.0f;
                    iVar2.f8898l = Paint.Cap.BUTT;
                    iVar2.f8899m = Paint.Join.MITER;
                    iVar2.f8900n = 4.0f;
                    iVar2.f8891d = iVar.f8891d;
                    iVar2.f8892e = iVar.f8892e;
                    iVar2.g = iVar.g;
                    iVar2.f8893f = iVar.f8893f;
                    iVar2.f8913c = iVar.f8913c;
                    iVar2.f8894h = iVar.f8894h;
                    iVar2.f8895i = iVar.f8895i;
                    iVar2.f8896j = iVar.f8896j;
                    iVar2.f8897k = iVar.f8897k;
                    iVar2.f8898l = iVar.f8898l;
                    iVar2.f8899m = iVar.f8899m;
                    iVar2.f8900n = iVar.f8900n;
                    hVar = iVar2;
                } else if (obj instanceof h) {
                    hVar = new h((h) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f8902b.add(hVar);
                Object obj2 = hVar.f8912b;
                if (obj2 != null) {
                    eVar.put(obj2, hVar);
                }
            }
        }
    }
}
