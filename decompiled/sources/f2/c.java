package f2;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import o9.v0;
import o9.y;
import okhttp3.internal.ws.WebSocketProtocol;
import org.chromium.net.UrlRequest;
import u3.a0;

/* compiled from: r8-map-id-d8f78b0b892205f23cbf9de15380b222f43276593fa4b3f0d12b47401bc18e39 */
/* loaded from: classes.dex */
public final /* synthetic */ class c implements Comparator {

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f4882o;

    public /* synthetic */ c(int i10) {
        this.f4882o = i10;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f4882o) {
            case 0:
                return ((i1.p) obj2).f5987j - ((i1.p) obj).f5987j;
            case 1:
                Integer num = (Integer) obj;
                Integer num2 = (Integer) obj2;
                if (num.intValue() == -1) {
                    return num2.intValue() == -1 ? 0 : -1;
                }
                if (num2.intValue() == -1) {
                    return 1;
                }
                return num.intValue() - num2.intValue();
            case 2:
                return Integer.compare(((h) ((List) obj).get(0)).f4904t, ((h) ((List) obj2).get(0)).f4904t);
            case 3:
                List list = (List) obj;
                List list2 = (List) obj2;
                int i10 = 7;
                return o9.w.f(q.c((q) Collections.max(list, new c(6)), (q) Collections.max(list2, new c(6)))).a(list.size(), list2.size()).b((q) Collections.max(list, new c(i10)), (q) Collections.max(list2, new c(i10)), new c(i10)).e();
            case 4:
                return ((g) Collections.max((List) obj)).compareTo((g) Collections.max((List) obj2));
            case 5:
                return ((n) ((List) obj).get(0)).compareTo((n) ((List) obj2).get(0));
            case 6:
                return q.c((q) obj, (q) obj2);
            case 7:
                q qVar = (q) obj;
                q qVar2 = (q) obj2;
                boolean z10 = qVar.f4930s;
                int i11 = qVar.f4935x;
                v0 a10 = (z10 && qVar.f4933v) ? r.f4938l : r.f4938l.a();
                boolean z11 = qVar.f4931t.B;
                y yVar = y.f9691a;
                if (z11) {
                    yVar = yVar.b(Integer.valueOf(i11), Integer.valueOf(qVar2.f4935x), r.f4938l.a());
                }
                return yVar.b(Integer.valueOf(qVar.f4936y), Integer.valueOf(qVar2.f4936y), a10).b(Integer.valueOf(i11), Integer.valueOf(qVar2.f4935x), a10).e();
            case 8:
                return ((g2.q) obj).f5139a - ((g2.q) obj2).f5139a;
            case 9:
                return Float.compare(((g2.q) obj).f5141c, ((g2.q) obj2).f5141c);
            case 10:
                return Integer.compare(((i3.d) obj2).f6348b, ((i3.d) obj).f6348b);
            case 11:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i12 = 0; i12 < bArr.length; i12++) {
                    byte b2 = bArr[i12];
                    byte b10 = bArr2[i12];
                    if (b2 != b10) {
                        return b2 - b10;
                    }
                }
                return 0;
            case UrlRequest.Status.SENDING_REQUEST /* 12 */:
                return Integer.compare(((q3.d) obj).f10291a.f10294b, ((q3.d) obj2).f10291a.f10294b);
            case UrlRequest.Status.WAITING_FOR_RESPONSE /* 13 */:
                return Long.compare(((q3.c) obj).f10288b, ((q3.c) obj2).f10288b);
            case UrlRequest.Status.READING_RESPONSE /* 14 */:
                a0 a0Var = (a0) obj;
                a0 a0Var2 = (a0) obj2;
                int compare = Integer.compare(a0Var2.f12341b, a0Var.f12341b);
                if (compare != 0) {
                    return compare;
                }
                int compareTo = a0Var.f12342c.compareTo(a0Var2.f12342c);
                return compareTo != 0 ? compareTo : a0Var.f12343d.compareTo(a0Var2.f12343d);
            case WebSocketProtocol.B0_MASK_OPCODE /* 15 */:
                a0 a0Var3 = (a0) obj;
                a0 a0Var4 = (a0) obj2;
                int compare2 = Integer.compare(a0Var4.f12340a, a0Var3.f12340a);
                if (compare2 != 0) {
                    return compare2;
                }
                int compareTo2 = a0Var4.f12342c.compareTo(a0Var3.f12342c);
                return compareTo2 != 0 ? compareTo2 : a0Var4.f12343d.compareTo(a0Var3.f12343d);
            default:
                return ((x1.d) obj).f13355a.compareTo(((x1.d) obj2).f13355a);
        }
    }
}
