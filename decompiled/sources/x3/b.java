package x3;

import android.graphics.Color;
import android.util.SparseBooleanArray;
import b4.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final o f13511f = new o(5);
    public static final c g = new c();

    /* renamed from: a, reason: collision with root package name */
    public final Object f13512a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13513b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13514c;

    /* renamed from: d, reason: collision with root package name */
    public final Cloneable f13515d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f13516e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(int[] iArr, int i10, c[] cVarArr) {
        a aVar;
        this.f13516e = new float[3];
        this.f13515d = cVarArr;
        int[] iArr2 = new int[32768];
        this.f13513b = iArr2;
        for (int i11 = 0; i11 < iArr.length; i11++) {
            int i12 = iArr[i11];
            int b2 = b(Color.blue(i12), 8, 5) | (b(Color.red(i12), 8, 5) << 10) | (b(Color.green(i12), 8, 5) << 5);
            iArr[i11] = b2;
            iArr2[b2] = iArr2[b2] + 1;
        }
        int i13 = 0;
        for (int i14 = 0; i14 < 32768; i14++) {
            if (iArr2[i14] > 0) {
                int rgb = Color.rgb(b((i14 >> 10) & 31, 5, 8), b((i14 >> 5) & 31, 5, 8), b(i14 & 31, 5, 8));
                float[] fArr = (float[]) this.f13516e;
                ThreadLocal threadLocal = e0.a.f4383a;
                e0.a.a(Color.red(rgb), Color.green(rgb), Color.blue(rgb), fArr);
                if (c(fArr)) {
                    iArr2[i14] = 0;
                }
            }
            if (iArr2[i14] > 0) {
                i13++;
            }
        }
        int[] iArr3 = new int[i13];
        this.f13512a = iArr3;
        int i15 = 0;
        for (int i16 = 0; i16 < 32768; i16++) {
            if (iArr2[i16] > 0) {
                iArr3[i15] = i16;
                i15++;
            }
        }
        if (i13 <= i10) {
            this.f13514c = new ArrayList();
            for (int i17 = 0; i17 < i13; i17++) {
                int i18 = iArr3[i17];
                ((ArrayList) this.f13514c).add(new d(Color.rgb(b((i18 >> 10) & 31, 5, 8), b((i18 >> 5) & 31, 5, 8), b(i18 & 31, 5, 8)), iArr2[i18]));
            }
            return;
        }
        PriorityQueue priorityQueue = new PriorityQueue(i10, f13511f);
        priorityQueue.offer(new a(this, 0, ((int[]) this.f13512a).length - 1));
        while (priorityQueue.size() < i10 && (aVar = (a) priorityQueue.poll()) != null) {
            int i19 = aVar.f13503b;
            int i20 = aVar.f13502a;
            if ((i19 + 1) - i20 <= 1) {
                break;
            }
            b bVar = aVar.f13510j;
            if ((i19 + 1) - i20 <= 1) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int i21 = aVar.f13506e - aVar.f13505d;
            int i22 = aVar.g - aVar.f13507f;
            int i23 = aVar.f13509i - aVar.f13508h;
            int i24 = (i21 < i22 || i21 < i23) ? (i22 < i21 || i22 < i23) ? -1 : -2 : -3;
            int[] iArr4 = (int[]) bVar.f13512a;
            int[] iArr5 = (int[]) bVar.f13513b;
            a(iArr4, i24, i20, i19);
            Arrays.sort(iArr4, i20, aVar.f13503b + 1);
            a(iArr4, i24, i20, aVar.f13503b);
            int i25 = aVar.f13504c / 2;
            int i26 = 0;
            int i27 = i20;
            while (true) {
                int i28 = aVar.f13503b;
                if (i27 > i28) {
                    break;
                }
                i26 += iArr5[iArr4[i27]];
                if (i26 >= i25) {
                    i20 = Math.min(i28 - 1, i27);
                    break;
                }
                i27++;
            }
            a aVar2 = new a(bVar, i20 + 1, aVar.f13503b);
            aVar.f13503b = i20;
            aVar.a();
            priorityQueue.offer(aVar2);
            priorityQueue.offer(aVar);
        }
        ArrayList arrayList = new ArrayList(priorityQueue.size());
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            b bVar2 = aVar3.f13510j;
            int[] iArr6 = (int[]) bVar2.f13512a;
            int[] iArr7 = (int[]) bVar2.f13513b;
            int i29 = 0;
            int i30 = 0;
            int i31 = 0;
            int i32 = 0;
            for (int i33 = aVar3.f13502a; i33 <= aVar3.f13503b; i33++) {
                int i34 = iArr6[i33];
                int i35 = iArr7[i34];
                i30 += i35;
                i29 = (((i34 >> 10) & 31) * i35) + i29;
                i31 = (((i34 >> 5) & 31) * i35) + i31;
                i32 += i35 * (i34 & 31);
            }
            float f10 = i30;
            d dVar = new d(Color.rgb(b(Math.round(i29 / f10), 5, 8), b(Math.round(i31 / f10), 5, 8), b(Math.round(i32 / f10), 5, 8)), i30);
            if (!c(dVar.b())) {
                arrayList.add(dVar);
            }
        }
        this.f13514c = arrayList;
    }

    public static void a(int[] iArr, int i10, int i11, int i12) {
        if (i10 == -2) {
            while (i11 <= i12) {
                int i13 = iArr[i11];
                iArr[i11] = (i13 & 31) | (((i13 >> 5) & 31) << 10) | (((i13 >> 10) & 31) << 5);
                i11++;
            }
            return;
        }
        if (i10 != -1) {
            return;
        }
        while (i11 <= i12) {
            int i14 = iArr[i11];
            iArr[i11] = ((i14 >> 10) & 31) | ((i14 & 31) << 10) | (((i14 >> 5) & 31) << 5);
            i11++;
        }
    }

    public static int b(int i10, int i11, int i12) {
        return (i12 > i11 ? i10 << (i12 - i11) : i10 >> (i11 - i12)) & ((1 << i12) - 1);
    }

    public boolean c(float[] fArr) {
        c[] cVarArr = (c[]) this.f13515d;
        if (cVarArr != null && cVarArr.length > 0) {
            for (c cVar : cVarArr) {
                cVar.getClass();
                float f10 = fArr[2];
                if (f10 < 0.95f && f10 > 0.05f) {
                    float f11 = fArr[0];
                    if (f11 < 10.0f || f11 > 37.0f || fArr[1] > 0.82f) {
                    }
                }
                return true;
            }
        }
        return false;
    }

    public b(List list, ArrayList arrayList) {
        this.f13512a = list;
        this.f13513b = arrayList;
        this.f13515d = new SparseBooleanArray();
        this.f13514c = new p.e(0);
        int size = list.size();
        int i10 = Integer.MIN_VALUE;
        d dVar = null;
        for (int i11 = 0; i11 < size; i11++) {
            d dVar2 = (d) list.get(i11);
            int i12 = dVar2.f13521e;
            if (i12 > i10) {
                dVar = dVar2;
                i10 = i12;
            }
        }
        this.f13516e = dVar;
    }
}
